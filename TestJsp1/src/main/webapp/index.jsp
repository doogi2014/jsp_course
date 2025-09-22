<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<%@ page import="cn.doogi.User" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Test</h1>
	<% 
		int sum = 0;
		for(int i=0;i<=10;i++){
			sum +=i;
		}
		out.println(sum);
	%>
	<br/>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    <%
        List list1 = new ArrayList();
        list1.add(new User("张三",23,new Date()));
        list1.add(new User("李四",24,new Date()));
        list1.add(new User("王五",25,new Date()));

        request.setAttribute("list1",list1);
    %>
    <table border="1" width="500" align="center">
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>生日</th>
        </tr>
        数据行
        <c:forEach items="${list1}" var="user" varStatus="s">

            <c:if test="${s.count % 2 != 0}">

                <tr bgcolor="red">
                    <td>${s.count}</td>
                    <td>${user.name}</td>
                    <td>${user.age}</td>
                    <td>${user.birStr}</td>
                </tr>
            </c:if>

            <c:if test="${s.count % 2 == 0}">

                <tr  bgcolor="green">
                    <td>${s.count}</td>
                    <td>${user.name}</td>
                    <td>${user.age}</td>
                    <td>${user.birStr}</td>
                </tr>
            </c:if>
        </c:forEach>
    </table>
	<%
        List list2 = new ArrayList();
        for(int i=1;i<10;i++){
        	List list3 = new ArrayList();
        	for(int j=1;j<10;j++){
        		list3.add(i*j);
        	}
        	list2.add(list3);
        }

        request.setAttribute("list2",list2);
    %>
    <table border="1" width="500" align="center">
        <%--数据行--%>
        <c:forEach items="${list2}" var="user2" varStatus="s2">
        <tr  bgcolor="green">
        	<%-- <td>${s2.count-1}</td>
        	<td>${user2[s2.count-1]}</td> --%>
        	<c:forEach items="${user2}" var="user3" varStatus="s3">
            <td>${user3}</td>
            </c:forEach>
        </tr>
        </c:forEach>
    </table>
    
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
    测试fmt<br/>
    <fmt:formatNumber value = "123456789" pattern = "####,####"></fmt:formatNumber><br/>
    
    <!-- 创建了个Data类型的对象，对象名叫myDate -->
    <jsp:useBean id="myDate" class="java.util.Date"></jsp:useBean>
    <fmt:formatDate value="${myDate}" type="DATE"/><br/>
    <fmt:formatDate value="${myDate}" type="TIME"/><br/>
    <fmt:formatDate value="${myDate}" type="BOTH"/><br/>
    
    <fmt:formatDate value="${myDate}" type="DATE" dateStyle="FULL"/><br/>
    <fmt:formatDate value="${myDate}" type="DATE" dateStyle="LONG"/><br/>
    <fmt:formatDate value="${myDate}" type="DATE" dateStyle="MEDIUM"/><br/>
    <fmt:formatDate value="${myDate}" type="DATE" dateStyle="SHORT"/><br/>
    
    
    
</body>
</html>