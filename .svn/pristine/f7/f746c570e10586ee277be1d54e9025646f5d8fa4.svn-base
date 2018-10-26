/** 表单验证组件 * */
(function($) {
	
$.extend($.fn, {
	
	validate : function(options) {
		if (!this.length) {
			return;
		}

		var validator = $.data(this[0], 'validator');
		if (validator) {
			return validator;
		}

		validator = new $.validator(options, this[0]);
		$.data(this[0], 'validator', validator);
		// 表单提交时进行验证设置为有效
		if (validator.settings.onsubmit) {
			// allow suppresing validation by adding a cancel class to the
			// submit button
			// .cancel样式的按钮点击事件触发
			this.find("input, button").filter(".cancel").click(function() {
				validator.cancelSubmit = true;
			});

			// when a submitHandler is used, capture the submitting button
			// 当submitHandler设置为有效时，type为submit的按钮为提交按钮
			if (validator.settings.submitHandler) {
				this.find("input, button").filter(":submit").click(function() {
					validator.submitButton = this;
				});
			}

			// validate the form on submit
			this.submit(function(event) {
				if (validator.settings.debug)
					// prevent form submit to be able to see console output
					event.preventDefault();

				function handle() {
					// 去除表单中录入数据的前后空白字符
					trimForm(validator.currentForm);
					if (validator.settings.submitHandler) {
						if (validator.submitButton) {
							// insert a hidden input as a replacement for the
							// missing submit button
							var hidden = $("<input type='hidden'/>").attr(
									"name", validator.submitButton.name)
									.val(validator.submitButton.value)
									.appendTo(validator.currentForm);
						}
						// submitHandler函数输入参数为当前验证的表单对象
						validator.settings.submitHandler.call(validator,
								validator.currentForm);
						if (validator.submitButton) {
							// and clean up afterwards; thanks to
							// no-block-scope, hidden can be referenced
							hidden.remove();
						}
						//去除submitHandler固定返回false约束，返回true
						return false;
					}
					if(validator.settings.submitTip){//表单提交时使用提示信息
						showLoadingTip("数据正在提交，请稍候...")
					}
					
					return true;
				}

				// prevent submit for invalid forms or custom submit handlers
				if (validator.cancelSubmit) {
					validator.cancelSubmit = false;
					return handle();
				}
				// 验证表单方法
				if (validator.form()) {
					if (validator.pendingRequest) {
						validator.formSubmitted = true;
						return false;
					}
					return handle();
				} else {
					validator.focusInvalid();
					return false;
				}
			});
			$(this)[0].onSubmit = function(event){
				if (validator.settings.debug)
					// prevent form submit to be able to see console output
					event.preventDefault();

				function handle() {
					// 去除表单中录入数据的前后空白字符
					trimForm(validator.currentForm);
					if (validator.settings.submitHandler) {
						if (validator.submitButton) {
							// insert a hidden input as a replacement for the
							// missing submit button
							var hidden = $("<input type='hidden'/>").attr(
									"name", validator.submitButton.name)
									.val(validator.submitButton.value)
									.appendTo(validator.currentForm);
						}
						// submitHandler函数输入参数为当前验证的表单对象
						validator.settings.submitHandler.call(validator,
								validator.currentForm);
						if (validator.submitButton) {
							// and clean up afterwards; thanks to
							// no-block-scope, hidden can be referenced
							hidden.remove();
						}
						//去除submitHandler固定返回false约束，返回true
						//return false;
					}
					return true;
				}

				// prevent submit for invalid forms or custom submit handlers
				if (validator.cancelSubmit) {
					validator.cancelSubmit = false;
					return handle();
				}
				// 验证表单方法
				if (validator.form()) {
					if (validator.pendingRequest) {
						validator.formSubmitted = true;
						return false;
					}
					return handle();
				} else {
					validator.focusInvalid();
					return false;
				}
			};
		}
		return validator;
	},
	// http://docs.jquery.com/Plugins/Validation/valid
	valid : function() {
		if ($(this[0]).is('form')) {
			return this.validate().form();
		} else {
			var valid = true;
			var validator = $(this[0].form).validate();
			this.each(function() {
				valid &= validator.element(this);
			});
			return valid;
		}
	},
	// attributes: space seperated list of attributes to retrieve and remove
	removeAttrs : function(attributes) {
		var result = {}, $element = this;
		$.each(attributes.split(/\s/), function(index, value) {
			result[value] = $element.attr(value);
			$element.removeAttr(value);
		});
		return result;
	},
	// http://docs.jquery.com/Plugins/Validation/rules
	rules : function(command, argument) {
		var element = this[0];

		if (command) {
			var settings = $.data(element.form, 'validator').settings;
			var staticRules = settings.rules;
			var existingRules = $.validator.staticRules(element);
			switch (command) {
				case "add" :
					$
							.extend(existingRules, $.validator
									.normalizeRule(argument));
					staticRules[element.name] = existingRules;
					if (argument.messages)
						settings.messages[element.name] = $.extend(
								settings.messages[element.name],
								argument.messages);
					break;
				case "remove" :
					if (!argument) {
						delete staticRules[element.name];
						return existingRules;
					}
					var filtered = {};
					$.each(argument.split(/\s/), function(index, method) {
						filtered[method] = existingRules[method];
						delete existingRules[method];
					});
					return filtered;
			}
		}

		var data = $.validator.normalizeRules($.extend({}, $.validator
				.metadataRules(element), $.validator.classRules(element),
				$.validator.attributeRules(element), $.validator
						.staticRules(element)), element);

		// make sure required is at front
		if (data.required) {
			var param = data.required;
			delete data.required;
			data = $.extend({
				required : param
			}, data);
		}

		return data;
	}
});

// Custom selectors
$.extend($.expr[":"], {
	// http://docs.jquery.com/Plugins/Validation/blank
	blank: function(a) {return !$.trim(a.value);},
	// http://docs.jquery.com/Plugins/Validation/filled
	filled: function(a) {return !!$.trim(a.value);},
	// http://docs.jquery.com/Plugins/Validation/unchecked
	unchecked: function(a) {return !a.checked;}
});

// constructor for validator
$.validator = function( options, form ) {
	this.settings = $.extend( {}, $.validator.defaults, options );
	this.currentForm = form;
	this.init();
};

//处理range等验证方法的错误信息
$.validator.format = function(source, params) {
	if ( arguments.length == 1 )
		//返回给message一个function
		return function() {
			var args = $.makeArray(arguments);
			args.unshift(source);
			//重新调用format方法
			return $.validator.format.apply( this, args );
		};
	if ( arguments.length > 2 && params.constructor != Array  ) {
		params = $.makeArray(arguments).slice(1);
	}
	if ( params.constructor != Array ) {
		params = [ params ];
	}
	var reg = new RegExp("\\{\\d+\\}");
	$.each(params, function(i, n) {
		//source = source.replace(new RegExp("\\{" + i + "\\}", "g"), n);
		source = source.replace(reg, n);
	});
	return source;
};

// 处理range等验证方法的错误信息，取代$.validator.format()方法，直接使用‘，’分隔而不采用数组形式
$.validator.formatString = function(source, params) {
	if (arguments.length == 1){
		// 返回给message一个function
		return function() {
			var args = $.makeArray(arguments);
			args.unshift(source);
			// 重新调用formatString方法
			return $.validator.formatString.apply(this, args);
		};
	}
	if (arguments.length > 2 && params.constructor != Array) {
		params = params.toString();//在某些情况下将params从Number转换为String类型
		params = $.makeArray(params.split(","));
	}
	if (params.constructor != Array) {
		params = [params];
	}
	var reg = new RegExp("\\{\\d+\\}");
	$.each(params, function(i, n) {
		//source = source.replace(new RegExp("\\{" + i + "\\}", "g"), n);
		source = source.replace(reg, n);
	});
	return source;
};

$.extend($.validator, {
	
	defaults: {
		//错误提示信息
		messages: {},
		groups: {},
		//表单验证规则
		rules: {},
		//验证错误的展现样式名称，高亮有效时使用
		errorClass: "tip_input",
		//验证错误的展现样式名称，高亮无效时使用
		validClass: "",
		tipClass: "tooltip",//采用tip信息展现方式时，验证错误提示信息主体样式名称
		errorElement: "label",
		//聚焦验证未通过的元素
		focusInvalid: true,
		errorContainer: $( [] ),
		errorLabelContainer: $( [] ),
		//是否在表单提交时进行验证
		onsubmit: true,
		//忽略掉的表单元素，即不进行表单验证
		ignore: [],
		ignoreTitle: false,
		submitTip: true,//表单提交时是否展示提示信息,依赖于common.js
		onfocusin : function(element) {
			var classes = $(element).attr("class");
			
			if(classes == undefined || classes.indexOf('tip_input') < 0) { 
				return;
			}
		},
		// 取消onkeyup验证事件
		onkeyup : function(element) {
			
		},
		onkeydown : function(element) {
			var obj = $(element);
			if(!obj.attr('class')) {
				return;
			}
		},

		onfocusout : function(element) {
			var obj = $(element);
			var className = obj.attr('class');
			if(className == undefined || className.indexOf('tip_input') < 0) {
				//没有验证
				return;
			}
			$(element).removeClass('tip_input');
			$(element).poshytip('destroy');
		},
		onclick: function(element) {
			if (this.checkable(element)) {
				this.element(element);
			}
		},
		//高亮验证错误的表单元素		highlight: function( element, errorClass, validClass ) {
			$(element).addClass(errorClass).removeClass(validClass);
		},
		//不高亮验证错误的表单元素
		unhighlight: function( element, errorClass, validClass ) {
			$(element).removeClass(errorClass).addClass(validClass);
		}
	},

	// http://docs.jquery.com/Plugins/Validation/Validator/setDefaults
	setDefaults: function(settings) {
		$.extend( $.validator.defaults, settings );
	},
	//默认的验证错误提示信息
	messages: {
		required : "errors_required",
		remote : "errors_remote",
		email : "errors_email",
		url : "errors_url",
		date : "errors_date",
		dateISO : "errors_dateISO",
		dateDE : "errors_dateDE",
		number : "errors_number",
		numberDE : "errors_numberDE",
		digits : "errors_digits",
		creditcard : "errors_creditcard",
		equalTo : "errors_equalTo",
		accept : "errors_accept",
		maxlength : "errors_maxlength",
		minlength : "errors_minlength",
		rangelength : "errors_rangelength",
		range : "errors_range",
		max : "errors_max",
		min : "errors_min"
	},
	
	autoCreateRanges: false,
	
	prototype: {
		
		/**
		 * 根据errorLabel得到对应的控件元素的Jquery对象
		 * @param {} $error -错误页面
		 * @return 对应的控件元素Jquery对象
		 */
		_getElementByError: function($error){
			var idOrName = $error.attr("for");
			//id为idOrName
			var element = $("#" + idOrName);
			if(!element[0]){//如果idOrName不是id值，则是name值
				element = $("*[name='" + idOrName + "']");
			}
			if(!element[0]){//如果Id和name都不存在，则该元素不存在
				return null;
			}
			return element;
		},
		
		/**
		 * 根据页面控件元素找到该元素同一行最后一个Input、a或img元素
		 * @param {} $element -页面控件Jquery对象
		 * @return 对应的控件元素Jquery对象
		 */
		_getLastElement: function($element){
			var element1 = $element;
			
			if($element.attr("tagFlag") && $element.attr("tagFlag") == "numberInput"){//如果是页面的标签控件，如货币、数量标签
				var idOrName = this.idOrName($element[0]);
				idOrName = "_" + idOrName;//查找货币、数量标签的展现控件
				//id为idOrName
				var element1 = $("#" + idOrName);
				if(!element1[0]){//如果idOrName不是id值，则是name值
					element1 = $("*[name='" + idOrName + "']");
				}
			}
			
			//如果element后面是input、a、img元素则error label放在这些元素后面
			while($(element1).next()[0] && /input|a|img/i.test($(element1).next()[0].tagName) && "block" == $(element1).next().attr("display")){
				element1 = $(element1).next();
			}
			return element1;
		},
			
		/**
		 * 设置errorLabel的大小和位置
		 * @param {} $element -在该元素后面放置errorLabel
		 * @param {} $errorLabel -要放置的errorLabel
		 */
		_placeErrorLabel: function($element, $errorLabel){
			var pos = $element.position();//element1相对于视窗的位置
			var dim = {width:$element.outerWidth(), height:$element.outerHeight()};//element1的实际高度和宽度
			
			var dim2 = {width:$errorLabel.width(), height:$errorLabel.height()};//error label的高度和宽度
			var scrolltop = 0;
			var scrollleft = 0;
			var parentElement = $element;
			parentElement = $(parentElement.parent());
			while(parentElement[0]){//element1的滚动宽度和高度
				if(parentElement[0].tagName && parentElement[0].tagName.toLowerCase() == "body"){
					if($errorLabel.parent()[0].tagName && $errorLabel.parent()[0].tagName.toLowerCase() == "body"){//如果label的父容器就是body，则需要考虑body的滚动距离
						scrolltop = scrolltop + parentElement[0].scrollTop;
						scrollleft = scrollleft + parentElement[0].scrollLeft;
					}
					break;
				}
				scrolltop = scrolltop + parentElement[0].scrollTop;
				scrollleft = scrollleft + parentElement[0].scrollLeft;
				
				parentElement = $(parentElement.parent());
			}
			$errorLabel.css({ "left":"" + (pos.left + scrollleft), "top":"" + (pos.top + scrolltop - dim2.height - 7)});
			$errorLabel.css({"width":dim2.width + 1, "height": dim2.height});
			dim2 = {width:$errorLabel.width(), height:$errorLabel.height()};//重新获取error label的高度和宽度
			$errorLabel.css({"left":"" + (pos.left + scrollleft) + "px","top":"" + (pos.top + scrolltop - dim2.height - 7) + "px" });
		},
		
		/**
		 * 当前窗口大小变化时改变error label的相对视窗的位置
		 */
		windowResize: function(){
			// 增加 孟得宝
			var erroElement = this.settings.errorElement || $.validator.defaults.errorElement;
			// 增加 孟得宝
			var tipClass = this.settings.tipClass || $.validator.defaults.tipClass;
			//修改 孟得宝
			//var errorLabels = $($.validator.defaults.errorElement + "." + $.validator.defaults.tipClass.split(" ")[0]);
			var errorLabels = $(erroElement + "." + tipClass);
			
			var vOjb = this;
			$.each(errorLabels, function(index, errorLabel){
				var width = $(errorLabel).width();//保存窗口变换之前的宽度
				var height = $(errorLabel).height();//保存窗口变换之前的高度
				
				$(errorLabel).css({"width":"","height":""});
				var element = vOjb._getElementByError($(errorLabel));
				if(!element || !element[0]){//如果Id和name都不存在，则该元素不存在
					return;
				}
				//如果element后面是input、a、img元素则error label放在这些元素后面
				var element1 = vOjb._getLastElement(element);
				
				var pos = $(element1).position();//element1相对于视窗的位置
				var dim = {width:$(element1).outerWidth(), height:$(element1).outerHeight()};//element1的实际高度和宽度
				
				if($(errorLabel).width() < width){//如果变换之后的label宽度小于之前的宽度，则label保持之前的宽度和高度不变
					$(errorLabel).css({"width":width,"height":height});
				}else{
					$(errorLabel).css({"width":"" + $(errorLabel).width(), "height":"" + $(errorLabel).height()});
				}
				
				vOjb._placeErrorLabel(element1, $(errorLabel));
			});
		},
		
		//初始化函数
		init: function() {
			this.labelContainer = $(this.settings.errorLabelContainer);
			this.container = $(this.settings.container);
			//若设置了错误标签展现容器则返回错误标签展现容器，否则返回当前表单
			this.errorContext = this.labelContainer.length && this.labelContainer || $(this.currentForm);
			//将错误标签展现容器加入到错误展现容器中
			this.containers = $(this.settings.errorContainer).add( this.settings.errorLabelContainer );
			//已经处理过的页面元素，为对象
			this.submitted = {};
			this.valueCache = {};
			this.pendingRequest = 0;
			this.pending = {};
			this.invalid = {};
			//表单重置函数
			this.reset();
			
			var groups = (this.groups = {});
			$.each(this.settings.groups, function(key, value) {
				$.each(value.split(/\s/), function(index, name) {
					groups[name] = key;
				});
			});
			//表单验证策略，key为表单元素Id，value为表单元素验证策略
			var rules = this.settings.rules;
			$.each(rules, function(key, value) {
				rules[key] = $.validator.normalizeRule(value);
			});
			//处理设置的代理事件，当相应时间发生时回调用户自定义的事件处理函数function
			function delegate(event) {
				var validator = $.data(this[0].form, "validator");
				validator.settings["on" + event.type] && validator.settings["on" + event.type].call(validator, this[0] );
			}
			$(this.currentForm)
				.delegate("focusin focusout keyup keydown", ":text, :password, :file, select, textarea", delegate)
				.delegate("click", ":radio, :checkbox", delegate);

			if (this.settings.invalidHandler)
				$(this.currentForm).bind("invalid-form.validate", this.settings.invalidHandler);
		},
		
		// http://docs.jquery.com/Plugins/Validation/Validator/form
		//表单元素验证，通过则返回true，不通过则返回false
		form: function() {
			this.checkForm();
			$.extend(this.submitted, this.errorMap);
			this.invalid = $.extend({}, this.errorMap);
			if (!this.valid())
				$(this.currentForm).triggerHandler("invalid-form", [this]);
			this.showErrors();
			return this.valid();
		},
		//对表单中每个要验证的元素进行验证
		checkForm: function() {
			this.prepareForm();
			for ( var i = 0, elements = (this.currentElements = this.elements()); elements[i]; i++ ) {
				this.check( elements[i] );
			}
			return this.valid(); 
		},
		
		// http://docs.jquery.com/Plugins/Validation/Validator/element
		//验证单个表单元素，通过则返回true，未通过则返回false
		//这个函数行为类似validation的on blur 和on keyup事件，但是会返回结果result
		element: function( element ) {
			element = this.clean( element );
			this.lastElement = element;
			this.prepareElement( element );
			this.currentElements = $(element);
			var result = this.check( element );
			if ( result ) {
				delete this.invalid[element.name];
			} else {
				this.invalid[element.name] = true;
			}
			if ( !this.numberOfInvalids() ) {
				// Hide error containers on last error
				this.toHide = this.toHide.add( this.containers );
			}
			this.showErrors();
			return result;
		},
		
		//找到当前被验证的表单内的第一个文本框的ID
		firstId : function () {
			return $("#" + this.container[0].id + " input:text")[0].id;
		},

		// http://docs.jquery.com/Plugins/Validation/Validator/showErrors
		// Show the specified messages.
		// Keys have to refer to the names of elements, values are displayed for those elements, using the configured error placement.
		// var validator = $("#myform").validate();
		// validator.showErrors({"firstname": "I know that your firstname is Pete, Pete!"});
		showErrors: function(errors) {
			if(errors) {
				// add items to error list and map
				$.extend( this.errorMap, errors );
				this.errorList = [];
				var _form_firstId = this.firstId();
				for ( var name in errors ) {
					//errorList中保存的message为字符串，element为页面元素类型即Element
					this.errorList.push({
						message: errors[name],
						first: name == _form_firstId ? true : false,
						element: this.findByName(name)[0]
					});
				}
				// remove items from success list
				// 从successList中移除验证错误的元素
				this.successList = $.grep( this.successList, function(element) {
					return !(element.name in errors);
				});
			}
			//如果设置了showErrors处理函数，则执行该处理函数，该函数输入参数为validator、errorMap和errorList
			//否则执行默认defaultShowErrors()方法
			this.settings.showErrors
				? this.settings.showErrors.call( this, this.errorMap, this.errorList )
				: this.defaultShowErrors();
		},
		
		// http://docs.jquery.com/Plugins/Validation/Validator/resetForm
		//重置整个表单，消除表单验证错误的提示信息
		//已提交元素置为空
		resetForm: function() {
			if ( $.fn.resetForm )
				$( this.currentForm ).resetForm();
			this.submitted = {};
			this.prepareForm();
			this.hideErrors();
			this.elements().removeClass( this.settings.errorClass );
		},
		
		//验证通过的元素个数
		numberOfInvalids: function() {
			return this.objectLength(this.invalid);
		},
		
		//计算对象属性个数
		objectLength: function( obj ) {
			var count = 0;
			for ( var i in obj ){
				count++;
			}
			return count;
		},
		
		hideErrors: function() {
			this.addWrapper( this.toHide ).hide();
		},
		//表单验证错误元素长度是否等于0，即验证是否成功
		valid: function() {
			return this.size() == 0;
		},
		//表单验证错误元素长度
		size: function() {
			return this.errorList.length;
		},
		
		focusInvalid: function() {
			if( this.settings.focusInvalid ) {
				try {
					var obj = $.find(".tip_input");
					if(obj && obj.length > 0) {
						obj[0].focus();
					}
					
				} catch(e) {
					try{
						$(this.findLastActive() || this.errorList.length && this.errorList[0].element || []).filter(":visible").focus();
					} catch (e) {
						// ignore IE throwing errors when focusing hidden elements
					}
				}
			}
		},
		
		findLastActive: function() {
			var lastActive = this.lastActive;
			return lastActive && $.grep(this.errorList, function(n) {
				return n.element.name == lastActive.name;
			}).length == 1 && lastActive;
		},
		
		//返回一个数组，该数组中是需要验证的表单元素，元素类型为“input”并且验证策略不为空
		elements: function() {
			var validator = this,
				rulesCache = {};
			
			// select all valid inputs inside the form (no submit or reset buttons)
			// workaround $Query([]).add until http://dev.jquery.com/ticket/2114 is solved
			return $([]).add(this.currentForm.elements)
			.filter(":input")
			.not(":submit, :reset, :image, [disabled]")
			.not( this.settings.ignore )
			.filter(function() {
				!this.name && validator.settings.debug && window.console && console.error( "%o has no name assigned", this);
			
				// select only the first element for each name, and only those with rules specified
				//每个名字的元素只选择一个并且该元素的验证策略不为空
				//修改成非选择性元素可以重名
				if ( (this.name in rulesCache && /radio|checkbox/i.test(this.type)) || !validator.objectLength($(this).rules()) )
					return false;
				
				rulesCache[this.name] = true;
				return true;
			});
		},
		//获取dom对象
		clean: function( selector ) {
			return $( selector )[0];
		},
		
		//所有error label
		//errors: function() {
		//	return $( this.settings.errorElement + "." + this.settings.errorClass, this.errorContext );
		//},
		
		//所有error label
		errors: function() {
			//update by mengdb
			return $( this.settings.errorElement + "." + this.settings.tipClass.split(" ")[0]);
		},
		
		reset: function() {
			this.successList = [];
			this.errorList = [];
			this.errorMap = {};
			this.toShow = $([]);
			this.toHide = $([]);
			this.formSubmitted = false;
			this.currentElements = $([]);
		},
		//预备表单
		prepareForm: function() {
			this.reset();
			this.toHide = this.errors().add( this.containers );
		},
		//预备表单元素
		prepareElement: function( element ) {
			this.reset();
			this.toHide = this.errorsFor(element);
		},
		
		check: function( element ) {
			element = this.clean( element );
			
			// if radio/checkbox, validate first element in group instead
			//如果是radio或checkbox类型的表单元素，则验证相同Name的一个元素
			if (this.checkable(element)) {
				element = this.findByName( element.name )[0];
			}
			//获取到该元素下的验证策略信息
			var rules = $(element).rules();
			var dependencyMismatch = false;
			//循环验证策略中的每一个策略
			for( method in rules ) {
				var rule = { method: method, parameters: rules[method] };
				try {
					//验证函数，输入参数为validator、元素值、元素及验证策略参数
					var result = $.validator.methods[method].call( this, element.value.replace(/\r/g, ""), element, rule.parameters );
					// if a method indicates that the field is optional and therefore valid,
					// don't mark it as valid when there are no other rules
					if ( result == "dependency-mismatch" ) {
						dependencyMismatch = true;
						continue;
					}
					dependencyMismatch = false;
					if ( result == "pending" ) {
						this.toHide = this.toHide.not( this.errorsFor(element) );
						return;
					}
					
					if( !result ) {
						this.formatAndAdd( element, rule );
						return false;
					}
				} catch(e) {
					this.settings.debug && window.console && console.log("exception occured when checking element " + element.id
						 + ", check the '" + rule.method + "' method");
					throw e;
				}
			}
			if (dependencyMismatch)
				return true;
			if ( this.objectLength(rules) )
				this.successList.push(element);
			return true;
		},
		
		// return the custom message for the given element and validation method
		// specified in the element's "messages" metadata
		customMetaMessage: function(element, method) {
			if (!$.metadata)
				return;
			
			var meta = this.settings.meta
				? $(element).metadata()[this.settings.meta]
				: $(element).metadata();
			
			return meta && meta.messages && meta.messages[method];
		},
		
		// return the custom message for the given element name and validation method
		customMessage: function( name, method ) {
			var m = this.settings.messages[name];
			return m && (m.constructor == String
				? m
				: m[method]);
		},
		
		// return the first defined argument, allowing empty strings
		//找到第一个传入的有效参数
		findDefined: function() {
			var index = new RegExp("\\{\\d+\\}");
			for(var i = 0; i < arguments.length; i++) {
				if (arguments[i] !== undefined){
					var argumentsI = eval(arguments[i]);
					if(index.test(argumentsI)){//若message中包含{0}的参数传入格式，则作为函数处理
						return $.validator.formatString(argumentsI);
					}else{
						return argumentsI;
					}
				}
			}
			return undefined;
		},
		
		//获取验证错误提示信息
		//1.用户在Html控件中自定义的验证错误信息
		//2.用户自定义信息
		//3.用户自定义meta信息
		//4.元素的title属性信息
		//5.validator默认提供的信息
		//6.提示没有为该属性配置错误提示信息
		defaultMessage: function( element, method) {
			return this.findDefined(
				$(element).attr(method + "Msg")?$(element).attr(method + "Msg"):undefined,//添加Html控件中的自定义验证错误信息
				this.customMessage( element.name, method ),
				this.customMetaMessage( element, method ),
				// title is never undefined, so handle empty string as undefined
				!this.settings.ignoreTitle && element.title || undefined,
				$.validator.messages[method],
				"<strong>Warning: No message defined for " + element.name + "</strong>"
			);
		},
		
		//表单元素验证出错后的处理，并将相应出错信息加入errorList、errorMap、submitted中去
		formatAndAdd: function( element, rule ) {
			var message = this.defaultMessage( element, rule.method );
			//表单验证错误的处理信息可以是回调函数
			if ( typeof message == "function" ){
				//该回调函数的输入参数为 验证策略的参数 和 验证的表单元素，同时需要返回验证错误信息
				//用于$.validator.format处
				message = message.call(this, rule.parameters, element);
			}
			this.errorList.push({
				message: message,
				element: element
			});
			//出错map，存储内容为 key为表单元素Id值，value为出错提示信息
			this.errorMap[element.name] = message;
			//已经验证过的元素，存储内容为 key为表单元素Id值，value为出错提示信息
			this.submitted[element.name] = message;
		},
		
		//利用设置中的元素包裹toToggle元素
		addWrapper: function(toToggle) {
			if ( this.settings.wrapper )
				toToggle = toToggle.add( toToggle.parent( this.settings.wrapper ) );
			return toToggle;
		},
		
		//默认错误显示函数
		defaultShowErrors: function() {
			for ( var i = 0; this.errorList[i]; i++ ) {
				var error = this.errorList[i];
				this.settings.highlight && this.settings.highlight.call( this, error.element, this.settings.errorClass, this.settings.validClass );
				this.showLabel(error.element, error.message, error.first);
			}
			if( this.errorList.length ) {
				this.toShow = this.toShow.add( this.containers );
			}
			if (this.settings.success) {
				for ( var i = 0; this.successList[i]; i++ ) {
					this.showLabel( this.successList[i] );
				}
			}
			if (this.settings.unhighlight) {
				for ( var i = 0, elements = this.validElements(); elements[i]; i++ ) {
					this.settings.unhighlight.call( this, elements[i], this.settings.errorClass, this.settings.validClass );
				}
			}
			this.toHide = this.toHide.not( this.toShow );
			this.hideErrors();
			this.addWrapper( this.toShow ).show();
		},
		
		validElements: function() {
			return this.currentElements.not(this.invalidElements());
		},
		
		//返回验证错误的表单元素		invalidElements: function() {
			return $(this.errorList).map(function() {
				return this.element;
			});
		},
		
		showLabel: function(element, message, first) {
			element.title = message;
			var _f_e_cls = $(element).attr('class');
			if (_f_e_cls == null || _f_e_cls.indexOf('tip_input') < 0) {
				$(element).addClass('tip_input');
			}
			if (first) {
				$("#" + element.id).poshytip({
					className: 'tip-yellow',
					showOn: 'focus',
					alignTo: 'target',
					alignX: 'inner-left',
					alignY: 'bottom',
					offsetX: 0,
					offsetY: 5
				});
			} else {
				$("#" + element.id).poshytip({
					className: 'tip-yellow',
					showOn: 'focus',
					alignTo: 'target',
					alignX: 'inner-left',
					offsetX: 0,
					offsetY: 5
				});
			}
			
		},
		
		//根据error label的for属性寻找element的error label
		errorsFor: function(element) {
			return this.errors().filter("[for='" + this.idOrName(element) + "']");
		},
		
		idOrName: function(element) {
			return this.groups[element.name] || (this.checkable(element) ? element.name : element.id || element.name);
		},
		
		//判断元素是否是radio或checkbox类型
		checkable: function( element ) {
			return /radio|checkbox/i.test(element.type);
		},
		
		//从表单中查找符合条件的name = ‘name’的元素集合
		findByName: function( name ) {
			// select by name and filter by form for performance over form.find("[name=...]")
			//从表单中查找name = ‘name’的元素集合
			var form = this.currentForm;
			return $(document.getElementsByName(name)).map(function(index, element) {
				//该判断返回element或null
				return element.form == form && element.name == name && element  || null;
			});
		},
		
		//1. 返回select元素选中的项的个数		//2. 返回radio或checkbox元素选中的项的个数		//3. 返回元素值的长度
		getLength: function(value, element) {
			switch( element.nodeName.toLowerCase() ) {
			case 'select':
				if(element.multiple) {
					return $("option", element).length;
				} else {
					return $("option:selected", element).length;
				}
				
			case 'input':
				if( this.checkable( element) ){
					return this.findByName(element.name).filter(':checked').length;
				}
			}
			return value.length;
		},
	
		//返回true 或者 false
		depend: function(param, element) {
			return this.dependTypes[typeof param]
				? this.dependTypes[typeof param](param, element)
				: true;
		},
	
		//返回true 或者 false
		dependTypes: {
			"boolean": function(param, element) {
				return param;
			},
			"string": function(param, element) {
				return !!$(param, element.form).length;
			},
			"function": function(param, element) {
				return param(element);
			}
		},
		
		//判断该元素是否可选的，若是可选则不要求必填
		optional: function(element) {
			return !$.validator.methods.required.call(this, $.trim(element.value), element) && "dependency-mismatch";
		},
		
		//
		startRequest: function(element) {
			if (!this.pending[element.name]) {
				this.pendingRequest++;
				this.pending[element.name] = true;
			}
		},
		
		//
		stopRequest: function(element, valid) {
			this.pendingRequest--;
			// sometimes synchronization fails, make sure pendingRequest is never < 0
			if (this.pendingRequest < 0)
				this.pendingRequest = 0;
			delete this.pending[element.name];
			if ( valid && this.pendingRequest == 0 && this.formSubmitted && this.form() ) {
				$(this.currentForm).submit();
			} else if (!valid && this.pendingRequest == 0 && this.formSubmitted) {
				$(this.currentForm).triggerHandler("invalid-form", [this]);
			}
		},
		
		previousValue: function(element) {
			return $.data(element, "previousValue") || $.data(element, "previousValue", previous = {
				old: null,
				valid: true,
				message: this.defaultMessage( element, "remote" )
			});
		}
		
	},
	
	//经典验证策略设置
	classRuleSettings: {
		required: {required: true},
		email: {email: true},
		url: {url: true},
		date: {date: true},
		dateISO: {dateISO: true},
		dateDE: {dateDE: true},
		number: {number: true},
		numberDE: {numberDE: true},
		digits: {digits: true},
		creditcard: {creditcard: true}
	},
	
	//添加验证策略，className为String时取经典验证策略；不为String时添加策略到经典策略中
	addClassRules: function(className, rules) {
		className.constructor == String ?
			this.classRuleSettings[className] = rules :
			$.extend(this.classRuleSettings, className);
	},
	
	//取element中的class属性，并将以' '分隔的验证属性加入到rules中
	classRules: function(element) {
		var rules = {};
		var classes = $(element).attr('class');
		classes && $.each(classes.split(' '), function() {
			if (this in $.validator.classRuleSettings) {
				$.extend(rules, $.validator.classRuleSettings[this]);
			}
		});
		return rules;
	},
	
	//利用class外的属性来设置验证策略，并将其值读到rules中
	attributeRules: function(element) {
		var rules = {};
		var $element = $(element);
		
		for (method in $.validator.methods) {
			var value = $element.attr(method);
			if (value) {
			    if(value === "true"){//如果值为"true"，设置required的值为true
			    	rules[method] = true;
			    }else if(value === "false"){
			        rules[method] = false;
			    }else{
			    	rules[method] = value;
			    }
			}
		}
		
		// maxlength may be returned as -1, 2147483647 (IE) and 524288 (safari) for text inputs
		if (rules.maxlength && /-1|2147483647|524288/.test(rules.maxlength)) {
			delete rules.maxlength;
		}
		
		return rules;
	},
	
	metadataRules: function(element) {
		if (!$.metadata) return {};
		
		var meta = $.data(element.form, 'validator').settings.meta;
		return meta ?
			$(element).metadata()[meta] :
			$(element).metadata();
	},
	
	staticRules: function(element) {
		var rules = {};
		var validator = $.data(element.form, 'validator');
		if (validator.settings.rules) {
			rules = $.validator.normalizeRule(validator.settings.rules[element.name]) || {};
		}
		return rules;
	},
	
	normalizeRules: function(rules, element) {
		// handle dependency check
		$.each(rules, function(prop, val) {
			// ignore rule when param is explicitly false, eg. required:false
			if (val === false) {
				delete rules[prop];
				return;
			}
			if (val.param || val.depends) {
				var keepRule = true;
				switch (typeof val.depends) {
					case "string":
						keepRule = !!$(val.depends, element.form).length;
						break;
					case "function":
						keepRule = val.depends.call(element, element);
						break;
				}
				if (keepRule) {
					rules[prop] = val.param !== undefined ? val.param : true;
				} else {
					delete rules[prop];
				}
			}
		});
		
		// evaluate parameters
		$.each(rules, function(rule, parameter) {
			rules[rule] = $.isFunction(parameter) ? parameter(element) : parameter;
		});
		
		// clean number parameters
		$.each(['minlength', 'maxlength', 'min', 'max'], function() {
			if (rules[this]) {
				rules[this] = Number(rules[this]);
			}
		});
		
		$.each(['rangelength', 'range'], function() {
			if (rules[this]) {
				rules[this] = [Number(rules[this][0]), Number(rules[this][1])];
			}
		});
		
		if ($.validator.autoCreateRanges) {
			// auto-create ranges
			if (rules.min && rules.max) {
				rules.range = [rules.min, rules.max];
				delete rules.min;
				delete rules.max;
			}
			if (rules.minlength && rules.maxlength) {
				rules.rangelength = [rules.minlength, rules.maxlength];
				delete rules.minlength;
				delete rules.maxlength;
			}
		}
		
		// To support custom messages in metadata ignore rule methods titled "messages"
		if (rules.messages) {
			delete rules.messages;
		}
		
		return rules;
	},
	
	// Converts a simple string to a {string: true} rule, e.g., "required" to {required:true}
	normalizeRule: function(data) {
		if( typeof data == "string" ) {
			var transformed = {};
			$.each(data.split(/\s/), function() {
				transformed[this] = true;
			});
			data = transformed;
		}
		return data;
	},
	
	// http://docs.jquery.com/Plugins/Validation/Validator/addMethod
	//添加验证策略实现方法
	//method函数的输入参数为：value、element、param
	addMethod: function(name, method, message) {
		$.validator.methods[name] = method;
		$.validator.messages[name] = message || $.validator.messages[name];
		if (method.length < 3) {
			$.validator.addClassRules(name, $.validator.normalizeRule(name));
		}
	},

	methods: {
		// http://docs.jquery.com/Plugins/Validation/Methods/required
		required: function(value, element, param) {
			// check if dependency is met
			if ( !this.depend(param, element) )
				return "dependency-mismatch";
			switch( element.nodeName.toLowerCase() ) {
			case 'select':
				var options = $("option:selected", element);
				return options.length > 0 && ( element.type == "select-multiple" || ($.browser.msie && !(options[0].attributes['value'].specified) ? options[0].text : options[0].value).length > 0);
			case 'input':
				if ( this.checkable(element) )
					return this.getLength(value, element) > 0;
			default:
				return $.trim(value).length > 0;
			}
		},
		
		// http://docs.jquery.com/Plugins/Validation/Methods/remote
		remote: function(value, element, param) {
			if ( this.optional(element) )
				return "dependency-mismatch";
			
			var previous = this.previousValue(element);
			
			if (!this.settings.messages[element.name] )
				this.settings.messages[element.name] = {};
			this.settings.messages[element.name].remote = typeof previous.message == "function" ? previous.message(value) : previous.message;
			//该条件表达式返回{url:param}或param
			param = typeof param == "string" && {url:param} || param; 
			
			if ( previous.old !== value ) {
				previous.old = value;
				var validator = this;
				this.startRequest(element);
				var data = {};
				data[element.name] = value;
				$.ajax($.extend(true, {
					url: param,
					mode: "abort",
					port: "validate" + element.name,
					dataType: "json",
					data: data,
					success: function(response) {
						var valid = response === true;
						if ( valid ) {
							var submitted = validator.formSubmitted;
							validator.prepareElement(element);
							validator.formSubmitted = submitted;
							validator.successList.push(element);
							validator.showErrors();
						} else {
							var errors = {};
							errors[element.name] = previous.message = response || validator.defaultMessage( element, "remote" );
							validator.showErrors(errors);
						}
						previous.valid = valid;
						validator.stopRequest(element, valid);
					}
				}, param));
				return "pending";
			} else if( this.pending[element.name] ) {
				return "pending";
			}
			return previous.valid;
		},

		// http://docs.jquery.com/Plugins/Validation/Methods/minlength
		minlength: function(value, element, param) {
			return this.optional(element) || this.getLength($.trim(value), element) >= param;
		},
		
		// http://docs.jquery.com/Plugins/Validation/Methods/maxlength
		maxlength: function(value, element, param) {
			return this.optional(element) || this.getLength($.trim(value), element) <= param;
		},
		
		// http://docs.jquery.com/Plugins/Validation/Methods/rangelength
		rangelength: function(value, element, param) {
			var length = this.getLength($.trim(value), element);
			return this.optional(element) || ( length >= param[0] && length <= param[1] );
		},
		
		// http://docs.jquery.com/Plugins/Validation/Methods/min
		min: function( value, element, param ) {
			return this.optional(element) || value >= param;
		},
		
		// http://docs.jquery.com/Plugins/Validation/Methods/max
		max: function( value, element, param ) {
			return this.optional(element) || value <= param;
		},
		
		// http://docs.jquery.com/Plugins/Validation/Methods/range
		range: function( value, element, param ) {
			return this.optional(element) || ( value >= param[0] && value <= param[1] );
		},
		
		// http://docs.jquery.com/Plugins/Validation/Methods/email
		email: function(value, element) {
			// contributed by Scott Gonzalez: http://projects.scottsplayground.com/email_address_validation/
			return this.optional(element) || /^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i.test(value);
		},
	
		// http://docs.jquery.com/Plugins/Validation/Methods/url
		url: function(value, element) {
			// contributed by Scott Gonzalez: http://projects.scottsplayground.com/iri/
			return this.optional(element) || /^(https?|ftp):\/\/(((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:)*@)?(((\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5]))|((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?)(:\d*)?)(\/((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)+(\/(([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)*)*)?)?(\?((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|[\uE000-\uF8FF]|\/|\?)*)?(\#((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|\/|\?)*)?$/i.test(value);
		},
        
		// http://docs.jquery.com/Plugins/Validation/Methods/date
		date: function(value, element) {
			return this.optional(element) || !/Invalid|NaN/.test(new Date(value));
		},
	
		// http://docs.jquery.com/Plugins/Validation/Methods/dateISO
		dateISO: function(value, element) {
			return this.optional(element) || /^\d{4}[\/-]\d{1,2}[\/-]\d{1,2}$/.test(value);
		},
	
		// http://docs.jquery.com/Plugins/Validation/Methods/dateDE
		dateDE: function(value, element) {
			return this.optional(element) || /^\d\d?\.\d\d?\.\d\d\d?\d?$/.test(value);
		},
	
		// http://docs.jquery.com/Plugins/Validation/Methods/number
		number: function(value, element) {
			return this.optional(element) || /^-?(?:\d+|\d{1,3}(?:,\d{3})+)(?:\.\d+)?$/.test(value);
		},
	
		// http://docs.jquery.com/Plugins/Validation/Methods/numberDE
		numberDE: function(value, element) {
			return this.optional(element) || /^-?(?:\d+|\d{1,3}(?:\.\d{3})+)(?:,\d+)?$/.test(value);
		},
		
		// http://docs.jquery.com/Plugins/Validation/Methods/digits
		digits: function(value, element) {
			return this.optional(element) || /^\d+$/.test(value);
		},
		
		// http://docs.jquery.com/Plugins/Validation/Methods/creditcard
		// based on http://en.wikipedia.org/wiki/Luhn
		creditcard: function(value, element) {
			if ( this.optional(element) )
				return "dependency-mismatch";
			// accept only digits and dashes
			if (/[^0-9-]+/.test(value))
				return false;
			var nCheck = 0,
				nDigit = 0,
				bEven = false;

			value = value.replace(/\D/g, "");

			for (n = value.length - 1; n >= 0; n--) {
				var cDigit = value.charAt(n);
				var nDigit = parseInt(cDigit, 10);
				if (bEven) {
					if ((nDigit *= 2) > 9)
						nDigit -= 9;
				}
				nCheck += nDigit;
				bEven = !bEven;
			}

			return (nCheck % 10) == 0;
		},
		
		// http://docs.jquery.com/Plugins/Validation/Methods/accept
		accept: function(value, element, param) {
			param = typeof param == "string" ? param.replace(/,/g, '|') : "png|jpe?g|gif";
			return this.optional(element) || value.match(new RegExp(".(" + param + ")$", "i")); 
		},
		
		// http://docs.jquery.com/Plugins/Validation/Methods/equalTo
		equalTo: function(value, element, param) {
			return value == $(param).val();
		}
		
	}
	
});

// deprecated, use $.validator.format instead
$.format = $.validator.format;

})(jQuery);

// ajax mode: abort
// usage: $.ajax({ mode: "abort"[, port: "uniqueport"]});
// if mode:"abort" is used, the previous request on that port (port can be undefined) is aborted via XMLHttpRequest.abort() 
;(function($) {
	var ajax = $.ajax;
	var pendingRequests = {};
	$.ajax = function(settings) {
		// create settings for compatibility with ajaxSetup
		settings = $.extend(settings, $.extend({}, $.ajaxSettings, settings));
		var port = settings.port;
		if (settings.mode == "abort") {
			if ( pendingRequests[port] ) {
				pendingRequests[port].abort();
			}
			return (pendingRequests[port] = ajax.apply(this, arguments));
		}
		return ajax.apply(this, arguments);
	};
})(jQuery);

// provides cross-browser focusin and focusout events
// IE has native support, in other browsers, use event caputuring (neither bubbles)

// provides delegate(type: String, delegate: Selector, handler: Callback) plugin for easier event delegation
// handler is only called when $(event.target).is(delegate), in the scope of the jquery-object for event.target 

// provides triggerEvent(type: String, target: Element) to trigger delegated events
;(function($) {
	$.each({
		focus: 'focusin',
		blur: 'focusout'
	}, function( original, fix ){
		$.event.special[fix] = {
			setup:function() {
				if ( $.browser.msie ) return false;
				this.addEventListener( original, $.event.special[fix].handler, true );
			},
			teardown:function() {
				if ( $.browser.msie ) return false;
				this.removeEventListener( original,
				$.event.special[fix].handler, true );
			},
			handler: function(e) {
				arguments[0] = $.event.fix(e);
				arguments[0].type = fix;
				return $.event.handle.apply(this, arguments);
			}
		};
	});
	$.extend($.fn, {
		delegate: function(type, delegate, handler) {
			return this.bind(type, function(event) {
				var target = $(event.target);
				if (target.is(delegate)) {
					if(!$.browser.msie && event.type == "focusout"){//如果浏览器不是IE类型的，则需要在触发form的focusout事件前将触发事件元素的focusout事件触发，兼容数值和货币输入框验证
						if($.data(target[0], "events") && $.data(target[0], "events")["focusout"]){//该元素定义了focusout事件
							target.triggerHandler("focusout");//触发focusout事件
							event.stopPropagation();//阻止事件冒泡
						}
					}
					return handler.apply(target, arguments);
				}
			});
		},
		triggerEvent: function(type, target) {
			return this.triggerHandler(type, [$.event.fix({ type: type, target: target })]);
		}
	});
})(jQuery);

// 用户自定义函数验证，主要用于ajax验证
$.validator.addMethod("customFunction", function ajaxFunction(value, element,
		param) {
	//var returnValue = eval(param + "()");
	var returnValue = eval(param).call(element);
	if (typeof returnValue == "string") {
		$.validator.messages["customFunction"] = "\"" + returnValue + "\"";
		return false;
	} else if (typeof returnValue == "boolean") {
		return returnValue;
	} else {
		return false;
	}
}, "errors_customFunction");

// 字符串类型验证
$.validator.addMethod("string", function(value, element) {
	return this.optional(element) || /^[\u0391-\uFFE5\w]+$/.test(value);
}, "errors_string");

// 验证字符串的长度范围，中文字算两个字节
$.validator.addMethod("byteRangeLength", function(value, element, param) {
	var length = value.length;
	var params = param.split(",");
	for (var i = 0; i < value.length; i++) {
		if (value.charCodeAt(i) > 127) {
			length++;
		}
	}
	return this.optional(element)
			|| (length >= params[0] && length <= params[1]);
}, "errors_byteRangeLength");

// 验证字符串的最小长度，中文字算两个字节
$.validator.addMethod("byteMinLength", function(value, element, param) {
	var length = value.length;
	var params = param.split(",");
	for (var i = 0; i < value.length; i++) {
		if (value.charCodeAt(i) > 127) {
			length++;
		}
	}
	return this.optional(element) || (length >= params);
}, "errors_byteMinLength");

// 验证字符串的最大长度，中文字算两个字节
$.validator.addMethod("byteMaxLength", function(value, element, param) {
	var length = value.length;
	var params = param.split(",");
	for (var i = 0; i < value.length; i++) {
		if (value.charCodeAt(i) > 127) {
			length++;
		}
	}
	return this.optional(element) || (length <= params);
}, "errors_byteMaxLength");

// 验证用户自定义正则表达式
$.validator.addMethod("customReg", function(value, element, param) {
	if (param == "") {
		return true;
	}
	var reg = new RegExp(param);
	return reg.test(value);
}, "errors_customReg");

// 验证IP信息格式是否合法
$.validator.addMethod("ip", function(value, element) {
	return this.optional(element)
			|| (/^(\d+)\.(\d+)\.(\d+)\.(\d+)$/.test(value) && (RegExp.$1 < 256
					&& RegExp.$2 < 256 && RegExp.$3 < 256 && RegExp.$4 < 256));
}, "errors_ip");

// 手机号码验证
$.validator.addMethod("mobile", function(value, element) {
	var length = value.length;
	//var mobile = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
	var mobile = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))\d{8})$/; //判断是否是手机号的正则表达式
	return this.optional(element) || (length == 11 && mobile.test(value));
}, "errors_mobile");

