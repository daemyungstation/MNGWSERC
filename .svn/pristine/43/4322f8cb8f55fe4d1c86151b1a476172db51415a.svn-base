<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/include/el.jspf"%>

<style>
input[type="radio"], input[type="checkbox"] { margin: 0; }
label { display:inline-block; }

#preview{ position:fixed; display:table; top:0; left:0; width:100%; height:100%; background-color:rgba(0,0,0,0.6); z-index: 9999; }
#preview > div{ display:table-cell; text-align:center; vertical-align:middle; }
#preview > div > div{ position:relative; overflow-y: auto; margin: 0 auto; }
#preview > div > div > img{ max-width:500px; background:#fff; }

#list_sort { margin:0; }
#list_sort li { list-style:none; background:#ffffff !important; color:inherit !important; border:none !important; font-weight:normal !important; }

a.btn { color: #ffffff !important; }
.btn-xs { padding: 1px 5px; font-size: 12px; line-height: 1.5; border-radius: 3px; }

table.sorttable {  margin-bottom: -1px !important; }
.td-no { width: 6%; word-break:break-all; }
.td-auto { width: auto; word-break:break-all; }
.td-time { width: 20%; word-break:break-all; }
.td-bg { width: 5%; word-break:break-all; }
.td-desc { width: 10%; word-break:break-all; }
.td-use { width: 6%; word-break:break-all; }
.td-order { width: 5%; word-break:break-all; }
.td-mng { width: 10%; word-break:break-all; }
</style>

<h6>대명아임레디 박람회 - 소구포인트 설정</h6>

<form id="fairMainFrm" name="fairMainFrm" action ="./action.do" method="post" enctype="multipart/form-data">
	<table class="table table-bordered table-hover">
		<caption style="display: none;">대명아임레디 박람회 - 소구포인트 설정</caption>
		<tr id="IMG_BG">
			<th style="text-align:center; vertical-align:middle;">
				배경 이미지
			</th>
			<td style="text-align:left;">
				<span class="btn fileinput-button">
                    <i class="icon-upload"></i>
                    <span>파일추가</span>
                    <input type="file" name="FM_IMAGE_BG" accept=".gif, .jpg, .png"/>
                </span>
                <c:choose>
				    <c:when test="${rtnMap.mRow.fmImageBgSaveNm ne null}">
				        <span class="file_name" data-path="${ rtnMap.mRow.fmImageBgPath }" data-save="${ rtnMap.mRow.fmImageBgSaveNm }">&nbsp;[${rtnMap.mRow.fmImageBgRealNm}]</span>
						<input type="button" value="미리보기" class="btn btn_pop_preview"/>
				    </c:when>    
				    <c:otherwise>
				        <span class="file_name"></span>
						<input type="button" value="미리보기" class="btn btn_pop_preview" style="display: none;"/>
				    </c:otherwise>
				</c:choose>
				<br>* width: 1920px 이상, height: free (700px 권장)
			</td>
		</tr>
		
		<tr id="IMG_TITLE">
			<th style="text-align:center; vertical-align:middle;">
				타이틀 이미지
			</th>
			<td style="text-align:left;">
				<span class="btn fileinput-button">
                    <i class="icon-upload"></i>
                    <span>파일추가</span>
                    <input type="file" name="FM_IMAGE_TITLE" accept=".gif, .jpg, .png"/>
                </span>
                <c:choose>
				    <c:when test="${rtnMap.mRow.fmImageTitleSaveNm ne null}">
				        <span class="file_name" data-path="${ rtnMap.mRow.fmImageTitlePath }" data-save="${ rtnMap.mRow.fmImageTitleSaveNm }">&nbsp;[${rtnMap.mRow.fmImageTitleRealNm}]</span>
						<input type="button" value="미리보기" class="btn btn_pop_preview"/>
				    </c:when>    
				    <c:otherwise>
				        <span class="file_name"></span>
						<input type="button" value="미리보기" class="btn btn_pop_preview" style="display: none;"/>
				    </c:otherwise>
				</c:choose>
				<br>* width: 1080px 이하, height: 배경 height 이하 (120px 이하 권장)
			</td>
		</tr>
   		<tr>
		    <th width="20%">활성화</th>
		    <td width="80%">
		    	<label><input type="radio" name="FM_STATUS" value="Y" <c:if test="${rtnMap.mRow.fmStatus eq 'Y'}">checked</c:if>> 사용</label>&nbsp;&nbsp;&nbsp;
		    	<label><input type="radio" name="FM_STATUS" value="N" <c:if test="${rtnMap.mRow.fmStatus eq 'N'}">checked</c:if>> 미사용</label>&nbsp;&nbsp;&nbsp;
		    	<label><input type="radio" name="FM_STATUS" value="A" <c:if test="${rtnMap.mRow.fmStatus eq 'A'}">checked</c:if>> 상시사용(기간영향X)</label>
		    </td>
  		</tr>
  		<tr>
		    <th width="20%">시작시간</th>
		    <td width="80%">
		    	<input type="date" name="FM_SDAY" value="${rtnMap.mRow.fmStimeDay}">
		    	
		    	<select name="FM_SHH">
		    	<% 
		    	for (int ii = 0; ii <= 23; ii++) {
		    		String s = Integer.toString(ii);
		    	%>
		    		<c:set var="str" value="<%= s %>"/>
		    		<c:if test="${fn:length(str) <= 1}">
		    		<option value="0<%= ii %>" <c:if test="${rtnMap.mRow.fmStimeHh eq '0'+str}">selected</c:if>>0<%= ii %>시</option>
		    		</c:if>	
		    		<c:if test="${fn:length(str) > 1}">
		    		<option value="<%= ii %>" <c:if test="${rtnMap.mRow.fmStimeHh eq str}">selected</c:if>><%= ii %>시</option>
		    		</c:if>	
		    	<% } %>
		    	</select>
		    	
		    	<select name="FM_SMM">
		    	<% 
		    	for (int ii = 0; ii <= 59; ii++) {
		    		String s = Integer.toString(ii);
		    	%>
		    		<c:set var="str" value="<%= s %>"/>
		    		<c:if test="${fn:length(str) <= 1}">
		    		<option value="0<%= ii %>" <c:if test="${rtnMap.mRow.fmStimeMi eq '0'+str}">selected</c:if>>0<%= ii %>분</option>
		    		</c:if>	
		    		<c:if test="${fn:length(str) > 1}">
		    		<option value="<%= ii %>" <c:if test="${rtnMap.mRow.fmStimeMi eq str}">selected</c:if>><%= ii %>분</option>
		    		</c:if>	
		    	<% } %>
		    	</select>
		    	
		    	<select name="FM_SSS">
		    	<% 
		    	for (int ii = 0; ii <= 59; ii++) {
		    		String s = Integer.toString(ii);
		    	%>
		    		<c:set var="str" value="<%= s %>"/>
		    		<c:if test="${fn:length(str) <= 1}">
		    		<option value="0<%= ii %>" <c:if test="${rtnMap.mRow.fmStimeSs eq '0'+str}">selected</c:if>>0<%= ii %>초</option>
		    		</c:if>	
		    		<c:if test="${fn:length(str) > 1}">
		    		<option value="<%= ii %>" <c:if test="${rtnMap.mRow.fmStimeSs eq str}">selected</c:if>><%= ii %>초</option>
		    		</c:if>	
		    	<% } %>
		    	</select>
		    </td>
  		</tr>
  		<tr>
		    <th width="20%">마감시간</th>
		    <td width="80%">
		    	<input type="date" name="FM_EDAY" value="${rtnMap.mRow.fmEtimeDay}">
		    	
		    	<select name="FM_EHH">
		    	<% 
		    	for (int ii = 0; ii <= 23; ii++) {
		    		String s = Integer.toString(ii);
		    	%>
		    		<c:set var="str" value="<%= s %>"/>
		    		<c:if test="${fn:length(str) <= 1}">
		    		<option value="0<%= ii %>" <c:if test="${rtnMap.mRow.fmEtimeHh eq '0'+str}">selected</c:if>>0<%= ii %>시</option>
		    		</c:if>	
		    		<c:if test="${fn:length(str) > 1}">
		    		<option value="<%= ii %>" <c:if test="${rtnMap.mRow.fmEtimeHh eq str}">selected</c:if>><%= ii %>시</option>
		    		</c:if>	
		    	<% } %>
		    	</select>
		    	
		    	<select name="FM_EMM">
		    	<% 
		    	for (int ii = 0; ii <= 59; ii++) {
		    		String s = Integer.toString(ii);
		    	%>
		    		<c:set var="str" value="<%= s %>"/>
		    		<c:if test="${fn:length(str) <= 1}">
		    		<option value="0<%= ii %>" <c:if test="${rtnMap.mRow.fmEtimeMi eq '0'+str}">selected</c:if>>0<%= ii %>분</option>
		    		</c:if>	
		    		<c:if test="${fn:length(str) > 1}">
		    		<option value="<%= ii %>" <c:if test="${rtnMap.mRow.fmEtimeMi eq str}">selected</c:if>><%= ii %>분</option>
		    		</c:if>	
		    	<% } %>
		    	</select>
		    	
		    	<select name="FM_ESS">
		    	<% 
		    	for (int ii = 0; ii <= 59; ii++) {
		    		String s = Integer.toString(ii);
		    	%>
		    		<c:set var="str" value="<%= s %>"/>
		    		<c:if test="${fn:length(str) <= 1}">
		    		<option value="0<%= ii %>" <c:if test="${rtnMap.mRow.fmEtimeSs eq '0'+str}">selected</c:if>>0<%= ii %>초</option>
		    		</c:if>	
		    		<c:if test="${fn:length(str) > 1}">
		    		<option value="<%= ii %>" <c:if test="${rtnMap.mRow.fmEtimeSs eq str}">selected</c:if>><%= ii %>초</option>
		    		</c:if>	
		    	<% } %>
		    	</select>
		    </td>
  		</tr>
	</table>
	<div style="text-align:center;">
		<a class="btn btn-success" onclick="javascript:chkFormFairMain();">저장</a>
	</div>
</form>


<!-- 미리보기 -->
<div id="preview" style="display:none;">
	<div>
		<button type="button" onclick="preview_close()" class="btn btn-success btn-sm mb-1">닫기</button>
		<div>
			<img src="" />
		</div>
	</div>
</div>
<!-- // 미리보기 -->

<script>
//등록하기
	function chkFormFairMain()
	{
		var f = document.fairMainFrm;
		
		<c:if test="${rtnMap.mRow.fmImageBgSaveNm eq null}">
		if(f.FM_IMAGE_BG.value == "") {
			alert("배경이미지를 선택해주세요.");
			return;
		}
		</c:if>
		
		<c:if test="${rtnMap.mRow.fmImageTitleSaveNm eq null}">
		if(f.FM_IMAGE_TITLE.value == "") {
			alert("타이틀 이미지를 선택해주세요.");
			return;
		}
		</c:if>
		
		
		if(f.FM_STATUS[0].checked == false && f.FM_STATUS[1].checked == false && f.FM_STATUS[2].checked == false) {
			alert("활성화 여부를 선택해주세요.");
			f.FM_STATUS[0].focus();
			return;
		}
		
		if(f.FM_STATUS[0].checked == true) {
			if(f.FM_SDAY.value == "") {
				alert("시작일을 선택해주세요.");
				f.FM_SDAY.focus();
				return;
			}
			if(f.FM_SHH.value == "") {
				alert("시작시간(시)을 선택해주세요.");
				f.FM_SHH.focus();
				return;
			}
			if(f.FM_SMM.value == "") {
				alert("시작시간(분)을 선택해주세요.");
				f.FM_SMM.focus();
				return;
			}
			if(f.FM_SSS.value == "") {
				alert("시작시간(초)을 선택해주세요.");
				f.FM_SSS.focus();
				return;
			}
			
			if(f.FM_EDAY.value == "") {
				alert("마감일을 선택해주세요.");
				f.FM_EDAY.focus();
				return;
			}
			if(f.FM_EHH.value == "") {
				alert("마감시간(시)을 선택해주세요.");
				f.FM_EHH.focus();
				return;
			}
			if(f.FM_EMM.value == "") {
				alert("마감시간(분)을 선택해주세요.");
				f.FM_EMM.focus();
				return;
			}
			if(f.FM_ESS.value == "") {
				alert("마감시간(초)을 선택해주세요.");
				f.FM_ESS.focus();
				return;
			}
		}
		
		f.submit();
	}
	
	jQuery(document).ready(function(){
		imagePreview();
	});
	
	jQuery("input[name='FM_IMAGE_BG'], input[name='FM_IMAGE_TITLE']").change(function(){
		var file = jQuery(this)[0].files[0];
		if(typeof file === 'undefined') {
			jQuery(this).closest("td").find(".file_name").text("");
			jQuery(this).closest("td").find(".btn_pop_preview").hide();
			return;
		}
		var ext = file.name.substring(file.name.lastIndexOf(".")+1, file.name.length);
		var fileNm = file.name.substring(0, file.name.lastIndexOf("."));

		jQuery(this).closest("td").find(".file_name").html("&nbsp;["+fileNm+"]");
		jQuery(this).closest("td").find(".btn_pop_preview").show();;		
	
		// 이미지 미리보기 버튼 클릭
		imagePreview();
	});
	
	function preview_close() {
		jQuery("#preview").css("display","none");
	};
	
	function imagePreview(){
		jQuery(".btn_pop_preview").off("click").on("click", function(){
			var select_file = jQuery(this).closest("td").find("input:file");
			if(select_file.val() != '') {
				var file = select_file[0].files[0];
				var reader = new FileReader();
				
		        reader.onload = function(event){
		        	jQuery("#preview").find("img").attr("src", event.target.result);
		        }
	            reader.readAsDataURL(file);
				jQuery("#preview").css("display","table");
				return;
			}else {
				var select_span = jQuery(this).closest("td").find(".file_name");
				if(select_span.data("path") != "" && select_span.data("save") != "") {
					var path = select_span.data("path");
			 		var save = select_span.data("save");
					var saveFile = save.split(".");		
				
					//jQuery("#preview").find("img").attr("src", "/cmm/fms/getPrevImage.do?path="+path+"&fileNm="+save+"&fileExtn="+saveFile[saveFile.length - 1]);
					jQuery("#preview").find("img").attr("src", "/cmm/fms/getPrevImage.do?path=fair&fileNm="+save+"&fileExtn="+saveFile[saveFile.length - 1]);
					jQuery("#preview").css("display","table");
				}
			}
		});
	}
</script>

<h6 style="float:left;">대명아임레디 박람회 - 소구포인트 상세 관리 : 총 ${rtnMap.list[0].totCnt}건</h6>

<div style="float:right;">
	<a href="./subwrite.do" class="btn btn-success">등록</a>
</div>

<form name="frm" action ="${pageLink}">
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />	
	<input type="hidden" name="seq" value="" />
	
	<table class="table table-bordered table-hover sorttable">
		<caption style="display: none;">대명아임레디 박람회 - 탑배너 관리</caption>
	 	<thead>
	  		<tr>
			    <th class="td-no">번호</th>
			    <th class="td-auto">이미지</th>
			    <th class="td-bg">배경색</th>
			    <th class="td-desc">설명</th>
			    <th class="td-time">기간</th>
			    <th class="td-use">사용여부</th>
			    <th class="td-order">순서</th>
			    <th class="td-mng">관리</th>
	  		</tr>
	 	</thead>
	 	<tbody>
			<%-- 데이터를 없을때 화면에 메세지를 출력해준다 --%>
			<c:if test="${fn:length(rtnMap.list) == 0}">
				<tr>
					<td class="lt_text3" colspan="8" style="text-align:center;">
						<fmt:message key="common.nodata.msg" />
					</td>
				</tr>
			</c:if>
		</tbody>
	</table>
	<ul id="list_sort">
		<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
	  		<li class="ui-state-default" data-seq="${ list.fmsSeq }" data-order="${ list.fmsOrder }">
     			<table class="list_sort_table table table-bordered sorttable">
     				<tr>
					    <td class="td-no" style="text-align:center;">					    
					   		${list.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}
					   	</td>
					    <td class="td-auto" style="text-align:left;">
					    	<c:if test="${ list.fmsImageBgSaveNm ne null }">
					    	<input type="button" value="배경-[${ list.fmsImageBgRealNm }]" class="btn btn-default btn-xs btn_pop_preview_img" data-path="${ list.fmsImageBgPath }" data-save="${ list.fmsImageBgSaveNm }"/>
					    	</c:if>
					    	<c:if test="${ list.fmsImageWSaveNm ne null }">
					    	<input type="button" value="PC-[${ list.fmsImageWRealNm }]" class="btn btn-default btn-xs btn_pop_preview_img" data-path="${ list.fmsImageWPath }" data-save="${ list.fmsImageWSaveNm }"/>
					    	</c:if>
					    	<c:if test="${ list.fmsImageMSaveNm ne null }">
					    	<input type="button" value="MO-[${ list.fmsImageMRealNm }]" class="btn btn-default btn-xs btn_pop_preview_img" data-path="${ list.fmsImageMPath }" data-save="${ list.fmsImageMSaveNm }"/>
					    	</c:if>
					    </td>
					    <td class="td-bg" style="text-align:center; background-color:${list.fmsBgcolor};">
					    	${list.fmsBgcolor}
					    </td>
					    <td class="td-desc" style="text-align:center;">
					    	${list.fmsDesc}
					    </td>
					    <td class="td-time" style="text-align:center;">
					    	${ list.fmsStime } ~ ${ list.fmsEtime }
					    </td>
					    <td class="td-use" style="text-align:center;">
					    	<c:if test="${list.fmsStatus eq 'Y'}">사용</c:if>	
					    	<c:if test="${list.fmsStatus eq 'N'}">미사용</c:if>	
					    	<c:if test="${list.fmsStatus eq 'A'}">상시사용</c:if>	
					    </td>
					    <td class="td-order" style="text-align:center;">
					    	${list.fmsOrder}
					    </td>
					    <td class="td-mng" style="text-align:center;">
					    	<a href="./subwrite.do?seq=${list.fmsSeq}" class="btn btn-warning btn-xs">
					    		수정
					    	</a>
					    	<a href="javascript:del('${list.fmsSeq}');" class="btn btn-danger btn-xs">
					    		삭제
					    	</a>
				    	</td>
				  	</tr>
				</table>
			</li>
	 	</c:forEach>
	 </ul>
</form>

<div style="float:right;">
	<a href="./subwrite.do" class="btn btn-success">등록</a>
</div>

<div class="paging_all c_box">
	<div class="paging">
		<ul>
			<ui:pagination paginationInfo="${rtnMap.paginationInfo}" type="text" jsFunction="getPageList" />				
		</ul>
	</div>
</div>

	
<script type="text/javascript">
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
		
		f.action = "./index.do";
		f.submit();
	}
	
	//삭제
	function del(seq)
	{
		if(confirm("삭제하시겠습니까? 복구할수 없습니다."))
		{
			var f = document.frm;
			
			f.action = "./subdelete.do";
			f.method = "POST";
			f.seq.value = seq;
			f.submit();
		}
	}
	
	function preview_close() {
		jQuery("#preview").css("display","none");
	};
	
	jQuery(document).ready(function(){
		jQuery(".btn_pop_preview_img").click(function(){
			if(jQuery(this).data("path") != "" && jQuery(this).data("save") != "") {
				var path = jQuery(this).data("path");
		 		var save = jQuery(this).data("save");
				var saveFile = save.split(".");		
			
				//jQuery("#preview").find("img").attr("src", "/cmm/fms/getPrevImage.do?path="+path+"&fileNm="+save+"&fileExtn="+saveFile[saveFile.length - 1]);
				jQuery("#preview").find("img").attr("src", "/cmm/fms/getPrevImage.do?path=fair&fileNm="+save+"&fileExtn="+saveFile[saveFile.length - 1]);
				jQuery("#preview").css("display","table");
			}
		});
		
		var bSort = false;
		var sortPIndex = null;
		var sortNIndex = null;
		var sortFindex = null;
		jQuery("#list_sort").sortable({
			revert: 100,
			start: function( event, ui ) {
				bSort = true;
				sortPIndex = ui.item.index();
				sortFindex = jQuery("#list_sort li").eq(0).data("order");
			},
			stop: function( event, ui ) {
				sortNIndex = ui.item.index();
				
				if(sortPIndex != sortNIndex) {
					var arySort = new Array();
					jQuery("#list_sort li").each(function(){
						arySort.push(jQuery(this).data("seq"));
					});
					if(bSort == true) {
						jQuery.ajax({
							url: "./suborder.ajax",
							type: "POST",
							dataType: "JSON",
							data: {
								"fOrder": sortFindex,
								"seq": arySort.join(",")
							},
							beforeSend: function() {
								
				            },
				            complete: function() {
				            	
				            },
							success: function(data) {
								bSort = false;
								document.location.reload();
							}
						});
					}
				}else {
					bSort = false;
				}
			}
		});
		jQuery( "#list_sort.ul, #list_sort > li" ).disableSelection();
	});
</script>