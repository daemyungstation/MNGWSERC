var sSrc = document.getElementsByTagName("script");

// 기본값 지정
var CategoryInfo = {
    "d" : "5"
    ,"id" : "1"
	,"topNode" : "1"
	,"tree" : "divCategoris"
	,"select" : "categoryArea"
	,"menuGb" : "folder"
};

for (var i = 0; i < sSrc.length; i++) 
{
    var s = sSrc[i].src;

	if (s.match(/CODAdmMenu.js?/) != null) 
	{
        var qsE = s.split("/common/js/mngwserc/co/cod/CODAdmMenu.js");
				            
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

jQuery(function(){
	jQuery("#divCategoris")	
		.bind("before.jstree", function (event, data) {
			
		})
		.jstree({ 
			// List of active plugins
			"plugins" : [ 
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
				"valid_children" : [ "drive" , "folder" ],
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
						"valid_children" : [ "etc", "folder", "board", "cms", "notfolder"],
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
						"valid_children" : [ "etc", "folder", "board", "cms", "notfolder"],
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
						"valid_children" : [ "default", "folder"],
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
				dataparentid = data.rslt.parent.attr("id").replace("node_", "");
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
				).fail(function(){
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
				).fail(function(){
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
					).fail(function(){
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
						).fail(function(){
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
		.bind("move_node.jstree", function (event, data) {
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
					).fail(function(){
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
			jQuery(this).find("#node_21").remove();
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
						jQuery("#menuSeq").val(rtnMap.menuSeq);
						   
						if(rel != "drive")
						{
							jQuery("#userWndYn").val(rtnMap.userWndYn);
							jQuery("#userUseYn").val(rtnMap.userUseYn);
							jQuery("#userLink").val(rtnMap.userLink);
							jQuery("#admLink").val(rtnMap.admLink);
							jQuery("#seo").val(rtnMap.seo);
							jQuery("#kwrd").val(rtnMap.kwrd);	
							jQuery("#refSeq").val(rtnMap.refSeq);
							
							if(rtnMap.refSeq != null && rtnMap.refNm != null)
							{
								jQuery("#refNm").text(rtnMap.refNm);
							}
							else
							{
								jQuery("#refNm").text("");
							}
							
							jQuery("input:radio[name='menuGb']").prop("checked", false);
							jQuery("input:radio[name='menuGb']:radio[value='"+rtnMap.menuGb+"']").click();
						   
							var menuGb = jQuery("input:radio[name='menuGb']:checked").val();
						   
							if(menuGb == "board" || menuGb == "cms")
							{
								var userLink = jQuery("#userLink").val();		
								
								if(menuGb == "board")
								{
									userLink = userLink.replace("/communityid/" + jQuery("#refSeq").val() + "/list.do", "");
								}
								else
								{
									userLink = userLink.replace("/contentsid/" + jQuery("#refSeq").val() + "/index.do", "");
								}	
								
								jQuery("#userLink").val(userLink);	
							}
						}
					}
					else 
					{
						alert("잠시후 다시 시도 바랍니다.");
						jQuery.jstree.rollback(data.rlbk);
					}
				}
			).fail(function(){
				alert("잠시후 다시 시도 바랍니다.");
				jQuery.jstree.rollback(data.rlbk);
			});				
			
			return false; 
		});
		
		//버튼 제어
		jQuery("#mmenu a").click(function(event){
			switch(this.id) 
			{
				case "add_root":
					jQuery("#divCategoris").jstree("create", -1, "last", { "attr" : { "rel" : "folder" } }, false, false);				
					break;
				case "add_folder":
					jQuery("#divCategoris").jstree("create", null, "last", { "attr" : { "rel" : "folder" } });
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

//형태를 클릭했을때 화면이 바뀌어야 한다.
jQuery(document).ready(function(){
	jQuery("input[name='menuGb']").change(function(){
		var menuGb = jQuery("input:radio[name='menuGb']:checked").val();
		
		if(menuGb == "board" || menuGb == "cms")
		{
			jQuery("#contentstype").show();
			jQuery("#urlLastNm").show();
			
			if(menuGb == "board")
			{
				jQuery("#urlLastNm").text("/communityid/" + jQuery("#refSeq").val() + "/list.do");
			}
			else
			{
				jQuery("#urlLastNm").text("/contentsid/" + jQuery("#refSeq").val() + "/index.do");
			}			
		}
		else
		{
			jQuery("#contentstype").hide();
			jQuery("#urlLastNm").hide();
		}
	});
});

function updateMenuInf()
{
	var frm = document.menuFrm;	
	
	if(!validate(frm))
	{
		return;
	}
	
	var id = jQuery("#menuSeq").val();
	
	if(!id)
	{
		alert("선택된 카테고리가 없습니다.");
		return;
	}
	else
	{
		jQuery("#userLink").val(jQuery.trim(jQuery("#userLink").val()));
		
		var menuGb = jQuery("input:radio[name='menuGb']:checked").val();
		var userLink = jQuery("#userLink").val();
		var refSeq = jQuery("#refSeq").val();
		
		if(menuGb == "board" || menuGb == "cms")
		{						
			if(userLink.indexOf(".") > 0)
			{
				alert("게시판 또는 CMS에는 URL이 확장자가 아닌 폴더구조로 들어갑니다.");
				jQuery("#userLink").focus();
				return;
			}
			
			if(userLink.indexOf("bbs") > 0)
			{
				alert("게시판 또는 CMS에는 URL에는 'bbs'가 들어갈 수 없습니다.");
				jQuery("#userLink").focus();
				return;
			}
		}
		
		//게시판일경우 게시판을 선택하지 않으면 적용 버튼의 기능이 작동하지 않는다.
		//URL이 없어도 넘겨야 한다.
		if(menuGb == "board" || menuGb == "cms")
		{
			if(!refSeq)
			{
				alert("* 게시판을 선택해 주세요.");
				return;
			}
		}
		
		var admLink = "";
		
		if(confirm("적용하시겠습니까?"))
		{
			if(userLink != "" && typeof userLink != undefined)
			{
				if(userLink.indexOf("http") == -1)
				{
					if(userLink.substr(0, 1) != "/")				
					{
						jQuery("#userLink").val("/" + jQuery("#userLink").val());
					}		
					
					if(userLink.substr(userLink.length - 1, 1) != "/" && userLink.indexOf(".") == -1)
					{
						jQuery("#userLink").val(jQuery("#userLink").val() + "/");
					}
				}
				
				if(userLink.indexOf("/mngwserc") == -1)
				{
					if(menuGb == "board")
					{
						admLink = "/mngwserc" + jQuery("#userLink").val() + "communityid/" + refSeq + "/list.do";
					}
					else if(menuGb == "cms")
					{
						admLink = "/mngwserc" + jQuery("#userLink").val() + "contentsid/" + refSeq + "/index.do";
					}
					else
					{
						admLink = "/mngwserc" + jQuery("#userLink").val();
					}
				}
				else
				{
					admLink = jQuery("#userLink").val();
				}
			}
			else
			{
				if(menuGb == "board")
				{
					admLink = "/mngwserc/communityid/" + refSeq + "/list.do";
				}
				else if(menuGb == "cms")
				{
					admLink = "/mngwserc/contentsid/" + refSeq + "/index.do";
				}
			}
			
			jQuery.post("/mngwserc/cod/adm/updateMenuInf.ajax",
				{
					"menuSeq": id,
					"menuGb": CategoryInfo.menuGb,
					"userUseYn": "Y",
					"userWndYn" : "N",
					"userLink": userLink,
					"admLink" : admLink,
					"seo": jQuery("#seo").val(),
					"kwrd" : jQuery("#kwrd").val(),
					"refSeq" : refSeq
				},
				function (r) {
					var status = r.status;
					
					if(status == "Y") 
					{
						window.location.reload(true);
					}
				}
			).fail(function(){
				alert("잠시후 다시 시도 바랍니다.");
			});
		}
	}
}

//콘텐츠 선택을 눌렀을때
function getCategory()
{
	var menuGb = jQuery("input:radio[name='menuGb']:checked").val();
	var tUrl = "";
	
	if(menuGb == "cms")
	{
		//CMS경로
		tUrl = "/mngwserc/cod/cntns/selectCategory.ajax";
	}
	else if(menuGb == "board")
	{
		//게시판 리스트 경로
		tUrl = "/mngwserc/coh/list.ajax";
	}
	
	jQuery("#myModal").modal("show");
	
	jQuery.get(tUrl,
		{
            "topNode": 21, 
            "menuGb" : menuGb,
            "treeContainer" : "divContentsCategory"
        },
		function(text) {
        	jQuery("#divContentsCategory").removeClass("jstree jstree-1 jstree-focused jstree-default");
			jQuery("#divContentsCategory").html("");
			jQuery("#divContentsCategory").html(text);
		},
		"text"
	).fail(function(){
		alert("잠시후 다시 시도 바랍니다.");
	});
}

function setCategory()
{
	var menuGb = jQuery("input:radio[name='menuGb']:checked").val();
	
	if(menuGb == "cms")
	{
		//CMS경로
		setCmsCategory();
	}
	else if(menuGb == "board")
	{
		//게시판 리스트 경로
		setBoardCategory();
	}		
}

//CMS선택시
function setCmsCategory()
{
	var obj = jQuery("#divContentsCategory").jstree("get_selected").attr("id").replace("node_","");
	
	if(isNaN(obj))
	{
		alert("카테고리를 선택해주세요.");
	}
	else
	{
		if(confirm("해당 카테고리를 선택하시겠습니까?"))
		{
			jQuery("input[name='refSeq']").val(obj);
			jQuery("#refNm").text(jQuery("#divContentsCategory").jstree("get_selected").text());
			jQuery("#urlLastNm").text("communityid/" + jQuery("#refSeq").val() + "/index.do");
			jQuery("#myModal").modal("hide");
		}
	}
}

//게시판 선택시
function setBoardCategory()
{
	var obj = jQuery("input:radio[name='boardcheck']:checked").val();		
	
	if(isNaN(obj))
	{
		alert("카테고리를 선택해주세요.");
	}
	else
	{
		if(confirm("해당 카테고리를 선택하시겠습니까?"))
		{
			jQuery("input[name='refSeq']").val(obj);
			jQuery("#refNm").text(jQuery("#divContentsCategory").find("#tr" + obj).find(".refNm").text());
			jQuery("#urlLastNm").text("communityid/" + jQuery("#refSeq").val() + "/list.do");
			jQuery("#myModal").modal("hide");
		}
	}
}	