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
	<script type="text/javascript" src="${path}/js/jquery-1.11.3.min.js"></script>
	<!-- 引入默认css -->
	<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/icon.css" />
	<script type="text/javascript" src="${path}/js/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="${path}/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${path}/js/easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="${path}/js/My97DatePicker/WdatePicker.js"></script>
	
<script type="text/javascript">
	$(function(){
		$("#left_a_1").addClass('on');
	});

	//function funcChina(obj) {
    //    if (/.*[\u4e00-\u9fa5]+.*$/.test(obj)) {
    //        return false;
    //    }
    //    return true;
    //}
	
	function funcChina(obj) {
        if (/^[A-Za-z0-9_-]*$/g.test(obj)) {
            return true;
        }
        return false;
    }
	
	//整数验证
	function checkInt(strValue, strName) {
		var regu = /^[1-9]([0-9])*$/;
	    if(regu.test(strValue) == false){
	    	 //alert(strName + "请输入正整数！");
	    	 $.messager.alert('提示', strName + "请输入正整数！", 'info');
	    	 return false;
	     }
	     return true;
	}
	
	//保存
	function saveUser() {
		var regFlag = true;
		var id = $.trim($("#userId").val());
		var username = $.trim($("#username").val());
		if (username == null || username == "") {
			//alert('账户名称不能为空!');
			$.messager.alert('提示', "账户名称不能为空!", 'info');
			return false;
		}
		if(username.length < 4 || username.length > 16 || !funcChina(username)){
			//alert("账户名称请输入4至16个字符（字母、数字、下划线）");
			$.messager.alert('提示', "账户名称请输入4至16个字符（字母、数字、下划线）", 'info');
			regFlag = false;
			return false;
		}
		var startnum = $.trim($("#startnum").val());
		if (startnum != null && startnum != "") {
			//整数验证
			if(!checkInt(startnum, "起始编号")){
				regFlag = false;
	            return false;
	        }
		}
		
		var minver = $.trim($("#minver").val());
		if (minver == null || minver == "") {
			//alert('数量不能为空!');
			$.messager.alert('提示', "数量不能为空!", 'info');
			return false;
		}
		//整数验证
		if(!checkInt(minver, "数量")){
			regFlag = false;
            return false;
        }
		//校验密码
		var password = $.trim($("#password").val());
		var roleId = $("#roleId").val();
		if (roleId == null || roleId == "") {
			//alert('请先添加权限!');
			$.messager.alert('提示', "请先添加权限!", 'info');
			return false;
		}
		$("#formDiv").html("");
		$("#formDiv").html("<img src=\"${path}/image/load.gif\" style=\"width:500px; height:450px;\"/>");
		var starttime = $.trim($("#starttime").val());
		var endtime = $.trim($("#endtime").val());
		if (roleId != "1") {
			if (starttime == null || starttime == "") {
				//alert('权限起始日期不能为空!');
				$.messager.alert('提示', "权限起始日期不能为空!", 'info');
				regFlag = false;
				return false;
			}
			if (endtime == null || endtime == "") {
				//alert('权限结束日期不能为空!');
				$.messager.alert('提示', "权限结束日期不能为空!", 'info');
				regFlag = false;
				return false;
			}
		}
		var infoMsg = $("#infoMsg").val();
		if(regFlag){
			$.ajax({
				url : "${path}/member/saveUserMore",
				data : {
					'username' : username,
					'minver' : minver,
					'password' : password,
					'usertype' : roleId,
					'info' : infoMsg,
					'starttimeStr':starttime,
					'endtimeStr':endtime,
					'startnum':startnum,
					'id' : id
				},
				type : "POST",
				async : false,
				success : function(data) {
					if (data == "true") {
						//$.jBox.tip('保存成功');
						//$.messager.alert("提示!", '保存成功!', 'info',
						//	function() {
						refreshPage();
						//});
					} else if (data == "false") {
						//$.jBox.tip('保存失败', 'error');
						//$("#submitId").attr("disabled", false);
						$.messager.alert("提示!", '保存失败!', 'error',
							function() {
							$("#submitId").attr("disabled", false);
						});
					} else {
						//alert(data);
						$.messager.alert("提示!", "系统已存在账户："+data+"，其他账户添加成功。", 'error',
							function() {
							refreshPage();
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
                   <h3><a href="${path}/member/jumpcommonmember">账户列表</a><i>/</i><a href="#" class="on">批量添加账户</a></h3>
                   <div class="main">
        		   		<input type="hidden" value="${user.id }" name="userId" id="userId"/>
                      	<div class="Form" id="formDiv">
                            <div class="dline">
                                <label>账户名称：</label>
			                   	<p><input type="text" name="username" id="username" maxlength="16" placeholder="请输入账户名称前缀(4-16位)"/></p>
                            </div>
                            <div class="dline">
                                <label>起始编号：</label>
			                   	<p><input type="text" name="startnum" id="startnum" maxlength="4" placeholder="如输入21，账户名称：前缀+0021"/></p>
                            </div>
                            <div class="dline">
                                <label>数量：</label>
			                   	<p><input type="text" name="minver" id="minver" maxlength="4" placeholder="批量生成数量(1-9999)"/></p>
                            </div>
                            <div class="dline">
                                <label>账户密码：</label>
		                   		<p><input type="password" name="password" id="password" maxlength="20" placeholder="请输入账户密码"/></p>
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
                                 <input type="text" value="<fmt:formatDate value="${user.starttime}" type="both"/>" id="starttime" name="starttime"  
                                 class="Wdate" style="width:180px;" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" placeholder="起始日期"/><span class="xian">~</span>
                                 <input type="text" value="<fmt:formatDate value="${user.endtime}" type="both"/>" id="endtime" name="endtime" 
                                 class="Wdate" style="width:180px;" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'starttime\')}'})" placeholder="结束日期"/>
                            </div>
                            <div class="dline">
                                 <label style="color:#fff;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                                 <button class="Submit" onclick="saveUser();" id="submitId">提交</button>
                                 <button class="Submit cancel" onclick="refreshPage();">取消</button>
                            </div>
                       </div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>