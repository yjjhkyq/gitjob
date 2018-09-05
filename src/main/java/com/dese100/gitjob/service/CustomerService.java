package com.dese100.gitjob.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dese100.gitjob.domain.Customer;
import com.dese100.gitjob.domain.CustomerPassword;
import com.dese100.gitjob.domain.CustomerRole;
import com.dese100.gitjob.domain.PasswordFormat;
import com.dese100.gitjob.exception.BizException;
import com.dese100.gitjob.exception.code.ExceptionCode;
import com.dese100.gitjob.repository.CustomerMapper;
import com.dese100.gitjob.repository.CustomerRoleMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class CustomerService implements ICustomerService{

	@Autowired
	CustomerMapper customerDao;
	@Autowired
	CustomerRoleMapper customerRoleDao;
	
	@Override
	public void DeleteCustomer(Customer customer) {
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

	@Override
	public void deleteCustomerRole(CustomerRole customerRole) {
		if(customerRole.getIsSystemRole())
			throw BizException.wrap(ExceptionCode.DELETE_SYSTEM_ROLE_ERROR);
		customerRoleDao.deleteCustomerRole(customerRole.getId());
	}

	@Override
	public CustomerRole getCustomerRoleById(Long customerRoleId) {
		return customerRoleDao.getCustomerRoleById(customerRoleId);
	}

	@Override
	public CustomerRole getCustomerRoleBySystemName(String systemName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo<CustomerRole> GetAllCustomerRoles(Boolean showHidden) {
		 PageHelper.startPage(1, Integer.MAX_VALUE);
		 List<CustomerRole> data = customerRoleDao.getAllCustomerRoles(showHidden);
		 PageInfo<CustomerRole> pageInfo = new PageInfo<>(data);
		 return pageInfo;
	}

	@Override
	public void insertCustomerRole(CustomerRole customerRole) {
		customerRoleDao.insertCustomerRole(customerRole);
	}

	@Override
	public void updateCustomerRole(CustomerRole customerRole) {
		customerRoleDao.updateCustomerRole(customerRole);
	}

}
