package mngwserc.cm.cmb.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mngwserc.cm.cmb.service.CMBChngPrdctService;
import mngwserc.cm.cmb.service.dao.CMBChngPrdctDAO;
import mngwserc.co.util.COPaginationUtil;
import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.idgnr.impl.EgovTableIdGnrService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import emf.core.extend.service.EmfAbstractService;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 전환서비스 상품관리를 위한 ServiceImpl
 * </pre>
 * 
 * @ClassName		: CMBChngPrdctServiceImpl.java
 * @Description		: 전환서비스 상품관리를 위한 ServiceImpl
 * @author 김대환
 * @since 2016.02.17
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author				  description
 *   ===========    ==============    =============================
 *    2016.02.17		김대환				   최초 생성
 * </pre>
 */
@Service("cMBChngPrdctService")
public class CMBChngPrdctServiceImpl extends EmfAbstractService implements CMBChngPrdctService {

	@Resource(name="cMBChngPrdctDAO")
	private CMBChngPrdctDAO cMBChngPrdctDAO;
	
	@Resource(name="EgovCmmUseService")
    private EgovCmmUseService cmmUseService;
	
	@Resource(name="prdctIdgen")
	private EgovTableIdGnrService prdctIdgen;
	
	/**
     * 전환서비스 상품 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public EmfMap selectChngPrdctList(EmfMap emfMap) throws Exception 
	{
		PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
		
		//페이징 처리
		emfMap.put("paginationInfo", paginationInfo);    	
		
		//리스트 가져오기
		List<EmfMap> list = cMBChngPrdctDAO.selectChngPrdctList(emfMap);

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
		
		//상품구분
		cdDtlList.add("PRDCT_GB");
		
		//정의된 코드id값들의 상세 코드 맵 반환		
		emfMap.put("cdDtlList", cmmUseService.selectCmmCodeBindAll(cdDtlList));
		
		return emfMap;
	}
	
	/**
     * 전환서비스 상품 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public EmfMap selectChngPrdct(EmfMap emfMap) throws Exception 
	{
		if(!"".equals(EMFStringUtil.nullConvert(emfMap.get("prdctSeq"))))
    	{
    		EmfMap prdctInfo = cMBChngPrdctDAO.selectChngPrdct(emfMap);
    		
	    	if(prdctInfo != null)
	    	{
	    		emfMap.put("prdctInfo", prdctInfo);
	    	}
    	}
    	
    	//공통코드 배열 셋팅
		ArrayList<String> cdDtlList = new ArrayList<String>();
		
		//상품구분
		cdDtlList.add("PRDCT_GB");
		
		//정의된 코드id값들의 상세 코드 맵 반환		
		emfMap.put("cdDtlList", cmmUseService.selectCmmCodeBindAll(cdDtlList));
		
		return emfMap;
	}

	/**
     * 전환서비스 상품을 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertChngPrdct(EmfMap emfMap) throws Exception 
	{
		EmfMap lgnMap = (EmfMap)EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("prdctSeq", prdctIdgen.getNextIntegerId());
		emfMap.put("regId", lgnMap.getString("id"));
		emfMap.put("regIp", lgnMap.getString("loginIp"));
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		cMBChngPrdctDAO.insertChngPrdct(emfMap);
	}
	
	/**
     * 전환서비스 상품을 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateChngPrdct(EmfMap emfMap) throws Exception {
		
		EmfMap lgnMap = (EmfMap)EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		cMBChngPrdctDAO.updateChngPrdct(emfMap);
	}
	
	/**
     * 전환서비스 상품을 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteChngPrdctList(int[] delSeq) throws Exception 
	{
		EmfMap emfMap = new EmfMap();
		
		emfMap.put("delSeq", delSeq);
		
		cMBChngPrdctDAO.deleteChngPrdct(emfMap);
	}

    /**
	 * 전환서비스 상품을 복사한다.
	 * 
	 * @param EmfMap 검색데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */	
	public void insertChngPrdctCopy(EmfMap emfMap) throws Exception 
	{
		EmfMap lgnMap = (EmfMap)EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("prdctSeq", prdctIdgen.getNextIntegerId());
		emfMap.put("regId", lgnMap.getString("id"));
		emfMap.put("regIp", lgnMap.getString("loginIp"));
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		cMBChngPrdctDAO.insertChngPrdctCopy(emfMap);
	}
}
