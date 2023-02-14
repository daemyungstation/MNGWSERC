<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!--   
	######################################################################
	파일명 		:	CMFChkReqnList.jsp
	프로그램 명 : 	확인요청 내역 목록을 조회한다.
	설명		: 	확인요청 내역 목록을 조회하는 페이지
	작성자		: 	허진영
	작성일		:	2016.02.11
	수정일자				수정자				수정내용
	=====================================================================
	2016.02.11				허진영				최초작성
	######################################################################
-->

<form name="frm" method="post" action ="${pageLink}">
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
	<input type="hidden" name="reqnSeq" value="" />
	
	<div class="well well-small">
		요청구분 : 
		<select name="reqnGb">
			<option value="">전체</option>
			<option value="01">고유번호</option>
			<option value="02">가입상품</option>
		</select>
		&nbsp;&nbsp;
		현황 : 
		<select name="prcsCd">
			<option value="">전체</option>
			<c:forEach var="cdlist" items="${rtnMap.cdDtlList.processType}" varStatus="status">
				<option value="${cdlist.cd}" <c:if test="${rtnMap.prcsCd eq cdlist.cd}">selected</c:if>>${cdlist.cdNm}</option>				
			</c:forEach>
			<option value="4" <c:if test="${rtnMap.prcsCd eq '4'}">selected</c:if>>매칭불가</option>			
		</select>
		&nbsp;&nbsp;
		<select name="f">
			<option value="1" <c:if test="${rtnMap.f eq '1'}">selected</c:if>>이름</option>
			<option value="2" <c:if test="${rtnMap.f eq '2'}">selected</c:if>>아이디</option>
			<option value="3" <c:if test="${rtnMap.f eq '3'}">selected</c:if>>SSO 통합아이디</option>
		</select>
		<input type="text" name="q" value="${rtnMap.q}" class="inputType" maxlength="15" />
		<a href="javascript:getPageList();" class="btn" title="검색"><i class="icon-search"></i></a>
		<a href="${pageLink}" class="btn " title="전체검색"><i class="icon-refresh"></i></a>
	</div>
	
	<table class="table table-bordered table-hover">
		<caption style="display: none;">확인요청 내역 관리</caption>
		<thead>
			<tr>
				<th width="3%"><input type="checkbox" name="all_check"/></th>
				<th width="6%">번호</th>
				<th width="10%">구분</th>
				<th width="8%">회원명</th>
				<th width="13%">아이디</th>
				<th width="13%">SSO 통합아이디</th>
				<th width="9%">고유번호</th>
				<th width="10%">확인요청일</th>
				<th width="10%">접수일</th>
				<th width="10%">완료일</th>
				<th width="8%">현황</th>
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
					<td style="text-align:center; vertical-align:middle;">
						<input type="checkbox" name="delSeq" value="${list.reqnSeq}" />
					</td>
					<td style="text-align:center; vertical-align:middle;">
						${list.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}
					</td>
					<td style="text-align:center; vertical-align:middle;">
						<c:choose>
							<c:when test="${list.reqnGb eq '01'}">
								고유번호 확인 필요
							</c:when>
							<c:when test="${list.reqnGb eq '02'}">
								가입상품 확인 필요
							</c:when>
						</c:choose>
					</td>
					<td style="text-align:left; vertical-align:middle;">
						${list.name}
					</td>
					<td style="text-align:left; vertical-align:middle;">
						${list.id}
					</td>
					<td style="text-align:left; vertical-align:middle;">
						${list.ssoId}
					</td>
					<td style="text-align:center; vertical-align:middle;">
						${egov:decode(list.unqNo, null, '-', list.unqNo)}
					</td>
					<td style="text-align:center; vertical-align:middle;">
						${egov:convertDate(list.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}
					</td>
					<td style="text-align:center; vertical-align:middle;">
						${egov:nvl(egov:convertDate(list.acptDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', ''), '-')}
					</td>
					<td style="text-align:center; vertical-align:middle;">
						${egov:nvl(egov:convertDate(list.compDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', ''), '-')}
					</td>
					<td style="text-align:center; vertical-align:middle;">
						<select name="prscCd" onchange="updatePrcsCd(this, '${list.reqnSeq}', '${list.prcsCd}');">
							<c:forEach var="cdlist" items="${rtnMap.cdDtlList.processType}" varStatus="status">
								<option value="${cdlist.cd}" <c:if test="${list.prcsCd eq cdlist.cd}">selected</c:if>>${cdlist.cdNm}</option>
							</c:forEach>
							<option value="4" <c:if test="${list.prcsCd eq '4'}">selected</c:if>>매칭불가</option>
						</select>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</form>

<form name="frm2" method="post" >
</form>

<div style="float:left;">
	<a href="javascript:deleteChkReqnList();" class="btn btn-danger">삭제</a>
</div>
<div style="float:right;">
	<select id="allPrcsCd">
		<c:forEach var="cdlist" items="${rtnMap.cdDtlList.processType}" varStatus="status">
			<option value="${cdlist.cd}">${cdlist.cdNm}</option>
		</c:forEach>
		<option value="4">매칭불가</option>
	</select> 
	<input type="button" value="현황변경" class="btn btn-primary"  onclick="changePrcsCd()" />
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
	
	//선택 삭제하기
	function deleteChkReqnList()
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
	
	//처리현황을 수정한다.
	function updatePrcsCd(obj, reqnSeq, prcsCd)
	{
		if(confirm("현황을 변경하시겠습니까?"))
		{
			jQuery.post("./prcs-update.ajax",
				{
					"reqnSeq" : reqnSeq, 
					"prcsCd" : jQuery(obj).val() 
				},
				function(r)
				{
					var status = r.status;
					
					if(status == "Y") 
					{
						alert("변경되었습니다.");
						window.location.reload(true);
					}
				}
			).fail(function(){
				alert("잠시후 다시 시도 바랍니다.");
			});
		}
		else
		{
			jQuery(obj).find("option[value='"+prcsCd+"']").prop("selected", true);
		}
	}
	
	// 처리현황을 수정한다(선택한 데이터)
	function changePrcsCd(){
		if(jQuery("input:checkbox[name='delSeq']:checked").length > 0)
		{
			if(confirm("현황을 변경하시겠습니까?")) 
			{
				$('form[name=frm2]').append('<input type="hidden" name="prcsCd" value="'+$("#allPrcsCd").val()+'" />');
				$.each($("input:checkbox[name='delSeq']:checked"), function(index, obj){					
					$('form[name=frm2]').append('<input type="hidden" name="delSeq" value="'+$(obj).val()+'" />');
				});
				
				$.ajax({
					type : 'post',
					url : './prcs-update-all.ajax',
					data : $('form[name=frm2]').serialize(),
					success : function(r){
						var status = r.status;
						
						if(status == "Y") 
						{
							alert("변경되었습니다.");
							window.location.reload(true);
						}
					}
				})
			}
		} 
		else 
		{
			alert("변경할 대상을 선택하세요.");
			return;
		}
	}	
	
</script>