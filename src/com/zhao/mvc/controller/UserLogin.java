package com.zhao.mvc.controller;

import com.zhao.mvc.bean.User;
import com.zhao.mvc.model.UserModel;
import com.zhao.mvc.model.UserModelImpl;

public class UserLogin {
	public static void login(User user, Callback<String> callback) {
		// TODO Auto-generated method stub
		login(user, new UserModelImpl(), callback);
	}

	public static void login(User user, UserModel userModel, Callback<String> callback) {
		// TODO Auto-generated method stub
		String ret = checkUser(user);
		if (!"success".equals(ret)) {
			callback.check(ret);
			return;
		}
		if (userModel.login(user)) {
			callback.success("login success !");
		} else {
			callback.failue("login failue !");
		}
	}

	public static String checkUser(User user) {
		// TODO Auto-generated method stub
		String ret = "success";
		if ("".equals(user.getName()) || null == user.getName()) {
			ret = "User name cannot be empty";
		}
		if (user.getAge() < 0 || user.getAge() > 120) {
			ret = "Age is not legal";
		}
		return ret;
	}

	public static interface Callback<T> {
		void success(T t);

		void failue(T t);

		void check(String ret);
	}
}
