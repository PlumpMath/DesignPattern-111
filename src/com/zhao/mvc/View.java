package com.zhao.mvc;

import java.util.List;

import com.zhao.mvc.bean.User;
import com.zhao.mvc.controller.UserLogin;
import com.zhao.mvc.model.Callback;
import com.zhao.mvc.model.UserModel;
import com.zhao.mvc.model.UserModelImpl;

public class View {

	public static void main(String args[]){
		UserModel userModel = new UserModelImpl();
		//��ȡUser��Ϣ
		User user = userModel.getUser();  //ͬ����ȡ
		System.out.println(user.toString());
		List<User> users = userModel.getUserList();  //ͬ����ȡ
		System.out.println(users.toString());
		
		User user1 = userModel.getUser(UserModel.PRIORITY_CACHE);  //ͬ����ȡ
		System.out.println(user1.toString());
		
		//�첽��ȡ
		userModel.getUser(new Callback<User>(){
			@Override
			public void success(User user) {
				// TODO Auto-generated method stub
				System.out.println("get user success!");
				System.out.println(user.toString());
			}

			@Override
			public void error() {
				// TODO Auto-generated method stub
				System.out.println("get user error!");
			}
		}); 
		
		
		//login test
		User mUser = new User("loginUser",130);
		UserLogin.login(mUser,userModel, new UserLogin.Callback<String>(){

			@Override
			public void success(String t) {
				// TODO Auto-generated method stub
				System.out.println(t);
			}

			@Override
			public void failue(String t) {
				// TODO Auto-generated method stub
				System.out.println(t);
			}

			@Override
			public void check(String ret) {
				// TODO Auto-generated method stub
				System.out.println(ret);
			}
			
		});
	}
}
