package com.covid19.cfc.vaccination.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.covid19.cfc.user.registration.model.VaccinationAlert;
import com.covid19.cfc.vaccination.service.VaccinationAlertServiceImpl;


@RestController
//@RequestMapping(value = "/")
@RequestMapping("/api/v1/vaccinealert")
public class VaccinationAlertController {

	private final Logger LOGGER = LoggerFactory.getLogger(VaccinationAlertController.class);

	@Autowired
	VaccinationAlertServiceImpl vaccinationAlertService;
	
	@RequestMapping(value = "/enablevaccinationalert", method = RequestMethod.POST)
	public String postEnableVaccinationalert(@RequestBody VaccinationAlert vaccinationAlert , @RequestParam("mobileNumber") long mobileNumber ) {
		LOGGER.info("Enable Vaccination alert staterd");
		VaccinationAlert alert = vaccinationAlertService.enableVaccinationAlertService(vaccinationAlert,mobileNumber);
		if(!alert.equals(null))
		{
			LOGGER.info("Suceessfully Vaccination alert is enable");
			return "Suceessfully Vaccination alert is enable";	
		}else {
			LOGGER.info("Vaccination alert is not enable");
			return "Vaccination alert is not enable";	
			
		}
	}
	
	@RequestMapping(value = "/disablevaccinationalert", method = RequestMethod.POST)
	public String postDisableVaccinationalert(@RequestParam("mobileNumber") long mobileNumber) {
		LOGGER.info("Disable Vaccination alert staterd");
		boolean disablevaccinationalert = vaccinationAlertService.disableVaccinationAlertService(mobileNumber);
		if(disablevaccinationalert)
		{
			LOGGER.info("Suceessfully Vaccination alert is disable");
			return "Suceessfully Vaccination alert is disable";	
		}else {
			LOGGER.info("Vaccination alert is not disable/ Mobile Number not found in db");
			return "Vaccination alert is not disable";	
			
		}
	}
}
