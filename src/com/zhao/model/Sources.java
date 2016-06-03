package com.zhao.model;

public class Sources {

	public void method1(){
		System.out.println("this is origin method");
	}
}

interface Targetable{
	public void method1();  //
	public void method2();
}

//类适配器
class TargetAdapter extends Sources implements Targetable{

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		System.out.println("this is targetalbe method");
	}
	
}

//类包装器
class Wrapper implements Targetable{
	
	Sources source;
	
	public Wrapper(Sources source){
		this.source = source;
	}

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		source.method1();
	}

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		System.out.println("this is targetalbe method");
	}
	
}