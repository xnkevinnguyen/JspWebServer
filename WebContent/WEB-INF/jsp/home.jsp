<%@ page import = "java.io.*,java.util.*" 
		 import = "model.UserModel" %>
<%
   // Get session creation time.
   Date createTime = new Date(session.getCreationTime());
   
   // Get last access time of this Webpage.
   Date lastAccessTime = new Date(session.getLastAccessedTime());

   String hasSessionId = session.getId();
   if(hasSessionId == null){
	   response.sendRedirect("login.jsp");
   }
   
   UserModel user = (UserModel)session.getAttribute("user");
   if(user != null){
	  session.setAttribute("username", user.getFirst_name());
	  session.setAttribute("email", user.getEmail());
	  session.setAttribute("user_id", user.getUser_id());
   }else{
	   response.sendRedirect("login.jsp");
   }
   
%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Home</title>
     <link href="authStyle.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
<div class="container">
	<header class="header">
		<a href="home.jsp">Home</a>
		<a href="games.jsp">Games</a>
		<a href="findPlayers.jsp">Find Players</a>
		<a href="profile.jsp">Profile</a>
		<span>Welcome <% out.print(session.getAttribute("username")); %></span>
		<a id="logout">Logout</a>
	</header>
	<ul>
         <li><p><b>First Name:</b>
            <%= request.getParameter("username")%>
         </p></li>
         <li><p><b>Last  Name:</b>
            <%= request.getParameter("email")%>
         </p></li>
      </ul>
		<% out.print(session.getId()); %>
  <%--   <div class="form-container">
    	<span id="form-title">Login</span>
    	<% out.print(firstName); %>
        <%
	      out.println("Customer Name:&nbsp;");
          
	      
		%>
		{
		"status":"success",
 		"message":"${message}",
 		"user":"${message}"
 		}
        <span id="form-option">Don't have an account? <a href="/PokemonWebApp/ui/register.jsp" >Register</a></span>  --%>
        
   <!--  </div> -->
</div>
	<script src="main.js"></script>
</body>
</html>