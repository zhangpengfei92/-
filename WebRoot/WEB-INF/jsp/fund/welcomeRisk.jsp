<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
	<link rel="stylesheet" type="text/css" href="${path}/css/style.css" />
	<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/icon.css" />
	
	<script type="text/javascript" src="${path}/js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="${path}/js/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="${path}/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${path}/js/easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<script type="text/javascript">
	$(function(){
		$("#nav_1").addClass('.current');
	});
	
</script>
<body>
	<%@include file="../../../head.jsp"%>
	<div class="wrap">
		<%@include file="subzhMaster.jsp"%>
		<div class="Rbox">
			<div class="mainbox">
				<h3><a href="${path}/fund/welcomeRisk" class="on">报单账户风控</a></h3>
                <div class="main">
	       			<div class="mtable">
                     	<table width="100%;">
	                        <tr class="tit">
								<td width="35%">风控内容</td>
								<td>状态</td>
							</tr>
	                     	
							<tr>
								<td>报单账户自成交屏蔽</td>
								<td>已执行</td>
							</tr>
						</table>
		 			</div>
		 		</div>
	    	</div>
		</div>
     </div>
</body>
</html>