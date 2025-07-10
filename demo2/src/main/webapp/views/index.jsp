<%--
  Created by IntelliJ IDEA.
  User: shaun
  Date: 10/07/25
  Time: 6:30 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>


<h1>Welcome ${username != null ?username:"to Quiz App"}</h1>
<h1>Login</h1>
<form action="/login" method="post">
    <input type="text" name="username" placeholder="Username">
    <input type="password" name="password" placeholder="Password">
    <input type="submit">
</form>
<h3>Register <a href="/register">Here</a> </h3>


</body>
</html>
