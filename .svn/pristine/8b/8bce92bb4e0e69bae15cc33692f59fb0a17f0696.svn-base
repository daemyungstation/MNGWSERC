package mngwserc.fair.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import emf.core.exception.EmfException;
import emf.core.extend.web.EmfController;
import emf.core.vo.EmfMap;
import mngwserc.fair.service.FairUserService;

/**
 * <pre> 
 * 박람회 상담 관리 Controller
 * </pre>
 * 
 * @ClassName		: FairUserController.java
 * @Description		: 박람회 상담 관리 Controller
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
@RequestMapping(value="/mngwserc/fair/user")
public class FairUserController extends EmfController {
	
	/** 서비스 **/
	@Resource(name="fairUserService")
	private FairUserService fairService;
	
	/**
	 * 목록 조회
	 *
	 * @param EmfMap, ModelMap
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value="/index.do")
	public String selectUser(HttpServletRequest request, EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		try
		{
			String domain = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
			EmfMap rtnMap = fairService.selectList(emfMap);
			EmfMap cateMap = fairService.selectCateList(new EmfMap());
			modelMap.addAttribute("rtnMap", rtnMap);
			modelMap.addAttribute("cateMap", cateMap);
			modelMap.addAttribute("formMap", emfMap);
			modelMap.addAttribute("domain", domain);
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		} 	
		return "mngwserc/fair/FairUser.admin";
	}
	
	/**
	 * 목록 조회 - 각 카테고리별
	 *
	 * @param EmfMap, ModelMap
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value="/{fcSeq}/consult.do")
	public String selectUserConsult(HttpServletRequest request, EmfMap emfMap, ModelMap modelMap, @PathVariable int fcSeq) throws Exception
	{
		try
		{
			emfMap.put("fcseq", fcSeq);
			String domain = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
			EmfMap rtnMap = fairService.selectList(emfMap);
			EmfMap cateMap = fairService.selectCateList(new EmfMap());
			modelMap.addAttribute("rtnMap", rtnMap);
			modelMap.addAttribute("cateMap", cateMap);
			modelMap.addAttribute("formMap", emfMap);
			modelMap.addAttribute("domain", domain);
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		} 	
		return "mngwserc/fair/FairUserConsult.admin";
	}
	
	/**
	 * 협력업체용 상세 조회
	 *
	 * @param EmfMap, ModelMap
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value="/consultdetail.do")
	public String selectUserConsultDetail(EmfMap emfMap, ModelMap modelMap) throws Exception 
    {
    	try
		{
			EmfMap rtnMap = fairService.select(emfMap);
			modelMap.addAttribute("rtnMap", rtnMap);
			
//    		EmfMap memoMap = fairService.selectMemo(emfMap);
//    		modelMap.addAttribute("memoMap", memoMap);
		}
    	catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}
    	
    	return "mngwserc/fair/FairUserConsultDetail.admin";
    }
	
	/**
	 * 목록 다운
	 *
	 * @param EmfMap, ModelMap
	 * @return String
	 * @throws Exception
	 */
