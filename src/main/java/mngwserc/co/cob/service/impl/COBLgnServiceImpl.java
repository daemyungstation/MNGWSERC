package mngwserc.co.cob.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import mngwserc.co.cob.service.COBLgnService;
import mngwserc.co.cob.service.dao.COBLgnDAO;
import mngwserc.co.cob.service.dao.COBLgnOutDAO;
import mngwserc.co.cof.service.COFSysLogService;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import egovframework.com.cmm.service.EgovProperties;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.com.utl.fcc.service.EgovDateUtil;
import egovframework.com.utl.sim.service.EgovNetworkState;
import egovframework.com.utl.sim.service.SeedCipher;
import emf.core.extend.service.EmfAbstractService;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 로그인을 위한 Controller
 * </pre>
 * 
 * @ClassName		: COBLgnServiceImpl.java
 * @Description		: 로그인 ServiceImpl
 * @author 박주석
 * @since 2015.11.22
 * @version 1.0
 * @see
 * @Modification Information
 * <pre> 
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2015.11.22		박주석					최초생성
 * </pre>
 */
@Service("cOBLgnService") 
public class COBLgnServiceImpl extends EmfAbstractService implements COBLgnService {
	
    @Resource(name="cOBLgnDAO")
    private COBLgnDAO cOBLgnDAO;
    
    @Resource(name="cOBLgnOutDAO")
    private COBLgnOutDAO cOBLgnOutDAO;
    
    @Resource(name="cOFSysLogService")
	private COFSysLogService cOFSysLogService;
    
    private String intraDefPwd = EgovProperties.getProperty("Globals.intraDefPwd");
    
