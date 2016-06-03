package com.zhao.mvc.model;

public interface Callback<T>{
	void success(T t);
	void error();
}