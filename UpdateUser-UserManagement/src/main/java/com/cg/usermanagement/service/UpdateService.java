package com.cg.usermanagement.service;

import com.cg.usermanagement.entity.UserDto;
import com.cg.usermanagement.exception.InvalidDetailsException;

public interface UpdateService {

	String updateUser(UserDto userDto) throws InvalidDetailsException;

	
}
