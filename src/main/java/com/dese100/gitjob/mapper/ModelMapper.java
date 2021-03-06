package com.dese100.gitjob.mapper;

import java.util.ArrayList;
import java.util.List;

import com.dese100.gitjob.domain.Category;
import com.dese100.gitjob.domain.Customer;
import com.dese100.gitjob.domain.CustomerRole;
import com.dese100.gitjob.models.CategoryModel;
import com.dese100.gitjob.models.CustomerModel;
import com.dese100.gitjob.models.CustomerRoleModel;
import com.dese100.gitjob.service.ICustomerService;
import com.github.pagehelper.PageInfo;

public class ModelMapper {
	
	public static Category toEntity(CategoryModel src) {
		Category dest = new Category();
		dest.setCreatedOnUtc(src.getCreatedOnUtc());
		dest.setDeleted(src.getDeleted());
		dest.setDescription(src.getDescription());
		dest.setDisplayOrder(src.getDisplayOrder());
		dest.setId(src.getId());
		dest.setIncludeInTopMenu(src.getIncludeInTopMenu());
		dest.setName(src.getName());
		dest.setParentCategoryId(src.getParentCategoryId());
		dest.setPublished(src.getPublished());
		dest.setShowOnHomePage(src.getShowOnHomePage());
		dest.setUpdatedOnUtc(src.getUpdatedOnUtc());
		return dest;
	}
	
	public static CategoryModel toModel(Category src) {
		CategoryModel dest = new CategoryModel();
		dest.setCreatedOnUtc(src.getCreatedOnUtc());
		dest.setDeleted(src.getDeleted());
		dest.setDescription(src.getDescription());
		dest.setDisplayOrder(src.getDisplayOrder());
		dest.setId(src.getId());
		dest.setIncludeInTopMenu(src.getIncludeInTopMenu());
		dest.setName(src.getName());
		dest.setParentCategoryId(src.getParentCategoryId());
		dest.setPublished(src.getPublished());
		dest.setShowOnHomePage(src.getShowOnHomePage());
		dest.setUpdatedOnUtc(src.getUpdatedOnUtc());
		return dest;
	}
	
	public static PageInfo<CategoryModel> toCategoryPageModel(PageInfo<Category> src){
		if(null == src)
			return null;
		List<CategoryModel> dest = new ArrayList<CategoryModel>();
		src.getList().forEach(s -> {dest.add(toModel(s));});
		PageInfo<CategoryModel> pageInfo = pageInfoCopy(src);
		pageInfo.setList(dest);
		return pageInfo;
	}
	
	public static CustomerRole toEntity(CustomerRoleModel model)
	{
		CustomerRole customerRole = new CustomerRole();
		customerRole.setId(model.getId());
		customerRole.setActive(model.getActive());
		customerRole.setIsSystemRole(model.getIsSystemRole());
		customerRole.setName(model.getName());
		customerRole.setSystemName(model.getSystemName());
		return customerRole;
	}
	
	public static CustomerRoleModel toModel(CustomerRole entity)
	{
		if(null == entity)
			return null;
		CustomerRoleModel model = new CustomerRoleModel();
		model.setId(entity.getId());
		model.setActive(entity.getActive());
		model.setIsSystemRole(entity.getIsSystemRole());
		model.setName(entity.getName());
		model.setSystemName(entity.getSystemName());
		return model;
	}
	
	public static PageInfo<CustomerRoleModel> toModel(PageInfo<CustomerRole> entityList){
		if(null == entityList)
			return null;
		List<CustomerRoleModel> modelList = new ArrayList<CustomerRoleModel>();
		entityList.getList().forEach(s -> {modelList.add(toModel(s));});
		PageInfo<CustomerRoleModel> pageInfo = pageInfoCopy(entityList);
		pageInfo.setList(modelList);
		return pageInfo;
	}
	
	public static PageInfo<CustomerModel> toModel(PageInfo<Customer> entityList, ICustomerService customerService){
		List<CustomerModel> modelList = new ArrayList<CustomerModel>();
		entityList.getList().forEach(s -> {modelList.add(toModel(s, customerService));});
		PageInfo<CustomerModel> pageInfo = pageInfoCopy(entityList);
		pageInfo.setList(modelList);
		return pageInfo;
	}
	
	public static Customer toEntity(CustomerModel model, ICustomerService customerService) {
		Customer entity = new Customer();
		entity.setId(model.getId());
		entity.setEmail(model.getEmail());
		entity.setPhone(model.getPhone());
		entity.setUserName(model.getUserName());
		entity.setCreatedOnUtc(model.getCreatedOnUtc());
		entity.setActive(model.getActive());
		entity.setIsSystemAccount(model.isSystemAccount());
		entity.setTenantId(model.getTenantId());
		entity.setDeleted(model.getDeleted());
		entity.setFailedLoginAttempts(0);
		entity.setSystemName(model.getSystemName());
		if(null != model.getCustomerRoles())
			model.getCustomerRoles().forEach(s -> {
				if(null != customerService) {
					CustomerRole customerRole = customerService.getCustomerRoleById(s.getId());
					if(null != customerRole)
						entity.getCustomerRoles().add(customerRole);
				}
				});
		return entity;
	}
	
	public static CustomerModel toModel(Customer customer, ICustomerService customerService) {
		CustomerModel customerModel = new CustomerModel();
		customerModel.setId(customer.getId());
		customerModel.setEmail(customer.getEmail());
		customerModel.setPhone(customer.getPhone());
		customerModel.setUserName(customer.getUserName());
		customerModel.setCreatedOnUtc(customer.getCreatedOnUtc());
		customerModel.setActive(customer.getActive());
		if(null != customer.getCustomerRoles())
			customer.getCustomerRoles().forEach(s -> {
				if(null != customerService) {
					s = customerService.getCustomerRoleById(s.getId());
					if(null != s)
						customerModel.getCustomerRoles().add(toModel(s));
				}
				});
		return customerModel;
	}
	
	private static PageInfo pageInfoCopy(PageInfo source)
	{
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNum(source.getPageNum());
		pageInfo.setPageSize(source.getPages());
		pageInfo.setHasNextPage(source.isHasNextPage());
		return pageInfo;
	}
}
