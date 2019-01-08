<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html> 
<head>
<meta charset="utf-8">
<title>H5提现</title>
<meta name="viewport" content="width=320,maximum-scale=1,user-scalable=no">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=yes"/><!-- 打电话 -->
<link rel="stylesheet" type="text/css" href="${path }/apppay/pay/paycss.css"/>
<script src="${path }/apppay/js/jquery-1.9.1.min.js" type="text/javascript" ></script>
<script type="text/JavaScript" src="${path }/js/DateFormatter.js"></script>
<script src="http://pv.sohu.com/cityjson?ie=utf-8"></script>
<script type="text/javascript">
	$(function () {
	    var nowDate = new Date().format("yyyyMMddhhmmss");
	    $("#orderno").val($("#subzh").val()+nowDate);
	});
	function buy(){
		//$(".consu").removeAttr("onclick");		
		alert($(".consu"));
		var fund = $.trim($("#fund").val());
    	if (fund.length < 1 || fund.length > 20) {
        	alert('请输入提现金额长度在2-20之间');
        	
            return false;
        }
    	var bFlag = true;
		if(!checkDouble(fund, "提现金额") || fund<=0){
			bFlag = false;
	        return false;
	    }
		
		if(fund<=0){
			alert('提现金额不合法');
			bFlag = false;
	        return false;
	    }
		
		var availMoney = $("#availMoney").val();
		if(availMoney*1 < fund*1){
			bFlag = false;
			alert('账户资产不足');
        	
            return false;
		} 
		
		var name = $.trim($("#name").val());
    	if (name.length < 1 || name.length > 20) {
        	alert('请输入姓名');
            return false;
        }
    	
    	var bankCardNumber = $.trim($("#bankCardNumber").val());
    	if (bankCardNumber.length < 1 || bankCardNumber.length > 20) {
        	alert('请输入银行卡号');
        	
            return false;
        }
		
		if(bFlag){
            $("#infoInputForm").submit();
		}
	}
	
	//Double验证
	function checkDouble(strValue, strName) {
		var pattern = /(^[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)/;
	   if(!pattern.test(strValue)){
		   alert(strName + "的数值不正确！");
		   try {
				javatojs.showToast(strName + "的数值不正确！");
			} catch (e){ 
       		window.location.href = "alert://alertInfo?message=" + strName + "的数值不正确！";
       	}
	  	   return false;
	   }
	   return true;
	}
	
	//消费记录
	function xfjl(){
		var subzh = $("#subzh").val();
		window.location.href="${path}/clientshow/phonePay!xfjl.action?subzh="+subzh;
	}
	
	//判断输入的金额是否为数字
	function checkNum(num){
		var b=true;
		if(isNaN(num)){
			alter("充值金额必须为数字");
			$("#zhBalance").val("");
			return false;
		}
		return b;
	}
	
</script>
</head> 
<body>
<div class="bg">
	
	<div class="top">
		<p class="balance"><i>
		   <fmt:formatNumber value="${sub.fundbalance==null?0:sub.fundbalance}" pattern="0.00"/>元</p>   		
		</i></p>
		<p>账户余额</p>
	</div>
	   <input type="hidden" id="availMoney" name="availMoney" value="<fmt:formatNumber value="${sub.fundbalance==null?0:sub.fundbalance}" pattern="0.00"/>"/>            
	<div class="main">
		<p class="btit">提现</p>
	</div>
		<div class="line"></div>
	<div class="main">
	<form action="${path}/apppay/PhonePay/withdrawend" id="infoInputForm" method="post">
		<table>
			<tr>
				<td class="tit">提现金额：</td>
				<td><input type="text" id="fund" name="fund" value="" placeholder="请输入提现金额"onkeyup="checkNum(this.value)" onpaste="checkNum(this.value)"/>元</td>
			</tr>
			<tr>
				<td class="tit">提现姓名：</td>
				<td><input type="text" id="name" name="name" value="${sub.isadmin==6?sub.name:''}"  <c:if test="${sub.isadmin==6}">readonly='readonly'</c:if> placeholder="请输入姓名"/></td>
			</tr>
			<tr>
				<td class="tit">银行卡号：</td>
				<td><input type="text" id="bankCardNumber" name="bankCardNumber" value="${sub.isadmin==6?sub.bankCard:''}"<c:if test="${sub.isadmin==6}">readonly='readonly'</c:if> placeholder="请输入银行卡号"/></td>
			</tr>
			<tr>
				<td class="tit">开户银行：</td>
				<td><input type="text" id="bankname" name="bankname" value="${sub.isadmin==6?sub.bank:''}" <c:if test="${sub.isadmin==6}">readonly='readonly'</c:if>  placeholder="请输入开户行"/></td>
			</tr>
			<tr>
				<td class="tit">开户支行：</td>
			<td><input type="text" id="banchname" name="banchname" value="${sub.isadmin==6?sub.qq:''}" <c:if test="${sub.isadmin==6}">readonly='readonly'</c:if> placeholder="请输入开户支行"/></td>
			</tr>			
 	 	</table>
 	 	<input type="hidden" id="subzh" name="subzh" value="${sub.subzh}"/>  
        <input type="hidden" id="orderno" name="orderno" />  
 	 	</form> 	
	</div>
	<div style="height: 2rem"></div>
	<a class="ok" href="javascript:void(0);" onclick="buy()" id="sbn">提交</a>
</div>
</body>
</html>