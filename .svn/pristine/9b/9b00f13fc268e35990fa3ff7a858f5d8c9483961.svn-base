$(function() {
	$("#btnLogin").click(function() {
		// Begin
		var telephone = $("#telephone").val();
		var password = $("#password").val();

		if (myFn.isNil(telephone)) {
			alert("请填写帐号...");
			return;
		} else if (myFn.isNil(password)) {
			alert("请填写密码...");
			return;
		} else {

		}
		telephone = $.md5(telephone);
		password = $.md5(password);

		login(telephone, password);
	});

	//telephone = $.cookie("telephone");
	//password = $.cookie("password");

	//if (!myFn.isNil(telephone) && !myFn.isNil(password)) {
	//	if (confirm("是否自动登录上一次登录的用户？")) {
	//		login(telephone, password);
	//	}
	//}
});
function login(telephone, password) {
	myFn.invoke({
		url : '/user/login',
		data : {
			telephone : telephone,
			password : password
		},
		success : function(result) {
			if (1 == result.resultCode) {
				var loginData = {};
				// 常用数据缓存
				loginData.userId = result.data.userId;
				loginData.jid = loginData.userId + "@" + myData.boshDomain;
				loginData.telephone = telephone;
				loginData.password = password;
				loginData.access_token = result.data.access_token;
				loginData.loginResult = result.data;
				mySdk.getUser(loginData.userId, function(result) {
					loginData.user = result;

					// ***** Begin *****
					$.cookie("telephone", telephone, {
						expires : 30
					});
					$.cookie("password", password, {
						expires : 30
					});
					$.cookie("loginData", JSON.stringify(loginData));
					// ***** End *****
					
					// 登录成功，跳转到主页面
					window.location.href = "jrjuser/questionLevel!list.action";
				});
			} else {
				alert(result.resultMsg);
			}
		},
		error : function(result) {
			alert("登录失败！请稍后再试。");
		}
	});
	// End
}