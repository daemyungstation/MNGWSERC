package mngwserc.cm.cmf.web;

import javax.annotation.Resource;

import mngwserc.cm.cmf.service.CMFChkReqnService;

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
 * 확인요청 내역 관리를 위한 Controller
 * </pre>
 * 
 * @ClassName		: CMFChkReqnController.java
 * @Description		: 확인요청 내역 관리를 위한 Controller
 * @author 허진영
 * @since 2016.02.11
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2016.02.11		허진영					 최초생성
 * </pre>
 */
@Controller
@RequestMapping("/mngwserc/cmf")
public class CMFChkReqnController extends EmfController {

	/** 서비스 **/
	@Resource(name="cMFChkReqnService")
    private CMFChkReqnService cMFChkReqnService;
	
	/**
	 * 확인요청 내역 목록을 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/list.do")
	public String selectChkReqnList(EmfMap emfMap,  ModelMap modelMap) throws Exception
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
			EmfMap rtnMap = cMFChkReqnService.selectChkReqnList(emfMap);
			
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
		
		return "mngwserc/cm/cmf/CMFChkReqnList.admin";
	}
	
	/**
	 * 확인요청 내역을 삭제한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/delete.do", method=RequestMethod.POST)
	public String deleteChkReqnList(EmfMap emfMap, ModelMap modelMap, @RequestParam(value="delSeq", required=true) int[] delSeq) throws Exception
	{
		try
		{
			cMFChkReqnService.deleteChkReqnList(delSeq);
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}
		
		return "redirect:/mngwserc/cmf/list.do";
	}
	
	/**
	 * 확인요청 내역 처리현황을 수정한다.
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
			cMFChkReqnService.updateChkReqnPrcsCd(emfMap);
			
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
	 * 확인요청 내역 처리현황을 수정한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/prcs-update-all.ajax", method=RequestMethod.POST)
	public ModelAndView updateChkReqnPrcsCdAll(EmfMap emfMap, ModelMap modelMap, @RequestParam(value="delSeq", required=false) int[] delSeq) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		
		try
		{
			emfMap.put("delSeq", delSeq);
			cMFChkReqnService.updateChkReqnPrcsCd(emfMap);
			
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
