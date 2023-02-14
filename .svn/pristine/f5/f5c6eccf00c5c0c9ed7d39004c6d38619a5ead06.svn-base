package mngwserc.cm.cmg.web;

import javax.annotation.Resource;

import mngwserc.cm.cmg.service.CMGAcntChngService;

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
 * 결제계좌 변경내역 관리를 위한 Controller
 * </pre>
 * 
 * @ClassName		: CMGAcctModPtcController.java
 * @Description		: 결제계좌 변경내역 관리를 위한 Controller
 * @author 허진영
 * @since 2016.03.07
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2016.03.07		허진영					 최초생성
 * </pre>
 */
@Controller
@RequestMapping("mngwserc/cmg")
public class CMGAcntChngController extends EmfController {
	
	/** 서비스 **/
	@Resource(name="cMGAcntChngService")
	private CMGAcntChngService cMGAcntChngService; 
	
	/**
	 * 결제계좌 변경내역 목록을 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */	
	@RequestMapping("/list.do")
	public String selectAcntChngList(EmfMap emfMap ,ModelMap modelMap) throws Exception
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
			EmfMap rtnMap = cMGAcntChngService.selectAcntChngList(emfMap);

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
		
		return "mngwserc/cm/cmg/CMGAcntChngList.admin";
	}

	
	/**
	 * 회원정보 상세를 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/write.do")
	public String selectMemInf(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		try
		{
			EmfMap rtnMap = cMGAcntChngService.selectAcntChngListDtl(emfMap);
			System.out.println(" ###################### rtnMap  ====> " + rtnMap);
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

		return "mngwserc/cm/cmg/CMGAcntChngList.admin";
	}
	
	/**
	 * 결제계좌 변경내역 처리현황을 수정한다.
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
			cMGAcntChngService.updateChngPtcPrcsYn(emfMap);
			
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
