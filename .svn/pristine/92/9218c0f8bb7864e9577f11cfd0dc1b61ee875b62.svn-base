package mngwserc.cm.cme.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import mngwserc.cm.cme.service.CMETermsMngService;
import mngwserc.cm.cme.service.dao.CMETermsMngDAO;
import mngwserc.co.util.COPaginationUtil;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.idgnr.impl.EgovTableIdGnrService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import emf.core.extend.service.EmfAbstractService;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 약관별관리를 위한 ServiceImpl
 * </pre>
 * 
 * @ClassName		: CMETermsMngServiceImpl.java
 * @Description		: 약관별관리를 위한 ServiceImpl
 * @author 김필기
 * @since 2016.02.18
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2016.02.18		김필기					 최초생성
 * </pre>
 */ 
@Service("cMETermsMngService")
public class CMETermsMngServiceImpl extends EmfAbstractService implements CMETermsMngService {
	
	@Resource(name="cMETermsMngDAO")
	private CMETermsMngDAO cMETermsMngDAO;
	
	@Resource(name="EgovCmmUseService")
    private EgovCmmUseService cmmUseService;	
	
	@Resource(name="trsMstIdgen")
	private EgovTableIdGnrService trsMstIdgen;
	
	@Resource(name="trsDtlIdgen")
	private EgovTableIdGnrService trsDtlIdgen;	
	/**
     * 약관별관리 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectTermsMngList(EmfMap emfMap) throws Exception
    {
    	PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
		emfMap.put("paginationInfo", paginationInfo);   	//페이징 처리
				
		List<EmfMap> termsList = cMETermsMngDAO.selectTermsMngList(emfMap);	//리스트 가져오기
		
		emfMap.put("list", termsList);
		
		if(termsList.size() > 0)
		{
			paginationInfo.setTotalRecordCount(Integer.parseInt(termsList.get(0).getString("totCnt")));
		}
		else
		{
			paginationInfo.setTotalRecordCount(0);
		}    	
    	
		ArrayList<String> cdDtlList = new ArrayList<String>();		//공통코드 배열 셋팅
		cdDtlList.add("TRS_GB");	// 상품약관 구분
		cdDtlList.add("CONTRACT_GB");	// 계약안내 구분
		emfMap.put("cdDtlList", cmmUseService.selectCmmCodeBindAll(cdDtlList));	//정의된 코드id값들의 상세 코드 맵 반환
				
		return emfMap;
    }
    
    /**
     * 약관별관리 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectTermsMng(EmfMap emfMap) throws Exception
    {
    	String isview = "";
    	
		if(!"".equals(EMFStringUtil.nullConvert(emfMap.get("trsMstSeq"))))
    	{
			/*
	  		if(emfMap.get("isview")!=null){
	  			isview = (String)emfMap.get("isview");
	  		}
	  		
	  		//isview : 게시글 내용 iframe으로 재호출 구분값
	  		if(!"1".equals(isview)){
	  	  		//조회수 증가
	  			cMETermsMngDAO.updateReadCnt(emfMap);  	    			
	  		}*/
			
    		EmfMap termsInfo = cMETermsMngDAO.selectTermsMng(emfMap);
    		
