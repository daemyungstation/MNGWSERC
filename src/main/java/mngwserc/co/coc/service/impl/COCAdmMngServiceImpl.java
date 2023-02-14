package mngwserc.co.coc.service.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.annotation.Resource;

import mngwserc.co.cob.service.dao.COBLgnOutDAO;
import mngwserc.co.coc.service.COCAdmMngService;
import mngwserc.co.coc.service.dao.COCAdmMngDAO;
import mngwserc.co.util.COPaginationUtil;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

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
 * 관리자 관리를 위한 ServiceImpl
 * </pre>
 * 
 * @ClassName		: COCAdmMngServiceImpl.java
 * @Description		: 관리자 관리를 위한 ServiceImpl
 * @author 허진영
 * @since 2015.11.13
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2015.11.13		허진영					최초생성
 * </pre>
 */ 
@Service("cOCAdmMngService")
public class COCAdmMngServiceImpl extends EmfAbstractService implements COCAdmMngService {
	
	@Resource(name="cOCAdmMngDAO")
    private COCAdmMngDAO cOCAdmMngDAO;
	
    @Resource(name="cOBLgnOutDAO")
    private COBLgnOutDAO cOBLgnOutDAO;

    @Resource(name="admIdgen")
	private EgovTableIdGnrService admIdgen;
    
    @Resource(name="EgovCmmUseService")
    private EgovCmmUseService cmmUseService;
	
	private String ENCODE = EgovProperties.getProperty("Global.CHARCODE");
	
	private String roleGb = EgovProperties.getProperty("Globals.roleGb");
	
	/**
	 * 관리자 목록을 조회한다.
	 * 
	 * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
    public EmfMap selectAdmList(EmfMap emfMap) throws Exception
    {
		PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
		
		//페이징 처리
		emfMap.put("paginationInfo", paginationInfo);    	
		
		//리스트 가져오기
		List<EmfMap> list = cOCAdmMngDAO.selectAdmList(emfMap);
		
		emfMap.put("list", list);

		EmfMap logMap = new EmfMap();
		logMap.put("check", RequestContextHolder.getRequestAttributes().getAttribute("check", RequestAttributes.SCOPE_SESSION));
		if(  !"N".equals(logMap.getString("check") ) ) {
			cmmUseService.actionViewAuthLogV2("관리자 관리 - 관리자 조회", "", "S", logMap);
		}
		
		if(list.size() > 0)
		{
			paginationInfo.setTotalRecordCount(Integer.parseInt(list.get(0).getString("totCnt")));
		}
		else
		{
			paginationInfo.setTotalRecordCount(0);
		}

		
		return emfMap;
    }
    
    /**
	 * 관리자 상세를 조회한다.
	 * 
	 * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
    public EmfMap selectAdm(EmfMap emfMap) throws Exception
    {
    	if(!"".equals(EMFStringUtil.nullConvert(emfMap.get("admSeq"))))
    	{
    		//2018.01.03 관리자 정보 수정 시 로그 한번만 생성
    		if(EMFStringUtil.zeroConvert(RequestContextHolder.getRequestAttributes().getAttribute("checkCnt", RequestAttributes.SCOPE_SESSION)) == 0){
    			RequestContextHolder.getRequestAttributes().setAttribute("checkCnt", 1, RequestAttributes.SCOPE_SESSION);
    		}
			EmfMap admInfo = cOCAdmMngDAO.selectAdm(emfMap);
	
	    	if(admInfo != null)
	    	{
	    		//전화번호
	    		String tel = admInfo.getString("tel");
	    		//2017.04.24 박주석 디아모 솔루션 도입 작업
//	    		if(!"".equals(tel))
//	    		{
//	    			admInfo.put("tel", SeedCipher.decrypt(tel, ENCODE));
//	    		}
	    		
	    		//이메일
	    		String email = admInfo.getString("email");
	    		//2017.04.24 박주석 디아모 솔루션 도입 작업
//	    		if(!"".equals(email))
//	    		{
//	    			admInfo.put("email", SeedCipher.decrypt(email, ENCODE));
//	    		}
	    		
				emfMap.put("admInfo", admInfo);

				/*
				 홈페이지 개인정보 로그 - 보안관련 로직 신규 구현
				 2017.12.26
				 */
				if(EMFStringUtil.zeroConvert(RequestContextHolder.getRequestAttributes().getAttribute("checkCnt", RequestAttributes.SCOPE_SESSION)) == 1){
					EmfMap logMap = new EmfMap();
					logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
					logMap.put("gubun", "관리자 관리 - 관리자 상세조회");
					logMap.put("flag", "D");
					logMap.put("name", RequestContextHolder.getRequestAttributes().getAttribute("name", RequestAttributes.SCOPE_SESSION));
					logMap.put("hp", RequestContextHolder.getRequestAttributes().getAttribute("hp", RequestAttributes.SCOPE_SESSION));
					logMap.put("id", RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION));
					if(logMap.getString("id") != null && !logMap.getString("id").equals("")){
						cmmUseService.actionViewAuthLog(logMap);
					}
					
