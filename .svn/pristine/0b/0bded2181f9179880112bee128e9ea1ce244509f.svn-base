/**
 * 
 */
package mngwserc.co.coh.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import mngwserc.co.coh.service.COHBoardMngService;
import mngwserc.co.coh.service.dao.COHBoardMngDAO;
import mngwserc.co.util.COPaginationUtil;

import org.springframework.stereotype.Service;

import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import emf.core.extend.service.EmfAbstractService;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 게시판 관리 서비스 구현
 * </pre>
 * 
 * @ClassName		: COHBbsMngServiceImpl.java
 * @Description		: 게시판 관리 서비스 구현
 * @author 김필기
 * @since 2015. 11. 17.
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2015. 11. 17.		김필기					최초생성
 * </pre>
 */

@Service("cOHBoardMngService")
public class COHBoardMngServiceImpl extends EmfAbstractService implements COHBoardMngService {
	
	@Resource(name="cOHBoardMngDAO")
	private COHBoardMngDAO cOHBoardMngDAO;
	
	@Resource(name="EgovCmmUseService")
    private EgovCmmUseService cmmUseService;
	
    @Resource(name="BoardMasterIdgen")
    private EgovIdGnrService idgenService;

    /**
	 * 게시판 속성 정보 목록을 조회 한다.
	 * 
	 * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public EmfMap selectBoardConfigList(EmfMap emfMap) throws Exception {

		PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
		
		//페이징 처리
		emfMap.put("paginationInfo", paginationInfo);    
				
		//리스트 가져오기
		List<EmfMap> list = cOHBoardMngDAO.selectBoardConfigList(emfMap);
		
		emfMap.put("list", list);
		
		if(list.size() > 0)
		{
			paginationInfo.setTotalRecordCount(Integer.parseInt(list.get(0).getString("totCnt")));
		}
		else
		{
			paginationInfo.setTotalRecordCount(0);
		}
		
		//공통코드 배열 셋팅
		ArrayList<String> cdDtlList = new ArrayList<String>();
		
		//커뮤니티 TYPE
		cdDtlList.add("COMMUNITY_TYPE");
		
		//정의된 코드id값들의 상세 코드 맵 반환		
		emfMap.put("cdDtlList", cmmUseService.selectCmmCodeBindAll(cdDtlList));
		
		return emfMap;
	}
	
	/**
	 * 게시판 속성 정보 상세를 조회 한다.
	 * 
	 * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public EmfMap selectBoardConfig(EmfMap emfMap) throws Exception 
	{
		if(!"".equals(EMFStringUtil.nullConvert(emfMap.get("communityId"))))
    	{
			EmfMap boardInfo = cOHBoardMngDAO.selectBoardConfig(emfMap);
			
			if(boardInfo != null)
	    	{
				emfMap.put("boardInfo", boardInfo);
	    	}
    	}
		
		//공통코드 배열 셋팅
		ArrayList<String> cdDtList = new ArrayList<String>();
		
		//커뮤니티TYPE
		cdDtList.add("COMMUNITY_TYPE");
		
		//관리자 승인 사용 여부
		cdDtList.add("USER_TYPE");

		//사용자 권한 설정
		cdDtList.add("USER_AUTHORITY");
		
		//정의된 코드id값들의 상세 코드 맵 반환
		emfMap.put("cdDtlList", cmmUseService.selectCmmCodeBindAll(cdDtList));
		
		return emfMap;
	}
	
	/**
	 * 신규 게시판 속성정보를 등록한다.
	 */
	public void insertBoardConfig(EmfMap emfMap) throws Exception 
	{
		String idgen = idgenService.getNextStringId();
		
		emfMap.put("communityId", Integer.parseInt(idgen));
		emfMap.put("tableNm", "TN_BOARD_" + idgen);
		
		cOHBoardMngDAO.createBoardTbl(emfMap);
		cOHBoardMngDAO.createBoardIndex(emfMap);
		cOHBoardMngDAO.createBoardPk(emfMap);
		
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("regId", lgnMap.getString("id"));
		emfMap.put("regNm", lgnMap.getString("name"));
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modNm", lgnMap.getString("name"));
		
		cOHBoardMngDAO.insertBoardConfig(emfMap);
	}

	/**
	 * 게시판 속성 정보를 수정한다.
	 */
	public void updateBoardConfig(EmfMap emfMap) throws Exception 
	{
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("modId", lgnMap.get("id"));
		emfMap.put("modNm", lgnMap.get("name"));
		
		cOHBoardMngDAO.updateBoardConfig(emfMap);		
	}
	
	/**
	 * 게시판 속성 정보를 삭제한다.
	 */
	public void deleteBoardConfig(EmfMap emfMap) throws Exception 
	{
		cOHBoardMngDAO.deleteBoardConfig(emfMap);
	}
	
	public void insertBoardConfigCopy(EmfMap emfMap) throws Exception
	{
		String idgen = idgenService.getNextStringId();
		
		emfMap.put("communityId", Integer.parseInt(idgen));
		emfMap.put("tableNm", "TN_BOARD_" + idgen);
		
		cOHBoardMngDAO.createBoardTbl(emfMap);
		cOHBoardMngDAO.createBoardIndex(emfMap);
		cOHBoardMngDAO.createBoardPk(emfMap);
		
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("regId", lgnMap.get("id"));
		emfMap.put("regNm", lgnMap.get("name"));
		emfMap.put("communityName", emfMap.get("communityName") + "(복사)");
		
		cOHBoardMngDAO.insertBoardConfig(emfMap);
	}
	
	/**
	 * 게시판 배너 속성 정보를 수정한다.
	 */
	public void updateBanrConfig(EmfMap emfMap) throws Exception
	{
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("modId", lgnMap.get("id"));
		emfMap.put("modNm", lgnMap.get("name"));
    	
		cOHBoardMngDAO.updateBanrConfig(emfMap);		
	}
}