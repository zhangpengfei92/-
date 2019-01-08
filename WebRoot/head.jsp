<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="${path}/css/style.css" />
<script src="${path}/js/jquery.SuperSlide.2.1.1.js" type="text/javascript"></script>
<script type="text/javascript">
	//会员管理
	function member() {
		window.location.href = "${path}/member/jumpcommonmember";
	}

	//广告管理
	function guanggaomanagement() {
		window.location.href = "${path}/mainImage/mainImage/index";
	}
	//文章管理
	function community() {
		window.location.href = "${path}/articleManage/helpCenter/junmpHelpCenter";
	}
	//管理员
	function warden() {
		window.location.href = "${path}/warden/jumpwardenList";
	}
	//結算管理
	function clearing() {
		//window.location.href.href = "${path}/clearing/agentstatement";
		window.location.href.href = "${path}/clearing/agentapplysettle";
	}
	//退出登录
	function loginOut() {
     window.location.href="${path}/login/loginOut";
	}
	//修改密码
	function modifypassword(){
		window.location.href="${path}/membersys/modifyPassword";
	}
</script>
</head>
<body class="grey">
     <div class="headbox">
          <div class="logo">
               <span class="logo"><img src="${path}/image/logo.png" /></span>
          </div>
          <ul id="hnav" class="hnav clearfix">
               <li class="nLi on">
                   <h3><a href="javascript:;">${sessionScope.SESSION_LOGINNAME}</a></h3>
                   <ul class="navsub">
						<li><a href="javascript:;" onclick="modifypassword()">修改密码</a></li>
						<li><a href="javascript:;" onclick="loginOut()">退出登录</a></li>
                   </ul>
               </li>
           </ul>
           <script id="jsID" type="text/javascript">
                jQuery("#hnav").slide({ 
                type:"menu",// 效果类型，针对菜单/导航而引入的参数（默认slide）
                titCell:".nLi", //鼠标触发对象
                targetCell:".navsub", //titCell里面包含的要显示/消失的对象
                effect:"slideDown", //targetCell下拉效果
                delayTime:300 , //效果时间
                triggerTime:0, //鼠标延迟触发时间（默认150）
                returnDefault:true //鼠标移走后返回默认状态，例如默认频道是“预告片”，鼠标移走后会返回“预告片”（默认false）
              });
          </script>
     </div>	
</body>
</html>