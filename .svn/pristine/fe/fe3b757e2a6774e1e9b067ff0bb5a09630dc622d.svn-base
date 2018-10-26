<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-Ua-Compatible" content="IE=EmulateIE8" />
<title>系统账户</title>
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
		//$("#left_a_3").addClass('on');
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
	function deleteWarden() {
		var sessionid =  ${sessionScope.SESSION_ACCOUNTID };
		var ids = [];
		var hasnowsys = false;
		$("input[name='id']:checked").each(function(i) {
			ids[i] = $(this).val();
			if($(this).val() == sessionid){
				hasnowsys = true;
			}
		});
		if(hasnowsys){
			alert("删除列表中存在当前登陆用户，请重新选择");
			return false;
		}
		if (ids == null || ids == "") {
			alert("请至少选择一行！");
			return false;
		}
		$.ajax({
			url : "${path}/membersys/deleteWarden",
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
				if (data == "admin") {
					alert("删除完成！admin为默认用户，已保留！");
					parent.RefreshPage();
				}
			}

		});
	}
	
	//删除单个
	function deleteWardenOne(id){
		var sessionid =  ${sessionScope.SESSION_ACCOUNTID };
		if(sessionid == id ){
			alert("无法删除当前管理员");
			return false;
		}
		
		$.ajax({
			url : "${path}/membersys/deleteWardenOne",
			type : "post",
			dataType : "text",
			data : {
				'id' : id
			},
			success : function(obj) {
				if (obj == "true") {
					$.messager.alert('提示!', '保存成功!','info',function() {
						RefreshPage();
					});
				}
				if (obj == "false") {
					$.messager.alert('提示!', '保存失败!','error',function() {
						RefreshPage();
					});
				}
				if (obj == "admin") {
					alert("admin不允许删除！");
				}
			}

		}); 
	}
	
	
	//搜索
	function serchWarden(){
		var username = $.trim($("#title").val());
		window.location.href = "${path}/membersys/jumpwardenList?username="+username;
	}
	
	//刷新页面
	function RefreshPage() {
		window.location.href = "${path}/membersys/jumpwardenList";
	}
	
	function funAddWarden() {
		window.location.href = "${path}/membersys/jumpAddWarden";
	}
	
</script>

</head>
<body>
	<%@include file="../../../head.jsp"%>
	<div class="wrap">
		<%@include file="../fund/subzhMaster.jsp"%>
		<div class="Rbox">
            <div class="mainbox">
                 <h3><a href="${path}/membersys/jumpwardenList" class="on">系统账户</a></h3>
                 <div class="main">
                      <div class="Inputbox">
                           <p><label>管理员用户名：</label><input type="text" id="title" value="${username}" placeholder="请输入"/></p>
                           <p>
                              <button class="cx" onclick="serchWarden();">查询</button>
                           </p>
                           <p class="rbutbox">
                           		<button class="cx xbuild" onclick="funAddWarden();">添加</button>
                           		<%--<button class="cz" onclick="deleteWarden();">删除</button>--%>
                           </p>
                      </div>
                      <div class="mtable">
                           <table width="100%;">
                           		<tr class="tit">
			                       <%--<td width="5%"><input type="checkbox" onclick="checkAll()"/></td>--%>
			                       <td width="5%">序号</td>
			                       <td>管理员用户名</td>
			                       <td>管理员名称</td>
			                       <td>管理员密码</td>
			                       <td>创建时间</td>
			                       <td width="10%">操作</td>
			                   </tr>
			                   <c:forEach items="${sysusers}" var="sysuser" varStatus="s">
				                   <tr>
				                       <%--<td width="5%"><input type="checkbox" name="id" id="id" value="${sysuser.id}"/></td>--%>
				                       <td width="5%">${s.count}</td>
				                       <td>${sysuser.username}</td>
				                       <td>${sysuser.nickname}</td>
				                       <td>${sysuser.password}</td>
				                       <td><fmt:formatDate value="${sysuser.modifytime}" pattern="yyyy-MM-dd hh:mm:ss" /></td>
				                       <td><a href="${path}/membersys/jumpAddWarden?id=${sysuser.id}">编辑</a>
				                       <c:if test="${sysuser.username != 'admin' }"><em>|</em>&nbsp;&nbsp;
				                       <a style="cursor: pointer;" onclick="deleteWardenOne(this.id)" id="${sysuser.id}">删除</a></c:if></td>
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
