<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!--   
	######################################################################
	파일명 		:	CSAJoinCnslWrite.jsp
	프로그램 명 : 	가입 상담 상세를 조회한다.
	설명		: 	가입 상담 상세를 조회하는 페이지
	작성자		: 	허진영
	작성일		:	2016.02.07
	수정일자				수정자				수정내용
	=====================================================================
	2016.02.07				허진영				최초작성
	######################################################################
-->

<c:set var="joinCnslInfo" value="${rtnMap.joinCnslInfo}" />

<form name="listFrm" method="post" action="./index.do">
	<input type="hidden" name="f" value="${rtnMap.f}" />
	<input type="hidden" name="q" value="${rtnMap.q}" />
	<input type="hidden" name="inqryCd" value="${rtnMap.inqryCd}" />
	<input type="hidden" name="prcsCd" value="${sPrcsCd}" />
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
</form>

<form name="frm" method="post" action="">
	<input type="hidden" name="joinCnslSeq" value="" />
	<input type="hidden" name="delSeq" value="" />

	<input type="hidden" name="f" value="${rtnMap.f}" />
	<input type="hidden" name="q" value="${rtnMap.q}" />
	<input type="hidden" name="inqryCd" value="${rtnMap.inqryCd}" />
	<input type="hidden" name="sPrcsCd" value="${sPrcsCd}" />
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />

	<table class="table table-bordered">
		<caption style="display: none;">가입 상담 관리</caption>
		<colgroup>
			<col width="33%" />
			<col width="34%" />
			<col width="33%" />	
		</colgroup>		
		<tbody>
			<tr>
				<td colspan="3" style="background-color:#f9f9f9">
					<font style="display:inline-block; float:left; margin-left:10px;">
						<b>[${joinCnslInfo.inqryNm}] ${joinCnslInfo.titl}</b>
					</font>
					<font style="display:inline-block; float:right; margin-right:10px;">
						${joinCnslInfo.name}&nbsp;
						${egov:convertDate(joinCnslInfo.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}
					</font>
				</td>
			</tr>
			<tr>
				<td style="padding-left:15px; background-color:#f9f9f9">
					<b>연락처</b> : ${joinCnslInfo.ctel}
				</td>
				<td style="padding-left:15px; background-color:#f9f9f9">
					<b>이메일</b> : ${joinCnslInfo.email} 
				</td>
				<td style="padding-left:15px; background-color:#f9f9f9">
					<b>통화가능시간</b> : 
					${egov:convertDate(joinCnslInfo.telAbleDt, 'yyyyMMdd', 'yyyy-MM-dd', '')}&nbsp;
					${egov:convertDate(joinCnslInfo.telAbleStrtTime, 'HHmm', 'HH:mm', '')} ~ 
					${egov:convertDate(joinCnslInfo.telAbleEndTime, 'HHmm', 'HH:mm', '')}&nbsp;
				</td>
			</tr>
			<tr>
				<td colspan="3" style="height:200px; text-align:left;">
					<jsp:scriptlet>
					    pageContext.setAttribute("cr", "\r");
					    pageContext.setAttribute("lf", "\n");
					    pageContext.setAttribute("crlf", "\r\n");
					</jsp:scriptlet>
					${fn:replace(fn:replace(joinCnslInfo.cntn, ' ', '&nbsp;'), crlf, '<br />')}
 				</td>
			</tr>
		</tbody>
	</table>
	
	<div style="text-align:right; margin-bottom:20px;">
		<a href="javascript:deleteJoinCnsl();" class="btn btn-danger">삭제</a>
		<a href="javascript:document.listFrm.submit();" class="btn btn-default">취소</a>						
	</div>
	
	<table class="table table-bordered">
		<caption style="display:none;">가입 상담 답변</caption>
		<colgroup>
			<col width="100%" />
		</colgroup>
		<tbody>
			<tr>
				<td>• 상담이력</td>
			</tr>
			<tr>
				<td>
					<textarea name="answ" style="height:200px; width:98%;">${joinCnslInfo.answ}</textarea>
				</td>
			</tr>
		</tbody>
	</table>
</form>

<div style="float:left">
	<b>※ 해당 건에 대한 업무처리를 한 뒤 상담이력을 저장하시면 완료처리가 됩니다.</b>	
</div>

<div style="float:right;">
	<a href="javascript:updateJoinCnslAnsw();" class="btn btn-success">상담이력 저장</a>
</div>

<table class="table table-bordered" style="margin-top:80px;">
	<colgroup>
		<col width="20%" />
		<col width="30%" />
		<col width="50%" />
	</colgroup>
	<tbody>
		<tr>
			<th>확인자</th>
			<td>${rtnMap.joinCnslLog[0].modNm}</td>
			<td>${egov:convertDate(rtnMap.joinCnslLog[0].modDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm', '')}</td>
		</tr>
		<tr>
			<th>답변자</th>
			<td>${rtnMap.joinCnslLog[1].modNm}</td>
			<td>${egov:convertDate(rtnMap.joinCnslLog[1].modDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm', '')}</td>
		</tr>	
	</tbody>
</table>
	
<script type="text/javascript">

	//가입 상담 상담이력 저장
	function updateJoinCnslAnsw()
	{
		if(confirm("저장하시겠습니까?"))
		{
			var f = document.frm;
			
			f.action = "./update.do";
			f.joinCnslSeq.value = "${joinCnslInfo.joinCnslSeq}";
			f.submit();		 
		}
	}
	
	//가입 상담 삭제
	function deleteJoinCnsl()
	{
		if(confirm("삭제하시겠습니까?"))
		{
			var f = document.frm;
			
			f.action = "./delete.do";
			f.delSeq.value = "${joinCnslInfo.joinCnslSeq}";
			f.submit();
		}
	}
	
</script>