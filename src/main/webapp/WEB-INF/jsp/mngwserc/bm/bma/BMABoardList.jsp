<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	BMABoardList.jsp
	프로그램 명 : 	게시판 통합 리스트
	설명		: 	게시판 관리에서 생성한 게시판 통합 리스트
	작성자		: 	김대환
	작성일		:	2016.02.11
	수정일자				수정자					수정내용
	=====================================================================
	2016.02.11				김대환					최초작성
	######################################################################
-->

<jsp:useBean id="now" class="java.util.Date" />

<form name="frm" method="post" action="${pageLink}">
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
	<input type="hidden" name="idx" value="" />
	<input type="hidden" name="blind" value="" />

	<div class="well well-small">
		<c:if test="${mstInfo.categoryYn eq 'Y'}">
			구분 :
			<span id="categoryId">
		
			</span>&nbsp;&nbsp;
			<script type="text/javascript" src="/common/js/mngwserc/bm/bma/BMABoardCtgr.js?{'select':'categoryId', 'topNode':'${mstInfo.categoryId}', 'id':'${rtnMap.categoryId}'}"></script>
		</c:if>
		노출여부 :
		<select name="useYn">
			<option value="">전체</option>
			<option value="Y" <c:if test="${rtnMap.useYn eq 'Y'}">selected</c:if>>Y</option>
			<option value="N" <c:if test="${rtnMap.useYn eq 'N'}">selected</c:if>>N</option>				
		</select>
		&nbsp;&nbsp;
		<select name="f">
			<option value="1" <c:if test="${rtnMap.f eq '1'}">selected</c:if>>제목</option>
			<option value="2" <c:if test="${rtnMap.f eq '2'}">selected</c:if>>내용</option>
			<option value="3" <c:if test="${rtnMap.f eq '3'}">selected</c:if>>작성자</option>
		</select>
		<input type="text" name="q" value="${rtnMap.q}" class="inputType" maxlength="15" />
		<a href="javascript:getPageList();" class="btn" title="검색"><i class="icon-search"></i></a>
		<a href="${pageLink}" class="btn btn-default" title="전체검색"><i class="icon-refresh"></i></a>
	</div>
	
	<table class="table-bordered table-hover table tdC">
		<caption style="display: none;">게시판 목록</caption>
		<thead>
			<tr>
				<th width="3%"><input type="checkbox" name="all_check"></th>
				<th width="5%">번호</th>
				<c:if test="${mstInfo.categoryYn eq 'Y'}">
					<th width="10%">구분</th>
					<th width="10%">분류</th>
				</c:if>
				<th width="*">제목</th>
				<c:if test="${mstInfo.periodYn eq 'Y'}">
				<th width="13%">기간</th>
				</c:if>
				<th width="10%">작성자</th>
				<th width="9%">작성일</th>
				<th width="6%">조회수</th>
				<th width="5%">노출</th>
			</tr>
	 	</thead>
	 	<tbody>
	 		<c:if test="${fn:length(rtnMap.noticeList) eq 0 and fn:length(rtnMap.list) eq 0}">
				<tr>
					<td class="lt_text3" colspan="10" style="text-align:center">
						<fmt:message key="common.nodata.msg" />
					</td>
				</tr>
			</c:if>
			<c:forEach var="noticeList" items="${rtnMap.noticeList}" varStatus="status">
				<tr>
					<td style="text-align:center;">
						<input type="checkbox" name="delidx" value="${noticeList.idx}" />
					</td>
					<td style="text-align:center; cursor:pointer;" onclick="getView('${noticeList.idx}');">
						공지
					</td> 
					<c:if test="${mstInfo.categoryYn eq 'Y'}">
						<td style="text-align:center; cursor:pointer;" onclick="getView('${noticeList.idx}');">
							${fn:split(noticeList.categoryNm, '-')[0]}
						</td>
						<td style="text-align:center; cursor:pointer;" onclick="getView('${noticeList.idx}');">
							${egov:nvl(fn:split(noticeList.categoryNm, '-')[1], '-')}
						</td>
					</c:if>
					<td style="text-align:left; cursor:pointer;" onclick="getView('${noticeList.idx}');">
						<span style="${egov:decode(noticeList.useYn, 'N', 'text-decoration:line-through', '')}">
				    		${egov:tldCutString(noticeList.title, '...', mstInfo.listTitleCnt)}
				    	</span>		
						<c:if test="${egov:diffOfDate(noticeList.regdate) ge mstInfo.newCnt * -1}">
				    		<img src="/egov/img/new_icon.gif" />
				    	</c:if>
						<c:if test="${noticeList.openYn eq 'N'}">
				    		<i class="icon-lock"></i>
				    	</c:if>
						<c:if test="${not empty noticeList.atchFileId}">
							<i class="icon-file"></i>
						</c:if>
					</td>
					<c:if test="${mstInfo.periodYn eq 'Y'}">
						<td style="text-align:center; cursor:pointer;" onclick="getView('${noticeList.idx}');">
							<c:choose>
								<c:when test="${noticeList.odtmYn eq 'Y'}">
									상시
								</c:when>
								<c:otherwise>
									${egov:convertDate(noticeList.startDt, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')} 
									~ 
									${egov:convertDate(noticeList.endDt, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')} 
								</c:otherwise>
							</c:choose>
						</td>
					</c:if>		    
					<td style="text-align:left; cursor:pointer;" onclick="getView('${noticeList.idx}');">
						${noticeList.regname}
					</td>
					<td style="text-align:center; cursor:pointer;" onclick="getView('${noticeList.idx}');">
						${egov:convertDate(noticeList.regdate, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}
					</td>
					<td style="text-align:center; cursor:pointer;" onclick="getView('${noticeList.idx}');">
						${noticeList.readCnt}
					</td>
					<td style="text-align:center; cursor:pointer;" onclick="getView('${noticeList.idx}');">
						${noticeList.useYn}
					</td>
				</tr>
			</c:forEach>
			<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
				<tr>
					<td style="text-align:center;">
						<input type="checkbox" name="delidx" value="${list.idx}" />
					</td>
					<td style="text-align:center; cursor:pointer;" onclick="getView('${list.idx}');">
						${list.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}
					</td> 
					<c:if test="${mstInfo.categoryYn eq 'Y'}">
						<td style="text-align:center; cursor:pointer;" onclick="getView('${list.idx}');">
							${fn:split(list.categoryNm, '-')[0]}
						</td>
						<td style="text-align:center; cursor:pointer;" onclick="getView('${list.idx}');">
							${egov:nvl(fn:split(list.categoryNm, '-')[1], '-')}
						</td>
					</c:if>
					<td style="text-align:left; cursor:pointer;" onclick="getView('${list.idx}');">
				    	<span style="${egov:decode(list.useYn, 'N', 'text-decoration:line-through', '')}">
				    		${egov:tldCutString(list.title, '...', mstInfo.listTitleCnt)}
				    	</span>	
						<c:if test="${egov:diffOfDate(egov:nvl(list.regdate, list.regdate)) ge mstInfo.newCnt * -1}">
				    		<img src="/egov/img/new_icon.gif" />
				    	</c:if>
						<c:if test="${list.openYn eq 'N'}">
				    		<i class="icon-lock"></i>
				    	</c:if>
						<c:if test="${not empty list.atchFileId}">
							<i class="icon-file"></i>
						</c:if>
					</td>
					<c:if test="${mstInfo.periodYn eq 'Y'}">
						<td style="text-align:center; cursor:pointer;" onclick="getView('${list.idx}');">
							<c:choose>
								<c:when test="${list.odtmYn eq 'Y'}">
									상시
								</c:when>
								<c:otherwise>
									${egov:convertDate(list.startDt, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')} 
									~ 
									${egov:convertDate(list.endDt, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}
								</c:otherwise>
							</c:choose>
						</td>
					</c:if>		    
					<td style="text-align:left; cursor:pointer;" onclick="getView('${list.idx}');">
						${list.regname}
					</td>
					<td style="text-align:center; cursor:pointer;" onclick="getView('${list.idx}')">
						${egov:convertDate(list.regdate, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')} 
					</td>
					<td style="text-align:center; cursor:pointer;" onclick="getView('${list.idx}')">
						${list.readCnt}
					</td>
					<td style="text-align:center; cursor:pointer;" onclick="getView('${list.idx}')">
						${list.useYn}
					 </td>
				</tr>
			</c:forEach>
		</tbody>	  
	</table>
</form>

<div style="float:left;">
	<a href="javascript:delDate();" class="btn btn-danger">삭제</a>
	<c:if test="${mstInfo.approvalAuthority gt 0 and mstInfo.approvalAuthority le admLgnMap.authCd}">
		<a href="javascript:setBlind('Y');" class="btn btn-primary">승인</a>
		<a href="javascript:setBlind('N');" class="btn btn-warning">미승인</a>
	</c:if>
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
				jQuery("input:checkbox[name='delidx']").prop("checked", true);
			}
			else
			{
				jQuery("input:checkbox[name='delidx']").prop("checked", false);
			}	
		});
		
		//세부를 별도로 선택시 전체 체크 해제 & 전체 체크
		jQuery("input:checkbox[name='delidx']").click(function(){
			var allChkCnt = jQuery("input:checkbox[name='delidx']").length;
			var selChkCnt = jQuery("input:checkbox[name='delidx']:checked").length;
			
			if(allChkCnt == selChkCnt)
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
	
	//보기
	function getView(idx)
	{
		var f = document.frm;
		
		f.idx.value = idx;	
		f.action = "./view.do";
		f.submit();
	}
	
	//삭제
	function delDate()
	{
		if(jQuery("input:checkbox[name='delidx']:checked").length > 0)
		{
			if(confirm("삭제하시겠습니까?"))
			{				
				var f = document.frm;
				
				f.action = "./deleteMulti.do";
				f.submit();
			}
		}
		else
		{
			alert("삭제할 대상을 선택하세요.");
			return;
		}
	}
	
	//숨김
	function setBlind(blind)
	{
		var msg = "";
		
		if(blind == "Y")
		{
			msg = "승인";
		}
		else
		{
			msg = "미승인";
		}
		
		if(jQuery("input:checkbox[name='delidx']:checked").length > 0)
		{
			if(confirm(msg + "처리 하시겠습니까?"))
			{
				var f = document.frm;
				
				f.blind.value = blind;
				f.action = "./blindMulti.do";
				f.submit();
			}
		}
		else
		{
			alert(msg + "할 대상을 선택하세요.");
			return;
		}
	}
	
</script>	