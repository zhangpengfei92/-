<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<title>股期策略线下支付</title>
		<style type="text/css">
			html {
				margin: 0;
				padding: 0;
			}
			
			body {
				margin: 0 auto;
				padding: 0;
				max-width: 1000px;
				background: #fff;
				font-size: 14px;
			}
			
			.m-header {
				position: relative;
				height: 0.48rem;
				line-height: 0.48rem;
				font-size: 0.16rem;
				border-bottom: 1px solid #EBEBEB;
				text-align: center;
				color: #2C2C2C;
				letter-spacing: 0;
				background: #fff;
			}
			
			.m-return {
				position: absolute;
				display: inline-block;
				top: 0.13rem;
				left: 0.12rem;
				width: 0.14rem;
				height: 0.22rem;
				background-image: url(http://c2.cgyouxi.com/website/mobile/img/arrow-l.png?v=20180122);
				background-size: 100% 100%;
			}
			
			.m-tab {
				position: relative;
				padding: 0.40rem 0 0;
				width: 100%;
				background: #fff;
			}
			
			.m-tab a {
				position: absolute;
				display: inline-block;
				width: 33%;
				font-size: 0.14rem;
				color: #2C2C2C;
				letter-spacing: 0;
				line-height: 0.38rem;
				text-align: center;
				text-decoration: none;
			}
			
			.m-tab a:first-child {
				top: 0;
				left: 0;
			}
			
			.m-tab a.m-middle {
				top: 0;
				right: 33%;
			}
			
			.m-tab a.m-right {
				top: 0;
				right: 0;
			}
			
			.m-tab a.active {
				border-bottom: 2px solid #FFAC28;
			}
			
			.m-division {
				height: 1px;
				background: #EBEBEB;
			}
			
			.m-view1 {
				height: 200px;
				text-align: center;
			}
			
			.m-view2 {
				height: 200px;
				text-align: center;
			}
			
			.m-view3 {
				height: 200px;
				margin-top: 40px;
				text-align: center;
			}
			
			@media screen and (min-width: 360px) {
				html {
					font-size: 100px!important;
				}
			}
		</style>
		<script type="text/javascript">
			document.documentElement.style.fontSize = document.documentElement.clientWidth / 3.6 + 'px';
			(function(doc, win) {
				var docEl = doc.documentElement;
				var resizeEvt = 'orientationchange' in window ? 'orientationchange' : 'resize';

				var recalc = function() {
					var clientWidth = docEl.clientWidth;
					if(!clientWidth) {
						return;
					}
					docEl.style.fontSize = 100 * (clientWidth / 360) + 'px';
				};

				if(!doc.addEventListener) {
					return;
				}
				win.addEventListener(resizeEvt, recalc, false);
				doc.addEventListener('DOMContentLoaded', recalc, false);
			})(document, window);
		</script>
	</head>

	<body>
		<div class="m-header" id="m-header">
			<div class="m-return" id="m-return"></div>
			充值
		</div>
		<div class="m-tab">
			<a href="javascript:void(0);" id="m-my-invite" class="active">微信充值</a>
			<a href="javascript:void(0);" id="m-my-coupons" class="m-middle">支付宝充值</a>
			<div class="m-division"></div>
		</div>
		<div id="m-view1" class="m-view1">
			<img src="${path}/images/wx.jpg" width="50%" />
			<div style="line-height: 0.8rem;">充值成功请联系客服人员及时处理，客服电话13107622839</div>
		</div>
		<div id="m-view2" class="m-view2" style="display: none;">
			<img src="${path}/images/zfb.jpg" width="50%" />
			<div style="line-height: 0.8rem;">充值成功请联系客服人员及时处理，客服电话13107622839</div>
		</div>
		<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.js"></script>
		<script type="text/javascript">
			$('#m-return').on('click', function() {
				window.history.back()
			});
			var myCoupons = $('#m-my-coupons');
			var myCoupons2 = $('#m-my-coupons2');
			var myInvite = $('#m-my-invite');
			var view1 = $('#m-view1');
			var view2 = $('#m-view2');
			var view3 = $('#m-view3');
			$('#m-return').on('click', function() {
				window.history.back()
			});
			myInvite.on('click', function() {
				myCoupons.removeClass('active');
				myCoupons2.removeClass('active');
				myInvite.addClass('active');
				view2.hide();
				view3.hide();
				view1.show();
			});
			myCoupons.on('click', function() {
				myInvite.removeClass('active');
				myCoupons2.removeClass('active');
				myCoupons.addClass('active');
				view1.hide();
				view3.hide();
				view2.show();
			});
			myCoupons2.on('click', function() {
				myInvite.removeClass('active');
				myCoupons.removeClass('active');
				myCoupons2.addClass('active');
				view1.hide();
				view3.show();
				view2.hide();
			});
		</script>
	</body>

</html>