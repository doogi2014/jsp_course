<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="java.text.*" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		int count = (int)request.getSession().getAttribute("count");
		String mes = "";
		if(count == 0){
			mes = "今日はあなたの誕生日です。おめでとうごさいます。";
		}else{
			mes = "次の誕生日まであと"+count+"日です。";
		}
	%>
	<h3><%= month%>月<%= day%>日生まれのあなた。</h3>
	<h3><%= mes%></h3>
	
	
	
</body>
</html>