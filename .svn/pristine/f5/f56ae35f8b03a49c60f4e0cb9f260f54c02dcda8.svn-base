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
	       			$("#cycle").val($(this).text());
	       		})
	    		$("#xqzqp2 span").on("click",function(){
	    			$(this).siblings().removeClass('on');
	    			$(this).parent('p').siblings().children('span').removeClass('on');
	    			$(this).addClass('on');
	    			$("#cycle").val($(this).text());
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
	    		})
	    		$("#mybjp2 span").on("click",function(){
	    			$(this).siblings().removeClass('on');
	    			$(this).parent('p').siblings().children('span').removeClass('on');
	    			$(this).addClass('on');
	    			var temp = $(this).text();
	    			var length = temp.length;
	    			var num = temp.substring(0,length-1);
	    			$("#mymoney").val(num);
	    		})
	    	}
		})
		
		$("#mybj p span").click(function(){
			$(this).siblings().removeClass('on');
			$(this).parent('p').siblings().children('span').removeClass('on');
			$(this).addClass('on');
			var temp = $(this).text();
			var length = temp.length;
			var num = temp.substring(0,length-1);
			$("#mymoney").val(num);
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
// 		$("#stockcode").result(findValueCallback);
// 		var intervalNumber=0;
// 	 	function findValueCallback(event, data, formatted) { 
// 	     	if(intervalNumber!=0){
// 	        	clearInterval(intervalNumber);
// 	    	}
// 	        var code = data.code+"("+data.name+")";
// 	        $("#stockcode").val(code);
// 	  	}
	})
	
	function subStock(){
		var stockcode = $("#stockcode").val();
		var cycle = $("#cycle").val();
		var mymoney = $("#mymoney").val();
		if(stockcode.length == 0){
			layer.msg("股票代码不能为空");
			return ;
		}

		if(mymoney.length == 0){
			layer.msg("名义本金不能为空");
			return ;
		}
		if(cycle.length == 0){
			cycle = $("#xqzq .on").text();
		}
		$.post("${path}/stockoption/stockEnquiry",{"phone":username,"stockcode":stockcode,"cycle":cycle,"mymoney":mymoney},function(data){
	    	if(data.code == 0){
	    		window.location = "${path}/stockoption/stockoptionJump?str=xj";
	    	}else{
	    		layer.msg(data.message);
	 	   }
		})
	}
	
</script>
<body class="bggray">
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
                     <li>
                        <label>名义本金</label>
                        <input type="text" placeholder="请输入本金" id="mymoney" name="mymoney" class="Tinput"/><span style="position:absolute;right:2rem; top:1.8rem;">万元</span>
                        
                        <div class="Chbox" id="mybj">
                             <p class="Tline" id="mybjp1">
                             </p>
                             <p class="Tline" id="mybjp2">
                             </p>
                        </div>
                     </li>
                     <p class="RGbut" onclick="subStock()">询价</p>
                     <div class="rline">
                        <div class="rememberField">
                            <span class="checkboxPic" tabindex="-1" isshow="false">
                                <i class="i_icon"></i>
                            </span>
                            <label>我已阅读并同意<a href="javascript:;">《委托合作协议》</a></label>
                        </div>
                        <div class="forget"><a href="javascript:;">帮助说明</a></div>
                    </div>
                 </ul>
             </div>
        </section>   
        <%@include file="../../../foot.jsp"%>       
  </div>
</body>
</html>