<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>实时数据</title>
	<link rel="stylesheet" type="text/css" href="${path}/css/style.css" />
	<script type="text/javascript" src="${path}/js/jquery-1.11.3.min.js"></script>
	<!-- 引入默认css -->
	<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/icon.css" />
	<script type="text/javascript" src="${path}/js/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="${path}/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${path}/js/easyui/locale/easyui-lang-zh_CN.js"></script>
	<!--easyui  -->
	<link href="${path}/layui/css/layui.css" rel="stylesheet"type="text/css" />
	<link href="${path}/layui/css/main.css" rel="stylesheet" type="text/css" />
	<script src="${path}/layui/layui.js" type="text/javascript"></script>
	<link rel="stylesheet" href="${path}/css/select2.min.css">
    <!-- <script src="jquery-3.2.1.min.js"></script> -->
    <script src="${path}/js/select2.full.min.js"></script>
	<style type="text/css">
		p select.selectyz{
			    width: 162px;
			    line-height: 30px;
			    height: 30px;
			    padding: 0 5px;
			    background: none;
			    border: 1px solid #efe7e7;
		}
		
		p label.wid{
			width:85px;
			height: 30px;
			margin-left:10px;
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
	</style>
</head>
<script type="text/javascript">
//条件查询和分页
$(function(){
	var flag=$("#tabtype").val();
	searchQuery(1);
});

function serach(pageNum) {
	if (pageNum == 0) {
		pageNum = 1;
	}
	$("#pagenum").val(pageNum);
	var flag=$("#tabtype").val();
	searchQuery(flag);
} 


function searchQuery(flag){
	 var array = new Array();  //定义数组 
     $("#subzh option").each(function(){  //遍历所有option
          var txt = $(this).val();   //获取option值 
          if(txt!=''){
               array.push(txt);  //添加到数组中
          }
     })
	$("#subzhs").val(array);
	var formdate=$("#frm").serializeArray();
	var url="${path}/trade/getFund";
	if(flag==2){
		$("#seachspan").show();//显示div
		url="${path}/trade/getDrHolder";
	}else if(flag==3){
		$("#seachspan").show();//显示div
		url="${path}/trade/getDrEntrust";
	}else if(flag==4){
		$("#seachspan").show();//显示div
		url="${path}/trade/getDrDealcj";
	}else if(flag==1){
		$("#seachspan").hide();//显示div
	}
	
	$("#loadtable").load(url,formdate,function(){ $("#loadtable").fadeIn(100);})
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




//切换tab类型
function change(flag,id){
	
	if($("#tabtype").val()==flag){
		
	}else{
		$(".mainbox ul li").removeClass("selectchx");
		$("#"+id).addClass("selectchx");
		$("#tabtype").val(flag);//设置类型
		$("#pagenum").val(1);
		searchQuery(flag);
	}
	
}
	//如果渠道变成请选择了。那就会加载所有的代理，经纪人，交易用户
	function getAllSubData(){
		//当页面加载完后去加载下拉框中的数据;flag=3表示 在渠道变动后，改变它下面的代理商，经纪人和交易用户
		$.ajax({
			url : "${path}/fund/queryAgentJjrSubList",
			type : "post",
			data : {},
			traditional : true,
			dataType : "json",
			success : function(data) {
				if(data.status==1){
					var list=data.agentList;
					var obj=document.getElementById("agentzh");
					obj.options.length=0;
					obj.options.add(new Option("==请选择==",""));
					for(var i=0;i<list.length;i++){
						obj.options.add(new Option(list[i].name,list[i].subzh));
						
					}
					var rhlist=data.brokerList;
					var obj2=document.getElementById("broker");
					obj2.options.length=0;
					obj2.options.add(new Option("==请选择==",""));
					for(var i=0;i<rhlist.length;i++){
						obj2.options.add(new Option(rhlist[i].name,rhlist[i].subzh));
					}
					
					var jylist=data.sublist;
					var obj3=document.getElementById("subzh");
					obj3.options.length=0;
					obj3.options.add(new Option("==请选择==",""));
					for(var i=0;i<jylist.length;i++){
						obj3.options.add(new Option(jylist[i].subzh,jylist[i].subzh));
					}
					
				}else{
					$.messager.alert('提示',data.describe, 'info');
				}
			}

		});
	}

	//当渠道下拉框变动时，重新加载代理商和经纪人
	function getSubDataByQd(qd,flag){
		if(!qd || qd.length==0){
			getAllSubData();
			return ;
		}
		//当页面加载完后去加载下拉框中的数据;flag=3表示 在渠道变动后，改变它下面的代理商，经纪人和交易用户
		$.ajax({
			url : "${path}/fund/querySubData",
			type : "post",
			data : {
				"allocchannel" : qd,
				"isadmin" : 4,
				"flag" : 3
			},
			traditional : true,
			dataType : "json",
			success : function(data) {
				if(data.status==1){
					var list=data.list;
					var obj=document.getElementById("agentzh");
					obj.options.length=0;
					obj.options.add(new Option("==请选择==",""));
					for(var i=0;i<list.length;i++){
						obj.options.add(new Option(list[i].name,list[i].subzh));
						/* 代理商下拉框可以多加属性（含渠道信息）var myOption1=document.createElement("option");
						myOption1.setAttribute("value",list[i].subzh);
						myOption1.appendChild(document.createTextNode(list[i].name));
						myOption1.setAttribute("id","dls"+list[i].subzh+"-"+qd);
						obj.appendChild(myOption)  */
					}
					var rhlist=data.list2;
					var obj2=document.getElementById("broker");
					obj2.options.length=0;
					obj2.options.add(new Option("==请选择==",""));
					for(var i=0;i<rhlist.length;i++){
						obj2.options.add(new Option(rhlist[i].name,rhlist[i].subzh));
					}
					
					var jylist=data.list3;
					var obj3=document.getElementById("subzh");
					obj3.options.length=0;
					obj3.options.add(new Option("==请选择==",""));
					for(var i=0;i<jylist.length;i++){
						obj3.options.add(new Option(jylist[i].subzh,jylist[i].subzh));
					}
					
				}else{
					$.messager.alert('提示',data.describe, 'info');
				}
			}

		});
	}
	
	//当代理商变动后，重新加载经纪人和交易用户
	function getSubDataByDls(dls,flag){
		if((!dls || dls.length==0)){
			var channel=document.getElementById("channel").value;
			getSubDataByQd(channel,1);
			return ;
		}
		//当页面加载完后去加载下拉框中的数据
		$.ajax({
			url : "${path}/fund/querySubData",
			type : "post",
			data : {
				"allocagent" : dls,
				"isadmin" : 5,
				"flag" : 2
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
						obj.options.add(new Option(rhlist[i].name,rhlist[i].subzh));
					}
					
					var jylist=data.list2;
					var obj3=document.getElementById("subzh");
					obj3.options.length=0;
					obj3.options.add(new Option("==请选择==",""));
					for(var i=0;i<jylist.length;i++){
						obj3.options.add(new Option(jylist[i].subzh,jylist[i].subzh));
					}
				}else{
					$.messager.alert('提示',data.describe, 'info');
				}
			}

		});
	}

	//当经纪人变动后，重新加载交易用户
	function getJySub(jjr){
		if(!jjr || jjr.length==0){
			var dls=document.getElementById("agentzh").value;
			getSubDataByDls(dls,1);
			return ;
		}
		//当页面加载完后去加载下拉框中的数据
		$.ajax({
			url : "${path}/fund/querySubData",
			type : "post",
			data : {
				"allocbroker" : jjr,
				"isadmin" : 6,
				"flag" : 1
			},
			traditional : true,
			dataType : "json",
			success : function(data) {
				if(data.status==1){
					var jylist=data.list;
					var obj3=document.getElementById("subzh");
					obj3.options.length=0;
					obj3.options.add(new Option("==请选择==",""));
					for(var i=0;i<jylist.length;i++){
						obj3.options.add(new Option(jylist[i].subzh,jylist[i].subzh));
					}
				}else{
					$.messager.alert('提示',data.describe, 'info');
				}
			}

		});
	}
	$(function(){
        $('.mySelect').select2();
    })
