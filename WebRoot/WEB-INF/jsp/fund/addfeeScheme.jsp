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
	
	//保存
	function saveUser() {
		var regFlag = true;
		var id = $.trim($("#lsh").val());
		var username = $.trim($("#schemename").val());
		if (username == null || username == "") {
			$.messager.alert('提示', "方案名称不能为空!", 'info');
			return false;
		}
		
		if(regFlag){
			$.ajax({
				url : "${path}/cost/editfeeSchemeMsg",
				data : {
					'schemename' : username,
					'agentzh' : $("#agentzh").val(),
					'id' : id
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
		window.location.href = "${path}/cost/feeSchemeList";
	}
</script>
</head>
<body>
	<%@include file="../../../head.jsp"%>
	<div class="wrap">
		<%@include file="subzhMaster.jsp"%>
		<div class="Rbox">
     		<div class="mainbox">
                   <h3><a href="${path}/cost/feeSchemeList">收费方案</a><i>/</i><a href="#" class="on">
	                    <c:if test="${user == null }">
	              			新建方案
				        </c:if>
				        <c:if test="${user != null }">
				                                   修改方案
				        </c:if>
			       </a></h3>
                   <div class="main">
        		   		<input type="hidden" value="${user.lsh}" name="lsh" id="lsh"/>
        		   		<input type="hidden" value="${user.agentzh}" id="agentzh" name="agentzh"/>
                      	<div class="Form">
                            <div class="dline">
                                <label>方案名称：</label>
			                   	<p><input type="text" name="schemename" id="schemename" maxlength="30" placeholder="请输入收费方案名称" value="${user.schemename}"/></p>
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