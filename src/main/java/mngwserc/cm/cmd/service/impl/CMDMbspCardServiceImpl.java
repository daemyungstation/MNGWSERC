package mngwserc.cm.cmd.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import emf.core.util.EMFSecurityUtil;
import mngwserc.cm.cmd.service.CMDMbspCardService;
import mngwserc.cm.cmd.service.dao.CMDMbspCardDAO;
import mngwserc.co.util.COPaginationUtil;

import mngwserc.mb.sso.exception.SsoException;
import org.springframework.stereotype.Service;

import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.service.EgovProperties;
import egovframework.com.cmm.service.MailService;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.com.utl.sim.service.SeedCipher;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import emf.core.extend.service.EmfAbstractService;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 멤버십카드신청 내역 관리를 위한 ServiceImpl
 * </pre>
 * 
 * @ClassName		: CMDMbspCardServiceImpl.java
 * @Description		: 멤버십카드신청 내역 관리를 위한 ServiceImpl
 * @author 허진영
 * @since 2016.02.11
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author				   description
 *    ==========    ==============    =============================
 *    2016.02.11		허진영					최초 생성
 * </pre>
 */ 
@Service("cMDMbspCardService")
public class CMDMbspCardServiceImpl extends EmfAbstractService implements CMDMbspCardService {
	
	@Resource(name="cMDMbspCardDAO")
	private CMDMbspCardDAO cMDMbspCardDAO;
	
	@Resource(name="EgovCmmUseService")
    private EgovCmmUseService cmmUseService;
	
	@Resource(name="mailService")
	private MailService mailService;
	
	private String ENCODE = EgovProperties.getProperty("Global.CHARCODE");
	
