<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<title></title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" />
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta content="telephone=no" name="format-detection">
    <link href="${path}/css/css.css" rel="stylesheet" type="text/css" />
    <link href="${path}/css/animation.css" rel="stylesheet" type="text/css" />
    <link href="${path}/css/DateTimePicker.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${path}/js/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="${path}/js/DateTimePicker.js"></script>
	<script type="text/javascript" src="${path}/js/layer/layer/layer.js"></script>
	<script type="text/javascript" src="${path}/js/layui/layui.js"></script>
    <script type="text/javascript" src="${path}/js/All.js" ></script>
</head> 
<script type="text/javascript">
var uid= "<%=session.getAttribute("SESSION_ACCOUNTID")%>"; 
var username= "<%=session.getAttribute("SESSION_LOGINNAME")%>"; 
$(document).ready(function() {
	$.post("${path}/subzhfund/getFundInfoList",{"username":username},function(data){
		if(data.code == 0){
			var html ="";
			$.each(data.fundorderlist,function(i,n){
				var cz = n.zjUse;
				var zt = n.status;
				var time = n.modifiedTime;
				var arr = time.split(" ");
				if(cz == 1){
					cz = "<span class=\"blue\">充值</span>";
				}else{
					cz = "<span class=\"blank\">提现</span>";
				}
				if(zt == 0){
					zt = "<span class=\"blank\">审核中</span>";
				}else if(zt == 1){
					zt = "<span class=\"err\">通过</span>";
				}else{
					zt = "<span class=\"true\">未通过</span>";
				}
				html = html + "<tr><td><span>"+arr[0].replace(/\-/g,".")+"</span><span>"+arr[1]+"</span></td>";
				html = html +"<td>"+cz+"</td>";
				html = html +"<td>"+n.fund+"</td><td>"+n.paymentzh+"</td><td>"+zt+"</td></tr>";
			})
			html = "<tr class=\"tit\"><td>时间</td><td>类型</td><td>申请金额</td><td>申请卡号</td><td>状态</td></tr>" + html;
			$("#tabview").html(html);
		}
	})
})
function chaxun(){
	var tj = $("#selecttj option:selected").val();
	if(tj === "0"){
		tj = null;
	}
	$.post("${path}/subzhfund/getFundInfoList",{"username":username,"zjuse":tj},function(data){
		if(data.code == 0){
			var html ="";
			$.each(data.fundorderlist,function(i,n){
				var cz = n.zjUse;
				var zt = n.status;
				var time = n.modifiedTime;
				var arr = time.split(" ");
				if(cz == 1){
					cz = "<span class=\"blue\">充值</span>";
				}else{
					cz = "<span class=\"blank\">提现</span>";
				}
				if(zt == 0){
					zt = "<span class=\"blank\">审核中</span>";
				}else if(zt == 1){
					zt = "<span class=\"err\">通过</span>";
				}else{
					zt = "<span class=\"true\">未通过</span>";
				}
				html = html + "<tr><td><span>"+arr[0].replace(/\-/g,".")+"</span><span>"+arr[1]+"</span></td>";
				html = html +"<td>"+cz+"</td>";
				html = html +"<td>"+n.fund+"</td><td>"+n.paymentzh+"</td><td>"+zt+"</td></tr>";
			})
			html = "<tr class=\"tit\"><td>时间</td><td>类型</td><td>申请金额</td><td>申请卡号</td><td>状态</td></tr>" + html;
			$("#tabview").html(html);
		}
	})
}

</script>
<body class="hgray">
    <div class="category">
    <div class="mainbox">
        <div class="Tslist">
           <div class="Lookb">
              <label>操作类型</label>
              <div class="selectt">
                 <select id="selecttj">
                    <option value="0" selected="selected">请选择</option>
                    <option value="1">充值</option>
                    <option value="2">提现</option>
                 </select>
              </div>
              <button onclick="chaxun()">查询</button>
           </div>
           <table class="tablist" id="tabview" width="100%;">
              <tr class="tit">
                 <td>时间</td>
                 <td>类型</td>
                 <td>申请金额</td>
                 <td>申请卡号</td>
                 <td>状态</td>
              </tr>
              <tr>
                 <td><span>2017.11.12</span><span>14:22:03</span></td>
                 <td><span class="blue">充值</span></td>
                 <td>100000.0</td>
                 <td>622222222222222</td>
                 <td><span class="err">已到帐</span></td>
              </tr>
              <tr>
                 <td><span>2017.11.12</span><span>14:22:03</span></td>
                 <td><span class="blank">提现</span></td>
                 <td>100000.0</td>
                 <td>622222222222222</td>
                 <td><span class="true">审核中</span></td>
              </tr>
           </table>
        </div>
    </div>
  </div>
  <p class="bts">提示：如充值/提现失败请联系客服！</p>      
</body>
</html>