//列表resize生效的延迟时间
var delay_resize = 10;
//页面中grid的setting列表
var settingMap = {
	length : 0
};
//加载时间控件 
function toDate(ids, format,isShowClear) {
	var flag = (isShowClear == undefined ? true : false);
	for ( var i = 0; i < ids.length; i++) {
		$.datetime({
			elId : ids[i],
			format : format,
			readOnly : false,
			isShowClear : flag,
			val : null
		});
	}
}

/*
 *	全局替换系统内置alert样式为统一样式 
 */
window.alert = function(info,callback,params){
	if ( arguments.length > 2 ) {
		if ( params.constructor != Array  ) {
			params = [ params ];
		}
		var reg = new RegExp("\\{\\d+\\}");
		$.each(params, function(i, n) {
			info = info.replace(reg, n);
		});
	}
	$.jBox.info(info, common_ts, {closed:callback} );
};

/**
 * 获取当前客户端日期
 * 
 * @returns 返回年月日
 */
function getNowTime() {
	var nowDate = new Date();
	var strNowDate = nowDate.getFullYear()
			+ '-'
			+ (nowDate.getMonth() >= 9 ? (nowDate.getMonth() + 1)
					: ('0' + (nowDate.getMonth() + 1)))
			+ '-'
			+ (nowDate.getDate() >= 10 ? nowDate.getDate() : ('0' + nowDate
					.getDate()));
	return strNowDate;
}

/**
 * 获取当前客户端日期
 * 
 * @returns 返回年月日时分
 */
function getNowDateAndTime() {
	var nowDate = new Date();
	var strNowDate = nowDate.getFullYear()
			+ '-'
			+ (nowDate.getMonth() >= 9 ? (nowDate.getMonth() + 1)
					: ('0' + (nowDate.getMonth() + 1)))
			+ '-'
			+ (nowDate.getDate() >= 10 ? nowDate.getDate() : ('0' + nowDate.getDate()))
			+ ' '
			+ (nowDate.getHours() >= 10 ? nowDate.getHours() : ('0' + nowDate.getHours()))
			+ ':'
			+ (nowDate.getMinutes() >= 10 ? nowDate.getMinutes() : ('0' + nowDate.getMinutes()));
			
	return strNowDate;
}

/**
 * 获取当前日期前dayNo天的日期 
 * @param dayNo
 * @returns 格式为yyyy-mm-dd
 */
function getDate(dayNo) {
	var nowDay = new Date();
	var date_milliseconds = nowDay.getTime() - 1000 * 60 * 60 * 24 * dayNo;
	var date = new Date();
	date.setTime(date_milliseconds);

	var strYear = date.getFullYear();
	var strDay = date.getDate();
	if(strDay < 10) {
		strDay = "0" + strDay;
	}
	var strMonth = date.getMonth() + 1;
	if (strMonth < 10) {
		strMonth = "0" + strMonth;
	}
	var datastr = strYear + "-" + strMonth + "-" + strDay;
	return datastr;
}

// 跳转
function doAction(url) {
	url += (url.indexOf('action?') > -1) ? '&' : '?';
	parent.document.getElementById("mainframe").src = url + "d=" + new Date();
}

//var gridWidth = 1;

/**
 * 生成JqGrid列表
 * 
 * @author liuhua
 * @param {Object}
 *            setting 必须包含</br> parentId 例中的 'parentDiv'</br> tableId 例中的
 *            'lstTable'</br> pagerId 例中的 'pageDiv'</br> colNames 例中的
 *            '编号'、'名称'，书写形式为：['编号','名称']</br> colModel 形如：[
 *            {name:'bh',index:'bh',sortable:false,align:"right",width:"8%"},</br>          
 *            {name:'bpmc',index:'bpmc',sortable:false,width:"10%"}</br> ]</br>
 *            对应Action中数据JSON串对应colNames的数据字段及呈现方式的描述</br> url
 *            JqGrid获取数据的Action地址</br> </br> 例：</br> 比如，列表中显示两列 —— ‘编号’、‘名称’</br>
 *            &lt;div id="parentDiv"&gt;</br> &lt;table
 *            id="lstTalbe"&gt;&lt;/table&gt;--></br> &lt;div
 *            id="pageDiv"&gt;&lt;/div&gt;--></br> <!--&lt;/div&gt;--></br>
 * @return
 */
