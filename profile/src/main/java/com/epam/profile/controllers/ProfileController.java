package com.epam.profile.controllers;

import com.epam.profile.beans.Profile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {
    private final static Logger LOGGER = LoggerFactory.getLogger(ProfileController.class);

    @GetMapping("/get/profile/{id}")
    public Profile getProfile(@PathVariable int id) {
        long startTime = System.currentTimeMillis();
        Profile profile = new Profile(id, "some profile name " + startTime);
        LOGGER.info("getProfile " + profile.toString());
        return profile;
    }
}
