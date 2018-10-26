<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta content="telephone=no" name="format-detection">
<link type="text/css" href="${path}/css/css.css" rel="stylesheet"/>
<link type="text/css" href="${path}/css/animation.css" rel="stylesheet"/>
<link type="text/css" href="${path}/css/DateTimePicker.css" rel="stylesheet"/>

<script type="text/javascript" src="${path}/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="${path}/js/DateTimePicker.js"></script>
<script type="text/javascript" src="${path}/js/layer/layer/layer.js"></script>
<script type="text/javascript" src="${path}/js/layui/layui.js"></script>
<script type="text/javascript" src="${path}/js/All.js"></script>
<script src="${path}/js/moment.js" type="text/javascript"></script>
<script type="text/javascript">
	var uid= "<%=session.getAttribute("SESSION_ACCOUNTID")%>"; 
	var username= "<%=session.getAttribute("SESSION_LOGINNAME")%>"; 
	function xj(){
		$.post("${path}/userinfoData/userLogin",{"phone":uid},function(data){
	    	if(data.code == 1){
	    		window.location = "${path}/stockoption/stockoptionJump";
	    	}else{
	    		window.location = "${path}/stockoption/stockoptionJump?str=xj";
	    	}
		})
	}
	function rg(){
		
		$.post("${path}/userinfoData/userLogin",{"phone":uid},function(data){
	    	if(data.code == 1){
	    		window.location = "${path}/stockoption/stockoptionJump";
	    	}else{
	    		window.location = "${path}/stockoption/stockoptionJump?str=rg";	
	    	}
		})
	    
	}
	function cc(){
		$.post("${path}/userinfoData/userLogin",{"phone":uid},function(data){
	    	if(data.code == 1){
	    		window.location = "${path}/stockoption/stockoptionJump";
	    	}else{
	    		window.location = "${path}/stockoption/stockoptionJump?str=cc";
	    	}
		})
		
	}
	function js(){
		$.post("${path}/userinfoData/userLogin",{"phone":uid},function(data){
	    	if(data.code == 1){
	    		window.location = "${path}/stockoption/stockoptionJump";
	    	}else{
	    		window.location = "${path}/stockoption/stockoptionJump?str=js";
	    	}
		})
	}
	function rgcx(){
		$.post("${path}/userinfoData/userLogin",{"phone":uid},function(data){
	    	if(data.code == 1){
	    		window.location = "${path}/stockoption/stockoptionJump";
	    	}else{
	    		$.post("${path}/stockoption/getStockEnquiry",{"phone":username},function(data){
	    			window.location = "${path}/stockoption/stockoptionJump?str=rgcx";
	    		})
	    	}
		})
	}
	
</script>
</head>

</html>