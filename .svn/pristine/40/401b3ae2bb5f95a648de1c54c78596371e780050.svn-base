<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>账户列表</title>
<link rel="stylesheet" type="text/css" href="${path}/css/style.css" />
	<script type="text/javascript" src="${path}/js/jquery-1.11.3.min.js"></script>
	<!-- 引入默认css -->
	<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/icon.css" />
	<script type="text/javascript" src="${path}/js/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="${path}/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${path}/js/easyui/locale/easyui-lang-zh_CN.js"></script>
	
	<link rel="stylesheet" href="${path}/layui/css/layui.css"  media="all">
	<script src="${path}/layui/layui.js" charset="utf-8"></script>
</head>
<script type="text/javascript">
	$(function(){
		//$("#left_a_1").addClass('on');
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

	//批量禁用
	function deleteUsers() {
		var ids = [];
		$("input[name='id']:checked").each(function(i) {
			ids[i] = $(this).val();
		});
		if (ids == null || ids == "") {
			$.messager.alert('提示', '请至少选择一行!', 'info');
			return false;
		} else {
			$.messager.confirm('提示!', '是否确定删除所选账号?', function(yn) {
				if (yn) {
					$.ajax({
						url : "${path}/fund/deleteSubzhList",
						type : "post",
						data : {
							"ids" : ids
						},
						traditional : true,
						dataType : "text",
						success : function(data) {
							if (data == "true") {
								$.messager.alert("提示!", '账号删除成功!', 'info',
								function() {
									RefreshPage();
								});
							}
							if (data == "false") {
								$.messager.alert("提示!", '账号删除失败!', 'error',
								function() {
									RefreshPage();
								});
							}
						}
	
					});
				}
			})
		}

	}

	//禁用单个会员
	function DeleteUserOne(id,accountid) {
		$.messager.confirm('提示', '是否确定删除此账号?', function(yn) {
			if (yn) {
				var b=true;
				
				if(b){
					$.ajax({
						url : "${path}/main/deletebdzh",
						type : "post",
						data : {
							"accountid" : accountid,
							"bdzhid" : id
						},
						traditional : true,
						dataType : "text",
						success : function(data) {
							if (data == "true") {
								$.messager.alert('提示!', '成功删除此账号!', 'info',
								function() {
									parent.RefreshPage();
								});
							}
							
							if (data == "isexist") {
								$.messager.alert('提示!', '绑定了用户,无法删除!', 'info',
								function() {
									parent.RefreshPage();
								});
							}
							if (data == "false") {
								$.messager.alert('提示!', '删除此账号失败!', 'error',
								function() {
									parent.RefreshPage();
								});
							}
						}
					});
				
				}
				
			}
		})
	}
	
	//禁用单个会员
	function setStatusUserOne(id) {
		$.messager.confirm('提示', '是否确定暂停此账号?', function(yn) {
			if (yn) {
				$.ajax({
					url : "${path}/fund/setStatusSubzhOne",
					type : "post",
					data : {
						"id" : id
					},
					traditional : true,
					dataType : "text",
					success : function(data) {
						if (data == "true") {
							$.messager.alert('提示!', '成功暂停此账号!', 'info',
							function() {
								parent.RefreshPage();
							});
						}
						if (data == "false") {
							$.messager.alert('提示!', '暂停此账号失败!', 'error',
							function() {
								parent.RefreshPage();
							});
						}
					}
				});
			}
		});
	}

	//恢复
	function reinstate(id) {
		$.messager.confirm('提示', '确定启用此账号状态?', function(yn) {
			if (yn) {
				$.ajax({
					url : "${path}/fund/reinstate",
					type : "post",
					data : {
						"id" : id
					},
					traditional : true,
					dataType : "text",
					success : function(data) {
						if (data == "true") {
							$.messager.alert('提示!', '成功启用此账号!', 'info',
							function() {
								parent.RefreshPage();
							});
						}
						if (data == "false") {
							$.messager.alert('提示!', '此账号启用失败!', 'error',
							function() {
								parent.RefreshPage();
							});
						}
					}
				});
			}
		});
	}
	
	//重置默认密码
	function defaultPsw(id) {
		$.messager.confirm('提示', '确定重置密码?', function(yn) {
			if (yn) {
				$.ajax({
					url : "${path}/fund/defaultPsw",
					type : "post",
					data : {
						"id" : id
					},
					traditional : true,
					dataType : "text",
					success : function(data) {
						if (data == "true") {
							$.messager.alert('提示!', '成功重置密码!', 'info',
							function() {
								parent.RefreshPage();
							});
						}
						if (data == "false") {
							$.messager.alert('提示!', '此账号重置密码失败!', 'error',
							function() {
								parent.RefreshPage();
							});
						}
					}
				});
			}
		});
	}
	
	//批量启用
	function reinstateUsers() {
		var ids = [];
		$("input[name='id']:checked").each(function(i) {
			ids[i] = $(this).val();
		});
		if (ids == null || ids == "") {
			$.messager.alert('提示', '请至少选择一行!', 'info');
			return false;
		} else {
			$.messager.confirm('提示!', '是否确定启用所选账号?', function(yn) {
				if (yn) {
					$.ajax({
						url : "${path}/fund/reinstateSubzhList",
						type : "post",
						data : {
							"ids" : ids
						},
						traditional : true,
						dataType : "text",
						success : function(data) {
							if (data == "true") {
								$.messager.alert("提示!", '账号启用成功!', 'info',
								function() {
									RefreshPage();
								});
							}
							if (data == "false") {
								$.messager.alert("提示!", '账号启用失败!', 'error',
								function() {
									RefreshPage();
								});
							}
						}
	
					});
				}
			});
		}
	}

	//条件查询
	function serach(pageNum) {
		if (pageNum == 0) {
			pageNum = 1;
		}
		var form = document.getElementById("form1");
		form.action = "${path}/main/querybdzh?pageNum=" + pageNum;
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
	function findbdzh(id) {
		if(id == "" || id == null){
			window.location.href = "${path}/main/addBdzhlist";
		} else {
			window.location.href = "${path}/main/addBdzhlist?id=" + id;
		}
	}

	//刷新页面
	function RefreshPage() {
		window.location.href = "${path}/main/querybdzh";
	}
	
	//删除报单账户---修改账户状态0表示不显示，1显示
	/* function DeleteUserOne(id) {
		window.location.href = "${path}/main/deletebdzh?accountid="+id;
	} */
	
	function setNext(){//重置
		$("#accountid").val("");
		serach('1');
	}
	
	function addsubzhMore() {//批量生成
		window.location.href = "${path}/fund/addsubzhMore";
	}
	
	function addsubzhImport() {//导入
		window.location.href = "${path}/fund/addsubzhImport";
	}
	
</script>
<body>
	<%@include file="../../../head.jsp"%>
	<div class="wrap">
		<%@include file="subzhMaster.jsp"%>
		<div class="Rbox">
            <div class="mainbox">
                 <h3><a href="${path}/main/querybdzh" class="on">主账户列表</a></h3>
                 <div class="main">
                      <div class="Inputbox">
		                   <form id="form1" method="post" style="float:left;">
	                           <p><label>报单账户：</label><input type="text" id="accountid" name="accountid" value="${accountid}" placeholder="请输入"/></p>
	                           <p>
	                              <button class="cx" onclick="serach('1')">查询</button>
	                              <button class="cz" onclick="setNext()">重置</button>
	                           </p>
                           </form>
                           <p class="rbutbox">
                           <button class="cx xbuild" onclick="findbdzh('');">新建</button>
                          <!--  <button class="cz" onclick="deleteUsers();">删除</button> -->
                           <%--<button class="cz" onclick="reinstateUsers();">启用</button>--%>
                           </p>
                      </div>
                    <div class="mtable">
                           <table width="100%;">
	                           <tr class="tit">
								<td width="5%">序号</td>
								<td >账户编号</td>
								<td >静态权益</td>
								
								<td >平仓盈亏</td>
								<td >持仓盈亏</td>
								<td >动态权益</td>
								
								<td >占用保证金</td>
								<td >可用资金</td>
								<td >交易手续费</td>
								
								<td width="15%">操作</td>
							</tr>
	                      	<c:forEach items="${blist}" var="bdzh" varStatus="st">
									<td>${(userpage.pageNum-1)*userpage.pageSize + st.count}</td>
									<td><a href="javascript:void(0)">${bdzh.accountid}</a></td>
									<td><fmt:formatNumber value="${bdzh.suminterest}" pattern="0.0"/></td>
									
									<td><fmt:formatNumber value="${bdzh.pcProfit}" pattern="0.0"/></td>
									<td><fmt:formatNumber value="${bdzh.holderProfit}" pattern="0.0"/></td>
									<td><fmt:formatNumber value="${bdzh.dymicEquities}" pattern="0.0"/></td>
									
									<td><fmt:formatNumber value="${bdzh.bzmoney}" pattern="0.0"/></td>
									<td><fmt:formatNumber value="${bdzh.avaamoney}" pattern="0.0"/></td>
									<td><fmt:formatNumber value="${bdzh.fee}" pattern="0.0"/></td>
									<td>
										<a href="javascript:;" onclick="DeleteUserOne('${bdzh.bdzhid}','${bdzh.accountid}')" id="${bdzh.accountid}">删除</a>
										<em>|</em><a href="javascript:;" onclick="findbdzh(this.id)" id="${bdzh.bdzhid}" style="padding-right: 0px;">修改</a>
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