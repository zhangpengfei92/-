<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-Ua-Compatible" content="IE=EmulateIE8" />
<title>账户列表-授权管理</title>
	<link rel="stylesheet" type="text/css" href="${path}/css/style.css" />
	<script type="text/javascript" src="${path}/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="${path}/js/My97DatePicker/WdatePicker.js"></script>

	<!-- 引入默认css -->
	<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/icon.css" />
	<script type="text/javascript" src="${path}/js/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="${path}/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${path}/js/easyui/locale/easyui-lang-zh_CN.js"></script>
	
	
	<!-- 引入二维码的js -->
	<script type="text/javascript" src="${path}/js/dist/qrcode.js"></script>
	<script type="text/javascript" src="${path}/js/dist/qart.min.js"></script>
	
<script type="text/javascript">	
	var isadmin="${isadmin}";
	//中文验证
	function funcChina(obj) {
        if (/^[A-Za-z0-9_]*$/g.test(obj)) {
            return true;
        }
        return false;
    }
	
	//保存
function saveUser(isadmin) {
		var regFlag=true;
		var num="";
	$("input[name='zjgl']:checked").each(function(index,data1) {
		if(this.checked){
			num+=data1.value+',';
		}
	});
		$("input[name='zhgl']:checked").each(function(index,data2) {
			if(this.checked){
				num+=data2.value+',';
			}
		});	
	/* 	$("input[name='sys']:checked").each(function(index,data3) {
				if(this.checked){
					num+=data3.value+',';
			}
			
	}); 去掉系统管理菜单*/
		
		$("input[name='jygl']:checked").each(function(index,data4) {
			if(this.checked){
				num+=data4.value+',';
			}
		
		});
		//var roleid = $.trim($("#role").val());
		var subzh = $.trim($("#subzh").val());
		if(regFlag){
			$.ajax({
				url : "${path}/fund/savePre?num="+num,
				data :{
					'subzh':subzh
				},	
				type : "POST",
				success : function(data) {
					var url="${path}/fund/subzhList?isadmin="+isadmin;
					if(isadmin==1 || isadmin==2){
						url="${path}/fund/agentPt";
					}
					if(data>1){
						alert("添加成功");
						window.location.href = url;
					}else{
						alert("添加失败");
						window.location.href = url;
					}	
				}  
			});
		}
	}

	//取消
	function refreshPage(isadmin) {
		var url="${path}/fund/subzhList?isadmin="+isadmin;
		if(isadmin==1||isadmin==2){
			url="${path}/fund/agentPt";
		}
		window.location.href=url;
	}

	function checkAll(obj,num){
		var Ajsglcheckbox;
		if(obj.checked){
			Ajsglcheckbox = false;
		}else{
			Ajsglcheckbox = true;
		}
		if(num==3){
			if (Ajsglcheckbox) {
				//选择每个被选中的input
				$("[name='zjgl']").each(function() {
					this.checked = false;
				});
				Ajsglcheckbox = false;
			} else {
				$("[name='zjgl']").each(function() {
					this.checked = true;
				});
				Ajsglcheckbox = true;
			}

			
		}else if(num==2){
				if (Ajsglcheckbox) {
					//选择每个被选中的input
					$("[name='zhgl']").each(function() {
						this.checked = false;
					});
					Ajsglcheckbox = false;
				} else {
					$("[name='zhgl']").each(function() {
						this.checked = true;
					});
					Ajsglcheckbox = true;
				}

				
			}else if(num==4){
					if (Ajsglcheckbox) {
						//选择每个被选中的input
						$("[name='jygl']").each(function() {
							this.checked = false;
						});
						Ajsglcheckbox = false;
					} else {
						$("[name='jygl']").each(function() {
							this.checked = true;
						});
						Ajsglcheckbox = true;
					}

					
			}else{
				if(num==5){
					if (Ajsglcheckbox) {
						//选择每个被选中的input
						$("[name='sys']").each(function() {
							this.checked = false;
						});
						Ajsglcheckbox = false;
					} else {
						$("[name='sys']").each(function() {
							this.checked = true;
						});
						Ajsglcheckbox = true;
					}
				}
			}
	}
	
	
	function  checkRole() {
		var roleid = $.trim($("input[name='role']:checked").val());
		if(roleid==4){
			$("#erwei_code").attr("style","");
		}else{
			$("#erwei_code").attr("style","display:none");
		}
		
	}
	
	
	//页面加载的时候回显单选的角色信息
	$(document).ready(function(){ 
		//var role = $("input[name='role']");
		var roleid = $.trim($("#hid").val());
		/*   */
		<c:forEach items="${plist}" var="per">
			var selectid="${per.id}";
			$("#menu"+selectid).attr("checked",true);
		</c:forEach>
		
		//选中一级菜单
		var arr=["zjgl","zhgl","jygl","sys"];
		for(var j=0;j<arr.length;j++){
			var role = $("input[name='"+arr[j]+"']");
			for(var i=0;i<role.length;i++){
				 if(role[i].checked){
					 $("#pre_"+arr[j]).attr("checked",true);
					 break;
				 }
			}
		}
		
		/* if(roleid==4){
			$("#erwei_code").attr("style","");
			$("#role6").attr("disabled","disabled");
		}else{
			$("#erwei_code").attr("style","display:none");
		}
		
		if(roleid==3){
			role.attr("disabled","disabled");
		} */
	});
	
	/* $(document).ready(function() {
        var value = 'http://101.132.105.35/ctpcms/user/pbMain!register.action';
       function makeQR() {
            var qr = qrcode.QRCode(10, 'H');
            qr.addData(value);
            qr.make();
            document.getElementById('qr').innerHTML = qr.createImgTag(3);
            
        }
       
       makeQR();
	}); */
	
