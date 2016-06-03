package com.zhao.model;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ProtoType implements Cloneable, Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 普通拷贝，及浅拷贝
	 */
	public ProtoType clone() throws CloneNotSupportedException {
		ProtoType proto = (ProtoType) super.clone();
		return proto;
	}

	/**
	 * 通过序列化 实现深拷贝
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public ProtoType deepClone() throws ClassNotFoundException, IOException {
		// 写入当前对象的二进制流
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(this);

		// 读出二进制流产生的新对象
		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);
		return (ProtoType) ois.readObject();
	}

}

class Model extends ProtoType {
	private static final long serialVersionUID = 11L;
	int type;
	Integer model;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Integer getModel() {
		return model;
	}

	public void setModel(Integer model) {
		this.model = model;
	}

}
