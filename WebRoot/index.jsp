<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<link href="${path}/css/login_front.css" rel="stylesheet"
	type="text/css" />
<link href="${path}/css/msgbox/jbox.css" rel="stylesheet"
	type="text/css" />
<script src="${path}/js/jquery-1.11.3.min.js"></script> 
<script src="${path}/js/msgbox/jquery.jBox-2.3.min.js"
	type="text/javascript"></script>
<script src="${path}/js/base/Message_zh_CN.js" type="text/javascript"></script>
<script src="${path}/js/jquery.cookie.js" type="text/javascript"></script>
<script src="${path}/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${path}/js/tb_areas.js" type="text/javascript"></script>
<script src="${path}/js/jquery.md5.js" type="text/javascript"></script>
<script src="${path}/js/_coolchat-commons.js" type="text/javascript"></script>
<script src="${path}/js/_coolchat-login.js" type="text/javascript"></script>

<script type="text/javascript">
	//回车
	function keyOnClick(e){
	    var theEvent = window.event || e;
	    var code = theEvent.keyCode || theEvent.which;
	    if (code==13) {  //回车键的键值为13
	    	login();  //调用登陆事件
	    }
	}
	//占据整个页面
	function reHrefAll() {
		var bodyHeight = document.body.clientHeight - 30;
		//alert(document.body.clientHeight);//630
		//alert("可见区域高度："+document.documentElement.clientHeight);//583
		var documentHeight = document.documentElement.clientHeight;
		//if(documentHeight < bodyHeight){
		if (top.location != self.location) {
			top.location = self.location;
		}
		//}
	}  

	//登录验证
	function login() {
		/* debugger; */
		var username = $.trim($("#form-loginName").val());
		var password = $.trim($("#form-password").val());
		var yzm = $.trim($("#form-authcode").val());
		if (username == null || username == "") {
			alert("请输入用户名!");
			return false;
		}
		if (password == null || password == "") {
			alert("请输入密码!");
			return false;
		}

		if (yzm == null || yzm == "") {
			alert("请输入验证码");
			return false;
		} else {
			$.ajax({
				url : "${path}/login/validationyzm",
				data : {
					'yzm' : yzm
				},
				type : "POST",
				async : false,
				success : function(date) {
					if (date == "true") {
						$.ajax({
							url : "${path}/login/Loging",
							data : {
								'username' : username,
								'password' : password,
							},
							Type : "POST",
							success : function(date) {
								if (date == "true") {
									window.location.href = "${path}/fund/welcomeIndex";
								} else if (date == "false") {
									alert("用户名或密码错误!");
								} else if (date == "error") {
									alert("用户名不存在!");
								}
							}
						})
					} else if (date == "false") {
						alert("验证码错误!");
					}
				}
			});
		}
	}
</script>
</head>
<body onkeydown="keyOnClick(event);"><!-- onload="reHrefAll(); "-->
	<div id="contaniner">
		<div id="login_wrap">
			<div class="logo"></div>
			<div class="signinDiv">
				<%-- <a href="#">反馈</a> | <a href="#" class="help">帮助</a> | 
				<a href="${path }/front/account!register.action">注册</a> --%>
			</div>
		
				<input type="hidden" name="form.type" value="0" />
				<div class="loginDiv">
					<h6>用户登录</h6>
					<p>
						<input id="form-loginName" name="username" type="text"
							maxlength="30" /> <label for="form-username">用户名</label>
					</p>
					<p>
						<input id="form-password" name="password" type="password"
							maxlength="20" /> <label>密码</label>
					</p>
					<p>
						<input id="form-authcode" name="yzm" type="text" class="yzm"
							maxlength="4" /> <label>验证码</label> <span><img
							id="verifyimg" src="${path}/Captcha/get/1"
							onClick="changeVerifyImg();" /></span>
					</p>
					<div>
						<span style="float: left">${fieldErrors.errMsg[0]}</span> <a
							href="javascript:void(0);" onClick="changeVerifyImg();">换一张</a>
					</div>
					<input id="login_btn" type="submit" class="btn_login" value="登 录" onclick="login();" />
					<%--<div>
						<p>
							<a href="${path}/user/user!regst.action">注册帐号</a> | 
							<a href="${path}/front/account!inputEmail.action">忘记密码</a>
						</p>
					</div>--%>
				</div>
			
			<div class="footer"></div>
		</div>
	</div>

	<script type="text/javascript">
	 	$("label").on("click", function(e) {
			$(this).hide();
			$(this).parent().find("input").focus();
		});
		$("input").bind({
			'focus' : function() {
				$(this).parent().find("label").hide();
			},
			'blur' : function() {
				if ($(this).val().length == 0) {
					$(this).parent().find("label").attr('style',
							'inline-block');
				}
			}
		});
 
		/**
		 * 提交表单
		 */
		/* function submitForm(form) {
			//不为空验证
			var loginName = $.trim($("#form-loginName").val());
			if (loginName == "" || loginName == null) {
				alert("用户名不能为空");
				return false;
			}
			var loginPassword = $.trim($("#form-password").val());
			if (loginPassword == "" || loginPassword == null) {
				alert("密码不能为空");
				return false;
			}
			var loginAuthCode = $.trim($("#form-authcode").val());
			if (loginAuthCode == "" || loginAuthCode == null) {
				alert("验证码不能为空");
				return false;
			}

			$('#login_btn').attr('disabled', true);
			$
					.ajax({
						type : "POST",
						url : "${path }/login!loginForm.action",
						data : {
							"form.loginName" : $.trim($("#form-loginName")
									.val()),
							"form.password" : $.trim($("#form-password").val()),
							"form.authcode" : $.trim($("#form-authcode").val()),
							"form.type" : "0"
						},
						error : function() {
							alert(common_xtyc);
						},
						success : function(data) {
							if (data == 'true') {
								window.location.href = "${path}/jrjuser/questionLevel!list.action";
							} else if (data == "expertLogin") {
								//专家登录
								var telephone = $.md5(loginName);
								var password = $.md5(loginPassword);

								login(telephone, password);
								//window.location.href = "${path}/jrjuser/questionLevel!list.action";
							} else {
								alert(data);
							}
						}
					})
			$('#login_btn').attr('disabled', false);
			return false;
		}  
 		*/
 		
		/**
		 * 更换验证码
		 */
		function changeVerifyImg() {
			$('#verifyimg').attr('src', '${path}/Captcha/get/' + new Date().valueOf());
		}
	</script>
</body>
</html>
