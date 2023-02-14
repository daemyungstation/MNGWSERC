package mngwserc.pr.prb.service.impl;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import mngwserc.pr.prb.service.PRBNaverTestPromotionMngService;
import mngwserc.pr.prb.service.dao.PRBNaverTestPromotionMngDAO;
import mngwserc.co.util.COPaginationUtil;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.service.EgovFileMngUtil;
import egovframework.com.cmm.service.EgovProperties;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import emf.core.extend.service.EmfAbstractService;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 네이버 실검 테스트 프로모션 관리 구현
 * </pre>
 * 
 * @ClassName		: PRBNaverTestPromotionMngImpl.java
 * @Description		: 네이버 실검 테스트 프로모션 구현
 * @author inuscomm
 * @since 2019. 07. 16.
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2019. 07. 16.	   inuscomm				                최초생성
 * </pre>
 */

@Service("pRBNaverTestPromotionMngService")
public class PRBNaverTestPromotionMngImpl extends EmfAbstractService implements PRBNaverTestPromotionMngService {
	
	@Resource(name="pRBNaverTestPromotionMngDAO")
	private PRBNaverTestPromotionMngDAO pRBNaverTestPromotionMngDAO;
	
	/**
	 * 설정을 조회 한다.
	 * 
	 * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public EmfMap selectConfigList(EmfMap emfMap) throws Exception {

		List<EmfMap> list = pRBNaverTestPromotionMngDAO.selectConfigList(emfMap);
		emfMap.put("list", list);

		return emfMap;
	}
	
	/**
	 * 설정을 업데이트 한다.
	 * 
	 * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void updateConfig(EmfMap emfMap) throws Exception {
		EmfMap rtnMap = new EmfMap();
		String pntecSday = (String) emfMap.get("pntecSday");
		String pntecEday = (String) emfMap.get("pntecEday");
		rtnMap.put("PNTEC_STIME", pntecSday.replaceAll("-", "/") +" "+ emfMap.get("pntecShh") +":"+ emfMap.get("pntecSmm") +":"+ emfMap.get("pntecSss"));
		rtnMap.put("PNTEC_ETIME", pntecEday.replaceAll("-", "/") +" "+ emfMap.get("pntecEhh") +":"+ emfMap.get("pntecEmm") +":"+ emfMap.get("pntecEss"));
		rtnMap.put("PNTEC_NAVER_CHECK", emfMap.get("pntecNaverCheck"));
		rtnMap.put("PNTEC_FROMURL_CHECK", emfMap.get("pntecFromurlCheck"));
		rtnMap.put("PNTEC_DIVISION", emfMap.get("pntecDivision"));
		pRBNaverTestPromotionMngDAO.updateConfig(rtnMap);		
	}
	
	
	
    /**
	 * 응모내역을 조회 한다.
	 * 
	 * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public EmfMap selectList(EmfMap emfMap) throws Exception {

		PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
		
		//페이징 처리
		emfMap.put("paginationInfo", paginationInfo);    
				
		//리스트 가져오기
		List<EmfMap> list = pRBNaverTestPromotionMngDAO.selectList(emfMap);
		
		emfMap.put("list", list);
		
		if(list.size() > 0)
		{
			paginationInfo.setTotalRecordCount(Integer.parseInt(list.get(0).getString("totCnt")));
		}
		else
		{
			paginationInfo.setTotalRecordCount(0);
		}

		return emfMap;
	}
	
	/**
	 * 응모내역을 다운로드 한다.
	 * 
	 * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public EmfMap selectExcelList(EmfMap emfMap) throws Exception {

		//리스트 가져오기
		List<EmfMap> list = pRBNaverTestPromotionMngDAO.selectExcelList(emfMap);
		emfMap.put("list", list);

		return emfMap;
	}
	
	/**
	 * Pv내역을 조회 한다.
	 * 
	 * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public EmfMap selectPvList(EmfMap emfMap) throws Exception {

		PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
		
		//페이징 처리
		emfMap.put("paginationInfo", paginationInfo);    
				
		//리스트 가져오기
		List<EmfMap> list = pRBNaverTestPromotionMngDAO.selectPvList(emfMap);
		
		emfMap.put("list", list);
		
		if(list.size() > 0)
		{
			paginationInfo.setTotalRecordCount(Integer.parseInt(list.get(0).getString("totCnt")));
		}
		else
		{
			paginationInfo.setTotalRecordCount(0);
		}

		return emfMap;
	}
	
	/**
	 * Pv내역을 다운로드 한다.
	 * 
	 * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public EmfMap selectPvExcelList(EmfMap emfMap) throws Exception {

		//리스트 가져오기
		List<EmfMap> list = pRBNaverTestPromotionMngDAO.selectPvExcelList(emfMap);
		emfMap.put("list", list);

		return emfMap;
	}
}