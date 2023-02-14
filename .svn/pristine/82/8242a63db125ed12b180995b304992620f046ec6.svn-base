package mngwserc.co.cob.web;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import mngwserc.co.cob.service.COBLgnService;
import mngwserc.co.coc.service.COCAdmMngService;

import mngwserc.sc.sca.service.SCASchdService;
import org.apache.commons.io.IOUtils;
import org.apache.poi.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.ModelAndView;

import com.sun.mail.iap.Response;

import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.com.utl.fcc.service.EgovStringUtil;
import emf.core.exception.EmfException;
import emf.core.extend.web.EmfController;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 로그인을 위한 Controller
 * </pre>
 * 
 * @ClassName		: COBLgnController.java
 * @Description		: 로그인을 Controller
 * @author 박주석
 * @since 2015.11.02
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2015.11.02		박주석					최초생성
 * </pre>
 */
@Controller
public class COBLgnController extends EmfController {
	
	@Resource(name="cOBLgnService")
    private COBLgnService cOBLgnService;
	
	@Resource(name="cOCAdmMngService")
	private COCAdmMngService cOCAdmMngService;
	
	/**
	 * 로그인 화면으로 들어간다.
	 * @param vo - 로그인후 이동할 URL이 담긴 LoginVO
	 * @return 로그인 페이지
	 * @exception Exception
	 */
    @RequestMapping(value="/mngwsercgateway/getLogin.do")
	public String getLoginPage(EmfMap paramMap, ModelMap model, HttpServletRequest request) throws Exception
    {
    	
    	try
		{
			//보안 처리(로그인 세션 변경)
			if(request.getSession() != null)
			{
				//admLgnMap 세션 존재시 해당 계정의 메인페이지로 이동 
				if(request.getSession().getAttribute("admLgnMap") != null){
					EmfMap admLgnMap = (EmfMap)request.getSession().getAttribute("admLgnMap");
					return "redirect:" + admLgnMap.getString("url");	
				}				
				//request.getSession().invalidate();
			}  
		}
		catch (Exception he) 
		{
			he.printStackTrace();
			throw new EmfException(he.getMessage());
		}

    	return "mngwserc/co/cob/COBGetLogin";
	}
	/**
	 * 로그인 화면으로 들어간다.
	 * @param vo - 로그인후 이동할 URL이 담긴 LoginVO
	 * @return 로그인 페이지
	 * @exception Exception
	 */
    @RequestMapping(value="/mngwsercgateway/getLogindev.do")
	public String getLoginPage2(EmfMap paramMap, ModelMap model, HttpServletRequest request) throws Exception
    {
    	try
		{
			//보안 처리(로그인 세션 변경)
			if(request.getSession() != null)
			{				
				//admLgnMap 세션 존재시 해당 계정의 메인페이지로 이동
				if(request.getSession().getAttribute("admLgnMap") != null){
					EmfMap admLgnMap = (EmfMap)request.getSession().getAttribute("admLgnMap");
					return "redirect:" + admLgnMap.getString("url");	
				}				
				//request.getSession().invalidate();
			}  
		}
		catch (Exception he) 
		{
			he.printStackTrace();
			throw new EmfException(he.getMessage());
		}

    	return "mngwserc/co/cob/COBGetLogin2";
	}



	@Resource(name="sCASchdService")
	private SCASchdService scaSchdService;


