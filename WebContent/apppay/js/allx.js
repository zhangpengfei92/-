

// JavaScript Document
//选项卡
$(function(){
		window.onload = function()
		{
			var $li = $('#tab li');
			var $ul = $('#content ul');
						
			$li.mouseover(function(){
				var $this = $(this);
				var $t = $this.index();
				$li.removeClass();
				$this.addClass('current');
				$ul.css('display','none');
				$ul.eq($t).css('display','block');
			})
		}
	});




// JavaScript Document
//弹框
var w,h,className;
function getSrceenWH(){
	w = $(window).width();
	h = $(window).height();
	$('#dialogBg').width(w).height(h);
}

window.onresize = function(){  
	getSrceenWH();
}  
$(window).resize();  

$(function(){
	getSrceenWH();
	
	//显示弹框
	$('.Bombbox a').click(function(){
		className = $(this).attr('class');
		$('#dialogBg').fadeIn(300);
		$('#dialog').removeAttr('class').addClass('animated '+className+'').fadeIn();
	});
	
	//关闭弹窗
	$('.claseDialogBtn').click(function(){
		$('#dialogBg').fadeOut(300,function(){
			$('#dialog').addClass('bounceOutUp').fadeOut();
		});
	});
});



$(function(){
//协议条款
	$(".checkboxPic").click(function(){
		if($(this).attr("isshow")=="false")
		{
			$(this).parent().css("margin-bottom","10px");
			$(".checkboxPic i").css({"background-position":" -0px -18px"});
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
                $("#btn").css("background","#f5f5f5")
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

