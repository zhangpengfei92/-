<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-Ua-Compatible" content="IE=EmulateIE8" />
<title>新建app帮助</title>
	<link rel="stylesheet" type="text/css" href="${path}/css/style.css" />
	<script type="text/javascript" src="${path}/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="${path}/js/My97DatePicker/WdatePicker.js"></script>

	<!-- 引入默认css -->
	<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="${path}/js/easyui/themes/icon.css" />
	<script type="text/javascript" src="${path}/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${path}/js/easyui/locale/easyui-lang-zh_CN.js"></script>
	
	<!--layui  -->
	<link href="${path}/layui/css/layui.css" rel="stylesheet"type="text/css" />
	<link href="${path}/layui/css/main.css" rel="stylesheet" type="text/css" />
	

<script type="text/javascript">
	
	//中文验证
	 function funcChina(obj) {
        if (/^[A-Za-z0-9_]*$/g.test(obj)) {
            return true;
        }
        return false;
    } 
	
	//取消
	function refreshPage() {
		window.location.href = "${path}/doc/queryAll";
	} 		
</script>
</head>
<body>
	<%@include file="../../../head.jsp"%>
	<div class="wrap">
		<%@include file="../fund/subzhMaster.jsp"%>
		<div class="Rbox">
     		<div class="mainbox">
     		
                   <h3><a href="${path}/doc/queryAll">App帮助</a><i>/</i><a href="#" class="on">
              			新建App帮助
			    </a></h3>
                   <div class="main">
        		   		
                      	<div class="Form">                                                	
                            <div class="dline">
                                <label>文档名称：</label>
		                   		 <input type="text" value="${doc.docname}" id="docname" name="docname"/>
                            </div>
                            <div class="dline">
                                 <label>标题信息：</label>
                                 <input type="text" value="${doc.title}" id="title" name="title" />
                            </div>                                         
                              <div style="margin:0 0 0 140px; width: 550px;">
                                 <label>内容：</label>
                              		<textarea class="layui-textarea" id="doccontext" style="display: none">  
										${doc.doccontext}
									</textarea>   
                            </div>
                            
                            <div class="dline">
                                 <label style="color:#fff;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                                 <button class="Submit" onclick="saveUser()" id="submitId">提交</button>
                                 <button class="Submit cancel" onclick="refreshPage()">取消</button>
                            </div>
                       </div>
                      
				</div>
			</div>
		</div>
	</div>
</body>
<script src="${path}/layui/layui.js" type="text/javascript"></script>
<script type="text/javascript">
<!--加载layUI的富文本编辑器  -->
layui.use(['layedit','layer','jquery'], function(){
	  var layedit = layui.layedit
	  ,$ = layui.jquery,layer=layui.layer;
	 
	  var index = layedit.build('doccontext');
	  
	  $('#submitId').click(function(){
			
			var regFlag = true;
			//文档名称
				var docname = $.trim($("#docname").val());
				if (docname == null || docname == "") {
					$.messager.alert('提示', "请输入文档名称!", 'info');
					return false;
				}
				//文档标题   
				var title = $.trim($("#title").val());
				if(!title){
					
					$.messager.alert('提示', "请输入标题信息!", 'info');
					return false;
				}
					
		        //文档内容var
		      	var doccontext=$.trim(layedit.getContent(index));
				if (doccontext == null || doccontext == "") {
					//alert('请输入占用保证金');
					$.messager.alert('提示', "请输入文本信息!", 'info');
					return false;
				}	
				if(regFlag){
					$.ajax({
						url : "${path}/doc/add",
						data : {
							'docname': docname,
							'title': title,
							'doccontext': doccontext,
						},
						type : "POST",
						async : true,
						success : function(num) {
							 if(num>0){
								 window.location.href="${path}/doc/queryAll";				
							}
						} 
					});
				}	  
			  }); 
	  });
	 
	
	
</script>

</html>