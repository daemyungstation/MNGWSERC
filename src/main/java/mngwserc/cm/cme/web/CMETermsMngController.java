package mngwserc.cm.cme.web;

import javax.annotation.Resource;

import mngwserc.cm.cme.service.CMETermsMngService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import egovframework.com.utl.fcc.service.EgovStringUtil;
import emf.core.exception.EmfException;
import emf.core.extend.web.EmfController;

import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 약관별 관리를 위한 Controller
 * </pre>
 * 
 * @ClassName		: CMETermMngController.java
 * @Description		: 약관별 그룹관리 위한 Controller
 * @author 김필기
 * @since 2016.02.18
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2016.02.18		김필기					 최초생성
 * </pre>
 */
@Controller
@RequestMapping("/mngwserc/cme/terms")
public class CMETermsMngController extends EmfController {
	
	/** 서비스 **/
	@Resource(name = "cMETermsMngService")
    private CMETermsMngService cMETermsMngService;
	
	
	/**
	 * 약관별 관리 목록을 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/list.do")
	public String selectTermsMngList(EmfMap emfMap,  ModelMap modelMap) throws Exception
	{

		try
		{
			EmfMap rtnMap = cMETermsMngService.selectTermsMngList(emfMap);
			
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
		
		return "mngwserc/cm/cme/CMETermsList.admin";
	}
	
	/**
     * 약관별 관리 상세를 조회한다. (뷰 페이지)
     * 
     * @param EmfMap 검색할 데이터
     * @return String View URL
     * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
    @RequestMapping(value="/view.do")
    public String getTermsMngViewPage(EmfMap emfMap, ModelMap modelMap) throws Exception 
    {
		String url = "mngwserc/cm/cme/CMETermsView.admin";
		String isview = "";
		
		try
		{
			String trsGb = emfMap.getString("trsGb");
			
			//isview : 게시글 내용 iframe으로 재호출 구분값
			/*
			if(!"".equals(emfMap.get("isview"))&&emfMap.get("isview")!=null){
				isview = (String)emfMap.get("isview");
			}
			if("1".equals(isview))
			{
				url = "mngwserc/cm/cme/CMETermsFrameView";
			}*/
			
			EmfMap rtnMap = cMETermsMngService.selectTermsMng(emfMap);
			EmfMap termsInfo = (EmfMap)rtnMap.get("termsInfo");
			
			if(termsInfo.getString("trsGb").startsWith("CTINF")){
				// 계약안내
				url = "mngwserc/cm/cme/CMEContractInfView.admin";
			}else{
				// 약관
				url = "mngwserc/cm/cme/CMETermsView.admin";
			}
			
