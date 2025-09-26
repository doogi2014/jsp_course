<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		List<String> list = (List<String>)request.getSession().getAttribute("list");
	%>
	<h3>ご注文は「<%=list.get(0) %>」ですね!</h3>
	<h3>合計<%=list.get(1) %>皿で<%=list.get(2) %>円頂戴致します!</h3>
	<a href="javascript:history.back(-1)">戾る</a>
</body>
</html>