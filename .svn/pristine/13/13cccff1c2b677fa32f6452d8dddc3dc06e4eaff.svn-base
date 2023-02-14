package mngwserc.fair.service.impl;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import egovframework.com.cmm.service.EgovCmmUseService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import egovframework.com.cmm.service.EgovFileMngUtil;
import egovframework.com.cmm.service.EgovProperties;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import emf.core.extend.service.EmfAbstractService;
import emf.core.vo.EmfMap;
import mngwserc.co.util.COPaginationUtil;
import mngwserc.fair.service.FairUserService;
import mngwserc.fair.service.dao.FairUserDAO;

/**
 * <pre> 
 * 박람회 상담 관리 Implement
 * </pre>
 * 
 * @ClassName		: FairUserServiceImpl.java
 * @Description		: 박람회 상담 관리 Implement
 * @author inuscommunity
 * @since 2019. 10. 23.
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 	    since			author	               description
 *  ============    ==============    =============================
 *  2019. 10. 23.	   inuscomm                 최초생성
 * </pre>
 */

@Service("fairUserService")
public class FairUserServiceImpl extends EmfAbstractService implements FairUserService {
	
	/** 서비스 **/
	@Resource(name="fairUserDAO")
	private FairUserDAO fairUserDAO;
	
	/** SEQ **/
	@Resource(name="fairUserProductConsultIdgen")
    private EgovIdGnrService fairUserIdgen;

	@Resource(name="EgovCmmUseService")
	private EgovCmmUseService cmmUseService;
	
	/**
     * 목록 조회
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws Exception
     */
	public EmfMap selectList(EmfMap emfMap) throws Exception {

		PaginationInfo paginationInfo = COPaginationUtil.getPage(emfMap);
		
		//페이징 처리
		emfMap.put("paginationInfo", paginationInfo);    

		//리스트 가져오기
		List<EmfMap> list = fairUserDAO.selectList(emfMap);
		
		emfMap.put("list", list);
		
		if(list.size() > 0)
		{
			paginationInfo.setTotalRecordCount(Integer.parseInt(list.get(0).getString("totCnt")));
			/*2022.03.18 황순용 로그기록 추가 */
			cmmUseService.actionViewAuthLogV2("시스템관리 - 대박나라 - 상품상담", "", "S", null);
		}
		else
		{
			paginationInfo.setTotalRecordCount(0);
		}

		return emfMap;
	}
	
	/**
     * 목록 조회
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws Exception
     */
	public EmfMap selectListExcel(EmfMap emfMap) throws Exception {

		//리스트 가져오기
		List<EmfMap> list = fairUserDAO.selectListExcel(emfMap);
		emfMap.put("list", list);
		cmmUseService.actionViewAuthLogV2("시스템관리 - 대박나라 - 상품상담", "", "E", null);
		return emfMap;
	}
	
	/**
     * 카테고리 조회
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws Exception
     */
	public EmfMap selectCateList(EmfMap emfMap) throws Exception {

		//리스트 가져오기
		emfMap.put("list", fairUserDAO.selectCateList(emfMap));
		return emfMap;
	}
	
	/**
     * 상세 조회
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws Exception
     */
	public EmfMap select(EmfMap emfMap) throws Exception {

		//리스트 가져오기
		List<EmfMap> list = fairUserDAO.select(emfMap);
		emfMap.put("list", list);
		cmmUseService.actionViewAuthLogV2("시스템관리 - 대박나라 - 상품상담 - 상세", "", "D", null);
		return emfMap;
	}
	
	/**
     * 상세 조회
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws Exception
     */
	public EmfMap selectMemo(EmfMap emfMap) throws Exception {

		//리스트 가져오기
		emfMap.put("list", fairUserDAO.selectMemo(emfMap));
		cmmUseService.actionViewAuthLogV2("시스템관리 - 대박나라 - 상품상담 - 메모", "", "E", null);
		return emfMap;
	}
	
	/**
	 * 등록
	 */
	public void insertMemo(EmfMap emfMap) throws Exception 
	{
		
		EmfMap lgnMap = (EmfMap)EgovUserDetailsHelper.getAuthenticatedUser();
		emfMap.put("regId", lgnMap.getString("id"));
		emfMap.put("regIp", lgnMap.getString("loginIp"));

		emfMap.put("FUPC_SEQ", fairUserIdgen.getNextIntegerId());
		cmmUseService.actionViewAuthLogV2("시스템관리 - 대박나라 - 상품상담 - 메모등록", "", "C", null);
    	fairUserDAO.insertMemo(emfMap);
	}
	
	/**
	 * 삭제
	 */
	public void deleteMemo(EmfMap emfMap) throws Exception 
	{
		
		EmfMap lgnMap = (EmfMap)EgovUserDetailsHelper.getAuthenticatedUser();
		emfMap.put("regId", lgnMap.getString("id"));
		emfMap.put("regIp", lgnMap.getString("loginIp"));
		cmmUseService.actionViewAuthLogV2("시스템관리 - 대박나라 - 상품상담 - 메모삭제", "", "R", null);
    	fairUserDAO.deleteMemo(emfMap);
	}	
	
	/**
	 * 삭제
	 */
	public void delete(EmfMap emfMap) throws Exception 
	{
		cmmUseService.actionViewAuthLogV2("시스템관리 - 대박나라 - 상품상담", "", "R", null);
		fairUserDAO.delete(emfMap);
	}
	
	/**
	 * 상태변경
	 */
	public void statusChange(EmfMap emfMap) throws Exception 
	{
		cmmUseService.actionViewAuthLogV2("시스템관리 - 대박나라 - 상품상담", "", "M", null);
		fairUserDAO.statusChange(emfMap);
	}
	
	/**
     * 콜센터 목록 조회
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws Exception
     */
	public EmfMap selectListCall(EmfMap emfMap) throws Exception {

		PaginationInfo paginationInfo = COPaginationUtil.getPage(emfMap);
		
		//페이징 처리
		emfMap.put("paginationInfo", paginationInfo);    

		//리스트 가져오기
		List<EmfMap> list = fairUserDAO.selectListCall(emfMap);
		
		emfMap.put("list", list);
		
		if(list.size() > 0)
		{
			paginationInfo.setTotalRecordCount(Integer.parseInt(list.get(0).getString("totCnt")));
			cmmUseService.actionViewAuthLogV2("시스템관리 - 대박나라 - 상품상담 - 콜센터", "", "S", null);
		}
		else
		{
			paginationInfo.setTotalRecordCount(0);
		}

		return emfMap;
	}
	
	/**
     * 목록 조회
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws Exception
     */
	public EmfMap selectListExcelCall(EmfMap emfMap) throws Exception {

		//리스트 가져오기
		List<EmfMap> list = fairUserDAO.selectListExcel(emfMap);
		cmmUseService.actionViewAuthLogV2("시스템관리 - 대박나라 - 상품상담 - 콜센터", "", "E", null);
		emfMap.put("list", list);
		return emfMap;
	}
}