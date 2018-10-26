<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>异常订单</title>
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
		//$("#left_a_7").addClass('on');
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
		$.messager.confirm('提示', '确定异常订单通过?', function(yn) {
			if (yn) {
				$.ajax({
					url : "${path}/tradeData/reinstate",
					type : "post",
					data : {
						"id" : id,
						"status" : 5
					},
					traditional : true,
					dataType : "text",
					success : function(data) {
						if (data == "true") {
							$.messager.alert('提示!', '审核通过!', 'info',
							function() {
								parent.RefreshPage();
							});
						}
						if (data == "false") {
							$.messager.alert('提示!', '提交失败!', 'error',
							function() {
								parent.RefreshPage();
							});
						}
					}
				});
			}
		});
	}
	
	//拒绝
	function refuseCheck(id) {
		$.messager.confirm('提示', '确定异常订单拒绝?', function(yn) {
			if (yn) {
				$.ajax({
					url : "${path}/tradeData/reinstate",
					type : "post",
					data : {
						"id" : id,
						"status" : 6
					},
					traditional : true,
					dataType : "text",
					success : function(data) {
						if (data == "true") {
							$.messager.alert('提示!', '审核拒绝!', 'info',
							function() {
								parent.RefreshPage();
							});
						}
						if (data == "false") {
							$.messager.alert('提示!', '提交失败!', 'error',
							function() {
								parent.RefreshPage();
							});
						}
					}
				});
			}
		});
	}
	
	//查询
	function serach(pageNum) {
		if (pageNum == 0) {
			pageNum = 1;
		}
		var form = document.getElementById("formInfoPage");
		form.action = "${path}/tradeData/exceptionOrderList?pageNum=" + pageNum;
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
		window.location.href = "${path}/tradeData/exceptionOrderList";
	}
	
	function setNext(){//重置
		$("#userId").val("");
	}
	
</script>
<body>
	<%@include file="../../../head.jsp"%>
	<div class="wrap">
		<%@include file="subzhMaster.jsp"%>
		<div class="Rbox">
            <div class="mainbox">
                 <h3><a href="${path}/tradeData/exceptionOrderList" class="on">异常订单</a></h3>
                 <div class="main">
                      <div class="Inputbox">
		                   <form id="formInfoPage" method="post" style="float:left;">
	                           <p><label>用户账号：</label><input type="text" id="userId" name="userId" value="${userId}" placeholder="请输入"/></p>
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
	                           <tr class="tit">
								<td width="5%">序号</td>
								<td>用户账户</td>
								<td>报单账户</td>
								<td>交易市场</td>
								<td>合约代码</td>
								<td>合约名称</td>
								<td>方向</td>
								<td>开平</td>
								<td>下单数量</td>
								<td>下单价格</td>
								<td>下单时间</td>
								<td>异常原因</td>
							</tr>
	                      	<c:forEach items="${page.list}" var="user" varStatus="st">
								<tr>
									<td>${(page.pagenum-1)*page.pagesize+st.count}</td>
									<td>${user.userId}</td>
									<td>${user.mainzh}</td>
									<td>
										${user.exchange }
									</td>
									<td>${user.hycode}</td>
									<td>${user.hypz}</td>
									<td>
										${user.fangx }
									</td>
									<td>
										${user.orderDirec }
									</td>
									<td>${user.vol}</td>
									<td>${user.price}</td>
									<td>${user.entrusttime }</td>
									<td>${user.reason}</td>
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