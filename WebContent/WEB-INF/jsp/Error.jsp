<%@ page contentType="text/html; charset=Windows-31J" isErrorPage="true"%>
<%
	String error = (String)request.getAttribute("error");
%>
<html>
<head>
<title>Film Information System</title>
</head>
<body bgcolor="9999ff">
<div align="center">
<h2>ƒGƒ‰[‰æ–Ê</h2>
<table border="1">
<%
	if(error != null){
		out.println("<tr><td>" + error + "</td></tr>");
	}
	if(exception != null){
		out.println("<tr><td>" + exception.getMessage() + "</td></tr>");
	}
%>
</table>
</div>
</body>
</html>
