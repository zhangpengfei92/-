<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>中金宸大</title>
<link href="${staticpath}/css/css.css" rel="stylesheet" type="text/css" />
<script src="${staticpath}/js/jquery.SuperSlide.2.1.1.js"></script>
<script src="${staticpath}/js/jquery1.42.min.js"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?key=&v=1.1&services=true"></script>
<script type="text/javascript">
$(document).ready(function () {	
	//去掉所有的导航栏高亮显示样式
	$(".Zlogo ul li a ").each(function () {  
			$(this).removeClass("on");  
		}); 
	//被导航栏选中高亮显示
	$("#aboutus").addClass("on");
});
</script>


</head>
<body>
<%@include file="../../top.jsp"%>
<!-- banner start-->
<div class="banner">
    <div class="flexslider" style="height:523px;">
        <ul class="slides">
            <li style="background:url(${staticpath}/images/Abanner.png) 50% 0 no-repeat;" style="height:523px;"></li>
        </ul>
    </div> 
</div> 
<!-- banner end--> 
<div class="main" >
   <div class="Abox" id="div1">
      <h3><span class="red">关于我们</span><span>ABOUT US</span></h3>
      <div class="about" id="div1">
          <p>中金宸大是国内领先的互联网股票配资平台，是一家专注于股票投资、
          金融服务、及资产管理专业机构，平台以帮助用户安全、高效和快速财富增值为主线，
          平台拥有行业领先风险管控能力，通过科学、严谨、安全、高效业务办理流程，
          为全国金融投资者提供最专业配资咨询、 资金匹配、风险控制等金融信息一站式股票配资服务，
          全程网络操作，高效便捷。</p>
          <p>中金宸大管理团队来自于国内领先互联网公司和国内证券期货金融机构，
          由拥有丰富互联网产品经验和金融风控经验的资深人士组成，
          具备丰富金融行业与互联网行业专业知识与从业实操经验，
          从经营模式、运营流程、风控体系、技术安全、
          客户服务等多角度确保投融资客户资金安全无忧。</p>
          <p>中金宸大，是中国最安全的网络配资平台，通过与证券公司、银行合作，
          做到交易账户证券公司监管、账户资金银行托管。为广大股民提供安全、快捷、灵活资金，是广大股民投资利器</p>
         
      </div>
      <ul class="lnian">
         <li>
           <p class="tit">企业服务</p>
           <p>公司秉承“公平、公开、公正”的原则，为投资者提供专业的金融理财服务；</p>
         </li>
         <li>
           <p class="tit">企业文化</p>
           <p>
            	诚信、规范、稳健、致远。
           </p>
         </li>
         <li>
           <p class="tit">企业理念</p>
           <p>全力打造国内最规范、最安全投资理财服务平台；</p>
         </li>
      </ul>
      <div class="Map" id="div2">
          <h3><span class="red">联系我们</span><span>CONTACT US</span></h3>
          <div class="w1200 clearfix">
			<ul class="leftmenu">
				<li><p class="call">服务热线: 027-88771708</p></li>
				<li><p class="QQ">公司QQ: 2852373337</p></li>
                <li><p class="email">公司邮箱: 2852373337@qq.com</p></li>
                <li><p class="address">公司地址:武汉市光谷大道与珞瑜路交汇处以北
                                     100米未来之光大厦6号楼11楼</p></li>
			</ul>
			
			<div class="conright">
				<div class="padd">
						 <div style="width:670px;height:290px;border:#ccc solid 1px;" id="dituContent"></div>
					<script type="text/javascript">
					    //创建和初始化地图函数：
					    function initMap(){
					        createMap();//创建地图
					        setMapEvent();//设置地图事件
					        addMapControl();//向地图添加控件
					        addMarker();//向地图中添加marker
					    }
					    
					    //创建地图函数：
					    function createMap(){
					        var map = new BMap.Map("dituContent");//在百度地图容器中创建一个地图
					        var point = new BMap.Point(114.438383,30.511029);//定义一个中心点坐标
					        map.centerAndZoom(point,18);//设定地图的中心点和坐标并将地图显示在地图容器中
					        window.map = map;//将map变量存储在全局
					    }
					    
					    //地图事件设置函数：
					    function setMapEvent(){
					        map.enableDragging();//启用地图拖拽事件，默认启用(可不写)
					        map.enableScrollWheelZoom();//启用地图滚轮放大缩小
					        map.enableDoubleClickZoom();//启用鼠标双击放大，默认启用(可不写)
					        map.enableKeyboard();//启用键盘上下左右键移动地图
					    }
					    
					    //地图控件添加函数：
					    function addMapControl(){
					        //向地图中添加缩放控件
						var ctrl_nav = new BMap.NavigationControl({anchor:BMAP_ANCHOR_TOP_LEFT,type:BMAP_NAVIGATION_CONTROL_LARGE});
						map.addControl(ctrl_nav);
					        //向地图中添加缩略图控件
						var ctrl_ove = new BMap.OverviewMapControl({anchor:BMAP_ANCHOR_BOTTOM_RIGHT,isOpen:1});
						map.addControl(ctrl_ove);
					        //向地图中添加比例尺控件
						var ctrl_sca = new BMap.ScaleControl({anchor:BMAP_ANCHOR_BOTTOM_LEFT});
						map.addControl(ctrl_sca);
					    }
					    
					    //标注点数组
					    var markerArr = [{title:"武汉中金宸大网络科技有限公司",content:"武汉市光谷大道与珞喻路交汇处以北100米未来之光大厦6号楼11楼",point:"114.438792|30.510835",isOpen:1,icon:{w:23,h:25,l:0,t:21,x:9,lb:12}}
							 ];
					    //创建marker
					    function addMarker(){
					        for(var i=0;i<markerArr.length;i++){
					            var json = markerArr[i];
					            var p0 = json.point.split("|")[0];
					            var p1 = json.point.split("|")[1];
					            var point = new BMap.Point(p0,p1);
								var iconImg = createIcon(json.icon);
					            var marker = new BMap.Marker(point,{icon:iconImg});
								var iw = createInfoWindow(i);
								var label = new BMap.Label(json.title,{"offset":new BMap.Size(json.icon.lb-json.icon.x+10,-20)});
								marker.setLabel(label);
					            map.addOverlay(marker);
					            label.setStyle({
					                        borderColor:"#808080",
					                        color:"#333",
					                        cursor:"pointer"
					            });
								
								(function(){
									var index = i;
									var _iw = createInfoWindow(i);
									var _marker = marker;
									_marker.addEventListener("click",function(){
									    this.openInfoWindow(_iw);
								    });
								    _iw.addEventListener("open",function(){
									    _marker.getLabel().hide();
								    })
								    _iw.addEventListener("close",function(){
									    _marker.getLabel().show();
								    })
									label.addEventListener("click",function(){
									    _marker.openInfoWindow(_iw);
								    })
									if(!!json.isOpen){
										label.hide();
										_marker.openInfoWindow(_iw);
									}
								})()
					        }
					    }
					    //创建InfoWindow
					    function createInfoWindow(i){
					        var json = markerArr[i];
					        var iw = new BMap.InfoWindow("<b class='iw_poi_title' title='" + json.title + "'>" + json.title + "</b><div class='iw_poi_content'>"+json.content+"</div>");
					        return iw;
					    }
					    //创建一个Icon
					    function createIcon(json){
					        var icon = new BMap.Icon("http://app.baidu.com/map/${staticpath}/images/us_mk_icon.png", new BMap.Size(json.w,json.h),{imageOffset: new BMap.Size(-json.l,-json.t),infoWindowOffset:new BMap.Size(json.lb+5,1),offset:new BMap.Size(json.x,json.h)})
					        return icon;
					    }
					    
					    initMap();//创建和初始化地图
					</script>
				</div>
			</div>
		</div>
      </div>
   </div>
</div>
<%@include file="../../foot.jsp"%>
</body>
</html>
