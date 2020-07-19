package com.cg.usermanagement.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.usermanagement.entity.UserDto;
import com.cg.usermanagement.exception.InvalidDetailsException;
import com.cg.usermanagement.service.UpdateService;

@CrossOrigin(origins="http://localhost:8200")
@RestController
@RequestMapping("/UserManagement")
public class UserManagementController
{

	@Autowired
	UpdateService updateserviceobj;
	
	static  Logger logger=LoggerFactory.getLogger(UserManagementController.class);

	
	/*Updating an exisiting User*/
	/*--------------------------------------*/
	@PutMapping("/UpdateUser")
	public UserDto updateUser(@RequestBody UserDto userDto) throws InvalidDetailsException 
	{
		logger.warn("Request{}",userDto);
		return updateserviceobj.updateUser(userDto);
	}
	
}
