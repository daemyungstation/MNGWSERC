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
import mngwserc.fair.service.FairBannerTopService;

/**
 * <pre> 
 * 박람회 탑배너 관리 Controller
 * </pre>
 * 
 * @ClassName		: FairConfigController.java
 * @Description		: 박람회 탑배너 관리 Controller
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
@RequestMapping(value="/mngwserc/fair/banner")
public class FairBannerTopController extends EmfController {
	
	/** 서비스 **/
	@Resource(name="fairBannerTopService")
	private FairBannerTopService fairService;
	
	/**
	 * 목록 조회
	 *
	 * @param EmfMap, ModelMap
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value="/index.do")
	public String selectBannerTop(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		try
		{
			EmfMap rtnMap = fairService.selectList(emfMap);
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
		return "mngwserc/fair/FairBannerTop.admin";
	}
	
	/**
	 * 상세 조회
	 *
	 * @param EmfMap, ModelMap
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value="/write.do")
	public String writeBannerTop(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		try
		{
			if(!"".equals(emfMap.getString("seq")))
			{
				EmfMap rtnMap = fairService.select(emfMap);
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
		return "mngwserc/fair/FairBannerTopWrite.admin";
	}
	
	/**
     * 등록 or 수정
     * 
     * @param EmfMap
	 * @return String
	 * @throws Exception
     */
	@RequestMapping(value="/action.do", method=RequestMethod.POST)
    public String actionBannerTop(HttpServletRequest request, EmfMap emfMap) throws Exception 
    {	
    	try
    	{
    		emfMap.put("request", request);
    		
    		String fbtSday = (String) emfMap.get("fbtSday");
    		String fbtEday = (String) emfMap.get("fbtEday");
    		if(!fbtSday.isEmpty())
    		{
    			emfMap.put("FBT_STIME", fbtSday.replaceAll("-", "/") +" "+ emfMap.get("fbtShh") +":"+ emfMap.get("fbtSmm") +":"+ emfMap.get("fbtSss"));
    		}
    		if(!fbtEday.isEmpty())
    		{
    			emfMap.put("FBT_ETIME", fbtEday.replaceAll("-", "/") +" "+ emfMap.get("fbtEhh") +":"+ emfMap.get("fbtEmm") +":"+ emfMap.get("fbtEss"));
    		}
    		
    		if("".equals(EMFStringUtil.nullConvert(emfMap.getString("seq"))))		
    		{
    			fairService.insert(emfMap);
    		}
    		else
    		{
    			emfMap.put("FBT_SEQ", emfMap.getString("seq"));
    			fairService.update(emfMap);
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

		return "redirect:/mngwserc/fair/banner/index.do";
    }
	
	/**
     * 순서 변경
     * 
     * @param EmfMap
	 * @return ModelAndView
	 * @throws Exception
     */    
    @RequestMapping(value="/order.ajax", method=RequestMethod.POST)
    public ModelAndView orderBannerTop(EmfMap emfMap) throws Exception 
    {
    	try
		{
			fairService.order(emfMap);
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
     * 삭제
     * 
     * @param EmfMap
	 * @return String
	 * @throws Exception
     */
	@RequestMapping(value="/delete.do", method=RequestMethod.POST)
    public String deleteBannerTop(HttpServletRequest request, EmfMap emfMap) throws Exception 
    {	
    	try
    	{
    		emfMap.put("request", request);
    		
			emfMap.put("FBT_SEQ", emfMap.getString("seq"));
			fairService.delete(emfMap);
    	}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		} 	

		return "redirect:/mngwserc/fair/banner/index.do";
    }
	
}
