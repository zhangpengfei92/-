<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-Ua-Compatible" content="IE=EmulateIE8" />
<title>会员管理-编辑会员</title>
<link href="${path}/css/css.css" rel="stylesheet" type="text/css" />
<link href="${path}/css/per.css" rel="stylesheet" type="text/css" />
<script src="${path}/js/jquery-1.9.1.min.js"></script>
<script src="${path}/js/xl.js"></script>
<script src="${path}/js/My97DatePicker/WdatePicker.js"></script>
<!-- 引入默认css -->
<link rel="stylesheet" type="text/css"
	href="${path}/js/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="${path}/js/easyui/themes/icon.css" />
<!-- 引入jquery 注意位置，一定要是排在easyui的上面，否则可能会有问题-->
<script type="text/javascript" src="${path}/js/easyui/jquery.min.js"></script>
<!-- 引入easyui -->
<script type="text/javascript"
	src="${path}/js/easyui/jquery.easyui.min.js"></script>
<!-- 引入国际化 中文 -->
<script type="text/javascript"
	src="${path}/js/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	//保存
	function saveUser() {
		var id = $.trim($("#id").val());
		var email = $.trim($("#email").val());
		var phone = $.trim($("#phone").val());
		if (email == null || email == "") {
			$.messager.alert('提示!', '请输入邮箱!', 'warning');
			return false;
		}
		if (phone == null || phone == "") {
			$.messager.alert('提示!', '请输入手机号码!', 'warning');
			return false;
		}
		$.ajax({
			url : "${path}/member/editUser",
			data : {
				'email' : email,
				'phone' : phone,
				'id' : id
			},
			type : "post",
			dateType : "text",
			success : function(data) {
				if (data == "true") {
					$.messager.alert('提示!', '保存成功!','info',function() {
						parent.RefreshPage();
					})
				}
				if (data == "false") {
					$.messager.alert('提示!', '保存失败!','error',function() {
						parent.RefreshPage();
					})
				}
			}
		});
	}
	function RefreshPage() {
		window.location.href = "${path}/member/jumpcommonmember"
	}
</script>
</head>
<body>
	<%@include file="../../../head.jsp"%>
	<div class="Mamain">
		<%@include file="memberView.jsp"%>
		<div class="Marbox">
			<ul class="Matit">
				<li class="Maselect">编辑会员</li>
			</ul>

			<div class="adbox">
				<p>账号名称</p>
				<p>
					<input type="hidden" id="id" name="id" value="${user.id}" /> <input
						type="text" value="${user.nickname}" id="nickname" name="nickname"
						disabled="disabled" />
				</p>
				<p>用户分类</p>
				<p>
					<c:choose>
						<c:when test="${user.usertype==1}">
							<input type="text" value="普通用户" disabled="disabled" />
						</c:when>
						<c:when test="${user.usertype==2}">
							<input type="text" value="博主" disabled="disabled" />
						</c:when>
						<c:when test="${user.usertype==3}">
							<input type="text" value="交易员" disabled="disabled" />
						</c:when>
					</c:choose>

				</p>
				<p>电子邮箱</p>
				<p>
					<input type="text" value="${user.email}" id="email" name="email" />
				</p>

				<p>手机号码</p>
				<p>
					<input type="text" value="${user.phone}" id="phone" name="phone" />
				</p>
				<p>注册时间</p>
				<p>
					<input type="text"
						value="<fmt:formatDate value="${user.createtime}" type="both"/>"
						disabled="disabled" id="createtime" name="createtime" />
				</p>

				<p>
					<button class="save" onclick="saveUser()">保存</button>
					<button onclick="RefreshPage()">取消</button>

				</p>
			</div>

		</div>
	</div>
	</div>
	<%@include file="../../../foot.jsp"%>
	</div>
</body>
</html>
