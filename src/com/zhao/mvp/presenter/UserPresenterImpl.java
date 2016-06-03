package com.zhao.mvp.presenter;

import java.util.List;

import com.zhao.mvc.bean.User;
import com.zhao.mvc.model.UserModel;
import com.zhao.mvc.model.UserModelImpl;
import com.zhao.mvp.IUserView;

public class UserPresenterImpl implements UserPresenter {

	private IUserView iUserView;
	private UserModel userModel;

	public UserPresenterImpl(IUserView iUserView) {
		this.iUserView = iUserView;
		this.userModel = new UserModelImpl();
	}

	@Override
	public void getUser(String priority) {
		// TODO Auto-generated method stub
		User user = userModel.getUser(priority);
		if (user != null) {
			iUserView.show(user);
		} else {
			iUserView.empty();
		}
	}

	@Override
	public void getUser() {
		// TODO Auto-generated method stub
		User user = userModel.getUser();
		if (user != null) {
			iUserView.show(user);
		} else {
			iUserView.empty();
		}
	}

	@Override
	public void getUserList() {
		// TODO Auto-generated method stub
		List<User> users = userModel.getUserList();
		if (users != null) {
			iUserView.show(users);
		} else {
			iUserView.empty();
		}
	}

	@Override
	public void getUserList(String priority) {
		// TODO Auto-generated method stub
		List<User> users = userModel.getUserList(priority);
		if (users != null) {
			iUserView.show(users);
		} else {
			iUserView.empty();
		}
	}

	@Override
	public void login(User user) {
		// TODO Auto-generated method stub
		if(!checkUser(user))
			return;
		if (userModel.login(user)) {
			iUserView.loginSuccess();
		} else {
			iUserView.loginFailue();
		}
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub

	}

	public boolean checkUser(User user) {
		// TODO Auto-generated method stub
		String ret = "success";
		if ("".equals(user.getName()) || null == user.getName()) {
			ret = "User name cannot be empty";
		}
		if (user.getAge() < 0 || user.getAge() > 120) {
			ret = "Age is not legal";
		}
		if ("success".equals(ret)) {
			return true;
		}
		iUserView.checkUser(ret);
		return false;
	}

}
