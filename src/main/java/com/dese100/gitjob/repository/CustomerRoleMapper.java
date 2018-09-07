package com.dese100.gitjob.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.dese100.gitjob.domain.CustomerRole;

@Mapper
@Repository
public interface CustomerRoleMapper {	
	
    void deleteCustomerRole(Long id);
    
    CustomerRole getCustomerRoleById(Long customerRoleId);

    List<CustomerRole> getCustomerRoleBySystemName(String systemName);

    List<CustomerRole> getAllCustomerRoles(boolean showHidden);

    void insertCustomerRole(CustomerRole customerRole);

    void updateCustomerRole(CustomerRole customerRole);
}
