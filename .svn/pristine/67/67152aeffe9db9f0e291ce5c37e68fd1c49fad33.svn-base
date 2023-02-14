<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	CMAB2bPrdctCsWrite.jsp
	프로그램 명 : 	온라인 상담신청(B2B) 등록/수정을 한다.
	설명		: 	온라인 상담신청(B2B) 등록/수정을 하는 페이지
	작성자		: 	김필기
	작성일		:	2016.02.24
	수정일자	 			수정자				수정내용
	=====================================================================
	2016.02.24				김필기				최초작성
	######################################################################
-->

<c:set var="info" value="${rtnMap.onlinePrdctCsInfo}" />

<form name="frm" method="post"  action="${egov:decode(info, null, './insert.do', './update.do')}" enctype="multipart/form-data" >
	<input type="hidden" name="seq" value="${info.onlinePrdctCsMstSeq}" />
	<input type="hidden" name="prdct_cs_gb" value="${rtnMap.prdctCsGb}" />

	<input type="" name="prdct_cd" class="productcode" value="" />
	<input type="" name="prdct_nm" class="productname" value="" />
	<input type="" name="prdctDtlNm" class="prdctdtlnm" value="" />
	<input type="" name="prdctDtlCd" class="prdctdtlcd" value="" />
	
	<input type="" name="prdct_cd2" class="productcode" value="" />
	<input type="" name="prdct_nm2" class="productname" value="" />
	<input type="" name="prdctDtlNm2" class="prdctdtlnm" value="" />	
	<input type="" name="prdctDtlCd2" class="prdctdtlcd" value="" />
	
	
	<input type="" name="pay_mtd" value="월납" />

	<h5>● 고객정보 입력</h5>
	<table class="table table-bordered">
		<colgroup>
			<col width="20%" />
			<col width="*" />
		</colgroup>
		<tbody>
			<tr>
				<th>회원이름</th>
				<td><input type="text" name="name" value="${info.name}"/></td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td><input type="text" name="birth" value="${info.birth}"/></td>
			</tr>
			<tr>
				<th>성별</th>
				<td>
					<input type="radio" name="sex" value="m" <c:if test="${info.sex == 'm'}">checked="checked"</c:if> />남
					<input type="radio" name="sex" value="f"  <c:if test="${info.sex == 'f'}">checked="checked"</c:if>/>여
				</td>
			</tr>
			<tr>
				<th>휴대전화</th>
				<td><input type="text" name="hp" value="${info.hp}"/></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="text" name="tel" value="${info.tel}"/></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="email" value="${info.email}"/></td>
			</tr>
			<tr>
				<th>주소(우편물 수령)</th>
				<td>
					<input type="text" id="zipcd1" name="zipcd1" value="" readonly="readonly" class="input-mini" />
					<input type="text" id="adr" name="adr" value="" readonly="readonly"  />
					<input type="button" value="우편번호 찾기" onclick="zipcode('zipcd1', 'adr')" />
					<input type="text" name="adr_dtl" value="" class="input-large"  />
				</td>
			</tr>
			<tr>
				<th>주소(전자제품 설치)</th>
				<td>
					<input type="text" id="zipcd2" name="zipcd2" value="" readonly="readonly" class="input-mini" />
					<input type="text" id="adr2" name="adr2" value="" readonly="readonly"  />
					<input type="button" value="우편번호 찾기" onclick="zipcode('zipcd2', 'adr2')" />
					<input type="text" name="adr_dtl2" value="" class="input-large"  />				
				</td>
			</tr>																				
		</tbody>
	</table>
	
	<h5>● 상품정보 입력</h5>
	<table id="prdctInfo1" class="table table-bordered">
		<colgroup>
			<col style="width:20%;" />
			<col style="width:80%;" />				
		</colgroup>
		<tbody>
			<tr>
				<th style="text-align:center; vertical-align:middle;">
					* 상품선택
				</th>
				<td>
					<select name="prdctGrpCd" class="grpCd" required="B2B상품을 선택해주세요.">
						<option value="">[선택]</option>
						<c:forEach var="prdctGrpList" items="${rtnMap.prdctGrpList}" varStatus="status">
							<option value="${prdctGrpList.prdctGrpCd}" data-productcd="${prdctGrpList.prdctCd}" data-productnm="${prdctGrpList.prdctPrtNm}">${prdctGrpList.prdctPrtNm}</option>
						</c:forEach>									
					</select>					
					
					<select name="" class="detailProduct"">
						<option value="">[상세상품]</option>
					</select>
					
					<c:if test="${rtnMap.b2bMem eq 'mem1'}">
					</c:if>
				</td>				
			</tr>
			<tr>
				<th style="text-align:center; vertical-align:middle;">
					추가부담금
				</th>
				<td>
					<input type="hidden" id="alt" name="alt" value="0" />
					<span id="alt_text"></span>
				</td>
			</tr>
			<tr>
				<th style="text-align:center; vertical-align:middle;">
					* 납입방식
				</th>
				<td class="paymentMethod">상품을 선택해주세요.</td>
			</tr>
			<tr>
				<th>담당자</th>
				<c:if test="${rtnMap.b2bMem eq 'mem1' }">
				<td>
					<input type="radio" name="asgn_yn" value="N" />없음
					<input type="radio" name="asgn_yn" value="Y" />있음
					
					<input type="hidden" name="asgn_cd" value="" class="asgn_cd"  />
					<input type="text" name="asgn_nm" value=""  class="asgn_nm" />
					<input type="button" value="담당자 검색" onclick="searchEmp('prdctInfo1')" />					
				</td>
				</c:if>
				
				<c:if test="${rtnMap.b2bMem eq 'mem2' }">
				<td>
					회사명 <input type="text" name="coCd" value="" />
					부서(지점명) <input type="text" name="dept" value="" />
					사원명 <input type="text" name="stf" value="" />					
				</td>
				</c:if>				
			</tr>

		</tbody>		
	</table>
	
	<table id="prdctInfo2" class="table table-bordered">
		<colgroup>
			<col style="width:20%;" />
			<col style="width:80%;" />				
		</colgroup>
		<tbody>
			<tr>
				<th style="text-align:center; vertical-align:middle;">
					* 상품선택
				</th>
				<td>
					<select name="prdctGrpCd2" class="grpCd" required="B2B상품을 선택해주세요.">
						<option value="">[선택]</option>
						<c:forEach var="prdctGrpList" items="${rtnMap.prdctGrpList}" varStatus="status">
							<option value="${prdctGrpList.prdctGrpCd}" data-productcd="${prdctGrpList.prdctCd}" data-productnm="${prdctGrpList.prdctPrtNm}">${prdctGrpList.prdctPrtNm}</option>
						</c:forEach>									
					</select>					

					<select class="detailProduct">
						<option value="">[상세상품]</option>
					</select>
				</td>				
			</tr>
			<tr>
				<th style="text-align:center; vertical-align:middle;">
					추가부담금
				</th>
				<td>
					<input type="hidden" id="alt2" name="alt2" value="0" />
					<span id="alt_text2"></span>
				</td>
			</tr>
			<tr>
				<th style="text-align:center; vertical-align:middle;">
					* 납입방식
				</th>
				<td class="paymentMethod">월납</td>
			</tr>
			<tr>
				<th>담당자</th>
				<c:if test="${rtnMap.b2bMem eq 'mem1' }">
				<td>
					<input type="radio" name="asgn_yn2" value="N" />없음
					<input type="radio" name="asgn_yn2" value="Y" />있음
					
					<input type="hidden" name="asgn_cd2" value="" class="asgn_cd"   />
					<input type="text" name="asgn_nm2" value="" class="asgn_nm"   />
					<input type="button" value="담당자 검색" onclick="searchEmp('prdctInfo2')" />
				</td>
				</c:if>
				
				<c:if test="${rtnMap.b2bMem eq 'mem2' }">
				<td>
					회사명 <input type="text" name="coCd2" value="" />
					부서(지점명) <input type="text" name="dept2" value="" />
					사원명 <input type="text" name="stf2" value="" />					
				</td>
				</c:if>				
			</tr>

		</tbody>		
	</table>	
	
	<h5>● 계좌정보 입력</h5>
	<table class="table table-bordered">
		<colgroup>
			<col style="width:20%;" />
			<col style="width:80%;" />				
		</colgroup>
		<tbody>
			<tr>
				<th>결제구분</th>
				<td>
					<input type="radio" name="pmt_gb" value="${rtnMap.cms}" />CMS 계좌
					<input type="radio" name="pmt_gb" value="${rtnMap.creditCard}" />신용카드
				</td>
			</tr>
			<tr>
				<th>예금주</th>
				<td><input type="text" name="acnthd" value="" /></td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td><input type="text" name="acnt_birth" value="" /></td>
			</tr>
			<tr>
				<th>연락처</th>
				<td><input type="text" name="acnt_hp" value="" /></td>
			</tr>	
			<tr>
				<th id="pmtCo">은행명</th>
				<td id="pmtCoGb">
					<select id="bank" name="pmt_co_gb" required="은행명을 선택해주세요.">
						<option value="">[선택]</option>
						<c:forEach var="cdlist" items="${rtnMap.cdDtlList.bankGb}" varStatus="status">
							<option value="${cdlist.cd}" <c:if test="${info.pmtCoGb eq cdlist.cd}">selected</c:if>>${cdlist.cdNm}</option>
						</c:forEach>									
					</select>					
				
					<select id="card" name="pmt_co_gb" required="카드사를 선택해주세요.">
						<option value="">[선택]</option>
						<c:forEach var="cdlist" items="${rtnMap.cdDtlList.cardGb}" varStatus="status">
							<option value="${cdlist.cd}" <c:if test="${info.pmtCoGb eq cdlist.cd}">selected</c:if>>${cdlist.cdNm}</option>
						</c:forEach>									
					</select>				
				
				</td>
			</tr>
			<tr>
				<th id="payNo">계좌번호</th>
				<td><input type="text" name="pmt_no" value="" /></td>
			</tr>
			<tr>
				<th>납부일자</th>
				<td>
					<c:forEach var="cdlist" items="${rtnMap.cdDtlList.pmtDayGb}" varStatus="status">
						<input type="radio" name="pmt_day_gb" value="${cdlist.cd}" />${cdlist.cdNm}&nbsp;
					</c:forEach>													
				</td>
			</tr>
			<tr>
				<th>해피콜 가능시간</th>
				<td>
					<select name="happy_call_gb" required="해피콜 가능시간을 선택해주세요.">
						<option value="">[선택]</option>
						<c:forEach var="cdlist" items="${rtnMap.cdDtlList.happyCall}" varStatus="status">
							<option value="${cdlist.cd}" <c:if test="${info.happyCallGb eq cdlist.cd}">selected</c:if>>${cdlist.cdNm}</option>
						</c:forEach>									
					</select>					
				
				</td>
			</tr>					
		</tbody>	
	</table>
