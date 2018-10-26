<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="../../../head.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>忘记密码</title>
</head>
<script type="text/javascript">

</script>
<body class="gray">
    <div class="category">
    <!-- insder header -->
    <header class="ls-header">
        <div class="ls-header-left">
            <a href="javascript:history.go(-1)"><i class="iconfont icon-back"></i></a>
        </div>
        <div class="ls-header-title">忘记密码</div>
        <!--<div class="ls-header-right">
           <a href=""><i class="iconfont icon-flash"></i></a>
        </div>-->
    </header>
    <div class="mainbox">
        <section>
           <div class="Caccount">
              <ul>
                <li>
                   <span class="Swidth">新密码</span>
                   <p style="float:left;"><input value="155****1230"type="text" style="width:60%;text-align:left;"><span class="Get">获取验证码</span></p>
                </li>
                <li>
                   <span class="Swidth">确认密码</span>
                   <p style="float:left;"><input placeholder="请输入短信验证码"  type="text" style="width:80%;text-align:left;"></p>
                </li>
              </ul>
           </div>
           <p class="Qus"><a href="javascript:;">手机无法接收短信？</a></p>
           <button class="Suc">下一步</button>
        </section>
  </div>
</body>
</html>