<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>left menu</title>
<link rel="stylesheet" type="text/css" href="${path}/css/nav.css" />
<script type="text/javascript">
	$(function(){
		$("#index_${leftmenu}").addClass('current');
	});

	//首页
	function indexFunction(){
		window.location.href = "${path}/fund/welcomeIndex";
	}

	//普通会员
	function commonMember() {
		var isadmin="${sessionScope.SESSION_ISADMIN}";
		isadmin=1+parseInt(isadmin);
		window.location.href = "${path}/fund/subzhList?isadmin="+isadmin;
	}
	//管理員列表
	function wardenList(){
	    window.location.href = "${path}/membersys/jumpwardenList";
	}
	//权限管理
	function roleList(){
	    window.location.href = "${path}/membersys/jumproleList";
	}
	//提现审核
	function withdrawList(){
	    window.location.href = "${path}/fundlog/agentzhfundLogList";
	}
	//资金流水
	function fundList(){
	    window.location.href = "${path}/fundPzlog/fundPzLogList";
	}
	
	//交易管理
	function dealCjList(){
	    window.location.href = "${path}/tradeData/dealHolderList";
	}
	function ccdbList(){
	    window.location.href = "${path}/tradeData/holderCompareList";
	}
	function exceptionOrderList(){
		window.location.href = "${path}/tradeData/exceptionOrderList";
	}
	
</script>
</head>
<body>
	<div class="sidebar">
        <div class="sidebar-bg"></div>
        <ul class="nav" id="ulIndex">
           	<li class="nav-li" id="nav_1">
           	  	<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text"><i class="Ficon"><img src="${path}/image/er-ji-dao-hang-1.png"/></i>首页</span></a>
           	  	<ul class="subnav">
	          		<li class="subnav-li" data-id="1" id="index_1"><a id="left_a_0" href="javascript;" onclick="indexFunction();" class="ue-clear"><span class="subnav-text">首页</span></a></li>
	            </ul>
	        </li>
               
            <li class="nav-li last-nav-li" id="nav_2">
            	<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text"><i class="Ficon"><img src="${path}/image/er-ji-dao-hang-1.png"/></i>资金管理</span></a>
              	<ul class="subnav">
	              	<%-- <shiro:hasRole name="customer_user"> --%><li class="subnav-li" data-id="3" id="index_3"><a id="left_a_3" href="javascript:;" onclick="commonMember('1')" class="ue-clear"><span class="subnav-text">账户列表</span></a></li><%-- </shiro:hasRole> --%>
	              	<li class="subnav-li" data-id="4" id="index_4"><a id="left_a_4" href="javascript:;" onclick="fundList()" class="ue-clear"><span class="subnav-text">资金流水</span></a></li>
	              	<li class="subnav-li" data-id="2" id="index_2"><a id="left_a_2" href="javascript:;" onclick="withdrawList()" class="ue-clear"><span class="subnav-text">提现审核</span></a></li>
              	</ul>
            </li>
            
            <li class="nav-li last-nav-li current" id="nav_3">
                <a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text"><i class="Ficon"><img src="${path}/image/er-ji-dao-hang-1.png"/></i>交易管理</span></a>
	            <ul class="subnav">
		             <li class="subnav-li" data-id="5" id="index_5"><a id="left_a_5" href="javascript:;" onclick="dealCjList()" class="ue-clear"><span class="subnav-text">订单记录</span></a></li>
		             <li class="subnav-li" data-id="6" id="index_6"><a id="left_a_6" href="javascript:;" onclick="ccdbList()" class="ue-clear"><span class="subnav-text">持仓对比</span></a></li>
		             <li class="subnav-li" data-id="7" id="index_7"><a id="left_a_7" href="javascript:;" onclick="exceptionOrderList()" class="ue-clear"><span class="subnav-text">异常订单</span></a></li>
              	</ul>
            </li>
            
            <li class="nav-li last-nav-li" id="nav_4">
                <a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text"><i class="Ficon"><img src="${path}/image/er-ji-dao-hang-1.png"/></i>系统设置</span></a>
                <ul class="subnav">
		             <%--<shiro:hasRole name="rights_manage"><li id="left2"><a id="left_a_2" href="javascript:;" onclick="roleList('2')"><span><img src="${path}/image/lthree.png"/></span>权限管理</a></li></shiro:hasRole>--%>
		             <c:if test="${sessionScope.SESSION_LOGINNAME == 'admin'}"><li id="left3"><a id="left_a_3" href="javascript:;" onclick="wardenList('3')" class="ue-clear"><span class="subnav-text">系统账户</span></a></li></c:if>
		             <%--<li id="left4"><a id="left_a_4" href="javascript:;" onclick="statisticList()"><span></span>行为统计</a></li>
		             <shiro:hasRole name="rolelist"><li id="left2"><a href="javascript:;" onclick="roleList()">系统角色</a></li></shiro:hasRole>--%>
          		</ul>
            </li>
         </ul>
	</div>
</body>
<script type="text/javascript" src="${path}/js/nav.js"></script>
<script type="text/javascript" src="${path}/js/Menu.js"></script>
<script type="text/javascript">
	var menu = new Menu({
		defaultSelect: $('.nav').find('li[data-id="${leftmenu}"]')
	});
	
	$('.sidebar h2').click(function(e) {
        $('.tree-list').toggleClass('outwindow');
		$('.nav').toggleClass('outwindow');
    });
	
</script>
</html>