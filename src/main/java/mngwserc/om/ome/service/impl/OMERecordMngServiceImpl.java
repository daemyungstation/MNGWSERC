package mngwserc.om.ome.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import mngwserc.co.util.COPaginationUtil;
import mngwserc.om.ome.service.OMERecordMngService;
import mngwserc.om.ome.service.dao.CuckooDAO;
import mngwserc.om.ome.service.dao.OMERecordMngDAO;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import emf.core.extend.service.EmfAbstractService;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 외주업체 실적관리를 위한 ServiceImpl
 * </pre>
 * 
 * @ClassName		: PRARecordMngServiceImpl.java
 * @Description		: 외주업체 실적관리를 위한 ServiceImpl
 * @author 김필기
 * @since 2016.02.12
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2016.02.12		김필기					 최초생성
 * </pre>
 */ 
@Service("oMERecordMngService")
public class OMERecordMngServiceImpl extends EmfAbstractService implements OMERecordMngService {
	
	@Resource(name="oMERecordMngDAO")
	private OMERecordMngDAO oMERecordMngDAO;

	@Resource(name="cuckooDAO")
	private CuckooDAO cuckooDAO;
	
	@Resource(name="EgovCmmUseService")
	private EgovCmmUseService cmmUseService;
	
	/**
     * 외주업체 실적관리 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectRecordMngList(EmfMap emfMap) throws Exception
    {
    	// 로그인 사용자 정보
    	EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
    	
    	// 아이디
		String id = lgnMap.getString("id");

    	// 페이징 처리
    	PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
    	
		emfMap.put("paginationInfo", paginationInfo);    	
		
		// 리스트 가져오기
		if("".equals(emfMap.getString("strtDt")) || "".equals(emfMap.getString("endDt")))
		{
			emfMap.put("strtDt", new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()));
			emfMap.put("endDt", new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()));			
		}		
		
		emfMap.put("id", id);
		List<EmfMap> dataList = null;
		EmfMap count = null;

		if( "cuckoo".equalsIgnoreCase(id) ) {
			dataList = cuckooDAO.selectRecordMngList(emfMap);
			count = cuckooDAO.selectRecordMngListCnt(emfMap);
		} else {
			dataList = oMERecordMngDAO.selectRecordMngList(emfMap);
			count = oMERecordMngDAO.selectRecordMngListCnt(emfMap);
		}

		emfMap.put("totCnt", count.getString("cnt"));
		emfMap.put("list", dataList);

		if(dataList.size() > 0)
		{
			paginationInfo.setTotalRecordCount(Integer.parseInt(count.getString("cnt")));
		}
		else
		{
			paginationInfo.setTotalRecordCount(0);
		}    	
    	
		emfMap.put("totalCount", paginationInfo.getTotalRecordCount());
		
		/*
		 홈페이지 개인정보 로그 - 보안관련 로직 신규 구현
		 2017.12.26
		 */
		EmfMap logMap = new EmfMap();
		logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
		logMap.put("gubun", "외주업체 관리 - 실적 관리 조회");
		logMap.put("flag", "S");
		logMap.put("name", RequestContextHolder.getRequestAttributes().getAttribute("name", RequestAttributes.SCOPE_SESSION));
		logMap.put("hp", RequestContextHolder.getRequestAttributes().getAttribute("hp", RequestAttributes.SCOPE_SESSION));
		logMap.put("id", RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION));
		if(logMap.getString("id") != null && !logMap.getString("id").equals("")){
			cmmUseService.actionViewAuthLog(logMap);
		}
		return emfMap;
    }
    
	/**
     * 외주업체 실적관리 목록 엑셀 다운로드
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
    public EmfMap selectRecordMngExcelList(EmfMap emfMap) throws Exception
    {
    	// 로그인 사용자 정보
    	EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
    	// 아이디
    	String id = lgnMap.getString("id");

		// 리스트 가져오기
		if("".equals(emfMap.getString("strtDt")) || "".equals(emfMap.getString("endDt")))
		{
			emfMap.put("strtDt", new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()));
			emfMap.put("endDt", new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()));			
		}			
		
		emfMap.put("id", id);
		
		List<EmfMap> dataList = oMERecordMngDAO.selectRecordMngExcelList(emfMap);
		EmfMap count = oMERecordMngDAO.selectRecordMngListCnt(emfMap);
		
		emfMap.put("totCnt", count.getString("cnt"));
		emfMap.put("list", dataList);
		
		/*
		 홈페이지 개인정보 로그 - 보안관련 로직 신규 구현
		 2017.12.26
		 */
		EmfMap logMap = new EmfMap();
		logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
		logMap.put("gubun", "외주업체 관리 - 실적 관리 엑셀다운로드");
		logMap.put("flag", "E");
		logMap.put("name", RequestContextHolder.getRequestAttributes().getAttribute("name", RequestAttributes.SCOPE_SESSION));
		logMap.put("hp", RequestContextHolder.getRequestAttributes().getAttribute("hp", RequestAttributes.SCOPE_SESSION));
		logMap.put("id", RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION));
		if(logMap.getString("id") != null && !logMap.getString("id").equals("")){
			cmmUseService.actionViewAuthLog(logMap);
		}
				
		return emfMap;
    }
	
    /**
     * 입금내역 목록 
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectPopGridList(EmfMap emfMap) throws Exception 
    {
    	//페이징 처리
    	PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
    	
		emfMap.put("paginationInfo", paginationInfo);    	
		
		List<EmfMap> dataList = oMERecordMngDAO.selectPopGridList(emfMap);
		EmfMap count = oMERecordMngDAO.selectPopGridListCnt(emfMap);
		
		emfMap.put("list", dataList);

		if(dataList.size() > 0)
		{
			emfMap.put("totCnt", count.getString("cnt"));
			paginationInfo.setTotalRecordCount(Integer.parseInt(count.getString("cnt")));
		}
		else
		{
			paginationInfo.setTotalRecordCount(0);
		}    	
    	
		emfMap.put("totalCount", paginationInfo.getTotalRecordCount());

		/*2022.03.18 황순용 refactor*/
		cmmUseService.actionViewAuthLogV2("외주업체 관리 - 실적 관리 입금 내역 조회", "", "S", null);

		return emfMap;    	
    }
}
