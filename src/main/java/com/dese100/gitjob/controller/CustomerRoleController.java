package com.dese100.gitjob.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dese100.gitjob.common.DataSourceRequest;
import com.dese100.gitjob.domain.Customer;
import com.dese100.gitjob.domain.CustomerRole;
import com.dese100.gitjob.domain.result.Result;
import com.dese100.gitjob.exception.BizException;
import com.dese100.gitjob.exception.code.ExceptionCode;
import com.dese100.gitjob.mapper.ModelMapper;
import com.dese100.gitjob.models.CustomerRoleModel;
import com.dese100.gitjob.service.ICustomerService;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/customerrole")
public class CustomerRoleController {
	protected Logger logger =  LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	ICustomerService customerService;
	
	@PostMapping("/list")
	public Result<?> list(@Validated @RequestBody DataSourceRequest command){
		PageInfo<CustomerRole> customerRoles = customerService.GetAllCustomerRoles(true);
		return Result.success(ModelMapper.toModel(customerRoles));
	}
	
	@PostMapping("/createcustomerrole")
	public Result<?> create(@Validated @RequestBody CustomerRoleModel customerRoleMode, BindingResult bindingResult)
	{
		if(bindingResult.hasErrors()){
			return Result.bindingError(bindingResult);
		}
		customerRoleMode.setIsSystemRole(false);
		CustomerRole customerRole = ModelMapper.toEntity(customerRoleMode);
		customerService.insertCustomerRole(customerRole);
		return Result.success(customerRole.getId());
	} 
	
	@GetMapping("/edit")
	public Result<?> edit(long id)
	{
		CustomerRole customerRole = customerService.getCustomerRoleById(id);
		if(null == customerRole)
			throw BizException.wrap(ExceptionCode.NOT_FOUND_ENTITT_ERROR);
		return Result.success(ModelMapper.toModel(customerRole));
	} 
	
	@PostMapping("/edit")
	public Result<?> edit(@Validated @RequestBody CustomerRoleModel customerRoleMode, BindingResult bindingResult)
	{
		if(bindingResult.hasErrors()){
			return Result.bindingError(bindingResult);
		}
		CustomerRole customerRole = customerService.getCustomerRoleById(customerRoleMode.getId());
		if(null == customerRole)
			throw BizException.wrap(ExceptionCode.NOT_FOUND_ENTITT_ERROR);
		
		if(customerRole.getIsSystemRole()) {
			if(!customerRole.getActive() || !customerRoleMode.getIsSystemRole() || !customerRole.getSystemName().equalsIgnoreCase(customerRoleMode.getSystemName())) {
				throw BizException.wrap(ExceptionCode.EDIT_SYSTEM_ROLE_ERROR);
			}
		}
		
		customerRole = ModelMapper.toEntity(customerRoleMode);
		customerService.updateCustomerRole(customerRole);
		return Result.success(customerRole.getId());
	} 
	
	@PostMapping("/delete")
	public Result<?> delete(@RequestBody long id)
	{
		CustomerRole customerRole = customerService.getCustomerRoleById(id);
		if(null == customerRole)
			throw BizException.wrap(ExceptionCode.NOT_FOUND_ENTITT_ERROR);
		customerService.deleteCustomerRole(customerRole);
		return Result.success(customerRole.getId());
	} 
}
