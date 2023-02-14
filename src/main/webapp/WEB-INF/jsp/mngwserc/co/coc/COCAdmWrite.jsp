<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<!-- 
	######################################################################
	파일명 		:	COCAdmWrite.jsp
	프로그램 명 : 	관리자관리
	설명		: 	작성
	작성자		: 	김대환
	작성일		:	2015.11.13
	수정일자				수정자				수정내용
	=====================================================================
	2015.11.13				김대환				최초작성
	######################################################################
-->

<c:set var="admInfo" value="${rtnMap.admInfo}" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<script type="text/javascript" src="/egov/js/jstree/jquery.jstree.js"></script>
<script type="text/javascript" src="/egov/js/jstree/jquery.hotkeys.js"></script>
<script type="text/javascript" src="/egov/js/jstree/jquery.cookies.js"></script>
<script type="text/javascript" src="/common/js/mngwserc/co/coc/COCAdmRole.js?{'topNode':'1', 'uid':'${admInfo.admSeq}', 'did':'${admInfo.roleCd}'}"></script>

<form name="frm" method="post" action="${egov:decode(admInfo, null, '/mngwserc/coc/adm/insert.do', '/mngwserc/coc/adm/update.do')}">
	<input type="hidden" name="mUndetermined" value="" />
	<input type="hidden" name="mChecked" value="" />
		
	<div id="divCategoris" style="width:30%; height:570px; float:left; margin-right:5%; overflow-y:auto;">
		
	</div>
	
	<table class="table table-bordered" style="width:60%;">
		<colgroup>
			<col width="20%" />
			<col width="80%" />
		</colgroup>
		<tbody>
			<tr>
				<th style="text-align:center; vertical-align:middle;">
					관리자 등급
				</th>
				<td style="text-align:left;">
					<select name="authCd">
					<c:forEach var="userTypelist" items="${rtnMap.admUserTypeList}" varStatus="status">
						<option value="${userTypelist.cd}" <c:if test="${admInfo.authCd eq userTypelist.cd}">selected</c:if>>${userTypelist.cdNm}</option>
					</c:forEach>
					</select>
				</td>
			</tr>
			<c:if test="${rtnMap.roleGb ne 'AUTH'}">
			<tr>
				<th style="text-align:center; vertical-align:middle;">
					부서 (ROLE)
				</th>
				<td style="text-align:left;">
					<input type="text" name="roleAuto" value="${admInfo.roleNm}" style="width:35%;" maxlength="20" placeholder="부서 (ROLE)명으로 검색해주세요." /><br />
					<input type="hidden" name="roleCd" value="${admInfo.roleCd}" />
				</td>
			</tr>
			</c:if>
			<tr>
				<th style="text-align:center; vertical-align:middle;">
					* 이름
				</th>
				<td style="text-align:left;">
					<c:choose>
						<c:when test="${not empty admInfo}">
							${admInfo.name}
							<input type="hidden" name="admSeq" value="${admInfo.admSeq}" />
						</c:when>
						<c:otherwise>
							<input type="text" name="name" value="${admInfo.name}" style="width:35%;" maxlength="15" required="이름을 입력해주세요." />
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<th style="text-align:center; vertical-align:middle;">
					* 아이디
				</th>
				<td style="text-align:left;">
					<c:choose>
						<c:when test="${not empty admInfo}">
							${admInfo.id} 	
						</c:when>
						<c:otherwise>
							<input type="text" name="id" style="width:35%;" maxlength="20" onchange="jQuery('#id_chk').val('')" required="아이디를 입력해주세요."  idChk />
							<input type="hidden" id="id_chk" name="id_chk" value="" />
							<a href="javascript: fnCheckId();" class="btn btn-inverse">중복확인</a>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<th style="text-align:center; vertical-align:middle;">
					* 비밀번호					
				</th>
				<td style="text-align:left;">
					<input type="password" name="pwd" style="width:35%;" maxlength="20" <c:if test="${empty admInfo}">required="비밀번호를 입력해주세요."</c:if> passChk />
					<span class="material-icons pwd_visible"  style="vertical-align: middle;" onclick="javascript:viewPassword('pwd')">visibility_off</span>
					<br />
					• 특수문자, 숫자, 영문 3가지 조합시 8자리이상 ~ 20자리 이하<br /> 
				    • 특수문자, 숫자, 영문 2가지 조합시 10자리이상 ~ 20자리 이하
				</td>
			</tr>
			<tr>
				<th style="text-align:center; vertical-align:middle;">
					비밀번호 확인
				</th>
				<td style="text-align:left;">
					<input type="password" name="pwd_chk" style="width:35%;" maxlength="20" passChk />
					<span class="material-icons pwd_chk_visible" style="vertical-align: middle;" onclick="javascript:viewPassword('pwd_chk')">visibility_off</span>
				</td>				
			</tr>
			<tr>
				<th style="text-align:center; vertical-align:middle;">
					연락처
				</th>
				<td style="text-align:left;">
					<input type="text" name="tel" style="width:35%;" value="${admInfo.tel}" maxlength="30" phoneKr />
				</td>
			</tr>
			<tr>
				<th style="text-align:center; vertical-align:middle;">
					* 이메일
				</th>
				<td style="text-align:left;">
					<input type="text" name="email" style="width:35%;" onchange="jQuery('#email_chk').val('')" value="${admInfo.email}" maxlength="40" required="이메일주소를 입력해주세요." emailkr />
					<input type="hidden" id="email_chk" name="email_chk" value="" />
					<a href="javascript:fnCheckEmail();" class="btn btn-inverse">중복확인</a>
				</td>
			</tr>
			<tr>
				<th style="text-align:center; vertical-align:middle;">
					허용IP
				</th>
				<td style="text-align:left;">
					<input type="text" name="allwIp" style="width:80%;" value="${admInfo.allwIp}" placeholder="미입력시 모든 IP로 접근이 가능합니다" maxlength="100" />
				</td>
			</tr>
			<tr>
				<th style="text-align:center;vertical-align:middle;">
					계정상태
				</th>
				<td style="text-align:left;">
					<input type="radio" name="useYn" value="Y" title="" class="checkbox" <c:if test="${empty admInfo or admInfo.useYn eq 'Y'}">checked</c:if> />
					허용&nbsp;&nbsp;
					<input type="radio" name="useYn" value="N" title="" class="checkbox" <c:if test="${admInfo.useYn eq 'N'}">checked</c:if> />
					차단
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
					<c:when test="${empty admInfo}">
						<a href="javascript:chkForm();" class="btn btn-success">등록</a>
					</c:when>
					<c:otherwise>
						<a href="javascript:chkForm();" class="btn btn-primary">수정</a>
						<a href="javascript:deleteAdm();" class="btn btn-danger">삭제</a>
					</c:otherwise>
				</c:choose>
				<a href="./index.do" class="btn btn-default">취소</a>
			</td>
		</tr>
		
	</tbody>
