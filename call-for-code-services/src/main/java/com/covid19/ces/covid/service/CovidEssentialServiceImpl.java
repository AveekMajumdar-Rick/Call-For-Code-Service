package com.covid19.ces.covid.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.covid19.ces.covid.dao.CovidEssentialDao;
import com.covid19.ces.covid.model.ServiceProvider;
import com.covid19.ces.covid.model.ServiceProviderBean;
import com.covid19.ces.covid.model.ServiceProviderEnum;
import com.covid19.cfc.user.registration.service.SequenceGeneratorService;
import com.mongodb.MongoException;

@Service
@Transactional
public class CovidEssentialServiceImpl implements CovidEssentialService {

	@Autowired
	private CovidEssentialDao covidEssentialDao;

	@Autowired
	private SequenceGeneratorService generatorService;

	@Override
	public String saveOperation(ServiceProviderBean serviceProviderBean) {
		ServiceProvider serviceProvider = null;
		try {
			if (serviceProviderBean != null) {
				serviceProvider = new ServiceProvider(serviceProviderBean.getServiceProviderName(),
						serviceProviderBean.getAddress(), serviceProviderBean.getLandmark(),
						serviceProviderBean.getCity(), Long.parseLong(serviceProviderBean.getPincode()),
						Long.parseLong(serviceProviderBean.getContactNumber()),
						Long.parseLong(serviceProviderBean.getLandlineNumber()), serviceProviderBean.getEmailAddress());

				if (!serviceProviderBean.getServiceProviderEnum().isEmpty()) {
					for (ServiceProviderEnum serviceProviderEnum : serviceProviderBean.getServiceProviderEnum()) {
						switch (serviceProviderEnum) {
						case BLOOD_BANK:
							serviceProvider.setServiceBloodBank(true);
							break;
						case COVID_MEDICINE_PHARMACY:
							serviceProvider.setServicePharmacy(true);
							break;
						case COVID_TREATMENT_HOSPITAL:
							serviceProvider.setServiceHospital(true);
							break;
						case OXYGEN_SUPPLIER:
							serviceProvider.setServiceOxygen(true);
							break;
						default:
							break;
						}
					}
				}
				serviceProvider.setId(generatorService.getSequenceNumber(ServiceProvider.SEQUENCE_NAME));
				serviceProvider = covidEssentialDao.insert(serviceProvider);
				if (serviceProvider.getId() != 0) {
					return "User registration for " + serviceProviderBean.getServiceProviderName()
							+ " service is done successfully";
				}
			}
		} catch (MongoException e) {
			throw new MongoException("Error in inserting data in DB: {}", e);
		}
		return "User registration is not done successfully";
	}

	@Override
	public List<ServiceProviderBean> search(Long pincode, List<String> services) {
		List<ServiceProviderBean> serviceProviderBeans = new ArrayList<ServiceProviderBean>();
		ServiceProvider serviceProvider = new ServiceProvider();
		try {
			serviceProvider.setPincode(pincode);
			for (String provider : services) {

				switch (ServiceProviderEnum.valueOf(provider)) {
				case BLOOD_BANK:
					serviceProvider.setServiceBloodBank(true);
					break;
				case COVID_MEDICINE_PHARMACY:
					serviceProvider.setServicePharmacy(true);
					break;
				case COVID_TREATMENT_HOSPITAL:
					serviceProvider.setServiceHospital(true);
					break;
				case OXYGEN_SUPPLIER:
					serviceProvider.setServiceOxygen(true);
					break;
				default:
					break;
				}
			}
			List<ServiceProvider> serviceProviders = covidEssentialDao.findByServiceProvider(
					serviceProvider.getPincode(), serviceProvider.isServiceBloodBank(),
					serviceProvider.isServiceHospital(), serviceProvider.isServiceOxygen(),
					serviceProvider.isServicePharmacy());
			if (!serviceProviders.isEmpty()) {
				return serviceProviders.stream()
						.map(listMap -> new ServiceProviderBean(listMap.getServiceProviderName(), listMap.getAddress(),
								listMap.getLandmark(), listMap.getCity(), String.valueOf(listMap.getPincode()),
								String.valueOf(listMap.getContactNumber()), String.valueOf(listMap.getLandlineNumber()),
								listMap.getEmailAddress()))
						.collect(Collectors.toList());
			}
		} catch (MongoException e) {
			throw new MongoException("Error in fetching data from DB: {}", e);
		}
		return serviceProviderBeans;
	}

}
