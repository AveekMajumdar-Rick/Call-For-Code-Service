package com.covid19.cfc.vaccination.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WhatsAPPAlertEnabledUsersByPINCodeConrollerServiceImpl implements WhatsAPPAlertEnabledUsersByPINCodeConrollerService{

	@Autowired 
	SMSAlertEnabledUsersByPINCodeServiceImpl alertEnabledUsersByPINCodeServiceImpl;
	
	@Override
	public JSONObject enableWhatsAppAlert(int pincode) {
		
		
		return alertEnabledUsersByPINCodeServiceImpl.enableSMSAlert(pincode);
	
		
	}

}
