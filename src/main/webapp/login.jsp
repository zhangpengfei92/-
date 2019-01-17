<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
  	<jsp:include page="${path}/commons/commons.jsp"></jsp:include>

</head>

<body class="gray-bg">

    <div class="middle-box text-center loginscreen  animated fadeInDown">
        <div>
            <div>

                <h3 class="logo-name">瑞美</h3>

            </div>
            <h3>欢迎使用后台管理系统</h3>

            <form class="m-t" role="form" action="${path}/login/dologin"/>
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="用户名" required="">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="密码" required="">
                </div>
                <button type="submit" class="btn btn-primary block full-width m-b">登 录</button>


                <p class="text-muted text-center"> <a href="${path}/useraction/find`pwd"><small>忘记密码了？</small></a> | <a href="${path}/useraction/toRegister">注册一个新账号</a>
                </p>

            </form>
        </div>
    </div>

</body>

</html>