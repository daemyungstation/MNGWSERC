<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>

<c:set var="info" value="${rtnMap}" />
<c:set var="loginMap" value="${admLgnMap}" />
<c:set var="answerList" value="${rtnMap.answerList}" />
<c:set var="opmInfMap" value="${rtnMap.opmInfMap}" />

<jsp:scriptlet>
	pageContext.setAttribute("crlf", "\r\n");
	pageContext.setAttribute("lf", "\n");
	pageContext.setAttribute("cr", "\r");
</jsp:scriptlet>

<form name="frm" method="post"  enctype="multipart/form-data" >
	<input type="hidden" name="idx" value="${info.oscCnslSeq}" />
	<input type="hidden" name="updateSkb" value="" />
	
	<input type="hidden" name="f" value="${f}" />
	<input type="hidden" name="q" value="${q}" />
	<input type="hidden" name="shCallStts" value="${callStts}" />
	<input type="hidden" name="pageIndex" value="${pageIndex}" />
	<input type="hidden" name="strtDt" value="${strtDt}" />
	<input type="hidden" name="endDt" value="${endDt}" />
	
	<h5>고객 정보</h5>

	<table class="table table-bordered">
		<colgroup>
			<col width="20%" />
			<col width="*" />
		</colgroup>
		<tbody>

			<tr>
				<th>고객명</th>
				<td>${info.name}</td>
			</tr>

			<tr>
				<th>고객 연락처(핸드폰)</th>
				<td>${info.hp}</td>
			</tr>

			<tr>
				<th>제휴 상품 1</th>
				<td>${info.prdctNm}</td>
			</tr>

			<tr>
				<th>제휴 상품 2</th>
				<td>${info.prdctNm2}</td>
			</tr>

			<!-- 메모 -->
			<tr>
				<th>메모</th>
				<td>${fn:replace(fn:replace(info.memo, ' ', '&nbsp;'), crlf, '<br />')}</td>
			</tr>
		</tbody>
	</table>

 	<c:if test="${opmInfMap.agentInfoYn eq 'Y'}">
 		<h5>판매사 정보</h5>
		<table class="table table-bordered">
			<colgroup>
				<col width="20%" />
				<col width="*" />
			</colgroup>
			<tbody>

				<tr>
					<th>영업 담당자 소속 (B2B회사명)</th>
					<td>${info.sllrPart}</td>
				</tr>

				<tr>
					<th>영업 담당자 사번 (B2B사원코드 1)</th>
					<td>${info.agentEmpNum}</td>
				</tr>

				<tr>
					<th>담당자명 (B2B사원코드 2)</th>
					<td>${info.b2bEmpCd}</td>
				</tr>

				<tr>
					<th>제품군 (ID NO.)</th>
					<td>${info.productNm}</td>
				</tr>

				<tr>
					<th>제품 모델명 (KB NO.)</th>
					<td>${info.serialNo}</td>
				</tr>

				<tr>
					<th>계약 번호 (주문번호)</th>
					<td>
						${info.contractNo}
						<input type="hidden" id="contractNo" value="${info.contractNo}" />
						<span style="margin-left: 100px;"><a href="javascript:copy_to_clipboard(${info.contractNo});" class="btn">복사</a> </span>
					</td>
					<script type="text/javascript">
						function copy_to_clipboard(text) {
							var textArea = document.createElement("textarea");
							textArea.value = text;
							document.body.appendChild(textArea);
							textArea.select();

							document.execCommand("copy");
							document.body.removeChild(textArea);
						}
					</script>
				</tr>

				<tr>
					<th>영업 담당자 연락처</th>
					<td>${info.agentEmpTel}</td>
				</tr>

			</tbody>
		</table>
 	</c:if>

	<table class="table table-bordered">
		<colgroup>
			<col width="20%" />			
			<col width="*" />
			<col width="15%" />
		</colgroup>
		<tbody>
			<tr>
				<th colspan="3">상담현황</th>
			</tr>
			
			<c:forEach var="list" items="${answerList}" varStatus="status">
				<tr>
					<th>${list.name}</th>
					<td>${fn:replace(fn:replace(list.cntn, ' ', '&nbsp;'), crlf, '<br />')}</td>
					<td>${list.regDtm}</td>
				</tr>
			</c:forEach>
			
			<c:if test="${fn:length(answerList) == 0}">
				<tr>
					<td class="lt_text3" colspan="3" style="text-align:center">등록된 상담현황이 없습니다.</td>
				</tr>
			</c:if>
		</tbody>
	</table>

	<table class="table table-bordered">
		<colgroup>
			<col width="20%" />
			<col width="*" />
		</colgroup>
		<tbody>
			<tr>
				<th colspan="2">답변등록</th>
			</tr>
			<tr>
				<th>상담원명</th>
				<td><input type="text" name="answer" value="" class="" maxlength="20"/> </td>
			</tr>
			<tr>
				<th>상담상태</th>
				<td>
					<select name="call_stts">
						<c:forEach var="cdlist" items="${rtnMap.cdDtlList.callStts}" varStatus="status">
							<option value="${cdlist.cd}">
								<c:choose>
									<c:when test="${cdlist.cdNm eq '가입완료' and loginMap.id eq 'tmontm'}">상담가입완료</c:when>
									<c:otherwise>${cdlist.cdNm}</c:otherwise>
								</c:choose>							
							</option>
						</c:forEach>					
					</select>
				</td>
			</tr>
			<tr>
				<th>상담이력</th>
				<td>
					<textarea name="cntn" style="width:99%; height:100px" maxlength="500"></textarea>
				</td>
			</tr>						
			<tr>
				<td colspan="2" style="text-align:right">
					<input type="button" value="상담이력 등록" class="btn btn-info2" onclick="memoReg()" />
				</td>
			</tr>					
		</tbody>
	</table>
</form>

<div style="text-align:right;">
	<a href="./list.do?f=${f}&q=${q}&callStts=${callStts}&pageIndex=${pageIndex}&strtDt=${strtDt}&endDt=${endDt}" class="btn btn-inverse">목록</a>
</div>

<script type="text/javascript">
	function memoReg()
	{
		var f = document.frm;
		
		if(f.answer.value == "")
		{
			alert("상담원명을 입력하세요.");
			f.answer.focus();
			return false;
		}
		
		if(f.cntn.value == "")
		{
			alert("상담내용을 입력해주세요.");
			f.cntn.focus();
			return false;
		}
	
		if(confirm("상담내용을 등록하시겠습니까?"))
		{
			f.action = "./update.do";
			f.submit();
		}
	}
	
	function changeSkbJoin()
	{
		if(confirm("변경하시겠습니까?"))
		{
			document.frm.updateSkb.value = "Y";
			document.frm.action = "./update.do";
			document.frm.submit();
		}
	}
</script>