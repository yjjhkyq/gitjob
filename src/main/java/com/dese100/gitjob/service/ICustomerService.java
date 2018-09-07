package com.dese100.gitjob.service;

import java.util.Date;
import java.util.List;

import com.dese100.gitjob.domain.Customer;
import com.dese100.gitjob.domain.CustomerPassword;
import com.dese100.gitjob.domain.CustomerRole;
import com.dese100.gitjob.domain.PasswordFormat;
import com.github.pagehelper.PageInfo;

public interface ICustomerService {

    PageInfo<Customer> GetAllCustomers(Date createdFromUtc,
    		Date createdToUtc, 
        Integer[] customerRoleIds, String email, String userName,
         String phone, Integer pageIndex, Integer pageSize);
    
    /// <summary>
    /// Delete a customer
    /// </summary>
    /// <param name="customer">Customer</param>
    void DeleteCustomer(Customer customer);

    /// <summary>
    /// Gets a customer
    /// </summary>
    /// <param name="customerId">Customer identifier</param>
    /// <returns>A customer</returns>
    Customer GetCustomerById(Integer customerId);

    /// <summary>
    /// Get customers by identifiers
    /// </summary>
    /// <param name="customerIds">Customer identifiers</param>
    /// <returns>Customers</returns>
    List<Customer> GetCustomersByIds(Integer[] customerIds);

    /// <summary>
    /// Get customer by email
    /// </summary>
    /// <param name="email">Email</param>
    /// <returns>Customer</returns>
    Customer GetCustomerByEmail(String email);
    
    /// <summary>
    /// Get customer by system role
    /// </summary>
    /// <param name="systemName">System name</param>
    /// <returns>Customer</returns>
    Customer GetCustomerBySystemName(String systemName);

    /// <summary>
    /// Get customer by username
    /// </summary>
    /// <param name="username">Username</param>
    /// <returns>Customer</returns>
    Customer GetCustomerByUsername(String username);

    /// <summary>
    /// Insert a guest customer
    /// </summary>
    /// <returns>Customer</returns>
    Customer InsertGuestCustomer();

    /// <summary>
    /// Insert a customer
    /// </summary>
    /// <param name="customer">Customer</param>
    long InsertCustomer(Customer customer);

    /// <summary>
    /// Updates the customer
    /// </summary>
    /// <param name="customer">Customer</param>
    void UpdateCustomer(Customer customer);
    
    List<CustomerPassword> GetCustomerPasswords(Integer customerId,
        PasswordFormat passwordFormat, Integer passwordsToReturn);

    /// <summary>
    /// Get current customer password
    /// </summary>
    /// <param name="customerId">Customer identifier</param>
    /// <returns>Customer password</returns>
    CustomerPassword GetCurrentPassword(Integer customerId);

    /// <summary>
    /// Insert a customer password
    /// </summary>
    /// <param name="customerPassword">Customer password</param>
    void InsertCustomerPassword(CustomerPassword customerPassword);

    /// <summary>
    /// Update a customer password
    /// </summary>
    /// <param name="customerPassword">Customer password</param>
    void UpdateCustomerPassword(CustomerPassword customerPassword);
   
    /// <summary>
    /// Delete a customer role
    /// </summary>
    /// <param name="customerRole">Customer role</param>
    void deleteCustomerRole(CustomerRole customerRole);

    /// <summary>
    /// Gets a customer role
    /// </summary>
    /// <param name="customerRoleId">Customer role identifier</param>
    /// <returns>Customer role</returns>
    CustomerRole getCustomerRoleById(Long customerRoleId);

    /// <summary>
    /// Gets a customer role
    /// </summary>
    /// <param name="systemName">Customer role system name</param>
    /// <returns>Customer role</returns>
    CustomerRole getCustomerRoleBySystemName(String systemName);

    /// <summary>
    /// Gets all customer roles
    /// </summary>
    /// <param name="showHidden">A value indicating whether to show hidden records</param>
    /// <returns>Customer roles</returns>
    PageInfo<CustomerRole> GetAllCustomerRoles(Boolean showHidden);

    /// <summary>
    /// Inserts a customer role
    /// </summary>
    /// <param name="customerRole">Customer role</param>
    void insertCustomerRole(CustomerRole customerRole);

    /// <summary>
    /// Updates the customer role
    /// </summary>
    /// <param name="customerRole">Customer role</param>
    void updateCustomerRole(CustomerRole customerRole);
    
    void setCustomerRole(Customer customer,  List<CustomerRole> customerRoles);

}
