<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!DOCTYPE html>
<html lang="ko">
  	<head>
    	<meta charset="utf-8">
   	 	<title>${pageTitle}|대명아임레디</title>
    	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
    	<meta name="description" content="" />
    	<meta name="author" content="" />
    	<meta content="A fully featured admin theme which can be used to build CRM, CMS, etc." name="description" />
        <meta content="Coderthemes" name="author" />
	    <link href="/egov/css/paging.css" rel="stylesheet" />
	    <link href="/egov/css/jquery.fileupload.css" rel="stylesheet" />
	    <link href="/egov/css/jquery.fileupload-ui.css" rel="stylesheet" />
	    <link href="/common/css/redmond/jquery-ui-1.8.16.custom.css" rel="stylesheet" />
	    
        <!-- Bootstrap Css -->
        <link href="/egov/css/bootstrap.min.lgu.css" id="bootstrap-stylesheet" rel="stylesheet" type="text/css" />
        <!-- Icons Css -->
        <link href="/egov/css/icons.min.css" rel="stylesheet" type="text/css" />
        <!-- App Css-->
        <link href="/egov/css/app.min.css" id="app-stylesheet" rel="stylesheet" type="text/css" />
        
	    <style>
	      	.open > .dropdown-menu {display: block;}
	    </style>
		<script type="text/javascript" src="/common/js/jquery.js"></script>
		<script type="text/javascript" src="/common/js/jquery-ui.js"></script>
	    <script type="text/javascript" src="/common/js/jquery.ui.datepicker-ko.js"></script>
	    <script type="text/javascript" src="/common/js/common.js"></script>
	    <script type="text/javascript" src="/common/js/devtest.js"></script> 
	    <script type="text/javascript" src="/common/js/fnc.js"></script>
		<script type="text/javascript" src="/common/js/frm.js"></script>
	    <!-- <script type="text/javascript" src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script> -->
	    <script type="text/javascript" src="https://spi.maps.daum.net/imap/map_js_init/postcode.v2.js"></script> 
	    <script type="text/javascript">
	    	jQuery(document).ready(function(){
	    		if(jQuery("#navLeft").find("li").size() == 0)
	   			{
	    			jQuery("#navLeft").find("ul").append("<li><a href='javascript:'>"+jQuery("#pageName").text()+"</a></li>");
	   			}
	    	});
	    </script>
  	</head>
 	<body>
 		<header id="topnav" style="top: 0;background-color: #333333"> 
			<!-- Topbar Start -->
			<div class="navbar-custom" style="background-color: #333333">
				<div class="container-fluid">
					<ul class="list-unstyled topnav-menu float-right mb-0">
		    			<li class="dropdown notification-list">
							<a class="nav-link dropdown-toggle nav-user mr-0 waves-effect" data-toggle="dropdown" href="/mngwserc/oma/counsel/list.do" role="button" aria-haspopup="false" aria-expanded="false">
								<span class="pro-user-name ml-1">
								   ${admLgnMap.name} <div class="arrow-down"></div>
								</span>
							</a>
							<div class="dropdown-menu dropdown-menu-right profile-dropdown ">
								<!-- item-->
								<a href="./setLogout.do"" class="dropdown-item notify-item">
									<i class="fe-log-out"></i>
									<span>로그아웃</span>
								</a>
								<!-- item-->
								<a href="./modify.do" class="dropdown-item notify-item">
									<i class="fe-settings"></i>
									<span>내 정보변경</span>
								</a>
								<div class="dropdown-divider"></div>
								<!-- item-->
								<a href="javascript:void(0);" class="dropdown-item notify-item">
									<i class="fe-user"></i>
									<span>${admLgnMap.loginIp}</span>
								</a>
							</div>
						</li>
					</ul>
		
					<!-- LOGO -->
					<div class="logo-box" style="background-color: #333333; width: 60px; margin-left: 10px;">
						<a href="/"><img src="https://www.daemyungimready.com/common/images/main/newIndex_logo.png" alt="" style=" height: 60px; filter: brightness(0) invert(1); margin-top: 8px;"></a>
					</div>
					<div class="logo-box" style="background-color: #333333;">
						<a href="/"><img src="/common/images/LGUplus_Logo.png" alt="" style="margin-top: 15px;"></a>
					</div>
					
					<div class="container-fluid">
						<div id="navigation" class="active">
							<!-- Navigation Menu-->
							<ul class="navigation-menu in">
								<li class="has-submenu">
									<a href="#">
										외주업체 관리 <div class="arrow-down"></div></a>
									<ul class="submenu">
										<li class="has-submenu">
											<a href="/mngwserc/oma/counsel/list.do">상담관리 <div class="arrow-down"></div></a>
											<ul class="submenu">
												<li>
													<a href="/mngwserc/oma/counsel/list.do">상담목록</a>
												</li>
											
											</ul>
										</li>
									</ul>
								</li>
							</ul>
						</div>
						<!-- end #navigation -->
					</div>
		
					<div class="clearfix"></div>
				</div> <!-- end container-fluid-->
			</div>
		</header>
		<!-- ========== Left Sidebar Start ========== -->
        <div class="left-side-menu">
	        <div class="slimScrollDiv" style="position: relative; overflow: hidden; width: auto; height: 551px;">
				<div class="slimscroll-menu" style="overflow: hidden; width: auto; height: 551px;">
                <!--- Sidemenu -->
                    <div id="sidebar-menu" class="mm-active">
                        <ul class="metismenu mm-show" id="side-menu" style="height:600px; overflow-y: auto; margin: 0 0 0 0;">
		                   	<li class="menu-title">외주업체 관리</li>
		                   	<li class="mm-active">
	                          <a href="/mngwserc/oma/counsel/list.do" aria-expanded="true">
	                              <span>상담관리</span>
	                          </a>
	                          <ul class="nav-second-level mm-collapse mm-show" aria-expanded="false" >
	                              <li style="background-color: skyblue; font-weight: bold;"><a href="/mngwserc/oma/counsel/list.do">상담목록</a></li>
	                          </ul>
		                    </li>
                    	</ul>

                </div>
                <!-- End Sidebar -->
                <div class="clearfix"></div>
            	</div>
            <!-- Sidebar -left -->
			</div>
		</div>
        <!-- Left Sidebar End -->
        <div class="content-page">
            <div class="content">
            	<div class="container-fluid">

				<!-- 본문 시작 --> 
		 		<%-- <div id="wrapper">
		    		<div class="navbar-custom" style="top: 0; background-color: #333333">
		    			<ul class="list-unstyled topnav-menu float-left mb-0" >
		    				<li class="dropdown notification-list" style="float: left;">
		    					<a class="nav-link dropdown-toggle nav-user mr-0 waves-effect" href="javascript:" role="button">
		                            <span class="pro-user-name ml-1" style="color: 999999; text-shadow: 0 -1px 0 rgb(0 0 0 / 25%); font-size: 20px; font-weight: 200;">
		                              	 대명아임레디
		                            </span>
		                        </a>
		    				</li>
		    				<li class="dropdown notification-list" style="float: left;">
		    					<a class="nav-link dropdown-toggle nav-user mr-0 waves-effect" data-toggle="dropdown" href="#" role="button" aria-haspopup="false" aria-expanded="false">
		                            <span class="pro-user-name ml-1" style="color: #ffffff">
		                               	외주업체 관리
		                            </span>
		                        </a>
		                        <div class="dropdown-menu dropdown-menu-right profile-dropdown ">
		                            <!-- item-->
		                            <a href="/mngwserc/oma/counsel/list.do" class="dropdown-item notify-item">
		                                <span>상담관리</span>
		                            </a>
		                            <!-- item-->
		                            
		                        </div>
		    				</li>
		    			</ul>
		    			<ul class="list-unstyled topnav-menu float-right mb-0">
		    				
		                    <li class="dropdown notification-list">
		                        <a class="nav-link dropdown-toggle nav-user mr-0 waves-effect" data-toggle="dropdown" href="/mngwserc/oma/counsel/list.do" role="button" aria-haspopup="false" aria-expanded="false">
		                            <span class="pro-user-name ml-1">
		                               ${admLgnMap.name} 
		                            </span>
		                        </a>
		                        <div class="dropdown-menu dropdown-menu-right profile-dropdown ">
		                            <!-- item-->
		                            <a href="./setLogout.do"" class="dropdown-item notify-item">
		                                <i class="fe-log-out"></i>
		                                <span>로그아웃</span>
		                            </a>
		                            <!-- item-->
		                            <a href="./modify.do" class="dropdown-item notify-item">
		                                <i class="fe-settings"></i>
		                                <span>내 정보변경</span>
		                            </a>
		                            <div class="dropdown-divider"></div>
		                            <!-- item-->
		                            <a href="javascript:void(0);" class="dropdown-item notify-item">
		                                <i class="fe-user"></i>
		                                <span>${admLgnMap.loginIp}</span>
		                            </a>
		                        </div>
		                    </li>
		                </ul>
		    	</div>

    	<!-- ========== Left Sidebar Start ========== -->
            <div class="left-side-menu">

                <div class="slimscroll-menu">

                    <!--- Sidemenu -->
                    <div id="sidebar-menu" style="padding: 8px 0;">

                        <ul class="metismenu" id="side-menu" style="height:600px; overflow-y: auto;">
                        	 <li class="menu-title" style="font-size: 14px;">외주업체 관리</li>
                        	 <li style="padding-right: 10px; padding-left: 10px;">
                                <a href="/mngwserc/oma/counsel/list.do">
                                    <span style="font-size: 12px; font-weight: bold;">상담관리</span>
                                </a>
                                <ul class="nav-second-level" aria-expanded="false" style="padding-right: 10px; padding-left: 10px;">
                                    <li style="font-size: 11px; background-color: #0088cc;">
                                    	<a href="/mngwserc/oma/counsel/list.do" style="margin-right: -10px; margin-left: -10px;color: #ffffff">상담목록</a>
                                    </li>
                                </ul>
                            </li>
                            
                        </ul>

                    </div>
                    <!-- End Sidebar -->

                    <div class="clearfix"></div>

                </div>
                <!-- Sidebar -left -->

            </div>
            <!-- Left Sidebar End -->
            <div class="content-page">
                <div class="content">
                 <div class="container-fluid">

				<!-- 본문 시작 --> --%>