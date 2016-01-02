package com.hotel.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.web.service.LoginService;

@RestController
@RequestMapping("/service/")
public class LoginController {
	@Autowired
	public LoginService loginService = new LoginService();

	/*http://localhost:8080/service/login
	{
	  username : 'sujoy',
	  password : '1234'
	}*/
	@RequestMapping(value="login", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public String authenticateUser(@RequestBody String userDetails){
		return loginService.authenticateUser(userDetails);
	}
	/*http://localhost:8080/service/create-user
	{
	  username : 'sujoy',
	  password : '1234'
	}*/
	@RequestMapping(value="create-user", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public String createUser(@RequestBody String userDetails) {
		return loginService.createUser(userDetails);
	}
}
