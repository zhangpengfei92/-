<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="../../../head.jsp"%>
<head>
	<meta charset="utf-8">
	<title></title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" />
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta content="telephone=no" name="format-detection">
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
				html = html +"<td>"+n.fund+"</td><td>"+n.ckBank+"</td><td>"+zt+"</td></tr>";
			})
			html = "<tr class=\"tit\"><td>时间</td><td>类型</td><td>申请金额</td><td>订单号</td><td>状态</td></tr>" + html;
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
    <!-- insder header -->
    <header class="ls-header">
        <div class="ls-header-left">
            <a href="javascript:void(0)" onclick="zjmx()"><i class="iconfont icon-back"></i></a>
        </div>
        <div class="ls-header-title">充值提现记录</div>
    </header>
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
                 <td style="width: 30%">申请卡号</td>
                 <td>状态</td>
              </tr>
           </table>
        </div>
    </div>
  <div class="homebottom">
         <ul>
              <li class="nav01" onclick="hangqing()">
                  <a href="javascript:;" >
                      <i></i>
                      <span >行情</span>
                  </a>
              </li>
              <li class="nav02" onclick="trader()">
                  <a href="javascript:;"  >
                      <i></i>
                      <span >交易</span>
                  </a>
              </li>
              <li class="nav13" onclick="zjmx()">
                  <a href="javascript:;" class="on">
                      <i></i>
                      <span >资金</span>
                  </a>
              </li>
              <li class="nav04" onclick="helpCenter()">
                  <a href="javascript:;" >
                      <i></i>
                      <span >帮助</span>
                  </a>
              </li>
              <li class="nav05" onclick="personal()">
                  <a href="javascript:;" >
                      <i></i>
                      <span>我的</span>
                  </a>
              </li>
         </ul>
    </div>
    <%@include file="../../../foot.jsp"%>
  </div>
      
</body>
</html>