/**
 * 
 */
package mngwserc.bm.bma.web;

import javax.annotation.Resource;

import mngwserc.bm.bma.service.BMABoardCommentService;
import mngwserc.bm.bma.service.BMABoardMngService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import emf.core.exception.EmfException;
import emf.core.extend.web.EmfController;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 게시글 댓글 관리를 위한 Controller
 * </pre>
 * 
 * @ClassName		: BMABoardCommentController.java
 * @Description		: 게시글 댓글 관리를 위한 Controller
 * @author 허진영
 * @since 2016.04.12
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since		   author				  description
 *   ==========    ==============    =============================
 *   2016.04.12		   허진영				   최초 생성
 * </pre>
 */
@Controller
public class BMABoardCommentController extends EmfController {
	
	// 게시판 관리 서비스 선언
	@Resource(name="bMABoardMngService")
	private BMABoardMngService bMABoardMngService;
	
	// 게시판 덧글관리 서비스 선언
	@Resource(name="bMABoardCommentService")
	private BMABoardCommentService bMABoardCommentService;
 
	/**
     * 게시글에 대한 댓글을 조회한다.
     * 
     * @param EmfMap 데이터
	 * @return String 뷰 URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */  	
	@RequestMapping(value={"/mngwserc/communityid/{communityid}/commentlist.ajax", "/mngwserc/**/communityid/{communityid}/commentlist.ajax"})
	public String selectBoardCommentList(EmfMap emfMap, ModelMap modelMap, @PathVariable int communityid) throws Exception
	{
		try
		{
			emfMap.put("communityId", communityid);
			
			//게시판 속성정보 한 건을 상세조회한다.
			EmfMap mstInfo = bMABoardMngService.selectMaster(emfMap);
			
			if(mstInfo != null && "Y".equals(mstInfo.getString("useYn")) && "Y".equals(mstInfo.getString("commentYn")))
			{
				emfMap.put("tablenm", mstInfo.getString("tablenm"));
				
				EmfMap rtnMap = bMABoardCommentService.selectBoardCommentList(emfMap);
				
				modelMap.addAttribute("rtnMap", rtnMap);
				modelMap.addAttribute("mstInfo", mstInfo);
			}
		}
		catch(Exception he)
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}

