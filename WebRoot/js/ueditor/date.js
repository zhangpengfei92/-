/**
 * Created by qiupenghua on 2018/3/14.
 */
/**
 * 返回ISO格式的日期字符串（去掉时分秒）
 * 如："2016-09-22T08:37:43.438Z" --> "2016-09-22"
 */
Date.prototype.toIsoDateString = function () {
    return this.toISOString().slice(0, -14);
};

/**
 * 返回一个加上days天的新Date
 */
Date.prototype.plusDays = function (days) {
    return new Date(this.getTime() + days * 60 * 60 * 24 * 1000);
};

/**
 * 返回一个减去days天的新Date
 */
Date.prototype.minusDays = function (days) {
    return new Date(this.getTime() - days * 60 * 60 * 24 * 1000);
};

/**
 * 返回一个加上若干个月的新Date
 * 注1：Date(2-28).plusMonth(1)=Date(3-28)。如果需要变成3-31，需要另外的函数来处理。
 * 注2：Date(1-31).plusMonth(1)=Date(2-28)或Date(2-29)
 */
Date.prototype.plusMonths = function (num) {
    var newDate = new Date(this);
    newDate.setMonth(this.getMonth() + num); //setMonth()会自动除以12
    //注意：此时，月数可能会自动进位，比如：1-31加上num=1的情况，会变成3-3（非闰年）或3-2（闰年），即2-31自动转换为下个月的某一天。

    var currentMonth = this.getMonth() + this.getFullYear() * 12; //获得月的绝对值
    var diff = (newDate.getMonth() + newDate.getFullYear() * 12) - currentMonth; //计算新旧两个月绝对值的差

    if (diff != num) { //如果月绝对值的差和加上的月数不一样，说明月进位了，此时需要退一个月
        //setDate(0)表示变成上个月的最后一天
        newDate.setDate(0);
    }

    return newDate;
};

/**
 * 返回下个月的第一天的Date对象
 */
Date.prototype.getStartOfNextMonth = function () {
    var newDate = new Date(this);
    newDate.setDate(15); //确保月数不会进位
    newDate.setMonth(this.getMonth() + 1);
    newDate.setDate(1);
    return newDate;
};

/**
 * 返回下个月的最后一天的Date对象
 */
Date.prototype.getEndOfNextMonth = function () {
    var newDate = new Date(this);
    newDate.setDate(15); //确保月数不会进位
    newDate.setMonth(this.getMonth() + 2); //加两个月
    newDate.setDate(0); //再退回上个月的最后一天
    return newDate;
};
/** * 对Date的扩展，将 Date 转化为指定格式的String * 月(M)、日(d)、12小时(h)、24小时(H)、分(m)、秒(s)、周(E)、季度(q)
 可以用 1-2 个占位符 * 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字) * eg: * (new
 Date()).pattern("yyyy-MM-dd hh:mm:ss.S")==> 2006-07-02 08:09:04.423
 * (new Date()).pattern("yyyy-MM-dd E HH:mm:ss") ==> 2009-03-10 二 20:09:04
 * (new Date()).pattern("yyyy-MM-dd EE hh:mm:ss") ==> 2009-03-10 周二 08:09:04
 * (new Date()).pattern("yyyy-MM-dd EEE hh:mm:ss") ==> 2009-03-10 星期二 08:09:04
 * (new Date()).pattern("yyyy-M-d h:m:s.S") ==> 2006-7-2 8:9:4.18
 */
Date.prototype.pattern = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "h+": this.getHours() % 12 == 0 ? 12 : this.getHours() % 12, //小时
        "H+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    var week = {
        "0": "/u65e5",
        "1": "/u4e00",
        "2": "/u4e8c",
        "3": "/u4e09",
        "4": "/u56db",
        "5": "/u4e94",
        "6": "/u516d"
    };
    if (/(y+)/.test(fmt)) {
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    }
    if (/(E+)/.test(fmt)) {
        fmt = fmt.replace(RegExp.$1, ((RegExp.$1.length > 1) ? (RegExp.$1.length > 2 ? "/u661f/u671f" : "/u5468") : "") + week[this.getDay() + ""]);
    }
    for (var k in o) {
        if (new RegExp("(" + k + ")").test(fmt)) {
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        }
    }
    return fmt;
};
