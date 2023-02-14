package mngwserc.cs.csa.web;

import java.util.List;

import javax.annotation.Resource; 

import mngwserc.cs.csa.service.CSACustVoiceService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import egovframework.com.utl.fcc.service.EgovStringUtil;
import emf.core.exception.EmfException;
import emf.core.extend.web.EmfController;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 *  고객의 소리 접수관리를 위한 Controller
 * </pre>
 * 
 * @ClassName		: CSACustVoiceController
 * @Description		: 고객의 소리 접수관리 위한 Controller
 * @author 허진영
 * @since 2016.02.04
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2016.02.04		허진영					 최초생성
 * </pre>
 */
@Controller
@RequestMapping("/mngwserc/customer-center/customer-voice")
public class CSACustVoiceController extends EmfController {
	
	/** 서비스 **/
	@Resource(name="cSACustVoiceService")
    private CSACustVoiceService cSACustVoiceService;
	
	/**
	 * 고객의 소리 접수 목록을 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/index.do")
	public String selectCustVoiceList(EmfMap emfMap, ModelMap modelMap) throws Exception
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
			EmfMap rtnMap = cSACustVoiceService.selectCustVoiceList(emfMap);
			
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
		
		return "mngwserc/cs/csa/CSACustVoiceList.admin";
	}
	
	/**
	 * 고객의 소리 접수 상세를 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/write.do")
	public String selectCustVoice(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		try
		{
			String prcsCd = emfMap.getString("prcsCd");
			System.out.println("aa"+emfMap.getString("custVoiceSeq"));
			EmfMap rtnMap = cSACustVoiceService.selectCustVoice(emfMap);
			
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

		return "mngwserc/cs/csa/CSACustVoiceWrite.admin";
	}
	
	/**
	 *  고객의 소리 접수 답변을 등록한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	public String updateCustVoiceAnsw(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		try
		{
			cSACustVoiceService.updateCustVoiceAnsw(emfMap);
			
			modelMap.addAttribute("f", emfMap.getString("f"));
			modelMap.addAttribute("q", emfMap.getString("q"));
			modelMap.addAttribute("inqryCd", emfMap.getString("inqryCd"));
			modelMap.addAttribute("inqryDtlCd", emfMap.getString("inqryDtlCd"));
			modelMap.addAttribute("prcsCd", emfMap.getString("sPrcsCd"));
			modelMap.addAttribute("strtDt", emfMap.getString("strtDt"));
			modelMap.addAttribute("endDt", emfMap.getString("endDt"));
			modelMap.addAttribute("pageIndex", emfMap.getString("pageIndex"));
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}
		
		return "redirect:./write.do?custVoiceSeq=" + emfMap.getString("custVoiceSeq");
	}
	
	/**
	 * 고객의 소리 접수을 삭제한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/delete.do", method=RequestMethod.POST)
	public String deleteCustVoiceList(EmfMap emfMap, ModelMap modelMap, @RequestParam(value="delSeq", required=true) int[] delSeq) throws Exception
	{
		try
		{
			cSACustVoiceService.deleteCustVoiceList(delSeq);
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}
		
		return "redirect:./index.do";
	}
	
	/**
	 * 고객의 소리 접수 답변메일을 발송한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/send.do", method=RequestMethod.POST)
	public String updateCustVoiceAnswMail(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		String url = "error/blank.error";
		
		try
		{
			System.out.println("~~~~~~~답변 이메일~~~~~~~~~~~");
			cSACustVoiceService.updateCustVoiceAnswMail(emfMap);
			
			url = "redirect:./write.do?custVoiceSeq=" + emfMap.getString("custVoiceSeq");
			
			modelMap.addAttribute("f", emfMap.getString("f"));
			modelMap.addAttribute("q", emfMap.getString("q"));
			modelMap.addAttribute("inqryCd", emfMap.getString("inqryCd"));
			modelMap.addAttribute("inqryDtlCd", emfMap.getString("inqryDtlCd"));
			modelMap.addAttribute("prcsCd", emfMap.getString("sPrcsCd"));
			modelMap.addAttribute("strtDt", emfMap.getString("strtDt"));
			modelMap.addAttribute("endDt", emfMap.getString("endDt"));
			modelMap.addAttribute("pageIndex", emfMap.getString("pageIndex"));
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			
			if("답변메일오류".equals(EgovStringUtil.nullConvert(he.getMessage())))
			{
				modelMap.addAttribute("msg", "이미 답변 메일발송을 하였습니다.");
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
	 * 고객의 소리 접수 문의구분 상세를 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/inqry-type.ajax", method=RequestMethod.POST)
	public ModelAndView selectCustVoiceDtlList(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		
		try
		{
			List<EmfMap> rtnList = cSACustVoiceService.selectCustVoiceDtlList(emfMap);
			
			mav.addObject("rtnList", rtnList);
			
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
	 * 고객의 소리 접수 목록을 조회한다. (엑셀 다운로드)
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/excel.do")
	public String excelCustVoiceList(EmfMap emfMap, ModelMap modelMap) throws Exception
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
			modelMap.addAttribute("excelList", cSACustVoiceService.excelCustVoiceList(emfMap));
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		} 
		
		return "mngwserc/cs/csa/CSACustVoiceExcel";
	}
}
