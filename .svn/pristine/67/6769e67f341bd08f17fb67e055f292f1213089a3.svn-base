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
    <header class="ls-header">
       <div class="ls-header-left">
            <a href="javascript:void(0)" onclick="zjmx()"><i class="iconfont icon-back"></i></a>
        </div>
        <div class="ls-header-title">帮助说明</div>
        <div class="ls-header-right">
           <a href="javascript:void(0)" onclick="helpCenter()"><i class="iconfont icon-flash"></i></a>
        </div>
    </header>
    <div class="mainbox">
         <section>
              <div class="leftbox">
               	<ul class="yiji">
                    <li><a href="JavaScript:;" class="inactive">1.名义本金</a>
                        <ul style="display: none">
                            <li>
                            <a href="JavaScript:;" class=" active"><c:if test="${empty helpList.aboutus}">敬请期待</c:if><c:if test="${not empty helpList.aboutus}">${helpList.aboutus}</c:if> </a>
                            </li> 
                        </ul>
                    </li>
                    <li><a href="JavaScript:;" class="inactive">2.行权周期</a>
                        <ul style="display: none">
                            <li>
                            <a href="JavaScript:;" class=" active"><c:if test="${empty helpList.jylc}">敬请期待</c:if><c:if test="${not empty helpList.jylc}">${helpList.jylc}</c:if></a>
                            </li> 
                        </ul>
                    </li>
                    <li><a href="JavaScript:;" class="inactive">3.权利金比例</a>
                        <ul style="display: none">
                            <li>
                            <a href="JavaScript:;" class=" active"><c:if test="${empty helpList.pttd}">敬请期待</c:if><c:if test="${not empty helpList.pttd}">${helpList.pttd}</c:if></a>
                            </li> 
                        </ul>
                    </li>
                    <li><a href="JavaScript:;" class="inactive">4.到期日期</a>
                        <ul style="display: none">
                            <li>
                            <a href="JavaScript:;" class=" active"><c:if test="${empty helpList.sfbz}">敬请期待</c:if><c:if test="${not empty helpList.sfbz}">${helpList.sfbz}</c:if></a>
                            </li> 
                        </ul>
                    </li>
                     <li><a href="JavaScript:;" class="inactive">5.交易方式</a>
                        <ul style="display: none">
                            <li>
                            <a href="JavaScript:;" class=" active"><c:if test="${empty helpList.lybzj}">敬请期待</c:if><c:if test="${not empty helpList.lybzj}">${helpList.lybzj}</c:if></a>
                            </li> 
                        </ul>
                    </li>
                </ul>
        </section> 
        <div class="homebottom">
         <ul>
              <li class="nav01" onclick="hangqing()">
                  <a href="javascript:;" >
                      <i></i>
                      <span >行情</span>
                  </a>
              </li>
              <li class="nav02" onclick="trader()">
                  <a href="javascript:;" >
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
              <li class="nav14" onclick="helpCenter()">
                  <a href="javascript:;" class="on" >
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