
(function($){	

	var validation = {
		defaults : {
			notRequiredClass : "notRequired",
			ExceptionRequiredClass : "exceRequired",
			validateType : {
				idChk : {
					className : "idChk",
					regExr : "^(?=.*[a-z])[a-z0-9]{4,12}$"	// 영문만 검사
					//regExr : "^(?=.*[a-z])(?=.*[0-9])[a-z0-9]{4,12}$" // 영문 + 숫자 검사
				},
				passChk : {
					className : "passChk",
					subClassName : "passChkSub",
					//regExr : "^(?=.*[a-z])(?=.*[0-9])[a-z0-9]{6,16}$",
					regExr : "^[!@#$%^&+=a-zA-Z0-9_]{6,20}$",				
					//regExr : "^.*(?=^.{6,16}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$",
					equalClass : "passEqual"
				},
				emailChk : {
					className : "emailChk",
					regExr : "^[_a-zA-Z0-9-\\.\\_]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$"
				},
				numberChk : {
					className : "numberChk",
					regExr : "^[0-9]+$"
				},
				lengthLimitChk : {
					className : "lengthChk",
					min : 2,
					max : 4
				},
				mobileNumChk : {
					className : "mobileChk",
					regExr : "^([0]{1}[0-9]{2})-([1-9]{1}[0-9]{2,3})-([0-9]{4})$"
				},
				phoneNumChk : {
					className : "phoneChk",
					regExr : "^([0]{1}[0-9]{1,2})-([1-9]{1}[0-9]{2,3})-([0-9]{4})$"
				},
				englishChk : {
					className : "englishChk",
					regExr : "^[a-zA-Z]+$"
				},
				koreanChk : {
					className : "koreanChk",
					regExr : "^[가-힣]+$"
				}
			},
			msg : {
				type : "alert",
				empty : {
					text : "을(를) 입력해주세요.",
					password : "을(를) 입력해주세요.",
					passwordChk : "을(를) 입력해주세요.",
					radio : "라디오 버튼 값을 선택해주세요.",
					checkbox : "체크박스 값을 한개 이상 선택해주세요.",
					select : "을(를) 선택해주세요.",
					textarea : "을(를) 입력해주세요.",
					names : {
					}
				},
				idChk : "아이디 입력값이 올바르지 않습니다.\n(알파벳 소문자, 4 ~ 12자로 입력합니다.",
				passChk : "패스워드 입력값이 올바르지 않습니다.\n비밀번호는 6~16자 영문 대소문자, 숫자, 특수문자(!@#$%^&*+=)를 사용할 수 있습니다.",
				passEqualChk : "입력한 패스워드와 일치하여야 합니다.",
				emailChk : "이메일 입력값이 올바르지 않습니다.",
				numberChk : "숫자만 입력가능합니다.",
				lengthLimitChk : "길이가 조건에 맞지 않습니다.",
				mobileNumChk : "핸드폰번호는 010-1234-5678 형식으로 입력되어야 합니다.",
				phoneNumChk : "전화번호는 02-1234-5678 형식으로 입력되어야 합니다.",
				englishChk : "영문만 입력하실 수 있습니다.",
				koreanChk : "한글만 입력하실 수 있습니다.",
				confirm : "진행하시겠습니까?"
			},
			placeholder : true,
			comma : {
				use : true,
				className : "comma"
			},
			async : {
				use : false,
				func : ""
			},
			tooltip : {
				use : false
			}
		},
		action : "",
		confirm : "",
		method : {
			RegExrCheck : function(obj, regexr, msg, returnType){
				var patten, regResult;

				patten = eval("/" + regexr + "/g");

				regResult = patten.test(obj.val());

				if(typeof returnType === "function"){
					if(!regResult) returnType(obj, msg);
				}else{
					return regResult;
				}
			},
			LengthCheck : function(obj, lengthInfo, msg, returnType){
				if (obj.val().length >= lengthInfo.min && obj.val().length <= lengthInfo.max)
					regResult = true;
				else
					regResult = false;

				if(typeof returnType === "function"){
					if(!regResult) returnType(obj, msg);
				}else{
					return regResult;
				}
			},
			Comma : function(obj, event){
				var commaval = "";		

				if(event == "keyup"){
					obj.keyup(function(){
						commaval = $(this).val().replace(/[^0-9]/g, '').replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,");
						$(this).val(commaval);		
					});
				}else{
					commaval = obj.val().replace(/[^0-9]/g, '').replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,");
					obj.val(commaval);							
				}
				
			},
			AutoHypenPhone : function(str){
				var tmp = ""
				  , lens1 = 4, lens2 = 7, lens3 = 11
				  , cutlen1 = 3, cutlen2 = 3;

				str = str.replace(/[^0-9]/g, '');

				if (str.substr(0, 2) == "02")
				{
					lens1 = 3; lens2 = 6; lens3 = 10; cutlen1 = 2;
				}
				
				if( str.length < lens1){
					return str;
				}else if(str.length < lens2){
					tmp += str.substr(0, cutlen1);
					tmp += '-';
					tmp += str.substr(cutlen1);
					return tmp;
				}else if(str.length < lens3){
					tmp += str.substr(0, cutlen1);
					tmp += '-';
					tmp += str.substr(cutlen1, cutlen2);
					tmp += '-';
					tmp += str.substr(cutlen1+cutlen2);
					return tmp;
				}else{
					tmp += str.substr(0, cutlen1);
					tmp += '-';
					tmp += str.substr(cutlen1, cutlen2+1);
					tmp += '-';
					tmp += str.substr(cutlen1+(cutlen2+1));
					return tmp;
				}

				return str;				
			},
			Indicator : function(ptarget, target){
				var indicator
				  , documentHeight = $(document).height();

			  	if($(target).size() > 0){
			  		indicator = $(target).remove();

			  		indicator.css('position', 'absolute').css('top', '0px').css('left', '0px').css('background-color','#000').css('z-index',1001).css('opacity',0.7)
								.width('100%').height(documentHeight);

					$('body').after(indicator.show());
			  	}
			},
			GetByteLenth : function(s, b, i, c){
				for(b=i=0 ; c=s.charCodeAt(i++) ; b+=c>>11?3:c>>7?2:1);
				return b;
			}
		},
		developmentMode : ""
	};

	$.fn.validation = function(options){
		var $this = this
		  , notRequired
		  , isOk = true
		  , tagType
		  , tagTypeValue
		  , tagNameValue
		  , tagName
		  , tagTitle
		  , tagID
		  , message = ""
		  , regResult;

		var regExrs = {
			idExr : "",
			passExr : "",
			emailExr : "",
			numberExr : "",
			mobileExr : "",
			phoneExr : "",
			englishExr : "",
			koreanExr : ""
		};
		var rtnFunc;
		//var version = $.browser.version;

		var msg = {
			empty : {
				text : "",
				password : "",
				passwordChk : "",
				select : "",
				radio : "",
				checkbox : "",
				textarea : ""
			},
			idChk : "",
			passChk : "",
			passEqualChk : "",
			emailChk : "",
			numberChk : "",
			lengthLimitChk : "",
			mobileNumChk : "",
			phoneNumChk : "",
			englishChk : "",
			koreanChk : "",
			confirm : ""
		};

		var func = {
			customFunc : "",
		};

		var settings = jQuery.extend(true, {}, validation.defaults, options);

		notRequired = settings.notRequiredClass;

		regExrs.idExr = settings.validateType.idChk.regExr;
		regExrs.passExr = settings.validateType.passChk.regExr;
		regExrs.emailExr = settings.validateType.emailChk.regExr;
		regExrs.numberExr = settings.validateType.numberChk.regExr;
		regExrs.mobileExr = settings.validateType.mobileNumChk.regExr;
		regExrs.phoneExr = settings.validateType.phoneNumChk.regExr;
		regExrs.englishExr = settings.validateType.englishChk.regExr;
		regExrs.koreanExr = settings.validateType.koreanChk.regExr;

		func.customFunc = settings.customfunc;

		msg.empty.text = settings.msg.empty.text;
		msg.empty.password = settings.msg.empty.password;
		msg.empty.passwordChk = settings.msg.empty.passwordChk;
		msg.empty.checkbox = settings.msg.empty.checkbox;
		msg.empty.radio = settings.msg.empty.radio;
		msg.empty.textarea = settings.msg.empty.textarea;
		msg.empty.select = settings.msg.empty.select;

		msg.idChk = settings.msg.idChk;
		msg.passChk = settings.msg.passChk;
		msg.passEqualChk = settings.msg.passEqualChk;
		msg.emailChk = settings.msg.emailChk;
		msg.numberChk = settings.msg.numberChk;
		msg.lengthLimitChk = settings.msg.lengthLimitChk + "(" + settings.validateType.lengthLimitChk.min + "자리)";
		msg.mobileNumChk = settings.msg.mobileNumChk;
		msg.phoneNumChk = settings.msg.phoneNumChk;
		msg.englishChk = settings.msg.englishChk;
		msg.koreanChk = settings.msg.koreanChk;
		msg.confirm = settings.msg.confirm;

		/*
		* Window 객체에 Feel 객체 선언
		* Feel 객체에는 validation 객체 선언
		* 정규화 문구 축약 명령어 선언
		*/
		Window.prototype.Feel = {
			Validation : validation,
			RegExr : {
				Id : regExrs.idExr,
				Pass : regExrs.passExr,
				Email : regExrs.emailExr,
				Number : regExrs.numberExr,
				Mobile : regExrs.mobileExr,
				Phone : regExrs.phoneExr,
				English : regExrs.englishExr,
				Korean : regExrs.koreanExr
			},
			Msg : {
				Id : msg.idChk,
				Pass : msg.passChk,
				Email : msg.emailChk,
				Number : msg.numberChk,
				Mobile : msg.mobileNumChk,
				Phone : msg.phoneNumChk,
				English : msg.englishChk,
				Korean : msg.koreanChk
			}
		};


		// 경고 메시지를 설정한다.
		var SetMsg = function(obj, className){
			tagType = obj[0].nodeName;
			tagTypeValue = obj.attr('type');
			tagNameValue = obj.attr('name');

			switch (tagType)
			{
				case "INPUT" : 
					if (tagTypeValue == "text" || tagTypeValue == "hidden" || tagTypeValue == "file") message = msg.empty.text; 

					if (tagTypeValue == "password"){
						if (obj.hasClass(settings.validateType.passChk.className)) message = msg.empty.password; 
						if (obj.hasClass(settings.validateType.passChk.subClassName)) message = msg.empty.password; 
						if (obj.hasClass(settings.validateType.passChk.equalClass)) message = msg.empty.passwordChk; 

					}
					if (tagTypeValue == "radio") message = msg.empty.radio; 
					if (tagTypeValue == "checkbox") message = msg.empty.checkbox; 

					break;
				case "SELECT" : message = msg.empty.select; break;
				case "TEXTAREA" : message = msg.empty.textarea; break;
			}

			if (settings.msg.empty.names.hasOwnProperty(tagNameValue)){
				message = settings.msg.empty.names[tagNameValue];
			}
			else
			{
				if (message.indexOf(tagTitle) == -1){
					message = tagTitle + message;
				}
			}
		};

		// 설정된 메시지를 발생시키고 해당 객체로 포커스를 이동시킨다.
		var GenerateMsg = function(obj, msg){

			if(!obj.hasClass(settings.ExceptionRequiredClass) && !settings.tooltip.use){
				alert(msg);	
			}

			if(settings.tooltip.use){
				// jquery ui widget
				obj.tooltip({
					disabled: true				
				}).on("focusin", function () {
					if(obj.val() == "" || isOk){
						obj.tooltip("enable").tooltip("open").tooltip({content : msg});
					}
				}).on("focusout", function () {						 
					obj.tooltip("close").tooltip("disable");
				}).on("keyup", function(e){
					if($.trim($(this).val()) != ""){
						obj.tooltip("close").tooltip("disable");
					}
				});				
			}

			obj.focus();
			isOk = false;			
		};

		// 필수 입력이 아닌 경우 체크
		var NotRequiredCheck = function(obj, single, name){
			var rtnFlag = true;

			if (single){
				rtnFlag = !obj.hasClass(notRequired);

				if (!rtnFlag && obj.val() != "") rtnFlag = true;
			}
			else
			{
				$this.find('input[name='+name+']').each(function(){
					if ($(this).hasClass(notRequired)) rtnFlag = false;
				});
			}

			return rtnFlag;
		};

		// 사용자 정의 함수 실행
		var UserDefineFunc = function(func, obj, tagid, okval, msg){
			if (typeof func == "function"){ 
				//isOk = func(obj, tagid);
				return func(obj, tagid, okval, msg);
			}
		};

		// 패스워드 일치 검사
		var PasswordEqualCheck = function(obj, passChkClass, msg){
			if (obj.val() !=  $this.find('.' + passChkClass).val()){ 
				regResult = false; 
				GenerateMsg(obj, msg); 
			}
		};

		var ConvertPhone = function(){
			$('input').each(function(){
				if ($(this).hasClass(settings.validateType.mobileNumChk.className) || $(this).hasClass(settings.validateType.phoneNumChk.className))
				{
					$(this).keyup(function(event){
						event = event || window.event;
						//var _val = this.value.trim();
						var _val = $.trim(this.value);

						this.value = Feel.Validation.method.AutoHypenPhone(_val);

					});
				}
			});
		}();

		// placeholder
		/*
		if (version == 7.0 || version == 8.0 || version == 9.0){
			var Placeholder = function(){
				if (settings.placeholder == true)
				{
					$('input').each(function(){
						var phval = $(this).attr('placeholder');
						
						if (typeof phval != "undefined")
						{
							$(this).val(phval).css('color', '#bbb')
									.focus(function(){
										if ($(this).val() == phval){
											$(this).val('');
										}
									})
									.focusout(function(){
										if ($(this).val() == ''){
											$(this).val(phval);
										}
									});
						}
					});
				}
			}();
		}*/

		var hasMaxlengthCheck = function(obj){
			if(Feel.Validation.developmentMode == "dev"){
				if(!typeof $(obj).is('[maxlength]') == false){
					GenerateMsg(obj, "최대 입력 길이(maxlength) 설정해주세요.");
				}
			}
		};
				
		// 콤마 기능
		if (settings.comma.use){
			Feel.Validation.method.Comma($('.' + settings.comma.className), 'keyup');
		}

		// 값 또는 태그의 상태에 대한 확인 모음
		var validationType = {
			Empty : function(obj, msg){
				if (NotRequiredCheck(obj, true))
					if ($.trim(obj.val()).length == 0) GenerateMsg(obj, msg);
			},
			Radio : function(obj, msg){					 
				var radio_ok = false;
				tagName = obj.attr('name');
	
				if (NotRequiredCheck(obj, false, tagName)){
					if ($('input[name='+tagName+']:checked').length > 0) radio_ok = true;
					if (!radio_ok) GenerateMsg(obj, msg);
				}
			},
			CheckBox : function(obj, msg){
				var check_ok = false;
				tagName = obj.attr('name');

				if (NotRequiredCheck(obj, false, tagName)){
					if ($('input[name='+tagName+']:checked').length > 0) check_ok = true;
					if (!check_ok) GenerateMsg(obj, msg);
				}
			},
			IdChk : function(obj, regexr, msg){
				Feel.Validation.method.RegExrCheck(obj, regexr, msg, GenerateMsg);
			},
			PassChk : function(obj, regexr, msg){
				if (NotRequiredCheck(obj, true))					
					Feel.Validation.method.RegExrCheck(obj, regexr, msg, GenerateMsg);
			},
			PassEqualChk : function(obj, passChkClass, msg){
				if (NotRequiredCheck(obj, true))
					PasswordEqualCheck(obj, passChkClass, msg);
			},
			LengthLimitChk : function(obj, lengthInfo, msg){
				Feel.Validation.method.LengthCheck(obj, lengthInfo, msg, GenerateMsg);
			},
			CommonChk : function(obj, regexr, msg){
				if(NotRequiredCheck(obj, true)){
					Feel.Validation.method.RegExrCheck(obj, regexr, msg, GenerateMsg);
				}
			}
		};

		$this.submit(function(e){
			window.onbeforeunload = null;

			isOk = true;
			//isOk = false;

			$this.find('input:text, input:hidden, input:password, input:radio, input:checkbox, input:file, select, textarea').each(function(){
				tagType = $(this)[0].nodeName;
				tagTypeValue = "";
				tagTitle = $(this).attr('title');
				tagID = $(this).attr('id');

				if (typeof tagTitle == "undefined") tagTitle = "";

				SetMsg($(this));

				switch (tagType)
				{					
					case "INPUT" : 

						tagTypeValue = $(this).attr('type');

						if (tagTypeValue == "text" || tagTypeValue == "hidden" || tagTypeValue == "password" || tagTypeValue == "file")
						{
							if(tagTypeValue == "text") hasMaxlengthCheck($(this));							
							if(isOk){
								if (tagTypeValue == "text" && $(this).val() == $(this).attr('placeholder')){
									$(this).val('');
									validationType.Empty($(this), message);
								}
								else{
									validationType.Empty($(this), message);
								}


								if (isOk && $(this).hasClass(settings.validateType.idChk.className)) validationType.IdChk($(this), regExrs.idExr, msg.idChk );
								if (tagTypeValue == "password")
								{
									if (isOk && $(this).hasClass(settings.validateType.passChk.className)) validationType.PassChk($(this), regExrs.passExr, msg.passChk );
									if (isOk && $(this).hasClass(settings.validateType.passChk.subClassName)) validationType.PassChk($(this), regExrs.passExr, msg.passChk );
									if (isOk && $(this).hasClass(settings.validateType.passChk.equalClass)) validationType.PassEqualChk($(this), settings.validateType.passChk.className , msg.passEqualChk );
								}
								if (isOk && $(this).hasClass(settings.validateType.emailChk.className)) validationType.CommonChk($(this), regExrs.emailExr, msg.emailChk);
								if (isOk && $(this).hasClass(settings.validateType.numberChk.className)) validationType.CommonChk($(this), regExrs.numberExr, msg.numberChk );
								if (isOk && $(this).hasClass(settings.validateType.mobileNumChk.className)) validationType.CommonChk($(this), regExrs.mobileExr, msg.mobileNumChk );
								if (isOk && $(this).hasClass(settings.validateType.phoneNumChk.className)) validationType.CommonChk($(this), regExrs.phoneExr, msg.phoneNumChk );
								if (isOk && $(this).hasClass(settings.validateType.englishChk.className)) validationType.CommonChk($(this), regExrs.englishExr, msg.englishChk );
								if (isOk && $(this).hasClass(settings.validateType.koreanChk.className)) validationType.CommonChk($(this), regExrs.koreanExr, msg.koreanChk );
								if (isOk && $(this).hasClass(settings.validateType.lengthLimitChk.className)) validationType.LengthLimitChk($(this), settings.validateType.lengthLimitChk, msg.lengthLimitChk );
							}
						}
						else if (tagTypeValue == "radio")
						{
							validationType.Radio($(this), message);							
						}
						else if (tagTypeValue == "checkbox")
						{
							validationType.CheckBox($(this), message);
						}

						break;
					case "SELECT" : 
						tagTypeValue = "select";
						validationType.Empty($(this), message);
						break;
					case "TEXTAREA" : 
						tagTypeValue = "textarea";
						validationType.Empty($(this), message);
						break;					
				}

				if(!$(this).hasClass(settings.ExceptionRequiredClass) && !settings.tooltip.use){
					if (!isOk) return false;
				}

				rtnFunc = UserDefineFunc(func.customFunc, $(this), tagID, isOk, message);
				if (typeof rtnFunc != "undefined")
				{
					isOk = rtnFunc;
					if (!isOk) return false;
				}
			});

			if (!isOk) e.preventDefault();

			if (isOk)
			{
				// 포스트 액션값 셋팅
				if(Feel.Validation.action !== "") $this.attr('action', Feel.Validation.action);

				if(Feel.Validation.confirm !== "") msg.confirm = Feel.Validation.confirm;

				if(msg.confirm != ""){
					if(!confirm(msg.confirm)){
						isOk = false;
						e.preventDefault();
					}
				}

				if (settings.async.use)
				{
					e.preventDefault();
					if (typeof settings.async.func === "function")
					{
						settings.async.func();
					}
				}

				if(isOk) Feel.Validation.method.Indicator($('#wrap'), $('#indi'));
			}

			//e.preventDefault()
		});
	};
})(jQuery);