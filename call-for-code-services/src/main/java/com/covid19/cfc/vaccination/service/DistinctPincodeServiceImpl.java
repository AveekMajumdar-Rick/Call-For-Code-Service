package com.covid19.cfc.vaccination.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.covid19.cfc.vaccination.dao.DistinctPincodeDao;
import com.covid19.cfc.vaccination.model.DistinctPincode;

@Component
public class DistinctPincodeServiceImpl implements DistinctPincodeService{

	@Autowired
	MongoTemplate mongoTemplate;

	@Autowired
	MongoOperations mongoOperations;
	
	@Autowired
	DistinctPincodeDao districtPincodeDao;
	
	public DistinctPincodeServiceImpl(DistinctPincodeDao districtPincodeDao) {
        this.districtPincodeDao = districtPincodeDao;
    }
	
	@Override
	public List<Integer> getListOfPincode() {
		// TODO Auto-generated method stub

		/*
		 * Query query = new Query(); Criteria criteria = new Criteria();
		 * criteria.andOperator(Criteria.where("district").is(district));
		 * query.addCriteria(criteria); List<DistinctPincode> districtsPincodes =
		 * mongoTemplate.find(query, DistinctPincode.class);
		 */
		
		List<Integer> listPincode = new ArrayList<Integer>();
		List<DistinctPincode> distinctPincode = this.districtPincodeDao.findAll();
		for (DistinctPincode pincodes : distinctPincode) {
			//System.out.println(pincodes.getPincode());
			listPincode.add(pincodes.getPincode());
		}
		
	List<Integer> listPincodeWithoutDuplicates = listPincode.stream()
				     .distinct()
				     .collect(Collectors.toList());
		System.out.println(distinctPincode);
		return listPincodeWithoutDuplicates;
	}


	@Override
	public List<DistinctPincode> listOfDistinctPincode() {

		DistinctPincode distinctPincode = new DistinctPincode(411028);
		DistinctPincode distinctPincode1 = new DistinctPincode(411029);
		DistinctPincode distinctPincode2 = new DistinctPincode(411030);
		DistinctPincode distinctPincode3 = new DistinctPincode(411031);		
	
		 List<DistinctPincode> listofPincode = Arrays.asList(distinctPincode,distinctPincode1,distinctPincode2,distinctPincode3);
	        this.districtPincodeDao.saveAll(listofPincode);
		
		System.out.println("*************");
		//mongoTemplate.insert(Arrays.asList(listofPincode),DistinctPincode.class);
		
		return listofPincode;
	}



}
