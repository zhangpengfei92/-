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
	$("#futuresAllocation").addClass("on");
});
</script>

</head>
<body>
<%@include file="../../top.jsp"%>
<!-- banner start-->
<div class="banner">
    <div class="flexslider" style="height:350px;">
        <ul class="slides">
            <li style="background:url(${staticpath}/images/qhbanner.png) 50% 0 no-repeat;" style="height:350px;"></li>
        </ul>
    </div> 
</div> 
<!-- banner end--> 
<div class="main">
   <div class="Mbox">
       <h3>什么是期货配资</h3>
       <div class="Pzbox">
          <div class="Pznrong">
              <p>期货配资是一种创新的资金融资工具，为具备丰富交易经验及风险控制能力较强的投资者提供放大其操作资金，很多有良好风控意识和盈利能力的投资者在资金得到安全保障的前提下，就是通过配资扩大投资操作资金，进而大幅放大投资收益。</p>
              <p>1.通过少量的自有资金当本金，可配资本金1-10倍的资金。</p>
              <p>2.简单来说假如您有1万本金，最高可配资10万，共11万资金由你操盘。</p>
              <p>3.配资后1%既能本金翻倍，盈利全部归您。</p>
          </div>
       </div>
    </div>
    <div class="Mbox">
       <h3>期货与实物现货的区别</h3>
       <div class="Differ">
            <div class="Dtit">
                <p>现货买卖的交易标的是商品本身，而期货交易的是合约；现货交易是一手交钱一手交货，在交易的同时就能完成资金与商品的转移，而期货
                交易的目的则是从合约中获取利润；现货是一对一完成合约的签订，具体内容由双方协商确定，而期货交易则是在交易所内公开竞价成交；
                现货交易是没有固定场所的，可以在任何时间任何地点完成交易，而期货交易必须在交易所内完成；现货交易的结算采用的是货款两清的方
                式，而期货交易实行的是保证金的制度，实行每日无负债；现货交易主要实现商品所有权的转让，而期货交易可以不完成商品转移，直接通
                过价格变化来获利。</p>
                <p>以下对两项业务做个对比:</p>
            </div>
            <div class="Pzul">
               <ul class="redul">
                  <li class="tit">期货配资</li>
                  <li>撮合制交易公平的竞价交易模式</li>
                  <li>普遍为国立的结算会员交易所</li>
                  <li>有指定交割仓库可以进行实物交割</li>
                  <li>只收取手续费没有其他任何费用</li>
                  <li>三方存款保证金</li>
                  <li>主流交易软件无卡盘等各种操纵手段</li>
                  <li>合法合规</li>
               </ul>
               <ul class="redul yellow">
                  <li class="tit">电子现货</li>
                  <li>做市抵制的与客户对赌交易模式
                  <li>地方虚设的各类虚假平台</li>
                  <li>无法交割只能做投机交易</li>
                  <li>各种杂乱费用高昂</li>
                  <li>客户资金基本就无法保障安全</li>
                  <li>虚假盘口可干预行情最终造成客户注定亏损</li>
                  <li>国家全力打击的非法平台</li>
               </ul>
            </div>
       </div>
    </div>
    <div class="Mbox">
       <h3>我们的优势</h3>
       <div class="advas">
            <ul>
               <li>
                   <p class="icon"><img src="${staticpath}/images/qicon01.png" /></p>
                   <p>严格筛选资方</p>
                   <p>配资可以随时联系出资方</p>
                   <p>安全可靠</p>
                </li>
                <li>
                   <p class="icon"><img src="${staticpath}/images/qicon02.png" /></p>
                   <p>运营至今</p>
                   <p>无一例资方跑路</p>
                   <p>无一例不归还保证金</p>
                </li>
                <li>
                   <p class="icon"><img src="${staticpath}/images/qicon03.png" /></p>
                   <p>全国加盟400余家实体公司</p>
                   <p>实力雄厚</p>
                </li>
            </ul>
            <ul>
                <li>
                   <p class="icon"><img src="${staticpath}/images/qicon04.png" /></p>
                   <p>全国最专业三方</p>
                   <p>法律文书担保</p>
                </li>
                <li>
                   <p class="icon"><img src="${staticpath}/images/qicon05.png" /></p>
                   <p>风险保障金担保</p>
                   <p>先行赔付</p>
                </li>
                <li>
                   <p class="icon"><img src="${staticpath}/images/qicon06.png" /></p>
                   <p>同等安全条件下</p>
                   <p>价格最低</p>
                </li>
            </ul>
       </div>
    </div>
</div>
<%@include file="../../foot.jsp"%>
</body>
</html>
