<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	if(uid == ""||uid == null || uid == "null"){
		window.location = "${path}/stockoption/stockoptionJump";
	}
	function hangqing(){
		window.location = "http://gzh.jincelue.net:8080/hqcn";
	}
	function helpCenter(){
		$.post("${path}/appHelpInfo/getHelpInfoList",function(data){
			window.location = "${path}/stockoption/stockoptionJump?str=bz";
		})
	}
	function zjmx(){
		window.location = "${path}/stockoption/stockoptionJump?str=fundpc";
	}
	function trader(){
		window.location = "${path}/stockoption/stockoptionJump?str=rg";  
	}
	function personal(){
		window.location = "${path}/stockoption/stockoptionJump?str=wd";
	}
</script>
