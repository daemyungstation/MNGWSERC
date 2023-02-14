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
import emf.core.vo.EmfMap;
import mngwserc.fair.service.FairConfigService;

/**
 * <pre> 
 * 박람회 설정 관리 Controller
 * </pre>
 * 
 * @ClassName		: FairConfigController.java
 * @Description		: 박람회 설정 관리 Controller
 * @author inuscommunity
 * @since 2019. 10. 14.
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 	    since			author	               description
 *  ============    ==============    =============================
 *  2019. 10. 14.	   inuscomm                 최초생성
 * </pre>
 */

@Controller
@RequestMapping(value="/mngwserc/fair/config")
public class FairConfigController extends EmfController {
	
	/** 서비스 **/
	@Resource(name="fairConfigService")
	private FairConfigService fairService;
	
	/**
	 * 설정 조회
	 *
	 * @param modelMap
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value="/index.do")
	public String select(ModelMap modelMap) throws Exception
	{
		try
		{
			EmfMap rtnMap = fairService.select();
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
		return "mngwserc/fair/FairConfig.admin";
	}
	

	/**
	 * 설정 업데이트
	 *
	 * @param HttpServletRequest request data
	 * @return ModelAndView
	 * @throws Exception
	 */
    @RequestMapping(value="/action.ajax", method=RequestMethod.POST)
    public ModelAndView update(HttpServletRequest request, EmfMap emfMap) throws Exception 
    {
    	try
		{
    		emfMap.put("request", request);
    		
    		String fcfgSday = (String) emfMap.get("fcfgSday");
    		String fcfgEday = (String) emfMap.get("fcfgEday");
    		if(!fcfgSday.isEmpty())
    		{
    			emfMap.put("FCFG_STIME", fcfgSday.replaceAll("-", "/") +" "+ emfMap.get("fcfgShh") +":"+ emfMap.get("fcfgSmm") +":"+ emfMap.get("fcfgSss"));
    		}
    		if(!fcfgEday.isEmpty())
    		{
    			emfMap.put("FCFG_ETIME", fcfgEday.replaceAll("-", "/") +" "+ emfMap.get("fcfgEhh") +":"+ emfMap.get("fcfgEmm") +":"+ emfMap.get("fcfgEss"));
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
    	
    	ModelAndView mav = new ModelAndView();
    	mav.addObject("result", "OK");
		mav.setViewName("jsonView");

		return mav; 
    }
}