var num_width = 0;
var menu_width ;
function createJqGrid(setting) {
	var rowNum = 10;
	var _grid = jQuery("#" + setting.tableId);
	_grid.exSetting = {};
	_grid.exSetting.parentId = setting.parentId ? setting.parentId : undefined;
	_grid.exSetting.width = setting.width ? setting.width : 1;
	_grid.jqGrid(
					{
						url : setting.url,
						datatype : (setting.datatype ? setting.datatype : "json"),
						colNames : setting.colNames,
						colModel : setting.colModel,
						grouping : setting.grouping,
						scroll : (setting.scroll ? setting.scroll : 0),
						groupingView : setting.groupingView,
						rowNum : (setting.rowNum ? setting.rowNum : rowNum),
						editurl : (setting.editurl ? setting.editurl : true),
						pager : (setting.pagerId ? jQuery("#" + setting.pagerId)
								: ""),
						sortname: (setting.sortname ? setting.sortname : "id"),
						sortorder: (setting.sortorder ? setting.sortorder : "asc"),
						width : (
									setting.width 
									? $("#" + setting.parentId).outerWidth()* setting.width 
									: $("#" + setting.parentId).outerWidth()-1
								),
//								* gridWidth),
						height : (setting.height ? setting.height : 'auto'),
						altRows : true,
						altclass : 'altRow',
						rowList: (setting.rowList ? setting.rowList : [10,20,30]),
						loadonce : (setting.loadonce ? setting.loadonce : false),
						prmNames : {
							page : 'curpage',
							rows : 'unitpage',
							sidx : 'orderBy',
							sord : 'order'
						},
						forceFit : (setting.forceFit ? setting.forceFit : true),
						jsonReader : {
							// root: "rows",
							root : "result",
							page : "currpage",
							total : "totalpages",
							records : "totalrecords",
							repeatitems : false
						},
						viewrecords : true,
						emptyrecords : '没有检索到您要的结果',
						mtype : 'POST',
						multiselect : setting.multiselect ? setting.multiselect
								: false,
						multikey : setting.multikey ? setting.multikey : "",
						gridComplete : setting.gridComplete ? setting.gridComplete
								: function() {
								},
						onSelectRow : setting.onSelectRow ? setting.onSelectRow
								: function() {
								},
						onSelectAll : setting.onSelectAll ? setting.onSelectAll
								: function() {
								},
						onclickPgButtons : setting.onclickPgButtons ? setting.onclickPgButtons
								: function() {
								},
						onPaging : setting.onPaging ? setting.onPaging
								: function() {
								},
						loadComplete : function(){
							if(typeof page_size == 'function'){
								page_size();
							}
							
							if(typeof setting.loadComplete == 'function'){
								setting.loadComplete();
							}
						},
						beforeSelectRow : setting.beforeSelectRow ? setting.beforeSelectRow
								: function() {
									return true;
								},
						ExpandColumn : setting.ExpandColumn,
						treeGrid : setting.treeGrid ? setting.treeGrid : false,
						treeIcons: (setting.treeIcons ? setting.treeIcons : null)
					});
	return _grid;
}

/**
 * 执行调整列表宽度
 * @param grid 列表jQgrid对象
 * @param referenceid 参考对象的ID（根据参考对象调整列表宽度，默认为列表的父级容器）
 * @param percent	百分比（占参考对象宽度的百分比（小数形式，56%即0.56），默认为同列表默认值相同）
 * @returns
 */
function doResizeGrid(setting){
	var tmpPercent = setting.percent ? setting.percent : setting.grid.exSetting.width;
	if(tmpPercent <= 0 && tmpPercent > 1){
		return;
	}
	var target ;
	var referenceTarget = $("#"+ ((setting.referenceId && typeof setting.referenceId == 'string') ? setting.referenceId : setting.grid.exSetting.parentId));
	var referenceTargetParent = referenceTarget.parent();
	//针对IE7则使用其Grid容器的父级对象
	if(setting.notNeedReference){
		target = referenceTarget;
	} else {
		target = referenceTargetParent;
	}
	setting.grid.jqGrid("setGridWidth", target.width() * tmpPercent + (target.scrollTop() > 0 ? 18 : 0));
}

