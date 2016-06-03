package com.zhao.mvp;

import java.util.List;

import org.junit.Test;

import com.zhao.mvc.bean.User;
import com.zhao.mvp.presenter.UserPresenter;
import com.zhao.mvp.presenter.UserPresenterImpl;

public class UserView implements IUserView{

	private UserPresenter userPresenter;
	
	@Test
	public void init(){
		userPresenter = new UserPresenterImpl(this);
		userPresenter.getUser();
		
		userPresenter.getUser(UserPresenter.PRIORITY_CACHE);
		
		userPresenter.getUserList();
		
		//login test
		User mUser = new User("loginUser",130);
		userPresenter.login(mUser);
	}

	@Override
	public void show(User user) {
		// TODO Auto-generated method stub
		System.out.println(user.toString());
	}

	@Override
	public void empty() {
		// TODO Auto-generated method stub
		System.out.println("user empty !");
	}

	@Override
	public void show(List<User> users) {
		// TODO Auto-generated method stub
		System.out.println(users.toString());
	}

	@Override
	public void loginSuccess() {
		// TODO Auto-generated method stub
		System.out.println("login success !");
	}

	@Override
	public void loginFailue() {
		// TODO Auto-generated method stub
		System.out.println("login failue !");
	}

	@Override
	public void checkUser(String ret) {
		// TODO Auto-generated method stub
		System.out.println(ret);
	}
}
