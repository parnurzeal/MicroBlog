<%@ page language="java" contentType="text/html; charset=windows-31j"
    pageEncoding="windows-31j"%>
<%@ page import="beans.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="user" class="beans.User" scope="session"/>
<jsp:useBean id="nonFriendList" class="java.util.ArrayList" scope="session"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-31j">
<title>Insert title here</title>
</head>
<body>
		<br />
		<h3 align='center'>Relater!</h3>
		<hr width='20%' />
		<h4 align='center'>Add New Friend for <jsp:getProperty name="user" property="nickname"/></h4>
		<br />
		<table border='1' align='center'>
		<tr>
			<th>Username</th><th>Nickname</th>
		</tr>
			<% for(int i=0; i<nonFriendList.size(); i++){
				User a = (User)nonFriendList.get(i);
			%>
		<tr>
			<td><a href='/MicroBlog/app/CommitNewFriend?UserID=<%=a.getUserID() %>'><%=a.getUsername()%></a></td><td><%=a.getNickname()%></td>
		</tr>
			<% } %>
		</table>
		<p style='text-align:center;'>
			<a href='/MicroBlog/app/Main'>Main Page</a>
		</p>
</body>
</html>