// 电话号码验证
$.validator.addMethod("telephone", function(value, element) {
	//var tel = /^\d{3,4}-?\d{7,9}$/; // 电话号码格式010-12345678
	var tel = /^(((010|02[1-9]|852)-?\d{8})|((0[3-9][0-9]{2})-?\d{7,8}))$/;	//判断是否是座机号的正则表达式
	return this.optional(element) || (tel.test(value));
}, "errors_telephone");

// 联系电话(手机/电话皆可)验证
$.validator.addMethod("phone", function(value, element) {
	var length = value.length;
	//var mobile = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
	var mobile = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))\d{8})$/; //判断是否是手机号的正则表达式
	//var tel = /^\d{3,4}-?\d{7,9}$/;
	var tel = /^(((010|02[1-9]|852)-?\d{8})|((0[3-9][1-9]{2})-?\d{7,8}))$/;	//判断是否是座机号的正则表达式
	return this.optional(element)
			|| (tel.test(value) || mobile.test(value));
}, "errors_phone");

// 邮政编码验证
$.validator.addMethod("zipCode", function(value, element) {
	var tel = /^[0-9]{6}$/;
	return this.optional(element) || (tel.test(value));
}, "errors_zipCode");


/** 横向tab页组件 * */
(function(){
	var HTabPanel = function (config) {
		var tabHeadRenderer = $('#' + config.tabHeadRenderer),
			tabBodyRenderer	= $('#' + config.tabBodyRenderer),
			tabHeadTemplate = $(config.tabHeadTemplate),// 高亮显示的
			tabHeadWidth	= config.tabHeadWidth, // 标签头 宽度
			// tabWidth = config.tabWidth, // 整个标签页宽度
			autoAdaptFunc	= config.autoAdaptFunc;// 窗口变化时的tab容器宽度获取自定义函数
			that = this;
		
		this.tabHeadTemplate = tabHeadTemplate;
		this.tabHeadWidth 	 = tabHeadWidth;
		this.autoAdaptFunc   = autoAdaptFunc;// 窗口变化时的tab容器宽度获取自定义函数
		// this.tabWidth = tabWidth;
		this.showMenu 		 = config.showMenu;
		
		this.tabHeadRenderer  = tabHeadRenderer;
		this.tabBodyRenderer  = tabBodyRenderer;
		this.tabHeadContainer = $('<div class="tabHeadContainer"></div>');
		this.tabHeadSlider 	  = $('<div class="tabHeadSlider"></div>');
		this.tabHeadWraper 	  = $('<ul class="tabHeadWraper"></ul>');
		this.tabHeaddown 	  = $('<div class="tabHeaddown"></div>').hide();
		// this.tabBodyContainer = $('<div class="tabBodyContainer"
		// style="width:100%;height:100%;"></div>');
		this.init();
		
		this.tabHeaddown.click(function(e) {
			var tabHeadSlider = that.tabHeadSlider, hidetabs = tabHeadSlider.find('.tabHead:hidden'), hidetabssize = hidetabs.size(), hidetab, hidetabtext, hidetabid, i, menu = [],mm, xx;
			var menuclick = function(e) {
				var id = this.data.alias.slice(10),thetab = $('#'+id),headtabs = that.tabHeadWraper.find('.tabHead'), curActiveTab = that.tabHeadWraper.find('.menubg'), index;
				if(curActiveTab.css('display') === 'none') {
					// alert(that.tabHeadWraper.find('li:visible').size());
					that.tabHeadWraper.find('li:visible').first().hide();
					thetab.show();
					thetab.find('.tabHeadText').click();
				}
				curActiveTab.hide();
				thetab.show();
				thetab.find('.tabHeadText').click();
			};
			
			if(hidetabssize > 0) {
				for(i = 0; i < hidetabssize; i += 1) {
					hidetab = $(hidetabs[i]);
					hidetabtext = hidetab.find('.tabHeadText').html();
					hidetabid = hidetab.attr('id');
					
					menu[i] = {text:hidetabtext, alias:'menuoption'+hidetabid, icon: "http://jscs.cloudapp.net/images/icons/ico1.gif", action:menuclick};
				}
				
				mm = {alias:'aaaaa' + new Date(), items:menu};
				xx = $.fn.contextmenu(mm);
				xx.displayMenuByPos(e, this, {top:e.pageY, left:e.pageX});
			}
			
		});
	};

	HTabPanel.prototype = {
		init:function() {
			var that = this;
			
			that.hasResize = false;// 判断是否已经响应了窗口resize事件，IE6 sp3版本之前使用
			
			this.tabHeadRenderer.append(this.tabHeadContainer);
			
			this.tabHeadContainer.append(this.tabHeadSlider);
			this.tabHeadSlider.append(this.tabHeadWraper);
			this.tabHeadContainer.append(this.tabHeaddown);
			
			this.tabWidth 	 = this._autoAdaptWidth();
			
			this.tabHeadContainer.width(this.tabWidth);
			this.tabHeadSlider.width(this.tabWidth - this.tabHeaddown.outerWidth());
			// this.tabHeadSlider.width("95%");
			
			// this.tabHeaddown.css('float', 'right');
			// this.tabBodyRenderer.append(this.tabBodyContainer);
			$(window).bind('resize', function() {
				that.tabWidth = that._autoAdaptWidth();
				
				if($.browser.msie && ($.browser.version == "6.0") && !$.support.style){// 处理IE6浏览器
					if(!that.hasResize){
						that.hasResize = true;
			            that.tabHeadContainer.width(that.tabWidth);
						that.tabHeadSlider.width(that.tabWidth - that.tabHeaddown.outerWidth());
						that.showhide();
					}
					setTimeout(function(){
						that.hasResize = false;
					}, 1000);
				}else{// 其它浏览器
					that.tabHeadContainer.width(that.tabWidth);
					that.tabHeadSlider.width(that.tabWidth - that.tabHeaddown.outerWidth());
					that.showhide();
				}				
				
				if(that.tabHeadWraper.find("li.menubg").css('display') === 'none') {
					that.tabHeadWraper.find('li').first().hide();
					that.tabHeadWraper.find("li.menubg").show();
					that.tabHeadWraper.find("li.menubg").find('.tabHeadText').click();
				}
			});
		},
		
		/**
		 * 获取tab容器宽度，若定义了自定义函数则通过自定义函数获取，否则直接获取tab容器宽度
		 */
		_autoAdaptWidth: function(){
			if(this.autoAdaptFunc && typeof(this.autoAdaptFunc) == "function"){
				return this.autoAdaptFunc.call(this);
			}
			return this.tabHeadRenderer.outerWidth();
		},
		
		/**
		 * 添加tab页
		 */
		add : function(config) {
			var that	 = this, 
				id		 = config.id, // tab页 id，
										// tabHead的id和此id相同，tabBody的id为_id
				text	 = config.text, // tab页标题
				closeAble= config.closeAble, // 是否可以关闭
				url		 = config.url, // tabHead接受URL，
				content	 = config.content,// tabHead接受content，
				tabHead		    = this.tabHeadTemplate.clone().attr('id', id),
				tabHeadText		= tabHead.find('.tabHeadText').append(text),
				tabHeadClose	= tabHead.find('.tabHeadClose'),
				tabHeadWidth	= this.tabHeadWidth,
				tabWidth        = this.tabWidth,
				tabHeadWraper	= this.tabHeadWraper,
				// tabBodyContainer= this.tabBodyContainer,
				tabBodyRenderer = this.tabBodyRenderer,
				tabBodyWraper	= $('<div class="tabBodyWraper" id="_'+id+'" style="width:100%;height:100%;"></div>'), 
				tabHeaddown		= this.tabHeaddown,
				lazy			= config.lazy != null ? config.lazy : false,
				highlight       = config.highlight != null ? config.highlight : true,
				cb = config.callback || function(){},
				cbargs = config.callbackargs,
				close			= function() {
					tabHeadClose.click();
				},
				closeOthers		= function() {
					var tabheads = tabHeadWraper.find('.tabHead').not(tabHead),i;
					for(i = 0; i < tabheads.size(); i += 1) {
						$(tabheads[i]).find('.tabHeadClose').click();
					}
				},
				closeAll		= function() {
					 tabHeadWraper.find('.tabHead').find('.tabHeadClose').click();
				},
				menuOption 		= {alias:"menu"+id, items: [{text:"关闭当前",icon: "http://jscs.cloudapp.net/images/icons/ico1.gif", alias:"menuOptiona", action:close},
			         		                        	  {text:"关闭其他",icon:"http://jscs.cloudapp.net/images/icons/ico2.gif",alias:"menuOptionb",action:closeOthers},
			         		                              {text:"关闭全部",icon:"http://jscs.cloudapp.net/images/icons/ico3.gif",alias:"menuOptionc",action:closeAll}]},
			    menu 			= $.fn.contextmenu(menuOption);
				
			// 添加tabHead
			this.reset();
			tabHeadWraper.prepend(tabHead);
			tabHeadText.width(tabHeadWidth);
			
			// tabBody 内容添加
			if((!lazy) && url) {
				tabBodyWraper.append('<iframe src="'+url+'" width="100%" height="100%" frameborder="0"></iframe>');
				tabBodyRenderer.append(tabBodyWraper);
			}
			else if(content != null && content != undefined && content != 'null') {
				tabBodyWraper.append(content);
				tabBodyRenderer.append(tabBodyWraper);
			}
			// tabBodyContainer.append(tabBodyWraper);
			
			// 单击事件
			tabHead.click(function() {
				if(url && lazy) {
					tabBodyWraper.append('<iframe src="'+url+'" width="100%" height="100%" frameborder="0"></iframe>');
					tabBodyRenderer.append(tabBodyWraper);
					lazy=false;
				}
				that.reset();
				that.active(tabHead);
				cb.call(null, that.tabHeadWraper.find('.tabHead').index(tabHead), text, '_'+id, cbargs);
			});
			
			if(!highlight) {
				// alert('#' + tabHead.attr('id'));
				tabHead.removeClass('menubg').addClass('menubg2');
				$('#_' + tabHead.attr('id')).hide();
			}
			
			// 显示菜单
			if(this.showMenu) {
				tabHeadText.bind('contextmenu', function(e) {
					menu.displayMenuByPos(e, this, {top:e.pageY, left:e.pageX});
					e.preventDefault();
				});
			}
			
			// 关闭按钮
			if(closeAble) {
				tabHeadClose.show();
				tabHeadClose.click(function() { // 关闭
					var heads = tabHeadWraper.find('.tabHead'),index = heads.index(tabHead),count = heads.size(),vtabs,w = 0, i;
					
					tabHead.remove();
					// tabBodyWraper.remove();
					
					var id = tabHead.attr('id');
					$('#_' + id).remove();
					
					if(that.isActive(tabHead)) {
						if(index + 1 === count) {
							that.active($(heads[index - 1]));
						}
						else {
							that.active($(heads[index + 1]));
						}
					}
					
					if(tabHeadWraper.find('.menubg:hidden').size() > 0) {
						tabHeadWraper.find('.menubg').show();
					}
					else {
						tabHeadWraper.find('.tabHead:hidden').first().show();
					}
					
					if(tabHeadWraper.find('.tabHead:hidden').size() < 1) {
						that.tabHeaddown.hide();
					}
				});
			}
			
			else {
				tabHeadClose.hide();
			}
			
			this.showhide();
			if(highlight) {
				// this.active(tabHead);
				tabHead.click();
			}
			// this.active(tabHeadWraper.find('.tabHead').first());
			// cb.call(null, this.tabHeadWraper.find('.tabHead').index(tabHead),
			// text, '_'+id, cbargs);
		},
		
		showhide : function() {
			var tabHeadWraper = this.tabHeadWraper, tabheads = tabHeadWraper.find('.tabHead'), i, w = 0, tabWidth = this.tabWidth - that.tabHeaddown.outerWidth(), tabHeaddown = this.tabHeaddown;
			// alert(this.tabHeadSlider.width());
			// tabWidth = this.tabHeadWidth;
			for(i = 0; i < tabheads.size(); i+=1) {
				w = w + this.getHSpace($(tabheads[i]));
				if(w > tabWidth) {
					$(tabheads[i]).hide();
					w = w - this.getHSpace($(tabheads[i]));
					tabHeaddown.show();
				}
				else {
					$(tabheads[i]).show();
					tabHeaddown.hide();
				}
			}
		},
		
		/**
		 * 将所有tab页 变成非高亮状态
		 */
		reset : function() {
			var tabHeadWraper = this.tabHeadWraper,tabBodyRenderer = this.tabBodyRenderer;
			tabHeadWraper.find('.menubg').removeClass('menubg').addClass('menubg2');
			tabBodyRenderer.children().hide();
		},
		
		active : function(tabhead) {
			var id = tabhead.attr('id'), tabBodyWraper = $('#_' + id);
			tabhead.removeClass('menubg2').addClass('menubg'); // 换高亮样式
			tabBodyWraper.show(); // 显示对应的内容
		},
		
		getHSpace : function(tabHead) {
			return tabHead.outerWidth(true);
		},
		
		/**
		 * 判断 传入id 的tab页是否存在
		 */
		isExist : function(id) {
			if(this.tabHeadWraper.find("#"+id).size() === 1) {
				return true;
			}
			else {
				return false;
			}
		},
		
		/**
		 * 高亮传入id的tab页
		 */
		activeId : function(id) {
			this.reset();
			this.tabHeadWraper.find("#"+id).find('.tabHeadText').click();
		},
		
		isActive : function(tabHead) {
			if(tabHead.hasClass('menubg')) {
				return true;
			}
			else {
				return false;
			}
		}
		
	};
	window.HTabPanel = HTabPanel;
	
})();;

