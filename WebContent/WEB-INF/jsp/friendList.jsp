<%@ page language="java" contentType="text/html; charset=windows-31j"
    pageEncoding="windows-31j"%>
<%@ page import="beans.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="user" class="beans.User" scope="session"/>
<jsp:useBean id="list" class="java.util.ArrayList" scope="session"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-31j">
<title>Insert title here</title>
</head>
<body>
		<br />
		<h3 align='center'>MicroBlog!</h3>
		<hr width='20%' />
		<h4 align='center'> 
		<jsp:getProperty name="user" property="username"/>	Friend List</h4>
		<br />
		<p style='text-align:center;'>Click username to exclude from your friend list.</p>
		<table border='1' align='center'>
		<tr>
			<th>Username</th><th>Nickname</th>
		</tr>

	<% for(int i=0; i<list.size(); i++){
		User a = (User)list.get(i);
	%>
		
<tr>
<td><a href='/MicroBlog/app/ExcludeFriend?UserID=<%=a.getUserID()%>'><%=a.getUsername()%> </a></td><td><%=a.getNickname()%></td></tr>
<% } %>

		</table>
		<p style='text-align:center;'>
			<a href='/MicroBlog/app/Main'>Main Page</a>
		</p>
</body>
</html>