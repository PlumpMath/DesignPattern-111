package com.zhao.model;

/**
 * 静态工厂
 * @author Administrator
 *
 */
public class SenderFactory {

	public enum Type {
		SMS, EMAIL;
	}

	/**
	 * 普通工厂模式 实现方式
	 * 
	 * @param type
	 * @return
	 */
	public static Sender create(Type type) {
		if (Type.SMS.equals(type)) {
			return new SmsSender();
		} else {
			return new EmailSender();
		}
	}

	/**
	 * 多个工厂方法模式
	 */
	public static Sender createSmsSender() {
		return new SmsSender();
	}

	public static Sender createEmailSender() {
		return new EmailSender();
	}
}

/**
 * 抽象工厂
 */
interface SendFactory {
	public Sender create();
}

class SmsSenderFactory implements SendFactory{

	@Override
	public Sender create() {
		return new SmsSender();
	}

}

class EmailSenderFactory implements SendFactory{

	@Override
	public Sender create() {
		return new EmailSender();
	}

}

interface Sender {
	public void send(String text);
}

class SmsSender implements Sender {

	@Override
	public void send(String text) {
		// TODO Auto-generated method stub
		System.out.println("send sms!" + text);
	}

}

class EmailSender implements Sender {

	@Override
	public void send(String text) {
		// TODO Auto-generated method stub
		System.out.println("send email!" + text);
	}

}
