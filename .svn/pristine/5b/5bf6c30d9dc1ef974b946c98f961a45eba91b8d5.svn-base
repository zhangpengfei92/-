<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@include file="../../../head.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-Ua-Compatible" content="IE=EmulateIE8" />
<title>权限更新</title>
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
		var perids = ${perids};
		for ( var int = 0; int < perids.length; int++) {
			$("input:checkbox[value='"+perids[int]+"']").attr('checked','true');
		}
	});
	
	//会员管理全选
	function checkAllhygl(obj){
		var Ahyglcheckbox;
		if(obj.checked){
			Ahyglcheckbox = false;
		}else{
			Ahyglcheckbox = true;
		}
		if (Ahyglcheckbox) {
			//选择每个被选中的input
			$(".bx :checkbox").each(function() {
				this.checked = false;
			});
			$(".bxb :checkbox").each(function() {
				this.checked = false;
			});
			Ahyglcheckbox = false;
		} else {
			$(".bx :checkbox").each(function() {
				this.checked = true;
			});
			$(".bxb :checkbox").each(function() {
				this.checked = true;
			});
			Ahyglcheckbox = true;
		}
	}
	
	function checkAll(type){
		var chekObjlist;
		var chekObj;
		if(type == 'hygl'){
			chekObjlist = $("#hygl :checkbox");
			chekObj = $("#hyglroot");
		}
		var count = 0;
		for(var i=0 ; i < chekObjlist.length ;i++){
            if(chekObjlist[i].checked){
            	chekObj[0].checked = true;
            	count++;
        	}
		}
		if(count == 0){
			chekObj[0].checked = false;
		}
	}
	//保存
	function saveRole(){
		var regFlag = true;
		//校验用户名
		var rolename = $.trim($("#rolename").val());
		var rolename2 = '${role.rolename }';
		
		if(!rolename){
			alert("权限名称不能为空");
			return false;
		}
		if(rolename != rolename2){
			if(isExist(rolename)){
				alert("权限名称已存在");
				regFlag = false;
				return false;
			}
		} 
		//校验权限
		var checked = $("input[type='checkbox']:checked").length;
		if(checked == 0){
			alert("至少选择一项功能");
			return false;
		}
		//获取选中项
		var rightsColumnData = ""; 
		var list = $('input[name="rightsColumnData"]').filter(':checked');
        for (var i = 0; i < list.length; i++) {
        	rightsColumnData += list[i].value + ",";
        }
		//提交表单
		//$('#save_form').submit();
		//提交表单
		$("#submitId").attr("disabled", "disabled");
		if(regFlag){
			var params = {
				"id" : $("#roleId").val(),
				"rolename" : rolename,
				"rightsColumnData" : rightsColumnData
			};
			$.ajax({
				url : "${path}/membersys/saverole",
				data : params,
				type : "POST",
				async : false,
				success : function(data) {
					if (data == "true") {
						$.messager.alert('提示!', '保存成功!','info',function() {
							window.location.href = "${path}/membersys/jumproleList";
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
		var url = "${path}/membersys/isExist/role";
		var params = {
			name : rolename
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
	
	//取消，返回角色列表
	function comback(){
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
                   <h3><a href="${path}/membersys/jumproleList">权限管理</a><i>/</i><a href="#" class="on">
                    <c:if test="${role == null }">
              			新建权限
			        </c:if>
			        <c:if test="${role != null }">
			                                   修改权限
			        </c:if>
			    </a></h3>
                   <div class="main">
                   		 <h3>权限信息</h3>
						 <input type="hidden" value="${role.id }" name="roleId" id="roleId"/>
                         <div class="perbox">
                              <label>权限名称</label>
                              <p>
                              <c:if test="${role != null }">
					                <input type="text" id="rolename" name="rolename" value="${role.rolename}" readonly="readonly" maxlength="20"/>
			                    </c:if>
			                    <c:if test="${role == null }">
			                   		<input type="text" id="rolename" name="rolename" value="${role.rolename}" placeholder="请输入权限名称" maxlength="20"/>
			                    </c:if>
                              </p>
                         </div>
                         <h3>权限功能</h3>
                         <div class="pertable">
                              <table width="100%" id="hygl">
                                   <tr class="tit">
                                       <td width="20%">一级</td>
                                       <td colspan="6">权限配置细则</td>
                                   </tr>
                                   <tr style="border-bottom:1px solid #eee;">
                                       <td rowspan="5" class="fl bx">功能列表</td>
                                       <td class="bx"><div class="checkbox"><input type="checkbox" name="rightsColumnDataAll" onchange="checkAllhygl(this)" value="all" id="hyglroot"/><span>全选</span></div></td>
                                   </tr>
	                               <tr style="border-bottom:1px solid #eee;">
                                   	  <c:forEach items="${columnList1}" var="rightsColumn1" varStatus="st">
	                                      <td class="bxb"><div class="checkbox"><input type="checkbox" value="${rightsColumn1.id}" name="rightsColumnData" onchange="checkAll('hygl')"/><label for="checkbox-1"></label><span>${rightsColumn1.columnname}</span></div></td>
                                      </c:forEach>
	                               </tr>
	                               <tr style="border-bottom:1px solid #eee;">
                                   	  <c:forEach items="${columnList2}" var="rightsColumn2">
	                                      <td class="bx"><div class="checkbox"><input type="checkbox" value="${rightsColumn2.id}" name="rightsColumnData" onchange="checkAll('hygl')"/><label for="checkbox-2"></label><span>${rightsColumn2.columnname}</span></div></td>
                                      </c:forEach>
	                               </tr>
	                               <tr style="border-bottom:1px solid #eee;">
                                   	  <c:forEach items="${columnList3}" var="rightsColumn3">
	                                      <td class="bxb"><div class="checkbox"><input type="checkbox" value="${rightsColumn3.id}" name="rightsColumnData" onchange="checkAll('hygl')"/><label for="checkbox-3"></label><span>${rightsColumn3.columnname}</span></div></td>
                                      </c:forEach>
	                               </tr>
	                               <tr style="border-bottom:1px solid #eee;">
                                   	  <c:forEach items="${columnList4}" var="rightsColumn4">
	                                      <td class="bx"><div class="checkbox"><input type="checkbox" value="${rightsColumn4.id}" name="rightsColumnData" onchange="checkAll('hygl')"/><label for="checkbox-4"></label><span>${rightsColumn4.columnname}</span></div></td>
                                      </c:forEach>
	                               </tr>
	                               <tr style="border-bottom:1px solid #eee;">
                                   	  <c:forEach items="${columnList5}" var="rightsColumn5">
	                                      <td class="bxb"><div class="checkbox"><input type="checkbox" value="${rightsColumn5.id}" name="rightsColumnData" onchange="checkAll('hygl')"/><label for="checkbox-5"></label><span>${rightsColumn5.columnname}</span></div></td>
                                      </c:forEach>
	                               </tr>
	                               <tr style="border-bottom:1px solid #eee;">
                                   	  <c:forEach items="${columnList6}" var="rightsColumn6">
	                                      <td class="bx"><div class="checkbox"><input type="checkbox" value="${rightsColumn6.id}" name="rightsColumnData" onchange="checkAll('hygl')"/><label for="checkbox-6"></label><span>${rightsColumn6.columnname}</span></div></td>
                                      </c:forEach>
	                               </tr>
                                   
                              </table>
                              <div class="dline" style="text-align:center; padding:50px 0;">
                                   <button class="Submit" onclick="saveRole()" id="submitId">提交</button>
                                   <button class="Submit cancel" onclick="comback()">取消</button>
                              </div>
                         </div>
                    </div>
               </div>
          </div>
     </div>
</body>
</html>
