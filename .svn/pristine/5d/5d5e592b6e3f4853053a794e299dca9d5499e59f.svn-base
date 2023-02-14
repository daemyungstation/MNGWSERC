package mngwserc.cm.cma.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import mngwserc.cm.cma.service.CMAOnlinePrdctCsMngService;
import mngwserc.cm.cma.service.DmLifeService;
import mngwserc.cm.cma.service.dao.CMAOnlinePrdctCsMngDAO;
import mngwserc.co.util.COPaginationUtil;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.service.EgovProperties;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.com.utl.sim.service.SeedCipher;
import egovframework.rte.fdl.idgnr.impl.EgovTableIdGnrService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import emf.core.extend.service.EmfAbstractService;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 온라인 상담신청를 위한 ServiceImpl
 * </pre>
 * 
 * @ClassName		: CMAOnlinePrdctCsMngServiceImpl.java
 * @Description		: 온라인 상담신청를 위한 ServiceImpl
 * @author 김필기
 * @since 2016.02.22
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2016.02.22		김필기					 최초생성
 * </pre>
 */ 
@Service("cMAOnlinePrdctCsMngService")
public class CMAOnlinePrdctCsMngServiceImpl extends EmfAbstractService implements CMAOnlinePrdctCsMngService {
	
	@Resource(name="cMAOnlinePrdctCsMngDAO")
	private CMAOnlinePrdctCsMngDAO cMAOnlinePrdctCsMngDAO;
	
	@Resource(name = "dMLifeService")
    private DmLifeService dMLifeService;
	
	@Resource(name="EgovCmmUseService")
    private EgovCmmUseService cmmUseService;	
	
	@Resource(name="onlinePrdctCsMstIdgen")
	private EgovTableIdGnrService onlinePrdctCsMstIdgen;
	
	private String ENCODE = EgovProperties.getProperty("Global.CHARCODE");
	
