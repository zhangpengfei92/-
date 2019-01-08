<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>H5充值</title>
<link rel="stylesheet" type="text/css" href="${path}/apppay/pay/css.css"/>
<script type="text/javascript" src="${path}/js/qrcode/dist/qrcode.js"></script>
<script type="text/javascript" src="${path}/js/qrcode/dist/qart.min.js"></script>
<script type="text/javascript" src="${path}/js/qrcode/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	var t;
	$(document).ready(function() {
		alert('${map}');
	   var value ='${map.codeUrl}';
	   function makeQR() {
	        var qr = qrcode.QRCode(10, 'H');
	        qr.addData(value);
	        qr.make();
	        document.getElementById('qrcode').innerHTML = qr.createImgTag(3);
	        
	    }
	   
	   makeQR();
	  countTime(120);
	  
	});
	
	function countTime(count) {		
		var m;
		
		if(count>0){
			count--;
			
			$("#pay_status").text("请在120S内完成操作...->"+count+"S");
			m= setTimeout(function() {countTime(count) },1000)			
		}else{
			$("#qrcode").empty();
			$("#qrcode").html("<span style='font-size:30px;'>二维码已失效</span>");
			$("#pay_status").text("二维码已失效");
			clearTimeout(m);
		}
	}
	
	
</script>

</head>
<body>
<body>
	<div class=" top0"><h4>欢迎使用</h4></div>
	<div class=" pic0">
		
	</div>
	
	<div class=" remind0">
	<p id="pay_status"></p>
	</div>
	<div class=" qrcode0" id="qrcode"></div>
	<div class=" steps0"></div>
  	<div class=" foot0"><a href="${map.codeUrl}">跳转支付宝支付</a></div>
</body>
</body>
</html>