    /**
	 * 일반 로그인을 처리한다
	 * @param EmfMap
	 * @return EmfMap
	 * @exception Exception
	 */
    public EmfMap actionLogin(HttpServletRequest request, EmfMap paramMap) throws Exception 
    {    	
    	//보안문자 체크
 		String captcha = EMFStringUtil.nullConvert(request.getSession().getAttribute("CurrentAnswer"));

		int retryCount;
		retryCount = (Integer) RequestContextHolder.  getRequestAttributes().getAttribute("retryCount", RequestAttributes.SCOPE_SESSION) == null ? 0 : (Integer) RequestContextHolder.getRequestAttributes().getAttribute("retryCount", RequestAttributes.SCOPE_SESSION) ;
		log.debug(retryCount);
    	
    	//단방향 암호화 처리
    	String enpassword = SeedCipher.oneencrypt(paramMap.getString("password"));
    	
    	paramMap.put("password", enpassword);
    	
    	EmfMap emfMap = cOBLgnDAO.actionLogin(paramMap);

    	String captchaYn = "Y";

    	if (emfMap != null){
        	if(retryCount > 4){
        		if(!captcha.equals(EMFStringUtil.nullConvert(paramMap.get("captchaText")))) 
        		{
        			emfMap.put("msg", "보안문자가 일치하지 않습니다.");
        			emfMap.put("url", "/mngwsercgateway/getLogin.do");
        			
        			captchaYn = "N";
        		}
        	}

        	if( captchaYn.equals("Y") ) {

	    		emfMap.put("url", "");
	    		emfMap.put("loginIp", EgovNetworkState.getMyIPaddress(request));
	    		emfMap.put("ip", EgovNetworkState.getMyIPaddress(request));
	    		emfMap.put("gubun", "로그인");
	    		emfMap.put("flag", "R");
	    		
		    	//최초 REDIRECT URL 설정
				List<EmfMap> gnbMenuList = getMenuList(emfMap);
				
				String pageAdminLink = "";
				String firstUrl = "";
				
				EmfMap gnbEmfMap = null;
	
				for (int i = 0; i < gnbMenuList.size(); i++)
				{
					gnbEmfMap = (EmfMap) gnbMenuList.get(i);
					pageAdminLink = getUrlFolder(gnbEmfMap.getString("admLink"));
					
					if("".equals(firstUrl) && !"".equals(pageAdminLink))
					{
						firstUrl = gnbEmfMap.getString("admLink");
						
						emfMap.put("url", firstUrl);
					}
				}			
				
				emfMap.put("conSessionId", RequestContextHolder.getRequestAttributes().getSessionId());
			
				RequestContextHolder.getRequestAttributes().setAttribute("admLgnMap", emfMap, RequestAttributes.SCOPE_SESSION);
				RequestContextHolder.getRequestAttributes().setAttribute("gnbMenuList", gnbMenuList, RequestAttributes.SCOPE_SESSION);
				
				RequestContextHolder.getRequestAttributes().setAttribute("ip", emfMap.getString("ip"), RequestAttributes.SCOPE_SESSION);
				RequestContextHolder.getRequestAttributes().setAttribute("name", emfMap.getString("name"), RequestAttributes.SCOPE_SESSION);
				RequestContextHolder.getRequestAttributes().setAttribute("hp", "01010002000", RequestAttributes.SCOPE_SESSION);
				RequestContextHolder.getRequestAttributes().setAttribute("id", emfMap.getString("id"), RequestAttributes.SCOPE_SESSION);
				RequestContextHolder.getRequestAttributes().setAttribute("check", "N", RequestAttributes.SCOPE_SESSION);

				//로그인 시간을 업데이트 해준다.
				cOBLgnDAO.setLgnLstDtm(emfMap);
				
				//cOBLgnDAO.setAdmAuthLog(emfMap);
				
	    		//3개월 비번 주기 확인 
		    	String lastUpdPassDate = emfMap.getString("lastPwdModDtm");
	
		    	if ("".equals(lastUpdPassDate))
				{
					lastUpdPassDate = EgovDateUtil.convertDate(emfMap.getString("regDtm"), "yyyy-MM-dd", "yyyyMMdd", "");
				}
				else
				{
					lastUpdPassDate = EgovDateUtil.convertDate(lastUpdPassDate, "yyyy-MM-dd", "yyyyMMdd", "");
				}
	
				if (EgovDateUtil.getDaysDiff(lastUpdPassDate, EgovDateUtil.getToday()) > 90)
				{
					//emfMap.put("msg", "개인정보 보호를 위해 3개월 마다\\n비밀번호 변경을 하셔야 이용이 가능합니다.");
					emfMap.put("msg", "회원님의 개인정보보호를 위하여 비밀번호를 변경해 주시기 바랍니다.\\n\\n"
							+ "개인정보 유출로 인한 피해 사례를 방지하기 위해 회원님의 소중한 개인정보를 보호하고자 비밀번호 변경 안내를 시행하고 있습니다.\\n\\n"
							+ "타 사이트와 동일한 비밀번호 사용을 할 경우, 개인정보 도용에 노출될 가능성이 높습니다.\\n\\n"
							+ "불편하시더라도 비밀번호를 자주 변경해 주시기 바랍니다.");

					emfMap.put("url", "/mngwsercgateway/getPwdChng.do");
		    		return emfMap;
				}
				
				
				//로그인 로그를 등록한다.
				EmfMap sysLogMap = new EmfMap();
				
				sysLogMap.put("srvcNm", "COBLgnServiceImpl");
				sysLogMap.put("fncNm", "actionLogin");
				sysLogMap.put("trgtMenuNm", "로그인 페이지");
				sysLogMap.put("prcsCd", "L");
				sysLogMap.put("prcsTime", "100");
				sysLogMap.put("reqnId", emfMap.getString("id"));
				sysLogMap.put("reqnIp", emfMap.getString("loginIp"));
				
				try
				{
					cOFSysLogService.logInsertSysLog(sysLogMap);
				}
				catch(Exception e)
				{
					log.debug(e.getMessage());
				}
        	}
    	}
    	else
    	{
    		//대명 인트라넷 사원 테이블 조회
    		emfMap = cOBLgnOutDAO.actionLogin(paramMap);
    		
    		if (emfMap != null)
        	{
            	if(retryCount > 4){
            		if(!captcha.equals(EMFStringUtil.nullConvert(paramMap.get("captchaText")))) 
            		{
            			emfMap.put("msg", "보안문자가 일치하지 않습니다.");
            			emfMap.put("url", "/mngwsercgateway/getLogin.do");
            			
            			captchaYn = "N";
            		}
            	}

            	if( captchaYn.equals("Y") ) {
	    			emfMap.put("id", emfMap.getString("grpEmpleNo"));
	    			emfMap.put("name", emfMap.getString("empleNm"));
	    			emfMap.put("loginIp", EgovNetworkState.getMyIPaddress(request));
	        		
	    	    	//최초 REDIRECT URL 설정
	    			emfMap.put("url", "/mngwserc/allowance/benefit/year/index.do");
	    			
	    			emfMap.put("conSessionId", RequestContextHolder.getRequestAttributes().getSessionId());
	    			
	    			emfMap.put("intra", "Y");
	    			emfMap.put("roleCd", "ROLE_00012");
	    		
	    			RequestContextHolder.getRequestAttributes().setAttribute("admLgnMap", emfMap, RequestAttributes.SCOPE_SESSION);
	    			
	    			//최초 로그인 확인
	    			if (intraDefPwd.equals(enpassword))
	    			{
	    				emfMap.put("msg", "비밀번호 변경을 하셔야 이용이 가능합니다.");
	    	    		emfMap.put("url", "/mngwsercgateway/getPwdChng.do");
	    	    		return emfMap;
	    			}
	    			
	    			//로그인 로그를 등록한다.
	    			EmfMap intraLogMap = new EmfMap();
	    			
	    			intraLogMap.put("cntrCd", "WEB");
	    			intraLogMap.put("lgnTypCd", "LOGIN");
	    			intraLogMap.put("reqnId", emfMap.getString("id"));
	    			intraLogMap.put("reqnIp", emfMap.getString("loginIp"));
	    			
	    			try
	    			{
	    				cOBLgnOutDAO.logInsertIntraLog(intraLogMap);
	    			}
	    			catch(Exception e)
	    			{
	    				log.debug(e.getMessage());
	    			}
            	}
        	}
    		else
    		{
    			retryCount++;

    			RequestContextHolder.getRequestAttributes().setAttribute("retryCount", retryCount, RequestAttributes.SCOPE_SESSION);

    			emfMap = new EmfMap();
        		
         		emfMap.put("msg", "로그인 정보가 올바르지 않습니다.");
        		emfMap.put("url", "/mngwsercgateway/getLogin.do");
        	}
    	}
    	
    	return emfMap;
    }

