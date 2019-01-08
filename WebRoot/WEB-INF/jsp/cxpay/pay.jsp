<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="utf8">
    <title>正在转到付款页</title>
    <script type="text/javascript" src="${path}/js/h5/js/jquery-1.11.0.min.js"></script>
    
</head>
<body>
    <form name="pay" id="form" action="http://www.zhongxinzhifu101.com/apibank" method="post">
        <input type="hidden" name="version" value="${map.version}">
        <input type="hidden" name="customerid" value="${map.customerid}">
        <input type="hidden" name="sdorderno" value="${map.sdorderno}">
        <input type="hidden" name="total_fee" value="${map.total_fee}">
        <input type="hidden" name="paytype" value="${map.paytype}">
        <input type="hidden" name="notifyurl" value="${map.notifyurl}">
        <input type="hidden" name="returnurl" value="${map.returnurl}">
        <input type="hidden" name="remark" value="${map.remark}">
        <input type="hidden" name="bankcode" value="${map.bankcode}">
        <input type="hidden" name="sign" value="${map.sign}">        
    </form> 
</body>
<script type="text/javascript">
    $(document).ready(function(){
        $("#form").submit();
    }); 
</script>
</html>
