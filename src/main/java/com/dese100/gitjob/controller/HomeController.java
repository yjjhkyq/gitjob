package com.dese100.gitjob.controller;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dese100.gitjob.domain.Customer;
import com.dese100.gitjob.domain.result.Result;
import com.dese100.gitjob.exception.BizException;
import com.dese100.gitjob.exception.code.ExceptionCode;
import com.dese100.gitjob.service.ICustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/Home")
public class HomeController {
	protected Logger logger =  LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	ICustomerService customerService;
	
	@GetMapping("/index")
	public ResponseEntity<String> Index(int value)
	{
		logger.info("index");
		return ResponseEntity.ok("Hello:" + value);
	}
	
	@GetMapping("/CreateCustomer")
	public Result<Long> CreateCustomer()
	{
		Customer customer = new Customer();
		customer.setUserName("test");
		long id = customerService.InsertCustomer(customer);
		return Result.success(id);
	} 
}
