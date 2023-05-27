package com.covid19.cfc.vaccination.service;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.covid19.cfc.user.registration.dao.UserRegistrationDao;
import com.covid19.cfc.user.registration.model.UserRegistration;
import com.covid19.cfc.user.registration.model.VaccinationAlert;
import com.covid19.cfc.vaccination.dao.VaccinationAlertDao;

@Component
public class SMSAlertEnabledUsersByPINCodeServiceImpl implements SMSAlertEnabledUsersByPINCodeService {

	@Autowired
	MongoTemplate mongoTemplate;

	@Autowired
	VaccinationAlertDao vaccinationAlertDao;

	@Autowired
	UserRegistrationDao userRegistrationDao;

	@Override
	public JSONObject enableSMSAlert(int pincode) {
		JSONObject jsonForCollectMobileNoList = new JSONObject();
		List<UserRegistration> userListByPincode = userRegistrationDao.findByPincode(pincode);
		for (UserRegistration userRegistration : userListByPincode) {
			List<VaccinationAlert> vaccinationList = vaccinationAlertDao
					.findByMobileNumber(userRegistration.getMobileNumber());
			for (VaccinationAlert vaccinationListName : vaccinationList) {
				JSONObject jsonForCollectMobileNo = new JSONObject();
				JSONArray jsonArrayForCollectMobileNo = new JSONArray();
				String vaccineName = "";
				if (vaccinationListName.getIsFirstDose().equalsIgnoreCase("true")) {
					vaccineName = "Vaccine";
					jsonForCollectMobileNo.accumulate("mobile", userRegistration.getMobileNumber());
				} else {
					vaccineName = vaccinationListName.getVaccineName();
					jsonForCollectMobileNo.accumulate("mobile", userRegistration.getMobileNumber());
				}

				jsonForCollectMobileNoList.accumulate(vaccineName, jsonForCollectMobileNo);
				jsonArrayForCollectMobileNo.put(jsonForCollectMobileNoList);
			}

		}

		return jsonForCollectMobileNoList;
	}

}
