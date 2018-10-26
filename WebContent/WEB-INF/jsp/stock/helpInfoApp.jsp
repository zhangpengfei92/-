<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@include file="../../../head.jsp"%>
<head>
<script type="text/javascript">
$(document).ready(function() {
	$('.inactive').click(function(){
		$(this).parent('li').siblings().children('ul').css('display','none');
		$(this).parent('li').siblings().find('.inactive').removeClass('inactives');
		if($(this).siblings('ul').css('display')=='none'){
			$(this).parent('li').siblings('li').removeClass('inactives');
			$(this).addClass('inactives');
			$(this).siblings('ul').slideDown(100).children('li');
			if($(this).parents('li').siblings('li').children('ul').css('display')=='block'){
				$(this).parents('li').siblings('li').children('ul').parent('li').children('a').removeClass('inactives');
				$(this).parents('li').siblings('li').children('ul').slideUp(100);

			}
		}else{
			//控制自身变成+号
			$(this).removeClass('inactives');
			//控制自身菜单下子菜单隐藏
			$(this).siblings('ul').slideUp(100);
			//控制自身子菜单变成+号
			$(this).siblings('ul').children('li').children('ul').parent('li').children('a').addClass('inactives');
			//控制自身菜单下子菜单隐藏
			$(this).siblings('ul').children('li').children('ul').slideUp(100);

			//控制同级菜单只保持一个是展开的（-号显示）
			$(this).siblings('ul').children('li').children('a').removeClass('inactives');
		}
	})
});
</script>
</head> 
<body class="bggray">
    <div class="category">
    <!-- insder header -->
    <div class="mainbox">
         <section>
              <div class="leftbox">
               	<ul class="yiji">
                    <li><a href="JavaScript:;" class="inactive">1.名义本金</a>
                        <ul style="display: none">
                            <li>
                            <a href="JavaScript:;" class=" active"><c:if test="${empty helpAppList.aboutus}">敬请期待</c:if><c:if test="${not empty helpAppList.aboutus}">${helpAppList.aboutus}</c:if> </a>
                            </li> 
                        </ul>
                    </li>
                    <li><a href="JavaScript:;" class="inactive">2.行权周期</a>
                        <ul style="display: none">
                            <li>
                            <a href="JavaScript:;" class=" active"><c:if test="${empty helpAppList.jylc}">敬请期待</c:if><c:if test="${not empty helpAppList.jylc}">${helpAppList.jylc}</c:if></a>
                            </li> 
                        </ul>
                    </li>
                    <li><a href="JavaScript:;" class="inactive">3.权利金比例</a>
                        <ul style="display: none">
                            <li>
                            <a href="JavaScript:;" class=" active"><c:if test="${empty helpAppList.pttd}">敬请期待</c:if><c:if test="${not empty helpAppList.pttd}">${helpAppList.pttd}</c:if></a>
                            </li> 
                        </ul>
                    </li>
                    <li><a href="JavaScript:;" class="inactive">4.到期日期</a>
                        <ul style="display: none">
                            <li>
                            <a href="JavaScript:;" class=" active"><c:if test="${empty helpAppList.sfbz}">敬请期待</c:if><c:if test="${not empty helpAppList.sfbz}">${helpAppList.sfbz}</c:if></a>
                            </li> 
                        </ul>
                    </li>
                     <li><a href="JavaScript:;" class="inactive">5.交易方式</a>
                        <ul style="display: none">
                            <li>
                            <a href="JavaScript:;" class=" active"><c:if test="${empty helpAppList.lybzj}">敬请期待</c:if><c:if test="${not empty helpAppList.lybzj}">${helpAppList.lybzj}</c:if></a>
                            </li> 
                        </ul>
                    </li>
                </ul>
        </section> 
  </div>
</body>
</html>