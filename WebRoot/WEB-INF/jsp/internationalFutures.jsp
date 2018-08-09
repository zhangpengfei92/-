<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>中金宸大</title>
<link href="${staticpath}/css/css.css" rel="stylesheet" type="text/css" />
<script src="${staticpath}/js/jquery1.42.min.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function () {	
	//去掉所有的导航栏高亮显示样式
	$(".Zlogo ul li a ").each(function () {  
			$(this).removeClass("on");  
		}); 
	//被导航栏选中高亮显示
	$("#internationalFutures").addClass("on");
});
</script>

</head>
<body>
<%@include file="../../top.jsp"%>
<!-- banner start-->
<div class="banner">
    <div class="flexslider">
        <ul class="slides">
            <li style="background:url(${staticpath}/images/gbanner.png) 50% 0 no-repeat;"></li>
        </ul>
    </div> 
</div> 
<!-- banner end--> 
<div class="main">
   <div class="Mbox">
       <div class="Goldbox">
          <div class="left">
              <p class="tit">保证金交易，只需<span>1.5%</span>投入</p>
              <p style="padding-top:40px;">以美国原油为例。中金投资每标准手美国原油交易为1,000桶 (BBL)，以50美元/桶计算，价值$50,000。</p>
              <p style="padding-bottom:40px;">客户通过中金投资交易1个标准手美国原油，只需支付1.5%的保证金，即$750保证金。</p>
              <p class="tit">超强盈利能力，可获<span>200%</span>以上收益</p>
              <p>客户投入$750，买入1,000桶。当日原油每桶涨2美元。1,000桶原油则盈利$2,000。盈利高达266%</p>
           </div>
           <div class="right">
             <img src="${staticpath}/images/gold.png" />
           </div>
       </div>
    </div>
    <div class="Mbox">
       <h3>得天独厚平台优势</h3>
       <ul class="advant">
          <li><img src="${staticpath}/images/adicon01.png" /></li>
          <li><img src="${staticpath}/images/adicon02.png" /></li>
          <li><img src="${staticpath}/images/adicon03.png" /></li>
          <li><img src="${staticpath}/images/adicon04.png" /></li>
       </ul>
    </div>
    <div class="Mbox">
       <h3>国际期货投资案例</h3>
       <div class="Case">
           <p class="big">李先生的账户类型是：专业账户，活动期间，李先生交易白银参加活动，周交易大于15手，可获得的周奖励：</p>
           <p class="redbg">善用优惠获利，财富增值快速增长</p>
           <div>
               <p>李先生选择期货交易贵金属白银，获双重交易奖励:</p>
               <p>1. 交易白银每手固定返点，根据账户层级，最高可获回馈 26美元/手</p>
               <p>2. 周交易奖励，最高可获得1000 美元/周</p>
           </div>
           <div class="brown">
             <p>( 平仓价 - 开仓价 ) x 合约单位 x 手数 + 点差回赠 + 交易奖励 =李先生获利</p>
             <p class="sum">( $17.46-$16.89 ) x 5000 x 15 + 15 x 26 + $1000 = 44140</p>
           </div>
       </div>
    </div>
</div>
<%@include file="../../foot.jsp"%>
</body>
</html>
