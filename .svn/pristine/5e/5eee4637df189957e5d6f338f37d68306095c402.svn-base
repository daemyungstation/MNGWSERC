<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	CSAPrsnCnslWrite.jsp
	프로그램 명 : 	1:1 상담 상세를 조회한다.
	설명		: 	1:1 상담 상세를 조회하는 페이지
	작성자		: 	허진영
	작성일		:	2016.02.07	
	수정일자				수정자				수정내용
	=====================================================================
	2016.02.07				허진영				최초작성
	######################################################################
-->

<c:set var="prsnCnslInfo" value="${rtnMap.prsnCnslInfo}" />

<form name="listFrm" method="post" action="./index.do">
	<input type="hidden" name="f" value="${rtnMap.f}" />
	<input type="hidden" name="q" value="${rtnMap.q}" />
	<input type="hidden" name="inqryCd" value="${rtnMap.inqryCd}" />
	<input type="hidden" name="inqryDtlCd" value="${rtnMap.inqryDtlCd}" />		
	<input type="hidden" name="prcsCd" value="${sPrcsCd}" />
	<input type="hidden" name="strtDt" value="${rtnMap.strtDt}" />	
	<input type="hidden" name="endDt" value="${rtnMap.endDt}" />
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
</form>

<form name="frm" method="post" action="" >
	<input type="hidden" name="prsnCnslSeq" value="" />
	<input type="hidden" name="delSeq" value="" />

	<input type="hidden" name="inqryCd" value="${rtnMap.inqryCd}" />
	<input type="hidden" name="inqryDtlCd" value="${rtnMap.inqryDtlCd}" />
	<input type="hidden" name="sPrcsCd" value="${sPrcsCd}" />
	<input type="hidden" name="strtDt" value="${rtnMap.strtDt}" />	
	<input type="hidden" name="endDt" value="${rtnMap.endDt}" />
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />

	<table class="table table-bordered">
		<caption style="display: none;">1:1 상담 관리</caption>
		<colgroup>
			<col width="33%" />
			<col width="34%" />
			<col width="33%" />	
		</colgroup>
		<tbody>
			<tr>
				<td colspan="3" style="background-color:#f9f9f9">
					<font style="display:inline-block; float:left; margin-left:10px;">
						<b>[${prsnCnslInfo.inqryNm} - ${prsnCnslInfo.inqryDtlNm}] ${prsnCnslInfo.titl}</b>
					</font>
					<font style="display:inline-block; float:right; margin-right:10px;">

					</font>
				</td>
			</tr>
			<tr>
				<td style="padding-left:15px; background-color:#f9f9f9">
					<b>고유번호</b> : ${prsnCnslInfo.unqNo}
				</td>
				<td style="padding-left:15px; background-color:#f9f9f9">
					<b>회원명</b> : ${egov:nvl(prsnCnslInfo.name, prsnCnslInfo.oldRegNm)}
				</td>
				<td style="padding-left:15px; background-color:#f9f9f9">
					<b>작성일</b> : ${egov:convertDate(prsnCnslInfo.regDtm, 'yyyy-MM-dd HH:mm', 'yyyy-MM-dd HH:mm', '')}
				</td>
			</tr>
			<tr>
				<td style="padding-left:15px; background-color:#f9f9f9">
					<b>연락처</b> : ${egov:nvl(prsnCnslInfo.ctel, prsnCnslInfo.oldRegCtel)}
				</td>
				<td style="padding-left:15px; background-color:#f9f9f9">
					<b>이메일</b> : ${egov:nvl(prsnCnslInfo.email, prsnCnslInfo.oldRegEmail)} 
				</td>
				<td style="padding-left:15px; background-color:#f9f9f9">

				</td>
			</tr>
			<tr>
				<td colspan="3" style="height:200px; text-align:left;">
					<jsp:scriptlet>
					    pageContext.setAttribute("cr", "\r");
					    pageContext.setAttribute("lf", "\n");
					    pageContext.setAttribute("crlf", "\r\n");
					</jsp:scriptlet>
					${fn:replace(fn:replace(prsnCnslInfo.cntn, ' ', '&nbsp;'), crlf, '<br />')}
 				</td>
			</tr>
		</tbody>
	</table>
	
	<div style="text-align:right; margin-bottom:20px;">
		<a href="javascript:deletePrnsCnsl();" class="btn btn-danger">삭제</a>
		<a href="javascript:document.listFrm.submit();" class="btn btn-default">취소</a>						
	</div>
	
	<table class="table table-bordered">
		<caption style="display:none;">1:1 상담 답변</caption>
		<colgroup>
			<col width="100%" />
		</colgroup>
		<tbody>
			<tr>
				<td>• 답변</td>
			</tr>
			<tr>
				<td>
					<textarea name="answ" style="height:200px; width:98%;" <c:if test="${prsnCnslInfo.mailSendCnt gt 0}">readonly</c:if>>${prsnCnslInfo.answ}</textarea>
				</td>
			</tr>
		</tbody>
	</table>
