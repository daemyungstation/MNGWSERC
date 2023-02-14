 function windowMasking(maskSelector) {
    var maskHeight = $(document).height(); 
    var maskWidth = $(window).width();   
    $(maskSelector).css({
        'width' : maskWidth,
        'height' : maskHeight
    }); 
    $(maskSelector).fadeTo("slow", 0.5);
}

function openLayerPopup(layerSelector) {
    $('.layer-popup').css("position", "absolute");        
    $('.layer-popup').css("top",(($(window).height() - $('.layerpop').outerHeight()) / 2) + $(window).scrollTop());
    $('.layer-popup').css("left",(($(window).width() - $('.layerpop').outerWidth()) / 2) + $(window).scrollLeft());
    $('.layer-popup').draggable();
    $(layerSelector).show();
}

function closePopup(maskSelector, layerSelector) {
    $(layerSelector).hide();
    $(maskSelector).hide();
}

function openPopup(maskSelector, layerSelector) {

    /*팝업 오픈전 별도의 작업이 있을경우 구현*/ 

	openLayerPopup(layerSelector); //레이어 팝업창 오픈 
    windowMasking(maskSelector); //화면 마스크 효과 
}


