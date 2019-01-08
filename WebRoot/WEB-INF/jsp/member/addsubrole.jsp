<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@include file="../../../head.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-Ua-Compatible" content="IE=EmulateIE8" />
<title> 
	<c:if test="${role == null }"> 添加子栏目</c:if>
    <c:if test="${role != null }"> 修改子栏目</c:if>
</title>
	<link rel="stylesheet" type="text/css" href="${path}/css/style.css" />
	<script type="text/javascript" src="${path}/js/jquery-1.11.3.min.js"></script>
	<!-- 引入默认css -->
	<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/icon.css" />
	<script type="text/javascript" src="${path}/js/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="${path}/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${path}/js/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">

	$(document).ready(function() {
		$("#left_a_2").addClass('on');
	});

	//保存
	function saveRightsColumn(){
		//校验用户名
		var rolename = $.trim($("#rolename").val());
		
		if(!rolename){
			alert("子栏目名称不能为空");
			return false;
		}
		var regFlag = true;
		if(isExist(rolename)){
			alert("子栏目名称已存在");
			regFlag = false;
			return false;
		}
		//提交表单
		$("#submitId").attr("disabled", "disabled");
		if(regFlag){
			$.ajax({
				url : "${path}/membersys/saveRightsColumn",
				data : {
					'columnname' : rolename,
					'status' : 1
				},
				type : "post",
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
					}
				}
			});
		} else {
			$("#submitId").attr("disabled", false);
		}
	}
	
	//校验角色名称时候存在
	function isExist(rolename){
		var flag = false;
		var url = "${path}/membersys/isExistColumn";
		var params = {
			name : rolename
		};
		$.ajax({
			type : "POST",
			url : url,
			data : params,
			async : false, 
			error : function() {
				alert("error!");
			},
			success : function(data) {
				if(data == 'true'){
					flag = true;
				}
			}
		});
		return flag;
	}
	
	//取消，返回角色列表
	function comback(){
		 window.location.href = "${path}/membersys/jumproleList";
	}
	
	function refreshPage() {//取消
		window.location.href = "${path}/membersys/jumproleList";
	}
	
</script>

</head>
<body>
    <%@include file="../../../head.jsp"%>
	<div class="wrap">
		<%@include file="memberView.jsp"%>
		<div class="Rbox">
     		<div class="mainbox">
            	<h3><a href="${path}/membersys/jumproleList">权限管理</a><i>/</i><a href="#" class="on">新建子栏目</a></h3>
                <div class="main">
                 	<div class="Form">
                         <div class="dline">
                          	<label>子栏目名称：</label>
                          	<p><input type="text" id="rolename" name="name" value="${role.name}" placeholder="请输入子栏目名称"/></p>
	                     </div>
	                     <div class="dline">
	                          <label style="color:#fff;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
	                          <button class="Submit" onclick="saveRightsColumn()" id="submitId">提交</button>
	                          <button class="Submit cancel" onclick="comback()">取消</button>
	                     </div>
	                </div>
                 </div>
              </div>
          </div>
     </div>
</body>
</html>
