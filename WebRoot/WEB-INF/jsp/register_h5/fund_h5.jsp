<%@page import="org.apache.commons.lang3.RandomStringUtils"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	pageContext.setAttribute("basePath", basePath);
%>
<html>
<head>
<base href="<%=basePath %>">
<meta name="viewport"content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta http-equiv="Expires" CONTENT="0" />
<meta http-equiv="Cache-Control" CONTENT="no-cache" />
<meta http-equiv="Pragma" CONTENT="no-cache" />
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/icon.css" />
<script type="text/javascript" src="${path}/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${path}/js/easyui/locale/easyui-lang-zh_CN.js"></script>

<script type="text/javascript">

function buy(){
	
	var tranAmt = $.trim($("#amount").val());
	if(tranAmt.indexOf(".")>0){//控制不让输入小数
		$.messager.alert('提示',"充值金额不允许有小数",'info');
	
		 return false;  
	}
	
	if (tranAmt.length < 1 || tranAmt.length > 20) {
		$.messager.alert('提示',"请输入充值金额",'info');

    
        return false;
    }
	
	if(isNaN(tranAmt)||tranAmt<2.0){

		$.messager.alert('提示',"充值金额必须为数字,且金额必须大于2.0",'info');

		$("#tranAmt").val("");
		return false;
	}	
	var bFlag = true;

	
	if(bFlag){
		var form = $("#infoInputForm")

		form.submit();
	}
}
</script>


</head>
<body>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">快捷支付绑卡>输入信息</h3>
			</div>
			<div class="panel-body">
				<form class="form-horizontal" id="infoInputForm" role="form" method="post" action="${path}/subzhfund/ispay">
					<div class="form-group">
						<label for="accountName" class="col-sm-4 col-xs-4 control-label">姓&emsp;&emsp;名:</label>
						<div class="col-sm-8 col-xs-8">
							<input type="text" class="form-control  input-sm input-xs"
								name="accountName" id="accountName" placeholder="请输入姓名" value="${sub.name}">
						</div>
					</div>
					
					<div class="form-group">
						<label for="accountNumber" class="col-sm-4 col-xs-4 control-label">银行卡号:</label>
						<div class="col-sm-8 col-xs-8">
							<input type="text" class="form-control  input-sm input-xs"
								name="accountNumber" id="accountNumber" value="${sub.bankCard}" maxlength="30" placeholder="请输入银行卡号">
						</div>
					</div>
					<div class="form-group">
						<label for="cardType" class="col-sm-4 col-xs-4 control-label">卡&ensp;类&ensp;型:</label>
						<div class="col-sm-8 col-xs-8">
							<select class="form-control  input-sm input-xs" name="cardType" id="cardType">
								<!-- <option value="">--请选择卡类型--</option> -->
								<option value="10">借记</option>
							<!-- 	<option value="20">贷记</option> -->
							</select>
						</div>
					</div>
					
<!-- 					<div class="form-group">
						<label for="validDate" class="col-sm-4 col-xs-4 control-label">有&ensp;效&ensp;期:</label>
						<div class="col-sm-8 col-xs-8">
							<input type="text" class="form-control  input-sm input-xs"
								name="validDate" id="validDate" maxlength="18" placeholder="请输入有效期(信用卡必填)">
						</div>
					</div> -->
				<!-- 	<div class="form-group">
						<label for="CVN2" class="col-sm-4 col-xs-4 control-label">C&nbsp;&nbsp;V&nbsp;N&nbsp;&nbsp;2:</label>
						<div class="col-sm-8 col-xs-8">
							<input type="text" class="form-control  input-sm input-xs"
								name="CVN2" id="CVN2" maxlength="18" placeholder="请输入CVN2(信用卡必填)">
						</div>
					</div> -->
					
					
					<div class="form-group">
						<label for="phoneNumber" class="col-sm-4 col-xs-4 control-label">手机号码:</label>
						<div class="col-sm-8 col-xs-8">
							<input type="text" class="form-control  input-sm input-xs"
								name="phoneNumber" id="phoneNumber" value="${sub.phone}" maxlength="18" placeholder="请输入预留手机号码">
						</div>
					</div>
					<div class="form-group">
						<label for="identificationType"
							class="col-sm-4 col-xs-4 control-label">证件类型:</label>
						<div class="col-sm-8 col-xs-8">
							<select class="form-control  input-sm input-xs"
								name="identificationType" id="identificationType">
							<!-- 	<option value="">--请选择证件类型--</option> -->
								<option value="0">身份证</option>
					<!-- 			<option value="1">户口簿</option>
								<option value="2">护照</option>
								<option value="3">军官证</option>
								<option value="4">士兵证</option>
								<option value="5">港澳居民来往内地通行证</option>
								<option value="6">台湾同胞来往内地通行证</option>
								<option value="7">临时身份证</option>
								<option value="8">外国人居留证</option>
								<option value="9">警官证</option>
								<option value="X">其他证件</option> -->
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="identificationNumber"
							class="col-sm-4 col-xs-4 control-label">证件证号:</label>
						<div class="col-sm-8 col-xs-8">
							<input type="text" class="form-control  input-sm input-xs"
								name="identificationNumber" id="identificationNumber" value="${sub.idNo}"
								maxlength="18" placeholder="请输入证件证号">
						</div>
					</div>
					<div class="form-group">
						<label for="amount" class="col-sm-4 col-xs-4 control-label">金额(元):</label>
						<div class="col-sm-8 col-xs-8">
							<input type="text" class="form-control  input-sm input-xs" value=""
								name="tranAmt" id="amount" maxlength="18" placeholder="请输入金额">
						</div>
					</div>
					<div class="form-group">
						<label for="remark" class="col-sm-4 col-xs-4 control-label">备&emsp;&emsp;注:</label>
						<div class="col-sm-8 col-xs-8">
							<input type="text" class="form-control  input-sm input-xs"
								name="remark" id="remark" maxlength="18" placeholder="请输入备注">
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-sm-12 col-xs-12">
							<button type="button" onclick="buy()" class="btn btn-success btn-block">下&emsp;一&emsp;步</button>
						</div>
					</div>
					<input type="hidden" name="txSn" id="txSn"
						value="${sub.subzh}<%=RandomStringUtils.randomNumeric(17)%>" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>
