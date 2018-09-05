package com.dese100.gitjob.common;

public class DataSourceRequest {
	private int page;
	private int pageSize;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public DataSourceRequest() {
		this.page = 1;
		this.pageSize = 10;
	}
}
