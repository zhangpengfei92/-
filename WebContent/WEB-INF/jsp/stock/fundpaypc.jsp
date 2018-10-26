<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html> 
<head>
<meta charset="utf-8">
<title>H5支付</title>
<meta name="viewport" content="width=320,maximum-scale=1,user-scalable=no">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta content="telephone=no" name="format-detection">
<link href="${path }/apppay/css/css.css" rel="stylesheet" type="text/css" />
<link href="${path }/apppay/css/animation.css" rel="stylesheet" type="text/css" />
<script src="${path }/apppay/js/jquery-1.9.1.min.js" type="text/javascript" ></script>
<script src="${path }/apppay/js/All.js" type="text/javascript"></script>

<!-- 引入layui -->
<link rel="stylesheet" href="${path}/js/layui/css/layui.css"  media="all">
<script src="${path}/js/layui/layui.js" charset="utf-8"></script>

<script src="http://pv.sohu.com/cityjson?ie=utf-8"></script>
<script type="text/javascript">
	

	function buy(packId){
		var txmoney = $.trim($("#zhBalance").val());
    	if (txmoney.length < 1 || txmoney.length > 20) {
        	alert('请输入充值金额');
        	bFlag = false;
            return false;
        }
    	var bFlag = true;
		if(!checkDouble(txmoney, "充值金额")){
			bFlag = false;
	        return false;
	    }
		
		var username = $.trim($("#subzh").val());
		
		if(username==null||username==""){
			alert("请先登录");
			bFlag = false;
	        return false;
		}
		
		if(bFlag){
			 window.location = "${path}/fund/pcpayMent?username="+username+"&txmoney="+txmoney+"&channel=union";
		}
	}
	
	//Double验证
	function checkDouble(strValue, strName) {
	   var pattern=/^[\-\+]?([0-9]\d*|0|[1-9]\d{0,2}(,\d{3})*)(\.\d+)?$/;
	   if(!pattern.test(strValue)){
		   alert(strName + "的数值不正确！");
		   bFlag = false;
	  	   return false;
	   }
	   return true;
	}
	
	//登录
	function paylogin(){

		layui.use('layer', function() {
			//2.调用jquery模块
			var $ = layui.jquery;
			
			//3.调用layer模块
			layer = layui.layer;
			index=layer.open({
				type : 2,
				title : "充值登录",
				//不显示关闭按钮  右上角X   1为显示
				closeBtn : 2,
				//遮罩  透明度0-1  屏幕由原始亮度到最黑
				shade : [ 0.5 ],
				//坐标 弹出位置右下角
				//offset: 'rb', //右下角弹出  lt  rt  lb  rb
				anim : 0,//动画 
				area : [ '600px', '400px' ],
				content : '${path}/fund/topayLogin',
				end : function() {
					window.location.href="${path}/fund/toPaypc";
				}
			});
		}); 
	}
	
	//监听浏览器大小发生变化，让layui的弹框自适应
	 $(window).on("resize",function(){ 
	 		if(layui.layer && layui.layer!="undefined"){
	 			layui.layer.full(index);
	 		}
	 	    
	  });
</script>
</head> 
<body class="grey">
    <div class="category">
    <section class="phonewrap2">
             <div class="Monbox">
                   <div class="paymon">
                   <p>账户资产</p>
	                   <c:if test="${!empty subzh.subzh}">
	                  	 	<p class="num">${subzh.xzj}</p>
	                   		<p>当前用户：${subzh.subzh}</p>
	                   </c:if>
	                    <c:if test="${empty subzh.subzh}">
	                  	 	<p class="num">0.00</p>
	                   		<p><a href="javascript:;" class="consu" onclick="paylogin()">登录</a></p>
	                   </c:if>
                   </div>
             </div>
             <div class="paybox2">
                  <h3>充值</h3>
                  <div class="paymethod2">
                       <div class="paylist paylist2">
                        <form action="" id="infoInputForm" method="post">
                            <ul>
                                <li>
                                    <div class="payicon wpayicon"><p class="icon02"><img src="${path}/apppay/images/jinb.png"></p>
                                    <p class="icontit2">充值金额：<input type="text" id="zhBalance" name="zhBalance" value="" placeholder="请输入充值金额"/>元</p><span></span></div>
                                </li>
                            </ul>
             				<input type="hidden" id="subzh" name="subzh" value="${subzh.subzh}"/>
             				<div class="paymon">
	             				<p><a href="javascript:;" class="consu" onclick="buy()">提交</a></p>
			                </div>
                        </form>    
                       </div>
                  </div>
                  <h3>充值中如遇到任何问题，请联系客服电话<em>400-1027-727</em></h3>
             </div>
    </section>
  </div>  
</body>
</html>