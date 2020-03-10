package com.village.address.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.village.address.domain.Address;

@Service
public class AddressService {
	
	private static Map<String, List<Address>> addressMap = new HashMap<>();
	
	static {
		loadData();
	}

	public List<Address> getMyAddresses(String email) {
		return addressMap.get(email.toLowerCase());
	}

	private static void loadData() {
		List<Address> addresses = Arrays.asList(
				 new Address("1/128", "Settipalli", 516215, "Kadapa", "Andhra Pradesh", "India"),
				 new Address("1/55", "SN Colony", 516269, "Rayachoty", "Andhra Pradesh", "India"),
				 new Address("55", "BTM First Stage", 560029, "Bangalore", "Karnataka", "India")
			);
		addressMap.put("patanarshad2@gmail.com", addresses);
		addressMap.put("salarpatan19@gmail.com", addresses);
	}

	public Address getAnyAddress() {
		List<Address> addresses = addressMap.values().stream().findAny().get();
		return addresses.get(getRandomIntegerBetweenRange(0, addresses.size()-1));
	}
	
	public static int getRandomIntegerBetweenRange(double min, double max){
	    Double x = (int)(Math.random()*((max-min)+1))+min;
	    return x.intValue();
	}

}
