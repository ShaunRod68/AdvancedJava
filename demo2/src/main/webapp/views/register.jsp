<%--
  Created by IntelliJ IDEA.
  User: shaun
  Date: 10/07/25
  Time: 6:35 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Register</title>
  </head>
  <body>
  <h1>Register</h1>
  <form action="/register" method="post">
    <input type="text" name="username" placeholder="Username">
    <input type="password" name="password" placeholder="Password">
    <input type="submit" value="Register">
  </form>
  </body>
</html>
