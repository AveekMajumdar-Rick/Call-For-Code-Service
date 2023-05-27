package com.covid19.cfc.vaccination.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Districts_Pincode")
public class DistinctPincode {

	int pincode;

	public DistinctPincode(int pincode) {
		// TODO Auto-generated constructor stub
		this.pincode=pincode;


		
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "DistinctPincode [pincode=" + pincode + "]";
	}
	
	
	
}
