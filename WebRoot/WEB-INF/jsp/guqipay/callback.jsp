<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html> 
<head>
<meta charset="utf-8">
<title>无法充值提现</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="viewport" content="width=320,maximum-scale=1,user-scalable=no">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=yes"/><!-- 打电话 -->

<link href="${path }/apppay/css/css.css" rel="stylesheet" type="text/css" />
<link href="${path }/apppay/css/animation.css" rel="stylesheet" type="text/css" />
<script src="${path }/apppay/js/jquery-1.9.1.min.js" type="text/javascript" ></script>
<script src="${path }/apppay/js/All.js" type="text/javascript"></script>

	<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/icon.css" />

</head> 
<body>
	<div class="wrap">
		<div class="Rbox">
			<div class="mainbox">
	         	<div class="main" style="min-height: 661px;">
	         		 <div class="Monbox" align="center"><br/><br/><br/>
	         		 <c:if test="${empty msg}">
	         		 	<font style="font-size:3.0rem;">充值异常，请联系管理员</font>
	         		 </c:if>
					<font style="font-size:3.0rem;">${msg}</font>  			 
             		</div>
	            </div>
	    	</div>
		</div>
     </div>
</body>
</html>