package com.covid19.ces.covid.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.covid19.ces.covid.model.ServiceProvider;

@Repository
public interface CovidEssentialDao extends MongoRepository<ServiceProvider, String> {

	@Query("{pincode: ?0,serviceBloodBank: ?1,serviceHospital: ?2,serviceOxygen: ?3,servicePharmacy: ?4}")
	List<ServiceProvider> findByServiceProvider(Long pincode, boolean serviceBloodBank, boolean serviceHospital,
			boolean serviceOxygen, boolean servicePharmacy);

}
