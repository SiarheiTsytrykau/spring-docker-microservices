package com.epam.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class TestRestController {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestRestController.class);

	@RequestMapping("/test")
	public String test() {
		String test = "client saves test word to log-file";
		LOGGER.info(test);
		return test;
	}
}
