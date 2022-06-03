package com.spring.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//HttpSession session = request.getSession();
		String userId = request.getParameter("userID");
		String uname = request.getParameter("name");
		String upwd = request.getParameter("password");
		String mobileNo = request.getParameter("mobileNo");
		String address = request.getParameter("address");
		String userType = request.getParameter("userType");
		
	
			RequestDispatcher dispatcher = null;
			Connection con= null;
			
			try{  
				Class.forName("com.mysql.cj.jdbc.Driver");  
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project?useSSL=false","root","");    
				PreparedStatement stmt=con.prepareStatement("insert into users(userId,uname,upwd,mobileNo,address,userType) values(?,?,?,?,?,?) ");  
				stmt.setString(1, userId);
				stmt.setString(2, uname);
				stmt.setString(3, upwd);
				stmt.setString(4, mobileNo);
				stmt.setString(5, address);
				stmt.setString(6, userType);
				
				int rowcount = stmt.executeUpdate();
				System.out.println(rowcount);
				dispatcher = request.getRequestDispatcher("login.jsp");
	
				
				if(rowcount>0) {
					request.setAttribute("status", "success");
				}
				else {
					request.setAttribute("status", "failed");
				}
				dispatcher.forward(request, response);
			}
	
			catch(Exception e){
				System.out.println(e);
				}
			
			
		
	}

}
