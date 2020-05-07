package com.epam.client;

import com.epam.client.model.Profile;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
class TestRestController {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestRestController.class);

	@Autowired
	private EurekaClient discoveryClient;

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/test")
	public String test() {
		String test = "client saves test word to log-file";
		LOGGER.info(test);
		return test;
	}

	@GetMapping("/find/{name}")
	public String getServiceInfo(@PathVariable String name) {
		InstanceInfo instance = discoveryClient.getNextServerFromEureka(name, false);
		List<String> info = new ArrayList<>();
		info.add(instance.getId());
		info.add(instance.getIPAddr());
		info.add(Integer.toString(instance.getPort()));
		info.add(Integer.toString(instance.getSecurePort()));
		info.add(instance.getInstanceId());
		info.add(instance.getVIPAddress());
		info.add(instance.getHealthCheckUrl());
		info.add(instance.getAppName());
		info.add(instance.getHomePageUrl());
		info.add(instance.getHostName());
		return String.join("\n", info);
	}

	@RequestMapping("/get/profile/{id}")
	public Profile testRequestToProfileService(@PathVariable String id) {
		String serviceName = "profile";
		String servicePath = "/get/profile";
		String urlTemplate = "http://%s:%s%s/%s";

		Application application = discoveryClient.getApplication(serviceName);
		InstanceInfo instanceInfo = application.getInstances().get(0);
		String url = String.format(urlTemplate,
				instanceInfo.getIPAddr(),
				instanceInfo.getPort(),
				servicePath,
				id
		);
		LOGGER.info("Request URL [{}]", url);

		Profile profile = restTemplate.getForObject(url, Profile.class);
		LOGGER.info("Response [{}]", profile);
		return profile;
	}

}
