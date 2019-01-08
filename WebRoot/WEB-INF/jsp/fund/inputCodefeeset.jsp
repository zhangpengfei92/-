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
	$(function(){
		//$("#left_a_2").addClass('on');
		var riskTemplateIdValue = $("#riskTemplateIdValue").val();
		if(riskTemplateIdValue != null && riskTemplateIdValue != ""){
			$("#riskTemplateId").val(riskTemplateIdValue);
		}
		/* 下拉框选中 */
		var parentidValue = $("#parentidValue").val();
		$("#parentid").val(parentidValue);
	});
	

	//刷新页面
	function refreshPage() {
		window.location.href = "${path}/codefeeset/codefeesetList?usertype="+$("#parentid").val();
	}
	
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
		
		var codefeesetIdCode = $("#id").val();
        if(codefeesetIdCode != null && codefeesetIdCode != ""){
        	//修改
        } else {
	        var hyname = $.trim($("#hyname").val());
	    	if (hyname.length < 1) {
	        	$.messager.alert('提示', '请选择合约信息', 'info');
	            return false;
	        }
        }
    	var bFlag = true;
    	
        //验证开仓手续费(手)
    	var counterfee1 = $.trim($("#counterfee1").val());
    	if (counterfee1.length < 1 || (counterfee1*1 > 0 && counterfee1*1 < 0.001) || (counterfee1*1 < 0.001 && counterfee1*1 != 0)) {
        	$.messager.alert('提示', '请输入正确的开仓手续费(按手数)', 'info');
            return false;
        }
    	if(!checkDouble(counterfee1, "开仓手续费(按手数)")){
			bFlag = false;
            return false;
        }
    	
        //验证开仓手续费(比)
    	var counterfee2 = $.trim($("#counterfee2").val());
    	if (counterfee2.length < 1 || (counterfee2*1 > 0 && counterfee2*1 < 0.001) || (counterfee2*1 < 0.001 && counterfee2*1 != 0)) {
        	$.messager.alert('提示', '请输入正确的开仓手续费(按金额%)', 'info');
            return false;
        }
    	if(!checkDouble(counterfee2, "开仓手续费(按金额%)")){
			bFlag = false;
            return false;
        }
    	
        //验证平今仓手续费(手)
    	var pcfee1 = $.trim($("#pcfee1").val());
    	if (pcfee1.length < 1 || (pcfee1*1 > 0 && pcfee1*1 < 0.001) || (pcfee1*1 < 0.001 && pcfee1*1 != 0)) {
        	$.messager.alert('提示', '请输入正确的平仓手续费(按手数)', 'info');
            return false;
        }
    	if(!checkDouble(pcfee1, "平仓手续费(按手数)")){
			bFlag = false;
            return false;
        }
    	
        //验证平仓手续费(比)
    	var pcfee2 = $.trim($("#pcfee2").val());
        if (pcfee2.length < 1 || (pcfee2*1 > 0 && pcfee2*1 < 0.001) || (pcfee2*1 < 0.001 && pcfee2*1 != 0)) {
        	$.messager.alert('提示', '请输入正确的平仓手续费(按金额%)', 'info');
            return false;
        }
        if(!checkDouble(pcfee2, "平仓手续费(按金额%)")){
			bFlag = false;
            return false;
        }
        
        //验证平今仓手续费(手)
    	var pcamountfee1 = $.trim($("#pcamountfee1").val());
    	if (pcamountfee1.length < 1 || (pcamountfee1*1 > 0 && pcamountfee1*1 < 0.001) || (pcamountfee1*1 < 0.001 && pcamountfee1*1 != 0)) {
        	$.messager.alert('提示', '请输入正确的平仓手续费(按手数)', 'info');
            return false;
        }
    	if(!checkDouble(pcamountfee1, "平仓手续费(按手数)")){
			bFlag = false;
            return false;
        }
        
    	//验证平仓手续费(比)
    	var pcamountfee2 = $.trim($("#pcamountfee2").val());
        if (pcamountfee2.length < 1 || (pcamountfee2*1 > 0 && pcamountfee2*1 < 0.001) || (pcamountfee2*1 < 0.001 && pcamountfee2*1 != 0)) {
        	$.messager.alert('提示', '请输入正确的平仓手续费(按金额%)', 'info');
            return false;
        }
        if(!checkDouble(pcamountfee2, "平仓手续费(按金额%)")){
			bFlag = false;
            return false;
        }
    	
        var bzj = $.trim($("#bzj").val());
        if (bzj.length < 1) {
        	$.messager.alert('提示', '请输入正确的保证金', 'info');
            return false;
        }
        if(!checkDouble(bzj, "保证金")){
			bFlag = false;
            return false;
        }
        
        if(bFlag){
	       	var url = "${path}/codefeeset/editcodefeesetMsg";
        	var formData = $("#infoInputForm").serialize();
    		$.ajax({
    			type:"POST",
    			url:url,data: formData,
    			dataType:"json",
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
					} else {
						$.messager.alert('提示!', '合约信息已存在，请重新输入!','error',function() {
							$("#submitId").attr("disabled", false);
						});
					} 
	         	},
	         	error: function (returndata) {  
	         		$.messager.alert('提示!', '合约信息已存在，请重新输入!','error',function() {
						$("#submitId").attr("disabled", false);
					});
		          } 
			});
        }
    }
	
	function changePage(value){//tab切换
		window.location.href = value;
	}
	
