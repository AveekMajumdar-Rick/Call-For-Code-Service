package com.covid19.cfc.user.registration.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.covid19.cfc.user.registration.model.UserRegistration;

@Repository
public interface UserRegistrationDao extends MongoRepository<UserRegistration, String> {

	UserRegistration findByEmail(String email);

	 @Query(value= "{pincode: ?0}", fields="{mobileNumber:1,}")   
	List<UserRegistration> findByPincode(int pincode);

}
