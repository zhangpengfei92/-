<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="../../../head.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<script type="text/javascript">
$(document).ready(function(){
    $("#dtBox").DateTimePicker({
    
        dateFormat: "MM-dd-yyyy",
        timeFormat: "HH:mm",
        dateTimeFormat: "MM-dd-yyyy HH:mm:ss AA"
    });
});
function sureConfig() {
	var star=$("#start").val();
	var end=$("#end").val();
	if(star !='' && end !=''){
		 var starDate=new Date(star.replace(/-/g,"/"));
	     var endDate=new Date(end.replace(/-/g,"/"));
	     if(starDate-endDate>0){
	         layer.msg("开始日期要在截止日期之前!");  
	         return false;
	     }
	}
	$.post("${path}/stockoption/getStockEnquiry",{"phone":username,"star":star,"end":end},function(data){
		window.location = "${path}/stockoption/stockoptionJump?str=rgcx";
	})
}
</script>
<body class="bggray">
    <!-- 遮罩层 start -->
    <div class="maskBg"></div>
    <!-- 遮罩层 end -->
    <div class="category">
    <!-- insder header -->
    <header class="ls-header">
        <div class="ls-header-left">
            <a href="javascript:void(0)" onclick="rg()"><i class="iconfont icon-back"></i></a>
        </div>
        <div class="ls-header-title">交易与持仓</div>
        <div class="ls-header-right">
           <a href="javascript:void(0)" onclick="rgcx()"><i class="iconfont icon-flash"></i></a>
        </div>
    </header>
    <div class="mainbox">
         <section>
             <div class="Tradebox">
                 <ul class="Tnum">
                    <li>总资产：<span>${userinfo.rzj}</span></li>
                    <li>可用资产：<span>${userinfo.xzj + userinfo.bzj}</span></li>
                 </ul>
                 <ul class="Ttab">
                     <li><a href="javascript:;" onclick="rg()">询价</a></li>
                     <li><a href="javascript:;" class="on"  onclick="rgcx()">认购</a></li>
                     <li><a href="javascript:;" onclick="cc()">持仓</a></li>
                     <li><a href="javascript:;" onclick="js()">查询</a></li>
                 </ul>
                 <div class="Cjbox">
                <ul>
                    <li>
                 	<div class="rl">
                          <label>认购日期</label>
                          <input type="text" data-field="date" data-format="yyyy-MM-dd" readonly id="start">
                          <span>-</span>
                          <input type="text" data-field="date" data-format="yyyy-MM-dd" readonly id="end">
                          <i class="cbut" onclick="sureConfig()">确定</i>
                    </div>
                    </li></ul>
                  </div>  
                    <div id="dtBox"></div>
                 <ul class="Cdbox">
                 	<c:forEach items="${stockEnquiryList}" var="se" varStatus="st">
	                     <li>
	                        <h3><p><span><fmt:formatDate value="${se.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>
	                        </span></p>
	                        <c:if test="${se.status == 2}"><em class="rgbut" style ="background:#000000;color:#de3f2a" >认购失败</em></c:if>
	                        <c:if test="${se.status == 1}"><em class="rgbut" style ="background:#000000;color:#A9A9A9" >认购中</em></c:if>
	                        <c:if test="${se.status != 1 && se.status != 2}"><em class="rgbut" style ="background:#000000;color:#00FF00" >认购成功</em></c:if></h3>
	                        <table width="100%;" class="Cdtable">
	                           <tr>
	                              <td>${se.stockname} <span>(${se.stockcode})</span></td>
	                              <td class="tpadd"><span>权利金：</span>${se.principalfloat}%</td>
	                              
	                              <td class="tpadd"><span>期初价：</span><c:if test="${empty se.freeprice}">--</c:if><c:if test="${not empty se.freeprice}">${se.freeprice}</c:if></td>
	                           </tr>
	                           <tr>
	                              <td><span>名义本金：</span>${se.principalbalance}万</td>
	                              <td><span>周期：</span>${se.enquirytime}<c:choose><c:when test="${se.type == 1}">天</c:when><c:when test="${se.type == 2}">周</c:when><c:when test="${se.type == 3}">个月</c:when><c:when test="${se.type == 4}">年</c:when></c:choose></td>
	                              <td class="tpadd"><span>到期时间：</span><fmt:formatDate value="${se.endtime}" pattern="yyyy-MM-dd"/></td>
	                           </tr>
	                        </table>
	                     </li>
                     </c:forEach>
                 </ul>
             </div>
        </section> 
        <div class="homebottom">
         <ul>
              <li class="nav01" onclick="hangqing()">
                  <a href="javascript:;" >
                      <i></i>
                      <span >行情</span>
                  </a>
              </li>
              <li class="nav12" onclick="trader()">
                  <a href="javascript:;" class="on" >
                      <i></i>
                      <span >交易</span>
                  </a>
              </li>
              <li class="nav03" onclick="zjmx()">
                  <a href="javascript:;" >
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
                  <a href="javascript:;">
                      <i></i>
                      <span>我的</span>
                  </a>
              </li>
         </ul>
    </div>
        <%@include file="../../../foot.jsp"%>
  </div>
</body>
</html>