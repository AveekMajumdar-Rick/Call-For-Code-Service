package com.covid19.cfc.authentication.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.covid19.cfc.authentication.dao.AuthenticationDao;
import com.covid19.cfc.authentication.dao.VaccinationDao;
import com.covid19.cfc.authentication.dto.AuthenticatedDto;
import com.covid19.cfc.user.registration.model.UserRegistration;
import com.covid19.cfc.user.registration.model.VaccinationAlert;
import com.google.gson.Gson;

@Component
public class AuthenticationServiceImpl implements AuthenticationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationServiceImpl.class);

	@Autowired
	AuthenticationDao authenticationDao;

	@Autowired
	VaccinationDao vaccinationDao;

	@Autowired
	EncryptionService encryptionService;

	@Override
	public Object getAuthenticatedData(String userName, String password) {

		AuthenticatedDto authenticatedDto = null;
		UserRegistration userRegistration = authenticationDao.findByUserName(userName);

		if (userRegistration != null) {

			LOGGER.info("User exists in DB");

			final String passwordFromDb = encryptionService.aesDecryptAndBase64Decode(userRegistration.getPassword());

			if (password.equals(passwordFromDb)) {
				LOGGER.info("User Authenticated");
				LOGGER.debug("Getting Vaccination Data...");
				authenticatedDto = getVaccineData(userRegistration);

			} else {

				LOGGER.error("User is NOT authenticated");
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

			}
		} else {

			LOGGER.error("UserName does NOT exist in DB");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return authenticatedDto;
	}

	public AuthenticatedDto getVaccineData(UserRegistration userRegistration) {

		VaccinationAlert vaccinationData = vaccinationDao.findByMobileNumber(userRegistration.getMobileNumber());

		Gson gson = new Gson();
		String vaccineJson = gson.toJson(vaccinationData);

		LOGGER.info("Vaccine data::{}", vaccineJson);

		AuthenticatedDto response = new AuthenticatedDto();
		response.setFullName(userRegistration.getFirstName() + " " + userRegistration.getLastName());
		response.setBirthDate(userRegistration.getDob());

		prepareResponse(vaccinationData, response);

		String finalJson = gson.toJson(response);
		LOGGER.info("Final Response is::{}", finalJson);

		return response;
	}

	private void prepareResponse(VaccinationAlert vaccinationData, AuthenticatedDto response) {
		response.setIsFirstDose(vaccinationData.getIsFirstDose());
		response.setVaccineName(vaccinationData.getVaccineName());
		response.setDateOfDose(vaccinationData.getDateOfDose());
		response.setLocation(vaccinationData.getLocation());
		response.setAlertStartDate(vaccinationData.getAlertStartDate());
		response.setAlertEndDate(vaccinationData.getAlertEndDate());
		response.setSmsAlert(vaccinationData.getSmsAlert());
		response.setWhatsAppAlert(vaccinationData.getWhatsAppAlert());

	}

}
