<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>收费方案</title>
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
	function setNext(){//重置
		$("#nickname").val("");
	}

	//Double验证
	function checkDouble(strValue, strName) {
	   var pattern=/^[\-\+]?([0-9]\d*|0|[1-9]\d{0,2}(,\d{3})*)(\.\d+)?$/;
	   if(!pattern.test(strValue)){
		   $.messager.alert('提示', strName + "的数值不正确！", 'info');
	  	   return false;
	   }
	   return true;
	}
	
	function clickSave() {
		
    	var bFlag = true;
    	
    	var mreg = /(^[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)/;
    	var counterfee1 = $.trim($("#counterfee1").val());
    	if (!mreg.test(counterfee1) || (counterfee1<0 || counterfee1>100)) {
        	$.messager.alert('提示', '请输入正确机构分成系数', 'info');
            return false;
        }
    	
    	
    	var counterfee2 = $.trim($("#counterfee2").val());
    	if (!mreg.test(counterfee2) || (counterfee2<0 || counterfee2>100)) {
        	$.messager.alert('提示', '请输入正确渠道分成系数', 'info');
            return false;
        }
    	
    	
    	var pcfee1 = $.trim($("#pcfee1").val());
    	if (!mreg.test(pcfee1) || (pcfee1<0 || pcfee1>100)) {
        	$.messager.alert('提示', '请输入正确代理商分成系数', 'info');
            return false;
        }
    	
    	
    	var pcfee2 = $.trim($("#pcfee2").val());
    	if (!mreg.test(pcfee2) || (pcfee2<0 || pcfee2>100)) {
        	$.messager.alert('提示', '请输入正确的经纪人分成系数', 'info');
            return false;
        }
   
        if(bFlag){
	       	var url = "${path}/feeTemplate/editcodefeesetMsgMore";
    		$.ajax({
    			type:"POST",
    			url:url,
    			data : {
    				"ids" : $("#codefeesetIds").val(),
					"jgratio" : counterfee1,
					"qdratio" : counterfee2,
					"dlsratio" : pcfee1,
					"jjrratio" : pcfee2
				},
				type : "POST",
    			async : false,
	         	success: function (data) {
	         		if (data == true) {
						$.messager.alert('提示!', '保存成功!','info',function() {
							refreshPage();
						});
					} else if (data == false) {
						$.messager.alert('提示!', '保存失败!','error',function() {
							$("#submitId").attr("disabled", false);
						});
					} else if (data == "isExist") {
						$.messager.alert('提示!', '方案名称已存在，请重新输入!','error',function() {
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
    }
	
	function changePage(value){//tab切换
		window.location.href = value;
	}
	
	function refreshPage() {
		//关闭弹出层
		var index = parent.layer.getFrameIndex(window.name);  
		window.parent.layer.close(index); 
	}
	
</script>
<body>
	<div class="main">
        <div class="layForm">
            <input type="hidden" value="${codefeesetId}" id="codefeesetIds" name="codefeesetIds" />
            <div class="laydline">
	            <label style="width:160px;text-align:left;"><font color="red">*</font>机构分成系数：</label>
	            <input type="text" id="counterfee1" name="jgratio"  onkeyup="value=value.replace(/[^\-?\d.]/g,'')"/>
	        </div>
            <div class="laydline">
	            <label style="width:160px;text-align:left;"><font color="red">*</font>渠道分成系数：</label>
	            <input type="text" id="counterfee2" name="qdratio"  onkeyup="value=value.replace(/[^\-?\d.]/g,'')"/>
	        </div>
	        <div class="laydline">
	          	<label style="width:160px;text-align:left;"><font color="red">*</font>代理商分成系数：</label>
	            <input type="text" id="pcfee1" name="dlsratio"  onkeyup="value=value.replace(/[^\-?\d.]/g,'')"/>
	        </div>
	        <div class="laydline">
	            <label style="width:160px;text-align:left;"><font color="red">*</font>经纪人分成系数：</label>
	            <input type="text" id="pcfee2" name="jjrratio"   onkeyup="value=value.replace(/[^\-?\d.]/g,'')"/>
	        </div>
            <div class="laydline">
               	<label style="color:#fff;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                   <button class="Submit" onclick="clickSave();" id="submitId">提交</button>
                   <button class="Submit cancel" onclick="refreshPage()">取消</button>
               </div>
           </div>
       </div>
</body>
</html>