<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-Ua-Compatible" content="IE=EmulateIE8" />
<title>账户列表-机构平台</title>
	<link rel="stylesheet" type="text/css" href="${path}/css/style.css" />
	<script type="text/javascript" src="${path}/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="${path}/js/My97DatePicker/WdatePicker.js"></script>

	<!-- 引入默认css -->
	<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/icon.css" />
	<script type="text/javascript" src="${path}/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${path}/js/easyui/locale/easyui-lang-zh_CN.js"></script>
	<style type="text/css">
		#Tindex{width:480px;background: #fff;z-index: 11;display: none; border:1px solid #267ed8;font-size:14px; }
		#Tindex h3{height:34px;line-height:34px;color:#267ed8;font-size:18px;padding-left:20px;}		  
		#closeboxI{position:absolute;right:10px;top:5px;}
		#closeboxI a{ display:block;}
		
		#Tindex2{width:480px;background: #fff;z-index: 11;display: none; border:1px solid #267ed8;font-size:14px; }
		#Tindex2 h3{height:34px;line-height:34px;color:#267ed8;font-size:18px;padding-left:20px;}		  
		#closeboxI2{position:absolute;right:10px;top:5px;}
		#closeboxI2 a{ display:block;}
	</style>
<script type="text/javascript">
	$(function(){
		//定义弹窗位置
        jQuery.fn.center = function () {
            this.css({
                "position" :"fixed",
                "top" : 50 + "%",
                "marginTop" : ("-" + this.height() / 2) + "px",
                "left" : ( $(window).width() - this.width() ) / 2+$(window).scrollLeft() + "px"
            });
            return this;
		};
			$("#Tindex").center();
			//弹窗、遮罩显示/隐藏
			$('.bta').click(function(){
				$('#Tindex').fadeIn();
			});
			$('#closeboxI').click(function(){
				$('#Tindex').fadeOut();
			});
			
			$("#Tindex2").center();
			//弹窗、遮罩显示/隐藏
			$('.bta2').click(function(){
				$('#Tindex2').fadeIn();
			});
			$('#closeboxI2').click(function(){
				$('#Tindex2').fadeOut();
			});
			
	});
	
	//中文验证
	 function funcChina(obj) {
        if (/^[A-Za-z0-9_]*$/g.test(obj)) {
            return true;
        }
        return false;
    } 
	//重置默认密码
	function resetPass(id) {
		$.messager.confirm('提示', '确定重置密码?', function(yn) {
			if (yn) {
				$.ajax({
					url : "${path}/fund/defaultPsw",
					type : "post",
					data : {
						"subzhName" : id
					},
					traditional : true,
					dataType : "text",
					success : function(data) {
						if (data == "true") {
							$.messager.alert('提示!', '成功重置密码!', 'info',
							function() {
								parent.refreshPage();
							});
						}
						if (data == "false") {
							$.messager.alert('提示!', '此账号重置密码失败!', 'error',
							function() {
								parent.refreshPage();
							});
						}
					}
				});
			}
		});
	}
	
	//去设置权限页面
	function setper(isadmin,subzh) {
		window.location.href = "${path}/fund/setpre?subzh="+subzh+"&isadmin="+isadmin;
	}
	
	function updateCoeffi2(subzh,coefficient,name){
		$("#subzhcoeffi2").val(subzh);
		$("#name2").val(name);
	}
	//保存修改平台名称
	function savePtname() {
		var name=$("#name2").val();
		if($.trim(name).length<1){
			$.messager.alert("提示!", '平台名称不能为空!', 'info');
			return false;
		}
		
		var subzh=$("#subzhcoeffi2").val();
		$.ajax({
				url : "${path}/fund/updateCoeffi",
				type : "post",
				data : {
					"name" : name,
					"subzh" : subzh
				},
				traditional : true,
				dataType : "text",
				success : function(data) {
					if (data == "true") {
						$.messager.alert("提示!", '修改平台名称成功!', 'info',
						function() {
							parent.refreshPage();
						});
					}
					if (data == "false") {
						$.messager.alert("提示!", '修改平台名称失败!', 'error');
					}
				}

			});
	}
	
	
	//点击修改分成手续费时
	function updateCoeffi(subzh,coefficient,name){
		$("#coefficient").val(coefficient);
		$("#subzhcoeffi").val(subzh);
		$("#name").val(name);
	}	
	
	//保存手续费分成
	function saveCoeffi() {
		var coefficient=$("#coefficient").val();
		var name=$("#name").val();
		if($.trim(name).length<1){
			$.messager.alert("提示!", '机构名称不能为空!', 'info');
			return false;
		}
		if($.trim(coefficient).length==0){
			$.messager.alert("提示!", '手续费分成必须要填写!', 'info');
			return false;
		}
		if(isNaN(coefficient)){
			$.messager.alert("提示!", '手续费分成必须是数字!', 'info');
			return false;
		}
		var xiaoshu=coefficient.split(".");
		if(xiaoshu.length==2 && xiaoshu[1].length>5){
			$.messager.alert("提示!", '手续费分成数字最多只能有四位小数!', 'info');
			return false;
		}
		var subzh=$("#subzhcoeffi").val();
		$.ajax({
				url : "${path}/fund/updateCoeffi",
				type : "post",
				data : {
					"coefficient" : coefficient,
					"name" : name,
					"subzh" : subzh
				},
				traditional : true,
				dataType : "text",
				success : function(data) {
					if (data == "true") {
						$.messager.alert("提示!", '修改手续费分成成功!', 'info',
						function() {
							parent.refreshPage();
						});
					}
					if (data == "false") {
						$.messager.alert("提示!", '修改手续费分成失败!', 'error');
					}
				}

			});
	}
	//取消
	function giveup() {
		$('#closeboxI').click();
		
	}
	//取消
	function giveup2() {
		$('#closeboxI2').click();
		
	}

	//取消
 	function refreshPage() {
		window.location.href="${path}/fund/agentPt";
	} 
	
	//查看风控模板详情
	function toRiskTempall() {  
		var riskTemplateId = $("#riskTemplateId").val();
		if(riskTemplateId>0){
			window.location.href="${path}/riskTempall/queryRiskTempall?id="+riskTemplateId;
		}
	} 
		