	/**
     * 온라인 상담신청 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectOnlinePrdctCsMngList(EmfMap emfMap) throws Exception
    {
    	PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
		emfMap.put("paginationInfo", paginationInfo);   	//페이징 처리
				
		List<EmfMap> OnlinePrdctCsList = cMAOnlinePrdctCsMngDAO.selectOnlinePrdctCsMngList(emfMap);	//리스트 가져오기
		
		if(OnlinePrdctCsList.size() > 0)
		{
			EmfMap tmpMap = new EmfMap();
			EmfMap tmpMap2 = new EmfMap();
			EmfMap tmpMap3 = new EmfMap();
			
			List<String> cellList = new ArrayList<String>();
			List<String> nameList = new ArrayList<String>();
			
			for(int i = 0; i < OnlinePrdctCsList.size(); i++)
			{
				tmpMap = OnlinePrdctCsList.get(i);
				//2017.04.24 박주석 디아모 솔루션 도입 작업
//				if(!"".equals(EMFStringUtil.nullConvert(tmpMap.get("hp"))))
//				{
//					tmpMap.put("hp", SeedCipher.decrypt(tmpMap.getString("hp"), ENCODE));
//				}
				
				nameList.add(tmpMap.getString("name"));
				if(!"".equals(tmpMap.getString("hp"))){
					cellList.add(tmpMap.getString("hp").replace("-", ""));
				}
				
				OnlinePrdctCsList.get(i).put("hp", tmpMap.getString("hp"));
			}

			EmfMap dmLifeMem = new EmfMap();
			dmLifeMem.put("name", nameList);
			dmLifeMem.put("cell", cellList);
			
			List<EmfMap> memNoList = dMLifeService.selectDMLifeMemInf(dmLifeMem); 
			
			if(memNoList.size() > 0){
				for(int i = 0 ; i < memNoList.size() ; i++){
					tmpMap2 = memNoList.get(i);

					for(int j = 0 ; j < OnlinePrdctCsList.size() ; j++){
						tmpMap3 = OnlinePrdctCsList.get(j);	

						if(!"".equals(tmpMap3.getString("hp"))){
							if(tmpMap3.getString("hp").replace("-", "").equals(tmpMap2.getString("cell"))){
								OnlinePrdctCsList.get(j).put("memNo", tmpMap2.getString("memNo"));
								OnlinePrdctCsList.get(j).put("accntNo", tmpMap2.getString("accntNo"));
								OnlinePrdctCsList.get(j).put("prodNm", tmpMap2.getString("prodNm"));
								OnlinePrdctCsList.get(j).put("joinDt", tmpMap2.getString("joinDt"));								
							}
						}						
					}
				}
			}			
			
			emfMap.put("list", OnlinePrdctCsList);
			paginationInfo.setTotalRecordCount(Integer.parseInt(OnlinePrdctCsList.get(0).getString("totCnt")));
		}
		else
		{
			paginationInfo.setTotalRecordCount(0);
		}    	
    	
		ArrayList<String> cdDtlList = new ArrayList<String>();		//공통코드 배열 셋팅
		cdDtlList.add("PROCESS_TYPE");		// 처리현황 구분
		emfMap.put("cdDtlList", cmmUseService.selectCmmCodeBindAll(cdDtlList));	//정의된 코드id값들의 상세 코드 맵 반환
				
		return emfMap;
    }
    
    /**
     * 온라인 상담신청 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectOnlinePrdctCsMng(EmfMap emfMap) throws Exception
    {
    	
		if(!"".equals(EMFStringUtil.nullConvert(emfMap.get("seq"))))	// 상세조회
    	{
    		EmfMap onlinePrdctCsInfo = cMAOnlinePrdctCsMngDAO.selectOnlinePrdctCsMng(emfMap);	// 고객정보 조회
    		
	    	if(onlinePrdctCsInfo != null)
	    	{
	    		//2017.04.24 박주석 디아모 솔루션 도입 작업
//	    		if(!"".equals(EMFStringUtil.nullConvert(onlinePrdctCsInfo.get("hp"))))
//	    		{
//	    			onlinePrdctCsInfo.put("hp", SeedCipher.decrypt(onlinePrdctCsInfo.getString("hp"), ENCODE));
//	    		}
//	    		
//	    		if(!"".equals(EMFStringUtil.nullConvert(onlinePrdctCsInfo.get("tel"))))
//	    		{
//	    			onlinePrdctCsInfo.put("tel", SeedCipher.decrypt(onlinePrdctCsInfo.getString("tel"), ENCODE));
//	    		}
//	    		
//	    		if(!"".equals(EMFStringUtil.nullConvert(onlinePrdctCsInfo.get("email"))))
//	    		{
//	    			onlinePrdctCsInfo.put("email", SeedCipher.decrypt(onlinePrdctCsInfo.getString("email"), ENCODE));
//	    		}	    		
//
//	    		if(!"".equals(EMFStringUtil.nullConvert(onlinePrdctCsInfo.get("adrDtl"))))
//	    		{
//	    			onlinePrdctCsInfo.put("adrDtl", SeedCipher.decrypt(onlinePrdctCsInfo.getString("adrDtl"), ENCODE));
//	    		}
//	    		if(!"".equals(EMFStringUtil.nullConvert(onlinePrdctCsInfo.get("adrDtl2"))))
//	    		{
//	    			onlinePrdctCsInfo.put("adrDtl2", SeedCipher.decrypt(onlinePrdctCsInfo.getString("adrDtl2"), ENCODE));
//	    		}	    		
	    		
	    		List<EmfMap> onlinePrdctInf = cMAOnlinePrdctCsMngDAO.selectOnlinePrdctInf(emfMap);		// 신청상품정보 조회
	    		
	    		EmfMap onlinePrdctAcntInf = cMAOnlinePrdctCsMngDAO.selectOnlinePrdctAcntInf(emfMap);		// 계좌정보 조회	    		
	    		
	    		//2017.04.24 박주석 디아모 솔루션 도입 작업
//	    		if(!"".equals(EMFStringUtil.nullConvert(onlinePrdctAcntInf.get("acntHp"))))
//	    		{
//	    			onlinePrdctAcntInf.put("acntHp", SeedCipher.decrypt(onlinePrdctAcntInf.getString("acntHp"), ENCODE));
//	    		}
//	    		if(!"".equals(EMFStringUtil.nullConvert(onlinePrdctAcntInf.get("pmtNo"))))
//	    		{
//	    			onlinePrdctAcntInf.put("pmtNo", SeedCipher.decrypt(onlinePrdctAcntInf.getString("pmtNo"), ENCODE));
//	    		}
	    		
	    		// 전산DB 공통코드정보 조회
	    		if(!"".equals(EMFStringUtil.nullConvert(onlinePrdctAcntInf.getString("pmtCoGb"))) && !"".equals(EMFStringUtil.nullConvert(onlinePrdctAcntInf.getString("pmtCoGrpGb"))))
	    		{
		    		EmfMap comCdInfMap = dMLifeService.selectComCdInf(onlinePrdctAcntInf);
		    		comCdInfMap = (EmfMap)comCdInfMap.get("comCdInf");
		    		
		    		onlinePrdctAcntInf.put("pmtCoGb", comCdInfMap.getString("cdNm"));	    			
	    		}

	    		emfMap.put("onlinePrdctCsInfo", onlinePrdctCsInfo);	    		
	    		emfMap.put("onlinePrdctInf", onlinePrdctInf);	    		
	    		emfMap.put("onlinePrdctAcntInf", onlinePrdctAcntInf);	    		
	    	}
    	}else{	// 작성화면
    		List<EmfMap> onlinePrdctList = cMAOnlinePrdctCsMngDAO.selectOnlinePrdctList(emfMap);	// 상품그룹 조회    		
    		emfMap.put("prdctGrpList", onlinePrdctList);
    	}
    	
		
		ArrayList<String> cdDtlList = new ArrayList<String>();		//공통코드 배열 셋팅
		cdDtlList.add("PROCESS_TYPE");		// 처리현황 구분
		cdDtlList.add("B2B_PRDCT_CD");		// 온라인 B2B 상품 코드
		//cdDtlList.add("BANK_GB");				// 은행코드
		//cdDtlList.add("CARD_GB");				// 카드사코드
		//cdDtlList.add("PMT_DAY_GB");		// 납부일
		cdDtlList.add("HAPPY_CALL");		// 해피콜 가능시간
		
		emfMap.put("cdDtlList", cmmUseService.selectCmmCodeBindAll(cdDtlList));	//정의된 코드id값들의 상세 코드 맵 반환
		
    	return emfMap;
    }
    
	/**
     * 온라인 상담신청을 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertOnlinePrdctCsMng(MultipartHttpServletRequest multiRequest, EmfMap emfMap) throws Exception
	{		
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();	// 로그인 사용자 정보
		
		emfMap.put("onlinePrdctCsMstSeq", onlinePrdctCsMstIdgen.getNextIntegerId());
		emfMap.put("regId", lgnMap.getString("id"));
		emfMap.put("regNm", lgnMap.getString("name"));
		emfMap.put("regIp", lgnMap.getString("loginIp"));
		//2017.04.24 박주석 디아모 솔루션 도입 작업
//		if(!"".equals(EMFStringUtil.nullConvert(emfMap.get("email")))){
//			emfMap.put("email", SeedCipher.encrypt(emfMap.getString("email"), ENCODE));	// 이메일 암호화	
//		}
//		if(!"".equals(EMFStringUtil.nullConvert(emfMap.get("hp")))){
//			emfMap.put("hp", SeedCipher.encrypt(emfMap.getString("hp"), ENCODE));	// 핸드폰 암호화	
//		}
//		if(!"".equals(EMFStringUtil.nullConvert(emfMap.get("tel")))){
//			emfMap.put("tel", SeedCipher.encrypt(emfMap.getString("tel"), ENCODE));	// 전화번호 암호화	
//		}
//		if(!"".equals(EMFStringUtil.nullConvert(emfMap.get("adrDtl")))){
//			emfMap.put("adrDtl", SeedCipher.encrypt(emfMap.getString("adrDtl"), ENCODE));	// 상세주소 암호화	
//		}
//		if(!"".equals(EMFStringUtil.nullConvert(emfMap.get("adrDtl2")))){
//			emfMap.put("adrDtl2", SeedCipher.encrypt(emfMap.getString("adrDtl2"), ENCODE));	// 상세주소 암호화	
//		}		

		cMAOnlinePrdctCsMngDAO.insertOnlinePrdctCsMng(emfMap);	// 상담신청 고객정보 저장
		cMAOnlinePrdctCsMngDAO.insertOnlinePrdctInf(emfMap);	// 신청상품 정보 저장
		
		if(!"".equals(EMFStringUtil.nullConvert(emfMap.get("prdctCd2")))){
			
			emfMap.put("prdctNm", emfMap.get("prdctNm2"));
			emfMap.put("prdctCd", emfMap.get("prdctCd2"));
			emfMap.put("prdctDtlNm", emfMap.get("prdctDtlNm2"));
			emfMap.put("prdctDtlCd", emfMap.get("prdctDtlCd2"));
			emfMap.put("alt", emfMap.get("alt2"));
			//emfMap.put("payMtd", emfMap.get("payMtd2"));
			emfMap.put("asgnYn", emfMap.get("asgnYn2"));
			emfMap.put("asgnNm", emfMap.get("asgnNm2"));
			emfMap.put("coCd", emfMap.get("coCd2"));
			emfMap.put("dept", emfMap.get("dept2"));
			emfMap.put("stf", emfMap.get("stf2"));
			
			cMAOnlinePrdctCsMngDAO.insertOnlinePrdctInf(emfMap);	// 추가 신청상품 정보 저장
		}
		//2017.04.24 박주석 디아모 솔루션 도입 작업
//		if(!"".equals(EMFStringUtil.nullConvert(emfMap.get("acntHp")))){
//			emfMap.put("acntHp", SeedCipher.encrypt(emfMap.getString("acntHp"), ENCODE));	// 연락처 암호화	
//		}
//		
//		if(!"".equals(EMFStringUtil.nullConvert(emfMap.get("pmtNo")))){
//			emfMap.put("pmtNo", SeedCipher.encrypt(emfMap.getString("pmtNo"), ENCODE));	// 계좌 or 카드번호 암호화	
//		}				
		
		cMAOnlinePrdctCsMngDAO.insertOnlinePrdctAcntInf(emfMap);	// 계좌정보 저장
	}
	
	/**
     * 온라인 상담신청을 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateOnlinePrdctCsMng(EmfMap emfMap) throws Exception
	{
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();	// 로그인 사용자 정보
	
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modNm", lgnMap.getString("name"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		cMAOnlinePrdctCsMngDAO.updateOnlinePrdctCsMng(emfMap);		//  상담내용 수정			
		cMAOnlinePrdctCsMngDAO.insertOnlinePrdctCsLog(emfMap);		//	상담내용 로그 작성
	}
	
	/**
     * 온라인 상담신청을 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteOnlinePrdctCsMngList(EmfMap emfMap) throws Exception
	{
		cMAOnlinePrdctCsMngDAO.deleteOnlinePrdctCsMng(emfMap);	// 상담신청 고객정보 삭제
		cMAOnlinePrdctCsMngDAO.deleteOnlinePrdctInf(emfMap);	// 신청상품 정보 삭제		
		cMAOnlinePrdctCsMngDAO.deleteOnlinePrdctAcntInf(emfMap);	// 계좌정보 삭제	
		
	}
	
	/**
     * 온라인 상담 회사 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectOnlinePrdctCoList(EmfMap emfMap) throws Exception
    {
    	PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
		emfMap.put("paginationInfo", paginationInfo);   	//페이징 처리
				
		List<EmfMap> OnlinePrdctCsList = cMAOnlinePrdctCsMngDAO.selectOnlinePrdctCoList(emfMap);	//리스트 가져오기
		
		emfMap.put("list", OnlinePrdctCsList);
		
		if(OnlinePrdctCsList.size() > 0)
		{
			paginationInfo.setTotalRecordCount(Integer.parseInt(OnlinePrdctCsList.get(0).getString("totCnt")));
		}
		else
		{
			paginationInfo.setTotalRecordCount(0);
		}    	
		return emfMap;
    }	

	/**
     * 온라인 상담 회사 목록을 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public boolean insertOnlinePrdctCo(EmfMap emfMap) throws Exception
	{		
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();	// 로그인 사용자 정보
		
		emfMap.put("regId", lgnMap.getString("id"));
		emfMap.put("regNm", lgnMap.getString("name"));
		emfMap.put("regIp", lgnMap.getString("loginIp"));

		EmfMap coInfMap = cMAOnlinePrdctCsMngDAO.selectOnlinePrdctCo(emfMap);
		if(coInfMap == null )
		{
			cMAOnlinePrdctCsMngDAO.insertOnlinePrdctCo(emfMap);	
			return true;
		}else{
			return false;
		}			
	}    
    
	
	/**
     * 온라인 상담신청을 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteOnlinePrdctCoList(EmfMap emfMap) throws Exception
	{
		cMAOnlinePrdctCsMngDAO.deleteOnlinePrdctCoList(emfMap);
	}	
	
}
