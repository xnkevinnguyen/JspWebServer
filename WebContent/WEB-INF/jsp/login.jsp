<%
  
	/* String hasSessionId = session.getId();
	if(hasSessionId != null){
		   response.sendRedirect("login.jsp");
	} */
  /*  UserModel user = (UserModel)request.getAttribute("user");
   String firstName = user.getFirst_name(); */
   
%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login</title>
 	<link href="style.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
<div class="container">
    <div class="form-container">
    	<span id="form-title">Login</span>
        <form action="Login" method="POST" class="form">
            <input type="email" name="email" placeholder="Email here ..."/>
            <input type="password" name="pass" placeholder="Password here ..."/>
            <input type="submit">
        </form>
        <span id="form-option">Don't have an account? <a href="register.jsp" >Register</a></span> 
        
    </div>
</div>
	
</body>
</html>