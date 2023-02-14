package mngwserc.cm.cmb.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import emf.core.util.EMFSecurityUtil;
import mngwserc.cm.cmb.service.CMBChngRqstService;
import mngwserc.cm.cmb.service.dao.CMBChngRqstDAO;
import mngwserc.cm.cmb.service.dao.CMBChngRqstOutDAO;
import mngwserc.co.util.COPaginationUtil;

import org.springframework.stereotype.Service;

import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.service.EgovProperties;
import egovframework.com.cmm.service.MailService;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.com.utl.fcc.service.EgovNumberUtil;
import egovframework.com.utl.sim.service.SeedCipher;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import emf.core.extend.service.EmfAbstractService;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 전환서비스 신청 관리를 위한 ServiceImpl
 * </pre>
 * 
 * @ClassName		: CMBChngRqstServiceImpl.java
 * @Description		: 전환서비스 신청 관리를 위한 ServiceImpl
 * @author 허진영
 * @since 2016.03.24
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2016.03.24		허진영					 최초생성
 * </pre>
 */
@Service("cMBChngRqstService")
public class CMBChngRqstServiceImpl extends EmfAbstractService implements CMBChngRqstService {	
	
	@Resource(name="cMBChngRqstDAO")
	private CMBChngRqstDAO cMBChngRqstDAO;
	
	@Resource(name="cMBChngRqstOutDAO")
	private CMBChngRqstOutDAO cMBChngRqstOutDAO;
	
	@Resource(name="EgovCmmUseService")
    private EgovCmmUseService cmmUseService;
	
	@Resource(name="mailService")
	private MailService mailService;
	
	private String ENCODE = EgovProperties.getProperty("Global.CHARCODE");
	
