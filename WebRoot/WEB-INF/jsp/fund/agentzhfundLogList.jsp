<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>提现审核</title>
<link rel="stylesheet" type="text/css" href="${path}/css/style.css" />
<script type="text/javascript" src="${path}/js/jquery-1.11.3.min.js"></script>
<!-- 引入默认css -->
<link rel="stylesheet" type="text/css"
	href="${path}/js/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="${path}/js/easyui/themes/icon.css" />
<script type="text/javascript" src="${path}/js/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${path}/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${path}/js/easyui/locale/easyui-lang-zh_CN.js"></script>

<!-- 引入layui -->
<link rel="stylesheet" href="${path}/layui/css/layui.css" media="all">
<script src="${path}/layui/layui.js" charset="utf-8"></script>
</head>
<script type="text/javascript">
	$(function() {
		//$("#left_a_2").addClass('on');
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
		$.messager.confirm('提示', '确定提现审核通过?', function(yn) {
			if (yn) {
				openwindows();
				$.ajax({
					url : "${path}/fundAuto/fundAuto",
					type : "post",
					data : {
						"id" : id,
						"status" : 5
					},
					traditional : true,
					dataType : "json",
					success : function(data) {
						closewindows();
						
						if (data.status ==200) {
							$.messager.alert('提示!', '审核通过!', 'info',
									function() {
										parent.RefreshPage();
									});
						} else {
							$.messager.alert('提示!', '提交失败!', 'info',
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
		$.messager.confirm('提示', '确定提现审核拒绝?', function(yn) {
			if (yn) {
				openwindows();
				$.ajax({
					url : "${path}/apppay/PhonePay/checkWithdraw",
					type : "post",
					data : {
						"id" : id,
						"status" : 6
					},
					traditional : true,
					dataType : "json",
					success : function(data) {
						if (data == "200") {
							$.messager.alert('提示!', '审核拒绝!', 'info',
									function() {
										closewindows()
									});
									tzfy()
						}
						if (data == "400") {
							$.messager.alert('提示!', '提交失败!', 'error',
									function() {
										closewindows()
									});
									tzfy()
						} else {
							$.messager.alert('提示!', data, 'info', function() {
								closewindows()
							});
						}
					}
				});
			}
		});
	}

		//监听浏览器大小发生变化，让layui的弹框自适应
	 $(window).on("resize",function(){ 
	 		if(layui.layer && layui.layer!="undefined"){
	 			layui.layer.full(index);
	 		}
	 	    
	  });
	
	//查看用户实时金额数据
	function lookagen(id) {
		layui.use('layer', function() {
			//2.调用jquery模块
			var $ = layui.jquery,
			//3.调用layer模块
			layer = layui.layer;
			layer.open({
				type : 2,
				title : '提现信息',
				//不显示关闭按钮  右上角X   1为显示
				closeBtn : 2,
				//遮罩  透明度0-1  屏幕由原始亮度到最黑
				shade : [ 0.5 ],
				//坐标 弹出位置右下角
				//offset: 'rb', //右下角弹出  lt  rt  lb  rb
				anim : 0,//动画 
				area : [ '800px', '300px' ],
				content : '${path}/apppay/PhonePay/querysubzhfund?subzh='+id,
				
				end : function() {
					 tzfy()

				}
			});
		});
	}
	
	
	//当点通过后，出现悬浮框悬浮框
	function openwindows() {
		layui.use('layer', function() {
			//2.调用jquery模块
			var $ = layui.jquery,
			//3.调用layer模块
			layer = layui.layer;
			layer.open({
				type : 1,
				offset : 'auto',
				id : 'layerDemo' + 'auto' //防止重复弹出
				,
				content : '<div style="padding: 20px 100px;">' + "审核提交中，请稍侯"
						+ '</div>',
				shade : 0.5 //不显示遮罩
				,
				closeBtn : 0,
				yes : function() {
					layer.closeAll();
				}
			});
		});
	}

	function closewindows(){
		layui.use('layer', function() {
			//2.调用jquery模块
			var $ = layui.jquery,
			//3.调用layer模块
			layer = layui.layer;
			layer.closeAll();
		});
	}

	//查询
	function serach(pageNum) {
		if (pageNum == 0) {
			pageNum = 1;
		}
		var form = document.getElementById("form1");
		form.action = "${path}/fundlog/selectPage?pageNum=" + pageNum;
		form.submit();
	}

	//导出
	function setExport() {
		var form = document.getElementById("form1");
		form.action = "${path}/fundlog/selectExport";
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
		if (pageNum * 1 > pages * 1) {
			$.messager.alert('提示', '输入的页数无效!', 'info');
			return false;
		}
		serach(pageNum);
	}

	/* 编辑页面跳转 */
	function findsubzh(id) {
		if (id == "" || id == null) {
			window.location.href = "${path}/fundlog/addsubzh";
		} else {
			window.location.href = "${path}/fundlog/editsubzh?id=" + id;
		}
	}

	//刷新页面
	function RefreshPage() {
		window.location.href = "${path}/fundlog/agentzhfundLogList";
	}

	function setNext() {//重置
		$("#nickname").val("");
	}
</script>
<body>
	<%@include file="../../../head.jsp"%>
	<div class="wrap">
		<%@include file="subzhMaster.jsp"%>
		<div class="Rbox">
			<div class="mainbox">
				<h3>
					<a href="${path}/fundlog/agentzhfundLogList" class="on">提现审核</a>
				</h3>
				<div class="main">
					<div class="Inputbox">
						<form id="form1" method="post" style="float: left;">
							<p>
								<label>账号代码：</label><input type="text" id="nickname"
									name="nickname" value="${nickname}" placeholder="请输入" />
							</p>
						</form>
						<p>
							<button class="cx" onclick="serach('1')">查询</button>
							<button class="cz" onclick="setNext()">重置</button>
							<button class="cz" onclick="setExport()">导出</button>
						</p>
						<p class="rbutbox"></p>
					</div>
					<div class="mtable">
						<table width="100%;">
							<tr class="tit">
								<td width="5%">序号</td>
								<td>账户代码</td>
								<td>类型</td>
								<td>金额</td>
								<td>姓名</td>
								<td>卡号</td>
								<td>开户行</td>
								<td>开户支行</td>
								<td>状态</td>
								<td>更新时间</td>
								<td>查看余额</td>
								<td width="18%">操作</td>
							</tr>
							<c:forEach items="${userlist}" var="user" varStatus="st">
								<tr>
									<td>${st.count}</td>
									<td>${user.subzh}</td>
									<td>提现</td>
									<td><fmt:formatNumber value="${user.fund}" pattern="0.00" /></td>
									<td>${user.name}</td>
									<td>${user.bankID=="null"?"":user.bankID}</td>
									<td>${user.bankname}</td>
									<td>${user.banchname}</td>
									<td><c:choose>
											<c:when test="${user.status==4}">提现申请</c:when>
											<c:when test="${user.status==5}">处理中</c:when>
											<c:when test="${user.status==6}">审核拒绝</c:when>
											<c:when test="${user.status==7}">提现成功</c:when>
											<c:when test="${user.status==8}">提现失败</c:when>
											<c:when test="${user.status==9}">调账出金失败</c:when>
											<c:when test="${user.status==11}">调账出金成功</c:when>
										</c:choose></td>
									<td><fmt:formatDate value="${user.modifytime}" type="both" /></td>
									<td><a href="javascript:;" onclick="lookagen(this.id)"id="${user.subzh}">查看</a></td>
									<td><c:choose>
											<c:when test="${user.status==4}">
												<a href="javascript:;" onclick="reinstate(this.id)"
													id="${user.id}">通过</a>
												<em>|</em>&nbsp;&nbsp;<a href="javascript:;"
													onclick="refuseCheck(this.id)" id="${user.id}">拒绝</a>
											</c:when>
											<c:when test="${user.status==7}">
												<a href="javascript:;">提现完成</a>
											</c:when>

											<c:when test="${user.status==5}">
												<a href="javascript:;">审核中</a>
											</c:when>
											<c:when test="${user.status==6}">
												<a href="javascript:;">提现审核不通过</a>
											</c:when>
											<c:when test="${user.status==8}">
												<a href="javascript:;">提现失败</a>
											</c:when>
											<c:when test="${user.status==9}">
												<a href="javascript:;">调账出金失败</a>
											</c:when>
											<c:when test="${user.status==11}">
												<a href="javascript:;">调账出金成功</a>
											</c:when>
										</c:choose></td>
								</tr>
							</c:forEach>
						</table>
					</div>
					<div class="page">
						<c:choose>
							<c:when test="${userpage.pages==0}">0/${userpage.pages}</c:when>
							<c:otherwise>${userpage.pageNum}/${userpage.pages}</c:otherwise>
						</c:choose>
						共<i>${userpage.pages}</i>页 <a class="bs" href="javascript:;"
							onclick="serach('1')">首页</a> <input type="hidden"
							value="${userpage.pages}" id="pages" />
						<c:if test="${userpage.pageNum!=1}">
							<a class="bs" href="javascript:;"
								onclick="serach('${userpage.prePage}')">上一页</a>
						</c:if>
						<c:if test="${userpage.pageNum!=userpage.pages}">
							<a class="bs" href="javascript:;"
								onclick="serach('${userpage.nextPage}')">下一页</a>
						</c:if>
						<a class="bs" href="javascript:;"
							onclick="serach('${userpage.pages}')">尾页</a> <a><input
							type="text" id="pageNum" value="${userpage.pageNum}"
							style="height: 30px; line-height: 30px; padding: 0 5px;" /></a> <a
							style="cursor: pointer;" type="button" onclick="tzfy()">跳转</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>