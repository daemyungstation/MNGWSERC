<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/include/el.jspf" %>
<!--
######################################################################
파일명 : OMACounselList.jsp
프로그램 명 : 외주업체 상담관리 목록
설명 : 목록
작성자 : 김필기
작성일 : 2016.02.26
수정일자 수정자 수정내용
=====================================================================
2016.02.26 김필기 최초작성
2016.05.20 김필기 최초작성
######################################################################
-->

<script type="text/javascript" src="/common/js/jquery.fileDownload.js"></script>
<script type="text/javascript" src="/common/js/mngwserc/layer_popup.js"></script>

<c:set var="loginMap" value="${admLgnMap}"/>

<c:set var="opmInfMap" value="${rtnMap.opmInfMap}"/>


<form id="excelFrm" name="excelFrm" method="post" action="excel.do">
    <input type="hidden" name="f" id="fExcel" value="${rtnMap.f}"/>
    <input type="hidden" name="q" id="qExcel" value="${rtnMap.q}"/>
    <input type="hidden" name="rtnMapf" id="rtnMapfExcel" value="${rtnMap.uDlrCd}"/>
    <input type="hidden" name="securityCd" id="securityCdExcel" value="${rtnMap.securityCd}"/>
    <input type="hidden" name="callStts" id="callSttsExcel" value="${rtnMap.callStts}"/>
    <input type="hidden" name="strtDt" id="strtDtExcel" value="${rtnMap.strtDt}"/>
    <input type="hidden" name="endDt" id="endDtExcel" value="${rtnMap.endDt}"/>
</form>

<div class="row">
    <div class="col-12">
        <div class="page-title-box d-flex align-items-center justify-content-between">
            <h4 class="page-title">상담 목록</h4>
        </div>
    </div>
</div>
<style>
    .modal-backdrop { opacity:0.5 !important; }
</style>
<div class="modal" id="securityCdModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
     aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header"><h5 class="modal-title" id="staticBackdropLabel">보안코드 입력</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="securityCdPop" class="col-form-label">보안코드:</label>
                        <input type="password" class="form-control" id="securityCdPop">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" onclick="$('#securityCdModal').modal('hide');" data-bs-dismiss="modal">취소</button>
                <button type="button" class="btn btn-primary" onclick="closePopupWithSetSecurityCode();">확인</button>
            </div>
        </div>
    </div>
</div>

