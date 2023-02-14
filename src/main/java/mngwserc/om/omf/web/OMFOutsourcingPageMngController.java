package mngwserc.om.omf.web;

import javax.annotation.Resource;

import mngwserc.cn.cna.GetAllMapValue;
import mngwserc.om.omf.service.OMFOutsourcingPageMngService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import emf.core.exception.EmfException;
import emf.core.extend.web.EmfController;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 외주업체 페이지 관리를 위한 Controller
 * </pre>
 * 
 * @ClassName		: OMFOutsourcingPageMngController.java
 * @Description		: 외주업체 페이지 관리를 위한 Controller
 * @author 김필기
 * @since 2016.05.16
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2016.05.16		김필기					 최초생성
 * </pre>
 */
@Controller
@RequestMapping("/mngwserc/omf")
public class OMFOutsourcingPageMngController extends EmfController {
	
	/** 서비스 **/
	@Resource(name="oMFOutsourcingPageMngService")
    private OMFOutsourcingPageMngService oMFOutsourcingPageMngService;
	
	/**
	 * 외주업체 코드별 관리 목록을 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/list.do")
	public String selectOutsourcingPageMngList(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		try
		{
			EmfMap rtnMap = oMFOutsourcingPageMngService.selectOutsourcingPageMngList(emfMap);
			
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
		
		return "mngwserc/om/omf/OMFOutsourcingPageMngList.admin";
	}
    
	/**
	 * 외주업체 코드별 관리 등록 화면
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/write.do")
	public String selectOutsourcingPageMngWrite(EmfMap emfMap,  ModelMap modelMap) throws Exception
	{
		try
		{
			EmfMap rtnMap = oMFOutsourcingPageMngService.selectOutsourcingPageMngInfo(emfMap);
			EmfMap osclist = oMFOutsourcingPageMngService.selectOutsourcingCode(emfMap);
			
			modelMap.addAttribute("rtnMap", rtnMap);
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
		
		return "mngwserc/om/omf/OMFOutsourcingPageMngWrite.admin";
	}	
	
	/**
	 * 외주업체 코드별 관리 입력
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/insert.do", method=RequestMethod.POST)
	public String insertOutsourcingPageMngInf(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		String url = "error/blank.error";
		
		try
		{
//			oMFOutsourcingPageMngService.insertOutsourcingPageMngInf(emfMap);
			oMFOutsourcingPageMngService.iopmi(emfMap);
			url = "redirect:/mngwserc/omf/list.do";
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			
			if("외주업체 코드 중복 등록".equals(he.getMessage()))
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
	 * 외주업체 코드별 관리 수정
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	public String updateOutsourcingPageMngInf(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		try
		{
			System.out.println("Controller start --------------------------------------------------");
//			oMFOutsourcingPageMngService.updateOutsourcingPageMngInf(emfMap);
			oMFOutsourcingPageMngService.uopm(emfMap);
			System.out.println("Controller end --------------------------------------------------");
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			
			throw new EmfException(he.getMessage());
		} 
		
		return "redirect:/mngwserc/omf/write.do?seq=" + emfMap.getString("seq");
	}
}
