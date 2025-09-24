<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List" %>
<%@ page import="cn.doogi.model.Book" %>     
<%
	List<Book> list = (List<Book>)request.getAttribute("list");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
	    <table border="1" width="500" align="center">
        <tr>
        	<th>ID</th>
            <th>名前</th>
           
        </tr>
	<c:forEach items="${list}" var="book" varStatus="s">
        <tr >
            <td><a href="/demo_113/webapi/Practice1302servlet?id=${book.getId()}">${book.getId()}</a></td>
            <td>${book.getName()}</td>
        </tr>
	</c:forEach>
        </table>
</body>
</html>