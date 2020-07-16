package com.cg.usermanagement;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.net.URI;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.cg.usermanagement.dao.UpdateDao;
import com.cg.usermanagement.entity.UserDto;
import com.cg.usermanagement.service.UpdateService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=EdituserApplication.class)

class EdituserApplicationTests
{
	@MockBean
	UpdateDao repository;
	@Autowired
	UpdateService updateserviceobj;
	
	@Test
	public void test1() throws Exception
	{
		   RestTemplate restTemplate = new RestTemplate();
		     
		    final String baseUrl = "http://localhost:" + 8975 + "/UserManagement/updateuser";
		    URI uri = new URI(baseUrl);
		    UserDto userdto=new UserDto();
		    userdto.setUserid(384);
		    userdto.setEmail("anu@gmail.com");
		    userdto.setFirstName("Anu");
		    userdto.setPassword("fruit");
		    HttpHeaders headers = new HttpHeaders();
		    headers.set("X-COM-PERSIST", "Updated Succesfully");
		    HttpEntity<UserDto> request = new HttpEntity<>(userdto, headers);
			 ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.PUT,request,String.class);
			 System.out.println(result);
			 assertEquals("Updated Succesfully", result.getBody());
	}
    
	
    
}
