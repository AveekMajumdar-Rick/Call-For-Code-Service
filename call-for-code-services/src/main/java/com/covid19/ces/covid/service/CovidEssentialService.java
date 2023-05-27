package com.covid19.ces.covid.service;

import java.util.List;

import com.covid19.ces.covid.model.ServiceProviderBean;
import com.covid19.ces.covid.model.ServiceProviderEnum;

public interface CovidEssentialService {

	String saveOperation(ServiceProviderBean serviceProviderBean);

	List<ServiceProviderBean> search(Long pincode, List<String> services);

}
