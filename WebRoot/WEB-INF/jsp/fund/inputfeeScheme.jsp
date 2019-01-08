<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-Ua-Compatible" content="IE=EmulateIE8" />
<title>收费方案-编辑收费信息</title>
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
	});
	
	function checkNum(weight){
		if (isNaN(weight)) {
			alert("此项目必须为数字");
			return false;
		}
		if(weight.lenght>20){
			alert("此项目必须为20以内的数字");
			return false;
		}
	}
	
	//保存
	function saveFeeScheme() {
		var url = "${path}/cost/editfeeSchemeInfo";
		var lsh = $("#lsh").val();
		
		var percentage=$("#percentage").val();
		if ($.trim(percentage).length==0 || isNaN(percentage) || percentage.length>20) {
			alert("交易金额比例必须为数字");
			return false;
		}
		var formData=$("#feeSchemeForm").serialize();
		$.ajax({
			type:"POST",
			url:url,data: formData,
			dataType:"json",
			success: function (msg) {
				if(msg == true){
					$.messager.alert('提示!', '保存成功!','info',function() {
						window.location.href="${path}/cost/feeSchemeList?lsh="+lsh;
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
		window.location.href = "${path}/cost/feeSchemeList";
	}
</script>
</head>
<body>
	<%@include file="../../../head.jsp"%>
	<div class="wrap">
		<%@include file="subzhMaster.jsp"%>
		<div class="Rbox">
     		<div class="mainbox">
                   <h3><a href="${path}/cost/feeSchemeList">收费方案</a><i>/</i><a href="#" class="on">
                    <c:if test="${user == null }">
              			新建
			        </c:if>
			        <c:if test="${user != null }">
			                                   修改
			        </c:if>
			    </a></h3>
                   <div class="main">
                   <form id="feeSchemeForm" method="post">
        		   		<input type="hidden" value="${user.lsh}" name="lsh" id="lsh"/>
        		   		<input type="hidden" value="${user.feeschemeid}" id="feeschemeid" name="feeschemeid"/>
        		   		<input type="hidden" value="${user.schemename}" id="schemename" name="schemename"/>
                      	<div class="Form">
                            <div class="dline">
                                <label>方案名称：</label>
			                   	<p>${user.schemename}</p>
                            </div>
                            <div class="dline">
                            	<label>收费类型：</label>
                            	<c:if test="${empty user }">
                            		<select name="schemetype" id="schemetype" class="iselect-wrapper2" onchange="getBsDirect(this.value)">
                            			<option value="1">经纪商交易佣金</option>
                            			<option value="2">印花税</option>
                            			<option value="3">过户费</option>
                            			<option value="4">综合服务费</option>
                            			<option value="5">管理费</option>
                            			<option value="6">加配手续费</option>
                            		</select>
                            	</c:if>
                            	<c:if test="${not empty user }">
                            		<c:if test="${user.schemetype eq 1 }">经纪商交易佣金</c:if>
                            		<c:if test="${user.schemetype eq 2 }">印花税</c:if>
                            		<c:if test="${user.schemetype eq 3 }">过户费</c:if>
                            		<c:if test="${user.schemetype eq 4 }">综合服务费</c:if>
                            		<c:if test="${user.schemetype eq 5 }">管理费</c:if>
                            		<c:if test="${user.schemetype eq 6 }">加配手续费</c:if>
                            		<input type="hidden" name="schemetype" value="${user.schemetype}" id="schemetype"/>
                            	</c:if>
				
                            </div>
                            <div class="dline">
                                <label><c:if test="${user.schemetype eq 1 }">交易金额比例：</c:if>
                            		<c:if test="${user.schemetype eq 2 }">印花税比例：</c:if>
                            		<c:if test="${user.schemetype eq 3 }">过户费比例：</c:if>
                            		<c:if test="${user.schemetype eq 4 }">综合服务费：</c:if>
                            		<c:if test="${user.schemetype eq 5 }">管理费：</c:if>
                            		<c:if test="${user.schemetype eq 6 }">加配手续费：</c:if></label>
                            		<c:if test="${user.schemetype lt 4 }">
                                 	<input type="text" name="percentage" value="${user.percentage }" id="percentage" onblur="checkNum(this.value)"
                                 	style="width:300px;" <c:if test="${istradeDay eq 1 }">readOnly </c:if> >%  
                                 </c:if>	
                                 <c:if test="${user.schemetype gt 3 }">
                                	 <input type="text" name="percentage" value="${user.percentage }" id="percentage" onblur="checkNum(this.value)" 
                                	 style="width:300px;" <c:if test="${istradeDay eq 1 }">readOnly </c:if> >元/天 
                                 </c:if>	
                            </div>
                            
                            <c:if test="${user.schemetype lt 4 }">
                             <div class="dline">
                                 <label>委托方向：</label>
                                 <c:if test="${not empty user.lsh}">
                                 	<c:if test="${istradeDay ne 1 }">
                                  	<label style="text-align:left;">
                                   	<input type="checkbox" name="direction" value="0" id="buy" style="width:20px;height:20px" 
                                   	<c:if test="${fn:contains(user.direction,'0')}"> checked</c:if> /> 买入
                                   </label>
                                   <label style="text-align:left;">
                                   	<input type="checkbox" name="direction" value="1" id="sell" style="width:20px;height:20px" 
                                   	<c:if test="${fn:contains(user.direction,'1')}"> checked</c:if> /> 卖出
                                   </label>
                                  </c:if>
                                  <c:if test="${istradeDay eq 1 }">
                                   <label style="text-align:left;">
                                   	<input type="checkbox" name="direction" value="0" id="buy" style="width:20px;height:20px" 
                                   	<c:if test="${fn:contains(user.direction,'0')}"> checked</c:if>  disabled /> 买入
                                   </label>
                                   <label style="text-align:left;">
                                   	<input type="checkbox" name="direction" value="1" id="sell" style="width:20px;height:20px" 
                                   	<c:if test="${fn:contains(user.direction,'1')}"> checked</c:if> disabled /> 卖出
                                   </label>
                                   <input type="checkbox" name="direction" value="0" id="buy" style="display:none;" <c:if test="${fn:contains(user.direction,'0')}"> checked</c:if> />
                                   <input type="checkbox" name="direction" value="1" id="sell"  style="display:none;" <c:if test="${fn:contains(user.direction,'1')}"> checked</c:if> />
                                  </c:if>
                                 </c:if>
                             </div>
                            </c:if>
                            
                            <c:if test="${user.schemetype gt 3 }">
                            	<input type="hidden" name="direction" value="0" />
                            </c:if>
                            <div class="dline">
                                <label>显示状态：</label>
                                <div class="kv-item-content">
                                   <span class="choose">
                                     <span class="checkboxouter"><input type="radio" name="showstatus" value="1" ${user.showstatus eq 1 ? 'checked' : '' } />
                                     </span>
                                     <span class="text">显示</span>
                                   </span>
                                   <span class="choose">
                                     <span class="checkboxouter"><input type="radio" name="showstatus" value="0" ${user.showstatus eq 0 ? 'checked' : '' } />
                                     </span><span class="text">隐藏</span>
                                   </span>
                                 </div>
                            </div>
                           
                            <div class="dline">
                            	<label style="color:#fff;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                                <button class="Submit" onclick="saveFeeScheme();" id="submitId">提交</button>
                                <button class="Submit cancel" onclick="refreshPage()">取消</button>
                            </div>
                       </div>
                       </form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>