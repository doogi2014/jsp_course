<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>注文数を入カしてください</h3>
	<form name="thisform"method="post">
	まぐる<input type="text" name="n1" value="0">皿<br>
	サ一モン<input type="text" name="n2" value="0">皿<br>
	エビ<input type="text" name="n3" value="0">皿<br>
	タコ<input type="text" name="n4" value="0">皿<br>
	イ力<input type="text" name="n5" value="0">皿<br>
	いくら<input type="text" name="n6" value="0">皿<br>
	<input type="button" value="注文"onclick="sel()">
	</form>
	
	<script language="javascript">
	function sel(){
		document.thisform.submit();
	}
	</script>
</body>
</html>