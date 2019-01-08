<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
    <meta charset="utf8">
    <title>正在转到付款页</title>
    <script type="text/javascript" src="${path}/js/h5/js/jquery-1.11.0.min.js"></script>
    
</head>
<body>
    	 <form id="pay_form" action="${url}" method="${method}" target="_blank" content-type="application/x-www-form-urlencoded">
		<c:forEach items="${params}" var="maps" > 
			<input type="hidden" name="${maps.key}" id="${maps.key}" value="${maps.value}" />
			</c:forEach> 
	 </form> 
</body>
<script type="text/javascript">
   $(document).ready(function(){
    	
        $("#pay_form").submit();
    });
</script>
</html>