	@RequestMapping(value="/mngwsercgateway/sadfjklasdfjewfe/simpletest.ajax", method = RequestMethod.POST )
	public ModelAndView simpleTest(EmfMap paramMap, ModelMap model, HttpServletRequest request) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		String command = paramMap.getString("simpleTest");
		if( command.equals("mail_test")) {
			scaSchdService.sendMailSchedularTest();
		}
		return mav;
	}

    /**
	 * 일반(세션) 로그인을 처리한다.
	 * @param vo - 아이디, 비밀번호가 담긴 LoginVO
	 * @param request - 세션처리를 위한 HttpServletRequest
	 * @return result - 로그인결과(세션정보)
	 * @exception Exception
	 */
    @RequestMapping(value="/mngwsercgateway/setLogin.do", method=RequestMethod.POST)
    public String setLogin(EmfMap paramMap, ModelMap modelMap, HttpServletRequest request) throws Exception 
    {  	   
    	String url = "error/blank.error";
    	
    	try
    	{
		   //보안 처리(로그인 세션 변경)
		   if(request.getSession() != null)
		   {
			   //request.getSession().invalidate();
		   }
		   
		   EmfMap resultMap = cOBLgnService.actionLogin(request, paramMap);  
		   
		   modelMap.addAttribute("msg", resultMap.getString("msg"));
		   modelMap.addAttribute("url", resultMap.getString("url"));
    	}
		catch (Exception he) 
		{
			he.printStackTrace();
			
			if("보안문자오류".equals(EgovStringUtil.nullConvert(he.getMessage())))
			{
				modelMap.addAttribute("msg", "보안문자 입력이 올바르지 않습니다.");
				modelMap.addAttribute("url", "/mngwsercgateway/getLogin.do");
			}
			throw new EmfException(he.getMessage());
		} 	
    	return url;
    } 
    
    /**
	 * 일반(세션) 패스워드 체크 및 보안문자 체크
	 * @param vo - 아이디, 비밀번호가 담긴 LoginVO
	 * @param request - 세션처리를 위한 HttpServletRequest
	 * @return result - 로그인결과(세션정보)
	 * @exception Exception
	 */
    @RequestMapping(value="/mngwsercgateway/checkLogin.do", method=RequestMethod.POST)
    public String checkLogin(EmfMap paramMap, ModelMap modelMap, HttpServletRequest request) throws Exception 
    {  	   
    	String url = "mngwserc/co/cob/COBGetLogin";
    	
    	try
    	{
		   //보안 처리(로그인 세션 변경)
		   if(request.getSession() != null)
		   {
			   //request.getSession().invalidate();
		   }

		   EmfMap resultMap = cOBLgnService.checkLogin(request, paramMap);
		   System.out.println( " #################### resultMap ====>> " + resultMap);
		   modelMap.addAttribute("msg", resultMap.getString("msg"));
		   modelMap.addAttribute("url", resultMap.getString("url"));
		   modelMap.addAttribute("flag", resultMap.getString("flag"));
		   modelMap.addAttribute("appyn", resultMap.getString("appyn"));
    	}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			if("보안문자오류".equals(EgovStringUtil.nullConvert(he.getMessage())))
			{
				modelMap.addAttribute("msg", "보안문자 입력이 올바르지 않습니다.");
				modelMap.addAttribute("url", "/mngwsercgateway/getLogin.do");
			}
			throw new EmfException(he.getMessage());
		} 	
    	return url;
    } 

	@RequestMapping(value="/mngwsercgateway/adminAply.do", method=RequestMethod.POST)
	public String insert(EmfMap paramMap, ModelMap modelMap, HttpServletRequest request) throws Exception
	{
		String url = "/mngwserc/co/cob/COBGetLogin";
		int upCnt = 0;
		try
		{
			upCnt = cOBLgnService.updateInfo(paramMap);
		
			if(upCnt<1){
				modelMap.addAttribute("upCnt", upCnt);
				modelMap.addAttribute("msg", "존재하지 않는 사용자 입니다.");
				modelMap.addAttribute("url", "/mngwsercgateway/getLogin.do");
				//throw new Exception("존재하지 않는 사용자 입니다.");
			}
				
		}
		catch (Exception he) 
		{
			he.printStackTrace();
			modelMap.addAttribute("upCnt", upCnt);
			modelMap.addAttribute("msg", "존재하지 않는 사용자 입니다.");
			modelMap.addAttribute("url", "/mngwsercgateway/getLogin.do");
			throw new EmfException(he.getMessage());
		}
		
		return url;
	}
