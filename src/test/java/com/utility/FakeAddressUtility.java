package com.utility;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.ui.pojo.AddressPOJO;

public class FakeAddressUtility {
	
	public static AddressPOJO getFakeAddress()
	{
		Faker faker = new Faker(Locale.US);
		
		String companyName = faker.company().name();
		String addressLine1 = faker.address().buildingNumber();
		String addressLine2 = faker.address().streetAddress();
		String city = faker.address().city();
		String state = faker.address().state();
		String zipCode = faker.address().zipCode().substring(0, 5);
		String homePhone = faker.phoneNumber().cellPhone();
		String mobilePhone = faker.phoneNumber().cellPhone();
		//String additionalInfo = faker.lorem().sentence();
		String additionalInfo = faker.lorem().characters(10);
		String addressTitle = faker.regexify("[A-Za-z0-9]{10}");
		
		AddressPOJO address = new AddressPOJO(companyName,addressLine1,addressLine2,city,state,zipCode,homePhone,mobilePhone,additionalInfo,addressTitle);
		return address;
	}

}
