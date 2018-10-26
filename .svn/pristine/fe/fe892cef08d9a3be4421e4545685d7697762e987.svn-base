<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="../../../head.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${path}/js/stockjs/css.css" />
<link rel="stylesheet" type="text/css" href="${path}/js/stockjs/jquery.autocomplete.css"/>
<script type="text/javascript" src="${path}/js/stockjs/main.js"></script>
<script type="text/javascript" src="${path}/js/stockjs/jquery.example.js"></script>
<script type='text/javascript' src='${path}/js/stockjs/jquery.autocomplete.js'></script>
<script type='text/javascript' src='${path}/js/stockjs/stockdata.js'></script>
<script type='text/javascript' src='${path}/js/browser.js'></script>
</head>
<script type="text/javascript">
	function getEndtime(stockcycle){
		var cycletype = stockcycle.substring(stockcycle.length-1);
		var date = new Date();
		var strdate = "";
		if(cycletype == "天"){
			cycletype = stockcycle.substring(0,stockcycle.length-1);
			strdate = DateAdd("d",parseInt(cycletype),date);
		}else if(cycletype == "周"){
			cycletype = stockcycle.substring(0,stockcycle.length-1);
			strdate = DateAdd("w",parseInt(cycletype),date);
		}else if(cycletype == "月"){
			cycletype = stockcycle.substring(0,stockcycle.length-1);
			strdate = DateAdd("m",parseInt(cycletype),date);
		}else{
			cycletype = stockcycle.substring(0,stockcycle.length-1);
			strdate = DateAdd("y",parseInt(cycletype),date);
		}
		var endDate =  strdate.getFullYear()+"."+(strdate.getMonth()+1)+"."+strdate.getDate();
		return endDate;
	}
	$(document).ready(function() {
		 $("#stockcode").autocomplete(stock, {
			    minChars: 1,
			    max: 12,
			    autoFill: false,
			    mustMatch: true,
			    scrollHeight: 330,
			    matchSubset: true,
			    scroll: false,
			    matchContains: true,
			    //link : "/jsp/stock/stockDiagnosis.jsp?stockCode=",
			    formatItem: function(row, i, max) {
			        return row.code + " " + row.name + " " +  row.pinyin;
			    },
			    formatMatch: function(row, i, max) {
			        return row.code + " " + row.name + " " + row.pinyin;
			    },
			    formatResult: function(row) {
			    	var test = row.code + " " + row.name;
			        return test;
			    }
		});
		//回调
			$("#stockcode").result(findValueCallback);
			var intervalNumber=0;
		 	function findValueCallback(event, data, formatted) { 
		 		getStockCycleList();
		  	}
		    
	})

