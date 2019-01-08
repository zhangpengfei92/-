<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="utf8">
    <title>正在转到付款页</title>
    <script type="text/javascript" src="${path}/js/h5/js/jquery-1.11.0.min.js"></script>
    
</head>
<body>
    <form name="pay" id="form" action="${map.url}" method="post">
        <input type="hidden" name="app_id" value="${map.app_id}">
        <input type="hidden" name="method" value="${map.method}">
        <input type="hidden" name="version" value="${map.version}">
        <input type="hidden" name="content" value="${map.content}">
        <input type="hidden" name="sign" value="${map.sign}">
        <input type="hidden" name="sign_type" value="${map.sign_type}">    
    </form> 
</body>
<script type="text/javascript">
    $(document).ready(function(){
        $("#form").submit();
    }); 
</script>
</html>
