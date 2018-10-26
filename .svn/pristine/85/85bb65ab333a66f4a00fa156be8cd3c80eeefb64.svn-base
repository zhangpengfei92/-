<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="../../../head.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
</head>
<script type="text/javascript">
	var flag = true;
	var flag1 = true;
	var flag2 = true;
	var flag3 = true;
	var flag4 = true;
	
	function hqyzm(){
		if(!flag){
	    	return;
	    }
	    var username = $("#username").val();
	    if(username.length == 0){
	    	layer.msg("请输入正确的手机号");
	    	return;
	    }
	    $.post("${path}/userinfoData/getMsg",{"phone":username},function(data){
			layer.msg(data.message);
		})
	}
	function checkyzm(){
	    var msg = $("#msg").val();
	    var username = $("#username").val();
	    if(!flag){
	    	return;
	    }
	    if(msg.length == 0){
	    	return;
	    }
	    if(msg.length != 6){
	    	layer.msg("验证码不正确");
	    	return;
	    }
	    $.post("${path}/userinfoData/checkMsg",{"phone":username,"messagecode":msg},function(data){
	    	if(data.code == "1"){
	    		flag1 = false;
	    		layer.msg(data.message);
	    	}else{
	 		   flag1 = true;
	 	   }
		})
	}
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
	function confirmCheckPwd(){
		var confirmPassword = $("#confirmPassword").val();
		var password = $("#password").val();
		if(confirmPassword !== password){
			flag3 = false;
			layer.msg("密码不一致");
		}else{
			   flag3 = true;
		}
	}
	function regSubmit(){
		if(!$('#agreement').is(':checked')){
			layer.msg("请先接受注册协议");
	        return;
		}
		var username = $("#username").val();
		var password = $("#password").val();
		var eamilyzm = $("#msg").val();
		var broker = $("#broker").val();
		
		if(username.length==0){
			layer.msg("手机号不能为空");
			return;
		}
		if(eamilyzm.length==0){
			layer.msg("验证码不能为空");
			return;
		}
		if(password.length==0){
			layer.msg("密码不能为空");
			return;
		}
		if(!flag){
			layer.msg("手机号不正确,请确认");
			return;
		}
		if(!flag1){
			layer.msg("验证码不正确,请确认");
			return;
		}
		if(!flag2){
			layer.msg("密码格式不正确,请确认");
			return;
		}
		if(!flag3){
			layer.msg("密码不一致,请确认");
			return;
		}
	    if(broker === "" || broker ==null){
			layer.msg("请选择经纪人");
	        return false;
	    }
	    if(isNaN(broker)){
	    	layer.msg("请选择经纪人");
	        return false;
	    }
		$.post("${path}/userinfoData/userRegister",{"phone":username,"password":password,"yzm":eamilyzm,"broker":broker},function(data){
	    	if(data.code == "1"){
	    		$("#password").value="";
	    		$("#confirmPassword").value="";
	    		layer.msg(data.message);
	    	}else{
	    		layer.msg(data.message);
	    		window.location = "${path}/stockoption/stockoptionJump?str=downApp";
	    	}
		})
	}
	//注册的回车事件
	function keyLogin(e){
		if (e.keyCode === 13) {  //回车键的键值为13
			var input = document.getElementById("confirmPassword");
			input.blur();
			regSubmit(); //调用注册的方法
		}
	}
	function checkPhone(){
		   var username = $("#username").val();
		   if(username.length == 0){
			   return;
		   }
		   //对手机的验证
		   var reg = /^1[3|4|5|7|8][0-9]{9}$/; //验证规则
		   if(!reg.test(username)){
		        layer.msg("请输入有效的手机号！");
		        flag = false;
		        return;
		   }else{
			   flag = true;
		   }
		   
		   $.post("${path}/userinfoData/checkPhone",{"username":username},function(data){
		    	if(data.code == 0){
		    		flag = false;
		    		layer.msg(data.message);
		    	}else{
		 		   flag1 = true;
		 	   }
			})	
	}
	//委托合作协议
	function jumpxy(){
		window.location = "${path}/stockoption/stockoptionJump?str=wtxy";
	}
	function clearphone(){
		$("#username").val("");
	}
</script>
<body class="bgray">
    <div class="category">
    <!-- insder header -->
    <header class="ls-header">
        <div class="ls-header-left">
            <a href="javascript:;"><i class="iconfont icon-close"></i></a>
        </div>
        <div class="ls-header-title"></div>
        <!--<div class="ls-header-right">
           <a href=""><i class="iconfont icon-flash"></i></a>
        </div>-->
    </header>
    <div class="mainbox">
        <section>
          <div class="regbox">
               <h3>Hi,欢迎注册</h3>
               <ul>
                  <li>
                     <span>手机号</span>
                     <input type="text" id="username" name="username" autocomplete="off" onblur="checkPhone()" />
                     <em><img src="${path}/images/shanchu.png" onclick="clearphone()"></em>
                  </li>
                  <li>
                     <span>验证码</span>
                     <input type="text" id="msg" name="msg" onblur="checkyzm()"  placeholder="请输入验证码" />
                     <em class="Get" onclick="hqyzm()">获取验证码</em>
                  </li>
                  <li>
                     <span>设置密码</span>
                     <input type="password" id="password" name="password" onblur="checkpwd()" placeholder="请输入密码" />
                  </li>
                  <li>
                     <span>确认密码</span>
                     <input type="password" id="confirmPassword" name="confirmPassword" onblur="confirmCheckPwd()" onkeydown="keyLogin(event)" placeholder="请确认密码" />
                  </li>
                  <li>
                     <span>代理商</span>
                     <input type="text" id="brokername" name="brokername" value="${brokerName}" readonly="readonly"/>
                     <input type="hidden" id="broker" name="broker" value="${broker}" readonly="readonly"/>
                  </li>
               </ul>
          

          <button class="Suc" onclick="regSubmit()">立即注册</button>
          <p class="Tk"><input type="checkbox" id="agreement" />新用户注册完成即同意<a href="javascript:;" onclick="jumpxy()">《委托合作协议》</a></p>
        </section>
  </div>
</body>
</html>