</script>
<body>
	<%@include file="../../../head.jsp"%>
	<div class="wrap">
		<%@include file="subzhMaster.jsp"%>
		<div class="Rbox">
            <div class="mainbox">
                <h3><a href="${path}/codefeeset/codefeesetList">收费方案</a><i>/</i><a href="#" class="on">合约规则</a></h3>
                 <div class="main">
                      	<div class="Form">
			                 <form id="infoInputForm" name="infoInputForm" method="post" action="">
			                 	<input type="hidden" id="id" name="id" value="${user.id}"/>
	                            <div class="dline">
	                                <label>方案名称：</label>
                                    <p>
                                    	<select id="parentid" name="parentid" class="selectCss">
			                           		<c:forEach items="${codefeesetMenuList}" var="codefeesetMenu">
										    	<option value="${codefeesetMenu.id}">${codefeesetMenu.title}</option>
									        </c:forEach>
							        	</select>
                                 	</p>
                                 </div>
		                         <%--<div class="dline">
						        	<label><font color="red">*</font>市场：</label>
						            <p>   		
						            	<select id="marketcode" name="marketcode" class="selectCss">
											<option value="3">上海股指期货</option> 
		                                  	<option value="4">上海商品</option>
		                                  	<option value="5">大连商品</option>
		                                  	<option value="6">郑州商品</option>
		                                  	<option value="7">上海能源中心</option>
										</select>
						            </p>
						        </div>--%>
						        <div class="dline">
		                        	<label><font color="red">*</font>合约信息：</label>
						            <c:if test="${empty user.id}">
						            	<select id="hyname" name="hyname" class="selectCss">
						            		<c:forEach items="${yyCodeList}" var="msCode">
									           <option value="${msCode.key}">${msCode.codeName}</option>
								        	</c:forEach>
							        	</select>
							        </c:if>
							        <c:if test="${not empty user.id}">${user.hyname}
							        <input type="hidden" id="hyname" name="hyname" value="${user.hyname}"/>
							        <input type="hidden" id="code" name="code" value="${user.code}"/>
							        <input type="hidden" id="marketcode" name="marketcode" value="${user.marketcode}"/>
							        </c:if>
						            <%--<label><font color="red">*</font>合约代码：</label>
						            <input type="text" id="code" name="code" maxlength="40" value="${user.code}"/>--%>
						        </div>
						        <%--<div class="dline">
						            <label><font color="red">*</font>合约名称：</label>
						            <input type="text" id="hyname" name="hyname" value="${user.hyname}"/>
						        </div>--%>
						        <div class="dline">
						            <%-- <label><font color="red">*</font>合约信息：</label>
						            <s:if test="codefeesetId==null">
						            	<select id="hyname" name="hyname" class="select-h2">
					            			<s:iterator value="msCodeList" var="msCode">
									           <option value="${msCode.key}">${msCode.codeName}</option>
								        	</s:iterator>
							        	</select>
							        </s:if>
							        <s:else>${codefeesetvalue.hyname}</s:else> --%>
						            <label>币种：</label>
						            <input type="hidden" id="bbbz" name="bbbz" value="1"/>
						            <input type="hidden" id="bzValue" name="bzValue" value="${user.bz}"/>
						            <select id="bz" name="bz" class="selectCss">
					                	<option value="CNY">人名币</option>
					                	<option value="USD">美元</option>
					                	<option value="EUR">欧元</option>
					                	<option value="HKD">港币</option>
				      				</select>
						        </div>
						        <div class="dline" id="addDiv">
						            <label><font color="red">*</font>开仓手续费(按手数)：</label>
						            <input type="text" id="counterfee1" name="counterfee1" value="${user.counterfee1}"/>
						        </div>
		                        <div class="dline">
						            <label style="width:160px;text-align:left;"><font color="red">*</font>开仓手续费(按金额%)：</label>
						            <input type="text" id="counterfee2" name="counterfee2" value="${user.counterfee2}"/>
						        </div>
						        <div class="dline">
						          	<label><font color="red">*</font>平今仓手续费(按手数)：</label>
						            <input type="text" id="pcfee1" name="pcfee1" value="${user.pcfee1}"/>
						        </div>
		                        <div class="dline">
						            <label style="width:160px;text-align:left;"><font color="red">*</font>平今仓手续费(按金额%)：</label>
						            <input type="text" id="pcfee2" name="pcfee2" value="${user.pcfee2}"/>
						        </div>
						        <div class="dline">
						          	<label><font color="red">*</font>平昨仓手续费(按手数)：</label>
						            <input type="text" id="pcamountfee1" name="pcamountfee1" value="${user.pcamountfee1}"/>
						        </div>
		                        <div class="dline">
						            <label style="width:160px;text-align:left;"><font color="red">*</font>平昨仓手续费(按金额%)：</label>
						            <input type="text" id="pcamountfee2" name="pcamountfee2" value="${user.pcamountfee2}"/>
						        </div>
						        <div class="dline" style="display: none;">
						            <label >收取方式:</label>
				                    <select id="sqfs" name="sqfs" class="selectCss">
										<option value="1">绝对</option>
										<option value="2">相对</option>
				  					</select>
						            <input type="hidden" id="servicefee" name="servicefee" value="1"/>
						            <input type="hidden" id="gjwhgylx" name="gjwhgylx" value="1"/>
						            <input type="hidden" id="bzj" name="bzj" value="1"/>
						            <input type="hidden" id="parentidValue" name="parentidValue" value="${user.parentid}"/>
						        </div>
                        	</form>
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