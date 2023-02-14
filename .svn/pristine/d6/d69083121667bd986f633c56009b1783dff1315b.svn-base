package mngwserc.cm.cmb.web;

import javax.annotation.Resource;

import mngwserc.cm.cmb.service.CMBChngPrdctService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import emf.core.exception.EmfException;
import emf.core.extend.web.EmfController;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 전환서비스 상품관리를 위한 Controller
 * </pre>
 * 
 * @ClassName		: CMBChngPrdctController.java
 * @Description		: 전환서비스 상품관리를 위한 Controller
 * @author 김대환
 * @since 2016.02.17
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author				  description
 *   ===========    ==============    =============================
 *    2016.02.17		김대환				   최초 생성
 * </pre>
 */
@Controller
@RequestMapping("/mngwserc/cmb/prdct")
public class CMBChngPrdctController extends EmfController{
	
	/** 서비스 **/
	@Resource(name="cMBChngPrdctService")
	private CMBChngPrdctService cMBChngPrdctService;
	
	/**
     * 전환서비스 상품 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@RequestMapping(value="/list.do")
	public String selectChngPrdctList(EmfMap emfMap, ModelMap modelMap) throws Exception
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
			EmfMap rtnMap = cMBChngPrdctService.selectChngPrdctList(emfMap);

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
		
		return "mngwserc/cm/cmb/CMBChngPrdctList.admin";
	}
	
	/**
     * 전환서비스 상품 상세를 조회한다. (뷰 페이지)
     * 
     * @param EmfMap
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@RequestMapping(value="/view.do")
	public String getChngPrdctViewPage(EmfMap emfMap, ModelMap modelMap) throws Exception 
	{
		String url = "error/blank.error";
		
		try 
		{
			EmfMap rtnMap = cMBChngPrdctService.selectChngPrdct(emfMap);
			
			//editor 플레그 값.
			if("Y".equals(EMFStringUtil.nullConvert(emfMap.get("editorView"))))
			{
				url = "mngwserc/cm/cmb/CMBChngPrdctEditorView";
			}
			else
			{
				url = "mngwserc/cm/cmb/CMBChngPrdctView.admin";
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
     * 전환서비스 상품 상세를 조회한다. (등록, 수정 페이지)
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */  
	@RequestMapping(value="/write.do") 
	public String selectChngPrdct(EmfMap emfMap, ModelMap modelMap) throws Exception 
	{
		try 
		{
			EmfMap rtnMap = cMBChngPrdctService.selectChngPrdct(emfMap);

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
		
		return "mngwserc/cm/cmb/CMBChngPrdctWrite.admin";
	}
	
	/**
     * 전환서비스 상품을 등록한다.
     * 
     * @param EmfMap
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@RequestMapping(value="/insert.do", method=RequestMethod.POST)
	public String insertChngPrdct(EmfMap emfMap, ModelMap modelMap) throws Exception 
	{
		try 
		{
			cMBChngPrdctService.insertChngPrdct(emfMap);				
		} 	
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		} 	
 
		return "redirect:/mngwserc/cmb/prdct/list.do";
	}
	
	/**
     * 전환서비스 상품을 수정한다.
     * 
     * @param EmfMap
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	public String updateChngPrdct(EmfMap emfMap, ModelMap modelMap) throws Exception 
	{
		try 
		{
			cMBChngPrdctService.updateChngPrdct(emfMap);
		} 	
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		} 	
 
		return "redirect:/mngwserc/cmb/prdct/view.do?prdctSeq=" + emfMap.getString("prdctSeq");
	}

	/**
     * 전환서비스 상품을 삭제한다.
     * 
     * @param EmfMap
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@RequestMapping(value="/delete.do", method=RequestMethod.POST)
	public String deleteChngPrdct(EmfMap emfMap, ModelMap modelMap, @RequestParam(value="delSeq", required=true) int[] delSeq) throws Exception 
	{
		try 
		{
			cMBChngPrdctService.deleteChngPrdctList(delSeq);	
		} 	
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		} 	

		return "redirect:/mngwserc/cmb/prdct/list.do";
	}

    /**
	 * 전환서비스 상품을 복사한다.
	 * 
	 * @param EmfMap 검색데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */	
	@RequestMapping(value="/copy.do", method=RequestMethod.POST)
	public String insertChngPrdctCopy(EmfMap emfMap, ModelMap modelMap)throws Exception
	{
		try 
		{
			cMBChngPrdctService.insertChngPrdctCopy(emfMap);			
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}
		
		return "redirect:/mngwserc/cmb/prdct/list.do";
	}
}
