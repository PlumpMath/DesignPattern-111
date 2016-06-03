package com.zhao.model;

import java.util.ArrayList;
import java.util.List;

/**
 * ���ģʽ
 * 
 * @author zhaofg
 *
 */
public class CompositePattern {
	public static void main(String args[]){
		Company company = new ParentCompany("�ܹ�˾A");
		company.add(new ChildCompany("�ӹ�˾1"));
		company.add(new ChildCompany("�ӹ�˾2"));
		company.add(new ChildCompany("�ӹ�˾3"));
		company.display();
		Company childCompany = new ChildCompany("��ͨ��˾B");
		childCompany.display();
	}
}

/**
 * ��˾
 * 
 * @author zhaofg
 *
 */
abstract class Company {
	private String name;

	public Company() {
	}

	public Company(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public abstract void add(Company company);

	public abstract void remove(Company company);

	public abstract Company getChildAt(int index);

	public abstract void display();
}

/**
 * �ܹ�˾
 * 
 * @author zhaofg
 *
 */
class ParentCompany extends Company {

	private List<Company> cList;

	public ParentCompany() {
		cList = new ArrayList<Company>();
	}
	
	public ParentCompany(String name) {
		super(name);
		cList = new ArrayList<Company>();
	}

	@Override
	public void add(Company company) {
		// TODO Auto-generated method stub
		cList.add(company);
	}

	@Override
	public void remove(Company company) {
		// TODO Auto-generated method stub
		cList.remove(company);
	}

	@Override
	public Company getChildAt(int index) {
		// TODO Auto-generated method stub
		if (index >= 0 && index < cList.size()) {
			return cList.get(index);
		} else {
			return null;
		}
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("start display " + this.getName() + " ���ӹ�˾ !");
		for (Company company : cList) {
			System.out.println(company.getName());
		}
		System.out.println("display end !");
	}

}

/**
 * �ӹ�˾
 * @author zhaofg
 *
 */
class ChildCompany extends Company {
	

	public ChildCompany(String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}

	@Override
	public void add(Company company) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(Company company) {
		// TODO Auto-generated method stub

	}

	@Override
	public Company getChildAt(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println(this.getName());
	}

}
