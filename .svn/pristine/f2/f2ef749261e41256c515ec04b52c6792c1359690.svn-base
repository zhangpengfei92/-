$(function(){
	 <!--下拉菜单js s-->
	$("#sel_1").click(function(){
		if($(this).hasClass("cur")){
			$("#sel_2").hide();
			$(this).removeClass("cur");
		    }
		else{
			$(this).addClass("cur");
			$("#sel_2").show();
			}
		
		})
	$("#sel_2 li").click(function(){
		$("#sel_1").text($(this).text());
		$("#sel_2").hide();
		
		});
	 <!--下拉菜单 js s-->	
	});

//首页banner切换 s//
$(document).ready(function () {
	$(".main_visual").hover(function(){
		$("#btn_prev,#btn_next").fadeIn()
		},function(){
		$("#btn_prev,#btn_next").fadeOut()
		})
	$dragBln = false;
	$(".main_image").touchSlider({
		flexible : true,
		speed : 100,
		btn_prev : $("#btn_prev"),
		btn_next : $("#btn_next"),
		paging : $(".flicking_con a"),
		counter : function (e) {
			$(".flicking_con a").removeClass("on").eq(e.current-1).addClass("on");
		}
	});
	$(".main_image").bind("mousedown", function() {
		$dragBln = false;
	})
	$(".main_image").bind("dragstart", function() {
		$dragBln = true;
	})
	$(".main_image a").click(function() {
		if($dragBln) {
			return false;
		}
	})
	timer = setInterval(function() { $("#btn_next").click();}, 30000);
	$(".main_visual").hover(function() {
		clearInterval(timer);
	}, function() {
		timer = setInterval(function() { $("#btn_next").click();}, 30000);
	})
	$(".main_image").bind("touchstart", function() {
		clearInterval(timer);
	}).bind("touchend", function() {
		timer = setInterval(function() { $("#btn_next").click();}, 30000);
	})
});
//首页banner切换 e//

$(function(){
  //radio切换
	$(".xz_fs li").click(function(){
		$(this).addClass("cur").siblings().removeClass("cur");
		$(this).parents(".xz_fs").find(".radio_value").val($(this).attr("data"));
		})	
    $(".sp_sx li a").click(function(){
		$(this).addClass("red").siblings().removeClass("red");
		})			   
})

$(document).ready(function () {
	$(".main_visual2").hover(function(){
		$("#btn_prev2,#btn_next2").fadeIn()
		},function(){
		$("#btn_prev2,#btn_next2").fadeOut()
		})
	$dragBln = false;
	$(".main_image2").touchSlider({
		flexible : true,
		speed : 100,
		btn_prev : $("#btn_prev2"),
		btn_next : $("#btn_next2"),
		paging : $(".flicking_con2 a"),
		counter : function (e) {
			$(".flicking_con2 a").removeClass("on2").eq(e.current-1).addClass("on2");
		}
	});
	$(".main_image2").bind("mousedown", function() {
		$dragBln = false;
	})
	$(".main_image2").bind("dragstart", function() {
		$dragBln = true;
	})
	$(".main_image2 a").click(function() {
		if($dragBln) {
			return false;
		}
	})
	timer = setInterval(function() { $("#btn_next2").click();}, 30000);
	$(".main_visual2").hover(function() {
		clearInterval(timer);
	}, function() {
		timer = setInterval(function() { $("#btn_next2").click();}, 30000);
	})
	$(".main_image2").bind("touchstart", function() {
		clearInterval(timer);
	}).bind("touchend", function() {
		timer = setInterval(function() { $("#btn_next2").click();}, 30000);
	})
});

