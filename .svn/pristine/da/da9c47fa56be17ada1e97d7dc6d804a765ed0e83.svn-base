package mngwserc.fair.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import emf.core.exception.EmfException;
import emf.core.extend.web.EmfController;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;
import mngwserc.fair.service.FairProductBenefitService;

/**
 * <pre> 
 * 박람회 제품 결합상품 관리 Controller
 * </pre>
 * 
 * @ClassName		: FairProductBenefitController.java
 * @Description		: 박람회 제품 결합상품 관리 Controller
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
@RequestMapping(value="/mngwserc/fair/product/benefit")
public class FairProductBenefitController extends EmfController {
	
	/** 서비스 **/
	@Resource(name="fairProductBenefitService")
	private FairProductBenefitService fairService;
	
	/**
	 * 목록 조회
	 *
	 * @param EmfMap, ModelMap
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value="/index.do")
	public String selectProductBenefit(EmfMap emfMap, ModelMap modelMap) throws Exception
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
		return "mngwserc/fair/FairProductBenefit.admin";
	}
	
	/**
	 * 상세 조회
	 *
	 * @param EmfMap, ModelMap
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value="/write.do")
	public String writeProductBenefit(EmfMap emfMap, ModelMap modelMap) throws Exception
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
		return "mngwserc/fair/FairProductBenefitWrite.admin";
	}
	
	/**
     * 등록 or 수정
     * 
     * @param EmfMap
	 * @return String
	 * @throws Exception
     */
	@RequestMapping(value="/action.do", method=RequestMethod.POST)
    public String actionProductBenefit(HttpServletRequest request, EmfMap emfMap) throws Exception 
    {	
    	try
    	{
    		emfMap.put("request", request);
    		
    		String fbSday = (String) emfMap.get("fbSday");
    		String fbEday = (String) emfMap.get("fbEday");
    		if(!fbSday.isEmpty())
    		{
    			emfMap.put("FB_STIME", fbSday.replaceAll("-", "/") +" "+ emfMap.get("fbShh") +":"+ emfMap.get("fbSmm") +":"+ emfMap.get("fbSss"));
    		}
    		if(!fbEday.isEmpty())
    		{
    			emfMap.put("FB_ETIME", fbEday.replaceAll("-", "/") +" "+ emfMap.get("fbEhh") +":"+ emfMap.get("fbEmm") +":"+ emfMap.get("fbEss"));
    		}
    		
    		if("".equals(EMFStringUtil.nullConvert(emfMap.getString("seq"))))		
    		{
    			fairService.insert(emfMap);
    		}
    		else
    		{
    			EmfMap rtnMap = fairService.select(emfMap);
    			
    			emfMap.put("FB_SEQ", emfMap.getString("seq"));
    			EmfMap rstMap = fairService.update(emfMap);
    			
//    			productBenefit extBenefitObj = new productBenefit();
//    			extBenefitObj.fbSeq = Integer.parseInt(rtnMap.getString("fbSeq"));
//    			extBenefitObj.fbTitle = rtnMap.getString("fbTitle");
//    			extBenefitObj.fbSubtitle = rtnMap.getString("fbSubtitle");
//    			extBenefitObj.fbModel = rtnMap.getString("fbModel");
//    			extBenefitObj.fbPrice = rtnMap.getString("fbPrice");
//    			extBenefitObj.fbPath = rtnMap.getString("fbImageWPath");
//    			extBenefitObj.fbSave = rtnMap.getString("fbImageWSaveNm");
//    			extBenefitObj.fbReal = rtnMap.getString("fbImageWRealNm");
//    			
//    			productBenefit newBenefitObj = new productBenefit();
//				newBenefitObj.fbSeq = Integer.parseInt(rstMap.getString("fbSeq"));
//				newBenefitObj.fbTitle = rstMap.getString("fbTitle");
//				newBenefitObj.fbSubtitle = rstMap.getString("fbSubtitle");
//				newBenefitObj.fbModel = rstMap.getString("fbModel");
//				newBenefitObj.fbPrice = rstMap.getString("fbPrice");
//				newBenefitObj.fbPath = rstMap.getString("fbImageWPath");
//				newBenefitObj.fbSave = rstMap.getString("fbImageWSaveNm");
//				newBenefitObj.fbReal = rstMap.getString("fbImageWRealNm");
//				if(newBenefitObj.fbPath.isEmpty()) newBenefitObj.fbPath = rtnMap.getString("fbImageWPath");
//				if(newBenefitObj.fbSave.isEmpty()) newBenefitObj.fbSave = rtnMap.getString("fbImageWSaveNm");
//				if(newBenefitObj.fbReal.isEmpty()) newBenefitObj.fbReal = rtnMap.getString("fbImageWRealNm");
//				
//				EmfMap updMap = new EmfMap();
//				ObjectMapper mapper = new ObjectMapper();
//				updMap.put("extBenefit", mapper.writeValueAsString(extBenefitObj));
//				updMap.put("newBenefit", mapper.writeValueAsString(newBenefitObj));
//				
//				fairService.updateProduct(updMap);
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

		return "redirect:/mngwserc/fair/product/benefit/index.do";
    }
	
	/**
     * 순서 변경
     * 
     * @param EmfMap
	 * @return ModelAndView
	 * @throws Exception
     */    
    @RequestMapping(value="/order.ajax", method=RequestMethod.POST)
    public ModelAndView orderProductBenefit(EmfMap emfMap) throws Exception 
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
     * 복사
     * 
     * @param EmfMap
	 * @return ModelAndView
	 * @throws Exception
     */    
    @RequestMapping(value="/copy.ajax", method=RequestMethod.POST)
    public ModelAndView copyProductBenefit(EmfMap emfMap) throws Exception 
    {
    	int seq = 0;
    	try
		{
    		seq = fairService.copy(emfMap);
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
    	mav.addObject("seq", seq);
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
    public String deleteProductBenefit(HttpServletRequest request, EmfMap emfMap) throws Exception 
    {	
    	try
    	{
    		emfMap.put("request", request);
    		
			emfMap.put("FB_SEQ", emfMap.getString("seq"));
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

		return "redirect:/mngwserc/fair/product/benefit/index.do";
    }
}
