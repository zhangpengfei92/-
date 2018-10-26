<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<title></title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" />
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta content="telephone=no" name="format-detection">
    <link href="${path}/css/css.css" rel="stylesheet" type="text/css" />
    <link href="${path}/css/animation.css" rel="stylesheet" type="text/css" />
    <link href="${path}/css/DateTimePicker.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${path}/js/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="${path}/js/DateTimePicker.js"></script>
	<script type="text/javascript" src="${path}/js/layer/layer/layer.js"></script>
	<script type="text/javascript" src="${path}/js/layui/layui.js"></script>
    <script type="text/javascript" src="${path}/js/All.js" ></script>
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
	 var bankaccname = $.trim($("#bankaccname").val());
	 var bankcardNum = $.trim($("#bankcardNum").val());
	 var openbankname = $.trim($("#openbankname").val());
	 var txmoney = $.trim($("#txmoney").val());
	 if(bankaccname == null || bankaccname == ""){
		 layer.msg("账户名不能为空");
		 return;
	 }
	 if(bankcardNum == null || bankcardNum == ""){
		 layer.msg("银行卡号不能为空");
		 return;
	 }
	 if(openbankname == null || openbankname == ""){
		 layer.msg("开户行不能为空");
		 return;
	 }
	 if(txmoney == null || txmoney == ""){
		 layer.msg("提现金额不能为空");
		 return;
	 }
	 
	 $.post("${path}/subzhfund/incarnate",{"username":username,"bankaccname":bankaccname,"bankcardNum":bankcardNum,"openbankname":openbankname,"txmoney":txmoney,},function(data){
		 if(data.code == 0){
			 	layer.msg(data.message);
			 	setTimeout(jump(), 2000);
	    	}else{
	    		layer.msg(data.message);
	 	    }
	 })
 	}
	function jump(){
		window.location = "${path}/stockoption/stockoptionJump?str=fundtx";
	}
 

</script>
<body class="hgray">
    <div class="category">
    <!-- insder header -->
    <div class="mainbox">
        <div class="zjbox wbox">
        	<div class="User">
                  <img src="${path}/images/zjzh.png">
                  <div class="Ugold">
                      <p class="tit">资金账户</p>
                      <p class="sum"><span>账户余额</span><em>￥${userinfo.xzj}</em></p>
                  </div>
             </div>
             <div class="Uzhao">
                 <ul>
                    <li>
                       <label>账户名</label>
                       <input type="text" id="bankaccname" name="bankaccname" placeholder="请输入姓名">
                    </li>
                    <li>
                       <label>银行卡号</label>
                       <input type="text" id="bankcardNum" name="bankcardNum" placeholder="请输入银行卡号">
                    </li>
                    <li>
                       <label>开户行</label>
                       <input type="text" id="openbankname" name="openbankname" placeholder="请输入开户行">
                    </li>
                    <li style="position:relative;">
                       <label>提现金额</label>
                       <input type="text" id="txmoney" name="txmoney" placeholder="请输入提现金额">
                       <em>元</em>
                    </li>
                 </ul>
             </div>
             <a href="javascript:;" class="czbutton" onclick="tixiansubmit()">提交</a>
        </div>
    </div>
  </div>
</body>
</html>