    /**
	 * 일반 로그인을 처리한다
	 * @param EmfMap
	 * @return EmfMap
	 * @exception Exception
	 */
    public EmfMap checkLogin(HttpServletRequest request, EmfMap paramMap) throws Exception 
    {    	
    	//보안문자 체크
		String captcha = EMFStringUtil.nullConvert(request.getSession().getAttribute("CurrentAnswer"));

//		int retryCount;
//		retryCount = (Integer) RequestContextHolder.getRequestAttributes().getAttribute("retryCount", RequestAttributes.SCOPE_SESSION) == null ? 0 : (Integer) RequestContextHolder.getRequestAttributes().getAttribute("retryCount", RequestAttributes.SCOPE_SESSION) ;
//		log.debug(retryCount);
		
		EmfMap lgnInfo = cOBLgnDAO.selectMemLgnCnt(paramMap.getString("id"));
		Integer retryCount = 1;
		
		if (lgnInfo != null) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date lastLgnDate = formatter.parse(lgnInfo.getString("lastLgnTryDtm"));
			Calendar cal = new GregorianCalendar(Locale.KOREA);
			cal.add(Calendar.DAY_OF_YEAR,  -1);
			
			if (lastLgnDate.getTime() < cal.getTimeInMillis()) {
				// 마지막 로그인시도 한지 하루 지났을때 카운트 초기화
				lgnInfo.put("lgnTryCnt", retryCount);
				cOBLgnDAO.updateMemLgnCnt(lgnInfo);
			} else {
				retryCount += Integer.valueOf(String.valueOf(lgnInfo.get("lgnTryCnt")));
				lgnInfo.put("lgnTryCnt", retryCount);
				cOBLgnDAO.updateMemLgnCnt(lgnInfo);
			}
		} else {
			cOBLgnDAO.insertMemLgnCnt(paramMap);
		}
		
