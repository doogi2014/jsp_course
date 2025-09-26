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
		String con = "ok";
	%>
	<h3>確認</h3>
	<form name="thisform"method="post">
	まぐる:<%=list.get(0) %>皿<br>
	サ一モン:<%=list.get(1) %>皿<br>
	エビ:<%=list.get(2) %>皿<br>
	タコ:<%=list.get(3) %>皿<br>
	イ力:<%=list.get(4) %>皿<br>
	いくら:<%=list.get(5) %>皿<br>
	<input type="hidden" name="con" value="<%=con %>>">
	<a href="javascript:history.back(-1)">戾る</a>
	<a href="javascript:document.thisform.submit()">確定</a>
	</form>
</body>
</html>