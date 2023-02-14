package mngwserc.fair.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import emf.core.exception.EmfException;
import emf.core.extend.web.EmfController;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;
import mngwserc.fair.service.FairMainService;

/**
 * <pre> 
 * 박람회 소구포인트 관리 Controller
 * </pre>
 * 
 * @ClassName		: FairMainController.java
 * @Description		: 박람회 소구포인트 관리 Controller
 * @author inuscommunity
 * @since 2019. 10. 23.
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 	    since			author	               description
 *  ============    ==============    =============================
 *  2019. 10. 23.	   inuscomm                 최초생성
 * </pre>
 */

@Controller
@RequestMapping(value="/mngwserc/fair/main")
public class FairMainController extends EmfController {
	
	/** 서비스 **/
	@Resource(name="fairMainService")
	private FairMainService fairService;
	
	/**
	 * 조회
	 *
	 * @param emfMap, modelMap
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value="/index.do")
	public String select(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		try
		{
			//서브 리스트
			EmfMap rtnMap = fairService.selectSubList(emfMap);
			//메인 설정
			rtnMap.put("mRow",  fairService.select());
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
		return "mngwserc/fair/FairMain.admin";
	}
	
	/**
	 * 업데이트
	 *
	 * @param HttpServletRequest request data
	 * @return ModelAndView
	 * @throws Exception
	 */
    @RequestMapping(value="/action.do", method=RequestMethod.POST)
    public String update(HttpServletRequest request, EmfMap emfMap) throws Exception 
    {
    	try
		{
    		emfMap.put("request", request);
    		
    		String fmSday = (String) emfMap.get("fmSday");
    		String fmEday = (String) emfMap.get("fmEday");
    		if(!fmSday.isEmpty())
    		{
    			emfMap.put("FM_STIME", fmSday.replaceAll("-", "/") +" "+ emfMap.get("fmShh") +":"+ emfMap.get("fmSmm") +":"+ emfMap.get("fmSss"));
    		}
    		if(!fmEday.isEmpty())
    		{
    			emfMap.put("FM_ETIME", fmEday.replaceAll("-", "/") +" "+ emfMap.get("fmEhh") +":"+ emfMap.get("fmEmm") +":"+ emfMap.get("fmEss"));
    		}
    		fairService.update(emfMap);
		}
    	catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}
    	
    	return "redirect:/mngwserc/fair/main/index.do"; 
    }
    
    /**
	 * 서브 등록/수정
	 *
	 * @param emfMap, modelMap
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value="/subwrite.do")
	public String subWrite(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		try
		{
			EmfMap rtnMap = new EmfMap();
			if(!"".equals(emfMap.getString("seq")))
			{
				rtnMap = fairService.selectSub(emfMap);
			}
			EmfMap mainEmfMap = fairService.select();
			rtnMap.put("FAIR_MAIN_FM_SEQ",  mainEmfMap.get("fmSeq"));
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
		return "mngwserc/fair/FairMainSubWrite.admin";
	}
	
	/**
     * 서브 등록/수정 액션
     * 
     * @param EmfMap
	 * @return String
	 * @throws Exception
     */
	@RequestMapping(value="/subaction.do", method=RequestMethod.POST)
    public String subAction(HttpServletRequest request, EmfMap emfMap) throws Exception 
    {	
    	try
    	{
    		emfMap.put("request", request);
    		
    		String fmsSday = (String) emfMap.get("fmsSday");
    		String fmsEday = (String) emfMap.get("fmsEday");
    		if(!fmsSday.isEmpty())
    		{
    			emfMap.put("FMS_STIME", fmsSday.replaceAll("-", "/") +" "+ emfMap.get("fmsShh") +":"+ emfMap.get("fmsSmm") +":"+ emfMap.get("fmsSss"));
    		}
    		if(!fmsEday.isEmpty())
    		{
    			emfMap.put("FMS_ETIME", fmsEday.replaceAll("-", "/") +" "+ emfMap.get("fmsEhh") +":"+ emfMap.get("fmsEmm") +":"+ emfMap.get("fmsEss"));
    		}
    		
    		if("".equals(EMFStringUtil.nullConvert(emfMap.getString("seq"))))		
    		{
    			fairService.subInsert(emfMap);
    		}
    		else
    		{
    			emfMap.put("FMS_SEQ", emfMap.getString("seq"));
    			fairService.subUpdate(emfMap);
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

		return "redirect:/mngwserc/fair/main/index.do";
    }
	
	/**
     * 서브 순서 변경
     * 
     * @param EmfMap
	 * @return ModelAndView
	 * @throws Exception
     */    
    @RequestMapping(value="/suborder.ajax", method=RequestMethod.POST)
    public ModelAndView subOrder(EmfMap emfMap) throws Exception 
    {
    	try
		{
			fairService.subOrder(emfMap);
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
	
	/**
     * 서브 삭제
     * 
     * @param EmfMap
	 * @return String
	 * @throws Exception
     */
	@RequestMapping(value="/subdelete.do", method=RequestMethod.POST)
    public String subDelete(HttpServletRequest request, EmfMap emfMap) throws Exception 
    {	
    	try
    	{
    		emfMap.put("request", request);
    		
			emfMap.put("FMS_SEQ", emfMap.getString("seq"));
			fairService.subDelete(emfMap);
    	}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		} 	

		return "redirect:/mngwserc/fair/main/index.do";
    }
}
