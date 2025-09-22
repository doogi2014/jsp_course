<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>あなたの誕生日を入力してください。</h3>
	<form name="thisform" action="" method="post">
		<input type="text"  name="month" />月
		<input type="text"  name="day"  />日
		<input type="button" value="送信"onclick="sel()">
	</form>
	<script language="javascript">
		function sel(){
			document.thisform.submit();
		}
	</script>
</body>
</html>