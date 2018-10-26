<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>出入金设置</title>
<link rel="stylesheet" type="text/css" href="${path}/css/style.css" />
	<script type="text/javascript" src="${path}/js/jquery-1.11.3.min.js"></script>
	<!-- 引入默认css -->
	<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/icon.css" />
	<script type="text/javascript" src="${path}/js/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="${path}/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${path}/js/easyui/locale/easyui-lang-zh_CN.js"></script>
	<!--引入layui  -->
	<link rel="stylesheet" href="${path}/layui/css/layui.css"  media="all">
	<script src="${path}/layui/layui.js" charset="utf-8"></script>
</head>
<script type="text/javascript">
    var rate= "<%=session.getAttribute("EXCHANGE_RATE")%>"; 
	$(function(){
		//$("#left_a_2").addClass('on');
	});
	
	$(function() {
		var id= $("#fid").val()
		
		if(id!=""&&id!=null){
			$("input[name='pcswitch']").attr("disabled","disabled")
			$("input[name='appswitch']").attr("disabled","disabled")
			$("input[name='czcost']").attr("disabled","disabled")
			$("input[name='txcost']").attr("disabled","disabled")
			$("input[name='minmoney']").attr("disabled","disabled")
			$("input[name='maxmoney']").attr("disabled","disabled")
			$("input[name='starttime']").attr("disabled","disabled")
			$("input[name='endtime']").attr("disabled","disabled")
			$("#btn").attr("disabled","disabled")
		}
		 
	});
	
	function update(){
		 layer.confirm('确定要修改出入金方案吗?', { btn : [ '确定', '取消' ]},function(index){
			 layer.close(index);		
			$("input[name='pcswitch']").removeAttr("disabled")		
			$("input[name='appswitch']").removeAttr("disabled")
			$("input[name='czcost']").attr("disabled",false)
			$("input[name='txcost']").attr("disabled",false)
			$("input[name='minmoney']").attr("disabled",false)
			$("input[name='maxmoney']").attr("disabled",false)
			$("input[name='starttime']").attr("disabled",false)
			$("input[name='endtime']").attr("disabled",false)
			$("#btn").attr("disabled",false)
		 })
		}
	
	function saveData() {
		layer.confirm('确定提交该出入金方案吗?', { btn : [ '确定', '取消' ]},function(index){
		layer.close(index);
		
		var id= $("#fid").val()
		var url="${path}/fundset/savefundset";
		if(id!=""&&id!=null){
			url="${path}/fundset/savefundset?id="+id;
		}
		var flag=true;	
		var pcswitch=$("input[name='pcswitch']:checked").val()
		var appswitch=$("input[name='appswitch']:checked").val()
		
		
		var starttime= $("input[name='starttime']").val()
		if (starttime==""||starttime==null) {
			layer.msg('出入金开始时间未设置'); 
			flag=false;
            return false;
        }
		var endtime= $("input[name='endtime']").val()	
		if (endtime==""||endtime==null) {
			layer.msg('出入金开始结束未设置'); 
			flag=false;
            return false;
        }
		
		
		var czcost= $("input[name='czcost']").val()
		
		if(isNaN(czcost)){
			layer.msg('手续费参数设置有误'); 
			flag=false;
            return false;
        }
		
		if(czcost==""||czcost=="undefined"||czcost<=0||czcost>=100){
			layer.msg('充值手续费设置有误'); 
			flag=false;
			 return false;
		}
		
		var txcost= $("input[name='txcost']").val()
		if(isNaN(txcost)){
			layer.msg('手续费参数设置有误'); 
			flag=false;
            return false;
        }
		
		if(czcost==""||txcost=="undefined"||czcost<=0||czcost>=100){
			layer.msg('提现手续费设置有误'); 
			flag=false;
			return false;
		}
		
		var mreg = /(^[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)/;
    	
		
		var minmoney= $("input[name='minmoney']").val()
		
		
		if (isNaN(minmoney)) {
			layer.msg('金额输入有误'); 
			flag=false;
            return false;
        }
		
		if (minmoney<0 ) {
			layer.msg('请输入正确金额'); 
			flag=false;
            return false;
        }
		var maxmoney= $("input[name='maxmoney']").val()
		
		if (isNaN(maxmoney)) {
			layer.msg('金额输入有误'); 
			flag=false;
            return false;
        }
		
		if (maxmoney<0 ) {
			layer.msg('请输入正确金额'); 
			flag=false;
            return false;
        }
		
		if (maxmoney<minmoney ) {
			layer.msg('单次最大金额小于最小金额，请重新设置'); 
			flag=false;
            return false;
        }

		if(flag){
		$.post(url,{
				"pcswitch":pcswitch,
				"appswitch":appswitch,
				"czcost":czcost,
				"txcost":txcost,
				"minmoney":minmoney,
				"maxmoney":maxmoney,
				"starttime":starttime,
				"endtime":endtime
			},function(str){
				if(str=="SUCCESS"){
					layer.msg('出入金方案设置成功');
					window.location.href = "${path}/fundset/fundsetlist";
				}
		
			
			})
		}
		})
	}
	
	//加载layui的from表单
	$(function($) {
		layui.use(['form', 'layedit', 'laydate'], function(){
			  var form = layui.form
			  ,layer = layui.layer
			  ,layedit = layui.layedit
			  ,laydate = layui.laydate;
			  
			  
			  //监听指定开关
			  form.on('switch(switchTest1)', function(data){
			    layer.msg((this.checked ? '您允许了移动端出入金' : '您禁止了客户端出入金'), {
			      offset: 'auto'
			    });
			  });
			  
			  //监听指定开关
			  form.on('switch(switchTest2)', function(data){
			    layer.msg((this.checked ? '您允许了移动端出入金' : '您禁止了移动端出入金'), {
			    	offset: 'auto'
			    });
			  });
			  
			  //日期
			  laydate.render({
			    elem: '#starttime'
			   	,type: 'time'
			  });
			  laydate.render({
			    elem: '#endtime'
			    ,type: 'time'
			  });
			});
	}); 
	
</script>
<body>
	<%@include file="../../../head.jsp"%>
	<div class="wrap">
		<%@include file="subzhMaster.jsp"%>
		<div class="Rbox">
            	<div class="mainbox">
            		<div class="Inputbox" style="width: 800px">
            	 		<h3><a href="javascript:void(0)" class="on">出入金设置</a>&nbsp;&nbsp;/&nbsp;&nbsp;<a href="javascript:void(0)" class="on" onclick="update()">需要修改请点这里</a></h3> 
            	 		<input type="hidden" id="fid" value=${fundset.id}>
						  <form class="layui-form" action="" lay-filter="example">
						
							<div class="layui-form-item" style="display: inline-block;">
						    <label class="layui-form-label">客户端入金开关</label>
						    <div class="layui-input-block">
						      <input type="checkbox" name="pcswitch" value="1" lay-skin="switch" lay-filter="switchTest1"  lay-text="允许|禁止" <c:if test="${fundset.pcswitch!=2}">checked</c:if> >
						    </div>
						  </div>
						  
						
						  <div class="layui-form-item" style="display: inline-block;">
						    <label class="layui-form-label">移动端入金开关</label>
						    <div class="layui-input-block">
						      <input type="checkbox" name="appswitch" value="1" lay-skin="switch" lay-filter="switchTest2" lay-text="允许|禁止" <c:if test="${fundset.appswitch!=2}">checked</c:if>>
						    </div>
						  </div>
							<div class="layui-inline">
						      <label class="layui-form-label">出入金时间限制</label>
						      <div class="layui-input-inline">
						        <input type="text" name="starttime" id="starttime" lay-verify="starttime"  value="${fundset.starttime}" placeholder="时-分-秒" autocomplete="off" class="layui-input">
						      </div>
						    </div>
							
							<div class="layui-inline">
						      <label class="layui-form-label1">到</label>
						      <div class="layui-input-inline">
						        <input type="text" name="endtime" id="endtime" lay-verify="endtime" value="${fundset.endtime}"  placeholder="时-分-秒" autocomplete="off" class="layui-input">
						      </div>
						  </div>
						  <br /><br />
						  <div class="layui-form-item">
						
						  <div class="layui-form-item">
						    <label class="layui-form-label">客户每笔入金手续费（%）</label>
						    <div class="layui-input-block">
						      <input type="text" name="czcost" value="${fundset.czcost}" lay-verify="title" autocomplete="off" placeholder="请输入客户每笔入金手续费" class="layui-input">
						    </div>
						  </div>
						
						<div class="layui-form-item">
						    <label class="layui-form-label">客户每笔出金手续费（%）</label>
						    <div class="layui-input-block">
						      <input type="text" name="txcost" value="${fundset.txcost}" lay-verify="title" autocomplete="off" placeholder="请输入客户每笔出金手续费" class="layui-input">
						    </div>
						  </div>
						  
						<div class="layui-form-item">
						    <label class="layui-form-label">客户每次出金最小金额</label>
						    <div class="layui-input-block">
						      <input type="text" name="minmoney" value="${fundset.minmoney}" lay-verify="title" autocomplete="off" placeholder="请输入客户每次出金最小金额" class="layui-input">
						    </div>
						  </div>
						
						<div class="layui-form-item">
						    <label class="layui-form-label">客户每次出金最大金额</label>
						    <div class="layui-input-block">
						      <input type="text" name="maxmoney" value="${fundset.maxmoney}" lay-verify="title" autocomplete="off" placeholder="请输入客户每次出金最大金额" class="layui-input">
						    </div>
						  </div>
						  </div>
						</form> 
						<div class="layui-form-item" style="width: 800px;" align="center">
								 <div class="layui-input-block">
								      <button class="layui-btn" id="btn"  onclick="saveData()">&nbsp;&nbsp;&nbsp;保&nbsp;&nbsp;存&nbsp;&nbsp;&nbsp;</button>
								 </div>
						</div>
               </div>
          </div>
     </div>
   </div> 
</body>
</html>