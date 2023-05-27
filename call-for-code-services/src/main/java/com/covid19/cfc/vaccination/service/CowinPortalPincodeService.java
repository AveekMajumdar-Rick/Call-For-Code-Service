package com.covid19.cfc.vaccination.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface CowinPortalPincodeService {

	ResponseEntity<String> getCowinPortalPincode(String date, int pincode);

}
