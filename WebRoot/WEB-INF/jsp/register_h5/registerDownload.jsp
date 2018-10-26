<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<% String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta content="telephone=no" name="format-detection">
<link href="css/h5/css/css.css" rel="stylesheet" type="text/css" />
<link href="css/h5/css/animation.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/h5/js/jquery-1.9.1.min.js"></script>
<script src="js/h5/js/All.js" type="text/javascript"></script>
<script src="js/h5/js/swiper.min.js" type="text/javascript"></script>
<script src="js/layer/layer.js"></script>
<script type="text/javascript">
	//验证手机唯一
	function verifyPhone(phone){
		$.ajax({
			type : "POST",
			url : "app/verifyPhone",
			data : {
				"phone":phone
			},
			success : function(result){
				if(result != 'ok'){
					layer.msg(result);
					$("#phone").val("");
				}	
			}
		});
	}
	function deletePhone(){
		$("#phone").val("");
		return false;
	}
	function getCode(val){
		var phone = $("#phone").val().trim();
		if(phone.length == 0){
			layer.msg("请输入手机号");
			clearTimeout();
			return false;
		}else{
			$.ajax({
				type : "POST",
				url : "app/sendsms",
				data : {
					"phone":phone
				},
				success : function(result){
					if(result == 'ok'){
						settime(val);
					}else{
						layer.msg(result);
					}
				}
			});
		}
	}
	var countdown=60; 
	function settime(val) {  
		if (countdown == 0) {  
		    val.removeAttribute("disabled");  
		    val.value="获取验证码";  
		    countdown = 60;  
		} else {  
		    val.setAttribute("disabled", true);  
		    val.value="重新发送(" + countdown + ")";  
		    countdown--;  
		   t = setTimeout(function() {  
		        settime(val)  
		    },1000);
		}  
	}
	var objData = {};
	<c:if test="${!empty subzh.allocchannel}">
		objData.allocchannel = '${subzh.allocchannel}';
	</c:if>
	<c:if test="${!empty subzh.allocbroker}">
		objData.allocbroker = '${subzh.allocbroker}';
	</c:if>
	<c:if test="${!empty subzh.allocagent}">
		objData.allocagent = '${subzh.allocagent}';
	</c:if>
	<c:if test="${!empty subzh.allocpt}">
		objData.allocpt = '${subzh.allocpt}';
	</c:if>
	<c:if test="${!empty subzh.manage}">
		objData.manage = '${subzh.manage}';
	</c:if>
	<c:if test="${!empty subzh.pagentzh}">
		objData.pagentzh = '${subzh.pagentzh}';
	</c:if>
	function register(){
		var code = $("#code").val().trim();
		var password = $("#password").val().trim();
		var affirmPassword = $("#affirmPassword").val().trim();
		/* var inviteCode = $("#inviteCode").val().trim(); */
		if($("#phone").val().trim().length == 0){
			layer.msg("请输入手机号");
			return false;
		}	
		if(code.length == 0){
			layer.msg("请输入验证码");
			return false;
		}
		if(password.length == 0){
			layer.msg("请输入密码");
			return false;
		}
		if(affirmPassword.length == 0){
			layer.msg("请输入确认密码");
			return false;
		}
		if(password != affirmPassword){
			layer.msg("密码与确认密码不一致");
			return false;
		}
		objData.code = code;
		objData.password = password;
		objData.affirmPasswors = affirmPassword;
		objData.phone = $("#phone").val().trim();
		/* objData.inviteCode = inviteCode; */
		$.ajax({
			type : "POST",
			url : "app/reg",
			data : objData,
			success : function(result){
				if(result == 'ok'){
					window.location.href = "app/downloadPage";
					//layer.msg("注册成功！");
				}else{
					layer.msg(result);
				}
			}
		});
	}
	 function checkClick(){
		 if($("input[type='checkbox']:checked").length > 0){//被选中状态
			 $("input[type='checkbox']").attr("checked",true);
			 $("#btn_register").attr("disabled",false);
			 $("#btn_register").attr("class","Suc yellow");
		 }else{
			 $("input[type='checkbox']").attr("checked",false);
			 $("#btn_register").attr("disabled",true);
			 $("#btn_register").attr("class","Suc");
		 }
	 }
	 
	 function clause(){
		 layer.open({  
	            type : 2,  
	            title : "应用服务条款",  
	            shadeClose : true,  
	            shade : 0.8,  
	            area : [ '100%', '100%' ],  
	            fix : true,  
	            maxmin : false,  
	            content : "app/getRegisterProtocol",  
	            /*btn : ['确定'],
	            yes : function(index, layero){
	            	var body = layer.getChildFrame('body', index);
	            	var id = body.find("input[type='radio']:checked").val();
	            	 objData.id = id;
	            	$.ajax({
	            		type : "POST",
	            		url : "mall/takeAddress",
	            		data : {
	            			"id" : id
	            		},
	            		success : function(result){
	            			$("#take_address").html(result);
	            			layer.close(index);
	            		} 
	            	});
	            }*/
	        });
	 }
