;Date.prototype.Pattern=function(fmt){
    var o = {
    "M+" : this.getMonth()+1,
    "d+" : this.getDate(), 
    "h+" : this.getHours()%12 == 0 ? 12 : this.getHours()%12,
    "H+" : this.getHours(), 
    "m+" : this.getMinutes(), 
    "s+" : this.getSeconds(), 
    "q+" : Math.floor((this.getMonth()+3)/3), 
    "S" : this.getMilliseconds()
    };
    var week = {"0" : "\u65e5","1" : "\u4e00","2" : "\u4e8c","3" : "\u4e09","4" : "\u56db","5" : "\u4e94","6" : "\u516d"};
    if(/(y+)/.test(fmt)){fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));}
    if(/(E+)/.test(fmt)){fmt=fmt.replace(RegExp.$1, ((RegExp.$1.length>1) ? (RegExp.$1.length>2 ? "\u661f\u671f" : "\u5468") : "")+week[this.getDay()+""]);}
    for(var k in o){
      if(new RegExp("("+ k +")").test(fmt)){
         fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
      }
    }
    return fmt;
};
var ut = {
    e:function(id){var obj = document.getElementById(id);if(va.isnull(obj)){return null;}return obj;},
    n:function(na){return document.getElementsByName(na);},
    v:function(id){return ut.trim(ut.e(id).value);},
    h:function(id){return ut.e(id).innerHTML;},
    html:function(id,s){ut.e(id).innerHTML=s;},
    m:function(s){alert(s);},
    show:function(s){var ida=s.toString().split(' ');for(var i=0; i<ida.length; i++)this.e(ida[i]).style.display='block';},
    hide:function(s){var ida=s.toString().split(' ');for(var i=0; i<ida.length; i++)this.e(ida[i]).style.display='none';},
    swap:function(b){var v=ut.e(b).style.display;ut.e(b).style.display=(v=='block')?'none':'block';},
    trim:function(s){return s.replace(/^\s+|\s+$/g,"");},
    cutstr:function(s,m){return (s.length>m)?(s.substring(0,m-2)+'...'):(s);},
    dec:function(s){return decodeURIComponent(s);},
    enc:function(s){return encodeURIComponent(s);},
    reload:function(s){if(va.isnull(s)){location.reload();}else{location.replace(s);} },
    gopage:function(s){top.location.replace(s);return;},/* location.href=s; */
    get:function(q){
        var v="";var s = location.href;s = s.replace("?","?&").split("&");for(var i=1;i<s.length;i++){if(s[i].indexOf(q+"=")==0)v = s[i].replace(q+"=","");}v = ( typeof(v) == "undefined" )?'':v;if( v.indexOf("#")>=0)v = v.substring(0,v.indexOf("#"));return v;},
    delay:function(f){setTimeout(f,600);},
    wait:function(f,ms){return setTimeout(f,ms);},
    swapsel:function(na){var ds = ut.n(na);for(var i=0; i<ds.length; i++){ds[i].checked=ds[i].checked==true?false:true;}},
    getselv:function(na){var ds = ut.n(na);var sm =[];for(var i=0; i<ds.length; i++){if(ds[i].checked){sm.push(ds[i].value);}}return sm.join('-');},
    lower:function(s){return s.toLowerCase();},
    upper:function(s){return s.toUpperCase();},
    parseMs:function(datestr){
        if(!va.datetime(datestr)){return 0;}
        var d  = new Date();var d1 =  datestr.split(' ');var a = d1[0].split('-');var b = d1[1].split(':');
        d.setFullYear(Number(a[0]), Number(a[1])-1, Number(a[2]));d.setHours(Number(b[0]), Number(b[1]), Number(b[2]), 1);
        return d.getTime();
    },
    parseDate:function(ms,len){if(ms<10){return '';}else{
            var l = len || 19;
            var fmt = "yyyy-MM-dd HH:mm:ss".substring(0,l);
            return (new Date(ms)).Pattern(fmt);
        }},
    getTime:function(){
    var now = new Date();
    var year = now.getFullYear();
    var month = now.getMonth()+1;
    month=(parseInt(month)<10)?('0'+month.toString()):month;
    var day = now.getDate();
    day=(parseInt(day)<10)?('0'+day.toString()):day;
    var wd=["日","一","二","三","四","五","六"];
    return [year,"年",month,"月",day,"日  星期",wd[now.getDay()]].join('');
    },
    outpage:function(pn,r,cmd,pgid,ls,step){
	if(va.isnull(ut.e(pgid)) || !va.mint(pn))return;
        var rn = Number(r);
        var pc =(rn%ls==0)?parseInt(rn/ls):parseInt(rn/ls)+1;
        if(pn>pc || pn<1 || pc==1){ut.html(pgid, '');return;}
        var p1 = (pn==1)?1:(pn-1);
        var p2 = (pn<pc)?(pn+1):pc;
        var fp = (pn<2)?'':['<a href="#p" onclick="',cmd,'(1,',rn,');">首页</a> '].join('');
        var pre = (pn<=2)?'':['<a href="#p" onclick="',cmd,'(',p1,',',rn,');">上一页</a> '].join('');
        var nex = (pn>pc-2)?'':[' <a href="#p" onclick="',cmd,'(',p2,',',rn,');">下一页</a> '].join('');
        var ep = (pn>=pc)?'':['<a href="#p" onclick="',cmd,'(',pc,',',rn,');">末页</a> '].join('');
        var rt =[];
        var u =['<a href="#p" onclick="',cmd,'(@p,',rn,');">@p</a> '].join('');
        var du = '<a href="javascript:;" disabled="disabled" onclick="return false;" class="cur">@p</a> ';
        var go = [' 转到第<input type="text" size="4" onchange="',cmd,'(this.value,',rn,');" value="" maxlength="5"/>页 '].join('');
        if ( (pn<=pc) && (pn>=1) ){
        var k =(parseInt(pn/step))*step +1;
        if( k+step-1 <= pc ){
            for (var j=0 ;j<step; j++){
                if(k==pn){rt.push(du.replace(/@p/g,k));}else{rt.push(u.replace(/@p/g,k));}
                k++;}
        }else{
            for(var i=k ; i<= pc ; i++){ if(i==pn){rt.push(du.replace(/@p/g,i));}else{rt.push(u.replace(/@p/g,i));}}
        }
         }
       var pt =[fp,pre,rt.join(''),' <a href="javascript:;">共',pc,'页</a> ', nex, ep, go].join('') ;
        ut.html(pgid, pt);
},
	r:function(){return Math.random()*100;},
	rndint:function(b,e){return parseInt( b + parseInt( Math.random()*(e-b) ) );},
	doxCall:function(url,func){ 
        $.ajax({cache:false,url:url,dataType:"jsonp",jsonp:"jsonpcall",
                success:function(d){
                    func(d);
    }});},
    getFormData:function(frm){
         if(typeof(frm) == "string"){frm = jQuery(frm);}
	var datas = frm.serializeArray();
	var json = {};
	jQuery.each(datas, function(i, e){
		  if(e.value!=''){
			  var v = jQuery.trim(e.value);
			  if(v.length>0){
				  json[e.name]=v;
			  }
		  }
	});
	return jQuery.param(json);
    },
    rndChr:function(len){
    	var _map = 'abcdefghijklmnopqrstuvwxyz0123456789';
    	var size = _map.length;
    	var len = len || 16;
    	var s=[];
    	for(var i=0; i<len; i++){
    		s.push(_map.charAt(ut.rndint(0,size)));
    	}
    	return s.join('');
    }
};
/* 格式化数值 */
ut.fmtNumber = function(number,pattern){
    var str            = number.toString();
    var strInt;
    var strFloat;
    var formatInt;
    var formatFloat;
    if(/\./g.test(pattern)){
        formatInt        = pattern.split('.')[0];
        formatFloat        = pattern.split('.')[1];
    }else{
        formatInt        = pattern;
        formatFloat        = null;
    }

    if(/\./g.test(str)){
        if(formatFloat!=null){
            var tempFloat    = Math.round(parseFloat('0.'+str.split('.')[1])*Math.pow(10,formatFloat.length))/Math.pow(10,formatFloat.length);
            strInt        = (Math.floor(number)+Math.floor(tempFloat)).toString();                
            strFloat    = /\./g.test(tempFloat.toString())?tempFloat.toString().split('.')[1]:'0';            
        }else{
            strInt        = Math.round(number).toString();
            strFloat    = '0';
        }
    }else{
        strInt        = str;
        strFloat    = '0';
    }
    if(formatInt!=null){
        var outputInt    = '';
        var zer        = formatInt.match(/0*$/)[0].length;
        var comma        = null;
        if(/,/g.test(formatInt)){
            comma        = formatInt.match(/,[^,]*/)[0].length-1;
        }
        var newReg        = new RegExp('(\\d{'+comma+'})','g');

        if(strInt.length<zero){
            outputInt        = new Array(zer+1).join('0')+strInt;
            outputInt        = outputInt.substr(outputInt.length-zer,zer);
        }else{
            outputInt        = strInt;
        }

        outputInt            = outputInt.substr(0,outputInt.length%comma)+outputInt.substring(outputInt.length%comma).replace(newReg,(comma!=null?',':'')+'$1');
        outputInt            = outputInt.replace(/^,/,'');

        strInt    = outputInt;
    }
    if(formatFloat!=null){
        var outputFloat    = '';
        var zero        = formatFloat.match(/^0*/)[0].length;

        if(strFloat.length<zero){
            outputFloat        = strFloat+new Array(zero+1).join('0');
            //outputFloat        = outputFloat.substring(0,formatFloat.length);
            var outputFloat1    = outputFloat.substring(0,zero);
            var outputFloat2    = outputFloat.substring(zero,formatFloat.length);
            outputFloat        = outputFloat1+outputFloat2.replace(/0*$/,'');
        }else{
            outputFloat        = strFloat.substring(0,formatFloat.length);
        }

        strFloat    = outputFloat;
    }else{
        if(pattern!='' || (pattern=='' && strFloat=='0')){
            strFloat    = '';
        }
    }
    return strInt+(strFloat==''?'':'.'+strFloat);
};
/* 格式化缩图地址 */
ut.fmtImageThumb = function(picUrl, thumbWidth){
	var pos = picUrl.lastIndexOf('.');// abc.jpg
	var pre = picUrl.substring(0, pos);// abc
	var ext = picUrl.substring(pos+1); // jpg
	return [pre, thumbWidth, ext].join('.');
};
var va={
    tint:function(s){return (/^[0-9\-]{1,2}$/).test(s);},
    mint:function(s){return (/^[0-9\-]{1,5}$/).test(s);},
    isint:function(s){return (/^[0-9\-]{1,8}$/).test(s);},
    islong:function(s){return (/^[0-9\-]{1,20}$/).test(s);},
    joinstr:function(s){return (/^[0-9a-zA-Z,\-]{1,215}$/).test(s);},
    price:function(s){return (/^([0-9\\-]{1,7})\.([0-9]{1,2})$/).test(s);},
    email:function(s){return (/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/).test(s);},
    key:function(s){return (/^[^\s]{6,20}$/).test(s);},
    name:function(s){return (/^[a-zA-Z0-9\s,\/\-\u4E00-\u9FA5]{2,64}$/).test(s);},
    title:function(s){return (/^[^=<>]{2,64}$/).test(s);},
    tel:function(s){return (/^((\(\d{2,3}\))|(\d{3}\-))?(13|15|18)\d{9}$/).test(s);},
    phone:function(s){return (/^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/).test(s);},
    nick:function(s){return (/^[a-zA-Z0-9\u4E00-\u9FA5]{2,16}$/).test(s);},
    date:function(s){return (/^([0-9]{4})-([0-9]{2})-([0-9]{2})$/).test(s);},
    datetime:function(s){return (/^([0-9]{4})-([0-9]{2})-([0-9]{2})\s([0-9]{1,2}):([0-9]{1,2}):([0-9]{1,2})$/).test(s);},
    pic:function(s){return (/^.+.(jpg|png|gif)$/i).test(s);},
    url:function(s){return (/^http[s]?:\/\/[A-Za-z0-9]+\.[A-Za-z0-9]+[\/=\?%\-&_~`@[\]\':+!]*([^<>\"\"])*$/i).test(s);},
    isnull:function(exp){if(typeof(exp)=="undefined"){return true;}if(exp===0 ){return false;}else if(exp==null || !exp  || exp=='' || exp=='null'){return true;}else{return false;}},
    krate:function(s){return s.replace(/^(?:(?=.{4})(?=.*([a-z])|.)(?=.*([A-Z])|.)(?=.*(\d)|.)(?=.*(\W)|.).*|.*)$/, "$1$2$3$4").length;}
};
var filter={
    html:function(s){
        if(va.isnull(s))return '';
        var t=ut.trim(s);
        return t.replace(/&/g,'&amp;').replace(/\"/g,'&quot;').replace(/\'/g,'&#39;').replace(/。/g,'.').replace(/[，、]{1,}/g,',').replace(/…/g,'.').replace(/；/g,';').replace(/：/g,':').replace(/？/g,'?').replace(/（/g,'(').replace(/）/g,')').replace(/！/g,'!').replace(/[〈<（]{1,}/g,'&lt;').replace(/[〉>）]{1,}/g,'&gt;').replace(/[\f\t]{1,}/g,'');
    },
    txt:function(s){
      if(va.isnull(s))return '';
      var t=ut.trim(s);
      return t.replace(/&amp;/g,'&').replace(/&quot;/g,'"').replace(/&#39;/g,'\'').replace(/&lt;/g,'<').replace(/&gt;/g,'>').replace(/<br>/g,'\n');
    },
    script:function(s){
        if(va.isnull(s))return '';
        var t=ut.trim(s);
	return t.replace(/<\/?script[^>]*>/gi,"").replace(/(javascript|jscript|vbscript|vbs|xss):/gi,"").replace(/exp(\w+)/gi,"").replace(/on(.{3,20})=/gi,"").replace(/[\r\n\f\t\b]{1,}/g,"");
    },
    clrxml:function(s){
        if(va.isnull(s))return '';var t=ut.trim(s);
        return t.replace(/<[^>]+>/g,"").replace(/[\f\t\b]{1,}/g,"");
    }
};
//  jQuery.parseJSON() or JSON.stringify(obj) 
/**
 * 返回json数组格式的表单数据
 * 已剔除没有值的参数名
 */
jQuery.fn.getFormData = function(options){
	var datas = this.serializeArray();
	var json = {};
	jQuery.each(datas, function(i, e){
		  if(e.value!=''){
			  var v = jQuery.trim(e.value);
			  if(v.length>0){
				  json[e.name]=v;
			  }
		  }
	});
	return json;
};
/**
 *重置表单
 */
jQuery.fn.resetfrm = function(options){
	var arr = this.toArray();
	for(var k in arr){
		arr[k].reset();
	}
};

var ArrayUtil = {};
/**
 * 提取array中的ID值，返回多个ID值的连接串
 * 可指定连接串字符：concatChar，默认: , 
 * 可指定ARRAY中的ID名称：idName, 默认: id
 */
ArrayUtil.getKeyConcatText=function(arr, concatChar, key){
	var vs = ArrayUtil.getValueArray(arr, key);
	return vs.join(concatChar || ',');
};

/**
 * 将array数组中的JSON名称为IDNAME的值转换为查询地址串文本，查询名称以queryName开头使用[n]标注多个值
 */
ArrayUtil.getQueryText = function(arr, queryName, idName) {
	var vs = ArrayUtil.getValueArray(arr, idName);
	var qt = [];
	var qn = queryName || 'id';
	for ( var k in vs) {
		qt.push( (qn+'[' + k + ']=')+encodeURIComponent(String(vs[k])));
	}
	return qt.join('&');
};

/**
 * 从一个数组中提取JSON属性为idName的值作为新数组返回
 */
ArrayUtil.getValueArray=function(arr, key){
	if(!jQuery.isArray(arr)){
		alert('不是数组对象');
		return [];
	}
	var idkey = key || 'id';
	var vs = [];
	for(var k in arr){
		var idval = arr[k][idkey];
		if(idval!=='undefined'){
			vs.push(idval);
		}
	}
	return vs;
};

/**
 * 对话框封装
 */
var JDialog ={
 isLayer:function(){
			return !!window.layer ;
 },
 tips : '请实例化layer对话框组件!'
};
JDialog.alertError=function(msg, func){
	if(JDialog.isLayer()){
		layer.alert(msg, {icon: 0, title: '错误提示'}, func);
	}else{
		alert(msg);
	}
};
JDialog.alertMsg=function(msg, func){
	if(JDialog.isLayer()){
		layer.alert(msg, {icon: 6, title: '提示'}, function(index){
			if(typeof(func)=="function"){func();};
			setTimeout(function(){layer.close(index);}, 200);
		});
	}else{
		alert(msg);
		if(typeof(func)=="function"){func();};
	}
};
JDialog.msg=function(msg){
	if(JDialog.isLayer()){
		layer.msg(msg);
	}else{
		alert(msg);
	}
};
// 打开一个对话窗口,使用外部的一个布局容器
JDialog.openWin = function(title, jqSelector, opt){
	if(JDialog.isLayer()){
		var wh = [];
		if(opt && opt.width){
			wh[0]= opt.width+'px';
		}
		if(opt && opt.height){
			wh[1]= opt.height+'px';
		}
		return layer.open({
			type : 1,
			title : title,
			area : wh.length>0 ? wh : 'auto' ,
			content : $(jqSelector)
		});
	}else{
		alert(JDialog.tips);
	}
};
// eg : JDialog.openIFrameWin('http://www.baidu.com', {width:500, height:500});
JDialog.openIFrameWin = function(src, opt){ 
	if(JDialog.isLayer()){
		var wh = [];
		if(opt && opt.width){
			wh[0]= opt.width+'px';
		}
		if(opt && opt.height){
			wh[1]= opt.height+'px';
		}
		layer.open({
			  type: 2, 
			  area : wh.length>0 ? wh : 'auto' ,
			  content: [src,'no']
		});
	}else{
		alert(JDialog.tips);
	}
};
// 询问对话框
JDialog.confirm = function(tit, ask, func){
	if(JDialog.isLayer()){
		layer.confirm(ask, {icon: 3, title:tit||'提示'}, function(index){
			func(index);
		});
	}else{
		if(confirm(ask)){
			func();
		}
	}
};
JDialog.closeAll=function(){
	if(JDialog.isLayer()){
		layer.closeAll();
	}else{
		alert(JDialog.tips);
	}
};
JDialog.close=function(index){
	if(JDialog.isLayer()){
		layer.close(index);
	}else{
		alert(JDialog.tips);
	}
};
// ajax加载数据后展示对话框
JDialog.ajaxLoadWin = function(restUrl, callfunc, divId, title, w, h){
	if(!JDialog.isLayer()){
		alert(JDialog.tips);
		return ;
	}
	var loading = layer.load();
	$.get(restUrl, function(x){
		layer.close(loading);
    	if(typeof(callfunc) == 'function'){
			callfunc(x);
		}
        JDialog.openWin(title, divId, {width:w, height:h});
    });
};
/***********************************
 * 对ajax异常消息框的封装
 * 处理服务器返回的各种错误
 * @param event
 * @param request
 * @param settings
 */
function globalAjaxErrorHandler(event, xhr, settings, err){
	if(xhr.status == 400 || xhr.status == 500){// validate failed , Business error
		var result = xhr.status + " 请求失败.\r\n" + (xhr.responseText);
		showErrorMsg(result);
		return;
	}
	if(xhr.status == 510){// validate failed , Business error
		var result = jQuery.parseJSON(xhr.responseText);
		showErrorMsg(result);
		return;
	}
	if(xhr.status == 403){
		var result = "403 拒绝访问.\r\n" + (xhr.responseText);
		showErrorMsg(result);
		return;
	}
	if(xhr.status == 404){
		var result = "404 资源未发现.\r\n" + (xhr.responseText);
		showErrorMsg(result);
		return;
	}
	if(window.JDialog) {
		try {
			var handler = window;
			while(true) {
				if(! handler.JDialog) {
					break;
				}
				var p = handler.parent;
				if(p == handler || !p) {
					return;
				}
				handler = p;
			}
			if(handler && window != handler) {
				handler.globalAjaxErrorHandler(event, xhr, settings);
				return;
			}
		}catch(e){
			console.log(e);
		}
	}
	var type = settings.dataTypes.join(",");
	type = type.toLowerCase();
	try{
		if(type.match("xml")){
			var result = xhr.responseXML;
			if(result) {
				showErrorMsg(result.firstChild.firstChild.errors.nodeValue);
			}else{
				showErrorMsg("系统错误！");
			}
		}else if(type.match(/(json)|(script)/)){
			var result = jQuery.parseJSON(xhr.responseText);
			if(result) {
				showErrorMsg(result);
			} else {
				showErrorMsg("系统错误！");
			}
		}else{
			showErrorMsg(xhr.responseText);
		}
	}catch(e){
		console.log(e)
		showErrorMsg("Unknow Error:"+ err + "\r\n" +xhr.responseText);
	}
};

function showErrorMsg(res){
	var emsg = '';
	if (res.errors) {
		$.each(res.errors, function(index, value) {
			emsg +=(value.replace(/\r|\n/g,'<br/>'));
		});
	}else if(res.exception){
		emsg +=(res.exception.replace(/\r|\n/g,'<br/>'));
	}else {
		emsg +=(filter.clrxml(res).replace(/\r|\n/g,'<br/>'));
	}
	JDialog.alertError('<p id="error_msg_box" class="alert alert-warning">' + emsg +'</p>');
};

if(window.jQuery){
 jQuery(document).ajaxError(globalAjaxErrorHandler);
};

var JGrid = {};
// 实例化一个jqgrid查询表格, 返回jqgrid对象
JGrid.initSearchGrid = function(tableId, pageId, _colModel, _opt){
	var myGrid = $(tableId);
	var ctxpath = window.ctx || '' ;
	var jqGridOpt ={
			url : ctxpath +'/static/empty.html',
			mtype : "GET",
			styleUI : 'Bootstrap',
			datatype : "json",
			colModel : _colModel,
			multiselect : true,
			viewrecords : true,
			height : 500,
			rowList : [ 10, 20, 50 ],
			rowNum : 10,
			pager : pageId,
			shrinkToFit : false,
			autowidth : true,
			rownumbers : true,
			scrollOffset : 5,
			prmNames : {
				page : 'pageNo',
				rows : 'listSize'
			},
			postData : {
				"_ref" : "uuola_search"
			},
			jsonReader : {
				root : "dataSet",
				records : "total",
				total : "pages"
			},
			beforeProcessing : function(data, status, xhr) {
				if (data) {
					var records = data.total;
					var rows = myGrid.getGridParam("rowNum");
					var pages = Math.ceil(records / rows);
					data['pages'] = Number(pages).toString();
				}
			}
		};
	if(_opt){
		$.extend(jqGridOpt, _opt);
	}
	myGrid.jqGrid(jqGridOpt);
	return myGrid;
};

JGrid.initArrayGrid = function(tableId, _colModel, _data){
	var myGrid = $(tableId);
	var jqGridOpt ={
		datatype : "local",
        height: 'auto',
		styleUI : 'Bootstrap',
		colModel : _colModel,
		autowidth : true,
		shrinkToFit : false
	};
	myGrid.jqGrid(jqGridOpt);
	if(_data){
		for ( var i = 0; i <= _data.length; i++){
			myGrid.jqGrid('addRowData', i + 1, _data[i]);
		}
	}
	return myGrid;
};

// jqgrid 日期格式化
JGrid.datetimeFormat = function(cellvalue, options, rowObject) {
	if (cellvalue) {
		return ut.parseDate(cellvalue);
	}
	return "-";
};
//默认布尔值格式化： 0,1 分别对应 ：[否,是]  
JGrid.boolFormat = function(cellvalue, options, rowObject) {
	if(cellvalue == null){
		return "";
	}
	var textArgs = ['<span class="label label-danger">否</span>','<span class="label label-success">是</span>'];
	return textArgs[parseInt(cellvalue)];
};
//布尔状态类格式化 ： 0,1 分别对应 ：[无效,有效] 
JGrid.boolStateFormat = function(cellvalue, options, rowObject) {
	if(cellvalue == null){
		return "";
	}
	var textArgs = ['<span class="badge badge-warning">无效</span>','<span class="badge badge-success">有效</span>'];
	return textArgs[parseInt(cellvalue)];
};
//审批状态类格式化 ： 0,1 分别对应 ：[无效,有效,待审核] 
JGrid.auditStateFormat = function(cellvalue, options, rowObject) {
	if(cellvalue == null){
		return "";
	}
	var textArgs = ['<span class="label label-danger">无效</span>','<span class="label label-success">有效</span>','<span class="label label-warning">待审核</span>'];
	return textArgs[parseInt(cellvalue)];
};
//逻辑删除格式化 ： 0,1 分别对应 ：[正常,已删] 
JGrid.deleteFormat = function(cellvalue, options, rowObject) {
	if(cellvalue == null){
		return "";
	}
	var textArgs = ['<span class="label label-success">正常</span>','<span class="label label-danger">已删</span>'];
	return textArgs[parseInt(cellvalue)];
};
// 初始化编辑连接
JGrid.initEidtFormat = function(cellvalue, options, rowObject) {
	return '<a href="#init-edit" class="edit-record" data-id="'+rowObject.id+'">' + cellvalue + '</a>';
};
// 绑定JQGRID 行编辑事件 function(id)
JGrid.bindEidtOnClickEvent = function(jqGridObj, func){
	jqGridObj.bind('jqGridGridComplete', function(){
		$('.edit-record').on('click', function(){
			var $a = $(this);
			var id = $a.attr('data-id');
			if(typeof(func) == 'function'){
				func(id);
			}else{
				alert('请传入function(id)函数!');
			}
		});
	});
};
// 将字典参数绑定下拉选项
jQuery.fn.selectOptions = function(DICT,label){
	var lb = label || '';
    var options = '<option value="">-请选择'+lb+'-</option>';
    $.each(DICT,function (key,value) {
        var option = '<option value="'+key+'">' + value + '</option>';
        options += option;
    });
    this.html(options);
};