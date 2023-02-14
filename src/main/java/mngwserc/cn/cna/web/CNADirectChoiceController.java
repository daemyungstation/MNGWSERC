package mngwserc.cn.cna.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mngwserc.cn.cna.CNAFileUtil;
import mngwserc.cn.cna.service.CNADirectChoiceService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import emf.core.exception.EmfException;
import emf.core.extend.web.EmfController;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 다이렉트 채널 > 컨텐츠 관리 > 다이렉트초이스를 위한 Controller
 * </pre>
 * 
 * @ClassName		: CNADirectChoiceController.java
 * @Description		: 다이렉트 초이스를 위한 Controller
 * @author 박주윤
 * @since 2018.02.22
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2018.04.10		박주윤					 최초생성
 * </pre>
 */

@Controller
@RequestMapping(value="/mngwserc/cna/direct")
public class CNADirectChoiceController extends EmfController {

	@Resource(name = "cNADirectChoiceService")
	private CNADirectChoiceService cNADirectChoiceService;
	
	private final static String gubun = "direct";
	
	/**
	 * 다이렉트 초이스를 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value={"/list.do"})
	public String selectDirectChoiseList(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
    	//검색어 체크
		String f1 = emfMap.getString("f1");
		String f2 = emfMap.getString("f2");
		String q = emfMap.getString("q");	
		
		if(!"".equals(EMFStringUtil.nullConvert(q)) && q.length() <= 15)
		{
			emfMap.put("f1", f1);
			emfMap.put("f2", f2);
			emfMap.put("q", q);
		}
		else
		{
			emfMap.put("f1", "");
			emfMap.put("q", "");
		}
		
		try
		{
			emfMap.put("gubun", gubun);

			EmfMap rtnMap = cNADirectChoiceService.selectDirectChoiList(emfMap);
			
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
    	
		return "mngwserc/cn/cna/CNADirectChoiList.admin";
	}
	
   /**
    * 다이렉트 초이스를 등록한다.
    * 
    * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
    */   
   @RequestMapping(value="/insert.do", method=RequestMethod.POST)
   public String insertZeroChoise(EmfMap emfMap, ModelMap modelMap, HttpServletRequest request) throws Exception 
   {
	   	try
			{
		   		emfMap.put("gubun", gubun);
		   		emfMap.put("request", request);
		   		
		   		/*insertDirectChoiceInfo*/
		   		cNADirectChoiceService.idci(emfMap);
			}
	   	catch (Exception he) 
			{
				if (log.isDebugEnabled()) 
				{
					log.debug(he);
	           }
				throw new EmfException(he.getMessage());
			}
	   	
	   	return "redirect:./list.do";    	
   }
   
	/**
	 * 다이렉트  상세를 조회한다. (뷰 페이지)
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */    
	@RequestMapping(value="/view.ajax")
	public ModelAndView getZeroChoiseViewPage(EmfMap emfMap) throws Exception 
	{
		EmfMap rtnMap = null;
			
		try
		{
				rtnMap = cNADirectChoiceService.selectDirectChoice(emfMap);
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
		mav.addObject("data", rtnMap);
		mav.setViewName("jsonView");
		
		return mav;
	}
	
    /**
     * 다이렉트 초이스를 수정한다.
     * 
     * @param EmfMap 검색데이터
     * @return String View URL
     * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
    @RequestMapping(value="/update.do", method=RequestMethod.POST)
    public String updateDirectChoise(EmfMap emfMap, HttpServletRequest request) throws Exception 
    {
    	try
		{
    		emfMap.put("request", request);
    		emfMap.put("gubun", gubun);
    		
    		/*updateDirectChoise*/
    		cNADirectChoiceService.udc(emfMap);
		}
    	catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}
    	
    	return "redirect:./list.do";
    }
    
    /**
 	 *  다이렉트 초이스를 삭제한다.
 	 * 
 	 * @param EmfMap 검색데이터
 	 * @return String View URL
 	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
 	 */	
 	@RequestMapping(value="/delete.do", method=RequestMethod.POST)
 	public String deleteZeroChoiseList(EmfMap emfMap, @RequestParam(value="delSeq", required=true) int[] delSeq) throws Exception
 	{
     	try
 		{
     		emfMap.put("delSeq", delSeq);

// 			cNADirectChoiceService.deleteDirectChoiseList(delSeq);
     		cNADirectChoiceService.ddcl(emfMap);
 		}
 		catch (Exception he) 
 		{
 			if (log.isDebugEnabled()) 
 			{
 				log.debug(he);
             }
 			throw new EmfException(he.getMessage());
 		}
 		
 		return "redirect:./list.do";
 	}
 	
    /**
     * 다이렉트 초이스 미리보기 상세를 조회한다.
     * 
     * @param EmfMap 검색할 데이터
     * @return String View URL
     * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
	@RequestMapping(value={"/previewImg.do"})
	public void previewImgFile(EmfMap emfMap, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String fileSeq = request.getParameter("fileSeq");
		emfMap.put("fileSeq", fileSeq);
		
		EmfMap fvo = cNADirectChoiceService.selectFileInfoByFileSeq(emfMap);
		
		CNAFileUtil.getImageInf(fvo, response);
	}
}