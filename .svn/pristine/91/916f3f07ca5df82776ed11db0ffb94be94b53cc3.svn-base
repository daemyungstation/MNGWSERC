<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/include/el.jspf"%>

<!doctype html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="대명아임레디"/>

	<title>대명아임레디</title>

	<script type='text/javascript' src='https://www.daemyungimready.com/common/js/jquery-1.8.2.min.js'></script>
	<script type='text/javascript' src='https://www.daemyungimready.com/common/js/TweenMax.js'></script>
	<script type='text/javascript' src='https://www.daemyungimready.com/common/js/common.js'></script>
	<script type='text/javascript' src='https://www.daemyungimready.com/common/js/fnc.js'></script>
	<link rel='stylesheet' type='text/css' href='https://www.daemyungimready.com/common/css/lifeway_style.css' />

	<script type='text/javascript' src='https://www.daemyungimready.com/common/js/swiper.min.js'></script>
	<link rel='stylesheet' type='text/css' href='https://www.daemyungimready.com/common/css/swiper.min.css' />

	<script>
	var oneNum = -1, twoNum = -1, thrNum = -1, fouNum = -1;
	</script>
	
	<style>
	@font-face{
		font-family:"NanumSquareB";
		src:url('/common/css/fonts/NanumSquareB.eot');
		src:url('/common/css/fonts/NanumSquareB.eot?#iefix') format('embedded-opentype'),
		url('/common/css/fonts/NanumSquareB.woff') format('woff'),
		url('/common/css/fonts/NanumSquareB.ttf') format('truetype');
		src:local('?'), url('/common/css/fonts/NanumSquareB.woff') format('woff');
	}
	
	@font-face{
		font-family:"NanumSquareR";
		src:url('/common/css/fonts/NanumSquareR.eot');
		src:url('/common/css/fonts/NanumSquareR.eot?#iefix') format('embedded-opentype'),
		url('/common/css/fonts/NanumSquareR.woff') format('woff'),
		url('/common/css/fonts/NanumSquareR.ttf') format('truetype');
		src:local('?'), url('/common/css/fonts/NanumSquareR.woff') format('woff');
	}
	
	@font-face{
		font-family:"NanumSquareEB";
		src:url('/common/css/fonts/NanumSquareEB.eot');
		src:url('/common/css/fonts/NanumSquareEB.eot?#iefix') format('embedded-opentype'),
		url('/common/css/fonts/NanumSquareEB.woff') format('woff'),
		url('/common/css/fonts/NanumSquareEB.ttf') format('truetype');
		src:local('?'), url('/common/css/fonts/NanumSquareEB.woff') format('woff');
	}
	
	/* 푸터 - 메인 : STR */
	#footer_main { position:fixed; width:100%; bottom:-175px; left:0; text-align:center; background:#283066; z-index:999;}
	#footer_main .footerDiv{position:relative; width:100%; height:55px; overflow:hidden; margin:auto; color:#fff; text-align:left}
	#footer_main .footerDiv .noti{position:relative; width:50%; height:55px; overflow:hidden; float:left; border-right:1px solid #535985; padding-left:9%; box-sizing:border-box; }
	#footer_main .footerDiv .noti .tit { position:relative; width:75px; height:55px; padding:20px 0 0 30px; box-sizing:border-box; float:left; font-family:'NanumSquareB', dotum,sans-serif; background:url('/common/images/main/main_noti_icon.png') no-repeat 0 16px;}
	#footer_main .footerDiv .noti .tit::after { position:absolute; content:''; top:20px; right:0; width:1px; height:15px; background:#fff; }
	#footer_main .footerDiv .noti .nList{position:relative; width:calc(100% - 200px) ; height:55px; overflow:hidden; margin-left:29px; float:left; }
	#footer_main .footerDiv .noti .nList a{position:absolute; top:20px; left:0; width:100%; height:15px; padding:20px 0; display:block; color:#fff}
	#footer_main .footerDiv .noti .nList a .date{position:absolute; top:0; right:0; height:15px; padding:20px 0; display:block; color:#fff; font-size:13px;}
	#footer_main .footerDiv .noti .bts{width:70px; height:55px; overflow:hidden; float:right;}
	#footer_main .footerDiv .noti .bts a{display:block; text-align:center; height:6px;}
	#footer_main .footerDiv .noti .bts a.up{padding:15px 0 5px}
	#footer_main .footerDiv .noti .bts a.down{padding:5px 0 15px}
	#footer_main .footerDiv .contact { position:relative; width:50%; height:55px; box-sizing:border-box; overflow:hidden; float:left; font-size:15px; padding-left: 5%; text-align:left; }
	#footer_main .footerDiv .open{position:absolute; top:0; right:0; width:55px; height:55px; overflow:hidden; float:left;}
	#footer_main .footerDiv .open img{width:55px; height:55px;}
	#footer_main .footerDiv .open img.on{position:absolute; top:0; left:0; opacity:0}
	#footer_main .footerDiv .contact span{margin:0 6px; color:#ffffff; float:none; width:auto; line-height:55px; }
	#footer_main .footerDiv .contact .contact1 { width:auto; float:none; display:inline-block; line-height:55px; background:url('/common/images/main/contact_icon.png') no-repeat 18px 12px; padding-left:60px; box-sizing:border-box;}
	#footer_main .footerDiv .contact .contact2 { width:auto; float:none; display:inline-block; line-height:55px; }
	/* 푸터 - 메인 : END */
	
	.clear { clear:both; }
	#main-wraper { position:relative; width:100%; }

	/* 컨텐츠 영역 왼쪽 : STR */
	#contents_left { position:fixed; display:block; float:none; width:50%; top:102px; left:0; height: calc(100vh - 156px); }
	#contents_left .swiper { width:100%; height:100%; }
	#contents_left .left-visual { position:relative; width:100%; height:100%; cursor:pointer; }
	#contents_left .left-visual .left-visual-title { position: relative; z-index:2; }
	#contents_left .left-visual .left-visual-title img { position: relative; }
	#contents_left .left-visual .left-visual-content { position: relative; font-size:21px; font-family:'NanumSquareR', dotum,asans-serif;  color:#282828; line-height:160%; font-weight:600; word-break:keep-all; z-index:2; }
	#contents_left .left-visual .left-visual-content small { font-size:0.8em; display:block; line-height:120%; }
	#contents_left .left-visual .left-visual-btn { position: absolute; z-index:2; }
	#contents_left .left-visual .left-visual-img { position: absolute;  z-index:1; top:0; left:0; }
	
	#contents_left .btn_prev { position:absolute; display:none; top:50%; left:0; margin-top:-33px; z-index:1; text-align:left; }
	#contents_left .btn_next { position:absolute; display:none; top:50%; right:0; margin-top:-33px; z-index:1; text-align:right; }
	#contents_left .swiper-pagination { position: absolute; left: 50%; bottom:20px;-webkit-transform: translateX( -50%);-ms-transform: translateX( -50%);transform: translateX( -50%); z-index: 1;}
	#contents_left .swiper-pagination .swiper-pagination-bullet {position: relative;display: inline-block; width:14px; height:14px; background:#fff; border-radius: 50%; margin-left:7px; opacity:.7;}
	#contents_left .swiper-pagination .swiper-pagination-bullet:first-child {margin-left: 0;}
	#contents_left .swiper-pagination .swiper-pagination-bullet-active { opacity:1; width:45px; border-radius:14px; }
	/* 컨텐츠 영역 왼쪽 : END */
	
	/* 컨텐츠 영역 오른쪽 : STR */
	#contents_right { position:relative; float:none; width:50%; top:0; left:50%; height:auto; overflow:auto; padding-top:102px; padding-bottom:55px; box-sizing:border-box;}
	#contents_right .right-container { width:100%; }
	#contents_right .right-container .right-inner { width:100%; height:100%; background:url('/common/images/main/right_bg.jpg') center top repeat-y; }
	#contents_right .right-section { position:relative; padding-top:35px; box-sizing:border-box; }
	#contents_right .right-section:last-child { padding-bottom: 50px; }
	#contents_right .right-section .right-section-title { position:relative; padding-top:25px; box-sizing:border-box; font-size:28px; font-family:'NanumSquareR', dotum,asans-serif;  color:#505050; letter-spacing:-1px; text-align:center; }
	#contents_right .right-section .right-section-title span { font-family:'NanumSquareEB', dotum,asans-serif; font-size:34px; font-weight:800; }
	#contents_right .right-section .right-section-title .top-bar { position:absolute; top:0px; left:50%; margin-left:-25px; width:50px; height:2px; }
	#contents_right .right-section .right-section-title .top-bar.r01 { background:#62c0d9; }
	#contents_right .right-section .right-section-title .top-bar.r02 { background:#f38ca6; }
	#contents_right .right-section .right-section-title .top-bar.r03 { background:#ffcd72; }
	
	#contents_right .right-section .right-section-contents { position:relative; width:90%; margin:35px auto 0 auto; }
	#contents_right .right-section .right-section-contents a { color:#505050; }
	#contents_right .right-section .right-section-contents .right-section-content { float:left; margin-left:2%; width:49%; }
	#contents_right .right-section .right-section-contents .right-section-content:first-child { margin-left: 0; }
	#contents_right .right-section .right-section-contents .right-section-content .right-section-content-img { width:100%; }
	#contents_right .right-section .right-section-contents .right-section-content .right-section-content-img img { width:100%; }
	#contents_right .right-section .right-section-contents .right-section-content .right-section-content-title { margin-top:20px; font-family:'NanumSquareEB', dotum,asans-serif; font-size:18px; }
	#contents_right .right-section .right-section-contents .right-section-content .right-section-content-msg { margin-top:10px; font-family:'NanumSquareB', dotum,asans-serif; font-size:15px; line-height:140%; word-break:keep-all;}

	body { width:100%; height:auto; overflow: auto;}
	#header { position:fixed; top:0; }
	#wrapper.main{ height:auto; overflow: hidden; }
	#footer { position:relative !important; text-align:left; }
	/* 컨텐츠 영역 오른쪽 : END */

	@media all and (max-width:1919px) {
		#contents_left .left-visual .left-visual-content { font-size: 1.3rem; }
		#contents_left .btn_prev img{ width:80%; }
		#contents_left .btn_next img{ width:80%; }
	}
	@media all and (max-width:1400px) {
		#contents_left .left-visual .left-visual-content { font-size: 1.2rem; }
	}
	@media all and (max-width:1200px) {
		#contents_left .left-visual .left-visual-content { font-size: 1.1rem; }
	}
	@media all and (max-width:980px) {
		body { position:relative; width:100%; height:auto; max-width:100%; margin:0 auto; overflow:auto; }
		#header { position:relative; }

		#footer_main { bottom:auto; position:relative !important; }
		#footer_main .footerDiv { width:100%; height:70px; overflow:auto; }
		#footer_main .footerDiv .noti { display:none; }
		#footer_main .footerDiv .contact { width:100%; height:70px; padding:0; overflow:auto; font-size:0.8rem; text-align:center; }
		#footer_main .footerDiv .contact span { margin:0; float:left; width:1px; line-height:70px; }
		#footer_main .footerDiv .contact .contact1 { width:calc(50% - 1px); float:left; line-height:70px; background:none; padding:0; }
		#footer_main .footerDiv .contact .contact2 { width: calc(50% - 1px); float:left; line-height:70px; }
	
		#contents_left { position:relative; display:block; float:none; width:100%; height:660px; top:0; }
		#contents_left .left-visual .left-visual-content { font-size: 1.3rem; }
		#contents_left .btn_prev { display:none; }
		#contents_left .btn_next { display:none; }
			
		#contents_right { float:none; width:100%; height:auto; overflow:auto; left: 0; padding:0; }
		#contents_right .right-container .right-inner { background:url('/common/images/main/m_right_bg.jpg') center top repeat-y; background-size:100% auto;}
		#contents_right .right-section .right-section-title { font-size:1.3rem; }
		#contents_right .right-section .right-section-title span { font-size:1.5rem; }
		#contents_right .right-section .right-section-contents { position:relative; width:80%; margin:0 auto 0 auto; }
		#contents_right .right-section .right-section-contents .right-section-content { float:none; margin:35px auto 0 auto; width:100%; }
		#contents_right .right-section .right-section-contents .right-section-content .right-section-content-title { margin-top:10px; font-size:1.1rem; letter-spacing:-1px; }
		#contents_right .right-section .right-section-contents .right-section-content .right-section-content-msg { margin-top:5px; font-size:1.0rem; letter-spacing:-1px;}
	}
	@media all and (max-width:800px) {
		#contents_left .left-visual .left-visual-content { font-size: 1.2rem; }
	}
	@media all and (max-width:640px) {
		#contents_left .left-visual .left-visual-content { font-size: 1.0rem; }
	}
	@media all and (max-width:500px) {
		#contents_left .left-visual .left-visual-content { font-size: 0.9rem; }
	}
	@media all and (max-width:400px) {
		#contents_left .left-visual .left-visual-content { font-size: 0.8rem; }
	}
	@media all and (max-width:320px) {
		#contents_left .left-visual .left-visual-content { font-size: 0.7rem; }
	}

	/* FOOTER CSS START */
	#footer { width: 100%; height:175px; border-top: 1px solid #ddd; background: #f7f7f7; z-index: 800; box-sizing:border-box; }
	#footer .footDiv { position: relative; width: 1200px; height: auto; margin: auto; padding: 40px 0; overflow: hidden; }
	#footer .footDiv .fLine { clear:both; }
	#footer .footDiv .fUtil { float:left; }
	#footer .footDiv .fUtil a { display:inline-block; height:32px; line-height:32px; font-size:15px; }
	#footer .footDiv .fUtil a.safe-key { margin-left:10px; }
	#footer .footDiv .fUtil select { font-size:15px; position:relative; top:auto; right:auto; width:auto; font-family:"NanumGothic"; }
	#footer .footDiv .fUtil a.linkBt { position:relative; top:auto; right:auto; text-align:center; background: #666; color: #fff; padding:0 20px; }
	#footer .footDiv .fUtil.fbtns img { vertical-align:middle; }
	#footer .footDiv .awardMark { float:right; margin-top:15px; border-left: 1px solid #d2d1d1; }
	#footer .footDiv .awardMark img { float:left; height:50px; margin-left:25px; }
	#footer .footDiv .awardMark .webaward span { float:left; color:#888; box-sizing: border-box; display:inline-block; padding-top:12px; font-size: 13px; }
	#footer .footDiv .copyRight { float:left; margin-top:20px; font-size:13px; color:#888; }
	#footer .footDiv .copyRight p { font-size:12px; color:#888; margin-top:10px; font-family:"NanumGothic"; }
	@media (max-width: 1199px){
		#footer_main { bottom:-219px; }
		#footer { height:219px; }
		#footer .footDiv { width:94%; margin: 0 auto; height:auto; }
		#footer .footDiv .fUtil { width:calc(100% - 400px); }
		#footer .footDiv .fUtil.fbtns { width:400px; }
		#footer .footDiv .fUtil a { height:auto; line-height:160%; }
		#footer .footDiv .awardMark { width:300px; }
		#footer .footDiv .copyRight { width:calc(100% - 310px); line-height: 160%; }
	}
	@media (max-width: 980px){
		#footer { height:auto; }
		#footer .footDiv .fLine { clear: none; }
		#footer .footDiv .fLine2 { clear: both; }
		#footer .footDiv .fUtil { float:none; width:100%; margin-bottom:10px; }
		#footer .footDiv .fUtil.fbtns { float:left; margin-bottom:0px; height:50px; margin-top: 10px; }
		#footer .footDiv .fUtil a.safe-key { margin-left:0px; }
		#footer .footDiv .fUtil select { top:0px; }
		#footer .footDiv .fUtil a.linkBt { height:32px; line-height:32px; top:0px; }
		#footer .footDiv .awardMark { float:left; margin-top:0; }
		#footer .footDiv .copyRight { float:none; width:100%; margin-top:10px; }
	}
	@media (max-width: 800px){
		#footer { height:auto; }
		#footer .footDiv { padding:20px 0; }
		#footer .footDiv .fUtil { float:none; margin:0; }
		#footer .footDiv .fUtil.fbtns { float:none; display:none; }
		#footer .footDiv .fUtil select { display:inline-block; }
		#footer .footDiv .awardMark { float:none; margin:10px auto; border:none; }
		#footer .footDiv .awardMark img:first-child { margin-left:0; }
		#footer .footDiv .awardMark a.webaward img { margin-left:10px; }
		#footer .footDiv .copyRight { margin:0; }
	}
	/* FOOTER CSS END */
	</style>
	<script>
	var swiper;
	var swiper_m;
	jQuery(document).ready(function () {
		pc_swiper();
		setTimeout("left_change()", 500);

		jQuery("#contents_left").mouseenter(function(){
			jQuery("#contents_left .btn_prev").css({"display":"inline-block"});
			jQuery("#contents_left .btn_next").css({"display":"inline-block"});
		});
		jQuery("#contents_left").mouseleave(function(){
			jQuery("#contents_left .btn_prev").css({"display":"none"});
			jQuery("#contents_left .btn_next").css({"display":"none"});
		});


		jQuery("#footer_main").mouseenter(function(){
			if(jQuery(document).width() >= 980){
				jQuery("#footer_main").stop().animate({
					bottom: 0
				}, 300);
			}
		});
		jQuery("#footer_main").mouseleave(function(){
			if(jQuery(document).width() >= 980){
				if (!jQuery("#selectAflt").is(":focus")) {
					if(jQuery(document).width() >= 1200){
						jQuery("#footer_main").stop().animate({
							bottom: -175
						}, 300);
					}else {
						jQuery("#footer_main").stop().animate({
							bottom: -219
						}, 300);
					}
				}
			}
		});
		
		jQuery("#selectAflt").change(function(){
			jQuery(this).blur();
		});
	});
	
	jQuery(window).load(function () {
		left_change();
	});

	//좌측 비쥬얼 스와이프 기능
	function pc_swiper() {
		swiper = new Swiper('.swiper', {
			autoplay: {
				delay: 3000
			},
			loop: true,
			delay: 2000,
			disableOnInteraction: false,
			navigation: {
				nextEl: '.btn_next',
				prevEl: '.btn_prev'
			},
			pagination: {
				el: '.swiper-pagination',
				clickable: true,
				renderBullet: function (index, className) {
					return '<span class="' + className + '"></span>';
				}
			},
			on: {
				autoplayStop: function () {
					this.autoplay.start();
				}
			}
		});
	}

	function left_change() {
		left_resize();
	}
	
	function left_resize() {
		if(jQuery(document).width() <= 1920){
			//좌측 타이틀 이미지를 가로 비율대로.
			jQuery(".left-visual-title img").each(function(index){
				if(typeof jQuery(this)[0].naturalWidth != "undefined") {
					var this_width = (jQuery(this)[0].naturalWidth / 960) * jQuery("#contents_left").width();
					jQuery(this).width(this_width);
				}
			});
			jQuery(".left-visual-img img").each(function(index){
				if(typeof jQuery(this)[0].naturalWidth != "undefined") {
					var this_width = (jQuery(this)[0].naturalWidth / 960) * jQuery("#contents_left").width();
					jQuery(this).width(this_width);
				}
			});
			jQuery(".left-visual-btn img").each(function(index){
				if(typeof jQuery(this)[0].naturalWidth != "undefined") {
					var this_width = (jQuery(this)[0].naturalWidth / 960) * jQuery("#contents_left").width();
					jQuery(this).width(this_width);
				}
			});
		}else {
			//좌측 타이틀 이미지를 원래 크기대로.
			jQuery(".left-visual-title img").each(function(index){
				if(typeof jQuery(this)[0].naturalWidth != "undefined") {
					jQuery(this).width(jQuery(this)[0].naturalWidt);
				}
			});
			jQuery(".left-visual-img img").each(function(index){
				if(typeof jQuery(this)[0].naturalWidth != "undefined") {
					jQuery(this).width(jQuery(this)[0].naturalWidt);
				}
			});
			jQuery(".left-visual-btn img").each(function(index){
				if(typeof jQuery(this)[0].naturalWidth != "undefined") {
					jQuery(this).width(jQuery(this)[0].naturalWidt);
				}
			});
		}
		
		if(jQuery(".nList a").width() <= 310) {
			jQuery(".nList a span.date").hide();
		}else {
			jQuery(".nList a span.date").show();
		}
		
		if(jQuery(document).width() > 980){
			//푸터 높이 변경
			if (!jQuery("#selectAflt").is(":focus")) {
				if(jQuery(document).width() >= 1200){
					jQuery("#footer_main").css({
						bottom: -175
					});
				}else {
					jQuery("#footer_main").css({
						bottom: -219
					});
				}
			}
			jQuery("#contents_left").css("height", "calc(100vh - 156px)");
		//모바일 화면일 경우
		}else{
			var mh = (jQuery(document).width() / 640) * 660;
			jQuery("#contents_left").height(mh);
			
			jQuery("#footer_main").css({ 
				bottom:'auto', 
				position:'relative !important'
			});
		}
		jQuery(window).one("resize", function(){
			left_resize();
		});
	}
	</script>
