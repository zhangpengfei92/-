<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${staticpath}/css/css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	
//股票配资
function stockAllocation() {
	window.location.href = "${path}/gppz";
} 

//期货配资
function futuresAllocation() {
	window.location.href = "${path}/qhpz";
}

//场外期权
function outOptions() {
	window.location.href = "${path}/cwqq";
}

//国际期货
function internationalFutures() {
	window.location.href = "${path}/gjqh";
}

function selectNews(index){
	var papeNum=1;
	if(index==1){
		window.location.href = "${path}/news/zxzt/"+papeNum;
	}else if(index==2){
		window.location.href = "${path}/news/gsxw/"+papeNum;	
	}else if(index==3){
		window.location.href = "${path}/news/zxdt/"+papeNum;
	}else if(index==4){
		window.location.href = "${path}/news/cjdy/"+papeNum;
	}
}

</script>
</head>
<body>
	<div class="footbox">
    <div class="foot">
         <ul>
            <li class="tit"><a href="javscript:;">关于我们</a></li>
          	<li><a href="${path}/aboutus.jsp#div1" >公司介绍</a></li>
            <li><a href="${path}/aboutus.jsp#div2" >联系我们</a></li>
         </ul>
         <ul>
            <li class="tit"><a href="javscript:;">方案中心</a></li>
            <li><a href="javascript:;" onclick="stockAllocation()">股票配资</a></li>
            <li><a href="javascript:;" onclick="futuresAllocation()">期货配资</a></li>
            <li><a href="javascript:;" onclick="outOptions()">场外期权</a></li>
            <li><a href="javascript:;" onclick="internationalFutures()">国际期货</a></li>
         </ul>
         <ul>
            <li class="tit"><a href="javscript:;">新闻资讯</a></li>
            <li><a href="javascript:;"  onclick="selectNews(1)">最热专题</a></li>
            <li><a href="javascript:;"  onclick="selectNews(2)">公司新闻</a></li>
            <li><a href="javascript:;"  onclick="selectNews(3)">市场动态</a></li>
            <li><a href="javascript:;"  onclick="selectNews(4)">常见答疑</a></li>
         </ul>
         <div class="call">
            <p class="tit">联系我们</p>
            <p>武汉中金宸大网络科技有限公司</p>
            <p>服务热线<span>027-88771708</span></p>
            <p>E-Mail<i>2852373337@qq.com</i></p>
         </div>
         <div class="ewm">
           <img src="${staticpath}/images/ewm.png" />
         </div>
    </div>
    <div class="footb">版权所有：武汉中金宸大网络科技有限公司©2018<i></i>鄂ICP备17030531号</div>
</div>
</body>
</html>