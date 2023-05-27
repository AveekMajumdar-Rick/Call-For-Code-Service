package com.covid19.cfc.vaccination.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.covid19.cfc.vaccination.service.SMSAlertEnabledUsersByPINCodeService;

@RestController
//@RequestMapping(value = "/")
@RequestMapping("/api/v1/smsalertenable")
public class SMSAlertEnabledUsersByPINCodeController {

	private final Logger LOGGER = LoggerFactory.getLogger(SMSAlertEnabledUsersByPINCodeController.class);
	
	@Autowired
	SMSAlertEnabledUsersByPINCodeService smsAlertEnabledUsersByPINCodeService;
	
	@RequestMapping(value = "/enablesmsalert", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getEnableSMSAlert(@RequestParam("pincode") int pincode) {
		LOGGER.info("Enable SMS alert staterd");
		org.json.JSONObject enableSMSAlert = smsAlertEnabledUsersByPINCodeService.enableSMSAlert(pincode);
		if(enableSMSAlert.isNull(null))
		{
			LOGGER.info("Sucessfullly SMS alert is enable");
			LOGGER.info("SMS Alert List : "+enableSMSAlert);
			 return ResponseEntity.ok(enableSMSAlert.toString());
		}else {
			LOGGER.info(" SMS alert is not enable");
			 return (ResponseEntity) ResponseEntity.status(HttpStatus.NO_CONTENT);
			
		}
		 //return ResponseEntity.
	}
}
