var AppConfig = {
	defAvatar : 'http://file.youjob.co/image/ic_avatar.png'
}
var myData = {
	boshDomain : "121.41.14.128",// XMPP主机IP或域名
	mucJID : "muc.121.41.14.128",// muc.+XMPP主机IP或域名
	boshUrl : "http://121.41.14.128:8089/http/",// http://+（XMPP主机IP或域名）+（:5222）
	//boshUrl : "http://120.26.106.242:8089/baidu/",
	apiUrl : "http://121.41.14.128:8092",// 接口地址（修改“114.119.6.150”即可）
	uploadAvatarUrl : "http://121.41.14.128:8080/upload/UploadifyAvatarServlet",// 头像上传URL（修改“www.youjob.co”即可）
	uploadUrl : "http://121.41.14.128:8080/upload/UploadifyServlet",// 文件上传URL（修改“www.youjob.co”即可）
	defaultAvatarUrl : "http://121.41.14.128/avatar/t/104/10000104.jpg",// 默认头像地址（）
	avatarBase : "http://121.41.14.128/avatar/o/",// 头像父目录（修改“file.youjob.co”即可）

	jid : null,
	_connection : null,
	messageReceiver : null,
	successCallback : null,
	failureCallback : null,
	init : function(successCallback, failureCallback, messageReceiver) {
		this.successCallback = successCallback;
		this.failureCallback = failureCallback;
		this.messageReceiver = messageReceiver;

		this._connection = new Strophe.Connection(this.boshUrl);
		this._connection.connect(this.jid, this.password, this.callback);
	},
	callback : function(status) {
		if (status == Strophe.Status.CONNECTED) {
			// 登录成功后发送一个空<presence>给服务器
			this._connection.send($pres().tree());
			// 当接收到<message>节，调用onMessage回调函数
			var _handler = this._connection.addHandler(this.messageReceiver, null, 'message', null, null, null);
			this.successCallback.call();
		} else if (status = Strophe.Status.CONNECTING) {

		} else {
			this.failureCallback.call();
		}
	},
	send : function(elem) {
		this._connection.send(elem);
	},

	userId : null,
	telephone : null,
	password : null,
	access_token : null,
	loginResult : null,
	user : null,

	locateParams : null,

	charArray : '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz'.split('')
}
var myFn = {
	invoke : function(obj) {
		jQuery.support.cors = true;
		var params = {
			type : "POST",
			url : "",
			data : {},
			contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
			dataType : 'JSON',
			success : function(result) {
			},
			error : function(result) {
			},
			complete : function() {
			}
		};
		
		$.extend(params, obj);
		params.data["geturl"] = params.url;
		params.url = '/clientshow/liveShow!getdata.action';
		params.data["access_token"] = myData.access_token;
		$.ajax(params);
	},
	getAvatarUrl : function(userId) {
		var imgUrl = myData.avatarBase + (parseInt(userId) % 10000) + "/" + userId + ".jpg";
		return imgUrl;
	},
	isNil : function(s) {
		return undefined == s || null == s || $.trim(s) == "" || $.trim(s) == "null";
	},
	randomUUID : function() {
		var chars = myData.charArray, uuid = new Array(36), rnd = 0, r;
		for (var i = 0; i < 36; i++) {
			if (i == 8 || i == 13 || i == 18 || i == 23) {
				uuid[i] = '-';
			} else if (i == 14) {
				uuid[i] = '4';
			} else {
				if (rnd <= 0x02)
					rnd = 0x2000000 + (Math.random() * 0x1000000) | 0;
				r = rnd & 0xf;
				rnd = rnd >> 4;
				uuid[i] = chars[(i == 19) ? (r & 0x3) | 0x8 : r];
			}
		}
		return uuid.join('').replace(/-/gm, '').toLowerCase();
	},
	toDateTime : function(timestamp) {
		return (new Date(timestamp * 1000)).format("yyyy-MM-dd hh:mm:ss");
	},
	toDate : function(timestamp) {
		return (new Date(timestamp * 1000)).format("yyyy-MM-dd");
	},
	getUserIdFromJid : function(jid) {
		var userId = jid.substr(0, jid.indexOf("@"));
		return userId;
	},
	getJid : function(userId) {
		return userId + "@" + myData.boshDomain;
	},
	getAudioPlayer : function(passedOptions) {
		var playerpath = "/js/";

		// passable options
		var options = {
			"filepath" : "", // path to MP3 file (default: current directory)
			"backcolor" : "", // background color
			"forecolor" : "ffffff", // foreground color (buttons)
			"width" : "25", // width of player
			"repeat" : "no", // repeat mp3?
			"volume" : "50", // mp3 volume (0-100)
			"autoplay" : "false", // play immediately on page load?
			"showdownload" : "true", // show download button in player
			"showfilename" : "true" // show .mp3 filename after player
		};

		if (passedOptions) {
			jQuery.extend(options, passedOptions);
		}
		var filename = options.filepath;
		var mp3html = '<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" ';
		mp3html += 'width="' + options.width + '" height="20" ';
		mp3html += 'codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab">';
		mp3html += '<param name="movie" value="' + playerpath + 'singlemp3player.swf?';
		mp3html += 'showDownload=' + options.showdownload + '&file=' + filename + '&autoStart=' + options.autoplay;
		mp3html += '&backColor=' + options.backcolor + '&frontColor=' + options.forecolor;
		mp3html += '&repeatPlay=' + options.repeat + '&songVolume=' + options.volume + '" />';
		mp3html += '<param name="wmode" value="transparent" />';
		mp3html += '<embed wmode="transparent" width="' + options.width + '" height="20" ';
		mp3html += 'src="' + playerpath + 'singlemp3player.swf?'
		mp3html += 'showDownload=' + options.showdownload + '&file=' + filename + '&autoStart=' + options.autoplay;
		mp3html += '&backColor=' + options.backcolor + '&frontColor=' + options.forecolor;
		mp3html += '&repeatPlay=' + options.repeat + '&songVolume=' + options.volume + '" ';
		mp3html += 'type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" />';
		mp3html += '</object>';
		//console.log(mp3html);
		return mp3html;
	},
	parseContent : function(content) {
		var emojlKeys = new Array();
		var s = content;
		var fromIndex = 0;
		while (fromIndex != -1) {
			fromIndex = s.indexOf("[", fromIndex);
			if (fromIndex == -1)
				break;
			else {
				var stop = s.indexOf("]", fromIndex);
				if (stop == -1)
					break;
				else {
					var emojlKey = s.substring(fromIndex, stop + 1);
					emojlKeys.push(emojlKey);
					fromIndex = fromIndex + 1;
				}
			}
		}
		if (emojlKeys.length != 0) {
			for (var i = 0; i < emojlKeys.length; i++) {
				var key = emojlKeys[i];
				s = s.replace(key, "<img src='" + _emojl[key] + "' width='24' height='24' />");
			}
		}
		return s;
	}
}
var mySdk = {
	getUser : function(userId, callback) {
		myFn.invoke({
			url : '/user/get',
			data : {
				userId : userId
			},
			success : function(result) {
				if (1 == result.resultCode) {
					callback(result.data);
				}
			},
			error : function(result) {
			}
		});
	},
	getFriendsList : function(userId, pageIndex, callback) {
		myFn.invoke({
			url : '/friends/page',
			data : {
				userId : userId,
				pageIndex : pageIndex,
				pageSize : 11
			},
			success : function(result) {
				if (1 == result.resultCode) {
					callback(result.data);
				}
			},
			error : function(result) {
			}
		});
	},
	locate : function(callback) {
		var script = document.createElement('script');
		if (callback)
			script.src = 'http://api.map.baidu.com/location/ip?ak=OuLCe9EHc0v6Ik5BiAE4oxfN&coor=bd09ll&callback=' + callback;
		else
			script.src = 'http://api.map.baidu.com/location/ip?ak=OuLCe9EHc0v6Ik5BiAE4oxfN&coor=bd09ll&callback=mySdk.locateCallback';
		document.body.appendChild(script);
	},
	locateCallback : function(result) {
		if (0 == result.status) {
			//console.log("百度IP定位成功");
			var provinceName = result.content.address_detail.province;
			var cityName = result.content.address_detail.city;
			var provinceId = TB_AREAS[provinceName];
			var cityId = TB_AREAS[cityName];
			var longitude = result.content.point.x;
			var latitude = result.content.point.y;
			myData.locateParams = {
				provinceId : provinceId,
				cityId : cityId,
				longitude : longitude,
				latitude : latitude
			}
		} else{
			//console.log("百度IP定位失败，请求错误。");
	}
	},
	getAccessToken : function() {
		if (!isNil(myData.access_token))
			return myData.access_token;

		invoke({
			async : false,
			url : '/user/login',
			data : {
				telephone : myData.telephone,
				password : myData.password
			},
			success : function(result) {
				if (1 == result.resultCode) {
					myData.access_token = result.data.access_token;
				}
			},
			error : function(result) {
			}
		});
		return myData.access_token;
	}
}
$(function() {
	// 对象序列化
	jQuery.prototype.serializeObject = function() {
		var data = new Object();
		$.each(this.serializeArray(), function(i, o) {
			if (!(o.name in data)) {
				data[o.name] = o.value;
			}
		});
		return data;
	};
	// 百度定位
	mySdk.locate();
});

