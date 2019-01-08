<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";%>
<!DOCTYPE html>
<html> 
<head>
	<base href="<%=basePath%>">
	<meta charset="utf-8">
	<title>万盛期宝</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" />
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta content="telephone=no" name="format-detection">
    <link href="css/h5/download.css" rel="stylesheet" type="text/css" />
    <link href="css/h5/animation.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
    <script src="js/All.js" type="text/javascript"></script>
    <script src="js/jquery1.42.min.js" type="text/javascript"></script>
    <script type="text/javascript">
	$(document).ready(function () {	
		$(".Downbox ul li").click(function(){
				var index=$(".Downbox ul li").index(this);
				$(this).addClass("selected hover").siblings().removeClass("selected hover");
				$(".Downbox .hide").eq(index).show().siblings(".Downbox .hide").hide();
		})
	});
	
	//下载app
	function giveAppVersion(filetype){
		//filetype;//0安卓，1IOS
		$.ajax({
			type: "POST",
			url: "${path }/user/pbMain!giveAppVersion.action",
			data:{"fundtype":filetype},
			dataType:"json",
			error: function(){
				layer.msg("error");
			},
			success: function(data) {
				if(data.status=='0'){
					var url=data.apacheUrl+data.results.filepath;
					window.location.href=url;
				}else{
					layer.msg("不能下载此app");
				}
			}
		
		});
	
	}
	</script>
</head> 
<body>
    <div class="category">
    <!-- insder header -->
    <header class="ls-header">
        <div class="ls-header-left">
            <a href="javascript:history.go(-1)"><i class="iconfont icon-back"></i></a>
        </div>
        <div class="ls-header-title">下载软件</div>
        <!--<div class="ls-header-right">
           <a href=""><i class="iconfont icon-flash"></i></a>
        </div>-->
    </header>
    <div class="mainbox">
        <section>
           <div class="Downbox">
               <ul class="tit">
                   <li class="selected">安卓版本</li>
                   <li>IOS版本</li>
               </ul>
               <div class="hide" style="display:block;">
                    <p class="ewm"><img src="images/h5/images/sq_qr.png"></p>
                    <a href="http://47.98.36.36/wsqb_download/wsqb.apk"><span><img src="images/h5/images/and.png"></span><em>立即下载</em></a>
               </div>
               <div class="hide" style="display:none;">
                    <p class="ewm"><img src="images/h5/images/iosw.png"></p>
                    <a class="Downbut" href="https://fir.im/5j3r"><span><img src="images/h5/images/apple.png"></span><em>立即下载</em></a>
               </div>
           </div> 
        </section>
    </div>
  </div>
</body>
</html>