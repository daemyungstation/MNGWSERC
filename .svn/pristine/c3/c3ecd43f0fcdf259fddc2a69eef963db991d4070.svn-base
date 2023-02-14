package mngwserc.pr.prb.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import emf.core.exception.EmfException;
import emf.core.extend.web.EmfController;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;
import mngwserc.pr.prb.service.PRBNaverTestPromotionMngService;


/**
 * <pre> 
 * 네이버 실검 테스트 프로모션 관리 Controller
 * </pre>
 * 
 * @ClassName		: PRBNaverTestPromotionMngController.java
 * @Description		: 네이버 실검 테스트 프로모션 Controller
 * @author inuscomm
 * @since 2019. 07. 16.
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2019. 07. 16.	   inuscomm				                최초생성
 * </pre>
 */

@Controller
@RequestMapping(value="/mngwserc/pr-center/promotion")
public class PRBNaverTestPromotionMngController extends EmfController {
	
	/** 서비스 **/
	@Resource(name="pRBNaverTestPromotionMngService")
	private PRBNaverTestPromotionMngService pRBNaverTestPromotionMngService;
	
	
	/**
     * 네이버 실검 테스트 프로모션 설정 - 구분값이 없을 경우 리다이렉트
     * 
     * @param null
	 * @return String View URL
	 * @throws null
     */
	@RequestMapping(value="/config.do")
	public String PRBNaverTestPromotionConfigMng(){
		return "redirect:/mngwserc/pr-center/promotion/1/config.do";
	}
	
	/**
     * 네이버 실검 테스트 프로모션 설정
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@RequestMapping(value="/{strDivision}/config.do")
    public String PRBNaverTestPromotionConfigMng(EmfMap emfMap, ModelMap modelMap, @PathVariable String strDivision) throws Exception {
		try
		{
			if(strDivision.isEmpty()) {
				throw new EmfException();
			}
			int iDivision = Integer.parseInt(strDivision);
			emfMap.put("PNTEC_DIVISION", iDivision);
			EmfMap rtnMap = pRBNaverTestPromotionMngService.selectConfigList(emfMap);
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
		return "mngwserc/pr/prb/PRBNaverTestPromotionConfigMng.admin";
	}
	
	/**
     * 네이버 실검 테스트 프로모션 업데이트
     * 
     * @param EmfMap POST 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@RequestMapping(value="/{strDivision}/action.do", method=RequestMethod.POST)
    public String PRBNaverTestPromotionConfigUpdate(HttpServletRequest request, EmfMap emfMap, @PathVariable String strDivision) throws Exception 
    {	
    	try
    	{
    		if(strDivision.isEmpty()) {
    			throw new EmfException();
			}
    		
    		emfMap.put("request", request);
    		pRBNaverTestPromotionMngService.updateConfig(emfMap);
    	}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		} 	

		return "redirect:/mngwserc/pr-center/promotion/"+strDivision+"/config.do";
    }
	
	/**
     * 네이버 실검 테스트 프로모션 응모내역 리다이렉트
     * 
     * @param null
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@RequestMapping(value="/index.do")
	public String PRBNaverTestPromotionMng(){
		return "redirect:/mngwserc/pr-center/promotion/1/index.do";
	}
	
	/**
     * 네이버 실검 테스트 프로모션 응모내역 조회
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@RequestMapping(value="/{strDivision}/index.do")
    public String PRBNaverTestPromotionMng(EmfMap emfMap, ModelMap modelMap, @PathVariable String strDivision) throws Exception {
		try
		{
			if(strDivision.isEmpty()) {
				throw new EmfException();
			}
			int iDivision = Integer.parseInt(strDivision);
			emfMap.put("NTEVT_DIVISION", iDivision);
			EmfMap rtnMap = pRBNaverTestPromotionMngService.selectList(emfMap);
			modelMap.addAttribute("rtnMap", rtnMap);
			modelMap.addAttribute("ntevtDivision", iDivision);
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		} 	
		return "mngwserc/pr/prb/PRBNaverTestPromotionMng.admin";
	}
	
	/**
     * 네이버 실검 테스트 프로모션 응모내역 다운
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@RequestMapping(value="/{strDivision}/excel.do")
    public String PRBNaverTestPromotionExcelMng(EmfMap emfMap, ModelMap modelMap, @PathVariable String strDivision) throws Exception {
		try
		{
			if(strDivision.isEmpty()) {
				throw new EmfException();
			}
			int iDivision = Integer.parseInt(strDivision);
			emfMap.put("NTEVT_DIVISION", iDivision);

			EmfMap rtnMap = pRBNaverTestPromotionMngService.selectExcelList(emfMap);
			modelMap.addAttribute("rtnMap", rtnMap);
			modelMap.addAttribute("ntevtDivision", strDivision);
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		} 	
		return "mngwserc/pr/prb/PRBNaverTestPromotionExcel";
	}
	
	/**
     * 네이버 실검 테스트 프로모션 PV내역 조회
     * 
     * @param null
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@RequestMapping(value="/pv.do")
	public String PRBNaverTestPromotionPVMng(){
		return "redirect:/mngwserc/pr-center/promotion/1/pv.do";
	}
	
	/**
     * 네이버 실검 테스트 프로모션 PV내역 조회
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@RequestMapping(value="/{strDivision}/pv.do")
    public String PRBNaverTestPromotionPVMng(EmfMap emfMap, ModelMap modelMap, @PathVariable String strDivision) throws Exception {
		try
		{
			if(strDivision.isEmpty()) {
				throw new EmfException();
			}
			int iDivision = Integer.parseInt(strDivision);
			emfMap.put("NTEVTPV_DIVISION", iDivision);
			
			EmfMap rtnMap = pRBNaverTestPromotionMngService.selectPvList(emfMap);
			modelMap.addAttribute("rtnMap", rtnMap);
			modelMap.addAttribute("ntevtpvDivision", iDivision);
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		} 	
		return "mngwserc/pr/prb/PRBNaverTestPromotionPVMng.admin";
	}
	
	/**
     * 네이버 실검 테스트 프로모션 PV 다운
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@RequestMapping(value="/{strDivision}/pvexcel.do")
    public String PRBNaverTestPromotionPvExcelMng(EmfMap emfMap, ModelMap modelMap, @PathVariable String strDivision) throws Exception {
		try
		{
			if(strDivision.isEmpty()) {
				throw new EmfException();
			}
			int iDivision = Integer.parseInt(strDivision);
			emfMap.put("NTEVTPV_DIVISION", iDivision);
			
			EmfMap rtnMap = pRBNaverTestPromotionMngService.selectPvExcelList(emfMap);
			modelMap.addAttribute("rtnMap", rtnMap);
			modelMap.addAttribute("ntevtpvDivision", iDivision);}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		} 	
		return "mngwserc/pr/prb/PRBNaverTestPromotionPvExcel";
	}
}