$(document).ready(function() {
	
	var bjJson1 = "";
	var bjJson2 = "";
	var stocklist = "";
	var qljlist = "";
	$.post("${path}/stockoption/getCycleAndPrice",function(data){
    	if(data.code == 0){
    		$.each(data.cycleList,function(i,n){
    			var dw = "";
    			if(n.type == 1){
    				dw = "天";
    			}else if(n.type == 2){
    				dw = "周";
    			}else if(n.type == 3){
    				dw = "月";
    			}else{
    				dw = "年";
    			}
				var time = n.cycle+dw;
				if(i == 0){
					stocklist = stocklist + "<span class=\"choose\"><span class=\"checkboxouter\"><input type=\"radio\" value='"+time+"' checked=\"checked\" name=\"need\" />"
								 + "<span class=\"radio\"></span></span><span class=\"text\">期限："+time+"</span></span>";
					$("#endtime").text(getEndtime(time));
					$("#cycletime").val(time);
					$("#cycleqlj").val(n.rate);
				}else{
					stocklist = stocklist + "<span class=\"choose\"><span class=\"checkboxouter\"><input type=\"radio\" value='"+time+"' name=\"need\" />"
					 + "<span class=\"radio\"></span></span><span class=\"text\">期限："+time+"</span></span>";
				}
				qljlist = qljlist + "<span>权利金比例：0.00%</span>";
    		})
    		$("#radiocycle").html(stocklist);
    		$("#spanqlj").html(qljlist);
    		$("#radiocycle input").on("click",function(){
				var val = $(this).val();
				$("#cycletime").val(val);
				$("#endtime").text(getEndtime(val));

	    	})
    		$.each(data.bjJson,function(i,n){
    			if(i < 3){
    				if(n.df == 0){
    					if(i == 2){
		    				bjJson1 = bjJson1 + "<span class=\"on\" style=\"margin-right:0\">"+n.money+"万</span>";
	    				}else{
	    					bjJson1 = bjJson1 + "<span class=\"on\" >"+n.money+"万</span>";
	    				}
    				}else{
    					if(i == 2){
		    				bjJson1 = bjJson1 + "<span style=\"margin-right:0\">"+n.money+"万</span>";
	    				}else{
	    					bjJson1 = bjJson1 + "<span >"+n.money+"万</span>";
	    				}
    				}
    			}else{
    				return false;
    			}
    		})
    		$("#mybjp1").html(bjJson1);
    		
    		
    		$.each(data.bjJson,function(i,n){
    			if(i > 2){
    				if(n.df == 0){
    					if(i == 5){
	    					bjJson2 = bjJson2 + "<span class=\"on\" style=\"margin-right:0\">"+n.money+"万</span>";
	    				}else{
	    					bjJson2 = bjJson2 + "<span class=\"on\" >"+n.money+"万</span>";
	    				}
	    			}else{
	    				if(i == 5){
	    					bjJson2 = bjJson2 + "<span style=\"margin-right:0\">"+n.money+"万</span>";
	    				}else{
	    					bjJson2 = bjJson2 + "<span>"+n.money+"万</span>";
	    				}
	    			}
    				
    			}else{
    				return true;
    			}
    		})
    		$("#mybjp2").html(bjJson2);
    		$("#mybjp1 span").on("click",function(){
    			$(this).siblings().removeClass('on');
    			$(this).parent('p').siblings().children('span').removeClass('on');
    			$(this).addClass('on');
    			var temp = $(this).text();
    			var length = temp.length;
    			var num = temp.substring(0,length-1);
    			$("#mymoney").val(num);
       			getqlj(null,null,num);
    		})
    		$("#mybjp2 span").on("click",function(){
    			$(this).siblings().removeClass('on');
    			$(this).parent('p').siblings().children('span').removeClass('on');
    			$(this).addClass('on');
    			var temp = $(this).text();
    			var length = temp.length;
    			var num = temp.substring(0,length-1);
    			$("#mymoney").val(num);
    			getqlj(null,null,num);
    		})
    	}
	})
		$("#mymoney").bind("keypress", function(event) {
		    var event= event || window.event;  
		    var getValue = $(this).val();  
		    //控制只能输入的值  
		    if (event.which && (event.which < 48 || event.which > 57) && event.which != 8 ) {  
		        event.preventDefault();  
		         return;  
		    }
		 })
	})
	//获取权利金
	function getqlj(stockcode,stockcycle,stockmybj){
		$.post("${path}/stockoption/getStockFloat",{"stockmybj":stockmybj},function(data){
	    	if(data.code == 0){
	    		var sum = 0;//权利金
	    		var mybjqlj = 0;
	    		
	    		var stockqlj = $("#stockqlj").val();
				if(stockqlj != null && stockqlj !== ""){
	    			sum = addNum(sum,stockqlj);
				}
				if(data.mybjqlj != null && data.mybjqlj !== ""){
	    			mybjqlj = data.mybjqlj;//名义本金权利金
	    			$("#mybjqlj").val(mybjqlj);
	    			sum = addNum(sum,mybjqlj);
	    			$("#sumqlj").val(sum.toFixed(2));
	    			var mybj = parseInt(stockmybj);
		     		var qljsum = (parseFloat(sum) * 100).toFixed(2);
		     		var zfje = (mybj*qljsum).toFixed(2);
		     		$("#rgqlj").text(zfje);
		     		$("#xzfje").text(zfje+"元");
		     		
	    		}
	    	}
		})
	}
	function payment(){
		var stock = $("#stockcode").val();
		if(stock == null || stock == ""){
			layer.msg("股票代码不能为空");
			return;
		}
		var mymoney = $("#mymoney").val();//名义本金
		if(mymoney == null || mymoney == "" || mymoney === "0"){
			layer.msg("名义本金不能为空");
			return;
		}
		var kyzc = $("#kyzc").text();
		var zfje = $("#rgqlj").text();
		if(kyzc == null || kyzc == ""){
			return ;
		}
		if(zfje == null || zfje == ""){
			return ;
		}
		kyzc = parseFloat(kyzc);
		zfje = parseFloat(zfje);
		if((kyzc - zfje) > 0){
			rengou();
		}else{
			layer.confirm('余额不足,是否充值？', {
				  btn: ['是','否'] 
				}, function(){
					window.location = "${path}/stockoption/stockoptionJump?str=fundpc&username="+username;
			});
		}
	}
	function rengou(){
		var stock = $("#stockcode").val();
		var arr = stock.split(" ");
		var stockcode = arr[0];//股票代码
		var stockname = arr[1];//股票名称
		var mymoney = $("#mymoney").val();//名义本金
		var stockcycle = $("#cycletime").val();//周期
		var qljsum = $("#sumqlj").val();//权利金
		var endDate = getEndtime(stockcycle);//到期时间
		//解析周期type 和 time
		var cycletype = stockcycle.substring(stockcycle.length-1);
		var type = "";
		var time = "";
		if(cycletype == "天"){
			type = "1";
			time = stockcycle.substring(0,stockcycle.length-1);
		}else if(cycletype == "周"){
			type = "2";
			time = stockcycle.substring(0,stockcycle.length-1);
		}else if(cycletype == "月"){
			type = "3";
			time = stockcycle.substring(0,stockcycle.length-1);
		}else{
			type = "4";
			time = stockcycle.substring(0,stockcycle.length-1);
		}
		
 		var qlje = $("#rgqlj").text();//权利金额
 		
		var cycleqlj = $("#cycleqlj").val();//cycleqlj 周期权利金
		var mybjqlj = $("#mybjqlj").val();//mybjqlj 名义本金权利金
		
		layer.confirm('您确认要认购吗？', {
			  btn: ['是','否'] 
			}, function(){
				$.post("${path}/stockoption/appSubscription",{"subzh":username,"stockcode":stockcode,"stockname":stockname,"qlj":qljsum,"mybj":mymoney,"money":qlje,"type":type,"value":time,"cycleqlj":cycleqlj,"mybjqlj":mybjqlj,"endtime":endDate,"localsource":"pc"},function(data){
			    	if(data.code == 0){
			    		window.location = "${path}/stockoption/stockoptionJump?str=rg";
			    	}else{
			    		layer.msg(data.message);
			 	    }
				})
		});
	}
	function addNum(num1, num2) {
		 var sq1,sq2,m;
		 try {
		  sq1 = num1.toString().split(".")[1].length;
		 }
		 catch (e) {
		  sq1 = 0;
		 }
		 try {
		  sq2 = num2.toString().split(".")[1].length;
		 }
		 catch (e) {
		  sq2 = 0;
		 }
		 m = Math.pow(10,Math.max(sq1, sq2));
		 return (num1 * m + num2 * m) / m;
	}
	function keyupmoney(){
		var mymoney = $("#mymoney").val();
		if(mymoney == "" || mymoney == 0){
			$("#rgqlj").text("");
			$("#xzfje").text("元");
		}else{
			getqlj(null,null,mymoney);
		}
	}
	function getStockCycleList(){//获取股票周期list
		var stockcode = $("#stockcode").val();
		var arr = stockcode.split(" ");
		var stocklist = "";
		var qljlist = "";
		$.post("${path}/stockoption/getStockcodeList",{"stockcode":arr[0]},function(data){
			if(data.code == 0){
				$.each(data.stockcodeList,function(i,n){
	    			var dw = "";
	    			if(n.cycleType == 1){
	    				dw = "天";
	    			}else if(n.cycleType == 2){
	    				dw = "周";
	    			}else if(n.cycleType == 3){
	    				dw = "月";
	    			}else{
	    				dw = "年";
	    			}
					var time = n.cycleTime+dw;
    				if(i == 0){
    					stocklist = stocklist + "<span class=\"choose\"><span class=\"checkboxouter\"><input type=\"radio\" value='"+n.stockcodeqlj+","+n.cycleqlj+","+time+"' checked=\"checked\" name=\"need\" />"
    								 + "<span class=\"radio\"></span></span><span class=\"text\">期限："+time+"</span></span>";
    					$("#endtime").text(getEndtime(time));
    					$("#cycletime").val(time);
    					$("#stockqlj").val(n.stockcodeqlj);
    					$("#cycleqlj").val(n.cycleqlj);
    				}else{
    					stocklist = stocklist + "<span class=\"choose\"><span class=\"checkboxouter\"><input type=\"radio\" value='"+n.stockcodeqlj+","+n.cycleqlj+","+time+"' name=\"need\" />"
						 + "<span class=\"radio\"></span></span><span class=\"text\">期限："+time+"</span></span>";
    				}
    				qljlist = qljlist + "<span>权利金比例："+n.stockcodeqlj+"%</span>";
	    		})
	    		$("#radiocycle").html(stocklist);
				$("#spanqlj").html(qljlist);
			}else{
				layer.msg("该品种不支持询价");
				$.post("${path}/stockoption/getCycleAndPrice",function(data){
			    	if(data.code == 0){
			    		$.each(data.cycleList,function(i,n){
			    			var dw = "";
			    			if(n.type == 1){
			    				dw = "天";
			    			}else if(n.type == 2){
			    				dw = "周";
			    			}else if(n.type == 3){
			    				dw = "月";
			    			}else{
			    				dw = "年";
			    			}
							var time = n.cycle+dw;
							if(i == 0){
								stocklist = stocklist + "<span class=\"choose\"><span class=\"checkboxouter\"><input type=\"radio\" value='"+time+"' checked=\"checked\" name=\"need\" />"
											 + "<span class=\"radio\"></span></span><span class=\"text\">期限："+time+"</span></span>";
								$("#endtime").text(getEndtime(time));
								$("#cycletime").val(time);
								$("#stockqlj").val("");
								$("#rgqlj").text("");
								$("#xzfje").text("元");
								$("#cycleqlj").val(n.rate);
							}else{
								stocklist = stocklist + "<span class=\"choose\"><span class=\"checkboxouter\"><input type=\"radio\" value='"+time+"' name=\"need\" />"
								 + "<span class=\"radio\"></span></span><span class=\"text\">期限："+time+"</span></span>";
							}
							qljlist = qljlist + "<span>权利金比例：0.00%</span>";
			    		})
			    		$("#radiocycle").html(stocklist);
			    		$("#spanqlj").html(qljlist);
			    	}
			    })
			}
			$("#radiocycle input").on("click",function(){
				var val = $(this).val();
				var arr = val.split(",");
				var stockqlj = arr[0];
				var cycleqlj = arr[1];
				var cycle = arr[2];

				$("#stockqlj").val(stockqlj);
				$("#sumqlj").val(stockqlj);
				$("#cycleqlj").val(cycleqlj);
				$("#cycletime").val(cycle);
				$("#endtime").text(getEndtime(cycle));
				var mymoney = $("#mymoney").val();
				if(mymoney != null && mymoney != ""){
					var mybj = parseInt(mymoney);
					var sum = addNum ($("#sumqlj").val(), $("#mybjqlj").val())
		     		var qljsum = (parseFloat(sum) * 100).toFixed(2);
		     		var zfje = (mybj*qljsum).toFixed(2);
		     		
		     		$("#rgqlj").text(zfje);
		     		$("#xzfje").text(zfje+"元");
				}
	    	})
		})
	}
	/*
	 *   功能:实现VBScript的DateAdd功能.
	 *   参数:interval,字符串表达式，表示要添加的时间间隔.
	 *   参数:number,数值表达式，表示要添加的时间间隔的个数.
	 *   参数:date,时间对象.
	 *   返回:新的时间对象.
	 *   var now = new Date();
	 *   var newDate = DateAdd( "d", 5, now);
	 *---------------   DateAdd(interval,number,date)   -----------------
	 */
	function DateAdd(interval, number, date) {
	    switch (interval) {
	    case "y": {
	        date.setFullYear(date.getFullYear() + number);
	        return date;
	        break;
	    }
	    case "q": {
	        date.setMonth(date.getMonth() + number * 3);
	        return date;
	        break;
	    }
	    case "m": {
	        date.setMonth(date.getMonth() + number);
	        return date;
	        break;
	    }
	    case "w": {
	        date.setDate(date.getDate() + number * 7);
	        return date;
	        break;
	    }
	    case "d": {
	        date.setDate(date.getDate() + number);
	        return date;
	        break;
	    }
	    case "h": {
	        date.setHours(date.getHours() + number);
	        return date;
	        break;
	    }
	    case "m": {
	        date.setMinutes(date.getMinutes() + number);
	        return date;
	        break;
	    }
	    case "s": {
	        date.setSeconds(date.getSeconds() + number);
	        return date;
	        break;
	    }
	    default: {
	        date.setDate(date.getDate() + number);
	        return date;
	        break;
	    }
	    }
	}
	function toDecimal2(x) { 
		  var f = parseFloat(x); 
		  if (isNaN(f)) { 
		  return false; 
		  } 
		  var f = Math.round(x*100)/100; 
		  var s = f.toString(); 
		  var rs = s.indexOf('.'); 
		  if (rs < 0) { 
		  rs = s.length; 
		  s += '.'; 
		  } 
		  while (s.length <= rs + 2) { 
		  s += '0'; 
		  } 
		  return s; 
	}
	function jumphangqing(){
		var stockcode = $("#stockcode").val();
		if(stockcode != null && stockcode != ""){
			var arr = stockcode.split(" ");
			window.location = "http://gzh.jincelue.net:8080/hqcn/html/zijin.html?symbol="+arr[0]+"&xuao=1"
		}
	}
	function wtxy(){
		window.location = "${path}/stockoption/stockoptionJump?str=wtxy";
	}
