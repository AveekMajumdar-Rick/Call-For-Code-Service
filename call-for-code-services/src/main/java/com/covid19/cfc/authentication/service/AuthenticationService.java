package com.covid19.cfc.authentication.service;

import org.springframework.stereotype.Service;

import com.covid19.cfc.authentication.dto.AuthenticatedDto;
import com.covid19.cfc.user.registration.model.VaccinationAlert;

@Service
public interface AuthenticationService {

	public Object getAuthenticatedData(final String userName, final String password);

}
