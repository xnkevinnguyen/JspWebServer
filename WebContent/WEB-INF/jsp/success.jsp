<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login</title>
    <style>
        body{
            margin:0;
        }
        #background-overlay{
            position: fixed;
            top: 0;
            bottom: 0;
            right: 0;
            left: 0;
            overflow: hidden;
            background-color: #000000;
            opacity: 0.4;
            z-index: -99;
        }
        #logo{
            height:140px;
            width:140px;
        }
        .container{
            height:100vh;
            width:100vw;
            display: flex;
            align-items: center;
            justify-content: center;
            /* Permalink - use to edit and share this gradient: http://colorzilla.com/gradient-editor/#fedd02+0,ee4026+100 */
			background: #fedd02; /* Old browsers */
			background: -moz-linear-gradient(45deg, #fedd02 0%, #ee4026 100%); /* FF3.6-15 */
			background: -webkit-linear-gradient(45deg, #fedd02 0%,#ee4026 100%); /* Chrome10-25,Safari5.1-6 */
			background: linear-gradient(45deg, #fedd02 0%,#ee4026 100%); /* W3C, IE10+, FF16+, Chrome26+, Opera12+, Safari7+ */
			filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#fedd02', endColorstr='#ee4026',GradientType=1 ); /* IE6-9 fallback on horizontal gradient */
        }
        .form-container{
            display: flex;
            justify-content: center;
            align-items: center;
            height:55vh;
            width:55vw;
            background-color: #ffffff;
            flex-direction: column;
            box-shadow: 0 0 3px;
            border-radius: 5px;
        }
        .form{
            display: flex;
            flex-direction: column;
            width: 65%;
        }
        .form input {
            padding:15px;
            border: none;
            box-shadow: 0 0 3px;
            margin: 10px;
            border-radius: 5px;
        }
        #form-title {
        	font-family: 'Montserrat', sans-serif;
        	font-size: 1.5rem;
        	margin-bottom: 20px;
        }
        #form-option {
        	font-family: 'Montserrat', sans-serif;
        	font-size: 1rem;
        	margin-top: 20px;
        }
        
    </style>
    <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
<div class="container">
    <div class="form-container">
    	<span id="form-title">Login</span>
		{
		"status":"success",
 		"message":"${message}"
 		}
        <span id="form-option">Don't have an account? <a href="/PokemonWebApp/ui/register.jsp" >Register</a></span> 
        
    </div>
</div>
	
</body>
</html>