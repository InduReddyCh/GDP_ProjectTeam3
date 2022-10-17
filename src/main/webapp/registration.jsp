<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<!-- <meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Sign Up Form by Colorlib</title>

Font Icon
<link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">

Main css
<link rel="stylesheet" href="css/style.css">
</head>
<body>

	<div class="main">

		Sign up form
		<section class="signup">
			<div class="container">
				<div class="signup-content">
					<div class="signup-form">
						<h2 class="form-title">Sign up</h2>
					
						<form method="" action="" class="register-form"
							id="register-form">
							<div class="form-group">
								<label for="userId">User ID:</label> <input
									type="text" name="userId" id="userId" placeholder="Your Name" />
							</div>
							<div class="form-group">
								<label for="name">User Name:</label> <input
									type="text" name="name" id="name" placeholder="Your Name" />
							
							</div>
							<div class="form-group">
								<label for="pass">Password:</label> <input
									type="password" name="pass" id="pass" placeholder="Password" />
							</div>
							<div class="form-group">
								<label for="contact">Mobile No:</label>
								<input type="text" name="contact" id="contact"
									placeholder="Contact no" />
							</div>
							
							<div class="form-group">
								<label for="address">Address:</label> <input
									type="address" name="address" id="address" placeholder="Your address" />
							
							<div class="form-group">
								<input type="checkbox" name="userType" id="userType"
									class="userType" /> <label for="userType"
									class="userType"><span><span></span></span>Farmer </label>
									<input type="checkbox" name="userType" id="userType"
									class="userType" /> <label for="userType"
									class="userType"><span><span></span></span>Customer </label>
									<input type="checkbox" name="userType" id="userType"
									class="userType" /> <label for="userType"
									class="userType"><span><span></span></span>Dealer </label>
							</div>
							<div class="form-group form-button">
								<input type="submit" name="signup" id="signup"
									class="form-submit" value="Register" />
							</div>
						</form>
					</div>
					<div class="signup-image">
						<figure>
							<img src="images/signup-image.jpg" alt="sing up image">
						</figure>
						<a href="login.jsp" class="signup-image-link">I am already
							member</a>
					</div>
				</div>
			</div>
		</section>


	</div>
	JS
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>



</body> -->


<title>Registration</title>
<style>
button {
background-color: #90ee90;
border : none;
height : 30px;
width : 120px;
}
</style>
</head>
<body>
<h1 style = "text-align:center">REGISTRATION PAGE</h1>
<form style = "text-align:center" action = "register" method = "post">
<label >UserID:             </label> &nbsp; &nbsp; &nbsp; &nbsp;
<input type = "text" name= "userID" placeholder= "Enter UserId" ><br><br>
<label >Name:             </label> &nbsp; &nbsp; &nbsp; &nbsp;
<input type = "text" name= "name" placeholder= "Enter Name"  ><br><br>
<label>Password:            </label>&nbsp; &nbsp; &nbsp; &nbsp;
<input type = "password" name= "password" placeholder= "Enter Password"  ><br><br>
<label >Mobile No:             </label> &nbsp; &nbsp; &nbsp; &nbsp;
<input type = "text" name= "mobileNo" placeholder= "Enter MobileNo"  ><br><br>
<label >Address:             </label> &nbsp; &nbsp; &nbsp; &nbsp;
<input type = "text" name= "address" placeholder= "Enter Address" ><br><br>
<input type = "radio" value= "Farmer" name="userType" >
<label>Farmer    </label>
<input type = "radio" value = "Customer" name="userType" >
<label>Customer</label>
<input type = "radio" value= "Dealer" name="userType" >
<label>Dealer</label>
<br>
<br>
<button type="submit">Submit</button><br>
</form>
</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>
