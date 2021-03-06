package com.boot.controller;

import java.util.ArrayList;
import java.util.List;

import com.boot.repository.AddressRepository;
import com.boot.utils.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.boot.model.AddressInfo;
import com.boot.model.Customer;
import com.boot.repository.CustomerRepository;

@RestController
@RequestMapping("api/v1/")
public class CustomerController {
	
	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	AddressRepository addressRepository;
	
	
	@RequestMapping(value="getAddresses/{lastName}", method=RequestMethod.GET)
	public List<AddressInfo> getAllAddresses(@PathVariable String lastName){
		List<AddressInfo> addressInfo= new ArrayList<AddressInfo>();
		Customer c = customerRepository.findByLastName(lastName)
						.stream()
						.findAny()
						.orElse(null);
		if(null != c && c.getAddressInfo().size() > 0){
			addressInfo.addAll(c.getAddressInfo());
			return addressInfo;
		}
		return addressInfo;
		
	}


	@RequestMapping(value="getAddressesLineNameMatches/{addressLineOne}", method=RequestMethod.GET)
	public List<String> getAddressLineNameMatches(@PathVariable String addressLineOne){
		return customerRepository.findNamesWhereAddressLineOneMatches(addressLineOne);
	}

	@RequestMapping(value="updateAddressLine1/{id}", method=RequestMethod.PUT)
	public AddressInfo updateAddressLine1(@PathVariable int id, @RequestBody AddressInfo addressInfo){
		String addressLine1 = addressInfo.getAddressLine1();
		addressRepository.updateAddressLineOne(addressLine1, id);

		return addressRepository.findById(id).get();
	}

	@RequestMapping(value="updateAddress/{id}", method=RequestMethod.PUT)
	public AddressInfo updateAddress(@PathVariable int id, @RequestBody AddressInfo addressInfo){
		AddressInfo existingAddress = addressRepository.findById(id).get();
		Utilities.merge(existingAddress, addressInfo, "id");

		return addressRepository.saveAndFlush(existingAddress);
	}

}
