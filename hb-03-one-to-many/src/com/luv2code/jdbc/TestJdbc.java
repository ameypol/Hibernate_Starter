package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		String jdbcurl="jdbc:mysql://localhost:3306/hb-03-one-to-many?useSSL=false";	
		String user="hbstudent";
		String pass ="hbstudent";
		try {
		System.out.println("connecting to jdbc"+jdbcurl);
		Connection myconn =
				DriverManager.getConnection(jdbcurl,user,pass);
			System.out.println("connection successfull" + myconn);
		}
		catch(Exception E) {
			E.printStackTrace();
		}
		

	}

}
