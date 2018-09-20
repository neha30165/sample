package com.project.utility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseController {
	Connection con=ConnectionProvider.getConnection();
	public void addUser(String fullname, String username, String password, String usertype, String email, String contact)
	{
		
		Statement stmt;
		try {
			stmt = con.createStatement();
			stmt.executeQuery("insert into Users values('"+fullname+"','"+usertype+"','"+username+"','"+password+"','"+contact+"','"+email+"')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

	public boolean validateUser(String username, String password) {
		Statement stmt;
		
		String usertype;
		try {
			stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from Users where username='"+username+"' and password='"+password+"'");
			while(rs.next())
			{
				usertype=rs.getString("usertype");
			}
		return true ;	
		} 
		catch (SQLException e) {
			System.out.println("User not Available");
		}
		return false;
		
	}
}
