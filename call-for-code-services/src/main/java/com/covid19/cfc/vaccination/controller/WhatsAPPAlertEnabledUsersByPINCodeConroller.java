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

import com.covid19.cfc.vaccination.service.WhatsAPPAlertEnabledUsersByPINCodeConrollerService;


@RestController
//@RequestMapping(value = "/")
@RequestMapping("/api/v1/whatsappalertenable")
public class WhatsAPPAlertEnabledUsersByPINCodeConroller {
private final Logger LOGGER = LoggerFactory.getLogger(WhatsAPPAlertEnabledUsersByPINCodeConroller.class);
	
	@Autowired
	WhatsAPPAlertEnabledUsersByPINCodeConrollerService whatsAPPAlertEnabledUsersByPINCodeConrollerService;
	
	@RequestMapping(value = "/enablewhatsappalert", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getEnableWhatsAppAlert(@RequestParam("pincode") int pincode) {
		LOGGER.info("Enable Whatsapp alert staterd");
		org.json.JSONObject enableWhatsAppAlert = whatsAPPAlertEnabledUsersByPINCodeConrollerService.enableWhatsAppAlert(pincode);
		if(enableWhatsAppAlert.isNull(null))
		{
			LOGGER.info("Sucessfullly Whatsapp alert is enable");
			LOGGER.info("Whatsapp Alert List : "+enableWhatsAppAlert);
			 return ResponseEntity.ok(enableWhatsAppAlert.toString());
		}else {
			LOGGER.info(" Whatsapp alert is not enable");
			 return (ResponseEntity) ResponseEntity.status(HttpStatus.NO_CONTENT);
			
		}
		 //return ResponseEntity.
	}
}