/**
 * 执行resize前的准备和判断工作
 * @param setting 参见resizeGrid方法
 */
function doResize(setting){	
	if(!setting.grid){
		return;
	}
	if(isIE6 && (typeof setting.gridWidthUnderIe6 =='function')){//判断是否是IE6
		setting.grid.jqGrid("setGridWidth", setting.gridWidthUnderIe6());
	}else{
		
		if(setting.grid){
			doResizeGrid(setting);
		}
	}
}
/**
 * 调整列表宽度<br>
 * @param setting<br>
 * 	setting={<br>
 * 		&nbsp; &nbsp;grid<br>
 * 		&nbsp; &nbsp;referencedId<br> 
 * 		&nbsp; &nbsp;percent	&nbsp; &nbsp;以上三种参数的说明参见doResizeGrid方法<br>
 * 		&nbsp; &nbsp;gridWidthUnderIe6	&nbsp; &nbsp;IE6下获取列表宽度的方法（需要以window为参考对象）<br>
 * 		&nbsp; &nbsp;delay	&nbsp; &nbsp;resize事件结束后执行列表宽度设置的延迟时间<br>
 * 		&nbsp; &nbsp;extendTargetIdOfResize	&nbsp; &nbsp;额外的监听对象<br>
 * 	}
 */
function resizeGrid(setting){
	settingMap[setting.grid.attr("id")] = setting;
	settingMap.length += 1;
	var func = function(){
		for(var key in settingMap){
			if(key != 'length'){
				doResize(settingMap[key]);
			}
		}
	};
	if(settingMap.length == 1){
		$(window).resize(function(){
			clearTimeout(setting.timeOfTimeout);
			setting.timeOfTimeout = setTimeout(func, setting.delay ? setting.delay: delay_resize);
		});
		if(setting.extendTargetIdOfResize){
			$("#" + setting.extendTargetIdOfResize).click(function(){
				clearTimeout(setting.timeOfTimeout);
				setting.timeOfTimeout = setTimeout(func, setting.delay ? setting.delay: delay_resize);
			});
		}
	}
}
var three_side = 0;
function Listwidth(){
	if($('#content').css('margin-left') == '4px'){
		menu_width = 4;
	} else if($('#content').css('margin-left') == '15px'){
		menu_width = 25;
	} else {
		menu_width = 204;
	}
	if($(window).width() < 1000 ){
		return 1000 - num_width - three_side - menu_width - 30;
	} else {
		return $(window).width() - three_side - num_width - menu_width - 30;
	}
}


/*HashCode计算*/
function hashCode(str){
    var h = 0, off = 0;
    var len = str.length;
    for(var i = 0; i < len; i++){
        h = 31 * h + str.charCodeAt(off++);
    }
    var t=-2147483648*2;
    while(h>2147483647){
    	h+=t
    }
    return h;
}

var __sto = setTimeout;
window.setTimeout = function(callback,timeout)
{
    var args = Array.prototype.slice.call(arguments,2);
    var _cb = function()
    {
        callback.apply(null,args);
    }
    __sto(_cb,timeout);
}

// 生成列表序号
function setNumber(jqgrid) {
	var ids = jqgrid.getDataIDs();
	
	var page = setting.grid.jqGrid('getGridParam','page');
	var rowNum = 1;
	if(page > 1) {
		var pageSize = jqgrid.jqGrid('getGridParam','rowNum');
		rowNum = (page - 1) * pageSize + 1
	}
	
	if(ids.length > 0) {
		for(var i=0;i < ids.length ;i++){
			jqgrid.jqGrid('setRowData',ids[i],{id : rowNum++});
		}
	} 
}

//表格全选框共通
function setAllCheckBoxStatus(jqgridObj,checkBoxObj) {
	//获取列表中所有行标识
	var allRows = jqgridObj.getDataIDs();
	//获取列表中选中行标识
	var selectedRows = jqgridObj.jqGrid('getGridParam','selarrrow');
	//全选
	if(allRows.length == selectedRows.length) {
		
		//全选按钮选中
		checkBoxObj.attr('checked',true);
	}
}