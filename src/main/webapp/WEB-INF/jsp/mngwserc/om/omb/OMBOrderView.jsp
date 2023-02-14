<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	OMBOrderView.jsp
	프로그램 명 : 	발주관리 상세화면
	설명		: 	목록
	작성자		: 	김필기
	작성일		:	2016.03.21
	수정일자	 			수정자				수정내용
	=====================================================================
	2016.03.21				김필기				최초작성
	######################################################################
-->

<form id="frm" name="frm" method="post">
	<input type="hidden" name="type" />
	<input type="hidden" name="param" value="" />
	<input type="hidden" name="accntNo" value="${rtnMap.accntNo}" />
	<input type="hidden" name="updateAddr" value="${rtnMap.updateAddr}" />

	<h4></h4>
	<table class="table table-bordered">	
		<colgroup>
			<col style="width:13%" />
			<col style="width:87%" />
		</colgroup>	
		<tr>
			<th>회원번호</th>
			<td>${rtnMap.accntNo}</td>
		</tr>
		<tr>
			<th>회원명</th>
			<td>${rtnMap.memNm}</td>
		</tr>
		<tr>
			<th>상품명</th>
			<td>${rtnMap.prodNm}</td>
		</tr>
		<tr>
			<th>상품모델</th>
			<td>${rtnMap.prodModel}</td>
		</tr>
		<tr>
			<th>제품타입</th>
			<td>
				<select name="prodkind">
					<option value="">선택하세요</option>
					<c:choose>
						<c:when test="${rtnMap.id eq 'lgorder'}">
							<option value="스탠드-기본" <c:if test="${rtnMap.prodKind eq '스탠드-기본'}">selected</c:if>>스탠드-기본</option>
							<option value="회전 벽걸이-기본" <c:if test="${rtnMap.prodKind eq '회전 벽걸이-기본'}">selected</c:if>>회전 벽걸이-기본</option>	
						</c:when>
						<c:when test="${rtnMap.id eq 'csvorder'}">
							<option value="스탠드-기본" <c:if test="${rtnMap.prodKind eq '스탠드-기본'}">selected</c:if>>스탠드-기본</option>						
							<option value="고정 벽걸이-기본" <c:if test="${rtnMap.prodKind eq '고정 벽걸이-기본'}">selected</c:if>>고정 벽걸이-기본</option>
							<option value="고정 벽걸이-7만원" <c:if test="${rtnMap.prodKind eq '고정 벽걸이-7만원'}">selected</c:if>>고정 벽걸이-7만원</option>
							<option value="회전형 벽걸이-기본" <c:if test="${rtnMap.prodKind eq '회전형 벽걸이-기본'}">selected</c:if>>회전형 벽걸이-기본</option>
							<option value="회전 벽걸이-5만원" <c:if test="${rtnMap.prodKind eq '회전 벽걸이-5만원'}">selected</c:if>>회전 벽걸이-5만원</option>
							<option value="회전 벽걸이-9만원" <c:if test="${rtnMap.prodKind eq '회전 벽걸이-9만원'}">selected</c:if>>회전 벽걸이-9만원</option>
						</c:when>
						<c:otherwise>
						
						</c:otherwise>
					</c:choose>
				</select>
			</td>
		</tr>
		<tr>
			<th>핸드폰번호</th>
			<td>
				${rtnMap.cell}
				<input type="hidden" name="cell" value="${rtnMap.cell}" style="width:100px" readonly />
			</td>
		</tr>
		<tr>
			<th>설치전화번호</th>
			<td>${rtnMap.insplPhone}</td>
		</tr>
		<tr>
			<th>주소(집)</th>
			<td>${rtnMap.homeAddr}</td>
		</tr>
		<tr>
			<th>주소(설치주소)</th>
			<td><input type="text" name="inspaddr" style="width:80%;"  value="${rtnMap.insplAddr}" /></td>
		</tr>
		<tr>
			<th>발주일</th>
			<td>${egov:convertDate(rtnMap.orderDt, 'yyyyMMdd', 'yyyy-MM-dd', '')}</td>
		</tr>
		<tr>
			<th>배송상황일</th>
			<td><input type="text" name="reqdate" maxlength="10" value="${egov:convertDate(rtnMap.confirmDt, 'yyyyMMdd', 'yyyy-MM-dd', '')}" class="datepicker_input" style="width:100px;" /></td>
		</tr>
		<tr>
			<th>납품일</th>
			<td><input type="text" name="delvdate" maxlength="10" value="${egov:convertDate(rtnMap.deliveryDt, 'yyyyMMdd', 'yyyy-MM-dd', '')}" class="datepicker_input"  style="width:100px;" /></td>
		</tr>
		<tr>
			<th>보류일</th>
			<td><input type="text" name="holddate" maxlength="10" value="${egov:convertDate(rtnMap.holdDt, 'yyyyMMdd', 'yyyy-MM-dd', '')}" class="datepicker_input"  style="width:100px;" /></td>
		</tr>
		<tr>
			<th>사전해피콜</th>
			<td>
				<c:set var="hpcallYn" value="${egov:nvl(rtnMap.hpcallYn, 'X')}" />
				<select name="opthpcall">
					<option value="O" <c:if test="${hpcallYn eq 'O'}">selected</c:if>>O</option>
					<option value="X" <c:if test="${hpcallYn eq 'X'}">selected</c:if>>X</option>					
				</select>					
			</td>
		</tr>
		<tr>
			<th>특이사항</th>
			<td>
				<textarea name="csetc" style="width:80%;height:80px;">${rtnMap.etc}</textarea>
			</td>
		</tr>
		<tr>
			<th>비고</th>
			<td>
				<textarea name="content" style="width:80%;height:80px;">${rtnMap.note}</textarea>					
			</td>
		</tr>
	</table>
	
	<div style="float:right;">
		<input type="button" name="btn_write" value="등록" class="btn btn-info2" onclick="Reply('rpl')" />
		<input type="button" value="목록" class="btn btn-inverse" onclick="history.back(-1)" />
	</div>		
</form>
	
<script type="text/javascript">
	function Reply(type)
	{
		document.frm.type.value = type;
		
		if(confirm("등록하시겠습니까?")) 
		{
			jQuery.ajax({
				type : "POST",
				url : "./csv_db.ajax",
				data : jQuery("#frm").serialize(),
				success : function(e){
					if(e.errorMsg != "")
					{
						alert(e.errorMsg);
					}
					else
					{
						alert("등록되었습니다.");
						location.reload(true);
					}
				}
			});
		}		
	}	
</script>