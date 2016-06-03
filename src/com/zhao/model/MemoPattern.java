package com.zhao.model;

/**
 * 备忘录模式
 * 
 * @author zhaofg
 *
 */
public class MemoPattern {

	public static void main(String[] args) {
		// 创建原始类
		Original origin = new Original("egg");

		// 创建备忘录
		Storage storage = new Storage(origin.save());
		// 修改原始类的状态
		System.out.println("初始化状态为：" + origin.getValue());
		origin.setValue("niu");
		System.out.println("修改后的状态为：" + origin.getValue());
		// 回复原始类的状态
		origin.restore(storage.getMemento());
		System.out.println("恢复后的状态为：" + origin.getValue());
	}

}

class Original {

	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Original(String value) {
		this.value = value;
	}

	public Memento save() {
		return new Memento(value);
	}

	public void restore(Memento memento) {
		this.value = memento.getValue();
	}
}

/**
 * Origin 属性 value的备忘录
 * 
 * @author zhaofg
 *
 */
class Memento {

	private String value;

	public Memento(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}

/**
 * 存储备忘录
 * 
 * @author zhaofg
 *
 */
class Storage {

	private Memento memento;

	public Storage(Memento memento) {
		this.memento = memento;
	}

	public Memento getMemento() {
		return memento;
	}

	public void setMemento(Memento memento) {
		this.memento = memento;
	}
}
