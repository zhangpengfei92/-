<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html manifest="/manifest.appcache" xmlns="http://www.w3.org/1999/xhtml">
<head><meta charset="utf-8" />
<title>注册</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="${path}/js/jquery/jquery-1.7.1.js"></script>
<script type="text/javascript" src="${path}/js/jquery/jquery.validator.js"></script>
<script type="text/javascript" src="${path}/js/jquery/jquery.corners.min.js"></script>
<script src="${path}/js/layer/layer/layer.js"></script>
<style type="text/css">
	.errorTip{background-image:url(${themePath}/images/access_disallow.gif);background-repeat:no-repeat;padding-left:16px;color:Red;}
	.errorInput{background-color:#FFCC33;}
	#regtop { position:relative; margin:0; width:569; height:86; background-image:url(${themePath}/images/regtop.jpg); background-repeat:no-repeat;}
	#regmiddle { position:relative; margin:0; width:569; height:248; overflow:hidden; background-image:url(${themePath}/images/regmiddle.jpg); background-repeat:no-repeat;}
	#regbottom { position:relative; margin:0; width:569; height:36; background-image:url(${themePath}/images/regbottom.jpg); background-repeat:no-repeat;}
	
	
	.bodydiv{ width:640px; height:440px; margin:0px; padding:0px; overflow:hidden; background-image:url(${themePath}/images/reg_bg.png); background-position:center center ; background-repeat:no-repeat;}
	.closediv { width:50px; height:24px; float:right; overflow:hidden; text-align:right;}
	.min{ width:10px; height:10px; float:left; padding:0px; margin-left:5px; margin-top:10px; overflow:hidden;}
	.min img { width:10px; height:10px; margin:0px; padding:0xp;}
	.close{ width:10px; height:10px; float:left; padding:0px; margin-left:15px; margin-top:10px;overflow:hidden; }
	.close img { width:10px; height:10px; margin:0px; padding:0xp;}
	.getregdiv{  width:69px; height:25px; margin-top: 2px;}
	.authcodeDiv{ position: absolute;left: 189px;}
	
	.reginfodiv{ width:500px; height:295px; float:left; margin-top:80px; margin-left:122px;  padding:0px; overflow:hidden;position: relative;}
	.reginfoL{ width:262px; height:295px; float:left; margin:0px; padding:0px; overflow:hidden;}
	.reginfoR{ width:238px; height:280px; float:left; margin:0px; padding:0px; overflow:hidden;}
	
	.reginfolinediv{ width:262px; height:42px; margin:0px; padding:0px; text-align:left; overflow:hidden;}
	.infotittlediv{ width:83px; height:28px; margin-top:0px; padding:0px; float:left; text-align:right;}
	.infotittlefont{font-family:'宋体'; font-size:14px; line-height:26px;  color:#000000;margin-top: 10px;}
	.inputdiv2 { width:178px; height:28px;margin:0px; padding:0px; text-align:left; overflow:hidden; float:left;}
	.input_bg { width:173px; height:26px; margin-left:2px; margin-top:1px; padding:0px,0px,0px,30px; text-align:left; border:0px; background-image:url(${themePath}/images/but_bg.png);background-position:center center ; background-repeat:no-repeat;}
	.input_bg1 { width:173px; height:26px; margin-left:2px; margin-top:1px; padding:0px,0px,0px,30px; text-align:left; border:0px; background-image:url(${themePath}/images/but_bg1.png);background-position:center center ; background-repeat:no-repeat;}
	.input_bg2 { width:173px; height:26px; margin-left:2px; margin-top:1px; padding:0px,0px,0px,30px; text-align:left; border:0px; background-image:url(${themePath}/images/but_bg2.png);background-position:center center ; background-repeat:no-repeat;}
	.input_bg3 { width:173px; height:26px; margin-left:2px; margin-top:1px; padding:0px,0px,0px,30px; text-align:left; border:0px; background-image:url(${themePath}/images/but_bg3.png);background-position:center center ; background-repeat:no-repeat;}
	.input_bg4 { width:173px; height:26px; margin-left:2px; margin-top:1px; padding:0px,0px,0px,30px; text-align:left; border:0px; background-image:url(${themePath}/images/but_bg4.png);background-position:center center ; background-repeat:no-repeat;}
	.input_bg5 { width:173px; height:26px; margin-left:2px; margin-top:1px; padding:0px,0px,0px,30px; text-align:left; border:0px; background-image:url(${themePath}/images/but_bg5.png);background-position:center center ; background-repeat:no-repeat;}
	.error1div{  width:202px; height:52px; position:absolute; margin-top:-14px; padding:0px; overflow:hidden; text-align:left; background-image:url(${themePath}/images/alert2div_bg.png);background-position:center center ; background-repeat:no-repeat;font-size:12px; line-height:12px; color:#CD3700; }
	.error1msg{  width:160px; height:43px; position:absolute; margin-top:10px;margin-left:20px; padding:0px; overflow:hidden; text-align:left; font-size:12px;  color:#CD3700; }
	.error2div{  width:202px; height:39px; position:absolute;  margin-top:52px;padding:0px;overflow:hidden; text-align:left; background-image:url(${themePath}/images/alert2div_bg.png);background-position:center center ; background-repeat:no-repeat; font-size:12px; line-height:18px; color:#CD3700; }
	.error2msg{  width:160px; height:43px; position:absolute; margin-top:56px;margin-left:20px; padding:0px; overflow:hidden; text-align:left; font-size:12px;  color:#CD3700; }
	.error3div{  width:202px; height:39px;  position:absolute; margin-top:102px; padding:0px;overflow:hidden; text-align:left;  background-image:url(${themePath}/images/alert2div_bg.png);background-position:center center ; background-repeat:no-repeat;font-size:12px; line-height:18px; color:#CD3700; }
	.error3msg{  width:160px; height:43px; position:absolute; margin-top:108px;margin-left:20px; padding:0px; overflow:hidden; text-align:left; font-size:12px;  color:#CD3700; }
	.error4div{  width:202px; height:52px;  position:absolute; margin-top:150px; padding:0px;overflow:hidden; text-align:left;  background-image:url(${themePath}/images/alert2div_bg.png);background-position:center center ; background-repeat:no-repeat; font-size:12px; line-height:18px; color:#CD3700; }
	.error4msg{  width:160px; height:40px; position:absolute; margin-top:160px;margin-left:20px; padding:0px; overflow:hidden; text-align:left; font-size:12px;  color:#CD3700; }
	.error5div{  width:202px; height:52px;  position:absolute; margin-top:196px; padding:0px;overflow:hidden; text-align:left;  background-image:url(${themePath}/images/alert2div_bg.png);background-position:center center ; background-repeat:no-repeat; font-size:12px; line-height:18px; color:#CD3700; }
	.error5msg{  width:160px; height:40px; position:absolute; margin-top:212px;margin-left:20px; padding:0px; overflow:hidden; text-align:left; font-size:12px;  color:#CD3700; }
	
	.alert1div{  width:202px; height:39px; position:absolute; margin-top:-2px; padding:0px; overflow:hidden; text-align:left; background-image:url(${themePath}/images/error1div_bg.png);background-position:center center ; background-repeat:no-repeat;font-size:12px; line-height:12px; color:#CD3700; }
	.alert1msg{  width:160px; height:43px; position:absolute; margin-top:5px;margin-left:20px; padding:0px; overflow:hidden; text-align:left; font-size:12px;  color:#CD3700; }
	.alert2div{  width:202px; height:39px; position:absolute;  margin-top:52px;padding:0px;overflow:hidden; text-align:left; background-image:url(${themePath}/images/error2div_bg.png);background-position:center center ; background-repeat:no-repeat; font-size:12px; line-height:18px; color:#CD3700; }
	.alert2msg{  width:160px; height:43px; position:absolute; margin-top:56px;margin-left:20px; padding:0px; overflow:hidden; text-align:left; font-size:12px;  color:#CD3700; }
	.alert3div{  width:202px; height:31px;  position:absolute; margin-top:102px; padding:0px;overflow:hidden; text-align:left;  background-image:url(${themePath}/images/error3div_bg.png);background-position:center center ; background-repeat:no-repeat;font-size:12px; line-height:18px; color:#CD3700; }
	.alert3msg{  width:160px; height:25px; position:absolute; margin-top:108px;margin-left:20px; padding:0px; overflow:hidden; text-align:left; font-size:12px;  color:#CD3700; }
	.alert4div{  width:202px; height:52px;  position:absolute; margin-top:150px; padding:0px;overflow:hidden; text-align:left;  background-image:url(${themePath}/images/error2div_bg.png);background-position:center center ; background-repeat:no-repeat; font-size:12px; line-height:18px; color:#CD3700; }
	.alert4msg{  width:160px; height:40px; position:absolute; margin-top:160px;margin-left:20px; padding:0px; overflow:hidden; text-align:left; font-size:12px;  color:#CD3700; }
	.alert5div{  width:202px; height:52px;  position:absolute; margin-top:198px; padding:0px;overflow:hidden; text-align:left;  background-image:url(${themePath}/images/error3div_bg.png);background-position:center center ; background-repeat:no-repeat; font-size:12px; line-height:18px; color:#CD3700; }
	.alert5msg{  width:160px; height:40px; position:absolute; margin-top:212px;margin-left:20px; padding:0px; overflow:hidden; text-align:left; font-size:12px;  color:#CD3700; }
	.reggddiv{ width:350px; height:40px; margin-left:86px; padding:0px; text-align:left; overflow:hidden;}
	.regbtndiv{ width:340px; height:38px; margin-left:84px; padding:0px; text-align:left;}

	html{overflow:hidden;}
</style>
    <script type="text/javascript">
	    try {
	    	window.external.RegisterBackfunction("cmd_resizepopup", "642", "445");
		} catch (e){ }
		
        function getQueryString(name) {
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
            var r = window.location.search.substr(1).match(reg);
            if (r != null) return unescape(r[2]); return null;
        }
        var channelpk = "";
        $(document).ready(function () {
            var pk = getQueryString("pkid");
            if (pk != null && pk != "") {
                channelpk = pk;
            }
        });
        function isMobel(value) {
            if (/^13\d{9}$/g.test(value) || (/^14[0-9]\d{8}$/g.test(value)) || (/^15[0-9]\d{8}$/g.test(value)) || (/^17[0-9]\d{8}$/g.test(value)) || (/^18[0-9]\d{8}$/g.test(value))) {
                return true;
            } else {
                return false;
            }
        }
        function funcChina(obj) {
            if (/.*[\u4e00-\u9fa5]+.*$/.test(obj)) {
                return false;
            }
            return true;
        }
        //发送短信
        var sec;
	    var wait;
        function sendMessage() {
        	var ps = $("#phone").val();
            if (ps == "" || !isMobel(ps)) {
            	$("#error4msg").html('请输入正确的手机号');
                $("#error4msg").css("display", "block");
                $("#errormsg4").css("display", "block");
                return false;
            } else {
                $.ajax({
                    type: "POST",
                    url: '${path}/user/user!isExistsPhone.action',
                    async: false,
                    data: { phoneNumber: ps },
                    success: function (data) {
                        if (data == "true") {
                            $("#error4msg").html('该手机号已被注册，请勿重复注册！');
                            $("#errormsg4").css("display", "block");
                            $("#error4msg").css("display", "block");
                            return false;
                        } else {
                        	$.ajax({
                                type: "POST",
                                url: '${path}/user/user!getMessageByPhone.action',
                                async: false,
                                data: { phoneNumber: ps },
                                success: function (data) {
                                    if (data == "true") {
                                        //none
                                    } else {
                                    	$("#error4msg").html('发送短信异常，请联系管理员！');
                                        $("#errormsg4").css("display", "block");
                                        $("#error4msg").css("display", "block");
                                    }
                                }
                            });
                        }
                    }
                });
            	//$.get("${path}/user/user!getMessageByPhone.action?phoneNumber=" + ps);
            	sec = 60;
                wait = sec * 1000;
                $("input#getchk").get(0).value = "确认中[" + sec + "]";
                $("input#getchk").get(0).disabled = true;

                for (var i = 0; i <= sec; i++) {
                    window.setTimeout("TimeUpdate(" + i + ")", i * 1000);
                }
                window.setTimeout("TimeOk()", wait);
            }
        }
        function TimeOk() {
	        $("input#getchk").get(0).value = "获取验证码";
	        $("input#getchk").get(0).disabled = false;
	    }
        function TimeUpdate(num) {
	        if (num != sec) {
	            var pntNum = (wait / 1000) - num;
	            $("input#getchk").get(0).value = "确认中[" + pntNum + "]";
	        }
	    }
        function formcheck() {
        	
            $("#errormsg1").css("display", "none");
            $("#error1msg").css("display", "none");
            $("#errormsg2").css("display", "none");
            $("#error2msg").css("display", "none");
            $("#errormsg3").css("display", "none");
            $("#error3msg").css("display", "none");
            $("#errormsg4").css("display", "none");
            $("#error4msg").css("display", "none");
            $("#alertmsg1").css("display", "none");
            $("#alert1msg").css("display", "none");
            $("#alertmsg2").css("display", "none");
            $("#alert2msg").css("display", "none");
            $("#alertmsg3").css("display", "none");
            $("#alert3msg").css("display", "none");
            $("#alertmsg4").css("display", "none");
            $("#alert4msg").css("display", "none");
            var username = $("#phone").val();
            var reg = false;
            if($("input[type='checkbox']:checked").length != 2){
        		$("#error6msg").html('请确认勾选注册协议');
                $("#errormsg6").css("display", "block");
                $("#error6msg").css("display", "block");
                reg = true;
                return false;
        	}
            //if (username.length < 1 || username.length > 14 || !funcChina(username)) {
            //    $("#error1msg").html('请输入正确的用户名');
            //    $("#error1msg").css("display", "block");
            //    $("#errormsg1").css("display", "block");
            //    return false;
            //}
            $("#error2msg").css("display", "block");
            $("#errormsg2").css("display", "block");
            var pwd = $("#pwd").val();
            if (pwd.length < 6 || pwd.length > 18) {
                $("#error2msg").html('请输入6至18位字符（0-9a-zA-Z）');
                $("#error2msg").css("display", "block");
                $("#errormsg2").css("display", "block");
                return false;
            }
            $("#error2msg").css("display", "none");
            $("#errormsg2").css("display", "none");
            $("#error3msg").css("display", "block");
            $("#errormsg3").css("display", "block");
            var repwd = $("#repwd").val();
            if (repwd != pwd) {
                $("#error3msg").html('两次输入密码必须一致');
                $("#errormsg3").css("display", "block");
                $("#error3msg").css("display", "block");
                return false;
            }
            $("#error3msg").css("display", "none");
            $("#errormsg3").css("display", "none");
            var phone = $("#phone").val();
            if (phone != "") {
                if (!isMobel(phone)) {
                    $("#error4msg").html('请输入11位正确手机号码');
                    $("#errormsg4").css("display", "block");
                    $("#error4msg").css("display", "block");
                    return false;
                }
            }
            if (phone != "") {
                $.ajax({
                    type: "POST",
                    url: '${path}/user/user!isExistsPhone.action',
                    async: false,
                    data: { phoneNumber: phone },
                    success: function (data) {
                        if (data == "true") {
                            $("#error4msg").html('该手机号已被注册，请勿重复注册！');
                            $("#errormsg4").css("display", "block");
                            $("#error4msg").css("display", "block");
                            reg = true;
                        }
                    }
                });
                $.ajax({
                	type: "POST",
                    url: '${path}/user/user!isExistsUserName.action',
                    async: false,
                    data: { userName: phone },
                    success: function (data) {
                        if (data == "true") {
                        	 $("#error4msg").html('该手机号已存在，请重新输入。');
                             $("#errormsg4").css("display", "block");
                             $("#error4msg").css("display", "block");
                            reg = true;
                        }
                    }
                });
            }
            var authCode = $("#authCode").val();//验证码
            if (authCode == "" || authCode == null) {
                $("#error5msg").css("display", "block");
                $("#errormsg5").css("display", "block");
            }
            var inviteCode = $("#inviteCode").val();//验证码
            if (inviteCode == "" || inviteCode == null) {
                $("#error6msg").css("display", "block");
                $("#errormsg6").css("display", "block");
            }
            if (!reg) {
            	var channel = $("#qudao2").val();
            	var jinjiren = $("#jinjiren").val();
                $("#errormsg4").css("display", "none");
                $("#error4msg").css("display", "none");
                $.ajax({
                    type: "POST",
                    url: '${path}/user/user!saveRegister.action',
                    async: false,
                    data: { 
                    	userName: phone, 
                    	newPwd: pwd, 
                    	phoneNumber: phone,
                    	allocchannel : channel,
						allocbroker : jinjiren,
                    	authCode: authCode,
                    	inviteCode: inviteCode
                    },
                    success: function (data) {
                        if (data == "OK") {
                            alert("注册成功。");
                            window.external.RegisterBackfunction("cmd_registerback", username, pwd);
                            external.Close();
                        } else if(data == "false"){
                        	$("#error5msg").html('请输入正确的验证码！');
                            $("#errormsg5").css("display", "block");
                            $("#error5msg").css("display", "block");
                        } else if(data == "isExist"){
                       	  	$("#error1msg").html('用户名已存在，请重新输入。');
                            $("#error1msg").css("display", "block");
                            $("#errormsg1").css("display", "block");
                        } else if ("the phone is exist!"){
                        	$("#error1msg").html('手机号已存在，请重新输入。');
                            $("#error1msg").css("display", "block");
                            $("#errormsg1").css("display", "block");
                        } else if ("inviteCode is not exist!"){
                        	$("#error6msg").html('邀请码不存在，请重新输入。');
                            $("#error6msg").css("display", "block");
                            $("#errormsg6").css("display", "block");
                        }
                        else {
                            alert("注册失败。");
                        }
                    }
                });
            }

        }

        function focusUser(num) {
            $("#alert1msg").css("display", "none");
            $("#alert2msg").css("display", "none");
            $("#alert3msg").css("display", "none");
            $("#alert4msg").css("display", "none");
            if (num == 1) {
                $("#errormsg1").css("display", "none");
                $("#error1msg").css("display", "none");
                $("#alertmsg1").css("display", "block");
                $("#alert1msg").css("display", "block");
            }
            else if (num == 2) {
                $("#errormsg2").css("display", "none");
                $("#error2msg").css("display", "none");
                $("#alertmsg2").css("display", "block");
                $("#alert2msg").css("display", "block");
            }
            else if (num == 3) {
                $("#errormsg3").css("display", "none");
                $("#error3msg").css("display", "none");
                $("#alertmsg3").css("display", "block");
                $("#alert3msg").css("display", "block");
            }
            else if (num == 4) {
                $("#errormsg4").css("display", "none");
                $("#error4msg").css("display", "none");
                $("#alertmsg4").css("display", "block");
                $("#alert4msg").css("display", "block");
            }else if (num == 5) {
                $("#errormsg5").css("display", "none");
                $("#error5msg").css("display", "none");
                $("#alertmsg5").css("display", "block");
                $("#alert5msg").css("display", "block");
            }else if (num == 6) {
                $("#errormsg6").css("display", "none");
                $("#error6msg").css("display", "none");
                $("#alertmsg6").css("display", "block");
                $("#alert6msg").css("display", "block");
            }
        }

        function CheckUser(num) {
            $("#errormsg1").css("display", "none");
            $("#error1msg").css("display", "none");
            $("#errormsg2").css("display", "none");
            $("#error2msg").css("display", "none");
            $("#errormsg3").css("display", "none");
            $("#error3msg").css("display", "none");
            $("#errormsg4").css("display", "none");
            $("#error4msg").css("display", "none");
            $("#alertmsg1").css("display", "none");
            $("#alert1msg").css("display", "none");
            $("#alertmsg2").css("display", "none");
            $("#alert2msg").css("display", "none");
            $("#alertmsg3").css("display", "none");
            $("#alert3msg").css("display", "none");
            $("#alertmsg4").css("display", "none");
            $("#alert4msg").css("display", "none");
            $("#errormsg5").css("display", "none");
            $("#error5msg").css("display", "none");
            $("#alertmsg5").css("display", "none");
            $("#alert5msg").css("display", "none");
            $("#errormsg6").css("display", "none");
            $("#error6msg").css("display", "none");
            $("#alertmsg6").css("display", "none");
            $("#alert6msg").css("display", "none");
            var username = $("#username").val();
            var pwd = $("#pwd").val();
            var repwd = $("#repwd").val();
            var phone = $("#phone").val();
            var authCode = $("#authCode").val();
            var inviteCode = $("#inviteCode").val();
            if (num == 1) {
                
                var reg = false;
                if (username.length < 1 || username.length > 14 || !funcChina(username)) {
                    $("#error1msg").html('请输入正确的用户名');
                    $("#error1msg").css("display", "block");
                    $("#errormsg1").css("display", "block");
                    return false;
                }
                $.ajax({
                	type: "POST",
                    url: '${path}/user/user!isExistsUserName.action',
                    async: false,
                    data: { userName: username },
                    success: function (data) {
                        if (data == "true") {
                            reg = true;
                        }
                    }
                });
                if (reg) {
                    $("#error1msg").html('用户名已存在，请重新输入。');
                    $("#error1msg").css("display", "block");
                    $("#errormsg1").css("display", "block");
                    return false;
                }
            } else if (num == 2) {
                
                if (pwd.length < 6 || pwd.length > 18) {
                    $("#error2msg").html('密码只允许0-9a-zA-Z');
                    $("#error2msg").css("display", "block");
                    $("#errormsg2").css("display", "block");
                    return false;
                }
            } else if (num == 3) {
                
                if (repwd != pwd) {
                    $("#error3msg").html('请再输入一次上面输入的密码');
                    $("#errormsg3").css("display", "block");
                    $("#error3msg").css("display", "block");
                    return false;
                }
            } else if (num == 4) {
                
                if (phone != "") {
                    if (!isMobel(phone)) {
                        $("#error4msg").html('请输入11位正确手机号码');
                        $("#errormsg4").css("display", "block");
                        $("#error4msg").css("display", "block");
                        return false;
                    } else {
                        $("#errormsg4").css("display", "none");
                        $("#error4msg").css("display", "none");
                    }
                }
                if (phone != "") {
                    $.ajax({
                    	type: "POST",
                        url: '${path}/user/user!isExistsPhone.action',
                        async: false,
                        data: { phoneNumber: phone },
                        success: function (data) {
                            if (data == "true") {
                                reg = true;
                            }
                        }
                    });
                }
                if (reg) {
                    $("#error4msg").html('该手机号已被注册！');
                    $("#errormsg4").css("display", "block");
                    $("#error4msg").css("display", "block");
                    return false;
                }
            } else if (num == 5) {
                if (authCode == "" || authCode == null) {
                    $("#error5msg").html('请输入验证码');
                    $("#errormsg5").css("display", "block");
                    $("#error5msg").css("display", "block");
                    return false;
                }
            } else if (num == 6) {
                if (inviteCode == "" || inviteCode == null) {
                    $("#error6msg").html('请输入邀请码');
                    $("#errormsg6").css("display", "block");
                    $("#error6msg").css("display", "block");
                    return false;
                }
            } 
        }
        
        function checkClick(){
	   		 if($("input[type='checkbox']:checked").length > 1){//被选中状态
	   			 $("input[type='checkbox']").attr("checked",true);
	   		 }else{
	   			 $("input[type='checkbox']").attr("checked",false);
	   		 }
   	 	}
        
        function clause(){
   		 layer.open({  
   	            type : 2,  
   	            title : "注册协议",  
   	            shadeClose : true,  
   	            shade : 0.8,  
   	            area : [ '100%', '100%' ],  
   	            fix : true,  
   	            maxmin : false,  
   	            content : "http://web.gjqh.jclkj.cn/ctpsubcms/app/getRegisterProtocol",  
   	           
   	        });
   	 }
</script>
</head>

<body style="margin:0px;">
  <div class="bodydiv">
  	<a target="_blank" href="http://shang.qq.com/wpa/qunwpa?idkey=0a60e0df8e45ad9841f80158b7c8eef67080086eb833b8c8d0c24b526e2d4176"><div class="yzmdiv"></div></a>
    <div class="closediv">
    </div>
    <div class="reginfodiv">
      <div class="reginfoL">
      <%--<div class="reginfolinediv">
            <div class="infotittlediv">
                <span class="infotittlefont">注册帐号：</span>
            </div>
            <div class="inputdiv2">
                <input id="username" type="text" name="username" class="input_bg1 infotittlefont" maxlength="14" onfocus="focusUser(1);" onblur="CheckUser(1);" style="text-indent:26px;float:left;"/>
            </div>
      </div>--%>
      <div class="reginfolinediv">
            <div class="infotittlediv">
                <span class="infotittlefont">手机号码：</span>
            </div>
            <div class="inputdiv2">
                <input id="phone" type="text" name="phone" class="input_bg4 infotittlefont" maxlength="11" onfocus="focusUser(4);" onblur="CheckUser(4);" style="text-indent:26px;float:left;"/>
            </div>
      </div>
      <div class="reginfolinediv">
            <div class="infotittlediv">
                <span class="infotittlefont">密&nbsp;&nbsp;码：</span>
            </div>
            <div class="inputdiv2">
                <input id="pwd" type="password" class="input_bg2 infotittlefont" name="pwd" 
                    value=""  onfocus="focusUser(2);" onblur="CheckUser(2);" style="text-indent:26px;float:left;font-size:10px;"/>
            </div>

      </div>
      <div class="reginfolinediv">
            <div class="infotittlediv">
                <span class="infotittlefont">确认密码：</span>
            </div>
            <div class="inputdiv2">
                <input id="repwd" type="password" class="input_bg3 infotittlefont" value=""
                      onfocus="focusUser(3);" onblur="CheckUser(3);" style="text-indent:26px;float:left;font-size:10px;"/>
            </div>
            
      </div>
      <%--<div class="reginfolinediv">
            <div class="infotittlediv">
                <span class="infotittlefont">手机号码：</span>
            </div>
            <div class="inputdiv2">
                <input id="phone" type="text" name="phone" class="input_bg4 infotittlefont" maxlength="11" onfocus="focusUser(4);" onblur="CheckUser(4);" style="text-indent:26px;float:left;"/>
            </div>
      </div>--%>
      <div class="reginfolinediv">
            <div class="infotittlediv">
                <span class="infotittlefont">验 证 码：</span>
            </div>
            <div class="inputdiv2">
                <input id="authCode" type="text" name="authCode" class="input_bg5 infotittlefont" maxlength="10" onfocus="focusUser(5);" onblur="CheckUser(5);" style="text-indent:26px;float:left;width:99px;"/>
            </div>
            <div class="authcodeDiv">
            	<input class="getregdiv" style="background-color:#7d7d7d; border:0; color:White; line-height:25px; text-align:center; font-size:13px; padding:0px; cursor:pointer;" id="getchk" value="获取验证码" onclick="sendMessage();"/>
            </div>
      </div>
      <div class="reginfolinediv">
            <div class="infotittlediv">
                <span class="infotittlefont">邀 请 码：</span>
            </div>
            <div class="inputdiv2">
                <input id="inviteCode" type="text" name="inviteCode" class="input_bg4 infotittlefont" maxlength="10" onfocus="focusUser(6);" onblur="CheckUser(6);" style="text-indent:26px;float:left;"/>
            </div>
      </div>
      <div class="reginfolinediv" style="display:none;">
            <div class="infotittlediv">
                <span class="infotittlefont">渠&nbsp;&nbsp;道：</span>
            </div>
            <select id="qudao2" onchange="getBrokers(this.value)" style="background:#0c0c0c;color:#fff;width:25%;height: 2.0rem;">
            	<c:forEach var="item" items="${channelList }">
            		<option value="${item.channelid }">${item.cname }-${item.channelno }</option>
            	</c:forEach>
            </select><em style="float:left;"><img src="${path}/images/Next1.png"></em>
            
            <select id="jinjiren"  style="background:#0c0c0c;color:#fff;width:25%;height: 2.0rem;">
            	<c:forEach var="item" items="${brokerlist }">
            		<option value="${item.brokerid }">${item.cname }-${item.brokerno }</option>
            	</c:forEach>
            </select><em><img src="${path}/images/Next1.png"></em>
      </div>
      
      <div class="reggddiv infotittlefont" style="display:none;">
      	<input type="checkbox" checked="checked" id="chkmsg" />是否接收高端信息</div>
        <input id="ismsg" type="hidden" value="1" name="ismsg" />
      <div class="regbtndiv" style="margin-left: 20px">
      	<input type="checkbox" onclick="checkClick()"><span>新用户注册完成即同意</span><a href="javascript:;" onclick="clause()" style="color: red;">注册协议</a>
      </div>
      <div class="regbtndiv">
        <input id="from" type="hidden" value="zxbj2" name="from" />
        <input id="submit" type="submit" value="" style="width:171px; height:38px; background-image:url(${themePath}/images/regbut.png); border:0; "  onclick="return formcheck();" onmouseover="this.style.backgroundImage='url(${themePath}/images/regbut_hover.png)'" onmouseout="this.style.backgroundImage='url(${themePath}/images/regbut.png)'"  />
      </div>
      <div class="infotittlefont"></div>
      </div>
      <div class="reginfoR">
           <div class="error1div" id="errormsg1" style="display:none;"></div>
            <div class="error1msg" id="error1msg" style="display:none;">请输入不超过14个字符（字母、数字、下划线），<span style="color:Red;">用户名一经确认，无法修改。</span></div>
           <div class="error2div" id="errormsg2" style="display:none;"></div>
            <div class="error2msg" id="error2msg" style="display:none;">请输入6至18位字符（0-9a-zA-Z）</div>
           <div class="error3div" id="errormsg3" style="display:none;"></div>
            <div class="error3msg" id="error3msg" style="display:none;">请再输入一次上面输入的密码</div>
           <div class="error1div" id="errormsg4" style="display:none;"></div>
            <div class="alert1msg" id="error4msg" style="display:none;">请输入11位正确手机号码</div>
           <div class="alert4div" id="errormsg5" style="display:none;"></div>
            <div class="error4msg" id="error5msg" style="display:none;">请输入验证码</div>
           <div class="alert5div" id="errormsg6" style="display:none;"></div>
            <div class="error5msg" id="error6msg" style="display:none;">请输入邀请码</div>

            <div class="alert1div" id="alertmsg1" style="display:none;"></div>
            <div class="alert1msg" id="alert1msg" style="display:none;">请输入不超过14个字符（字母、数字、下划线），<span style="color:Red;">用户名一经确认，无法修改。</span></div>
           <div class="alert2div" id="alertmsg2" style="display:none;"></div>
            <div class="alert2msg" id="alert2msg" style="display:none;">请输入6至18位字符（0-9a-zA-Z）</div>
           <div class="alert3div" id="alertmsg3" style="display:none;"></div>
            <div class="alert3msg" id="alert3msg" style="display:none;">请再输入一次上面输入的密码</div>
           <div class="alert1div" id="alertmsg4" style="display:none;"></div>
            <div class="alert1msg" id="alert4msg" style="display:none;">请输入11位正确手机号码</div>
           <div class="alert4div" id="alertmsg5" style="display:none;"></div>
            <div class="error4msg" id="alert5msg" style="display:none;">请输入验证码</div>
           <div class="alert5div" id="alertmsg6" style="display:none;"></div>
            <div class="error5msg" id="alert6msg" style="display:none;">请输入邀请码</div>
            <div class="alert6div" id="alertmsg7" style="display:none;"></div>
            <div class="error6msg" id="alert7msg" style="display:none;">请确认勾选注册协议</div>
      </div>
	  <input id="localsource" type="hidden" name="localsource" value="${localsource}" />
    </div>
  </div>
</body>
</html>