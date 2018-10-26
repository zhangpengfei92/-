<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html> 
<head>
<meta charset="utf-8">
<title>在线充值</title>
<meta name="viewport" content="width=320,maximum-scale=1,user-scalable=no">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=yes"/><!-- 打电话 -->
<script src="${path}/apppay/js/jquery-1.9.1.min.js" type="text/javascript" ></script>
	<style>
		*{ font-family:Arial, Helvetica, sans-serif;
			font-size:12px}
			.STYLE1 {font-size: 12px}
			
			
	</style>	
	<script type="text/javascript">
		function  buy() {
			debugger;
			alert($("#Bankco"));
			var Bankco = $.trim($("#Bankco").val()); 
			var Moneys = $.trim($("#Moneys").val());
			alert(Bankco);
			alert(Moneys);
			
			 window.location.href="${path}/iffund/ispay/"+Bankco+"/"+Moneys;
			 
	/* 		 $.ajaxSetup({async: false});
			$.post("${path}/iffund/ispay",
			{
			  "Bankco":Bankco,
			  "Moneys":Moneys
			  
			}); */
		}
		
		
	</script>
	
</head> 
<body>
<div style="text-align:center">
  <h2>请选择网上银行</h2>
</div>

	  <table width="445" border="0" align="center" cellpadding="0" cellspacing="0" style="border:#99CC00 solid 2px">
	    <tr>
	      <td  colspan="2" align="center" bordercolor="#00CCFF">
				<table width="68%" border="0" cellpadding="0" cellspacing="1" bgcolor="#CCCCCC">
	      		  <tr>
	         		 <td width="32%" height="25" align="left" bgcolor="#FFFFFF">
	         		 <input type="radio" name="Bankco" id="Bankco" checked="checked" value="wx"  />
	         		 	微信支付</td>
	         		 <td width="32%" align="left" bgcolor="#FFFFFF">
	         		 <input type="radio" name="Bankco" id="Bankco" value="zfb"/>
	         		 	支付宝支付</td>
	          		 </tr>
	       		 </table>充值金额：<input type="text" name="Moneys" id="Moneys" value="0.01" />
			</td>
	    </tr>
	    <tr>
	      <td height="36" colspan="2" align="center">
	     		 <a href="javascript:void(0);"  onclick="buy()">提交</a>
	      </td>
	    </tr>
	  </table>
</body>
</html>