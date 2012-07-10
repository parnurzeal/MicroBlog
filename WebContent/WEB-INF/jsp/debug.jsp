<%@ page language="java" contentType="text/html; charset=windows-31j"
    pageEncoding="windows-31j"
    import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-31j">
<title>debug jsp</title>
</head>
<body>
<h2>Request Parameters</h2>
<table border="1">
<tr><th>name</th><th>value</th></tr>
<%
	Enumeration enu = request.getParameterNames();
	while(enu.hasMoreElements()){
		String name = (String)enu.nextElement();
		out.print("<tr><td>" + name + "</td><td>");
		String[] values = request.getParameterValues(name);
		for(int i = 0; i < values.length; i++){
			out.print(values[i] + "<br />");
		}
		out.print("</td></tr>");
	}
%>
</table><br />

<h2>Request Scope</h2>
<table border="1">
<tr><th>name</th><th>value</th></tr>
<%
	enu = request.getAttributeNames();
	while(enu.hasMoreElements()){
		String name = (String)enu.nextElement();
		out.println("<tr><td>" + name + "</td><td>" + request.getAttribute(name) + "</td></tr>");
	}
%>
</table><br />

<h2>Session Scope</h2>
<table border="1">
<tr><th>name</th><th>value</th></tr>
<%
	enu = session.getAttributeNames();
	while(enu.hasMoreElements()){
		String name = (String)enu.nextElement();
		out.println("<tr><td>" + name + "</td><td>" + session.getAttribute(name) + "</td></tr>");
	}
%>
</table><br />

<h2>Application Scope</h2>
<table border="1">
<tr><th>name</th><th>value</th></tr>
<%
	enu = application.getAttributeNames();
	while(enu.hasMoreElements()){
		String name = (String)enu.nextElement();
		out.println("<tr><td>" + name + "</td><td>" + application.getAttribute(name) + "</td></tr>");
	}
%>
</table><br />

<h2>Cookies</h2>
<table border="1">
<tr><th>name</th><th>value</th></tr>
<%
	Cookie[] cookies = request.getCookies();
	if(cookies != null){
		for(int i = 0; i < cookies.length; i++){
			out.println("<tr><td>" + cookies[i].getName() + "</td><td>" + cookies[i].getValue() + "</td></tr>");		
		}
	}
%>
</table><br />

<h2>Headers</h2>
<table border="1">
<tr><th>name</th><th>value</th></tr>
<%
	enu = request.getHeaderNames();
	while(enu.hasMoreElements()){
		String name = (String)enu.nextElement();
		out.print("<tr><td>" + name + "</td><td>");
		Enumeration enu2 = request.getHeaders(name);
		while(enu2.hasMoreElements()){
			
			out.print(enu2.nextElement() + "<br />");
		}
		out.print("</td></tr>");
	}
%>
</table><br />

<hr />
</body>
</html>