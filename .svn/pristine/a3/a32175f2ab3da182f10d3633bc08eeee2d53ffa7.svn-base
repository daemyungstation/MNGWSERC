var sSrc = document.getElementsByTagName("script");

// 기본값 지정
var CategoryInfo = {
    "d" : "5"
    ,"id" : "1"
	,"topNode" : "1"
	,"tree":"divCategoris"
	,"select":"categoryArea"
	,"uid" : ""
	,"did" : ""
};

for (var i = 0; i < sSrc.length; i++) 
{
    var s = sSrc[i].src;

	if (s.match(/COCAdmRole.js?/) != null) 
	{
        var qsE = s.split("/common/js/mngwserc/co/coc/COCAdmRole.js");
        
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

		if (CategoryInfoSub.uid != undefined)
		{
			CategoryInfo.uid = CategoryInfoSub.uid;
		}
		
		if (CategoryInfoSub.did != undefined)
		{
			CategoryInfo.did = CategoryInfoSub.did;
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
				"themes","json_data","ui","crrm","search","types", "checkbox"
			],
			"themes" : {
				"icons" : false
			},
			// I usually configure the plugin that handles the data first
			// This example uses JSON as it is most common
			"json_data" : { 
				// This tree is ajax enabled - as this is most common, and maybe a bit more complex
				// All the options are almost the same as jQuery's AJAX (read the docs)
				"ajax" : {
					// the URL to fetch the data
					"url" : "/mngwserc/coc/adm/getMenuList.ajax",
					// the `data` function is executed in the instance's scope
					// the parameter is the node being loaded 
					// (may be -1, 0, or undefined when loading the root nodes)
					"menuSeq" : 1,
					"dpth" : 0,
					"admSeq" : CategoryInfo.uid,
					"roleCd" : CategoryInfo.did,
					"data" : function (n) { 
						// the result is fed to the AJAX request `data` option
						return { 
							"menuSeq" : n.attr ? n.attr("id").replace("node_","") : parseInt(CategoryInfo.topNode),
							"dpth" : n.attr ? n.attr("level") : 0,
							"admSeq" : CategoryInfo.uid,
							"roleCd" : CategoryInfo.did,
							"Ran" : Math.random()
						}; 
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
	            "initially_open": ["node_53"]
	        }
		})
		.bind("open_node.jstree", function (event, data) {
			jQuery(this).find("li").each(function(q){
				if(typeof jQuery(this).attr("checkdept") != "undefined")
				{
					jQuery(this).removeClass("jstree-checked");
					jQuery(this).children("a").children(".jstree-checkbox").remove().addClass("jstree-icon");
					jQuery(this).children("a").css("color", "#36912C");
				}	
				
				if(jQuery(this).attr("status") == "N")
				{
					jQuery(this).children("a").css("color", "#FF3366");
				}		
			});
		})	
		.bind("loaded.jstree", function (event, data) {	// after load 
			// all open
			jQuery(this).jstree("open_all");
        });
	});