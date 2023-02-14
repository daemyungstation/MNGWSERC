var sSrc = document.getElementsByTagName("script");

// 기본값 지정
var CategoryInfo = {
	"id" : "1"
	,"topNode" : "1"
	,"select" : "categoryArea"
	,"value" : "0"
	,"required" : false
};

for (var i=0;i < sSrc.length; i++)
{
    var s = sSrc[i].src;
    
	if (s.match(/BMABoardCtgr.js?/) != null)
	{
        var qsE = s.split("/common/js/mngwserc/bm/bma/BMABoardCtgr.js");
        
		var qs = qsE[1].split("?");

        var CategoryInfoSub = CategoryInfo;
	
        if (qs.length > 1)
        {
           var qsVar = qs[1].replace(/\%2C/g, '+').replace(/\%22/g,'"').replace(/\%27/g, "'");
		   qsVar = unescape(qsVar);
           CategoryInfoSub = eval("("+qsVar+")");
        }
	
        if (CategoryInfoSub.id != undefined)
        {
        	CategoryInfo.id = CategoryInfoSub.id;
        }

		if (CategoryInfoSub.topNode != undefined)
		{
			CategoryInfo.topNode = CategoryInfoSub.topNode;
		}

		if (CategoryInfoSub.select != undefined)
		{
			CategoryInfo.select = CategoryInfoSub.select;
		}
		
		if (CategoryInfoSub.value != undefined)
		{
			CategoryInfo.value = CategoryInfoSub.value;
		}

		if (CategoryInfoSub.required != undefined)
		{
			CategoryInfo.required = CategoryInfoSub.required;
		}
    }
}

jQuery(document).ready(function(){
	getCategory(CategoryInfo.id, null);
});

function getCategory(ctgrId, obj) 
{
    if (CategoryInfo.topNode != "") 
    {
        focusCategory(ctgrId, CategoryInfo.topNode);
		createCategory(CategoryInfo.topNode, obj, CategoryInfo.select);		
    }
}

function focusCategory(ctgrId, topNode) 
{
	focusArray = new Array();
	
    if(ctgrId != "" && !isNaN(ctgrId) && topNode != "" && !isNaN(topNode)) 
    {
		jQuery.ajax({
			async : false,
            type : "post",
            url : "/mngwserc/cod/adm/getParntData.ajax",
            dataType : "json",
            data : 
            {
                "menuSeq" : ctgrId
            },
            success : function(r)
            {
            	if (r != null && r.length > 0) 
                {
	            	for(var i = 1; i < r.length; i++)
					{
	            		focusArray.push(r[i].attr.id);
					}
                }
            }
        });
    }
}

function createCategory(topNode, obj, slt)
{
    var curObj;
    
    if(topNode != "" && !isNaN(topNode))
    {
        if(obj == null)
        {
        	jQuery("#"+slt).children("select").remove();
			
			if(CategoryInfo.required)
			{
	            jQuery("#"+slt).append("<select class=\"CATEGORYSELECT\" onchange=\"createCategory(this.value, this, '"+slt+"');\" required=\"구분을 선택해주세요.\"></select>");
			}
			else
			{
	            jQuery("#"+slt).append("<select class=\"CATEGORYSELECT\" onchange=\"createCategory(this.value, this, '"+slt+"');\"></select>");
			}
			
            curObj = jQuery("#"+slt+" select:first");
        } 
        else 
        {
            jQuery(obj).nextAll().remove();
            curObj = jQuery(obj).clone(true);
        }
		
        jQuery.ajax({
            async : false,
            type : "post",
            url : "/mngwserc/cod/adm/getChildData.ajax",
            dataType : "json",
            data : 
            {
                "menuSeq" : topNode
            },
            success : function(r) 
            {
                if (r != null && r.length > 0) 
                {
                	jQuery(obj).css("margin-right", "5px");
                    jQuery(obj).parent().append(curObj);
                    jQuery(curObj).children().remove();
                    
                    if(CategoryInfo.required)
                    {
                    	jQuery(curObj).append("<option value=''>선택</option>");
                    }
                    else
                    {
                    	jQuery(curObj).append("<option value=''>전체</option>");
                    }
                    
                    jQuery.each(r, function(i, entry) 
                    {
                        jQuery(curObj).append("<option value='" + entry["attr"].id + "'>" + entry["data"] + "</option>");
                    });	
                    
                    jQuery(curObj).change(function(i){
				    	jQuery(".CATEGORYSELECT").attr("name", "");
				    	
				    	var curIndex = jQuery(curObj).parent().find(this).index();
				    	
				    	if(!jQuery(this).val())
				    	{
				    		if(curIndex > 0)
				    		{
				    			jQuery(curObj).prev().attr("name", slt);
				    		}
				    		
				    		jQuery(curObj).parent().find("select:gt("+curIndex+")").remove();
				    	}
				    	else
				    	{				    		
				    		jQuery(this).attr("name", slt);
				    	}
				    });
                    
                    var focusId = focusArray.shift();

                    if (typeof(focusId) != "undefined")
				    {
				    	jQuery(curObj).val(focusId).trigger("change");
				    }
				    else
			    	{
				    	jQuery(curObj).trigger("change");
			    	}				   
                }
            }
        });
    }
}