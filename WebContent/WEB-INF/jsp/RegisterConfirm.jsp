<%@ page language="java" contentType="text/html; charset=windows-31j"
    pageEncoding="windows-31j"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-31j">
<title>Insert title here</title>
</head>
<body>
	<br />
	<h3 align='center'>MicroBlog!</h3>
	<hr width='20%' />
	<h4 align='center'>Do you want to register this user?</h4>
		<form method='post' action='RegisterCommit'>
			<table border='0' align='center'>
				<tr>
					<td>Username</td>
					<td><%=request.getParameter("username") %></td>
				</tr>
				<tr>
					<td>Nickname</td>
					<td><%=request.getParameter("nickname") %></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><%=request.getParameter("password") %></td>
				</tr>
				<tr>
					<td rowspan='2'>
						<input type='submit' value='commit' name='submit' />
					</td>
				</tr>
			</table>
			<input type='hidden' name='username' value='<%=request.getParameter("username") %>' />
			<input type='hidden' name='nickname' value='<%=request.getParameter("nickname") %>' />
			<input type='hidden' name='password' value='<%=request.getParameter("password") %>' />
	</form>
	<br />
</body>
</html>