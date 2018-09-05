package com.dese100.gitjob.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CustomerRoleModel {
	private Long id;
	@NotEmpty
	private String name;
	@NotNull
	private Boolean active;
	@NotNull
	private Boolean isSystemRole;
	private String systemName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public Boolean getIsSystemRole() {
		return isSystemRole;
	}
	public void setIsSystemRole(Boolean isSystemRole) {
		this.isSystemRole = isSystemRole;
	}
	public String getSystemName() {
		return systemName;
	}
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
}
