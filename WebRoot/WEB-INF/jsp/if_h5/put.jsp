<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html> 
<head>
<meta charset="utf-8">
<title>H5提现</title>
<meta name="viewport" content="width=320,maximum-scale=1,user-scalable=no">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<!-- <meta content="telephone=no" name="format-detection"> -->
<meta name="format-detection" content="telephone=yes"/><!-- 打电话 -->
<link href="${path }/apppay/css/css.css" rel="stylesheet" type="text/css" />
<link href="${path }/apppay/css/animation.css" rel="stylesheet" type="text/css" />
<script src="${path }/apppay/js/jquery-1.9.1.min.js" type="text/javascript" ></script>
<script src="${path }/apppay/js/All.js" type="text/javascript"></script>
<script src="${path }/apppay/js/city.js" type="text/javascript"></script>
<script src="http://pv.sohu.com/cityjson?ie=utf-8"></script>

<style type="text/css">
	
	.sel{height:40px;
		padding-top:0.3rem;
		appearance: none;
		-webkit-appearance: none;
		-moz-appearance: none;
		}

</style>

<script type="text/javascript">
	function buy(){
		debugger;
		var amount = $.trim($("#amount").val());
    	if (amount.length < 1 || amount.length > 20) {
        	alert('请输入提现金额长度在2-20之间');
        	try {
				javatojs.showToast("请输入提现金额");
			} catch (e){ 
        		window.location.href = "alert://alertInfo?message=请输入提现金额";
        	}
            return false;
        }
    	var bFlag = true;
		if(!checkDouble(amount, "提现金额")){
			bFlag = false;
	        return false;
	    }
		
		
		var name = $.trim($("#name").val());
    	if (name.length < 1 || name.length > 20) {
   	
				javatojs.showToast("请输入姓名");
			
            return false;
        }
    	
    	var bankCardNumber = $.trim($("#bankCardNumber").val());
    	if (bankCardNumber.length < 1 || bankCardNumber.length > 20) {
        	alert('请输入银行卡号');
        	try {
				javatojs.showToast("请输入银行卡号");
			} catch (e){ 
        		window.location.href = "alert://alertInfo?message=请输入银行卡号";
        	}
            return false;
        }
		//根据下拉列表中的银行编号获取开户银行名称
 	 var bankcode=$("[name=bankcode]").val();
 	 
 	 var bstr=["ICBC","ABC","BOC","CCB","BCOM","CMB",
 		 "GDB","CITIC","CMBC","CEB",
 		 "PABC","SPDB","PSBC","HXB","CIB","BJBANK",
 		 "BJRCB","BOS","CBHB","CCQTGB","CSCB"];
 	 
 	 var strnum=bstr.indexOf(bankcode);
 	 var str=["工商银行","农业银行","中国银行","建设银行","交通银行"
 		 ,"招商银行","广东发展银行","中信银行","民生银行","光大银行",
 		 "平安银行","上海浦东发展银行","中国邮政储蓄银行","华夏银行","兴业银行",
 		 "北京银行","北京农商行","上海银行","渤海银行","重庆三峡银行","长沙银行"];

 	 var bankname=str[strnum]; 
 	 var banchname =$("#banchName").val();
     var phoneNum =$("#phoneNum").val();
     var idcard =$("#idcard").val();
     var province=$("#s_province").val();
     var city=$("#s_city").val();
    	
		if(bFlag){
			 $.ajaxSetup({async: false});
			 $.post("${path}/subzhfund/paya",{
				 "amount":amount,
				 "bankcode":bankcode,
				 "bankname":bankname,
				 "banchname":banchname,
				 "name":name,
				 "bankCardNumber":bankCardNumber,
				 "phoneNum":phoneNum,
				 "idcard":idcard,
				 "province":province,
				 "city":city
			 },function(msg){
				 console.log(msg);
				 if(msg=="ok"){
					 alert(msg+"--提现申请提交成功")
					 window.location.href="${path}/subzhfund/stockoptionJump";
				 }else{
					 alert(msg)
				 }
			 })
		}
	}
	
	//Double验证
	function checkDouble(strValue, strName) {
	   var pattern=/^[\-\+]?([0-9]\d*|0|[1-9]\d{0,2}(,\d{3})*)(\.\d+)?$/;
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
	

	//判断输入的金额是否为数字	
	function checkNum(num){
		 
		var b=true;
		if(isNaN(num)){
			alert("充值金额必须为数字");
			$("#txmoney").val("");
			return false;
		}		
		return b;
	}
</script>
</head> 
<body class="grey">
    <div class="category">
    <section class="phonewrap2">
           <div class="Monbox">
                   <div class="paymon">
                   <p class="num">账户资产：<p>
                   <fmt:formatNumber value="${money==null?0:money}" pattern="0.00"/>元 </p>             
                   </div>
             </div>
             <div class="paybox2">
                  <h3>提现</h3>
                  <div class="paymethod2">
                       <div class="paylist paylist2">
                       	
                            <ul>
                                <li>
                                    <div class="payicon wpayicon"><p class="icon02"><img src="${path }/apppay/images/jinb.png"></p><p class="icontit2">
                                    	提现金额：<input type="text" id="amount" name="amount" value="100" placeholder="请输入提现金额"
                                    	onkeyup="checkNum(this.value)" onpaste="checkNum(this.value)" />元</p><span></span></div>
                                </li>
                                <li>
                                    <div class="payicon wpayicon">
                                    <p class="icon02"></p>
                                    <p>请选择开户银行：
                                    <select name="bankcode" class="sel">
                                    	<option value="0" selected="selected">==请选择开户银行==</option>
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
                                 </p>
                                  <!--   <p class="icontit2">银行卡编号：<input type="text" id="bankcode" name="bankcode" value="" placeholder="银行卡编号"/> -->
                                    <span></span></div>
                                </li>
<!--                                 <li>
                                    <div class="payicon wpayicon"><p class="icon02"></p>
                                    <p class="icontit2">银行卡开户行名称：<input type="text" id="bankName" name="bankName" value="" placeholder="请输入银行卡开户行名称"/>
                                    </p><span></span></div>
                                </li> -->
                                
                                 <li>
                                    <div class="payicon wpayicon"><p class="icon02"></p>
                                    <p class="icontit2">银行卡开户支行名称：<input type="text" id="banchName" name="banchName" value="武汉支行" placeholder="请输入银行卡开户支行名称"/>
                                    </p><span></span></div>
                                </li>
                                
                                 <li>
                                    <div class="payicon wpayicon"><p class="icon02"></p>
                                    <p class="icontit2">收款人姓名：<input type="text" id="name" name="name" value="收款人" placeholder="请输入收款人姓名"/>
                                    </p><span></span></div>
                                </li>
                                
                                 <li>
                                    <div class="payicon wpayicon"><p class="icon02"></p>
                                    <p class="icontit2">收款人银行账号：<input type="text" id="bankCardNumber" name="bankCardNumber" value="6210265485748947458" placeholder="收款人银行账号"/></p>
                                    <span></span></div>
                                </li>
                                
                                   <li>
                                    <div class="payicon wpayicon"><p class="icon02"></p>
                                    <p class="icontit2">预留手机号：<input type="text" id="phoneNum" name="phoneNum" value="15118953197" placeholder="预留手机号"/>
                                    </p><span></span></div>
                                </li>
                                
                                   <li>
                                    <div class="payicon wpayicon"><p class="icon02"></p>
                                    <p class="icontit2">身份证号：<input type="text" id="idcard" name="idcard" value="420982199212236414" placeholder="请输入身份证号"/>
                                    </p><span></span></div>
                                </li>
                            
                            <li>
                             <p class="icon02"></p>

                           	<div class="fblineb" style="font-size: 0.30em;margin: 0 0 0 70px"> 请选择开户银行所在地：                             
                                 <select style="border:solid 1px #D9D9D9; margin-right: 10px" id="s_province" name="city" ></select>
                                 <select style="border:solid 1px #D9D9D9;" id="s_city" name="town"></select>
                            </div>
  
                             </li>  
                            </ul>
             				<div class="paymon">
	             				<p><a href="javascript:void(0);" class="consu" onclick="buy()">提交</a></p>
			                </div>
                      
                       </div>
                  </div>          
             </div>
            
    </section>
     </div>
</body>
<script type="text/javascript">
	_init_area();

</script>
</html>