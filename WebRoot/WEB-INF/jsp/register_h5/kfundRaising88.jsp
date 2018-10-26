<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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

<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/icon.css" />
<script type="text/javascript" src="${path}/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${path}/js/easyui/locale/easyui-lang-zh_CN.js"></script>

<!-- 引入layui -->
<link rel="stylesheet" href="${path}/layui/css/layui.css"  media="all">
<script src="${path}/layui/layui.js" charset="utf-8"></script>
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
		var amount = $.trim($("#amount").val());
		var minmoney = $.trim($("#minmoney").val());
		var maxmoney = $.trim($("#maxmoney").val());
    	if (amount.length < 1 || amount.length > 20) {
        	openwindows('请输入提现金额长度在2-20之间')
            return false;
        }
    	var bFlag = true;
		if(!checkDouble(amount, "提现金额")){
			bFlag = false;
	        return false;
	    }
		
		if(!isNaN(amount) && Number(amount)<=minmoney){
			openwindows("提现金额必须大于"+minmoney)
			return false;
		}
		
		if(!isNaN(amount) && Number(amount)<=maxmoney){
			openwindows("提现金额必须小于"+maxmoney)
			return false;
		}
		
		var fundbalance=$("#fund").val();
		
		if(fundbalance-amount<0){
			openwindows("余额不足")
			bFlag = false;
	        return false;
		}
		
		var name = $.trim($("#name").val());
    	if (name.length < 1 || name.length > 20) {
    		openwindows("请输入姓名")
			bFlag = false;
            return false;
        }
    	
    	var bankCardNumber = $.trim($("#bankCardNumber").val());
    	if (bankCardNumber.length < 1 || bankCardNumber.length > 20) {
    		openwindows("请输入银行卡号")
            return false;
        }
	//根据下拉列表中的银行编号获取开户银行名称
 	 var bankcode=$("[name=bankcode]").val();
 	 var bankname=str[strnum]; 
 	 var banchname =$("#banchName").val();
     var phoneNum =$("#phoneNum").val();
     var idcard =$("#idcard").val();
     var province=$("#s_province").val();
     var city=$("#s_city").val();
      if("省份"==province || "地级市"==city){
    	  openwindows("开户银行所在地必须选择")  
       	return false;
       }	
		if(bFlag){
			 $.ajaxSetup({async: false});
			 $.post("${path}/subzhfund/savePay",{
				 "amount":amount,
				 "bankcode":bankcode,
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
					 layui.use('layer',function(){
							//2.调用jquery模块
							var $ = layui.jquery,
							//3.调用layer模块
							layer = layui.layer;
					 		layer.confirm(msg+"--提现申请提交成功", {icon: 3, title:'提示'}, function(index){							  
						 		window.location.href="${path}/subzhfund/stockoptionJump"
						});
					 });		
				 }else{
					 openwindows(msg)
				 }
			 })
		}
	}
	
	//Double验证
	function checkDouble(strValue, strName) {
	   var pattern=/^[\-\+]?([0-9]\d*|0|[1-9]\d{0,2}(,\d{3})*)(\.\d+)?$/;
	   if(!pattern.test(strValue)){
		   alert(strName + "的数值不正确！");
		   openwindows(strName + "的数值不正确！")
	  	   return false;
	   }
	   return true;
	}

	//当点通过后，出现悬浮框悬浮框
	function openwindows(str) {
				layui.use('layer',function(){
					//2.调用jquery模块
					var $ = layui.jquery,
					//3.调用layer模块
					layer = layui.layer;				
				      layer.open({
				          type: 1
				          ,title: false
				          ,offset: 'auto' 
				          ,id: 'layerDemo'+'auto'//防止重复弹出
				          ,content: '<div style="padding: 20px 100px;">'+ str +'</div>'	
				          ,btn: '确定'
				          ,btnAlign: 'c' //按钮居中
				          ,shade: 0 //不显示遮罩
				          ,closeBtn : 0
				          ,yes: function(){
				            layer.closeAll();
				          }
				        });
				}); 
			}
	
	//询问框
	function notice(smsg,url){
		layui.use('layer',function(){
			//2.调用jquery模块
			var $ = layui.jquery,
			//3.调用layer模块
			layer = layui.layer;				
		     layer.open({
		         type: 1
		         ,title: false //不显示标题栏
		         ,closeBtn: false
		         ,area: '300px;'
		         ,shade: 0.8
		         ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
		         ,btn: ['确认', '取消']
		         ,btnAlign: 'c'
		         ,moveType: 1 //拖拽模式，0或者1
		         ,content: '<div style="padding: 20px 100px;">'+ smsg +'</div>'
		         ,success: function(layero){
		           var btn = layero.find('.layui-layer-btn');
		           btn.find('.layui-layer-btn0').attr({
		             href:url
		             ,target: '_blank'
		           });
		         }
		       });
		});
	}
	
