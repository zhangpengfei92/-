<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<html>
<meta HTTP-EQUIV="pragma" CONTENT="no-cache"> 
<meta HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate"> 
<meta HTTP-EQUIV="expires" CONTENT="Wed, 26 Feb 2012 01:23:45 GMT">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
    <title></title>
    <script src="${path}/js/lib/jquery/jquery-1.9.0.min.js" type="text/javascript"></script> 
</head>
<body style="background: white; font-size: 12px;"> 
 
    
   
    <center>
    <h2>欢迎进入外汇后台展示 
	</h2>
    	<table border="1px">
    		<tr>
    			<td>
    			商品名字
    			</td>
    			<td>
    			价格
    			</td>
    			<td>
    			数量
    			</td>
    			<td>
    			详情
    			</td>
    		</tr>
    		<c:forEach var="product" items="${list }">
    		<tr>
    			<td>
    			${ product.name}
    			</td>
    			<td>
    			${ product.price}
    			</td>
    			<td>
    			${ product.number}
    			</td>
    			<td>
    			${ product.desc}
    			</td>
    		</tr>
    		</c:forEach>
    	
    	</table>
    </center>
</body>
</html>
