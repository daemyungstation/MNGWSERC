package mngwserc.cm.cmc.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import emf.core.util.EMFSecurityUtil;
import mngwserc.cm.cmc.service.CMCPfmcRsvtnService;
import mngwserc.cm.cmc.service.dao.CMCPfmcRsvtnDAO;
import mngwserc.co.util.COPaginationUtil;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.service.MailService;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.com.utl.fcc.service.EgovDateUtil;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import emf.core.extend.service.EmfAbstractService;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 공연예약 관리를 위한 ServiceImpl
 * </pre>
 * 
 * @ClassName		: CMCPfmcRsvtnServiceImpl.java
 * @Description		: 공연예약 관리를 위한ServiceImpl
 * @author 허진영
 * @since 2016.02.18
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2016.02.18		허진영					 최초생성
 * </pre>
 */ 
@Service("cMCPfmcRsvService")
public class CMCPfmcRsvtnServiceImpl extends EmfAbstractService implements CMCPfmcRsvtnService {
	
	@Resource(name="cMCPfmcRsvtnDAO")
	private CMCPfmcRsvtnDAO cMCPfmcRsvtnDAO;
	
	@Resource(name="EgovCmmUseService")
    private EgovCmmUseService cmmUseService;
	
	@Resource(name="mailService")
	private MailService mailService;
	
