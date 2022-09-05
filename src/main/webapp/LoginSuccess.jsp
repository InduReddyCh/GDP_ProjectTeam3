<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
button {
background-color: #90ee90;
border : none;
height : 30px;
width : 130px;
}
</style>
</head>
<body style = "text-align:center">
<h1 style = "text-align:center">FARMatrix - Farmer Page</h1>
<div>

<button id="myButton8">Home</button>&nbsp; &nbsp; &nbsp; &nbsp;
&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;
<script type="text/javascript">document.getElementById("myButton8").onclick = function () {
        location.href = "index.jsp";
    };
</script>
<button id="myButton5" class="float-left submit-button" >Add Product</button>
&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;

<button id="myButton6" class="float-left submit-button" >View Products</button>
&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;

<button id="myButton7" class="float-left submit-button" >Buy</button>


<br>
<br>
<img src= "images/farmer.jpg">


</div>
</body>
</html>
