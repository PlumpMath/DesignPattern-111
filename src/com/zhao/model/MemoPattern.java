package com.zhao.model;

/**
 * ����¼ģʽ
 * 
 * @author zhaofg
 *
 */
public class MemoPattern {

	public static void main(String[] args) {
		// ����ԭʼ��
		Original origin = new Original("egg");

		// ��������¼
		Storage storage = new Storage(origin.save());
		// �޸�ԭʼ���״̬
		System.out.println("��ʼ��״̬Ϊ��" + origin.getValue());
		origin.setValue("niu");
		System.out.println("�޸ĺ��״̬Ϊ��" + origin.getValue());
		// �ظ�ԭʼ���״̬
		origin.restore(storage.getMemento());
		System.out.println("�ָ����״̬Ϊ��" + origin.getValue());
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
 * Origin ���� value�ı���¼
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
 * �洢����¼
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
