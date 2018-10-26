layui
		.define(
				[ 'element', 'layer' ],
				function(exports) {

					var element = layui.element, $ = layui.jquery, layer = layui.layer;

					var obj = {
						init : function(str) {
							var clientHeight = document.body.clientHeight-41-77;
							
							$(".refreshThis").click(function(){
								var $lis = $(".layui-tab-title li");
								if($lis.length==0){
									layer.msg('当前无可刷新页面');
								}else{
									$lis.each(function(){
										if('layui-this'==$(this).attr('class')){
											var compare = $(this).attr('lay-id');
											$('iframe').each(function(){
												if(compare==$(this).attr('lay-id')){
													
													this.contentWindow.location.reload(true);
												}
											});
											return;
										}
									});
								}
							});
							$(".closePageOther").click(function(){
								var $lis = $(".layui-tab-title li");
								if($lis.length==0){
									layer.msg('当前无可关闭的页面');
								}else{
									$lis.each(function(){
										if($(this).attr('class')!='layui-this'){
											$(this).find('i').click();
										}
									});
								}
							});
							$(".closePageAll").click(function(){
								 $(".layui-tab-title li i").click();
							});
							
							$(".changema")
									.click(
											function() {
												layer
														.open({
															title : '修改密码',
															type : 2,
															content : str
																	+ '/login/Alert/loginPwdUpdate',
															area : [ "460px",
																	"330px" ],
															moveOut : true
														});
											});

							$(".close").click(function() {
								layer.confirm('确定要退出吗?', {
									btn : [ '确定', '取消' ],
									btn1 : function(index, layero) {
										 location.href=str+'/login/loginOut';
									}
								});
							});
							$(".oom")
									.click(
											function() {
												var layId = $(this).attr(
														"lay-id");
												var title = $(this).find("a")
														.text();
												var $lis = $(".layui-tab-title li");
												if ($lis.length == 0) {
													element
															.tabAdd(
																	'indextab',
																	{
																		title : title,
																		content : '<iframe src="'
																				+ str
																				+ "/"
																				+ layId
																				+ '/skip'
																				+ '" width="100%" height="'+clientHeight+'px" scrolling ="yes" lay-id="'+layId+'"></iframe>',
																		id : layId
																	});
													element.tabChange(
															'indextab', layId);
												} else {
													var flag = false;
													$lis
															.each(function() {
																if ($(this)
																		.attr(
																				"lay-id") == layId) {
																	flag = true;
																}
															});
													if (flag) {
														element.tabChange(
																'indextab',
																layId);
													} else {
														element
																.tabAdd(
																		'indextab',
																		{
																			title : title,
																			content : '<iframe src="'
																					+ str
																					+ "/"
																					+ layId
																					+ '/skip'
																					+ '" width="100%" height="'+clientHeight+'px" scrolling ="yes" lay-id="'+layId+'"></iframe>',
																			id : layId
																		});
														element.tabChange(
																'indextab',
																layId);
													}
												}
											});
						}
					};

					exports('slidTab', obj);
				});