/** 纵向tab页组件 * */
(function(){
	var VTabPanel = function (config) {
		
		var tabHeadRenderer = $('#' + config.tabHeadRenderer),
			tabBodyRenderer	= $('#' + config.tabBodyRenderer),
			tabHeadTemplate = $('<li class="tabHead"><div class="container"><span class="tabHeadLeft"></span><span class="tabHeadLeft_left"></span><span class="tabHeadText"></span><span class="tabHeadClose"></span><span class="tabHeadright"></span></div></li>'),
			tabHeadHeight	= config.tabHeadHeight,
			// tabHeight = config.tabHeight,
			showMenu		= config.showMenu,
			autoAdaptFunc	= config.autoAdaptFunc;// 窗口变化时的tab容器高度获取自定义函数
			that			= this;
		
		this.tabHeadRenderer = tabHeadRenderer;
		this.tabBodyRenderer = tabBodyRenderer;
		this.tabHeadTemplate = tabHeadTemplate;
		this.tabHeadHeight 	 = tabHeadHeight;
		this.autoAdaptFunc   = autoAdaptFunc;// 窗口变化时的tab容器高度获取自定义函数
		// this.tabHeight = tabHeight;
		this.showMenu 		 = showMenu;
		
		this.tabHeadContainer = $('<div class="tabHeadContainer"></div>');
		this.tabHeadSlider 	  = $('<div class="tabHeadSlider"></div>');
		this.tabHeadWraper 	  = $('<ul class="tabHeadWraper"></ul>');
		this.tabHeaddown 	  = $('<div class="tabHeaddown"></div>').hide();
		// this.tabBodyContainer = $('<div class="tabBodyContainer"
		// style="width:100%;height:100%;"></div>');
		this.tabBodyWraperTemplate = $('<div class="tabBodyWraper" style="width:100%;height:100%;"></div>');
		
		this.init();
		
		// 弹出菜单
		this.tabHeaddown.click(function(e) {
			var tabHeadSlider = that.tabHeadSlider, hidetabs = tabHeadSlider.find('.tabHead:hidden'), hidetabssize = hidetabs.size(), 
				hidetab, hidetabtext, hidetabid, i, menu = [], mm, xx;
			
			var menuclick = function(e) {
				var id = this.data.alias.slice(10),thetab = $('#'+id),headtabs = that.tabHeadWraper.find('.tabHead'), curActiveTab = that.tabHeadWraper.find('.highLight').parent('.tabHead'), index;
				if(curActiveTab.size() != 0) {
				curActiveTab.hide();
				}
				else {
					headtabs.first().hide();
				}
				
				thetab.show();
				thetab.click();
			};
			
			if(hidetabssize > 0) {
// menuOption = {alias:"menu"+id, items: [{text:"关闭当前",icon:
// "http://jscs.cloudapp.net/images/icons/ico1.gif", alias:"menuOptiona",
// action:close},
// {text:"关闭其他",icon:"http://jscs.cloudapp.net/images/icons/ico2.gif",alias:"menuOptionb",action:closeOthers},
// {text:"关闭全部",icon:"http://jscs.cloudapp.net/images/icons/ico3.gif",alias:"menuOptionc",action:closeAll}]},
				for(i = 0; i < hidetabssize; i += 1) {
					hidetab = $(hidetabs[i]);
					hidetabtext = hidetab.find('.tabHeadText').html();
					hidetabid = hidetab.attr('id');
					
					menu[i] = {text:hidetabtext, alias:'menuoption'+hidetabid, icon: "http://jscs.cloudapp.net/images/icons/ico1.gif", action:menuclick};
				}
				
				mm = {alias:'aaaaa' + new Date(), items:menu};
				xx = $.fn.contextmenu(mm);
				xx.displayMenuByPos(e, this, {top:e.pageY, left:e.pageX});
			}
			
		});
	};

	VTabPanel.prototype = {
			
		init : function() {
			var that = this;
			that.hasResize = false;// 判断是否已经响应了窗口resize事件，IE6 sp3版本之前使用
			this.tabHeadSlider.append(this.tabHeadWraper);
			this.tabHeadContainer.append(this.tabHeadSlider);
			this.tabHeadContainer.append(this.tabHeaddown);
			this.tabHeadContainer.appendTo(this.tabHeadRenderer);
			// this.tabHeadSlider.height(this.tabHeight);
			// this.tabBodyContainer.appendTo(this.tabBodyRenderer);
			
			this.tabHeight 	 = this._autoAdaptHeight();
			
			// this.tabHeadRenderer
			// that.tabHeadSlider.height($(window).height() - 20);
			that.tabHeadContainer.height(this.tabHeight);
			that.tabHeadSlider.height(this.tabHeight - this.tabHeaddown.outerHeight());
			
			$(window).bind('resize', function() {
				that.tabHeight 	 = that._autoAdaptHeight();
				if($.browser.msie && ($.browser.version == "6.0") && !$.support.style){// 处理IE6浏览器
					if(!that.hasResize){
						that.hasResize = true;
			            that.tabHeadContainer.height(that.tabHeight);
						that.tabHeadSlider.height(that.tabHeight - that.tabHeaddown.outerHeight());
						that.setHidden();
					}
					setTimeout(function(){
						that.hasResize = false;
					}, 1000);
				}else{// 其它浏览器
					that.tabHeadContainer.height(that.tabHeight);
					that.tabHeadSlider.height(that.tabHeight - that.tabHeaddown.outerHeight());
					that.setHidden();
				}				
			});
		},
		
		/**
		 * 获取tab容器高度，若定义了自定义函数则通过自定义函数获取，否则直接获取tab容器高度
		 */
		_autoAdaptHeight: function(){
			if(this.autoAdaptFunc && typeof(this.autoAdaptFunc) == "function"){
				return this.autoAdaptFunc.call(this);
			}
			return this.tabHeadRenderer.outerHeight();
		},
		
		initTabHeadTemplate : function(id, tabHeadText, tabHeadClose) {
			var tabHead = this.tabHeadTemplate.clone();
			tabHead.attr('id', id);
			if(tabHeadClose) {
				tabHead.find('.tabHeadClose').show();
			}
			else {
				tabHead.find('.tabHeadClose').hide();
			}
			tabHead.find('.tabHeadText').append(tabHeadText);			
			return tabHead;
		},
		
		/**
		 * 重置
		 */
		reset : function() {
			var tabHeads, i;
			
			// 重置所有
			this.tabHeadWraper.find('.tabHeadCss').removeClass('tabHeadCss');
			this.tabHeadWraper.find('.tabMidCss').removeClass('tabMidCss');
			this.tabHeadWraper.find('.tabTailCss').removeClass('tabTailCss');
			this.tabHeadWraper.find('.nhighLight').removeClass('nhighLight');
			this.tabHeadWraper.find('.highLight').removeClass('highLight');
			this.tabHeadWraper.find('.downHighLight').removeClass('downHighLight');
			this.tabHeadWraper.find('.upHighLight').removeClass('upHighLight');
			
			tabHeads = this.tabHeadWraper.find('li.tabHead:visible');// 非隐藏的
			// 对非隐藏的tab，添加些默认的class
			for(i = 0; i < tabHeads.size(); i += 1) {
				if(i === 0) {
					$(tabHeads[i]).addClass('tabHeadCss'); // 优先加tabHeadCss
					$(tabHeads[i]).find('div.container').addClass('nhighLight');
				}
				else if(i === tabHeads.size() - 1) {
					$(tabHeads[i]).addClass('tabTailCss');
					$(tabHeads[i]).find('.container').addClass('nhighLight');
				}
				else {
					$(tabHeads[i]).addClass('tabMidCss');
					$(tabHeads[i]).find('.container').addClass('nhighLight');
				}
			}
			// 隐藏所有tabBody
			this.tabBodyRenderer.children().hide();
		},
		
		/**
		 * 高亮tab ，用于单击高亮显示
		 */
		active : function(tabHead) {
			var next, prev, tabHeads = this.tabHeadWraper.find('li.tabHead:visible'), index = tabHeads.index(tabHead);
			
			// 重置
			this.reset();
			
			// 如果只有一个
			if(tabHeads.size() === 1) {
				tabHead.addClass('tabTailCss');
			    tabHead.find('div.nhighLight').removeClass('nhighLight').addClass('highLight');
			}else{
				if(index === 0) {
					tabHead.find('div.nhighLight').removeClass('nhighLight').addClass('highLight');
					$(tabHeads[index + 1]).find('.nhighLight').addClass('upHighLight');
					
				}
				else if(index === tabHeads.size() - 1) {
					tabHead.find('div.nhighLight').removeClass('nhighLight').addClass('highLight');
					$(tabHeads[index - 1]).find('.nhighLight').addClass('downHighLight');
				}
				
				else {
					tabHead.find('.nhighLight').removeClass('nhighLight').addClass('highLight');
					// prev = tabHead.prev();
					// next = tabHead.next();
					$(tabHeads[index + 1]).find('.nhighLight').addClass('upHighLight');
					$(tabHeads[index - 1]).find('.nhighLight').addClass('downHighLight');
				}
			}
			// 显示 tabBody
			$('#_'+tabHead.attr('id')).show();
		},
		
		/**
		 * 
		 */
		getIndex : function(tabHead) {
			return this.tabHeadWraper.find('.tabHead').index(tabHead);
		},
		
		/**
		 * 高亮
		 */
		isActive : function(tabHead) {
			if(tabHead.find('.highLight').size() === 0) {
				return false;
			}
			else {
				return true;
			}
		},
		
		/**
		 * 移除
		 */
		remove : function(tabHead) {
			var id = tabHead.attr('id');
			$('#_' + id).remove();
			tabHead.remove();
		},
		
		/**
		 * 
		 * @return
		 */
		setHidden : function() {

			var tabHeads = this.tabHeadWraper.find('.tabHead'), i, h = 0;
			var htab = tabHeads.find('div.highLight').parent();
			
			// !!!!!!!!!!!!!!!
			// var height = $(window).height() - 20;
			var height = this.tabHeight - this.tabHeaddown.outerHeight();
			
			for(i = 0; i < tabHeads.size(); i+=1) {
				h = h + $(tabHeads[i]).outerHeight(true);
				if(h > height) {
					h = h - $(tabHeads[i]).outerHeight(true);
					$(tabHeads[i]).hide();
					this.tabHeaddown.show();
					this.active(htab);
				}
				else {
					$(tabHeads[i]).show();
					this.tabHeaddown.hide();
					this.active(htab);
				}
			}
			if(htab.is(':hidden')) {
				this.tabHeadWraper.find('.tabHead:visible').first().hide();
				htab.show();
				this.active(htab);
			}
		},
		
		/**
		 * 
		 */
		isExist : function(id) {
			if(this.tabHeadWraper.find('#' + id).size()) {
				return true;
			}
			else {
				return false;
			}
		},
		
		/**
		 * 
		 */
		activeId : function(id) {
			// this.reset();
			// this.active(this.tabHeadWraper.find('#' + id));
			this.tabHeadWraper.find('#' + id).click();
		},
		
		/**
		 * 添加tab
		 */
		add : function(config) {
			var id = config.id, 
				tabHeadText = config.text, 
				close = config.closeAble, 
				url = config.url, 
				content = config.content,
				that = this, 
				cb = config.callback || function(){}, 
				cbargs = config.callbackargs,
				tabHead = this.initTabHeadTemplate(id, tabHeadText, close), // tabhead
				tabBodyWraper = this.tabBodyWraperTemplate.clone(),
				lazy = config.lazy,
				highlight = config.highlight;
			
			// tabhead
			this.tabHeadWraper.prepend(tabHead);
			tabHead.height(this.tabHeadHeight);
			tabHead.find('div.container').height(this.tabHeadHeight);
			
			// tabbody
			tabBodyWraper.attr('id', '_'+id);
			if((!lazy) && url) {
			// if(url && lazy) {
				tabBodyWraper.append('<iframe width="100%" frameborder="0" height="100%" src="'+url+'"></iframe>');
				this.tabBodyRenderer.append(tabBodyWraper);
				// lazy = false;
			}
			else if(content != undefined && content != null && content != 'null') {
				tabBodyWraper.append(content);
				this.tabBodyRenderer.append(tabBodyWraper);
			}
			
			this.setHidden();
			// this.reset();
			
			
			
			if(this.tabHeadWraper.find('.tabHead:hidden').size() !== 0) {
				that.tabHeaddown.show();
			}
			
			// 弹出菜单初始化
			var close = function() {
				tabHead.find('.tabHeadClose').click();
			},
			closeOthers	= function() {
				var tabheads = that.tabHeadWraper.find('.tabHead').not(tabHead),i;
				for(i = 0; i < tabheads.size(); i += 1) {
					$(tabheads[i]).find('.tabHeadClose').click();
				}
			},
			closeAll = function() {
				 that.tabHeadWraper.find('.tabHead').find('.tabHeadClose').click();
			},
			menuOption = {alias:"menu"+id, items: [{text:"关闭当前",icon: "http://jscs.cloudapp.net/images/icons/ico1.gif", alias:"menuOptiona", action:close},
		         		                           {text:"关闭其他",icon:"http://jscs.cloudapp.net/images/icons/ico2.gif",alias:"menuOptionb",action:closeOthers},
		         		                           {text:"关闭全部",icon:"http://jscs.cloudapp.net/images/icons/ico3.gif",alias:"menuOptionc",action:closeAll}
		         		                           ]},
		    menu = $.fn.contextmenu(menuOption);
			
			if(this.showMenu) {
				that.tabHeadWraper.find('.tabHead').bind('contextmenu', function(e) {
					menu.displayMenuByPos(e, this, {top:e.pageY, left:e.pageX});
					e.stopImmediatePropagation();
					e.preventDefault();
				});
			}
			
			// tabHead单击事件
			tabHead.click(function(e) {
				if(url && lazy) {
					tabBodyWraper.append('<iframe width="100%" frameborder="0" height="100%" src="'+url+'"></iframe>');
					that.tabBodyRenderer.append(tabBodyWraper);
					lazy = false;
				}
				that.reset();
				that.active(tabHead);
				cb.call(null, that.getIndex(tabHead), tabHeadText, '_'+id, cbargs);
			});
			
			// tabHead 关闭事件
			tabHead.find('.tabHeadClose').click(function(e) {
				var prev = tabHead.prev(), next = tabHead.next(), curActive = that.tabHeadWraper.find('.highLight').parent('.tabHead');
				if(that.isActive(tabHead)) {
					if(tabHead.hasClass('tabTailCss')) {
						that.remove(tabHead);
						var aa = that.tabHeadWraper.find('.tabHead:hidden').first();
						if(aa.size()) {
							aa.show();
							that.reset();
							that.active(aa);
						} 
						else {
							that.reset();
							that.active(prev);
						}
					}
					else {
						that.remove(tabHead);
						that.tabHeadWraper.find('.tabHead:hidden').first().show();
						that.reset();
						that.active(next);
					}
				}
				else {
					that.remove(tabHead);
					that.tabHeadWraper.find('.tabHead:hidden').first().show();
					that.reset();
					that.active(curActive);
				}
				
				if(that.tabHeadWraper.find('.tabHead:hidden').size() === 0) {
					that.tabHeaddown.hide();
				}
				
				e.stopImmediatePropagation();
			});
			
			var tabHeads = this.tabHeadWraper.find('li.tabHead:visible');
			if(tabHeads.size() === 1){// 若选项卡只有一个，则为该选项卡添加tabTailCss样式
				tabHead.addClass("tabTailCss");
			}
			
			if(highlight) {
				// this.active(tabHead);
				tabHead.click();
			}
			// cb.call(null, this.getIndex(tabHead), tabHeadText, '_'+id,
			// cbargs);
		}
	};
	
	window.VTabPanel = VTabPanel;
	
})();;

/** 日期时间组件 **/
(function() {
	$.datetime = function(setting) {
		 var ps = $.extend({
                //content holder(Object || css Selector)
                elId:"",
                format:"",
                readOnly:false,
                //whether the slider can be dragged
                val: null   
            }, setting);
		
		var el = $('#'+ps.elId);
		el.attr('tagFlag', 'dateTime');
		el.focus(function() {
			var picking = function(dp) {
				var newVal = dp.cal.getNewDateStr(), oldVal = dp.cal.getDateStr();
				el.val(newVal);
				//验证
				if(ps.val) {
					ps.val.element($('#' + ps.elId));
				}
				//
			};
			WdatePicker({onpicking:picking, el:ps.elId, readOnly:ps.readOnly, dateFmt:ps.format,errDealMode:1});
		});
	};
})();