    	//단방향 암호화 처리
    	String enpassword = SeedCipher.oneencrypt(paramMap.getString("password"));
    	paramMap.put("password", enpassword);
    	
    	EmfMap emfMap = cOBLgnDAO.actionLogin(paramMap);

    	String captchaYn = "Y";
    	String checkCaptha = "Y";
    	
    	if(retryCount > 4){
    		if(!captcha.equals(EMFStringUtil.nullConvert(paramMap.get("captchaText")))) 
    		{
    			emfMap.put("msg", "보안문자가 일치하지 않습니다.");
    			emfMap.put("url", "/mngwsercgateway/getLogin.do");
    			emfMap.put("flag", "3");
    			
    			captchaYn = "N";
    		}
    	}
    	
    	if(retryCount > 4 && EMFStringUtil.nullConvert(paramMap.get("captchaText")).equals("")) {
    		checkCaptha = "N";
    		RequestContextHolder.getRequestAttributes().setAttribute("checkCaptha", checkCaptha, RequestAttributes.SCOPE_SESSION);
    	}
    	
    	if( captchaYn.equals("Y") ) {
	    	if (emfMap != null && checkCaptha.equals("Y"))
	    	{
	    		EmfMap resultMap = cOBLgnDAO.getMaxLogId(paramMap);

	    		RequestContextHolder.getRequestAttributes().setAttribute("id", emfMap.getString("id"), RequestAttributes.SCOPE_SESSION);
	        	RequestContextHolder.getRequestAttributes().setAttribute("authCd", emfMap.getString("authCd"), RequestAttributes.SCOPE_SESSION);
	    		RequestContextHolder.getRequestAttributes().setAttribute("admSeq", emfMap.getString("admSeq"), RequestAttributes.SCOPE_SESSION);
	    		RequestContextHolder.getRequestAttributes().setAttribute("roleCd", emfMap.getString("roleCd"), RequestAttributes.SCOPE_SESSION);
	    		RequestContextHolder.getRequestAttributes().setAttribute("lastPwdModDtm", emfMap.getString("lastPwdModDtm"), RequestAttributes.SCOPE_SESSION);
	    		RequestContextHolder.getRequestAttributes().setAttribute("regDtm", emfMap.getString("regDtm"), RequestAttributes.SCOPE_SESSION);
/*	    		
	    		System.out.println("------------------>get");
	    		System.out.println("authCd"+RequestContextHolder.getRequestAttributes().getAttribute("authCd", RequestAttributes.SCOPE_SESSION));
	    		System.out.println("admSeq"+RequestContextHolder.getRequestAttributes().getAttribute("admSeq", RequestAttributes.SCOPE_SESSION));
	    		System.out.println("roleCd"+RequestContextHolder.getRequestAttributes().getAttribute("roleCd", RequestAttributes.SCOPE_SESSION));
	    		System.out.println("logSeq"+RequestContextHolder.getRequestAttributes().getAttribute("logSeq", RequestAttributes.SCOPE_SESSION));
	    		System.out.println("------------------>get");
*/	    		
	    		if(resultMap != null){
		    		if( EMFStringUtil.nullConvert(resultMap.getString("logout")) == null){
		    			RequestContextHolder.getRequestAttributes().setAttribute("logSeq", resultMap.getString("logSeq"), RequestAttributes.SCOPE_SESSION);
		    			emfMap.put("url", "/mngwsercgateway/getLogin.do");
		    			emfMap.put("flag", "1");
			    		emfMap.put("msg", "다른 사용자가 사용중입니다. 로그인하시겠습니까? <br /> 5 초 후 로그인페이지로 이동합니다.");
		    		} else {
			    		emfMap.put("url", "/mngwsercgateway/getLogin.do");
			    		emfMap.put("loginIp", EgovNetworkState.getMyIPaddress(request));
			    		emfMap.put("flag", "2");
			    		emfMap.put("msg", "");
		    		}
	    		} else {
		    		emfMap.put("url", "/mngwsercgateway/getLogin.do");
		    		emfMap.put("loginIp", EgovNetworkState.getMyIPaddress(request));
		    		emfMap.put("flag", "2");
		    		emfMap.put("msg", "");
	    		}
	    		
	    		lgnInfo.put("lgnTryCnt", 0);
				cOBLgnDAO.updateMemLgnCnt(lgnInfo);

	    		//3개월 비번 주기 확인 
		    	String lastUpdPassDate = emfMap.getString("lastPwdModDtm");
	
		    	if ("".equals(lastUpdPassDate))
				{
					lastUpdPassDate = EgovDateUtil.convertDate(emfMap.getString("regDtm"), "yyyy-MM-dd", "yyyyMMdd", "");
				}
				else
				{
					lastUpdPassDate = EgovDateUtil.convertDate(lastUpdPassDate, "yyyy-MM-dd", "yyyyMMdd", "");
				}
	
				if (EgovDateUtil.getDaysDiff(lastUpdPassDate, EgovDateUtil.getToday()) > 90)
				{
					RequestContextHolder.getRequestAttributes().setAttribute("admLgnMap", emfMap, RequestAttributes.SCOPE_SESSION);

					//emfMap.put("msg", "개인정보 보호를 위해 3개월 마다\\n비밀번호 변경을 하셔야 이용이 가능합니다.");
					emfMap.put("msg", "회원님의 개인정보보호를 위하여 비밀번호를 변경해 주시기 바랍니다.\\n\\n"
							+ "개인정보 유출로 인한 피해 사례를 방지하기 위해 회원님의 소중한 개인정보를 보호하고자 비밀번호 변경 안내를 시행하고 있습니다.\\n\\n"
							+ "타 사이트와 동일한 비밀번호 사용을 할 경우, 개인정보 도용에 노출될 가능성이 높습니다.\\n\\n"
							+ "불편하시더라도 비밀번호를 자주 변경해 주시기 바랍니다.");

					emfMap.put("url", "/mngwsercgateway/getPwdChng.do");
		    		emfMap.put("flag", "4");
		    		return emfMap;
				}
	    	
	    	} 
	    	else 
	    	{
//	    		retryCount++;
	    		
    			RequestContextHolder.getRequestAttributes().setAttribute("retryCount", retryCount, RequestAttributes.SCOPE_SESSION);

    			emfMap = new EmfMap();
	    		emfMap.put("msg", "로그인 정보가 올바르지 않습니다.");
	    		emfMap.put("flag", "3");
    			emfMap.put("url", "/mngwsercgateway/getLogin.do");
	    	}
    	}
/*    	
    	System.out.println("final~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    	System.out.println("msg 	==> "+emfMap.getString("msg"));
    	System.out.println("flag 	==> "+emfMap.getString("flag"));
    	System.out.println("url 	==> "+emfMap.getString("url"));
    	System.out.println("final~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
*/
    	return emfMap;
    }

    /**
	 * 일반 로그인을 처리한다
	 * @param EmfMap
	 * @return EmfMap
	 * @exception Exception
	 */
    public EmfMap moveLogin(HttpServletRequest request, EmfMap paramMap) throws Exception 
    {    	
    	EmfMap emfMap = new EmfMap();
    	emfMap.put("url", "");
		emfMap.put("loginIp", EgovNetworkState.getMyIPaddress(request));
		emfMap.put("ip", EgovNetworkState.getMyIPaddress(request));
		emfMap.put("gubun", "로그인");
		emfMap.put("flag", "L");
		emfMap.put("name", RequestContextHolder.getRequestAttributes().getAttribute("name", RequestAttributes.SCOPE_SESSION));
		emfMap.put("hp", RequestContextHolder.getRequestAttributes().getAttribute("hp", RequestAttributes.SCOPE_SESSION));
		emfMap.put("ci", paramMap.getString("ci"));
		emfMap.put("id", RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION));
		emfMap.put("authCd", RequestContextHolder.getRequestAttributes().getAttribute("authCd", RequestAttributes.SCOPE_SESSION));
		emfMap.put("admSeq", RequestContextHolder.getRequestAttributes().getAttribute("admSeq", RequestAttributes.SCOPE_SESSION));
		emfMap.put("roleCd", RequestContextHolder.getRequestAttributes().getAttribute("roleCd", RequestAttributes.SCOPE_SESSION));
		emfMap.put("lastPwdModDtm", RequestContextHolder.getRequestAttributes().getAttribute("lastPwdModDtm", RequestAttributes.SCOPE_SESSION));
		emfMap.put("regDtm", RequestContextHolder.getRequestAttributes().getAttribute("regDtm", RequestAttributes.SCOPE_SESSION));
