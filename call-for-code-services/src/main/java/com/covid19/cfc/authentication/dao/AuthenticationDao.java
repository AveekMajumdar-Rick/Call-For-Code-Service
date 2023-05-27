package com.covid19.cfc.authentication.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.covid19.cfc.user.registration.model.UserRegistration;

@Repository
public interface AuthenticationDao extends MongoRepository<UserRegistration, String> {

	public UserRegistration findByUserName(String userName);

}
