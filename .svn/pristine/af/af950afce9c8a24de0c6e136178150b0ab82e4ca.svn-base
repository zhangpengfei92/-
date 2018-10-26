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

</head>
<script type="text/javascript">
//条件查询和分页
function serach(pageNum) {
	if (pageNum == 0) {
		pageNum = 1;
	}
	var form = document.getElementById("frm");
	form.action = "${path}/doc/queryByname?pageNum="+pageNum;
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

/* 去添加文档 */
function addDoc() {
		window.location.href = "${path}/doc/toAdd"	
}

//刷新页面
function RefreshPage() {
		window.location.href = "${path}/doc/queryAll";
}

//删除app文档
function DeleteUserOne(id) {
		$.ajax({
			url : "${path}/doc/delByid?id="+id,
			type : "post",
			success : function(num) {
				if (num>0) {
					alert("删除成功");
					
					window.location.href = "${path}/doc/queryAll";
			
				}else{
					alert("删除成功");
					window.location.href = "${path}/doc/queryAll";
				}
			}
		});
	
}

//查询指定文档
function querydoc(id) {
	window.location.href = "${path}/doc/queryDoc?did="+id;
}

function readApp(url) {
	window.open(url);
}

</script>
<body>
	<%@include file="../../../head.jsp"%>
		<div class="wrap">
		<%@include file="../fund/subzhMaster.jsp"%>
		<div class="Rbox">
            <div class="mainbox">
                  <h3><a href=""${path}/doc/queryAll"" class="on">App帮助</a></h3>
			<div class="mainbox">
                 <div class="main">
                      <div class="Inputbox">
                      		<form id="frm" method="post" style="float:left;">
	                           <p><label>文档名称：</label><input type="text" id="docnaem" name="docnaem" value="${docnaem}" placeholder="请输入"/></p>	                        
	                           <p>
	                              	<button class="cx" onclick="serach()">查询</button>
	                           </p>
		                     
                           </form>
                           
                        <p class="rbutbox">
	                          <button class="cx xbuild" onclick="addDoc();">新建</button>
	                     </p>
                           
                      </div> 
                    <div class="mtable">
                           <table width="100%;">
	                           <tr class="tit">
								<td >序号</td>
								<td >文档名称</td>
								<td >标题信息</td>
								<td >创建时间</td>	
								<td >操作</td>
							</tr>
	                      	<c:forEach items="${dlist}" var="doc" varStatus="st">
								<tr>
									<td>${st.count}</td>
									<td><a href="javascript:void(0)" onclick="readApp('${doc.docurl}')">${doc.docname}</a></td>
									<td>${doc.title}</td>
									<td><fmt:formatDate value="${doc.doctime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
									<td>
									<a href="javascript:;" onclick="DeleteUserOne(this.id)" name="删除" id="${doc.did}">删除</a>
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