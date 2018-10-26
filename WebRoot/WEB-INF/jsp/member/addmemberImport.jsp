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
	<link rel="stylesheet" type="text/css" href="${path}/css/msgbox/jbox.css" />
	<link rel="stylesheet" type="text/css" href="${path}/css/jquery.grid.css" />
	<link rel="stylesheet" type="text/css" href="${path}/css/jquery.dialog.css" />
	
	<script type="text/javascript" src="${path}/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="${path}/js/Message_zh_CN.js"></script>
	<script type="text/javascript" src="${path}/js/util.js"></script>
	
<script type="text/javascript">
	$(function(){
		$("#left_a_1").addClass('on');
		var upload = $("#upload").val();
		if(upload != null && upload != "" && upload != "true"){
			alert(upload);
		}
	});
	
	//保存
	function saveUser() {
		$("#submit_btn").attr("disabled", "disabled");
		//提交表单
		$("#infoInputForm").submit();
		alert('保存成功');
	}
	
	function refreshPage() {//取消
		window.location.href = "${path}/member/jumpcommonmember";
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
			alert(msg);
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
</head>
<body>
	<%@include file="../../../head.jsp"%>
	<div class="wrap">
		<%@include file="memberView.jsp"%>
		<div class="Rbox">
     		<div class="mainbox">
                   <h3><a href="${path}/member/jumpcommonmember">账户列表</a><i>/</i><a href="#" class="on">批量导入</a></h3>
                   <div class="main">
	                    <div class="Form">
                   	  		<form id="infoInputForm" name="infoInputForm" method="post" action="${path}/member/saveUserMoreExcel" enctype="multipart/form-data">
	                            <div class="dline">
	                                <label>模板下载：</label>
						            <p style="padding-top: 7px;"><a href="${path}/images/excelmodel.xlsx">Excel模板</a> (除手机号码，其他都为必输项)</p>
	                            </div>
	                            <div class="dline">
	                                <label>excel上传：</label>
			                   		<p><input type="file" id="myFile" name="file" onchange="checkExt(this)" class="input_text" style="float: left;"/></p>
	                            </div>
                      		</form>
	                            <div class="dline">
	                                 <label style="color:#fff;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
	                                 <button class="Submit" onclick="saveUser();" id="submit_btn">提交</button>
	                                 <button class="Submit cancel" onclick="refreshPage();">取消</button>
	                            </div>
	                       </div>
                       <input type="hidden" value="${upload}" name="upload" id="upload"/>
				  </div>
			</div>
		</div>
	</div>
</body>
</html>