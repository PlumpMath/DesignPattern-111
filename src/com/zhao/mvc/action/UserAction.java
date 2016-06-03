package com.zhao.mvc.action;

import java.util.ArrayList;
import java.util.List;

import com.zhao.mvc.bean.User;

public class UserAction {

	public static int count = 0;

	public static User getUser(String url) {
		// TODO Auto-generated method stub
		count++;
		return new User("userName" + count, 12 + count);
	}

	public static List<User> getUserList(String url) {
		// TODO Auto-generated method stub
		List<User> users = new ArrayList<User>();
		int len = count == 0 ? 1 : (count % 5);
		for (int i = 0; i < len; i++) {
			count++;
			User user = new User("userName" + count, 12 + count);
			users.add(user);
		}
		return users;
	}

}
