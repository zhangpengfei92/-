<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="../../../head.jsp"%>
<head>
	<meta charset="utf-8">
	<title></title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" />
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta content="telephone=no" name="format-detection">
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
	  $("#bankflownum").bind("keypress", function(event) {         
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
	 var bankflownum = $.trim($("#bankflownum").val());
	 var txmoney = $.trim($("#txmoney").val());
	 if(txmoney == null || txmoney == ""){
		 layer.msg("充值金额不能为空");
		 return;
	 }
	 if(parseFloat(txmoney) > parseFloat(50000)){
		 layer.msg("充值限额5万");
		 return;
	 }
	 window.location = "${path}/subzhfund/payMentWG?username="+username+"&txmoney="+txmoney;
 	}
	function jump(){
		window.location = "${path}/stockoption/stockoptionJump?str=payMent";
	}
 

</script>
<body class="hgray">
    <div class="category">
     <header class="ls-header"> 
         <div class="ls-header-left"> 
             <a href="javascript:void(0)" onclick="zjmx()"><i class="iconfont icon-back"></i></a> 
         </div> 
         <div class="ls-header-title">充值</div> 
     </header> 
    <div class="mainbox">
        <div class="zjbox">
             <div class="Uzhao">
                 <ul>
                    <li style="position:relative;">
                       <label>充值金额</label>
                       <input type="text" id="txmoney" name="txmoney" placeholder="请输入充值金额">
                       <em>元</em>
                    </li>
                 </ul>
             </div>
             <a href="javascript:;" class="czbutton" onclick="tixiansubmit()">提交</a>
        </div>
    </div>
    <div class="homebottom">
         <ul>
              <li class="nav01" onclick="hangqing()">
                  <a href="javascript:;" >
                      <i></i>
                      <span >行情</span>
                  </a>
              </li>
              <li class="nav02" onclick="trader()">
                  <a href="javascript:;"  >
                      <i></i>
                      <span >交易</span>
                  </a>
              </li>
              <li class="nav13" onclick="zjmx()">
                  <a href="javascript:;" class="on">
                      <i></i>
                      <span >资金</span>
                  </a>
              </li>
              <li class="nav04" onclick="helpCenter()">
                  <a href="javascript:;" >
                      <i></i>
                      <span >帮助</span>
                  </a>
              </li>
              <li class="nav05" onclick="personal()">
                  <a href="javascript:;" >
                      <i></i>
                      <span>我的</span>
                  </a>
              </li>
         </ul>
    </div>
    <%@include file="../../../foot.jsp"%>
  </div>
</body>
</html>