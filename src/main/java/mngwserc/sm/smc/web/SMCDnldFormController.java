package mngwserc.sm.smc.web;

import javax.annotation.Resource;

import mngwserc.sm.smc.service.SMCDnldFormService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import egovframework.com.utl.fcc.service.EgovStringUtil;
import emf.core.exception.EmfException;
import emf.core.extend.web.EmfController;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 다운로드 양식 관리를 위한 Controller
 * </pre>
 * 
 * @ClassName		: SMCDnldFormController.java
 * @Description		: 다운로드 양식 관리를 위한 Controller
 * @author 허진영
 * @since 2016.03.30
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author				   description
 *    ==========    ==============    =============================
 *    2016.03.30		허진영					최초 생성
 * </pre> 
 */
@Controller
@RequestMapping("/mngwserc/smc/form")
public class SMCDnldFormController extends EmfController {
	
	/**서비스**/
	@Resource(name="sMCDnldFormService")
    private SMCDnldFormService sMCDnldFormService;
	
	/**
     * 다운로드 양식 목록을 조회한다.
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
    @RequestMapping(value="/list.do")
    public String selectDnldFormList(EmfMap emfMap, ModelMap modelMap) throws Exception
    {
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
			EmfMap rtnMap = sMCDnldFormService.selectDnldFormList(emfMap);
			
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
    	
    	return "mngwserc/sm/smc/SMCDnldFormList.admin";
    }
    
    /**
     * 다운로드 양식 상세를 조회한다.
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
    @RequestMapping(value="/write.do")
    public String writeDnldForm(EmfMap emfMap, ModelMap modelMap) throws Exception 
    {    
    	try
		{
			EmfMap rtnMap = sMCDnldFormService.selectDnldForm(emfMap);
			
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

    	return "mngwserc/sm/smc/SMCDnldFormWrite.admin";
    }
    
    /**
     * 다운로드 양식을 등록한다.
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
    @RequestMapping(value="/insert.do", method=RequestMethod.POST)
    public String insertDnldForm(MultipartHttpServletRequest multiRequest, EmfMap emfMap, ModelMap modelMap) throws Exception 
    {
    	String url = "error/blank.error";
    	
    	try
		{
		    sMCDnldFormService.insertDnldForm(multiRequest, emfMap);
		    
		    url =  "redirect:./list.do";
		}
		catch(Exception he)
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			
			if("파일용량초과".equals(EgovStringUtil.nullConvert(he.getMessage())))
			{
				modelMap.addAttribute("msg", "파일 용량이 초과되었습니다.");
				modelMap.addAttribute("url", "javascript:history.back();");
			}
			else
			{
				throw new EmfException(he.getMessage());
			}
		}
    	
    	return url;
    }
    
    /**
     * 다운로드 양식을 수정한다.
	 *
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
    @RequestMapping(value="/update.do", method=RequestMethod.POST)
    public String updateDnldForm(MultipartHttpServletRequest multiRequest, EmfMap emfMap, ModelMap modelMap) throws Exception 
    {
    	String url = "error/blank.error";
		try
		{
			sMCDnldFormService.updateDnldForm(multiRequest, emfMap);
			
			url = "redirect:./write.do?dnldFormSeq=" + emfMap.getString("dnldFormSeq");
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }

			if("파일용량초과".equals(EgovStringUtil.nullConvert(he.getMessage())))
			{
				modelMap.addAttribute("msg", "파일 용량이 초과되었습니다.");
				modelMap.addAttribute("url", "javascript:history.back();");
			}
			else
			{
				throw new EmfException(he.getMessage());
			}
		}
    	
		return url; 
    }
    
    /**
	 * 다운로드 양식을 삭제한다. 
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */	
    @RequestMapping(value="/delete.do", method=RequestMethod.POST)
	public String deleteDnldFormList(EmfMap emfMap, ModelMap modelMap, @RequestParam(value="delSeq", required=true) int[] delSeq) throws Exception
    {
    	try
		{
    		sMCDnldFormService.deleteDnldFormList(delSeq);
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
}