/*
		System.out.println("authCd"+RequestContextHolder.getRequestAttributes().getAttribute("authCd", RequestAttributes.SCOPE_SESSION));
		System.out.println("admSeq"+RequestContextHolder.getRequestAttributes().getAttribute("admSeq", RequestAttributes.SCOPE_SESSION));
		System.out.println("roleCd"+RequestContextHolder.getRequestAttributes().getAttribute("roleCd", RequestAttributes.SCOPE_SESSION));
		System.out.println("authCd"+emfMap.getString("authCd"));
		System.out.println("admSeq"+emfMap.getString("admSeq"));
		System.out.println("roleCd"+emfMap.getString("roleCd"));
		System.out.println("id"+emfMap.getString("id"));
		System.out.println("name"+emfMap.getString("name"));
		System.out.println("hp"+emfMap.getString("hp"));
		System.out.println("------------------>");
*/		
		//최초 REDIRECT URL 설정
		List<EmfMap> gnbMenuList = getMenuList(emfMap);
		
		String pageAdminLink = "";
		String firstUrl = "";
		
		EmfMap gnbEmfMap = null;

		for (int i = 0; i < gnbMenuList.size(); i++)
		{
			gnbEmfMap = (EmfMap) gnbMenuList.get(i);
			pageAdminLink = getUrlFolder(gnbEmfMap.getString("admLink"));
			
			if("".equals(firstUrl) && !"".equals(pageAdminLink))
			{
				firstUrl = gnbEmfMap.getString("admLink");
				
				emfMap.put("url", firstUrl);
			}
		}			
		emfMap.put("conSessionId", RequestContextHolder.getRequestAttributes().getSessionId());

		RequestContextHolder.getRequestAttributes().setAttribute("admLgnMap", emfMap, RequestAttributes.SCOPE_SESSION);
		RequestContextHolder.getRequestAttributes().setAttribute("gnbMenuList", gnbMenuList, RequestAttributes.SCOPE_SESSION);
		RequestContextHolder.getRequestAttributes().setAttribute("ip", EgovNetworkState.getMyIPaddress(request), RequestAttributes.SCOPE_SESSION);
		
		//로그인 시간을 업데이트 해준다.
		cOBLgnDAO.setLgnLstDtm(emfMap);
		if( EMFStringUtil.isNullToString(RequestContextHolder.getRequestAttributes().getAttribute("logSeq", RequestAttributes.SCOPE_SESSION)) != null 
			&& !EMFStringUtil.isNullToString(RequestContextHolder.getRequestAttributes().getAttribute("logSeq", RequestAttributes.SCOPE_SESSION)).equals("")){
			emfMap.put("logSeq", RequestContextHolder.getRequestAttributes().getAttribute("logSeq", RequestAttributes.SCOPE_SESSION));
			cOBLgnDAO.setAdmAuthLogOut(gnbEmfMap);
		}

		cOBLgnDAO.setAdmAuth(emfMap);
		cOBLgnDAO.setAdmAuthLog(emfMap);
		RequestContextHolder.getRequestAttributes().setAttribute("logSeq", cOBLgnDAO.getMaxLogId(emfMap).getString("logSeq"), RequestAttributes.SCOPE_SESSION);
		//로그인 로그를 등록한다.
		EmfMap sysLogMap = new EmfMap();
		System.out.println("start START ~~ ");
		sysLogMap.put("srvcNm", "COBLgnServiceImpl");
		sysLogMap.put("fncNm", "actionLogin");
		sysLogMap.put("trgtMenuNm", "로그인 페이지");
		sysLogMap.put("prcsCd", "L");
		sysLogMap.put("prcsTime", "100");
		sysLogMap.put("reqnId", emfMap.getString("id"));
		sysLogMap.put("reqnIp", emfMap.getString("loginIp"));
		
		try
		{
			cOFSysLogService.logInsertSysLog(sysLogMap);
		}
		catch(Exception e)
		{
			log.debug(e.getMessage());
		}
    	
    	return emfMap;
    }
    
    /**
	 * 일반 로그아웃을 처리한다.
	 * @param EmfMap
	 * @return EmfMap
	 * @exception Exception
	 */
    public void actionLogout(HttpServletRequest request) throws Exception
    {
    	EmfMap admLgnMap = (EmfMap)EgovUserDetailsHelper.getAuthenticatedUser();

    	EmfMap admIdMap = cOBLgnDAO.getMaxLogId(admLgnMap);

    	//로그아웃 로그를 등록한다.
    	if ("Y".equals(admLgnMap.getString("intra")))
    	{
    		EmfMap intraLogMap = new EmfMap();
    		
    		intraLogMap.put("logSeq", admIdMap.getString("logSeq"));
    		intraLogMap.put("cntrCd", "WEB");
			intraLogMap.put("lgnTypCd", "LOGOUT");
			intraLogMap.put("reqnId", admLgnMap.getString("id"));
			intraLogMap.put("reqnIp", admLgnMap.getString("loginIp"));
			
			try
			{
				if(admIdMap != null){
					cOBLgnDAO.setAdmAuthLogOut(intraLogMap);
				}
				cOBLgnOutDAO.logInsertIntraLog(intraLogMap);
			}
			catch(Exception e)
			{
				log.debug(e.getMessage());
			}
    	}
    	else
    	{
    		EmfMap sysLogMap = new EmfMap();
    		
    		sysLogMap.put("srvcNm", "EgovLoginController");
    		sysLogMap.put("fncNm", "actionLogin");
    		sysLogMap.put("trgtMenuNm", "로그인 페이지");
    		sysLogMap.put("prcsCd", "O");
    		sysLogMap.put("prcsTime", "100");
    		sysLogMap.put("reqnId", admLgnMap.getString("id"));
    		sysLogMap.put("reqnIp", admLgnMap.getString("loginIp"));
    		if(admIdMap != null){
    			sysLogMap.put("logSeq", admIdMap.getString("logSeq"));
    		}
    		
    		try
			{
				if(admIdMap != null){
					cOBLgnDAO.setAdmAuthLogOut(sysLogMap);
				}
				cOFSysLogService.logInsertSysLog(sysLogMap);
			}
			catch(Exception e)
			{
				log.debug(e.getMessage());
			}			
    	}
    	
    	RequestContextHolder.getRequestAttributes().setAttribute("admLgnMap", null, RequestAttributes.SCOPE_SESSION);
    	RequestContextHolder.getRequestAttributes().setAttribute("firstUrl", null, RequestAttributes.SCOPE_SESSION);	
    }
    
    /**
     * 비밀번호를 변경한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap setPwdChng(EmfMap paramMap) throws Exception
    {
    	EmfMap admLgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
    	
    	if (admLgnMap != null)
    	{
    		paramMap.put("id", admLgnMap.getString("id"));
    		
        	//단방향 암호화 처리
    		String enpassword = SeedCipher.oneencrypt(paramMap.getString("password"));
    		
        	paramMap.put("password", enpassword);
        	
        	EmfMap emfMap = null;
        	
        	if ("Y".equals(admLgnMap.getString("intra")))
        	{
        		emfMap = cOBLgnOutDAO.actionLogin(paramMap);
        	}
        	else
        	{
        		emfMap = cOBLgnDAO.actionLogin(paramMap);
        	}
        	
        	if (emfMap == null)
        	{
        		paramMap.put("msg", "기존 비밀번호를 다시 확인해 주세요.");
        		paramMap.put("url", "/mngwsercgateway/getPwdChng.do");
        		return paramMap;
        	}
        	
        	if (!paramMap.getString("newpassword").equals(paramMap.getString("newpasswordconfirm")))
    		{
        		paramMap.put("msg", "신규 비밀번호를 다시 확인해 주세요.");
        		paramMap.put("url", "/mngwsercgateway/getPwdChng.do");
        		return paramMap;
    		}
        	
        	String newEnpassword = SeedCipher.oneencrypt(paramMap.getString("newpassword"));
        	
        	paramMap.put("pwd", newEnpassword);
        	
        	if (enpassword.equals(newEnpassword))
        	{
        		paramMap.put("msg", "기본 비밀번호와 다르게 입력해 주세요.");
        		paramMap.put("url", "/mngwsercgateway/getPwdChng.do");
        		return paramMap;
        	}
        	
        	if ("Y".equals(admLgnMap.getString("intra")))
        	{
        		cOBLgnOutDAO.updatePassword(paramMap);
        	}
        	else
        	{
        		cOBLgnDAO.setPwdChng(paramMap);
        	}
        	
        	paramMap.put("msg", "비밀번호를 변경하였습니다.");
    	}
    	
    	paramMap.put("url", "/mngwsercgateway/getLogin.do");

    	return paramMap;
    }
    
    /**
     * 관리자 비밀번호를 변경을 연기한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap pwdChngLater(EmfMap paramMap) throws Exception
    {
    	EmfMap admLgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
    	
    	if (admLgnMap != null)
    	{
    		paramMap.put("id", admLgnMap.getString("id"));
    		
        	//단방향 암호화 처리
    		String enpassword = SeedCipher.oneencrypt(paramMap.getString("password"));
    		
        	paramMap.put("password", enpassword);

        	EmfMap emfMap = null;
        	
        	if ("Y".equals(admLgnMap.getString("intra")))
        	{
        		emfMap = cOBLgnOutDAO.actionLogin(paramMap);
        	}
        	else
        	{
        		emfMap = cOBLgnDAO.actionLogin(paramMap);
        	}
        	
        	if (emfMap == null)
        	{
        		paramMap.put("msg", "기존 비밀번호를 다시 확인해 주세요.");
        		paramMap.put("url", "/mngwsercgateway/getPwdChng.do");
        		return paramMap;
        	}

        	paramMap.put("pwd", enpassword);
        	if ("Y".equals(admLgnMap.getString("intra")))
        	{
        		cOBLgnOutDAO.updatePassword(paramMap);
        	}
        	else
        	{
        		cOBLgnDAO.setPwdChng(paramMap);
        	}
        	paramMap.put("msg", "설정이 변경되었습니다.\n"+"다시 로그인 해주세요.");
    	}
    	else
    	{
    		paramMap.put("msg", "로그인 정보가 존재하지 않습니다.");
    	}
    	
    	paramMap.put("url", "/mngwsercgateway/getLogin.do");

    	return paramMap;
    }

    /**
	 * 메뉴 리스트를 가져온다.
	 * @param EmfMap
	 * @return EmfMap
	 * @exception Exception
	 */
    public List<EmfMap> getMenuList(EmfMap emfMap) throws Exception
    {
    	return cOBLgnDAO.getMenuList(emfMap);
    }
    
    /**
	 * 상위 부모의 메뉴를 가져온다.
	 * @param EmfMap
	 * @return EmfMap
	 * @exception Exception
	 */
    public List<EmfMap> getParentMenuList(int pageNo) throws Exception
    {
    	return cOBLgnDAO.getParentMenuList(pageNo);
    }
    
    /**
   	 * 메뉴의 링크를 파싱한다.
   	 * @param String
   	 * @return String
   	 * @exception Exception
   	 */
 	private String getUrlFolder(String str)
 	{		
 		String rtn = "";
 		String val = "";
 		
 		if (str.indexOf(".do") > -1)
 		{
 			String[] arrFolder = str.split("/");
 		
 			for (int i = 0; i < arrFolder.length - 1; i++)
 			{
 				val = arrFolder[i];
 				
 				if (!"".equals(val))
 				{
 					rtn = rtn  + "/" + arrFolder[i];
 				}
 			}
 		}
 		else
 		{
 			rtn = str;
 		}
 		
 		return rtn;
 	}

	public EmfMap getMaxLogId(EmfMap emfMap) throws Exception {
		return cOBLgnDAO.getMaxLogId(emfMap);
	}
	 
    /**
     * 관리자 인증을 처리한다.
     * 
     * @param EmfMap
     * @return 
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public int updateInfo(EmfMap infoMap) throws Exception 
    {
    	return cOBLgnDAO.updateInfo(infoMap);
    }
    
}
