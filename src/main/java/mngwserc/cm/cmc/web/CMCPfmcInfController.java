package mngwserc.cm.cmc.web;

import javax.annotation.Resource;

import mngwserc.cm.cmc.service.CMCPfmcInfService;

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
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 공연 정보 관리를 위한 Controller
 * </pre>
 * 
 * @ClassName		: CMCPfmcInfController.java
 * @Description		: 공연정보 관리 위한 Controller
 * @author 허진영
 * @since 2016.02.11
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2016.02.11		허진영					 최초생성
 * </pre>
 */
@Controller
@RequestMapping("/mngwserc/cmc/pfmc")
public class CMCPfmcInfController extends EmfController {
	
	/** 서비스 **/
	@Resource(name="cMCPfmcInfService")
    private CMCPfmcInfService cMCPfmcInfService;
	
	/**
	 * 공연정보 목록을 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/list.do")
	public String selectPfmcInfList(EmfMap emfMap,  ModelMap modelMap) throws Exception
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
			EmfMap rtnMap = cMCPfmcInfService.selectPfmcInfList(emfMap);
			
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
		
		return "mngwserc/cm/cmc/CMCPfmcInfList.admin";
	}
	
	/**
	 * 공연정보 상세를 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/write.do")
	public String selectPfmcInf(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		try
		{
			String pfmcGb = emfMap.getString("pfmcGb");
			
			EmfMap rtnMap = cMCPfmcInfService.selectPfmcInf(emfMap);
			
			modelMap.addAttribute("sPfmcGb", pfmcGb);
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

		return "mngwserc/cm/cmc/CMCPfmcInfWrite.admin";
	}
	
	/**
	 * 공연정보를 등록한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/insert.do", method=RequestMethod.POST)
	public String insertPfmcInf(MultipartHttpServletRequest multiRequest, EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		String url = "error/blank.error";
		
		try
		{
			cMCPfmcInfService.insertPfmcInf(multiRequest, emfMap);
			
			url =  "redirect:/mngwserc/cmc/pfmc/list.do";
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
	 * 공연정보를 수정한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	public String updatePfmcInf(MultipartHttpServletRequest multiRequest, EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		String url = "error/blank.error";
		
		try
		{
			modelMap.addAttribute("f", emfMap.getString("f"));
			modelMap.addAttribute("q", emfMap.getString("q"));
			modelMap.addAttribute("pfmcGb", emfMap.getString("sPfmcGb"));
			modelMap.addAttribute("pageIndex", emfMap.getString("pageIndex"));

			cMCPfmcInfService.updatePfmcInf(multiRequest, emfMap);
			
			url =  "redirect:/mngwserc/cmc/pfmc/write.do?pfmcSeq=" + emfMap.getString("pfmcSeq");
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
	 * 공연정보를 삭제한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/delete.do", method=RequestMethod.POST)
	public String deletePfmcInfList(EmfMap emfMap, ModelMap modelMap, @RequestParam(value="delSeq", required=true) int[] delSeq) throws Exception
	{
		try
		{
			cMCPfmcInfService.deletePfmcInfList(delSeq);
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}
		
		return "redirect:/mngwserc/cmc/pfmc/list.do";
	}
	
	/**
	 * 공연예약정보를 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/rsvtn-write.do")
	public String selectRsvtnInf(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		try
		{
			String pfmcGb = emfMap.getString("pfmcGb");
			EmfMap rtnMap = cMCPfmcInfService.selectRsvtnInf(emfMap);
			
			modelMap.addAttribute("sPfmcGb", pfmcGb);
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

		return "mngwserc/cm/cmc/CMCRsvtnInfWrite.admin";
	}
	
	/**
     * 공연예약정보를 등록한다.
     * @param request
     * @param modelMap
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/rsvtn-insert.ajax", method=RequestMethod.POST)
    public ModelAndView insertRsvtnInf(EmfMap emfMap, ModelMap modelMap) throws Exception
    {
    	ModelAndView mav = new ModelAndView();
    	
    	try
    	{
			cMCPfmcInfService.insertRsvtnInf(emfMap);
			
			mav.addObject("status", "Y");
			
			mav.setViewName("jsonView");
    	}
    	catch(Exception he)
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
