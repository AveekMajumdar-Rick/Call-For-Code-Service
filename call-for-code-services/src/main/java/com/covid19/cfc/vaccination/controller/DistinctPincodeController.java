package com.covid19.cfc.vaccination.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.covid19.cfc.vaccination.model.DistinctPincode;
import com.covid19.cfc.vaccination.service.DistinctPincodeService;


@RestController
@RequestMapping("/api/v1/listofdistrict")
//@RequestMapping(value = "/listofdistrict")
public class DistinctPincodeController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(DistinctPincodeController.class);

	@Autowired
	DistinctPincodeService distinctPincodeService;
	
	@RequestMapping(value = "/pincode", method = RequestMethod.POST)
	public ResponseEntity<Object> postListOfDistrictPincode() {
		LOGGER.info("Insert Pincode into staterd");
		
		
	
		List<DistinctPincode> distinctPincode = distinctPincodeService.listOfDistinctPincode();
		if(!distinctPincode.isEmpty())
		{
			LOGGER.info("Suceessfully pincode added into DB");
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		}else {
			LOGGER.info("Pincode is not  added into DB");
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
			
		}
	}
	
	@GetMapping()
	public List<Integer> getListOfPincode()
	{
		LOGGER.info("List of District Pincode");
		List<Integer> distinctPincodes = distinctPincodeService.getListOfPincode();
		if(!distinctPincodes.isEmpty()) {
			LOGGER.info("List of  Pincode are : "+distinctPincodes);
			
			return distinctPincodes;
		}else
		{
			LOGGER.error("No data found in db");
			return null;
		}
		
		
	}

}
