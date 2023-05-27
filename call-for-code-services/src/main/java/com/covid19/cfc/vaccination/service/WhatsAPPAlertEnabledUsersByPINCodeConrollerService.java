package com.covid19.cfc.vaccination.service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public interface WhatsAPPAlertEnabledUsersByPINCodeConrollerService {

	JSONObject enableWhatsAppAlert(int pincode);

}
