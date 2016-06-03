package com.zhao.mvc.model;

import java.util.List;

import com.zhao.mvc.bean.User;

public interface UserModel {
	public static final String PRIORITY_CACHE = "priority_cache";
	public static final String PRIORITY_NETWORK = "priority_network";

	User getUser(String priority);

	User getUser();
	
	void getUser(Callback<User> callback);
	
	void getUser(String priority ,Callback<User> callback);

	List<User> getUserList();
	
	void getUserList(Callback<List<User>> callback);

	List<User> getUserList(String priority);
	
	void getUserList(String priority ,Callback<List<User>> callback);

	void saveUser(User user);

	void deleteUser(User user);
	
	boolean login(User user);
	
	void login(User user,Callback<Boolean> callback);
	
	boolean logout();

}