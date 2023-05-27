package com.covid19.cfc.vaccination.controller;

import java.util.List;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.covid19.cfc.vaccination.service.CowinPortalPincodeService;

@RestController
@RequestMapping("/api/v1/cowinportal")
public class CowinPortalPincodeController {

	private final Logger LOGGER = LoggerFactory.getLogger(CowinPortalPincodeController.class);

	@Autowired
	CowinPortalPincodeService cowinPortalPincodeService;
	
	@GetMapping("/pincode")
	public ResponseEntity<String> getCowinPortalPincode(@RequestParam("date") String date, @RequestParam("pincode") int pincode)
	{
		LOGGER.info("Cowin Portal Pincode API Started");
		ResponseEntity<String> res= cowinPortalPincodeService.getCowinPortalPincode(date,pincode);
		System.out.println(res);
		if(res.getStatusCodeValue()==200) {
			LOGGER.error("Cowin Portal Pincode API Date found");
			return ResponseEntity.ok(res).getBody();
			
		}else
		{
			LOGGER.error("No data found in db");
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
		}
		
		
	}

}
