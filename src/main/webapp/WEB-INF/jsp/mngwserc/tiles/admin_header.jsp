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
		<link href="/egov/css/bootstrap.css" rel="stylesheet" />
	    <link href="/egov/css/bootstrap-responsive.css" rel="stylesheet" />
	    <link href="/egov/css/paging.css" rel="stylesheet" />
	    <link href="/egov/css/table.css" rel="stylesheet" />
	    <link href="/egov/css/jquery.fileupload.css" rel="stylesheet" />
	    <link href="/egov/css/jquery.fileupload-ui.css" rel="stylesheet" />
	    <link href="/common/css/redmond/jquery-ui-1.8.16.custom.css" rel="stylesheet" />
	    <style type="text/css">
	    	body {
	        	padding-top: 60px;
	        	padding-bottom: 40px;
	      	}
	      	.sidebar-nav {
	        	padding: 9px 0;
	      	}
	
	      	@media (max-width: 980px) {
	        	/* Enable use of floated navbar text */
	        	.navbar-text.pull-right {
	          	float: none;
	          	padding-left: 5px;
	          	padding-right: 5px;
	        	}
	      	}
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
    	<div class="navbar navbar-inverse navbar-fixed-top">
      		<div class="navbar-inner">
        		<div class="container-fluid">
          			<button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            			<span class="icon-bar"></span>
            			<span class="icon-bar"></span>
            			<span class="icon-bar"></span>
          			</button>
          			<a class="brand" href="javascript:">대명아임레디</a>
          			<div class="nav-collapse collapse">
						<ul class="nav pull-right">
			  				<li class="divider-vertical"></li>
			  				<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">${admLgnMap.name}<b class="caret"></b></a>
								<ul class="dropdown-menu">
				  					<li><a href="./setLogout.do"><i class="icon-off"></i> 로그아웃</a></li>
				  					<li><a href="./modify.do"><i class="icon-wrench"></i> 내 정보변경</a></li>
				  					<li class="divider"></li>
				  					<li><a href="javascript:" style="cursor:default"><i class="icon-info-sign"></i> ${admLgnMap.loginIp}</a></li>
								</ul>
			  				</li>
						</ul>        
            			<c:set var="admLink" value="" />
            			<fmt:formatNumber value="0" type="number" var="prelevel" />
            			<c:set var="gnbMenuListCnt" value="${fn:length(gnbMenuList)}" />
						<c:forEach var="top" items="${gnbMenuList}" varStatus="status">	
							<c:set var="admLink" value="${top.admLink}" />
						  	<c:choose>
						  		<c:when test="${status.count lt gnbMenuListCnt}">
						  			<fmt:formatNumber value="${gnbMenuList[status.count].dpth}" type="number" var="nextlevel" /> 
						  		</c:when>
						  		<c:otherwise>
						  			<fmt:formatNumber value="${gnbMenuList[status.count-1].dpth}" type="number" var="nextlevel" /> 
						  		</c:otherwise>
						  	</c:choose>		
							<fmt:formatNumber value="${top.dpth}" type="number" var="currentlevel" />
							<c:if test="${empty nextlevel}">
								<fmt:formatNumber value="${currentlevel}" type="number" var="nextlevel" /> 
							</c:if>						
							<c:if test="${empty admLink}">
								<c:set var="admLink" value="javascript:" />
							</c:if>		
							<c:if test="${status.count eq 1}">
								<ul class="nav">
							</c:if>	
							<c:choose>
						       	<c:when test="${prelevel lt currentlevel and currentlevel ne 2}">
						       		<ul class="dropdown-menu">					       	     			
						       	</c:when>
						    </c:choose>
						    <c:choose>			       
						       <c:when test="${currentlevel lt nextlevel}">
						       		<c:choose>				  
								       	<c:when test="${currentlevel eq 2}">		       		
								       		<li class="dropdown active" TTYPE="${top.menuGb}" id="TREEID_${top.menuSeq}">
								       	</c:when>
								       	<c:when test="${prelevel lt currentlevel}">
								       		<li class="dropdown-submenu" TTYPE="${top.menuGb}" id="TREEID_${top.menuSeq}">     	     			
								       	</c:when>
								       	<c:when test="${currentlevel lt nextlevel}">
								       		<li class="dropdown-submenu" TTYPE="${top.menuGb}" id="TREEID_${top.menuSeq}">      	     			
								       	</c:when>
								    </c:choose>			       		
						      		<a href="${admLink}" class="dropdown-toggle" data-toggle="dropdown">${top.menuNm}<b class="caret"></b></a>
						       </c:when>
						       <c:otherwise>
						       		<c:choose>	
							       		<c:when test="${currentlevel eq 2}">		       		
								       		<li class="dropdown active" TTYPE="${top.menuGb}" id="TREEID_${top.menuSeq}">
								       	</c:when>
								       	<c:otherwise>
								       		<li class="" TTYPE="${top.menuGb}" id="TREEID_${top.menuSeq}">		       	     			
								       	</c:otherwise>
							       	</c:choose>
							       	<%-- 개발용
									<a href="${admLink}">${top.menuNm}(${admLink})</a>
									--%>
									<a href="${admLink}">${top.menuNm}</a>
						       </c:otherwise>
						    </c:choose>
							<c:choose>	
								<c:when test="${gnbMenuListCnt eq status.count}">
						       		<!-- 닫아 -->
						       		<c:forEach begin="2" end="${currentlevel}" step="1" var="close">
											</li>
										</ul>
									</c:forEach> 
						       	</c:when>
						       	<c:when test="${currentlevel gt nextlevel}">
						       		<!-- 닫아 -->
						       		<c:forEach begin="1" end="${currentlevel - nextlevel}" step="1" var="close">
											</li>
										</ul>
									</c:forEach> 
						       	</c:when>
						        <c:when test="${currentlevel eq nextlevel}">
							       		<!-- 같아 -->
							      		</li>
						       </c:when>
						    </c:choose>		
			    			<fmt:formatNumber value="${top.dpth}" type="number" var="prelevel" />
						</c:forEach>
          			</div><!--/.nav-collapse -->
        		</div>
      		</div>
    	</div>

    	<div class="container-fluid">
      		<div class="row-fluid" >
        		<div class="span2">
          			<div class="well " style="padding:8px 0;" id="navLeft">
            			<ul class="nav nav-list" id="UL_${firstParentId}" style="height:600px; overflow-y:auto;">             
              				<c:set var="admLink" value="" />
	            			<fmt:formatNumber value="0" type="number" var="prelevel" />
	            			<c:set var="lnbMenuListCnt" value="${fn:length(lnbMenuList)}" />
							<c:forEach var="left" items="${lnbMenuList}" varStatus="status">
							    <c:set var="admLink" value="${left.admLink}" />
							  	<c:choose>
							  		<c:when test="${status.count lt lnbMenuListCnt}">
							  			<fmt:formatNumber value="${lnbMenuList[status.count].dpth}" type="number" var="nextlevel" /> 
							  		</c:when>
							  		<c:otherwise>
							  			<fmt:formatNumber value="${lnbMenuList[status.count-1].dpth}" type="number" var="nextlevel" /> 
							  		</c:otherwise>
							  	</c:choose>					
								<fmt:formatNumber value="${left.dpth}" type="number" var="currentlevel" />
								<c:if test="${empty nextlevel}">
									<fmt:formatNumber value="${currentlevel}" type="number" var="nextlevel" /> 
								</c:if>						
								<c:if test="${empty admLink}">
									<c:set var="admLink" value ="javascript:" />
								</c:if>		
								<c:if test="${status.count eq 1}">
									<li class="nav-header" style="font-size:14px;">${left.menuNm}</li>
								</c:if>
								<c:if test="${status.count ne 1}">
									<c:choose>
								       	<c:when test="${prelevel lt currentlevel and currentlevel ne 2}">
								       		<ul class="nav nav-list"  TTYPE="${left.menuGb}" id="UL_${left.menuSeq}">	       	     			
								       	</c:when>
								    </c:choose>
								    <c:choose>				  
								       	<c:when test="${left.menuSeq eq pageNo}">
											<li class="active" TREEID="${left.menuSeq}" TTYPE="${left.menuGb}" id="TREEID_${left.menuSeq}">
								       	</c:when>
								       	<c:otherwise>
							       			<li class="" TREEID="${left.menuSeq}" TTYPE="${left.menuGb}" id="TREEID_${left.menuSeq}">
								       	</c:otherwise>
								    </c:choose>	
								    <c:choose>			       
								       	<c:when test="${currentlevel eq 3}">					       				       		
								      		<a href="${admLink}" style="font-size:12px; font-weight:bold;">${left.menuNm}</a>
								       	</c:when>
								       	<c:otherwise>
								       		<a href="${admLink}" style="font-size:11px;">${left.menuNm}</a>
								       	</c:otherwise>
									</c:choose>
									<c:choose>	
										<c:when test="${lnbMenuListCnt eq status.count}">
								       		<!-- 닫아 -->
								       		<c:forEach begin="2" end="${currentlevel}" step="1" var="close">
													</li>
												</ul>
											</c:forEach> 
								       	</c:when>
								       	<c:when test="${currentlevel gt nextlevel}">
								       		<!-- 닫아 -->
								       		<c:forEach begin="1" end="${currentlevel - nextlevel}" step="1" var="close">
													</li>
												</ul>
											</c:forEach> 
								       	</c:when>
								        <c:when test="${currentlevel eq nextlevel}">
								       		<!-- 같아 -->
								      		</li>
								       	</c:when>
								    </c:choose>
							    </c:if>			
							    <fmt:formatNumber value="${left.dpth}" type="number" var="prelevel" />		
							</c:forEach>
						</ul>
          			</div><!--/.well -->
        		</div><!--/span-->
				<div class="span10" >
					<div class="span6 ">
						<i class="icon-ok"></i>
						<b id="pageName">${pageTitle}</b>
					</div>
					<div class="span6">
						<p class="text-right muted" id="locationPath">
							Home&gt;${pageIndicator}
						</p>
					</div>
				</div>		
				<div class="span10">
				<!-- 본문 시작 -->