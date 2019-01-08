<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>手续费分成报表</title>
<link rel="stylesheet" type="text/css" href="${path}/css/style.css" />
	<script type="text/javascript" src="${path}/js/jquery-1.11.3.min.js"></script>
	<!-- 引入默认css -->
	<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/icon.css" />
	<script type="text/javascript" src="${path}/js/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="${path}/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${path}/js/easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="${path}/js/My97DatePicker/WdatePicker.js"></script>
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
	serach(1);
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
	
	//查询
	function serach(pageNum) {
		if (pageNum == 0) {
			pageNum = 1;
		}
		var formdate=$("#form1").serializeArray();
		var url="${path}/fundPzlog/selectPageFundSettlelog?pageNum=" + pageNum;
		$("#loadtable").load(url,formdate,function(){ $("#loadtable").fadeIn(100);})
		
		/* var form = document.getElementById("form1");
		form.action = "${path}/fundPzlog/selectPageFundSettlelog?pageNum=" + pageNum;
		form.submit(); */
	}
	
	//导出
	function setExport() {
		var form = document.getElementById("form1");
		form.action = "${path}/fundPzlog/selectExport";
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
			window.location.href = "${path}/fundPzlog/addsubzh";
		} else {
			window.location.href = "${path}/fundPzlog/editsubzh?id=" + id;
		}
	}

	//刷新页面
	function RefreshPage() {
		window.location.href = "${path}/fundPzlog/fundSettlelogList";
	}
	
	function setNext(){//重置
		$("#subzh").val("");
		$("#channel").val("");
		$("#allocagent").val("");
		$("#broker").val("");
		$("#stockCode").val("");
		$("#starttime").val("");
		$("#endtime").val("");
		serach("1");
	}
	
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
					var obj2=document.getElementById("broker");
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
					var obj=document.getElementById("broker");
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
	
</script>
<body>
	<%@include file="../../../head.jsp"%>
	<div class="wrap">
		<%@include file="subzhMaster.jsp"%>
		<div class="Rbox">
            <div class="mainbox">
                 <h3><a href="${path}/fundPzlog/fundSettlelogList" class="on">手续费分成报表</a></h3>
                 <div class="main">
                      <div class="Inputbox">
		                   <form id="form1" method="post" style="float:left;">
		                   	   <p><label>用户账户：</label><input type="text" id="subzh" name="subzh" value="${subzh}" placeholder="请输入用户账户"/>
		                   	   <label>所属渠道：</label>
			                        <select name="channel" id="channel" onchange="getSubDataByQd(this.value)" class="selectyz">
	                           			<option value="">==请选择==</option>
			                         	<c:forEach items="${channelList}" var="channel">
			                         		<option value="${channel.subzh}" <c:if test="${channel eq channel.subzh }">selected</c:if> >${channel.subzh}-${channel.name}</option>
			                         	</c:forEach>
			                        </select>
			                        
	                           </p>
	                           <p>
	                           		<label class="plsearch">所属代理商：</label>
			                        <select name="agentzh" id="allocagent" onchange="getSubDataByDls(this.value)" class="selectyz">
			                         	<option value="">==请选择==</option>
			                         	<c:forEach items="${agentList}" var="agent">
			                         		<option value="${agent.subzh}" <c:if test="${sub.allocagent eq agent.subzh }">selected</c:if> >${agent.subzh}-${agent.name}</option>
			                         	</c:forEach>
			                        </select>
	                           		<label>所属经纪人：</label>
	                           		<select name="broker" id="broker" class="selectyz">
			                         	<option value="">==请选择==</option>
			                         	<c:forEach items="${brokerList}" var="sn">
			                         		<option value="${sn.subzh}" <c:if test="${broker eq sn.subzh }">selected</c:if>>${sn.subzh}-${sn.name}</option>
			                         	</c:forEach>
			                        </select>
	                           </p>
	                           <p style="padding-top:5px;"><label>合约代码：</label><input type="text" id="stockCode" name="stockCode" value="${stockCode}" placeholder="请输入" style="width:150px;"/></p>
	                           <p style="padding-top:5px;">
	                           		<label class="wid">成交时间：</label>
			        				<span><input id="starttime" name="starttime" type="text" class="input_text" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'2018-11-10 11:30:00',maxDate:'%y-%M-%d'})" value="${starttime}" style="width:125px;min-width:125px;margin-left:5px;margin-right:0px;"/>
			        				<span style="margin-top:4px;">&nbsp;&nbsp;至&nbsp;&nbsp;</span>
			        				<input id="endtime" name="endtime" type="text" class="input_text" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'2018-11-10 11:30:00',maxDate:'%y-%M-%d'})" value="${endtime}" style="width:125px;min-width:125px;"/></span>
	                           </p>
                           </form>
	                           <p style="padding-top:5px;">
	                              <button class="cx" onclick="serach('1')">查询</button>
	                              <button class="cz" onclick="setNext()">重置</button>
	                              <button class="cz" onclick="setExport()">导出</button>
	                           </p>
                           <p class="rbutbox">
                           </p>
                      </div>
                    <div class="mtable" id="loadtable">
                           <%-- <table width="100%;">
	                           <tr class="tit">
								<td width="5%">序号</td>
								<td>用户账户</td>
								<td>所属渠道</td>
								<td>所属代理商</td>
								<td>所属经纪人</td>
								<td>合约代码</td>
								<td>合约名称</td>
								<td>方向</td>
								<td>开平</td>
								<td>数量</td>
								<td>成交时间</td>
								<td>手续费总额</td>
								<c:if test="${sessionScope.SESSION_ISADMIN < 4}"><td>渠道存留手续费</td></c:if>
								<c:if test="${sessionScope.SESSION_ISADMIN < 5}"><td>代理商存留手续费</td></c:if>
								<td>经纪人存留手续费</td>
							</tr>
	                      	<c:forEach items="${userlist}" var="user" varStatus="st">
								<tr>
									<td>${st.count}</td>
									<td>${user.subzh}</td>
									<td>${user.allocchannel}</td>
									<td>${user.agentzh}</td>
									<td>${user.allocbroker}</td>
									<td>${user.name}</td>
									<td>${user.settledesc}</td>
									<td>
										<c:choose>
											<c:when test="${user.stockbalance<0.1}">买入</c:when>
											<c:when test="${user.stockbalance>0.9}">卖出</c:when>
										</c:choose>
									</td>
									<td>
										<c:choose>
											<c:when test="${user.registnum==0}">开仓</c:when>
											<c:when test="${user.registnum==1}">平仓</c:when>
											<c:when test="${user.registnum==2}">平今</c:when>
											<c:when test="${user.registnum==3}">平昨</c:when>
										</c:choose>
									</td>
									<td><fmt:formatNumber value="${user.feebalance}" pattern="#" type="number"/></td>
									<td><fmt:formatDate value="${user.createtime}" type="both"/></td>
									<td><fmt:formatNumber value="${user.deferredbalance}" pattern="#.##" type="number"/></td>
									<c:if test="${sessionScope.SESSION_ISADMIN < 4}"><td><fmt:formatNumber value="${user.feenextbalance}" pattern="#.##" type="number"/></td></c:if>
									<c:if test="${sessionScope.SESSION_ISADMIN < 5}"><td><fmt:formatNumber value="${user.addbalance}" pattern="#.##" type="number"/></td></c:if>
									<td><fmt:formatNumber value="${user.overbalance}" pattern="#.##" type="number"/></td>
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
                    </div> --%>
               </div>
          </div>
     </div>
</body>
</html>