package com.dese100.gitjob.domain;

import java.util.Date;

public class Customer extends BaseEntity{
	private long id;
	private String userName;
	private String phone;
	private String email;
	private String emailToRevalidate;
	private int failedLoginAttempts;
	private Date cannotLoginUntilDateUtc;
	private boolean deleted;
	private boolean isSystemAccount;
	private String systemName;
	private Date createdOnUtc;
	private boolean active;
	private long tenantId;
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
	public boolean isDeleted() {
		return deleted;
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
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public long getTenantId() {
		return tenantId;
	}
	public void setTenantId(long tenantId) {
		this.tenantId = tenantId;
	}
	
}
