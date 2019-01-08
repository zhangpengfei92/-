<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>风控方案</title>
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
		var riskTemplateIdValue = $("#riskTemplateIdValue").val();
		if(riskTemplateIdValue != null && riskTemplateIdValue != ""){
			$("#riskTemplateId").val(riskTemplateIdValue);
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
		window.location.href="${path}/cost/editRiskTempall?id="+id;
	}
	
	//查询
	function serach(pageNum) {
		if (pageNum == 0) {
			pageNum = 1;
		}
		var form = document.getElementById("form1");
		form.action = "${path}/cost/selectPageRiskTemplateList?pageNum=" + pageNum;
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
	function refreshPage() {
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
	
	//***********************上传文件*************************
	var FileObj, FileExt, ErrMsg, FileMsg, HasCheked;//全局变量 图片相关属性

	//以下为限制变量
	var AllowExt = ".xls|.xlsx|";//允许上传的文件类型 ŀ为无限制 每个扩展名后边要加一个"|" 小写字母表示

	HasChecked = false;

	function ShowMsg(msg, tf) //显示提示信息 tf=true 显示文件信息 tf=false 显示错误信息 msg-信息内容
	{
		msg = msg.replace("\n", "<li>");
		msg = msg.replace(/\n/gi, "<li>");
		if (!tf) {
			FileObj.outerHTML = FileObj.outerHTML;
			//MsgList.innerHTML = msg;
			$.messager.alert('提示', msg, 'info');
			HasChecked = false;
		} else {
			//PreviewImg.innerHTML = "非图片文件";
			//MsgList.innerHTML = msg;
			HasChecked = true;
		}
	}
	
	function checkExt(obj) {
		ErrMsg = "";
		FileMsg = "";
		FileObj = obj;
		HasChecked = false;
		if (obj.value == "") {
			return false;
		}
		//MsgList.innerHTML = "文件信息处理中...";
		FileExt = obj.value.substr(obj.value.lastIndexOf(".")).toLowerCase();
		if (AllowExt != 0 && AllowExt.indexOf(FileExt + "|") == -1) //判断文件类型是否允许上传
		{
			ErrMsg = "\n该文件类型不允许上传。请上传 .xls 或 .xlsx 类型的文件，当前文件类型为" + FileExt;
			ShowMsg(ErrMsg, false);
			return false;
		}

	}
</script>
<body>
	<%@include file="../../../head.jsp"%>
	<div class="wrap">
		<%@include file="subzhMaster.jsp"%>
		<div class="Rbox">
            <div class="mainbox">
                <h3><a href="${path}/cost/riskStockList">品种</a><i>/</i><a href="#" class="on">导入</a></h3>
                 <div class="main">
                      	<div class="Form">
	                            <div class="dline">
	                                <label>方案名称：</label>
                                    <p>
                                    	<select id="parentid" name="parentid" class="selectCss">
			                           		<c:forEach items="${menulist}" var="riskTempall">
										    	<option value="${riskTempall.id}">${riskTempall.type}</option>
									        </c:forEach>
							        	</select>
                                 	</p>
                                 </div>
	                             <div class="dline"><label>&nbsp;&nbsp;&nbsp;类型：</label>
	                                <p><select id="type" name="type" onclick="checkSelectType()" class="selectCss">
											    <option value="1" >白名单</option>
											    <option value="2" >黑名单</option>
									        </select>
	                                     </p>
	                             </div>
		                         <div class="dline">
		                            <label>模板下载：</label>
		                            <label><a href="${path}/uploadfiles/model.xlsx" style="float:left;">名单模板</a>&nbsp;&nbsp;</label>
		                         </div>
		                         <div class="dline">
		                         	<form id="infoInputForm" name="infoInputForm" method="post" action="${path}/cost/importStock" enctype="multipart/form-data">
		                         	
		                            	<label style="float:left;">名单上传：</label>
		                                <input type="file" id="myFile" name="file" onchange="checkExt(this)" class="input_text" style="float: left;padding-top:4px;"/>
			                            <p>
		                          		</p>
		                                <%--<p style="color: red;width: 195px;padding-top: 5px;">(注：当前提交名单为<span id="stockTypeValue">白名单</span>)</p>
		                                --%><input type="hidden" id="menuId" name="menuId" value=""/>
		                                <input type="hidden" id="paramId" name="paramId" value=""/>
		                         	</form>
		                         </div>
		                         <div class="dline">
	                            	<label style="color:#fff;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
	                                <button class="Submit" onclick="clickSave();" id="submitId">提交</button>
	                                <button class="Submit cancel" onclick="refreshPage()">取消</button>
	                            </div>
                        </div>
                    </div>
               </div>
          </div>
     </div>
</body>
</html>