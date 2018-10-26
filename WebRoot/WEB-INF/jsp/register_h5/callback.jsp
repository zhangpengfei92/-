<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html> 
<head>
<meta charset="utf-8">
<title>H5支付</title>
<meta name="viewport" content="width=320,maximum-scale=1,user-scalable=no">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta content="telephone=no" name="format-detection">
<link href="${path }/apppay/css/css.css" rel="stylesheet" type="text/css" />
<link href="${path }/apppay/css/animation.css" rel="stylesheet" type="text/css" />
<script src="${path }/apppay/js/jquery-1.9.1.min.js" type="text/javascript" ></script>
<script src="${path }/apppay/js/All.js" type="text/javascript"></script>
<script src="http://pv.sohu.com/cityjson?ie=utf-8"></script>
</head> 
<body class="grey">
    <div class="category">
    <section class="phonewrap2">
             <div class="Monbox">       
             		<p>${msg}</p>   
             </div>
             <div class="paybox2">
                  <h3>充值中如遇到任何问题，请联系客服</h3>
             </div>
    </section>
</body>
</html>