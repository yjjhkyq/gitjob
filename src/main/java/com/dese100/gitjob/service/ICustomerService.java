package com.dese100.gitjob.service;

import java.util.List;

import com.dese100.gitjob.domain.Customer;
import com.dese100.gitjob.domain.CustomerPassword;
import com.dese100.gitjob.domain.PasswordFormat;

public interface ICustomerService {
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
    Customer GetCustomerById(int customerId);

    /// <summary>
    /// Get customers by identifiers
    /// </summary>
    /// <param name="customerIds">Customer identifiers</param>
    /// <returns>Customers</returns>
    List<Customer> GetCustomersByIds(int[] customerIds);

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
    
    List<CustomerPassword> GetCustomerPasswords(int customerId,
        PasswordFormat passwordFormat, int passwordsToReturn);

    /// <summary>
    /// Get current customer password
    /// </summary>
    /// <param name="customerId">Customer identifier</param>
    /// <returns>Customer password</returns>
    CustomerPassword GetCurrentPassword(int customerId);

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

}
