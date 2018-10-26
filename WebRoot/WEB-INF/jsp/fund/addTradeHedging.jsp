<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-Ua-Compatible" content="IE=EmulateIE8" />
<title>样本账户-编辑</title>
	<link rel="stylesheet" type="text/css" href="${path}/css/style.css" />
	<script type="text/javascript" src="${path}/js/jquery-1.11.3.min.js"></script>
	<!-- 引入默认css -->
	<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/icon.css" />
	<script type="text/javascript" src="${path}/js/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="${path}/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${path}/js/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	
	function checkNum(weight){
		if (isNaN(weight)) {
			$.messager.alert('提示', "管理费必须为数字", 'info');
			return false;
		}
	}
	
	//保存
	function saveUser() {
		var regFlag = true;
		var username = $.trim($("#vipnumber").val());
		if (username == null || username == "") {
			$.messager.alert('提示', "分组编号不能为空!", 'info');
			return false;
		}
		
		var accountcode = $.trim($("#accountcode").val());
		if (accountcode == null || accountcode == "") {
			$.messager.alert('提示', "样本账户不能为空!", 'info');
			return false;
		}
		
		if(regFlag){
			$.ajax({
				url : "${path}/tradeData/editTradeHedgingMsg",
				data : {
					'id' : $("#hedgingId").val(),
					'vipnumber' : username,
					'accountcode' : accountcode
				},
				type : "POST",
				async : false,
				success : function(data) {
					if (data == "true") {
						$.messager.alert('提示!', '保存成功!','info',function() {
							refreshPage();
						});
					} else if (data == "false") {
						$.messager.alert('提示!', '保存失败!','error',function() {
							$("#submitId").attr("disabled", false);
						});
					} else if (data == "isExist") {
						$.messager.alert('提示!', '已存在，请重新输入!','error',function() {
							$("#submitId").attr("disabled", false);
						});
					}
				}
			});
		}
	}
	
	function refreshPage() {//取消
		window.location.href = "${path}/tradeData/tradeHedgingList";
	}
</script>
</head>
<body>
	<%@include file="../../../head.jsp"%>
	<div class="wrap">
		<%@include file="subzhMaster.jsp"%>
		<div class="Rbox">
     		<div class="mainbox">
                   <h3><a href="${path}/tradeData/tradeHedgingList">样本账户</a><i>/</i><a href="#" class="on">新建样本账户</a></h3>
                   <div class="main">
                      	<div class="Form">
                      		<input type="hidden" name="hedgingId" id="hedgingId" value="${user.id}"/>
                            <div class="dline">
                                <label>分组编号：</label>
			                   	<input type="text" name="vipnumber" id="vipnumber" maxlength="50" placeholder="请输入分组编号" value="${user.vipnumber}"/>
                            </div>
                            <div class="dline">
                                <label>样本账户：</label>
			                   	<input type="text" name="accountcode" id="accountcode" maxlength="50" placeholder="请输入样本账户" value="${user.accountcode}"/>
                            </div>
                           
                            <div class="dline">
                                 <label style="color:#fff;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                                 <button class="Submit" onclick="saveUser();" id="submitId">提交</button>
                                 <button class="Submit cancel" onclick="refreshPage()">取消</button>
                            </div>
                       </div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>