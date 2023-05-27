package com.covid19.cfc.vaccination.service;

import org.springframework.stereotype.Service;

import com.covid19.cfc.user.registration.model.VaccinationAlert;

@Service
public interface VaccinationAlertService {

	VaccinationAlert enableVaccinationAlertService(VaccinationAlert vaccinationAlert,long mobileNumber);
	boolean disableVaccinationAlertService(long mobileNumber);
}