			modelMap.addAttribute("sTrsGb", trsGb);
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
	 *  약관별 관리 상세를 조회한다. (등록, 수정 페이지)
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/write.do")
	public String selectTermsMng(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		String url = "";
		try
		{
			String trsGb = emfMap.getString("trsGb");
			
			EmfMap rtnMap = cMETermsMngService.selectTermsMng(emfMap);
			
			EmfMap termsInfo = (EmfMap)rtnMap.get("termsInfo");
			
			if(termsInfo != null){
				if(termsInfo.getString("trsGb").startsWith("CTINF")){
					// 계약안내
					url = "mngwserc/cm/cme/CMEContractInfWrite.admin";
				}else{
					// 약관
					url = "mngwserc/cm/cme/CMETermsWrite.admin";
				}				
			}else{
				url = "mngwserc/cm/cme/CMETermsWrite.admin";
			}
			
			modelMap.addAttribute("sTrsGb", trsGb);
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
	 * 약관별 관리을 입력한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/insert.do", method=RequestMethod.POST)
	public String insertTermsMng(MultipartHttpServletRequest multiRequest, EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		String url = "error/blank.error";
		
		try
		{
			cMETermsMngService.insertTermsMng(multiRequest, emfMap);
			
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

		//return url;    	
		return "redirect:/mngwserc/cme/terms/list.do";
	}
	
	/**
	 * 약관별 관리을 수정한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	public String updateTermsMng(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		String url = "error/blank.error";
		
		try
		{
			modelMap.addAttribute("f", emfMap.getString("f"));
			modelMap.addAttribute("q", emfMap.getString("q"));
			modelMap.addAttribute("trsGb", emfMap.getString("sTrsGb"));
			modelMap.addAttribute("strtDt", emfMap.getString("strtDt"));
			modelMap.addAttribute("endDt", emfMap.getString("endDt"));
			modelMap.addAttribute("pageIndex", emfMap.getString("pageIndex"));
			
			cMETermsMngService.updateTermsMng(emfMap);
			
			url = "redirect:/mngwserc/cme/terms/view.do?trsMstSeq=" + emfMap.get("trsMstSeq");
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
	}
	
	/**
	 * 약관별 관리을 삭제한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/delete.do", method=RequestMethod.POST)
	public String deleteTermsMngList(EmfMap emfMap, ModelMap modelMap, @RequestParam(value="delSeq", required=true) int[] delSeq) throws Exception
	{
		try
		{
			emfMap.put("delSeq", delSeq);
			cMETermsMngService.deleteTermsMngList(emfMap);
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}
		
		return "redirect:/mngwserc/cme/terms/list.do";
	}
	
	/**
     * 약관을 복사한다.
     * 
     * @param EmfMap 검색할 데이터
     * @return String View URL
     * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
    @RequestMapping(value="/copy.do")
    public String insertCopyTermsMng(EmfMap emfMap, ModelMap modelMap) throws Exception 
    {
		String url = "error/blank.error";
		
		try
		{
			cMETermsMngService.insertCopyTermsMng(emfMap);
			
			//modelMap.addAttribute("msg", "등록되었습니다.");
			//modelMap.addAttribute("url", "/mngwserc/cme/termgroup/list.do");
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			
			throw new EmfException(he.getMessage());
		}

		return "redirect:/mngwserc/cme/terms/list.do";
    }
    
    /**
	 * 약관 내용을 조회한다(iframe).
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/termsDtl.do")
	public String selectTermsDtl(EmfMap emfMap,  ModelMap modelMap) throws Exception
	{
		String url = "";
		try
		{
			EmfMap rtnMap = cMETermsMngService.selectTermsDtl(emfMap);
			
			modelMap.addAttribute("seq", emfMap.getString("seq"));
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
		
		if("true".equals(emfMap.getString("view"))){
			url = "mngwserc/cm/cme/termsView.pop";
		}else{
			url = "mngwserc/cm/cme/termsList.pop";
		}
		return url;
	}    
	

	/**
	 * 약관 내용 등록
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */	
	@RequestMapping(value="/insertTermsDtl.ajax", method=RequestMethod.POST)
	public ModelAndView insertTermsDtl(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		
		try
		{			
			cMETermsMngService.insertTermsDtl(emfMap);
			
			mav.addObject("result", true);
			
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
	 * 약관 내용 수정
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */	
	@RequestMapping(value="/updateTermDtl.ajax", method=RequestMethod.POST)
	public ModelAndView updateTermDtl(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		
		try
		{			
			cMETermsMngService.updateTermDtl(emfMap);
			
			mav.addObject("result", true);
			
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
	 * 약관 내용 삭제
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */	
	@RequestMapping(value="/deleteTermsDtl.ajax", method=RequestMethod.POST)
	public ModelAndView deleteTermsDtl(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		
		try
		{			
			cMETermsMngService.deleteTermsDtl(emfMap);
			
			mav.addObject("result", true);
			
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
	 * 등록한 약관 상세 내용을 엑셀 다운로드한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/excel.do")
	public String excelDownLoad (EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		String url = "";
		try
		{			
			EmfMap rtnMap = cMETermsMngService.selectTermsMng(emfMap);
			
			emfMap.put("seq", emfMap.getString("trsMstSeq"));
			EmfMap dtlMap = cMETermsMngService.selectTermsDtl(emfMap);

			EmfMap termsInfo = (EmfMap)rtnMap.get("termsInfo");
			if(termsInfo.getString("trsGb").startsWith("CTINF")){
				// 계약안내
				url = "mngwserc/cm/cme/CMEContractInfViewExcel";
			}else{
				// 약관
				url = "mngwserc/cm/cme/CMETermsViewExcel";
			}
			
			modelMap.addAttribute("rtnMap", rtnMap);
			modelMap.addAttribute("dtlMap", dtlMap);
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
	
}
	