package com.covid19.cfc.user.registration.controller;

import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.covid19.cfc.user.registration.model.UserRegistration;
import com.covid19.cfc.user.registration.service.UserRegistrationService;


/**
 * @author 0027V1744
 *
 */
@RestController
@RequestMapping("/api/v1/user")
public class UserRegistrationController {
	private final Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	UserRegistrationService userRegistrationService; 


	
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public UserRegistration addNewUser(@RequestBody UserRegistration userRegistration) {
		LOG.info("Saving user.");
		return this.userRegistrationService.addNewUser(userRegistration);
	}

	
	@GetMapping("/byemail")
	public ResponseEntity getByEmailAndMobileNumber(@RequestParam("email") String email,@RequestParam("mobileNumber") long mobileNumber)
	{
		HttpStatus statusUserAlreadyExistOrNot = HttpStatus.ACCEPTED;
		List<UserRegistration> userRegistrationInfo = userRegistrationService.findByEmailAndMobileNumber(email,mobileNumber);
		try {
		for (Iterator<UserRegistration> iterator = userRegistrationInfo.iterator(); iterator.hasNext();) {
			UserRegistration userInfo = (UserRegistration) iterator.next();
			/*
			 * System.out.println(userInfo.getEmail());
			 * System.out.println(userInfo.getMobileNumber());
			 * System.out.println("Valusde of : "+Long.valueOf(userInfo.getMobileNumber()));
			 */
			if(userInfo.getEmail() ==null &&  Long.valueOf(userInfo.getMobileNumber()) == null ) {
				
				System.out.println(HttpStatus.ACCEPTED);
				statusUserAlreadyExistOrNot = HttpStatus.ACCEPTED;
				LOG.info("getByEmailAndMobileNumber() : User Mobile Number: "+ mobileNumber +" and email address "+ email+" Accepted");
			}
			else {
				System.out.println(HttpStatus.NOT_ACCEPTABLE);
				statusUserAlreadyExistOrNot = HttpStatus.NOT_ACCEPTABLE;
				LOG.info("getByEmailAndMobileNumber() : User Mobile Number: "+ mobileNumber +" and email address "+ email+" NOT Accepted");
				break;
			}
		}
	
		}catch (Exception e) {
			LOG.error("getByEmailAndMobileNumber", e);
		}
		return new ResponseEntity<>(statusUserAlreadyExistOrNot);
	}

	/*
	 * @PostMapping("/vaccinationalert") public ResponseEntity
	 * getvaccinationalert(@RequestParam("alertStartDate") String alertStartDate,
	 * 
	 * @RequestParam("alertEndDate") String alertEndDate,
	 * 
	 * @RequestParam("isFirstDose") String isFirstDose,
	 * 
	 * @RequestParam("vaccineName") String vaccineName,
	 * 
	 * @RequestParam("dateOfDose") String dateOfDose,
	 * 
	 * @RequestParam("location") String location,
	 * 
	 * @RequestParam("smsAlert") String smsAlerts,
	 * 
	 * @RequestParam("whatsAppAlert") String whatsAppAlert){ return new
	 * ResponseEntity<>(HttpStatus.ACCEPTED); }
	 */

}
