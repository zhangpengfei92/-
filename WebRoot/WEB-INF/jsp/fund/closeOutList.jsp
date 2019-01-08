<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>止损平仓预警</title>
	<link rel="stylesheet" type="text/css" href="${path}/css/style.css" />
	<script type="text/javascript" src="${path}/js/jquery-1.11.3.min.js"></script>
	<!-- 引入默认css -->
	<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/icon.css" />
	<script type="text/javascript" src="${path}/js/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="${path}/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${path}/js/easyui/locale/easyui-lang-zh_CN.js"></script>
	<!--easyui  -->
	<link href="${path}/layui/css/layui.css" rel="stylesheet"type="text/css" />
	<link href="${path}/layui/css/main.css" rel="stylesheet" type="text/css" />
	<script src="${path}/layui/layui.js" type="text/javascript"></script>
</head>
	<style type="text/css">
		.otherCss{ height:32px;border-bottom:1px solid #e9e9e9;}
		.otherCss li {float: left;cursor: pointer;display: block;width: 130px;text-align: center;height: 32px;line-height: 32px;background: #ddd; margin-right: 15px;}
		.otherCss li.select{background:#1890ff;color:#fff;}
	</style>
<script type="text/javascript">
	//条件查询和分页
	
	function serach(pageNum) {
		if (pageNum == 0) {
			pageNum = 1;
		}
		var form = document.getElementById("frm");
		form.action = "${path}/order/queryPageCloseOut?pagenum="+pageNum;
		form.submit();
	} 

	//翻页
	function tzfy() {
	
		var pageNum = $.trim($("#pageNum").val());
		if (!pageNum) {
			$.messager.alert('提示', '请输入页码!', 'info');
			return false;
		}
		var pages = $.trim($("#pages").val());
		if (pageNum*1 > pages*1) {
			$.messager.alert('提示', '输入的页数无效!', 'info'); 
			return false;
		}
		serach(pageNum);
	}
	
	function RefreshPage() {
		 window.location.href = "${path}/order/closeOutList";
	}

	function changePage(value){//tab切换
		window.location.href = value;
	}
	
	//通过
	function reinstate(id) {
		$.messager.confirm('提示', '确定执行一键平仓?', function(yn) {
			if (yn) {
				$.ajax({
					url : "${path}/order/reinstate",
					type : "post",
					data : {
						"subzh" : id
					},
					traditional : true,
					dataType : "text",
					success : function(data) {
						if (data == true || data == "true") {
							$.messager.alert('提示!', '提交成功!', 'info',
							function() {
								parent.RefreshPage();
							});
						} else if (data == "false") {
							$.messager.alert('提示!', '提交失败!', 'error',
							function() {
								parent.RefreshPage();
							});
						} else {
							$.messager.alert('提示!', data, 'error',
							function() {
								parent.RefreshPage();
							});
						}
					}
				});
			}
		});
	}
	
</script>
<body>
	<%@include file="../../../head.jsp"%>
		<div class="wrap">
		<%@include file="subzhMaster.jsp"%>
		<div class="Rbox">
            <div class="mainbox">
                 <h3><a href="${path}/order/closeOutList" class="on">止损平仓预警</a></h3>
                 <div class="main">
                 	<ul class="otherCss">
                    	<li class="select" onclick="changePage('${path}/order/closeOutList');">风控预警</li>
                        <li onclick="changePage('${path}/order/riskLogList');">预警记录</li>
                    </ul>
                      <div class="Inputbox" style="padding-top: 15px;">
                      		
                      	  <form id="frm" method="post" style="float:left;">
	                           <p><label>账户代码：</label><input type="text" id="subzh" name="subzh" value="${subzh}" placeholder="请输入"/></p>	                        
	                           <p>
	                              <button class="cx" onclick="serach('1')">查询</button>
	                           </p>
                           </form>
                      </div> 
                    <div class="mtable">
                           <table width="100%;">
	                           <tr class="tit">
								<td >序号</td>
								<td >账户代码</td>
								<td >币种账户</td>
								<td >总资产</td>
								<td >预警线</td>
								<td >平仓线</td>
								<td >风控状态</td>
								<td >限制状态</td>
								<td >操作</td>
							</tr>
	                      	<c:forEach items="${olist}" var="order" varStatus="st">
								<tr>
									<td>${st.count}</td>
									<td>${order.subzh}</td>
									<td>人民币账户</td>
									<td><fmt:formatNumber value="${order.total_assets}" pattern="#.##" type="number"/></td>
									<td><fmt:formatNumber value="${order.warning_line}" pattern="#.##" type="number"/></td>
									<td><fmt:formatNumber value="${order.close_line}" pattern="#.##" type="number"/></td>
									<td>
										<c:choose>
											<c:when test="${order.risk_state==1}">正常</c:when>
											<c:when test="${order.risk_state==2}">触发预警</c:when>
											<c:when test="${order.risk_state==3}">触发平仓</c:when>
											<c:when test="${order.risk_state==0}">风控异常</c:when>
										</c:choose>
									</td>
									<td><c:choose>
											<c:when test="${order.can_buy==1}">禁买</c:when>
											<c:when test="${order.can_buy==2}"></c:when>
										</c:choose>
									</td>
									<td><a href="javascript:;" onclick="reinstate(this.id)" id="${order.subzh}">一键平仓</a></td>
								</tr>
							</c:forEach>
						</table>
		 				</div>
		 				<div class="page">
							<c:choose>
									<c:when test="${userpage.pagecount==0}">0/${userpage.pagecount}</c:when>
									<c:otherwise>${userpage.pagenum}/${userpage.pagecount}</c:otherwise>
								</c:choose> 共<i>${userpage.pagecount}</i>页
							<a class="bs" href="javascript:;" onclick="serach('1')">首页</a>
							<input type="hidden" value="${userpage.pagecount}" id="pages" />
							<c:if test="${userpage.pagenum!=1}">
								<a class="bs" href="javascript:;" onclick="serach('${userpage.pagenum-1}')">上一页</a>
							</c:if>
							<c:if test="${userpage.pagenum!=userpage.pagecount}">
								<a class="bs" href="javascript:;" onclick="serach('${userpage.pagenum+1}')">下一页</a>
							</c:if>
							<a class="bs" href="javascript:;" onclick="serach('${userpage.pagecount}')">尾页</a>
							<a ><input type="text" id="pageNum" value="${userpage.pagenum}" style="height: 30px;line-height: 30px;padding: 0 5px;"/></a>
							<a style="cursor: pointer;" type="button" onclick="tzfy()">跳转</a>
						</div>
                    </div>
               </div>
    		</div>  
    	</div>
	</div>

</body>
</html>