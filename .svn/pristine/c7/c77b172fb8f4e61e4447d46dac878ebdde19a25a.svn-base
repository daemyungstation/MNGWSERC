package mngwserc.cm.cma.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import mngwserc.cm.cma.service.CMAOnlinePrdctCsMngService;
import mngwserc.cm.cma.service.DmLifeService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import egovframework.com.cmm.service.EgovProperties;
import emf.core.exception.EmfException;
import emf.core.extend.web.EmfController;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 온라인 상담신청를 위한 Controller
 * </pre>
 * 
 * @ClassName		: CMAOnlinePrdctCsMngController.java
 * @Description		: 온라인 상담신청 위한 Controller
 * @author 김필기
 * @since 2016.02.22
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2016.02.22		김필기					 최초생성
 *    2016.03.10		김필기					 회사관리 추가
 * </pre>
 */
@Controller
@RequestMapping("/mngwserc/cma")
public class CMAOnlinePrdctCsMngController extends EmfController {
	
	/** 서비스 **/
	@Resource(name = "cMAOnlinePrdctCsMngService")
    private CMAOnlinePrdctCsMngService cMAOnlinePrdctCsMngService;
	
	@Resource(name = "dMLifeService")
    private DmLifeService dMLifeService;
	
	/**
	 * 온라인 상담신청 목록을 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value={"/gnrlPrdctCs/list.do", "/b2bPrdctCs/list.do"})
	public String selectOnlinePrdctCsMngList(HttpServletRequest request
												,EmfMap emfMap,  ModelMap modelMap) throws Exception
	{

		try
		{		
			if(request.getServletPath().indexOf("gnrlPrdctCs") > -1){
				emfMap.put("prdctCsGb", EgovProperties.getProperty("Globals.gnrlPrdctCd"));	// 일반상품 코드를 Globals에서 가져와서 설정
			}else if(request.getServletPath().indexOf("b2bPrdctCs") > -1) {
				emfMap.put("prdctCsGb", EgovProperties.getProperty("Globals.b2bPrdctCd"));	// b2b상품 코드를 Globals에서 가져와서 설정

			}			
			EmfMap rtnMap = cMAOnlinePrdctCsMngService.selectOnlinePrdctCsMngList(emfMap);
			
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
		
		return "mngwserc/cm/cma/CMAOnlinePrdctCsList.admin";
	}
	
	/**
     * 온라인 상담신청 상세를 조회한다. (뷰 페이지)
     * 
     * @param EmfMap 검색할 데이터
     * @return String View URL
     * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
    @RequestMapping(value={"/gnrlPrdctCs/view.do", "/b2bPrdctCs/view.do"})
    public String getOnlinePrdctCsMngViewPage(HttpServletRequest request
    														, EmfMap emfMap, ModelMap modelMap) throws Exception 
    {
		String url = "mngwserc/cm/cma/CMAOnlinePrdctCsView.admin";
		String gnrlPrdctCd = "", b2bPrdctCd = "";
		
		try
		{
			String prcsCd = emfMap.getString("prcsCd");
	
			if(request.getServletPath().indexOf("gnrlPrdctCs") > -1){
				gnrlPrdctCd = EgovProperties.getProperty("Globals.gnrlPrdctCd");	// 일반상품 코드를 Globals에서 가져와서 설정
			}else if(request.getServletPath().indexOf("b2bPrdctCs") > -1) {
				b2bPrdctCd = EgovProperties.getProperty("Globals.b2bPrdctCd");	// b2b상품 코드를 Globals에서 가져와서 설정
			}		
			
			EmfMap rtnMap = cMAOnlinePrdctCsMngService.selectOnlinePrdctCsMng(emfMap);
			
			rtnMap.put("gnrlPrdctCd", gnrlPrdctCd);
			rtnMap.put("b2bPrdctCd", b2bPrdctCd);
			rtnMap.put("cms", EgovProperties.getProperty("Globals.cms"));
			rtnMap.put("creditCard", EgovProperties.getProperty("Globals.creditCard"));
			
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
    	
		return url;       	
    }
    
	/**
	 *  온라인 상담신청 상세를 조회한다. (등록, 수정 페이지)
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	/*@RequestMapping(value={"/gnrlPrdctCs/write.do", "/b2bPrdctCs/write.do"})
	public String selectOnlinePrdctCsMng(HttpServletRequest request
												, EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		String url = "";
		try
		{
			if(request.getServletPath().indexOf("gnrlPrdctCs") > -1){
				emfMap.put("prdctCsGb", EgovProperties.getProperty("Globals.gnrlPrdctCd"));	// 일반상품 코드를 Globals에서 가져와서 설정
				url = "mngwserc/cm/cma/CMANormalPrdctCsWrite.admin";
			}else if(request.getServletPath().indexOf("b2bPrdctCs") > -1) {
				emfMap.put("prdctCsGb", EgovProperties.getProperty("Globals.b2bPrdctCd"));	// b2b상품 코드를 Globals에서 가져와서 설정
				url = "mngwserc/cm/cma/CMAB2bPrdctCsWrite.admin";
			}
			
			EmfMap rtnMap = cMAOnlinePrdctCsMngService.selectOnlinePrdctCsMng(emfMap);
			
			rtnMap.put("prdctCsGb", emfMap.get("prdctCsGb"));								//	상담상품 구분(일반, b2b)
			rtnMap.put("cms", EgovProperties.getProperty("Globals.cms"));					//  계좌구분 코드(cms)
			rtnMap.put("creditCard", EgovProperties.getProperty("Globals.creditCard"));	//  계좌구분 코드(신용카드)
			rtnMap.put("b2bMem", EgovProperties.getProperty("Globals.b2bMem"));		// b2b 회원 구분(임시)
			
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

		return url;
	}*/
	
