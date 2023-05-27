package com.covid19.cfc.vaccination.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.covid19.cfc.user.registration.model.VaccinationAlert;

@Component
public class VaccinationAlertServiceImpl implements VaccinationAlertService {

	@Autowired
	MongoTemplate mongoTemplate ;
	
	@Autowired
	MongoOperations mongoOperations;
	
	@Override
	public VaccinationAlert enableVaccinationAlertService(VaccinationAlert vaccinationAlert, long mobileNumber) {
		vaccinationAlert.setMobileNumber(mobileNumber);
		mongoTemplate.save(vaccinationAlert);
		return vaccinationAlert;
	}

	public boolean disableVaccinationAlertService(long mobileNumber) {
		       
	        Query query = new Query();
	        query.addCriteria(Criteria.where("mobileNumber").is(mobileNumber));
	        Update update = new Update();
	        update.set("smsAlert", "false");
	        update.set("whatsAppAlert", "false");
	            
	        VaccinationAlert disableAlert = mongoOperations.findAndModify(query, update,  new FindAndModifyOptions().returnNew(true), VaccinationAlert.class);
	        System.out.println("disableAlert "+disableAlert);
	        if(disableAlert != null)
	        {
	        	return true;
	        }else
	        {
	        	return false;
	        }
	        
	   
	}

}