</script>
</head> 
<body class="grey">
    <div class="category">
    <section class="phonewrap2">
           <div class="Monbox">
                   <div class="paymon">
                   <p class="num">账户资产：<p>
                   <fmt:formatNumber value="${sub.fundbalance==null?0:sub.fundbalance}" pattern="0.00"/>  元（人民币）</p>             
                   </div>
                  <input type="hidden" id="fund" value="<fmt:formatNumber value="${sub.fundbalance==null?0:sub.fundbalance}" pattern="0.00"/>">
				  <input type="hidden" id="maxmoney" value="${fundset.maxmoney}"/>
				   <input type="hidden" id="minmoney" value="${fundset.minmoney}"/>
             </div>
             <div class="paybox2">
                  <h3>提现</h3>
                  <div class="paymethod2">
                       <div class="paylist paylist2">
                       	
                            <ul>
                                <li>
                                    <div class="payicon wpayicon"><p class="icon02"><img src="${path }/apppay/images/jinb.png"></p><p class="icontit2">
                                    	提现金额：<input type="text" id="amount" name="amount" value="" placeholder="请输入提现金额"/>元（人民币）</p><span></span></div>
                                </li>
                                <li>
                                    <div class="payicon wpayicon">
                                    <p class="icon02"></p>
                                    <p>请选择开户银行：
                                    <select name="bankcode" class="sel">
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
                                  <!--   <p class="icontit2">银行卡编号：<input type="text" id="bankcode" name="bankcode" value="" placeholder="银行卡编号"/> -->
                                    <span></span></div>
                                </li>
                                
                                 <li>
                                    <div class="payicon wpayicon"><p class="icon02"></p>
                                    <p class="icontit2">开户支行名称：<input type="text" id="banchName" name="banchName" value="${sub.qq}" placeholder="请输入银行卡开户支行名称"/>
                                    </p><span></span></div>
                                </li>
                                
                                 <li>
                                    <div class="payicon wpayicon"><p class="icon02"></p>
                                    <p class="icontit2">收款人姓名：<input type="text" id="name" name="name" value="${sub.name}" placeholder="请输入收款人姓名"/>
                                    </p><span></span></div>
                                </li>
                                
                                 <li>
                                    <div class="payicon wpayicon"><p class="icon02"></p>
                                    <p class="icontit2">收款人银行账号：<input type="text" id="bankCardNumber" name="bankCardNumber" value="${sub.bankCard}" placeholder="收款人银行账号"/></p>
                                    <span></span></div>
                                </li>
                                
                                   <li>
                                    <div class="payicon wpayicon"><p class="icon02"></p>
                                    <p class="icontit2">预留手机号：<input type="text" id="phoneNum" name="phoneNum" value="${sub.phone}" placeholder="预留手机号"/>
                                    </p><span></span></div>
                                </li>
                                
                                   <li>
                                    <div class="payicon wpayicon"><p class="icon02"></p>
                                    <p class="icontit2">身份证号：<input type="text" id="idcard" name="idcard" value="${sub.idNo}" placeholder="请输入身份证号"/>
                                    </p><span></span></div>
                                </li>
                            
                            <li>
                             <p class="icon02"></p>

                            <div class="fblineb" style="font-size: 15px;margin: 0 0 0 45px">开户所在地：                             
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