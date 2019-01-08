<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-Ua-Compatible" content="IE=EmulateIE8" />
<title>账户列表-新建账户</title>
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
		//校验账户编号
		var accountid = $.trim($("#accountid").val());
		if (accountid == null || accountid == "") {
			$.messager.alert('提示', "账户编号不能为空!", 'info');
			return;
		}
		if(accountid.length < 1 || accountid.length > 20){
			//alert("账号编号不能少于8到16个数字");
			$.messager.alert('提示', "账号编号长度在1到20个字符", 'info');
			regFlag = false;
			return false;
		}
		var password=$.trim($("#password").val());
		if(!password){
			$.messager.alert('提示', "密码必须要填写", 'info');
			regFlag = false;
			return false;
		}
		if(password.length<6 || password.length>16){
			$.messager.alert('提示', "密码的长度必须在6到16个字符", 'info');
			regFlag = false;
			return false;
		}
		/* //总权益
		var suminterest = $.trim($("#suminterest").val());
		if(!suminterest){
			//alert("总权益");
			$.messager.alert('提示', "总权益不能为空!", 'info');
			return false;
		}
		
		//占用保证金
		var bzmoney = $.trim($("#bzmoney").val());
		if(!bzmoney){
			//alert("总权益");
			$.messager.alert('提示', "占用保证金不能为空!", 'info');
			return false;
		}
		
        //可用资金  
		var avaamoney = $("#avaamoney").val();
		if (avaamoney == null || avaamoney == "") {
			//alert('请输入可用资金 ');
			$.messager.alert('提示', "请输入可用资金!", 'info');
			return false;
		}
		//子账号权益  
		var subinterest = $.trim($("#subinterest").val());
		//剩余资金  
		var symoney = $.trim($("#symoney").val()); */
		//席位编号
		var broker = $.trim($("#broker").val());
		if(broker.length<4||broker.length>6){
			$.messager.alert('提示', "请输入正确的席位编号!", 'info');
			return false;
		}
		
		
		//CTP柜台的地址
		var serverip = $.trim($("#serverip").val());
		if(serverip==null||serverip.substring(0,6)!="tcp://"){
			$.messager.alert('提示', "请输入CTP柜台的地址!", 'info');
			return false;
		}
		var id=$("#id").val();
		$.ajax({
				url : "${path}/main/isexist",
				async:false,
				data : {
					'accountid' : accountid,
					'bdzhid' : id
				},
				type : "POST",
				success : function(response) {
					if(response=="true"){
						$.messager.alert('提示', "此报单账户编号已存在", 'info');
						regFlag=false;
					}else{
						
					}
				
				}  
			});
		
		if(regFlag){
			$.ajax({
				url : "${path}/main/addbdzh",
				data : {
					'accountid' : accountid,
					'password' : password,
					'broker' : broker,
					'serverip' : serverip,
					'bdzhid' : id
				},
				type : "POST",
				success : function(response) {
					if(response=="true"){
						window.location.href="${path}/main/querybdzh";
					}else{
						$.messager.alert('提示', "增加报单账户出错，请联系管理员！", 'info');
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
                   <h3><a href="${path}//main/querybdzh">账户列表</a><i>/</i><a href="javascript:void(0)" class="on">
              			新建账户 
			    </a></h3>
                   <div class="main">
        		   		<input type="hidden" id="id" value="${bdzh.bdzhid}" name="id"/>
                      	<div class="Form">
                            <div class="dline">
                                <label>账户编号：</label>
		                   		 <input type="text" value="${bdzh.accountid}" id="accountid" name="accountid" 
		                   		 <c:if test="${not empty bdzh.bdzhid }">readonly</c:if> />
                            </div>
                            <%-- <div class="dline">
                                 <label>总权益：</label>
                                 <input type="text" value="${bdzh.suminterest}" id="suminterest" name="suminterest"/>
                            </div>
                     
							<div class="dline">
                            <label>占用保证金：</label>
                                 <input type="text" value="${bdzh.bzmoney}" id="bzmoney" name="bzmoney"/>
                            </div>
                            
							<div class="dline">
                            <label>可用资金：</label>
                                 <input type="text" value="${bdzh.avaamoney}" id="avaamoney" name="avaamoney"/>
                            </div>
                            
                            <div class="dline">
                            <label>子账号权益：</label>
                                 <input type="text" value="${bdzh.subinterest}" id="subinterest" name="subinterest"/>
                            </div>
							
                            <div class="dline">
                                 <label>剩余资金额度：</label>
                                 <input type="text" value="${bdzh.symoney}" id="symoney" name="symoney"/>
                            </div> --%>
                            <div class="dline">
                            	<label>密码：</label>
                                 <input type="password" value="${bdzh.password}" id="password" name="password"/>
                            </div>
                            
                              <div class="dline">
                                <label>席位编号：</label>
		                   		 <input type="text" value="${bdzh.broker}" id="broker" name="broker" />
                            </div>
                            
                              <div class="dline">
                                <label>CTP柜台的地址：</label>
		                   		 <input type="text" value="${bdzh.serverip}" id="serverip" name="serverip" />
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