//	@RequestMapping(value="/excel.do") /*BLOCK_EXCEL*/
	public String selectUserExcel(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		try
		{		
			EmfMap rtnMap = fairService.selectListExcel(emfMap);
			
			ObjectMapper mapper = new ObjectMapper();
			
			List<EmfMap> list = (List<EmfMap>) rtnMap.get("list");
			List<String> titleTd = new ArrayList<String>();
			for(int i = 0; i < list.size(); i++)
			{
				EmfMap row = list.get(i);
				FairUserJson userInput = mapper.readValue(row.getString("fupValue"), FairUserJson.class);
				List<EmfMap> INPUT = new ArrayList<EmfMap>();
				
				for(userInput input : userInput.INPUT)
				{
					EmfMap iMap = new EmfMap();
					iMap.put("TITLE", input.TITLE);
					iMap.put("KEY", input.KEY);
					iMap.put("VALUE", input.VALUE);
					
					INPUT.add(iMap);
					
					if(!titleTd.contains(input.TITLE))
					{
						titleTd.add(input.TITLE);
					}
				}
				row.put("INPUT", INPUT);
				
				EmfMap BENEFIT = new EmfMap();
				BENEFIT.put("FB_SEQ", userInput.BENEFIT.FB_SEQ);
				BENEFIT.put("FB_TITLE", userInput.BENEFIT.FB_TITLE);
				BENEFIT.put("FB_SUBTITLE", userInput.BENEFIT.FB_SUBTITLE);
				BENEFIT.put("FB_MODEL", userInput.BENEFIT.FB_MODEL);
				BENEFIT.put("FB_PRICE", userInput.BENEFIT.FB_PRICE);
				BENEFIT.put("FB_IMAGE_W_PATH", userInput.BENEFIT.FB_IMAGE_W_PATH);
				BENEFIT.put("FB_IMAGE_W_SAVE_NM", userInput.BENEFIT.FB_IMAGE_W_SAVE_NM);
				BENEFIT.put("FB_IMAGE_W_REAL_NM", userInput.BENEFIT.FB_IMAGE_W_REAL_NM);
				row.put("BENEFIT", BENEFIT);
				
				row.put("PRICE", userInput.PRICE);
				
				EmfMap memoMap = new EmfMap();
				memoMap.put("fupSeq", row.getString("fupSeq"));
				row.put("memoList", fairService.selectMemo(memoMap));
			}
			rtnMap.put("titleTd", titleTd);
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
		return "mngwserc/fair/FairUserExcel";
	}
	
	/**
	 * 상세 조회
	 *
	 * @param EmfMap, ModelMap
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value="/detail.do")
	public String selectUserDetail(EmfMap emfMap, ModelMap modelMap) throws Exception 
    {
    	try
		{
			EmfMap rtnMap = fairService.select(emfMap);
			modelMap.addAttribute("rtnMap", rtnMap);
			
//    		EmfMap memoMap = fairService.selectMemo(emfMap);
//    		modelMap.addAttribute("memoMap", memoMap);
		}
    	catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}
    	
    	return "mngwserc/fair/FairUserDetail.admin";
    }
	
	/**
	 * 메모 조회
	 *
	 * @param EmfMap, ModelMap
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value="/memoselect.do")
	public String selectMemo(EmfMap emfMap, ModelMap modelMap) throws Exception 
    {
    	try
		{
    		EmfMap rtnMap = fairService.selectMemo(emfMap);
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
    	
    	return "mngwserc/fair/FairUserMemo";
    }
	
	/**
     * 등록 or 수정
     * 
     * @param EmfMap
	 * @return String
	 * @throws Exception
     */
	@RequestMapping(value="/memo_insert.ajax", method=RequestMethod.POST)
    public ModelAndView insertMemo(EmfMap emfMap) throws Exception 
    {
    	try
		{
			fairService.insertMemo(emfMap);
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
     * 메모삭제
     * 
     * @param EmfMap
	 * @return String
	 * @throws Exception
     */
	@RequestMapping(value="/memo_delete.ajax", method=RequestMethod.POST)
    public ModelAndView deleteMemo(EmfMap emfMap) throws Exception 
    {
    	try
		{
			fairService.deleteMemo(emfMap);
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
	@RequestMapping(value="/delete.ajax", method=RequestMethod.POST)
	public ModelAndView delete(EmfMap emfMap) throws Exception 
    {
    	try
		{
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
    	
    	ModelAndView mav = new ModelAndView();
    	mav.addObject("result", "OK");
		mav.setViewName("jsonView");

		return mav; 
    }
	
	/**
     * 상태 수정
     * 
     * @param EmfMap
	 * @return String
	 * @throws Exception
     */
	@RequestMapping(value="/status_change.ajax", method=RequestMethod.POST)
    public ModelAndView statusChange(EmfMap emfMap) throws Exception 
    {
    	try
		{
			fairService.statusChange(emfMap);
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
	 * 목록 조회 - 콜센터
	 *
	 * @param EmfMap, ModelMap
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value="/call.do")
	public String selectUserCall(HttpServletRequest request, EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		try
		{
			String domain = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
			emfMap.put("fairStatus", "RECORD");
			EmfMap rtnMap = fairService.selectListCall(emfMap);
			EmfMap cateMap = fairService.selectCateList(new EmfMap());
			modelMap.addAttribute("rtnMap", rtnMap);
			modelMap.addAttribute("cateMap", cateMap);
			modelMap.addAttribute("formMap", emfMap);
			modelMap.addAttribute("domain", domain);
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		} 	
		return "mngwserc/fair/FairUserConsultCall.admin";
	}
}