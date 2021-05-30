<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign In page</title>
</head>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>

<script type="/MiniProject1/WebContent/WEB-INF/lib/jquery-3.4.0.min.js"></script>
			
<script>

//alert('hello');
$(document).ready(function(){
	//alert('Jquery is called');
	$("#submit").click(function(){
		//alert('onClick called');
		var email=$('#email').val();
		var password=$('#password').val();

		$.ajax({
			type: 'GET',
		 	data: {email:email,password:password},
			url:'./JqueryServlet',
			success: function(msg){
				//alert(msg);
			
				$("#submitError").text(msg);
				
				},
			
			 error: function(err){
				alert("Unable to retrieve data"+err);
			}
		}); 
	});
});
</script>

<link rel="stylesheet" href="css-files/SignIn.css">

<body>

<form action="JqueryServlet">
  <div class="container">
  <h1>Sign In</h1>
  <span id="submitError" style="color : red;" > </span> 
 
    <p>Please fill the required fields.</p>
    <hr>

    <label for="email"><b>Email</b></label>
    <input type="text" placeholder="Enter email" name="email" id="email" required> <span style="color : red;"> (required, at least 8 characters)</span>
    <span id="emailError" style="color : red;" > </span>
    <br>
    
    <label for="pwd"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" id="password" required>

    <hr>
    <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>

    <button type="submit"  id="submit" class="registerbtn">Sign in</button>
  </div>
  
  <div class="container signin">
    <p>Forgot <a href="ForgotFrontEnd.jsp">Password?</a></p>
  </div>
  
 <div class="footer">
  <p>Copyrights © 2021</p>
</div>
</form>

</body>
</html>