	/**
     * 전환서비스 신청 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public EmfMap selectChngRqstList(EmfMap emfMap) throws Exception
	{
		PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
		
		//페이징 처리
		emfMap.put("paginationInfo", paginationInfo);    	
		
		//리스트 가져오기
		List<EmfMap> list = cMBChngRqstDAO.selectChngRqstList(emfMap);
		
		emfMap.put("list", list);
		
		if(list.size() > 0)
		{
			paginationInfo.setTotalRecordCount(Integer.parseInt(list.get(0).getString("totCnt")));
			
			EmfMap tmpMap = new EmfMap();
			
			EmfMap userInfo = new EmfMap();
			
			for(int i = 0; i < list.size(); i++)
			{

				tmpMap = list.get(i);

				EMFSecurityUtil.maskEmfMap(tmpMap, "memNm", null, null);
				EMFSecurityUtil.maskEmfMap(tmpMap, "userNm", "userCtel", null);
				//2017.04.24 박주석 디아모 솔루션 도입 작업
//				if(!"".equals(EMFStringUtil.nullConvert(list.get(i).get("userCtel"))))
//				{
//					list.get(i).put("userCtel", SeedCipher.decrypt(list.get(i).getString("userCtel"), ENCODE));
//				}
				
				userInfo.put("memNo", list.get(i).getString("memNo"));
				userInfo.put("accntNo", list.get(i).getString("accntNo"));
				
				emfMap.put("userInfo", userInfo);
				
				tmpMap.put("prdctInfo", cMBChngRqstOutDAO.selectJoinPrdct(emfMap));
				EMFSecurityUtil.maskEmfMap((EmfMap)tmpMap.get("prdctInfo"), "memNm", "cell", null);
				list.set(i, tmpMap);
			}
			cmmUseService.actionViewAuthLogV2("고객서비스 관리 - 전환서비스관리 - 전환서비스 신청관리", "", "S", null);
		}
		else
		{
			paginationInfo.setTotalRecordCount(0);
		}
		
		//공통코드 배열 셋팅
		ArrayList<String> cdDtlList = new ArrayList<String>();
		
		//전환서비스 - 처리현황
		cdDtlList.add("CHNG_PRCS_STTS");
		
		//정의된 코드id값들의 상세 코드 맵 반환		
		emfMap.put("cdDtlList", cmmUseService.selectCmmCodeBindAll(cdDtlList));
		
		return emfMap;
	}
	
	/**
     * 전환서비스 신청 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public EmfMap selectChngRqst(EmfMap emfMap) throws Exception
	{
		EmfMap userInfo = cMBChngRqstDAO.selectChngRqst(emfMap);

		emfMap.put("userInfo", userInfo);
		//2017.04.24 박주석 디아모 솔루션 도입 작업
//		if(!"".equals(EMFStringUtil.nullConvert(userInfo.get("memEmail"))))
//		{
//			userInfo.put("memEmail", SeedCipher.decrypt(userInfo.getString("memEmail"), ENCODE));
//		}
//		
//		if(!"".equals(EMFStringUtil.nullConvert(userInfo.get("userCtel"))))
//		{
//			userInfo.put("userCtel", SeedCipher.decrypt(userInfo.getString("userCtel"), ENCODE));
//		}
//		
//		if(!"".equals(EMFStringUtil.nullConvert(userInfo.get("userEmail"))))
//		{
//			userInfo.put("userEmail", SeedCipher.decrypt(userInfo.getString("userEmail"), ENCODE));
//		}
		
		emfMap.put("memInfo", cMBChngRqstOutDAO.selectJoinPrdct(emfMap));
		
		emfMap.put("prdctInfo", cMBChngRqstDAO.selectChngPrdctInf(emfMap));
		
		emfMap.put("prcsLog", cMBChngRqstDAO.selectRqstPrcsLog(emfMap));
		
		//공통코드 배열 셋팅
		ArrayList<String> cdDtlList = new ArrayList<String>();
		
		//전환서비스 - 회원관계구분
		cdDtlList.add("MEM_REL_GB");
				
		//전환서비스 - 처리현황
		cdDtlList.add("CHNG_PRCS_STTS");
		cmmUseService.actionViewAuthLogV2("고객서비스 관리 - 전환서비스관리 - 전환서비스 신청관리", "", "D", null);
		//정의된 코드id값들의 상세 코드 맵 반환		
		emfMap.put("cdDtlList", cmmUseService.selectCmmCodeBindAll(cdDtlList));
    	
    	return emfMap;
	}
	
	/**
     * 전환서비스 신청을 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateChngRqst(EmfMap emfMap) throws Exception
	{
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		//2017.04.24 박주석 디아모 솔루션 도입 작업
//		if(!"".equals(EMFStringUtil.nullConvert(emfMap.get("userCtel"))))
//		{
//			emfMap.put("userCtel", SeedCipher.encrypt(emfMap.getString("userCtel"), ENCODE));
//		}
//		
//		if(!"".equals(EMFStringUtil.nullConvert(emfMap.get("userEmail"))))
//		{
//			emfMap.put("userEmail", SeedCipher.encrypt(emfMap.getString("userEmail"), ENCODE));
//		}
		
		emfMap.put("prdctUseReqnDt", emfMap.getString("prdctUseReqnDt").replaceAll("-", ""));
		
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		//전환서비스 신청 처리현황 로그를 등록한다.
		int insCnt = cMBChngRqstDAO.insertRqstPrcsLog(emfMap);
		
		//전환서비스 신청을 수정한다.
		cMBChngRqstDAO.updateChngRqst(emfMap);

		cmmUseService.actionViewAuthLogV2("고객서비스 관리 - 전환서비스관리 - 전환서비스 신청관리", "", "M", null);

		if("05".equals(EMFStringUtil.nullConvert(emfMap.getString("prcsCd"))) && insCnt > 0)
		{
			EmfMap userInfo = cMBChngRqstDAO.selectChngRqst(emfMap);
			
			emfMap.put("userInfo", userInfo);
			
			EmfMap memInfo = cMBChngRqstOutDAO.selectJoinPrdct(emfMap);
			
			EmfMap prdctInfo = cMBChngRqstDAO.selectChngPrdctInf(emfMap);
			
			if(!"".equals(userInfo.getString("memEmail")) && Integer.parseInt(userInfo.getString("payCompCnt")) == 1)
			{
				EmfMap mailMap = new EmfMap();
				
				mailMap.put("subject", "[대명라이프웨이 전환서비스 결제완료] 메일입니다.");
				//2017.04.24 박주석 디아모 솔루션 도입 작업
//				mailMap.put("toUser", SeedCipher.decrypt(userInfo.getString("memEmail"), ENCODE));
				mailMap.put("toUser", userInfo.getString("memEmail") );
				mailMap.put("name", userInfo.getString("name"));
				mailMap.put("accntNo", userInfo.getString("accntNo"));
				
				int prodAmt = Integer.parseInt(EMFStringUtil.nvl(memInfo.getString("prodAmt"), "0"));
				//int trueAmt = Integer.parseInt(EMFStringUtil.nvl(memInfo.getString("trueAmt"), "0"));
				//int relatAmt = Integer.parseInt(EMFStringUtil.nvl(memInfo.getString("relatAmt"), "0"));
				//int addAmt = Integer.parseInt(EMFStringUtil.nvl(memInfo.getString("addAmt"), "0"));
				//int itmdtPay = Integer.parseInt(EMFStringUtil.nvl(userInfo.getString("itmdtPay"), "0"));
						
				mailMap.put("pay", EgovNumberUtil.amtConvert(prodAmt));
				mailMap.put("prodNm", memInfo.getString("prodNm"));
				mailMap.put("prdctGb", prdctInfo.getString("prdctGb"));
				
				mailService.sendTempleteMail(mailMap, "cm/cmb/CMBChngPayComp.html");
			}
		}
	}
	
	/**
     * 전환서비스 신청을 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteChngRqstList(int[] delSeq) throws Exception
	{
		EmfMap emfMap = new EmfMap();
		
		emfMap.put("delSeq", delSeq);
		
		cMBChngRqstDAO.deleteChngRqst(emfMap);

		cmmUseService.actionViewAuthLogV2("고객서비스 관리 - 전환서비스관리 - 전환서비스 신청관리", "", "R", null);
	}
	
	/**
     * 전환서비스 신청 처리현황을 수정한다.
     * 
     * @param EmfMap
	 * @return
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateChngRqstPrcsCd(EmfMap emfMap) throws Exception
	{
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		//전환서비스 신청 처리현황 로그를 등록한다.
		cMBChngRqstDAO.insertRqstPrcsLog(emfMap);
				
		//전환서비스 신청 처리현황을 수정한다.
		cMBChngRqstDAO.updateChngRqstPrcsCd(emfMap);

		cmmUseService.actionViewAuthLogV2("고객서비스 관리 - 전환서비스관리 - 전환서비스 신청관리 - 처리", "", "M", null);
	}
	
	/**
     * 전환서비스 신청 목록을 조회한다. (엑셀 다운로드)
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public List<EmfMap> excelChngRqstList(EmfMap emfMap) throws Exception
	{
		List<EmfMap> list = cMBChngRqstDAO.excelChngRqstList(emfMap);
		
		if(list.size() > 0)
		{
			EmfMap tmpMap = new EmfMap();
			
			EmfMap userInfo = new EmfMap();
			
			for(int i = 0; i < list.size(); i++)
			{
				tmpMap = list.get(i);
				
				if(!"".equals(EMFStringUtil.nullConvert(list.get(i).get("userCtel"))))
				{
					//2017.04.24 박주석 디아모 솔루션 도입 작업
//					list.get(i).put("userCtel", SeedCipher.decrypt(list.get(i).getString("userCtel"), ENCODE));
					list.get(i).put("userCtel", list.get(i).getString("userCtel") );
				}
				
				userInfo.put("memNo", list.get(i).getString("memNo"));
				userInfo.put("accntNo", list.get(i).getString("accntNo"));

				emfMap.put("userInfo", userInfo);
				
				tmpMap.put("prdctInfo", cMBChngRqstOutDAO.selectJoinPrdct(emfMap));
				
				list.set(i, tmpMap);
			}
		}
		cmmUseService.actionViewAuthLogV2("고객서비스 관리 - 전환서비스관리 - 전환서비스 신청관리", "", "E", null);
		return list;
	}
}
