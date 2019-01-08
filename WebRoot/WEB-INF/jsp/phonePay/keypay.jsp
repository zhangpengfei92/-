<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>确认支付</title>
<meta name="viewport"
	content="width=320,maximum-scale=1,user-scalable=no">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta content="telephone=no" name="format-detection">
<link href="${path }/apppay/css/css.css" rel="stylesheet"
	type="text/css" />
<link href="${path }/apppay/css/animation.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="${path}/apppay/js/jquery.js"></script>
<script type="text/javascript" src="${path}/apppay/js/md5.js"></script>
<script type="text/javascript" src="${path}/apppay/js/All.js"></script>
<script src="${path}/apppay/js/jquery-1.9.1.min.js"
	type="text/javascript"></script>
<script type="text/JavaScript" src="${path }/js/DateFormatter.js"></script>
<script type="text/javascript">
// 填充默认的时间字段
$(function () {
    var nowDate = new Date().format("yyyyMMddhhmmss");
    $("#reqTime").val(nowDate);
    $("#orderTime").val(nowDate);
    $("#order_id").val($("#order_uid").val()+"_" + nowDate);
    
    $(".num").on("click",function(){
			 /* $(this).siblings().removeClass('onaon');
			$(this).siblings().children().removeClass('onaon'); */
			$(".num").each(function () {  
				$(this).removeClass("onaon");  
			}); 
			$(this).addClass('onaon');
			$("#price").val($(this).text()); 
		})
});

function  OfflinePay() {
	window.location.href="${path}/offline/offlinePay"
}

function clickSave() {
	var totalAmount= $("#price").val();
	var pattern = /(^[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)/;
	   if(!pattern.test(totalAmount) || totalAmount<=0){
		   alert("金额不对");
	  	   return false;
	   }
	var radioType = $("input[type='radio']:checked").val();
	$("#type").val(radioType);
    $.ajax({
        cache: false,
        type: "POST",
        url: "${path}/apppay/PhonePay/gopay",
        data: $('#orderPayForm').serialize(),// 你的formid
        async: true,
        error: function (request) {
            alert("Connection error");
        },
        success: function (r) {
            $("#key").val(r);
		   // $("#orderPayForm").attr("action", 'https://cashier.sandpay.com.cn/fastPay/quickPay/index');
		    $("#orderPayForm").submit();
        }
    });
    
}
</script>
</head>
<body class="grey">
	<div class="category">
		<section class="phonewrap2">
			<div class="Monbox">
				<div class="paymon">
					<ul>
						<li><div class="num"><i>100</i></div>  </li>
						<li><div class="num"><i>1000</i></div>  </li>
						<li><div class="num"><i>3000</i></div>  </li>
					</ul>	
					<ul>
						<li><div class="num"><i>5000</i></div>  </li>
						<li><div class="num"><i>10000</i></div>  </li>
						<li><div class="num"><i>20000</i></div>  </li>
					</ul>	
					<ul>
						<li><div class="num"><i>30000</i></div>  </li>
						<li><div class="num"><i>50000</i></div>  </li>
						<li><div class="num"><i>0.01</i></div>  </li>
					</ul>
				</div>
			</div>
			<div class="paybox2">
				<h3>支付方式</h3>
				<div class="paymethod2">
					<div class="paylist paylist2">
							<ul>
								<!-- <li style="border-bottom: none;">
									<div class="payicon">
										<p class="icontit">微信支付</p>
									</div>
									<div id="container">
										<input type="radio" class="input_check" name="radio" value="1"
											checked="checked">
									</div>
								</li> -->
								<li style="border-bottom: none;">
									<div class="payicon">
										<p class="icontit">支付宝支付</p>
									</div>
									<div id="container">
										<input type="radio" class="input_check" name="radio" value="2" checked="checked">
									</div>
								</li>
								
									<li style="border-bottom: none;">
									<div class="payicon">
										<p class="icontit">线下支付</p>
									</div>
									<div id="container">
										<div class="jiant"> <i onclick="OfflinePay()">></i></div>
									</div>
								</li>
						<form id="orderPayForm" method="post" action="http://mq.key58.top/Home/Pay/payFor">
								<li>
									<div class="payicon wpayicon">
										<p class="icon02"></p>
										<p class="icontit2">
											支付金额： <input type="text" id="price" name="price"
												value="" placeholder="请输入金额"  onkeyup="value=value.replace(/[^\-?\d.]/g,'')" readonly="readonly"/>
										</p>
										<span></span>
									</div>
								</li>
							<input type="hidden" name="uid" id="uid" value="${uid }" />
							<input name="type" id="type" type="hidden" value="">
							<input name="notify_url" id="notify_url" type="hidden" value="${notifyUrl }">
							<input type="hidden" name="return_url" id="return_url" value="${frontUrl }" />
							<input name="order_id" id="order_id" type="hidden" value="17788538285_2113111241589755">
							<input name="order_uid" id="order_uid" type="hidden" value="${subzh }">
							<input name="order_name" id="order_name" type="hidden" value="shoping">
							<input name="key" id="key" type="hidden" value="">
						</form>
							<button class="rebut rebut2" onclick="clickSave();">确认支付</button>
					</div>
				</div>
			</div>
		</section>
</body>
</html>
