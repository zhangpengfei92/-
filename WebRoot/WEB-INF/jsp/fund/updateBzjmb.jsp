<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-Ua-Compatible" content="IE=EmulateIE8" />
<title>保证金方案-编辑保证金信息</title>
	<link rel="stylesheet" type="text/css" href="${path}/css/style.css" />
	<script type="text/javascript" src="${path}/js/jquery-1.11.3.min.js"></script>
	<!-- 引入默认css -->
	<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/icon.css" />
	<script type="text/javascript" src="${path}/js/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="${path}/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${path}/js/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	
	function checkNum(weight){
		if (isNaN(weight)) {
			alert("此项目必须为数字");
			return false;
		}
	}
	
	//保存
	function saveBzjmb() {
		var url = "${path}/cost/editBzjmbMsgMore";
		
		var percentage = $("#tjdtbzj1").val();
		if ($.trim(percentage).length==0 || isNaN(percentage) || percentage.length>20) {
			$.messager.alert('提示', "多头保证金率必须为数字!", 'info');
			return false;
		}
		
		var tjdtbzj2 = 0;
		/* if ($.trim(tjdtbzj2).length==0 || isNaN(tjdtbzj2) || tjdtbzj2.length>20) {
			$.messager.alert('提示', "多头保证金率(按金额%)必须为数字!", 'info');
			return false;
		} */
		
		var tjktbzj1 = $("#tjktbzj1").val();
		if ($.trim(tjktbzj1).length==0 || isNaN(tjktbzj1) || tjktbzj1.length>20) {
			$.messager.alert('提示', "空头保证金率必须为数字!", 'info');
			return false;
		}
		
		var tjktbzj2 = 0;
		/* if ($.trim(tjktbzj2).length==0 || isNaN(tjktbzj2) || tjktbzj2.length>20) {
			$.messager.alert('提示', "空头保证金率(按金额%)必须为数字!", 'info');
			return false;
		} */
		
		var bbbz = $("#bbbz").val();
		if ($.trim(bbbz).length==0 || isNaN(bbbz) ) {
			$.messager.alert('提示', "空头保证金率(按金额%)必须为数字!", 'info');
			return false;
		}
		$.ajax({
			type:"POST",
			url:url,
			data : {
				"codefeesetIds" : $("#codefeesetIds").val(),
				"tjdtbzj1" : percentage,
				"tjdtbzj2" : tjdtbzj2,
				"tjktbzj1" : tjktbzj1,
				"tjktbzj2" : tjktbzj2,
				"bbbz":bbbz
			},
			async : false,
			success: function (msg) {
				if(msg == true || msg == "true"){
					$.messager.alert('提示!', '保存成功!','info',function() {
						window.location.href="${path}/cost/bzjmbList";
					});
				} else {
					$.messager.alert('提示!', '保存失败','error',function() {
						$("#submitId").attr("disabled", false);
					});
				}
			},  
	        error: function (returndata) {  
	              $.messager.alert('提示!', returndata,'error',function() {
						$("#submitId").attr("disabled", false);
					});
	        },
			complete : function() {//请求完成之后调用 全查询
					//关闭弹出层
					var index = parent.layer.getFrameIndex(window.name);  
					window.parent.layer.close(index); 
			}
		});
	}
	
	function refreshPage() {
		//关闭弹出层
		var index = parent.layer.getFrameIndex(window.name);  
		window.parent.layer.close(index); 
	}
</script>
</head>
<body>
	<div class="main">
        <div class="layForm">
            <input type="hidden" value="${codefeesetIds}" id="codefeesetIds" name="codefeesetIds" />
					        <div class="laydline" id="addDiv">
					            <label style="width:160px;text-align:left;"><font color="red">*</font>多头保证金率(按手数)</label>
					            <input type="text" id="tjdtbzj1" name="tjdtbzj1" value="" onkeyup="value=value.replace(/[^\-?\d.]/g,'')"/>
					        </div>
					        <!-- <div class="laydline">
					            <label style="width:160px;text-align:left;">
					            <font color="red">*</font>多头保证金率(按金额%)</label>
					            <input type="text" id="tjdtbzj2" name="tjdtbzj2" value="" onkeyup="value=value.replace(/[^\-?\d.]/g,'')"/>
					        </div> -->
					        <div class="laydline">
					          	<label style="width:160px;text-align:left;"><font color="red">*</font>空头保证金率(按手数)</label>
					            <input type="text" id="tjktbzj1" name="tjktbzj1" value="" onkeyup="value=value.replace(/[^\-?\d.]/g,'')"/>
					        </div>
					        <!-- <div class="laydline">
					            <label style="width:160px;text-align:left;"><font color="red">*</font>空头保证金率(按金额%)</label>
					            <input type="text" id="tjktbzj2" name="tjktbzj2" value="" onkeyup="value=value.replace(/[^\-?\d.]/g,'')"/>
					        </div> -->
					        <div class="laydline">
					            <label style="width:160px;text-align:left;"><font color="red">*</font>收盘冻结保证金(按手数)</label>
					            <input type="text" id="bbbz" name="bbbz" value="" onkeyup="value=value.replace(/[^\-?\d.]/g,'')"/>
					        </div>
                            <div class="laydline">
                            	<label style="color:#fff;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                                <button class="Submit" onclick="saveBzjmb();" id="submitId">提交</button>
                                <button class="Submit cancel" onclick="refreshPage()">取消</button>
                            </div>
                       </div>
				</div>
</body>
</html>