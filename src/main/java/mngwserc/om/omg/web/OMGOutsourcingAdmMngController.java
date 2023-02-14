package mngwserc.om.omg.web;

import java.util.List;

import javax.annotation.Resource;

import mngwserc.om.omf.service.OMFOutsourcingPageMngService;
import mngwserc.om.omg.service.OMGOutsourcingAdmMngService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import emf.core.exception.EmfException;
import emf.core.extend.web.EmfController;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 외주업체 관리자 조건 설정을 위한 Controller
 * </pre>
 * 
 * @ClassName		: OMGOutsourcingAdmMngController.java
 * @Description		: 외주업체 관리자 조건 설정을 위한 Controller
 * @author 김필기
 * @since 2016.05.20
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2016.05.20		김필기					 최초생성
 * </pre>
 */
@Controller
@RequestMapping("/mngwserc/omg")
public class OMGOutsourcingAdmMngController extends EmfController {
	
	/** 서비스 **/
	@Resource(name="oMGOutsourcingAdmMngService")
    private OMGOutsourcingAdmMngService oMGOutsourcingAdmMngService;
	
	@Resource(name="oMFOutsourcingPageMngService")
    private OMFOutsourcingPageMngService oMFOutsourcingPageMngService;
	
	/**
	 * 조건 설정된 외주업체 관리자 목록을 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/list.do")
	public String selectOutsourcingAdmMngList(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		try
		{
			EmfMap rtnMap = oMGOutsourcingAdmMngService.selectOutsourcingAdmMngList(emfMap);
			
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
		
		return "mngwserc/om/omg/OMGOutsourcingAdmMngList.admin";
	}
    
	/**
	 * 외주업체 관리자 조건 등록 화면
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/write.do")
	public String selectOutsourcingAdmMngWrite(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		try
		{
			EmfMap rtnMap = oMGOutsourcingAdmMngService.selectOutsourcingAdmMngInfo(emfMap);
			List<EmfMap> admList = oMGOutsourcingAdmMngService.selectAdmList(emfMap);
			EmfMap osclist = oMFOutsourcingPageMngService.selectOutsourcingCode(emfMap);
			
			modelMap.addAttribute("rtnMap", rtnMap);
			modelMap.addAttribute("admList", admList);
			modelMap.addAttribute("osclist", osclist);
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		} 
		
		return "mngwserc/om/omg/OMGOutsourcingAdmMngWrite.admin";
	}	
	
	/**
	 * 외주업체 관리자 조건 입력
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/insert.do", method=RequestMethod.POST)
	public String insertOutsourcingAdmMngInf(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		String url = "error/blank.error";
		
		try
		{
			oMGOutsourcingAdmMngService.insertOutsourcingAdmMngInf(emfMap);
			
			url = "redirect:/mngwserc/omg/list.do";
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			
			if("관리자 아이디 중복 등록".equals(he.getMessage()))
			{
				modelMap.addAttribute("url", "javascript:history.back()");
				modelMap.addAttribute("msg", he.getMessage());
			}
			else
			{
				throw new EmfException(he.getMessage());	
			}
		} 
		
		return url;
	}

	/**
	 * 외주업체 관리자 조건 수정
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	public String updateOutsourcingAdmMngInf(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		String url = "error/blank.error";
		
		try
		{
			oMGOutsourcingAdmMngService.updateOutsourcingAdmMngInf(emfMap);
			
			url = "redirect:/mngwserc/omg/write.do?seq=" + emfMap.getString("seq");
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
	 * 영업채널1 목록을 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/getChannelList.ajax", method=RequestMethod.POST)
	public ModelAndView selectChannelList(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		
		try
		{
			mav.addObject("list", oMGOutsourcingAdmMngService.selectChannelList(emfMap));
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
