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
	<script type="text/javascript" src="${path}/js/qrcode.min.js"></script>
	<script type="text/javascript" src="${path}/js/easyui/locale/easyui-lang-zh_CN.js"></script>
	
	<!-- 引入layui -->
	<link rel="stylesheet" href="${path}/layui/css/layui.css"  media="all">
	<script src="${path}/layui/layui.js" charset="utf-8"></script>
	<style type="text/css">
		.headdiv a{
			border:3px solid #000;
			width: 65px;
    		height: 30px;
		}
		.headdiv .ona{
    		background: #74eada;
		}
		.tableinputbutton{
		    width: 60px;
		    height: 25px;
		    background: #76a2d0;
		}
		.mainbox ul{
            display:inline;
            white-space: nowrap;
        }
        .mainbox ul li{
            padding: 10px 20px;
            display: inline-block;
            background:#f1e5e5;
            white-space:nowrap;
        }
        .mainbox ul li.selectchx{
        	background:#49a9ee;
        }
        #Tindexcode{width:300px;background: #fff;z-index: 11;display: none; border:1px solid #267ed8;font-size:14px; }
		#Tindexcode h3{height:34px;line-height:34px;color:#267ed8;font-size:18px;padding-left:20px;}		  
		#closeboxIcode{position:absolute;right:10px;top:5px;}
		#closeboxIcode a{ display:block;}
	</style>
