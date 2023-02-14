/*
 * Style File - jQuery plugin for styling file input elements
 *  
 * Copyright (c) 2007-2008 Mika Tuupola
 *
 * Licensed under the MIT license:
 *   http://www.opensource.org/licenses/mit-license.php
 *
 * Based on work by Shaun Inman
 *   http://www.shauninman.com/archive/2007/09/10/styling_file_inputs_with_css_and_the_dom
 *
 * Revision: $Id: jquery.filestyle.js 303 2008-01-30 13:53:24Z tuupola $
 *
 */

(function($) {
    
    $.fn.filestyle = function(options) {
                
        /* TODO: This should not override CSS. */
        var settings = {
            width : 50
        };
                
        if(options) {
            $.extend(settings, options);
        };
                        
        return this.each(function() {
            
            var self = this;
            var wrapper = $("<div>").css(
            		{
                        "width": settings.imagewidth + "px",
                        "height": settings.imageheight + "px",
                        "background": "url(" + settings.image + ") 0 0 no-repeat",
                        "display": "inline",
                        "background-position-y" : "1px",
                        "position": "absolute",
                        "overflow": "hidden",
						"margin-left":"5px"
                    });
                            
            var filename = $('<input type="text" disabled="disabled" />').css(
            		{
            			"display": "inline",
                        "width": settings.width + "%"
            		});

            $(self).before(filename);
            $(self).wrap(wrapper);

            $(self).css(
            		{
            			"position": "relative",
                        "height": settings.imageheight + "px",
                        "width": (settings.imagewidth * 2) + "px",
                        "display": "inline",
                        "cursor": "pointer",
                        "opacity": "0.0",
                        "margin-left" : - (settings.imagewidth) + "px"
                    });
            /*
            if ($.browser.mozilla) {
                if (/Win/.test(navigator.platform)) 
                {
                    $(self).css("margin-left", "-142px");                    
                } 
                else
                {
                    $(self).css("margin-left", "-168px");                    
                };
            } else {
                $(self).css("margin-left", settings.imagewidth - settings.width + "px");                
            };
			*/
            
            $(self).bind("change", function() {
                filename.val($(self).val());
            });
        });
    };
})(jQuery);