		return "mngwserc/bm/bma/BMABoardCommentList";
	}
	
	/**
     * 게시글에 대한 댓글을 등록한다.
     * 
     * @param EmfMap 데이터
	 * @return String 뷰 URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */ 
	@RequestMapping(value={"/mngwserc/communityid/{communityid}/insertComment.ajax", "/mngwserc/**/communityid/{communityid}/insertComment.ajax"}, method=RequestMethod.POST)
	public ModelAndView insertBoardComment(EmfMap emfMap, ModelMap modelMap, @PathVariable int communityid) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		
		try
		{
			emfMap.put("communityId", communityid);
			
			// 게시판 속성정보 한 건을 상세조회한다.
			EmfMap mstInfo = bMABoardMngService.selectMaster(emfMap);
			
			if(mstInfo != null && "Y".equals(mstInfo.getString("useYn")) && "Y".equals(mstInfo.getString("commentYn")))
			{
				emfMap.put("tablenm", mstInfo.getString("tablenm"));
				
				bMABoardCommentService.insertBoardComment(emfMap);
				
				mav.addObject("status", "Y");
				
				mav.setViewName("jsonView");
			}
		}
		catch(Exception he)
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he.getMessage());
            }
			throw new EmfException(he.getMessage());
		}			
		
		return mav;
	}
	
	/**
     * 게시글에 대한 댓글을 수정한다.
     * 
     * @param EmfMap 데이터
	 * @return String 뷰 URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */ 
	@RequestMapping(value={"/mngwserc/communityid/{communityid}/updateComment.ajax", "/mngwserc/**/communityid/{communityid}/updateComment.ajax"}, method=RequestMethod.POST)
	public ModelAndView updateBoardComment(EmfMap emfMap, ModelMap modelMap, @PathVariable int communityid) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		
		try
		{
			emfMap.put("communityId", communityid);
			
			// 게시판 속성정보 한 건을 상세조회한다.
			EmfMap mstInfo = bMABoardMngService.selectMaster(emfMap);
			
			if(mstInfo != null && "Y".equals(mstInfo.getString("useYn")) && "Y".equals(mstInfo.getString("commentYn")))
			{
				emfMap.put("tablenm", mstInfo.getString("tablenm"));
				
				bMABoardCommentService.updateBoardComment(emfMap);
				
				mav.addObject("status", "Y");
				
				mav.setViewName("jsonView");
			}
		}
		catch(Exception he)
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he.getMessage());
            }
			throw new EmfException(he.getMessage());
		}			
		
		return mav;
	}	
	
	/**
     * 게시글에 대한 댓글을 삭제한다.
     * 
     * @param EmfMap 데이터
	 * @return String 뷰 URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */ 
	@RequestMapping(value={"/mngwserc/communityid/{communityid}/deleteComment.ajax", "/mngwserc/**/communityid/{communityid}/deleteComment.ajax"}, method=RequestMethod.POST)
	public ModelAndView deleteBoardComment(EmfMap emfMap, ModelMap modelMap, @PathVariable int communityid) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		
		try
		{
			emfMap.put("communityId", communityid);
			
			// 게시판 속성정보 한 건을 상세조회한다.
			EmfMap mstInfo = bMABoardMngService.selectMaster(emfMap);
			
			if(mstInfo != null && "Y".equals(mstInfo.getString("useYn")) && "Y".equals(mstInfo.getString("commentYn")))
			{
				emfMap.put("tablenm", mstInfo.getString("tablenm"));
				
				bMABoardCommentService.deleteBoardComment(emfMap);
				
				mav.addObject("status", "Y");
				
				mav.setViewName("jsonView");
			}
		}
		catch(Exception he)
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he.getMessage());
            }
			throw new EmfException(he.getMessage());
		}			
		
		return mav;
	}	
	
	/**
     * 댓글 숨기기(상태값 변경)
     * 
     * @param EmfMap 데이터
	 * @return String 뷰 URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */ 
	@RequestMapping(value={"/mngwserc/communityid/{communityid}/commentUseYn.ajax", "/mngwserc/**/communityid/{communityid}/commentUseYn.ajax"}, method=RequestMethod.POST)
	public ModelAndView updateBoardStatus(EmfMap emfMap, ModelMap modelMap, @PathVariable int communityid) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		
		try
		{
			emfMap.put("communityId", communityid);
			
			// 게시판 속성정보 한 건을 상세조회한다.
			EmfMap mstInfo = bMABoardMngService.selectMaster(emfMap);
			
			if(mstInfo != null && "Y".equals(mstInfo.getString("useYn")) && "Y".equals(mstInfo.getString("commentYn")))
			{
				emfMap.put("tablenm", mstInfo.getString("tablenm"));
				
				bMABoardCommentService.updateBoardStatus(emfMap);
				
				mav.addObject("status", "Y");
				
				mav.setViewName("jsonView");
			}
		}
		catch(Exception he)
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he.getMessage());
            }
			throw new EmfException(he.getMessage());
		}			
		
		return mav;
	}
	
	/**
	 * 댓글 목록 조회(엑셀다운)
	 * 
	 * @param EmfMap 데이터
	 * @return URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value={"/mngwserc/communityid/{communityid}/excelComment.do", "/mngwserc/**/communityid/{communityid}/excelComment.do"})
	public String excelBoardCommentList(EmfMap emfMap, ModelMap modelMap, @PathVariable int communityid) throws Exception
	{
		try
		{			
			emfMap.put("communityId", communityid);
			
			// 게시판 속성정보 한 건을 상세조회한다.
			EmfMap mstInfo = bMABoardMngService.selectMaster(emfMap);
			
			if(mstInfo != null && "Y".equals(mstInfo.getString("useYn")) && "Y".equals(mstInfo.getString("commentYn")))
			{
				emfMap.put("tablenm", mstInfo.getString("tablenm"));
				
				modelMap.addAttribute("excelList", bMABoardCommentService.excelBoardCommentList(emfMap));
			}
			
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		} 
		
		return "mngwserc/bm/bma/BMACommentExcel";
	}
}
