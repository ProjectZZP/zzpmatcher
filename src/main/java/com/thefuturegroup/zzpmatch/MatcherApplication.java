package com.thefuturegroup.zzpmatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class MatcherApplication {

	public static void main(String[] args) {
		SpringApplication.run(MatcherApplication.class, args);
	}

    @RequestMapping(value = "findProposals", method = RequestMethod.GET)
    public List<String> getProposals(String profileId) {
        return new ArrayList<>();
    }
 }
