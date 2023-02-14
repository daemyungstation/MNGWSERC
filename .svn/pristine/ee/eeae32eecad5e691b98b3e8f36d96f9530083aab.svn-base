package mngwserc.fair.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import emf.core.exception.EmfException;
import emf.core.extend.web.EmfController;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;
import mngwserc.fair.service.FairProductInputService;

/**
 * <pre> 
 * 박람회 제품 입력폼 관리 Controller
 * </pre>
 * 
 * @ClassName		: FairProductInputController.java
 * @Description		: 박람회 제품 입력폼 관리 Controller
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
@RequestMapping(value="/mngwserc/fair/product/input")
public class FairProductInputController extends EmfController {
	
	/** 서비스 **/
	@Resource(name="fairProductInputService")
	private FairProductInputService fairService;
	
	/**
	 * 목록 조회
	 *
	 * @param EmfMap, ModelMap
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value="/index.do")
	public String selectProductInput(EmfMap emfMap, ModelMap modelMap) throws Exception
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
		return "mngwserc/fair/FairProductInput.admin";
	}
	
	/**
	 * 상세 조회
	 *
	 * @param EmfMap, ModelMap
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value="/write.do")
	public String writeProductInput(EmfMap emfMap, ModelMap modelMap) throws Exception
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
		return "mngwserc/fair/FairProductInputWrite.admin";
	}
	
	/**
     * 등록 or 수정
     * 
     * @param EmfMap
	 * @return String
	 * @throws Exception
     */
	@RequestMapping(value="/action.do", method=RequestMethod.POST)
    public String actionProductInput(HttpServletRequest request, EmfMap emfMap) throws Exception 
    {	
    	try
    	{
    		
    		emfMap.put("FPI_INPUT", emfMap.getString("fpiInput").replace("&#34;",  "\""));
    		if("".equals(EMFStringUtil.nullConvert(emfMap.getString("seq"))))		
    		{
    			fairService.insert(emfMap);
    		}
    		else
    		{
    			emfMap.put("FPI_SEQ", emfMap.getString("seq"));
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

		return "redirect:/mngwserc/fair/product/input/index.do";
    }
	
	/**
     * 삭제
     * 
     * @param EmfMap
	 * @return String
	 * @throws Exception
     */
	@RequestMapping(value="/delete.do", method=RequestMethod.POST)
    public String deleteProductInput(HttpServletRequest request, EmfMap emfMap) throws Exception 
    {	
    	try
    	{
    		emfMap.put("request", request);
    		
			emfMap.put("FPI_SEQ", emfMap.getString("seq"));
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

		return "redirect:/mngwserc/fair/product/input/index.do";
    }
}
