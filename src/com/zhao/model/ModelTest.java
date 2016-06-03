package com.zhao.model;

import java.io.IOException;

import com.zhao.bean.Source;
import com.zhao.bean.Sourceable;
import com.zhao.model.SenderFactory.Type;

public class ModelTest {

	public static void main(String args[]) throws CloneNotSupportedException, ClassNotFoundException, IOException {
		/*
		Sender smsSender;
		Sender emailSender;
		// 普通工厂模式
		smsSender = SenderFactory.create(Type.SMS);
		emailSender = SenderFactory.create(Type.EMAIL);
		smsSender.send("");
		emailSender.send("");
		// 多个工厂方法模式
		smsSender = SenderFactory.createSmsSender();
		emailSender = SenderFactory.createEmailSender();
		smsSender.send("!!");
		emailSender.send("!!");

		// 抽象工厂
		SendFactory smsSenderFactory = new SmsSenderFactory();
		SendFactory emailSenderFactory = new SmsSenderFactory();
		smsSender = smsSenderFactory.create();
		emailSender = emailSenderFactory.create();
		smsSender.send("!!!!");
		emailSender.send("!!!!");

		// 建造者模式
		Message.Builder builder = Message.Builder()
				.buildHeader("header")
				.buildContent("content");
		builder.send();

		Message.Builder contentBuilder = Message
				.Builder(new Message.NoHeaderMessageBuilder())
				.buildHeader("header")
				.buildContent("content");
		contentBuilder.send();
		
		//原型模式
		Model model = new Model();
		model.setType(10);
		model.setModel(12);
		Model model_1 = (Model) model.clone();
		Model model_2 = (Model) model.deepClone();
		System.out.println(model==model_1);  //false
        System.out.println(model==model_2);  //false
        System.out.println(model.getModel()==model_1.getModel());  //true
        System.out.println(model.getModel()==model_2.getModel());  //false
        
        //类适配器模式
        Targetable target = new TargetAdapter();
        target.method1();  //实际运行的为Source中的 method1()
        target.method2();
        Targetable target1 = new Wrapper(new Sources());
        target1.method1();  //实际运行的为Source中的 method1()
        target1.method2();
        
        //装饰器模式
        Decorator decorator = new Decorator(new Source());
        decorator.method();
        Decorators decorators = new Decorators(new Source());
        decorators.method();
      
        //代理模式
        Proxy proxy = new Proxy();
        proxy.method();  //实际是访问Source.method(),另外有做了些额外的处理
        ProxyHandler proxyHandler = new ProxyHandler();
        Sourceable source = proxyHandler.newProxyInstance(new Source());
        source.method();
                 */
		//桥接模式
		
	}
}
