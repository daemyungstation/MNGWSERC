package mngwserc.cn.cna.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import mngwserc.cn.cna.service.CNABannerService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import egovframework.com.utl.fcc.service.EgovStringUtil;
import emf.core.exception.EmfException;
import emf.core.extend.web.EmfController;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;

@Controller
@RequestMapping("/mngwserc/cna/banner")
public class CNABannerController extends EmfController {

	/** 서비스 **/
	@Resource(name="cNABannerService")
	private CNABannerService cNABannerService;

	@RequestMapping(value="/{bannerGubun}/list.do")
	public String selectProdcnblList(EmfMap emfMap, ModelMap modelMap, @PathVariable String bannerGubun) throws Exception {
		String url = "error/blank.error";
		
		//검색어 체크
		String f = emfMap.getString("f");
		String q = emfMap.getString("q");	

		String mapping = "";
		if(bannerGubun.equals("MAIN")){
			mapping = "Main";
		} else if (bannerGubun.equals("TOP")){
			mapping = "Top";
		} else {
			mapping = "Floating";
		}
		
		if(!"".equals(EMFStringUtil.nullConvert(q)) && q.length() <= 15){
			emfMap.put("f", f);
			emfMap.put("q", q);
		} else {
			emfMap.put("f", "");
			emfMap.put("q", "");
		}
		
		try
		{
			emfMap.put("bannerGubun", bannerGubun);
			EmfMap rtnMap = cNABannerService.selectBannerList(emfMap);
			modelMap.addAttribute("rtnMap", rtnMap);
			modelMap.addAttribute("bannerGubun", emfMap.getString("bannerGubun"));
			url = "mngwserc/cn/cna/CNA"+mapping+"BannerList.admin";
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			
			if("권한오류".equals(EgovStringUtil.nullConvert(he.getMessage())))
			{
				modelMap.addAttribute("msg", "외주업체로 로그인이 되지 않았습니다.");
				modelMap.addAttribute("url", "/");
			}
			if("설정오류".equals(EgovStringUtil.nullConvert(he.getMessage())))
			{
				modelMap.addAttribute("msg", "조회 조건 설정이 되지 않았습니다.");
				modelMap.addAttribute("url", "/");
			}
			else
			{
				throw new EmfException(he.getMessage());	
			}
		} 
		
		return url;
	}

    @RequestMapping(value="/{bannerGubun}/bannerView.ajax")
    public ModelAndView bannerView(EmfMap emfMap, ModelMap modelMap, @PathVariable String bannerGubun) throws Exception 
    {
    	EmfMap rtnMap = null;
		try
		{
			emfMap.put("bannerGubun", bannerGubun);
			rtnMap = cNABannerService.selectBanner(emfMap);
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}
    	
		ModelAndView mav = new ModelAndView();
		mav.addObject("data", rtnMap);
		mav.setViewName("jsonView");
		return mav; 
    }

	/**
	 * 배너 관리을 수정한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/{bannerGubun}/updateBanner.do", method=RequestMethod.POST)
	public String updateBanner(HttpServletRequest request, EmfMap emfMap, ModelMap modelMap, @PathVariable String bannerGubun) throws Exception
	{
		try
		{
			System.out.println("updateBanner start");
			emfMap.put("request", request);
    		emfMap.put("bannerGubun", bannerGubun);
//			cNABannerService.updateBanner(request, emfMap);		
			cNABannerService.ub(request, emfMap);		
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			
			throw new EmfException(he.getMessage());
		}

		//return "redirect:/mngwserc/cna/prodcnbl/view.do?idx=" + emfMap.getString("idx");  	
		return "redirect:./list.do";
	}
	
	/**
	 * 배너 관리을 삭제한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/{bannerGubun}/bannerDelete.do", method=RequestMethod.POST)
	public String bannerDelete(EmfMap emfMap, ModelMap modelMap, @RequestParam(value="delSeq", required = true) int[] delSeq) throws Exception
	{
		try
		{
			System.out.println("AAAAAAAAAAAAAAAAAAAA"+delSeq[0]);
			emfMap.put("delSeq", delSeq);
//			cNABannerService.deleteBannerList(emfMap);
			cNABannerService.dbl(emfMap);
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}
		
		return "redirect:./list.do";
	}

    /**
     * 제로초이스 (상품 관리 목록 & 이미지 관리 목록) 상세를 조회한다. (등록, 수정 페이지)
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
    @RequestMapping(value="/{bannerGubun}/write.ajax")
    public ModelAndView selectZeroChoise(EmfMap emfMap) throws Exception 
    {    	    	
    	EmfMap rtnMap = null;
    	
    	try
		{
    		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaa");
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}
    	
    	ModelAndView mav = new ModelAndView();
		mav.addObject("data", rtnMap);
		mav.setViewName("jsonView");
		
		return mav;
    }

    /**
     * 제로초이스 (상품 관리 목록 & 이미지 관리 목록) 상세를 조회한다. (등록, 수정 페이지)
     * 
     * @param EmfMap 검색할 데이터
     * @return String View URL
     * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
    @RequestMapping(value="/{bannerGubun}/getBannerPreviewImgPath.ajax")
    public ModelAndView getBannerPreviewImgPath(EmfMap emfMap, @PathVariable String bannerGubun) throws Exception 
    {    	
    	ModelAndView mav = new ModelAndView();
    	try
    	{
    		EmfMap path = cNABannerService.getBannerPreviewImgPath(emfMap);
    			
			mav.addObject("path", path);
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
     * 배너 정보를 등록한다.
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
    @RequestMapping(value="/{bannerGubun}/insertBanner.do", method=RequestMethod.POST)
    public String insertBanner(EmfMap emfMap, ModelMap modelMap, @PathVariable String bannerGubun, HttpServletRequest request) throws Exception 
    {
    	try
		{
    		emfMap.put("request", request);
    		emfMap.put("bannerGubun", bannerGubun);
//    		cNABannerService.insertBanner(emfMap);
    		cNABannerService.ib(emfMap);
		}
    	catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}
    	
    	return "redirect:./list.do";	
    }
}
