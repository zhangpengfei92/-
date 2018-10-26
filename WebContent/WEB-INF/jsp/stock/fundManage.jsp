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
	<link type="text/css" href="${path}/css/css.css" rel="stylesheet"/>
	<link type="text/css" href="${path}/css/animation.css" rel="stylesheet"/>
	<link type="text/css" href="${path}/css/DateTimePicker.css" rel="stylesheet"/>
	
	<script type="text/javascript" src="${path}/js/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="${path}/js/DateTimePicker.js"></script>
	<script type="text/javascript" src="${path}/js/layer/layer/layer.js"></script>
	<script type="text/javascript" src="${path}/js/layui/layui.js"></script>
	<script type="text/javascript" src="${path}/js/All.js"></script>
	<script src="${path}/js/moment.js" type="text/javascript"></script>
</head> 
<script type="text/javascript">

	$(document).ready(function() {
		$.post("${path}/stockoption/stockoptionJump",{"str":"fundpc","username":username},function(data){
		})
	})

	function txonclick(){
		window.location = "${path}/stockoption/stockoptionJump?str=fundtxpc";
	}
	 function fiveonclick(){
		 window.location = "${path}/stockoption/stockoptionJump?str=h5paypc";
	 }
	 function zjmxjump(){
		 window.location = "${path}/stockoption/stockoptionJump?str=fundInfopc";
	 }
</script>
<body class="hgray">
    <div class="category">
     <header class="ls-header"> 
         <div class="ls-header-left"> 
             <a href="javascript:void(0)" onclick="trader()"><i class="iconfont icon-back"></i></a> 
         </div> 
         <div class="ls-header-title">资金</div>
		 <div class="ls-header-right" style="padding-right:1.0rem; width:6rem;">
            <a href="javascript:;" class="Goldmx" style="width:6rem; line-height:4rem;" onclick="zjmxjump()">资金明细</a>
         </div>
     </header> 
    <div class="mainbox">
        <div class="zjbox wbox">
             <div class="User">
                  <img src="${path}/images/zjzh.png">
                  <div class="Ugold">
                      <p class="tit">资金账户</p>
                      <p class="sum"><span>账户余额</span><em>￥${userinfo.xzj}</em></p>
                  </div>
             </div>
             <a href="javascript:;" class="czbutton" onclick="fiveonclick()">h5充值</a>
             <a href="javascript:;" class="czbutton txbutton" onclick="txonclick()">提现</a>
        </div>
    </div>
  </div>
</body>
</html>