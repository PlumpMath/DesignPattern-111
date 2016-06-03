package com.zhao.mvp.presenter;

import com.zhao.mvc.bean.User;

public interface UserPresenter {

	public static final String PRIORITY_CACHE = "priority_cache";
	public static final String PRIORITY_NETWORK = "priority_network";

	void getUser(String priority);

	void getUser();
	
	void getUserList();
	
	void getUserList(String priority);
	
	void login(User user);
	
	void logout();
}
