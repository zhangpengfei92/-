<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理-会员列表</title>
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
		$("#left_a_1").addClass('on');
	})
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
						url : "${path}/member/DeleteUsers",
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
	function DeleteUserOne(id) {

		$.messager.confirm('提示', '是否确定删除此账号?', function(yn) {
			if (yn) {
				$.ajax({
					url : "${path}/member/DeleteUserOne",
					type : "post",
					data : {
						"id" : id
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
						if (data == "false") {
							$.messager.alert('提示!', '删除此账号失败!', 'error',
							function() {
								parent.RefreshPage();
							});
						}
					}
				});
			}
		})
	}
	
	//禁用单个会员
	function setStatusUserOne(id) {
		$.messager.confirm('提示', '是否确定暂停此账号?', function(yn) {
			if (yn) {
				$.ajax({
					url : "${path}/member/setStatusUserOne",
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
					url : "${path}/member/reinstate",
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
					url : "${path}/member/defaultPsw",
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
						url : "${path}/member/reinstateUsers",
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

	//查询
	function serach(pageNum) {
		if (pageNum == 0) {
			pageNum = 1;
		}
		var form = document.getElementById("form1");
		form.action = "${path}/member/select?pageNum=" + pageNum;
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
	function findmember(id) {
		if(id == "" || id == null){
			window.location.href = "${path}/member/addmember";
		} else {
			window.location.href = "${path}/member/editmember?id=" + id;
		}
	}

	//刷新页面
	function RefreshPage() {
		window.location.href = "${path}/member/jumpcommonmember";
	}
	
	function setNext(){//重置
		$("#nickname").val("");
	}
	
	function addmemberMore() {//批量生成
		window.location.href = "${path}/member/addmemberMore";
	}
	
	function addmemberImport() {//导入
		window.location.href = "${path}/member/addmemberImport";
	}
	
</script>
<body>
	<%@include file="../../../head.jsp"%>
	<div class="wrap">
		<%@include file="memberView.jsp"%>
		<div class="Rbox">
            <div class="mainbox">
                 <h3><a href="${path}/warden/jumpwardenList" class="on">账户列表</a></h3>
                 <div class="main">
                      <div class="Inputbox">
		                 <form id="form1" method="post" style="float:left;">
                           <p><label>账号名称：</label><input type="text" id="nickname" name="nickname" value="${nickname}" placeholder="请输入"/></p>
                           <p>
                              <button class="cx" onclick="serach('1')">查询</button>
                              <button class="cz" onclick="setNext()">重置</button>
                           </p>
                           </form>
                           <p class="rbutbox">
                           <button class="cx xbuild" onclick="findmember('');">新建</button>
                           <button class="cz" onclick="addmemberMore();">批量生成</button>
                           <button class="cz" onclick="addmemberImport();">导入</button>
                           <button class="cz" onclick="deleteUsers();">删除</button>
                           <button class="cz" onclick="reinstateUsers();">启用</button>
                           </p>
                      </div>
                    <div class="mtable">
                           <table width="100%;">
	                           <tr class="tit">
								<td width="3%"><input type="checkbox" onclick="checkAll()" /></td>
								<td width="5%">序号</td>
								<td>账户名称</td>
							<!-- 	<td>账户密码</td> -->
								<td>账户收费</td>
								<td>账户权限</td>
								<td>起始日期</td>
								<td>结束日期</td>
								<td>手机号码</td>
								<td width="23%">操作</td>
							</tr>
	                      	<c:forEach items="${userlist}" var="user" varStatus="st">
								<tr>
									<td><input type="checkbox" name="id" value="${user.id}" /></td>
									<td>${st.count}</td>
									<td>${user.username}</td>
									<td>${user.password}</td>
									<td>${user.info}</td>
									<td>${user.funcinfo}</td>
									<td>${user.syncinfo}</td>
									<td>${user.clientfrom}</td>
									<td>${user.telephone}</td>
									<td><a href="javascript:;" onclick="findmember(this.id)" id="${user.id}">编辑</a>
									<em>|</em>&nbsp;&nbsp;<a href="javascript:;" onclick="DeleteUserOne(this.id)" id="${user.id}">删除</a>
									<c:choose>
										<c:when test="${user.delflag==0}">
											<em>|</em>&nbsp;&nbsp;<a href="javascript:;" onclick="reinstate(this.id)"
												id="${user.id}" style="color:green;">启用</a>
										</c:when>
										<c:when test="${user.delflag==1}">
											<em>|</em>&nbsp;&nbsp;<a href="javascript:;" onclick="setStatusUserOne(this.id)"
												id="${user.id}">暂停</a>
										</c:when>
									</c:choose>
									<em>|</em>&nbsp;&nbsp;<a href="javascript:;" onclick="defaultPsw(this.id)" id="${user.id}">重置密码</a>
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