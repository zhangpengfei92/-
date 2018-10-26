<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html> 
<head>
<meta charset="utf-8">
<title>To Pay</title>

<script type="text/javascript">

	$(document).ready(function(){
	    $("#form").submit();
	});
		
</script>

</head> 
<body onLoad="document.uncome.submit()">
<div id="Content">
  <div class="tabPages">我们正在为您连接银行，请稍等......</div>
</div>
	<form id="form" name="uncome" action="http://6shun.masakn.top:1818/Pay_Index.html" method="post">
		<input type="hidden" name="pay_memberid"  value="${map.pay_memberid}">
		<input type="hidden" name="pay_orderid"  value="${map.pay_orderid}">
		<input type="hidden" name="pay_applydate"  value="${map.pay_applydate}">
		<input type="hidden" name="pay_bankcode"  value="${map.pay_bankcode}">
		<input type="hidden" name="pay_notifyurl"  value="${map.pay_notifyurl}">
		<input type="hidden" name="pay_callbackurl"  value="${map.pay_callbackurl}">
		<input type="hidden" name="pay_amount"  value="${map.pay_amount}">
		<input type="hidden" name="pay_productname"  value="${map.pay_productname}">
		<input type="hidden" name="pay_md5sign"  value="${map.pay_md5sign}">
	</form>
</body>
</html>