</table>

<script type="text/javascript">
	<c:if test="${rtnMap.updateSuccess eq 'true'}">
	alert('수정이 완료되었습니다.');
	</c:if>
	<c:if test="${rtnMap.updateSuccess eq 'false'}">
	alert('수정이 실패했습니다.');
	</c:if>


	jQuery(document).ready(function(){
		<c:choose>
			<c:when test="${rtnMap.roleGb eq 'AUTH'}">
				jQuery("select[name='authCd']").on("change", function(){
					viewRole(jQuery(this).val());
				});
				
				viewRole(jQuery("select[name='authCd'] option:selected").val());
			</c:when>
			<c:otherwise>
				jQuery("input[name='roleAuto']").autocomplete({
					source : function(request, response) 
					{
						jQuery.get("/mngwserc/coc/role/getRole.ajax",
							{
								"f" : 1,
								"q" : jQuery("input[name='roleAuto']").val()
							},
							function(r) 
							{
								var roleList = r.roleList;
								
								console.log(roleList);

								if (roleList.length > 0)
								{
									response(jQuery.map(roleList, function(item) {
										return {
											label: jQuery.trim(item.roleNm) + "("+item.roleCd+")",
											value: jQuery.trim(item.roleNm),
											data : jQuery.trim(item.roleNm + ":" + item.roleCd)
										};
									}));
								}
							}
						);
					},
					minLength : 2,
					select : function(event, ui) 
					{				
						if (ui.item.label != "") 
						{
							var arr = ui.item.data.split(":");
							jQuery("input[name='roleNm']").val(arr[0]);
							jQuery("input[name='roleCd']").val(arr[1]);
							
							//관리자 관리의 메뉴를 변경해주어야한다.
							viewRole(arr[1]);
						}
						else 
						{
							alert("찾고자 하는 ROLE이 없습니다.");
						}
					},
					focus : function(event, ui) 
					{
						event.preventDefault();
					},
					open : function() 
					{
						//444-444 ZIPCODE 인풋 텍스트의 값을 빈값으로 만들어준다.
					}
				});
			</c:otherwise>
		</c:choose>
	});
	
	//관리자 부서 롤 불러오기
	function viewRole(cd)
	{
		CategoryInfo.did = cd;
		<c:if test="${empty admInfo}">
		CategoryInfo.uid = -1;
		</c:if>
		$.jstree._reference($("#divCategoris")).refresh(-1);
	}
	
	//유효성 체크
	function chkForm()
	{		
		var f = document.frm;	
		
		if(!validate(f))
		{
			return;
		}
		
		if(f.pwd.value != f.pwd_chk.value)
		{
			alert("확인 비밀번호가 다릅니다.");
			return;				
		}
		
		<c:choose>
			<c:when test="${not empty admInfo}">
				if(f.email.value != "${admInfo.email}" && f.email_chk.value == "")
				{
					alert("이메일 중복체크가 필요합니다.");
					return;				
				}
			</c:when>
			<c:otherwise>
				if(f.id_chk.value == "")
				{
					alert("아이디 중복체크가 필요합니다.");
					return;
				}
				
				if(f.email_chk.value == "")
				{
					alert("이메일 중복체크가 필요합니다.");
					return;
				}
			</c:otherwise>
		</c:choose>
		
		var msg = "";
		<c:choose>
			<c:when test="${not empty admInfo}">
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

			$("input[name='mUndetermined']").val(tmp1);
			$("input[name='mChecked']").val(tmp2);
			
			f.submit();
		}
	}
	
	//아이디 중복체크
	function fnCheckId()
	{
		var admId = jQuery("input[name='id']").val();
		
		if(!admId)
		{
			alert("아이디를 입력해주세요.");
			jQuery("input[name='id']").focus();
			return;
		}
		else
		{
			var pattern = /^[a-zA-Z0-9]{1}[a-zA-Z0-9_]{4,12}$/;

			if (pattern.test(admId) == true) 
			{
				jQuery.post("/mngwserc/coc/adm/getIdChk.ajax",
					{
						"id" : admId
					},
					function(r) 
					{
						alert(r.msg);
						
						if(r.id_chk != "Y")
						{
							jQuery("input[name='id']").val(""); 
						}
						
						jQuery("input[name='id_chk']").val(r.id_chk);
					}
				);
			} 
			else 
			{
				alert("* 아이디 입력값이 올바르지 않습니다.\n(알파벳 대소문자 + 숫자, 5~12자로 입력합니다.)");
				jQuery("input[name='id']").focus();
				return;
			}
		}
	}
	
	//이메일 중복체크
	function fnCheckEmail()
	{
		var email= jQuery("input[name='email']").val();
		
		if(!email)
		{
			alert("이메일주소를 입력해주세요.");
			jQuery("input[name='email']").focus();
			return;
		}
		else
		{
			var pattern = /^[_a-zA-Z0-9-\.\_]+@[\.a-zA-Z0-9-]+\.[a-zA-Z]+$/;		
			
			if((pattern.test(email)) == true)
		    {
				jQuery.post("/mngwserc/coc/adm/getEmailChk.ajax",
					{
						"email" : email
					},
					function(r)
					{
						alert(r.msg);
						
						if(r.email_chk != "Y")
						{
							jQuery("input[name='email_chk']").val(""); 
						}
						
						jQuery("input[name='email_chk']").val(r.email_chk);
					}
				);
		    }
			else
			{
				alert("이메일 입력값이 올바르지 않습니다.");
				jQuery("input[name='email']").focus();
				return;
			}
		}
	}
	function viewPassword(input_name) {
		if( $('.' + input_name + '_visible').text() == 'visibility_off') {
			$('.' + input_name + '_visible').text('visibility');
			$('input[name="' + input_name +'"').attr('type',"text");
		} else {
			$('.' + input_name + '_visible').text('visibility_off');
			$('input[name="' + input_name +'"').attr('type',"password");
		}
	}
	function deleteAdm()
	{
		if(confirm("삭제하시겠습니까?"))
		{
			var f = document.frm;	
			f.action = "./delete.do";
			f.submit();
		}
	}
</script>