<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<%-- <link rel="stylesheet" href="${path}/css/css.css" /> --%>
<link href="${path}/layui/css/layui.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${path}/export/bootstrap-grid.min.css">
<link rel="stylesheet" href="${path}/export/zoomify.min.css">
<link rel="stylesheet" href="${path}/export/style.css">	
<title>认证信息审核</title>
<style>
.numbox{border-bottom:1px solid #e9e9e9; padding:40px 0;}
.pbasic{ border:1px solid #999; padding:20px 40px; margin:0 100px;color:#666; font-size:14px;}
.pbasic ul li{border-bottom:1px solid #ddd; padding:12px 0 8px; font-size:16px;}
.pbasic ul li span{ display:inline-block; width:30%; text-align:right; padding-right:10px;}
.pbasic ul li em{display:inline-block; width:55%; padding-left:15px; }
.pbasic ul li.IDcard{ overflow:hidden; border-bottom:none;}
.pbasic ul li.IDcard p{ float:left; padding:30px 20px;}
.npbasic{ float:left; margin-left:100px; margin-right:0; width:594px;}
</style>
</head>
<body>
	<div class="numbox" style="border-top: 3px solid #eee;">
		<div class="pbasic npbasic">
			<ul>
				<li><span>真实姓名:</span><em>${subzh.name}</em></li>
				<li><span>证件号码:</span><em>${subzh.idNo}</em></li>
				<li><span>开户银行:</span><em>${subzh.bank}</em></li>
				<li><span>开户分行:</span><em>${subzh.qq}</em></li>
				<li><span>银行卡号:</span><em>${subzh.bankCard}</em></li>
				<li class="IDcard">
					<div class="container">
						<div class="examples"></div>
						<div class="row">
							<div class="example col-xs-3 col-md-3">
								<p>
									<img src="${subzh.frontPic}" class="img-rounded" alt=""  onclick="window.open('${subzh.frontPic}')">
								</p>
							</div>
							<div class="example col-xs-3 col-md-3">
								<p>
									<img src="${subzh.backPic}" class="img-rounded" alt="" onclick="window.open('${subzh.backPic}')">
								</p>
							</div>
							<div class="example col-xs-3 col-md-3">
								<p>
									<img src="${subzh.cardPic}" class="img-rounded" alt="" onclick="window.open('${subzh.cardPic}')">
								</p>
							</div>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</div>
	<form class="layui-form" action="" method="post" accept-charset="UTF-8">
		<c:if test="${sessionScope.SESSION_ISADMIN lt 3 }">
		<div class="layui-form-item" style="text-align: center;">
			<br /> <input type="hidden" name="account" value="${subzh.subzh}" />
			<c:if test="${subzh.authState eq '1'}">
				<button class="layui-btn layui-btn-warm" lay-submit lay-filter="formDemo">通过</button>
				<button class="layui-btn layui-btn-warm" lay-submit lay-filter="formDemo2">不通过</button>
			</c:if>
			<c:if test="${subzh.authState eq '2'}">
				<button type="button" class="layui-btn layui-btn-warm" lay-submit lay-filter="formDemo3">认证取消</button>
			</c:if>
			
			<button type="button" class="layui-btn layui-btn-warm Cancel">取消</button>
		</div>
		</c:if>
	</form>
</body>
<script src="${path}/js/jquery-1.9.1.min.js"></script>
<script src="${path}/js/glass/js/jquery.bridget.js"></script>
<script src="${path}/js/glass/js/jquery.mousewheel.min.js"></script>
<script src="${path}/js/glass/js/jquery.event.drag.js"></script>
<script src="${path}/js/glass/js/screenfull.js"></script>
<script src="${path}/js/glass/js/hammer.min.js"></script>
<script src="${path}/js/glass/js/PreventGhostClick.js"></script>
<script src="${path}/js/glass/src/js/mag-analytics.js"></script>
<script src="${path}/js/glass/src/js/mag.js"></script>
<script src="${path}/js/glass/src/js/mag-jquery.js"></script>
<script src="${path}/js/glass/src/js/mag-control.js"></script>
<script src="${path}/js/glass/js/index.js"></script>
<script type="text/javascript" src="${path}/layui/layui.js"></script>
<script src="${path}/export/zoomify.min.js"></script>
<script type="text/javascript">
	/* $('.example img').zoomify(); */
</script>
<script type="text/javascript">
	layui.use([ 'form', 'layer' ], function() {
		var layer = layui.layer, form = layui.form,$=layui.$;
		$(".Cancel").click(function() {
			var index = index = parent.layer.getFrameIndex(window.name);
			parent.layer.close(index);
		});
	/* 	//通过
		layer.open({
        type: 1
        ,offset: type //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
        ,id: 'layerDemo'+type //防止重复弹出
        ,content: '<div style="padding: 20px 100px;">'+ text +'</div>'
        ,btn: '关闭全部'
        ,btnAlign: 'c' //按钮居中
        ,shade: 0 //不显示遮罩
        ,yes: function(){
          layer.closeAll();
        }
      }); */
		
		
		
		form.on('submit(formDemo)',function(data){
			var field = data.field;
			var arguments = "{";
			var index = 0;
			for ( var i in field) {
			
				arguments += '"'+i + '":"' + field[i]+'"';
				arguments+=",";
			}
			
			arguments=arguments.substring(0,arguments.length-1);
            arguments+="}";
            eval("var log ="+arguments);
            $.ajax({
            	url : '${path}/fund/auth/2',
				type : 'post',
				async : false,
				data:log,
				success:function(res){
					if (res == "ok") {
						layer.msg('操作已成功');
						var pars ='?';
						var data=  $(".layui-table",window.parent.document).attr('lay-data');
					 	eval('var layData2='+data);
						var options={
				    			  height: parent.ConstantHeight 
				    			  ,url:layData2.url+pars
				    			  ,done:function(res, curr, count){
					    				  parent.layer.close(closeindex); 
					    				  parent.layer.msg('成功');
					    			  }
				    			 };
				        var index = parent.layer.getFrameIndex(window.name);
				    	parent.layer.close(index);
				    	parent.layui.table.reload('test',options);
					}else{
						layer.msg(res);
					}
				}
            });
            
			return false;
		});
		
		//不通过
		form.on('submit(formDemo2)',function(data){
			var field = data.field;
			var arguments = "{";
			var index = 0;
			for ( var i in field) {
			
				arguments += '"'+i + '":"' + field[i]+'"';
				arguments+=",";
			}
			arguments=arguments.substring(0,arguments.length-1);
            arguments+="}";
            eval("var log ="+arguments);
            $.ajax({
            	url : '${path}/fund/auth/3',
				type : 'post',
				async : false,
				data:log,
				success:function(res){
					if (res == "ok") {
						layer.msg('操作已成功');
						var pars ='?';
						var data=  $(".layui-table",window.parent.document).attr('lay-data');
					 	eval('var layData2='+data);
						var options={
				    			  height: parent.ConstantHeight 
				    			  ,url:layData2.url+pars
				    			  ,done:function(res, curr, count){
					    				  parent.layer.close(closeindex); 
					    				  parent.layer.msg('成功');
					    			  }
				    			 };
				        var index = parent.layer.getFrameIndex(window.name);
				    	parent.layer.close(index);
				    	parent.layui.table.reload('test',options);
					}else{
						layer.msg(res);
					}
				}
            });
            
			return false;
		});
		
		//取消认证
		form.on('submit(formDemo3)',function(data){
			//debugger;
			var field = data.field;
			var arguments = "{";
			var index = 0;
			for ( var i in field) {
			
				arguments += '"'+i + '":"' + field[i]+'"';
				arguments+=",";
			}
			arguments=arguments.substring(0,arguments.length-1);
            arguments+="}";
            eval("var log ="+arguments);
            $.ajax({
            	url : '${path}/fund/auth/4',//表示取消认证
				type : 'post',
				async : false,
				data:log,
				success:function(res){
					if (res == "ok") {
						layer.msg('操作已成功');
						var pars ='?';
						var data=  $(".layui-table",window.parent.document).attr('lay-data');
					 	eval('var layData2='+data);
						var options={
				    			  height: parent.ConstantHeight 
				    			  ,url:layData2.url+pars
				    			  ,done:function(res, curr, count){
					    				  parent.layer.close(closeindex); 
					    				  parent.layer.msg('成功');
					    			  }
				    			 };
				        var index = parent.layer.getFrameIndex(window.name);
				    	parent.layer.close(index);
				    	parent.layui.table.reload('test',options);
					}else{
						layer.msg(res);
					}
				}
            });
            
			return false;
		});
	});
</script>
</html>