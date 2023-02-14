<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	COCAdmRoleWrite.jsp
	프로그램 명 : 	관리자 ROLE 관리
	설명		: 	작성
	작성자		: 	김대환
	작성일		:	2015.11.13
	수정일자				수정자				수정내용
	=====================================================================
	2015.11.13				김대환				최초작성
	######################################################################
-->

<c:set var="roleInfo" value="${rtnMap.roleInfo}" />

<script type="text/javascript" src="/egov/js/jstree/jquery.jstree.js"></script>
<script type="text/javascript" src="/egov/js/jstree/jquery.hotkeys.js"></script>
<script type="text/javascript" src="/egov/js/jstree/jquery.cookies.js"></script>
<script type="text/javascript" src="/common/js/mngwserc/co/coc/COCAdmRole.js?{'topNode':'1', 'did':'${roleInfo.roleCd}'}"></script>

<form name="frm" method="post" action="${egov:decode(roleInfo, null, './insert.do', './update.do')}">
	<input type="hidden" name="mUndetermined" value="" />
	<input type="hidden" name="mChecked" value="" />	

	<div id="divCategoris" style="width:30%; height:570px; float:left; margin-right:5%; overflow-y:auto;">
		
	</div>
	
	<table class="table table-bordered" style="width:60%;">
		<colgroup>
			<col width="30%" />
			<col width="70%" />
		</colgroup>
		<tbody>
			<tr>
				<th style="text-align:center;vertical-align:middle;">
					* 부서명(ROLE)
				</th>
				<td style="text-align:left;">
					<c:choose>
						<c:when test="${not empty roleInfo}">
							<c:choose>
								<c:when test="${rtnMap.roleGb eq 'AUTH'}">
									${roleInfo.roleNm}
									<input type="hidden" name="roleNm" value="${roleInfo.roleNm}" />
									<input type="hidden" name="roleCd" value="${roleInfo.roleCd}" />
								</c:when>
								<c:otherwise>
									<input type="text" name="roleNm" value="${roleInfo.roleNm}" required="ROLE 명을 입력해주세요." maxlength="20" />
									<input type="hidden" name="roleCd" value="${roleInfo.roleCd}" />
								</c:otherwise>
							</c:choose>
						</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${rtnMap.roleGb eq 'AUTH'}">
									<select name="roleCd" onchange="jQuery(this).next().val(jQuery(this).children('option:selected').text())">
										<c:forEach var="userTypelist" items="${rtnMap.admUserTypeList}" varStatus="status">
											<option value="${userTypelist.cd}" <c:if test="${roleInfo.roleCd eq userTypelist.cd}">selected</c:if>>${userTypelist.cdNm}</option>
										</c:forEach>
									</select>
									<input type="hidden" name="roleNm" value="${egov:decode(roleInfo, null, rtnMap.admUserTypeList[0].cdNm, roleInfo.roleNm)}" />
								</c:when>
								<c:otherwise>
									<input type="text" name="roleNm" value="${roleInfo.roleNm}" required="ROLE 명을 입력해주세요." maxlength="20" />
									<input type="hidden" name="roleCd" value="${roleInfo.roleCd}" />
								</c:otherwise>
							</c:choose>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</tbody>
	</table>
</form>

<table style="width:60%;">
	<colgroup>
		<col width="30%" />
		<col width="70%" />
	</colgroup>
	<tbody>
		<tr>
			<td style="text-align:right;">
				<c:choose>
					<c:when test="${empty roleInfo}">
						<a href="javascript:chkForm();" class="btn btn-success">등록</a>
					</c:when>
					<c:otherwise>
						<a href="javascript:chkForm();" class="btn btn-primary">수정</a>
						<!-- <a href="javascript:getDelete();" class="btn btn-danger">삭제</a> -->
					</c:otherwise>
				</c:choose>
				<a href="./index.do" class="btn btn-default">취소</a>
			</td>
		</tr>
	</tbody>
</table>
	
<script type="text/javascript">
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
			<c:when test="${not empty roleInfo}">
			msg = "수정하시겠습니까?";		
			</c:when>
			<c:otherwise>
			msg = "등록하시겠습니까?";
			</c:otherwise>
		</c:choose>
		
		if(confirm(msg))
		{
			var tmp1 = "";
			var tmp2 = "";
			
			$jstree_checked = $('.jstree-checked');
			$jstree_undetermined = $('.jstree-undetermined');

			$jstree_undetermined.each(function(key, value){
				nodeid = $(this).attr("id");

				tmp1 += nodeid.replace("node_","") + ",";
			});

			$jstree_checked.each(function(key, value){
				nodeid = $(this).attr("id");

				tmp2 += nodeid.replace("node_","") + ",";
			});

			jQuery("input[name='mUndetermined']").val(tmp1);
			jQuery("input[name='mChecked']").val(tmp2);
			
			f.submit();			
		}
	}
	
	function getDelete()
	{
		if(confirm("삭제하시겠습니까?"))
		{
			var f = document.frm;	
			f.action = "./delete.do";
			f.submit();
		}
	}
</script>