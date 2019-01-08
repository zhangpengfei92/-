<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>	
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>	
	
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
    $("#orderCode").val($("#subzh").val()+"_" + nowDate);
});

function clickSave() {
	var totalAmount= $("#totalAmount").val();
	var pattern = /(^[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)/;
	   if(!pattern.test(totalAmount) || totalAmount<=0){
		   alert("金额不对");
	  	   return ;
	   }
	
    $.ajax({
        cache: false,
        type: "POST",
        url: "${path}/apppay/PhonePay/fastPay",
        data: $('#orderSignForm').serialize(),// 你的formid
        async: true,
        error: function (request) {
            alert("Connection error");
        },
        success: function (r) {
        	if(r!="fail"){
        		
        	}
            $("#data").val($.parseJSON(r).data);
            $("#sign").val($.parseJSON(r).sign);
		    $("#orderPayForm").attr("action", 'https://cashier.sandpay.com.cn/fastPay/quickPay/index');
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
					<p class="mtit">快捷支付</p>
				</div>
			</div>
			<div class="paybox2">
				<h3>支付方式</h3>
				<div class="paymethod2">
					<div class="paylist paylist2">
						<form action="" method="post"  id="orderSignForm">
							<ul>
								<li style="border-bottom: none;">
									<div class="payicon">
										<p class="icontit">杉德快捷支付</p>
									</div>
									<div id="container">
										<input type="radio" class="input_check" name="radio" value="2"
											checked="checked">
									</div>
								</li>
								<!--  <label>[version]版本号:</label> -->
								<input type="hidden" name="version" id="version" value="1.0" />
								<!--  <label>[method]接口名称:</label> -->
								<input type="hidden" name="method" id="method"
									value="sandPay.fastPay.quickPay.index" />
								<!--  <label>[productId]产品编码:</label> -->
								<!-- <select name="productId" id="productId">
                        <option value="00000016">00000016-一键快捷产品</option>
                    </select> -->
								<input type="hidden" name="productId" id="productId"
									value="00000016" />
								<input type="hidden" name="accessType" id="accessType" value="1" />
								<!-- <div>
                    <label>[accessType]接入类型:</label>
                    <select name="accessType" id="accessType">
                        <option value="1">1-普通商户接入（目前支持1）</option>
                        <option value="2">2-平台商户接入</option>
                    </select>
                </div> -->
								<!-- <label>[mid]商户号:</label> -->
								<input type="hidden" name="mid" id="mid" value="16468578" />
								<!--  <label>[plMid]平台商户号:</label> -->
								<input type="hidden" name="plMid" id="plMid" value="" />
								<!-- <label>[channelType]渠道类型:</label> -->
								<input type="hidden" name="channelType" id="channelType"
									value="07" />
								<!-- <select name="channelType" id="channelType">
                        <option value="07">07-互联网</option>
                        <option value="08">08-移动端</option>
                    </select>-->
								<!-- <label>[reqTime]请求时间:</label>  -->
								<input type="hidden" name="reqTime" id="reqTime" value="" />
								<!-- <label>[userId]用户ID:</label>  -->
								<input type="hidden" name="userId" id="userId" value="${fixSubzh}" />
								<input type="hidden" name="subzh" id="subzh" value="${sub.subzh}" />
								<!-- <label>[orderCode]商户订单号:</label>  -->
								<input type="hidden" name="orderCode" id="orderCode"
									value="SH000001" readonly="readonly" />
								<!-- <label>[orderTime]商户订单时间:</label>  -->
								<input type="hidden" name="orderTime" id="orderTime" value="" />
								<!-- <label>[totalAmount]订单金额:</label> -->
								<!-- <input type="text" name="totalAmount" id="totalAmount" value="000000000001" /> -->
								<li>
									<div class="payicon wpayicon">
										<p class="icon02"></p>
										<p class="icontit2">
											支付金额： <input type="text" id="totalAmount" name="totalAmount"
												value="" placeholder="请输入金额"  onkeyup="value=value.replace(/[^\-?\d.]/g,'')"/>
										</p>
										<span></span>
									</div>
								</li>

								<!-- <label>[subject]订单标题:</label>  -->
								<input type="hidden" name="subject" id="subject"
									value="test01Title" />
								<!-- <label>[body]订单描述:</label>  -->
								<input type="hidden" name="body" id="body" value="test01Desc" />
								<!-- <label>[currencyCode]币种:</label>  -->
								<input type="hidden" name="currencyCode" id="currencyCode"
									value="156" />
								<!-- <label>[notifyUrl]异步通知地址:</label>  -->
								<input type="hidden" name="notifyUrl" id="notifyUrl"
									value="http://192.168.22.133:8088/moon-servlet01/test02" />
								<!-- <label>[frontUrl]前台通知地址:</label>  -->
								<input type="hidden" name="frontUrl" id="frontUrl"
									value="http://192.168.22.133:8088/moon-servlet01/test01" />
								<!-- <label>[clearCycle]清算模式:</label>  -->
								<input type="hidden" name="clearCycle" id="clearCycle" value="0" />
								<!-- <label>[extend]扩展域:</label>  -->
								<input type="hidden" name="extend" id="extend" value="" />
							</ul>
						</form>
							<button class="rebut rebut2" onclick="clickSave();">确认支付</button>

						<form id="orderPayForm" method="post">
							<!-- <label>[charset]编码:</label> -->
							<input type="hidden" name="charset" id="charset" value="UTF-8" />
							<!-- <label>[signType]签名类型:</label> -->
							<input type="hidden" name="signType" id="signType" value="01" />
							<!--  <label>[data]交易报文:</label> -->
							<input name="data" id="data" type="hidden">
							<!-- <label>[sign]签名:</label> -->
							<input name="sign" id="sign" type="hidden">
							<!-- <label>[extend]扩展域:</label> -->
							<input type="hidden" name="extend" id="extend" value="" />
						</form>
					</div>
				</div>
			</div>
		</section>
</body>
</html>
