package com.zhao.mvc.model;

import java.util.List;

import com.zhao.mvc.action.UserAction;
import com.zhao.mvc.bean.User;
import com.zhao.mvc.dao.UserDB;
import com.zhao.mvc.util.UrlUtils;

public class UserModelImpl implements UserModel {

	@Override
	public User getUser() {
		// TODO Auto-generated method stub
		getUserByNetworkSaveCache();
		return UserDB.getUser(UrlUtils.GET_USER_URL);
	}

	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		getUserListByNetworkSaveCache();
		return UserDB.getUserList(UrlUtils.GET_USER_LIST_URL);
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		UserDB.saveUser(UrlUtils.GET_USER_URL,user);
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		UserDB.deleteUser(user);
	}

	@Override
	public User getUser(String priority) {
		// TODO Auto-generated method stub
		User user = null;
		if (PRIORITY_NETWORK.equals(priority)) {
			getUserByNetworkSaveCache();
		}else{
			user = UserDB.getUser(UrlUtils.GET_USER_URL);
			if(user==null){
				getUserByNetworkSaveCache();
			}
		}
		return user;
	}

	@Override
	public List<User> getUserList(String priority) {
		// TODO Auto-generated method stub
		List<User> users = null;
		if (PRIORITY_NETWORK.equals(priority)) {
			getUserListByNetworkSaveCache();
		}else{
			users = UserDB.getUserList(UrlUtils.GET_USER_LIST_URL);
			if(users==null){
				getUserListByNetworkSaveCache();
			}
		}
		return users;
	}

	private void getUserByNetworkSaveCache(){
		UserDB.saveUser(UrlUtils.GET_USER_URL,UserAction.getUser(UrlUtils.GET_USER_URL));
	}
	
	private void getUserListByNetworkSaveCache(){
		UserDB.saveUserList(UrlUtils.GET_USER_LIST_URL,UserAction.getUserList(UrlUtils.GET_USER_LIST_URL));
	}

	@Override
	public void getUser(Callback<User> callback) {
		// TODO Auto-generated method stub
		getUserByNetworkSaveCache();
		User user = UserDB.getUser(UrlUtils.GET_USER_URL);
		if(user!=null){
			callback.success(user);
		}else{
			callback.error();
		}
	}

	@Override
	public void getUser(String priority, Callback<User> callback) {
		// TODO Auto-generated method stub
		User user = null;
		if (PRIORITY_NETWORK.equals(priority)) {
			getUserByNetworkSaveCache();
		}else{
			user = UserDB.getUser(UrlUtils.GET_USER_URL);
			if(user==null){
				getUserByNetworkSaveCache();
			}
		}
		if(user!=null){
			callback.success(user);
		}else{
			callback.error();
		}
	}

	@Override
	public void getUserList(Callback<List<User>> callback) {
		// TODO Auto-generated method stub
		getUserListByNetworkSaveCache();
		List<User> users = UserDB.getUserList(UrlUtils.GET_USER_LIST_URL);
		if(users!=null){
			callback.success(users);
		}else{
			callback.error();
		}
	}

	@Override
	public void getUserList(String priority, Callback<List<User>> callback) {
		// TODO Auto-generated method stub
		List<User> users = null;
		if (PRIORITY_NETWORK.equals(priority)) {
			getUserListByNetworkSaveCache();
		}else{
			users = UserDB.getUserList(UrlUtils.GET_USER_LIST_URL);
			if(users==null){
				getUserListByNetworkSaveCache();
			}
		}
		if(users!=null){
			callback.success(users);
		}else{
			callback.error();
		}
	}

	@Override
	public boolean login(User user) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean logout() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void login(User user, Callback<Boolean> callback) {
		// TODO Auto-generated method stub
		callback.success(true);
	}

}