</script>
</head>
<body>
	<%@include file="../../../head.jsp"%>
	<div class="wrap">
		<%@include file="subzhMaster.jsp"%>
		<div class="Rbox">
     		<div class="mainbox">   		
                   <h3>机构/平台</h3>
                   <div class="main">
        		   		 <div class="mtable">
                           <table width="100%;">
	                           <tr class="tit">
								<td>机构名称</td>
								<td>机构编号</td>
								<td>手续费分成系数</td>
								<td width="32%">操作</td>
							</tr>
	                      	<c:forEach items="${agentList}" var="user" varStatus="st">
								<tr>
									<td>${user.name}</td>
									<td>${user.subzh }</td>
									<td><fmt:formatNumber value="${user.coefficient}" pattern="#.#######"/>%</td>
									<td>
										<a href="javascript:;" class="bta" onclick="updateCoeffi('${user.subzh}','${user.coefficient }','${user.name }')" id="${user.subzh}">修改</a>
										<em>|</em>&nbsp;&nbsp;<a href="javascript:;" onclick="resetPass(this.id)" id="${user.subzh}">密码初始化</a>
									</td>
								</tr>
							</c:forEach>
						</table>
		 				</div>
		 				
		 				 <div class="mtable">
                           <table width="100%;">
	                           <tr class="tit">
								<td>平台名称</td>
								<td>平台编号</td>
								<td width="32%">操作</td>
							</tr>
	                      	<c:forEach items="${ptList}" var="user" varStatus="st">
								<tr>
									<td>${user.name}</td>
									<td>${user.subzh }</td>
									<td>
										<a href="javascript:;" class="bta2" onclick="updateCoeffi2('${user.subzh}','${user.coefficient }','${user.name }')" id="${user.subzh}">修改</a>
										<em>|</em>&nbsp;&nbsp;<a href="javascript:;" onclick="setper('${user.isadmin }','${user.subzh}')" id="${user.subzh}">权限设置</a>
										<em>|</em>&nbsp;&nbsp;<a href="javascript:;" onclick="resetPass(this.id)" id="${user.subzh}">密码初始化</a>
									</td>
								</tr>
							</c:forEach>
						</table>
		 				</div>
                      	
                      <div id="Tindex" style="display:none;">
			                 <h3>交易权限设置</h3>
			                 <div id="closeboxI">
			                      <a href="javascript:void(0);"><img src="${path}/image/close.png" /></a>
			                 </div>
			                 <form action="">
			                 		<div style="margin-left:60px;margin-top:10px;">
							        	<label style="margin-right:45px;">机构名称:</label><input type="text" name="name" id="name" value="" style="width:150px;height:28px;border:1px solid #267ed8;"/>
							        </div>
							        <div style="margin-left:60px;margin-top:10px;">
							        	<label style="margin-right:5px;">手续费分成系数:</label><input type="text" name="coefficient" id="coefficient" value="" style="width:150px;height:28px;border:1px solid #267ed8;"/>%
							        </div>
							        <input type="hidden" id="subzhcoeffi" value="" />
							        <div style="margin-top:10px;margin-bottom:20px;">
							       		<input type="button" class="cx" onclick="saveCoeffi()" style="margin-left:100px;width:60px;height:30px;background:#108ee9;" value="确定">
	                              		<input type="button" class="cz" onclick="giveup()" style="width:60px;height:30px;background:#108ee9;" value="取消">
							       </div>
			                 </form>
		 				
		 				</div>
                      
                      
                      <div id="Tindex2" style="display:none;">
			                 <h3>交易权限设置</h3>
			                 <div id="closeboxI2">
			                      <a href="javascript:void(0);"><img src="${path}/image/close.png" /></a>
			                 </div>
			                 <form action="">
			                 		<div style="margin-left:60px;margin-top:10px;">
							        	<label style="margin-right:5px;">平台名称:</label><input type="text" name="name" id="name2" value="" style="width:150px;height:28px;border:1px solid #267ed8;"/>
							        </div>
							        <input type="hidden" id="subzhcoeffi2" value="" />
							        <div style="margin-top:10px;margin-bottom:20px;">
							       		<input type="button" class="cx" onclick="savePtname()" style="margin-left:100px;width:60px;height:30px;background:#108ee9;" value="确定">
	                              		<input type="button" class="cz" onclick="giveup2()" style="width:60px;height:30px;background:#108ee9;" value="取消">
							       </div>
			                 </form>
		 				
		 				</div>
                      
				</div>
			</div>
		</div>
	</div>
</body>
</html>