package com.covid19.cfc.authentication.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.covid19.cfc.user.registration.model.VaccinationAlert;

@Repository
public interface VaccinationDao extends MongoRepository<VaccinationAlert, String> {

	public VaccinationAlert findByMobileNumber(long mobileNumber);

}
