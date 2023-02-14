package mngwserc.mb.mba.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import mngwserc.co.util.COPaginationUtil;
import mngwserc.cs.csa.service.dao.DMLifeMemDAO;
import mngwserc.mb.mba.service.MBAMemInfService;
import mngwserc.mb.mba.service.dao.MBAMemInfDAO;
import mngwserc.mb.sso.exception.SsoException;
import mngwserc.mb.sso.service.SSOService;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.service.EgovProperties;
import egovframework.com.cmm.service.MailService;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.com.utl.sim.service.SeedCipher;
import egovframework.rte.fdl.idgnr.impl.EgovTableIdGnrService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import emf.core.extend.service.EmfAbstractService;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 회원정보 관리를 위한 ServiceImpl
 * </pre>
 * 
 * @ClassName		: MBAMemInfServiceImpl.java
 * @Description		: 회원정보 관리를 위한 ServiceImpl
 * @author 허진영
 * @since 2016.02.15
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2016.02.15		허진영					 최초생성
 * </pre>
 */
@Service("mBAMemInfService")
public class MBAMemInfServiceImpl extends EmfAbstractService implements MBAMemInfService {
	
	@Resource(name="mBAMemInfDAO")
	private MBAMemInfDAO mBAMemInfDAO;
	
	@Resource(name="dMLifeMemDAO")
	private DMLifeMemDAO dMLifeMemDAO;
	
	@Resource(name="EgovCmmUseService")
    private EgovCmmUseService cmmUseService;
	
	@Resource(name="mailService")
	private MailService mailService;
	
	@Resource(name="memChngIdgen")
	private EgovTableIdGnrService memChngIdgen;

	@Resource(name="ssoService")
	private SSOService ssoService;

	private String ENCODE = EgovProperties.getProperty("Global.CHARCODE");
	
