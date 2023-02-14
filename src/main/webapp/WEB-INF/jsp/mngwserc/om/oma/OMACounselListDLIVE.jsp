<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!--
######################################################################
파일명 		:	OMACounselList.jsp
프로그램 명 : 	외주업체 상담관리 목록
설명		: 	목록
작성자		: 	김필기
작성일		:	2016.02.26
수정일자	 			수정자				수정내용
=====================================================================
2016.02.26				김필기				최초작성
2016.05.20				김필기				최초작성
######################################################################
-->

<script type="text/javascript" src="/common/js/jquery.fileDownload.js"></script>

<c:set var="loginMap" value="${admLgnMap}" />

<c:set var="opmInfMap" value="${rtnMap.opmInfMap}" />


<form id="excelFrm" name="excelFrm" method="post" action="excel.do">
	<input type="hidden" name="f" id="fExcel" value="${rtnMap.f}" />
	<input type="hidden" name="q" id="qExcel" value="${rtnMap.q}" />
	<input type="hidden" name="callStts" id="callSttsExcel" value="${rtnMap.callStts}" />
	<input type="hidden" name="strtDt" id="strtDtExcel" value="${rtnMap.strtDt}" />
	<input type="hidden" name="endDt" id="endDtExcel" value="${rtnMap.endDt}" />
</form>

<form id="frm" name="frm" method="post" action="${pageLink}">
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />

	<div class="well well-small">
		${((opmInfMap.b2bStts eq 'ONLIFECC') or (opmInfMap.b2bStts eq 'EZWEL')) ? '등록일 : ' : '신청일 : '}
		<div class="input-append" style="margin-bottom:0px;">
			<input type="text" id="strtDt" name="strtDt" class="datepicker_input input-small" value="${rtnMap.strtDt}" readonly="readonly" />
			<button class="btn" type="button" onclick="jQuery(this).prev().focus();"><i class="icon-calendar"></i></button>
		</div>
		~
		<div class="input-append" style="margin-bottom:0px;">
			<input type="text" id="endDt" name="endDt" class="datepicker_input input-small" value="${rtnMap.endDt}" readonly="readonly" />
			<button class="btn" type="button" onclick="jQuery(this).prev().focus();"><i class="icon-calendar"></i></button>
		</div>

		<select name="f" id="f">
			<c:if test="${loginMap.id eq 'dlivesales'}">
				<option value="39" <c:if test="${rtnMap.f eq '14'}">selected</c:if>>사번ID</option>
			</c:if>
			<c:if test="${loginMap.id ne 'dlivesales'}">
				<option value="4" <c:if test="${rtnMap.f eq '4'}">selected</c:if>>고객명</option>
				<option value="5" <c:if test="${rtnMap.f eq '5'}">selected</c:if>>연락처</option>
				<option value="11" <c:if test="${rtnMap.f eq '11'}">selected</c:if>>고객번호</option>
				<option value="15" <c:if test="${rtnMap.f eq '15'}">selected</c:if>>지점</option>
				<option value="14" <c:if test="${rtnMap.f eq '14'}">selected</c:if>>사번ID</option>
			</c:if>
		</select>

		<input type="text" name="q" id="q" value="${rtnMap.q}" class="inputType w146" maxlength="50" />

		<select name="callStts" id="callStts" >
			<c:choose>
				<c:when test="${opmInfMap.b2bStts eq 'WEDDING' and loginMap.roleCd eq 'ROLE_00024'}">
					<option value="">[상담현황선택]</option>
				</c:when>
				<c:otherwise>
					<option value="">[상담확인선택]</option>
				</c:otherwise>
			</c:choose>
			<option value="no" <c:if test="${'no' eq rtnMap.callStts}">selected</c:if>>미상담</option>
			<c:forEach var="cdlist" items="${rtnMap.cdDtlList.callStts}" varStatus="status">
				<option value="${cdlist.cd}" <c:if test="${cdlist.cd eq rtnMap.callStts}">selected</c:if>>${cdlist.cdNm}</option>
			</c:forEach>
		</select>

		<a href="javascript:getPageList();" class="btn" title="검색"><i class="icon-search"></i></a>
		<!--<a href="${pageLink}" class="btn " title="전체검색"><i class="icon-refresh"></i></a>-->
		<a href="javascript:getPageNew();" class="btn " title="전체검색"><i class="icon-refresh"></i></a>
	</div>

	<p>전체 게시물 수 : ${rtnMap.list[0].totCnt}</p>

	<table class="table table-bordered table-hover" style="font-size:12px;">
		<caption style="display: none;">외주업체 상담 관리</caption>
		<thead>
		<tr>
			<th style="width:60px; vertical-align:middle;">
				번호
			</th>


