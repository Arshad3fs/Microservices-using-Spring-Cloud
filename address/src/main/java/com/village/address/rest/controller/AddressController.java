package com.village.address.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.village.address.domain.Address;
import com.village.address.service.AddressService;

@RestController
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@GetMapping("/getMyAddresses/{email}")
	public List<Address> getMyAddresses(@PathVariable("email") String email){
		
		if(email == null)
			return new ArrayList<Address>();
		
		return addressService.getMyAddresses(email);
	}
	
	@GetMapping("/getAnyAddress")
	public Address getAnyAddress() {
		return addressService.getAnyAddress();
	}
}
