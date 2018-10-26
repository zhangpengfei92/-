// 准确计算字符所占的位数
function calculate_byte(email) {
    return email.replace(/[^\x00-\xff]/g, "xx").length;
}

//Email检查
function isEmail(str) {
    return (str.indexOf("@") > 0);
}

// 字符增加去左右空格属性
String.prototype.Trim = function() {
    return this.replace(/(^\s*)|(\s*$)/g, "");
}

// 字符替换
String.prototype.replaceAll = function(s1, s2) {
    return this.replace(new RegExp(s1, "gm"), s2);
}

// 日期格式话
Date.prototype.format = function(format) {
    var o = {
        "M+" : this.getMonth() + 1, //month
        "d+" : this.getDate(), //day
        "h+" : this.getHours(), //hour
        "m+" : this.getMinutes(), //minute
        "s+" : this.getSeconds(), //second
        "q+" : Math.floor((this.getMonth() + 3) / 3), //quarter
        "S" : this.getMilliseconds() //millisecond
    }
    if (/(y+)/.test(format))
        format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(format))
            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
    return format;
}

//var sortCol;
var storeTable = {
    sortCol:null,
    storeTableByColIndex:function(sTableId, colIndex, sType) {
        var oTable = $("#" + sTableId);
        var trList = oTable.find("tbody>tr");
        var arrTr = trList.get();

        if (storeTable.sortCol != null && storeTable.sortCol == colIndex) {
            arrTr.reverse();
        } else {
            arrTr.sort(storeTable.generateCompareTrs(colIndex, sType));
        }
        oTable.find("tbody").html($(arrTr));

        storeTable.sortCol = colIndex;
        formatTable(sTableId);//格式化Table
    },
    convert:function(sValue, sDataType) {
        switch (sDataType) {
            case "int":
                return parseInt(sValue, 10);
                break;
            case "float":
                return parseFloat(sValue);
                break;
            case "date":
                return new Date(Date.parse(sValue));
                break;
            default:
                return sValue.toString();
        }
    },
    generateCompareTrs:function(iCol, sDataType) {
        return  function compareTrs(oTr1, oTr2) {
            var vValue1 = -9999;
            var vValue2 = -9999;
            if (navigator.userAgent.indexOf("Firefox") != -1) {
                if (oTr1.childNodes[iCol * 2 + 1].innerHTML != "-") {
                    vValue1 = storeTable.convert(oTr1.childNodes[iCol * 2 + 1].innerHTML, sDataType);
                }
                if (oTr2.childNodes[iCol * 2 + 1].innerHTML != "-") {
                    vValue2 = storeTable.convert(oTr2.childNodes[iCol * 2 + 1].innerHTML, sDataType);
                }
            } else {
                if (oTr1.children[iCol].innerText != '-') {
                    vValue1 = storeTable.convert(oTr1.children[iCol].innerText, sDataType);
                }
                if (oTr2.children[iCol].innerText != '-') {
                    vValue2 = storeTable.convert(oTr2.children[iCol].innerText, sDataType);
                }
            }

            if (vValue1 < vValue2) {
                return -1;
            } else if (vValue1 > vValue2) {
                return 1;
            } else {
                return 0;
            }
        };
    }
};

function formatTable(sTableId) {
    $("#" + sTableId).find("tbody>tr").removeClass("alt");
    $(".stripe tr").mouseover(function() {
        $(this).addClass("over");
    }).mouseout(function() {
        $(this).removeClass("over");
    });
    $(".stripe tr:even").addClass("alt");

    showId(sTableId, 0);
}

function showId(sTableId, colid) {
    var tbl = document.getElementById(sTableId);
    if (tbl) {
        var rows = tbl.rows;
        if (rows) {
            var c = rows.length;
            var r = 0;
            for (var i = 0; i < c; i++) {
                var p = rows[i].parentNode;
                if (p && p.nodeName == "TBODY" && p.getAttribute("excludeid") == "yes") {
                    //alert(p.getAttribute("excludeid"));
                    rows[i].cells[0].innerHTML = r + 1;
                    r++;
                }
            }
        }
    }
}

/**
 * 添加一个cookie：addCookie(name,value,expireHours)
   该函数接收3个参数：cookie名称，cookie值，以及在多少小时后过期。这里约定expireHours为
   0时不设定过期时间，即当浏览器关闭时cookie自动消失
 * @param name
 * @param value
 * @param expireHours
 */
function addCookie(name, value, expireHours) {
    var cookieString = name + "=" + escape(value);
    //判断是否设置过期时间
    if (expireHours > 0) {
        var date = new Date();
        var expire = new Date((new Date()).getTime() + expireHours * 3600000);
        cookieString = cookieString + "; path=/; expires=" + expire.toGMTString();
    }
    document.cookie = cookieString;
}

