package com.dese100.gitjob.models.Validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.dese100.gitjob.models.CustomerModel;
import com.dese100.gitjob.service.ICustomerService;

public class CustomerPostValidatorImpl implements ConstraintValidator<CustomerPostValidator, CustomerModel> {
	
	@Autowired
	ICustomerService customerService;

	@Override
	public void initialize(CustomerPostValidator constraintAnnotation) {
	}

	@Override
	public boolean isValid(CustomerModel arg0, ConstraintValidatorContext arg1) {
		if (null == arg0)
			return true;
		return true;
	}
}
