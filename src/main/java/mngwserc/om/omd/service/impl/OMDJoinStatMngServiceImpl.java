package mngwserc.om.omd.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import mngwserc.co.util.COPaginationUtil;
import mngwserc.om.omd.service.OMDJoinStatMngService;
import mngwserc.om.omd.service.dao.OMDJoinStatMngDAO;

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
 * 외주업체 가입현황관리를 위한 ServiceImpl
 * </pre>
 * 
 * @ClassName		: PRAJoinStatMngServiceImpl.java
 * @Description		: 외주업체 가입현황관리를 위한 ServiceImpl
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
@Service("oMDJoinStatMngService")
public class OMDJoinStatMngServiceImpl extends EmfAbstractService implements OMDJoinStatMngService {
	
	@Resource(name="oMDJoinStatMngDAO")
	private OMDJoinStatMngDAO oMDJoinStatMngDAO;
	
	@Resource(name="EgovCmmUseService")
	private EgovCmmUseService cmmUseService;
	
	/**
     * 외주업체 가입현황관리 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectJoinStatMngList(EmfMap emfMap) throws Exception
    {
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();	// 로그인 사용자 정보
		String id = lgnMap.getString("id");	// 아이디

		ArrayList<String> b2bCompCd = new ArrayList<String>();
		ArrayList<String> saleType = new ArrayList<String>();
		
		if(id.equals("test123")){
			b2bCompCd.add("1124");
			b2bCompCd.add("5177");
			b2bCompCd.add("5178");
		}else if(id.equals("dwadmin")){
			b2bCompCd.add("1429");
		}else if(id.equals("welfare")){
			b2bCompCd.add("3282");
		}else if(id.equals("jadmin")){
			saleType.add("0011");
		}else if(id.equals("akuser")){
			saleType.add("0018");
		}
		
		if(b2bCompCd.size() > 0){
			emfMap.put("b2bCompCd", b2bCompCd);	
		}

		if(saleType.size() > 0){
			emfMap.put("saleType", saleType);	
		}
		
    	//페이징 처리
    	PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
		emfMap.put("paginationInfo", paginationInfo);    	
		
		//리스트 가져오기
		List<EmfMap> dataList = oMDJoinStatMngDAO.selectJoinStatMngList(emfMap);
		EmfMap count = oMDJoinStatMngDAO.selectJoinStatMngListCnt(emfMap);
		
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
		logMap.put("gubun", "외주업체 관리 - 가입현황 조회");
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
     * 외주업체 가입현황관리 목록 엑셀 다운로드
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
    public EmfMap selectJoinStatMngExcelList(EmfMap emfMap) throws Exception
    {
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();	// 로그인 사용자 정보
		String id = lgnMap.getString("id");	// 아이디

		ArrayList<String> b2bCompCd = new ArrayList<String>();
		ArrayList<String> saleType = new ArrayList<String>();
		
		if(id.equals("test123")){
			b2bCompCd.add("1124");
			b2bCompCd.add("5177");
			b2bCompCd.add("5178");
		}else if(id.equals("dwadmin")){
			b2bCompCd.add("1429");
		}else if(id.equals("welfare")){
			b2bCompCd.add("3282");
		}else if(id.equals("jadmin")){
			saleType.add("0011");
		}else if(id.equals("akuser")){
			saleType.add("0018");
		}
		
		if(b2bCompCd.size() > 0){
			emfMap.put("b2bCompCd", b2bCompCd);	
		}

		if(saleType.size() > 0){
			emfMap.put("saleType", saleType);	
		}    	
		
    	List<EmfMap> excelList = oMDJoinStatMngDAO.selectJoinStatMngExcelList(emfMap);
    	EmfMap count = oMDJoinStatMngDAO.selectJoinStatMngListCnt(emfMap);
		
		emfMap.put("totCnt", count.getString("cnt"));    	
    	emfMap.put("list", excelList);
    	
    	/*
		 홈페이지 개인정보 로그 - 보안관련 로직 신규 구현
		 2017.12.26
    	 */
    	EmfMap logMap = new EmfMap();
    	logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
    	logMap.put("gubun", "외주업체 관리 - 가입현황 엑셀다운로드");
    	logMap.put("flag", "E");
    	logMap.put("name", RequestContextHolder.getRequestAttributes().getAttribute("name", RequestAttributes.SCOPE_SESSION));
    	logMap.put("hp", RequestContextHolder.getRequestAttributes().getAttribute("hp", RequestAttributes.SCOPE_SESSION));
    	logMap.put("id", RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION));
		if(logMap.getString("id") != null && !logMap.getString("id").equals("")){
			cmmUseService.actionViewAuthLog(logMap);
		}
    	
    	return emfMap;
    }
    
}
