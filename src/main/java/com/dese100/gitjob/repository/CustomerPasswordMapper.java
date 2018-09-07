package com.dese100.gitjob.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.dese100.gitjob.domain.CustomerPassword;

@Mapper
@Repository
public interface CustomerPasswordMapper {
	void InsertCustomerPassword(CustomerPassword customerPassword);
}
