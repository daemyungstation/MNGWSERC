var sSrc = document.getElementsByTagName("script");

// 기본값 지정
var CategoryInfo = {
    "d" : "5"
    ,"id" : "1"
	,"topNode" : "1"
	,"tree" : "divCategoris"
	,"select" : "categoryArea"
	,"menuGb" : "cms"
};

for (var i = 0; i < sSrc.length; i++)
{
    var s = sSrc[i].src;

	if (s.match(/CODCntnsMenu.js?/) != null) 
	{
        var qsE = s.split("/common/js/mngwserc/co/cod/CODCntnsMenu.js");
				            
        var qs = qsE[1].split("?");

        var CategoryInfoSub = CategoryInfo;
	
        if (qs.length > 1) 
        {
           var qsVar = qs[1].replace(/\%2C/g, '+').replace(/\%22/g,'"').replace(/\%27/g, "'");
		   qsVar = unescape(qsVar);
           CategoryInfoSub = eval("("+qsVar+")");
        }

        if (CategoryInfoSub.d != undefined)
        {
        	 CategoryInfo.d = CategoryInfoSub.d;
        }

        if (CategoryInfoSub.id != undefined)
    	{
        	 CategoryInfo.id = CategoryInfoSub.id;
    	}

		if (CategoryInfoSub.tree != undefined)
		{
			CategoryInfo.tree = CategoryInfoSub.tree;
		}

		if (CategoryInfoSub.topNode != undefined)
		{
			CategoryInfo.topNode = CategoryInfoSub.topNode;
		}

		if (CategoryInfoSub.select != undefined)
		{
			CategoryInfo.select = CategoryInfoSub.select;
		}
		
		if (CategoryInfoSub.menuGb != undefined)
		{
			CategoryInfo.menuGb = CategoryInfoSub.menuGb;
		}
    }
}

