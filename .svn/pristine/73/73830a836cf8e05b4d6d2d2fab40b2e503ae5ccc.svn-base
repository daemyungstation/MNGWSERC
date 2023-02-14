<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<style>
#preview{ position:fixed; display:table; top:0; left:0; width:100%; height:100%; background-color:rgba(0,0,0,0.6); z-index: 9999; }
#preview > div{ display:table-cell; text-align:center; vertical-align:middle; }
#preview > div > div{ position:relative; overflow-y: auto; margin: 0 auto; }
#preview > div > div > img{ max-width:500px; background:#fff; }
</style>

<h6>검색 : ${rtnMap.list[0].totCnt}건</h6>

<form name="frm" action ="${pageLink}">
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />	
	<input type="hidden" name="SNS_SEQ" value="" />
	
	<div class="well well-small">
		사용여부 : 
		<select name="useYn" onchange="javascript:getPageList();">
			<option value="">전체</option>
			<option value="Y" <c:if test="${rtnMap.useYn eq 'Y'}">selected</c:if>>Y</option>
			<option value="N" <c:if test="${rtnMap.useYn eq 'N'}">selected</c:if>>N</option>
		</select>
		&nbsp;&nbsp;
		<a href="${pageLink}" class="btn" title="전체검색"><i class="icon-refresh"></i></a>
	</div>

	<table class="table table-bordered table-hover">
		<caption style="display: none;">게시판 관리</caption>
	 	<thead>
	  		<tr>
			    <th width="6%">번호</th>
			    <th width="5%">구분</th>
			    <th width="*">이미지</th>
			    <th width="13%">링크</th>
			    <th width="16%">기간</th>
			    <th width="6%">사용여부</th>
			    <th width="10%">순서</th>
			    <th width="10%">관리</th>
	  		</tr>
	 	</thead>
	 	<tbody>
			<%-- 데이터를 없을때 화면에 메세지를 출력해준다 --%>
			<c:if test="${fn:length(rtnMap.list) == 0}">
				<tr>
					<td class="lt_text3" colspan="7" style="text-align:center;">
						<fmt:message key="common.nodata.msg" />
					</td>
				</tr>
			</c:if>	
		 	<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
		  		<tr>
				    <td style="text-align:center;">
				   		${list.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}
				   	</td>
				    <td style="text-align:center;">
				    	<c:if test="${list.type eq 'L'}">LARGE</c:if>
				    	<c:if test="${list.type eq 'S'}">SMALL</c:if>
				    </td>
				    <td style="text-align:left;">
				    	<c:if test="${list.type eq 'L'}">
				    	<input type="button" value="[${ list.img1RealFileNm }] 미리보기" class="btn btn-default btn-xs btn_pop_preview_img" data-path="${ list.img1Path }" data-save="${ list.img1SaveFileNm }"/>
				    	</c:if>
				    	<c:if test="${list.type eq 'S'}">
				    	<input type="button" value="[${ list.img1RealFileNm }] 미리보기" class="btn btn-default btn-xs btn_pop_preview_img" data-path="${ list.img1Path }" data-save="${ list.img1SaveFileNm }"/>
				    	<input type="button" value="[${ list.img2RealFileNm }] 미리보기" class="btn btn-default btn-xs btn_pop_preview_img" data-path="${ list.img2Path }" data-save="${ list.img2SaveFileNm }"/>
				    	<input type="button" value="[${ list.img3RealFileNm }] 미리보기" class="btn btn-default btn-xs btn_pop_preview_img" data-path="${ list.img3Path }" data-save="${ list.img3SaveFileNm }"/>
				    	<input type="button" value="[${ list.img4RealFileNm }] 미리보기" class="btn btn-default btn-xs btn_pop_preview_img" data-path="${ list.img4Path }" data-save="${ list.img4SaveFileNm }"/>
				    	</c:if>
				    </td>
				    <td style="text-align:left;">
				    	<c:if test="${list.type eq 'L'}">
				    	<a href="${list.link1}" target="_blank">${list.link1}</a>
				    	</c:if>
				    	<c:if test="${list.type eq 'S'}">
				    	<a href="${list.link1}" target="_blank">${list.link1}</a><br>
				    	<a href="${list.link2}" target="_blank">${list.link2}</a><br>
				    	<a href="${list.link3}" target="_blank">${list.link3}</a><br>
				    	<a href="${list.link4}" target="_blank">${list.link4}</a>
				    	</c:if>
				    </td>
				    <td style="text-align:center;">
				    	${ list.useStrtDtm } ~ ${ list.useEndDtm }
				    </td>
				    <td style="text-align:center;">
				    	${list.useYn}
				    </td>
				    <td style="text-align:center;">
				    	<input type="number" name="SNS_ORDER" data-seq="${list.snsSeq}" value="${list.snsOrder}" style="width:60%;">
				    </td>
				    <td style="text-align:center;">
				    	<a href="./write.do?snsSeq=${list.snsSeq}" class="btn btn-warning btn-xs">
				    		수정
				    	</a>
				    	<a href="javascript:snsDelete('${list.snsSeq}');" class="btn btn-danger btn-xs">
				    		삭제
				    	</a>
			    	</td>
			  	</tr>
		 	</c:forEach>
			 
	 	</tbody>
	</table>
</form>

<div style="float:right;">
	<a href="./write.do" class="btn btn-success">등록</a>
</div>

<div class="paging_all c_box">
	<div class="paging">
		<ul>
			<ui:pagination paginationInfo="${rtnMap.paginationInfo}" type="text" jsFunction="getPageList" />				
		</ul>
	</div>
</div>

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
	
	//SNS 삭제
	function snsDelete(snsSeq)
	{
		if(confirm("삭제하시겠습니까? 복구할수 없습니다."))
		{
			var f = document.frm;
			
			f.action = "./delete.do";
			f.method = "POST";
			f.SNS_SEQ.value = snsSeq;
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
				jQuery("#preview").find("img").attr("src", "/cmm/fms/getPrevImage.do?path=sns&fileNm="+save+"&fileExtn="+saveFile[saveFile.length - 1]);
				jQuery("#preview").css("display","table");
			}
		});
		
		jQuery("input[name='SNS_ORDER']").blur(function(){
			var SNS_ORDER = jQuery(this).val();
			var SNS_SEQ = jQuery(this).data("seq");
			jQuery.ajax({
				type: "POST",
				url: "./order.ajax",
				dataType: "json",
				data: {
					SNS_ORDER: SNS_ORDER,
					SNS_SEQ: SNS_SEQ
				},
				success: function(result){
					if(result.result == "OK") {
						document.location.reload();
					}
				}
			});
		});
	});
</script>