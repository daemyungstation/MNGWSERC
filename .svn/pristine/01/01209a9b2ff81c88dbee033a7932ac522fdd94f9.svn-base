package mngwserc.co.coi.web;

import java.io.FileNotFoundException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.utl.fcc.service.EgovStringUtil;
import emf.core.exception.EmfException;
import emf.core.extend.web.EmfController;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;
import mngwserc.co.coi.service.COISnsMngService;


/**
 * <pre> 
 * SNS 페이지 관리 Controller
 * </pre>
 * 
 * @ClassName		: COISnsMngController.java
 * @Description		: 메인 페이지 관리 Controller
 * @author inuscomm
 * @since 2019. 04. 19.
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2019. 05. 14.	   inuscomm				                최초생성
 * </pre>
 */

@Controller
@RequestMapping(value="/mngwserc/coi")
public class COISnsMngController extends EmfController {
	
	/** 서비스 **/
	@Resource(name="cOISnsMngService")
	private COISnsMngService cOISnsMngService;
	
	/**
     * SNS 화면 조회
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@RequestMapping(value="/index.do")
    public String COISnsMng(EmfMap emfMap, ModelMap modelMap) throws Exception {
		try
		{
			EmfMap rtnMap = cOISnsMngService.selectSnsList(emfMap);
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
		return "mngwserc/co/coi/COISnsMng.admin";
	}
	
	/**
     * SNS 등록 페이지로 이동한다.
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@RequestMapping(value="/write.do")   
    public String COISnsMngWrite(EmfMap emfMap, ModelMap modelMap) throws Exception 
    {
		try
		{	
			if(!"".equals(emfMap.getString("snsSeq")))
			{
				EmfMap rtnMap = cOISnsMngService.selectSns(emfMap);
				modelMap.addAttribute("rtnMap", rtnMap);			
			}
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		} 	
		
    	return "mngwserc/co/coi/COISnsMngWrite.admin";
    }
	
	/**
     * SNS내용을 등록 및 수정한다.
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@RequestMapping(value="/action.do", method=RequestMethod.POST)
    public String COISnsMngAction(HttpServletRequest request, EmfMap emfMap) throws Exception 
    {	
    	try
    	{
    		emfMap.put("request", request);
    		if("".equals(EMFStringUtil.nullConvert(emfMap.getString("snsSeq"))))		
    		{
    			cOISnsMngService.insertSns(emfMap);
    		}
    		else
    		{
    			cOISnsMngService.updateSns(emfMap);
    		}
    	}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		} 	

		return "redirect:/mngwserc/coi/index.do";
    }
	
	/**
     * SNS내용을 삭제한다.
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@RequestMapping(value="/delete.do", method=RequestMethod.POST)
    public String COISnsMngDelete(HttpServletRequest request, EmfMap emfMap) throws Exception 
    {	
    	try
    	{
			cOISnsMngService.deleteSns(emfMap);
    	}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		} 	

		return "redirect:/mngwserc/coi/index.do";
    }
	
	/**
     * SNS 순서변경
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@RequestMapping(value="/order.ajax", method=RequestMethod.POST)
    public ModelAndView COISnsMngOrder(HttpServletRequest request, EmfMap emfMap) throws Exception 
    {	
    	try
    	{
    		emfMap.put("request", request);
			cOISnsMngService.orderSns(emfMap);
    	}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		} 	

    	ModelAndView mav = new ModelAndView();
    	mav.addObject("result", "OK");
		mav.setViewName("jsonView");

		return mav; 
    }
	
}