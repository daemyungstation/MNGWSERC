<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	CMCPfmcInfList.jsp
	프로그램 명 : 	공연정보 목록을 조회한다.
	설명		: 	공연정보 목록을 조회하는 페이지
	작성자		: 	허진영
	작성일		:	2016.02.11
	수정일자	 			수정자				수정내용
	=====================================================================
	2016.02.11				허진영				최초작성
	######################################################################
-->

<form name="frm" method="post" action="${pageLink}">
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
	<input type="hidden" name="pfmcSeq" value="" />
	
	<div class="well well-small">
		공연구분 : 
		<select name="pfmcGb">
			<option value="">전체</option>
			<option value="free" <c:if test="${rtnMap.pfmcGb eq 'free'}">selected</c:if>>무료공연</option>
			<option value="dscnt" <c:if test="${rtnMap.pfmcGb eq 'dscnt'}">selected</c:if>>할인공연</option>
		</select>	
		&nbsp;&nbsp;
		<select name="f">
			<option value="1" <c:if test="${rtnMap.f eq '1'}">selected</c:if>>공연명</option>
			<option value="2" <c:if test="${rtnMap.f eq '2'}">selected</c:if>>작성자</option>
		</select>
		<input type="text" name="q" value="${rtnMap.q}" class="inputType" maxlength="15" />
		<a href="javascript:getPageList();" class="btn" title="검색"><i class="icon-search"></i></a>
		<a href="${pageLink}" class="btn " title="전체검색"><i class="icon-refresh"></i></a>
	</div>
	
	<table class="table table-bordered table-hover">
		<caption style="display: none;">공연정보 관리</caption>
		<thead>
			<tr>
				<th width="5%"><input type="checkbox" name="all_check"/></th>
				<th width="7%">번호</th>
				<th width="8%">공연구분</th>
				<th width="34%">공연명</th>
				<th width="13%">공연기간</th>
				<th width="13%">작성자</th>
				<th width="12%">작성일</th>
				<th width="8%">예약관리</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${fn:length(rtnMap.list) eq 0}">
					<tr>
						<td class="lt_text3" colspan="8" style="text-align:center">
							<fmt:message key="common.nodata.msg" />
						</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
						<tr> 
							<td style="text-align:center; vertical-align:middle;">
								<input type="checkbox" name="delSeq" value="${list.pfmcSeq}" />
							</td>
							<td style="text-align:center; cursor:pointer; vertical-align:middle;" onclick="selecPfmcInfoDtl('${list.pfmcSeq}');">
								${list.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}
							</td>
							<td style="text-align:center; vertical-align:middle;">
								<c:if test="${list.pfmcGb eq 'free'}">
									무료공연
								</c:if>
								<c:if test="${list.pfmcGb eq 'dscnt'}">
									할인공연
								</c:if>
							</td>
							<td style="text-align:left; cursor:pointer; vertical-align:middle;" onclick="selecPfmcInfoDtl('${list.pfmcSeq}');">
								${egov:tldCutString(list.pfmcNm, '...', '35')}
							</td>
							<td style="text-align:center; cursor:pointer; vertical-align:middle;" onclick="selecPfmcInfoDtl('${list.pfmcSeq}');">
								${egov:convertDate(list.pfmcStrtDt, 'yyyyMMdd', 'yyyy-MM-dd', '')}
								~
								 ${egov:convertDate(list.pfmcEndDt, 'yyyyMMdd', 'yyyy-MM-dd', '')}
							</td>
							<td style="text-align:left; cursor:pointer; vertical-align:middle;" onclick="selecPfmcInfoDtl('${list.pfmcSeq}');">
								${list.regNm}
							</td>
							<td style="text-align:center; cursor:pointer; vertical-align:middle;" onclick="selecPfmcInfoDtl('${list.pfmcSeq}');">
								${egov:convertDate(list.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}
							</td>
							<td style="text-align:center; cursor:pointer; vertical-align:middle;">
								<c:choose>
									<c:when test="${list.pfmcGb eq 'free'}">
										<a href="javascript:selectRsvtnInfoDtl('${list.pfmcSeq}');" class="btn btn-warning">관리</a>
									</c:when>
									<c:otherwise>
										-
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
</form>

<div style="float:left;">
	<a href="javascript:deletePfmcInfList()" class="btn btn-danger">삭제</a>
</div>

<div style="float:right;">
	<a href="./write.do" class="btn btn-success">등록</a>
</div>

<div class="paging_all c_box">
	<div class="paging">
		<ul>
			<ui:pagination paginationInfo="${rtnMap.paginationInfo}" type="text" jsFunction="getPageList" />
		</ul>
	</div>
</div>

<script type="text/javascript">

	//체크박스 jQeury
	jQuery(document).ready(function(){
		//삭제 체크박스 전체 선택 & 해제
		jQuery("input:checkbox[name='all_check']").click(function(){
			if(jQuery(this).is(":checked"))
			{
				jQuery("input:checkbox[name='delSeq']").prop("checked", true);
			}
			else
			{
				jQuery("input:checkbox[name='delSeq']").prop("checked", false);
			}	
		});
		
		//세부를 별도로 선택시 전체 체크 해제 & 전체 체크
		jQuery("input:checkbox[name='delSeq']").click(function(){
			var allChkCnt = jQuery("input:checkbox[name='delSeq']").length;
			var selChkCnt = jQuery("input:checkbox[name='delSeq']:checked").length;
			
			if(allChkCnt==selChkCnt)
			{
				jQuery("input:checkbox[name='all_check']").prop("checked", true);
			}
			else
			{
				jQuery("input:checkbox[name='all_check']").prop("checked", false);
			}
		});
	});

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
	function selecPfmcInfoDtl(pfmcSeq)
	{
		var f = document.frm;
		
		f.action = "./write.do";
		f.pfmcSeq.value = pfmcSeq;
		f.submit();
	}
	
	//선택 삭제하기
	function deletePfmcInfList()
	{
		if(jQuery("input:checkbox[name='delSeq']:checked").length > 0)
		{
			if(confirm("삭제하시겠습니까?")) 
			{
				var f = document.frm;
				
				f.action = "./delete.do";
				f.submit();
			}
		} 
		else 
		{
			alert("삭제할 대상을 선택하세요.");
			return;
		}
	}
	
	//예약관리 페이지 이동
	function selectRsvtnInfoDtl(pfmcSeq)
	{
		var f = document.frm;
		
		f.action = "./rsvtn-write.do";
		f.pfmcSeq.value = pfmcSeq;
		f.submit();
	}
	
</script>