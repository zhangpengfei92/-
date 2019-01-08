<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-Ua-Compatible" content="IE=EmulateIE8" />
<title>账户列表-新建操盘方案</title>
	<link rel="stylesheet" type="text/css" href="${path}/css/style.css" />
	<script type="text/javascript" src="${path}/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="${path}/js/My97DatePicker/WdatePicker.js"></script>

	<!-- 引入默认css -->
	<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/icon.css" />
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
	//页面加载触发--匹配风控模板
 	window.onload=function(){ 
		var mb = $.trim($("#md").val());
		var options=$("#riskTemplateId option");
		 for(var i=0;i<options.length;i++){
			 if(mb==options[i].value){
				 options[i].selected="selected";
			 }
			} 
		}
	
	//计算
	function count() {
		//获取到操盘资金的值
		var operatermoney = $.trim($("#operatermoney").val());
		
		//按照公式计算操盘保证金
		var operaterbzmoney =operatermoney*0.12;
		
		//按照公式计算操盘保证金
		var ksyjxbalance=operatermoney*0.12;
		
		//按照公式计算操盘保证金
		var kspcxbalance=operatermoney*0.12;
		
		
		
		//赋值操盘保证金
		$("#operaterbzmoney").val(operaterbzmoney);
		//亏损警戒线
		$("#ksyjxbalance").val(ksyjxbalance);
		//亏损平仓线
		$("#kspcxbalance").val(kspcxbalance);
		
		//将三个输入框变成只读
		$("#operaterbzmoney").attr("readonly","readonly")
		$("#ksyjxbalance").attr("readonly","readonly")
		$("#kspcxbalance").attr("readonly","readonly")
	}
	//保存
function saveUser() {
		var regFlag = true;
	//操盘方案名称
		var schemename = $.trim($("#schemename").val());
		if (schemename == null || schemename == "") {
			$.messager.alert('提示', "请填写操盘方案名!", 'info');
			return false;
		}
		//操盘资金   
		var operatermoney = $.trim($("#operatermoney").val());
		if(!operatermoney){
			
			$.messager.alert('提示', "请输入操盘资金!", 'info');
			return false;
		}
			
        //授信资金 
		var sxmoney = $("#sxmoney").val();
		if (sxmoney == null || sxmoney == "") {
			//alert('请输入占用保证金');
			$.messager.alert('提示', "请输入授信资金!", 'info');
			return false;
		}
				
		 //风控模板  riskTemplateId
		var riskTemplateId = $("#riskTemplateId").val();
		if (riskTemplateId == null || riskTemplateId == "") {
			
			$.messager.alert('提示', "请选择风控模板!", 'info');
			return false;
		}
		
		 //入账户管理费 
		var zhglmoney = $("#zhglmoney").val();
		if (zhglmoney == null || zhglmoney == "") {
			
			$.messager.alert('提示', "请输入账户管理费!", 'info');
			return false;
		}
		
		//操盘保证金 
		var operaterbzmoney = $.trim($("#operaterbzmoney").val());
		//亏损警戒线
		var ksyjxbalance = $.trim($("#ksyjxbalance").val());
		//亏损平仓线
		var kspcxbalance = $.trim($("#kspcxbalance").val());
		//备注
		var osremark = $.trim($("#osremark").val());
		//ID
		var osid = $.trim($("#osid").val());
		
		var	url1;
		
		//debugger;
		if(osid!=""){
			url1="${path}/OperateScheme/update?osid="+osid;
		}else{
			url1="${path}/OperateScheme/add"
		}	
		
		if(regFlag){
			$.ajax({
				url : url1,
				data : {
					'schemename': schemename,
					'operatermoney': operatermoney,
					'operaterbzmoney': operaterbzmoney,
					'sxmoney': sxmoney,
					'ksyjxbalance': ksyjxbalance,
					'kspcxbalance': kspcxbalance,
					'riskTemplateId': riskTemplateId,
					'zhglmoney': zhglmoney,
					'osremark':osremark ,
				},
				type : "POST",
				async : true,
				success : function(num) {
					 if(num>0){
						 window.location.href="${path}/OperateScheme/queryAll";				
					}
				} 
			});
		}
	}

	//取消
 	function refreshPage() {
		window.location.href="${path}/OperateScheme/queryAll";
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
     		
                   <h3><a href="${path}/main/queryos">账户列表</a><i>/</i><a href="#" class="on">
              			新建账户 
			    </a></h3>
                   <div class="main">
        		   		
                      	<div class="Form">
                      	<!--隐藏框存放操盘方案ID  -->   
                      	<input type="hidden" value="${os.osid}" id="osid" name="osid"/> 
                      	<!--存放方案的风控模板id  -->
                      	<input type="hidden" value="${os.riskTemplateId}" id="md" name="md"/>                                    	
                            <div class="dline">
                                <label>方案名称：</label>
		                   		 <input type="text" value="${os.schemename}" id="schemename" name="schemename"/>
                            </div>
                            <div class="dline">
                                 <label>操盘资金：</label>
                                 <input type="text" value="${os.operatermoney}" id="operatermoney" name="operatermoney" onblur="count()" />
                            </div>
                     
							<div class="dline">
                            <label>操盘保证金（劣后资金）：</label>
                                 <input type="text" value="${os.operaterbzmoney}" id="operaterbzmoney" name="operaterbzmoney"/>
                            </div>
                            
							<div class="dline">
                            <label>授信资金（优先资金）：</label>
                                 <input type="text" value="${os.sxmoney}" id="sxmoney" name="sxmoney"/>
                            </div>
                            
                            <div class="dline">
                            <label>亏损警戒线：</label>
                                 <input type="text" value="${os.ksyjxbalance}" id="ksyjxbalance" name="ksyjxbalance"/>
                            </div>
							
                            <div class="dline">
                                 <label>亏岁平仓线：</label>
                                 <input type="text" value="${os.kspcxbalance}" id="kspcxbalance" name="kspcxbalance"/>
                            </div>
                            
                             <div class="dline">
                                 <label>风控模板：</label>
                                <select id="riskTemplateId" style="width: 440px;height: 32px ;border:1px solid #dadada;">
                                <option  value="0" selected="selected">请选择风控模板</option>
                                <c:forEach items="${rlist}" var="r" varStatus="st">
                                	<option  value="${r.id}" >${r.type}</option>
                                </c:forEach>	
                                </select>
                                <span>
                                	<a href="javascript:void(0)" onclick="toRiskTempall()"><font color="blue">查看风控模板</font></a>
                                </span>
                            </div>
                            
                             <div class="dline">
                                 <label>账户管理费：</label>
                                 <input type="text" value="${os.zhglmoney}" id="zhglmoney" name="zhglmoney"/>
                            </div>
                            
                              <div class="dline">
                                 <label>备注：</label>
                               <textarea id="osremark" name="osremark" style=" border:1px solid #dadada; margin: 0 0px 0px 0px; width: 440px; height: 93px;">${os.osremark}</textarea> 
                            </div>
                            
                            <div class="dline">
                                 <label style="color:#fff;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                                 <button class="Submit" onclick="saveUser()" id="submitId">提交</button>
                                 <button class="Submit cancel" onclick="refreshPage()">取消</button>
                            </div>
                       </div>
                      
				</div>
			</div>
		</div>
	</div>
</body>
</html>