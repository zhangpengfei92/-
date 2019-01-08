
 //微信  js sdk
        (function() {
            var wx = document.createElement('script');
           // wx.src = "jweixin-1.0.0.js";
            wx.setAttribute('async', 'true');
           // document.documentElement.firstChild.appendChild(wx);
        })();

		var ua = navigator.userAgent;
		var iphoneplus = ua.indexOf('Device iPhone7,1') >= 0 ? true : false;
		//签入webview是否显示顶部导航条和底部导航条， true为显示，false为隐藏
		window.isAppShowHeader = false;	



 //适配
if(iphoneplus){
		//iPhone 6 plus处理样式
		if(window.screen.width > 400){
			document.documentElement.style.fontSize = '11.71875px';
		}else{
			document.documentElement.style.fontSize = '10.7px';
		}
	}else{
		//适配所有机型
		(function (doc, win) {
		    var docEl = doc.documentElement,
		        resizeEvt = 'orientationchange' in window ? 'orientationchange' : 'resize',
		        recalc = function () {
		            var clientWidth = docEl.clientWidth;
		            if (!clientWidth) return;
		            docEl.style.fontSize = 10 * (clientWidth / 320) + 'px';
		        };
		    if (!doc.addEventListener) return;
		    win.addEventListener(resizeEvt, recalc, false);
		    doc.addEventListener('DOMContentLoaded', recalc, false);
		})(document, window);
	}
	
//二级联动地址
 var currentShowCity=0;
$(document).ready(function(){
   $("#province").change(function(){
	   $("#province option").each(function(i,o){
		   if($(this).attr("selected"))
		   {
		 
			   $(".city").hide();
			   $(".city").eq(i).show();
			   currentShowCity=i;
		   }
	   });
   });
   $("#province").change();
   //
   
   
});


///选中状态
jQuery.divselect = function(divselectid,inputselectid) {	
	var inputselect = $(inputselectid);
	$(divselectid+" a").click(function(){
		
		$(this).addClass("on").siblings().removeClass("on");
		var value = $(this).attr("selectid");
		inputselect.val(value);
	});
	/*$(divselectid+" dl dd a").click(function(){
		var txt = $(this).text();
		$(divselectid+" cite").html(txt);
		var value = $(this).attr("selectid");
		inputselect.val(value);
		$(divselectid+" dl").hide();
		
	});*/
};



$(function(){
//协议条款
	$(".checkboxPic").click(function(){
		if($(this).attr("isshow")=="false")
		{
			$(this).parent().css("margin-bottom","");
			$(".checkboxPic i").css({"background-position":" -0px -24px"});
			$(".otherError").css("display","block");
			$(this).attr("isshow","true");
		}
		else
		{
			$(this).parent().css("margin-bottom","");
			$(".checkboxPic i").css({"background-position":"-0px -0px"});
			$(".otherError").hide();
			$(this).attr("isshow","false");
		}
		
	}); 
});



 $(function () {
            $('#btn').click(function () {
                var count = 60;
                $("#btn").css("background","#dbdbdb")
                $("#btn").val(count+" s后重新获取");
                var countdown = setInterval(CountDown, 1000);
                function CountDown() {
                    $("#btn").attr("disabled", true);
                    $("#btn").val(count+" s后重新获取");
                    
                    if (count == 0) {
                        $("#btn").val("重新获取验证码").removeAttr("disabled");
                        clearInterval(countdown);
                    }
                    count--;
                }
            })
        });
		
