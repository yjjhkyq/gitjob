package com.dese100.gitjob.domain;

import java.util.Date;

public class CustomerPassword {
	private Long id;
	 /// <summary>
    /// Gets or sets the customer identifier
    /// </summary>
    private Long customerId;

    /// <summary>
    /// Gets or sets the password
    /// </summary>
    private String password;

    /// <summary>
    /// Gets or sets the password format identifier
    /// </summary>
    private Integer passwordFormatId;

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
    public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getPasswordFormatId() {
		return passwordFormatId;
	}
	public void setPasswordFormatId(Integer passwordFormatId) {
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
