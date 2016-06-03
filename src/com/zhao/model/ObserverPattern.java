package com.zhao.model;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {

	public static void main(String args[]){
		//�������۲���
		Observable observable = new ObservableImpl();
		//�����۲���
		Observer observer1 = new Observer1();
		Observer observer2 = new Observer2(){
			@Override
			public void update() {
				// TODO Auto-generated method stub
				System.out.println("observer2 has received!");
			}
		};
		//����
		observable.onSubscribe(observer1);
		observable.onSubscribe(observer2);
		
		//���۲����и���������֪ͨ�۲���
		observable.operation();  //update observer
	}
}

/**
 * ���۲���
 * @author zhaofg
 *
 */
interface Observable{
	void onSubscribe(Observer observer);
	void unSubscribe(Observer observer);
	void notifyObservers();
	void operation();
}

abstract class AbstractObservable implements Observable{
	private List<Observer> observers = new ArrayList<Observer>();
	
	public void onSubscribe(Observer observer){
		observers.add(observer);
	}
	
	public void unSubscribe(Observer observer){
		observers.remove(observer);
	}
	
	public void notifyObservers(){
		for(Observer observer:observers){
			observer.update();
		}
	}
}

class ObservableImpl extends AbstractObservable{

	@Override
	public void operation() {
		// TODO Auto-generated method stub
		System.out.println("update self!");
		notifyObservers();
	}
	
}

/**
 * �۲���
 * @author zhaofg
 *
 */
interface Observer{
	void update();
}

class Observer1 implements Observer{

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("observer1 has received!"); 
	}
	
}

abstract class Observer2 implements Observer{
	//
}
