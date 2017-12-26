
function getQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
	var r = window.location.search.substr(1).match(reg);
	if (r != null) return r[2]; return "";
};
// ajax
function ajax(url, params) {
	return $.ajax({
	  dataType: "json",
	  url: url,
	  data: params,
	  cache: false,
	  type: "POST",
	  error: ajaxError
	});
};

function ajaxError(XMLHttpRequest, textStatus, errorThrown) {
	console.log(errorThrown);
    var message = "";
    switch (errorThrown) {
        case 'Request Time-out':
            message = "请求超时";
            break;
        case 'Not Found':
            message = "请求失败！";
            break;
        case 'Forbidden':
            message = "禁止访问";
            break;
        default:
        	//console.log(errorThrown);
        	message = "网络连接失败！";
	        break;
    }
    alert(message);
    if(errorThrown=='Forbidden'){
    	var win = window;
        while (win != win.top){
            win = win.top;
        }
        win.location.href= XMLHttpRequest.getResponseHeader("CONTEXTPATH");
    }  
    
	return false;
};

var gLocation = window.location.href,
gRe = /^(http:\/\/|https:\/\/)|([^\/]*\/)/g,
gArr = gLocation.match(gRe);

function getGUrl() {//这是接口的地址
	return gArr[0]+gArr[1]+gArr[2];//生产地址 上线用这个。
	// return "http://20.26.20.83:9301/sjyytmg/";//测试地址 禁止提交到生产。
};

function getLocalUrl() {//这是本地文件的地址，比如一些js或者html或图片
	return gArr[0]+gArr[1]+gArr[2];//生产/测试地址 上线用这个。
	// return "file:///D:/fenzhi/手厅运营管理平台/";//H5的同学用这个
};

function getSessionId() {
	return "";//每个开发人员保证下面这个名字不重复即可
	// return "zmm";//测试/生产环境使用""
};