</script>
<body>
	<%@include file="../../../head.jsp"%>
		<div class="wrap">
		<%@include file="subzhMaster.jsp"%>
		<div class="Rbox">
            <div class="mainbox">
                 <ul>
		            <li class="selectchx" onclick="change(1,'fundlable')" id="fundlable">资金</li>
		            <li onclick="change(2,'holdlable')" id="holdlable">持仓</li>
		            <li onclick="change(3,'entrustlable')" id="entrustlable">委托</li>
		            <li onclick="change(4,'deallable')" id="deallable">成交</li>
		        </ul>
                 <div class="main">
                      <div class="Inputbox">
                      		 <form id="frm" method="post" style="float:left;">
	                           <p>
	                           	<%-- <label class="wid">用户账户：</label><input type="text" id="subzh" name="subzh" value="${subzh}" placeholder="请输入" style="width:150px;"/> --%>
	                           	<c:if test="${isadmin lt 3 }"  >
	                           		<label class="wid">所属渠道：</label>
	                           		<select name="channel" id="channel" onchange="getSubDataByQd(this.value,0)" class="selectyz"><!-- class="easyui-combobox" style="width:162px;height: 30px" -->
	                           			<c:if test="${isadmin lt 3 }"  ><option value="">==请选择==</option></c:if>
			                         	<c:forEach items="${channelList}" var="qd">
			                         		<option value="${qd.subzh}" >${qd.name}</option>
			                         	</c:forEach>
			                        </select>
			                    </c:if>
			                    <c:if test="${isadmin lt 4 }"  >
				                    <label class="wid">所属代理商：</label>
		                           	<select name="agentzh" id="agentzh" onchange="getSubDataByDls(this.value,0)" class="selectyz">
				                         	<c:if test="${isadmin lt 4 }"  ><option value="">==请选择==</option></c:if>
				                         	<c:forEach items="${agentList}" var="dls">
				                         		<option value="${dls.subzh}" <c:if test="${broker eq dls.subzh }">selected</c:if> >${dls.name}</option>
				                         	</c:forEach>
				                     </select>
			                     </c:if>
	                           	<label class="wid">所属经纪人：</label>
	                           	<select name="broker" id="broker" class="selectyz" onchange="getJySub(this.value)">
	                           			<c:if test="${isadmin lt 5 }"  ><option value="">==请选择==</option></c:if>
			                         	<c:forEach items="${brokerList}" var="jjr">
			                         		<option value="${jjr.subzh}" <c:if test="${broker eq jjr.subzh }">selected</c:if> >${jjr.name}</option>
			                         	</c:forEach>
			                     </select>
			                     <label class="wid">交易用户：</label>
			                     <select name="subzh" id="subzh" class="mySelect" style="width: 162px;height: 30px"> <!-- class="selectyz" -->
			                     <option value="">==请选择==</option>
			                         	<c:forEach items="${jyList}" var="jysub">
			                         		<option value="${jysub.subzh}" <c:if test="${subzh eq jysub.subzh }">selected</c:if> >${jysub.subzh}</option>
			                         	</c:forEach>
			                     </select>
	                           </p>
	                           <div >  
	                           <p>
	                           <span id="seachspan" style="display: none;">
	                           	<label class="wid" id='' >合约代码：</label><input type="text" id="stockCode" name="stockCode" value="${stockCode}" placeholder="请输入" class="easyui-validatebox" style="width:150px;height: 28px"/>
	                           	<label class="wid">合约名称：</label><input type="text" id="stockName" name="stockName" value="${stockName}" placeholder="请输入" class="easyui-validatebox" style="width:150px;height: 28px"/>
	                            </span>
	                              <input type="button" class="cx" onclick="serach('1')" value="查询" style="background: #49a9ee;color:#fff;width:80px;" />
	                           </p>
	                           </div>
	                           <input type="hidden" name="jg" value="${sessionScope.SESSION_AGENTZHGL }" id="jg"/>
	                           <input type="hidden" name="pt" value="${sessionScope.SESSION_PLATEFORM }" id="pt"/>
	                           
	                           <input type="hidden" name="type" value="1" id="tabtype"/>
	                           <input type="hidden" name="pageNum" value="1" id="pagenum"/>
	                           <input type="hidden" name="subzhs" value="1" id="subzhs"/>
                           </form>
                      </div> 
                    	<div id="loadtable"></div>
                    </div>
               </div>
    		</div>  
    	</div>
	</div>

</body>
</html>