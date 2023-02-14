package mngwserc.cs.csa.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import mngwserc.co.util.COPaginationUtil;
import mngwserc.cs.csa.service.CSACustVoiceService;
import mngwserc.cs.csa.service.dao.CSACustVoiceDAO;

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
 * 고객의 소리 접수를 위한 ServiceImpl
 * </pre>
 * 
 * @ClassName		: CSACustVoiceServiceImpl.java
 * @Description		: 고객의 소리 접수를 위한 ServiceImpl
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
@Service("cSACustVoiceService")
public class CSACustVoiceServiceImpl extends EmfAbstractService implements CSACustVoiceService {
	
	@Resource(name="cSACustVoiceDAO")
	private CSACustVoiceDAO cSACustVoiceDAO;
	
	@Resource(name="EgovCmmUseService")
    private EgovCmmUseService cmmUseService;
	
	@Resource(name="mailService")
	private MailService mailService;
	
	private String ENCODE = EgovProperties.getProperty("Global.CHARCODE");
	
	/**
     * 고객의 소리 접수 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectCustVoiceList(EmfMap emfMap) throws Exception
    {
    	PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
		
		//페이징 처리
		emfMap.put("paginationInfo", paginationInfo);    	
		
		//리스트 가져오기
		List<EmfMap> list = cSACustVoiceDAO.selectCustVoiceList(emfMap);
		
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
		
		//1:1상담 구분
		cdDtlList.add("PRSN_INQRY_GB");
		
		//처리현황 TYPE
		cdDtlList.add("PROCESS_TYPE");
		
		//정의된 코드id값들의 상세 코드 맵 반환		
		emfMap.put("cdDtlList", cmmUseService.selectCmmCodeBindAll(cdDtlList));
		
		//고객의 소리 접수 상세구분
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
     * 고객의 소리 접수 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectCustVoice(EmfMap emfMap) throws Exception
    {
    	System.out.println("aa~~~~~~~"+emfMap.getString("custVoiceSeq"));
		EmfMap custVoiceInfo = cSACustVoiceDAO.selectCustVoice(emfMap);
		
    	if(custVoiceInfo != null)
    	{
    		emfMap.put("custVoiceInfo", custVoiceInfo);
    		//2017.04.24 박주석 디아모 솔루션 도입 작업
//    		if(!"".equals(EMFStringUtil.nullConvert(CustVoiceInfo.get("ctel"))))
//    		{
//    			CustVoiceInfo.put("ctel", SeedCipher.decrypt(CustVoiceInfo.getString("ctel"), ENCODE));
//    		}
//    		
//    		if(!"".equals(EMFStringUtil.nullConvert(CustVoiceInfo.get("email"))))
//    		{
//    			CustVoiceInfo.put("email", SeedCipher.decrypt(CustVoiceInfo.getString("email"), ENCODE));
//    		}
    		
    		// 관리자 정보를 가져온다.
    		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
    		
    		emfMap.put("taskGb", "R");
    		emfMap.put("prcsCd", "02");
    		emfMap.put("modId", lgnMap.getString("id"));
    		emfMap.put("modIp", lgnMap.getString("loginIp"));
    		
    		// 고객의 소리 접수 처리상태를 수정한다.
    		cSACustVoiceDAO.updateCustVoicePrcsCd(emfMap);
    		
    		// 확인로그등록
    		cSACustVoiceDAO.insertCustVoiceLog(emfMap);
	    	
	    	// 고객의 소리 접수 로그를 조회한다.
    		emfMap.put("custVoiceLog", cSACustVoiceDAO.selectCustVoiceLog(custVoiceInfo));
    	}
    	
    	return emfMap;
    }
    
	/**
     * 고객의 소리 접수 답변을 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateCustVoiceAnsw(EmfMap emfMap) throws Exception
	{
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("taskGb", "A");
		emfMap.put("prcsCd", "03");
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		// 답변등록
		cSACustVoiceDAO.updateCustVoiceAnsw(emfMap);
		
		// 고객의 소리 접수 처리상태를 수정한다.
		cSACustVoiceDAO.updateCustVoicePrcsCd(emfMap);
				
		// 답변로그등록
		cSACustVoiceDAO.insertCustVoiceLog(emfMap);
	}
	
	/**
     * 고객의 소리 접수을 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteCustVoiceList(int[] delSeq) throws Exception
	{
		EmfMap emfMap = new EmfMap();
		
		emfMap.put("delSeq", delSeq);
		
		cSACustVoiceDAO.deleteCustVoice(emfMap);
	}
	
	/**
     * 고객의 소리 접수 답변메일을 발송한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateCustVoiceAnswMail(EmfMap emfMap) throws Exception
	{
		try
		{
			// 메일발송을 위해 사용자정보를 가져온다.
			EmfMap custVoiceInfo = cSACustVoiceDAO.selectCustVoice(emfMap);
			System.out.println("~~~~~~~답변 이메일~~~~~~~~~~~"+custVoiceInfo.getString("name"));
			System.out.println("~~~~~~~답변 이메일~~~~~~~~~~~"+custVoiceInfo.getString("email"));
			System.out.println("~~~~~~~답변 이메일~~~~~~~~~~~"+custVoiceInfo.getString("inqryNm"));
			System.out.println("~~~~~~~답변 이메일~~~~~~~~~~~"+custVoiceInfo.getString("inqryDtlNm"));
			System.out.println("~~~~~~~답변 이메일~~~~~~~~~~~"+custVoiceInfo.getString("titl"));
			if(Integer.parseInt(custVoiceInfo.getString("mailSendCnt")) < 1)
			{
				EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
				System.out.println("이메일 보내는 중 1");
				emfMap.put("taskGb", "S");
				emfMap.put("modId", lgnMap.getString("id"));
				emfMap.put("modIp", lgnMap.getString("loginIp"));
				
				System.out.println("이메일 보내는 중 2");
				
				// 메일발송로그등록
				cSACustVoiceDAO.insertCustVoiceLog(emfMap);
						
				System.out.println("이메일 보내는 중 3");
				
				if(!"".equals(EMFStringUtil.nullConvert(custVoiceInfo.get("email"))))
				{
					EmfMap mailMap = new EmfMap();
					
					System.out.println("이메일 보내는 중 4");
					
					mailMap.put("subject", "[대명아임레디 고객의 소리 접수] 답변글입니다.");
					//2017.04.24 박주석 디아모 솔루션 도입 작업
//					mailMap.put("toUser", SeedCipher.decrypt(CustVoiceInfo.getString("email"), ENCODE));
					mailMap.put("toUser", custVoiceInfo.getString("email") );
					mailMap.put("name", custVoiceInfo.getString("name"));
					mailMap.put("regDtm", EgovDateUtil.convertDate(custVoiceInfo.getString("regDtm"), "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", ""));
					mailMap.put("inqryNm", custVoiceInfo.getString("inqryNm"));
					mailMap.put("inqryDtlNm", custVoiceInfo.getString("inqryDtlNm"));
					mailMap.put("titl", custVoiceInfo.getString("titl"));
					mailMap.put("cntn", custVoiceInfo.getString("cntn").replace(System.getProperty("line.separator"), "<br />"));
					mailMap.put("answ", custVoiceInfo.getString("answ").replace(System.getProperty("line.separator"), "<br />"));
					mailMap.put("asgnr", lgnMap.getString("name"));
					
					System.out.println("이메일 보내는 중 5");
					
					mailService.sendTempleteMail(mailMap, "cs/csa/CSACustVoiceAnsw.html");
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
     *  고객의 소리 접수 문의구분 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public List<EmfMap> selectCustVoiceDtlList(EmfMap emfMap) throws Exception
	{
		emfMap.put("highrCd", "CUST_VOICE_GB");
		emfMap.put("lowrCd", "CUST_VOICE_DTL_GB");
		
		return cmmUseService.selectCmmLinkCode(emfMap);
	}
	
	/**
     * 고객의 소리 접수 목록을 조회한다. (엑셀 다운로드)
     * 
     * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public List<EmfMap> excelCustVoiceList(EmfMap emfMap) throws Exception
    {
    	return cSACustVoiceDAO.excelCustVoiceList(emfMap);
    }
}