</script>
<body class="bggray">
    <div class="category">
    <!-- insder header -->
    <header class="ls-header">
<!--         <div class="ls-header-left"> -->
<!--             <a href="javascript:history.go(-1)"><i class="iconfont icon-back"></i></a> -->
<!--         </div> -->
        <div class="ls-header-title">交易与持仓</div>
        <div class="ls-header-right">
           <a href="javascript:void(0)" onclick="rg()"><i class="iconfont icon-flash"></i></a>
        </div>
    </header>
    <div class="mainbox">
         <section>
             <div class="Tradebox">
                 <ul class="Tnum">
                    <li>总资产：<span>${userinfo.rzj}</span></li>
                    <li>可用资产：<span id="kyzc">${userinfo.xzj + userinfo.bzj}</span></li>
                 </ul>
                 <ul class="Ttab">
                     <li><a href="javascript:;" class="on" onclick="rg()">询价</a></li>
                     <li><a href="javascript:;" onclick="rgcx()">认购</a></li>
                     <li><a href="javascript:;" onclick="cc()">持仓</a></li>
                     <li><a href="javascript:;" onclick="js()">查询</a></li>
                 </ul>
                 <ul class="Asknum">
                     <li>
                         <label>证券代码</label>
                         <input type="text" id="stockcode" name="stockcode" placeholder="请输入股票名称/代码" style="width:50%;">
                         <input type="button" class="HQbut" onclick="jumphangqing()" value="行情">
                     </li>
                     <li>
                         <div class="Timeg">
                              <div class="kv-item-content" id="radiocycle">
                              </div>
                         </div>
                         <div class="Goldbox" id="spanqlj">
                         </div>
                     </li>
                     <li style="position:relative;">
                        <span style="position:absolute; right:2rem; top:1.8rem;">万元</span>
                        <label>名义本金</label>
                        <input type="text" id="mymoney" onkeyup="keyupmoney()" placeholder="请输入本金" class="Tinput">
                        <div class="Chbox" id="mybj">
                             <p class="Tline" id="mybjp1">
                             </p>
                             <p class="Tline" id="mybjp2">
                             </p>
                        </div>
                     </li>
                     <li>
                         <label>认购权利金</label>
                         <span class="Qgold red" id="rgqlj"></span>
                         <span class="Qgold Unit">元</span>
                         <input type="hidden" id="cycleqlj"/>
                         <input type="hidden" id="mybjqlj"/>
                         <input type="hidden" id="stockqlj"/>
                         <input type="hidden" id="sumqlj"/>
                         <input type="hidden" id="cycletime"/>
                     </li>
                     <li>
                         <label>到期时间</label>
                         <span class="Qgold" id="endtime"></span>
                     </li>
                 </ul>
             </div>
             <div class="Sumbox">
                <div class="Gsum">
                   <p>需支付<span id="xzfje">元</span></p>
                   <div class="rline" style="margin:0;">
                        <div class="rememberField">
                             <span class="checkboxPic" tabindex="-1" isshow="false">
                                  <i class="i_icon"></i>
                             </span>
                                <label>我已阅读并同意<a href="javascript:;" onclick="wtxy()">《委托合作协议》</a></label>
                        </div>
                   </div>
               </div>
               <div class="Balan" id="balanDiv" onclick="payment()">
