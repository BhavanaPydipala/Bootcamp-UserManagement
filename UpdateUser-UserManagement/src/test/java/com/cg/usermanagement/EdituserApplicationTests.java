package com.cg.usermanagement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.usermanagement.entity.UserDto;
import com.cg.usermanagement.exception.InvalidDetailsException;
import com.cg.usermanagement.service.UpdateServiceImpl;

@SpringBootTest

class EdituserApplicationTests
{
 @Autowired
 UpdateServiceImpl service;
	@Test
	public void testUpdateUser_Positive1() throws Exception
	{
		UserDto user=new UserDto(384,"pydipalabhavana@gmail.com","Anusha","Anu");
       UserDto c=service.updateUser(user);
       //Asserstions.assertEquals()
     Assertions.assertEquals(c.getUserid(),user.getUserid());
	}
	@Test
	public void testUpdateUser_Positive2() throws Exception
	{
		UserDto user=new UserDto(382,"teju123@gmail.com","Madhuri","Madhu123");
       UserDto c=service.updateUser(user);
       //Asserstions.assertEquals()
     Assertions.assertEquals(c.getUserid(),user.getUserid());
	}
	
	@Test
	public void testUpdateUser_Negative1() throws InvalidDetailsException 
	{
		UserDto user=new UserDto(987,"pydipalabhavana@gmail.com","Anusha","Anu");
        UserDto c=service.updateUser(user);
       System.out.println(user.getUserid());
     Assertions.assertNotEquals(c.getUserid(),user.getUserid());
	}

}
