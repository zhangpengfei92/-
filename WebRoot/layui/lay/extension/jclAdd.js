layui.define([ 'form', 'layer', 'tree','layedit' ], function(exports) {

	var form = layui.form, $ = layui.jquery, layer = layui.layer,layedit = layui.layedit;

	form.verify({
		// 证件号表单验证
		idNo : function(value) {
			var reg = /^[A-Za-z0-9]+$/;
			if (reg.test(value) == false) {
				return '证件号输入有误，请重新输入';
			}
		},
		// 密码及确认密码表单验证(没有原密码的验证)
		pass : [ /(.+){6,12}$/, '密码必须6到12位' ],
		repass : function(value) {
			var passvalue = $('#L_pass').val();
			if (value != passvalue) {
				return '两次输入的密码不一致!';
			}
		},

		// 密码及确认密码表单验证(有原密码的验证)
		oldPass : function(value) {
			var reg = /(.+){6,12}$/;
			if (reg.test(value) == false) {
				return '密码必须6到12位';
			}
		},
		newPass : function(value) {
			var oldPass = $('#L_oldPass').val();
			if (value == oldPass) {
				return '原密码不能与新密码一致';
			}

			var reg = /(.+){6,12}$/;
			if (reg.test(value) == false) {
				return '密码必须6到12位';
			}

		},
		affirmPass : function(value) {
			var newPass = $('#L_newPass').val();
			if (value != newPass) {
				return '新密码与确认密码不一致';
			}
		},
		// 手机号表单验证
		phone : function(value) {
			var reg = /^(13|15|18|17|14)\d{9}$/;
			if (value.length <= 0) {
				return '不能为空';
			}
			if (reg.test(value) == false) {
				return '手机号格式输入不正确请重新输入';
			}

		},
		
		isNumber : function(value) {
			if (value.length <= 0) {
				return '不能为空';
			}
			if (isNaN(value)) {
				return '请输入数字';
			}
			if (value >= 1) {
				return '请输入小于1的数';
			}
			if (value <= 0) {
				return '请输入大于0的数';
			}
		},
		isValue : function(value) {
			var reg = /^(\d+|\d+\.\d{1,2})$/;
			if (isNaN(value)) {
				return '请输入数字';
			}
			if(reg.test(value) == false){
				return '至多输入小数点后两位';
			}
		},
		isInteger : function(value){
			if (isNaN(value)) {
				return '请输入数字';
			}
			if (value % 1 != 0) {
				return '请输入整数';
			}
		}
	});
	var obj = {
		init : function(path, datecount) {
			
			
			var layinit=layedit.build('demo',{tool:[
				 'strong' //加粗
				  ,'italic' //斜体
				  ,'underline' //下划线
				  ,'del' //删除线
				  ,'|' //分割线 
				  ,'left' //左对齐
				  ,'center' //居中对齐
				  ,'right' //右对齐
			]});
			function refuseTable(){
		          var pars ='?';
                  $(".layui-form input",window.parent.document).each(function(){
               	   if($(this).attr('name')!=undefined){
               		   pars+=$(this).attr('name');
               		   pars+='=';
               		   pars+=$(this).val();
               		   pars+='&';
               	   }
                  });
                  $("select",window.parent.doucment).each(function(){
                	  if($(this).attr('name')!=undefined){
                		  pars+=$(this).attr('name');
                		  pars+='=';
                		  pars+=$(this).find('option:selected').val();
                		  pars+='&';
                	  }
                  });
                  pars=pars.substring(0,pars.length-1);
               
					var closeindex=	parent.layer.msg('数据请求中', {
						icon: 16,
						anim: -1,
						fixed: !1
					});
				  var data=  $(".layui-table",window.parent.document).attr('lay-data');
			         
			 		eval('var layData2='+data);
			    	var options={ 
			    			  height: parent.ConstantHeight 
			    			  ,url:layData2.url+pars
			    			  ,done:function(res, curr, count){
				    				  parent.layer.close(closeindex); 
				    				  parent.layer.msg('成功');
				    			  }
			    			 };
			        var index = parent.layer
			    	.getFrameIndex(window.name);
			    	parent.layer.close(index);
			    	parent.layui.table.reload('test',options);
				
				
			}
			
			
			
			$(".Cancel").click(function() {
				var index = index = parent.layer.getFrameIndex(window.name);
				parent.layer.close(index);
			});
			form.on('submit(formDemo)', function(data) {
				var field = data.field;
				var arguments = "{";
				var index = 0;

				var msg=layedit.getContent(layinit);
				
				for ( var i in field) {
				
					arguments += '"'+i + '":"' + field[i]+'"';
					arguments+=",";
				}
			
				arguments=arguments.substring(0,arguments.length-1);
                arguments+="}";
                var sss= "var log ="+arguments
                eval(sss);
            	if(msg!=undefined||msg!=""){
					log.content=msg;
				}
				$.ajax({
					url : path,
					type : 'post',
					async : false,
					data:log,
					success : function(res) {

						if (res == "inreview") {
							layer.msg('正在审核中,请勿重复提交');
						}
						if(res=="pwdsuccess"){
							$(".Cancel").click();
						}
						if(res=='okFlush'){
							refuseTable();
						}
						if (res == "ok") {
							refuseTable();
						}
						if (res == "failpwd1") {
							layer.msg('账号密码与确认密码不一致');
						}
						if (res == "failpwd2") {
							layer.msg('资金密码与确认密码不一致');
						}
						if (res == "failpwd3") {
							layer.msg('账号密码与交易密码不能一致');
						}
						if (res == "oldPwdError") {
							layer.msg('原密码错误');
						}
						if (res == "repeatPwdError") {
							layer.msg('新密码和确认密码不一致');
						}
						
						if (res == "mimalength1") {
							layer.msg('账号密码必须由 6-16位字母、数字组成');
						}
						if (res == "mimalength2") {
							layer.msg('交易密码必须由 6-16位字母、数字组成');
						}
						if (res == "zhengjianIdno") {
							layer.msg('证件号码不符合要求');
						}
						if (res == "bankexist") {
							layer.msg('银行卡号已经存在');
						}
						
						if (res == "NoOk") {
							layer.msg('失败');
						}
						if (res == "number_NoOk") {
							layer.msg('该编号已存在');
						}
						if (res == "admin_NoOk") {
							layer.msg('该管理员账号已存在');
						}
						if (res == "dailiNum") {
							layer.msg('该代理商编号已经存在');
						}
						
						if (res == "dcError") {
							layer.msg('禁止修改对冲基金的用户名和账号');
						}
						if (res == "coNo_NoOk") {
							layer.msg('该运营中心编号已存在');
						}
						if (res == "marketerNo_NoOk") {
							layer.msg('该招商机构编号已存在');
						}
						if (res == "affiliation") {
							layer.msg('请选择归属');
						}
						if (res == "NotAttractInvestment") {
							layer.msg('请选择招商机构');
						}
						if (res == "accountexist") {
							layer.msg('账户已经存在');
						}
						
						if (res == "length") {
							layer.msg('输入的账号必须是五位数字');
						}
						if (res == "dalilength") {
							layer.msg('代理商编号必须为四位数字');
						}
						
						if (res == "notture") {
							layer.msg('手机号不符合要求');
						}
						if (res == "Telephonexist") {
							layer.msg('号码已经被注册');
						}
						if (res == "idNoexist") {
							layer.msg('证件号码已注册');
						}
						if (res == "exist") {
							layer.msg('数据已存在');
						}
						if (res == "blackList") {
							layer.msg('黑名单用户');
						}
						if (res.indexOf("result") != -1) {
							var str = res.substring(6);
							layer.msg(str);
						}
						if (res == "sendOk") {
							layer.msg('发送成功');
						}
						if (res == "sendNoOk") {
							layer.msg('发送失败');
						}
						if (res == "addResult") {
							layer.msg('分成系数和应为100');
						}
					},
					error : function() {
						layer.msg('系统异常');
					}
				});
				return false;
			});
		}
	};
	exports('jclAdd', obj);
});