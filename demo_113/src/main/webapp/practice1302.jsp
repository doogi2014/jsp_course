<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List" %>
<%@ page import="cn.doogi.model.Book" %>     
<%
	Book book = (Book)request.getAttribute("book");
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
        	<td>ID</td>
            <td>${book.getId()}</td>
        </tr>
        <tr>
        	<td>名前</td>
            <td>${book.getName()}</td>
        </tr>
        <tr>
        	<td>価格</td>
            <td>${book.getPrice()}</td>
        </tr>
        <tr>
        	<td>著者</td>
            <td>${book.getAuthor()}</td>
        </tr>
        <tr>
        	<td>コメント</td>
            <td>${book.getComment()}</td>
        </tr>
        </table>
</body>
</html>