</head>

<body>
<div id="header">
	<div class="headDiv">
		<h1><a href="/main/index.do"><img src="/common/images/logo.gif" alt=""></a></h1>
		<div class="util">
			<a href="javascript:goShop()" class="mbcardBtn">회원몰</a>
			<a href="/my-lifeway/member/resortagree/index.do" class="mbcardBtn mbResortBtn2 btnResortN" onclick="alert('대명리조트 예약을 위해서는 개인정보 제 3자 제공에 동의하셔야 합니다.\n나의 대명아임레디 리조트 객실 예약을 위한 개인정보 제공동의페이지로 이동합니다.');">리조트예약</a>
			<span>|</span>
			<a href="/member/login/Login.do">로그인</a>
					<span>|</span>
					<a href="/member/join/agree.do">회원가입</a>
					</div>
		
		<div id="gnb" class="">
			<a href="/lifeway-service/product-character/contentsid/175/index.do" target="_self" class="oneD">상품안내</a>
						<div class="twoD one" style="display: none;">
					<a href="/lifeway-service/product-character/contentsid/175/index.do" target="_self" class="">상품특징</a>
					<a href="/lifeway-service/normal-product/contentsid/321/index.do" target="_self">일반상품</a>
					<a href="/lifeway-service/etc-product/contentsid/324/index.do" target="_self">결합상품</a>
					<a href="/lifeway-service/etc-product/contentsid/185/index.do" target="_self">결합상품<br>(오프라인 전용)</a>
					</div>
							<a href="/membership-service/contentsid/227/index.do" target="_self" class="oneD">멤버십 서비스</a>
						<div class="twoD two" style="display: none;">
					<a href="/membership-service/mobile-card/index.do" target="_self">모바일 멤버십 카드</a>
					<a href="/membership-service/resort/index.do" target="_self">대명리조트</a>
					<a href="/membership-service/ok-cashback/contentsid/228/index.do" target="_self">OK캐쉬백</a>
					<a href="/membership-service/icehockey/index.do" target="_self">대명아이스하키<br>(대명킬러웨일즈)</a>
					</div>
							<a href="/change-service/contentsid/192/index.do" target="_self" class="oneD">하이브리드 서비스</a>
						<div class="twoD thr" style="display: none;">
					<a href="/change-service/tour/index.do" target="_self">여행</a>
					<a href="/change-service/wedding/introduction/index.do" target="_self" class="">웨딩</a>
					<a href="/change-service/marriage-information/index.do" target="_self">결혼정보</a>
					<a href="/change-service/convention/index.do" target="_self">웨딩홀</a>
					<a href="/change-service/english-camp/index.do" target="_self">어학연수</a>
					<a href="/change-service/education/index.do" target="_self" class="">교육</a>
					<a href="/change-service/move/index.do" target="_self">이사</a>
					<a href="/change-service/golf/index.do" target="_self">골프</a>
					</div>
							<a href="/pr-center/lifeway-event/communityid/6/list.do" target="_self" class="oneD">홍보센터</a>
						<div class="twoD fou" style="display: none;">
					<a href="/pr-center/lifeway-event/communityid/6/list.do" target="_self">이벤트</a>
					<a href="/pr-center/lifeway-magazine/index.do" target="_self">매거진</a>
					<a href="/pr-center/media-report/communityid/3/list.do" target="_self" class="">언론보도</a>
					<a href="/pr-center/praise/communityid/5/list.do" target="_self" class="">칭찬합시다</a>
					<a href="/pr-center/media/communityid/1/list.do" target="_self">홍보영상</a>
					<a href="/pr-center/paper/communityid/4/list.do" target="_self">지면광고</a>
					</div>
							<a href="/customer-center/communityid/7/list.do" target="_self" class="oneD">고객센터</a>
						<div class="twoD fiv" style="display: none;">
					<a href="/customer-center/communityid/7/list.do" target="_self">공지사항</a>
					<a href="/customer-center/communityid/8/list.do" target="_self" class="">FAQ</a>
					<a href="/customer-center/personal-counseling/index.do" target="_self" class="">1:1 상담하기</a>
					<a href="http://www.imdirect.co.kr/index" target="_blank">상담신청</a>
					<a href="/customer-center/alliance-counseling/index.do" target="_self">제휴 문의</a>
					</div>
							<a href="/daemyung-lifeway/ceo/contentsid/211/index.do" target="_self" class="oneD">회사소개</a>
						<div class="twoD six" style="display: none;">
					<a href="/daemyung-lifeway/ceo/contentsid/211/index.do" target="_self" class="">CEO 메세지</a>
					<a href="/daemyung-lifeway/introduction/contentsid/212/index.do" target="_self">회사소개</a>
					<a href="/daemyung-lifeway/history/contentsid/213/index.do" target="_self">연혁</a>
					<a href="/daemyung-lifeway/bi/contentsid/214/index.do" target="_self">BI 스토리</a>
					<a href="/daemyung-lifeway/location/contentsid/215/index.do" target="_self">찾아오시는 길</a>
					<a href="/communityid/2/list.do" target="_self">기업정보</a>
					</div>
		</div>
		
		<div class="mbBtns">
			<a href="javascript:goShop()" class="mbcardBtn2">회원몰</a>
			<a href="/my-lifeway/member/resortagree/index.do" class="mbcardBtn2 mbResortBtn2 btnResortN" onclick="alert('대명리조트 예약을 위해서는 개인정보 제 3자 제공에 동의하셔야 합니다.\n나의 대명아임레디 리조트 객실 예약을 위한 (주)대명레저산업 개인정보 제공동의페이지로 이동합니다.');">리조트예약</a>
		</div>
		
		<a href="javascript:" class="mobileMenu"><img src="/common/images/main/mobile_menubt.gif" alt=""></a>
	</div>
	
	<div class="twoDbg" style="display: none;"></div>
