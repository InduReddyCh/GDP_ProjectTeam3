--Registration Servlet 
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


--Login Servlet

Class.forName("com.mysql.cj.jdbc.Driver");  
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project?useSSL=false","root","");    
			PreparedStatement stmt=con.prepareStatement("select * from users where userId = ? and upwd = ?;");  
			stmt.setString(1, userId);
			stmt.setString(2, upwd);
			ResultSet rs = stmt.executeQuery();

--Creating Database and Table
create database project;
use project;
create table users(id int primary key auto_increment, userId varchar(50), uname varchar(50),upwd varchar(50), mobileNo varchar(50), address varchar(50), userType varchar(50) );
desc users;
select * from users;


