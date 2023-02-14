<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/jsp/include/el.jspf"%>

 <div>
 	
 	<c:forEach var="list" items="${rtnMap.list}" varStatus="status">
	<div class="level1" style="margin-bottom:5px">
		<h5 style="color:green">${list.cntn}</h5>

		<div class="level level2">
			<c:if test="${list.level2List ne null}">
				<c:forEach var="list2" items="${list.level2List}" varStatus="status">
				<div style="margin: 1px 0; ">
					<c:choose>
						<c:when test="${list2.level3List ne null}">
						<p style="white-space:pre; font-weight:bold">${list2.cntn }</p>	
						</c:when>
						<c:otherwise>
						<p style="white-space:pre;">${list2.cntn }</p>
						</c:otherwise>
					</c:choose>	

					<div class="level level3">
						<c:if test="${list2.level3List ne null}">
							<c:forEach var="list3" items="${list2.level3List}" varStatus="status">
							
							<div style="margin: 1px 0; " >
								<p style="white-space:pre;">${list3.cntn }</p>
							</div>
														
							</c:forEach>
						</c:if>
					</div>			
				</div>						
				</c:forEach>			
			</c:if>
		</div>	
	</div>
	</c:forEach>
						
</div> 

<script>
$(document).ready(function(){
	$('footer').remove();
	$('hr').remove();
});
</script>