</form>

<div style="text-align:right;">
	<c:choose>
		<c:when test="${empty info}">
			<input type="button" value="등록"  class="btn btn-success" onclick="chkForm()">
		</c:when>
		<c:otherwise>
			<input type="button" value="수정"  class="btn btn-primary" onclick="chkForm()">			
		</c:otherwise>
	</c:choose>
	<a href="./list.do" class="btn btn-inverse">목록</a>
</div>

<script type="text/javascript">
		
	var init = function(){
		var seq = $('input[name=seq]').val();
		
		var cms = '${rtnMap.cms}'
			, creditCard = '${rtnMap.creditCard}';
		
		$('.grpCd').each(function(index, obj){
			$(this).change(function(){
				var productCd = $(this).find(':selected').data('productcd')
				, productNm = $(this).find(':selected').data('productnm');

				$('.productcode').eq(index).val(productCd);
				$('.productname').eq(index).val(productNm);
				
				// 상세상품 조회
				$.ajax({
					type : 'POST',
					url : './detailProduct.ajax',
					data : {
						prodCd : productCd
					},
					success : function(data){
						var list = data.list
							, option = "";
							
						$('.detailProduct').eq(index).find('option').not(':first').remove();
						for(var i = 0 ; i < list.length ; i++){
							option = "<option value='"+list[i].modelClCd+"' data-productname='"+list[i].prodJoinPrtNm+"'>"+list[i].prodJoinPrtNm+"</option>";
							$('.detailProduct').eq(index).append(option);	
						}
					}					
				});
				
				// 납입방식 조회
				$.ajax({
					type : 'POST',
					url : './paymentMethod.ajax',
					data : {
						prodCd : productCd
					},
					success : function(data){
						var list = data.list
							//, prodCd = ""
							, monPayAmt = ""
							, exprNo = 1
							//, prodAmt = 0
							, text = ""
							//, value="";
						
						$('.paymentMethod').eq(index).html('');
						for(var i = 0 ; i < list.length ; i++){
							//prodCd = list[i].prodCd;				//상품코드
							monPayAmt = list[i].monPayAmt;	//월납 금액
							exprNo = list[i].exprNo;				//회차
							//prodAmt = list[i].prodAmt;			//일시납 금액
							
							text = "월 " + number_format(monPayAmt) + "원 X " + exprNo + "회" ;

							$('.paymentMethod').eq(index).html(text);
						}
					}
				});				
			});
		});
		
		$('.detailProduct').each(function(index){
			$(this).change(function(){				
				$('.prdctdtlnm').eq(index).val($(this).find(':selected').data('productname'));
				$('.prdctdtlcd').eq(index).val($(this).val());
			});
		});

		$('input[name=asgn_yn]').click(function(){
			if($(this).val() == 'N'){
				$('input[name=asgn_nm]').val('');
			}
		});
		
		var bankSelectObj = $('#bank').remove()
			, cardSelectObj = $('#card').remove();
		
		$('input[name=pmt_gb]').click(function(){
			if($(this).val() == cms){
				$('#pmtCo').text('은행명');
				$('#payNo').text('계좌번호');
				
				$('#pmtCoGb').html(bankSelectObj);
				
			}else if($(this).val() == creditCard){
				$('#pmtCo').text('카드사');
				$('#payNo').text('카드번호');
				$('#pmtCoGb').html(cardSelectObj);
				
			}
		});
		
		// 수정화면일때
		if(seq == ""){
			$('input[name=pmt_gb]').eq(0).trigger('click');	
		}		
	}();
	
	function searchEmp(target){
		window.open('./employeeList.do?target='+target, '담당자검색', 'width=520, height=640');
	}
	
	
	function zipcode(zipcd, adr){
		new daum.Postcode({
		    oncomplete: function(data) {
		    	$('#' + zipcd).val(data.postcode);		// 우편번호
		    	$('#' + adr).val(data.roadAddress);		// 도로명주소
		    }
		}).open();		
	}

	//유효성 체크
	function chkForm()
	{		
		var f = document.frm;	
		
		if(!validate(f))
		{
			return;
		}
		
		var msg = "";
		
		<c:choose>
			<c:when test="${empty info}">
				msg = "등록하시겠습니까?";
			</c:when>
			<c:otherwise>
				msg = "수정하시겠습니까?";
			</c:otherwise>
		</c:choose>
		
		if(confirm(msg))
		{
			f.seq.value = "${info.onlinePrdctCsMstSeq}";
			f.submit();		 
		}		
	}
</script>