<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-Ua-Compatible" content="IE=EmulateIE8" />
<title>账户列表-新建账户</title>
	<link rel="stylesheet" type="text/css" href="${path}/css/style.css" />
	<script type="text/javascript" src="${path}/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="${path}/js/My97DatePicker/WdatePicker.js"></script>

	<!-- 引入默认css -->
	<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/icon.css" />
	<script type="text/javascript" src="${path}/js/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="${path}/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${path}/js/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	$(function(){
		$("#left_a_1").addClass('on');
		
		var usertypeValue = $("#usertypeValue").val();
		if(usertypeValue != null && usertypeValue != ""){
			$("#roleId").val(usertypeValue);
		}
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
	
	//保存
	function saveUser() {
		var regFlag = true;
		var id = $.trim($("#userId").val());
		var username = $.trim($("#username").val());
		if (username == null || username == "") {
			$.messager.alert('提示', "账户名称不能为空!", 'info');
			return false;
		}
		if(username.length < 8 || username.length > 20 || !funcChina(username)){
			//alert("账户名称请输入8至20个字符（字母、数字、下划线）");
			$.messager.alert('提示', "账户名称请输入8至20个字符（字母、数字、下划线）", 'info');
			regFlag = false;
			return false;
		}
		//校验密码
		var password = $.trim($("#password").val());
		if(!password){
			//alert("账户密码不能为空");
			$.messager.alert('提示', "账户密码不能为空!", 'info');
			return false;
		}
		if(password.length < 8 || password.length > 20) {
            //alert('账户密码请输入8至20位字符');
            $.messager.alert('提示', "账户密码请输入8至20位字符", 'info');
            regFlag = false;
            return false;
        }
		var roleId = $("#roleId").val();
		if (roleId == null || roleId == "") {
			//alert('请先添加权限!');
			$.messager.alert('提示', "请先添加权限!", 'info');
			return false;
		}
		var starttime = $.trim($("#starttime").val());
		var endtime = $.trim($("#endtime").val());
		if (roleId != "1") {
			if (starttime == null || starttime == "") {
				$.messager.alert('提示', "权限起始日期不能为空!", 'info');
				regFlag = false;
				return false;
			}
			if (endtime == null || endtime == "") {
				$.messager.alert('提示', "权限结束日期不能为空!", 'info');
				regFlag = false;
				return false;
			}
		}
		var phone = $.trim($("#telephone").val());
		var infoMsg = $("#infoMsg").val();
		if(regFlag){
			$.ajax({
				url : "${path}/member/editUser",
				data : {
					'username' : username,
					'password' : password,
					'usertype' : roleId,
					'info' : infoMsg,
					'starttimeStr':starttime,
					'endtimeStr':endtime,
					'telephone' : phone,
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
					} else if (data == "fasle") {
						$.messager.alert('提示!', '用户名已存在，请重新输入!','error',function() {
							$("#submitId").attr("disabled", false);
						});
					} else if (data == "dateFalse") {
						$.messager.alert('提示!', '起始日期不能大于结束日期!','error',function() {
							$("#submitId").attr("disabled", false);
						});
					}
				}
			});
		}
	}
	
	function refreshPage() {//取消
		window.location.href = "${path}/member/jumpcommonmember";
	}
</script>
</head>
<body>
	<%@include file="../../../head.jsp"%>
	<div class="wrap">
		<%@include file="memberView.jsp"%>
		<div class="Rbox">
     		<div class="mainbox">
                   <h3><a href="${path}/member/jumpcommonmember">账户列表</a><i>/</i><a href="#" class="on">
                    <c:if test="${user == null }">
              			新建账户
			        </c:if>
			        <c:if test="${user != null }">
			                                   修改账户
			        </c:if>
			    </a></h3>
                   <div class="main">
        		   		<input type="hidden" value="${user.id }" name="userId" id="userId"/>
                      	<div class="Form">
                            <div class="dline">
                                <label>账户名称：</label>
                                <c:if test="${user != null }">
					                  <p><input type="text" value="${user.username }" readonly="readonly" name="username" id="username"/></p>
			                    </c:if>
			                    <c:if test="${user == null }">
			                   		<p><input type="text" name="username" id="username" maxlength="20" placeholder="请输入账户名称"/></p>
			                    </c:if>
                            </div>
                            <div class="dline">
                                <label>账户密码：</label>
		                   		<p><input type="password" name="password" id="password" value="${user.password}" maxlength="20" placeholder="请输入账户密码"/></p>
                            </div>
                            <div class="dline">
                                 <label>账户收费(元/年)：</label>
                                 <input type="text" value="${user.info}" id="infoMsg" name="infoMsg"/>
                            </div>
                            <div class="dline">
                                <label>账户权限：</label>
			                    <div id="parentart" class="dselect">
			                        <select name="roleId" id="roleId">
			                         	<c:forEach items="${rightsRoles}" var="role">
			                         		<option value="${role.id}">${role.rolename}</option>
			                         	</c:forEach>
			                        </select>
			                    </div>
                            </div>
                            <div class="dline">
                                 <label>权限时间：</label>
                                 <input type="text" value="${starttimeStr}" id="starttime" name="starttime"  
                                 class="Wdate" style="width:180px;" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" placeholder="起始日期"/><span class="xian">~</span>
                                 <input type="text" value="${endtimeStr}" id="endtime" name="endtime" 
                                 class="Wdate" style="width:180px;" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'starttime\')}'})" placeholder="结束日期"/>
                            </div>
                            <div class="dline">
                                 <label>手机号码：</label>
                                 <input type="text" value="${user.telephone}" id="telephone" name="telephone"/>
                            </div>
                            <div class="dline">
                                 <label style="color:#fff;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                                 <button class="Submit" onclick="saveUser();" id="submitId">提交</button>
                                 <button class="Submit cancel" onclick="refreshPage();">取消</button>
                            </div>
                            <input type="hidden" value="${user.usertype}" id="usertypeValue" name="usertypeValue"/>
                       </div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>