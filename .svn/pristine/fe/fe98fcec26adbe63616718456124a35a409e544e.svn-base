<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html> 
<head>
	<meta charset="utf-8">
	<title></title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" />
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta content="telephone=no" name="format-detection">
    <link href="${cssPath}/auth/appauth.css" rel="stylesheet" type="text/css" />
    <link href="${cssPath}/auth/animation.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${jsPath}/jquery-1.9.1.min.js"></script>
    <script src="${jsPath}/All.js" type="text/javascript"></script>
    <script type="text/javascript" src="${jsPath}/jquery.touchSlider.js"></script>
	<script type="text/javascript" src="${jsPath}/jquery.form.js"></script>
</head> 
<body class="bggray">
    <div class="category">
    <!-- insder header -->
    <header class="ls-header">
       <!--  <div class="ls-header-left">
            <a href="javascript:history.go(-1)"><i class="iconfont icon-back"></i></a>
        </div> -->
        <!-- <div class="ls-header-title">身份认证</div> -->
        <!--<div class="ls-header-right">
           <a href=""><i class="iconfont icon-flash"></i></a>
        </div>-->
    </header>
    <div class="mainbox">
    	<form id="form1" name="form1" method="POST" enctype="multipart/form-data" action="${path}/auth/doAuth">
         <input type="hidden" name="subzh" value="${subzh.subzh}">
         <div class="Uzhao">
              <ul>
                  <li class="pgrey">
                  <p><label>状态：</label>
						<strong>
							<c:if test="${subzh.authState eq '0'}">未认证</c:if>
							<c:if test="${subzh.authState eq null}">未认证</c:if>
							<c:if test="${subzh.authState eq '1'}">申请中</c:if>
							<c:if test="${subzh.authState eq '2'}">已通过</c:if>
							<c:if test="${subzh.authState eq '3'}">未通过</c:if>
						</strong>
					</p>
              </li>
              <li>
                  <label>姓名</label>
                  <c:if test="${subzh.authState eq '0' or subzh.authState eq '3' or subzh.authState eq null}">
							<input type="text" id="name" name="name" placeholder="请输入真实姓名" />
					</c:if>
					<c:if test="${subzh.authState eq '1' or subzh.authState eq '2'}">
							<input type="text" value="${subzh.name}" disabled/>
					</c:if>
              </li>
              <li>
                  <label>身份证号</label>
                  <c:if test="${subzh.authState eq '0' or subzh.authState eq '3' or subzh.authState eq null}">
							<input type="text" id="idNo" name="idNo" placeholder="请输入身份证号码" />
					</c:if>
					<c:if test="${subzh.authState eq '1' or subzh.authState eq '2'}">
							<input type="text" value="${subzh.idNo}" disabled />
					</c:if>
              </li>
              <li>
                  <label>银行卡号</label>
                  <c:if test="${subzh.authState eq '0' or subzh.authState eq '3' or subzh.authState eq null}">
							<input type="text" id="bankCard" name="bankCard" placeholder="请输入银行卡号" />
					</c:if>
					<c:if test="${subzh.authState eq '1' or subzh.authState eq '2'}">
							<input type="text" value="${subzh.bankCard}" disabled />
					</c:if>
              </li>
              <li style="position:relative;">
                  <label>开户银行</label>
                  <c:if test="${subzh.authState eq '0' or subzh.authState eq '3' or subzh.authState eq null}">
							<input type="text" id="bank" name="bank" placeholder="请输入开户行" />
					</c:if>
					<c:if test="${subzh.authState eq '1' or subzh.authState eq '2'}">
							<input type="text" value="${subzh.bank}" disabled />
					</c:if>
              </li>
              <li style="position:relative;">
                  <label>开户支行</label>
                  <c:if test="${subzh.authState eq '0' or subzh.authState eq '3' or subzh.authState eq null}">
							<input type="text" id="qq" name="qq" placeholder="请输入开户行分行" />
					</c:if>
					<c:if test="${subzh.authState eq '1' or subzh.authState eq '2' }">
							<input type="text" value="${subzh.qq}" disabled />
					</c:if>
              </li>
            </ul>
         </div>
         <%-- <div class="Uzhaot">
              <ul>
                <li class="pgrey">
                    <p>请拍摄上传您的证件照。</p>
                </li>
                <c:if test="${subzh.authState eq '0' or subzh.authState eq '3'}">
	                <li>
	                  <div class="Headbox">
	                    <div class="headfile">
	                         <div id="preview1" class="upload" style="overflow: hidden;">
										<img id="imghead1" border="0" src="${path}/images/auth/peop.png" width="100%" height="95%" onclick="$('#previewImg1').click();">
									</div>
									<input type="file" onchange="previewImage(this,1)" style="display: none;" id="previewImg1" name="frontFile">
	                    </div>
	                  </div>
	                  <!-- <p class="Paction">上传身份证人像面</p> -->
	               </li>
	               <li>
	                  <div class="Headbox">
	                    <div class="headfile ghfile">
	                         <div id="preview2" class="upload" style="overflow: hidden;">
										<img id="imghead2" border="0" src="${path}/images/auth/gh.png" width="100%" height="95%" onclick="$('#previewImg2').click();">
									</div>
									<input type="file" onchange="previewImage(this,2)" style="display: none;" id="previewImg2" name="backFile">
	                    </div>
	                  </div>
	                  <!-- <p class="Paction">上传身份证国徽面</p> -->
	               </li>
	               <li>
	                  <div class="Headbox">
	                    <div class="headfile yhfile">
	                         <div id="preview3" class="upload" style="overflow: hidden;">
										<img id="imghead3" border="0" src="${path}/images/auth/yhk.png" width="100%" height="95%" onclick="$('#previewImg3').click();">
									</div>
									<input type="file" onchange="previewImage(this,3)" style="display: none;" id="previewImg3" name="cardFile">
	                    </div>
	                  </div>
	                 <!--  <p class="Paction">上传银行卡照片</p> -->
	               </li>
               </c:if>
               <c:if test="${subzh.authState eq '1' or subzh.authState eq '2'}">
						<li>
							<div style="width: 56%;margin: 0 22%;height:12rem;overflow: hidden;">
								<img border="0" src="${subzh.frontPic}" width="100%" height="140">
							</div>
						</li>
						<li>
							<div style="width: 56%;margin: 0 22%;height:12rem;overflow: hidden;">
								<img border="0" src="${subzh.backPic}" width="100%" height="140">
							</div>
						</li>
						<li>
							<div style="width: 56%;margin: 0 22%;height:12rem;overflow: hidden;">
								<img border="0" src="${subzh.cardPic}" width="100%" height="140">
							</div>
						</li>
				</c:if>
               
            </ul>
         </div>
      </div> --%>
         <c:if test="${subzh.authState eq '0' or subzh.authState eq '3' or subzh.authState eq null}">
         	<a class="czbutton" href="javascript:void(0);" onclick="submitForm()" id="submitform">提交</a>
         </c:if>
         </form>
         