<!--                余额不足，请充值 -->
                  <p class="upp">确定</p>
<%--                   <p>余额：<span>${userinfo.xzj + userinfo.bzj}</span>元</p> --%>
               </div>
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
      <!--弹出信息-->
            <div id="Assetbox">
                 <span id="close"><img  src="${path }/images/shanchu.png"></span>
                 <div class="contents">
                      <h3>询价结果</h3>
                      <ul>
                         <li><span>标的股票:</span><em id="tr1"></em></li>
                         <li><span>名义本金:</span><i style="padding-top:0.5rem;">元</i><em class="Bnum" id="tr2"></em></li>
                         <li><span>行权周期:</span><em id="tr3"></em></li>
                         <li><span>权利金:</span><em class="red" id="tr4"></em></li>
                         <li><span>认购金额:</span><i>元</i><em class="red" id="tr5"></em></li>
                         
                      </ul>
                      <table width="88%;">
                         <tr>
                            <td>预期涨幅</td>
                            <td>盈亏比例</td>
                            <td>盈亏金额</td>
                         </tr>
                         <tr class="red">
                            <td id="tr1_1"></td>
                            <td>0%</td>
                            <td id="tr1_2"></td>
                         </tr>
                         <tr class="red">
                            <td id="tr2_1"></td>
                            <td>20%</td>
                            <td id="tr2_2"></td>
                         </tr>
                         <tr class="red">
                            <td id="tr3_1"></td>
                            <td>50%</td>
                            <td id="tr3_2"></td>
                         </tr>
                         <tr class="red">
                            <td id="tr4_1"></td>
                            <td>100%</td>
                            <td id="tr4_2"></td>
                         </tr>
                      </table>
                      <a href="javascript:;" class="RGbut" id="ljrg" onclick="rengou()">立即认购</a>
                 </div>
           </div>
<!--弹出信息-->
<script type="text/javascript">
    $(function(){
        //定义弹窗位置
        jQuery.fn.center = function () {
            this.css({
                "position" :"fixed",
                "top" : 58 + "%",
                "marginTop" : ("-" + this.height() / 2) + "px",
                "left" : ( $(window).width() - this.width() ) / 2+$(window).scrollLeft() + "px"
            });
            return this;
			};
			$("#Assetbox").center();
			//弹窗、遮罩显示/隐藏
// 			$('#balanDiv').click(function(){
// 				$('.maskBg,#Assetbox').fadeIn();
// 			});
			$('#close,#ljrg').click(function(){
				$('.maskBg,#Assetbox').fadeOut();
			});
    })
</script>
</body>
</html>