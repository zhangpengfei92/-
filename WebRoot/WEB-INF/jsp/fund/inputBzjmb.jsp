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
	
	$(document).ready(function(){
		/* 下拉框选中 */
		var parentidValue = $("#parentidValue").val();
		$("#parentid").val(parentidValue);
	});
	
	function checkNum(weight){
		if (isNaN(weight)) {
			alert("此项目必须为数字");
			return false;
		}
	}
	
	//Double验证
	function checkDouble(strValue, strName) {
	   var pattern=/^[\-\+]?([0-9]\d*|0|[1-9]\d{0,2}(,\d{3})*)(\.\d+)?$/;
	   if(!pattern.test(strValue) || strValue*1 < 0){
		   $.messager.alert('提示', strName + "的数值不正确！", 'info');
	  	   return false;
	   }
	   return true;
	}
	
	//保存
	function saveBzjmb() {
		var url = "${path}/cost/editBzjmbInfo";
		//var lsh = $("#lsh").val();
		//验证保证金合约代码
    	/*var bzjdm = $.trim($("#bzjdm").val());
    	if (bzjdm.length < 1) {
    		$.messager.alert('提示', "合约代码不能为空!", 'info');
            return false;
        }
    	var bzjname = $.trim($("#bzjname").val());
    	if (bzjname.length < 1) {
    		$.messager.alert('提示', "合约名称不能为空!", 'info');
            return false;
        }*/
		var codefeesetIdCode = $("#id").val();
        if(codefeesetIdCode != null && codefeesetIdCode != ""){
        	//修改
        } else {
	        var hyname = $.trim($("#bzjname").val());
	    	if (hyname.length < 1) {
	        	$.messager.alert('提示', '请选择合约信息', 'info');
	            return false;
	        }
        }
		
		var percentage = $("#tjdtbzj1").val();
		if ($.trim(percentage).length==0 || isNaN(percentage) || percentage.length>20) {
			$.messager.alert('提示', "多头保证金率必须为数字!", 'info');
			return false;
		}
		
		var bFlag = true;
		if(!checkDouble(percentage, "多头保证金率")){
		   bFlag = false;
           return false;
       	}
		
		var tjdtbzj2 = $("#tjdtbzj2").val();
		if ($.trim(tjdtbzj2).length==0 || isNaN(tjdtbzj2) || tjdtbzj2.length>20) {
			$.messager.alert('提示', "多头保证金率(按金额%)必须为数字!", 'info');
			return false;
		}
		
		var tjktbzj1 = $("#tjktbzj1").val();
		if ($.trim(tjktbzj1).length==0 || isNaN(tjktbzj1) || tjktbzj1.length>20) {
			$.messager.alert('提示', "空头保证金率必须为数字!", 'info');
			return false;
		}
		
		var tjktbzj2 = $("#tjktbzj2").val();
		if ($.trim(tjktbzj2).length==0 || isNaN(tjktbzj2) || tjktbzj2.length>20) {
			$.messager.alert('提示', "空头保证金率(按金额%)必须为数字!", 'info');
			return false;
		}
		
		if(!checkDouble(tjdtbzj2, "多头保证金率(按金额%)")){
			   bFlag = false;
	           return false;
	       	}
		if(!checkDouble(tjktbzj1, "空头保证金率")){
			   bFlag = false;
	           return false;
	       	}
		if(!checkDouble(tjktbzj2, "空头保证金率(按金额%)")){
			   bFlag = false;
	           return false;
	       	}
		
		var formData = $("#bzjmbForm").serialize();
		$.ajax({
			type:"POST",
			url:url,data: formData,
			dataType:"json",
			async : false,
			success: function (msg) {
				console.log(msg);
				if(msg.status == 200){
					$.messager.alert('提示!', '保存成功!','info',function() {
						window.location.href="${path}/cost/bzjmbList";
					});
				}else if (msg.status == 100) {
					$.messager.alert('提示!', '方案名称已存在，请重新输入!','info',function() {
						$("#submitId").attr("disabled", false);
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
	          }  
		});
	}
	
	function refreshPage() {//取消
		window.location.href = "${path}/cost/bzjmbList";
	}
</script>
</head>
<body>
	<%@include file="../../../head.jsp"%>
	<div class="wrap">
		<%@include file="subzhMaster.jsp"%>
		<div class="Rbox">
     		<div class="mainbox">
                   <h3><a href="${path}/cost/bzjmbList">保证金方案</a><i>/</i><a href="#" class="on">
	                    <c:if test="${user == null }">
	              			新建
				        </c:if>
				        <c:if test="${user != null }">
				                                   修改
				        </c:if>
				    </a></h3>
                   <div class="main">
                      	<div class="Form">
                   <form id="bzjmbForm" method="post">
        		   		<input type="hidden" value="${user.id}" name="id" id="id"/>
                            <div class="dline">
                                <label>方案名称：</label>
			                   	<p><select id="parentid" name="parentid" class="selectCss" >
		                           		<c:forEach items="${bzjmbMenuList}" var="bzjmbMenu">
									    	<option value="${bzjmbMenu.id}">${bzjmbMenu.title}</option>
								        </c:forEach>
							        </select></p>
                            </div>
                            <%--<div class="dline">
					        	<label><font color="red">*</font>市场</label>
					            <div class="select-outer select-wh200">  
					            	<div class="select-inner"> 
					               		<select id="sc" name="sc" class="selectCss">
											<option value="3">上海股指期货</option> 
		                                  	<option value="4">上海商品</option>
		                                  	<option value="5">大连商品</option>
		                                  	<option value="6">郑州商品</option>
										</select>
					               </div>
					            </div>
					       </div>
					       <div class="dline">
					            <label><font color="red">*</font>合约代码</label>
					            <input type="text" id="bzjdm" name="bzjdm" maxlength="32" value="${user.bzjdm}"/>
					        </div>
					        <div class="dline">
					            <label><font color="red">*</font>合约名称</label>
					            <input type="text" id="bzjname" name="bzjname" value="${user.bzjname}"/>
                            	--%>
                           <div class="dline">
					            <label><font color="red">*</font>合约信息：</label>
						            <c:if test="${empty user.id}">
						            	<select id="bzjname" name="bzjname" class="selectCss">
						            		<c:forEach items="${yyCodeList}" var="msCode">
									           <option value="${msCode.key}">${msCode.codeName}</option>
								        	</c:forEach>
							        	</select>
							        </c:if>
							        <c:if test="${not empty user.id}">${user.bzjname}
							        <input type="hidden" id="bzjname" name="bzjname" value="${user.bzjname}"/>
							        <input type="hidden" id="bzjdm" name="bzjdm" value="${user.bzjdm}"/>
							        <input type="hidden" id="sc" name="sc" value="${user.sc}"/>
							        </c:if>
							 </div>
					        <div class="dline">
					            <label>币种</label>
					            <select id="bz" name="bz" class="selectCss">
				                	<option value="CNY">人名币</option>
				                	<option value="USD">美元</option>
				                	<option value="EUR">欧元</option>
				                	<option value="HKD">港币</option>
			      				</select>
					            <input type="hidden" id="bzValue" name="bzValue" value="${user.bz}"/>
					            <%--
					            	<option value="CNY">人民币</option>
				                	<option value="HKD">港元</option>
				                	<option value="EUR">欧元</option>
					            <label >本币比重</label><input type="hidden" id="bbbz" name="bbbz" value="1"/>--%>
					        </div>
					        <div class="dline" id="addDiv">
					            <label><font color="red">*</font>多头保证金率(按手数)</label>
					            <input type="text" id="tjdtbzj1" name="tjdtbzj1" value="${user.tjdtbzj1}"/>
					        </div>
					        <div class="dline">
					            <label style="width:160px;text-align:left;">
					            <font color="red">*</font>多头保证金率(按金额%)</label>
					            <input type="text" id="tjdtbzj2" name="tjdtbzj2" value="${user.tjdtbzj2}"/>
					        </div>
					        <div class="dline">
					          	<label><font color="red">*</font>空头保证金率(按手数)</label>
					            <input type="text" id="tjktbzj1" name="tjktbzj1" value="${user.tjktbzj1}"/>
					        </div>
					        <div class="dline">
					            <label style="width:160px;text-align:left;"><font color="red">*</font>空头保证金率(按金额%)</label>
					            <input type="text" id="tjktbzj2" name="tjktbzj2" value="${user.tjktbzj2}"/>
					        </div>
					        <div class="dline" style="display:none;">
					            <label >收取方式</label>
					            <div class="select-outer select-wh200">  
					                <div class="select-inner"> 
					                    <select id="sqfs" name="sqfs" class="selectCss">
											<option value="1">绝对</option>
											<option value="2">相对</option>
					  					</select>
					                </div>
					            </div>
					            <input type="hidden" id="month" name="month" value="1"/>
					            <input type="hidden" id="agentzh" name="agentzh" value="${agentzh }"/>
					            <input type="hidden" id="parentidValue" name="parentidValue" value="${user.parentid}"/>
					        </div>
                           
                       </form>
                            <div class="dline">
                            	<label style="color:#fff;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                                <button class="Submit" onclick="saveBzjmb();" id="submitId">提交</button>
                                <button class="Submit cancel" onclick="refreshPage()">取消</button>
                            </div>
                       </div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>