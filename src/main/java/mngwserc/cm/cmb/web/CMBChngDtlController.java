package mngwserc.cm.cmb.web;

import javax.annotation.Resource;

import mngwserc.cm.cmb.service.CMBChngDtlService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import egovframework.com.utl.fcc.service.EgovStringUtil;
import emf.core.exception.EmfException;
import emf.core.extend.web.EmfController;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 전환서비스 상세관리를 위한 Cotroller
 * </pre>
 * 
 * @ClassName		: CMBDtlMngController.java
 * @description		: 전환서비스 상세관리를 위한 Cotroller
 * @author 김대환
 * @since 2016. 02. 19.
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since							author								description
 *   ===========    ==============    =============================
 *   2016. 02. 19.					김대환								최초생성
 * </pre>
 */ 
@Controller
@RequestMapping("/mngwserc/cmb/dtl")
public class CMBChngDtlController extends EmfController{
	
	/** 서비스 **/
	@Resource(name="cMBChngDtlService")
	private CMBChngDtlService cMBChngDtlService;
	
	/**
     * 전환서비스 상품내역 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return String View URL
	 * @throws 비지니스 로직이나 dAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@RequestMapping(value="/list.do")
	public String selectChngDtlList(EmfMap emfMap, ModelMap modelMap) throws Exception
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
			EmfMap rtnMap = cMBChngDtlService.selectChngDtlList(emfMap);
					
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
		
		return "mngwserc/cm/cmb/CMBChngDtlList.admin";
	}
	
	 /**
     * 전환서비스 상품내역 상세를 조회한다. (뷰 페이지)
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 dAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */  
	@RequestMapping(value="/view.do") 
	public String getChngDtlViewPage(EmfMap emfMap, ModelMap modelMap) throws Exception 
	{
		String url = "error/blank.error";
		
		try 
		{
			EmfMap rtnMap = cMBChngDtlService.selectChngDtl(emfMap);
			
			//editor 플레그 값.
			if("Y".equals(EMFStringUtil.nullConvert(emfMap.get("editorView"))))
			{
				url = "mngwserc/cm/cmb/CMBChngDtlEditorView";
			}
			else
			{
				url = "mngwserc/cm/cmb/CMBChngDtlView.admin";
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
     * 전환서비스 상품내역 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return String View URL
	 * @throws 비지니스 로직이나 dAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@RequestMapping(value="/write.do")
	public String selectChngDtl(EmfMap emfMap, ModelMap modelMap) throws Exception 
	{
		try 
		{
			EmfMap rtnMap = cMBChngDtlService.selectChngDtl(emfMap);
				
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
		
		return "mngwserc/cm/cmb/CMBChngDtlWrite.admin";
	}
	
	/**
     * 전환서비스 상품내역을 등록한다.
     * 
     * @param EmfMap
	 * @return String View URL
	 * @throws 비지니스 로직이나 dAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@RequestMapping(value="/insert.do")
	public String insertChngDtl(EmfMap emfMap, ModelMap modelMap, MultipartHttpServletRequest multiRequest) throws Exception 
	{
		String url = "error/blank.error";
		
		try 
		{
			cMBChngDtlService.insertChngDtl(emfMap, multiRequest);
			
			url = "redirect:./list.do";
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
     * 전환서비스 상품내역을 수정한다.
     * 
     * @param EmfMap
	 * @return String View URL
	 * @throws 비지니스 로직이나 dAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@RequestMapping(value="/update.do")
	public String updateChngDtl(EmfMap emfMap, ModelMap modelMap, MultipartHttpServletRequest multiRequest) throws Exception 
	{
		String url = "error/blank.error";
		
		try 
		{
			cMBChngDtlService.updateChngDtl(emfMap, multiRequest);
			
			url = "redirect:./view.do?prdctDtlSeq=" + emfMap.getString("prdctDtlSeq");
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
     * 전환서비스 상세관리를 삭제한다.
     * 
     * @param EmfMap
	 * @return String View URL
	 * @throws 비지니스 로직이나 dAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@RequestMapping("/delete.do")
	public String deleteChngDtlList(EmfMap emfMap, ModelMap modelMap, @RequestParam(value="delSeq", required=true) int[] delSeq) throws Exception 
	{
		try 
		{
			cMBChngDtlService.deleteChngDtlList(delSeq);	
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
	 * 전환서비스 상품내역을 복사한다.
	 * 
	 * @param EmfMap 검색데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 dAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */	
	@RequestMapping(value="/copy.do")
	public String insertChngDtlCopy(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		try 
		{
			cMBChngDtlService.insertChngDtlCopy(emfMap);			
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
     * 전환서비스 상세관리를 블라인드 설정한다.
     * 
     * @param EmfMap
	 * @return String View URL
	 * @throws 비지니스 로직이나 dAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@RequestMapping("/blind.ajax")
	public ModelAndView updateChngDtlBlind(EmfMap emfMap, ModelMap modelMap, @RequestParam(value="delSeq", required=true) int[] delSeq) throws Exception 
	{
		ModelAndView mav = new ModelAndView();
		
		try 
		{
			emfMap.put("delSeq", delSeq);
			
			cMBChngDtlService.updateChngDtlBlind(emfMap);
			
			mav.addObject("status", "Y");
			
			mav.setViewName("jsonView");
		} 	
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		} 	

		return mav;
	}
}
