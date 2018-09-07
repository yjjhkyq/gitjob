package com.dese100.gitjob.models;
import org.hibernate.validator.constraints.Length;
public class CustomerRoleModel {
	private long id;
	@Length(min=1,max=10,message="name length max between 1 and 10")
	private String name;
	private boolean active;
	private boolean isSystemRole;
	private String systemName;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean getActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean getIsSystemRole() {
		return isSystemRole;
	}
	public void setIsSystemRole(boolean isSystemRole) {
		this.isSystemRole = isSystemRole;
	}
	public String getSystemName() {
		return systemName;
	}
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
}
