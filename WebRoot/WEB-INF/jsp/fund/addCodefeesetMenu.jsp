<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-Ua-Compatible" content="IE=EmulateIE8" />
<title>收费方案-编辑方案</title>
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
		var username = $.trim($("#title").val());
		if (username == null || username == "") {
			$.messager.alert('提示', "方案名称不能为空!", 'info');
			return false;
		}

		if (username.length<5|| username.length>10) {
			$.messager.alert('提示', "方案名称字数请控制在5~10个字", 'info');
			return false;
		}
		
		
		//var percentage = $.trim($("#percentage").val());
		//if (percentage.length==0 || isNaN(percentage) || percentage.length>12) {
		//	$.messager.alert('提示', "管理费必须为数字", 'info');
		//	return false;
		//}
		
		if(regFlag){
			$.ajax({
				url : "${path}/codefeeset/editCodefeesetMenuMsg",
				data : {
					'title' : username,
					//'percentage' : percentage,
					'isdefault' : $("input[name='isdefault']:checked").val()
				},
				type : "POST",
				async : false,
				success : function(data) {
					if (data == "true") {
						$.messager.alert('提示!', '保存成功!','info',function() {
							refreshPage();
						});
					}
					if (data == "false") {
						$.messager.alert('提示!', '保存失败!','error',function() {
							$("#submitId").attr("disabled", false);
						});
					} else if (data == "isExist") {
						$.messager.alert('提示!', '方案名称已存在，请重新输入!','error',function() {
							$("#submitId").attr("disabled", false);
						});
					}
				}
			});
		}
	}
	
	function refreshPage() {//取消
		window.location.href = "${path}/codefeeset/codefeesetList";
	}
</script>
</head>
<body>
	<%@include file="../../../head.jsp"%>
	<div class="wrap">
		<%@include file="subzhMaster.jsp"%>
		<div class="Rbox">
     		<div class="mainbox">
                   <h3><a href="${path}/codefeeset/codefeesetList">收费方案</a><i>/</i><a href="#" class="on">新建方案</a></h3>
                   <div class="main">
                      	<div class="Form">
                            <div class="dline">
                                <label>方案名称：</label>
			                   	<input type="text" name="title" id="title" maxlength="30" placeholder="请输入收费方案名称" value=""/>
                            </div>
                            <%--<div class="dline">
                                <label>管理费（元/天）：</label>
			                   	<input type="text" name="percentage" id="percentage" maxlength="10" placeholder="请输入管理费金额" value="" onblur="checkNum(this.value)"/>
                            </div>--%>
                            <div class="div-radio" style="display:none;">
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <label>默认方案：</label>
			                   	&nbsp;&nbsp;&nbsp;<input type="radio" name="isdefault" value="1" />是
								<input type="radio" name="isdefault" value="0" checked="checked"/>否
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