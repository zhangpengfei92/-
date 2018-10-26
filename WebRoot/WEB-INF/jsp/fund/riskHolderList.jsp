<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>风控方案</title>
<link rel="stylesheet" type="text/css" href="${path}/css/style.css" />
	<script type="text/javascript" src="${path}/js/jquery-1.11.3.min.js"></script>
	<!-- 引入默认css -->
	<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/icon.css" />
	<script type="text/javascript" src="${path}/js/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="${path}/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${path}/js/easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<script type="text/javascript">
	$(function(){
		//$("#left_a_2").addClass('on');
		var riskTemplateIdValue = $("#riskTemplateIdValue").val();
		if(riskTemplateIdValue != null && riskTemplateIdValue != ""){
			$("#riskTemplateId").val(riskTemplateIdValue);
		}
	});
	
	/* 全选和反选 */
	var Acheckbox = false;
	function checkAll() {
		if (Acheckbox) {
			//选择每个被选中的input
			$(":checkbox").each(function() {
				this.checked = false;
			});
			Acheckbox = false;
		} else {
			$(":checkbox").each(function() {
				this.checked = true;
			});
			Acheckbox = true;
		}
	}

	//通过
	function reinstate(id) {
		window.location.href="${path}/cost/editRiskTempall?id="+id;
	}
	
	//查询
	function serach(pageNum) {
		if (pageNum == 0) {
			pageNum = 1;
		}
		var form = document.getElementById("form1");
		form.action = "${path}/cost/selectPageRiskTemplateList?pageNum=" + pageNum;
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

	//刷新页面
	function RefreshPage() {
		window.location.href = "${path}/cost/riskTemplateList";
	}
	
	function setNext(){//重置
		$("#nickname").val("");
	}
	
	function addriskTemplate(){
		window.location.href = "${path}/cost/addRiskTempall";
	}
	
	function changePage(value){//tab切换
		window.location.href = value;
	}
	
</script>
<body>
	<%@include file="../../../head.jsp"%>
	<div class="wrap">
		<%@include file="subzhMaster.jsp"%>
		<div class="Rbox">
            <div class="mainbox">
                 <h3><a href="${path}/cost/riskTemplateList" class="on">风控方案</a></h3>
                 <div class="main">
                 	  <ul class="otherCss">
                        	<li class="select" onclick="changePage('${path}/cost/riskTemplateList');">批量禁止</li>
                        	<li onclick="changePage('${path}/cost/riskStockList');">个股设置</li>
                        	<li onclick="changePage('${path}/cost/riskHolderList');">持仓比例</li>
                      </ul>
                      <div class="Inputbox">
                      	   <input type="hidden" id=riskTemplateIdValue name="riskTemplateIdValue" value="${riskTemplateId}"/>
		                   <form id="form1" method="post" style="float:left;">
	                           <p><label>方案名称：</label>
	                           		<input type="text" id="nickname" name="nickname" value="${nickname}"/>
	                           </p>
	                           <p>
	                              &nbsp;&nbsp;<button class="cx" onclick="serach('1')">查询</button>
	                           </p>
                           </form>
                           <p class="rbutbox">
                           		<button class="cx xbuild" onclick="addriskTemplate();">新建</button>
                           </p>
                      </div>
                    <div class="mtable">
                           <table width="100%;">
	                           <tr class="tit">
								<td width="5%">序号</td>
								<td>方案名称</td>
								<td>上海股指期货</td>
								<td>上海商品</td>
								<td>大连商品</td>
								<td>郑州商品</td>
								<td>更新时间</td>
								<td width="18%">操作</td>
							</tr>
	                      	<c:forEach items="${userlist}" var="user" varStatus="st">
								<tr>
									<td>${st.count}</td>
									<td>${user.type}</td>
									<td>
										<c:choose>
											<c:when test="${user.newstock==1}">禁止</c:when>
											<c:when test="${user.newstock==0}">--</c:when>
										</c:choose>
									</td>
									<td><c:choose>
											<c:when test="${user.newstockDay==1}">禁止</c:when>
											<c:when test="${user.newstockDay==0}">--</c:when>
										</c:choose></td>
									<td><c:choose>
											<c:when test="${user.rubbishstock==1}">禁止</c:when>
											<c:when test="${user.rubbishstock==0}">--</c:when>
										</c:choose></td>
									<td><c:choose>
											<c:when test="${user.businessplate==1}">禁止</c:when>
											<c:when test="${user.businessplate==0}">--</c:when>
										</c:choose></td>
									<td>
										<fmt:formatDate value="${user.modifytime}" pattern="yyyy-MM-dd hh:mm:ss" />
									</td>
									<td>
										<a href="javascript:;" onclick="reinstate('${user.id}')" id="${user.id}">修改</a>
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
</body>
</html>