<%--			<!-- 계약번호 -->--%>
<%--			<c:if test="${opmInfMap.contractNoYn eq 'Y'}">--%>
<%--				<th style="width:120px; vertical-align:middle;">--%>
<%--					계약번호--%>
<%--				</th>--%>
<%--			</c:if>--%>

			<!-- 1구좌 상품명 -->
			<th style="width:120px; vertical-align:middle;">상품명</th>
			<!-- 고유번호 -->
			<th style="width:120px; vertical-align:middle;">고객번호</th>
			<!-- 고객 연락처(핸드폰) -->
			<th style="width:120px; vertical-align:middle;">대사값</th>
			<!-- 판매사 소속 (업체명) -->
			<th style="width:100px; vertical-align:middle;">지점</th>
			<th style="width:100px; vertical-align:middle;">사번ID<br>(유치자)</th><!--sllrNumYn-->
			<th style="width:100px; vertical-align:middle;">신청일시</th>
			<th style="width:100px; vertical-align:middle;">가입일자</th>
			<!-- 상담현황 -->
			<th style="width:100px; vertical-align:middle;">상담<br>현황</th>
			<!-- 가입상태 -->
			<th style="width:80px; vertical-align:middle;">가입<br>상태</th>
			<th style="width:100px; vertical-align:middle;">납입회차</th>
			<!-- 가입일 -->
			<th style="width:100px; vertical-align:middle;">행사일자</th>
			<!-- 대명 회원번호 -->
			<th style="width:100px; vertical-align:middle;">대명<br>회원번호</th>
<%--			<!-- 주 계약 -->--%>
<%--			<th style="width:100px; vertical-align:middle;">주 계약</th>--%>
<%--			<!-- 메모 -->--%>
<%--			<c:if test="${opmInfMap.memoYn eq 'Y' and loginMap.id ne 'jausawon' and loginMap.id ne 'dmsawon' and loginMap.id ne 'weddingsawon' and loginMap.id ne 's1sawon' and opmInfMap.b2bStts ne 'KBCAR'}">--%>
<%--				<th style="width:200px; vertical-align:middle;">--%>
<%--					메모--%>
<%--				</th>--%>
<%--			</c:if>--%>
		</tr>
		</thead>
		<tbody>
		<c:choose>
			<c:when test="${fn:length(rtnMap.list) eq 0}">
				<tr>
					<td class="lt_text3" colspan="30" style="text-align:center">
						<fmt:message key="common.nodata.msg" />
					</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
					<c:if test="${loginMap.id eq 'dlivesales'}">
						<tr style="cursor:pointer">
					</c:if>
					<c:if test="${loginMap.id ne 'dlivesales'}">
					<tr onclick="view('${list.oscCnslSeq}', '${rtnMap.f}', '${rtnMap.q}', '${rtnMap.pageIndex}', '${rtnMap.callStts}', '${rtnMap.strtDt}', '${rtnMap.endDt}','${list.kbNo}')" style="cursor:pointer">
					</c:if>

					<td style="text-align:center;">${list.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}</td>