	/**
     * 회원정보 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public EmfMap selectMemInfList(EmfMap emfMap) throws Exception
	{
		
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
		
		//페이징 처리
		emfMap.put("paginationInfo", paginationInfo);    	
		
		//리스트 가져오기
		List<EmfMap> list;
		if (emfMap.get("unqExstYn") == null) // 페이지 처음 진입시 리스트 노출하지 않는다. 검색 눌렀을대 나오는 기본 input값중 하나(unqExstYn)로 비교
		{
			list = new ArrayList();
		}
		else
		{
			// SSO 통합아이디 [S] - SSO 통합 회원아이디 검색
			if (emfMap.getString("f") != null && emfMap.getString("f").equals("3") && emfMap.getString("q") != null)
			{
				emfMap.put("ci", "");
				HashMap ssoMemberInfo = null;
				String strId = (String)emfMap.getString("q");
				try
				{
					ssoMemberInfo = ssoService.find(strId, null, null, lgnMap.getString("loginIp"));
					if (ssoMemberInfo != null && ssoMemberInfo.get("id") != null) 
					{
						emfMap.put("ci", ssoMemberInfo.get("ci"));
					}
				}
				catch (SsoException ex)
				{
				}
				catch (Exception ex)
				{
				}
			}
			// SSO 통합아이디 [E]

			list = mBAMemInfDAO.selectMemInfList(emfMap);
		}

		if(list.size() > 0)
		{
			for (int j=0; j<list.size(); j++) { 
				String name = list.get(j).getString("name");
				String email = list.get(j).getString("email");

				String emailat = "";

				if ( email != null && email != "" && email.length() > 1 ) {
					String[] beforemail = email.split("[@]");
					String[] afteremail = email.split("[@]");
				
					try {
						for (int i = 2; i < beforemail[0].length(); i++) {
							emailat += '*';
						}
					}catch(Exception e) {
						continue; 
					}
				
					try {
						email = beforemail[0].substring(0,2) + emailat + "@" + afteremail[1];
					}catch(StringIndexOutOfBoundsException e) {
						email = beforemail[0].substring(0,2) + emailat + "@";
					}catch(ArrayIndexOutOfBoundsException e) {
						email = beforemail[0].substring(0,2) + emailat + "@";
					}catch(Exception e) {
						continue;
					}
					list.get(j).put("email", email);
				}
				
				if ( name != null && name != "" && name.length() > 1 ) {
					char ch = name.charAt(0);
					
					if (ch>='가' && ch<='힣') {
						name = name.substring(0,1) + "*" + name.substring(2,name.length());
						list.get(j).put("name", name);
					}
					
					if (ch>='A' && ch<='Z') {
						if(name.length() < 4) {
							name = name.substring(0,2) + "*";
							list.get(j).put("name", name);
						} else if(name.length() < 5) {
							name = name.substring(0,2) + "**";
							list.get(j).put("name", name);
						} else {
							name = name.substring(0,2) + "***" + name.substring(5,name.length());
							list.get(j).put("name", name);
						}
					}
	
					if (ch>='a' && ch<='z') {
						if(name.length() < 4) {
							name = name.substring(0,2) + "*";
							list.get(j).put("name", name);
						} else if(name.length() < 5) {
							name = name.substring(0,2) + "**";
							list.get(j).put("name", name);
						} else {
							name = name.substring(0,2) + "***" + name.substring(5,name.length());
							list.get(j).put("name", name);
						}
					}
				}
			}
		}
		
		emfMap.put("list", list);

		if(list.size() > 0)
		{
			paginationInfo.setTotalRecordCount(Integer.parseInt(list.get(0).getString("totCnt")));
			//2017.04.24 박주석 디아모 솔루션 도입 작업
//			for(int i = 0; i < list.size(); i++)
//			{
//				if(!"".equals(EMFStringUtil.nullConvert(list.get(i).get("email"))))
//				{
//					list.get(i).put("email", SeedCipher.decrypt(list.get(i).getString("email"), ENCODE));
//				}
//			}

			// SSO 통합아이디 [S]
			for (int i=0; i<list.size(); i++) {
				HashMap ssoMemberInfo = null;
				String strCi = list.get(i).getString("ci");
				list.get(i).put("ssoId", "");
				// 동일 CI값의 회원이 SSO에 존재하는지 확인
				try
				{
					ssoMemberInfo = ssoService.find(null, null, strCi, lgnMap.getString("loginIp"));
					if (ssoMemberInfo != null && ssoMemberInfo.get("id") != null) 
					{
						list.get(i).put("ssoId", ssoMemberInfo.get("id"));
					}
				}
				catch (SsoException ex)
				{
					continue;
				}
				catch (Exception ex)
				{
					continue;
				}
			}
			// SSO 통합아이디 [E]
		}
		else
		{
			paginationInfo.setTotalRecordCount(0);
		}

		/*
		 홈페이지 개인정보 로그 - 보안관련 로직 신규 구현
		 2017.12.26
		 */
		EmfMap logMap = new EmfMap();
		logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
		logMap.put("gubun", "회원 관리 - 회원정보 조회");
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
     * 회원정보 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public EmfMap selectMemInf(EmfMap emfMap) throws Exception
	{
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		EmfMap memInfo = mBAMemInfDAO.selectMemInf(emfMap);
		
    	if(memInfo != null)
    	{
			// SSO 통합아이디 [S]
			HashMap ssoMemberInfo = null;
			String strCi = memInfo.getString("ci");
			memInfo.put("ssoId", "");
			// 동일 CI값의 회원이 SSO에 존재하는지 확인
			try
			{
				ssoMemberInfo = ssoService.find(null, null, strCi, lgnMap.getString("loginIp"));
				if (ssoMemberInfo != null && ssoMemberInfo.get("id") != null) 
				{
					memInfo.put("ssoId", ssoMemberInfo.get("id"));
				}
			}
			catch (SsoException ex)
			{
			}
			catch (Exception ex)
			{
			}
			// SSO 통합아이디 [E]

			/*
			 회원 고유번호 자동 업데이트 관련 확인 요청(http://183.111.69.197:8080/issues/79)
			 */
			if(!StringUtils.isEmpty(strCi)){
				emfMap.put("ci", strCi);
				//고유번호 가져오기
				EmfMap dmLifeMap = dMLifeMemDAO.selectDMLifeMemInfByCi(emfMap);
				if(dmLifeMap != null){
					memInfo.put("memNo", dmLifeMap.get("memNo"));	
				}
			}
			
    		emfMap.put("memInfo", memInfo);
    		//2017.04.24 박주석 디아모 솔루션 도입 작업
//    		if(!"".equals(EMFStringUtil.nullConvert(memInfo.get("email"))))
//			{
//    			memInfo.put("email", SeedCipher.decrypt(memInfo.getString("email"), ENCODE));
//			}
//    		
//    		if(!"".equals(EMFStringUtil.nullConvert(memInfo.get("hp"))))
//			{
//    			memInfo.put("hp", SeedCipher.decrypt(memInfo.getString("hp"), ENCODE));
//			}
//    		
//    		if(!"".equals(EMFStringUtil.nullConvert(memInfo.get("tel"))))
//			{
//    			memInfo.put("tel", SeedCipher.decrypt(memInfo.getString("tel"), ENCODE));
//			}
//    		
//    		if(!"".equals(EMFStringUtil.nullConvert(memInfo.get("adrDtl"))))
//			{
//    			memInfo.put("adrDtl", SeedCipher.decrypt(memInfo.getString("adrDtl"), ENCODE));
//			}
    		
    		//서비스수신 변경 로그를 조회한다.
    		emfMap.put("srvcRcvModLog", mBAMemInfDAO.selectSrvcRcvModLog(memInfo));
    	}
    	
    	//공통코드 배열 셋팅
		ArrayList<String> cdDtlList = new ArrayList<String>();
		
		//회원 - 가입경로
		cdDtlList.add("JOIN_PATH_GB");
		
		//회원 - 관심정보
		cdDtlList.add("INTR_GB");
		
		//회원 - 선호정보
		cdDtlList.add("PFRN_GB");
		
		//정의된 코드id값들의 상세 코드 맵 반환		
		emfMap.put("cdDtlList", cmmUseService.selectCmmCodeBindAll(cdDtlList));


		/*
		 홈페이지 개인정보 로그 - 보안관련 로직 신규 구현
		 2017.12.26
		 */
		EmfMap logMap = new EmfMap();
		logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
		logMap.put("gubun", "회원 관리 - 회원정보 상세조회");
		logMap.put("flag", "D");
		logMap.put("name", RequestContextHolder.getRequestAttributes().getAttribute("name", RequestAttributes.SCOPE_SESSION));
		logMap.put("hp", RequestContextHolder.getRequestAttributes().getAttribute("hp", RequestAttributes.SCOPE_SESSION));
		logMap.put("id", RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION));
		if(logMap.getString("id") != null && !logMap.getString("id").equals("")){
			cmmUseService.actionViewAuthLog(logMap);
		}
		
