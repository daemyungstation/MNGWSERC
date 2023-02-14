(function(window, document, undefined){
	function Hashtable(){
		this.items = new Array();
		this.itemsCount = 0;

		this.add = function(key, value){
			if(!this.containsKey(key)){
				this.items[key] = value;
				this.itemsCount++;
			}else{
				this.items[key] = value;
			}
		}

		this.get = function(key){
			if(this.containsKey(key)){
				return this.items[key];
			}else{
				return null;
			}
		}

		this.remove = function(key){
			if(this.containsKey(key)){
				delete this.items[key];
				this.itemsCount--;
			}else{
				throw "key '" + key + "' dose not exists";
			}
		}

		this.containsKey = function(key){
			return typeof(this.items[key]) != "undefined";
		}

		this.containsValue = function containsValue(value){
			for(var item in this.items){
				if(this.items[item] == value){
					return true;
				}
			}
			return false;
		}

		this.contains = function(keyOrValue){
			return this.containsKey(keyOrValue) || this.containsValue(keyOrValue);
		}

		this.clear = function(){
			this.items = new Array();
			itemsCount = 0;
		}

		this.size = function(){
			return this.itemsCount;
		}

		this.isEmpty = function(){
			return this.size() === 0;
		}
	};

	// Recursion method
	function GetSearchObject(obj, key){
		var result = null;

		if(typeof obj === 'object'){
			for(k in obj){
				if(k != '$obj'){
					if(k == key){
						return obj[k];
					}

					if(typeof obj[k] === 'object'){
						result = GetSearchObject(obj[k], key);

						if(result){
							break;
						}
					}
				}
			}
		}

		return result;
	};

	// set controller objects
	function SetController(cn){
		$('div').each(function(){
			var $this = $(this)
			  , conValue = $this.data('controller');

			if(typeof conValue != 'undefined' && conValue != ''){

				if(typeof cn == "undefined"){
					controllerHashTable.add(conValue, $this);
				}else{
					if(conValue == cn){				
						controllerHashTable.add(conValue, $this);
					}
				}
			}
		});
	};

	
	function GetIds(parentTag, tagType){
		var idvalue = "", arr = [];

		for(type in tagType){
			parentTag.find(tagType[type]).each(function(i, v){
				idvalue = $(this).attr('id');
				if(idvalue !== undefined && idvalue != ""){
					arr.push(idvalue);
				//}else{
				//	alert(idvalue + '[id overrap!!]');
				}
			});
		}

		return arr;
	};

	function GetClass(parentTag, tagType){
		var classvalue = "", arr = [];

		for(type in tagType){
			parentTag.find(tagType[type]).each(function(i, v){
				classvalue = $(this).attr('class');
				if(classvalue !== undefined){
					if($.inArray(classvalue, arr) === -1){
						arr.push(classvalue);
					}
				}
			});
		}

		return arr;
	};

	function ArrayToJson(array){
		var jsonString = "{";
		for(arr in array){
			jsonString = jsonString + '"' + array[arr] + '"' + ':' + '{}';
			if(arr < array.length - 1) jsonString = jsonString + ',';
		}
		jsonString = jsonString + "}";

		return $.parseJSON(jsonString);
	};



	var feel = window.feel || (window.feel = {})
	  , controllerHashTable = new Hashtable();

	feel.controller = function(controllerName, mode){
		this.obj = {};
		this.model = {};

		var controllerVal = {
			obj : {},
			alias : 'view',
			viewdata : ''
		};

		var modelVal = {
			targetObj : {},
			attrObj : {},
			eventObj : {},
			viewObj : {},
			viewTargetString : "",
			arrTrigger : []
		};

		var defaultObj = {
			id : {},
			className : {}
		};

		var defaultTagObj = {
			$obj : {},
			isShow : true,
			show : function(e){
				this.isShow = true;
				this.$obj.show();
			},
			hide : function(e){
				this.isShow = false;
				this.$obj.val('').hide();
			},
			ShowHide : function(){
				this.isShow ? this.hide() : this.show();
			}
		};

		var targetChar = ""
		  , arrId = []
		  , arrClass = [];


		// get controller
		controllerVal.obj = controllerHashTable.get(controllerName);

		if (controllerVal.obj == null)
		{
			//alert("controller null!!");			
			this.exec = function(){
				return;
			};
			return;
		}

		this.obj = controllerVal.obj;

		// get alias
		if(typeof controllerVal.obj.data('alias') != 'undefined' && controllerVal.obj.data('alias') != ''){
			controllerVal.alias = controllerVal.obj.data('alias');
		}

		// get viewdata
		if(typeof controllerVal.obj.data('viewdata') != 'undefined' && controllerVal.obj.data('viewdata') != ''){
			controllerVal.viewdata = controllerVal.obj.data('viewdata');

			$.ajax({
				async : false,
				url : controllerVal.viewdata,
				dataType : 'json',
				success : function(jdata){
					model = jdata;
				}
			});
		}

		// get ids
		arrId = GetIds(controllerVal.obj, ['form', 'input', 'div', 'p', 'span', 'textarea', 'ul', 'checkbox']);
		//arrClass = GetClass(controllerVal.obj, ['input', 'div', 'p', 'span', 'textarea']);	'class가 여러개 있을 때 오류 발생'

		defaultObj.id = $.extend(true, {}, defaultObj.id, ArrayToJson(arrId));
		defaultObj.className = $.extend(true, {}, defaultObj.className, ArrayToJson(arrClass));

		this.exec = function(){
			// model extend
			this.model = $.extend(true, {}, this.model, defaultObj);

			// model projection logic
			for(key in this.model){
				switch(key.toLowerCase()){
					case 'id' :
					case 'className' :
						targetChar = key == 'id' ? "#" : ".";

						modelVal.targetObj = this.model[key];

						for(target in modelVal.targetObj){
							modelVal.attrObj = modelVal.targetObj[target];

							// add default attribute
							defaultTagObj.$obj = controllerVal.obj.find(targetChar + target);
							modelVal.attrObj = $.extend(true, {}, defaultTagObj, modelVal.attrObj);

							eval('defaultObj.' + key + '.' + target + ' = modelVal.attrObj');

							for(attr in modelVal.attrObj){

								if(attr === "event"){
									modelVal.eventObj = modelVal.attrObj[attr];

									for(e in modelVal.eventObj){
										if(typeof modelVal.eventObj[e] === "function"){
											defaultTagObj.$obj.bind(e, {}, modelVal.eventObj[e]);	
										}

										modelVal.arrTrigger = modelVal.attrObj['trigger'];

										if(typeof modelVal.arrTrigger != 'undefined' && modelVal.arrTrigger != ''){
											this.test = modelVal.arrTrigger;
											//for(trigger in modelVal.arrTrigger){
											//	defaultTagObj.$obj.trigger(modelVal.arrTrigger[trigger]);
											//}
										}
									}
								}
							}
						}
						break;
					case controllerVal.alias :
						AliasTest(controllerVal, this.model[controllerVal.alias]);
						break;
				}
			};

			for(key in this.model){
				switch(key.toLowerCase()){
					case 'immediately' : 
						if(typeof this.model[key]() === "function"){
							this.model[key]();
						}
						break;
					
				}
			};
		}

		// get define object by key name
		this.get = function(key){
			var rtn = GetSearchObject(defaultObj, key);
			
			if(rtn == null){
				return;
			}else{
				return rtn;
			}
		};

		// get jquery object key name
		this.getjq = function(key){			
			var o = GetSearchObject(defaultObj, key);

			if(typeof o === "object"){
				if(o.hasOwnProperty('$obj')){
					return o.$obj;
				}
			}

			return o;
		};


		function AliasTest(cv, vm){
			var ts = "";
			for(v in vm){
				ts = cv.alias + '.' + v;

				cv.obj.html(function(i, h){
					return h.replace(ts, vm[v]);
				});
			};
		}

		if(mode == "dev"){
			controllerVal.obj.css('position', 'relative')
							.css('border', '1px dashed red')
							.append('<span class="controllerLabel">' + controllerName + '</span>')
						    .find('.controllerLabel')
								.css('position','absolute').css('top',0).css('right',0)
								.css('background','#000').css('color','#fff');
		}


	};

	var init = function(){
		$(document).ready(function(){			
			SetController();
		});
	}();

})(window, document);