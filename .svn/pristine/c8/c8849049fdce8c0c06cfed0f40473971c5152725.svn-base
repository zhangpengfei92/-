<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-Ua-Compatible" content="IE=EmulateIE8" />
<title>权限管理</title>
	<link rel="stylesheet" type="text/css" href="${path}/css/style.css" />
	<script type="text/javascript" src="${path}/js/jquery-1.11.3.min.js"></script>
	<!-- 引入默认css -->
	<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/icon.css" />
	<script type="text/javascript" src="${path}/js/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="${path}/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${path}/js/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	$(function(){
		$("#left_a_2").addClass('on');
	});
	/* 全选和反选 */
	var Acheckbox = false;
	function checkAll() {
		if (Acheckbox) {
			//选择每个被选中的input
			$(":checkbox").each(function() {
				this.checked = false;
			});
			Acheckbox = false;
		} else {
			$(":checkbox").each(function() {
				this.checked = true;
			});
			Acheckbox = true;
		}
	
	}

	/* 批量删除 */
	function deleteRole() {
		var ids = [];
		$("input[name='id']:checked").each(function(i) {
			ids[i] = $(this).val();
		});
		if (ids == null || ids == "") {
			alert("请至少选择一行！");
			return false;
		}
		$.ajax({
			url : "${path}/membersys/deleteRole",
			type : "post",
			data : {
				"ids" : ids
			},
			traditional : true,
			dataType : "text",
			success : function(data) {
				if (data == "true") {
					alert("删除成功！");
					parent.RefreshPage();
				}
				if (data == "false") {
					alert("删除失败！");
					parent.RefreshPage();
				}
			}

		});
	}
	
	//删除单个
	function deleteRoleOne(id){
		$.ajax({
			url : "${path}/membersys/deleteRoleOne",
			type : "post",
			dataType : "text",
			data : {
				'id' : id
			},
			success : function(obj) {
				if (obj == "true") {
					alert("删除成功！");
					RefreshPage();
				}
				if (obj == "false") {
					alert("删除失败！");
					RefreshPage();
				}
			}
	
		}); 
	}
	
	//搜索
	function serchRole(){
		var name = $.trim($("#title").val());
		window.location.href = "${path}/membersys/jumproleList?name="+name;
	}
	
	//刷新页面
	function RefreshPage() {
		window.location.href = "${path}/membersys/jumproleList";
	}
	
	//新建权限
	function addRole() {
		window.location.href = "${path}/membersys/jumpAddRole";
	}
	
	//新建栏目
	function addSubRole() {
		window.location.href = "${path}/membersys/jumpAddSubRole";
	}
	
</script>
</head>
<body>
	<%@include file="../../../head.jsp"%>
	<div class="wrap">
		<%@include file="memberView.jsp"%>
		<div class="Rbox">
            <div class="mainbox">
                 <h3><a href="javascript:;" class="on">权限管理</a></h3>
                 <div class="main">
                      <div class="Inputbox">
                           <p><label>权限名称：</label><input type="text" id="title" value="${name}" placeholder="请输入"/></p>
                           <p>
                               <button class="cx" onclick="serchRole();">查询</button>
                           </p>
                           <p class="rbutbox">
	                           <button class="cx xbuild" onclick="addRole();">新建</button>
	                           <button class="cx xbuild" onclick="addSubRole();">栏目</button>
                           </p>
                      </div>
                      <div class="mtable">
                           <table width="100%;">
                                <tr class="tit">
			                       <td width="5%">序号</td>
			                       <td>权限名称</td>
			                       <td>功能列表</td>
			                       <td width="10%">权限标识</td>
			                       <td width="10%">操作</td>
			                   </tr>
			                   <c:forEach items="${rightsRoles}" var="role" varStatus="s">
				                   <tr>
				                       <td width="5%">${s.count}</td>
				                       <td>${role.rolename}</td>
				                       <td>${role.descript}</td>
				                       <td>${role.id}</td>
				                       <td><a href="${path}/membersys/jumpAddRole?id=${role.id}">编辑</a>
				                       <c:if test="${role.id != 1 }"><em>|</em>&nbsp;&nbsp;
				                       <a style="cursor: pointer;" onclick="deleteRoleOne(this.id)" id="${role.id}">删除</a></c:if></td>
				                   </tr>
			                   </c:forEach>
							</table>
		 				</div>
                    </div>
              </div>
          </div>
     </div>
</body>
</html>
