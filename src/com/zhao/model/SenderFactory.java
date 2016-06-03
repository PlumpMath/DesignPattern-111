package com.zhao.model;

/**
 * ��̬����
 * @author Administrator
 *
 */
public class SenderFactory {

	public enum Type {
		SMS, EMAIL;
	}

	/**
	 * ��ͨ����ģʽ ʵ�ַ�ʽ
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
	 * �����������ģʽ
	 */
	public static Sender createSmsSender() {
		return new SmsSender();
	}

	public static Sender createEmailSender() {
		return new EmailSender();
	}
}

/**
 * ���󹤳�
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
