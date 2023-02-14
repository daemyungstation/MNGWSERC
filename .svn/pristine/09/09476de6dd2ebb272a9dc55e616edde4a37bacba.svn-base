package mngwserc.cm.cmb.web;

import javax.annotation.Resource;

import mngwserc.cm.cmb.service.CMBChngSysService;

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
 * 전환서비스 체계 관리를 위한 Controller
 * </pre>
 * 
 * @ClassName		: CMBChngSysContoller.java
 * @Description		: 전환서비스 체계 관리를 위한 Controller
 * @author 허진영
 * @since 2016.02.17
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2016.02.17		허진영					 최초생성
 * </pre>
 */
@Controller
@RequestMapping("/mngwserc/cmb/sys")
public class CMBChngSysContoller extends EmfController {

	/** 서비스 **/
	@Resource(name="cMBChngSysService")
    private CMBChngSysService cMBChngSysService;
	
	/**
	 * 전환서비스 쳬계 그룹 목록을 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/list.do")
	public String selectChngSysGrpList(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		try
		{
			EmfMap rtnMap = cMBChngSysService.selectChngSysGrpList(emfMap);
			
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
		
		return "mngwserc/cm/cmb/CMBChngSysGrpList.admin";
	}
	
	/**
	 * 전환서비스 쳬계 그룹을 등록을 위해 중복 검사를 한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/grpNm-chk.ajax", method=RequestMethod.POST)
	public ModelAndView getChngSysGrpNmExstCnt(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		
		try
		{
			int exstCnt = cMBChngSysService.getChngSysGrpNmExstCnt(emfMap);
			
			mav.addObject("exstCnt", exstCnt);
			
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
	 * 전환서비스 쳬계 그룹을 등록한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/insert.ajax", method=RequestMethod.POST)
	public ModelAndView insertChngSysGrp(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		
		try
		{
			int grpSeq = cMBChngSysService.insertChngSysGrp(emfMap);
			
			mav.addObject("grpSeq", grpSeq);
			
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
	 * 전환서비스 쳬계 그룹을 수정한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/update.ajax", method=RequestMethod.POST)
	public ModelAndView updateChngSysGrp(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		
		try
		{
			cMBChngSysService.updateChngSysGrp(emfMap);
			
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
	 * 전환서비스 쳬계 그룹을 삭제한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/delete.ajax", method=RequestMethod.POST)
	public ModelAndView deleteChngSysGrp(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		
		try
		{
			cMBChngSysService.deleteChngSysGrp(emfMap);
			
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
	 * 전환서비스 쳬계 그룹 상세 목록을 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/prdct-list.do")
	public String selectChngSysGrpPrdctList(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		try
		{
			EmfMap rtnMap = cMBChngSysService.selectChngSysGrpPrdctList(emfMap);
			
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

		return "mngwserc/cm/cmb/CMBChngSysGrpPrdctList.admin";
	}
	
	/**
	 * 전환서비스 쳬계 외부상품(엔컴) 목록을 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/outPrdct-list.do")
	public String selectChngSysOutPrdctList(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		try
		{
			EmfMap rtnMap = cMBChngSysService.selectChngSysOutPrdctList(emfMap);
			
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
		
		return "mngwserc/cm/cmb/CMBChngSysOutPrdctPop.pop";
	}
	
	/**
	 * 전환서비스 쳬계 그룹 상품을 등록한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/prdct-insert.ajax", method=RequestMethod.POST)
	public ModelAndView deleteChngSysGrpPrdct(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		
		try
		{
			cMBChngSysService.insertChngSysGrpPrdct(emfMap);
			
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
	 * 전환서비스 쳬계 그룹명을 수정한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/grpNm-update.ajax", method=RequestMethod.POST)
	public ModelAndView updateChngSysGrpNm(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		
		try
		{
			cMBChngSysService.updateChngSysGrpNm(emfMap);
			
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
	 * 전환서비스 쳬계 그룹 상품을 삭제한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/prdct-delete.ajax", method=RequestMethod.POST)
	public ModelAndView deleteChngSysGrpPrdct(EmfMap emfMap, ModelMap modelMap, @RequestParam(value="delSeq", required=true) int[] delSeq) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		
		try
		{
			cMBChngSysService.deleteChngSysGrpPrdctList(delSeq);
			
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
	 * 전환서비스 쳬계 그룹 상품을 엑셀다운로드한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/prdct-excel.do")
	public String excelChngSysGrpPrdctList(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		try
		{
			modelMap.addAttribute("excelList", cMBChngSysService.excelChngSysGrpPrdctList(emfMap));
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}

		return "mngwserc/cm/cmb/CMBChngSysPrdctExcel";
	}
}
