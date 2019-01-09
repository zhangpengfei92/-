<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="utf8">
    <title>正在转到付款页</title>
    <script type="text/javascript" src="${path}/js/h5/js/jquery-1.11.0.min.js"></script>
    
</head>
<body>
    <form name="pay" id="form" action="http://test-codepay.open580.com/pay/toPay.do" method="post">
        <input type="hidden" name="tradeNo" value="${map.tradeNo}">
        <input type="hidden" name="payType" value="${map.payType}">
        <input type="hidden" name="orderPrice" value="${map.orderPrice}">
        <input type="hidden" name="merchantId" value="${map.merchantId}">
        <input type="hidden" name="productName" value="${map.productName}">
        <input type="hidden" name="remark" value="${map.remark}"> 
    </form>
</body>
<script type="text/javascript">
    $(document).ready(function(){
    
      $("#form").submit();
    }); 
</script>
</html>
