<%@page import="org.apache.catalina.tribes.ChannelSender"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.Random" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

<body>

<form name="thisform" action="" method="get">
	<input type="hidden" name="name" id="zh">
    <div class="">
        <strong>手を選んでね：</strong><br/>
            <label><input type="radio" name="lifeType" value="1" />グー</label>
            <label><input type="radio" name="lifeType" value="2" />チョキ</label>
            <label><input type="radio" name="lifeType" value="3" />ポー</label><input type="button" value="送信"onclick="sel()">
    </div>
</form>

<script language="javascript">
function sel(){
	var lifeType = $('input[name="lifeType"]:checked').val();
	document.getElementById("zh").value = lifeType;
	document.thisform.submit();
}
</script>

<%
	String name=request.getParameter("name");
	Random random = new Random();
	int randomInt = random.nextInt(3)+1;
	int yourInt = Integer.parseInt(name);
	String ran = "";
	String you = "";
	switch (randomInt){
	    case 1:
	    	ran = "PCはグー";
	      break;
	    case 2:
	    	ran = "PCはチョキ";
	      break;
	    case 3:
	    	ran = "PCはポー";
	      break;
	}
	switch (yourInt){
    case 1:
    	you = "あなたはグー";
      break;
    case 2:
    	you = "あなたはチョキ";
      break;
    case 3:
    	you = "あなたはポー";
      break;
	}
	String res = "";
	if(yourInt == randomInt){
		res = "同点です。";
	}else if( (yourInt == 1 && randomInt == 2) || (yourInt == 2 && randomInt == 3) || (yourInt == 3 && randomInt == 1)){
		res = "あなたの勝ち";
	}else{
		res = "PCの勝ち";
	}
	out.println(you);
	out.println("<br>");
	out.println(ran);
	out.println("<br>");
	out.println(res);
%>

<script type="text/javascript">

/*     $(document).ready(function () {
        $("input:radio[name='lifeType']").click(function(){
            var lifeType = $('input[name="lifeType"]:checked').val();
            if (lifeType == '1' || lifeType == '' || lifeType == null) {
                lifeType = "值为1";
                document.getElementById("value").innerHTML = lifeType;
            } else if (lifeType == '2') {
                lifeType = "值为2";
                document.getElementById("value").innerHTML = lifeType;
            } else if (lifeType == '3') {
                lifeType = "值为3";
                document.getElementById("value").innerHTML = lifeType;
            }
        });
    }); */
    
</script>



</body>
</html>