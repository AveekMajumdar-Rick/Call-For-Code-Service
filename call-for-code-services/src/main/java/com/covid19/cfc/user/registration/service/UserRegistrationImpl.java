package com.covid19.cfc.user.registration.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.covid19.cfc.authentication.service.EncryptionService;
import com.covid19.cfc.user.registration.dao.UserRegistrationDao;
import com.covid19.cfc.user.registration.model.UserRegistration;

@Service
public class UserRegistrationImpl implements UserRegistrationService{
 
	@Autowired
	MongoTemplate mongoTemplate ;
	
	@Autowired
	UserRegistrationDao dao;

	@Autowired
	EncryptionService encryptionService;

	@Autowired 
	private SequenceGeneratorService generatorService;

	@Override
	public UserRegistration findByEmail(String email) {
		// TODO Auto-generated method stub
		return dao.findByEmail(email);
	}

	@Override
	public List<UserRegistration> findByEmailAndMobileNumber(String email, long mobileNumber) {
		// TODO Auto-generated method stub
		Query query = new Query();
		Criteria criteria = new Criteria();
		criteria.andOperator(Criteria.where("email").is(email), Criteria.where("mobileNumber").is(mobileNumber));
		query.addCriteria(criteria);
		List<UserRegistration> userInfo = mongoTemplate.find(query, UserRegistration.class);

		if (userInfo.isEmpty()) {
			Query queryOR = new Query();
			Criteria criteriaOR = new Criteria();
			criteriaOR.orOperator(Criteria.where("mobileNumber").is(mobileNumber), Criteria.where("email").is(email));
			queryOR.addCriteria(criteriaOR);
			List<UserRegistration> userInfoOR = mongoTemplate.find(queryOR, UserRegistration.class);
			return userInfoOR;
		} else {
			return userInfo;
		}
		
		
	}
	
	public UserRegistration addNewUser(UserRegistration userRegistration){
		String encryptedPassword = encryptionService.aesEncryptAndBase64Encode(userRegistration.getPassword());
		userRegistration.setPassword(encryptedPassword);
		
		userRegistration.setId(generatorService.getSequenceNumber(UserRegistration.SEQUENCE_NAME));
		mongoTemplate.save(userRegistration);
		return userRegistration;
	}

}