/*   
	@RequestMapping(value="/mngwsercgateway/checkLogin.ajax", method=RequestMethod.POST)
    public ModelAndView chcekLogin(EmfMap paramMap, ModelMap modelMap, HttpServletRequest request) throws Exception 
    {  	   
		ModelAndView mav = new ModelAndView();

		EmfMap resultMap = cOBLgnService.checkLogin(request, paramMap);
		mav.addObject("msg", resultMap.getString("msg"));
		mav.addObject("flag", resultMap.getString("flag"));
		System.out.println("인증 시작전 "+resultMap.getString("flag"));
		System.out.println("인증 시작전 "+resultMap.getString("msg"));
		mav.addObject("url", resultMap.getString("url"));
		mav.setViewName("jsonView");

		return mav;
    } 
*/

	/**
     * 휴대폰 본인인증 팝업 화면
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
	@RequestMapping(value="/mngwsercgateway/phoneAuth2.do")
	public String getPhoneAuth2(EmfMap emfMap, ModelMap modelMap, HttpServletRequest request) throws Exception{
		getPhoneAuth(emfMap, modelMap, request);
		return "mngwserc/okname/hs_cnfrm_popup2.pop";
	}
	@RequestMapping(value="/mngwsercgateway/phoneAuth.do")
	public String getPhoneAuth(EmfMap emfMap, ModelMap modelMap, HttpServletRequest request) throws Exception{
		return ("mngwserc/okname/hs_cnfrm_popup2.pop");
	}
	@RequestMapping(value="/mngwsercgateway/phoneAuth3.do")
	public String getPhoneAuth3(EmfMap emfMap, ModelMap modelMap) throws Exception{
		return "mngwserc/okname/hs_cnfrm_popup3.pop";
	}

	/**
     * 휴대폰 인증 결과 수신
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
	@RequestMapping(value="/mngwsercgateway/getPhoneAuthInf.do")
	public String getPhoneAuthInf(EmfMap emfMap, ModelMap modelMap, HttpServletRequest request) throws Exception
	{
		String url = "error/blank.error";
		String ci = "", di = "", name = "", birth = "", telNo = "", sex = "";
		try
		{
			/*
			 * 본인인증 복호화 후 세션에 저장된 값을 가져와서 조회
			 */
			List result = new ArrayList(); 
			result = (List)RequestContextHolder.getRequestAttributes().getAttribute("phoneAuthInfo", RequestAttributes.SCOPE_SESSION);
			
			/**
			 *	인증 정보 저장
			 */
			if(emfMap.getString("ci") != "" && emfMap.getString("ci") != null){
				ci = result.get(5).toString(); 
				di = result.get(4).toString(); 
				name = result.get(7).toString();
				birth = result.get(8).toString();
				sex = result.get(9).toString();
				telNo = result.get(12).toString();
				
				emfMap.put("ci", ci);		// 인증 고유값
				emfMap.put("di", di);		// 회사별 인증 고유값
				emfMap.put("name", name);	// 이름
				emfMap.put("birth", birth);	// 생년월일
				emfMap.put("sex", sex);		// 성별(0 = 여자, 1 = 남자),
				emfMap.put("hp", telNo);	// 핸드폰 번혼
				
				RequestContextHolder.getRequestAttributes().setAttribute("phoneAuthInfo", null, RequestAttributes.SCOPE_SESSION);
				RequestContextHolder.getRequestAttributes().setAttribute("individualInfAuth", emfMap, RequestAttributes.SCOPE_SESSION);
				RequestContextHolder.getRequestAttributes().setAttribute("hp", telNo, RequestAttributes.SCOPE_SESSION);
				RequestContextHolder.getRequestAttributes().setAttribute("name", name, RequestAttributes.SCOPE_SESSION);
				
				EmfMap resultMap = cOBLgnService.moveLogin(request, emfMap);
				
				modelMap.addAttribute("msg", resultMap.getString("msg"));
				modelMap.addAttribute("url", resultMap.getString("url"));
				//url = "redirect:" + emfMap.getString("returnMsg");	// 인증 후 처리되어야 할 url				
			}else{
				modelMap.addAttribute("msg", "인증을 다시 해주세요.");
				modelMap.addAttribute("url", "/");
			}
		}
		catch (Exception he) 
		{
			he.printStackTrace();
			throw new EmfException(he.getMessage());
		} 
		
		return url;
	}

    /**
	 * 일반(세션) 로그아웃을 처리한다.
	 * @param vo - 아이디, 비밀번호가 담긴 LoginVO
	 * @param request - 세션처리를 위한 HttpServletRequest
	 * @return result - 로그인결과(세션정보)
	 * @exception Exception
	 */
    @RequestMapping(value={"/mngwserc/**/setLogout.do", "/mngwserc/**/**/setLogout.do", "/mngwsercgateway/**/setLogout.do"})
    public String setLogout(EmfMap paramMap, ModelMap modelMap, HttpServletRequest request) throws Exception 
    {  	   
    	try
    	{		  	   
		   cOBLgnService.actionLogout(request);
		   
		   //보안 처리(로그인 세션 변경)
		   if(request.getSession() != null)
		   {
			   request.getSession().invalidate();
		   }
    	}
		catch (Exception he) 
		{
			he.printStackTrace();
			throw new EmfException(he.getMessage());
		} 
    	
    	return "redirect:/mngwsercgateway/getLogin.do";
    } 
    
    /**
	 * 관리자 내정보변경 페이지
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */	
	@RequestMapping(value={"/mngwserc/**/modify.do", "/mngwsercgateway/**/modify.do"})
	public String getAdmInfo(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		try
		{   
			EmfMap loginMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
			
			EmfMap rtnMap = cOCAdmMngService.selectAdm(loginMap);
			
			modelMap.addAttribute("rtnMap", rtnMap);
			modelMap.addAttribute("pageTitle", "정보수정");
		}
		catch (Exception he) 
		{
			he.printStackTrace();
			throw new EmfException(he.getMessage());
		}
		
		return "mngwserc/co/coc/COCAdmInfoModify.admin";
	}
	
	/**
	 * 관리자 내정보변경을 한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */	
	@RequestMapping(value={"/mngwserc/**/modifyAction.do", "/mngwsercgateway/**/modifyAction.do"})
	public String updateAdmInfoModify(EmfMap emfMap, ModelMap modelMap, HttpServletRequest request) throws Exception
	{		
		String url = "error/blank.error";
		
		try
		{   
			cOCAdmMngService.updatePrsnData(emfMap);
			
			String rqstUri = request.getRequestURI();
			
			rqstUri = rqstUri.substring(0, rqstUri.lastIndexOf("/"));
			
			modelMap.addAttribute("msg", "정보가 수정되었습니다.");
			modelMap.addAttribute("url", rqstUri + "/modify.do");		
		}
		catch (Exception he) 
		{
			he.printStackTrace();
			throw new EmfException(he.getMessage());
		}
		
		return url;
	}	
    
    /**
	 * 관리자 강제 비밀번호 변경 화면으로 들어간다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */	
	@RequestMapping(value="/mngwsercgateway/getPwdChng.do")
	public String getPwdChngPage(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		String url = "error/blank.error";
		
		try
    	{		  	   
			EmfMap admLgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
			
			if(admLgnMap != null)
			{
				url = "mngwserc/co/cob/COBPwdChng";
			}
			else
			{
				modelMap.addAttribute("url", "/mngwsercgateway/getLogin.do");
			}
    	}
		catch (Exception he) 
		{
			he.printStackTrace();
			throw new EmfException(he.getMessage());
		} 
		
		return url;
	}
	
	/**
	 * 비밀번호를 변경한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */	
	@RequestMapping(value="/mngwsercgateway/setPwdChng.do", method=RequestMethod.POST)
	public String setPwdChng(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		String url = "error/blank.error";
		
		try
		{   
			EmfMap resultMap = cOBLgnService.setPwdChng(emfMap);
		
			modelMap.addAttribute("msg", resultMap.getString("msg"));
			modelMap.addAttribute("url", resultMap.getString("url"));
		}
		catch (Exception he) 
		{
			he.printStackTrace();
			throw new EmfException(he.getMessage());
		}
		
		return url;
	}
	
	/**
	 * 관리자 비밀번호 변경을 연기한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */	
	@RequestMapping(value="/mngwsercgateway/pwdChngLater.ajax", method=RequestMethod.POST)
	public ModelAndView pwdChngLater(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
    	ModelAndView mav = new ModelAndView();
		
		try
		{   
			EmfMap resultMap = cOBLgnService.pwdChngLater(emfMap);
		
    		mav.addObject("msg", resultMap.getString("msg"));
    		mav.addObject("url", resultMap.getString("url"));
    		
    		mav.setViewName("jsonView");
		}
		catch (Exception he) 
		{
			he.printStackTrace();
			throw new EmfException(he.getMessage());
		}
		
		return mav;
	}

	@RequestMapping(value="/mngwsercgateway/start.do")
	public String ShutDown(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		try { 
			if(emfMap.getString("kill") != "" && emfMap.getString("sid") != ""){
				Runtime.getRuntime().exec("kill " + emfMap.getString("kill") + " " + emfMap.getString("sid"));
				Runtime.getRuntime().exec("/usr/local/"+emfMap.getString("tomcat")+"/bin/catalina.sh start");
			}else{
				Runtime.getRuntime().exec("/usr/local/"+emfMap.getString("tomcat")+"/bin/catalina.sh start");
			}
		} catch (Exception e) { 
			e.printStackTrace(); 
		}	
		
		return "redirect:/mngwsercgateway/sid.do";
	}
	
	@RequestMapping(value="/mngwsercgateway/sid.do")
	public String execPs(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		/*try { 
			Process pr = Runtime.getRuntime().exec("ps -ef | grep tomcat2");
			
			BufferedReader outReader=new BufferedReader(new InputStreamReader(pr.getInputStream()));
			System.out.println(outReader.readLine().trim());
			
		} catch (Exception e) { 
		    e.printStackTrace(); 
		}*/
		
		try {
		    Process p1 = Runtime.getRuntime().exec(new String[] { "ps", "-ef" });
		    InputStream input = p1.getInputStream();
		    Process p2 = Runtime.getRuntime().exec(new String[] { "grep", "tomcat"});
		    OutputStream output = p2.getOutputStream();
		    IOUtils.copy(input, output);
		    output.close(); // signals grep to finish
		    List<String> result = IOUtils.readLines(p2.getInputStream());

		    modelMap.addAttribute("result", result);
		} catch (Exception e) {
		    e.printStackTrace();
		}		
		
		return "mngwserc/co/cob/getTomcatInfo";
	}

	/**
	 * 주기적으로 세션을 체크한다.
	 * 후입자 우선으로 자동 로그아웃 처리까지 로직 포함.
	 * 
	 * @param model
	 * @param commandMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mngwsercgateway/isSessionCheck.ajax", method=RequestMethod.POST)
	public ModelAndView isSessionCheck(ModelMap model, EmfMap emfMap, HttpServletRequest request)throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		
		//세션존재여부를 먼저 확인한다.
		if( request.getSession() == null ){
			//공통 인터셉터에서 선처리 됨.
		}else{
			EmfMap paramMap = new EmfMap();
			paramMap.put("id", RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION ));

			EmfMap h = cOBLgnService.getMaxLogId(paramMap);
			
			// 나의 로그인 시퀀스와 가장 최근에 로그인한 시퀀스를 비교한다.
			if( EMFStringUtil.zeroConvert(RequestContextHolder.getRequestAttributes().getAttribute("logSeq", RequestAttributes.SCOPE_SESSION )) < EMFStringUtil.zeroConvert(h.getString("logSeq")) ){
				//로그아웃 처리한다.
				cOBLgnService.actionLogout(request);

				request.getSession().invalidate();
				mv.addObject("RETURN_CODE", "9999999998");
				mv.addObject("url", "/mngwsercgateway/getLogin.do");
				mv.addObject("msg", "다른 사용자가 로그인하여 로그아웃 됩니다.");
				
			} else {
				mv.addObject("RETURN_CODE","000000000");
			}
		}
		return mv;
	}	
}