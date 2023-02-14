<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>
<style>
#preview{ position:fixed; display:table; top:0; left:0; width:100%; height:100%; background-color:rgba(0,0,0,0.6); z-index: 9999; }
#preview > div{ display:table-cell; text-align:center; vertical-align:middle; }
#preview > div > div{ position:relative; overflow-y: auto; margin: 0 auto; }
#preview > div > div > img{ max-width:500px; background:#fff; }

#list_sort { margin:0; }
#list_sort li { list-style:none; background:#ffffff !important; color:inherit !important; border:none !important; font-weight:normal !important; }

a.btn { color: #ffffff !important; }
.btn-xs { padding: 1px 5px; font-size: 12px; line-height: 1.5; border-radius: 3px; }

table.sorttable {  margin-bottom: -1px !important; }
.td-no { width: 6%; }
.td-auto { width: auto; }
.td-title { width: 5%; }
.td-time { width: 20%; }
.td-use { width: 6%; }
.td-order { width: 5%; }
.td-mng { width: 10%; }
</style>

<h6 style="float:left;">대명아임레디 박람회 - 제품 카테고리 관리 : 총 ${rtnMap.list[0].totCnt}건</h6>

<div style="float:right;">
	<a href="./write.do" class="btn btn-success">등록</a>
</div>

<form name="frm" action ="${pageLink}">
	<input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}" />	
	<input type="hidden" name="seq" value="" />
	
	<table class="table table-bordered table-hover sorttable">
		<caption style="display: none;">대명아임레디 박람회 - 제품 카테고리 관리</caption>
	 	<thead>
	  		<tr>
			    <th class="td-no">번호</th>
			    <th class="td-title">제목</th>
			    <th class="td-title">설명제목</th>
			    <th class="td-title">카테고리제목</th>
			    <th class="td-auto">이미지</th>
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
					<td class="lt_text3" colspan="7" style="text-align:center;">
						<fmt:message key="common.nodata.msg" />
					</td>
				</tr>
			</c:if>
		</tbody>
	</table>
	<ul id="list_sort">
		<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
	  		<li class="ui-state-default" data-seq="${ list.fcSeq }" data-order="${ list.fcOrder }">
     			<table class="list_sort_table table table-bordered sorttable">
     				<tr>
					    <td class="td-no" style="text-align:center;">
					   		${list.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}
					   	</td>
					   	<td class="td-title">${ list.fcTitle }</td>
					    <td class="td-title">${ list.fcSubtitle }</td>
					    <td class="td-title">${ list.fcCategoryTitle }</td>
					    <td class="td-auto" style="text-align:left;">
					    	<c:if test="${ list.fcImageWSaveNm ne null }">
					    	<input type="button" value="PC-[${ list.fcImageWRealNm }]" class="btn btn-default btn-xs btn_pop_preview_img" data-path="${ list.fcImageWPath }" data-save="${ list.fcImageWSaveNm }"/>
					    	</c:if>
					    	<c:if test="${ list.fcImageMSaveNm ne null }">
					    	<input type="button" value="MO-[${ list.fcImageMRealNm }]" class="btn btn-default btn-xs btn_pop_preview_img" data-path="${ list.fcImageMPath }" data-save="${ list.fcImageMSaveNm }"/>
					    	</c:if>
					    </td>
					    <td class="td-time" style="text-align:center;">
					    	${ list.fcStime } ~ ${ list.fcEtime }
					    </td>
					    <td class="td-use" style="text-align:center;">
					    	<c:if test="${list.fcStatus eq 'Y'}">사용</c:if>	
					    	<c:if test="${list.fcStatus eq 'N'}">미사용</c:if>	
					    	<c:if test="${list.fcStatus eq 'A'}">상시사용</c:if>	
					    </td>
					    <td class="td-order" style="text-align:center;">
					    	${list.fcOrder}
					    </td>
					    <td class="td-mng" style="text-align:center;">
					    	<a href="./write.do?seq=${list.fcSeq}" class="btn btn-warning btn-xs">
					    		수정
					    	</a>
					    	<a href="javascript:del('${list.fcSeq}');" class="btn btn-danger btn-xs">
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
	
	//삭제
	function del(seq)
	{
		if(confirm("삭제하시겠습니까? 복구할수 없습니다."))
		{
			var f = document.frm;
			
			f.action = "./delete.do";
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
							url: "./order.ajax",
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