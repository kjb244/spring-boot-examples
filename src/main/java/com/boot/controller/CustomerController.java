package com.boot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.model.AddressInfo;
import com.boot.model.Customer;
import com.boot.repository.CustomerRepository;

@RestController
@RequestMapping("api/v1/")
public class CustomerController {
	
	@Autowired
	CustomerRepository customerRepository;
	
	
	@RequestMapping(value="getAddresses/{lastName}", method=RequestMethod.GET)
	public List<AddressInfo> getAllAddresses(@PathVariable String lastName){
		List<AddressInfo> addressInfo= new ArrayList<AddressInfo>();
		Customer c = customerRepository.findAll()
						.stream()
						.filter(x -> x.getLastName().equalsIgnoreCase(lastName))
						.findAny()
						.orElse(null);
		if(null != c && c.getAddressInfo().size() > 0){
			addressInfo.addAll(c.getAddressInfo());
			return addressInfo;
		}
		return addressInfo;
		
	}

}