jQuery(function () {
	jQuery("#divCategoris")	
		.bind("before.jstree", function (event, data) {
			
		})
		.jstree({ 			
			// List of active plugins
			"plugins" : [ 
				//"themes","json_data","ui","crrm","cookies","dnd","search","types","hotkeys"
				"themes","json_data","ui","crrm","cookies","search","types","hotkeys", "dnd"
			],

			// I usually configure the plugin that handles the data first
			// This example uses JSON as it is most common
			"json_data" : { 
				// This tree is ajax enabled - as this is most common, and maybe a bit more complex
				// All the options are almost the same as jQuery's AJAX (read the docs)
				"ajax" : {
					// the URL to fetch the data
					"url" : "/mngwserc/cod/adm/getJson.ajax",
					// the `data` function is executed in the instance's scope
					// the parameter is the node being loaded 
					// (may be -1, 0, or undefined when loading the root nodes)
					"menuSeq" : "1",
					"data" : function (n) { 
						// the result is fed to the AJAX request `data` option
						return {
							"menuSeq" : n.attr ? n.attr("id").replace("node_","") : parseInt(CategoryInfo.topNode),
						    "Ran" : Math.random()
						}; 
					}
				}
			},
			// Using types - most of the time this is an overkill
			// read the docs carefully to decide whether you need types
			"types" : {
				// I set both options to -2, as I do not need depth and children count checking
				// Those two checks may slow jstree a lot, so use only when needed
				"max_depth" : CategoryInfo.d,
				"max_children" : -2,
				// I want only `drive` nodes to be root nodes 
				// This will prevent moving or creating any other type as a root node
				"valid_children" : [ "drive" , "cms" ],
				"types" : {
					// The default type
					"etc" : {
						// I want this type to have no children (so only leaf nodes)
						// In my case - those are files
						"valid_children" :  [ "etc", "folder", "board", "cms", "notfolder"],
						// If we specify an icon for the default type it WILL OVERRIDE the theme icons
						"icon" : {
							"image" : "/egov/js/jstree/etc.png"
						}
					},
					"board" : {
						// I want this type to have no children (so only leaf nodes)
						// In my case - those are files
						"valid_children" : [ "etc", "folder", "board", "cms", "notfolder", "drive"],
						// If we specify an icon for the default type it WILL OVERRIDE the theme icons
						"icon" : {
							"image" : "/egov/js/jstree/board.png"
						}
					},
					"cms" : {
						// I want this type to have no children (so only leaf nodes)
						// In my case - those are files
						"valid_children" : [ "etc", "folder", "board", "cms", "notfolder"],
						// If we specify an icon for the default type it WILL OVERRIDE the theme icons
						"icon" : {
							"image" : "/egov/js/jstree/cms.png"
						}
					},
					"html" : {
						// I want this type to have no children (so only leaf nodes)
						// In my case - those are files
						"valid_children" : [ "etc", "folder", "board", "html", "notfolder"],
						// If we specify an icon for the default type it WILL OVERRIDE the theme icons
						"icon" : {
							"image" : "/egov/js/jstree/cms.png"
						}
					},
					// The `folder` type
					"folder" : {
						// can have files and other folders inside of it, but NOT `drive` nodes
						"valid_children" : [ "etc", "folder", "board", "cms", "notfolder", "drive"],
						"icon" : {
							"image" : "/egov/js/jstree/folder.png"
						}
					},
					"notfolder" : {
						// can have files and other folders inside of it, but NOT `drive` nodes
						"valid_children" : [ "etc", "folder", "board", "cms", "notfolder"],
						"icon" : {
							"image" : "/egov/js/jstree/hold.png"
						}
					},
					// The `drive` nodes 
					"drive" : {
						// can have files and folders inside, but NOT other `drive` nodes
						"valid_children" : [ "default", "cms"],
						"icon" : {
							"image" : "/egov/js/jstree/root.png"
						},
						// those prevent the functions with the same name to be used on `drive` nodes
						// internally the `before` event is used
						"start_drag" : false,
						"move_node" : false,
						"delete_node" : false,
						"remove" : false
					}
				}
			},
			"ui" : {
		    // this makes the node with ID node_4 selected onload
		    //"initially_select" : [ "node_4" ]
			},
	        // the core plugin - not many options here
	        "core": {
	            // just open those two nodes up
	            // as this is an AJAX enabled tree, both will be downloaded from the server
	            "initially_open": ["node_15"]
	        }
		})
		.bind("open_node.jstree", function (event, data) {	
			jQuery(this).find("li[status='N']").each(function(q){
				jQuery(this).attr("rel", "notfolder");
			});
		})	
		.bind("create.jstree", function (event, data) {			
			//노드 생성		
			var dataRsltParent = data.rslt.parent;
			var dataparentid;
			
			if(dataRsltParent == -1)
			{
				dataparentid = CategoryInfo.topNode;
			}
			else
			{
				dataparentid = data.rslt.parent.attr("id").replace("node_","");
			}
			
			if(confirm("메뉴를 생성하시겠습니까?"))
			{
				jQuery.post("/mngwserc/cod/adm/insertMenu.ajax", 
					{ 
						"parntSeq" : dataparentid, 
						"pstn" : data.rslt.position,
						"menuNm" : data.rslt.name,
						"menuGb" : CategoryInfo.menuGb,
						"userUseYn" : "Y",
						"userWndYn" : "N"
					}, 
					function (r) {					
						var insMenuSeq = r.insMenuSeq;
						
						if(insMenuSeq > 0) 
						{
							jQuery(data.rslt.obj).attr("id", "node_" + insMenuSeq);
						}
					}
				).fail(function () {
					alert("잠시후 다시 시도 바랍니다.");
					jQuery.jstree.rollback(data.rlbk);
				});
			}
			else
			{
				jQuery.jstree.rollback(data.rlbk);
			}
		})		
		.bind("rename.jstree", function (event, data) {
			//노드 이름 변경
			if(confirm("메뉴명을 변경하시겠습니까?"))
			{
				jQuery.post("/mngwserc/cod/adm/updateMenuNm.ajax", 
					{ 
						"menuSeq" : data.rslt.obj.attr("id").replace("node_", ""),
						"menuNm" : data.rslt.new_name
					}, 
					function (r) {
						var updCnt = r.updCnt;
						
						if(updCnt < 1) 
						{
							jQuery.jstree.rollback(data.rlbk);
						}
					}
				).fail(function () {
					alert("잠시후 다시 시도 바랍니다.");
					jQuery.jstree.rollback(data.rlbk);
				});
			}
			else
			{
				jQuery.jstree.rollback(data.rlbk);
			}
		})
		.bind("remove.jstree", function (event, data) {
			if (data.rslt.obj == undefined)
			{
				if(confirm("삭제하시겠습니까?"))
				{
					jQuery.post("/mngwserc/cod/adm/deleteMenu.ajax",
						{ 
							"menuSeq" : jQuery("#divCategoris").jstree("get_selected").attr("id").replace("node_", "")
						}, 
						function (r) {
							var delCnt = r.delCnt;
							
							if(delCnt < 1) 
							{
								jQuery.jstree.rollback(data.rlbk);
							}
						}
					).fail(function () {
						alert("잠시후 다시 시도 바랍니다.");
						jQuery.jstree.rollback(data.rlbk);
					});
				}
				else
				{
					jQuery.jstree.rollback(data.rlbk);
				}
			}
			else
			{
				if(confirm("삭제하시겠습니까?"))
				{
					data.rslt.obj.each(function(){
						jQuery.post("/mngwserc/cod/adm/deleteMenu.ajax",
							{ 
								"menuSeq" : this.id.replace("node_","")
							}, 
							function (r) {
								var delCnt = r.delCnt;
								
								if(delCnt < 1) 
								{
									jQuery.jstree.rollback(data.rlbk);
								}
							}
						).fail(function () {
							alert("잠시후 다시 시도 바랍니다.");
							jQuery.jstree.rollback(data.rlbk);
						});
					});
				}
				else
				{
					jQuery.jstree.rollback(data.rlbk);
				}
			}
		})
		.bind("move_node.jstree", function (e, data) {
			if(confirm("이동 하시겠습니까?"))
			{
				data.rslt.o.each(function (i) {
					jQuery.post("/mngwserc/cod/adm/updateMenuPstn.ajax",
						{
							"menuSeq": jQuery(this).attr("id").replace("node_", ""),
							"refSeq": data.rslt.cr === -1 ? CategoryInfoSub.topNode : data.rslt.np.attr("id").replace("node_", ""),
							"pstn": data.rslt.cp + i,
							"menuNm": data.rslt.name,
							"isCopy": data.rslt.cy ? 1 : 0
						},
						function (r) {
							var moveYn = r.moveYn;
							
							if(moveYn == "Y") 
							{
								/*
								if(data.rslt.cy && jQuery(data.rslt.oc).children("UL").length)
								{
									data.inst.refresh(data.inst._get_parent(data.rslt.oc));
								}

								jQuery.jstree._reference("#divCategoris").refresh();
								*/
							}
						}
					).fail(function () {
						alert("잠시후 다시 시도 바랍니다.");
						jQuery.jstree.rollback(data.rlbk);
					});
				});
			}
			else
			{
				jQuery.jstree.rollback(data.rlbk);
			}
	    })
		.bind("loaded.jstree", function (event, data) {
			
        })
		.bind("select_node.jstree", function (event, data) { 
			var id = data.rslt.obj.attr("id").replace("node_", "");
			var rel = data.rslt.obj.attr("rel"); 
			
			jQuery.get("/mngwserc/cod/adm/selectMenuDtl.ajax",
				{
					"menuSeq": id,
					"menuGb": rel,
					"Ran" : Math.random()
				},
				function (r) {
					var rtnMap = r.rtnMap;
					
					if (rtnMap.menuSeq != null && typeof rtnMap.menuSeq != undefined) 
					{
						jQuery("#spanMenuSeq").text(rtnMap.menuSeq);
					}
					else 
					{
						alert("잠시후 다시 시도 바랍니다.");
						jQuery.jstree.rollback(data.rlbk);
					}
				}
			).fail(function () {
				alert("잠시후 다시 시도 바랍니다.");
				jQuery.jstree.rollback(data.rlbk);
			});	
			
			return false; 
		});
		
		//버튼 제어
		jQuery("#mmenu a").click(function (event) {
			switch(this.id) {
				case "add_root":
					jQuery("#divCategoris").jstree("create", -1, "last", { "attr" : { "rel" : "cms" } }, false, false);					
					break;
				case "add_folder":
					jQuery("#divCategoris").jstree("create", null, "last", { "attr" : { "rel" : "cms" } });
					break;
				case "remove":
					jQuery("#divCategoris").jstree("remove", null, "last", { "attr" : { "rel" : this.id.toString().replace("add_", "") } });
					break;
				case "text": break;
				default:
					jQuery("#divCategoris").jstree(this.id);
					break;
			}
		});
	});