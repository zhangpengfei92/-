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
<script src="http://pv.sohu.com/cityjson?ie=utf-8"></script>
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
		   alert("金额不合理");
	  	   return ;
	   }
	
    $("#orderSignForm").submit();
}
</script>
</head>
<body class="grey">
	<div class="category">
		<section class="phonewrap2">
			<div class="Monbox">
				<div class="paymon">
					<p class="mtit">网关支付</p>
				</div>
			</div>
			<div class="paybox2">
				<h3>支付方式</h3>
				<div class="paymethod2">
					<div class="paylist paylist2">
						<form action="${path}/apppay/PhonePay/orderPay" method="post"  id="orderSignForm">
							<ul>
								<li style="border-bottom: none;">
									<div class="payicon">
										<p class="icontit">杉德网关支付</p>
									</div>
									<div id="container">
										<input type="radio" class="input_check" name="radio" value="2"
											checked="checked">
									</div>
								</li>
								<input type="hidden" name="userId" id="userId" value="${fixSubzh}" />
								<input type="hidden" name="subzh" id="subzh" value="${sub.subzh}" />
								<input type="hidden" name="orderCode" id="orderCode" value="" />
								<li>
									<div class="payicon wpayicon">
										<p class="icon02"></p>
										<p class="icontit2">
											支付金额： <input type="text" id="totalAmount" name="totalAmount"
												value="" placeholder="请输入金额"  onkeyup="value=value.replace(/[^\-?\d.]/g,'')"/>
										</p>
										<span></span>
									</div>
										<div class="payicon wpayicon">
										<p class="icon02"></p>
										<p class="icontit2">
											请选择银行： <select name="bankcode" class="sel">
	                                    	<option value="0" selected="selected">==请选择开户银行==</option>
	                                    	<%-- <option value="01020000" <c:if test="${fn:contains(sub.bank,'工商')}">selected="selected"</c:if> >工商银行</option>                         
	                                    	<option value="03080000" <c:if test="${fn:contains(sub.bank,'招商')}">selected="selected"</c:if> >招商银行</option> --%>
	                                    	<option value="01030000" <c:if test="${fn:contains(sub.bank,'农业')}">selected="selected"</c:if> >农业银行</option>
	                                    	<option value="01050000" <c:if test="${fn:contains(sub.bank,'建设')}">selected="selected"</c:if> >建设银行</option>
	                                    	<option value="04031000" <c:if test="${fn:contains(sub.bank,'北京')}">selected="selected"</c:if> >北京银行</option>
	                                    	<%-- <option value="03010000" <c:if test="${fn:contains(sub.bank,'交通')}">selected="selected"</c:if>>交通银行</option> --%>
	                                    	<option value="03050000" <c:if test="${fn:contains(sub.bank,'民生')}">selected="selected"</c:if>>民生银行</option>
	                                    	<%-- <option value="03070000" <c:if test="${fn:contains(sub.bank,'平安')}">selected="selected"</c:if>>平安银行</option>
	                                    	<option value="03090000" <c:if test="${fn:contains(sub.bank,'兴业')}">selected="selected"</c:if>>兴业银行</option>
	                                    	<option value="04243010" <c:if test="${fn:contains(sub.bank,'南京')}">selected="selected"</c:if>>南京银行</option> --%>
	                                    	<option value="03030000" <c:if test="${fn:contains(sub.bank,'光大')}">selected="selected"</c:if>>光大银行</option>
	                                    	<option value="01040000" <c:if test="${fn:contains(sub.bank,'中国')}">selected="selected"</c:if>>中国银行</option>
	                                    	<option value="03060000" <c:if test="${fn:contains(sub.bank,'广发')}">selected="selected"</c:if>>广发银行</option>
	                                    	<option value="04012900" <c:if test="${fn:contains(sub.bank,'上海')}">selected="selected"</c:if>>上海银行</option>
	                                    	<%-- <option value="03100000" <c:if test="${fn:contains(sub.bank,'浦发')}">selected="selected"</c:if>>浦发银行</option> --%>
	                                    	<option value="01000000" <c:if test="${fn:contains(sub.bank,'邮')}">selected="selected"</c:if>>中国邮储银行</option>
	                                    	<%-- <option value="65012900" <c:if test="${fn:contains(sub.bank,'农商')}">selected="selected"</c:if>>上海农商行</option>
	                                    	<option value="03200000" <c:if test="${fn:contains(sub.bank,'东亚')}">selected="selected"</c:if>>东亚银行</option>
	                                    	<option value="04083320" <c:if test="${fn:contains(sub.bank,'宁波')}">selected="selected"</c:if>>宁波银行</option>
	                                    	<option value="03020000" <c:if test="${fn:contains(sub.bank,'中信')}">selected="selected"</c:if>>中信银行</option>
	                                    	<option value="64296511" <c:if test="${fn:contains(sub.bank,'徽商')}">selected="selected"</c:if>>徽商银行</option>
	                                    	<option value="03040000" <c:if test="${fn:contains(sub.bank,'华夏')}">selected="selected"</c:if>>华夏银行</option>
	                                    	<option value="03170000" <c:if test="${fn:contains(sub.bank,'渤海')}">selected="selected"</c:if>>渤海银行</option>
	                                    	<option value="04341101" <c:if test="${fn:contains(sub.bank,'天津')}">selected="selected"</c:if>>天津银行</option>
	                                    	<option value="64296510" <c:if test="${fn:contains(sub.bank,'成都')}">selected="selected"</c:if>>成都银行</option> --%>                   				 
	                                    	</select>
										</p>
										<span></span>
									</div>
									
								</li>

								
							</ul>
						</form>
							<button class="rebut rebut2" onclick="clickSave();">确认支付</button>
					</div>
				</div>
			</div>
		</section>
</body>
</html>
