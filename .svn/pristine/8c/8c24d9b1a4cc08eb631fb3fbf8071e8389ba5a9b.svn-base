package mngwserc.sm.sma.web;

import javax.annotation.Resource;

import mngwserc.sm.sma.service.SMABanrMngService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import egovframework.com.utl.fcc.service.EgovStringUtil;
import emf.core.exception.EmfException;
import emf.core.extend.web.EmfController;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 배너 관리를 위한 Controller
 * </pre>
 * 
 * @ClassName		: SMABanrMngController.java
 * @Description		: 배너 관리를 위한 Controller
 * @author 허진영
 * @since 2016.02.11.
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author				   description
 *   ===========    ==============    =============================
 *   2016.02.11.		허진영			 		최초생성
 * </pre>
 */
@Controller
@RequestMapping(value="/mngwserc/sma/banr")
public class SMABanrMngController extends EmfController {

	@Resource(name="sMABanrMngService")
	private SMABanrMngService sMABanrMngService;
	
	/**
     * 배너 목록을 조회한다.
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
    @RequestMapping(value="/list.do")
    public String selectBanrList(EmfMap emfMap, ModelMap modelMap) throws Exception
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
			EmfMap rtnMap = sMABanrMngService.selectBanrList(emfMap);
			
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
    	
    	return "mngwserc/sm/sma/SMABanrList.admin";
    }
    
    /**
     * 배너 상세를 조회한다.
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
    @RequestMapping(value="/write.do")
    public String writeBanr(EmfMap emfMap, ModelMap modelMap) throws Exception 
    {    
    	try
		{
			EmfMap rtnMap = sMABanrMngService.selectBanr(emfMap);
			
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

    	return "mngwserc/sm/sma/SMABanrWrite.admin";
    }
    
    /**
     * 배너를 등록한다.
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
    @RequestMapping(value="/insert.do", method=RequestMethod.POST)
    public String insertBanr(MultipartHttpServletRequest multiRequest, EmfMap emfMap, ModelMap modelMap) throws Exception 
    {
    	String url = "error/blank.error";
    	
    	try
		{
		    sMABanrMngService.insertBanr(multiRequest, emfMap);
		    
		    url =  "redirect:./list.do";
		}
		catch(Exception he)
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			
			if("파일용량초과".equals(EgovStringUtil.nullConvert(he.getMessage())))
			{
				modelMap.addAttribute("msg", "파일 용량이 초과되었습니다.");
				modelMap.addAttribute("url", "javascript:history.back();");
			}
			else
			{
				throw new EmfException(he.getMessage());
			}
		}
    	
    	return url;
    }
    
    /**
     * 배너를 수정한다.
	 *
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
    @RequestMapping(value="/update.do", method=RequestMethod.POST)
    public String updateBanr(MultipartHttpServletRequest multiRequest, EmfMap emfMap, ModelMap modelMap) throws Exception 
    {
    	String url = "error/blank.error";
		try
		{
			sMABanrMngService.updateBanr(multiRequest, emfMap);
			
			url = "redirect:./write.do?banrSeq=" + emfMap.getString("banrSeq");
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }

			if("파일용량초과".equals(EgovStringUtil.nullConvert(he.getMessage())))
			{
				modelMap.addAttribute("msg", "파일 용량이 초과되었습니다.");
				modelMap.addAttribute("url", "javascript:history.back();");
			}
			else
			{
				throw new EmfException(he.getMessage());
			}
		}
    	
		return url; 
    }
    
    /**
	 * 배너를 삭제한다. 
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */	
    @RequestMapping(value="/delete.do", method=RequestMethod.POST)
	public String deleteBanrList(EmfMap emfMap, ModelMap modelMap, @RequestParam(value="delSeq", required=true) int[] delSeq) throws Exception
    {
    	try
		{
    		sMABanrMngService.deleteBanrList(delSeq);
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}
		
		return "redirect:./list.do";
	}
    
    /**
     * 배너 정렬순서를 수정한다(up).
	 *
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
    @RequestMapping(value="/sort-up.ajax", method=RequestMethod.POST)
    public ModelAndView updateBanrSortUp(EmfMap emfMap, ModelMap modelMap) throws Exception 
    {
    	ModelAndView mav = new ModelAndView();
    	
		try
		{
			sMABanrMngService.updateBanrSortUp(emfMap);
			
			mav.addObject("status", "Y");
			
			mav.setViewName("jsonView");	
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}
    	
		return mav; 
    }
    
    /**
     * 배너 정렬순서를 수정한다(down).
	 *
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
    @RequestMapping(value="/sort-down.ajax", method=RequestMethod.POST)
    public ModelAndView updateBanrSortDown(EmfMap emfMap, ModelMap modelMap) throws Exception 
    {
    	ModelAndView mav = new ModelAndView();
    	
		try
		{
			sMABanrMngService.updateBanrSortDown(emfMap);
			
			mav.addObject("status", "Y");
			
			mav.setViewName("jsonView");	
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}
    	
		return mav; 
    }
}
