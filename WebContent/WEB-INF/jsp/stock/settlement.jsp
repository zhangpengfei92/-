<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="../../../head.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<script type="text/javascript">
$(document).ready(function() {
	var uid= "<%=session.getAttribute("SESSION_ACCOUNTID")%>";
	if (uid == 'null' || uid == '') {
		$("#StockEnquiryul").html('');
	} else {
		getSetStockEnquiryList();
	}
})	
	function getSetStockEnquiryList() {
	var star=$("#start").val();
	var end=$("#end").val();
	$("#StockEnquiryul").html('');
	var html='';
	$.post("${path}/stockoptionDealList/getSetStockEnquiryList",{"start":star,"end":end},function(data){
		if(data !=null && data !=''){
			$.each(data,function(i,n){
				var arr=n.buytime.toString().split(" ");
				var endtime=arr[0].replace(/\-/g,".");
				var enquirytime = n.enquirytime;
				var profit=n.profit;
				var settleprice=n.settleprice;
				if(n.type==1){
					enquirytime = enquirytime+"天"
				}else if(n.type==2){
					enquirytime = enquirytime+"周"
				}else if(n.type==3){
					enquirytime = enquirytime+"个月"
				}else if(n.type==4){
					enquirytime = enquirytime+"年"
				}
				html=html+"<li> <h3><p><span>"+n.starttime+"</span></p>";
				if(n.status==4){
					html=html+"<em style =\"background:#000000;color:#00FF00\">行权成功</em></h3>";
					
				}else if(n.status==5){
					html=html+"<em style =\"background:#000000;color:#de3f2a\">放弃行权</em></h3>";
					profit="--";
					settleprice="--";
				}else if(n.status==6){
					html=html+"<em style =\"background:#000000;color:#A9A9A9\">行权中</em></h3>";
					profit="--";
					settleprice="--";
				}
					html=html+"</h3><table width='100%;' class='Cdtable'> <tr> <td colspan='2'>"+
					"<span>行权时间：</span>"+endtime+"</td><td><span>周期：</span>"+enquirytime+"</td></tr>"+
					"<tr><td>"+n.stockname+"<span>("+n.stockcode+")</span></td><td class='tpadd'><span>权利金：</span>"+n.principalfloat+"%</td>"+
					" <td><span>期初价：</span>"+n.freeprice+"</td></tr><tr><td><span>名义本金：</span>"+n.principalbalance+"万</td>"+
					"<td class='tpadd'><span>盈亏：</span><span class='red'>"+profit+"</span></td>"+
					"<td><span>行权价：</span>"+settleprice+"</td></tr></table> </li>"
				})	
			}
		$("#StockEnquiryul").html(html);
		})	
	}
	
	function sureConfig() {
		var star=$("#start").val();
		var end=$("#end").val();
		if(star !='' && end !=''){
			 var starDate=new Date(star.replace(/-/g,"/"));
		     var endDate=new Date(end.replace(/-/g,"/"));
		     if(starDate-endDate>0){
		         layer.msg("开始日期要在截止日期之前!");  
		         return false;
		      }	
		}
		getSetStockEnquiryList();
	}
</script>
<body class="bggray">
    <div class="category">
    <!-- insder header -->
    <header class="ls-header">
        <div class="ls-header-left">
            <a href="javascript:void(0)" onclick="js()"><i class="iconfont icon-back"></i></a>
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
           </div>
           <div class="Tradebox">
                <ul class="Ttab">
                     <li><a href="javascript:;" onclick="rg()">询价</a></li>
                     <li><a href="javascript:;" onclick="rgcx()">认购</a></li>
                     <li><a href="javascript:;" onclick="cc()">持仓</a></li>
                     <li><a href="javascript:;" class="on" onclick="js()">查询</a></li>
                 </ul>
           </div>
           <div class="Cjbox">
                <ul>
                    <li>
                         <div class="rl">
                              <label>行权日期</label>
                              <input type="text" data-field="date" data-format="yyyy-MM-dd" readonly id="start">
                              <span>-</span>
                              <input type="text" data-field="date" data-format="yyyy-MM-dd" readonly id="end">
                              <i class="cbut" onclick="sureConfig()">确定</i>
                         </div>
                        <div id="dtBox"></div>
                        <script type="text/javascript">
                        
                            $(document).ready(function()
                            {
                                $("#dtBox").DateTimePicker({
                                
                                    dateFormat: "MM-dd-yyyy",
                                    timeFormat: "HH:mm",
                                    dateTimeFormat: "MM-dd-yyyy HH:mm:ss AA"
                                });
                            });
                        
                        </script>
                      </li>
                  </ul>
                  <div class="Tradebox">
                      <ul class="Cdbox" id="StockEnquiryul">
                         
                         <li>
                            <h3><p><span>2015.07.03</span><span>13:48:39</span></p></h3>
                            <table width="100%;" class="Cdtable">
                               <tr>
                                  <td colspan="2"><span>行权时间：</span>2015.07.06</td>
                                  <td><span>周期：</span>3个月</td>
                               </tr>
                               <tr>
                                  <td>武钢股份<span>(600005)</span></td>
                                  <td class="tpadd"><span>权利金：</span>10.3%</td>
                                  <td><span>期初价：</span>(10周)</td>
                               </tr>
                               <tr>
                                  <td><span>名义本金：</span>20万</td>
                                  <td class="tpadd"><span>盈亏：</span><span class="red">656.86</span></td>
                                  <td><span>行权价：</span>18.1</td>
                               </tr>
                            </table>
                         </li>
                         <li>
                            <h3><p><span>2015.07.03</span><span>13:48:39</span></p></h3>
                            <table width="100%;" class="Cdtable">
                               <tr>
                                  <td colspan="2"><span>行权时间：</span>2015.07.06</td>
                                  <td><span>周期：</span>3个月</td>
                               </tr>
                               <tr>
                                  <td>武钢股份<span>(600005)</span></td>
                                  <td class="tpadd"><span>权利金：</span>10.3%</td>
                                  <td><span>期初价：</span>(10周)</td>
                               </tr>
                               <tr>
                                  <td><span>名义本金：</span>20万</td>
                                  <td class="tpadd"><span>盈亏：</span><span class="red">656.86</span></td>
                                  <td><span>行权价：</span>18.1</td>
                               </tr>
                            </table>
                         </li>
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