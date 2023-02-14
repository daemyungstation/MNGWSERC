package mngwserc.co.main.web;

import java.io.FileNotFoundException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.utl.fcc.service.EgovStringUtil;
import emf.core.exception.EmfException;
import emf.core.extend.web.EmfController;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;
import mngwserc.co.main.service.COMainMngService;

/**
 * <pre> 
 * 메인 페이지 관리 Controller
 * </pre>
 * 
 * @ClassName		: COMainMngController.java
 * @Description		: 메인 페이지 관리 Controller
 * @author inuscomm
 * @since 2019. 04. 19.
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2019. 04. 19.	   inuscomm				                최초생성
 * </pre>
 */

@Controller
@RequestMapping(value="/mngwserc/main")
public class COMainMngController extends EmfController {
	
	/** 서비스 **/
	@Resource(name="coMainMngService")
	private COMainMngService coMainMngService;
	
	/**
     * 메인 화면 조회
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@RequestMapping(value="/index.do")
    public String COMainMng(EmfMap emfMap, ModelMap modelMap) throws Exception {
		try
		{
			String mainGrpId = emfMap.getString("grpId");
			emfMap.put("grpId", mainGrpId);
			
			EmfMap rtnMap = coMainMngService.selectMain(emfMap);
			modelMap.addAttribute("rtnMap", rtnMap);
			modelMap.addAttribute("mainGrpId", mainGrpId);
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		} 	
		return "mngwserc/co/main/COMainMng.admin";
	}
	
	/**
     * 메인 그룹을 LIVE 시키기
     * 
     * @param EmfMap 검색할 데이터
	 * @return ModelAndView 응답 JSON
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
    @RequestMapping(value="/live.ajax", method=RequestMethod.POST)
    public ModelAndView liveMain(HttpServletRequest request, EmfMap emfMap) throws Exception 
    {
    	try
		{
    		emfMap.put("request", request);
    		coMainMngService.liveMain(emfMap);
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
    	mav.addObject("result", "OK");
		mav.setViewName("jsonView");

		return mav; 
    }
    
    /**
     * 메인 visual 이미지 및 텍스트 XY 좌표 수정
     * 
     * @param EmfMap 검색할 데이터
	 * @return ModelAndView 응답 JSON
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
    @RequestMapping(value="/xy.ajax", method=RequestMethod.POST)
    public ModelAndView mainVisualXY(EmfMap emfMap, ModelMap modelMap) throws Exception 
    {
    	try
		{
    		coMainMngService.mainVisualXY(emfMap);
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
    	mav.addObject("result", "OK");
		mav.setViewName("jsonView");

		return mav; 
    }
    
    /**
     * 메인 화면 미리보기
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@RequestMapping(value="/preview.do")
    public String COMainPreview(EmfMap emfMap, ModelMap modelMap) throws Exception {
		try
		{
			String grpId = emfMap.getString("grpId");
			emfMap.put("grpId", grpId);
	
			EmfMap rtnMap = coMainMngService.selectMain(emfMap);
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
		return "mngwserc/co/main/COMainPreview.ajax";
	}
	
    /**
     * 메인 비주얼 영역 목록 화면 모달
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
    @RequestMapping(value="/visual/list.do")
    public String COMainMngVisualList(EmfMap emfMap, ModelMap modelMap) throws Exception 
    {
		//검색어 체크
		String grpId = emfMap.getString("grpId");
		emfMap.put("grpId", grpId);
		
		try
		{
			EmfMap rtnMap = coMainMngService.selectVisualList(emfMap);
			modelMap.addAttribute("rtnMap", rtnMap);
			modelMap.addAttribute("searchGrpId", grpId);
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}
    	
    	return "mngwserc/co/main/COMainMngVisualPop.ajax";
    }
    
    /**
     * 메인 비주얼 영역 등록 화면 모달
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
    @RequestMapping(value="/visual/write.do")
    public String COMainMngVisualWrite(EmfMap emfMap, ModelMap modelMap) throws Exception 
    {    	    	
    	try
		{
    		EmfMap rtnMap = coMainMngService.selectVisualGroup(emfMap);
			modelMap.addAttribute("rtnMap", rtnMap);
			modelMap.addAttribute("searchGrpId", emfMap.getString("grpId"));
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}
    	
    	return "mngwserc/co/main/COMainMngVisualWritePop.ajax";
    }
    
    /**
     * 메인 비주얼 영역 등록
     * 
     * @param EmfMap 검색할 데이터
	 * @return ModelAndView 응답 JSON
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
    @RequestMapping(value="/visual/insert.ajax", method=RequestMethod.POST)
    public ModelAndView insertVisual(HttpServletRequest request, EmfMap emfMap) throws Exception 
    {
    	try
		{
    		emfMap.put("request", request);
    		coMainMngService.insertVisual(emfMap);
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
    	mav.addObject("result", "OK");
		mav.setViewName("jsonView");

		return mav; 
    }
    
    /**
     * 메인 비주얼 영역 수정 화면 모달
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
    @RequestMapping(value="/visual/modify.do")
    public String COMainMngVisualModify(EmfMap emfMap, ModelMap modelMap) throws Exception 
    {    	    	
    	try
		{
    		EmfMap rtnMap = coMainMngService.selectVisual(emfMap);
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
    	
    	return "mngwserc/co/main/COMainMngVisualWritePop.ajax";
    }
    
    /**
     * 메인 비주얼 영역 수정
     * 
     * @param EmfMap 검색할 데이터
	 * @return ModelAndView 응답 JSON
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
    @RequestMapping(value="/visual/update.ajax", method=RequestMethod.POST)
    public ModelAndView updateVisual(HttpServletRequest request, EmfMap emfMap) throws Exception 
    {
    	try
		{
    		emfMap.put("request", request);
    		coMainMngService.updateVisual(emfMap);
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
    	mav.addObject("result", "OK");
		mav.setViewName("jsonView");

		return mav; 
    }
    
    /**
     * 메인 비주얼 영역 삭제
     * 
     * @param EmfMap 검색할 데이터
	 * @return ModelAndView 응답 JSON
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
    @RequestMapping(value="/visual/delete.ajax", method=RequestMethod.POST)
    public ModelAndView deleteVisual(HttpServletRequest request, EmfMap emfMap) throws Exception 
    {
    	try
		{
    		emfMap.put("request", request);
    		coMainMngService.deleteVisual(emfMap);
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
    	mav.addObject("result", "OK");
		mav.setViewName("jsonView");

		return mav; 
    }
    
    /**
     * 메인 비주얼 영역 순서 변경
     * 
     * @param EmfMap 검색할 데이터
	 * @return ModelAndView 응답 JSON
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
    @RequestMapping(value="/visual/order.ajax", method=RequestMethod.POST)
    public ModelAndView orderVisual(HttpServletRequest request, EmfMap emfMap) throws Exception 
    {
    	try
		{
    		emfMap.put("request", request);
    		coMainMngService.orderVisual(emfMap);
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
    	mav.addObject("result", "OK");
		mav.setViewName("jsonView");

		return mav; 
    }
    
    
	/**
     * 메인 컨텐츠 영역 목록 화면 모달
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
    @RequestMapping(value="/content/list.do")
    public String COMainMngContentList(EmfMap emfMap, ModelMap modelMap) throws Exception 
    {
		//검색어 체크
		String grpId = emfMap.getString("grpId");
		emfMap.put("grpId", grpId);
		
		try
		{
			EmfMap rtnMap = coMainMngService.selectContentList(emfMap);
			modelMap.addAttribute("rtnMap", rtnMap);
			modelMap.addAttribute("searchGrpId", grpId);
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}
    	
    	return "mngwserc/co/main/COMainMngContentPop.ajax";
    }
    

    /**
     * 메인 컨텐츠 영역 등록 화면 모달
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
    @RequestMapping(value="/content/write.do")
    public String COMainMngContentWrite(EmfMap emfMap, ModelMap modelMap) throws Exception 
    {    	    	
    	try
		{
    		EmfMap rtnMap = coMainMngService.selectVisualGroup(emfMap);
			modelMap.addAttribute("rtnMap", rtnMap);
			modelMap.addAttribute("searchGrpId", emfMap.getString("grpId"));
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}
    	
    	return "mngwserc/co/main/COMainMngContentWritePop.ajax";
    }
    
    /**
     * 메인 컨텐츠 영역 등록
     * 
     * @param EmfMap 검색할 데이터
	 * @return ModelAndView 응답 JSON
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
    @RequestMapping(value="/content/insert.ajax", method=RequestMethod.POST)
    public ModelAndView insertContent(HttpServletRequest request, EmfMap emfMap) throws Exception 
    {
    	try
		{
    		emfMap.put("request", request);
    		coMainMngService.insertContent(emfMap);
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
    	mav.addObject("result", "OK");
		mav.setViewName("jsonView");

		return mav; 
    }
    
    /**
     * 메인 컨텐츠 영역 수정 화면 모달
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
    @RequestMapping(value="/content/modify.do")
    public String COMainMngContentModify(EmfMap emfMap, ModelMap modelMap) throws Exception 
    {    	    	
    	try
		{
    		EmfMap rtnMap = coMainMngService.selectContent(emfMap);
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
    	
    	return "mngwserc/co/main/COMainMngContentWritePop.ajax";
    }
    
    /**
     * 메인 컨텐츠 영역 수정
     * 
     * @param EmfMap 검색할 데이터
	 * @return ModelAndView 응답 JSON
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
    @RequestMapping(value="/content/update.ajax", method=RequestMethod.POST)
    public ModelAndView updateContent(HttpServletRequest request, EmfMap emfMap) throws Exception 
    {
    	try
		{
    		emfMap.put("request", request);
    		coMainMngService.updateContent(emfMap);
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
    	mav.addObject("result", "OK");
		mav.setViewName("jsonView");

		return mav; 
    }
    
    /**
     * 메인 컨텐츠 영역 삭제
     * 
     * @param EmfMap 검색할 데이터
	 * @return ModelAndView 응답 JSON
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
    @RequestMapping(value="/content/delete.ajax", method=RequestMethod.POST)
    public ModelAndView deleteContent(HttpServletRequest request, EmfMap emfMap) throws Exception 
    {
    	try
		{
    		emfMap.put("request", request);
    		coMainMngService.deleteContent(emfMap);
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
    	mav.addObject("result", "OK");
		mav.setViewName("jsonView");

		return mav; 
    }
    
    /**
     * 메인 컨텐츠 영역 순서 변경
     * 
     * @param EmfMap 검색할 데이터
	 * @return ModelAndView 응답 JSON
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
    @RequestMapping(value="/content/order.ajax", method=RequestMethod.POST)
    public ModelAndView orderContent(HttpServletRequest request, EmfMap emfMap) throws Exception 
    {
    	try
		{
    		emfMap.put("request", request);
    		coMainMngService.orderContent(emfMap);
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
    	mav.addObject("result", "OK");
		mav.setViewName("jsonView");

		return mav; 
    }
    
    /**
     * 메인 컨텐츠 상세 영역 목록 화면
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
    @RequestMapping(value="/contentdtl/list.do")
    public String COMainMngContentDtlList(EmfMap emfMap, ModelMap modelMap) throws Exception 
    {
    	String url = "error/blank.error";
		
		String cntnsMstSeq = emfMap.getString("cntnsMstSeq");
		emfMap.put("cntnsMstSeq", cntnsMstSeq);
		
		try
		{
			EmfMap rtnMap = coMainMngService.selectContentDtlList(emfMap);
			modelMap.addAttribute("cntnsMstSeq", emfMap.getString("cntnsMstSeq"));
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
    	
    	return "mngwserc/co/main/COMainMngContentDtlPop.ajax";
    }
    
    /**
     * 메인 컨텐츠 상세 영역 등록 화면
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
    @RequestMapping(value="/contentdtl/write.do")
    public String COMainMngContentDtlWrite(EmfMap emfMap, ModelMap modelMap) throws Exception 
    {    	    	
    	try
		{
    		modelMap.addAttribute("cntnsMstSeq", emfMap.getString("cntnsMstSeq"));
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}
    	
    	return "mngwserc/co/main/COMainMngContentDtlWritePop.ajax";
    }

    /**
     * 메인 컨텐츠 상세 영역 등록
     * 
     * @param EmfMap 검색할 데이터
	 * @return ModelAndView 응답 JSON
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
    @RequestMapping(value="/contentdtl/insert.ajax", method=RequestMethod.POST)
    public ModelAndView insertContentDtl(HttpServletRequest request, EmfMap emfMap) throws Exception 
    {
    	try
		{
    		emfMap.put("request", request);
    		coMainMngService.insertContentDtl(emfMap);
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
    	mav.addObject("result", "OK");
		mav.setViewName("jsonView");

		return mav; 
    }
    
    /**
     * 메인 컨텐츠 상세 영역 수정 화면
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
    @RequestMapping(value="/contentdtl/modify.do")
    public String COMainMngContentDtlModify(EmfMap emfMap, ModelMap modelMap) throws Exception 
    {    	    	
    	try
		{
    		modelMap.addAttribute("cntnsMstSeq", emfMap.getString("cntnsMstSeq"));
    		EmfMap rtnMap = coMainMngService.selectContentDtl(emfMap);
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
    	
    	return "mngwserc/co/main/COMainMngContentDtlWritePop.ajax";
    }
    
    /**
     * 메인 컨텐츠 상세 영역 수정
     * 
     * @param EmfMap 검색할 데이터
	 * @return ModelAndView 응답 JSON
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
    @RequestMapping(value="/contentdtl/update.ajax", method=RequestMethod.POST)
    public ModelAndView updateContentDtl(HttpServletRequest request, EmfMap emfMap) throws Exception 
    {
    	try
		{
    		emfMap.put("request", request);
    		coMainMngService.updateContentDtl(emfMap);
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
    	mav.addObject("result", "OK");
		mav.setViewName("jsonView");

		return mav; 
    }
    
    /**
     * 메인 컨텐츠 영역 삭제
     * 
     * @param EmfMap 검색할 데이터
	 * @return ModelAndView 응답 JSON
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
    @RequestMapping(value="/contentdtl/delete.ajax", method=RequestMethod.POST)
    public ModelAndView deleteContentDtl(HttpServletRequest request, EmfMap emfMap) throws Exception 
    {
    	try
		{
    		emfMap.put("request", request);
    		coMainMngService.deleteContentDtl(emfMap);
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
    	mav.addObject("result", "OK");
		mav.setViewName("jsonView");

		return mav; 
    }
    
    /**
     * 메인 컨텐츠 상세 영역 순서 변경
     * 
     * @param EmfMap 검색할 데이터
	 * @return ModelAndView 응답 JSON
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
    @RequestMapping(value="/contentdtl/order.ajax", method=RequestMethod.POST)
    public ModelAndView orderContentDtl(HttpServletRequest request, EmfMap emfMap) throws Exception 
    {
    	try
		{
    		emfMap.put("request", request);
    		coMainMngService.orderContentDtl(emfMap);
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
    	mav.addObject("result", "OK");
		mav.setViewName("jsonView");

		return mav; 
    }
}


