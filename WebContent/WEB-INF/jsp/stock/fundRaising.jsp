<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="../../../head.jsp"%>
<head>
<meta charset="utf-8">
<title></title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta content="telephone=no" name="format-detection">
<link href="${path }/apppay/css/css.css" rel="stylesheet" type="text/css" />
<link href="${path }/apppay/css/animation.css" rel="stylesheet" type="text/css" />
<script src="${path }/apppay/js/jquery-1.9.1.min.js" type="text/javascript" ></script>
<script src="${path }/apppay/js/All.js" type="text/javascript"></script>
<script src="${path }/apppay/js/city.js" type="text/javascript"></script>
<script src="http://pv.sohu.com/cityjson?ie=utf-8"></script>

<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/icon.css" />
<script type="text/javascript" src="${path}/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${path}/js/easyui/locale/easyui-lang-zh_CN.js"></script>

<style type="text/css">
	
	.sel{height:40px;
		padding-top:0.3rem;
		appearance: none;
		font-size:1.6rem;
		-webkit-appearance: none;
		-moz-appearance: none;
		}

</style>

</head>
<script type="text/javascript">
var uid= "<%=session.getAttribute("SESSION_ACCOUNTID")%>"; 
var username= "<%=session.getAttribute("SESSION_LOGINNAME")%>"; 
$(document).ready(function() {
	$("#txmoney").bind("keypress", function(event) {
	    var event= event || window.event;  
	    var getValue = $(this).val();  
	    //控制只能输入的值  
	    if (event.which && (event.which < 48 || event.which > 57) && event.which != 8 && event.which != 46) {  
	        event.preventDefault();  
	         return;  
	    }
	    if (getValue.length == 1 && getValue.substring(0,1) == "0" && event.which != 46) {  
	        event.preventDefault();  
	        return;  
	    }
	  	//控制只能输入一个小数点"."  
	    if (getValue.indexOf('.') != -1 && event.which == 46) {  
	        event.preventDefault();   
	        return;  
	    }
	  	//小数点后面只能输2位
	    if(getValue.indexOf('.') != -1 && event.which != 46){
	    	var arr = getValue.split(".");
		    if(arr[1].length > 1){
		    	event.preventDefault();  
		        return; 
		    }
	    }
	 })
	 $("#bankcardNum").bind("keypress", function(event) {
	    var event= event || window.event;  
	    var getValue = $(this).val();  
	    //控制只能输入的值  
	    if (event.which && (event.which < 48 || event.which > 57) && event.which != 8 ) {  
	        event.preventDefault();  
	         return;  
	    }
	 })
})
 function tixiansubmit(){
	var bFlag = true;
	var amount = $.trim($("#amount").val());
 	if (amount.length < 1 || amount.length > 20) {
    	$.messager.alert('提示',"请输入提现金额",'info');
    	bFlag=false;
         return false;
     }
	 
 	if(isNaN(amount)){

		$.messager.alert('提示',"提现金额必须为数字",'info');

		$(amount).val("");
		bFlag=false;
		return false;
	}
 	
	if(amount<3){

		$.messager.alert('提示',"提现金额必须大于3元",'info');

		$(amount).val("");
		
		bFlag=false;
		
		return false;
	}
	
	if(amount>40000){

		$.messager.alert('提示',"提现金额单笔必须小于40000",'info');

		$(amount).val("");
		
		bFlag=false;
		
		return false;
	}
 	
 	
	var fundbalance=$("#fund").val();
	
	if(fundbalance-amount<0){
		$.messager.alert('提示',"余额不足",'info');
		bFlag = false;
        return false;
	}
 	
 	 var cardname =$("#cardname").val();
	if (cardname.length < 1 || cardname.length > 20) {
	
		$.messager.alert('提示',"请输入姓名",'info');
		bFlag=false;
        return false;
    }
	
	
	
	var cardno = $.trim($("#cardno").val());
	if (cardno.length!=19){
    $.messager.alert('提示',"银行卡号不能为空",'info');
   		bFlag=false;
        return false;
    }
 	
	var bankbranch=$("#bankbranch").val();
	if (bankbranch.length<1){
	    $.messager.alert('提示',"请输入开户支行名称",'info');
	    	bFlag=false;
	        return false;
	    }
	
	var cardmobile =$("#cardmobile").val();
	if (cardmobile.length!=11){
	    $.messager.alert('提示',"手机号输入有误",'info');
	    	bFlag=false;
	        return false;
	  }
	
	 var bankobj=document.getElementById("bankcode");
 	 var bankcode=bankobj.value;
 	 var index=bankobj.selectedIndex;//获取当前选择项的索引.
 	 var bankname=bankobj.options[index].text;//获取当前选择项的文本.
 	 
 	if (bankcode=="0"){
	    $.messager.alert('提示',"请选择开户银行",'info');
	    	bFlag=false;
	        return false;
	    }
 	 
     var province=$("#s_province").val();
     var city=$("#s_city").val();	
     

     var cardmobile =$("#cardmobile").val();
     var certid =$("#certid").val();
     
     if("省份"==province || "地级市"==city){
      	$.messager.alert('提示',"开户银行所在地必须选择",'info');
      	return false;
      }	
     if(bFlag){
	 $.post("${path}/subzhfund/paya",{
		 "amount":amount,
		 "bankcode":bankcode,
		 "bankname":bankname,
		 "bankbranch":bankbranch,
		 "cardname":cardname,
		 "cardno":cardno,
		 "cardmobile":cardmobile,
		 "certid":certid,
		 "province":province,
		 "city":city
	 },function(data){
		 if(data=="ok"){
			 $.messager.confirm('提示',"本次提现申请提交成功,如需再次提现，请半小时后操作", function(r){
					if (r){
						 jump();
					}
				});	
			
		 }else{
			 alert(data.substring(6));
		 }
	 })
 	}
}



	function jump(){
		window.location = "${path}/subzhfund/stockoptionJump";
	}

	

