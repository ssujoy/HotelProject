package com.hotel.web.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hotel.web.entity.User;
import com.hotel.web.repository.UserRepo;

@Service("loginService")
public class LoginService {
	
	@Autowired
	UserRepo userRepo;
	
	public String authenticateUser(String userDetails){
		String entityId = null;
		String username = "";
		String password = "";
		try
		{
			JSONObject userObject = new JSONObject(userDetails);
			username = userObject.getString("username");
			password = userObject.getString("password");
			
			entityId = userRepo.getUser(username, password);
			System.out.println("Status = "+entityId);
			if(entityId == null){
				return null;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return entityId;
	}
	
	public String createUser(String userDetails){
		String userId = "";
		String username = "";
		String password = "";
		try {
			JSONObject userObject = new JSONObject(userDetails);
			username = userObject.getString("username");
			password = userObject.getString("password");
			
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			userRepo.save(user);
			userId = String.valueOf(user.getEntityId());
		} catch (Exception ex) {
			return "Error creating the user: " + ex.toString();
		}
		return "User succesfully created with id = " + userId;
	}
}
