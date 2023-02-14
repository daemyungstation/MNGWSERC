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

    if (s.match(/CODCmsCtgr.js?/) != null)
	{
        var qsE = s.split("/common/js/mngwserc/co/cod/CODCmsCtgr.js");
				            
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
	jQuery("#" + CategoryInfo.tree)	
		.bind("before.jstree", function (event, data) {
			
		})
		.jstree({ 			
			// List of active plugins
			"plugins" : [ 
				//"themes","json_data","ui","crrm","cookies","dnd","search","types","hotkeys"
				"themes","json_data","ui","crrm","types"
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
					"menuSeq" : CategoryInfo.topNode,
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
				"valid_children" : [ "drive" , "folder" , "cms", "etc" ],
				"types" : {
					// The default type
					"etc" : {
						// I want this type to have no children (so only leaf nodes)
						// In my case - those are files
						"valid_children" :  [ "default", "etc", "folder", "board", "cms", "notfolder"],
						// If we specify an icon for the default type it WILL OVERRIDE the theme icons
						"icon" : {
							"image" : "/egov/js/jstree/etc.png"
						}
					},
					"board" : {
						// I want this type to have no children (so only leaf nodes)
						// In my case - those are files
						"valid_children" : [ "default", "etc", "folder", "board", "cms", "notfolder"],
						// If we specify an icon for the default type it WILL OVERRIDE the theme icons
						"icon" : {
							"image" : "/egov/js/jstree/board.png"
						}
					},
					"cms" : {
						// I want this type to have no children (so only leaf nodes)
						// In my case - those are files
						"valid_children" : [ "default", "etc", "folder", "board", "cms", "notfolder"],
						// If we specify an icon for the default type it WILL OVERRIDE the theme icons
						"icon" : {
							"image" : "/egov/js/jstree/cms.png"
						}
					},
					// The `folder` type
					"folder" : {
						// can have files and other folders inside of it, but NOT `drive` nodes
						"valid_children" : [ "default", "etc", "folder", "board", "cms", "notfolder"],
						"icon" : {
							"image" : "/egov/js/jstree/folder.png"
						}
					},
					"notfolder" : {
						// can have files and other folders inside of it, but NOT `drive` nodes
						"valid_children" : [ "default", "etc", "folder", "board", "cms", "notfolder"],
						"icon" : {
							"image" : "/egov/js/jstree/hold.png"
						}
					},
					// The `drive` nodes 
					"drive" : {
						// can have files and folders inside, but NOT other `drive` nodes
						"valid_children" : [ "default", "folder", "cms"],
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
		});
	});