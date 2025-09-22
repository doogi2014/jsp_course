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
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    <%
        List<Integer> list1 = new ArrayList<>();
    	list1.add(0);
    	list1.add(0);
    	list1.add(2);
    	list1.add(2);
    	list1.add(0);
    	list1.add(3);
    	list1.add(2);
    	list1.add(0);
    	list1.add(0);
    	list1.add(0);
    	list1.add(1);
    	List<Integer> list2 = new ArrayList<>();
    	list2.add(2);
    	list2.add(0);
    	list2.add(0);
    	list2.add(1);
    	list2.add(0);
    	list2.add(0);
    	list2.add(1);
    	list2.add(0);
    	list2.add(5);
    	list2.add(0);
    	list2.add(2);
    	
		int sum1 = list1.stream().reduce(Integer::sum).orElse(0);
		int sum2 = list2.stream().reduce(Integer::sum).orElse(0);
        request.setAttribute("list1",list1);
        request.setAttribute("list2",list2);
        request.setAttribute("sum1",sum1);
        request.setAttribute("sum2",sum2);
    %>
    <table border="1" width="500" align="center">
        <tr>
        	<th></th>
            <th>1</th>
            <th>2</th>
            <th>3</th>
            <th>4</th>
            <th>5</th>
            <th>6</th>
            <th>7</th>
            <th>8</th>
            <th>9</th>
            <th>10</th>
            <th>11</th>
            <th>計</th>
        </tr>

        <tr  >
            <td>巨人</td>
            <c:forEach items="${list1}" var="user" varStatus="s">
            <td>${user}</td>
            </c:forEach>
            <td>${sum1}</td>
        </tr>
        
        <tr  >
            <td>阪神</td>
            <c:forEach items="${list2}" var="user" varStatus="s">
            <td>${user}</td>
            </c:forEach>
            <td>${sum2}</td>
        </tr>
        
    </table>
</body>
</html>