/**
 * 获取指定名称的cookie值：getCookie(name)
   该函数返回名称为name的cookie值，如果不存在则返回空
 * @param name
 */
function getCookie(name) {
    var strCookie = document.cookie;
    var arrCookie = strCookie.split("; ");
    for (var i = 0; i < arrCookie.length; i++) {
        var arr = arrCookie[i].split("=");
        if (arr[0] == name)return arr[1];
    }
    return "";
}

/**
 * 删除指定名称的cookie：deleteCookie(name)
   该函数可以删除指定名称的cookie
 * @param name
 */
function deleteCookie(name) {
    var date = new Date();
    date.setTime(date.getTime() - 10000);
    document.cookie = name + "=v; expires=" + date.toGMTString();
}

/**
 * 同时登录时踢出用户提示
 * @param name
 */
/*setInterval(function(){unLoginOnTime();}, 30000);
function unLoginOnTime() {
	$.ajax({
		url : "${ctx}/ajaxOnTimeLoginSystem.do",
		type : 'POST',
		async : false,
		data : {},
		success : function(data) {
			if(data=='false'){
				//同时登录
				window.location.href = "/userIndex.do?authcode=2";
			}
		},
	});
}*/

Date.prototype.DateDiff = function(strInterval, dtEnd) {
	var dtStart = this;
	if (typeof dtEnd == 'string' )//如果是字符串转换为日期型
	{
		dtEnd = StringToDate(dtEnd);
	}
	switch (strInterval) {
		case 's' :return parseInt((dtEnd - dtStart) / 1000);
		case 'n' :return parseInt((dtEnd - dtStart) / 60000);
		case 'h' :return parseInt((dtEnd - dtStart) / 3600000);
		case 'd' :return parseInt((dtEnd - dtStart) / 86400000);
		case 'w' :return parseInt((dtEnd - dtStart) / (86400000 * 7));
		case 'm' :return (dtEnd.getMonth()+1)+((dtEnd.getFullYear()-dtStart.getFullYear())*12) - (dtStart.getMonth()+1);
		case 'y' :return dtEnd.getFullYear() - dtStart.getFullYear();
	};
};

function StringToDate(DateStr) {
	var converted = Date.parse(DateStr);
	var myDate = new Date(converted);
	if (isNaN(myDate)) {
		var arys = DateStr.split('-');
		myDate = new Date(arys[0], --arys[1], arys[2]);
	}
	return myDate;
}


function DateDiff(strInterval, dtStart,dtEnd) {
	if (typeof dtStart == 'string' )//如果是字符串转换为日期型
	{
		dtStart = StringToDate(dtStart);
	}
	if (typeof dtEnd == 'string' )//如果是字符串转换为日期型
	{
		dtEnd = StringToDate(dtEnd);
	}
	switch (strInterval) {
		case 's' :return Math.ceil((dtEnd - dtStart) / 1000);
		case 'n' :return Math.ceil((dtEnd - dtStart) / 60000);
		case 'h' :return Math.ceil((dtEnd - dtStart) / 3600000);
		case 'd' :return Math.ceil((dtEnd - dtStart) / 86400000);
		case 'w' :return Math.ceil((dtEnd - dtStart) / (86400000 * 7));
		case 'm' :return (dtEnd.getMonth()+1)+((dtEnd.getFullYear()-dtStart.getFullYear())*12) - (dtStart.getMonth()+1);
		case 'y' :return dtEnd.getFullYear() - dtStart.getFullYear();
	};
};
function DateDiffFloor(strInterval, dtStart,dtEnd) {
	if (typeof dtStart == 'string' )//如果是字符串转换为日期型
	{
		dtStart = StringToDate(dtStart);
	}
	if (typeof dtEnd == 'string' )//如果是字符串转换为日期型
	{
		dtEnd = StringToDate(dtEnd);
	}
	switch (strInterval) {
	case 's' :return Math.floor((dtEnd - dtStart) / 1000);
	case 'n' :return Math.floor((dtEnd - dtStart) / 60000);
	case 'h' :return Math.floor((dtEnd - dtStart) / 3600000);
	case 'd' :return Math.floor((dtEnd - dtStart) / 86400000);
	case 'w' :return Math.floor((dtEnd - dtStart) / (86400000 * 7));
	case 'm' :return (dtEnd.getMonth()+1)+((dtEnd.getFullYear()-dtStart.getFullYear())*12) - (dtStart.getMonth()+1);
	case 'y' :return dtEnd.getFullYear() - dtStart.getFullYear();
	};
};