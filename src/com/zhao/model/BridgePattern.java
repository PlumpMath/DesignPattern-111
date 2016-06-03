package com.zhao.model;

import java.sql.Connection;

/**
 * ге╫сдёй╫
 * 
 * @author zhaofg
 *
 */
public class BridgePattern {

	public static void main(String args[]){
		DriverManager driverManager = new DriverManagerImpl();
		DriverManager driverManager2 = new DriverManagerImpl2();
		
		MysqlDriver mysqlDriver = new MysqlDriver();
		driverManager.setDriver(mysqlDriver);
		driverManager.connect();
		
		SqliteDriver sqliteDriver = new SqliteDriver();
		driverManager.setDriver(sqliteDriver);
		driverManager.connect();
		
		OracleDriver oracleDriver = new OracleDriver();
		driverManager2.setDriver(oracleDriver);
		driverManager2.connect();
	}
}

interface Driver {
	public void connect();
}

class MysqlDriver implements Driver {

	@Override
	public void connect() {
		// TODO Auto-generated method stub
		System.out.println("connect mysql done!");
	}

}

class SqliteDriver implements Driver {

	@Override
	public void connect() {
		// TODO Auto-generated method stub
		System.out.println("connect sqlite done!");
	}

}

class OracleDriver implements Driver {

	@Override
	public void connect() {
		// TODO Auto-generated method stub
		System.out.println("connect oracle done!");
	}

}

abstract class DriverManager {
	private Driver dirver;

	public void connect() {
		dirver.connect();
	}

	public Driver getDriver() {
		return dirver;
	}

	public void setDriver(Driver dirver) {
		this.dirver = dirver;
	}

	public static Connection getConnection(String url, String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}
}

class DriverManagerImpl extends DriverManager{
	public void connect(){
		super.connect();
	}
}

class DriverManagerImpl2 extends DriverManager{
	public void connect(){
		System.out.println("connect before");
		super.connect();
		System.out.println("connect after");
	}
}