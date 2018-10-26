<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${path}/js/jquery-1.11.0.min.js"></script>
<link type="text/css" href="${path}/css/css.css" rel="stylesheet"/>
<link type="text/css" href="${path}/css/animation.css" rel="stylesheet"/>
<link type="text/css" href="${path}/css/DateTimePicker.css" rel="stylesheet"/>
<title>订单支付</title>
</head>
<script type="text/javascript">

</script>
<body class="gray">
    <form id="form" action="${url}" method="post">
    	<input name="merch" type="hidden" value="${payMap.merch}" />
    	<input name="orderno" type="hidden" value="${payMap.orderno}" />
    	<input name="amount" type="hidden" value="${payMap.amount}" />
    	<input name="tranchannel" type="hidden" value="${payMap.tranchannel}" />
    	<input name="body" type="hidden" value="${payMap.body}" />
    	<input name="pageurl" type="hidden" value="${payMap.pageurl}" />
    	<input name="notifyurl" type="hidden" value="${payMap.notifyurl}" />
    	<input name="comment" type="hidden" value="${payMap.comment}" />
    	<input name="sign" type="hidden" value="${payMap.sign}" />
    	<input name="signtype" type="hidden" value="${payMap.signtype}" />
	</form>

<script type="text/javascript">
    $(document).ready(function(){
        $("#form").submit();
    });
</script>
</body>
</html>