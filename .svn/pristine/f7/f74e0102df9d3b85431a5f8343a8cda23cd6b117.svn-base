<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html> 
<head>
	<meta charset="utf-8">
	<title></title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" />
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta content="telephone=no" name="format-detection">
    <link href="${cssPath}/auth/appauth.css" rel="stylesheet" type="text/css" />
    <link href="${cssPath}/auth/animation.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${jsPath}/jquery-1.9.1.min.js"></script>
    <script src="${jsPath}/All.js" type="text/javascript"></script>
    <script type="text/javascript" src="${jsPath}/jquery.touchSlider.js"></script>
</head> 
<body class="bggray">
    <div class="category">
    <!-- insder header -->
    <header class="ls-header">
        <div class="ls-header-left">
            <a href="javascript:history.go(-1)"><i class="iconfont icon-back"></i></a>
        </div>
        <div class="ls-header-title">身份认证</div>
        <!--<div class="ls-header-right">
           <a href=""><i class="iconfont icon-flash"></i></a>
        </div>-->
    </header>
    <div class="mainbox">
        <div class="Shbox">
            <p><img src="${path}/images/auth/renzheng.png"></p>
            <span><img src="${path}/images/auth/rz2.png"></span>
        </div>
        <a href="javascript:;" class="czbutton"  onclick="goAuth('${subzh.subzh}')">查看认证</a>
  </div>
  
    <script type="text/javascript">
   	function goAuth(subzh){
   		window.location.href="${path}/auth/toAuth?subzh="+subzh;
   	}
   </script>
</body>
</html>