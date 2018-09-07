package com.dese100.gitjob.repository;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.dese100.gitjob.domain.Customer;
import com.dese100.gitjob.domain.CustomerRole;

@Mapper
@Repository
public interface CustomerMapper{
	List<Customer> getAllCustomers(Date createdFromUtc, Date createdToUtc, Integer[] customerRoleIds,
			String email, String userName, String phone);
	void deleteCustomer(int id);
	Customer getCustomerBy(Long id, String email, String systemName, String userName);
	void insertCustomer(Customer customer);
	void updateCustomer(Customer customer);
	void insertCustomerRole(Customer customer, List<CustomerRole> customerRoles);
	void deleteAllCustomerRole(long customerId);
}
