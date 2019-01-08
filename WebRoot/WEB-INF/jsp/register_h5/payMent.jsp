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
    	<input name="trade_no" type="hidden" value="${map.trade_no}" />
    	<input name="bank_code" type="hidden" value="${map.bank_code}" />
    	<input name="money" type="hidden" value="${map.money}" />
    	<input name="uid" type="hidden" value="${map.uid}" />
    	<input name="action" type="hidden" value="${map.action}" />
    	<input name="pay_method" type="hidden" value="${map.pay_method}" />
    	<input name="mch_id" type="hidden" value="${map.mch_id}" />
    	<input name="name" type="hidden" value="${map.name}" />
    	<input name="number_id" type="hidden" value="${map.number_id}" />
    	<input name="tel" type="hidden" value="${map.tel}" />
    	<input name="card_no" type="hidden" value="${map.card_no}" />
		<input name="currency" type="hidden" value="${map.currency}" />
		<input name="sign" type="hidden" value="${map.sign}" />
	</form>

<script type="text/javascript">
    $(document).ready(function(){
        $("#form").submit();
    });
</script>
</body>
</html>