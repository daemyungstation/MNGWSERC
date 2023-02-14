package mngwserc.co.coh.web;

import java.io.FileNotFoundException;

import javax.annotation.Resource;

import mngwserc.co.coh.service.COHBoardMngService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.com.cmm.service.EgovCmmUseService;
import emf.core.exception.EmfException;
import emf.core.extend.web.EmfController;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 게시판 관리를 위한 Controller
 * </pre>
 * 
 * @ClassName		: COHBoardMngController.java
 * @Description		: 게시판 관리를 위한 Controller
 * @author 김필기
 * @since 2015. 11. 17.
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2015. 11. 17.		김필기					최초생성
 * </pre>
 */

@Controller
@RequestMapping(value="/mngwserc/coh")
public class COHBoardMngController extends EmfController {
	
	@Resource(name="cOHBoardMngService")
	private COHBoardMngService cOHBoardMngService;
	
    @Resource(name = "EgovCmmUseService")
    private EgovCmmUseService cmmUseService;
	
    /**
     * 게시판 관리 목록으로 이동.
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@RequestMapping(value="/index.do")
    public String selectBoardConfigList(EmfMap emfMap, ModelMap modelMap) throws Exception 
    {
		String url = "";
		
		//게시글 복사에 따른 게시판 카테고리 페이지
		if(!"".equals(EMFStringUtil.nullConvert(emfMap.getString("isView"))))
		{
			url = "mngwserc/co/coh/COHBoardMngCategoryBoard";
		}
		else
		{
			url = "mngwserc/co/coh/COHBoardMngList.admin";
		}
				
		try
		{
			EmfMap rtnMap = cOHBoardMngService.selectBoardConfigList(emfMap);
			
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
		
    	return url;
    }
    
    /**
     * 게시판 등록 페이지로 이동한다.
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@RequestMapping(value="/write.do")   
    public String selectBoardConfig(EmfMap emfMap, ModelMap modelMap) throws Exception 
    {
		try
		{	
			EmfMap rtnMap = cOHBoardMngService.selectBoardConfig(emfMap);
			
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
		
    	return "mngwserc/co/coh/COHBoardMngWrite.admin";
    }
    
    /**
     * 게시판내용을 등록 및 수정한다.
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@RequestMapping(value="/action.do", method=RequestMethod.POST)
    public String actionBoardConfig(EmfMap emfMap, ModelMap modelMap) throws Exception 
    {	
    	try
    	{
    		if("".equals(EMFStringUtil.nullConvert(emfMap.getString("communityId"))))		
    		{
    			cOHBoardMngService.insertBoardConfig(emfMap);
    		}
    		else
    		{
    			cOHBoardMngService.updateBoardConfig(emfMap);
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

		return "redirect:/mngwserc/coh/index.do";
    }
       
    /**
     *	게시판의 상단 및 하단 배너 설정을 한다. 
     *
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@RequestMapping(value="/banner.do")
    public String selectBannerConfig(EmfMap emfMap, ModelMap modelMap, @RequestParam(value="communityId", required=true) String communityId) throws Exception 
    {	
    	try
    	{
    		emfMap.put("communityId", communityId);
    		
    		EmfMap rtnMap = cOHBoardMngService.selectBoardConfig(emfMap);
    		
    		if(rtnMap.get("boardInfo") == null)
    		{
    			throw new FileNotFoundException("");
    		}
    		
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
    	
		return "mngwserc/co/coh/COHBoardMngBanner.admin";
    }    
    
    /**
     * 게시판의 상단 및 하단 배너 설정을 업데이트한다.
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@RequestMapping(value="/bannerAction.do", method=RequestMethod.POST)
    public String updateBannerConfig(EmfMap emfMap, ModelMap modelMap) throws Exception 
    {	
    	try
    	{
    		cOHBoardMngService.updateBanrConfig(emfMap);
    	}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		} 	
    	
		return "redirect:/mngwserc/coh/index.do";
    }

    /**
     * 게시판 복사
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@RequestMapping(value="/copy.do")
    public String insertBoardConfigCopy(EmfMap emfMap, ModelMap modelMap, @RequestParam(value="communityId", required=true) String communityId) throws Exception 
    {	
    	try
    	{
    		emfMap.put("communityId", communityId);
    		
    		EmfMap rtnMap = cOHBoardMngService.selectBoardConfig(emfMap);
    		
    		if(rtnMap.get("boardInfo") != null)
    		{
    			cOHBoardMngService.insertBoardConfigCopy((EmfMap) rtnMap.get("boardInfo"));
    		}
    		else
    		{
    			throw new FileNotFoundException();
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
    	
		return "redirect:/mngwserc/coh/index.do";
    }

    /**
     * 게시판 관리 있는 리스트를 비동기로 가져온다.
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@RequestMapping(value="/list.ajax")
    public String getBoardConfigList(EmfMap emfMap, ModelMap modelMap) throws Exception 
    {
		try
		{
			EmfMap rtnMap = cOHBoardMngService.selectBoardConfigList(emfMap);
			
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
		
    	return "mngwserc/co/coh/COHBoardMngCategoryBoard";
    }    
}