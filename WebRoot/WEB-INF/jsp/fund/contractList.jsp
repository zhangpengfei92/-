<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>合约列表</title>
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
		var mark=$.trim($("#exchangeName").val());
		var name=$.trim($("#contractName").val());
		$("#topagenum").val(pageNum);
		$("#formInfoPage").submit();
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
	var index=0;
	function  update(id) {
		layui.use('layer', function() {
			//2.调用jquery模块
			var $ = layui.jquery;
			
			//3.调用layer模块
			layer = layui.layer;
			index=layer.open({
				type : 2,
				title : "修改合约信息",
				//不显示关闭按钮  右上角X   1为显示
				closeBtn : 2,
				//遮罩  透明度0-1  屏幕由原始亮度到最黑
				shade : [ 0.5 ],
				//坐标 弹出位置右下角
				//offset: 'rb', //右下角弹出  lt  rt  lb  rb
				anim : 0,//动画 
				area : [ '600px', '400px' ],
				content : '${path}/contract/toupdate?cid='+id,
				end : function() {
					tzfy();
					//全查询
					//window.location.href = "${path}/contract/queryAll";
				}
			});
		}); 
	}
	//监听浏览器大小发生变化，让layui的弹框自适应
	 $(window).on("resize",function(){ 
	 		if(layui.layer && layui.layer!="undefined"){
	 			layui.layer.full(index);
	 		}
	 	    
	  });
	
	//修改多条合约信息
	function updateAll() {
		var cids ="";
		var arr =$("input[name='con']:checked");
		for (var i = 0; i < arr.length; i++) {
			cids=arr[i].value+","+cids
		}
		if(cids.length<1){
			$.messager.alert('提示', '请至少选择一个合约进行修改!', 'info');
			return false;
		}
		layui.use('layer', function() {
			//2.调用jquery模块
			var $ = layui.jquery,
			//3.调用layer模块
			layer = layui.layer;
			index=layer.open({
				type : 2,
				title : "修改合约信息",
				//不显示关闭按钮  右上角X   1为显示
				closeBtn : 2,
				//遮罩  透明度0-1  屏幕由原始亮度到最黑
				shade : [ 0.5 ],
				//坐标 弹出位置右下角
				//offset: 'rb', //右下角弹出  lt  rt  lb  rb
				anim : 0,//动画 
				area : [ '600px', '400px' ],
				content : '${path}/contract/toupdateAll?cids='+cids,
				end : function() {
					//全查询
					tzfy();
					//window.location.href = "${path}/contract/queryAll?";
				}
			});
		}); 
	}
	
	/* function deleteAll() {
		layui.use('layer', function() {
			//2.调用jquery模块
			var $ = layui.jquery,
			//3.调用layer模块
			layer = layui.layer;
			layer.open({
				type : 2,
				title : "批量删除合约",
				//不显示关闭按钮  右上角X   1为显示
				closeBtn : 2,
				//遮罩  透明度0-1  屏幕由原始亮度到最黑
				shade : [ 0.5 ],
				//坐标 弹出位置右下角
				//offset: 'rb', //右下角弹出  lt  rt  lb  rb
				anim : 0,//动画 
				area : [ '800px', '600px' ],
				content : '${path}/contract/todel',
				end : function() {
					//全查询
					window.location.href = "${path}/contract/queryAll";
				}
			});
		}); 
	}
	
	//导入合约excel
	layui.use('upload', function(){
		  var $ = layui.jquery
		  ,upload = layui.upload;
		  //指定允许上传的文件类型
		  upload.render({
		    elem: '#upload'
		    ,url: '${path}/contract/upload/'
		    ,accept: 'file' //普通文件
		    ,done: function(num){
		    	if(num>0){
		    		alert("合约导入成功");
		    		RefreshPage();
		    	}else{
		    		alert("请检测文件格式是否为xls或xlsx");
		    	}	
		    }
		  }); 
		}); */
	
	//刷新页面
	function RefreshPage() {
		window.location.href = "${path}/contract/queryAll";
	}
	
	function setNext(){//重置
		$("#contractName").val("");
		serach("1");
	}
	
	function addContract() {
		window.location.href = "${path}/contract/toadd";
	}
	
</script>
<body>
	<%@include file="../../../head.jsp"%>
	<div class="wrap">
		<%@include file="subzhMaster.jsp"%>
		<div class="Rbox">
            <div class="mainbox">
                 <h3><a href="${path}/contract/queryAll" class="on">合约列表</a></h3> 
                 <div class="main">
                 	<div class="Inputbox">
		                   <form id="formInfoPage" method="post" style="float:left;" action="${path}/contract/queryAll">
	                           <p style="display:none;"><label>市场：</label><input type="text" id="exchangeName" name="exchangeName" value="${co.exchangeName}" placeholder="请输入"/></p>
	                           <p><label>合约名称：</label><input type="text" id="contractName" name="contractName" value="${co.contractName}" placeholder="请输入"/></p>
	                          <input type="hidden" id="topagenum" name="pageNum" value="${empty param.pageNum ? 1 : param.pageNum }"/>
	                           <p>
	                              <button class="cx" onclick="serach('1')">查询</button>
	                              <button class="cz" onclick="setNext()">重置</button>
	                           </p>
                           </form>
                      </div>
                      <div class="Inputbox" style="margin-top:8px;">
                         <p style="margin: 0px 0px 0px 0px">
                         <button class="cx" onclick="updateAll()">批量修改</button>
                          <button class="cx" onclick="addContract()">新增合约</button>
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
	                      	<c:forEach items="${clist}" var="con" varStatus="st">
	                      			<td width="10px"><input type="checkbox"name="con" value="${con.contractCode}" /></td>
									<td>${(userpage.pageNum-1)*userpage.pageSize + st.count}</td>
									<td>${con.market}</td>
									<td>${con.contractCode}</td>
									<td>${con.contractName}</td>
									<td><fmt:formatNumber value="${con.contractdetail}" pattern="0.#######"/></td>
									<td><fmt:formatNumber value="${con.minchangeprice}" pattern="0.#######"/></td>
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
          </div>
     </div>
</body>
</html>