package com.project.utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpSession;

public class DatabaseController {
	Connection con = ConnectionProvider.getConnection();
	

	public boolean addUser(String fullname,String usertype,String username, String password,String contact, String email) throws SQLException {
	
		PreparedStatement ps = con.prepareStatement("insert into Users values(?,?,?,?,?,?)");
		ps.setString(1, fullname);
		ps.setString(2, usertype);
		ps.setString(3, username);
		ps.setString(4, password);
		ps.setString(5, contact);
		ps.setString(6, email);
		int i=ps.executeUpdate();
		System.out.println(i);
		return true;
	}

	public int validateUser(String username, String password) {
		int i=0;
		try {
			PreparedStatement ps =con.prepareStatement("select * from Users where username=? and password=?");
			ps.setString(1, username);
			ps.setString(2,password);
			ResultSet rs = ps.executeQuery();
			
			String usertype;
			while(rs.next())
			{
				usertype=rs.getString("USERTYPE");
				System.out.println(usertype);
				i++;
				
			}
			return i ;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
		
	}
}
