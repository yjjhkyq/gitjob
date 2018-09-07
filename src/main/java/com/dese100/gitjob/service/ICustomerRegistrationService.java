package com.dese100.gitjob.service;

import com.dese100.gitjob.domain.PasswordFormat;

public interface ICustomerRegistrationService {
	public void changePassword(String userName, boolean ValidateRequest, PasswordFormat paswordFormat, String newPassword, String oldPassword);
}
