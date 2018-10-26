<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-Ua-Compatible" content="IE=EmulateIE8" />
<title>新增合约</title>
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

	$(function(){
		var isaccess="${clist}";
		if(isaccess=="undefined" || isaccess=="" || isaccess=="null"){
			$.messager.alert('提示', '没有可以增加的行情合约!', 'info');
		}
	});
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
		var doc=document.getElementById("contract");
		var contractCode="";
		var contractName="";
		var exchangeName="";
		if(doc.tagName=="select" || doc.tagName=="SELECT"){
			contractCode=doc.value;
			//var akeys=doc.id;
			var index = doc.selectedIndex; // 选中索引
			contractName = doc.options[index].text; // 选中文本
			exchangeName=doc.options[index].id;
		}else{
			$.messager.alert('提示', '没有可以增加的行情合约!', 'info');
			regFlag=false;
		}
		//合约乘数
		var contractdetail = $.trim($("#contractdetail").val());
		//最小变动价 
		var minchangeprice = $.trim($("#minchangeprice").val());
		//币种 
		var unit = $.trim($("#unit").val());
		//时间
		var promptDay = $.trim($("#promptDay").val());//到期时间
		if(promptDay==''){
			$.messager.alert('提示', "合约到期时间不能为空", 'info');
			return;
		}
		if(!contractdetail || contractdetail.length==0){
			if(!minchangeprice || minchangeprice.length==0){
				regFlag=false;
				$.messager.alert('提示', "合約乘數和最小变动价至少填写一个", 'info');
			}
		}
		//剩余资金  
		if(regFlag){
			$.ajax({
				url : "${path}/contract/add",
				data : {
					'contractCode' : contractCode,
					'contractName' : contractName,
					'exchangeName' : exchangeName,
					'contractdetail' : contractdetail,
					'minchangeprice':minchangeprice,
					'unit':unit,
					'data' : promptDay
				},
				type : "POST",
				success : function(num) {
					if(num>0){
						alert("添加成功");
						window.location.href="${path}/contract/queryAll";
					}else{
						alert("添加失败，请联系管理员");
					}
					
				}  
			});
		}
	}

	//取消
	function refreshPage() {
		window.location.href="${path}/contract/queryAll";
	}
	
	
</script>
</head>
<body>
	<%@include file="../../../head.jsp"%>
	<div class="wrap">
	<%@include file="subzhMaster.jsp"%>
		<div class="Rbox">
     		<div class="mainbox">
                   <h3><a href="${path}/contract/queryAll">合约列表</a><i>/</i><a href="#" class="on">
              			新增合约 
			    </a></h3>
                   <div class="main">
        		   		
                      	<div class="Form">
                           <!--  <div class="dline">
                                <label>合约代码：</label>
		                   		 <input type="text" value="" id="contractCode" name="contractCode" />
                            </div>
                            <div class="dline">
                                 <label>合约名称：</label>
                                 <input type="text" value="" id="contractName" name="contractName"/>
                            </div>
                            
                             <div class="dline">
                                 <label>品种代码：</label>
                                 <input type="text" value="" id="varietyCode" name="varietyCode"/>
                            </div> -->
                            <c:if test="${not empty clist }">
                            	<div class="dline">
	                                <label>可增合约：</label>
				                    <div id="parentart" class="dselect">
				                        <select name="contract" id="contract">
				                         	<c:forEach items="${clist}" var="msCode">
									           <option value="${msCode.contractCode}" id="${msCode.exchangeName}" >${msCode.contractName}</option>
								        	</c:forEach>
				                        </select>
				                    </div>
	                            </div>
                            </c:if>
                            <c:if test="${empty clist }">
								 <div class="dline">
	                            	<span id="contract" style="margin-left:160px;">已同步行情中最新合约</span>
	                            </div>                           
                            </c:if>
                            
							<div class="dline">
                            <label>合约乘数：</label>
                                 <input type="text" value="" id="contractdetail" name="contractdetail"/>
                            </div>
                            
                            <div class="dline">
                            <label>最小变动价：</label>
                                 <input type="text" value="" id="minchangeprice" name="minchangeprice"/>
                            </div>
							<div class="dline">
                            <label>到期时间：</label>
                                 <input type="text" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"   id="promptDay" name="promptDay"/>
                          </div>
                            <div class="dline">
                            	<label>币种：</label>
                                 <select id="unit" name="unit" class="selectCss">
					                	<option value="CNY">人民币</option>
					                	<option value="USD">美元</option>
					                	<option value="EUR">欧元</option>
					                	<option value="HKD">港币</option>
				      				</select>
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