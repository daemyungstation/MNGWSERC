package mngwserc.cs.csa.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import mngwserc.co.util.COPaginationUtil;
import mngwserc.cs.csa.service.CSAPrsnCnslService;
import mngwserc.cs.csa.service.dao.CSAPrsnCnslDAO;

import org.springframework.stereotype.Service;

import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.service.EgovProperties;
import egovframework.com.cmm.service.MailService;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.com.utl.fcc.service.EgovDateUtil;
import egovframework.com.utl.sim.service.SeedCipher;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import emf.core.extend.service.EmfAbstractService;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 1:1 상담관리를 위한 ServiceImpl
 * </pre>
 * 
 * @ClassName		: CSAPrsnCnslServiceImpl.java
 * @Description		: 1:1 상담관리를 위한 ServiceImpl
 * @author 허진영
 * @since 2016.02.04
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2016.02.04		허진영					 최초생성
 * </pre>
 */ 
@Service("cSAPrsnCnslService")
public class CSAPrsnCnslServiceImpl extends EmfAbstractService implements CSAPrsnCnslService {
	
	@Resource(name="cSAPrsnCnslDAO")
	private CSAPrsnCnslDAO cSAPrsnCnslDAO;
	
	@Resource(name="EgovCmmUseService")
    private EgovCmmUseService cmmUseService;
	
	@Resource(name="mailService")
	private MailService mailService;
	
	private String ENCODE = EgovProperties.getProperty("Global.CHARCODE");
	