</script>
</head>
<body>
	<%@include file="../../../head.jsp"%>
	<div class="wrap">
	<%@include file="subzhMaster.jsp"%>
		<div class="Rbox" style="margin:20px 25px 25px 34px;">
     		<div class="mainbox">
     			  <h3><a href="${path}/main/querybdzh" class="on">主账户列表</a>/
                 		<a href="${path}/fund/subzhList?isadmin=${isadmin}" class="on">子账户列表</a>/
                 			<a href="javascript:void(0);" class="on">权限设置</a></h3>
                   <div class="main">
                      	<div class="Form">
                      	<input type="hidden" id="hid" value="${sr.roleid}"/>
                      	<div>
                      		<span>
                      			当前子账户是：<font>${sub.subzh}</font>
                      			<input type="hidden" id="subzh" value="${sub.subzh}"/>
                      		</span>
                      		&nbsp;&nbsp;&nbsp;&nbsp;
                      		<span>
                      		用户类型：
									<!-- <input type="radio"  name="role" id="role3" value="3"/>渠道
                      				<input type="radio"  name="role" id="role4" value="4"/>经纪人
                      				<input type="radio" checked="checked" name="role" id="role6" value="6"/>普通用户	 -->
                      				<c:if test="${isadmin eq 1 }">机构</c:if>
                      				<c:if test="${isadmin eq 2 }">平台</c:if>
                      				<c:if test="${isadmin eq 3 }">渠道</c:if>
                      				<c:if test="${isadmin eq 4 }">代理商</c:if>
                      				<c:if test="${isadmin eq 5 }">经纪人</c:if>
                      				<input type="hidden" id="role" name="role" value="${isadmin }" />
                      		</span>
                      		
                      		<!-- <div id="erwei_code" style="display: none;"><li>
                      		
                      			<div id="qr">
                      			
                      			</div>
                
                      			<font>二维码地址</font>
                      			<a href="javascript:void(0)">
                      			http://101.132.105.35/ctpcms/user/pbMain!register.action 
                      			</a></li>
                      		</div> -->
                      	</div>
                      
                      	<br /><br />
                      		 <div class="Tratable" style="margin-bottom:10px;">
		                        <table style="border-bottom: 1px solid #e9e9e9;border-collapse: collapse;" width="100%">
		                        	<c:if test="${fn:length(list3)>0}">	
			                        	<tr class="tit" >
			                                <td>
			                                <input type="checkbox" name="pre_zjgl" onchange="checkAll(this,3)" id="pre_zjgl" value="3"/><i style="color: #0faeed;padding: 0 5px">账户管理</i></td>
			                               
	    								<c:forEach items="${list3}" var="e">
											 <td></td>                                 
	 									</c:forEach>
			                            </tr>
			                            <tr id="zjgl">
			                            <c:forEach items="${list3}" var="e">
			                             	<td><input type="checkbox" name="zjgl"  value="${e.id}" id="menu${e.id}"/><i style="padding: 0 5px">${e.mname}</i></td>
	                                 	</c:forEach>
	                                 	<td></td>      
			                            </tr>	
		                        	</c:if>
		                        		
		                        	<!-- ***********************资金管理***********************************************  -->
		                        	<c:if test="${fn:length(list2)>0}">
			                        	<tr class="tit" >
			                                <td>
			                                <input type="checkbox" name="pre_zhgl" onchange="checkAll(this,2)" id="pre_zhgl" value="2"/><i style="color: #0faeed;padding: 0 5px">资金管理</i></td>
			                               
	    								<c:forEach items="${list2}" var="a">
	    									<c:if test="${a.menuCode ne 'xsrb' and a.menuCode ne 'sxyb' }">
											 <td></td>  
											 </c:if>                               
	 									</c:forEach>
			                            </tr>
			                            <tr id="zhgl">
			                            <c:forEach items="${list2}" var="a">
			                            	<c:if test="${a.menuCode ne 'xsrb' and a.menuCode ne 'sxyb' }">
			                             	<td><input type="checkbox" name="zhgl"  value="${a.id}" id="menu${a.id}"/><i style="padding: 0 5px">${a.mname}</i></td>
			                             	</c:if>
	                                 	</c:forEach>
	                                 	<td></td>      
			                            </tr>
		                            </c:if>
		                            
		                            <!-- ******************************交易管理 ************************** -->
		                            <c:if test="${fn:length(list4)>0}">
			                            <tr class="tit" >
			                                <td>
			                                <input type="checkbox" name="pre_jygl" onchange="checkAll(this,4)" id="pre_jygl" value="4"/><i style="color: #0faeed;padding: 0 5px">交易管理</i>
			                                </td>
			                               
	    								<c:forEach items="${list4}" var="b">
	    									<c:if test="${b.menuCode ne 'ddjl' and b.menuCode ne 'opsch' and b.menuCode ne 'zspcyj' }">
											 <td></td>       
											 </c:if>                          
	 									</c:forEach>
			                            </tr>
			                            
			                           <tr id="jygl">
			                            <c:forEach items="${list4}" var="b">
			                            	<!-- 56是订单记录，59是操盘方案，65是止损平仓 -->
			                             	<c:if test="${b.menuCode ne 'ddjl' and b.menuCode ne 'opsch' and b.menuCode ne 'zspcyj' }">
			                             		<td><input type="checkbox" name="jygl"  value="${b.id}" id="menu${b.id}"/><i style="padding: 0 5px">${b.mname}</i></td>
			                             	</c:if>
	                                 	</c:forEach>
	                                 	<td></td>      
			                            </tr>
		                            </c:if>
		                            
		                            <!-- **********************测试说不要系统管理********************************** -->
		                            <%-- <c:if test="${fn:length(list5)>0}">
			                            <tr class="tit" >
			                               <td>
			                               <input type="checkbox" name="pre_sys" onchange="checkAll(this,5)" id="pre_sys" value="5"/><i style="color: #0faeed;padding: 0 5px">系统管理</i></td>
	    								<c:forEach items="${list5}" var="c">
											 <td></td>                                 
	 									</c:forEach>
			                            </tr>
			                            <tr id="sys">
			                            <c:forEach items="${list5}" var="c">
			                             	<td><input type="checkbox" name="sys"  value="${c.id}" id="menu${c.id}"/><i style="padding: 0 5px">${c.mname}</i></td>
	                                 	</c:forEach>
	                                 	<td></td>      
			                            </tr> 	 
		                            </c:if>      --%>                      
		                        </table>
		                   </div>
                                             
                           <div class="dline">
                                 <label style="color:#fff;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                                 <button class="Submit" onclick="saveUser('${isadmin}');" id="submitId">提交</button>
                                 <button class="Submit cancel" onclick="refreshPage('${isadmin}')">取消</button>
                            </div>
                       </div> 
				</div>
			</div>
		</div>
	</div>
</body>
</html>