	/**
     * 공연예약 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public EmfMap selectPfmcRsvtnList(EmfMap emfMap) throws Exception 
	{
		PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
		
		//페이징 처리
		emfMap.put("paginationInfo", paginationInfo);    	
		
		//리스트 가져오기
		List<EmfMap> list = cMCPfmcRsvtnDAO.selectPfmcRsvtnList(emfMap);

		emfMap.put("list", list);
			
		if(list.size() > 0)
		{
			for (int i=0; i<list.size(); i++) {
				EMFSecurityUtil.maskEmfMap(list.get(i), "name", "hp", null);
			}
			paginationInfo.setTotalRecordCount(Integer.parseInt(list.get(0).getString("totCnt")));
		}
		else
		{
			paginationInfo.setTotalRecordCount(0);
		}
		
		//공통코드 배열 셋팅
		ArrayList<String> cdDtlList = new ArrayList<String>();
		
		//예약현황
		cdDtlList.add("RSVTN_PRCS_STTS");
		
		//정의된 코드id값들의 상세 코드 맵 반환		
		emfMap.put("cdDtlList", cmmUseService.selectCmmCodeBindAll(cdDtlList));

		/*
		 홈페이지 개인정보 로그 - 보안관련 로직 신규 구현
		 2017.12.26
		 */
		EmfMap logMap = new EmfMap();
		logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
		logMap.put("gubun", "고객서비스 관리 - 공연예약관리 - 공연예약 조회");
		logMap.put("flag", "S");
		logMap.put("name", RequestContextHolder.getRequestAttributes().getAttribute("name", RequestAttributes.SCOPE_SESSION));
		logMap.put("hp", RequestContextHolder.getRequestAttributes().getAttribute("hp", RequestAttributes.SCOPE_SESSION));
		logMap.put("id", RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION));
		if(logMap.getString("id") != null && !logMap.getString("id").equals("")){
			cmmUseService.actionViewAuthLog(logMap);
		}

		return emfMap;
	}
	
	/**
     * 공연예약 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public EmfMap selectPfmcRsvtn(EmfMap emfMap) throws Exception
	{
		if(!"".equals(EMFStringUtil.nullConvert(emfMap.get("rsvtnSeq"))))
    	{
			EmfMap rsvtnInfo = cMCPfmcRsvtnDAO.selectPfmcRsvtn(emfMap);
			
			if (rsvtnInfo != null)
			{
				emfMap.put("rsvtnInfo", rsvtnInfo);
				
				emfMap.put("cnslList", cMCPfmcRsvtnDAO.selectPfmcRsvtnCnslList(emfMap));
			}
			
			/*
			 홈페이지 개인정보 로그 - 보안관련 로직 신규 구현
			 2017.12.26
			 */
			EmfMap logMap = new EmfMap();
			logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
			logMap.put("gubun", "고객서비스 관리 - 공연예약관리 - 공연예약 상세조회");
			logMap.put("flag", "D");
			logMap.put("name", RequestContextHolder.getRequestAttributes().getAttribute("name", RequestAttributes.SCOPE_SESSION));
			logMap.put("hp", RequestContextHolder.getRequestAttributes().getAttribute("hp", RequestAttributes.SCOPE_SESSION));
			logMap.put("id", RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION));
			if(logMap.getString("id") != null && !logMap.getString("id").equals("")){
				cmmUseService.actionViewAuthLog(logMap);
			}
    	}
		
		//공통코드 배열 셋팅
		ArrayList<String> cdDtlList = new ArrayList<String>();
		
		//예약현황
		cdDtlList.add("RSVTN_PRCS_STTS");
		
		//정의된 코드id값들의 상세 코드 맵 반환		
		emfMap.put("cdDtlList", cmmUseService.selectCmmCodeBindAll(cdDtlList));
		
		return emfMap;
	}

	/**
     * 공연예약을 수정한다.
     * 
     * @param EmfMap
	 * @return
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updatePfmcRsvtn(EmfMap emfMap) throws Exception
	{
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		//공연예약 처리현황 로그를 등록한다.
		int insCnt = cMCPfmcRsvtnDAO.insertPfmcRsvtnPrcsLog(emfMap);
		
		//공연예약을 수정한다.
		cMCPfmcRsvtnDAO.updatePfmcRsvtn(emfMap);
		
		if("00".equals(emfMap.getString("prcsCd")) && insCnt > 0)
		{
			EmfMap rsvtnInfo = cMCPfmcRsvtnDAO.selectPfmcRsvtn(emfMap);
			
			String email = rsvtnInfo.getString("email");
			
			if(!"".equals(email) && Integer.parseInt(rsvtnInfo.getString("cnclCnt")) == 1 && "2".equals(rsvtnInfo.getString("gubun")))
			{
				EmfMap mailMap = new EmfMap();
				
				mailMap.put("subject", "[대명아임레디 예약 취소 안내] 메일입니다.");
				mailMap.put("toUser", email);
				mailMap.put("name", rsvtnInfo.getString("name"));
				mailMap.put("pfmcNm", rsvtnInfo.getString("pfmcNm"));
				mailMap.put("seatCnt", rsvtnInfo.getString("seatCnt"));
				mailMap.put("seatGb", rsvtnInfo.getString("seatGb"));
				mailMap.put("lastRsvtnDtm", EgovDateUtil.convertDate(rsvtnInfo.getString("lastRsvtnDtm"), "yyyy-MM-dd HH:mm:ss", "yyyy년 MM월 dd일(EE) HH시 mm분", ""));
				mailMap.put("reqn", rsvtnInfo.getString("reqn").replace(System.getProperty("line.separator"), "<br />"));
				
				mailService.sendTempleteMail(mailMap, "cm/cmc/CMCRsvtnCnclGuide.html");
			}
		}

		/*
		 홈페이지 개인정보 로그 - 보안관련 로직 신규 구현
		 2017.12.26
		 */
		EmfMap logMap = new EmfMap();
		logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
		logMap.put("gubun", "고객서비스 관리 - 공연예약관리 - 공연예약 수정");
		logMap.put("flag", "M");
		logMap.put("name", RequestContextHolder.getRequestAttributes().getAttribute("name", RequestAttributes.SCOPE_SESSION));
		logMap.put("hp", RequestContextHolder.getRequestAttributes().getAttribute("hp", RequestAttributes.SCOPE_SESSION));
		logMap.put("id", RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION));
		if(logMap.getString("id") != null && !logMap.getString("id").equals("")){
			cmmUseService.actionViewAuthLog(logMap);
		}
	}
	
	/**
     * 공연예약을 삭제한다.
     * 
     * @param EmfMap
	 * @return
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deletePfmcRsvtnList(int[] delSeq) throws Exception 
	{
		EmfMap emfMap = new EmfMap();
		
		emfMap.put("delSeq", delSeq);
		
		cMCPfmcRsvtnDAO.deletePfmcRsvtn(emfMap);

		/*
		 홈페이지 개인정보 로그 - 보안관련 로직 신규 구현
		 2017.12.26
		 */
		EmfMap logMap = new EmfMap();
		logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
		logMap.put("gubun", "고객서비스 관리 - 공연예약관리 - 공연예약 삭제");
		logMap.put("flag", "R");
		logMap.put("name", RequestContextHolder.getRequestAttributes().getAttribute("name", RequestAttributes.SCOPE_SESSION));
		logMap.put("hp", RequestContextHolder.getRequestAttributes().getAttribute("hp", RequestAttributes.SCOPE_SESSION));
		logMap.put("id", RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION));
		if(logMap.getString("id") != null && !logMap.getString("id").equals("")){
			cmmUseService.actionViewAuthLog(logMap);
		}
	}

	/**
     * 공연예약 목록을 조회한다. (엑셀다운로드)
     * 
     * @param EmfMap
	 * @return
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public List<EmfMap> excelPfmcRsvtnList(EmfMap emfMap) throws Exception 
	{
		/*
		 홈페이지 개인정보 로그 - 보안관련 로직 신규 구현
		 2017.12.26
		 */
		EmfMap logMap = new EmfMap();
		logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
		logMap.put("gubun", "고객서비스 관리 - 공연예약관리 - 공연예약 엑셀다운로드");
		logMap.put("flag", "E");
		logMap.put("name", RequestContextHolder.getRequestAttributes().getAttribute("name", RequestAttributes.SCOPE_SESSION));
		logMap.put("hp", RequestContextHolder.getRequestAttributes().getAttribute("hp", RequestAttributes.SCOPE_SESSION));
		logMap.put("id", RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION));
		if(logMap.getString("id") != null && !logMap.getString("id").equals("")){
			cmmUseService.actionViewAuthLog(logMap);
		}

		return cMCPfmcRsvtnDAO.excelPfmcRsvtnList(emfMap);
	}
	
	/**
     * 공연예약 상담이력을 등록한다.
     * 
     * @param EmfMap
	 * @return
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertPfmcRsvtnCnsl(EmfMap emfMap) throws Exception 
	{
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("regId", lgnMap.getString("id"));
		emfMap.put("regIp", lgnMap.getString("loginIp"));
		
		cMCPfmcRsvtnDAO.insertPfmcRsvtnCnsl(emfMap);

		/*
		 홈페이지 개인정보 로그 - 보안관련 로직 신규 구현
		 2017.12.26
		 */
		EmfMap logMap = new EmfMap();
		logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
		logMap.put("gubun", "고객서비스 관리 - 공연예약관리 - 공연예약 상담이력 등록");
		logMap.put("flag", "C");
		logMap.put("name", RequestContextHolder.getRequestAttributes().getAttribute("name", RequestAttributes.SCOPE_SESSION));
		logMap.put("hp", RequestContextHolder.getRequestAttributes().getAttribute("hp", RequestAttributes.SCOPE_SESSION));
		logMap.put("id", RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION));
		if(logMap.getString("id") != null && !logMap.getString("id").equals("")){
			cmmUseService.actionViewAuthLog(logMap);
		}
	}
	
	/**
     * 공연예약 담당자 확인을 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updatePfmcRsvtnConf(EmfMap emfMap) throws Exception
	{
		System.out.println("============== emfMap : "+emfMap);
		emfMap.put("confYn" + emfMap.getString("trgt"), "Y");
		
		cMCPfmcRsvtnDAO.updatePfmcRsvtnConf(emfMap);

		/*
		 홈페이지 개인정보 로그 - 보안관련 로직 신규 구현
		 2017.12.26
		 */
		EmfMap logMap = new EmfMap();
		logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
		logMap.put("gubun", "고객서비스 관리 - 공연예약관리 - 공연예약 담당자 확인정보 수정");
		logMap.put("flag", "M");
		logMap.put("name", RequestContextHolder.getRequestAttributes().getAttribute("name", RequestAttributes.SCOPE_SESSION));
		logMap.put("hp", RequestContextHolder.getRequestAttributes().getAttribute("hp", RequestAttributes.SCOPE_SESSION));
		logMap.put("id", RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION));
		if(logMap.getString("id") != null && !logMap.getString("id").equals("")){
			cmmUseService.actionViewAuthLog(logMap);
		}
	}
}