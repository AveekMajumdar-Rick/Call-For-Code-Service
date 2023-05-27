package com.covid19.cfc.vaccination.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.covid19.cfc.vaccination.model.DistinctPincode;

public interface DistinctPincodeDao extends MongoRepository<DistinctPincode, String>{

	
	
}
