<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    response.setHeader("Pragma","No-cache");  
    response.setHeader("Cache-Control","no-cache");  
    response.setDateHeader("Expires", 0);  
%>
<html>
<head>
    <title>正在提交数据.请稍等</title>
</head>
<body>
<%
	String submitForm=String.valueOf(request.getAttribute("submitForm"));
	out.print(submitForm);
 %>
</body>
</html>
