package mngwserc.cm.cmb.web;

import javax.annotation.Resource;

import mngwserc.cm.cmb.service.CMBChngRqstService;

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
 * 전환서비스 신청 관리를 위한 Controller
 * </pre>
 * 
 * @ClassName		: CMBChngRqstContoller.java
 * @Description		: 전환서비스 신청 관리를 위한 Controller
 * @author 허진영
 * @since 2016.03.24
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2016.03.24		허진영					 최초생성
 * </pre>
 */
@Controller
@RequestMapping("/mngwserc/cmb/rqst")
public class CMBChngRqstContoller extends EmfController {

	/** 서비스 **/
	@Resource(name="cMBChngRqstService")
    private CMBChngRqstService cMBChngRqstService;
	
	/**
	 * 전환서비스 신청 목록을 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/list.do")
	public String selectChngRqstList(EmfMap emfMap, ModelMap modelMap) throws Exception
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
			EmfMap rtnMap = cMBChngRqstService.selectChngRqstList(emfMap);
			
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
		
		return "mngwserc/cm/cmb/CMBChngRqstList.admin";
	}
	
	/**
	 * 전환서비스 신청 상세를 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/write.do")
	public String selectChngRqst(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		try
		{
			String prcsCd = emfMap.getString("prcsCd");
			
			EmfMap rtnMap = cMBChngRqstService.selectChngRqst(emfMap);
			
			modelMap.addAttribute("sPrcsCd", prcsCd);
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

		return "mngwserc/cm/cmb/CMBChngRqstWrite.admin";
	}
	
	/**
	 * 전환서비스 신청을 수정한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	public String updateChngRqst(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		try
		{
			modelMap.addAttribute("f", emfMap.getString("f"));
			modelMap.addAttribute("q", emfMap.getString("q"));
			modelMap.addAttribute("prcsCd", emfMap.getString("sPrcsCd"));
			modelMap.addAttribute("pageIndex", emfMap.getString("pageIndex"));
			
			cMBChngRqstService.updateChngRqst(emfMap);
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}
		
		return "redirect:./write.do?rqstSeq=" + emfMap.getString("rqstSeq");
	}
	
	/**
	 * 전환서비스 신청을 삭제한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/delete.do", method=RequestMethod.POST)
	public String deleteChngRqstList(EmfMap emfMap, ModelMap modelMap, @RequestParam(value="delSeq", required=true) int[] delSeq) throws Exception
	{
		try
		{
			cMBChngRqstService.deleteChngRqstList(delSeq);
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
	 * 전환서비스 신청 처리현황을 수정한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/prcs-update.ajax", method=RequestMethod.POST)
	public ModelAndView updateChkReqnPrcsCd(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		
		try
		{
			cMBChngRqstService.updateChngRqstPrcsCd(emfMap);
			
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
	
	/**
	 * 전환서비스 신청 목록을 조회한다. (엑셀 다운로드)
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/excel.do")
	public String excelChngRqstList(EmfMap emfMap, ModelMap modelMap) throws Exception
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
			modelMap.addAttribute("excelList", cMBChngRqstService.excelChngRqstList(emfMap));
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		} 
		
		return "mngwserc/cm/cmb/CMBChngRqstExcel";
	}
}