</script>
</head>
<body class="bgray">
	<div class="tk">
		<div class="swiper-container">
			<div class="swiper-wrapper">
				<div class="swiper-slide">
					<div class="category">
						<!-- insder header -->
						<header class="ls-header">
						<div class="ls-header-left">
							<a href="javascript:;"><i class="iconfont icon-close"></i></a>
						</div>
						<div class="ls-header-title"></div>
						<!--<div class="ls-header-right">
                           <a href=""><i class="iconfont icon-flash"></i></a>
                        </div>--> </header>
						<div class="mainbox">
							<section>
							<div class="regbox">
								<h3>
									<em style="width: 20%; padding: 5rem 40% 3rem;"><img src="images/h5/images/sqicon.png" /></em>
								</h3>
								<ul class="reg">
									<li><span>手机号</span> 
									<input type="text" placeholder="请输入手机号" onchange="verifyPhone(this.value)" name="phone" id="phone"> 
										<em><img src="images/h5/images/shanchu.png" onclick="deletePhone()"></em></li>
									<li><span>验证码</span> <input type="text" id="code"  placeholder="请输入验证码"> 
									<em class="Get"><input type="button" value="获取验证码" onclick="getCode(this)"/></em></li>
									<li><span>设置密码</span>
									 <input type="password" id="password" placeholder="请输入密码"></li>
									<li><span>确认密码</span> 
									<input type="password" id="affirmPassword" placeholder="请确认密码"></li>
									<!-- <li><span>邀请码</span> 
									<input type="text" id="inviteCode" placeholder="请输入邀请码"></li> -->
									<!-- <li>
										<p>
											渠道<i>(选填项)</i>
										</p>
										<div class="selectone">
											<select>
												<option>金策略渠道</option>
												<option>金策略渠道</option>
											</select>
										</div>
										<div class="selectone">
											<select>
												<option>金策略经纪人</option>
												<option>金策略经纪人</option>
											</select>
										</div>
									</li> -->
									<!--<li>
                                     <span>渠道</span>
                                     <input type="text" value="316" style="width:26%;">
                                     <em style="float:left;"><img src="images/Next1.png"></em>
                                     <input type="text" value="316" style="width:26%;">
                                     <em><img src="images/Next1.png"></em>
                                  </li>-->
								</ul>
							</div>
							<button class="Suc" disabled="disabled" id="btn_register" onclick="register()">立即注册</button>
							<p class="Tk">
								<input type="checkbox" onclick="checkClick()">&nbsp;新用户注册完成即同意<a href="javascript:;" onclick="clause()">应用服务条款</a>
							</p>
							<!-- <p class="downts">
								<img src="images/zh.png" />
							</p>
							<button class="Suc yellow">立即下载</button>
							</section> -->
						</div>
					</div>
				</div>
				<!-- Add Scroll Bar -->
				<div class="swiper-scrollbar"></div>
			</div>
		</div>
		<script>
			$('.tk').on('touchmove ', function(event) {
				event.preventDefault();
			});
			var swiper = new Swiper('.swiper-container', {
				direction : 'vertical',
				slidesPerView : 'auto',
				freeMode : true,
				scrollbar : '.swiper-scrollbar',
				mousewheel : true,
			});
			
		</script>
</body>
</html>