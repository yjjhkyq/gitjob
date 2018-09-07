package com.dese100.gitjob.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dese100.gitjob.domain.Customer;
import com.dese100.gitjob.domain.CustomerPassword;
import com.dese100.gitjob.domain.PasswordFormat;
import com.dese100.gitjob.utils.CryptoUtils;

@Service
public class CustomerRegistrationService implements ICustomerRegistrationService{

	@Autowired
	ICustomerService customerService;
	@Override
	public void changePassword(String userName, boolean ValidateRequest, PasswordFormat paswordFormat,
			String newPassword, String oldPassword) {
		Customer customer = customerService.GetCustomerByUsername(userName);
		CustomerPassword customerPassword = new CustomerPassword();
		customerPassword.setCreatedOnUtc(new Date());
		customerPassword.setCustomerId(customer.getId());
		customerPassword.setPasswordFormatId(paswordFormat.value());
		PasswordFormat.Hashed.value();
		switch(paswordFormat) {
		case Clear:
			customerPassword.setPassword(newPassword);
			break;
		case Hashed:
			customerPassword.setPasswordSalt(CryptoUtils.getSalt());
			customerPassword.setPassword(CryptoUtils.getHash(newPassword, customerPassword.getPasswordSalt()));
			break;
		}
		customerService.InsertCustomerPassword(customerPassword);
	}
}