	/**
     * 멤버십카드신청 내역 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectMbspCardList(EmfMap emfMap) throws Exception
    {
    	PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
		
		//페이징 처리
		emfMap.put("paginationInfo", paginationInfo);    	
		
		//리스트 가져오기
		List<EmfMap> list = cMDMbspCardDAO.selectMbspCardList(emfMap);
		
		emfMap.put("list", list);
		
		if(list.size() > 0)
		{
			for (int i=0; i<list.size(); i++) {
				EMFSecurityUtil.maskEmfMap(list.get(i), "name", "hp", null);
			}
			paginationInfo.setTotalRecordCount(Integer.parseInt(list.get(0).getString("totCnt")));
			cmmUseService.actionViewAuthLogV2("고객서비스 관리 - 멤버십카드관리 - 멤버십카드신청 내역", "", "S", null);
			//2017.04.24 박주석 디아모 솔루션 도입 작업
//			for(int i = 0; i < list.size(); i++)
//			{
//				if(!"".equals(EMFStringUtil.nullConvert(list.get(i).get("hp"))))
//				{
//					list.get(i).put("hp", SeedCipher.decrypt(list.get(i).getString("hp"), ENCODE));
//				}
//			}
		}
		else
		{
			paginationInfo.setTotalRecordCount(0);
		}
		
		//공통코드 배열 셋팅
		ArrayList<String> cdDtlList = new ArrayList<String>();
		
		//처리현황 TYPE
		cdDtlList.add("PROCESS_TYPE");
		
		//정의된 코드id값들의 상세 코드 맵 반환		
		emfMap.put("cdDtlList", cmmUseService.selectCmmCodeBindAll(cdDtlList));

		return emfMap;
    }
    
    /**
     * 멤버십카드신청 내역 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectMbspCard(EmfMap emfMap) throws Exception
    {
		EmfMap mbspCardInfo = cMDMbspCardDAO.selectMbspCard(emfMap);
		
    	if(mbspCardInfo != null)
    	{
    		emfMap.put("mbspCardInfo", mbspCardInfo);
    		//2017.04.24 박주석 디아모 솔루션 도입 작업
//    		if(!"".equals(EMFStringUtil.nullConvert(mbspCardInfo.get("email"))))
//			{
//    			mbspCardInfo.put("email", SeedCipher.decrypt(mbspCardInfo.getString("email"), ENCODE));
//			}
//    		
//    		if(!"".equals(EMFStringUtil.nullConvert(mbspCardInfo.get("hp"))))
//			{
//    			mbspCardInfo.put("hp", SeedCipher.decrypt(mbspCardInfo.getString("hp"), ENCODE));
//			}
//    		
//    		if(!"".equals(EMFStringUtil.nullConvert(mbspCardInfo.get("tel"))))
//			{
//    			mbspCardInfo.put("tel", SeedCipher.decrypt(mbspCardInfo.getString("tel"), ENCODE));
//			}
//    		
//    		if(!"".equals(EMFStringUtil.nullConvert(mbspCardInfo.get("adrDtl"))))
//			{
//    			mbspCardInfo.put("adrDtl", SeedCipher.decrypt(mbspCardInfo.getString("adrDtl"), ENCODE));
//			}
    	}
    	
		//공통코드 배열 셋팅
		ArrayList<String> cdDtlList = new ArrayList<String>();
		
		//처리현황 TYPE
		cdDtlList.add("PROCESS_TYPE");
		
		//정의된 코드id값들의 상세 코드 맵 반환		
		emfMap.put("cdDtlList", cmmUseService.selectCmmCodeBindAll(cdDtlList));

		cmmUseService.actionViewAuthLogV2("고객서비스 관리 - 멤버십카드관리 - 멤버십카드신청 내역", "", "D", null);

    	return emfMap;
    }
    
	/**
     * 멤버십카드신청 내역을 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateMbspCard(EmfMap emfMap) throws Exception
	{
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		//멤버십카드신청 내역 처리현황 로그를 등록한다.
		int insCnt = cMDMbspCardDAO.insertMbspCardPrcsLog(emfMap);
				
		//멤버십카드신청 내역을 수정한다.
		cMDMbspCardDAO.updateMbspCard(emfMap);
		cmmUseService.actionViewAuthLogV2("고객서비스 관리 - 멤버십카드관리 - 멤버십카드신청 내역", "", "M", null);
		if("03".equals(emfMap.getString("prcsCd")) && insCnt > 0)
		{
			EmfMap mbspCardInfo = cMDMbspCardDAO.selectMbspCard(emfMap);
			
			if(!"".equals(mbspCardInfo.getString("email")) && Integer.parseInt(mbspCardInfo.getString("rqstCompCnt")) == 1)
			{
				EmfMap mailMap = new EmfMap();
				
				mailMap.put("subject", "[대명아임레디 멤버십 카드 재발급 신청 완료] 메일입니다.");
				//2017.04.24 박주석 디아모 솔루션 도입 작업
//				mailMap.put("toUser", SeedCipher.decrypt(mbspCardInfo.getString("email"), ENCODE));
				mailMap.put("toUser", mbspCardInfo.getString("email") );
				mailMap.put("name", mbspCardInfo.getString("name"));
				
				mailService.sendTempleteMail(mailMap, "cm/cmd/CMDMbspRqstComp.html");
			}
		}
	}
	
	/**
     * 멤버십카드신청 내역 처리현황을 수정한다.
     * 
     * @param EmfMap
	 * @return int
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateMbspCardPrcsCd(EmfMap emfMap) throws Exception
	{
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		//멤버십카드신청 내역 처리현황 로그를 등록한다.
		cMDMbspCardDAO.insertMbspCardPrcsLog(emfMap);
		
		//멤버십카드신청 내역 처리현황을 수정한다.
		cMDMbspCardDAO.updateMbspCardPrcsCd(emfMap);
		cmmUseService.actionViewAuthLogV2("고객서비스 관리 - 멤버십카드관리 - 멤버십카드신청 내역 - 처리", "", "M", null);
	}
	
	/**
     * 멤버십카드신청 내역 처리현황을 일괄 수정한다.
     * 
     * @param EmfMap
	 * @return
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateMbspCardPrcsCdAll(EmfMap emfMap) throws Exception
	{
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		String[] trgtSeq = emfMap.getString("trgtSeqArr").split(",");
		
		for(int i = 0; i < trgtSeq.length; i++)
		{
			emfMap.put("rqstSeq", trgtSeq[i]);
			
			//멤버십카드신청 내역 처리현황 로그를 등록한다.
			cMDMbspCardDAO.insertMbspCardPrcsLog(emfMap);
			
			//멤버십카드신청 내역 처리현황을 수정한다.
			cMDMbspCardDAO.updateMbspCardPrcsCd(emfMap);
			
			if("03".equals(emfMap.getString("prcsCd")))
			{
				EmfMap mbspCardInfo = cMDMbspCardDAO.selectMbspCard(emfMap);
				
				if(!"".equals(mbspCardInfo.getString("email")))
				{
					if(Integer.parseInt(mbspCardInfo.getString("rqstCompCnt")) == 1)
					{
						EmfMap mailMap = new EmfMap();
						
						mailMap.put("subject", "[대명아임레디 멤버십 카드 재발급 신청 완료] 메일입니다.");
						//2017.04.24 박주석 디아모 솔루션 도입 작업
//						mailMap.put("toUser", SeedCipher.decrypt(mbspCardInfo.getString("email"), ENCODE));
						mailMap.put("toUser", mbspCardInfo.getString("email") );
						mailMap.put("name", mbspCardInfo.getString("name"));
						
						mailService.sendTempleteMail(mailMap, "cm/cmd/CMDMbspRqstComp.html");
					}
				}
			}
		}
		cmmUseService.actionViewAuthLogV2("고객서비스 관리 - 멤버십카드관리 - 멤버십카드신청 내역 - 일괄", "", "M", null);
	}
	
	/**
     * 멤버십카드신청 내역 목록을 조회한다. (엑셀 다운로드)
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public List<EmfMap> excelMbspCardList(EmfMap emfMap) throws Exception
    {
    	List<EmfMap> list = cMDMbspCardDAO.excelMbspCardList(emfMap);
		cmmUseService.actionViewAuthLogV2("고객서비스 관리 - 멤버십카드관리 - 멤버십카드신청 내역", "", "E", null);
    	//2017.04.24 박주석 디아모 솔루션 도입 작업
//    	for(int i = 0; i < list.size(); i++)
//		{
//			if(!"".equals(EMFStringUtil.nullConvert(list.get(i).get("hp"))))
//			{
//				list.get(i).put("hp", SeedCipher.decrypt(list.get(i).getString("hp"), ENCODE));
//			}
//		}
    	
		return list;
    }
}
