package mngwserc.cm.cmd.web;

import javax.annotation.Resource;   

import mngwserc.cm.cmd.service.CMDMbspCardService;

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
 * 멤버십카드신청 내역 관리를 위한 Controller
 * </pre>
 * 
 * @ClassName		: CMDMbspCardController
 * @Description		: 멤버십카드신청 내역 관리를 위한 Controller
 * @author 허진영
 * @since 2016.02.11
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author				   description
 *   ===========    ==============    =============================
 *    2016.02.11		허진영					 최초생성
 * </pre>
 */
@Controller
@RequestMapping("/mngwserc/cmd")
public class CMDMbspCardController extends EmfController {
	
	/** 서비스 **/
	@Resource(name="cMDMbspCardService")
    private CMDMbspCardService cMDMbspCardService;
	
	/**
	 * 멤버십카드신청 내역 목록을 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/list.do")
	public String selectMbspCardList(EmfMap emfMap,  ModelMap modelMap) throws Exception
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
			EmfMap rtnMap = cMDMbspCardService.selectMbspCardList(emfMap);
			
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
		
		return "mngwserc/cm/cmd/CMDMbspCardList.admin";
	}
	
	/**
	 * 멤버십카드신청 내역 상세를 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/write.do")
	public String selectMbspCard(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		try
		{
			String prcsCd = emfMap.getString("prcsCd");
			
			EmfMap rtnMap = cMDMbspCardService.selectMbspCard(emfMap);
			
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

		return "mngwserc/cm/cmd/CMDMbspCardWrite.admin";
	}
	
	/**
	 * 멤버십카드신청 내역을 수정한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	public String updateMbspCard(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		try
		{
			modelMap.addAttribute("f", emfMap.getString("f"));
			modelMap.addAttribute("q", emfMap.getString("q"));
			modelMap.addAttribute("prcsCd", emfMap.getString("sPrcsCd"));
			modelMap.addAttribute("strtDt", emfMap.getString("strtDt"));
			modelMap.addAttribute("endDt", emfMap.getString("endDt"));
			modelMap.addAttribute("pageIndex", emfMap.getString("pageIndex"));
			
			cMDMbspCardService.updateMbspCard(emfMap);
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
	 * 멤버십카드신청 내역 처리현황을 수정한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/prcs-update.ajax", method=RequestMethod.POST)
	public ModelAndView updateMbspCardPrcsCd(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		
		try
		{
			cMDMbspCardService.updateMbspCardPrcsCd(emfMap);
			
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
	 * 멤버십카드신청 내역 처리현황을 일괄 수정한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/prcsAll-update.ajax", method=RequestMethod.POST)
	public ModelAndView updateMbspCardPrcsCdAll(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		
		try
		{
			cMDMbspCardService.updateMbspCardPrcsCdAll(emfMap);
			
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
	 * 멤버십카드신청 내역 목록을 조회한다. (엑셀 다운로드)
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/excel.do")
	public String excelMbspCardList(EmfMap emfMap,  ModelMap modelMap) throws Exception
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
			modelMap.addAttribute("excelList", cMDMbspCardService.excelMbspCardList(emfMap));
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		} 
		
		return "mngwserc/cm/cmd/CMDMbspCardExcel";
	}
}