					RequestContextHolder.getRequestAttributes().setAttribute("checkCnt", 2, RequestAttributes.SCOPE_SESSION);
				}
	    	}
    	} else {
			/*
			 홈페이지 개인정보 로그 - 보안관련 로직 신규 구현
			 2017.12.26
			 */
			EmfMap logMap = new EmfMap();
			logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
			logMap.put("gubun", "관리자 관리 - 관리자 등록 페이지");
			logMap.put("flag", "S");
			logMap.put("name", RequestContextHolder.getRequestAttributes().getAttribute("name", RequestAttributes.SCOPE_SESSION));
			logMap.put("hp", RequestContextHolder.getRequestAttributes().getAttribute("hp", RequestAttributes.SCOPE_SESSION));
			logMap.put("id", RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION));
			if(logMap.getString("id") != null && !logMap.getString("id").equals("")){
				cmmUseService.actionViewAuthLog(logMap);
			}
    	}
    	
    	emfMap.put("admUserTypeList", cOCAdmMngDAO.selectAdmUserTypeList(emfMap));
    	
    	emfMap.put("roleGb", roleGb);
    	
    	
    	return emfMap;
    }
    
    /**
     * 아이디 중복체크를 위해 ID 갯수를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public int getIdCnt(EmfMap emfMap) throws Exception
	{
		return cOCAdmMngDAO.getIdCnt(emfMap);
	}
	
	/**
     * 이메일 중복체크를 위해 Email 갯수를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public int getEmailCnt(EmfMap emfMap) throws Exception
	{
		String email = emfMap.getString("email");
		//2017.04.24 박주석 디아모 솔루션 도입 작업
//    	if(!"".equals(email))
//		{
//    		emfMap.put("email", (SeedCipher.encrypt(email, ENCODE)));
//		}
    	
		return cOCAdmMngDAO.getEmailCnt(emfMap);
	}
       
	/**
     * 관리자를 등록한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertAdm(EmfMap emfMap) throws Exception 
	{
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		log.debug("=============================================================================================");
		log.debug(lgnMap);
		log.debug("=============================================================================================");
		emfMap.put("admSeq", admIdgen.getNextIntegerId());
		
		//패스워드
		String password = emfMap.getString("pwd");
		
		if(!"".equals(password) && password.length() >= 4)
		{
			emfMap.put("pwd", SeedCipher.oneencrypt(password));
		}
		
		//전화번호
		String tel = emfMap.getString("tel");
		//2017.04.24 박주석 디아모 솔루션 도입 작업
//		if(!"".equals(tel))
//		{
//    		emfMap.put("tel", SeedCipher.encrypt(tel, ENCODE));
//		}
		
		//이메일
		String email = emfMap.getString("email");
		//2017.04.24 박주석 디아모 솔루션 도입 작업
//		if(!"".equals(email))
//		{
//			emfMap.put("email", SeedCipher.encrypt(email, ENCODE));
//		}
		
		//권한구분
		if("AUTH".equals(roleGb))
		{
			emfMap.put("roleCd", emfMap.getString("authCd"));
		}
		
		emfMap.put("regId", lgnMap.getString("id"));
		emfMap.put("regIp", lgnMap.getString("loginIp"));
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		//관리자 등록
		cOCAdmMngDAO.insertAdm(emfMap);
		
		//관리자 메뉴정보를 Setting한다.
		setAdmMenu(emfMap);
		
		/*
		 홈페이지 개인정보 로그 - 보안관련 로직 신규 구현
		 2017.12.26
		 */
		EmfMap logMap = new EmfMap();
		logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
		logMap.put("gubun", "관리자 관리 - 관리자 등록");
		logMap.put("flag", "C");
		logMap.put("name", RequestContextHolder.getRequestAttributes().getAttribute("name", RequestAttributes.SCOPE_SESSION));
		logMap.put("hp", RequestContextHolder.getRequestAttributes().getAttribute("hp", RequestAttributes.SCOPE_SESSION));
		logMap.put("id", RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION));
		if(logMap.getString("id") != null && !logMap.getString("id").equals("")){
			cmmUseService.actionViewAuthLog(logMap);
		}
    }
	
	/**
     * 관리자를 수정한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateAdm(EmfMap emfMap) throws Exception
	{
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		//비밀번호
		String password = emfMap.getString("pwd");
		
		if(!"".equals(password) && password.length() >= 4)
		{
			emfMap.put("pwd", SeedCipher.oneencrypt(password));
		}
		
		//전화번호
		String telephone = emfMap.getString("tel");
		//2017.04.24 박주석 디아모 솔루션 도입 작업
//		if(!"".equals(telephone))
//		{
//    		emfMap.put("tel", SeedCipher.encrypt(telephone, ENCODE));
//		}
		
		//이메일
		String email = emfMap.getString("email");
		//2017.04.24 박주석 디아모 솔루션 도입 작업
//		if(!"".equals(email))
//		{
//			emfMap.put("email", SeedCipher.encrypt(email, ENCODE));
//		}
		
		//권한구분
		if("AUTH".equals(roleGb))
		{
			emfMap.put("roleCd", emfMap.getString("authCd"));
		}
		
		emfMap.put("regId", lgnMap.getString("id"));
		emfMap.put("regIp", lgnMap.getString("loginIp"));
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
    	
		//관리자 수정
    	cOCAdmMngDAO.updateAdm(emfMap);

    	/*
		 홈페이지 개인정보 로그 - 보안관련 로직 신규 구현
		 2017.12.26
    	 */
    	EmfMap logMap = new EmfMap();
    	logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
    	logMap.put("gubun", "관리자 관리 - 관리자 수정");
    	logMap.put("flag", "M");
    	logMap.put("name", RequestContextHolder.getRequestAttributes().getAttribute("name", RequestAttributes.SCOPE_SESSION));
    	logMap.put("hp", RequestContextHolder.getRequestAttributes().getAttribute("hp", RequestAttributes.SCOPE_SESSION));
    	logMap.put("id", RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION));
		if(logMap.getString("id") != null && !logMap.getString("id").equals("")){
			cmmUseService.actionViewAuthLog(logMap);
		}
    	
    	//관리자 메뉴정보를 Setting한다.
    	setAdmMenu(emfMap);
    	
	}
	
	/**
     * 관리자를 수정한다. (내정보 변경)
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updatePrsnData(EmfMap emfMap) throws Exception
	{
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		if("Y".equals(lgnMap.getString("intra")))
		{
			emfMap.put("id", lgnMap.getString("id"));
			
			//패스워드
			String password = emfMap.getString("pwd");
			
			if(!"".equals(password) && password.length() >= 4)
			{
				emfMap.put("pwd", SeedCipher.oneencrypt(password));
			}
			
			cOBLgnOutDAO.updatePassword(emfMap);	

			/*
			 홈페이지 개인정보 로그 - 보안관련 로직 신규 구현
			 2017.12.26
	    	 */
	    	EmfMap logMap = new EmfMap();
	    	logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
	    	logMap.put("gubun", "관리자 관리 - 관리자 비밀번호 수정");
	    	logMap.put("flag", "M");
	    	logMap.put("name", RequestContextHolder.getRequestAttributes().getAttribute("name", RequestAttributes.SCOPE_SESSION));
	    	logMap.put("hp", RequestContextHolder.getRequestAttributes().getAttribute("hp", RequestAttributes.SCOPE_SESSION));
	    	logMap.put("id", RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION));
			if(logMap.getString("id") != null && !logMap.getString("id").equals("")){
				cmmUseService.actionViewAuthLog(logMap);
			}
		}
		else
		{
			emfMap.put("admSeq", lgnMap.getString("admSeq"));
			
			//패스워드
			String password = emfMap.getString("pwd");
			
			if(!"".equals(password) && password.length() >= 4)
			{
				emfMap.put("pwd", SeedCipher.oneencrypt(password));
			}
			
			//전화번호
			String tel = emfMap.getString("tel");
			//2017.04.24 박주석 디아모 솔루션 도입 작업
//			if(!"".equals(tel))
//			{
//	    		emfMap.put("tel", SeedCipher.encrypt(tel, ENCODE));
//			}
			
			//이메일
			String email = emfMap.getString("email");
			//2017.04.24 박주석 디아모 솔루션 도입 작업
//			if(!"".equals(email))
//			{
//				emfMap.put("email", SeedCipher.encrypt(email, ENCODE));
//			}
			
			//권한구분
			if("AUTH".equals(roleGb))
			{
				emfMap.put("roleCd", emfMap.getString("authCd"));
			}
			
			emfMap.put("regId", lgnMap.getString("id"));
			emfMap.put("regIp", lgnMap.getString("loginIp"));
			emfMap.put("modId", lgnMap.getString("id"));
			emfMap.put("modIp", lgnMap.getString("loginIp"));
	    	
			//관리자 수정
	    	cOCAdmMngDAO.updateAdm(emfMap);

			/*
			 홈페이지 개인정보 로그 - 보안관련 로직 신규 구현
			 2017.12.26
	    	 */
	    	EmfMap logMap = new EmfMap();
	    	logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
	    	logMap.put("gubun", "관리자 관리 - 관리자 정보 수정");
	    	logMap.put("flag", "M");
	    	logMap.put("name", RequestContextHolder.getRequestAttributes().getAttribute("name", RequestAttributes.SCOPE_SESSION));
	    	logMap.put("hp", RequestContextHolder.getRequestAttributes().getAttribute("hp", RequestAttributes.SCOPE_SESSION));
	    	logMap.put("id", RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION));
			if(logMap.getString("id") != null && !logMap.getString("id").equals("")){
				cmmUseService.actionViewAuthLog(logMap);
			}
		}
	}
	
	/**
     * 관리자를 삭제한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteAdm(EmfMap emfMap) throws Exception
	{
		//관리자 삭제
		cOCAdmMngDAO.deleteAdm(emfMap);
		
		//관리자 메뉴를 삭제한다.
    	cOCAdmMngDAO.deleteAdmMenu(emfMap);

		/*
		 홈페이지 개인정보 로그 - 보안관련 로직 신규 구현
		 2017.12.26
    	 */
    	EmfMap logMap = new EmfMap();
    	logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
    	logMap.put("gubun", "관리자 관리 - 관리자 정보 삭제");
    	logMap.put("flag", "R");
    	logMap.put("name", RequestContextHolder.getRequestAttributes().getAttribute("name", RequestAttributes.SCOPE_SESSION));
    	logMap.put("hp", RequestContextHolder.getRequestAttributes().getAttribute("hp", RequestAttributes.SCOPE_SESSION));
    	logMap.put("id", RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION));
		if(logMap.getString("id") != null && !logMap.getString("id").equals("")){
			cmmUseService.actionViewAuthLog(logMap);
		}
	}
	 
	/**
     * 관리자 권한 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public List<EmfMap> getMenuList(EmfMap emfMap) throws Exception
    {
    	return cOCAdmMngDAO.getMenuList(emfMap);
    }
    
    /**
     * 관리자 메뉴정보를 Setting한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public void setAdmMenu(EmfMap emfMap) throws Exception
    {
    	//관리자 메뉴를 삭제한다.
    	cOCAdmMngDAO.deleteAdmMenu(emfMap);
    	
    	//관리자 메뉴 set
    	if(!"".equals(EMFStringUtil.nullConvert(emfMap.get("mChecked"))))
		{
    		String mChecked = emfMap.getString("mChecked");
    		
			String[] menuSeqs;
			
			if(mChecked.indexOf(",") > 0)
			{
				menuSeqs = mChecked.split(",");
			}
			else
			{
				menuSeqs = new String[]{mChecked};
			}

			if(!"99".equals(EMFStringUtil.nullConvert(emfMap.get("authCd"))))
			{
				if(menuSeqs != null)
				{
					for(int q = 0; q < menuSeqs.length; q++)
					{
						emfMap.put("menuSeq", Integer.parseInt(menuSeqs[q]));
						
						cOCAdmMngDAO.insertAdmMenu(emfMap);
					}
				}
			}
		}
    }
    
	/**
     * 부서별 관리자 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public List<EmfMap> getRoleAdmList(EmfMap emfMap) throws Exception
    {
    	emfMap.put("roleCd", "ROLE_00008");
    	
    	return cOCAdmMngDAO.getRoleAdmList(emfMap);
    }
    
 	public String SHA256(String str)
 	{
        String SHA = null;
        
        try
        {
            MessageDigest sh = MessageDigest.getInstance("SHA-256");
            sh.update(str.getBytes());
            byte byteData[] = sh.digest();
            StringBuffer sb = new StringBuffer();
            
            for(int i = 0 ; i < byteData.length ; i++)
            {
                sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
            }
            
            SHA = sb.toString();
        }
        catch(NoSuchAlgorithmException e)
        {
        	log.debug(e.getMessage());
        }
        
        return SHA;
 	}    
}