	    	if(termsInfo != null)
	    	{
	    		emfMap.put("termsInfo", termsInfo);
	    	}
    	}
    	
		ArrayList<String> cdDtlList = new ArrayList<String>();		//공통코드 배열 셋팅
		cdDtlList.add("TRS_GB");	// 상품약관 구분
		cdDtlList.add("CONTRACT_GB");	// 계약안내 구분
		emfMap.put("cdDtlList", cmmUseService.selectCmmCodeBindAll(cdDtlList));	//정의된 코드id값들의 상세 코드 맵 반환
    	return emfMap;
    }
    
	/**
     * 약관별관리을 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertTermsMng(MultipartHttpServletRequest multiRequest, EmfMap emfMap) throws Exception
	{		
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();	// 로그인 사용자 정보
		
		emfMap.put("trsMstSeq", trsMstIdgen.getNextIntegerId());
		emfMap.put("regId", lgnMap.getString("id"));
		emfMap.put("regNm", lgnMap.getString("name"));
		emfMap.put("regIp", lgnMap.getString("loginIp"));
		
		cMETermsMngDAO.insertTermsMng(emfMap);	
	}
	
	/**
     * 약관별관리을 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateTermsMng(EmfMap emfMap) throws Exception
	{
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();	// 로그인 사용자 정보
	
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modNm", lgnMap.getString("name"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		cMETermsMngDAO.updateTermsMng(emfMap);				
	}
	
	/**
     * 약관별관리을 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteTermsMngList(EmfMap emfMap) throws Exception
	{
		cMETermsMngDAO.deleteTermsMng(emfMap);
		cMETermsMngDAO.deleteTermsMngDtl(emfMap);
	}
	
	/**
     * 약관을 복사한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */	
	public void insertCopyTermsMng(EmfMap emfMap) throws Exception
	{
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();	// 로그인 사용자 정보
		
		emfMap.put("trsMstSeq", emfMap.get("delSeq"));
		EmfMap termsInfo = cMETermsMngDAO.selectTermsMng(emfMap);	// 복사할 약관 정보
		
		termsInfo.put("trsMstSeq", trsMstIdgen.getNextIntegerId());
		termsInfo.put("regId", lgnMap.getString("id"));
		termsInfo.put("regNm", lgnMap.getString("name"));
		termsInfo.put("regIp", lgnMap.getString("loginIp"));
		termsInfo.put("applyDt", "");
		
		cMETermsMngDAO.insertTermsMng(termsInfo);
		
		EmfMap termDtlMap = new EmfMap();	
		termDtlMap.put("seq", emfMap.getString("trsMstSeq"));

		// LEV 1
		termDtlMap.put("lev", 1);
		List<EmfMap> termInfListMap = cMETermsMngDAO.selectTermsDtl(termDtlMap);
				
		for(int i = 0 ; i < termInfListMap.size() ; i++){
			EmfMap tempMap = new EmfMap();
			
			tempMap = termInfListMap.get(i);
			tempMap.put("seq", trsDtlIdgen.getNextIntegerId());
			tempMap.put("oldSeq", tempMap.getString("trsDtlSeq"));
			tempMap.put("trsMstSeq", termsInfo.getString("trsMstSeq"));
			
			cMETermsMngDAO.insertTermsDtl(tempMap);			
		}
		
		// LEV 2
		termDtlMap.put("lev", 2);
		List<EmfMap> termInfListMap2 = cMETermsMngDAO.selectTermsDtl(termDtlMap);
				
		for(int i = 0 ; i < termInfListMap2.size() ; i++){
			EmfMap tempMap = new EmfMap();
			
			tempMap = termInfListMap2.get(i);
			tempMap.put("seq", trsDtlIdgen.getNextIntegerId());
			tempMap.put("oldSeq", tempMap.getString("trsDtlSeq"));
			tempMap.put("trsMstSeq", termsInfo.getString("trsMstSeq"));
						
			tempMap.put("parentSeq", cMETermsMngDAO.selectOldTermsDtl(tempMap));
			
			cMETermsMngDAO.insertTermsDtl(tempMap);			
		}
		
		// LEV 3
		termDtlMap.put("lev", 3);
		List<EmfMap> termInfListMap3 = cMETermsMngDAO.selectTermsDtl(termDtlMap);
				
		for(int i = 0 ; i < termInfListMap3.size() ; i++){
			EmfMap tempMap = new EmfMap();
			
			tempMap = termInfListMap3.get(i);
			tempMap.put("seq", trsDtlIdgen.getNextIntegerId());
			tempMap.put("oldSeq", tempMap.getString("trsDtlSeq"));
			tempMap.put("trsMstSeq", termsInfo.getString("trsMstSeq"));
						
			tempMap.put("parentSeq", cMETermsMngDAO.selectOldTermsDtl(tempMap));
			
			cMETermsMngDAO.insertTermsDtl(tempMap);			
		}		
	}
	
	  
	/**
     * 약관별관리 상세내용을 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertTermsDtl(EmfMap emfMap) throws Exception
	{		
		emfMap.put("seq", trsDtlIdgen.getNextIntegerId());
		
		cMETermsMngDAO.insertTermsDtl(emfMap);	
	}	
	
	/**
     * 약관별관리 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectTermsDtl(EmfMap emfMap) throws Exception
    {
    	emfMap.put("lev", 1);    	
		List<EmfMap> termLevel1Dtl = cMETermsMngDAO.selectTermsDtl(emfMap);
		
    	emfMap.put("lev", 2);
		List<EmfMap> termLevel2Dtl = cMETermsMngDAO.selectTermsDtl(emfMap);
		
    	emfMap.put("lev", 3);
		List<EmfMap> termLevel3Dtl = cMETermsMngDAO.selectTermsDtl(emfMap);
		
		for(int i = 0 ; i < termLevel2Dtl.size() ; i++){
			List<EmfMap> tempListMap = new ArrayList<EmfMap>();
			EmfMap tempMap2 = termLevel2Dtl.get(i);			
			for(int j = 0 ; j < termLevel3Dtl.size() ; j++){
				EmfMap tempMap3 = termLevel3Dtl.get(j);				
				if(tempMap2.getString("trsDtlSeq").equals(tempMap3.getString("parentSeq"))){					
					tempListMap.add(tempMap3);				
				}
			}

			tempMap2.put("level3List", tempListMap);
			termLevel2Dtl.set(i, tempMap2);
		}
		
		for(int i = 0 ; i < termLevel1Dtl.size() ; i++){
			List<EmfMap> tempListMap = new ArrayList<EmfMap>();
			EmfMap tempMap1 = termLevel1Dtl.get(i);			
			for(int j = 0 ; j < termLevel2Dtl.size() ; j++){
				EmfMap tempMap2 = termLevel2Dtl.get(j);				
				if(tempMap1.getString("trsDtlSeq").equals(tempMap2.getString("parentSeq"))){					
					tempListMap.add(tempMap2);				
				}
			}

			tempMap1.put("level2List", tempListMap);
			termLevel1Dtl.set(i, tempMap1);
		}		
		
		emfMap.put("list", termLevel1Dtl);
				
		return emfMap;
    }	
    
    /**
     * 약관별 상세내용을 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateTermDtl(EmfMap emfMap) throws Exception
	{
		cMETermsMngDAO.updateTermDtl(emfMap);				
	}    
    
	/**
     * 약관 상세내용을 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteTermsDtl(EmfMap emfMap) throws Exception
	{
		cMETermsMngDAO.deleteTermsDtl(emfMap);
	}	
}