<form id="frm" name="frm" method="post" action="${pageLink}">
    <input type="hidden" name="pageIndex" value="${rtnMap.pageIndex}"/>
    <div class="card-box">
        <div class="form-inline">
            <div class="form-group">
                <label for="inputPassword2">${((opmInfMap.b2bStts eq 'ONLIFECC') or (opmInfMap.b2bStts eq 'EZWEL')) ? '등록일 : ' : '신청일 : '} </label>
                &nbsp;&nbsp;
                <div class="input-group">
                    <input type="text" class="datepicker_input form-control form-control-sm" placeholder="검색 시작일"
                           id="strtDt" name="strtDt" value="${rtnMap.strtDt}" readonly="readonly"/>
                    <div class="input-group-append">
                        <button class="datepicker_input btn btn-dark btn-sm waves-effect waves-light" type="button"
                                onclick="jQuery('#strtDt').focus();">
                            <i class="dripicons-calendar"></i>
                        </button>
                    </div>
                </div>
                &nbsp;&nbsp;
                <div class="input-group">
                    <input type="text" class="datepicker_input form-control form-control-sm" placeholder="검색 종료일"
                           id="endDt" name="endDt" value="${rtnMap.endDt}" readonly="readonly"/>
                    <div class="input-group-append">
                        <button class="datepicker_input btn btn-dark btn-sm waves-effect waves-light" type="button"
                                onclick="jQuery('#endDt').focus();">
                            <i class="dripicons-calendar"></i>
                        </button>
                    </div>
                </div>
                &nbsp;&nbsp;
                <label for="inputPassword2">대리점/직영점코드 : </label>
                &nbsp;&nbsp;
                <div class="input-group">
                    <input type="text" id="rtnMapf" name="rtnMapf" class="form-control form-control-sm"
                           value="${rtnMap.rtnMapf}"/>
                </div>
                <input type="hidden" name="securityCd" id="securityCd" value="${rtnMap.securityCd}"/>
                &nbsp;&nbsp;
                <select name="f" id="f" class="form-control form-control-sm">
                    <c:if test="${loginMap.id eq 'lgusawon'}">
                        <option value="1" <c:if test="${rtnMap.f eq '1'}">selected</c:if>>대명<br/>가입번호(idNo)</option>
                        <option value="25" <c:if test="${rtnMap.f eq '25'}">selected</c:if>>U+가입번호</option>
                        <option value="2" <c:if test="${rtnMap.f eq '2'}">selected</c:if>>실제 판매자 이름</option>
                    </c:if>
                </select>
                &nbsp;&nbsp;
                <div class="input-group">
                    <input type="text" name="q" id="q" value="${rtnMap.q}" class="form-control form-control-sm"
                           maxlength="50"/>
                </div>
                &nbsp;&nbsp;
                <select name="callStts" id="callStts" class="form-control form-control-sm">
                    <c:choose>
                        <c:when test="${opmInfMap.b2bStts eq 'WEDDING' and loginMap.roleCd eq 'ROLE_00024'}">
                            <option value="">[상담현황선택]</option>
                        </c:when>
                        <c:otherwise>
                            <option value="">[상담확인선택]</option>
                        </c:otherwise>
                    </c:choose>
                    <option value="no" <c:if test="${'no' eq rtnMap.callStts}">selected</c:if>>미상담</option>
                    <c:forEach var="cdlist" items="${rtnMap.cdDtlList.callStts}" varStatus="status">
                        <option value="${cdlist.cd}"
                                <c:if test="${cdlist.cd eq rtnMap.callStts}">selected</c:if>>${cdlist.cdNm}</option>
                    </c:forEach>
                </select>

                &nbsp;&nbsp;
                <a href="javascript:getPageListWithSecurityCode(1, false);" class="btn btn-sm btn-primary"
                   title="검색">검색</a>
                &nbsp;&nbsp;
                <a href="javascript:getPageNew();" class="btn btn-sm btn-primary" title="전체검색">초기화</a>
            </div>
        </div>
    </div>


    <p>전체 게시물 수 : ${rtnMap.list[0].totCnt}<span class="red" style="color: red;">&nbsp;&nbsp;※ 유플러스 정보보안정책에 따라 최근 3개월 이전 접수 내역은 조회가 불가합니다.</span>
    </p>
    <div class="row">
        <div class="col-12">
            <div class="card-box">
                <div class="table-responsive">
                    <table class="table mb-0 table-bordered table-hover" style="font-size:12px;">
                        <caption style="display: none;">외주업체 상담 관리</caption>
                        <thead>
                        <tr>
                            <th style="vertical-align:middle;text-align: center; width: 1%;">번호</th>
                            <th style="vertical-align:middle;text-align: center; width: 6%;">가입방법</th>
                            <th style="vertical-align:middle;text-align: center; width: 5%;">코드1</th>
                            <th style="vertical-align:middle;text-align: center; width: 5%;">코드2</th>
                            <th style="vertical-align:middle;text-align: center; width: 5%;">U+가입번호</th>
                            <th style="vertical-align:middle;text-align: center; width: 5%;">대명가입번호</th>
                            <th style="vertical-align:middle;text-align: center; width: 5%;">상담신청일</th>
                            <th style="vertical-align:middle;text-align: center; width: 6%;">통화결과</th>
                            <th style="vertical-align:middle;text-align: center; width: 6%;">회원상태</th>
                            <th style="vertical-align:middle;text-align: center; width: 6%;">승인상태</th>
                            <th style="vertical-align:middle;text-align: center; width: 5%;">가입일</th>
                            <th style="vertical-align:middle;text-align: center; width: 5%;">납입회차</th>
                            <th style="vertical-align:middle;text-align: center; width: 5%;">납입수단</th>
                            <th style="vertical-align:middle;text-align: center; width: 5%;">해약(행사)일</th>
                            <th style="vertical-align:middle;text-align: center; width: 5%;">주계약</th>
                            <th style="vertical-align:middle;text-align: center; width: 5%;">채널유형코드명</th>
                            <th style="vertical-align:middle;text-align: center; width: 5%;">유치대리점명</th>
                            <th style="vertical-align:middle;text-align: center; width: 5%;">대리점/직영점 코드</th>
                            <th style="vertical-align:middle;text-align: center; width: 5%;">도매직영점 판매구분</th>
                            <th style="vertical-align:middle;text-align: center; width: 5%;">도매판매점 POS코드</th>
                            <th style="vertical-align:middle;text-align: center; width: 5%;">도매판매점명</th>
                            <th style="vertical-align:middle;text-align: center; width: 5%;">판매사명</th>
                            <th style="vertical-align:middle;text-align: center; width: 5%;">상담등록자 사번</th>

                            <!--
                            <th style="vertical-align:middle;text-align: center; width: 5%;">고객명</th> -->
                        </tr>
                        </thead>
                        <tbody>
                        <c:choose>
                            <c:when test="${fn:length(rtnMap.list) eq 0}">
                                <tr>
                                    <td class="lt_text3" colspan="30" style="text-align:center">
                                        <fmt:message key="common.nodata.msg"/>
                                    </td>
                                </tr>
                            </c:when>
                            <c:otherwise>
                                <c:forEach var="list" items="${rtnMap.list}" varStatus="status">
                                    <tr onclick="view('${list.idNo}', '${rtnMap.f}', '${rtnMap.q}', '${rtnMap.pageIndex}', '${rtnMap.callStts}', '${rtnMap.strtDt}', '${rtnMap.endDt}','${list.kbNo}')"
                                        style="cursor:pointer">
                                        <td style="text-align:center;">${list.totCnt - (rtnMap.pageIndex - 1) * rtnMap.paginationInfo.pageSize - status.count + 1}</td>
                                        <!-- 가입방법  -->
                                        <c:choose>
                                            <c:when test="${list.joinMethod eq 'fixedLine'}">
                                                <td style="text-align:center;">TM</td>
                                            </c:when>
                                            <c:otherwise>
                                                <td style="text-align:center;">전자서명</td>
                                            </c:otherwise>
                                        </c:choose>
                                        <!-- 코드1 -->
                                        <td style="text-align:center;">${list.prodNo}</td>
                                        <!-- 코드2 -->
                                        <td style="text-align:center;">${list.statNo}</td>
                                        <!-- U+가입번호 -->
                                        <td style="text-align:center;">${list.homePrdNum}</td>
                                        <!-- 대명가입번호 -->
                                        <td style="text-align:center;">${list.idNo}</td>
                                        <!-- 상담신청일 -->
                                        <td style="text-align:center;">${egov:convertDate(list.regDtm, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd HH:mm', '')}</td>
                                        <!-- 통화결과 -->
                                        <td style="text-align:center;">${list.dpmsReslNm}</td>
                                        <!-- 회원상태 -->
                                        <td style="text-align:center;">${list.accStat}</td>
                                        <!-- 승인상태 -->
                                        <td style="text-align:center;">${list.stat}</td>
                                        <!-- 가입일 -->
                                        <td style="text-align:center;">${egov:convertDate(list.joinDt, 'yyyy-MM-dd HH:mm:ss', 'yyyy-MM-dd', '')}</td>
                                        <!-- 납입회차 -->
                                        <td style="text-align:center;">${list.trueCount}</td>
                                        <!-- 납입수단 -->
                                        <td style="text-align:center;">${list.payMthd}</td>

                                        <!-- 해약(행사)일 -->
                                        <td style="text-align:center;">
                                            <c:if test='${list.statNo eq "5"}'>
                                                ${list.resnProcDay}
                                            </c:if>
                                            <c:if test='${list.statNo eq "6"}'>
                                                ${list.eventProcDay}
                                            </c:if>
                                        </td>
                                        <!-- 주계약 -->
                                        <td style="text-align:center;">${list.mainContType}</td>
                                        <!-- 채널유형코드명 -->
                                        <td style="text-align:center;">${list.uCmmnCdNm}</td>
                                        <!-- 유치대리점명 -->
                                        <td style="text-align:center;">${list.uDlrNm}</td>
                                        <!-- 대리점/직영점 코드 -->
                                        <td style="text-align:center;">${list.uDlrCd}</td>
                                        <!-- 도매직영점 판매구분 -->
                                        <td style="text-align:center;">${list.salesType}</td>
                                        <!-- 도매판매점 POS코드 -->
                                        <td style="text-align:center;">${list.whPosCd}</td>
                                        <!-- 도매판매점명 -->
                                        <td style="text-align:center;">${list.whStoreNm}</td>
                                        <!-- 판매사명 -->
                                        <td style="text-align:center;">${list.agentEmpNm}</td>
                                        <!-- 상담등록자 사번 -->
                                        <td style="text-align:center;">${list.uIndcEmpno}</td>


                                            <%--
                                            <!-- 고객명 -->
                                            <td style="text-align:center;">${list.name}</td> --%>
                                    </tr>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</form>

<div style="float:right;">
    <c:if test="${rtnMap.rtnMapf eq 'alliance' or rtnMap.rtnMapf eq 'ALLIANCE'}">
        <a href="javascript:lguExcelDownload();" class="btn btn-sm btn-primary">전체 DB 다운로드</a>
    </c:if>
    <a href="javascript:excel();" class="btn btn-sm btn-primary">엑셀 다운로드</a>
</div>

<c:if test="${rtnMap.paginationInfo ne null}">
    <div class="paging_all c_box">
        <div class="paging">
            <ul>
                <ui:pagination paginationInfo="${rtnMap.paginationInfo}" type="text"
                               jsFunction="getPageListWithSecurityCodePage"/>
            </ul>
        </div>
    </div>
</c:if>

<script type="text/javascript">
    //금일 날짜 가져온 후 LGU 엑셀 다운로드
    function lguExcelDownload() {
        let date = new Date();
        let year = date.getFullYear();
        let month = date.getMonth();
        let day = date.getDate();

        month++;

        if (month < 10) {
            month = "0" + month;
        }

        if (day < 10) {
            day = "0" + day;
        }

        let today = year.toString() + month.toString() + day.toString();

        //window.location.assign("/web/common/editor/LGUExcel/LGUDataExcel" + today + ".xls");
        window.location.assign("/common/editor/LGUExcel/LGUDataExcel" + today + ".xls");
    }

    //새로 고침
    function getPageNew() {
        //로딩중 띄우기
        $("#overlay, #pleaseWait").show();
        document.location.href = "${pageLink}";
    }

    function closePopupWithSetSecurityCode() {
        $("#securityCd").val($("#securityCdPop").val());
        $('#securityCdModal').modal('hide');
        getPageList(1);
    }
    function getPageListWithSecurityCodePage(pageNum) {
        getPageListWithSecurityCode(pageNum, true)
    }
    function getPageListWithSecurityCode(pageNum, pageNavigation) {
        var rtnMapf = $("#rtnMapf").val();
        var reg = new RegExp('^[0-9]+$');
        if ((pageNavigation != true && rtnMapf.length > 0 && reg.test(rtnMapf)) ||
            (pageNavigation === true && $("#securityCd").val().length <= 0 && rtnMapf.length > 0 && reg.test(rtnMapf) )) {
            $('#securityCdModal').modal('show');
            return;
        }
        getPageList(pageNum);
    }

    //리스트 가져오기
    function getPageList(pageNum) {
        var f = document.frm;
        f.pageIndex.value = pageNum;
        // if (arguments.length > 0) {
        //     f.pageIndex.value = arguments[0];
        // } else {
        //     f.pageIndex.value = 1;
        // }
        /* var strtDt = parseInt(jQuery("#strtDt").val().replace(/-/gi, ""));
        var endDt = parseInt(jQuery("#endDt").val().replace(/-/gi, "")); */

        var strtDt = new Date(jQuery("#strtDt").val());
        var endDt = new Date(jQuery("#endDt").val());
        var rtnMapf = $("#rtnMapf").val();


        strtDt = strtDt.getTime();
        endDt = endDt.getTime();

        var minStartDt = new Date();
        minStartDt.setMonth(minStartDt.getMonth() - 3);
        minStartDt = minStartDt.getTime();
        var gapDt = (endDt - strtDt) / 86400000;

        if (strtDt == '' || endDt == '' || rtnMapf == '') {
            alert("* 날짜와 대리점/직영점코드는 필수 입력사항입니다.");
            return;
        }

        if (strtDt && endDt && strtDt > endDt) {
            alert("* 검색 시작일이 종료일보다 클 수 없습니다.");
            return;
        }
        if (rtnMapf.toUpperCase() === "ALLIANCE") {
            if (jQuery("#q").val() != '') {
                if (jQuery("#strtDt").val() == '' || jQuery("#endDt").val() == '') {
                    alert("* 날짜를 입력해 주시기 바랍니다.");
                    return;
                }
                if (gapDt > 90) {
                    alert("* 검색기간을 90일 이내로 지정해주시기 바랍니다.");
                    return;
                }
            }
        } else {
            if (minStartDt > strtDt) {
                alert("* 보안정책에 따라 3개월 이전 데이터는 조회할 수 없습니다.");
                return;
            }
        }
        if (jQuery("#q").val() == '') {
            if (gapDt > 31) {
                alert("* 검색기간을 31일 이내로 지정해주시기 바랍니다.");
                return;
            }
        }

        //로딩중 띄우기
        $("#overlay, #pleaseWait").show();

        f.action = "./list.do";
        f.submit();
    }

    function excel() {
        var strtDt = parseInt(jQuery("#strtDt").val().replace(/-/gi, ""));
        var endDt = parseInt(jQuery("#endDt").val().replace(/-/gi, ""));
        var rtnMapf = $("#rtnMapf").val();

        if (!strtDt || !endDt || !rtnMapf) {
            alert("* 검색 기간과 대리점/직영점코드를 입력해주세요.");
        } else if (strtDt > endDt) {
            alert("* 검색 시작일이 종료일보다 클 수 없습니다.");
        } else {
            var arrStrgDt = jQuery("#strtDt").val().split("-");
            var arrEndDt = jQuery("#endDt").val().split("-");

            var strtDate = new Date(arrStrgDt[0], parseInt(arrStrgDt[1]) - 1, arrStrgDt[2]);
            var endDate = new Date(arrEndDt[0], parseInt(arrEndDt[1]) - 1, arrEndDt[2]);

            var minStartDt = new Date();
            minStartDt.setMonth(minStartDt.getMonth() - 3);
            minStartDt = minStartDt.getTime();
            if (rtnMapf.toUpperCase() != "ALLIANCE") {
                if (minStartDt > strtDate.getTime()) {
                    alert("* 보안정책에 따라 3개월 이전 데이터는 조회할 수 없습니다.");
                    return;
                }
            }
            if ((endDate.getTime() - strtDate.getTime()) / (24 * 60 * 60 * 1000) > 30) {
                alert("* 검색 기간을 30일 이하로 입력해주세요.");
            } else {
                $("#fExcel").val($("#f").val());
                $("#qExcel").val($("#q").val());
                $("#callSttsExcel").val($("#callStts").val());
                $("#strtDtExcel").val($("#strtDt").val());
                $("#endDtExcel").val($("#endDt").val());
                $("#rtnMapfExcel").val($("#rtnMapf").val());

                //document.excelFrm.submit();

                //로딩중 띄우고 Submit
                $("#overlay, #pleaseWait").show();
                $.fileDownload($("#excelFrm").prop('action'), {
                    httpMethod: "POST",
                    data: $("#excelFrm").serialize(),
                    successCallback: function (url) {
                        $("#overlay, #pleaseWait").hide();
                    },
                    failCallback: function (responseHtml, url) {
                        $("#overlay, #pleaseWait").hide();
                    }
                });
            }
        }
    }

    function view(seq, f, q, pageIndex, callStts, strtDt, endDt, kbNo) {
        location.href = "./view.do?idx=" + seq + "&f=" + f + "&q=" + q + "&pageIndex=" + pageIndex + "&callStts=" + callStts + "&strtDt=" + strtDt + "&endDt=" + endDt + "&kbNo=" + kbNo;
    }

    // 엑셀 등록 팝업
    function excelUploadPop() {
        setPopup("./excelUploadPop.do", "EXCELUPLOADPOP", 510, 310);
    }

    //로딩바 셋팅
    $(document).ready(function () {
        $("body").prepend('<div id="overlay" class="ui-widget-overlay" style="z-index: 1001; display: none;"></div>');
        $("body").prepend("<div id='pleaseWait' style='display: none;'><img src='/common/images/icon/loading-bar.gif'/></div>");
        $('#pleaseWait').middle();
    });

    //레이어 가운데 정렬
    jQuery.fn.middle = function () {
        this.css("position", "absolute");
        this.css("top", '50%');
        this.css("left", '50%');
        this.css("margin-top", -($(this).outerHeight()) / 2) + "px";
        this.css("margin-left", -($(this).outerWidth()) / 2) + "px";
        return this;
    }
</script>