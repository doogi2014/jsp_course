<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Random" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>暗算にチャレンジ</h1>


<form name="thisform" action="" method="get">
<%

	Random random = new Random();
	int min = 50;
	int max = 99;
	int randomNumber1 = random.nextInt(max - min + 1) + min;
	int randomNumber2 = random.nextInt(max - min + 1) + min;
	String str2= randomNumber1 +"x"+ randomNumber2+"=";

	out.println(str2);
%>

	<input type="hidden" id="var1" value="<%= randomNumber1 %>" />
	<input type="hidden" id="var2" value="<%= randomNumber2 %>" />
	<input type="hidden" id="c1" name= "cj1" value="<%= request.getParameter("cj1") %>" />
	<input type="hidden" id="c2" name= "cj2" value="<%= request.getParameter("cj2") %>" />
	<input type="text"  id="res">
	<input type="button" value="送信"onclick="sel()">
	<p id="demo"></p>
</form>
	<script language="javascript">
	

	function sel(){
		var cj1=document.getElementById("c1").value;
		var cj2=document.getElementById("c2").value;
		var rss = "";
		
		var v1 = document.getElementById("var1").value;
		var v2 = document.getElementById("var2").value;
		var r = document.getElementById("res").value;
		if(r == v1*v2){
			cj1++;
			rss = "正解";
		}
		else{
			cj2++;
			rss = "不正解";
		}
		//document.getElementById("demo").innerHTML = "正答数:"+cc1+" 誤答数:"+cc2;
		document.getElementById("c1").value = cj1;
		document.getElementById("c2").value = cj2;
		alert(rss);
		document.thisform.submit();
	}
	</script>
<%
	String str="<br>正答数:"+request.getParameter("cj1")+" 誤答数:"+request.getParameter("cj2")+" <br>";
	out.println(str);
%>
</body>
</html>