<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

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
		debugger;
		var moneys =$.trim($("#Moneys").val());
    	if (moneys.length < 1 || moneys.length > 20) {
        	try {
				javatojs.showToast("请输入充值金额");
			} catch (e){ 
				javatojs.showToast("请输入充值金额");
        	}
            return false;
        }
    	var bFlag = true;
		if(!checkDouble(moneys, "充值金额")){
			bFlag = false;
	        return false;
	    }
		var bankcode=$("[name=bankcode]").val();
		if(bFlag){
			window.location.href="${path}/subzhfund/kpay/"+bankcode+"/"+moneys;
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
					   <input type="hidden" value="kjzf" id="Bankco">
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
								<input id="Moneys" name="Moneys" placeholder="请输入充值金额" onkeyup="checkNum(this.value)" onpaste="checkNum(this.value)" type="text"/>
							</li>
								<li>
                               <div class="bank">
                                   <p class="icontit2">请选择开户银行：
                                    <select name="bankcode" class="sel" id="bankcode">
                                    	<option value="0" selected="selected">==请选择开户银行==</option>
	                                    	<option value="ICBC">工商银行</option>
	                                    	<option value="CMBCHINA">招商银行</option>
	                                    	<option value="ABC">中国农业银行</option>
	                                    	<option value="CCB">建设银行</option>
	                                    	<option value="BCCB">北京银行</option>
	                                    	<option value="BOCO">交通银行</option>
	                                    	<option value="CMBC">中国民生银行</option>
	                                    	<option value="PINGANBANK">平安银行</option>
	                                    	<option value="CIB">兴业银行</option>
	                                    	<option value="NJCB">南京银行</option>
	                                    	<option value="CEB">光大银行</option>
	                                    	<option value="BOC">中国银行</option>
	                                    	<option value="CGB">广发银行</option>
	                                    	<option value="SHB">上海银行</option>
	                                    	<option value="SPDB">上海浦东发展银行</option>
	                                    	<option value="POST">中国邮政</option>
	                                    	<option value="CBHB">渤海银行</option>
	                                    	<option value="HKBEA">东亚银行</option>
	                                    	<option value="NBCB">宁波银行</option>
	                                    	<option value="ECITIC">中信银行</option>
	                                    	<option value="BJRCB">北京农村商业银行</option>
	                                    	<option value="HXB">华夏银行</option>
	                                    	<option value="CZ">浙商银行</option>
	                                    	<option value="HZBANK">杭州银行</option>
	                                    	<option value="NCBBANK">南洋商业银行</option>
	                                    	<option value="SCCB">河北银行</option>
	                                    	<option value="BOCDBANK">成都银行</option>
	                                    	<option value="HKB">汉口银行</option>
	                                    	<option value="OTHER">其他</option>
                                    </select>
                                 </p>
                                    <span></span></div>
                                </li>
							
								<input type="hidden" id="cardno" name="cardno" value="0000000000000000000" />
						   </ul>
					   </p>
					  </div>
		
                  
                 
                 <!-- <button class="rebut rebut2">确认支付</button>-->
             			<p><a href="javascript:void(0);" class="consu rebut" onclick="buy()">确认支付</a></p>
             </div>
             
    </section>
	</div>
</body>
</html>