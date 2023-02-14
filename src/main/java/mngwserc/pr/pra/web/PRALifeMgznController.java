package mngwserc.pr.pra.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import mngwserc.pr.pra.service.PRALifeMgznService;

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
 * 라이프웨이 매거진관리를 위한 Controller
 * </pre>
 * 
 * @ClassName		: CSALifeMgznController.java
 * @Description		: 라이프웨이 매거진관리 위한 Controller
 * @author 허진영
 * @since 2016.02.16
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2016.02.16		허진영					 최초생성
 * </pre>
 */
@Controller
@RequestMapping("/mngwserc/pr-center/lifeway-magazine")
public class PRALifeMgznController extends EmfController {
	
	/** 서비스 **/
	@Resource(name = "pRALifeMgznService")
    private PRALifeMgznService pRALifeMgznService;
	
	/**
	 * 라이프웨이 매거진 목록을 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/index.do")
	public String selectLifeMgznList(EmfMap emfMap,  ModelMap modelMap) throws Exception
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
			EmfMap rtnMap = pRALifeMgznService.selectLifeMgznList(emfMap);
			
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
		
		return "mngwserc/pr/pra/PRAMgznList.admin";
	}
	
	/**
     * 라이프웨이 매거진 상세를 조회한다. (뷰 페이지)
     * 
     * @param EmfMap 검색할 데이터
     * @return String View URL
     * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
    @RequestMapping(value="/view.do")
    public String getLifeMgznViewPage(EmfMap emfMap, ModelMap modelMap) throws Exception 
    {
		try
		{
			EmfMap rtnMap = pRALifeMgznService.selectLifeMgzn(emfMap);
			
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
    	
		return "mngwserc/pr/pra/PRAMgznView.admin";   
    	
    }
    
	/**
	 *  라이프웨이 매거진 상세를 조회한다. (등록, 수정 페이지)
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/write.do")
	public String selectLifeMgzn(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		try
		{
			EmfMap rtnMap = pRALifeMgznService.selectLifeMgzn(emfMap);
			
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

		return "mngwserc/pr/pra/PRAMgznWrite.admin";
	}
	
	/**
	 * 라이프웨이 매거진을 입력한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/insert.do", method=RequestMethod.POST)
	public String insertLifeMgzn(MultipartHttpServletRequest multiRequest, EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		String url = "error/blank.error";
		
		try
		{
			pRALifeMgznService.insertLifeMgzn(multiRequest, emfMap);
			
			url = "redirect:./index.do";
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
	 * 라이프웨이 매거진을 수정한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	public String updateLifeMgzn(MultipartHttpServletRequest multiRequest, EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		String url = "error/blank.error";
		
		try
		{
			pRALifeMgznService.updateLifeMgzn(multiRequest, emfMap);
			
			url = "redirect:./view.do?mgznSeq=" + emfMap.getString("mgznSeq");
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
	 * 라이프웨이 매거진을 삭제한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/delete.do", method=RequestMethod.POST)
	public String deleteLifeMgznList(EmfMap emfMap, ModelMap modelMap, @RequestParam(value="delSeq", required=true) int[] delSeq) throws Exception
	{
		try
		{
			pRALifeMgznService.deleteLifeMgznList(delSeq);
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
	 * 라이프웨이 매거진 발간년도 중복확인.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */	
	@RequestMapping(value="/getMgznPbtnYrChk.ajax", method=RequestMethod.POST)
	public ModelAndView getMgznPbtnYrChk(EmfMap emfMap,  ModelMap modelMap, HttpServletResponse response) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		
		try
		{
			int chk = 0;
			
			if(!"".equals(EMFStringUtil.nullConvert(emfMap.get("mgznPbtnYr"))))
			{
				chk = pRALifeMgznService.getMgznPbtnYrChk(emfMap);
			}

			String mgznPbtnYr_chk = "";		
			
			if(chk > 0)
			{
				mgznPbtnYr_chk = "N";
			}
			else
			{
				mgznPbtnYr_chk = "Y";
			}		
			
			mav.addObject("mgznPbtnYr_chk", mgznPbtnYr_chk);
			
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
