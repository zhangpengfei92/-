<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="../../../head.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<script type="text/javascript">
var subzh= "<%=session.getAttribute("SESSION_LOGINNAME")%>";
if(uid == ""||uid == null || uid == "null"){
	window.location = "${path}/stockoption/stockoptionJump";
}
function logout(){
	window.location = "${path}/stockoption/stockoptionJump?str=loginPage";
}
function updatepwd(){
	window.location = "${path}/stockoption/stockoptionJump?str=updatepwd";
}
function guanyu(){
	window.location = "${path}/stockoption/stockoptionJump?str=guanyu";
}
</script>
<body class="bggray">
    		<header class="ls-header">
        <div class="ls-header-left">
            <a href="javascript:void(0)" onclick="helpCenter()"><i class="iconfont icon-back"></i></a>
        </div>
        <div class="ls-header-title">我的</div>
        <div class="ls-header-right">
           <a href=""><i class="iconfont icon-flash"></i></a>
        </div>
    </header>
     <div class="mainbox">
     <section>
     	<ul class="Asknum">
     	<li>
             <label style="text-align:left; font-size: 15px">&nbsp;&nbsp;账户</label>
             <label font-size: 15px">${userinfo.phone}</label>
         </li>
         <li onclick="updatepwd()">
            <label style="text-align:left; font-size: 15px">&nbsp;&nbsp;修改密码</label>
         </li>
<!--          <li onclick="guanyu()"> -->
<!--             <label style="text-align:left; font-size: 15px">&nbsp;&nbsp;关于</label> -->
<!--          </li> -->
         <li onclick="logout()">
            <label style="font-size:17px">&nbsp;&nbsp;退出账号</label>
         </li>
     </section>   
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
              <li class="nav15" onclick="personal()">
                  <a href="javascript:;" class="on">
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