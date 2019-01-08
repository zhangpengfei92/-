<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>批量删除合约</title>
<link rel="stylesheet" type="text/css" href="${path}/css/style.css" />
	<script type="text/javascript" src="${path}/js/jquery-1.9.1.min.js"></script>
	<!-- 引入默认css -->
	<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/icon.css" />
	<script type="text/javascript" src="${path}/js/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="${path}/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${path}/js/easyui/locale/easyui-lang-zh_CN.js"></script>
	<!-- 引入layui -->
	<link rel="stylesheet" href="${path}/layui/css/layui.css"  media="all">
	<script src="${path}/layui/layui.js" charset="utf-8"></script>
</head>
<script type="text/javascript">
	
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
	//条件查询
	function serach(pageNum) {
		if (pageNum == 0) {
			pageNum = 1;
		}
		var form = document.getElementById("form1");
		form.action = "${path}/contract/queryBy?pageNum=" + pageNum;
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
	
 	function del() {
		var cids ="";
		var arr =$("input[name='con']:checked");
		for (var i = 0; i < arr.length; i++){
			cids=arr[i].value+","+cids
		}
		if(cids==""){
			alert("请选择勾选要删除的合约");
		}else{
			$.messager.confirm('确认','您确认想要删除这些合约吗？',function(r){    
			    if (r){    
					$.ajax({
						url : '${path}/contract/delAll?cids='+cids,
						type : "POST",
						success : function(num) {
								alert("删除成功");
					},
						//textStatus失败的原因
						error : function(xhr, textStatus) {//请求失败之后调用 
							alert(textStatus);
						},
						complete : function() {//请求完成之后调用 全查询
							//关闭弹出层
							var index = parent.layer.getFrameIndex(window.name);  
							window.parent.layer.close(index); 
						}
					}); 
			    }    
			});
		}
	} 
	
	function setNext(){//重置
		$("#keywords").val("");
	}
	
</script>
<body>
            <div class="mainbox">
                 <div class="main">
                      <div class="Inputbox">
						   <form id="form1" method="post" style="float:left;">
	                           <p><label>请输入要删除的月份（例如：1805）：</label><input type="text" id="keywords" name="keywords" value="${keywords}" placeholder="请输入"/></p>
	                           <p>	             
	                              <button class="cx" onclick="serach('1')">查询</button>
	                              <button class="cz" onclick="setNext()">重置</button>
	                           </p>
                           </form>
                         <p class="rbutbox">
                         <button class="cx" onclick="del()">删除</button>
                         </p>
                      </div>
                    <div class="mtable">
                           <table width="100%;">
	                           <tr class="tit">
	                            <td width="10px"><input type="checkbox" onclick="checkAll()" /></td>
								<td >序号</td>
								<td >市场</td>
								<td >合约代码</td>
								<td >合约名称</td>
								<td >合约乘数</td>
								<td >最小变动价</td>
								<td >币种</td>
								<td >操作</td>
							</tr>
	                      	<c:forEach items="${rlist}" var="con" varStatus="st">
	                      			<td width="10px"><input type="checkbox"name="con" value="${con.contractCode}" /></td>
									<td>${st.count}</td>
									<td>${con.exchangeName}</td>
									<td>${con.contractCode}</td>
									<td>${con.contractName}</td>
									<td><fmt:formatNumber value="${con.contractdetail}" pattern="0.0"/></td>
									<td><fmt:formatNumber value="${con.minchangeprice}" pattern="0.0"/></td>
									<td>${con.unit}</td>
									<td>
									 <a href="javascript:;" onclick="update(this.id)" id="${con.contractCode}">修改</a>
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
</body>
</html>