	/**
	 * 온라인 상담신청을 입력한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	/*@RequestMapping(value={"/gnrlPrdctCs/insert.do", "/b2bPrdctCs/insert.do"}, method=RequestMethod.POST)
	public String insertOnlinePrdctCsMng(MultipartHttpServletRequest multiRequest
												, EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		String url = "error/blank.error";
		
		try
		{
			if(multiRequest.getServletPath().indexOf("gnrlPrdctCs") > -1){
				url = "redirect:/mngwserc/cma/gnrlPrdctCs/list.do";
			}else if(multiRequest.getServletPath().indexOf("b2bPrdctCs") > -1) {
				url = "redirect:/mngwserc/cma/b2bPrdctCs/list.do";
			}

			cMAOnlinePrdctCsMngService.insertOnlinePrdctCsMng(multiRequest, emfMap);
			
			
			//modelMap.addAttribute("msg", "등록되었습니다.");
			//modelMap.addAttribute("url", "/mngwserc/cme/termgroup/list.do");
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			
			if("파일용량초과".equals(EgovStringUtil.nullConvert(he.getMessage())))
			{
				modelMap.addAttribute("msg", "파일 용량이 초과되었습니다.");
				modelMap.addAttribute("url", "javascript:history.back();");
			}
			else
			{
				throw new EmfException(he.getMessage());
			}
		}

		return url;    	
		//return "redirect:/mngwserc/cma/OnlinePrdctCs/list.do";
	}*/
	
