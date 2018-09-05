package com.dese100.gitjob.domain;

import java.util.Date;

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
	public Boolean isDeleted() {
		return deleted;
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
	public Boolean isActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public Long getTenantId() {
		return tenantId;
	}
	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
	
}
