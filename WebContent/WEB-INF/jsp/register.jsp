<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Register</title>
	<link href="style.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
<div class="container">
    <div class="form-container">
    	<span id="form-title">Register</span>
        <form action="/PokemonWebApp/Register" method="POST" class="form">
        	<input type="text" name="name" placeholder="First name here ..."/>
            <input type="email" name="email" placeholder="Email here ..."/>
            <input type="password" name="pass" placeholder="Password here ..."/>
            <input type="submit">
        </form>
       <span id="form-option">Already have an account? <a href="login.jsp" >Sign In</a></span> 
        
    </div>
</div>
	
</body>
</html>