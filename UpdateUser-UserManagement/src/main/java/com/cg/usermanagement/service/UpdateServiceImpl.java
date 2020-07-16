package com.cg.usermanagement.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.usermanagement.dao.UpdateDao;
import com.cg.usermanagement.entity.UserDto;
import com.cg.usermanagement.exception.InvalidDetailsException;

@Service
public class UpdateServiceImpl  implements UpdateService
{
	@Autowired
	UpdateDao updatedaoobj;

		@Override
	public String updateUser(UserDto userDto) throws InvalidDetailsException
	{
		Optional<UserDto> userobj=updatedaoobj.findById(userDto.getUserid());
		
		 if(userobj.isPresent()) 
	        {
			 UserDto newEntity = userobj.get();
			 newEntity.setEmail(userDto.getEmail());
			 
	            newEntity.setFirstName(userDto.getFirstName());
	            newEntity.setPassword(userDto.getPassword());
	            
	            newEntity = updatedaoobj.save(newEntity);
	             
	            return "Updated Succesfully";
	        } else {
	        	 
	        	throw new InvalidDetailsException("User is not Updated!!!!!!!!!!");
	        	}
	}
	


		}


