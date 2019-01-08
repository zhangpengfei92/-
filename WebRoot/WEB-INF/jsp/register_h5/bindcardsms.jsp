<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<base href="<%=basePath%>">
<!-- 包含头部信息用于适应不同设备 -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">快捷支付>绑卡</h3>
			</div>
			<div class="panel-body">
				<form class="form-horizontal" role="form">
					<div class="form-group">
						<label for="accountName" class="col-sm-4 col-xs-4 control-label">姓&emsp;&emsp;名:</label>
						<div class="col-sm-8 col-xs-8">
							<input type="text" class="form-control  input-sm input-xs"
								id="accountName" placeholder="请输入姓名">
						</div>
					</div>
					<div class="form-group">
						<label for="certNo" class="col-sm-4 col-xs-4 control-label">身份证号:</label>
						<div class="col-sm-8 col-xs-8">
							<input type="text" class="form-control  input-sm input-xs"
								id="certNo" maxlength="18" placeholder="请输入身份证号">
						</div>
					</div>
					<div class="form-group">
						<label for="phoneNumber" class="col-sm-4 col-xs-4 control-label">手机号码:</label>
						<div class="col-sm-8 col-xs-8">
							<input type="text" class="form-control  input-sm input-xs"
								id="phoneNumber" maxlength="18" placeholder="请输入手机号码">
						</div>
					</div>
					<div class="form-group">
						<label for="bankId" class="col-sm-4 col-xs-4 control-label">开户银行:</label>
						<div class="col-sm-8 col-xs-8">
							<select class="form-control  input-sm input-xs" id="bankId">
								<option>--请选择开户银行--</option>
								<option>1</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="accountNumber" class="col-sm-4 col-xs-4 control-label">银行卡号:</label>
						<div class="col-sm-8 col-xs-8">
							<input type="text" class="form-control  input-sm input-xs"
								id="accountNumber" maxlength="18" placeholder="请输入银行卡号">
						</div>
					</div>
					<div class="form-group">
						<label for="accountNumber" class="col-sm-4 col-xs-4 control-label">验&ensp;证&ensp;码:</label>
						<div class="col-sm-8 col-xs-8">
							<input type="text" class="form-control  input-sm input-xs"
								id="accountNumber" maxlength="18" placeholder="请输入验证码">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12 col-xs-12">
							<button type="submit" class="btn btn-success btn-block">确&emsp;认</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
