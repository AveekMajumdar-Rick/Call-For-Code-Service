package com.covid19.cfc.authentication.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.covid19.cfc.authentication.dao.VaccinationDao;
import com.covid19.cfc.authentication.dto.AuthenticatedDto;
import com.covid19.cfc.authentication.service.AuthenticationService;
import com.covid19.cfc.user.registration.model.VaccinationAlert;

@RestController
@RequestMapping(value = "/")
public class AuthenticationCheckController {

	@Autowired
	private AuthenticationService authenticationService;

	@Autowired
	VaccinationDao vaccinationDao;

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationCheckController.class);

	@PostMapping(value = "/authenticate")
	public Object authenticateUser(@RequestParam String userName, @RequestParam String password) {
		LOGGER.info("Authenticating user...");

		return getAuthenticatedData(userName, password);

	}

	private Object getAuthenticatedData(String userName, String password) {

		return authenticationService.getAuthenticatedData(userName, password);

	}

}
