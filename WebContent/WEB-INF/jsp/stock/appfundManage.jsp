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
    <script type="text/javascript" src="${path}/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="${path}/js/All.js" ></script>
    <script type="text/javascript" src="${path}/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="${path}/js/DateTimePicker.js"></script>
	<script type="text/javascript" src="${path}/js/layer/layer/layer.js"></script>
	<script type="text/javascript" src="${path}/js/layui/layui.js"></script>
</head> 
<script type="text/javascript">
function txonclick(){
	window.location = "${path}/stockoption/stockoptionJump?str=fundtxpc";
}
 function fiveonclick(){
	 window.location = "${path}/stockoption/stockoptionJump?str=h5paypc";
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
     		 <a href="javascript:;" class="czbutton" onclick="fiveonclick()">h5充值</a>
             <a href="javascript:;" class="czbutton txbutton" onclick="txonclick()">提现</a>
        </div>
    </div>
    <div class="Tsbox">
      <p>温馨提示：</p>
      <p>1、推荐使用线下对公账户转账（秒到）；</p>
      <p>2、手机快捷支付（小额）；</p>
      <p>3、大额资金建议在电脑网关支付，手机银行支付；</p>
      <p>4、线下银行账号对公充值后，请认真填写充值金额，打款流水号，点击线下充值，以便财务客户人员后台审核。</p>
    </div>
  </div>
</body>
</html>