package com.covid19.ces.covid.model;

import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class ServiceProviderBean {

	@JsonIgnore
	private int id;

	@JsonProperty(value = "service_provider_name", required = true)
	@NotBlank
	private String serviceProviderName;

	@JsonProperty(value = "address", required = true)
	@NotBlank
	private String address;

	@JsonProperty(value = "landmark", required = true)
	@NotBlank
	private String landmark;

	@JsonProperty(value = "city", required = true)
	@NotBlank
	private String city;

	@JsonProperty(value = "pincode", required = true)
	@NotNull
	@Pattern(regexp="(^$|[0-9]{6})", message = "pincode cannot be more than 6 digits")
	private String pincode;

	@JsonProperty(value = "contact_number", required = true)
	@NotNull
	@Digits(integer = 10, fraction = 0)
	@Pattern(regexp="(^$|[0-9]{10})", message = "contact number cannot be more than 10 digits")
	private String contactNumber;

	@JsonProperty(value = "landline_number", required = false)
	@Digits(integer = 12, fraction = 0)
	@Pattern(regexp="(^$|[0-9]{12})", message = "contact number cannot be more than 12 digits")
	private String landlineNumber;

	@JsonProperty(value = "email", required = true)
	@NotBlank
	@Email(message = "Email should be valid")
	private String emailAddress;

	@JsonProperty(value = "services", required = true)
	@JsonFormat(shape = Shape.OBJECT)
	private List<ServiceProviderEnum> serviceProviderEnum;

	public ServiceProviderBean() {
		super();
	}

	public ServiceProviderBean(String serviceProviderName, String address, String landmark, String city, String pincode,
			String contactNumber, String landlineNumber, @Email(message = "Email should be valid") String emailAddress) {
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

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getLandlineNumber() {
		return landlineNumber;
	}

	public void setLandlineNumber(String landlineNumber) {
		this.landlineNumber = landlineNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	public List<ServiceProviderEnum> getServiceProviderEnum() {
		return serviceProviderEnum;
	}

	public void setServiceProviderEnum(List<ServiceProviderEnum> serviceProviderEnum) {
		this.serviceProviderEnum = serviceProviderEnum;
	}

}
