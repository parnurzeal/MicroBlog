<%@ page language="java" contentType="text/html; charset=windows-31j"
    pageEncoding="windows-31j"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

	<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=windows-31j">
		<title>MicroBlog!</title>
	</head>
	<body>
		<br />
		<h3 align='center'>MicroBlog!</h3>
		<hr width='20%' />
		<h4 align='center'>Register New User.</h4>
		<form method='post' action='RegisterConfirm'>
			<table border='0' align='center'>
				<tr>
					<td>Username</td>
					<td><input type='text' name='username'/></td>
				</tr>
				<tr>
					<td>Nickname</td>
					<td><input type='text' name='nickname' /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type='password' name='password'/></td>
				</tr>
				<tr>
					<td rowspan='2'>
						<input type='submit' value='confirm' name='submit' />
					</td>
				</tr>
			</table>
		</form>
		<br />
	</body>
</html>