</form>

<div class="well well-small" style="margin-bottom:20px;">
	<div style="margin-bottom:5px; font-weight:bold;">※ 답변저장은 메모 기능으로, 저장 내용은 관리자에게만 보여집니다.</div>
	<div style="margin-bottom:5px; font-weight:bold;">※ 확정된 답변에 한해 메일발송을 눌러주세요. 1대1 상담내역에서도 회원이 볼 수 있습니다.</div>
	<div style="font-weight:bold;">※ 메일발송 이후에는 취소할 수 없으니, 반드시 확정된 경우만 눌러주시기 바랍니다.</div>	
</div>

<div style="float:right; margin-bottom:20px;">
	<a href="javascript:updatePrsnCnslAnsw();" class="btn btn-success">답변저장</a>
	<a href="javascript:sendAnwsMail();" class="btn btn-primary">메일발송</a>
</div>

<table class="table table-bordered" style="margin-top:10px;">
	<colgroup>
		<col width="20%" />
		<col width="30%" />
		<col width="50%" />
	</colgroup>
	<tbody>
		<tr>
			<th>확인자</th>
			<td>${rtnMap.prsnCnslLog[0].modNm}</td>
			<td>${egov:convertDate(rtnMap.prsnCnslLog[0].modDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm', '')}</td>
		</tr>
		<tr>
			<th>답변자</th>
			<td>${rtnMap.prsnCnslLog[1].modNm}</td>
			<td>${egov:convertDate(rtnMap.prsnCnslLog[1].modDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm', '')}</td>
		</tr>	
		<tr>
			<th>메일발송</th>
			<td>${rtnMap.prsnCnslLog[2].modNm}</td>
			<td>${egov:convertDate(rtnMap.prsnCnslLog[2].modDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm', '')}</td>
		</tr>	
	</tbody>
</table>
	
<script type="text/javascript">	
	//1:1 상담 답변저장
	function updatePrsnCnslAnsw()
	{
		<c:choose>
			<c:when test="${prsnCnslInfo.mailSendCnt lt 1}">
				if(confirm("저장하시겠습니까?"))
				{
					var f = document.frm;
					
					f.action = "./update.do";
					f.prsnCnslSeq.value = "${prsnCnslInfo.prsnCnslSeq}";
					f.submit();		 
				}
			</c:when>
			<c:otherwise>
				alert("답변 메일발송 후 수정이 불가능합니다.");
			</c:otherwise>
		</c:choose>
	}
	
	//1:1 상담 삭제
	function deletePrnsCnsl()
	{
		if(confirm("삭제하시겠습니까?"))
		{
			var f = document.frm;
			
			f.action = "./delete.do";
			f.delSeq.value = "${prsnCnslInfo.prsnCnslSeq}";
			f.submit();
		}
	}
	
	//1:1 상답 답변메일 발송
	function sendAnwsMail()
	{
		<c:choose>
			<c:when test="${prsnCnslInfo.mailSendCnt gt 0}">
				alert("이미 답변 메일발송을 하였습니다.");
			</c:when>
			<c:when test="${prsnCnslInfo.prcsCd eq '03'}">
				if(confirm("답변 메일발송은 고객과의 신뢰를 위해 1회만 발송이 가능합니다.\n발송하시겠습니까?"))
				{
					var f = document.frm;
					
					f.action = "./send.do";
					f.prsnCnslSeq.value = "${prsnCnslInfo.prsnCnslSeq}";
					f.submit();		 
				}
			</c:when>
			<c:otherwise>
				alert("답변 저장 후 메일발송이 가능합니다.");
			</c:otherwise>
		</c:choose>
	}
	
</script>