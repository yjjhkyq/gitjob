package com.dese100.gitjob.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dese100.gitjob.domain.Customer;
import com.dese100.gitjob.domain.CustomerPassword;
import com.dese100.gitjob.domain.PasswordFormat;
import com.dese100.gitjob.repository.CustomerMapper;

@Service
public class CustomerService implements ICustomerService{

	@Autowired
	CustomerMapper customerDao;
	
	@Override
	public void DeleteCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer GetCustomerById(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> GetCustomersByIds(int[] customerIds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer GetCustomerByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer GetCustomerBySystemName(String systemName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer GetCustomerByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer InsertGuestCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long InsertCustomer(Customer customer) {
		customer.setActive(true);
		customer.setCreatedOnUtc(new Date());
		customer.setDeleted(false);
		customer.setFailedLoginAttempts(0);
		customerDao.insertCustomer(customer);
		return customer.getId();
	}

	@Override
	public void UpdateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CustomerPassword> GetCustomerPasswords(int customerId, PasswordFormat passwordFormat,
			int passwordsToReturn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerPassword GetCurrentPassword(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void InsertCustomerPassword(CustomerPassword customerPassword) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void UpdateCustomerPassword(CustomerPassword customerPassword) {
		// TODO Auto-generated method stub
		
	}

}
