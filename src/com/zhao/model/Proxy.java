package com.zhao.model;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.zhao.bean.Source;
import com.zhao.bean.Sourceable;
/**
 * 普通代理/静态代理
 * @author zhaofg
 *
 */
public class Proxy implements Sourceable{
	Source source;
	
	public Proxy(){
		source = new Source();
	}

	@Override
	public void method() {
		// TODO Auto-generated method stub
		before();
		source.method();
		after();
	}
	
	public void before(){
		System.out.println("before proxy");
	}
	
	public void after(){
		System.out.println("after proxy");
	}
}

/**
 * 动态代理
 * @author zhaofg
 *
 */
class ProxyHandler implements InvocationHandler{
	Sourceable source;
	
	public Sourceable newProxyInstance(Sourceable source){
		this.source = source;
		if(source!=null){
			source = new Source();
		}
		return (Sourceable) java.lang.reflect.Proxy.newProxyInstance(source.getClass().getClassLoader(), source.getClass().getInterfaces(), this);
	}
	
	public void before(){
		System.out.println("before proxyHandler");
	}
	
	public void after(){
		System.out.println("after proxyHandler");
	}

	@Override
	public Object invoke(Object object, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		before();
		Object ret = method.invoke(source, args);
		after();
		return ret;
	}
}