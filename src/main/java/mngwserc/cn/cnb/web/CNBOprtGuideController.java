package mngwserc.cn.cnb.web;

import java.io.FileNotFoundException;

import javax.annotation.Resource;

import mngwserc.cn.cna.GetAllMapValue;
import mngwserc.cn.cnb.service.CNBOprtGuideService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import emf.core.exception.EmfException;
import emf.core.extend.web.EmfController;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 이용안내 관리를 위한 Controller
 * </pre>
 * 
 * @ClassName		: CNBOprtGuideController.java
 * @Description		: 이용안내 관리를 위한 Controller
 * @author 허진영
 * @since 2016.02.12
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author				   description
 *    ==========    ==============    =============================
 *    2016.02.12		허진영				    최초 생성
 * </pre>
 */ 

@Controller
@RequestMapping(value="/mngwserc/cnb/{oprtGuideGb}")
public class CNBOprtGuideController extends EmfController {

	@Resource(name="cNBOprtGuideService")
	private CNBOprtGuideService cNBOprtGuideService;
    
	/**
     * 이용안내 목록을 조회한다.
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
    @RequestMapping(value="/list.do")
    public String selectOprtGuideList(EmfMap emfMap, ModelMap modelMap, @PathVariable String oprtGuideGb) throws Exception
    {
    	if(!"piocm".equals(oprtGuideGb) && !"prsn".equals(oprtGuideGb) && !"trms".equals(oprtGuideGb))
    	{
    		throw new FileNotFoundException();
    	}
		
    	//검색어 체크
		String f = emfMap.getString("f");
		String q = emfMap.getString("q");	
		
		if(!"".equals(EMFStringUtil.nullConvert(q)) && q.length() <= 15)
		{
			emfMap.put("f", f);
			emfMap.put("q", q);
		}
		else
		{
			emfMap.put("f", "");
			emfMap.put("q", "");
		}
		
		try
		{
			emfMap.put("oprtGuideGb", oprtGuideGb);
			
			EmfMap rtnMap = cNBOprtGuideService.selectOprtGuideList(emfMap);
			
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
    	
    	return "mngwserc/cn/cnb/CNBOprtGuideList.admin";
    }
    
    /**
     * 이용안내 상세를 조회한다. (뷰 페이지)
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
    @RequestMapping(value="/view.do")
    public String getOprtGuideViewPage(EmfMap emfMap, ModelMap modelMap, @PathVariable String oprtGuideGb) throws Exception 
    {
    	if(!"piocm".equals(oprtGuideGb) && !"prsn".equals(oprtGuideGb) && !"trms".equals(oprtGuideGb))
    	{
    		throw new FileNotFoundException();
    	}
    	String url = "erorr/blank.error";
    		
		try
		{
			emfMap.put("oprtGuideGb", oprtGuideGb);
			
			EmfMap rtnMap = cNBOprtGuideService.selectOprtGuide(emfMap);
			
			//editor 플레그 값.
			if("Y".equals(EMFStringUtil.nullConvert(emfMap.get("editorView"))))
			{
				url = "mngwserc/cn/cnb/CNBOprtGuideEditorView";
			}
			else
			{
				url = "mngwserc/cn/cnb/CNBOprtGuideView.admin";
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
    	
		return url;   
    }
    
    /**
     * 이용안내 상세를 조회한다. (등록, 수정 페이지)
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
    @RequestMapping(value="/write.do")
    public String selectOprtGuide(EmfMap emfMap, ModelMap modelMap, @PathVariable String oprtGuideGb) throws Exception 
    {    	
    	if(!"piocm".equals(oprtGuideGb) && !"prsn".equals(oprtGuideGb) && !"trms".equals(oprtGuideGb))
    	{
    		throw new FileNotFoundException();
    	}
    	
    	try
		{
    		emfMap.put("oprtGuideGb", oprtGuideGb);
    		
			EmfMap rtnMap = cNBOprtGuideService.selectOprtGuide(emfMap);
			
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

    	return "mngwserc/cn/cnb/CNBOprtGuideWrite.admin";    	
    }
    
    /**
     * 이용안내를 등록한다.
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
    @RequestMapping(value="/insert.do", method=RequestMethod.POST)
    public String insertOprtGuide(EmfMap emfMap, ModelMap modelMap, @PathVariable String oprtGuideGb) throws Exception 
    {
    	if(!"piocm".equals(oprtGuideGb) && !"prsn".equals(oprtGuideGb) && !"trms".equals(oprtGuideGb))
    	{
    		throw new FileNotFoundException();
    	}
    	
    	try
		{
    		emfMap.put("oprtGuideGb", oprtGuideGb);
    		
//		    cNBOprtGuideService.insertOprtGuide(emfMap);
    		cNBOprtGuideService.iog(emfMap);
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
     * 이용안내를 수정한다.
     * 
     * @param EmfMap 검색데이터
     * @return String View URL
     * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
    @RequestMapping(value="/update.do", method=RequestMethod.POST)
    public String updateOprtGuide(EmfMap emfMap, ModelMap modelMap, @PathVariable String oprtGuideGb) throws Exception 
    {
    	if(!"piocm".equals(oprtGuideGb) && !"prsn".equals(oprtGuideGb) && !"trms".equals(oprtGuideGb))
    	{
    		throw new FileNotFoundException();
    	}
    	
    	try
		{
    		emfMap.put("oprtGuideGb", oprtGuideGb);
		    
//    		cNBOprtGuideService.updateOprtGuide(emfMap);
    		cNBOprtGuideService.uog(emfMap);
		}
    	catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}
    	
    	return "redirect:./view.do?oprtGuideSeq=" + emfMap.getString("oprtGuideSeq");    	
    }
    
    /**
	 * 이용안내를 삭제한다.
	 * 
	 * @param EmfMap 검색데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */	
	@RequestMapping(value="/delete.do", method=RequestMethod.POST)
	public String deleteOprtGuideList(EmfMap emfMap, ModelMap modelMap, @PathVariable String oprtGuideGb, @RequestParam(value="delSeq", required=true) int[] delSeq) throws Exception
	{
		if(!"piocm".equals(oprtGuideGb) && !"prsn".equals(oprtGuideGb) && !"trms".equals(oprtGuideGb))
    	{
    		throw new FileNotFoundException();
    	}
		
		try
		{
			emfMap.put("oprtGuideGb", oprtGuideGb);
			
//			cNBOprtGuideService.deleteOprtGuideList(delSeq);
			cNBOprtGuideService.dogl(delSeq);
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
	 * 이용안내를 복사한다.
	 * 
	 * @param EmfMap 검색데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */	
	@RequestMapping(value="/copy.do")
	public String insertOprtGuideCopy(EmfMap emfMap, ModelMap modelMap, @PathVariable String oprtGuideGb)throws Exception
	{
		if(!"piocm".equals(oprtGuideGb) && !"prsn".equals(oprtGuideGb) && !"trms".equals(oprtGuideGb))
    	{
    		throw new FileNotFoundException();
    	}
    	
		try 
		{
//			cNBOprtGuideService.insertOprtGuideCopy(emfMap);			
			cNBOprtGuideService.iogc(emfMap);			
		}
		catch (Exception he) {
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}
		
		return "redirect:./list.do";
	}
}