</script>
<body class="hgray">
	<div class="category">
		<!-- insder header -->
		<header class="ls-header">
		<div class="ls-header-left">
			<a href="javascript:void(0)" onclick="zjmx()"><i
				class="iconfont icon-back"></i></a>
		</div>
		<div class="ls-header-title">提现</div>
	 </header>
		<div class="mainbox">
			<div class="zjbox wbox">
				<div class="User">
					<img src="${path}/images/zjzh.png">
					<div class="Ugold">
						<p class="tit">资金账户</p>
						<p class="sum">
							<span>账户余额</span><em>￥${userinfo.xzj}</em>
						</p>
						<input type="hidden" id="fund" value="${userinfo.xzj}">
					</div>
				</div>
				<div class="Uzhao">
					<div class="search">
						<ul>
							<li><label>金额</label> <input type="text" id="amount"
								name="amount" placeholder="请输入金额"></li>
							   <li>
                                    <label>请选择开户银行</label>
                                    <select name="bankcode" class="sel" id="bankcode">
                                    	<option value="0">==请选择开户银行==</option>
                                    	<option value="ICBC">工商银行</option>
                                    	<option value="ABC">农业银行</option>
                                    	<option value="BOC">中国银行</option>
                                    	<option value="CCB">建设银行</option>
                                    	<option value="BCOM">交通银行</option>
                                    	<option value="CMB">招商银行</option>
                                    	<option value="GDB">广东发展银行</option>
                                    	<option value="CITIC">中信银行</option>
                                    	<option value="CMBC">民生银行</option>
                                    	<option value="CEB">光大银行</option>
                                    	<option value="PABC">平安银行</option>
                                    	<option value="SPDB">上海浦东发展银行</option>
                                    	<option value="PSBC">中国邮政储蓄银行</option>
                                    	<option value="HXB">华夏银行</option>
                                    	<option value="CIB">兴业银行</option>
                                    	<option value="BJBANK">北京银行</option>
                                    	<option value="BJRCB">北京农商行</option>
                                    	<option value="BOS">上海银行</option>
                                    	<option value="CBHB">渤海银行</option>
                                    	<option value="CCQTGB">重庆三峡银行</option>
                                    	<option value="CSCB">长沙银行</option>
                                    </select>
                                </li>
							<li><label>银行卡开户支行名称</label> <input type="text"
								id="bankbranch" name="bankbranch" placeholder="请输入银行卡开户支行名称">
							</li>
							<li><label>收款人姓名</label> <input type="text" id="cardname"
								name="cardname" placeholder="请输入收款人姓名"></li>
							<li><label>收款人银行账号</label> <input type="text" id="cardno"
								name="cardno" placeholder="收款人银行账号"></li>
							<li><label>预留手机号</label> <input type="text" id="cardmobile"
								name="cardmobile" placeholder="银行预留手机号"></li>
							<li><label>身份证号</label> <input type="text" id="certid"
								name="certid" placeholder="身份证号"></li>
							<li> <label>开户所在地：</label>                          
                                 <select style="border:solid 1px #D9D9D9; margin-right: 10px" id="s_province" name="city" ></select>
                                 <select style="border:solid 1px #D9D9D9;" id="s_city" name="town"></select>
                       </li>																				
						</ul>
					</div>
					 	
				</div>
				<a href="javascript:;" class="czbutton" onclick="tixiansubmit()">提交</a>
			</div>
		</div>
	</div>
	
</body>
<script type="text/javascript">
	_init_area();

</script>
</html>