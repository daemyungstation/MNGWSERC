package mngwserc.cm.cme.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import mngwserc.cm.cme.service.CMETermsGroupMngService;
import mngwserc.cm.cme.service.dao.CMETermsGroupMngDAO;
import mngwserc.co.util.COPaginationUtil;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.idgnr.impl.EgovTableIdGnrService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import emf.core.extend.service.EmfAbstractService;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 상품 약관그룹관리를 위한 ServiceImpl
 * </pre>
 * 
 * @ClassName		: CMETermsGroupMngServiceImpl.java
 * @Description		: 상품 약관그룹관리를 위한 ServiceImpl
 * @author 김필기
 * @since 2016.02.17
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2016.02.17		김필기					 최초생성
 * </pre>
 */ 
@Service("cMETermsGroupMngService")
public class CMETermsGroupMngServiceImpl extends EmfAbstractService implements CMETermsGroupMngService {
	
	@Resource(name="cMETermsGroupMngDAO")
	private CMETermsGroupMngDAO cMETermsGroupMngDAO;
	
	@Resource(name="EgovCmmUseService")
    private EgovCmmUseService cmmUseService;	
	
	@Resource(name="trsGrpPrdctIdgen")
	private EgovTableIdGnrService trsGrpPrdctIdgen;
	
	@Resource(name="trsGrpIdgen")
	private EgovTableIdGnrService trsGrpIdgen;	
	
	@Resource(name="trsGrpMstLogIdgen")
	private EgovTableIdGnrService trsGrpMstLogIdgen;
	
	@Resource(name="trsGrpLogIdgen")
	private EgovTableIdGnrService trsGrpLogIdgen;	
	
	/**
     * 상품 약관그룹관리 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectTermsGroupMngList(EmfMap emfMap) throws Exception
    {
    	PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
		emfMap.put("paginationInfo", paginationInfo);   	//페이징 처리
				
		List<EmfMap> termsGroupList = cMETermsGroupMngDAO.selectTermsGroupMngList(emfMap);	//리스트 가져오기
		
		emfMap.put("list", termsGroupList);
		
		if(termsGroupList.size() > 0)
		{
			paginationInfo.setTotalRecordCount(Integer.parseInt(termsGroupList.get(0).getString("totCnt")));
		}
		else
		{
			paginationInfo.setTotalRecordCount(0);
		}    	
    	
		ArrayList<String> cdDtlList = new ArrayList<String>();		//공통코드 배열 셋팅
		cdDtlList.add("TRS_GB");	// 상품약관 구분
		cdDtlList.add("CONTRACT_GB");	// 상품약관 구분
		emfMap.put("cdDtlList", cmmUseService.selectCmmCodeBindAll(cdDtlList));	//정의된 코드id값들의 상세 코드 맵 반환
				
		return emfMap;
    }
    
    public List<EmfMap> selectTermsGroupMngListAll(EmfMap emfMap) throws Exception
    {
    	return cMETermsGroupMngDAO.selectTermsGroupMngListAll(emfMap);	// 전체 리스트 가져오기
    }
    
    /**
     * 상품 약관그룹관리 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    /*public EmfMap selectTermsGroupMng(EmfMap emfMap) throws Exception
    {
    	return emfMap;
    }*/
    
	/**
     * 상품 약관그룹관리을 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertTermsGroupMng(MultipartHttpServletRequest multiRequest, EmfMap emfMap) throws Exception
	{		
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();	// 로그인 사용자 정보

		if(!"".equals(emfMap.get("prdctCd").toString())){
			Integer checkCnt = cMETermsGroupMngDAO.selectCheckProductCode(emfMap);
			
			/*
			ArrayList<String> cdDtlList = new ArrayList<String>();		//공통코드 배열 셋팅		
			cdDtlList.add("TRS_GB");	// 상품약관 구분
			EmfMap cdDtMap = cmmUseService.selectCmmCodeBindAll(cdDtlList);	//정의된 코드id값들의 상세 코드 맵 반환
			ArrayList<EmfMap> trsGbMapList = (ArrayList<EmfMap>)cdDtMap.get("trsGb");
			
			for(int i = 0 ; i < trsGbMapList.size() ; i++){
				EmfMap trsGbMap = trsGbMapList.get(i);
			}		
			*/
			
