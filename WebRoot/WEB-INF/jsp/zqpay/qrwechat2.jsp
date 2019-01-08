<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>H5充值</title>
<link href="${path }/css/pay/css.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/icon.css" />
<script src="${path }/apppay/js/jquery-1.9.1.min.js" type="text/javascript" ></script>
<script type="text/javascript" src="${path}/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${path}/js/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${path}/js/qrcode/dist/qrcode.js"></script>
<script type="text/javascript" src="${path}/js/qrcode/dist/qart.min.js"></script>
<script type="text/javascript" src="${path}/js/qrcode/js/jquery-1.9.1.min.js"></script>
<!--layui  -->
<link rel="stylesheet" href="${path}/layui/css/layui.css"  media="all">
<script src="${path}/layui/layui.js" charset="utf-8"></script>
<style>

/*修改提示文字的颜色*/

input::-webkit-input-placeholder { /* WebKit browsers */ 

color: #666;font-size:16px; } 

input:-moz-placeholder { /* Mozilla Firefox 4 to 18 */ 

color:#666; font-size:16px; } 

input::-moz-placeholder { /* Mozilla Firefox 19+ */ 

color:#666; font-size:16px; } 

input:-ms-input-placeholder { /* Internet Explorer 10+ */ 

color:#666; font-size:16px; } 

.qr img{width: 80%;height: 80%}

</style>
<script src="http://pv.sohu.com/cityjson?ie=utf-8"></script>
<script type="text/javascript">
	var t;
	$(document).ready(function() {
	  countTime(120);
	  
	});
	
	function countTime(count) {		
		var m;
		
		if(count>0){
			count--;
			
			$("#pay_status").text("请在120S内完成操作...->"+count+"S");
			m= setTimeout(function() {countTime(count) },1000)			
		}else{
			$("#qr").empty();
			$("#qr").html("<span style='font-size:30px;'>二维码已失效</span>");
			$("#pay_status").text("二维码已失效");
			clearTimeout(m);
		}
	}
	
	
</script>

</head>
<body class="grey">
   <div class="category">
    
    <section class="phonewrap2">

             <div class="PMonbox">
             <div style="width:100%; height:200px; text-align:center; margin: auto;">
             	<img alt="" style="width: 400px;height: 200px;" src="${path}/apppay/images/wechat.jpg">           
             </div>
             
             <div style="width:100%; height:20px; text-align:center; margin: auto;">            	
             	 <span style="color:#F30;font-weight:bold;" id="pay_status"></span>
             </div>
             	
				<div id="qr" style="width:400px; height:400px; text-align:center; margin: auto;" >
					<iframe src="${map.imgUrl}" scrolling="no" width="50%" height="50%" frameborder="0"></iframe>
				</div>
				<a href="${map.codeUrl}" style="color:#F30;font-weight:bold;">手机支付点这里</a>
             </div>
             
    </section>
	</div>
</body>
</html>