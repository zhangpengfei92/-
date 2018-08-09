<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${nvo.title}_中金宸大</title>

<meta name="description" content="${nvo.summary}"/>
<meta name="keywords" content="${nvo.keywords}"/>


<link href="${staticpath}/css/css.css" rel="stylesheet" type="text/css" />
<script src="${staticpath}/js/jquery1.42.min.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function () {	
	$(".Ncenter ul li").click(function(){
			var index=$(".Ncenter ul li").index(this);
			$(this).addClass("select hover").siblings().removeClass("select hover");
			$(".Ncenter .hides").eq(index).show().siblings(".Ncenter .hides").hide();
	})
	
		//去掉所有的导航栏高亮显示样式
		$(".Zlogo ul li a ").each(function () {  
				$(this).removeClass("on");  
			}); 
		//被导航栏选中高亮显示
		$("#newsdetail").addClass("on");
});

//首页
function homepage() {
	  window.location.href = "${path}/indexList";
}

//新闻中心
function news() {
	window.location.href = "${path}/news";
}
</script>
</head>
<body>
<%@include file="../../top.jsp"%>
<div class="Ncenter">
    <h1>您的位置：<a href="javascript:;" class="on" onclick="homepage()">首页</a> > <a href="javascript:;" class="on" onclick="news()">新闻中心</a> > 
    <a href="javascript:;">${nvo.ntype==1?'最新专题':nvo.ntype==2?'公司新闻':nvo.ntype==3?'市场动态':'常见答疑'}</a></h1>
    <h2>${nvo.title}</h2>
    <h4>发布时间：<fmt:formatDate value="${nvo.modifytime}" pattern="yyyy-MM-dd HH:mm:ss"/></h4>
    <div class="Deaut">
		${nvo.newscontent}
   	 
    </div>
</div>
<%@include file="../../foot.jsp"%>
</body>
</html>