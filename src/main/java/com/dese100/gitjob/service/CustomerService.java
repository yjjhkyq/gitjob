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
import com.dese100.gitjob.repository.CustomerPasswordMapper;
import com.dese100.gitjob.repository.CustomerRoleMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mysql.cj.util.StringUtils;
@Service
public class CustomerService implements ICustomerService{

	@Autowired
	CustomerMapper customerDao;
	@Autowired
	CustomerRoleMapper customerRoleDao;
	@Autowired
	CustomerPasswordMapper customerPasswordDao;
	@Override
	public void DeleteCustomer(Customer customer) {
	}

	@Override
	public Customer GetCustomerById(Integer customerId) {
		return customerDao.getCustomerBy(customerId, null, null, null);
	}

	@Override
	public List<Customer> GetCustomersByIds(Integer[] customerIds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer GetCustomerByEmail(String email) {
		return customerDao.getCustomerBy(null, email, null, null);
	}

	@Override
	public Customer GetCustomerBySystemName(String systemName) {
		return customerDao.getCustomerBy(null, null, systemName, null);
	}

	@Override
	public Customer GetCustomerByUsername(String username) {
		return customerDao.getCustomerBy(null, null, null, username);
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
	public List<CustomerPassword> GetCustomerPasswords(Integer customerId, PasswordFormat passwordFormat,
			Integer passwordsToReturn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerPassword GetCurrentPassword(Integer customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void InsertCustomerPassword(CustomerPassword customerPassword) {
		customerPasswordDao.InsertCustomerPassword(customerPassword);
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
		if(StringUtils.isNullOrEmpty(systemName))
			return null;
		List<CustomerRole> customerRoles = customerRoleDao.getCustomerRoleBySystemName(systemName);
		if(0 < customerRoles.size())
			return customerRoles.get(0);
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

	@Override
	public PageInfo<Customer> GetAllCustomers(Date createdFromUtc, Date createdToUtc, Integer[] customerRoleIds,
			String email, String userName, String phone, Integer pageIndex, Integer pageSize) {
//		PageHelper.startPage(1, 10);
		List<Customer> data = customerDao.getAllCustomers(createdFromUtc, createdToUtc, customerRoleIds, email, userName, phone);
		PageInfo<Customer> pageInfo = new PageInfo<>(data);
		return pageInfo;
	}

	@Override
	public void setCustomerRole(Customer customer, List<CustomerRole> customerRoles) {
		customerDao.deleteAllCustomerRole(customer.getId());
		customerDao.insertCustomerRole(customer, customerRoles);
	}
}
