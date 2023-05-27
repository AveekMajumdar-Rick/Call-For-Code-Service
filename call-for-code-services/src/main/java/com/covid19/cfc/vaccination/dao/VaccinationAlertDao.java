package com.covid19.cfc.vaccination.dao;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.covid19.cfc.user.registration.model.VaccinationAlert;


public interface VaccinationAlertDao extends MongoRepository<VaccinationAlert, String> {

	
	  @Query(value="{ 'mobileNumber' : ?0 }",fields="{ 'vaccineName' : 1,'isFirstDose' : 1 }")
	  List<VaccinationAlert> findByMobileNumber(long mobileNumber);
}
