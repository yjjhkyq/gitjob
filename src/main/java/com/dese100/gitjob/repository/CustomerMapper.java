package com.dese100.gitjob.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.dese100.gitjob.domain.Customer;
@Mapper
@Repository
public interface CustomerMapper{
	void deleteCustomer(int id);
	Customer getCustomerBy(Integer id, String email, String systemName, String userName);
	void insertCustomer(Customer customer);
	void UpdateCustomer(Customer customer);
}
