// JavaScript Document
//banner
$(window).load(function() {
	$('.flexslider').flexslider({
		directionNav: false,
		pauseOnAction: false
	});
});

$(document).ready(function () {	
	$(".tab ul li").click(function(){
			var index=$(".tab ul li").index(this);
			$(this).addClass("selected").siblings().removeClass("selected");
			$(".tab .hide").eq(index).show().siblings(".tab .hide").hide();
	})
});

$(document).ready(function () {	
	$(".findtab ul li").click(function(){
			var index=$(".findtab ul li").index(this);
			$(this).addClass("fselected").siblings().removeClass("fselected");
			$(".findtab .fhide").eq(index).show().siblings(".findtab .fhide").hide();
	})
});

$(document).ready(function () {	
	$(".workbox ul li").click(function(){
			var index=$(".workbox ul li").index(this);
			$(this).addClass("wselected").siblings().removeClass("wselected");
			$(".workbox .whide").eq(index).show().siblings(".workbox .whide").hide();
	})
});

/*投教中心tab*/
$(document).ready(function () {	
	$(".talktable ul li").click(function(){
			var index=$(".talktable ul li").index(this);
			$(this).addClass("selected").siblings().removeClass("selected");
			$(".talktable .hide").eq(index).show().siblings(".talktable .hide").hide();
	})
});

/*投教中心tab*/
$(document).ready(function () {	
	$(".hotable ul li").click(function(){
			var index=$(".hotable ul li").index(this);
			$(this).addClass("hotselect").siblings().removeClass("hotselect");
			$(".hotable .hothide").eq(index).show().siblings(".hotable .hothide").hide();
	})
});

/*播主主页tab*/
$(document).ready(function () {	
	$(".bzindex ul li").click(function(){
			var index=$(".bzindex ul li").index(this);
			$(this).addClass("bzselect").siblings().removeClass("bzselect");
			$(".bzindex .bzhide").eq(index).show().siblings(".bzindex .bzhide").hide();
	})
});
/*播主主页tab2*/
$(document).ready(function () {	
	$(".jytab ul li").click(function(){
			var index=$(".jytab ul li").index(this);
			$(this).addClass("jyselect").siblings().removeClass("jyselect");
			$(".jytab .jyhide").eq(index).show().siblings(".jytab .jyhide").hide();
	})
});
/*播主主页tab3*/
$(document).ready(function () {	
	$(".indent ul li").click(function(){
			var index=$(".indent ul li").index(this);
			$(this).addClass("inselect").siblings().removeClass("inselect");
			$(".indent .inhide").eq(index).show().siblings(".indent .inhide").hide();
	})
});
/*播主主页tab4*/
$(document).ready(function () {	
	$(".fowbox ul li").click(function(){
			var index=$(".fowbox ul li").index(this);
			$(this).addClass("selectf").siblings().removeClass("selectf");
			$(".fowbox .fowhide").eq(index).show().siblings(".fowbox .fowhide").hide();
	})
});

/*关注的微博tab*/
$(document).ready(function () {	
	$(".Atfans ul li").click(function(){
			var index=$(".Atfans ul li").index(this);
			$(this).addClass("Atselect").siblings().removeClass("Atselect");
			$(".Atfans .Athide").eq(index).show().siblings(".Atfans .Athide").hide();
	})
});

$(document).ready(function(){
				$('.citem').hover(function(){
					$(".citemtxt", this).stop().animate({top:'0px'},{queue:false,duration:160});
				}, function() {
					$(".citemtxt", this).stop().animate({top:'360px'},{queue:false,duration:160});
				});
			});
			

/*点赞*/
$(function(){
		$("#praise").click(function(){
			var praise_img = $("#praise-img");
			var text_box = $("#add-num");
			var praise_txt = $("#praise-txt");
			var num=parseInt(praise_txt.text());
			if(praise_img.attr("src") == ("image/zan_select.png")){
				$(this).html("<img src='image/zan2.png' id='praise-img' class='animation' />");
				praise_txt.removeClass("hover");
				text_box.show().html("<em class='add-animation'>-1</em>");
				$(".add-animation").removeClass("hover");
				num -=1;
				praise_txt.text(num)
			}else{
				$(this).html("<img src='image/zan_select.png' id='praise-img' class='animation' />");
				praise_txt.addClass("hover");
				text_box.show().html("<em class='add-animation'>+1</em>");
				$(".add-animation").addClass("hover");
				num +=1;
				praise_txt.text(num)
			}
		});
	})
			
