package com.thefuturegroup.zzpmatch;

import com.sun.javaws.exceptions.InvalidArgumentException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@ComponentScan(includeFilters = {@ComponentScan.Filter(ControllerAdvice.class)})
@RestController
public class MatcherApplication {

    @Autowired
    private ProfileService profileService;

	public static void main(String[] args) {
		SpringApplication.run(MatcherApplication.class, args);
	}

    @RequestMapping(value = "findProposals", method = RequestMethod.GET)
    public List<String> getProposals(String profileId) {
        if (StringUtils.isBlank(profileId)) {
            throw  new IllegalArgumentException("Profile ID should not be empty");
        }
        return profileService.findAll();
    }
 }
