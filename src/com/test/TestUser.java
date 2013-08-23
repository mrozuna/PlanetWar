package com.test;

import com.Data.UserApi;
import com.Endpoint.UserController;
import com.google.appengine.api.oauth.OAuthRequestException;

public class TestUser {

	public TestUser() {
		// TODO Auto-generated constructor stub
	}
public UserApi add(UserApi user) throws OAuthRequestException{
	UserController userController= new UserController();
	return userController.add(user);
	
}


public UserApi getData(int id){
	UserController userController= new UserController();
	return userController.getData(id);
}

public UserApi udateData(UserApi user){
	UserController userController= new UserController();
	return userController.updateData(user);
	
}


}
