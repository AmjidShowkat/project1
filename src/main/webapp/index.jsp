<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3><i>Login Here Buddy...</i></h3>
<form action="verifyLogin" method="post">
<table>
<tr>
<td><i>Email</i></td>
<td><input type="text" name="email"/></td></tr>
<tr>
<td><i>Password</i></td>
<td><input type="text" name="password"/></td>
</tr>
<tr>
<td><input type="submit" value="Login"/></td></tr>
</table>
</form>
<%
if(request.getAttribute("error")!=null){
out.println(request.getAttribute("error"));
}
%>



</body>
</html>