</head>
<script type="text/javascript">
	var isadmin=2;
	$(function(){
		//定义弹窗位置
        jQuery.fn.center = function () {
            this.css({
                "position" :"fixed",
                "top" : 50 + "%",
                "marginTop" : ("-" + this.height() / 2) + "px",
                "left" : ( $(window).width() - this.width() ) / 2+$(window).scrollLeft() + "px"
            });
            return this;
		};
			$("#Tindexcode").center();
			//弹窗、遮罩显示/隐藏
			$('.bta').click(function(){
				$('#Tindexcode').fadeIn();
			});
			$('#closeboxIcode').click(function(){
				$('#Tindexcode').fadeOut();
			});
			
			
	});
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

	//删除
	function deleteSubzh(isadmin,id) {
		$.messager.confirm('提示', '是否确定删除此渠道?', function(yn) {
			if (yn) {
				$.ajax({
					url : "${path}/fund/deleteSubzh",
					type : "post",
					data : {
						"subzh" : id,
						"isadmin":isadmin
					},
					traditional : true,
					dataType : "json",
					success : function(data) {
						if (data.status == 0) {
							$.messager.alert('提示!', '成功删除此渠道!', 'info',
							function() {
								parent.RefreshPage();
							});
						}else{
							$.messager.alert('提示!', data.message);
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
	
	//切换
	function change(isadmin){
		window.location.href="${path}/fund/subzhList?isadmin="+isadmin;
	}
	
	//去设置权限页面
	function setper(isadmin,subzh) {
		//通过post请求去后台查询当前账户的上级账户是否有设置权限
		$.post("${path}/fund/ispre?subzh="+subzh+"&isadmin="+isadmin,function(data){
			if(data=="true"){
				window.location.href="${path}/fund/setpre?subzh="+subzh+"&isadmin="+isadmin;				
			}else{
				$.messager.alert('提示', '该用户的上级用户未设置权限!', 'info'); 
			}
		})			
		}

	//查询
	function serach(pageNum) {
		if (pageNum == 0) {
			pageNum = 1;
		}
		var form = document.getElementById("form1");
		form.action = "${path}/fund/subzhList?pageNum=" + pageNum+"&isadmin=3";
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
	function findsubzh(isadmin,id) {
		if(id == "" || id == null){
			window.location.href = "${path}/fund/addsubzh?isadmin="+isadmin;
		} else {
			window.location.href = "${path}/fund/toUpdate?id="+ id+"&isadmin="+isadmin;
		}
	}

	//刷新页面
	function RefreshPage() {
		window.location.href = "${path}/fund/subzhList?isadmin=3";
	}
	
	function setNext(){//重置
		$("#subzh").val("");
		$("#name").val("");
	}
	
	function addsubzhMore() {//批量生成
		window.location.href = "${path}/fund/addsubzhMore";
	}
	
	function resetPass(subzh) {//初始化密码
		$.messager.confirm('提示','确认需要初始化密码吗?',function(r){
		    if (r){
				$.ajax({
						url : "${path}/fund/defaultPsw",
						type : "post",
						data : {
							"subzhName" : subzh
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
	
/* 	function seeJjr(subzh,name){
		window.open("${path}/fund/subzhList?isadmin=5&allocchannel="+subzh);
	} */
	var qrcode="";
	//查看某个渠道的二维推广码
	function seeTheCode(manage,pt,channel,isadmin){
		var codeurl="${basePath}/app/skipRegister";
		if(qrcode){
			qrcode.clear();
			$("#qrcode").html("");
			qrcode="";
		}
		
		if(!manage || !pt){
			$.messager.alert('提示!', '此渠道的平台有问题不能用于推广!', 'info');
			$('#Tindexcode').fadeOut();
			$('#Tindexcode').hide();
			return false;
		}
		var url=codeurl+"?manage="+manage+"&allocpt="+pt+"&pagentzh="+channel+"&allocchannel="+channel;
		//生成二维码
		qrcode = new QRCode(document.getElementById("qrcode"), {
			text: url,
			width: 128,
			height: 128,
			colorDark : "#000000",
			colorLight : "#ffffff",
			correctLevel : QRCode.CorrectLevel.H
		});
	}
	
	function showAuth(subzh){
		layer.open({
			  title: '认证审核信息'
			  ,type:2
			  ,content:'${path}/fund/showAuth/'+subzh
			  ,area:["840px","600px"]
			  ,moveOut:true
			  ,end:function(){
			  }
		  });
	}
	
	function  querySchemes(id) {
		layui.use('layer', function() {
			//2.调用jquery模块
			var $ = layui.jquery;
			
			//3.调用layer模块
			layer = layui.layer;
			index=layer.open({
				type : 2,
				title : "关联方案",
				//不显示关闭按钮  右上角X   1为显示
				closeBtn : 2,
				//遮罩  透明度0-1  屏幕由原始亮度到最黑
				shade : [ 0.5 ],
				//坐标 弹出位置右下角
				//offset: 'rb', //右下角弹出  lt  rt  lb  rb
				anim : 0,//动画 
				area : [ '600px', '400px' ],
				content : '${path}/fund/querySchemes?subzh='+id,
				end : function() {
				/* 	//全查询
					$("#btn_skip").click(); */
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
	
</script>
<body>
	<%@include file="../../../head.jsp"%>
	<div class="wrap">
		<%@include file="subzhMaster.jsp"%>
		<div class="Rbox">
            <div class="mainbox">
                   <ul>
		            <c:if test="${sessionScope.SESSION_ISADMIN lt 3 }"><li class="selectchx" onclick="change(3)" id="fundlable">渠道账户</li></c:if>
		            <c:if test="${sessionScope.SESSION_ISADMIN lt 4 }"><li onclick="change(4)" id="holdlable">代理商</li></c:if>
		            <c:if test="${sessionScope.SESSION_ISADMIN lt 5 }"><li onclick="change(5)" id="entrustlable">经纪人账户</li></c:if>
		            <c:if test="${sessionScope.SESSION_ISADMIN lt 6 }"><li onclick="change(6)" id="deallable">交易用户</li></c:if>
		        	</ul>
                 <div class="main">
                 	<%-- <div style="height:50px;" class="headdiv">
	                 	<c:if test="${sessionScope.SESSION_ISADMIN eq 1 }"><a href="${path}/fund/subzhList?isadmin=2" class="ona">渠道账户</a></c:if>
	                 	<c:if test="${sessionScope.SESSION_ISADMIN lt 3 }"><a href="${path}/fund/subzhList?isadmin=3">经纪人账户</a></c:if>
	                 	<a href="${path}/fund/subzhList?isadmin=4">交易用户</a>
	                 </div> --%>
                      <div class="Inputbox">
		                   <form id="form1" method="post" style="float:left;">
	                           <p><label>渠道编号：</label><input type="text" id="subzh" name="subzh" value="${sub.subzh}" placeholder="请输入渠道编号"/>
	                           		<label>渠道名称：</label><input type="text" id="name" name="name" value="${sub.name}" placeholder="请输入渠道名称"/>
	                           </p>
	                           <p>
	                              <button class="cx" onclick="serach('1')">查询</button>
	                              <button class="cz" onclick="setNext()">重置</button>
	                           </p>
                           </form>
                           <p class="rbutbox">
                           <button class="cx xbuild" onclick="findsubzh(3,'');" style="width:100px;">新增渠道</button>
                           </p>
                      </div>
                    <div class="mtable">
                           <table width="100%;">
	                           <tr class="tit">
	                          	<!-- <td width="10px"><input type="checkbox" onclick="checkAll()" /></td> -->
								<td width="5%">序号</td>
								<td>渠道编号</td>
								<td>渠道名称</td>
								<td>认证状态</td>
								<!-- <td>分成系数%</td> -->
								<td>资金账户</td>
								<td>联系方式</td>
								<td>关联方案</td>
								<td>推广码</td>
								<td width="30%">操作</td>
							</tr>
	                      	<c:forEach items="${userlist}" var="user" varStatus="st">
	                      		<tr>
									<%-- <td width="10px"><input type="checkbox" value="${user.subzh}" /></td> --%>
									<td>${(userpage.pageNum-1)*userpage.pageSize+st.count}</td>
									<td>${user.subzh}</td>
									<td>${user.name}</td>
									<td>
										<c:if test="${empty user.authState or user.authState eq '0'}"><span style="color:#666666">未认证</span></c:if>
										<c:if test="${user.authState eq '1'}"><a href="javascript:void(0);" onclick="showAuth('${user.subzh}')" style="padding-right: 0px;color:#FF00FF">审核中</a></c:if>
										<c:if test="${user.authState eq '2'}"><a href="javascript:void(0);" onclick="showAuth('${user.subzh}')" style="padding-right: 0px;color:#00AA00">已认证</a></c:if>
										<c:if test="${user.authState eq '3'}"><a href="javascript:void(0);" onclick="showAuth('${user.subzh}')" style="padding-right: 0px;color:#FF5511">未通过</a></c:if>
									</td>
									<td><fmt:formatNumber value="${user.fundbalance}" pattern="#.#######"/></td>
									<td>${user.phone}</td>
									<td><a href="javascript:;" onclick="querySchemes(this.id)" id="${user.subzh}">查看方案</a></td>
									<td>${user.inviteCode}</td>
									<td>
									<a href="javascript:;" onclick="setper(3,this.id)" id="${user.subzh}" style="padding-right: 0px;">设置权限</a>
									<em>|</em><a href="javascript:;" onclick="findsubzh(3,this.id)" id="${user.subzh}" style="padding-right: 0px;">修改</a>
									<em>|</em><a href="javascript:;" onclick="resetPass(this.id)" id="${user.subzh}" style="padding-right: 0px;">密码初始化</a>
									<em>|</em><a href="javascript:;" onclick="deleteSubzh(3,this.id)" id="${user.subzh}" style="padding-right: 0px;">删除</a>
									<em>|</em><a href="javascript:;" onclick="seeTheCode('${user.manage}','${user.allocpt}','${user.subzh}','${user.isadmin}')" 
									id="${user.subzh}" style="padding-right: 0px;" class="bta">二维码</a>
									</td>
								</tr>
							</c:forEach>
						</table>
		 				</div>
		 				
		 				<div id="Tindexcode" style="display:none;">
			                 <h3>渠道推广二维码</h3>
			                 <div id="closeboxIcode">
			                      <a href="javascript:void(0);"><img src="${path}/image/close.png" /></a>
			                 </div>
			                <div id="qrcode" style="margin: 30px 85px;"></div>
		 				
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