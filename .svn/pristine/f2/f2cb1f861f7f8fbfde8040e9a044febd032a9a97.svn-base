package mngwserc.cm.cmc.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import mngwserc.cm.cmc.service.CMCPfmcRsvtnService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import emf.core.exception.EmfException;
import emf.core.extend.web.EmfController;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 공연예약 관리를 위한 Controller
 * </pre>
 * 
 * @ClassName		: CMCPfmcRsvtnController.java
 * @Description		: 공연예약 관리 위한 Controller
 * @author 허진영
 * @since 2016.02.18
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2016.02.18		허진영					 최초생성
 * </pre>
 */
@Controller
@RequestMapping("/mngwserc/cmc/rsvtn")
public class CMCPfmcRsvtnController extends EmfController {
	
	/** 서비스 **/
	@Resource(name="cMCPfmcRsvService")
    private CMCPfmcRsvtnService cMCPfmcRsvService;
	
	/**
	 * 공연예약 리스트를 조회한다. 
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/list.do")
	public String selectPfmcRsvtnList(EmfMap emfMap, ModelMap modelMap, HttpServletRequest request) throws Exception
	{
		//검색어 체크
		String f = emfMap.getString("f");
		String q = emfMap.getString("q");	
		
		if(!"".equals(q) && q.length() <= 15)
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
			EmfMap rtnMap = cMCPfmcRsvService.selectPfmcRsvtnList(emfMap);
			
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

		return "mngwserc/cm/cmc/CMCPfmcRsvtnList.admin";
	}
	
	/**
	 * 공연예약 상세를 조회한다. 
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/write.do")
	public String selectPfmcRsvtn(EmfMap emfMap, ModelMap modelMap, HttpServletRequest request) throws Exception
	{
		try
		{
			String prcsCd = emfMap.getString("prcsCd");
			
			EmfMap rtnMap = cMCPfmcRsvService.selectPfmcRsvtn(emfMap);
			
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

		return "mngwserc/cm/cmc/CMCPfmcRsvtnWrite.admin";
	}
	
	/**
	 * 공연예약을 수정한다. 
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	public String updatePfmcRsvtn(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		try
		{
			modelMap.addAttribute("f", emfMap.getString("f"));
			modelMap.addAttribute("q", emfMap.getString("q"));
			modelMap.addAttribute("prcsCd", emfMap.getString("sPrcsCd"));
			modelMap.addAttribute("strtDt", emfMap.getString("strtDt"));
			modelMap.addAttribute("endDt", emfMap.getString("endDt"));
			modelMap.addAttribute("pageIndex", emfMap.getString("pageIndex"));
			
			cMCPfmcRsvService.updatePfmcRsvtn(emfMap);
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}

		return "redirect:./write.do?rsvtnSeq=" + emfMap.getString("rsvtnSeq");
	}
	
	/**
	 * 공연예약을 삭제한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/delete.do", method=RequestMethod.POST)
	public String deletePfmcRsvtnList(EmfMap emfMap, ModelMap modelMap, @RequestParam(value="delSeq", required=true) int[] delSeq) throws Exception
	{
		try
		{
			cMCPfmcRsvService.deletePfmcRsvtnList(delSeq);
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
	 * 공연예약 목록을 조회한다. (엑셀다운로드)
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/excel.do")
	public String excelPfmcRsvtnList(EmfMap emfMap, ModelMap modelMap, HttpServletRequest request) throws Exception
	{
		//검색어 체크
		String f = emfMap.getString("f");
		String q = emfMap.getString("q");	
		
		if(!"".equals(q) && q.length() <= 15)
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
			modelMap.addAttribute("excelList", cMCPfmcRsvService.excelPfmcRsvtnList(emfMap));
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		} 
		
		return "mngwserc/cm/cmc/CMCPfmcRsvtnExcel";
	}
	
	/**
     * 공연예약 상담이력을 등록한다.
     * 
     * @param EmfMap
	 * @return String View URL
	 * @throws 비지니스 로직이나 dAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@RequestMapping("/cnsl-insert.ajax")
	public ModelAndView insertPfmcRsvtnCnsl(EmfMap emfMap, ModelMap modelMap) throws Exception 
	{
		ModelAndView mav = new ModelAndView();
		
		try 
		{
			cMCPfmcRsvService.insertPfmcRsvtnCnsl(emfMap);
			
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
     * 공연예약 담당자 확인을 수정한다.
     * 
     * @param EmfMap
	 * @return String View URL
	 * @throws 비지니스 로직이나 dAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@RequestMapping("/conf-update.ajax")
	public ModelAndView updatePfmcRsvtnConf(EmfMap emfMap, ModelMap modelMap) throws Exception 
	{
		ModelAndView mav = new ModelAndView();
		
		try 
		{
			cMCPfmcRsvService.updatePfmcRsvtnConf(emfMap);
			
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