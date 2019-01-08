
 //微信  js sdk
        //(function() {
        //    var wx = document.createElement('script');
       //     wx.src = "jweixin-1.0.0.js";
       //     wx.setAttribute('async', 'true');
       //     document.documentElement.firstChild.appendChild(wx);
       // })();

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



//登录是否弹出层
$(document).ready(function() {
	$('.theme-login').click(function(){
		$(this).parent().children('.theme-popover-mask').fadeIn(100); 
		$(this).parent().children('.theme-popover').slideDown(200); 
	})
	$('.theme-popbod .close').click(function(){
		$('.theme-popover-mask').fadeOut(100);
		$('.theme-popover').slideUp(200);
	})

})
