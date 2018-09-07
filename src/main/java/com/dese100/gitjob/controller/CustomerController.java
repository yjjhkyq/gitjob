package com.dese100.gitjob.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dese100.gitjob.common.DataSourceRequest;
import com.dese100.gitjob.domain.Customer;
import com.dese100.gitjob.domain.CustomerRole;
import com.dese100.gitjob.domain.PasswordFormat;
import com.dese100.gitjob.domain.SystemCustomerRoleNames;
import com.dese100.gitjob.domain.result.Result;
import com.dese100.gitjob.mapper.ModelMapper;
import com.dese100.gitjob.models.CustomerListModel;
import com.dese100.gitjob.models.CustomerModel;
import com.dese100.gitjob.models.CustomerRoleModel;
import com.dese100.gitjob.service.ICustomerRegistrationService;
import com.dese100.gitjob.service.ICustomerService;
import com.github.pagehelper.PageInfo;
import com.mysql.cj.util.StringUtils;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	ICustomerService customerService;
	@Autowired
	ICustomerRegistrationService customerRegistrationService;

	@PostMapping("/list")
	public Result<?> customerList(@RequestBody CustomerListModel customerListModel) {
		Integer[] customerRoles = new Integer[0];
		if(null != customerListModel.CustomerRoleIds) {
			customerRoles = new Integer[customerListModel.CustomerRoleIds.size()];
			customerListModel.CustomerRoleIds.toArray(customerRoles);
		}
		PageInfo<Customer> customer = customerService.GetAllCustomers(customerListModel.CreatedFromUtc,
				customerListModel.CreatedToUtc, customerRoles,
				customerListModel.Email, customerListModel.Username, customerListModel.Phone, customerListModel.getPage(),
				customerListModel.getPageSize());
		return Result.success(ModelMapper.toModel(customer, customerService));
	}
	
	@Transactional
	@PostMapping("/create")
	public Result<?> create(@RequestBody @Validated CustomerModel model, BindingResult bindingResult) {
		if (!StringUtils.isNullOrEmpty(model.getEmail())) {
			Customer customer = customerService.GetCustomerByEmail(model.getEmail());
			if (null != customer) {
				bindingResult.addError(new ObjectError("allerrors", "Email is already registered"));
			}
		}
		if (StringUtils.isNullOrEmpty(model.getUserName())) {
			Customer customer = customerService.GetCustomerByUsername(model.getUserName());
			if (null != customer) {
				bindingResult.addError(new ObjectError("allerrors", "Username is already registered"));
			}
		}

		List<CustomerRole> customerRoles = customerService.GetAllCustomerRoles(true).getList();
		List<CustomerRole> newCustomerRoles = new ArrayList<CustomerRole>();
		model.getCustomerRoles().forEach(s -> {
			for (CustomerRole customerRole : customerRoles) {
				if (customerRole.getId() == s.getId()) {
					newCustomerRoles.add(customerRole);
					return;
				}
			}
		});

		String customerRoleError = ValidateCustomerRoles(customerRoles);
		if (!StringUtils.isNullOrEmpty(customerRoleError)) {
			bindingResult.addError(new ObjectError("allerrors", customerRoleError));
		}
		if (bindingResult.hasErrors()) {
			return Result.bindingError(bindingResult);
		}

		Customer customer = ModelMapper.toEntity(model, null);
		customer.setActive(true);
		customer.setCreatedOnUtc(new Date());
		customer.setDeleted(false);
		customerService.InsertCustomer(customer);
		customerRegistrationService.changePassword(customer.getUserName(), false, PasswordFormat.Hashed,
				model.getPassword(), null);
		customerService.setCustomerRole(customer, newCustomerRoles);
		return Result.success(1);
	}

	private String ValidateCustomerRoles(List<CustomerRole> lists) {
		if (0 >= lists.size()) {
			return "NoCustomerRoleError";
		}

		boolean isGuestRole = false;
		boolean isRegisteredRole = false;
		for (CustomerRole customerRole : lists) {
			if (SystemCustomerRoleNames.Registered.equals(customerRole.getSystemName())) {
				isRegisteredRole = true;
			}
			if (SystemCustomerRoleNames.Guests.equals(customerRole.getSystemName())) {
				isGuestRole = true;
			}
		}
		if (isRegisteredRole && isGuestRole) {
			return "GuestsAndRegisteredRolesError";
		}
		if (!isRegisteredRole && !isGuestRole) {
			return "AddCustomerToGuestsOrRegisteredRoleError";
		}
		//TODO:should not add admin role if current user is not admin
		return null;
	}
}
