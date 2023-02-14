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
import mngwserc.fair.service.FairProductDetailService;

/**
 * <pre> 
 * 박람회 제품 상세 관리 Controller
 * </pre>
 * 
 * @ClassName		: FairDetailController.java
 * @Description		: 박람회 제품 상세 관리 Controller
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
@RequestMapping(value="/mngwserc/fair/product/detail")
public class FairProductDetailController extends EmfController {
	
	/** 서비스 **/
	@Resource(name="fairProductDetailService")
	private FairProductDetailService fairService;
	
	/**
	 * 목록 조회
	 *
	 * @param EmfMap, ModelMap
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value="/index.do")
	public String selectProductDetail(EmfMap emfMap, ModelMap modelMap) throws Exception
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
		return "mngwserc/fair/FairProductDetail.admin";
	}
	
	/**
	 * 상세 조회 / 등록폼
	 *
	 * @param EmfMap, ModelMap
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value="/write.do")
	public String writeProductDetail(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		try
		{
			EmfMap rtnMap = new EmfMap(); 
			if(!"".equals(emfMap.getString("seq")))
			{
				rtnMap = fairService.select(emfMap);
			}
			
			rtnMap.put("cateList", fairService.selectCate());
			rtnMap.put("inputList", fairService.selectInput());
			rtnMap.put("benefitList", fairService.selectBenefit());

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
		return "mngwserc/fair/FairProductDetailWrite.admin";
	}
		
	/**
     * 파일업로드
     * 
     * @param EmfMap
	 * @return ModelAndView
	 * @throws Exception
     */    
    @RequestMapping(value="/fileupload.ajax", method=RequestMethod.POST)
    public ModelAndView orderProductFile(HttpServletRequest request, EmfMap emfMap) throws Exception 
    {
    	EmfMap rtnMap = new EmfMap();
    	try
		{
    		emfMap.put("request", request);
			rtnMap = fairService.fileUpload(emfMap);		
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
    	mav.addObject("path", rtnMap.getString("path"));
    	mav.addObject("save", rtnMap.getString("save"));
    	mav.addObject("real", rtnMap.getString("real"));
		mav.setViewName("jsonView");

		return mav; 
    }
	
	/**
     * 등록 or 수정
     * 
     * @param EmfMap
	 * @return String
	 * @throws Exception
     */
	@RequestMapping(value="/action.do", method=RequestMethod.POST)
    public String actionProductDetail(HttpServletRequest request, EmfMap emfMap) throws Exception 
    {	
    	try
    	{
    		emfMap.put("request", request);
    		
    		String fpSday = (String) emfMap.get("fpSday");
    		String fpEday = (String) emfMap.get("fpEday");
    		if(!fpSday.isEmpty())
    		{
    			emfMap.put("FP_STIME", fpSday.replaceAll("-", "/") +" "+ emfMap.get("fpShh") +":"+ emfMap.get("fpSmm") +":"+ emfMap.get("fpSss"));
    		}
    		if(!fpEday.isEmpty())
    		{
    			emfMap.put("FP_ETIME", fpEday.replaceAll("-", "/") +" "+ emfMap.get("fpEhh") +":"+ emfMap.get("fpEmm") +":"+ emfMap.get("fpEss"));
    		}
    		
    		emfMap.put("FPI_INPUT", emfMap.getString("fpiInput").replace("&#34;",  "\""));
    		
    		if("".equals(EMFStringUtil.nullConvert(emfMap.getString("seq"))))		
    		{
    			fairService.insert(emfMap);
    		}
    		else
    		{
    			emfMap.put("FP_SEQ", emfMap.getString("seq"));
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

		return "redirect:/mngwserc/fair/product/detail/index.do";
    }
	
	/**
     * 순서 변경
     * 
     * @param EmfMap
	 * @return ModelAndView
	 * @throws Exception
     */    
    @RequestMapping(value="/order.ajax", method=RequestMethod.POST)
    public ModelAndView orderProductDetail(EmfMap emfMap) throws Exception 
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
    public ModelAndView copyProductDetail(EmfMap emfMap) throws Exception 
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
    public String deleteProductDetail(HttpServletRequest request, EmfMap emfMap) throws Exception 
    {	
    	try
    	{
    		emfMap.put("request", request);
    		
			emfMap.put("FP_SEQ", emfMap.getString("seq"));
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

		return "redirect:/mngwserc/fair/product/detail/index.do";
    }
}