</div>
  
 <script type="text/javascript">
	 //图片上传预览    IE是用了滤镜。
	function previewImage(file, num) {
	    var MAXWIDTH = 200;
	    var MAXHEIGHT = 125;
	    var div = document.getElementById('preview'+num);
	    if (file.files && file.files[0]) {
	        div.innerHTML = '<img id="imghead'+num+'" onclick=$("#previewImg' + num + '").click() width="100%" height="95%">';
	        var img = document.getElementById('imghead' + num);
	        var reader = new FileReader();
	        reader.onload = function (evt) {
	            img.src = evt.target.result;
	        }
	        reader.readAsDataURL(file.files[0]);
	    } else { //兼容IE
	        var sFilter = 'filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src="';
	        file.select();
	        var src = document.selection.createRange().text;
	        div.innerHTML = '<img id=imghead'+num+'>';
	        var img = document.getElementById('imghead' + num);
	        img.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = src;
	        var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
	        status = ('rect:' + rect.top + ',' + rect.left + ',' + rect.width + ',' + rect.height);
	        div.innerHTML = "<div id=divhead style='width:" + rect.width + "px;height:" + rect.height + "px;margin-top:" + rect.top + "px;" + sFilter + src + "\"'></div>";
	    }
	}
	 
	function submitForm(){
		var name = $('#name').val();
		if(name.trim() == ''){
			alert("姓名不能为空");
			return false;
		}
		var regName = /^[\u0391-\uFFE5]+$/i.test(name);   
		if(!regName){
			alert("请输入中文姓名");
			return false;
		}
		if(name.length>20){
			alert("请输入用户名");
			return false;
		}
		var idNo = $('#idNo').val();
		if(idNo.trim() == ''){
			alert("身份证不能为空");
			return false;
		}
		var regIdNo = /^\d{15}(\d{2}[A-Za-z0-9])?$/i.test(idNo);      
		if(!regIdNo){
			alert("请输入正确的身份证号码");
			return false;
		}
		var bankCard = $('#bankCard').val();
		if(bankCard.trim() == ''){
			alert("银行卡不能为空");
			return false;
		}
		var regBankCard = /^\d+(\.\d+)?$/i.test(bankCard);   
		if(!regBankCard){
			alert("请输入正确的银行卡号");
			return false;
		}
		if(regBankCard.length>20){
			alert("请输入正确的银行卡号");
			return false;
		}
		var bank = $('#bank').val();
		if(bank.trim()== ''){
			alert("请输入开户行");
			return false;
		}
		
		if(bank.length>20){
			alert("请输入正确的开户行");
			return false;
		}
		var qq = $('#qq').val();
		if(qq.trim()== ''){
			alert("请输入开户行支行");
			return false;
		}
		if(qq.length>20){
			alert("开户支行太长");
			return false;
		}
		/* var file1 = document.getElementById('previewImg1').value;
		var file2 = document.getElementById('previewImg2').value;
		var file3 = document.getElementById('previewImg3').value;
		var oFile1 = document.getElementById('previewImg1');
		var oFile2 = document.getElementById('previewImg2');
		var oFile3 = document.getElementById('previewImg3');
		//分割上传文件字符串  userfile的value为上传文件的名称 类型为字符串。  
		var fileNameArr1 = file1.toLowerCase().split('.');
		var fileNameArr2 = file2.toLowerCase().split('.');
		var fileNameArr3 = file3.toLowerCase().split('.');
		//或者document.getElementById("userfile")    也可以获得该dom元素  
		//文件名后缀  
		var suffix1 = fileNameArr1[fileNameArr1.length - 1];
		var suffix2 = fileNameArr2[fileNameArr2.length - 1];
		var suffix3 = fileNameArr3[fileNameArr3.length - 1];
		//如果后缀为空  
		if (suffix1 == "" || suffix2 == "" || suffix3 == "") {
			alert('请选择要上传的证件照片');
			return false;
		}
		var extName = "JPG,JPEG,PNG"; 
		if (extName.indexOf(suffix1.toUpperCase()) == -1) {
			alert("图片类型必须是jpeg,jpg,png中的一种");
			return false;
		}
		if (extName.indexOf(suffix2.toUpperCase()) == -1) {
			alert("图片类型必须是jpeg,jpg,png中的一种");
			return false;
		}
		if (extName.indexOf(suffix3.toUpperCase()) == -1) {
			alert("图片类型必须是jpeg,jpg,png中的一种");
			return false;
		}
		var imgSize1 = oFile1.files[0].size;
		var imgSize2 = oFile2.files[0].size;
		var imgSize3 = oFile3.files[0].size;
		if (imgSize1 > 104857600 || imgSize2 > 104857600 || imgSize3 > 104857600) {
			alert('图片尺寸过大');
			return false;
		}
		disabledsub(); */
		var options = {  
	        url : "${path}/auth/app/doAuth",
	        type : "POST",//提交方式  
	        success : function(data) {  
	            if(data == "SUCCESS"){
					alert("提交成功");
					try {
						javatojs.showToast("提交成功");
					} catch (e){ 
		        		javatojs.showToast("提交成功");
		        	}
   
	            }else {
	            	alert(data);
				}
				enabledsub();
	        },   
	        resetForm : true,  
	    };  
		$("#form1").ajaxSubmit(options);
	}
	
	//
	function enabledsub(){
		var ha = document.getElementById('submitform'); 
		ha.setAttribute("class", "czbutton"); 
		ha.setAttribute("onclick", "submitForm()"); 
	}
	
	function disabledsub(){
		var ha = document.getElementById('submitform'); 
		ha.setAttribute("class", "disbutton"); 
		ha.setAttribute("onclick", "nothing()"); 
	}
	
</script>
</body>
</html>