    	return emfMap;
	}
	
	/**
     * 회원정보를 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateMemInf(EmfMap emfMap) throws Exception {

		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("chngSeq", memChngIdgen.getNextIntegerId());
		//2017.04.24 박주석 디아모 솔루션 도입 작업
//		if(!"".equals(EMFStringUtil.nullConvert(emfMap.get("email"))))
//		{
//			emfMap.put("email", SeedCipher.encrypt(emfMap.getString("email"), ENCODE));	
//		}	
//		
//		if(!"".equals(EMFStringUtil.nullConvert(emfMap.get("hp"))))
//		{
//			emfMap.put("hp", SeedCipher.encrypt(emfMap.getString("hp"), ENCODE));	
//		}
//		
//		if(!"".equals(EMFStringUtil.nullConvert(emfMap.get("tel"))))
//		{
//			emfMap.put("tel", SeedCipher.encrypt(emfMap.getString("tel"), ENCODE));	
//		}
//		
//		if(!"".equals(EMFStringUtil.nullConvert(emfMap.get("adrDtl"))))
//		{
//			emfMap.put("adrDtl", SeedCipher.encrypt(emfMap.getString("adrDtl"), ENCODE));	
//		}	
		
		emfMap.put("regId", lgnMap.getString("id"));
		emfMap.put("regIp", lgnMap.getString("loginIp"));
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		//회원정보 패스워드 수정(http://183.111.69.197:8080/issues/76)
		String chgPwdYN = "N";
		String chgPwd = "";
		if(!StringUtils.isEmpty(emfMap.getString("pwd1")) && !StringUtils.isEmpty(emfMap.getString("pwd2"))){
			chgPwdYN = "Y";
			chgPwd = SeedCipher.oneencrypt(emfMap.getString("pwd1"));		// 비밀번호 암호화
			emfMap.put("chgPwdYN", chgPwdYN);
			emfMap.put("chgPwd", chgPwd);
		}
		
		//회원 정보 수정 로그등록
		mBAMemInfDAO.insertMemInfModLog(emfMap);

		//회원 정보 수정
		mBAMemInfDAO.updateMemInf(emfMap);
		
		// SSO 통합아이디 [S]
		if (emfMap.getString("ssoId") != null && emfMap.getString("ssoId") != "")
		{
			
			EmfMap memInfo = mBAMemInfDAO.selectMemInf(emfMap);
			
			if (memInfo != null && memInfo.getString("ci") != null && memInfo.getString("ci") != "")
			{
				String marketingYn = "";
				if (memInfo.getString("marketingYn") == null || memInfo.getString("marketingYn") == "")
					marketingYn = "N";
				else
					marketingYn = memInfo.getString("marketingYn");
				
				//회원정보 패스워드 수정(http://183.111.69.197:8080/issues/76)
				if("Y".equals(chgPwdYN)){
					if(emfMap.getString("pwd1").equals(emfMap.getString("pwd2"))){
						ssoService.updatePassword(
								emfMap.getString("ssoId"), memInfo.getString("ci"), null, null, chgPwd, lgnMap.getString("loginIp"));
					}								
				}
				
				//회원정보 정보 수정
				ssoService.update(emfMap.getString("ssoId")
									, memInfo.getString("ci")
									, lgnMap.getString("loginIp")
									, memInfo.getString("name")
									, memInfo.getString("email")
									, memInfo.getString("tel")
									, memInfo.getString("hp")
									, memInfo.getString("zipcd")
									, memInfo.getString("adr")
									, memInfo.getString("adrDtl")
									, marketingYn
									, memInfo.getString("birth")
									);									
			}
		}
		// SSO 통합아이디 [E]
		
		//관심내역 setting
		List<String> intrGb = emfMap.getList("intrGb");
		
		String intrPtc = "";
		
		for(int i = 0; i < intrGb.size(); i++)
		{
			if(i == 0)
			{
				intrPtc = intrGb.get(i);
			}
			else
			{
				intrPtc = intrPtc.concat(", " + intrGb.get(i));
			}
		}
		
		emfMap.put("intrPtc", intrPtc);
		
		//선호내역 setting
		List<String> pfrnGb = emfMap.getList("pfrnGb");
		
		String pfrnPtc = "";
		
		for(int i = 0; i < pfrnGb.size(); i++)
		{
			if(i == 0)
			{
				pfrnPtc = pfrnGb.get(i);
			}
			else
			{
				pfrnPtc = pfrnPtc.concat(", " + pfrnGb.get(i));
			}
		}
		
		emfMap.put("pfrnPtc", pfrnPtc);
		
		//기타 정보 수정
		mBAMemInfDAO.updateEtcInf(emfMap);

		/*
		 홈페이지 개인정보 로그 - 보안관련 로직 신규 구현
		 2017.12.26
		 */
		EmfMap logMap = new EmfMap();
		logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
		logMap.put("gubun", "회원 관리 - 회원정보 수정");
		logMap.put("flag", "M");
		logMap.put("name", RequestContextHolder.getRequestAttributes().getAttribute("name", RequestAttributes.SCOPE_SESSION));
		logMap.put("hp", RequestContextHolder.getRequestAttributes().getAttribute("hp", RequestAttributes.SCOPE_SESSION));
		logMap.put("id", RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION));
		if(logMap.getString("id") != null && !logMap.getString("id").equals("")){
			cmmUseService.actionViewAuthLog(logMap);
		}
	}

	/**
	 * 회원 탈퇴
	 *
	 * @param emfMap
	 * @throws Exception
	 */
	@Transactional
	public void updateMemDrot(EmfMap emfMap) throws Exception {
		EmfMap integrationMemberInfo = mBAMemInfDAO.getIntegrationMember(emfMap);

		if (integrationMemberInfo != null && emfMap.get("id").equals(integrationMemberInfo.get("homepageId"))) {
			// 통합 회원 탈퇴
			mBAMemInfDAO.dropOutIntegrationMember(integrationMemberInfo);
			//회원 탈퇴 테이블로 이관 후 회원정보 테이블에서 삭제
			mBAMemInfDAO.insertMemDropInfo(integrationMemberInfo);
			mBAMemInfDAO.deleteMemDrot(integrationMemberInfo);
			//부가식별정보를 삭제한다.
			mBAMemInfDAO.deleteIdntInf(integrationMemberInfo);

			// 탈퇴 메일 전송
			String email = EMFStringUtil.nullConvert(integrationMemberInfo.get("email"));
			String name = EMFStringUtil.nullConvert(integrationMemberInfo.get("name"));
			if (!"".equals(email) && !"".equals(name)) {
				EmfMap mailMap = new EmfMap();
				mailMap.put("subject", "[대명아임레디 회원 탈퇴 완료] 메일입니다.");
				mailMap.put("toUser", email);
				mailMap.put("name", name);
				mailService.sendTempleteMail(mailMap, "mb/mba/MBAMemDrotComp.html");
			}

//			홈페이지 개인정보 로그 - 보안관련 로직 신규 구현
			EmfMap logMap = new EmfMap();
			logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
			logMap.put("gubun", "회원 관리 - 회원정보 탈퇴");
			logMap.put("flag", "W");
			logMap.put("name", RequestContextHolder.getRequestAttributes().getAttribute("name", RequestAttributes.SCOPE_SESSION));
			logMap.put("hp", RequestContextHolder.getRequestAttributes().getAttribute("hp", RequestAttributes.SCOPE_SESSION));
			logMap.put("id", RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION));
			if(logMap.getString("id") != null && !logMap.getString("id").equals("")){
				cmmUseService.actionViewAuthLog(logMap);
			}
		}
	}
	
	// SSO 통합아이디 [S]
	@Transactional
	public void updateMemDrot_Sso(EmfMap emfMap) throws Exception {
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		EmfMap memInfo = mBAMemInfDAO.selectMemInf(emfMap);

		if (memInfo != null && memInfo.getString("id") != "")
		{
			if(!StringUtils.isEmpty(emfMap.getString("ssoId"))){
				// SSO 회원 탈퇴
				HashMap ssoMemberInfo = ssoService.find(emfMap.getString("ssoId"), null, null, lgnMap.getString("loginIp"));
				if (ssoMemberInfo.get("id") != null && ssoMemberInfo.get("id") != "") //SSO 회원 존재
				{
					ssoService.drop((String)ssoMemberInfo.get("id"), (String)ssoMemberInfo.get("uid"), lgnMap.getString("loginIp"));
				}				
			}

			memInfo.put("homepageId", memInfo.getString("id"));
			//회원 탈퇴 테이블로 이관 후 회원정보 테이블에서 삭제
			mBAMemInfDAO.insertMemDropInfo(memInfo);
			mBAMemInfDAO.deleteMemDrot(memInfo);
			mBAMemInfDAO.deleteMemEtcDrot(memInfo);
			//부가식별정보를 삭제한다.
			mBAMemInfDAO.deleteIdntInf(memInfo);

			// 탈퇴 메일 전송
			String email = EMFStringUtil.nullConvert(memInfo.get("email"));
			String name = EMFStringUtil.nullConvert(memInfo.get("name"));
			if (!"".equals(email) && !"".equals(name)) {
				EmfMap mailMap = new EmfMap();
				mailMap.put("subject", "[대명아임레디 회원 탈퇴 완료] 메일입니다.");
				mailMap.put("toUser", email);
				mailMap.put("name", name);
				mailService.sendTempleteMail(mailMap, "mb/mba/MBAMemDrotComp.html");
			}

//			홈페이지 개인정보 로그 - 보안관련 로직 신규 구현
			EmfMap logMap = new EmfMap();
			logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
			logMap.put("gubun", "회원 관리 - 회원정보 탈퇴");
			logMap.put("flag", "W");
			logMap.put("name", RequestContextHolder.getRequestAttributes().getAttribute("name", RequestAttributes.SCOPE_SESSION));
			logMap.put("hp", RequestContextHolder.getRequestAttributes().getAttribute("hp", RequestAttributes.SCOPE_SESSION));
			logMap.put("id", RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION));
			if(logMap.getString("id") != null && !logMap.getString("id").equals("")){
				cmmUseService.actionViewAuthLog(logMap);
			}
		}
	}
	// SSO 통합아이디 [E]

	/**
     * 회원정보 목록을 조회한다. (엑셀다운로드)
     * 
     * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */	
	public List<EmfMap> excelMemInfList(EmfMap emfMap)throws Exception
	{
		List<EmfMap> list = mBAMemInfDAO.excelMemInfList(emfMap);
		//2017.04.24 박주석 디아모 솔루션 도입 작업
//		for(int i = 0; i < list.size(); i++)
//		{
//			if(!"".equals(EMFStringUtil.nullConvert(list.get(i).get("email"))))
//			{
//				list.get(i).put("email", SeedCipher.decrypt(list.get(i).getString("email"), ENCODE));
//			}
//		}

        HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = req.getSession();
        String id = (String)session.getAttribute("id");
        String id2 = (String)RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION);
        EmfMap admLgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		/*2022.03.18 황순용 refactor*/
		cmmUseService.actionViewAuthLogV2("회원 관리 - 회원정보 엑셀 다운로드", emfMap.getString("reason"), "E", null);

		return list;
	}
	
	/**
     * 고객서비스 변경 목록을 조회한다. (엑셀다운로드)
     * 
     * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */	
	public List<EmfMap> excelRcvModList(EmfMap emfMap)throws Exception
	{

		/*
		 홈페이지 개인정보 로그 - 보안관련 로직 신규 구현
		 2017.12.26
		 */
		EmfMap logMap = new EmfMap();
		logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
		logMap.put("gubun", "회원 관리 - 회원정보 변경 목록 엑셀 다운로드");
		logMap.put("flag", "E");
		logMap.put("name", RequestContextHolder.getRequestAttributes().getAttribute("name", RequestAttributes.SCOPE_SESSION));
		logMap.put("hp", RequestContextHolder.getRequestAttributes().getAttribute("hp", RequestAttributes.SCOPE_SESSION));
		logMap.put("id", RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION));
		if(logMap.getString("id") != null && !logMap.getString("id").equals("")){
			cmmUseService.actionViewAuthLog(logMap);
		}
		
		return mBAMemInfDAO.excelRcvModList(emfMap);
	}
}