			if(checkCnt == 0){
				emfMap.put("trsGrpPrdctSeq", trsGrpPrdctIdgen.getNextIntegerId());	// seq값 설정
				emfMap.put("regIp", lgnMap.getString("loginIp"));	// ip설정
				emfMap.put("regId", lgnMap.getString("id"));	// id설정
							
				cMETermsGroupMngDAO.insertTermsGroupMng(emfMap);	// Step1 : 상품 약관그룹의 상품정보 등록
				
				emfMap.put("trsGrpSeq", trsGrpIdgen.getNextIntegerId());	// seq값 설정

				emfMap.put("trsGb", "TRS_GB");	// seq값 설정			
				cMETermsGroupMngDAO.insertTermsGroupDtl(emfMap);		// Step2 : 상품 약관 노출 여부를 등록

				emfMap.put("trsGb", "CONTRACT_GB");	// seq값 설정				
				cMETermsGroupMngDAO.insertTermsGroupDtl(emfMap);		// Step3 : 계약안내 노출 여부를 등록
				
				EmfMap logMap = new EmfMap();	// 로그를 위한 맵

				logMap.put("prdctCd", emfMap.get("prdctCd"));	// 상품코드

				logMap.put("trsGrpMstLogSeq", trsGrpMstLogIdgen.getNextIntegerId());
				cMETermsGroupMngDAO.insertTermsGroupMngLog(logMap);	// 상품 약관그룹의 상품정보 등록 로그
				
				logMap.put("trsGrpLogSeq", trsGrpLogIdgen.getNextIntegerId());
				cMETermsGroupMngDAO.insertTermsGroupDtlLog(logMap);		// 상품 약관 노출 여부 로그를 등록			
			}					
		}
	}
	
	/**
     * 상품 약관그룹관리을 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateTermsGroupMng(EmfMap emfMap) throws Exception
	{
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();	// 로그인 사용자 정보
			
		for(String cdId : emfMap.keySet()){
			if(cdId != "prdctCd"){
				EmfMap termsMap = new EmfMap();
				
				termsMap.put("prdctCd", emfMap.get("prdctCd"));
				termsMap.put("cdId", cdId);
				termsMap.put("expsYn", emfMap.get(cdId));
				
				cMETermsGroupMngDAO.updateTermsGroupDtlMng(termsMap);
				
				termsMap.put("modIp", lgnMap.getString("loginIp"));	// ip설정
				termsMap.put("modId", lgnMap.getString("id"));	// id설정
				termsMap.put("modDtm", emfMap.get("modDtm"));	// 적용일 설정				
				
				cMETermsGroupMngDAO.updateTermsGroupMng(termsMap);				
			}
		}
		
		EmfMap logMap = new EmfMap();	// 로그를 위한 맵

		logMap.put("prdctCd", emfMap.get("prdctCd"));	// 상품코드

		logMap.put("trsGrpMstLogSeq", trsGrpMstLogIdgen.getNextIntegerId());
		cMETermsGroupMngDAO.insertTermsGroupMngLog(logMap);	// 상품 약관그룹의 상품정보 등록 로그
		
		logMap.put("trsGrpLogSeq", trsGrpLogIdgen.getNextIntegerId());
		cMETermsGroupMngDAO.insertTermsGroupDtlLog(logMap);		// 상품 약관 노출 여부 로그를 등록				
		
	}
	
	/**
     * 상품 약관그룹관리을 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteTermsGroupMngList(EmfMap emfMap) throws Exception
	{
		cMETermsGroupMngDAO.deleteTermsGroupDtlMng(emfMap);
		cMETermsGroupMngDAO.deleteTermsGroupMng(emfMap);
	}
	
	public EmfMap logTermGroupLogExcelList(EmfMap emfMap) throws Exception
    {
		List<EmfMap> termsGroupList = cMETermsGroupMngDAO.logTermGroupLogExcelList(emfMap);	//리스트 가져오기

		emfMap.put("list", termsGroupList);

		ArrayList<String> cdDtlList = new ArrayList<String>();		//공통코드 배열 셋팅
		cdDtlList.add("TRS_GB");	// 상품약관 구분
		cdDtlList.add("CONTRACT_GB");	// 계약안내 구분
		emfMap.put("cdDtlList", cmmUseService.selectCmmCodeBindAll(cdDtlList));	//정의된 코드id값들의 상세 코드 맵 반환
		
		return emfMap;
    }
	
	public void insertAddTerms(EmfMap emfMap) throws Exception
	{
		cMETermsGroupMngDAO.insertAddTerms(emfMap);
	}
	
	
	   
	/**
     * 상품 약관그룹관리을 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void selectTermsGroupExcel(EmfMap emfMap) throws Exception
	{		
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();	// 로그인 사용자 정보

		List<EmfMap> excellist = cMETermsGroupMngDAO.selectTermsGroupExcelList(emfMap);

		if(excellist.size() > 0){
			for(int i = 0 ; i < excellist.size() ; i++){
				
				EmfMap tempMap = excellist.get(i);
				//System.out.println(tempMap);
				
				emfMap.put("prdctCd", tempMap.getString("코드"));
				emfMap.put("prdctNm", tempMap.getString("상품명"));
				
				
				System.out.println(tempMap);
				
				emfMap.put("trsGrpPrdctSeq", trsGrpPrdctIdgen.getNextIntegerId());	// seq값 설정
				emfMap.put("regIp", lgnMap.getString("loginIp"));	// ip설정
				emfMap.put("regId", lgnMap.getString("id"));	// id설정
				emfMap.put("modDtm", tempMap.getString("적용시점"));
							
				cMETermsGroupMngDAO.insertTermsGroupMng(emfMap);	// Step1 : 상품 약관그룹의 상품정보 등록
				
				// 상조약관
				emfMap.put("cd", "ITDPD");
				if("Y".equals(tempMap.getString("상조약관"))){
					emfMap.put("trsExpsYn", "Y");
				}else{
					emfMap.put("trsExpsYn", "N");
				}
				emfMap.put("trsGrpSeq", trsGrpIdgen.getNextIntegerId());	// seq값 설정
				cMETermsGroupMngDAO.insertTermsGroupExcelDtl(emfMap);
				
				// 리조트약관
				emfMap.put("cd", "RST");
				if("Y".equals(tempMap.getString("리조트약관"))){
					emfMap.put("trsExpsYn", "Y");
				}else{
					emfMap.put("trsExpsYn", "N");
				}
				emfMap.put("trsGrpSeq", trsGrpIdgen.getNextIntegerId());	// seq값 설정
				cMETermsGroupMngDAO.insertTermsGroupExcelDtl(emfMap);				
				
				// Ocb약관
				emfMap.put("cd", "OCB");
				if("Y".equals(tempMap.getString("ycb약관"))){
					emfMap.put("trsExpsYn", "Y");
				}else{
					emfMap.put("trsExpsYn", "N");
				}
				emfMap.put("trsGrpSeq", trsGrpIdgen.getNextIntegerId());	// seq값 설정
				cMETermsGroupMngDAO.insertTermsGroupExcelDtl(emfMap);		
				
				//  선불카드약관
				emfMap.put("cd", "CTINFO01");
				if("Y".equals(tempMap.getString("선불카드약관"))){
					emfMap.put("trsExpsYn", "Y");
				}else{
					emfMap.put("trsExpsYn", "N");
				}
				emfMap.put("trsGrpSeq", trsGrpIdgen.getNextIntegerId());	// seq값 설정
				cMETermsGroupMngDAO.insertTermsGroupExcelDtl(emfMap);						
				
				//  KB전자제품약관
				emfMap.put("cd", "CTINFO02");
				if("Y".equals(tempMap.getString("kb전자제품약관"))){
					emfMap.put("trsExpsYn", "Y");
				}else{
					emfMap.put("trsExpsYn", "N");
				}
				emfMap.put("trsGrpSeq", trsGrpIdgen.getNextIntegerId());	// seq값 설정
				cMETermsGroupMngDAO.insertTermsGroupExcelDtl(emfMap);

				//  전자제품약관
				emfMap.put("cd", "CTINFO05");
				if("Y".equals(tempMap.getString("전자제품약관"))){
					emfMap.put("trsExpsYn", "Y");
				}else{
					emfMap.put("trsExpsYn", "N");
				}
				emfMap.put("trsGrpSeq", trsGrpIdgen.getNextIntegerId());	// seq값 설정
				cMETermsGroupMngDAO.insertTermsGroupExcelDtl(emfMap);
					
				//  통신상품권약관
				emfMap.put("cd", "CTINFO03");
				if("Y".equals(tempMap.getString("통신상품권약관"))){
					emfMap.put("trsExpsYn", "Y");
				}else{
					emfMap.put("trsExpsYn", "N");
				}
				emfMap.put("trsGrpSeq", trsGrpIdgen.getNextIntegerId());	// seq값 설정
				cMETermsGroupMngDAO.insertTermsGroupExcelDtl(emfMap);

				//  하이세이프약관
				emfMap.put("cd", "CTINFO04");
				if("Y".equals(tempMap.getString("하이세이프약관"))){
					emfMap.put("trsExpsYn", "Y");
				}else{
					emfMap.put("trsExpsYn", "N");
				}
				emfMap.put("trsGrpSeq", trsGrpIdgen.getNextIntegerId());	// seq값 설정
				cMETermsGroupMngDAO.insertTermsGroupExcelDtl(emfMap);
				
				//  리빙
				emfMap.put("cd", "CTINFO06");
				if("Y".equals(tempMap.getString("리빙"))){
					emfMap.put("trsExpsYn", "Y");
				}else{
					emfMap.put("trsExpsYn", "N");
				}
				emfMap.put("trsGrpSeq", trsGrpIdgen.getNextIntegerId());	// seq값 설정
				cMETermsGroupMngDAO.insertTermsGroupExcelDtl(emfMap);

				//  렌탈약관
				emfMap.put("cd", "CTINFO07");
				if("Y".equals(tempMap.getString("렌탈약관"))){
					emfMap.put("trsExpsYn", "Y");
				}else{
					emfMap.put("trsExpsYn", "N");
				}
				emfMap.put("trsGrpSeq", trsGrpIdgen.getNextIntegerId());	// seq값 설정
				cMETermsGroupMngDAO.insertTermsGroupExcelDtl(emfMap);				
				
				//  충전계약약관
				emfMap.put("cd", "CTINFO08");
				if("Y".equals(tempMap.getString("충전계약약관"))){
					emfMap.put("trsExpsYn", "Y");
				}else{
					emfMap.put("trsExpsYn", "N");
				}
				emfMap.put("trsGrpSeq", trsGrpIdgen.getNextIntegerId());	// seq값 설정
				cMETermsGroupMngDAO.insertTermsGroupExcelDtl(emfMap);				
				
				////////////////////////////////////////////////////////////////
				
				EmfMap logMap = new EmfMap();	// 로그를 위한 맵

				logMap.put("prdctCd", emfMap.get("prdctCd"));	// 상품코드

				logMap.put("trsGrpMstLogSeq", trsGrpMstLogIdgen.getNextIntegerId());
				cMETermsGroupMngDAO.insertTermsGroupMngLog(logMap);	// 상품 약관그룹의 상품정보 등록 로그
				
				logMap.put("trsGrpLogSeq", trsGrpLogIdgen.getNextIntegerId());
				cMETermsGroupMngDAO.insertTermsGroupDtlLog(logMap);		// 상품 약관 노출 여부 로그를 등록			
				
			}
		}
	}	
}
