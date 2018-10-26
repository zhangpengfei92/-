<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>修改密码</title>
	<link rel="stylesheet" type="text/css" href="${path}/css/style.css" />
	<script type="text/javascript" src="${path}/js/jquery-1.11.3.min.js"></script>
	<!-- 引入默认css -->
	<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/icon.css" />
	<script type="text/javascript" src="${path}/js/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="${path}/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${path}/js/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
//修改密码
function savepassword(){
	var oldpass = $.trim($("#oldpass").val());
	if(!oldpass){
		alert("请输入原始密码");
		return false;
	}
	var newpass = $.trim($("#newpass").val());
	if(!newpass){
		alert("请输入新密码");
		return false;
	}
	if(newpass.length < 8 || newpass.length > 20) {
        alert("新密码请输入8至20位字符");
        return false;
    }
	var newpass2 = $.trim($("#newpass2").val());
	if(!newpass2){
		alert("请确认新密码");
		return false;
	}
	if(newpass != newpass2){
		alert("两次输入的新密码不一致");
		return false;
	}
	
	
	var url = "${path}/membersys/savePass";
	var params = {
			oldpass : oldpass,
			newpass : newpass
	};
	$("#submitId").attr("disabled", "disabled");
	$.ajax({
		type : "POST",
		url : url,
		data : params,
		async:false, 
		error : function() {
			alert("error!");
		},
		success : function(data) {
			if(data == 'true'){
				$.messager.alert('提示!', '修改密码成功!','info',function() {
					window.history.go(-1);
				});
			}else if(data == 'passerror'){
				$.messager.alert('提示!', '原始密码错误!','error',function() {
					$("#submitId").attr("disabled", false);
				});
			}else{
				$.messager.alert('提示!', '修改失败!','error',function() {
					$("#submitId").attr("disabled", false);
				});
			}
		}
	});
	
}

</script>
</head>
<body>
<%@include file="../../../head.jsp"%>
	<div class="wrap">
		<%@include file="memberView.jsp"%>
		<div class="Rbox">
     		<div class="mainbox">
                <h3>修改密码</h3>
                <div class="main">
          		<%--  <form action="${path}/warden/saveWarden" method="post" id="save_form"> --%>
                <div class="dline">
	                <label>原始密码：</label>
                   	<p><input type="password"  id="oldpass"/></p>
                </div>
	            <div class="dline">
	                <label>新密码：</label>
                   	<p><input type="password"  id="newpass" /></p>
                </div>
	            <div class="dline">
	             	<label>确认新密码：</label>
                    <p><input type="password"  id="newpass2"/></p>
                </div>
              <!-- </form> -->
                <div class="dline">
	                 <label style="color:#fff;">手机号码：</label>
	                 <p><button class="Submit" id="submitId" onclick="savepassword()" style="cursor: pointer;">保存</button>
	                 <button class="Submit cancel" onclick="window.history.go(-1)" style="cursor: pointer;">取消</button></p>
	            </div>
              </div>
          </div>
     </div>
</div>
</body>
</html>