package mngwserc.mb.mba.web;

import javax.annotation.Resource;

import mngwserc.mb.mba.service.MBAMemInfService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import emf.core.exception.EmfException;
import emf.core.extend.web.EmfController;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 회원정보 관리를 위한 Controller
 * </pre>
 * 
 * @ClassName		: MBAMemInfController.java
 * @Description		: 회원정보 관리를 위한 Controller
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
@Controller
@RequestMapping("/mngwserc/mba/mem")
public class MBAMemInfController extends EmfController {
	
	/** 서비스 **/
	@Resource(name="mBAMemInfService")
    private MBAMemInfService mBAMemInfService;
	
	/**
	 * 회원정보 목록을 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/list.do")
	public String selectMemInfList(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		//검색어 체크
		String f = emfMap.getString("f");
		String q = emfMap.getString("q");	
		
		if(!"".equals(EMFStringUtil.nullConvert(q)) && q.length() <= 20)
		{
			emfMap.put("f", f);
			emfMap.put("q", q);
		}
		else
		{
			emfMap.put("f", "");
			emfMap.put("q", "");
		}
		
		try
		{
			EmfMap rtnMap = mBAMemInfService.selectMemInfList(emfMap);
			
			modelMap.addAttribute("rtnMap", rtnMap);
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		} 
		
		return "mngwserc/mb/mba/MBAMemInfList.admin";
	}
	
	/**
	 * 회원정보 상세를 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/write.do")
	public String selectMemInf(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		try
		{
			EmfMap rtnMap = mBAMemInfService.selectMemInf(emfMap);
			
			modelMap.addAttribute("rtnMap", rtnMap);
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}

		return "mngwserc/mb/mba/MBAMemInfWrite.admin";
	}
	
	/**
	 * 회원정보를 수정한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	public String updateMemInf(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		try
		{
			modelMap.addAttribute("f", emfMap.getString("f"));
			modelMap.addAttribute("q", emfMap.getString("q"));			
			modelMap.addAttribute("pageIndex", emfMap.getString("pageIndex"));
			modelMap.addAttribute("smsRcvYn", emfMap.getString("smsRcvYn"));
			modelMap.addAttribute("emailRcvYn", emfMap.getString("emailRcvYn"));
			modelMap.addAttribute("unqExstYn", emfMap.getString("unqExstYn"));
			
			mBAMemInfService.updateMemInf(emfMap);
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}

		return "redirect:/mngwserc/mba/mem/write.do?id=" + emfMap.getString("id");
	}

	/**
	 * 회원 탈퇴
	 *
	 * @param emfMap
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/drot.do", method=RequestMethod.POST)
	public String updateMemDrot(EmfMap emfMap, ModelMap modelMap) throws Exception {
		try {
			if (false)
			{
				mBAMemInfService.updateMemDrot(emfMap);
			}
			else
			{
				// SSO 통합아이디 [S]
				mBAMemInfService.updateMemDrot_Sso(emfMap);
				// SSO 통합아이디 [E]
			}
		} catch (Exception he) {
			if (log.isDebugEnabled()) log.debug(he);
			throw new EmfException(he.getMessage());
		}
		return "redirect:/mngwserc/mba/mem/list.do";
	}
	
	/**
     * 회원정보 목록을 조회한다. (엑셀다운로드)
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@RequestMapping(value="/excel.do")
	public String excelMemInfList(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		//검색어 체크
		String f = emfMap.getString("f");
		String q = emfMap.getString("q");	
		
		if(!"".equals(EMFStringUtil.nullConvert(q)) && q.length() <= 20)
		{
			emfMap.put("f", f);
			emfMap.put("q", q);
		}
		else
		{
			emfMap.put("f", "");
			emfMap.put("q", "");
		}
		
		try
		{
			modelMap.addAttribute("excelList", mBAMemInfService.excelMemInfList(emfMap));
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		} 
				
		return "mngwserc/mb/mba/MBAMemInfExcel";
	}
	
	/**
     * 고객서비스 변경 목록을 조회한다. (엑셀다운로드)
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@RequestMapping(value="/rcv-excel.do")
	public String excelRcvModList(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		try
		{
			modelMap.addAttribute("excelList", mBAMemInfService.excelRcvModList(emfMap));
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		} 
				
		return "mngwserc/mb/mba/MBARcvModExcel";
	}
}
