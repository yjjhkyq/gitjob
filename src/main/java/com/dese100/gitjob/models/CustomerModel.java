package com.dese100.gitjob.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

public class CustomerModel {
	private long id;
	@Length(min=6,max=10,message="user name lenght max between 6 to 12")
	private String userName;
	private String phone;
	@Email(message="email format error")
	private String email;
	@NotEmpty(message = "passowrd is empty")
	@Length(min = 6, max = 32, message = "password length max between 6 to 20")
	@Pattern(regexp = "^[a-zA-Z0-9]{6,20}$", message = "password format error")
	private String password;
	private String emailToRevalidate;
	private int failedLoginAttempts;
	private Date cannotLoginUntilDateUtc;
	private boolean deleted;
	private boolean isSystemAccount;
	private String systemName;
	private Date createdOnUtc;
	private boolean active;
	private long tenantId;
	private List<CustomerRoleModel> customerRoles;
	
	public CustomerModel() {
		customerRoles = new ArrayList<CustomerRoleModel>();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmailToRevalidate() {
		return emailToRevalidate;
	}
	public void setEmailToRevalidate(String emailToRevalidate) {
		this.emailToRevalidate = emailToRevalidate;
	}
	public int getFailedLoginAttempts() {
		return failedLoginAttempts;
	}
	public void setFailedLoginAttempts(int failedLoginAttempts) {
		this.failedLoginAttempts = failedLoginAttempts;
	}
	public Date getCannotLoginUntilDateUtc() {
		return cannotLoginUntilDateUtc;
	}
	public void setCannotLoginUntilDateUtc(Date cannotLoginUntilDateUtc) {
		this.cannotLoginUntilDateUtc = cannotLoginUntilDateUtc;
	}
 
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public boolean isSystemAccount() {
		return isSystemAccount;
	}
	public void setSystemAccount(boolean isSystemAccount) {
		this.isSystemAccount = isSystemAccount;
	}
	public String getSystemName() {
		return systemName;
	}
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	public Date getCreatedOnUtc() {
		return createdOnUtc;
	}
	public void setCreatedOnUtc(Date createdOnUtc) {
		this.createdOnUtc = createdOnUtc;
	}

	public long getTenantId() {
		return tenantId;
	}
	public void setTenantId(long tenantId) {
		this.tenantId = tenantId;
	}
	public boolean getIsSystemAccount() {
		return isSystemAccount;
	}
	public void setIsSystemAccount(boolean isSystemAccount) {
		this.isSystemAccount = isSystemAccount;
	}
	public List<CustomerRoleModel> getCustomerRoles() {
		return customerRoles;
	}
	public void setCustomerRoles(List<CustomerRoleModel> customerRoles) {
		this.customerRoles = customerRoles;
	}
	public boolean getDeleted() {
		return deleted;
	}
	public boolean getActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
