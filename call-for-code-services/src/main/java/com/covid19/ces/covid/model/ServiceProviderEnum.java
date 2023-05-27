package com.covid19.ces.covid.model;

public enum ServiceProviderEnum {

	OXYGEN_SUPPLIER("Oxygen Supplier"),
	BLOOD_BANK("Blood Bank"),
	COVID_TREATMENT_HOSPITAL("COVID Treatment Hospital"),
	COVID_MEDICINE_PHARMACY("COVID Medicines Pharmacy");

	private String services;
	
	ServiceProviderEnum(String service) {
		this.services = service;
	}

	public String getServices() {
		return services;
	}
	
	
}
