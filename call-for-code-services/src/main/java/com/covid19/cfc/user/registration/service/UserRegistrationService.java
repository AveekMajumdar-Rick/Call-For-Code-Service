package com.covid19.cfc.user.registration.service;

import java.util.List;

import com.covid19.cfc.user.registration.model.UserRegistration;


public interface UserRegistrationService{
	
	UserRegistration addNewUser(UserRegistration userRegistration);

	UserRegistration findByEmail(String email);

	List<UserRegistration> findByEmailAndMobileNumber(String email, long mobileNumber);



	}
