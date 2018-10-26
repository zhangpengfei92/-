<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>风控方案 - 个股设置</title>
	<link rel="stylesheet" type="text/css" href="${path}/css/style.css" />
	<script type="text/javascript" src="${path}/js/jquery-1.11.3.min.js"></script>
	<!-- 引入默认css -->
	<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/icon.css" />
	<script type="text/javascript" src="${path}/js/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="${path}/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${path}/js/easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
	<style type="text/css">
		.otherCss{ height:32px;border-bottom:1px solid #e9e9e9;}
		.otherCss li {float: left;cursor: pointer;display: block;width: 130px;text-align: center;height: 32px;line-height: 32px;background: #ddd; margin-right: 15px;}
		.otherCss li.select{background:#1890ff;color:#fff;}
	</style>
<script type="text/javascript">
	$(function(){
		//$("#left_a_2").addClass('on');
		var riskTemplateIdValue = $("#parentidValue").val();
		if(riskTemplateIdValue != null && riskTemplateIdValue != ""){
			$("#parentid").val(riskTemplateIdValue);
		}
		var usertypeValue = $("#usertypeValue").val();
		if(usertypeValue != null && usertypeValue != ""){
			$("#usertype").val(usertypeValue);
		}
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

	//通过
	function reinstate(id) {
		$.messager.confirm('提示', '是否确定删除此记录?', function(yn) {
			if (yn) {
				$.ajax({
					url : "${path}/cost/deleteRiskTempall",
					type : "post",
					data : {
						"id" : id
					},
					traditional : true,
					dataType : "text",
					success : function(data) {
						if (data == "true") {
							$.messager.alert('提示!', '成功删除此记录!', 'info',
							function() {
								parent.RefreshPage();
							});
						}
						if (data == "false") {
							$.messager.alert('提示!', '删除此账号记录失败!', 'error',
							function() {
								parent.RefreshPage();
							});
						}
					}
				});
			}
		})
	}
	
	//查询
	function serach(pageNum) {
		if (pageNum == 0) {
			pageNum = 1;
		}
		var form = document.getElementById("form1");
		form.action = "${path}/cost/selectPageRiskStockList?pageNum=" + pageNum;
		form.submit();
	}
	
	//翻页
	function tzfy() {

		var pageNum = $.trim($("#pageNum").val());
		if (!pageNum) {
			$.messager.alert('提示', '请输入页码!', 'info');
			return false;
		}
		var pages = $.trim($("#pages").val());
		if (pageNum*1 > pages*1) {
			$.messager.alert('提示', '输入的页数无效!', 'info'); 
			return false;
		}
		serach(pageNum);
	}

	//刷新页面
	function RefreshPage() {
		window.location.href = "${path}/cost/riskStockList";
	}
	
	function setNext(){//重置
		$("#nickname").val("");
	}
	
	function clickSave() {
    	/* 文件不能为空 */
		var myFile = $.trim($("#myFile").val());
		if(myFile == "" || myFile == null){
			//alert("上传数据不能为空！");
			$.messager.alert('提示', '上传数据不能为空！', 'info'); 
			return false;
		}
		
		var menuId = $("#parentid").val();
		if(menuId == "" || menuId == null){
			//alert("请先添加风控全局方案！");
			$.messager.alert('提示', '请先添加风控全局方案！', 'info'); 
			return false;
		} else {
			var parentid = $("#parentid").val();
			$("#menuId").val(parentid);
			$("#paramId").val($("#type").val());
			//文章保存
			$("#submit_btn").attr("disabled", "disabled");
			$("#infoInputForm").submit();
		}
    }
	
	function changePage(value){//tab切换
		window.location.href = value;
	}
	
	//名单类型
	function checkSelectType(value) {
		var value = $("#type").val();
		if(value == "1"){
			$("#stockTypeValue").html("白名单");
		} else if(value == "2"){
			$("#stockTypeValue").html("黑名单");
		} else if(value == "3"){
			$("#stockTypeValue").html("策略名单");
		}
	}
	
	function addRiskStock(){//tab切换
		window.location.href = "${path}/cost/inputRiskStock";
	}
	
</script>
<body>
	<%@include file="../../../head.jsp"%>
	<div class="wrap">
		<%@include file="subzhMaster.jsp"%>
		<div class="Rbox">
            <div class="mainbox">
                 <h3><a href="${path}/cost/riskTemplateList" class="on">风控方案</a></h3>
                 <div class="main">
                 	  <ul class="otherCss">
                        	<li onclick="changePage('${path}/cost/riskTemplateList');">市场</li>
                        	<li class="select" onclick="changePage('${path}/cost/riskStockList');">品种</li>
                        	<%--<li onclick="changePage('${path}/cost/riskHolderList');">持仓比例</li>
                      --%></ul>
                      <div class="Inputbox" style="padding-top: 15px;">
                      	    <input type="hidden" id="parentidValue" name="parentidValue" value="${parentid}"/>
                      	    <input type="hidden" id="usertypeValue" name="usertypeValue" value="${usertype}"/>
		                   	<form id="form1" method="post" style="float:left;">
		                   		<p><label>合约代码：</label>
	                                <input id="nickname" name="nickname" type="text" class="input_text" value="${nickname}"/>
	                            </p>
	                            <p>
	                                <label>方案名称：</label>
                                    <select id="parentid" name="parentid" class="selectCss">
		                           		<c:forEach items="${menulist}" var="riskTempall">
									    	<option value="${riskTempall.id}">${riskTempall.type}</option>
								        </c:forEach>
							        </select>
                                 </p>
	                             <p><label>&nbsp;&nbsp;&nbsp;类型：</label>
	                                
                                      <select id="usertype" name="usertype" onclick="checkSelectType()" class="selectCss">
									    <option value="1" >白名单</option>
									    <option value="2" >黑名单</option>
							        </select>
                                 </p>
	                             <p>
	                              &nbsp;&nbsp;<button class="cx" onclick="serach('1')">查询</button>
	                           </p>
	                         </form>
	                         <p class="rbutbox">
                           		<button class="cx xbuild" onclick="addRiskStock();">导入</button>
                           </p>
	                         <%--<p>
	                            <label>模板下载：</label>
	                            <label><a href="${path}/uploadfiles/model.xlsx" style="float:left;">名单模板</a>&nbsp;&nbsp;</label>
	                         </p>
	                         <br/>
	                         <form id="infoInputForm" name="infoInputForm" method="post" action="${path}/cost/importStock" enctype="multipart/form-data">
	                         	<p style="float:left;">
	                            	<label style="float:left;">名单上传：</label>
	                                <input type="file" id="myFile" name="file" onchange="checkExt(this)" class="input_text" style="float: left;padding-top:4px;"/>
		                            <button class="cx" onclick="clickSave();">提交</button>
	                          	</p>
                                <p style="color: red;width: 195px;padding-top: 5px;">(注：当前提交名单为<span id="stockTypeValue">白名单</span>)</p>
                                <input type="hidden" id="menuId" name="menuId" value=""/>
                                <input type="hidden" id="paramId" name="paramId" value=""/>
	                         </form>
                        --%></div>
                        <div class="mtable">
                           <table width="100%;">
	                           <tr class="tit">
								<td width="5%">序号</td>
								<td>合约代码</td>
								<td>合约名称</td>
								<td>类型</td>
								<td width="18%">操作</td>
							</tr>
	                      	<c:forEach items="${userlist}" var="user" varStatus="st">
								<tr>
									<td>${st.count}</td>
									<td>${user.stockcode}</td>
									<td>${user.stockname}</td>
									<td>
										<c:choose>
											<c:when test="${user.type==1}">白名单</c:when>
											<c:when test="${user.type==2}">黑名单</c:when>
											<c:when test="${user.type==3}">策略名单</c:when>
										</c:choose>
									</td>
									<td>
										<a href="javascript:;" onclick="reinstate('${user.id}')" id="${user.id}">删除</a>
									</td>
								</tr>
							</c:forEach>
						</table>
		 				</div>
		 				<div class="page">
							<c:choose>
									<c:when test="${userpage.pages==0}">0/${userpage.pages}</c:when>
									<c:otherwise>${userpage.pageNum}/${userpage.pages}</c:otherwise>
								</c:choose> 共<i>${userpage.pages}</i>页
							<a class="bs" href="javascript:;" onclick="serach('1')">首页</a>
							<input type="hidden" value="${userpage.pages}" id="pages" />
							<c:if test="${userpage.pageNum!=1}">
								<a class="bs" href="javascript:;" onclick="serach('${userpage.prePage}')">上一页</a>
							</c:if>
							<c:if test="${userpage.pageNum!=userpage.pages}">
								<a class="bs" href="javascript:;" onclick="serach('${userpage.nextPage}')">下一页</a>
							</c:if>
							<a class="bs" href="javascript:;" onclick="serach('${userpage.pages}')">尾页</a>
							<a ><input type="text" id="pageNum" value="${userpage.pageNum}" style="height: 30px;line-height: 30px;padding: 0 5px;"/></a>
							<a style="cursor: pointer;" type="button" onclick="tzfy()">跳转</a>
						</div>
                    </div>
               </div>
          </div>
     </div>
</body>
</html>