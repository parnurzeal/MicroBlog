<%@ page language="java" contentType="text/html; charset=windows-31j"
    pageEncoding="windows-31j"%>
<%@ page import="beans.User"%>
<%@ page import="beans.Relation"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="user" class="beans.User" scope="session"/>
<jsp:useBean id="relationList" class="java.util.ArrayList" scope="session"/>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=windows-31j">
	<title>MicroBlog!</title>
</head>
<body>
	<br/>
	<h3 align='center'>MicroBlog!</h3>
	<hr width ='20%'></hr>
	<h4 align='center'>Welcome <jsp:getProperty name="user" property="nickname"/></h4>
	<br/>
	<table border='0' align='center' style='width:360px'>
		<tr><th colspan='2' style='border-bottom:1px solid gray;'>Relations</th></tr>
		<% for(int i =0;i<relationList.size();i++){ 
				Relation a = (Relation)relationList.get(i);
		%>
		<tr>
			<td style='width:240px; text-align:left; font-weight:bold; font-size:12pt;'>
				<%=a.getOwnerName() %>
			</td>
			<td style='text-align:right; font-style:italic; font-size:9pt;'>
				<%=a.getRelateDate() %>
			</td>
		</tr>
		<tr>
			<td colspan='2' style='font-size:11pt; padding-left:15px; padding-bottom:8px; border-bottom:1px solid gray;'>
				<%=a.getMessage() %>
			</td>
		</tr>
		<% } %>
	</table>
	<br/>
	<form method='post' action = '/MicroBlog/app/Relate'>
		<table border='0' align='center'>
			<tr>
				<td><input type='text' name='message' /></td>
				<td><input type='submit' value='relate!' name='submit' /></td>
			</tr>
		</table>
	</form>
	<p style='text-align:center;'>
		<a href='/MicroBlog/app/Main'>Reload</a>
		<a href='/MicroBlog/app/ListFriends'>Your Friends</a>
		<a href='/MicroBlog/app/NewFriends'>Add New Friend</a>
		<a href='/MicroBlog/app/Logout'>Logout</a>
	</p>
</body>
</html>
