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
	
	function checkpwd(){
		var password = $("#password").val();
		if(password.length == 0){
	    	return;
	    }
		if(password.length < 6){
			flag2 = false;
			layer.msg("密码不能低于6位");
		}else{
			   flag2 = true;
		}
		if(password.length > 18){
			flag2 = false;
			layer.msg("密码不能高于18位");
		}else{
			   flag2 = true;
		}
		var strTest =/^[0-9a-zA-Z]*$/g;
		if(!strTest.test(password)){
			flag2 = false;
			layer.msg("密码只能由字母数字组成");
		}else{
			   flag2 = true;
		}
	}
	function loginSubmit(){
		
		var username = $("#username").val();
		var password = $("#password").val();
		if(username.length==0){
			layer.msg("账号不能为空");
			return;
		}
		if(password.length==0){
			layer.msg("密码不能为空");
			return;
		}
		if(!flag1){
			layer.msg("账号格式不正确,请确认");
			return;
		}
		if(!flag2){
			layer.msg("密码格式不正确,请确认");
			return;
		}
		
		$.post("${path}/fund/payLogin",{"phone":username,"password":password},function(data){
	    	if(data.code == 1){
	    		layer.msg(data.message);
	    	}else{
	    		refreshPage();
	    	}
		})
	}
	
	
	function refreshPage() {
		//关闭弹出层
		var index = parent.layer.getFrameIndex(window.name);  
		window.parent.layer.close(index); 
}
</script>
<body class="gray">
    <div class="mainbox">
           <div class="Caccount">
              <ul>
                <li>
                   <span class="Swidth">用户名</span>
                   <p style="float:left;"><input type="text" id="username" name="username" placeholder="请输入手机号" autocomplete="off" style="width:100%;text-align:left;"></p>
                </li>
                <li>
                   <span class="Swidth">密码</span>
                   <p style="float:left;"><input placeholder="请输入密码" id="password" name="password" type="password" onblur="checkpwd()" style="width:100%;text-align:left;"></p>
                </li>
              </ul>
           </div>
           <button class="Suc" onclick="loginSubmit()">登录</button>
  </div>
</body>
</html>