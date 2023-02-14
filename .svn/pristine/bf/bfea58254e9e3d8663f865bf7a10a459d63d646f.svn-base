<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!--   
	######################################################################
	파일명 		:	MBAMemInfList.jsp
	프로그램 명 : 	회원 정보 목록을 조회한다.
	설명		: 	회원 정보 목록을 조회하는 페이지
	작성자		: 	허진영
	작성일		:	2016.02.22
	수정일자				수정자				수정내용
	=====================================================================
	2016.02.22				허진영				최초작성
	######################################################################
-->

<form name="frm" method="post" action ="${pageLink}">
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
	<input type="hidden" name="id" value="" />
	
	<div class="well well-small">
		발생일자 :
		<div class="input-append" style="margin-bottom:0px;">
			<input type="text" id="strtDt" name="strtDt" value="${rtnMap.strtDt}" class="datepicker_input input-small" style="text-align:center;" readonly="readonly" />
			<button class="btn" type="button" onclick="jQuery(this).prev().focus();"><i class="icon-calendar"></i></button>
		</div>
		~
		<div class="input-append" style="margin-bottom:0px;">
			<input type="text" id="endDt" name="endDt" value="${rtnMap.endDt}" class="datepicker_input input-small" style="text-align:center;" readonly="readonly" />
			<button class="btn" type="button" onclick="jQuery(this).prev().focus();"><i class="icon-calendar"></i></button>
		</div>
		<select name="f" style="margin-left:15px;">
			<option value="1" <c:if test="${rtnMap.f eq '1'}">selected</c:if>>이름</option>
			<option value="2" <c:if test="${rtnMap.f eq '2'}">selected</c:if>>아이디</option>
		</select>
		<input type="text" name="q" value="${rtnMap.q}" class="inputType" maxlength="15" />
		<a href="javascript:getPageList();" class="btn" title="검색"><i class="icon-search"></i></a>
		<a href="${pageLink}" class="btn " title="전체검색"><i class="icon-refresh"></i></a>
		<div style="overflow:hidden;margin-top:10px;"> 
			<div style="float:left;margin-left: 27px;">
				<span>구분 : </span>
				<select name="flag" id="flag">
					<option value="">전체</option>
					<option value="L" <c:if test="${rtnMap.flag eq 'L'}">selected</c:if>>로그인</option>
					<option value="S" <c:if test="${rtnMap.flag eq 'S'}">selected</c:if>>조회</option>
					<option value="D" <c:if test="${rtnMap.flag eq 'D'}">selected</c:if>>상세</option>
					<option value="C" <c:if test="${rtnMap.flag eq 'C'}">selected</c:if>>등록</option>
					<option value="M" <c:if test="${rtnMap.flag eq 'M'}">selected</c:if>>수정</option>
					<option value="R" <c:if test="${rtnMap.flag eq 'R'}">selected</c:if>>삭제</option>
					<option value="J" <c:if test="${rtnMap.flag eq 'J'}">selected</c:if>>회원가입</option>
					<option value="W" <c:if test="${rtnMap.flag eq 'W'}">selected</c:if>>회원탈퇴</option>
					<option value="E" <c:if test="${rtnMap.flag eq 'E'}">selected</c:if>>엑셀다운</option>
					<option value="U" <c:if test="${rtnMap.flag eq 'U'}">selected</c:if>>엑셀업로드</option>
				</select>
			</div>
			<div style="float:left;margin-left:180px;">
				<span>위치 : </span>
				<select name="pageGubun" id="pageGubun">
					<option value="">전체</option>
					<option value="A" <c:if test="${rtnMap.pageGubun eq 'A'}">selected</c:if>>관리자</option>
					<option value="H" <c:if test="${rtnMap.pageGubun eq 'H'}">selected</c:if>>홈페이지</option>
				</select>
			</div>
		</div>
	</div>
	
	<table class="table table-bordered table-hover table-fixed"><!-- 테이블 클래스 추가 2017-08-03 -->
		<caption style="display: none;">로그 관리</caption>
		<thead>
			<tr>
				<th width="6%" style="vertical-align:middle;">번호</th>
				<th width="8%" style="vertical-align:middle;">ID</th>
				<th width="8%" style="vertical-align:middle;">이름</th>
				<th width="10%" style="vertical-align:middle;">IP</th>
				<th width="7%" style="vertical-align:middle;">위치</th>
				<th width="21%" style="vertical-align:middle;">페이지</th>
				<th width="8%" style="vertical-align:middle;">구분</th>
				<th width="8%" style="vertical-align:middle;">로그인 시간</th>
				<th width="8%" style="vertical-align:middle;">로그아웃 시간</th>
				<th width="8%">발생일자</th>
				<th width="8%">사유</th>
			</tr>
		</thead>
		<tbody>
			<!-- 데이터를 없을때 화면에 메세지를 출력해준다 -->
			<c:if test="${fn:length(rtnMap.list) eq 0}">
				<tr>
					<td class="lt_text3" colspan="10" style="text-align:center">
						<fmt:message key="common.nodata.msg" />
					</td>
				</tr>
			</c:if>
			<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
	 			<tr>
					<td style="text-align:center; cursor:pointer;">
						${list.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}
					</td>
					<td style="text-align:left; cursor:pointer;">
						${list.id}
					</td>
					<td style="text-align:left; cursor:pointer;">
						${list.name}
					</td>
					<td style="text-align:left; cursor:pointer;">
						${list.ip}
					</td>
					<td style="text-align:center; cursor:pointer;">
						${list.pageGubunName}
					</td>
					<td style="text-align:left; cursor:pointer;">
						${list.gubun}
					</td>
					<td style="text-align:center; cursor:pointer;">
						<c:choose>
							<c:when test="${list.flag eq 'E'}">
								${list.flagName}<br />(누적 ${list.cnt}회)
							</c:when>
							<c:otherwise>
								${list.flagName}
							</c:otherwise>
						</c:choose>
					</td>
					<td style="text-align:center; cursor:pointer;">
						${egov:convertDate(list.login, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm:ss', '')}
					</td>
					<td style="text-align:center; cursor:pointer;">
						${egov:convertDate(list.logout, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm:ss', '')}
					</td>
					<td style="text-align:center; cursor:pointer;">
						${egov:convertDate(list.issueDate, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm:ss', '')}
					</td>
					<td style="text-align:center; cursor:pointer;">
						${list.reason}
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</form>

<div style="float:right;">
	<a href="javascript:excelList();" class="btn btn-info">엑셀 다운로드</a>
</div>

<div class="paging_all c_box">
	<div class="paging">
		<ul>
			<ui:pagination paginationInfo="${rtnMap.paginationInfo}" type="text" jsFunction="getPageList" />	
		</ul>
	</div>
</div>

<script type="text/javascript">
	
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
		
		f.action = "./list.do";
		f.submit();
	}
	
	//상세 가져오기
	function selectMemInfDtl(id)
	{
		var f = document.frm;
		
		f.action = "./write.do";
		f.id.value = id;
		f.submit();
	}
	
	//엑셀 다운로드
	function excelList()
	{
		var f = document.frm;
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

			if((endDate.getTime() - strtDate.getTime()) / (24 * 60 * 60 * 1000) > 31)
			{
				alert("* 검색 기간을 1개월 이하로 입력해주세요.");
			}
			else
			{
				f.action = "./excel.do";
				f.submit();
			}
		}
		
	}
	
	//고객서비스 변경일 체크
	function chkPeriod()
	{
		jQuery("#myModal").modal("show");
	}
</script>