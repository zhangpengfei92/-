<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-Ua-Compatible" content="IE=EmulateIE8" />
<title>修改合约信息</title>
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
		var cids = $.trim($("#cids").val());//合約乘數
		var cid = $.trim($("#cid").val());//合約乘數
		var contractdetail = $.trim($("#contractdetail").val());//合約乘數
		var minchangeprice = $.trim($("#minchangeprice").val());//最小变动价格cid
		var urls="";
		if(cids==null||cids==""){
			var urls="${path}/contract/update?contractCode="+cid;
		}else{
			var urls="${path}/contract/updateAll?cids="+cids;
		}
		if(!contractdetail || contractdetail.length==0){
			if(!minchangeprice || minchangeprice.length==0){
				regFlag=false;
				$.messager.alert('提示', "合約乘數和最小变动价至少填写一个", 'info');
			}
		}
		var unit=$("#unit").val();
		if(regFlag){
			$.ajax({
				url : urls,
				data : {
					'contractdetail' : contractdetail,
					'minchangeprice' : minchangeprice,
					'unit' : unit
				},
				type : "POST",
				success : function(num) {
						$.messager.alert('提示', "修改成功", 'info');
			},
				//textStatus失败的原因
				error : function(xhr, textStatus) {//请求失败之后调用 
					alert(textStatus);
				},
				complete : function() {//请求完成之后调用 全查询
					//关闭弹出层
					var index = parent.layer.getFrameIndex(window.name);  
					window.parent.layer.close(index); 
				}
			});
		}
	}
	
	function refreshPage() {
			//关闭弹出层
			var index = parent.layer.getFrameIndex(window.name);  
			window.parent.layer.close(index); 
	}
	
	
</script>
</head>
<body>
     <div class="main">
        		   		
             <div class="layForm">
            	 <input type="hidden" value="${con.contractCode}" id="cid" name="cid" />	
            	  <input type="hidden" value="${cids}" id="cids" name="cids" />	
                	 <div class="laydline">
                	 
                      	<label>合约乘数：</label>
		                	<input type="text" value="${con.contractdetail}" id="contractdetail" name="contractdetail" />
                     </div>
                     
                    	<div class="laydline">
                            <label>最小变动价格：</label>
                                 <input type="text" value="${con.minchangeprice}" id="minchangeprice" name="minchangeprice"/>
                          </div>   
                           
                           <div class="laydline">
                            	<label>币种：</label>
                                 <select id="unit" name="unit" class="selectCss">
					                	<option value="CNY">人民币</option>
					                	<option value="USD">美元</option>
					                	<option value="EUR">欧元</option>
					                	<option value="HKD">港币</option>
				      				</select>
                          </div> 
                           
                           
                           <div class="laydline">
                                 <label style="color:#fff;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                                 <button class="Submit" onclick="saveUser();" id="submitId">提交</button>
                                 <button class="Submit cancel" onclick="refreshPage()">取消</button>
                            </div>
                       </div> 
				</div>
</body>
</html>