/*TOP下拉*/	
function menuFix() {
    var sfEls = document.getElementById("nav").getElementsByTagName("li");
    for (var i=0; i<sfEls.length; i++) {
        sfEls[i].onmouseover=function() {
        this.className+=(this.className.length>0? " ": "") + "sfhover";
        }
        sfEls[i].onMouseDown=function() {
        this.className+=(this.className.length>0? " ": "") + "sfhover";
        }
        sfEls[i].onMouseUp=function() {
        this.className+=(this.className.length>0? " ": "") + "sfhover";
        }
        sfEls[i].onmouseout=function() {
        this.className=this.className.replace(new RegExp("( ?|^)sfhover\\b"),

"");
        }
    }
}
window.onload=menuFix;


/*个人中心首页tab*/
$(document).ready(function () {	
	$(".pmainmtop ul li").click(function(){
			var index=$(".pmainmtop ul li").index(this);
			$(this).addClass("selectop").siblings().removeClass("selectop");
			$(".pmainmtop .tophide").eq(index).show().siblings(".pmainmtop .tophide").hide();
	})
});
/*个人中心首页tab2*/
$(document).ready(function () {	
	$(".rhtab ul li").click(function(){
			var index=$(".rhtab ul li").index(this);
			$(this).addClass("rhselect").siblings().removeClass("rhselect");
			$(".rhtab .rhide").eq(index).show().siblings(".rhtab .rhide").hide();
	})
});


/*我的交易tab*/
$(document).ready(function () {	
	$(".pmainright ul li").click(function(){
			var index=$(".pmainright ul li").index(this);
			$(this).addClass("myselect").siblings().removeClass("myselect");
			$(".pmainright .tophide").eq(index).show().siblings(".pmainright .tophide").hide();
	})
});

/*私信tab*/
$(document).ready(function () {	
	$(".PLetter ul li").click(function(){
			var index=$(".PLetter ul li").index(this);
			$(this).addClass("PLselect").siblings().removeClass("PLselect");
			$(".PLetter .PLhide").eq(index).show().siblings(".PLetter .PLhide").hide();
	})
});

/*后台管理tab*/
$(document).ready(function () {	
	$(".Marbox ul li").click(function(){
			var index=$(".Marbox ul li").index(this);
			$(this).addClass("Maselect").siblings().removeClass("Maselect");
			$(".Marbox .Tratable").eq(index).show().siblings(".Marbox .Tratable").hide();
	})
});


/*稳健交易员tab*/
$(document).ready(function () {	
	$(".traderbox ul li").click(function(){
			var index=$(".traderbox ul li").index(this);
			$(this).addClass("Tchoice").siblings().removeClass("Tchoice");
			$(".traderbox .TRhide").eq(index).show().siblings(".traderbox .TRhide").hide();
	})
});

/*稳健交易员弹框tab*/
$(document).ready(function () {	
	$(".chartmain ul li").click(function(){
			var index=$(".chartmain ul li").index(this);
			$(this).addClass("hover").siblings().removeClass("hover");
			$(".chartmain .charthide").eq(index).show().siblings(".chartmain .charthide").hide();
	})
});

/*帮助中心tab*/
$(document).ready(function () {	
	$(".helpbox ul li").click(function(){
			var index=$(".helpbox ul li").index(this);
			$(this).addClass("hoverp").siblings().removeClass("hoverp");
			$(".helpbox .helphide").eq(index).show().siblings(".helpbox .helphide").hide();
	})
});
$(document).ready(function () {	
	$(".helphide ul li").click(function(){
			var index=$(".helphide ul li").index(this);
			$(this).addClass("newhover").siblings().removeClass("newhover");
			$(".helphide .newhide").eq(index).show().siblings(".helphide .newhide").hide();
	})
});


