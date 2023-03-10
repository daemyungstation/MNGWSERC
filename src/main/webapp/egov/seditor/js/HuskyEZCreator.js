if(typeof window.nhn=='undefined') window.nhn = {};
if (!nhn.husky) nhn.husky = {};

/**
 * @fileOverview This file contains application creation helper function, which would load up an HTML(Skin) file and then execute a specified create function.
 * @name HuskyEZCreator.js
 */
nhn.husky.EZCreator = new (function(){
	this.nBlockerCount = 0;

	this.createInIFrame = function(htOptions)
	{
		var oAppRef;
		var elPlaceHolder;
		var sSkinURI;
		var fCreator;
		var fOnAppLoad;
		var bUseBlocker;
		var htParams;
		
		if(arguments.length == 1)
		{
			oAppRef = htOptions.oAppRef;
			elPlaceHolder = htOptions.elPlaceHolder;
			sSkinURI = htOptions.sSkinURI;
			fCreator = htOptions.fCreator;
			fOnAppLoad = htOptions.fOnAppLoad;
			bUseBlocker = htOptions.bUseBlocker;
			htParams = htOptions.htParams || null;
		}
		else
		{
			// for backward compatibility only
			oAppRef = arguments[0];
			elPlaceHolder = arguments[1];
			sSkinURI = arguments[2];
			fCreator = arguments[3];
			fOnAppLoad = arguments[4];
			bUseBlocker = arguments[5];
			htParams = arguments[6];
		}

		if(bUseBlocker) 
		{
			nhn.husky.EZCreator.showBlocker();
		}

		var attachEvent = function(elNode, sEvent, fHandler) 
		{ 
			if(elNode.addEventListener)
			{
				elNode.addEventListener(sEvent, fHandler, false);
			}
			else
			{
				elNode.attachEvent("on"+sEvent, fHandler);
			}
		}; 

		if(!elPlaceHolder)
		{
			alert("Placeholder is required!");
			return;
		}

		if(typeof(elPlaceHolder) != "object")
		{
			elPlaceHolder = document.getElementById(elPlaceHolder);
		}

		var elIFrame, nEditorWidth, nEditorHeight;

		try
		{
			elIFrame = document.createElement("<IFRAME frameborder=0 scrolling=no>");
		}
		catch(e)
		{
			elIFrame = document.createElement("IFRAME");
			elIFrame.setAttribute("frameborder", "0");
			elIFrame.setAttribute("scrolling", "no");
		}
		
		elIFrame.style.width = "1px";
		elIFrame.style.height = "1px";
		elPlaceHolder.parentNode.insertBefore(elIFrame, elPlaceHolder.nextSibling);
		
		attachEvent(elIFrame, "load", function(){
			fCreator = elIFrame.contentWindow[fCreator] || elIFrame.contentWindow.createSEditor2;
			
			try
			{
				nEditorWidth = elPlaceHolder.style.width || "500px";
				nEditorHeight = elIFrame.contentWindow.document.body.scrollHeight + 12;
				elIFrame.style.width =  "100%";
				elIFrame.style.height = nEditorHeight+ "px";
				elIFrame.contentWindow.document.body.style.margin = "0";
			}
			catch(e)
			{
				nhn.husky.EZCreator.hideBlocker(true);
				elIFrame.style.border = "5px solid red";
				elIFrame.style.width = "500px";
				elIFrame.style.height = "500px";
				alert("Failed to access "+sSkinURI);
				return;
			}
			
			var oApp = fCreator(elPlaceHolder, htParams);	// oEditor
			
			oApp.elPlaceHolder = elPlaceHolder;

			oAppRef[oAppRef.length] = oApp;
			
			if(!oAppRef.getById) 
			{
				oAppRef.getById = {};
			}
			
			if(elPlaceHolder.id)
			{
				oAppRef.getById[elPlaceHolder.id] = oApp;
			}

			oApp.run({fnOnAppReady:fOnAppLoad}); 
			
			nhn.husky.EZCreator.hideBlocker();
		});

		elIFrame.src = sSkinURI;
	};
	
	this.showBlocker = function()
	{
		if(this.nBlockerCount<1)
		{
			var elBlocker = document.createElement("DIV");
			elBlocker.style.position = "absolute";
			elBlocker.style.top = 0;
			elBlocker.style.left = 0;
			elBlocker.style.backgroundColor = "#FFFFFF";
			elBlocker.style.width = "100%";

			document.body.appendChild(elBlocker);
			
			nhn.husky.EZCreator.elBlocker = elBlocker;
		}

		nhn.husky.EZCreator.elBlocker.style.height = Math.max(document.body.scrollHeight, document.body.clientHeight)+"px";
		
		this.nBlockerCount++;
	};
	
	this.hideBlocker = function(bForce)
	{
		if(!bForce)
		{
			if(--this.nBlockerCount > 0) 
			{
				return;
			}
		}
		
		this.nBlockerCount = 0;
		
		if(nhn.husky.EZCreator.elBlocker) nhn.husky.EZCreator.elBlocker.style.display = "none";
	};
})();