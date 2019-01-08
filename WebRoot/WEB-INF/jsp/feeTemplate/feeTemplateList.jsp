<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>手续费分成方案</title>
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
		var parentidValue = $("#parentidValue").val();
		if(parentidValue != null && parentidValue != ""){
			$("#usertype").val(parentidValue);
		}
		var marketcodeValue = $("#marketcodeValue").val();
		if(marketcodeValue != null && marketcodeValue != ""){
			$("#marketcode").val(marketcodeValue);
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

	function checkData(){
		var myDate = new Date();
		var week=myDate.getDay();//获取当前星期X(0-6,0代表星期天)
		var istradeDay=0;//0不是交易日。1是交易日
		var isUpdate = 0;//不可修改
			var hour=myDate.getHours();       //获取当前小时数(0-23)
			var minus=myDate.getMinutes();     //获取当前分钟数(0-59)
			 if(hour==16){//16:00-17:00
				$.messager.alert('提示', '手续费分成结算期间,不能变更方案!', 'info');
				return false;
			}else{
				return true;
			} 
	}
	
	//通过
	function reinstate(id, stype){
			if(! checkData()){
				return false;
			};
			window.location.href="${path}/feeTemplate/editCodefeeset?id="+id;
	}
	
	
	function addCodefeeset(){
		if(! checkData()){
			return false;
		};
		window.location.href = "${path}/feeTemplate/editCodefeeset";
	}
	//查询
	function serach(pageNum) {
		if (pageNum == 0) {
			pageNum = 1;
		}
		var form = document.getElementById("form1");
		form.action = "${path}/feeTemplate/feeTemplateList?pageNum=" + pageNum;
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
		window.location.href = "${path}/feeTemplate/feeTemplateList";
	}
	
	function setNext(){//重置
		$("#nickname").val("");
	}
	
	function addFeeScheme(){
		window.location.href = "${path}/feeTemplate/addfeeScheme";
	}
	
	//修改多条合约信息
	function updateAll() {
		if(! checkData()){
			return false;
		};
		var cids = "";
		var arr = $("input[name='codefeesetId']:checked");
		if(arr.length==0){
			$.messager.alert('提示', '请勾选方案!', 'info');
			return false;
		}
		for (var i = 0; i < arr.length; i++) {
			cids = arr[i].value+","+cids;
		}
		layui.use('layer', function() {
			//2.调用jquery模块
			var $ = layui.jquery,
			//3.调用layer模块
			layer = layui.layer;
			layer.open({
				type : 2,
				title : "修改手续费分成信息",
				//不显示关闭按钮  右上角X   1为显示
				closeBtn : 2,
				//遮罩  透明度0-1  屏幕由原始亮度到最黑
				shade : [ 0.5 ],
				//坐标 弹出位置右下角
				//offset: 'rb', //右下角弹出  lt  rt  lb  rb
				anim : 0,//动画 
				area : [ '600px', '400px' ],
				content : '${path}/feeTemplate/updateCodefeesetMore?codefeesetIds='+cids,
				end : function() {
					//全查询
					window.location.href = "${path}/feeTemplate/feeTemplateList";
				}
			});
		}); 
	}
	
	
	//delete
	function deleteUserOne(id) {
		if(! checkData()){
			return false;
		};
		$.messager.confirm('提示', '是否确定删除此记录?', function(yn) {
			if (yn) {
				$.ajax({
					url : "${path}/feeTemplate/deleteCodefeeset",
					type : "post",
					data : {
						"id" : id
					},
					traditional : true,
					dataType : "text",
					success : function(data) {
						if (data == "true") {
							$.messager.alert('提示!', '成功删除此记录!', 'info',
							function() {
								parent.RefreshPage();
							});
						}
						if (data == "false") {
							$.messager.alert('提示!', '删除此账号记录失败!', 'error',
							function() {
								parent.RefreshPage();
							});
						}
					}
				});
			}
		})
	}
	
	//删除当前方案菜单
	function deleteMenu(){
		var schemeid=$("#usertype").val();
		if(schemeid){
			$.messager.confirm('提示', '是否确定删除此方案?', function(yn) {
			if (yn) {
				$.ajax({
					url : "${path}/feeTemplate/deleteCodefeeMenu",
					type : "post",
					data : {
						"id" : schemeid
					},
					traditional : true,
					dataType : "text",
					success : function(data) {
						if (data == "true") {
							$.messager.alert('提示!', '成功删除方案!', 'info',
							function() {
								parent.RefreshPage();
							});
						}
						else if (data == "false") {
							$.messager.alert('提示!', '删除此方案失败!', 'error',
							function() {
								parent.RefreshPage();
							});
						}
						else{
							$.messager.alert('提示!', '此方案中有交易用户不能删除!', 'error');
						}
					}
				});
			}
		})
		
		}
	}
</script>
<body>
	<%@include file="../../../head.jsp"%>
	<div class="wrap">
		<%@include file="../fund/subzhMaster.jsp"%>
		<div class="Rbox">
            <div class="mainbox">
                 <h3><a href="${path}/feeTemplate/feeTemplateList" class="on">手续费分成方案</a></h3>
                 <div class="main">
                      <div class="Inputbox">
                      	   <input type="hidden" id="parentidValue" name="parentidValue" value="${usertypeValue}"/>
		                   <form id="form1" method="post" style="float:left;">
	                           <p><label>方案名称：</label>
	                           		<select id="usertype" name="usertype" class="selectCss">
		                           		<c:forEach items="${feeschemeMenuList}" var="codefeesetMenu">
									    	<option value="${codefeesetMenu.id}">${codefeesetMenu.title}</option>
								        </c:forEach>
							        </select>
	                           </p>
	                           <p><label>市场：</label>
	                           	  	<select id="marketcode" name="marketcode" class="selectCss">
			                         	<option value="">全部</option>
			                         	<option value="24">上期能源INE</option>
		                           		<option value="3">中金所CFFEX</option>
			                         	<option value="4">上期所SHFE</option>
			                         	<option value="5">大商所DCE</option>
			                         	<option value="6">郑商所CZCE</option>
							      	</select>
	                           </p>
	                           <p><label>合约代码：</label>
	                           		<input type="text" id="nickname" name="nickname" maxlength="32" value="${nickname}"/>
	                           </p>
	                           <p>
	                              &nbsp;&nbsp;<button class="cx" onclick="serach('1')">查询</button>
	                           </p>
                           </form>
                           <p>
	                              &nbsp;&nbsp;<button class="cx" onclick="updateAll()">批量修改</button>
	                           </p>
                           <p style="margin-top:5px;margin-left:10px;">
	                            <button class="cz" onclick="addFeeScheme()">添加方案</button>
	                            <button class="cz" onclick="deleteMenu()" style="width:110px;">删除当前方案</button>
                           		<button class="cx xbuild" onclick="addCodefeeset();">新建</button>
                           		<input type="hidden" id="marketcodeValue" name="marketcodeValue" value="${marketcodeValue}"/>
                           </p>
                      </div>
                    <div class="mtable">
                           <table width="100%;">
	                           <tr class="tit">
								<td width="10px"><input type="checkbox" onclick="checkAll()" /></td>
								<td width="5%">序号</td>
								<td>市场</td>
								<td>合约代码</td>
								<td>合约名称</td>
								<td>机构分成系数(%)</td>
								<td>渠道分成系数(%)</td>
								<td>代理商分成系数(%)</td>
								<td>经纪人分成系数(%)</td>
								<td width="18%">操作</td>
							</tr>
	                      	<c:forEach items="${userlist}" var="user" varStatus="st">
								<tr>
									<td width="10px"><input type="checkbox" name="codefeesetId" value="${user.id}" /></td>
									<td>${st.count}</td>
									<td>
										<c:choose>
											<c:when test="${user.sc==3}">中金所CFFEX</c:when>
											<c:when test="${user.sc==4}">上期所SHFE</c:when>
											<c:when test="${user.sc==5}">大商所DCE</c:when>
											<c:when test="${user.sc==6}">郑商所CZCE</c:when>
											<c:when test="${user.sc==24}">上期能源INE</c:when>
										</c:choose>
									</td>
									
									<td>${user.stockcode}</td>
									<td>${user.stockname}</td>
									<td>${user.jgratio}</td>
									<td>${user.qdratio}</td>
									<td>${user.dlsratio}</td>
									<td>${user.jjrratio}</td>
									<%-- <td>
										<c:choose>
											<c:when test="${user.schemetype==1}">交易佣金</c:when>
											<c:when test="${user.schemetype==2}">印花税</c:when>
											<c:when test="${user.schemetype==3}">过户费</c:when>
											<c:when test="${user.schemetype==5}">管理费</c:when>
										</c:choose>
									</td>
									<td><fmt:formatNumber value="${user.percentage}" pattern="#.##" type="number"/></td>
									<td><c:choose>
											<c:when test="${user.direction=='0,1'}">双向</c:when>
											<c:when test="${user.direction=='0'}">买</c:when>
											<c:when test="${user.direction=='1'}">卖</c:when>
										</c:choose></td>
									<td>
										<c:choose>
											<c:when test="${user.showstatus==1}">显示</c:when>
											<c:when test="${user.showstatus==0}">不显示</c:when>
										</c:choose>
									</td> --%>
									<td>
										<a href="javascript:;" onclick="reinstate('${user.id}')" id="${user.id}">修改</a>
										<em>|</em>&nbsp;&nbsp;<a href="javascript:;" onclick="deleteUserOne(this.id)" id="${user.id}">删除</a>
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