Date.prototype.format = function(format) {
	var o = {
		"M+" : this.getMonth() + 1,
		// month
		"d+" : this.getDate(),
		// day
		"h+" : this.getHours(),
		// hour
		"m+" : this.getMinutes(),
		// minute
		"s+" : this.getSeconds(),
		// second
		"q+" : Math.floor((this.getMonth() + 3) / 3),
		// quarter
		"S" : this.getMilliseconds()
	// millisecond
	};
	if (/(y+)/.test(format) || /(Y+)/.test(format)) {
		format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	}
	for ( var k in o) {
		if (new RegExp("(" + k + ")").test(format)) {
			format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
		}
	}
	return format;
};

var _emojl = {
	// "[严肃]" : "emojl/严肃.png",
	// "[亲亲]" : "emojl/亲亲.png",
	// "[呕吐]" : "emojl/呕吐.png",
	// "[哭]" : "emojl/哭.png",
	// "[奸笑]" : "emojl/奸笑.png",
	// "[委屈]" : "emojl/委屈.png",
	// "[害羞]" : "emojl/害羞.png",
	// "[开心]" : "emojl/开心.png",
	// "[得意]" : "emojl/得意.png",
	// "[微笑]" : "emojl/微笑.png",
	// "[惊呆了]" : "emojl/惊呆了.png",
	// "[晕]" : "emojl/晕.png",
	// "[汗]" : "emojl/汗.png",
	// "[爽]" : "emojl/爽.png",
	// "[生气]" : "emojl/生气.png",
	// "[生病]" : "emojl/生病.png",
	// "[疑问]" : "emojl/疑问.png",
	// "[色眯眯]" : "emojl/色眯眯.png"
	"[微笑]" : "/emojl/101.png",
	"[鼓掌]" : "/emojl/102.png",
	"[害羞]" : "/emojl/103.png",
	"[汗]" : "/emojl/104.png",
	"[再见]" : "/emojl/105.png",
	"[抠鼻]" : "/emojl/106.png",
	"[开心]" : "/emojl/107.png",
	"[哭]" : "/emojl/108.png",
	"[奸笑]" : "/emojl/109.png",
	"[亲亲]" : "/emojl/110.png",
	"[色眯眯]" : "/emojl/111.png",
	"[惊呆了]" : "/emojl/112.png",
	"[怒]" : "/emojl/113.png",
	"[调皮]" : "/emojl/114.png",
	"[委屈]" : "/emojl/115.png",
	"[得意]" : "/emojl/116.png",
	"[疑问]" : "/emojl/117.png",
	"[晕]" : "/emojl/118.png"
};