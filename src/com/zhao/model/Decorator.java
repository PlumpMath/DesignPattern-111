package com.zhao.model;

import com.zhao.bean.Source;
import com.zhao.bean.Sourceable;

public class Decorator implements Sourceable{
	
	Sourceable source;
	
	public Decorator(Sourceable source){
		super();
		this.source = source;
	}

	@Override
	public void method() {
		// TODO Auto-generated method stub
		System.out.println("before decorator");
		source.method();
		System.out.println("after decorator");
	}

}

//当缺少接口时可通过继承来解决
class Decorators extends Source{
	
	Sourceable source;
	
	public Decorators(Sourceable source){
		super();
		this.source = source;
	}

	@Override
	public void method() {
		// TODO Auto-generated method stub
		System.out.println("before decorator");
		source.method();
		System.out.println("after decorator");
	}

}