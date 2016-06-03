package com.zhao.model;

/**
 * 任务链模式
 * 
 * @author zhaofg
 *
 */
public class TaskChainPattern {

	public static void main(String args[]){
		Handler handler1 = new HandlerImpl("handler1");
		Handler handler2 = new HandlerImpl("handler2");
		Handler handler3 = new HandlerImpl("handler3");
		handler1.setHandler(handler2);
		handler2.setHandler(handler3);
		handler1.operator();
	}
}

interface Handler {
	public void operator();
	public Handler getHandler();
	public void setHandler(Handler handler);
}

abstract class AbstractHandler implements Handler {
	
	private Handler handler;

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

}

class HandlerImpl extends AbstractHandler {
	String name;

	public HandlerImpl(String name) {
		this.name = name;
	}

	@Override
	public void operator() {
		// TODO Auto-generated method stub
		System.out.println(name);
		if(getHandler()!=null){
			getHandler().operator();  //隐式的递归调用
		}
	}

}