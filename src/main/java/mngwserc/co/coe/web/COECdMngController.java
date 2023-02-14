package mngwserc.co.coe.web;

import java.util.List;

import javax.annotation.Resource;

import mngwserc.co.coe.service.COECdMngService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import emf.core.exception.EmfException;
import emf.core.extend.web.EmfController;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 코드 관리를 위한 Controller
 * </pre>
 * 
 * @ClassName		: COGCntsMngController.java
 * @Description		: 코드 관리를 위한 Controller
 * @author 박주석
 * @since 2015.11.02
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2015.11.22		박주석					최초생성
 * </pre>
 */
@Controller
@RequestMapping(value="/mngwserc/coe/code")
public class COECdMngController extends EmfController {
	
	/** 서비스 **/
	@Resource(name = "cOECdMngService")
    private COECdMngService cOECdMngService;	
	   
	/**
	 * 코드 페이지를 보여준다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
    @RequestMapping(value="/index.do")
	public String getCdMngPage(EmfMap emfMap, ModelMap modelMap) throws Exception 
	{
    	return "mngwserc/co/coe/COEIndex.admin";      	
	}
    
    /**
	 * 상위코드 목록을 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
    @RequestMapping(value="/list.ajax", method=RequestMethod.POST)    
	public String selectCdIdList(EmfMap emfMap, ModelMap modelMap) throws Exception 
    {
    	try
		{
    		List<EmfMap> rtnList = cOECdMngService.selectCdIdList(emfMap);
    		
    		modelMap.addAttribute("rtnList", rtnList);	
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		} 	
    	
		return "mngwserc/co/coe/COECdIdList";
	}
    
    /**
   	 * 하위코드 목록을 조회한다.
   	 * 
   	 * @param EmfMap 검색할 데이터
   	 * @return 
   	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
   	 */
    @RequestMapping(value="/selectCdIdDtl.ajax", method=RequestMethod.POST)    
	public String selectCdIdDtl(EmfMap emfMap, ModelMap modelMap) throws Exception 
    {
		try
		{
    		List<EmfMap> rtnList = cOECdMngService.selectCdIdDtl(emfMap);
    		
    		modelMap.addAttribute("emfMap", emfMap);
    		modelMap.addAttribute("rtnList", rtnList);
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		} 	
		
		return "mngwserc/co/coe/COECdChldList";
	}
    
    /**
   	 * 상위코드를 등록한다.
   	 * 
   	 * @param EmfMap 검색할 데이터
   	 * @return 
   	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
   	 */
    @RequestMapping(value="/insertCode.ajax", method=RequestMethod.POST)
	public ModelAndView insertCode(EmfMap emfMap, ModelMap modelMap) throws Exception 
	{
    	ModelAndView mav = new ModelAndView();
    	
    	try
		{
    		cOECdMngService.insertCode(emfMap);
    		
    		mav.addObject("status", "OK");
			
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
   	 * 상위코드를 수정한다.
   	 * 
   	 * @param EmfMap 검색할 데이터
   	 * @return 
   	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
   	 */
    @RequestMapping(value="/updateCode.ajax", method=RequestMethod.POST)
	public ModelAndView updateCode(EmfMap emfMap,  ModelMap modelMap) throws Exception
	{
    	ModelAndView mav = new ModelAndView();
    	
    	try
		{
    		cOECdMngService.updateCode(emfMap);
    		
    		mav.addObject("status", "OK");
			
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
   	 * 상위코드를 삭제한다.
   	 * 
   	 * @param EmfMap 검색할 데이터
   	 * @return 
   	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
   	 */
    @RequestMapping(value="/deleteCode.ajax", method=RequestMethod.POST)
	public ModelAndView deleteCode(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
    	ModelAndView mav = new ModelAndView();
    	
    	try
		{
    		cOECdMngService.deleteCode(emfMap);
    		
    		mav.addObject("status", "OK");
			
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
   	 * 하위코드를 등록한다.
   	 * 
   	 * @param EmfMap 검색할 데이터
   	 * @return 
   	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
   	 */
    @RequestMapping(value="/insertCodeDetail.ajax", method=RequestMethod.POST)
	public ModelAndView insertCodeDetail(EmfMap emfMap, ModelMap modelMap) throws Exception
    {
    	ModelAndView mav = new ModelAndView();
    	
    	try
		{
    		cOECdMngService.insertCodeDetail(emfMap);
    		
    		mav.addObject("status", "OK");
			
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
   	 * 하위코드를 수정한다.
   	 * 
   	 * @param EmfMap 검색할 데이터
   	 * @return 
   	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
   	 */
    @RequestMapping(value="/updateCodeDetail.ajax", method=RequestMethod.POST)
	public ModelAndView updateCodeDetail(EmfMap emfMap, ModelMap modelMap) throws Exception 
    {
    	ModelAndView mav = new ModelAndView();
    	
    	try
		{
    		cOECdMngService.updateCodeDetail(emfMap);
    		
    		mav.addObject("status", "OK");
			
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
   	 * 하위코드를 삭제한다.
   	 * 
   	 * @param EmfMap 검색할 데이터
   	 * @return 
   	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
   	 */
    @RequestMapping(value="/deleteCodeDetail.ajax", method=RequestMethod.POST)
	public ModelAndView deleteCodeDetail(EmfMap emfMap, ModelMap modelMap) throws Exception 
    {
    	ModelAndView mav = new ModelAndView();
    	
    	try
		{
    		cOECdMngService.deleteCodeDetail(emfMap);
    		
    		mav.addObject("status", "OK");
			
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
