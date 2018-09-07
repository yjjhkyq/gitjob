package com.dese100.gitjob.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Customer extends BaseEntity{
	private Long id;
	private String userName;
	private String phone;
	private String email;
	private String emailToRevalidate;
	private Integer failedLoginAttempts;
	private Date cannotLoginUntilDateUtc;
	private Boolean deleted;
	private Boolean isSystemAccount;
	private String systemName;
	private Date createdOnUtc;
	private Boolean active;
	private Long tenantId;
	private List<CustomerRole> customerRoles;
	
	public Customer() {
		customerRoles = new ArrayList<CustomerRole>();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public Integer getFailedLoginAttempts() {
		return failedLoginAttempts;
	}
	public void setFailedLoginAttempts(Integer failedLoginAttempts) {
		this.failedLoginAttempts = failedLoginAttempts;
	}
	public Date getCannotLoginUntilDateUtc() {
		return cannotLoginUntilDateUtc;
	}
	public void setCannotLoginUntilDateUtc(Date cannotLoginUntilDateUtc) {
		this.cannotLoginUntilDateUtc = cannotLoginUntilDateUtc;
	}
 
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	public Boolean isSystemAccount() {
		return isSystemAccount;
	}
	public void setSystemAccount(Boolean isSystemAccount) {
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

	public Long getTenantId() {
		return tenantId;
	}
	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
	public Boolean getIsSystemAccount() {
		return isSystemAccount;
	}
	public void setIsSystemAccount(Boolean isSystemAccount) {
		this.isSystemAccount = isSystemAccount;
	}
	public List<CustomerRole> getCustomerRoles() {
		return customerRoles;
	}
	public void setCustomerRoles(List<CustomerRole> customerRoles) {
		this.customerRoles = customerRoles;
	}
	public Boolean getDeleted() {
		return deleted;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
}
