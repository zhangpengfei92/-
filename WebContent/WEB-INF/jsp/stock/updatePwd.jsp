<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="../../../head.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<script type="text/javascript">
	var flag1 = true;
	var flag2 = true;
	function loginSubmit(){
		var oldpwd = $("#oldpassword").val();
		var newpwd = $("#password").val();
		var subzh = $("#username").val();
		if(oldpwd == ""){
			layer.msg("原密码不能为空");
			return;
		}
		if(newpwd == ""){
			layer.msg("新密码不能为空");
			return;
		}
		$.post("${path}/userinfoData/userUpdPwd",{"phone":uid,"subzh":username,"password":oldpwd,"newpassword":newpwd},function(data){
	    	if(data.code == 1){
	    		layer.msg(data.message);
	    	}else{
	    		layer.msg(data.message);
	    		window.location = "${path}/stockoption/stockoptionJump?str=loginPage";
	    	}
		})
	}
</script>
<body class="gray">
    <div class="category">
    <!-- insder header -->
    <header class="ls-header">
        <div class="ls-header-left">
            <a href="javascript:history.go(-1)"><i class="iconfont icon-back"></i></a>
        </div>
        <div class="ls-header-title">修改密码</div>
        <!--<div class="ls-header-right">
           <a href=""><i class="iconfont icon-flash"></i></a>
        </div>-->
    </header>
    <div class="mainbox">
        <section>
           <div class="Caccount">
              <ul>
              <input id="username" type="hidden" value="${userinfo.subzh}">
                <li>
                   <span class="Swidth">原密码</span>
                   <p style="float:left;"><input id="oldpassword" name="oldpassword" type="password" placeholder="请输入原密码"  style="width:100%;text-align:left;"></p>
                </li>
                <li>
                   <span class="Swidth">新密码</span>
                   <p style="float:left;"><input placeholder="请输入新密码" id="password" name="password" type="password"  style="width:100%;text-align:left;"></p>
                </li>
              </ul>
           </div>
           <button class="Suc" onclick="loginSubmit()">完成</button>
        </section>
  </div>
</body>
</html>