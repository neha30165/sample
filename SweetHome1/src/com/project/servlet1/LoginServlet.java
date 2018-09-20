package com.project.servlet1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.utility.ConnectionProvider;
import com.project.utility.DatabaseController;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String usertype = null;
	Connection con =ConnectionProvider.getConnection();
	DatabaseController db = new DatabaseController();
	int i =db.validateUser(username, password);
	if(i>0)
	{
		HttpSession session1= request.getSession();
		session1.setAttribute("username",username);
		session1.setAttribute("usertype",usertype);
		response.sendRedirect("index.html");
	}
	if(i==0)
	{
		response.sendRedirect("Login_v3/login.html");
	}
	}

}
