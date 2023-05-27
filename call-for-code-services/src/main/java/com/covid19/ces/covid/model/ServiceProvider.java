package com.covid19.ces.covid.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Service_Provider")
public class ServiceProvider {

	@Transient
    public static final String SEQUENCE_NAME = "users_sequence_ces";
	
	@Id
	private int id;

	private String serviceProviderName;

	private String address;

	private String landmark;

	private String city;

	private Long pincode;

	private Long contactNumber;

	private Long landlineNumber;

	private String emailAddress;

	private boolean serviceOxygen = false;

	private boolean serviceBloodBank = false;

	private boolean serviceHospital = false;

	private boolean servicePharmacy = false;

	public ServiceProvider() {
		super();
	}

	public ServiceProvider(String serviceProviderName, String address, String landmark, String city,
			Long pincode, Long contactNumber, Long landlineNumber, String emailAddress) {
		super();
		this.serviceProviderName = serviceProviderName;
		this.address = address;
		this.landmark = landmark;
		this.city = city;
		this.pincode = pincode;
		this.contactNumber = contactNumber;
		this.landlineNumber = landlineNumber;
		this.emailAddress = emailAddress;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getServiceProviderName() {
		return serviceProviderName;
	}

	public void setServiceProviderName(String serviceProviderName) {
		this.serviceProviderName = serviceProviderName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Long getLandlineNumber() {
		return landlineNumber;
	}

	public void setLandlineNumber(Long landlineNumber) {
		this.landlineNumber = landlineNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	public boolean isServiceOxygen() {
		return serviceOxygen;
	}

	public void setServiceOxygen(boolean serviceOxygen) {
		this.serviceOxygen = serviceOxygen;
	}

	public boolean isServiceBloodBank() {
		return serviceBloodBank;
	}

	public void setServiceBloodBank(boolean serviceBloodBank) {
		this.serviceBloodBank = serviceBloodBank;
	}

	public boolean isServiceHospital() {
		return serviceHospital;
	}

	public void setServiceHospital(boolean serviceHospital) {
		this.serviceHospital = serviceHospital;
	}

	public boolean isServicePharmacy() {
		return servicePharmacy;
	}

	public void setServicePharmacy(boolean servicePharmacy) {
		this.servicePharmacy = servicePharmacy;
	}

	@Override
	public String toString() {
		return "ServiceProvider [id=" + id + ", serviceProviderName=" + serviceProviderName + ", address=" + address
				+ ", landmark=" + landmark + ", city=" + city + ", pincode=" + pincode + ", contactNumber="
				+ contactNumber + ", landlineNumber=" + landlineNumber + ", emailAddress=" + emailAddress
				+ ", serviceOxygen=" + serviceOxygen + ", serviceBloodBank=" + serviceBloodBank + ", serviceHospital="
				+ serviceHospital + ", servicePharmacy=" + servicePharmacy + "]";
	}

}
