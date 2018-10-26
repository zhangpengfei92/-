<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>持仓对比</title>
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

	
	//查询
	function serach(pageNum) {
		if (pageNum == 0) {
			pageNum = 1;
		}
		var form = document.getElementById("formInfoPage");
		form.action = "${path}/HolderComparsion/queryList?pageNum=" + pageNum;
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

	/* 编辑页面跳转 */
	function findsubzh(id) {
		if(id == "" || id == null){
			window.location.href = "${path}/tradeData/addsubzh";
		} else {
			window.location.href = "${path}/tradeData/editsubzh?id=" + id;
		}
	}

	//刷新页面
	function RefreshPage() {
		window.location.href = "${path}/tradeData/holderCompareList";
	}
	
	function setNext(){//重置
		$("#nickname").val("");
	}
	
</script>
<body>
	<%@include file="../../../head.jsp"%>
	<div class="wrap">
		<%@include file="subzhMaster.jsp"%>
		<div class="Rbox">
            <div class="mainbox">
                 <h3><a href="${path}/tradeData/holderCompareList" class="on">持仓对比</a></h3>
                 <div class="main">
                      <div class="Inputbox">
		                   <form id="formInfoPage" method="post" style="float:left;">
	                           <p><label>主账户：</label><input type="text" id="bdzh" name="bdzh" value="${bdzh}" placeholder="请输入"/></p>
	                           <p><label>市场：</label><input type="text" id="mark" name="mark" value="${mark}" placeholder="请输入"/></p>
	                           <p><label>合约代码：</label><input type="text" id="code" name="code" value="${code}" placeholder="请输入"/></p>
	                           <p>
	                              <button class="cx" onclick="serach('1')">查询</button>
	                              <button class="cz" onclick="setNext()">重置</button>
	                           </p>
                           </form>
                           <p class="rbutbox">
                           </p>
                      </div>
                      <div class="mtable">
                           <table width="100%;">
                           <!--  <tr class="tit">
								<td colspan="4"></td>
								<td colspan="3" align="center"><font size="3px">持仓对比</font></td>
							</tr> -->
	                         <tr class="tit">
								<td width="5%">序号</td>
								<td>主账户</td>
								<td>交易市场</td>
								<td>合约代码</td>
								<td>合约名称</td>
								<td>方向</td>
								<td>持仓总量</td>
								<td>子账户持仓量</td>
							</tr>
	                      	<c:forEach items="${page.list}" var="h" varStatus="st">
								<tr>
									<td>${(page.pagenum-1)*page.pagesize+st.count}</td>
									<td>${h.account}</td>
									<td>
										<c:if test="${h.mark eq 3 }">中金所</c:if>
										<c:if test="${h.mark eq 4 }">上期所</c:if>
										<c:if test="${h.mark eq 5 }">大商所</c:if>
										<c:if test="${h.mark eq 6 }">郑商所</c:if>
										<c:if test="${empty h.mark or h.mark eq 24 }">上海原油</c:if>
									</td>
									<td>${h.code}</td>
									<td>${h.name}</td>
									<td>${h.order_bs eq 1 ? '卖出' : '买入'}</td>
									<td>${h.vol}</td>
									<%-- <td>${h.holdMany}/${h.holdnull}</td> --%>
									<td>${h.subNum }</td>
								</tr>
							</c:forEach>
						</table>
		 				</div>
		 					<div class="page">
							<c:choose>
									<c:when test="${page.pagecount==0}">0/${page.pagecount}</c:when>
									<c:otherwise>${page.pagenum}/${page.pagecount}</c:otherwise>
								</c:choose> 共<i>${page.pagecount}</i>页
							<a class="bs" href="javascript:;" onclick="serach('1')">首页</a>
							<input type="hidden" value="${page.pagecount}" id="pages" />
							<c:if test="${page.pagenum!=1}">
								<a class="bs" href="javascript:;" onclick="serach('${page.pagenum-1}')">上一页</a>
							</c:if>
							<c:if test="${page.pagenum!=page.pagecount}">
								<a class="bs" href="javascript:;" onclick="serach('${page.pagenum+1}')">下一页</a>
							</c:if>
							<a class="bs" href="javascript:;" onclick="serach('${page.pagecount}')">尾页</a>
							<a ><input type="text" id="pageNum" value="${page.pagenum}" style="height: 30px;line-height: 30px;padding: 0 5px;"/></a>
							<a style="cursor: pointer;" type="button" onclick="tzfy()">跳转</a>
						</div>
                    </div>
               </div>
          </div>
     </div>
</body>
</html>