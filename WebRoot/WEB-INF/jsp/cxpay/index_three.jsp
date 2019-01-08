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
<link href="${path }/css/pay/css.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/icon.css" />
<script src="${path}/apppay/js/jquery-1.9.1.min.js" type="text/javascript" ></script>
<script type="text/javascript" src="${path}/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${path}/js/easyui/locale/easyui-lang-zh_CN.js"></script>
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

</style>
<script src="http://pv.sohu.com/cityjson?ie=utf-8"></script>
<script type="text/javascript">

	$("#Moneys").bind("keypress", function(event) {
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
	
	function buy(){
		var moneys =$.trim($("#Moneys").val());
		var bFlag = true;
		if(moneys<10){
			$.messager.alert('提示',"充值金额10元起",'info');
			bFlag = false;
	        return false;
		}
		
		//moneys=moneys*100;
		
    	if (moneys.length < 1 || moneys.length > 20) {
    		$.messager.alert('提示',"请输入充值金额",'info');
    		bFlag = false;
            return false;
        }
    	
		if(!checkDouble(moneys, "充值金额")){
			bFlag = false;
	        return false;
	    }
		var cardno =$.trim($("#cardno").val());
		if(cardno==""||cardno.length<16){
			$.messager.alert('提示',"请输入银行卡号",'info');
			bFlag = false;
	        return false;
		}		
		if(bFlag){
			$("#total_fee").val(moneys);
			$("#bankcardnumber").val(cardno);
			$("#payfrm").submit();
		}
	}
	
	//Double验证
	function checkDouble(strValue, strName) {
	   var pattern=/^[\-\+]?([0-9]\d*|0|[1-9]\d{0,2}(,\d{3})*)(\.\d+)?$/;
	   if(!pattern.test(strValue)){
		   $.messager.alert('提示',strName + "的数值不正确！",'info');
		   
	  	   return false;
	   }
	   return true;
	}
	
	//判断输入的金额是否为数字
	function checkNum(num){
		 
		var b=true;
		if(isNaN(num)){

			$.messager.alert('提示',"充值金额必须为数字",'info');

			$("#Moneys").val("");
			return false;
		}		
		return b;
	}
	
</script>

</head>
<body class="grey">
    <div class="category">
    <!-- insder header -->
    
    <section class="phonewrap2">
		
             <div class="Monbox">
				 <div class="ls-header-title">充值</div>
                   <div class="paymon">
					   <p>
						   <ul>
							<li>
							   <i class="mtit">充值金额</i>
							</li>
							 <div class="line"></div>  
							<li>
							   <i class="rmb">￥</i>
							</li>
							 <li>
								<input id="Moneys" name="Moneys" placeholder="请输入充值金额" onkeyup="checkNum(this.value)" value="${total_fee}" onpaste="checkNum(this.value)" type="text"/>
							</li>
							<div class="line"></div> 
							 <li>
								<input id="cardno" name="cardno" placeholder="请输入银行账号" value="" type="text"/>
							</li>															
						   </ul>
					   </p>					   
					  </div> 

             			<p><a href="javascript:void(0);" class="consu rebut" onclick="buy()">确认支付</a></p>
             </div>
             
    </section>
    <form id="payfrm" action="${path}/secondpay/paythree" method="post">
    	<input type="hidden" id="subzh" name="subzh" value="${subzh}">
    	<input type="hidden" id="total_fee" name="total_fee" value="">
    	<input type="hidden" id="bankcardnumber" name="bankcardnumber" value="">
    	<input type="hidden" id="sdorderno" name="sdorderno" value="${sdorderno}">
    </form>
	</div>
</body>
</html>