</div>







<div id="main-wraper">
	<!-- left div -->
	<div id="contents_left">
		<div class="swiper swiper-container">
			<ul class="swiper-wrapper">
				<c:if test="${fn:length(rtnMap.visualList) > 0}">
					<c:forEach var="vlist" items="${rtnMap.visualList}">
						<li class="left-visual swiper-slide" style="background-color:${ vlist.webBgColor };" onclick="javascript:window.open('${ vlist.link }', '_blank');">
							<div class="left-visual-img" style="position:absolute;top:${ vlist.bgXyAry[0] }; left:${ vlist.bgXyAry[1] }; right:${ vlist.bgXyAry[2] }; bottom:${ vlist.bgXyAry[3] };">
								<%-- 
								<img src="/cmm/fms/getPrevImage.do?path=${ vlist.webBgPath }&fileNm=${ vlist.webBgSaveFileNm }&fileExtn=">
								--%>
								<img src="/cmm/fms/getPrevImage.do?path=main&fileNm=${ vlist.webBgSaveFileNm }&fileExtn=">
							</div>
							<div class="left-visual-title" style="position:relative; top:${ vlist.titleImgXyAry[0] }%; left:${ vlist.titleImgXyAry[1] }%;">
								<%-- 
								<img src="/cmm/fms/getPrevImage.do?path=${ vlist.webTitlePath }&fileNm=${ vlist.webTitleSaveFileNm }&fileExtn="/>
								--%>
								<img src="/cmm/fms/getPrevImage.do?path=main&fileNm=${ vlist.webTitleSaveFileNm }&fileExtn="/>
							</div>
							<c:if test="${vlist.webTitleTxt ne ''}">
								<div class="left-visual-content"  style="position:relative; top:${ vlist.titleTxtXyAry[0] }%; left:${ vlist.titleTxtXyAry[1] }%;">
									<span>${ vlist.webTitleTxt }</span>
								</div>
							</c:if>
							<div class="left-visual-btn" style="position:absolute; bottom:${ vlist.btnXyAry[0] }%; left:${ vlist.btnXyAry[1] }%;">
								<%-- 
								<img src="/cmm/fms/getPrevImage.do?path=${ vlist.webBtnPath }&fileNm=${ vlist.webBtnSaveFileNm }&fileExtn="/>
								--%>
								<img src="/cmm/fms/getPrevImage.do?path=main&fileNm=${ vlist.webBtnSaveFileNm }&fileExtn="/>
							</div>
						</li>
					</c:forEach>
				</c:if>
			</ul>
			<a href="#" class="btn_prev"><img src="/common/images/main/slide_prev_btn.png"></a>
			<a href="#" class="btn_next"><img src="/common/images/main/slide_next_btn.png"></a>
			<div class="swiper-pagination"></div>
		</div>
	</div>
	

	<!-- right div -->
	<div id="contents_right">
		<div class="right-container">
			<div class="right-inner">
				<c:if test="${fn:length(rtnMap.contentList) > 0}">
					<c:forEach var="clist" items="${rtnMap.contentList}">
						<div class="right-section">
							<div class="right-section-title">
								<div class="top-bar" style="background:${ clist.titleColor };"></div>
								${ clist.titleTxt }
							</div>
							<c:if test="${fn:length(rtnMap.contentDtlList) > 0}">
								<div class="right-section-contents">
									<c:forEach var="dlist" items="${rtnMap.contentDtlList}">
										<c:if test="${dlist.cntnsMstSeq eq clist.cntnsMstSeq}">
											<div class="right-section-content">
												<div class="right-section-content-img">
													<a href="${ dlist.link }">
														<%-- 
														<img src="/cmm/fms/getPrevImage.do?path=${ dlist.imgPath }&fileNm=${ dlist.imgSaveFileNm }&fileExtn=">
														--%>
														<img src="/cmm/fms/getPrevImage.do?path=main&fileNm=${ dlist.imgSaveFileNm }&fileExtn=">
													</a>
												</div>
												<div class="right-section-content-title"><a href="${ dlist.link }">${ dlist.title }</a></div>
												<div class="right-section-content-msg"><a href="${ dlist.link }">${ dlist.dsc }</a></div>
											</div>
										</c:if>
									</c:forEach>
								</div>
								<div class="clear"></div>
							</c:if>
						</div>
					</c:forEach>
				</c:if>
			</div>
		</div>
	</div>
