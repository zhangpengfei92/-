<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
 <!--头部开始-->
<%@include file="../../../head.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-Ua-Compatible" content="IE=EmulateIE8" />
<title>
	<c:if test="${sysuser == null }">添加管理员</c:if>
  	<c:if test="${sysuser != null }">修改管理员</c:if>
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
	var isIE6 = $.browser.msie && ($.browser.version == "6.0") && !$.support.style;

	//选中角色下拉框
	$(document).ready(function(){
		$("#left_a_3").addClass('on');
	 });
	
	//function funcChina(obj) {
    //    if (/.*[\u4e00-\u9fa5]+.*$/.test(obj)) {
    //        return false;
    //    }
    //    return true;
    //}
	
	function funcChina(obj) {
        if (/^[A-Za-z0-9_]*$/g.test(obj)) {
            return true;
        }
        return false;
    }

	function saveWarden(){
		var regFlag = true;
		//校验用户名
		var username = $.trim($("#username").val());
		var username2 = '${sysuser.username }';
		if(!username){
			alert("管理员用户名不能为空");
			return false;
		}
		if(username != username2){
			if(isExist(username)){
				alert("管理员用户名已存在");
				regFlag = false;
				return false;
			}
		}
		
		//校验密码
		var password = $.trim($("#password").val());
		var sysId = $("#sysid").val();
		if(sysId == null || sysId == ""){
			if(username.length < 8 || username.length > 20 || !funcChina(username)){
				alert("管理员用户名请输入8至20个字符（字母、数字、下划线）");
				regFlag = false;
				return false;
			}
		}
		if(!password){
			alert("管理员密码不能为空");
			return false;
		}
		if(password.length < 8 || password.length > 20) {
            alert('管理员密码请输入8至20位字符');
            regFlag = false;
            return false;
        }
		
		if(regFlag){
			//$('#save_form').submit();
			//提交表单
			$("#submitId").attr("disabled", "disabled");
			if(regFlag){
				var params = {
					"id" : $("#sysid").val(),
					"username" : username,
					"nickname" : $("#nickname").val(),
					"password" : password,
					"rid" : $("#rid").val()
				};
				$.ajax({
					url : "${path}/membersys/saveWarden",
					data : params,
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
						}
					}
				});
			} else {
				$("#submitId").attr("disabled", false);
			}
		}
	}
	
	//校验重复
	function isExist(username){
		var flag = false;
		
		var url = "${path}/membersys/isExist/sysuser";
		var params = {
			name : username
		};
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
					flag = true;
				}
			}
		});
		return flag;
	}
	
	//取消，返回管理员列表
	function comback(){
		//$("#save_form").attr("action", "").submit();
		window.location.href="${path}/membersys/jumpwardenList";
	}
	
	function refreshPage(){
		window.location.href="${path}/membersys/jumpwardenList";
	}
</script>
</head>
<body>
    <%@include file="../../../head.jsp"%>
	<div class="wrap">
		<%@include file="memberView.jsp"%>
		<div class="Rbox">
     		<div class="mainbox">
                    <h3><a href="${path}/membersys/jumpwardenList">系统账户</a><i>/</i><a href="#" class="on">
	                    <c:if test="${sysuser == null }">
	              			添加管理员
				        </c:if>
				        <c:if test="${sysuser != null }">
				                                   修改管理员
				        </c:if>
				    </a></h3>
                    <div class="main">
                    	<%--<form action="${path}/membersys/saveWarden" method="post" id="save_form">--%>
                    		<input type="hidden" value="${sysuser.id }" name="sysid" id="sysid"/>
                         	<div class="Form">
	                              <div class="dline">
	                                   <label>管理员用户名：</label>
	                                   <c:if test="${sysuser != null }">
					                   		<p><input type="text" value="${sysuser.username }" readonly="readonly" name="username" id="username"/></p>
					                   </c:if>
					                   <c:if test="${sysuser == null }">
					                   		<p><input type="text" name="username" id="username" maxlength="20"/></p>
					                   </c:if>
	                              </div>
	                              <div class="dline">
	                                   <label>管理员名称：</label>
	                                   <input type="text" value="${sysuser.nickname }" name="nickname" id="nickname"/>
	                              </div>
	                              <div class="dline">
	                                   <label>管理员密码：</label>
	                                   <c:if test="${sysuser != null }">
					                   		<p><input type="password" value="${sysuser.password }" name="password" id="password" style="border:1px,solid"/></p>
					                   </c:if>
					                   <c:if test="${sysuser == null }">
					                   		<p><input type="password" name="password" id="password" /></p>
					                   </c:if>
	                              </div>
	                              <div class="dline">
	                                   <label style="color:#fff;">手机号码：</label>
	                                   <input class="Submit" id="submitId" value="提交" type="button" onclick="saveWarden();"/>
	                                   <button class="Submit cancel" onclick="comback()">取消</button>
	                              </div>
	                              <div class="dline" style="display: none;">
	                              	   <p>管理员角色</p>
					                   <div id="parentart">
					                        <select name="rid" id="rid">
					                         	<c:forEach items="${roles}" var="role">
					                         		<option value="${role.id }">${role.name }</option>
					                         	</c:forEach>
					                        </select>
					                   </div>
	                   			  </div>
	                         </div>
                        <%-- </form> --%>
                    </div>
               </div>
            </div>
      </div>
    
</body>
</html>
