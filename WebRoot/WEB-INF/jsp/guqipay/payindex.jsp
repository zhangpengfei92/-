<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="utf8">
    <title>正在转到付款页</title>
    <script type="text/javascript" src="${path}/js/h5/js/jquery-1.11.0.min.js"></script>
    
</head>
<body>
<%--     <form name="pay" id="form" action="${map.payUrl}" method="post">
        <input type="hidden" name="agentNo" value="${map.agentNo}">
        <input type="hidden" name="merchantNo" value="${map.merchantNo}">
        <input type="hidden" name="orderAmount" value="${map.orderAmount}">
        <input type="hidden" name="outOrderNo" value="${map.outOrderNo}">
        <input type="hidden" name="notifyUrl" value="${map.notifyUrl}">
        <input type="hidden" name="callbackUrl" value="${map.callbackUrl}">
        <input type="hidden" name="productName" value="${map.productName}">
        <input type="hidden" name="acqCode" value="${map.acqCode}">
        <input type="hidden" name="sign" value="${map.sign}">    
    </form>  --%>
</body>
<script type="text/javascript">
    $(document).ready(function(){
    	window.location.href='${payUrl}';
       // $("#form").submit();
    }); 
</script>
</html>
