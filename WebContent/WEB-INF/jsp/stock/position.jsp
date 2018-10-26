<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="../../../head.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<script type="text/javascript">
var uid= "<%=session.getAttribute("SESSION_ACCOUNTID")%>";
var subzh= "<%=session.getAttribute("SESSION_LOGINNAME")%>";
$(document).ready(function() {
	if (uid == 'null' || uid == '') {
		$("#StockEnquiryul").html('');
	} else {
		getStockEnquiryList();
	}
})	

	//行权
	function execute(index) {
	if (uid == 'null' || uid == '') {
		layer.msg("请登录");
		return;
	}
	layer.confirm('您确认要行权吗？', {
		  btn: ['是','否'] 
		}, function(){
			$.post("${path}/stockoptionDealList/executeStockEnquiry",{"id":index,"subzh":subzh},function(data){
				if(data.code==0){
		 			getStockEnquiryList();	
				}else{
					layer.msg(data.msg);	
				}
			})
		});
	}
	//持仓列表
	function getStockEnquiryList() {
		$("#StockEnquiryul").html('');
		var html='';
		$.post("${path}/stockoptionDealList/getStockEnquiryList",{},function(data){
			if(data !=null && data !=''){
				$.each(data,function(i,n){
					var arr=n.endtime.toString().split(" ");
					var endtime=arr[0].replace(/\-/g,".");
					html=html+"<li><h3><p><span>"+n.buytime+"</span></p>";
					if(n.status==3){
						html=html+"<em onclick='execute("+n.id+")'>行权</em></h3>";
					}else if(n.status==6){
						html=html+"<em style =\"background:#000000;color:#A9A9A9\">行权中</em></h3>";
					}
						html=html+"<table width='100%;' class='Cdtable'><tr><td>"+n.stockname+"<span>("+n.stockcode+")</span></td>"+
						"<td class='tpadd'><span>权利金：</span>"+n.principalfloat+"%</td><td style='text-align:right;'><span>期初价：</span>"+n.freeprice+"</td>"+
						"</tr><tr><td><span>名义本金：</span>"+n.principalbalance+"万</td> <td class='tpadd'><span>周期：</span>"+n.enquirytime;
						if(n.type==1){
							html=html+"天</td></tr>"
						}else if(n.type==2){
							html=html+"周</td></tr>"
						}else if(n.type==3){
							html=html+"月</td></tr>"
						}else if(n.type==4){
							html=html+"年</td></tr>"
						}
						
						html=html+"</table><p class='time'><span>到期时间：</span>"+endtime+"</p></li>"
				})
				$("#StockEnquiryul").html(html);
			}
		})	
	}
</script>
<body class="bggray">
    <div class="category">
    <!-- insder header -->
    <header class="ls-header">
        <div class="ls-header-left">
            <a href="javascript:void(0)" onclick="rgcx()"><i class="iconfont icon-back"></i></a>
        </div>
        <div class="ls-header-title">交易与持仓</div>
        <div class="ls-header-right">
           <a href="javascript:void(0)" onclick="cc()"><i class="iconfont icon-flash"></i></a>
        </div>
    </header>
    <div class="mainbox">
         <section>
             <div class="Tradebox">
                 <ul class="Tnum">
                    <li>总资产：<span>${userinfo.rzj}</span></li>
                    <li>可用资产：<span>${userinfo.xzj + userinfo.bzj}</span></li>
                 </ul>
                 <ul class="Ttab">
                     <li><a href="javascript:;" onclick="rg()">询价</a></li>
                     <li><a href="javascript:;" onclick="rgcx()">认购</a></li>
                     <li><a href="javascript:;" class="on" onclick="cc()">持仓</a></li>
                     <li><a href="javascript:;" onclick="js()">查询</a></li>
                 </ul>
                 <ul class="Cdbox" id="StockEnquiryul">
                     
                 </ul>
             </div>
        </section> 
        <div class="homebottom">
         <ul>
              <li class="nav01" onclick="hangqing()">
                  <a href="javascript:;" >
                      <i></i>
                      <span >行情</span>
                  </a>
              </li>
              <li class="nav12" onclick="trader()">
                  <a href="javascript:;" class="on" >
                      <i></i>
                      <span >交易</span>
                  </a>
              </li>
              <li class="nav03" onclick="zjmx()">
                  <a href="javascript:;" >
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
                  <a href="javascript:;">
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