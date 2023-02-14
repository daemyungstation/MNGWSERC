package mngwserc.mb.mba.web;

import javax.annotation.Resource;

import mngwserc.mb.mba.service.MBAMemChngService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import emf.core.exception.EmfException;
import emf.core.extend.web.EmfController;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 회원정보 변경내역 관리를 위한 Controller
 * </pre>
 * 
 * @ClassName		: MBAMemChngController.java
 * @Description		: 회원정보 변경내역 관리를 위한 Controller
 * @author 허진영
 * @since 2016.02.22
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author				    description
 *   ===========    ==============    =============================
 *    2016.02.22		허진영					 최초 생성
 * </pre>
 */
@Controller
@RequestMapping("/mngwserc/mba/chng")
public class MBAMemChngController extends EmfController {
	
	/** 서비스 **/
	@Resource(name="mBAMemChngService")
    private MBAMemChngService mBAMemChngService;
	
	/**
	 * 회원정보 변경내역 목록을 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/list.do")
	public String selectMemInfList(EmfMap emfMap, ModelMap modelMap) throws Exception
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
			EmfMap rtnMap = mBAMemChngService.selectMemChngList(emfMap);
			
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
		
		return "mngwserc/mb/mba/MBAMemChngList.admin";
	}
	
	/**
	 * 회원정보 변경내역 처리현황을 수정한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/prcs-update.ajax", method=RequestMethod.POST)
	public ModelAndView updateChngPtcPrcsYn(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		
		try
		{
			mBAMemChngService.updateChngPtcPrcsYn(emfMap);
			
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
     * 회원정보 변경내역 목록을 조회한다. (엑셀다운로드)
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@RequestMapping(value="/excel.do")
	public String excelMemChngList(EmfMap emfMap, ModelMap modelMap) throws Exception
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
			modelMap.addAttribute("excelList", mBAMemChngService.excelMemChngList(emfMap));
			modelMap.addAttribute("type", emfMap.getString("type"));
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		} 
				
		return "mngwserc/mb/mba/MBAMemChngExcel";
	}
}
