<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<script type="text/javascript" src="${path}/js/layer/layer.js"></script>
	<style type="text/css">
		.headdiv a{
			border:3px solid #000;
			width: 65px;
    		height: 30px;
		}
		.headdiv .ona{
    		background: #74eada;
		}
		p select.selectyz{
			    width: 160px;
			    line-height: 30px;
			    height: 30px;
			    padding: 0 5px;
			    background: none;
			    border: 1px solid #efe7e7;
		}
		p label.plsearch{
			width:98px;
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
		#Tindex{width:480px;background: #fff;z-index: 11;display: none; border:1px solid #267ed8;font-size:14px; }
		#Tindex h3{height:34px;line-height:34px;color:#267ed8;font-size:18px;padding-left:20px;}		  
		#closeboxI{position:absolute;right:10px;top:5px;}
		#closeboxI a{ display:block;}
	</style>
</head>
<script type="text/javascript">
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
			$("#Tindex").center();
			//弹窗、遮罩显示/隐藏
			$('.bta').click(function(){
				$('#Tindex').fadeIn();
			});
			$('#closeboxI').click(function(){
				$('#Tindex').fadeOut();
			});
			
			
	});
	
	//当渠道下拉框变动时，重新加载代理商和经纪人
	function getSubDataByQd(qd){
		//当页面加载完后去加载下拉框中的数据
		$.ajax({
			url : "${path}/fund/querySubData",
			type : "post",
			data : {
				"allocchannel" : qd,
				"isadmin" : 4,
				"flag" : 2
			},
			traditional : true,
			dataType : "json",
			success : function(data) {
				if(data.status==1){
					var list=data.list;
					var obj=document.getElementById("allocagent");
					obj.options.length=0;
					obj.options.add(new Option("==请选择==",""));
					for(var i=0;i<list.length;i++){
						obj.options.add(new Option(list[i].subzh+"-"+list[i].name,list[i].subzh));
						/* if(i==0){
							obj.options[0].selected = true;
						} */
					}
					var rhlist=data.list2;
					var obj2=document.getElementById("allocbroker");
					obj2.options.length=0;
					obj2.options.add(new Option("==请选择==",""));
					for(var i=0;i<rhlist.length;i++){
						obj2.options.add(new Option(rhlist[i].subzh+"-"+rhlist[i].name,rhlist[i].subzh));
						/* if(i==0){
							obj2.options[0].selected = true;
						} */
					}
					
				}else{
					$.messager.alert('提示',data.describe, 'info');
				}
			}

		});
	}
	
	//当代理商变动后，重新加载经纪人
	function getSubDataByDls(dls){
		//当页面加载完后去加载下拉框中的数据
		$.ajax({
			url : "${path}/fund/querySubData",
			type : "post",
			data : {
				"allocagent" : dls,
				"isadmin" : 5,
				"flag" : 1
			},
			traditional : true,
			dataType : "json",
			success : function(data) {
				if(data.status==1){
					var rhlist=data.list;
					var obj=document.getElementById("allocbroker");
					obj.options.length=0;
					obj.options.add(new Option("==请选择==",""));
					for(var i=0;i<rhlist.length;i++){
						obj.options.add(new Option(rhlist[i].subzh+"-"+rhlist[i].name,rhlist[i].subzh));
						/* if(i==0){
							obj.options[0].selected = true;
						} */
					}
				}else{
					$.messager.alert('提示',data.describe, 'info');
				}
			}

		});
	}
	
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

	//删除
	function deleteSubzh(isadmin,id) {
		$.messager.confirm('提示', '是否确定删除此交易用户?', function(yn) {
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
							$.messager.alert('提示!', '成功删除此交易用户!', 'info',
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
	
	//切换
	function change(isadmin){
		window.location.href="${path}/fund/subzhList?isadmin="+isadmin;
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
		form.action = "${path}/fund/subzhList?pageNum=" + pageNum+"&isadmin=6";
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
		window.location.href = "${path}/fund/subzhList?isadmin=6";
	}
	
	function setNext(){//重置
		$("#subzh").val("");
		//allocchannel,allocagent,allocbroker,bdtd,subzh
		document.getElementById("allocchannel").options[0].selected = true;
		document.getElementById("allocagent").options[0].selected = true;
		document.getElementById("allocbroker").options[0].selected = true;
		document.getElementById("bdtd").options[0].selected = true;
		
	}
	
	function addsubzhMore() {//批量生成
		window.location.href = "${path}/fund/addsubzhMore";
	}
	
	function addsubzhImport() {//导入
		window.location.href = "${path}/fund/addsubzhImport";
	}
	
	//取消设置权限
	function giveup(){
		$('#Tindex').fadeOut();
	}
	
	//显示交易用户权限市里并设置已有的
	function setJymarket(subzh,jypzs){
		$("#getJymarket").val(subzh);
		var arr=jypzs.split(",");
		var hjypz =$("input[name='jypz']");//获取下拉交易品种数据
		for(var i=0;i<hjypz.length;i++){
			hjypz[i].checked=false;
		}
		for(var i=0;i<hjypz.length;i++){
			for (var j = 0; j < arr.length; j++) {
				 if(arr[j]==hjypz[i].value){
					 hjypz[i].checked="checked";
					 break;
				 }
			}
		} 
	}
	//保存交易用户的新市场
	function changeMarket(){
		var subzh=$("#getJymarket").val();
		var sjypz =$("input[name='jypz']:checked");
		var jypz="";
		for(var i=0;i<sjypz.length;i++){
			 jypz+=sjypz[i].value+",";
		}
		if($.trim(jypz).length>0){
			jypz=jypz.substring(0,jypz.length-1);
			$.ajax({
				url : "${path}/fund/updateMarket",
				type : "post",
				data : {
					"subzh" : subzh,
					"jypz" : jypz
				},
				traditional : true,
				dataType : "text",
				success : function(data) {
					if (data == "true") {
						$.messager.alert("提示!", '设置成功!', 'info');
						RefreshPage();
					}
					if (data == "false") {
						$.messager.alert("提示!", '账号启用失败!', 'error');
					}
				}

			});
		}else{
			$.messager.alert("提示!", '至少选择一个市场!');
		}
	}
	
	//监听浏览器大小发生变化，让layui的弹框自适应
	 $(window).on("resize",function(){ 
	 		if(layui.layer && layui.layer!="undefined"){
	 			layui.layer.full(index);
	 		}
	 	    
	  });
	
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
</script>
<body>
	<%@include file="../../../head.jsp"%>
	<div class="wrap">
		<%@include file="subzhMaster.jsp"%>
		<div class="Rbox">
            <div class="mainbox">
                 <%--  <h3><a href="${path}/main/querybdzh" class="on">主账户列表</a>/
                 <a href="javascript:void(0)" class="on">子账户列表</a>
                    <c:if test="${sessionScope.SESSION_LOGINNAME == '1272'}">
                    	/<a href="${path}/fund/toAddMenu?isadmin=4" class="on">增加权限菜单</a>	
                    </c:if>
                 </h3> --%>
                 <ul>
		            <c:if test="${sessionScope.SESSION_ISADMIN lt 3 }"><li onclick="change(3)" id="fundlable">渠道账户</li></c:if>
		            <c:if test="${sessionScope.SESSION_ISADMIN lt 4 }"><li onclick="change(4)" id="holdlable">代理商</li></c:if>
		            <c:if test="${sessionScope.SESSION_ISADMIN lt 5 }"><li onclick="change(5)" id="entrustlable">经纪人账户</li></c:if>
		            <c:if test="${sessionScope.SESSION_ISADMIN lt 6 }"><li class="selectchx" onclick="change(6)" id="deallable">交易用户</li></c:if>
		        	</ul>
                 <div class="main">
                 	<%-- <div style="height:50px;" class="headdiv">
	                 	<c:if test="${sessionScope.SESSION_ISADMIN eq 1 }"><a href="${path}/fund/subzhList?isadmin=2">渠道账户</a></c:if>
	                 	<c:if test="${sessionScope.SESSION_ISADMIN lt 3 }"><a href="${path}/fund/subzhList?isadmin=3">经纪人账户</a></c:if>
	                 	<a href="${path}/fund/subzhList?isadmin=4" class="ona">交易用户</a>
	                 </div> --%>
                      <div class="Inputbox">
		                   <form id="form1" method="post" style="float:left;">
	                           <p>
	                           		<label class="plsearch">渠道编号：</label>
	                           		<select name="allocchannel" id="allocchannel" onchange="getSubDataByQd(this.value)" class="selectyz">
	                           			<option value="">==请选择==</option>
			                         	<c:forEach items="${channelList}" var="channel">
			                         		<option value="${channel.subzh}" <c:if test="${sub.allocchannel eq channel.subzh }">selected</c:if> >${channel.subzh}-${channel.name}</option>
			                         	</c:forEach>
			                        </select>
			                        <label class="plsearch">代理商编号：</label>
			                        <select name="allocagent" id="allocagent" onchange="getSubDataByDls(this.value)" class="selectyz">
			                         	<option value="">==请选择==</option>
			                         	<c:forEach items="${agentList}" var="agent">
			                         		<option value="${agent.subzh}" <c:if test="${sub.allocagent eq agent.subzh }">selected</c:if> >${agent.subzh}-${agent.name}</option>
			                         	</c:forEach>
			                        </select>
	                           </p>
	                           <p style="margin-top:10px;">
	                           		<label class="plsearch">经纪人编号：</label>
	                           		<select name="allocbroker" id="allocbroker" class="selectyz">
			                         	<option value="">==请选择==</option>
			                         	<c:forEach items="${brokerList}" var="sn">
			                         		<option value="${sn.subzh}" <c:if test="${sub.allocbroker eq sn.subzh }">selected</c:if>>${sn.subzh}-${sn.name}</option>
			                         	</c:forEach>
			                        </select>
			                      <label class="plsearch">认证状态：</label>
			                        <select name="authState" id="authState" class="selectyz">
			                         	<option value="">==请选择==</option>
			                         	<option value="0" <c:if test="${sub.authState eq 0 }">selected</c:if>>未认证</option>
			                         	<option value="1" <c:if test="${sub.authState eq 1 }">selected</c:if>>审核中</option>
			                         	<option value="2" <c:if test="${sub.authState eq 2 }">selected</c:if>>已认证</option>
			                         	<option value="3" <c:if test="${sub.authState eq 3 }">selected</c:if>>未通过</option>
			                        </select>
	                           </p>
	                           <p style="margin-top:10px;width:98%;">
	                           		<label class="plsearch">用户账户：</label><input type="text" id="subzh" name="subzh" value="${sub.subzh}" placeholder="请输入用户编号"/>
	                           		<%-- <label class="plsearch" style="margin-left:30px;">用户名称：</label>
	                           		<input type="text" id="name" name="name" value="${param.name}" placeholder="请输入用户名称"/> --%>
	                           		<button class="cx" onclick="serach('1')" style="margin-left:30px;">查询</button>
	                              	<button class="cz" onclick="setNext()">重置</button>
	                           </p>
	                           
                           </form>
                           <p>
                           <button class="cx xbuild" onclick="findsubzh(6,'');" style="margin-top:10px;width:130px;">新增交易账户</button>                         
                           </p>
                      </div>
                    <div class="mtable">
                           <table width="100%;">
	                           <tr class="tit">
	                          	<!-- <td width="10px"><input type="checkbox" onclick="checkAll()" /></td> -->
								<td width="5%">序号</td>
								<td>账号</td>
								<td>姓名</td>
								<td>认证状态</td>
								<td>所属渠道</td>
								<td>所属代理商</td>
								<td>所属经纪人</td>
								<!-- <td>关联报单账户</td> -->
								<td>手续费方案</td>
								<td>风控方案</td>
								<td>保证金方案</td>
								<td>注册时间</td>
								<td width="6%">状态</td>
								<td width="10%">操作</td>
							</tr>
	                      	<c:forEach items="${userlist}" var="user" varStatus="st">
	                      		<tr>
									<%-- <td width="10px"><input type="checkbox" value="${user.subzh}" /></td> --%>
									<td>${st.count}</td>
									<td>${user.subzh}</td>
									<td>
									<c:if test="${user.authState eq '2'}" >
										${user.name}
									</c:if>
									</td>
									<td>
										<c:if test="${empty user.authState or user.authState eq '0'}"><span style="color:#666666">未认证</span></c:if>
										<c:if test="${user.authState eq '1'}"><a href="javascript:void(0);" onclick="showAuth('${user.subzh}')" style="padding-right: 0px;color:#FF00FF">审核中</a></c:if>
										<c:if test="${user.authState eq '2'}"><a href="javascript:void(0);" onclick="showAuth('${user.subzh}')" style="padding-right: 0px;color:#00AA00">已认证</a></c:if>
										<c:if test="${user.authState eq '3'}"><a href="javascript:void(0);" onclick="showAuth('${user.subzh}')" style="padding-right: 0px;color:#FF5511">未通过</a></c:if>
									</td>
									<td>${user.channelname}</td>
									<td>${user.agentname}</td>
									<td>${user.brokername}</td>
									<%-- <td>${user.bdtdName}</td> --%>
									<td>${user.feeName}</td>
									<td>${user.riskName}</td>
									<td>${user.marginName}</td> 
									<td><fmt:formatDate value="${user.khdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
									<td>
										<c:if test="${user.zhstate eq 1}">
											正常（可交易）
										</c:if>
										<c:if test="${empty user.zhstate or user.zhstate eq 0}">
											未激活
										</c:if>
									</td>
									<td>
									<a href="javascript:;" onclick="findsubzh(6,this.id)" id="${user.subzh}" style="padding-right: 0px;">编辑</a>
									<em>|</em><a href="javascript:;" onclick="deleteSubzh(6,this.id)" id="${user.subzh}" style="padding-right: 0px;">删除</a>
									</td>
								</tr>
							</c:forEach>
						</table>
		 				</div>
		 				
		 				<%-- <div id="Tindex" style="display:none;">
			                 <h3>交易权限设置</h3>
			                 <div id="closeboxI">
			                      <a href="javascript:void(0);"><img src="${path}/image/close.png" /></a>
			                 </div>
			                 <form action="">
			                 		<div style="margin-left:60px;margin-top:10px;">
			                 			<input type="checkbox" name="jypz" value="3" style="width:20px;height:20px;"/>中金所
			                 		</div>
							        <div style="margin-left:60px;margin-top:10px;">
							        	<input type="checkbox" name="jypz" value="4" style="width:20px;height:20px;"/>上期所
							        </div>
							        <div style="margin-left:60px;margin-top:10px;">
							        	<input type="checkbox" name="jypz" value="6" style="width:20px;height:20px;"/>郑商所
							        </div>
							        <div style="margin-left:60px;margin-top:10px;">
							        	<input type="checkbox" name="jypz" value="5" style="width:20px;height:20px;"/>大商所
							        </div>
							        <div style="margin-left:60px;margin-top:10px;">
							        	<input type="checkbox" name="jypz" value="24" style="width:20px;height:20px;"/>上海能源
							        </div>
							        <input type="hidden" id="getJymarket" value="" />
							        <div style="margin-top:10px;margin-bottom:20px;">
							       		<input type="button" class="cx" onclick="changeMarket()" style="margin-left:100px;width:60px;height:30px;background:#108ee9;" value="确定">
	                              		<input type="button" class="cz" onclick="giveup()" style="width:60px;height:30px;background:#108ee9;" value="取消">
							       </div>
			                 </form>
		 				
		 				</div> --%>
		 				
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