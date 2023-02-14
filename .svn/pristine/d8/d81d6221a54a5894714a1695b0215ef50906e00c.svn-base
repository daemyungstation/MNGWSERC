<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!--  
	######################################################################
	파일명 		:	CSAAlncCnslWrite.jsp
	프로그램 명 : 	제휴 상담 상세를 조회한다.
	설명		: 	제휴 상담 상세를 조회하는 페이지
	작성자		: 	허진영
	작성일		:	2016.02.07
	수정일자				수정자				수정내용
	=====================================================================
	2016.02.07				허진영				최초작성
	######################################################################
-->

<c:set var="alncCnslInfo" value="${rtnMap.alncCnslInfo}" />

<form name="listFrm" method="post" action="./index.do">
	<input type="hidden" name="f" value="${rtnMap.f}" />
	<input type="hidden" name="q" value="${rtnMap.q}" />
	<input type="hidden" name="inqryCd" value="${rtnMap.inqryCd}" />
	<input type="hidden" name="prcsCd" value="${sPrcsCd}" />
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />
</form>

<form name="frm" method="post" action="">
	<input type="hidden" name="alncCnslSeq" value="" />
	<input type="hidden" name="delSeq" value="" />

	<input type="hidden" name="f" value="${rtnMap.f}" />
	<input type="hidden" name="q" value="${rtnMap.q}" />
	<input type="hidden" name="inqryCd" value="${rtnMap.inqryCd}" />
	<input type="hidden" name="sPrcsCd" value="${sPrcsCd}" />
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />

	<table class="table table-bordered">
		<caption style="display: none;">제휴 상담 관리</caption>
		<colgroup>
			<col width="33%" />
			<col width="34%" />
			<col width="33%" />	
		</colgroup>
		<tbody>
			<tr>
				<td colspan="3" style="background-color:#f9f9f9">
					<font style="display:inline-block; float:left; margin-left:10px;">
						<b>[${alncCnslInfo.inqryNm}] ${alncCnslInfo.titl}</b>
					</font>
					<font style="display:inline-block; float:right; margin-right:10px;">
						${alncCnslInfo.name}&nbsp;
						${egov:convertDate(alncCnslInfo.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}
					</font>
				</td>
			</tr>
			<tr>
				<td style="padding-left:15px; background-color:#f9f9f9">
					<b>연락처</b> : ${alncCnslInfo.ctel}
				</td>
				<td style="padding-left:15px; background-color:#f9f9f9">
					<b>이메일</b> : ${alncCnslInfo.email} 
				</td>
				<td style="padding-left:15px; background-color:#f9f9f9">
				
				</td>
			</tr>
			<c:if test="${fn:length(rtnMap.fileList) > 0}">
			<tr>
				<td colspan="3" style="padding-left:15px;">
					첨부파일 : 
					<c:forEach var="fileList" items="${rtnMap.fileList}" varStatus="status">
      					<a href="/cmm/fms/FileDown.do?fileId=${fileList.atchFileId}&fileSn=${fileList.fileSeq}" style="<c:if test="${!status.last}">margin-right:15px</c:if>">${fileList.realFileNm}</a>
					</c:forEach>
				</td>
			</tr>
			</c:if>
			<tr>
				<td colspan="3" style="height:200px; text-align:left;">
					<jsp:scriptlet>
					    pageContext.setAttribute("cr", "\r");
					    pageContext.setAttribute("lf", "\n");
					    pageContext.setAttribute("crlf", "\r\n");
					</jsp:scriptlet>
					${fn:replace(fn:replace(alncCnslInfo.cntn, ' ', '&nbsp;'), crlf, '<br />')}
 				</td>
			</tr>
		</tbody>
	</table>
		
	<div style="text-align:right; margin-bottom:20px;">
		<a href="javascript:deleteAlncCnsl();" class="btn btn-danger">삭제</a>
		<a href="javascript:document.listFrm.submit();" class="btn btn-default">취소</a>						
	</div>
		
	<table class="table table-bordered">
		<caption style="display:none;">제휴 상담 답변</caption>
		<colgroup>
			<col width="100%" />
		</colgroup>
		<tbody>
			<tr>
				<td>• 상담이력</td>
			</tr>
			<tr>
				<td>
					<textarea name="answ" style="width:98%; height:200px;">${alncCnslInfo.answ}</textarea>
				</td>
			</tr>
		</tbody>
	</table>
</form>

<div style="float:left">
	<b>※ 해당 건에 대한 업무처리를 한 뒤 상담이력을 저장하시면 완료처리가 됩니다.</b>	
</div>

<div style="float:right;">
	<a href="javascript:updateAlncCnslAnsw();" class="btn btn-success">상담이력 저장</a>
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
			<td>${rtnMap.alncCnslLog[0].modNm}</td>
			<td>${egov:convertDate(rtnMap.alncCnslLog[0].modDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm', '')}</td>
		</tr>
		<tr>
			<th>답변자</th>
			<td>${rtnMap.alncCnslLog[1].modNm}</td>
			<td>${egov:convertDate(rtnMap.alncCnslLog[1].modDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm', '')}</td>
		</tr>	
	</tbody>
</table>
	
<script type="text/javascript">

	//제휴 상담 상담이력 저장
	function updateAlncCnslAnsw()
	{
		if(confirm("저장하시겠습니까?"))
		{
			var f = document.frm;
			
			f.action = "./update.do";
			f.alncCnslSeq.value = "${alncCnslInfo.alncCnslSeq}";
			f.submit();		 
		}
	}
	
	//제휴 상담 삭제
	function deleteAlncCnsl()
	{
		if(confirm("삭제하시겠습니까?"))
		{
			var f = document.frm;
			
			f.action = "./delete.do";
			f.delSeq.value = "${alncCnslInfo.alncCnslSeq}";
			f.submit();
		}
	}

</script>