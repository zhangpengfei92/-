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
</head> 
<script type="text/javascript">
	<%-- var uid= "<%=session.getAttribute("SESSION_ACCOUNTID")%>"; 
	var username= "<%=session.getAttribute("SESSION_LOGINNAME")%>";  --%>
	var username= "<%=session.getAttribute("SESSION_LOGINNAME")%>"
	$(document).ready(function() {
		$.post("${path}/stockoption/stockoptionJump",{"str":"fundpc","username":username},function(data){
		})
	})
	
	//h5提现
	function txonclick(){
		window.location = "${path}/subzhfund/drawMoneyH5";
	}
	//充值
	 function chartonclick(){
		 window.location = "${path}/subzhfund/toH5";
	 }
	 //h5充值
	 function fiveonclick(){
		 window.location = "${path}/subzhfund/toPayH5";
	 }
	 
	 function wgonclick(){
		 window.location = "${path}/subzhfund/toH5";
	 }
	 function zjmxjump(){
		 window.location = "${path}/subzhfund/toH5";
	 }
</script>
<body class="hgray">
    <div class="category">
    <!-- insder header -->
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
                      <p class="sum"><span>账户余额</span><em>￥10000</em></p>
                  </div>
             </div>
             <a href="javascript:;" class="czbutton" onclick="chartonclick()">充值</a>
             <a href="javascript:;" class="czbutton" onclick="fiveonclick()">h5充值</a>
             <a href="javascript:;" class="czbutton" onclick="wgonclick()">网关充值</a>
             <a href="javascript:;" class="czbutton txbutton" onclick="txonclick()">提现</a>
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
              <li class="nav13" onclick="zjmxjump()">
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