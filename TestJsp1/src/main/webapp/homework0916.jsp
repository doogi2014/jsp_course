<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name=(String)request.getAttribute("name");
	String email=(String)request.getAttribute("email");
	if(name == null)
		name = "";
	if(email == null)
		email = "";
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title>クッキーの練習</title>
</head>
<body>
<script language="javascript">
function sel(){
	var n=document.getElementById("name");
	var e=document.getElementById("email");
	
	var exdays = 3;
	var d = new Date();
	d.setTime(d.getTime()+(exdays*24*60*60*1000));
	var expires = "expires="+d.toGMTString();
	document.cookie = "name =" + n.value + "; " + expires; 
	document.cookie = "email =" +e.value + "; " + expires; 
	//alert(n+e);
	//alert(n.value);
}
</script>
<input type="text" id="name" value="<%=name %>" />
<input type="text" id="email" value="<%=email %>"/>
<input type="button" value="送信" onclick="sel()"/>
</body>
</html>
