<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${path}/js/h5/js/jquery-1.11.0.min.js"></script>
<link type="text/css" href="${path}/css/h5/css/css.css" rel="stylesheet"/>
<link type="text/css" href="${path}/css/h5/css/animation.css" rel="stylesheet"/>
<link type="text/css" href="${path}/css/h5/css/DateTimePicker.css" rel="stylesheet"/>
<title>订单支付</title>
</head>
<script type="text/javascript">

</script>
<body class="gray">
    <form id="form" action="${url}" method="post">
		<input type="hidden" name="payKey"  value="${map.payKey}">
		<input type="hidden" name="orderPrice"  value="${map.orderPrice}">
		<input type="hidden" name="outTradeNo"  value="${map.outTradeNo}">
		<input type="hidden" name="productType"  value="${map.productType}">
		<input type="hidden" name="orderTime"  value="${map.orderTime}">
		<input type="hidden" name="productName"  value="${map.productName}">
		<input type="hidden" name="orderIp"  value="${map.orderIp}">
		<input type="hidden" name="bankCode"  value="${map.bankCode}">
		<input type="hidden" name="bankAccountType"  value="${map.bankAccountType}">
		<input type="hidden" name="returnUrl"  value="${map.returnUrl}">
		<input type="hidden" name="notifyUrl"  value="${map.notifyUrl}">
		<input type="hidden" name="remark"  value="${map.remark}">
		<input type="hidden" name="sign"  value="${map.sign}">
	</form>

<script type="text/javascript">
    $(document).ready(function(){
        $("#form").submit();
    });
</script>
</body>
</html>