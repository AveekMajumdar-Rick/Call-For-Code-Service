package com.covid19.ces.covid.controller;

import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.covid19.ces.covid.model.ServiceProviderBean;
import com.covid19.ces.covid.service.CovidEssentialService;

@RestController
@RequestMapping(value = "/api/v1")
public class CovidEssentialController {

	private final Logger LOGGER = LoggerFactory.getLogger(CovidEssentialController.class);

	@Autowired
	private CovidEssentialService covidEssentialService;

	@PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<String> saveOperation(@Validated @RequestBody ServiceProviderBean serviceProviderBean) {
		LOGGER.debug("Method name: saveOperation, Service Provider request: {}", serviceProviderBean);
		return new ResponseEntity<>(covidEssentialService.saveOperation(serviceProviderBean), HttpStatus.CREATED);
	}

	@GetMapping(path = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
	List<ServiceProviderBean> search(@RequestParam(value = "pincode", required = true) String pincode,
			@RequestParam(value = "service", required = true) List<String> services) throws ParseException {
		LOGGER.debug("Method name: search, pincode: {}, service: {}", pincode, services);
		if (StringUtils.hasText(pincode) && !services.isEmpty()) {
			return covidEssentialService.search(Long.parseLong(pincode), services);
		} else {
			throw new IllegalArgumentException("Pincode and Service provider cannot be blank");
		}
	}

}
