package com.zhao.mvp;

import java.util.List;

import com.zhao.mvc.bean.User;

public interface IUserView {
	void show(User user);
	void show(List<User> users);
	void empty();
	void loginSuccess();
	void loginFailue();
	void checkUser(String ret);
}
