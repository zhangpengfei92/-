<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	//普通会员
	function commonMember() {
		var isadmin="${sessionScope.SESSION_ISADMIN}";
		isadmin=1+parseInt(isadmin);
		window.location.href = "${path}/fund/subzhList?isadmin="+isadmin;
	}
   //管理員列表
   function wardenList(){
	   window.location.href = "${path}/warden/jumpwardenList";
   }
   //权限管理
   function roleList(){
	   window.location.href = "${path}/warden/jumproleList";
   }
</script>
</head>
<body>
 	<div class="Lbox">
		<ul>
              <shiro:hasRole name="customer_user"><li id="left1"><a id="left_a_1" href="javascript:;" onclick="commonMember()"><span><img src="${path}/image/ltwo.png"/></span>账户列表</a></li></shiro:hasRole>
              <shiro:hasRole name="rights_manage"><li id="left2"><a id="left_a_2" href="javascript:;" onclick="roleList()"><span><img src="${path}/image/lthree.png"/></span>权限管理</a></li></shiro:hasRole>
              <shiro:hasRole name="sys_user"><li id="left3"><a id="left_a_3" href="javascript:;" onclick="wardenList()"><span><img src="${path}/image/lone.png"/></span>系统账户</a></li></shiro:hasRole>
              <%--<shiro:hasRole name="rolelist"><li id="left2"><a href="javascript:;" onclick="roleList()">系统角色</a></li></shiro:hasRole>--%>
          </ul>
	</div>
</body>
</html>