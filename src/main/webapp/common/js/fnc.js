//콘솔창 로그 찍기
function trace()
{
	var log = "";
	
	for (var i = 0; i < arguments.length; i++)
	{
	   log = (log == "" ) ? arguments[i] : log + " " + arguments[i];
	}
	if (typeof console != "undefined")
	{
		console.log(log);
	}
}

/*
 * replaceAll
 * note : 특정브라우저의 경우, { 는 %7B , { 는 } 는 %7D 로 문자열 처리가 되는경우가 있으므로, 해당 부분추가
 */
String.prototype.replaceAll = function(str1,str2) 
{
    return this.split(str1).join(str2);
};

/*
 * 숫자만 출력
 */
function Number()
{
	var keyCode = event.keyCode;
	
	if ( ((keyCode < 33) || (keyCode > 40)) && ((keyCode < 48) || (keyCode > 57)) && ((keyCode < 96) || (keyCode > 105)) && (keyCode !== 8) && (keyCode !== 9) && (keyCode != 13) && (keyCode != 46) && (keyCode != 144) && (keyCode != 110)  && (keyCode != 190))	
	{
		event.returnValue = false;
		return;
	}
}

function numChk(obj)
{
	var pttn = /^[0-9]*$/;
	var objVal = jQuery(obj).val();
		
	if(!pttn.test(objVal))
	{
		alert("* 숫자만 입력 가능합니다.");
		jQuery(obj).val("");
		jQuery(obj).focus();
	}
}

//browser detect
var browser = (function() {
	var s = navigator.userAgent.toLowerCase();
	var match = /(webkit)[ \/](\w.]+)/.exec(s) || /(opera)(?:.*version)?[ \/](\w.]+)/.exec(s) || /(msie) ([\w.]+)/.exec(s) || /(mozilla)(?:.*? rv:([\w.]+))?/.exec(s) || [];
	
	return { name: match[1] || "", version: match[2] || "0" };
}());

function textarea_maxlength(obj)
{
	var maxLength = parseInt(obj.getAttribute("maxlength"));
	
	if(obj.value.length > maxLength)
	{
		obj.value=obj.value.substring(0, maxLength);
	}
}

function number_format(num){
    var num_str = num.toString();
    var result = "";
 
    for(var i=0; i<num_str.length; i++){
        var tmp = num_str.length - (i+1);
 
        if(((i%3)==0) && (i!=0))    result = ',' + result;
        result = num_str.charAt(tmp) + result;
    }
 
    return result;
}

function setPopup(pUrl, pName, pSw, pSh) 
{
	//스크린의 크기
	var cw = screen.availWidth;
	var ch = screen.availHeight;
	var sw = pSw;
	var sh = pSh;
	var ml = (cw - sw) / 2; 
	var mt = (ch - sh) / 2;
	
	window.open(pUrl, pName, "width="+sw+",height="+sh+",top="+mt+",left="+ml+",toolbar=no,menubar=no,scrollbars=no,resizable=no,copyhistory=no");
}

function startProgress(ptarget, target)
{
  	if(jQuery(target).size() > 0)
  	{
  		var indicator = jQuery(target).remove();

  		indicator.css('position', 'absolute').css('top', '0px').css('left', '0px').css('background-color','#000').css('z-index',1001).css('opacity',0.7).width('100%').height(jQuery(document).height());

  		indicator.find('img').css('left', jQuery(document).width() / 2);
  		
		ptarget.after(indicator.show());
  	}
}

function endProgress(ptarget, target)
{
  	if(jQuery(target).size() > 0)
  	{
  		var indicator = jQuery(target).remove();
  		
  		indicator.removeAttr("style");
  		
		ptarget.after(indicator.hide());
  	}
}