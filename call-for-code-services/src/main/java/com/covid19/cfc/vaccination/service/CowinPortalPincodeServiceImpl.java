package com.covid19.cfc.vaccination.service;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CowinPortalPincodeServiceImpl implements CowinPortalPincodeService {

	@Override
	public ResponseEntity<String> getCowinPortalPincode(String date, int pincode) {
		// TODO Auto-generated method stub

		String uri = "https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/calendarByPin?pincode="+pincode+"&date="+date;
		 RestTemplate restTemplate = new RestTemplate();
		/*
		 * RestTemplate restTemplate = new RestTemplate(); System.out.println(uri);
		 * restTemplate.exchange(uri, HttpMethod.GET,HttpEntity<Object>,) Object res=
		 * restTemplate.getForObject(uri, Object.class); System.out.println(res); return
		 * res; // System.out.println(restTemplate.getForObject(uri, Object.class)); //
		 * return (ResponseEntity) restTemplate.getForObject(uri, Object.class);
		 */	
		
		 ResponseEntity<String> entity = restTemplate.getForEntity(uri, String.class);
		 String body = entity.getBody();
		 MediaType contentType = entity.getHeaders().getContentType();
		 HttpStatus statusCode = entity.getStatusCode();
		 return entity;
	}

}
