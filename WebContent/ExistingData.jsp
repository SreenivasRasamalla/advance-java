<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>

<script type="/MiniProject1/WebContent/WEB-INF/lib/jquery-3.4.0.min.js"></script>


<script>

$(document).ready(function(){
	//alert('hi, from Jquery');
	$('#email').on("input keyup", function() {
		//alert ("after id from jquery");
		var email = $('#email').val();
		
		$.get("ExistingDataServlet", {
			email : email				//sending FrontEnd data from here to above servlet
		},
		function(result) {
			//alert("result ---" + result);
			$("#emailError").text(result);
			if (result != "") {
				$('#email').val("");
			}
		});
	});
});

</script>
<link rel="stylesheet" href="css-files/signup.css">
<body>

<form action="ExistingDataServlet">
  <div class="container">
    <h1>Register</h1>
    <p>Please fill in this form to create an account.</p>
    <hr>

    <label for="firstName"><b>Firstname</b></label>
    <input type="text" placeholder="Enter Firstname" name="firstName" id="firstName" required>

    <label for="lastName"><b>Lastname</b></label>
    <input type="text" placeholder="lastName" name="lastName" id="lastName" required>
    
     <label for="email"><b>E-mail</b></label>
    <input type="text" placeholder="email" name="email" id="email"required> <span id="emailError" style="color : red;" > </span> 
    <br>
    <label for="pwd"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" id="password" required>

    <hr>
    <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>

    <button type="submit" class="registerbtn">Register</button>
  </div>
  
  <div class="container signin">
    <p>Already have an account? <a href="SignIn.jsp">Sign in</a>.</p>
  </div>
</form>

</body>
</html>