<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html> 
<head>
<meta charset="utf-8">
<title>H5支付</title>
<meta name="viewport" content="width=320,maximum-scale=1,user-scalable=no">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<!-- <meta content="telephone=no" name="format-detection"> -->
<meta name="format-detection" content="telephone=yes"/><!-- 打电话 -->

<link href="${path }/apppay/css/css.css" rel="stylesheet" type="text/css" />
<link href="${path }/apppay/css/animation.css" rel="stylesheet" type="text/css" />
<script src="${path }/apppay/js/jquery-1.9.1.min.js" type="text/javascript" ></script>
<script src="${path }/apppay/js/All.js" type="text/javascript"></script>

	<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/icon.css" />
	<script type="text/javascript" src="${path}/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${path}/js/easyui/locale/easyui-lang-zh_CN.js"></script>

<script src="http://pv.sohu.com/cityjson?ie=utf-8"></script>
<script type="text/javascript">
	function buy(str) {
		var subzh =$.trim($("#subzh").val());
		if(str==1){//金付
			 window.location.href="${path}/subzhfund/goKingPay?subzh="+subzh;
		}else if(str==2){//顺付
			 window.location.href="${path}/subzhfund/goPCPay?subzh="+subzh;
		}
	}

</script>

<style type="text/css">
	a{
		color: #21ADFA
		background-color:yellow
	}

</style>

</head> 
<body class="grey">
    <div class="category">
    <section class="phonewrap2">
             <div class="paybox2">
                  <h3>充值</h3>
                  <div class="paymethod2">
                       <div class="paylist paylist2">
                        <form action="" id="infoInputForm" method="post">
                        	<input type="hidden" value="${subzh}" id="subzh">
             				<div class="paymon" >
             				 <p align="left" style="margin: 0 0 30px 0;font-style: italic;color: red">请选择支付通道 </p>
	             				<p>
	             				&nbsp;<a style="background-color: #21ADFA" href="javascript:void(0);" class="consu" onclick="buy('1')">支付通道一</a>
	             				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;<a style="background-color: #21ADFA" href="javascript:void(0);" class="consu" onclick="buy('2')">支付通道二</a>
								</p>
			                </div>
                        </form>    
                       </div>
                  </div>
             </div>
    </section>
    </div>
</body>
</html>