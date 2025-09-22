<%@page import="org.apache.catalina.tribes.ChannelSender"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%! 
	final double d = Math.random();
	final int i = (int)(d*100);
	private int count = i; 
	private List list1 = new ArrayList();
%>
<% 
	out.println(count);
%>
<h1>1~100の乱数を生成したよ!</h1>
<h2>いくつかな?</h2>
<form name="thisform"method="post">
<input type="text" name="name">
<input type="button" value="送信"onclick="sel()">
</form>

<script language="javascript">
function sel(){
document.thisform.submit();
}
</script>

<%
String name=request.getParameter("name");
if(name != null){
	int tmp = Integer.parseInt(name);
	String res;
	if(tmp>count)
		res = name + "　は もっと上";
	else if(tmp < count)
		res = name + " は もっと下";
	else
		res = "正解！";

	out.println(res);	
	list1.add(res);
	//这里要注意，一定要执行setAttribute，否则在前台获取不到
	request.setAttribute("list1",list1);
}
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<ol>
	<c:forEach items="${list1}" var="user" varStatus="s">
	<li>${user}</li>
	</c:forEach>
</ol>

</body>
</html>