	/**
     * 1:1 상담 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectPrsnCnslList(EmfMap emfMap) throws Exception
    {
    	PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
		
		//페이징 처리
		emfMap.put("paginationInfo", paginationInfo);    	
		
		//리스트 가져오기
		List<EmfMap> list = cSAPrsnCnslDAO.selectPrsnCnslList(emfMap);
		
		emfMap.put("list", list);
		
		if(list.size() > 0)
		{
			paginationInfo.setTotalRecordCount(Integer.parseInt(list.get(0).getString("totCnt")));
			cmmUseService.actionViewAuthLogV2("고객센터 - 1:1 상담", "", "S", null);
		}
		else
		{
			paginationInfo.setTotalRecordCount(0);
		}
		
		//공통코드 배열 셋팅
		ArrayList<String> cdDtlList = new ArrayList<String>();
		
		//1:1상담 구분
		cdDtlList.add("PRSN_INQRY_GB");
		
		//처리현황 TYPE
		cdDtlList.add("PROCESS_TYPE");
		
		//정의된 코드id값들의 상세 코드 맵 반환		
		emfMap.put("cdDtlList", cmmUseService.selectCmmCodeBindAll(cdDtlList));
		
		//1:1 상담 상세구분
		if(!"".equals(EMFStringUtil.nullConvert(emfMap.get("inqryCd"))))
		{
			emfMap.put("highrCd", "PRSN_INQRY_GB");
			emfMap.put("highrDtlCd", emfMap.getString("inqryCd"));
			emfMap.put("lowrCd", "PRSN_INQRY_DTL_GB");
			
			emfMap.put("linkCdList", cmmUseService.selectCmmLinkCode(emfMap));
		}

		return emfMap;
    }
    
    /**
     * 1:1 상담 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectPrsnCnsl(EmfMap emfMap) throws Exception
    {
		EmfMap prsnCnslInfo = cSAPrsnCnslDAO.selectPrsnCnsl(emfMap);
		
    	if(prsnCnslInfo != null)
    	{
    		emfMap.put("prsnCnslInfo", prsnCnslInfo);
    		//2017.04.24 박주석 디아모 솔루션 도입 작업
//    		if(!"".equals(EMFStringUtil.nullConvert(prsnCnslInfo.get("ctel"))))
//    		{
//    			prsnCnslInfo.put("ctel", SeedCipher.decrypt(prsnCnslInfo.getString("ctel"), ENCODE));
//    		}
//    		
//    		if(!"".equals(EMFStringUtil.nullConvert(prsnCnslInfo.get("email"))))
//    		{
//    			prsnCnslInfo.put("email", SeedCipher.decrypt(prsnCnslInfo.getString("email"), ENCODE));
//    		}
    		
    		// 관리자 정보를 가져온다.
    		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
    		
    		emfMap.put("taskGb", "R");
    		emfMap.put("prcsCd", "02");
    		emfMap.put("modId", lgnMap.getString("id"));
    		emfMap.put("modIp", lgnMap.getString("loginIp"));
    		
    		// 1:1 상담 처리상태를 수정한다.
    		cSAPrsnCnslDAO.updatePrsnCnslPrcsCd(emfMap);
    		
    		// 확인로그등록
	    	cSAPrsnCnslDAO.insertPrsnCnslLog(emfMap);
	    	
	    	// 1:1 상담 로그를 조회한다.
    		emfMap.put("prsnCnslLog", cSAPrsnCnslDAO.selectPrsnCnslLog(prsnCnslInfo));
    	}
		cmmUseService.actionViewAuthLogV2("고객센터 - 1:1 상담", "", "D", null);
    	return emfMap;
    }
    
	/**
     * 1:1 상담 답변을 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updatePrsnCnslAnsw(EmfMap emfMap) throws Exception
	{
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("taskGb", "A");
		emfMap.put("prcsCd", "03");
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		// 답변등록
		cSAPrsnCnslDAO.updatePrsnCnslAnsw(emfMap);
		
		// 1:1 상담 처리상태를 수정한다.
		cSAPrsnCnslDAO.updatePrsnCnslPrcsCd(emfMap);
				
		// 답변로그등록
		cSAPrsnCnslDAO.insertPrsnCnslLog(emfMap);
		cmmUseService.actionViewAuthLogV2("고객센터 - 1:1 상담 - 답변", "", "M", null);
	}
	
	/**
     * 1:1 상담을 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deletePrsnCnslList(int[] delSeq) throws Exception
	{
		EmfMap emfMap = new EmfMap();
		
		emfMap.put("delSeq", delSeq);
		
		cSAPrsnCnslDAO.deletePrsnCnsl(emfMap);
		cmmUseService.actionViewAuthLogV2("고객센터 - 1:1 상담", "", "R", null);
	}
	
	/**
     * 1:1 상담 답변메일을 발송한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updatePrsnCnslAnswMail(EmfMap emfMap) throws Exception
	{
		try
		{
			// 메일발송을 위해 사용자정보를 가져온다.
			EmfMap prsnCnslInfo = cSAPrsnCnslDAO.selectPrsnCnsl(emfMap);
			
			if(Integer.parseInt(prsnCnslInfo.getString("mailSendCnt")) < 1)
			{
				EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
				
				emfMap.put("taskGb", "S");
				emfMap.put("modId", lgnMap.getString("id"));
				emfMap.put("modIp", lgnMap.getString("loginIp"));
				
				// 메일발송로그등록
				cSAPrsnCnslDAO.insertPrsnCnslLog(emfMap);
				cmmUseService.actionViewAuthLogV2("고객센터 - 1:1 상담 - 메일", "", "C", null);
				if(!"".equals(EMFStringUtil.nullConvert(prsnCnslInfo.get("email"))))
				{
					EmfMap mailMap = new EmfMap();
					
					mailMap.put("subject", "[대명라이프웨이 1:1 상담] 답변글입니다.");
					//2017.04.24 박주석 디아모 솔루션 도입 작업
//					mailMap.put("toUser", SeedCipher.decrypt(prsnCnslInfo.getString("email"), ENCODE));
					mailMap.put("toUser", prsnCnslInfo.getString("email") );
					mailMap.put("name", prsnCnslInfo.getString("name"));
					mailMap.put("regDtm", EgovDateUtil.convertDate(prsnCnslInfo.getString("regDtm"), "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", ""));
					mailMap.put("inqryNm", prsnCnslInfo.getString("inqryNm"));
					mailMap.put("inqryDtlNm", prsnCnslInfo.getString("inqryDtlNm"));
					mailMap.put("titl", prsnCnslInfo.getString("titl"));
					mailMap.put("cntn", prsnCnslInfo.getString("cntn").replace(System.getProperty("line.separator"), "<br />"));
					mailMap.put("answ", prsnCnslInfo.getString("answ").replace(System.getProperty("line.separator"), "<br />"));
					mailMap.put("asgnr", lgnMap.getString("name"));
					
					mailService.sendTempleteMail(mailMap, "cs/csa/CSAPrsnCnslAnsw.html");
				}
			}
			else
			{
				throw new Exception("답변메일오류");
			}
		}
		catch(Exception e)
		{
			throw (Exception)e;
		}
	}
	
	/**
     *  1:1 상담 문의구분 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public List<EmfMap> selectPrsnInqryDtlList(EmfMap emfMap) throws Exception
	{
		emfMap.put("highrCd", "PRSN_INQRY_GB");
		emfMap.put("lowrCd", "PRSN_INQRY_DTL_GB");
		cmmUseService.actionViewAuthLogV2("고객센터 - 1:1 상담 - 문의", "", "D", null);
		return cmmUseService.selectCmmLinkCode(emfMap);
	}
	
	/**
     * 1:1 상담 목록을 조회한다. (엑셀 다운로드)
     * 
     * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public List<EmfMap> excelPrsnCnslList(EmfMap emfMap) throws Exception
    {
		cmmUseService.actionViewAuthLogV2("고객센터 - 1:1 상담", "", "E", null);
    	return cSAPrsnCnslDAO.excelPrsnCnslList(emfMap);
    }
}
