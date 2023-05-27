package com.covid19.cfc.vaccination.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.covid19.cfc.vaccination.model.DistinctPincode;

@Service
public interface DistinctPincodeService {

	List<Integer> getListOfPincode();

	 List<DistinctPincode>  listOfDistinctPincode();

	

}