	/**
	 * 온라인 상담신청을 수정한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value={"/gnrlPrdctCs/update.do", "/b2bPrdctCs/update.do"}, method=RequestMethod.POST)
	public String updateOnlinePrdctCsMng(HttpServletRequest request
												,EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		String url = "error/blank.error"; 
		
		try
		{
			modelMap.addAttribute("f", emfMap.getString("f"));
			modelMap.addAttribute("q", emfMap.getString("q"));
			modelMap.addAttribute("prcsCd", emfMap.getString("sPrcsCd"));
			modelMap.addAttribute("strtDt", emfMap.getString("strtDt"));
			modelMap.addAttribute("endDt", emfMap.getString("endDt"));
			modelMap.addAttribute("pageIndex", emfMap.getString("pageIndex"));
			
			if(request.getServletPath().indexOf("gnrlPrdctCs") > -1){
				url = "redirect:/mngwserc/cma/gnrlPrdctCs/view.do";
			}else if(request.getServletPath().indexOf("b2bPrdctCs") > -1) {
				url = "redirect:/mngwserc/cma/b2bPrdctCs/view.do";
			}
			cMAOnlinePrdctCsMngService.updateOnlinePrdctCsMng(emfMap);
			
			url = url + "?seq=" + emfMap.get("onlinePrdctCsSeq");
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
	 * 온라인 상담신청을 삭제한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value={"/gnrlPrdctCs/delete.do", "/b2bPrdctCs/delete.do"}, method=RequestMethod.POST)
	public String deleteOnlinePrdctCsMngList(HttpServletRequest request
												, EmfMap emfMap, ModelMap modelMap
												, @RequestParam(value="delSeq", required=true) int[] delSeq) throws Exception
	{
		String url = "";
		try
		{
			emfMap.put("delSeq", delSeq);
			
			if(request.getServletPath().indexOf("gnrlPrdctCs") > -1){
				url = "redirect:/mngwserc/cma/gnrlPrdctCs/list.do";
			}else if(request.getServletPath().indexOf("b2bPrdctCs") > -1) {
				url = "redirect:/mngwserc/cma/b2bPrdctCs/list.do";
			}

			cMAOnlinePrdctCsMngService.deleteOnlinePrdctCsMngList(emfMap);
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
	 * 납입방식 조회
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */	
	@RequestMapping(value={"/gnrlPrdctCs/paymentMethod.ajax", "/b2bPrdctCs/paymentMethod.ajax"}, method=RequestMethod.POST)
	public ModelAndView selectPaymentMethod(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		
		try
		{			
			mav.addObject("list", dMLifeService.getPaymentMethod(emfMap));
			
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
	 * 상세상품 조회
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */	
	@RequestMapping(value={"/gnrlPrdctCs/detailProduct.ajax", "/b2bPrdctCs/detailProduct.ajax"}, method=RequestMethod.POST)
	public ModelAndView selectDetailProduct(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		
		try
		{			
			mav.addObject("list", dMLifeService.getDetailProduct(emfMap));
			
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
	 * 담당자를 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return Json 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	
	@RequestMapping(value={"/gnrlPrdctCs/employeeList.do", "/b2bPrdctCs/employeeList.do"})
	public String selectEmployeeList(EmfMap emfMap, ModelMap modelMap) throws Exception
	{	
		try
		{
			EmfMap rtnMap = dMLifeService.getEmployeeList(emfMap);
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
		
		return "mngwserc/cm/cma/employeeListPop.pop";		
	}	
	
	/**
	 * 등록한 엔컴회사 목록을 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/company/list.do")
	public String selectOnlinePrdctCoList(HttpServletRequest request
												,EmfMap emfMap,  ModelMap modelMap) throws Exception
	{

		try
		{		
			EmfMap rtnMap = cMAOnlinePrdctCsMngService.selectOnlinePrdctCoList(emfMap);
			
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
		
		return "mngwserc/cm/cma/CMAOnlinePrdctCompanyList.admin";
	}	
	
	/**
	 * 엔컴 회사목록을 입력한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/company/insert.ajax", method=RequestMethod.POST)
	public ModelAndView insertOnlinePrdctCo(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		
		try
		{			
			boolean result = cMAOnlinePrdctCsMngService.insertOnlinePrdctCo(emfMap);
			
			mav.addObject("result" , result);
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
	 * 등록한 엔컴회사 목록을 삭제한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/company/delete.do", method=RequestMethod.POST)
	public String deleteOnlinePrdctCoList(EmfMap emfMap, ModelMap modelMap, @RequestParam(value="delSeq", required=true) int[] delSeq) throws Exception
	{
		try
		{			
			emfMap.put("delSeq", delSeq);
			
			cMAOnlinePrdctCsMngService.deleteOnlinePrdctCoList(emfMap);
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}
		
		return "redirect:/mngwserc/cma/company/list.do";
	}	
	
	/**
	 * 엔컴 회사목록을 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/company/b2bcomcd/list.do")
	public String selectB2bComCdList(HttpServletRequest request
												,EmfMap emfMap,  ModelMap modelMap) throws Exception
	{

		try
		{		
			EmfMap rtnMap = dMLifeService.getB2bComCdList(emfMap);
			
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
		
		return "mngwserc/cm/cma/B2bComCdListPop.pop";
	}	
}
