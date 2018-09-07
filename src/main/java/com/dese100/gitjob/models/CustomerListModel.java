package com.dese100.gitjob.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dese100.gitjob.common.DataSourceRequest;

public class CustomerListModel extends DataSourceRequest{
	public List<Integer> CustomerRoleIds;
	public String Email;
	public String Username;
	public Date CreatedFromUtc;
	public Date CreatedToUtc;
	public String Phone;
	public  CustomerListModel() {
		CustomerRoleIds = new ArrayList<Integer>();
	}
	
}
