package com.project.servlet1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.utility.ConnectionProvider;
import com.project.utility.DatabaseController;

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in registration servlet");
		String fullname = request.getParameter("fullname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String confpassword = request.getParameter("confpass");
		String userarr[] = request.getParameterValues("usertype");
		String usertype = userarr[0];
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		int match=0;
		 String error=null;
		if(password.equals(confpassword))
		{
			match++;
		}
		if(contact.contains("e")||match==0)
		{
               if(contact.contains("e"))
               {
            	   error  ="Contact Number is not correct";
            	   RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            	   request.setAttribute("error", error);
            	   rd.forward(request,response);
            	
               }
               if(match==0)
               {
            	   error="Password and confirm Password are not same";
            	   RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            	   request.setAttribute("error", error);
            	   rd.forward(request,response);
            	
               }
		}
		else
		{
		
	
		Connection con = ConnectionProvider.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("insert into Users values(?,?,?,?,?,?)");
			ps.setString(1, fullname);
			ps.setString(2, usertype);
			ps.setString(3, username);
			ps.setString(4, password);
			ps.setString(5, contact);
			ps.setString(6, email);
			ps.executeQuery();
        response.sendRedirect("Login_v3/login.html");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

	}

}
