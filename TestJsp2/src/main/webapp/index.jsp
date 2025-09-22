<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome</h1>
<jsp:element name="div">jsp div</jsp:element>
<jsp:include page="test.jsp"></jsp:include>
<%@ include file = "test.jsp" %>
<div>native div</div>

<%-- <jsp:forward page="test.jsp">
	<jsp:param value="234" name="id"/>
</jsp:forward> --%>

<%-- <jsp:element name=""></jsp:element>
<jsp:forward page=""></jsp:forward>

<!-- 尽量用第一个 -->
<jsp:include page=""></jsp:include>
<%@ include file = "" %>

<jsp:useBean id=""></jsp:useBean>
<jsp:param value="" name=""/> --%>

</body>
</html>