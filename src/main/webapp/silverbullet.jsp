<%@ page 
	language="java" 
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.rmc.oss.werewolf.*" 
%>
<%
try{
	new SMSSilverBullet().SendSMS();
}catch(Exception ex){
	out.println("<font color=\"red\">");
	StackTraceElement[] ste = ex.getStackTrace();
	int counter = 0;
	out.println(ex.getMessage() + "<br>");
	while(counter < ste.length && counter < 15){
		out.println(ste[counter] + "<br>");
		counter++;
	}
	out.println("</font>");
}
%>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Silo Build Log</title>
</head>
<body>
<div align="center">
<h1>FIRING THE SILVER BULLET!!</h1>
</div>

</body>
</html>
