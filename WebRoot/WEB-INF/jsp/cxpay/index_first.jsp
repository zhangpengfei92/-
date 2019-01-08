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
		
		if(moneys<10){
			$.messager.alert('提示',"充值金额10元起",'info');
			bFlag = false;
	        return false;
		}
		
		//moneys=moneys*100;
		
    	if (moneys.length < 1 || moneys.length > 20) {
    		$.messager.alert('提示',"请输入充值金额",'info');
            return false;
        }
    	var bFlag = true;
		if(!checkDouble(moneys, "充值金额")){
			bFlag = false;
	        return false;
	    }
		var bankcode = $.trim($(".sel").val());
		if(bankcode==""||bankcode.length<=0){
			$.messager.alert('提示',"必须选择开户银行",'info');
			bFlag = false;
	        return false;
	    }
		if(bFlag){
			$("#bankcode").val(bankcode);
			$("#total_fee").val(moneys);
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
								<input id="Moneys" name="Moneys" placeholder="请输入充值金额" value="${total_fee}" onkeyup="checkNum(this.value)" onpaste="checkNum(this.value)" type="text"/>
							</li>

						   </ul>
					   </p>
					   <br> <br> <br>
					   <p class="icontit2">请选择开户银行：
					   <select name="bankco" class="sel">
	                          <option value="0" selected="selected">==请选择开户银行==</option>
	                          <option value="ICBC" <c:if test="${fn:contains(sub.bank,'工商')}">selected="selected"</c:if> >工商银行</option>                         
	                          <option value="CMBCHINA" <c:if test="${fn:contains(sub.bank,'招商')}">selected="selected"</c:if> >招商银行</option>
	                          <option value="ABC" <c:if test="${fn:contains(sub.bank,'农业')}">selected="selected"</c:if> >中国农业银行</option>
	                          <option value="CCB" <c:if test="${fn:contains(sub.bank,'建设')}">selected="selected"</c:if> >建设银行</option>
	                          <option value="BCCB"  <c:if test="${fn:contains(sub.bank,'北京')}">selected="selected"</c:if> >北京银行</option>
	                          <option value="BOCO" <c:if test="${fn:contains(sub.bank,'交通')}">selected="selected"</c:if>>交通银行</option>
	                          <option value="CMBC"<c:if test="${fn:contains(sub.bank,'民生')}">selected="selected"</c:if>>中国民生银行</option>
	                          <option value="PINGANBANK"<c:if test="${fn:contains(sub.bank,'平安')}">selected="selected"</c:if>>平安银行</option>
	                          <option value="CIB"<c:if test="${fn:contains(sub.bank,'兴业')}">selected="selected"</c:if>>兴业银行</option>
	                          <option value="NJCB"<c:if test="${fn:contains(sub.bank,'南京')}">selected="selected"</c:if>>南京银行</option>
	                          <option value="CEB"<c:if test="${fn:contains(sub.bank,'光大')}">selected="selected"</c:if>>光大银行</option>
	                          <option value="BOC"<c:if test="${fn:contains(sub.bank,'中国')}">selected="selected"</c:if>>中国银行</option>
	                          <option value="CGB"<c:if test="${fn:contains(sub.bank,'广发')}">selected="selected"</c:if>>广发银行</option>
	                          <option value="SHB"<c:if test="${fn:contains(sub.bank,'上海')}">selected="selected"</c:if>>上海银行</option>
	                          <option value="SPDB"<c:if test="${fn:contains(sub.bank,'浦东')}">selected="selected"</c:if>>上海浦东发展银行</option>
	                          <option value="POST"<c:if test="${fn:contains(sub.bank,'邮政')}">selected="selected"</c:if>>中国邮政</option>
	                          <option value="CBHB"<c:if test="${fn:contains(sub.bank,'海波')}">selected="selected"</c:if>>渤海银行</option>
	                          <option value="HKBEA"<c:if test="${fn:contains(sub.bank,'东亚')}">selected="selected"</c:if>>东亚银行</option>
	                          <option value="NBCB"<c:if test="${fn:contains(sub.bank,'宁波')}">selected="selected"</c:if>>宁波银行</option>
	                          <option value="ECITIC"<c:if test="${fn:contains(sub.bank,'中信')}">selected="selected"</c:if>>中信银行</option>
	                          <option value="BJRCB"<c:if test="${fn:contains(sub.bank,'农村商业')}">selected="selected"</c:if>>北京农村商业银行</option>
	                          <option value="HXB"<c:if test="${fn:contains(sub.bank,'华夏')}">selected="selected"</c:if>>华夏银行</option>
	                          <option value="CZ"<c:if test="${fn:contains(sub.bank,'浙江')}">selected="selected"</c:if>>浙商银行</option>
	                          <option value="HZBANK"<c:if test="${fn:contains(sub.bank,'杭州')}">selected="selected"</c:if>>杭州银行</option>
	                          <option value="NCBBANK"<c:if test="${fn:contains(sub.bank,'南洋')}">selected="selected"</c:if>>南洋商业银行</option>
	                          <option value="SCCB"<c:if test="${fn:contains(sub.bank,'河北')}">selected="selected"</c:if>>河北银行</option>
	                          <option value="BOCDBANK"<c:if test="${fn:contains(sub.bank,'成都')}">selected="selected"</c:if>>成都银行</option>
	                          <option value="HKB"<c:if test="${fn:contains(sub.bank,'汉口')}">selected="selected"</c:if>>汉口银行</option>
	                          <option value="OTHER">其他</option>
	                      </select>
					   </p>
					  </div> 

             			<p><a href="javascript:void(0);" class="consu rebut" onclick="buy()">确认支付</a></p>
             </div>
             
    </section>
    <form id="payfrm" action="${path}/cxpay/pay" method="post">
    	<input type="hidden" id="subzh" name="subzh" value="${subzh}">
    	<input type="hidden" id="total_fee" name="total_fee" value="">
    	<input type="hidden" id="bankcode" name="bankcode" value="">
    	<input type="hidden" id="sdorderno" name="sdorderno" value="${sdorderno}">
    </form>
	</div>
</body>
</html>