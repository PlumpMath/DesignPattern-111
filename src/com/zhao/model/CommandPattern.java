package com.zhao.model;

/**
 * ����ģʽ
 * @author zhaofg
 *
 */
public class CommandPattern {

	public static void main(String[] args) {
		Receiver receiver = new Receiver(); // ִ����
		Command cmd = new MyCommand(receiver); // ���� - ����
		Invoker invoker = new Invoker(cmd);
		invoker.action(); // �� ����/����
	}

}

/**
 * ���� - ����
 * 
 * @author zhaofg
 *
 */
interface Command {
	public void exe();
}

class MyCommand implements Command {

	private Receiver receiver;

	public MyCommand(Receiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public void exe() {
		receiver.action();
	}
}

/**
 * ��������� - ִ����
 * 
 * @author zhaofg
 *
 */
class Receiver {
	public void action() {
		System.out.println("receiver command !");
	}
}

/**
 * ִ������ - ��������
 * 
 * @author zhaofg
 *
 */
class Invoker {

	private Command command;

	public Invoker(Command command) {
		this.command = command;
	}

	public void action() {
		command.exe();
	}
}