<%--					<!-- 계약번호 -->--%>
<%--					<c:if test="${opmInfMap.contractNoYn eq 'Y'}">--%>
<%--						<td style="text-align:center;"> ${ list.contractNo } </td>--%>
<%--					</c:if>--%>
						<!-- 상품명 --><td style="text-align:center;">
						<c:choose>
							<c:when test="${list.prodCd eq 'QS'}">대명D라이프(150회)</c:when>
							<c:when test="${list.prodCd eq 'QT'}">대명D라이프(200회)</c:when>
							<c:otherwise>${list.prdctNm}</c:otherwise>
						</c:choose>
					</td>
						<!-- 고유번호 --><td style="text-align:center;">${list.cstmrUnqNum}</td>
						<!-- 고객 연락처(핸드폰) --><td style="text-align:center;">${list.hpShort}</td>
						<!-- 판매자 소속 --><td style="text-align:center;">${list.sllrPart}</td>
						<!-- 판매자 번호 --><td style="text-align:center;">${list.sllrNum}</td>
						<!-- 상담신청일 --><td style="text-align:center;">${egov:convertDate(list.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm', '')}</td>
						<!-- 가입일 --><td style="text-align:center;">${list.joinDt}</td>
						<!-- 상담현황  --><td style="text-align:center;">${list.callStts}</td>
						<!-- 가입상태 -->
						<td style="text-align:center;">
							<c:if test="${fn:length(list.accntNo) > 0 and list.trueCount == 0 and  list.accStat eq '정상'}">가입대기</c:if>
							<c:if test="${fn:length(list.accntNo) > 0 and ((list.trueCount > 0 and list.accStat eq '정상') or list.accStat ne '정상') }">${list.accStat}</c:if>
							<c:if test="${fn:length(list.accntNo) <= 0}"></c:if>
						</td>
						<!-- 납입회차 -->
						<td style="text-align:center;">
								${list.trueCount}
						</td>
						<!-- 행사날짜 -->
						<td style="text-align:center;">
							<c:if test="${list.statNo == '5'}">
								<!-- ${list.eventCompDay}	-->
								${list.resnProcDay}
							</c:if>
						</td>
						<!-- 대명 회원번호 --><td style="text-align:center;">${list.accntNo}</td>
<%--						<!-- 주 계약--><td style="text-align:center;"> ${list.mainContType} </td>--%>
<%--						<!-- 메모--><td style="text-align:center;">${list.memo}</td>--%>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		</tbody>
	</table>
</form>

<div style="float:right;">
	<a href="javascript:excel();" class="btn btn-info2">엑셀 다운로드</a>
</div>

<c:if test="${rtnMap.paginationInfo ne null}">
	<div class="paging_all c_box">
		<div class="paging">
			<ul>
				<ui:pagination paginationInfo="${rtnMap.paginationInfo}" type="text" jsFunction="getPageList" />
			</ul>
		</div>
	</div>
</c:if>

<script type="text/javascript">
	//새로 고침
	function getPageNew(){
		//로딩중 띄우기
		$("#overlay, #pleaseWait").show();
		document.location.href = "${pageLink}";
	}

	//리스트 가져오기
	function getPageList()
	{
		var f = document.frm;

		if(arguments.length > 0)
		{
			f.pageIndex.value = arguments[0];
		}
		else
		{
			f.pageIndex.value = 1;
		}

		/* var strtDt = parseInt(jQuery("#strtDt").val().replace(/-/gi, ""));
		var endDt = parseInt(jQuery("#endDt").val().replace(/-/gi, "")); */

		var strtDt = new Date(jQuery("#strtDt").val());
		var endDt = new Date(jQuery("#endDt").val());

		strtDt = strtDt.getTime();
		endDt = endDt.getTime();

		<c:if test="${loginMap.id eq 'dlivesales'}">
			if( f.f.value == '39' && f.q.value.length < 1 ) {
				alert('사번 ID를 입력하세요');
				return;
			}
		</c:if>


		var gapDt = (endDt - strtDt) / 86400000;

		if(strtDt && endDt && strtDt > endDt)
		{
			alert("* 검색 시작일이 종료일보다 클 수 없습니다.");
			return;
		}

		if(jQuery("#q").val() != ''){
			if(jQuery("#strtDt").val() == '' || jQuery("#endDt").val() == ''){
				alert("날짜를 입력해 주시기 바랍니다.");
				return;
			}
			if(gapDt > 90){
				alert("검색기간을 90일 이내로 지정해주시기 바랍니다.");
				return;
			}
		}
		if(jQuery("#q").val() == ''){
			if(gapDt > 31){
				alert("검색기간을 31일 이내로 지정해주시기 바랍니다.");
				return;
			}
		}

		//로딩중 띄우기
		$("#overlay, #pleaseWait").show();

		f.action = "./list.do";
		f.submit();
	}

	function excel()
	{
		var strtDt = parseInt(jQuery("#strtDt").val().replace(/-/gi, ""));
		var endDt = parseInt(jQuery("#endDt").val().replace(/-/gi, ""));

		if(!strtDt || !endDt)
		{
			alert("* 검색 기간을 입력해주세요.");
		}
		else if(strtDt > endDt)
		{
			alert("* 검색 시작일이 종료일보다 클 수 없습니다.");
		}
		else
		{
			var arrStrgDt = jQuery("#strtDt").val().split("-");
			var arrEndDt = jQuery("#endDt").val().split("-");

			var strtDate = new Date(arrStrgDt[0], parseInt(arrStrgDt[1]) - 1, arrStrgDt[2]);
			var endDate = new Date(arrEndDt[0], parseInt(arrEndDt[1]) - 1, arrEndDt[2]);

			if((endDate.getTime() - strtDate.getTime()) / (24 * 60 * 60 * 1000) > 30)
			{
				alert("* 검색 기간을 30일 이하로 입력해주세요.");
			}
			else
			{
				$("#fExcel").val($("#f").val());
				$("#qExcel").val($("#q").val());
				$("#callSttsExcel").val($("#callStts").val());
				$("#strtDtExcel").val($("#strtDt").val());
				$("#endDtExcel").val($("#endDt").val());

				//document.excelFrm.submit();

				//로딩중 띄우고 Submit
				$("#overlay, #pleaseWait").show();
				$.fileDownload($("#excelFrm").prop('action'),{
					httpMethod:"POST",
					data:$("#excelFrm").serialize(),
					successCallback: function(url){
						$("#overlay, #pleaseWait").hide();
					},
					failCallback: function(responseHtml,url){
						$("#overlay, #pleaseWait").hide();
					}
				});
			}
		}
	}

	<c:if test="${loginMap.id ne 'dlivesales'}">
	function view(seq, f, q, pageIndex, callStts, strtDt, endDt, kbNo)
	{
		location.href = "./view.do?idx="+seq+"&f="+f+"&q="+q+"&pageIndex="+pageIndex+"&callStts=" + callStts + "&strtDt=" + strtDt + "&endDt=" + endDt + "&kbNo=" + kbNo;
	}
	</c:if>

	// 엑셀 등록 팝업
	function excelUploadPop()
	{
		setPopup("./excelUploadPop.do", "EXCELUPLOADPOP", 510, 310);
	}

	//로딩바 셋팅
	$(document).ready(function() {
		$("body").prepend('<div id="overlay" class="ui-widget-overlay" style="z-index: 1001; display: none;"></div>');
		$("body").prepend("<div id='pleaseWait' style='display: none;'><img src='/common/images/icon/loading-bar.gif'/></div>");
		$('#pleaseWait').middle();
	});

	//레이어 가운데 정렬
	jQuery.fn.middle = function () {
		this.css("position","absolute");
		this.css("top", '50%');
		this.css("left", '50%');
		this.css("margin-top",- ($(this).outerHeight()) / 2) + "px";
		this.css("margin-left",- ($(this).outerWidth()) / 2) + "px";
		return this;
	}
</script>