</div>
<div class="clear"></div>

<div id="footer_main">
	<div class="footerDiv">
		<div class="noti">
			<p class="tit">공지</p>
			<div class="nList">
				<a href="/customer-center/communityid/7/view.do?pageIndex=1&idx=1198&f=&q=" style="top: 0px;">
					<span class="txt">제 15회 대한민국 명품브랜드 대상, 5년 연속 선정</span>
					<span class="date">2019.04.12</span>
				</a>
					<a href="/customer-center/communityid/7/view.do?pageIndex=1&idx=1055&f=&q=" style="top: 55px;">
					<span class="txt">대명아임레디 멤버십 개편 안내</span>
					<span class="date">2019.02.14</span>
				</a>
					<a href="/customer-center/communityid/7/view.do?pageIndex=1&idx=871&f=&q=" style="top: 110px;">
					<span class="txt">장지 하이브리드 서비스 신규 론칭</span>
					<span class="date">2018.10.31</span>
				</a>
					<a href="/customer-center/communityid/7/view.do?pageIndex=1&idx=611&f=&q=" style="top: 55px;">
					<span class="txt">새롭게 즐기는 라이프웨이, 대명아임레디</span>
					<span class="date">2018.05.18</span>
				</a>
			</div>
			<div class="bts">
				<a href="javascript:" class="up" title="이전"><img src="/common/images/main/main_noti_up.png" alt=""></a>
				<a href="javascript:" class="down" title="다음"><img src="/common/images/main/main_noti_down.png" alt=""></a>
			</div>
		</div>

		<div class="contact">
			<div class="contact1"><strong>컨택센터  <a href="tel:1588-8511" style="color:#fff;">1588-8511</a></strong></div>
			<span>|</span>
			<div class="contact2"><strong>24시 장례접수  <a href="tel:1588-2227" style="color:#fff;">1588-2227</a></strong></div>
		</div>
	</div>

	<div id="footer">
		<div class="footDiv">
			<div class="fUtil">
				<a href="/operation-guide/privacy/index.do" class="red">개인정보처리방침</a>
				<span>|</span>
				<a href="/operation-guide/terms/index.do">이용약관</a>
				<span>|</span>
				<a href="/customer-center/communityid/7/list.do">고객센터</a>
				<span>|</span>
				<a href="/operation-guide/important/index.do">중요정보 고시사항</a>
				<span>|</span>
				<!--<a href="/operation-guide/outsourcing-guide/index.do">외주 용역 안내</a>
				<span>|</span>-->
				<a href="/operation-guide/legal/index.do">법적고지</a>
				<span>|</span>
				<a href="/operation-guide/staff-search/index.do">담당사원 검색</a>
				<span>|</span>
				<a href="/my-lifeway/membership-card/index.do" class="red">멤버십 카드 정보</a>
				<span>|</span>
				<c:choose>
					<c:when test="${agreementForThirdParty eq 'Y'}">
						<a href="http://www.daemyungresort.com/mv.dp/dmparse.dm?menuCd=5551000" class="red mbResortBtn2" target="_blank">리조트객실예약</a>
					</c:when>
					<c:otherwise>
						<a href="/my-lifeway/member/resortagree/index.do" class="red mbResortBtn2" onclick="alert('대명리조트 예약을 위해서는 개인정보 제 3자 제공에 동의하셔야 합니다.\n나의 대명아임레디 리조트 객실 예약을 위한 (주)대명레저산업 개인정보 제공동의페이지로 이동합니다.');">리조트객실예약</a>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="fUtil fbtns">
				<a href="javascript:setPopup('/safe-key/index.do', 'NiceSafeKeyPop', 685, 585);" class="safe-key">
					<img src="/common/images/main/btn_safe_key.gif" alt="본인인증"/>
				</a>
				<select id="selectAflt" title="계열사 홈페이지 선택">
					<option value="">Family Site</option>
					<option value="http://www.daemyung.com">대명그룹</option>
					<option value="http://www.daemyungresort.com">대명리조트</option>
					<option value="http://www.daemyungtourmall.com">대명투어몰</option>
					<option value="http://www.dgolfclub.com">대명골프클럼</option>
					<option value="http://www.sonofeliceeclub.com">승마클럼</option>
					<option value="http://www.mvlhotel.com">엠블호텔</option>
					<option value="http://www.sonofeliceconvention.com">소노펠리체컨벤션</option>
					<option value="http://www.bornwedding.com">대명본웨딩</option>
					<option value="http://www.withone.co.kr">대명위드원</option>
					<option value="http://daemyungcorporation.com">대명코퍼레이션</option>
					<option value="http://www.daemyungcon.co.kr">대명건설</option>
					<option value="http://www.daemyungwelfare.org">대명복지재단</option>
					<option value="http://www.daemyung.co.kr/ethics">대명윤리경영</option>
					<option value="http://www.solbi.com/main.asp">U-솔비넷</option>
				</select>
				<a href="javascript:moveFooterAflt();" class="linkBt">이동</a>
			</div>
			<div class="fLine"></div>
			<p class="awardMark">
				<a class href="javascript:window.open('/ism-popup/index.do','window','width=515, height=360, left=0, top=0, scrollbars=0, resizable=no')">
					<img src="/common/images/icon/PIMS.png" />
				</a>
				<a class="webaward" href="http://www.i-award.or.kr/Web/Assess/FinalCandidateView.aspx?REG_SEQNO=6375" target="_blank">
					<img src="https://www.daemyungimready.com/common/images/icon/webaward.png" alt="웹어워드코리아2016 금융분야 대상" />
				</a>
				<!--KISA Certificate Mark-->
				<a href='javascript:window.open("https://www.ucert.co.kr/trustlogo/sseal_cert.html?sealnum=04e7de242465a332e56d1f3478666d46aef869581e44e976edf712e9fd8625fb&sealid=9829d0e94b87895acf4b1b43ef057f7a52c141666402efa0bb8f3efd8d30efbee58206c03f1855eb52ee806864945609","mark","scrollbars=no,resizable=no,width=565,height=780");'>
					<img src="https://www.daemyungimready.com/common/images/icon/kisia.png" align="absmiddle" style="cursor:hand; width: 71.74px; height:40px; padding-top: 5px; border: none;"></a>
				<!--KISA Certificate Mark-->

				<a class href="javascript:window.open('https://www.daemyungimready.com/ism-popup/ismsp.do','window','width=810, height=1050, left=0, top=0, scrollbars=0, resizable=no')">
					<img src="https://www.daemyungimready.com/common/images/main/isms_p.png" alt="ISMS-P 인증 달성"/>
				</a>
			</p>
			<div class="fLine2"></div>
			<div class="copyRight">
				서울시 송파구 법원로 135 대명타워
				<span>|</span>
				사업자등록번호 220-88-09321 
				<span>|</span>
				 대표자 (주)대명스테이션 대표이사 최성훈 
				<span>|</span>
				통신판매신고번호 제2016-서울송파-0669호
				<p>COPYRIGHT DAEMYUNGSTATION.CO,.LTD. ALL RIGHTS RESERVED.</p>
			</div>
			<div style="clear:both;"></div>
		</div>
	</div>
</div>


</body>
</html>
