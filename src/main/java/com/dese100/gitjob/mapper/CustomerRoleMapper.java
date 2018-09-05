package com.dese100.gitjob.mapper;
import com.dese100.gitjob.domain.CustomerRole;
import com.dese100.gitjob.models.CustomerRoleModel;

public class CustomerRoleMapper {
	public static CustomerRole toEntity(CustomerRoleModel model)
	{
		CustomerRole customerRole = new CustomerRole();
		customerRole.setId(model.getId());
		customerRole.setActive(model.getActive());
		customerRole.setIsSystemRole(model.getIsSystemRole());
		customerRole.setName(model.getName());
		customerRole.setSystemName(model.getSystemName());
		return customerRole;
	}
}
