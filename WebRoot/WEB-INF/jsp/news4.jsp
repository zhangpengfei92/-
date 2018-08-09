<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>中金宸大</title>
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
		$("#news").addClass("on");
		
		var num = $.trim($("#newstype").val());
		
		$(".Zlogo ul li a ").each(function () {  
			$(this).removeClass("select");  
		}); 
		
});	 



//分页查询
function  serach(pageNum) {
	
	window.location.href = "${path}/news/cjdy/"+pageNum;
}


//翻页
function tzfy() {

	var pageNum = $.trim($("#pageNum").val());
	var pages = $.trim($("#pages").val());
	
	if(pageNum==""||pageNum>pages){
		alert("输入页码有误")
	}else{
		serach(pageNum);
	}
}


function querydetails(nid) {
	window.open("${path}/news/"+nid);
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

<%@include file="../../top.jsp"%>
<div class="Ncenter">
<input type="hidden" value="${num}" id="newstype">
    <ul class="tit">
          <li onclick="selectNews('1')" id="news1">最新专题</li>
          <li onclick="selectNews('2')" id="news2">公司新闻</li>
          <li onclick="selectNews('3')" id="news3">市场动态</li>
          <li class="select" onclick="selectNews('4')" id="news4">常见答疑</li>
    </ul>
    <!--最新专题  -->
       <div class="hides">
           <ul class="QAbox">
		      <c:forEach items="${nlist}" var="sn">
		             <li>
		                  <p class="Qust">${sn.title} </p>
		                  <p class="Anws">${sn.summary} </p>
		               </li>
		       </c:forEach>
           </ul>
       
        <div class="Page"> 
         <c:choose>
         	<c:when test="${fn:length(nlist)<1}">
         	
         	</c:when>
         	<c:otherwise>
		 <c:if test="${userpage.pageNum == 1 }">
	    		<a href="javascript:;">首页</a>
	    		<a href="javascript:;">上一页</a>
	    </c:if>
	    <c:if test="${userpage.pageNum> 1 }">
	    		<a href="javascript:;" onclick="serach(1)">首页</a>
	    		<a href="javascript:;" onclick="serach(${userpage.prePage})">上一页</a>
	    </c:if>        
	
		<c:choose>
			<c:when test="${userpage.pages <= 5 }">
				<c:set var="begin" value="1"></c:set>
				<c:set var="end" value="${userpage.pages }"></c:set>
			</c:when>
			<c:otherwise>
				<c:if test="${userpage.pageNum <= 3 }">
					<c:set var="begin" value="1"></c:set>
					<c:set var="end" value="5"></c:set>
				</c:if>
				<c:if test="${userpage.pageNum > 3 }">
					<c:set var="begin" value="${userpage.pageNum - 2 }"></c:set>
					<c:set var="end" value="${userpage.pageNum + 2 }"></c:set>
					<c:if test="${end > userpage.pages }">
						<c:set var="end" value="${userpage.pages  }"></c:set>
						<c:set var="begin" value="${userpage.pages - 4 }"></c:set>
					</c:if>
				</c:if>
			</c:otherwise>
		</c:choose>
	
		<c:forEach begin="${begin }" end="${end}" var="index">
			<c:choose>
				<c:when test="${index == userpage.pageNum}">
					<a href="javascript:;" class="on">${index}</a>
				</c:when>
				<c:otherwise>
					<a href="javascript:;" onclick="serach(${index})">${index}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${userpage.pageNum == userpage.pages }">
			<a href="javascript:;">下一页</a>
			<a	href="javascript:;">末页</a>
		</c:if>
		<c:if test="${userpage.pageNum < userpage.pages }">
			<a href="javascript:;" onclick="serach(${userpage.nextPage})" >下一页</a>
			<a href="javascript:;" onclick="serach(${userpage.pages})" >末页</a>
		</c:if>
		 <a>跳转到：</a>
		 <input type="hidden" id="pages" value="${userpage.pages}" />
            <input type="text" id="pageNum" />
          <a href="javascript:;" onclick="tzfy()">GO</a>
            </c:otherwise>
        </c:choose>
       </div>
    </div>
  </div>  
<%@include file="../../foot.jsp"%>
</body>
</html>