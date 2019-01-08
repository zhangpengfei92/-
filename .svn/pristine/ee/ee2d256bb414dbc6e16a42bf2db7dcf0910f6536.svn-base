<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>操盘方案</title>
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
<script type="text/javascript">
//条件查询和分页

function serach(pageNum) {
	if (pageNum == 0) {
		pageNum = 1;
	}
	var form = document.getElementById("frm");
	form.action = "${path}/OperateScheme/selectPage?pageNum=" + pageNum;
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

/* 去编辑页面*/
function toaddOperateScheme(id) {
	if(id==null){
		
		window.location.href = "${path}/OperateScheme/addoplist"
	}else{

		window.location.href = "${path}/OperateScheme/upoplist?id="+id;
	}
			
}

//刷新操盘方案页面
function RefreshPage() {
	  window.location.href = "${path}/OperateScheme/queryAll";
}

//删除报单账户---修改账户状态0表示不显示，1显示
function DeleteOne(id) {
	window.location.href = "${path}/OperateScheme/deleteos?osid="+id;
}

</script>
<body>
	<%@include file="../../../head.jsp"%>
		<div class="wrap">
		<%@include file="subzhMaster.jsp"%>
		<div class="Rbox">
            <div class="mainbox">
                 <h3><a href="${path}/OperateScheme/queryAll" class="on">操盘方案</a></h3>
                 <div class="main">
                      <div class="Inputbox">
                      		
                      		 <form id="frm" method="post" style="float:left;">
	                           <p><label>方案名称：</label><input type="text" id="schemename" name="schemename" value="${schemename}" placeholder="请输入"/></p>	                        
	                           <p>
	                              <button class="cx" onclick="serach()">查询</button>
	                           </p>
                           </form>
                      		
                           <p class="rbutbox">
                           <button class="cx xbuild" onclick="toaddOperateScheme();">新建</button>
                           </p>
                      </div> 
                    <div class="mtable">
                           <table width="100%;">
	                           <tr class="tit">
								<td >方案编号</td>
								<td >方案名称</td>
								<td >操盘资金</td>
								<td >操盘保证金</td>
								<td >授信资金</td>
								<td >亏岁警戒线</td>
								<td >亏岁平仓线</td>
								<td >风控模板编号</td>
								<td >账号管理费</td>
								<td >备注</td>
								<td >操作</td>
							</tr>
	                      	<c:forEach items="${olist}" var="ops" varStatus="st">
								<tr>
									<td>${ops.osid}</td>
									<td>${ops.schemename}</td>
									<td><fmt:formatNumber value="${ops.operatermoney}" pattern="0.0"/></td>
									<td><fmt:formatNumber value="${ops.operaterbzmoney}" pattern="0.0"/></td>
									<td><fmt:formatNumber value="${ops.sxmoney}" pattern="0.0"/></td>
									<td><fmt:formatNumber value="${ops.ksyjxbalance}" pattern="0.0"/></td>
									<td><fmt:formatNumber value="${ops.kspcxbalance}" pattern="0.0"/></td>
									<td>${ops.type}</td>
									<td><fmt:formatNumber value="${ops.zhglmoney}" pattern="0.0"/></td>
									<td>${ops.osremark}</td>
									<td>
									<a href="javascript:;" onclick="toaddOperateScheme(this.id)" name="编辑" id="${ops.osid}">
									编辑
									</a>
									
									<a href="javascript:;" onclick="DeleteOne(this.id)" name="删除" id="${ops.osid}">
									删除
									</a>
									</td>
								</tr>
							</c:forEach>
						</table>
		 				</div>
		 				<div class="page">
							<c:choose>
									<c:when test="${userpage.pages==0}">0/${userpage.pages}</c:when>
									<c:otherwise>${userpage.pageNum}/${userpage.pages}</c:otherwise>
								</c:choose> 共<i>${userpage.pages}</i>页
							<a class="bs" href="javascript:;" onclick="serach('1')">首页</a>
							<input type="hidden" value="${userpage.pages}" id="pages" />
							<c:if test="${userpage.pageNum!=1}">
								<a class="bs" href="javascript:;" onclick="serach('${userpage.prePage}')">上一页</a>
							</c:if>
							<c:if test="${userpage.pageNum!=userpage.pages}">
								<a class="bs" href="javascript:;" onclick="serach('${userpage.nextPage}')">下一页</a>
							</c:if>
							<a class="bs" href="javascript:;" onclick="serach('${userpage.pages}')">尾页</a>
							<a ><input type="text" id="pageNum" value="${userpage.pageNum}" style="height: 30px;line-height: 30px;padding: 0 5px;"/></a>
							<a style="cursor: pointer;" type="button" onclick="tzfy()">跳转</a>
						</div>
                    </div>
               </div>
    		</div>  
    	</div>
	</div>

</body>
</html>