$(function(){
	$(".count input").val(1);
	$(".count span").click(function(){
		var $unit = $(this).parent(".count");
		var _val = parseInt( $unit.find("input").val() );
		if( !$.isNumeric(_val) ){
			alert("请输入数字");
			return;
		}
		if( $(this).hasClass("disabled") ) return;
		//增加
		if( $(this).hasClass("jia") ){
			$unit.find("input").val( ++_val );
			if( _val >= 1 ){
				$unit.find("span.jian").removeClass("disabled");
			}
		} else {
			$unit.find("input").val( --_val );
			if( _val <= 1 ){
				$unit.find("span.jian").addClass("disabled");
			}
		}
	});
	$(".checkbox:not('.allcheckbox')").click(function(){  
	 if($(this).hasClass("checkboxed")){
		$(this).removeClass("checkboxed");		 
	 	$(".allcheckbox").removeClass('checkboxed');
	 	
	}else{
	  $(this).addClass("checkboxed");
	  var _len = $(".checkp.checkboxed").length;
	  if(_len == $(".checkp:not('.allcheckbox')").length ){
		$(".allcheckbox").addClass('checkboxed');
	 }
	 }
	});
  
	$(".allcheckbox").click(function(){
		if($(this).hasClass("checkboxed")){
		   $(this).removeClass("checkboxed");
		   $(".checkbox").removeClass("checkboxed");
		   }else{
		   $(this).addClass("checkboxed");
		   $(".checkbox").addClass("checkboxed");}
	})
});

$(function(){
	$(".check_01").click(function(){
			if($(this).hasClass("cur")){
				$(this).removeClass("cur");
				$(this).prev().attr("checked",false);
				}
			else{
				$(this).addClass("cur");
				$(this).prev().attr("checked",true);
				}
			check_all();
  });
	$(".check_all").click(function(){
		if($(this).hasClass("active")){
				$(this).removeClass("active");
				$(".check_01").each(function(index, element) {
          $(this).removeClass("cur");
					$(this).prev().attr("checked",false);
        });
				}
			else{
				$(this).addClass("active");
				$(".check_01").each(function(index, element) {
          $(this).addClass("cur");
					$(this).prev().attr("checked",true);
        });
				}
	})
});
function check_all(){
	if($(".check_01").length==$(".check_01.cur").length){
		$(".check_all").addClass("active");
		}
	else{
		$(".check_all").removeClass("active");
		}
	}
	
$(function(){
  //购物车 s
	var one_price,one_num,one_money=[],one_index;
	if($("#all_price").length>0){
		for( var i=0;i<$(".s_price").length;i++){
		one_money[i]=parseFloat($(".s_price").eq(i).find(".s_price").val()*$(".s_price").eq(i).find(".btn_num").val()).toFixed(2);
		}
	}	
	$(".s_price .plus").click(function(){
		one_index=$(".s_price .plus").index($(this));
		one_price=$(this).parents(".s_price").find(".d_price").val();
		one_num=$(this).parents(".s_price").find(".btn_num").val();
		$(this).parents(".s_price").find(".minus").removeClass("disable");
		one_num++;
		$(this).parents(".s_price").find(".btn_num").val(one_num);
		one_money[one_index]=parseFloat(one_num*one_price).toFixed(2);
		$(this).parents(".s_price").find(".price").text(one_money[one_index]);
		$("#all_price").text(parseFloat(eval(one_money.join('+'))));
		})
	$(".s_price .minus").click(function(){
		one_index=$(".s_price .minus").index($(this));
		one_price=$(this).parents(".s_price").find(".d_price").val();
		one_num=$(this).parents(".s_price").find(".btn_num").val();		
		if(one_num>2){one_num--;$(this).removeClass("disable");}
		else if(one_num==2){one_num--;$(this).addClass("disable");}
		$(this).parents(".s_price").find(".btn_num").val(one_num);
		one_money[one_index]=parseFloat(one_num*one_price).toFixed(2);
		$(this).parents(".s_price").find(".price").text(one_money[one_index]);
		$("#all_price").text(parseFloat(eval(one_money.join('+'))));
		})
	//购物车 e	
})
$(function(){
$(".right2 .delete").click(function(){
			var this_obj=$(this).parent().parent();
			if(confirm("确定要删除当前商品吗？"))
   			{ 
				if(this_obj.parent().find("li").length<1){
					this_obj.parent().remove();
					}
				else{
					this_obj.remove();
					}
				}
	
			})
})