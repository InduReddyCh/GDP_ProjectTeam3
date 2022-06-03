package com.spring.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String upwd = request.getParameter("password");
		HttpSession session = request.getSession();
		
		
		RequestDispatcher dispatcher = null;
		Connection con= null;
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project?useSSL=false","root","");    
			PreparedStatement stmt=con.prepareStatement("select * from users where userId = ? and upwd = ?;");  
			stmt.setString(1, userId);
			stmt.setString(2, upwd);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				session.setAttribute("userId", rs.getString("userId"));
				dispatcher = request.getRequestDispatcher("LoginSuccess.jsp");
			}
			else {
				request.setAttribute("status", "failed");
				dispatcher = request.getRequestDispatcher("login.jsp");
			}
		
			dispatcher.forward(request, response);
		}

		catch(Exception e){
			System.out.println(e);
			}
		
		
	
	}

}
