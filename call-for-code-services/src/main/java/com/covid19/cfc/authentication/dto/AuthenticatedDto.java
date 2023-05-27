package com.covid19.cfc.authentication.dto;

public class AuthenticatedDto {
	
	private String fullName;
	
	private String birthDate;
	
	private String isFirstDose;
	
	private String vaccineName;
	
	private String dateOfDose;
	
	private String location;
	
	private String alertStartDate;
	
	private String alertEndDate;
	
	private String smsAlert;
	
	private String whatsAppAlert;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getIsFirstDose() {
		return isFirstDose;
	}

	public void setIsFirstDose(String isFirstDose) {
		this.isFirstDose = isFirstDose;
	}

	public String getVaccineName() {
		return vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	public String getDateOfDose() {
		return dateOfDose;
	}

	public void setDateOfDose(String dateOfDose) {
		this.dateOfDose = dateOfDose;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAlertStartDate() {
		return alertStartDate;
	}

	public void setAlertStartDate(String alertStartDate) {
		this.alertStartDate = alertStartDate;
	}

	public String getAlertEndDate() {
		return alertEndDate;
	}

	public void setAlertEndDate(String alertEndDate) {
		this.alertEndDate = alertEndDate;
	}

	public String getSmsAlert() {
		return smsAlert;
	}

	public void setSmsAlert(String smsAlert) {
		this.smsAlert = smsAlert;
	}

	public String getWhatsAppAlert() {
		return whatsAppAlert;
	}

	public void setWhatsAppAlert(String whatsAppAlert) {
		this.whatsAppAlert = whatsAppAlert;
	}

	@Override
	public String toString() {
		return "AuthenticatedDto [fullName=" + fullName + ", birthDate=" + birthDate + ", isFirstDose=" + isFirstDose
				+ ", vaccineName=" + vaccineName + ", dateOfDose=" + dateOfDose + ", location=" + location
				+ ", alertStartDate=" + alertStartDate + ", alertEndDate=" + alertEndDate + ", smsAlert=" + smsAlert
				+ ", whatsAppAlert=" + whatsAppAlert + "]";
	}
	
	


}
