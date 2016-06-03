package com.zhao.mvc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zhao.mvc.bean.User;

public class UserDB {

	private static Map<String, User> userCache = new HashMap<String, User>();
	private static Map<String, List<User>> usersCache = new HashMap<String, List<User>>();

	public static User getUser(String key) {
		// TODO Auto-generated method stub
		return userCache.get(key);
	}

	public static List<User> getUserList(String key) {
		// TODO Auto-generated method stub
		return usersCache.get(key);
	}

	public static void saveUser(String key, User user) {
		// TODO Auto-generated method stub
		userCache.put(key, user);
	}

	public static void saveUserList(String key, List<User> users) {
		// TODO Auto-generated method stub
		usersCache.put(key, users);
	}

	public static void deleteUser(User user) {
		// TODO Auto-generated method stub
		userCache.remove(user);
	}

}
