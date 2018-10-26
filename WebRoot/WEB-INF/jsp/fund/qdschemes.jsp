<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-Ua-Compatible" content="IE=EmulateIE8" />
<title>关联方案</title>
	<link rel="stylesheet" type="text/css" href="${path}/css/style.css" />
	<link  href="${path}/css/table/css.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${path}/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="${path}/js/My97DatePicker/WdatePicker.js"></script>
	<!-- 引入默认css -->
	<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/icon.css" />
	<script type="text/javascript" src="${path}/js/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="${path}/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${path}/js/easyui/locale/easyui-lang-zh_CN.js"></script>
	<style type="">
			.tabdiv{
				width:500px;margin-left:auto;margin-right:auto;				
			}
	
	</style>
</head>
<body style="text-align:center;">
	<div class="tabdiv" align="center">
     	<div class="tab">
			<h3>关联方案</h3>
				<div class="tabone">
					<ul>
						<li class="tit">手续方案</li>
							<c:forEach items="${cfmlist}" var="cf" >
								<li><em>${cf.title}</em></li>
							</c:forEach>
					</ul>
				</div>
				<div class="tabone tabtwo">
					<ul>
						<li class="tit">保证金方案</li>
							<c:forEach items="${blist}" var="bl">
								<li><em>${bl.title}</em></li>
							</c:forEach>
					</ul>
				</div>
					<div class="tabone tabtwo">
						<ul>
							<li class="tit">风控方案</li>
								<c:forEach items="${rtlist}" var="rl" >
									<li><em>${rl.type}</em></li>
								</c:forEach>
						</ul>
				 </div>
		</div>
	</div>	
</body>
</html>