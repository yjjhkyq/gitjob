package com.dese100.gitjob.domain;

import java.util.Date;

public class CustomerPassword {
	 /// <summary>
    /// Gets or sets the customer identifier
    /// </summary>
    private int customerId;

    /// <summary>
    /// Gets or sets the password
    /// </summary>
    private String password;

    /// <summary>
    /// Gets or sets the password format identifier
    /// </summary>
    private int passwordFormatId;

    /// <summary>
    /// Gets or sets the password salt
    /// </summary>
    private String passwordSalt;

    /// <summary>
    /// Gets or sets the date and time of entity creation
    /// </summary>
    private Date createdOnUtc;
    
    private PasswordFormat passwordFormat;
    
    /// <summary>
    /// Gets or sets the password format
    /// </summary>
    public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPasswordFormatId() {
		return passwordFormatId;
	}
	public void setPasswordFormatId(int passwordFormatId) {
		this.passwordFormatId = passwordFormatId;
	}
	public String getPasswordSalt() {
		return passwordSalt;
	}
	public void setPasswordSalt(String passwordSalt) {
		this.passwordSalt = passwordSalt;
	}
	public Date getCreatedOnUtc() {
		return createdOnUtc;
	}
	public void setCreatedOnUtc(Date createdOnUtc) {
		this.createdOnUtc = createdOnUtc;
	}
}
