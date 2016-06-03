package com.zhao.model;

/**
 * 命令模式
 * @author zhaofg
 *
 */
public class CommandPattern {

	public static void main(String[] args) {
		Receiver receiver = new Receiver(); // 执行者
		Command cmd = new MyCommand(receiver); // 命令 - 请求
		Invoker invoker = new Invoker(cmd);
		invoker.action(); // 发 命令/请求
	}

}

/**
 * 命令 - 请求
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
 * 命令接收者 - 执行者
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
 * 执行命令 - 发送请求
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
