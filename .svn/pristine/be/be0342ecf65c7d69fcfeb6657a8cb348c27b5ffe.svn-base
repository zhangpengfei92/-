<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-Ua-Compatible" content="IE=EmulateIE8" />
<title>新增权限菜单</title>
	<link rel="stylesheet" type="text/css" href="${path}/css/style.css" />
	<script type="text/javascript" src="${path}/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="${path}/js/My97DatePicker/WdatePicker.js"></script>

	<!-- 引入默认css -->
	<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/icon.css" />
	<script type="text/javascript" src="${path}/js/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="${path}/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${path}/js/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">	
	//中文验证
	function funcChina(obj) {
        if (/^[A-Za-z0-9_]*$/g.test(obj)) {
            return true;
        }
        return false;
    }
	
	//保存
function saveUser() {
		var regFlag = true;
		
		//所属权限
		var preId = $.trim($("#preId").val());
		//菜单名称
		var mname = $.trim($("#mname").val());
		//菜单简写
		var menuCode = $.trim($("#menuCode").val());
		if(regFlag){
			$.ajax({
				url : "${path}/fund/addmenu",
				data : {
					'preId' : preId,
					'mname' : mname,
					'menuCode' : menuCode,
				},
				type : "POST",
				success : function(num) {
					if(num>0){
						
						alert("添加成功");
						window.location.href = "${path}/fund/subzhList";	
					}		
				}  
			});
		}
	}
	
	//检查输入的权限菜单简写数据库是否已存在
	function inspect(){
		var menuCode = $.trim($("#menuCode").val());
		alert(menuCode);
		if(menuCode==null||menuCode==""){
		alert("请输入菜单简写");	
		}else{
			$.ajax({
				url : "${path}/fund/querykeywords?keyword="+menuCode,
				type : "POST",
				success : function(flag) {
					alert(flag);
					if(flag){	
						alert("该菜单简写已存在,请重新输入");
						$("#menuCode").attr("value","");
					}else{
						alert("OK");
					}	
				}  
			});
		}
	}
	
	//取消
	function refreshPage() {
		window.location.href="${path}/main/querybdzh";
	}
</script>
</head>
<body>
	<%@include file="../../../head.jsp"%>
	<div class="wrap">
	<%@include file="subzhMaster.jsp"%>
		<div class="Rbox">
     		<div class="mainbox">
                   <h3><a href="${path}/main/querybdzh">账户列表</a><i>/</i><a href="#" class="on">
              			新增权限菜单
			    </a></h3>
                   <div class="main">
        		   		
                      	<div class="Form">
                                 <div class="dline">
                                <label>所属权限：</label>
			                    <div id="parentart" class="dselect">
			                        <select name="preId" id="preId">
			                         	<c:forEach items="${plist}" var="sn">
			                         		<option value="${sn.pId}">${sn.keyword}</option>
			                         	</c:forEach>
			                        </select>
			                    </div>
                            </div>
                            
                            <div class="dline">
                                 <label>菜单名称：</label>
                                 <input type="text" value="" id="mname" name="mname"/>
                            </div>
                     
							<div class="dline">
                            <label>菜单简写：</label>
                                 <input type="text" value="" onblur="inspect()" id="menuCode" name="menuCode"/>
                            </div>
                            <div class="dline">
                                 <label style="color:#fff;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                                 <button class="Submit" onclick="saveUser();" id="submitId">提交</button>
                                 <button class="Submit cancel" onclick="refreshPage()">取消</button>
                            </div>
                       </div> 
				</div>
			</div>
		</div>
	</div>
</body>
</html>