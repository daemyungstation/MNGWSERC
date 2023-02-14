package mngwserc.co.coe.web;

import javax.annotation.Resource;

import mngwserc.co.coe.service.COECdLinkService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import emf.core.exception.EmfException;
import emf.core.extend.web.EmfController;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 링크코드 관리를 위한 Controller
 * </pre>
 * 
 * @ClassName		: COECdLinkController.java
 * @Description		: 링크코드 관리를 위한 Controller
 * @author 허진영
 * @since 2016.03.28
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author				   description
 *   ===========    ==============    =============================
 *   2016.03.28			허진영					최초 생성
 * </pre>
 */

@Controller
@RequestMapping(value="/mngwserc/coe/link-code")
public class COECdLinkController extends EmfController {
	
	/** 서비스 **/
	@Resource(name = "cOECdLinkService")
	private COECdLinkService cOECdLinkService;
	
	/**
     * 코드 관리 페이지를 가져온다.
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/list.do")
	public String selectLinkList(EmfMap emfMap,  ModelMap modelMap) throws Exception 
	{
    	//검색어 체크
		String f = emfMap.getString("f");
		String q = emfMap.getString("q");	
		
		if(!"".equals(EMFStringUtil.nullConvert(q)) && q.length() <= 15)
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
			EmfMap rtnMap = cOECdLinkService.selectLinkList(emfMap);
			
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
    	
    	return "mngwserc/co/coe/COECdLinkList.admin";
	}
	
	/**
     * 코드 관리 페이지를 가져온다.
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/write.do")
	public String getCdLinkWritePage(EmfMap emfMap,  ModelMap modelMap) throws Exception 
	{
    	return "mngwserc/co/coe/COECdLinkWrite.admin";
	}
    
    /**
     * 코드 등록
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/insertCdLink.ajax", method=RequestMethod.POST)    
	public ModelAndView insertCdLink(EmfMap emfMap,  ModelMap modelMap) throws Exception 
	{
    	ModelAndView mav = new ModelAndView();
    	
		try
		{			
			cOECdLinkService.insertCdLink(emfMap);
			
			mav.addObject("status", "OK");
			
			mav.setViewName("jsonView");
		}
		catch(Exception e)
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(e);
            }
			throw new EmfException(e.getMessage());
		}
		return mav;
	}
    
    /**
     * 코드 삭제
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/delete.do", method=RequestMethod.POST)    
	public String multiDelete(EmfMap emfMap,  ModelMap modelMap) throws Exception 
	{
		try
		{			
			cOECdLinkService.deleteCdLinkList(emfMap);
		}
		catch(Exception e)
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(e);
            }
			throw new EmfException(e.getMessage());
		}
		return "redirect:./list.do";
	}
    
}