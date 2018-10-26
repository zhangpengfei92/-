<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	$(document).ready(function() {
		
		var cycleJson1 = "";
		var cycleJson2 = "";
		var bjJson1 = "";
		var bjJson2 = "";
		$.post("${path}/stockoption/getCycleAndPrice",function(data){
	    	if(data.code == 0){
	    		$.each(data.cycleJson,function(i,n){
	    			var dw = "";
	    			if(n.type == 1){
	    				dw = "天";
	    			}else if(n.type == 2){
	    				dw = "周";
	    			}else if(n.type == 3){
	    				dw = "个月";
	    			}else{
	    				dw = "年";
	    			}
	    			if(i < 3){
	    				if(i == 0){
		    				cycleJson1 = cycleJson1 + "<span class=\"on\">"+n.value+dw+"</span>";
		    			}else if(i == 2){
	    					cycleJson1 = cycleJson1 + "<span style=\"margin-right:0\">"+n.value+dw+"</span>";
	    				}else{
	    					cycleJson1 = cycleJson1 + "<span>"+n.value+dw+"</span>";
	    				}
	    			}else{
	    				return false;
	    			}
	    		})
	    		$("#xqzqp1").html(cycleJson1);
	    		
	    		$.each(data.cycleJson,function(i,n){
	    			var dw = "";
	    			if(n.type == 1){
	    				dw = "天";
	    			}else if(n.type == 2){
	    				dw = "周";
	    			}else if(n.type == 3){
	    				dw = "个月";
	    			}else{
	    				dw = "年";
	    			}
	    			if(i > 2){
	    				if(i == 5){
	    					cycleJson2 = cycleJson2 + "<span style=\"margin-right:0\">"+n.value+dw+"</span>";
	    				}else{
	    					cycleJson2 = cycleJson2 + "<span>"+n.value+dw+"</span>";
	    				}
	    			}else{
	    				return true;
	    			}
	    		})
	    		$("#xqzqp2").html(cycleJson2);
	    		$("#xqzqp1 span").on("click",function(){
	       			$(this).siblings().removeClass('on');
	       			$(this).parent('p').siblings().children('span').removeClass('on');
	       			$(this).addClass('on');
	       			var cycle = $(this).text()
	       			$("#cycle").val(cycle);
	       			getqlj(null,cycle,null);
	       			
	       		})
	    		$("#xqzqp2 span").on("click",function(){
	    			$(this).siblings().removeClass('on');
	    			$(this).parent('p').siblings().children('span').removeClass('on');
	    			$(this).addClass('on');
	    			var cycle = $(this).text()
	       			$("#cycle").val(cycle);
	       			getqlj(null,cycle,null);
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
		 		var stockcode = data.code;
		 		var stockcycle = $("#xqzq .on").text();
		 		getqlj(stockcode,stockcycle,null);
		  	}
	})
		var realprice = 0;//股票权利金
		var cycleqlj = 0;//周期权利金
		var mybjqlj = 0;//名义本金权利金
		
	//获取权利金
	function getqlj(stockcode,stockcycle,stockmybj){
		if(stockcode == null){
			var stockcodes = $("#stockcode").val();
			if(stockcodes != null && stockcodes != "" ){
				stockcode = stockcodes.split(" ")[0];
			}
		}
		if(stockcycle == null){
			stockcycle = $("#xqzq .on").text();//周期
		}
		if(stockmybj == null){
			stockmybj = $("#mymoney").val();//名义本金
		}
		$.post("${path}/stockoption/getStockFloat",{"stockcode":stockcode,"stockcycle":stockcycle,"stockmybj":stockmybj},function(data){
	    	if(data.code == 0){
	    		var sum = 0;//权利金
	    		if(data.realprice != null && data.realprice != ""){
	    			realprice = data.realprice;//股票权利金
	    			$("#realprice").val(realprice);
	    		}
	    		if(data.cycleqlj != null && data.cycleqlj != ""){
	    			cycleqlj = data.cycleqlj;//周期权利金
	    			$("#cycleqlj").val(cycleqlj);
	    		}
	    		if(data.mybjqlj != null && data.mybjqlj != ""){
	    			mybjqlj = data.mybjqlj;//周期权利金
	    			$("#mybjqlj").val(mybjqlj);
	    		}
	    		sum = addNum(sum,realprice);
	    		sum = addNum(sum,cycleqlj);
	    		sum = addNum(sum,mybjqlj);
	    		
	    		$("#qljsum").text(sum.toFixed(2)+"%");
	    	}
		})
	}
	function addNum (num1, num2) {
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
			$("#qljsum").text("");
		}else{
			getqlj(null,null,mymoney);
		}
	}
	function xjrg(){
		//str1,str2,str3,str4,str5,str6,str7,str8,str9
		//str1 股票代码 str2 股票名称 str3 名义本金 str4 周期时间  str5 周期type  str6 权利金  str7 认购金额  str8 询价id  str9 到期时间
		var stock = $("#stockcode").val();
		var mymoney = $("#mymoney").val();//名义本金
		var stockcycle = $("#xqzq .on").text();//周期
		var qljsum = $("#qljsum").text();//权利金
		
		if(stock == "" || stock == null){
			layer.msg("股票代码不能为空");
			return;
		}
		if(mymoney == "" || mymoney == null){
			layer.msg("名义本金不能为空");
			return;
		}
		if(qljsum == "" || qljsum == null){
			layer.msg("权利金不能为空");
			return;
		}
		$('.maskBg,#Assetbox').fadeIn();
		var endDate = getEndtime(stockcycle);//到期时间
		var arr = stock.split(" ");
		$("#tr1").html(arr[0]+"("+arr[1]+")");
		
		$("#tr2").html(mymoney+"0000");

 		mymoney = parseInt(mymoney);
 		qljsum = parseFloat(qljsum);
 		
		$("#tr3").html(stockcycle+"("+endDate+")");
		$("#tr4").html(qljsum + "%");
		$("#tr5").html((qljsum*100*mymoney).toFixed(2));
// 		$("#seid").val(str8);
		var mybj = mymoney * 100;
		$("#tr1_1").html(toDecimal2(qljsum)+"%");
		$("#tr1_2").html((mybj * qljsum).toFixed(2) );
		$("#tr2_1").html(toDecimal2(qljsum * 1.2)+"%");
		$("#tr2_2").html((mybj * qljsum * 1.2).toFixed(2) );
		$("#tr3_1").html(toDecimal2(qljsum * 1.5)+"%");
		$("#tr3_2").html((mybj * qljsum * 1.5).toFixed(2) );
		$("#tr4_1").html(toDecimal2(qljsum * 2)+"%");
		$("#tr4_2").html((mybj * qljsum * 2).toFixed(2) );
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
			cycletype = stockcycle.substring(0,stockcycle.length-2);
			strdate = DateAdd("m",parseInt(cycletype),date);
		}else{
			cycletype = stockcycle.substring(0,stockcycle.length-1);
			strdate = DateAdd("y",parseInt(cycletype),date);
		}
		var endDate =  strdate.getFullYear()+"."+(strdate.getMonth()+1)+"."+strdate.getDate();
		return endDate;
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
	function rengou(){
		var stock = $("#stockcode").val();
		var arr = stock.split(" ");
		var stockcode = arr[0];//股票代码
		var stockname = arr[1];//股票名称
		var mymoney = $("#mymoney").val();//名义本金
		var stockcycle = $("#xqzq .on").text();//周期
		var qljsum = $("#qljsum").text();//权利金
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
			time = stockcycle.substring(0,stockcycle.length-2);
		}else{
			type = "4";
			time = stockcycle.substring(0,stockcycle.length-1);
		}
		qljsum = parseFloat(qljsum);
		mymoney = parseInt(mymoney);
 		var qlje = mymoney * qljsum * 100;;//权利金额
 		
		//cycleqlj 周期权利金
		//mybjqlj 名义本金权利金
		
		$.post("${path}/stockoption/appSubscription",{"subzh":username,"stockcode":stockcode,"stockname":stockname,"qlj":qljsum,"mybj":mymoney,"money":qlje,"type":type,"value":time,"cycleqlj":cycleqlj,"mybjqlj":mybjqlj,"endtime":endDate,"localsource":"pc"},function(data){
	    	if(data.code == 0){
	    		window.location = "${path}/stockoption/stockoptionJump?str=xj";
	    	}else{
	    		layer.msg(data.message);
	 	   }
		})
	}
</script>
<body class="bggray">
	<!-- 遮罩层 start -->
    <div class="maskBg"></div>
    <!-- 遮罩层 end -->
    <div class="category">
    <!-- insder header -->
    <header class="ls-header">
        <div class="ls-header-left">
            <a href="javascript:history.go(-1)"><i class="iconfont icon-back"></i></a>
        </div>
        <div class="ls-header-title">询价</div>
        <div class="ls-header-right">
           <a href=""><i class="iconfont icon-flash"></i></a>
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
                     <li><a href="javascript:;" class="on" onclick="xj()">询价</a></li>
                     <li><a href="javascript:;" onclick="rg()">认购</a></li>
<!--                      <li><a href="javascript:;" onclick="cd()">撤单</a></li> -->
                     <li><a href="javascript:;" onclick="cc()">持仓</a></li>
                     <li><a href="javascript:;" onclick="js()">结算</a></li>
                 </ul>
                 <ul class="Asknum">
                     <li>
                         <label>股票名称</label>
                         <input type="text" id="stockcode" name="stockcode"  placeholder="请输入股票名称/代码">
                         <input type="hidden" id="realprice" />
                         <input type="hidden" id="cycleqlj" />
                         <input type="hidden" id="mybjqlj" />
                     </li>
                     <li>
                        <label>行权周期</label>
                        <div class="Chbox" id="xqzq">
                             <p class="Tline" id="xqzqp1">
                             </p>
                             <p class="Tline" id="xqzqp2">
                             </p>
                             <input type="hidden" id="cycle" />
                        </div>
                     </li>
                     <li style="position:relative;">
                        <span style="position:absolute;right:2rem; top:1.8rem;">万元</span>
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
                         <label>权利金比例</label>
                         <span class="Qgold" id="qljsum"></span>
                     </li>
                     <p class="RGbut" onclick="xjrg()">认购</p>

                 </ul>
             </div>
        </section> 
        <%@include file="../../../foot.jsp"%>
  </div>
    <!--弹出信息-->
            <div id="Assetbox">
                 <span id="close"><img  src="${path}/images/shanchu.png"></span>
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
                "top" : 68 + "%",
                "marginTop" : ("-" + this.height() / 2) + "px",
                "left" : ( $(window).width() - this.width() ) / 2+$(window).scrollLeft() + "px"
            });
            return this;
			};
			$("#Assetbox").center();
			//弹窗、遮罩显示/隐藏
// 			$('.RGbut').click(function(){
// 				$('.maskBg,#Assetbox').fadeIn();
// 			});
			$('#close,#ljrg').click(function(){
				$('.maskBg,#Assetbox').fadeOut();
			});
    })
</script>
</body>
</html>