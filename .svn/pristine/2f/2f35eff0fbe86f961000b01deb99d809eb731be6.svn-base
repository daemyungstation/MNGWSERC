package mngwserc.co.cog.web;

import java.util.List;

import javax.annotation.Resource;

import mngwserc.co.cog.service.COGCntnsMngService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import emf.core.exception.EmfException;
import emf.core.extend.web.EmfController;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 컨텐츠 관리를 위한 Controller
 * </pre>
 * 
 * @ClassName		: COGCntnsMngController.java
 * @Description		: 컨텐츠 관리를 위한 Controller
 * @author 박주석
 * @since 2015.11.02
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2015.11.22		박주석					최초생성
 * </pre>
 */
@Controller
@RequestMapping(value="/mngwserc/contentsid")
public class COGCntnsMngController extends EmfController {
	
	// 컨텐츠 서비스 선언
	@Resource(name="cOGCntnsMngService")
	private COGCntnsMngService cOGCntnsMngService;
	 
	/**
	 * 게시글 조회
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/{menuSeq}/index.do", method=RequestMethod.GET)
	public String selectCntnsList(EmfMap emfMap, ModelMap modelMap, @PathVariable int menuSeq) throws Exception
	{
		try
		{
			emfMap.put("menuSeq", menuSeq);
			
			EmfMap rtnMap = cOGCntnsMngService.selectCntnsList(emfMap);

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
		
		return "mngwserc/co/cog/COGCntnsMngList.admin";
	}
	
	/**
	 * CMS 상세보기
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/{menuSeq}/view.do")
	public String selectCntns(EmfMap emfMap, ModelMap modelMap, @PathVariable int menuSeq) throws Exception
	{
		String url = "error/blank.error";
		
		try
		{
			emfMap.put("menuSeq", menuSeq);
			
			EmfMap rtnMap = cOGCntnsMngService.selectCntns(emfMap);
			
			//editor 플레그 값.
			if(!"".equals(EMFStringUtil.nullConvert(emfMap.get("status"))))
			{
				url = "mngwserc/co/cog/COGCntnsEditorView"; 
			}
			else
			{
				url = "mngwserc/co/cog/COGCntnsMngView.admin";
			}
			
			modelMap.addAttribute("rtnMap", rtnMap);
		}
		catch(Exception he) 
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
	 * CMS 등록페이지
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/{menuSeq}/write.do")
	public String getCntnsWritePage(EmfMap emfMap, ModelMap modelMap, @PathVariable int  menuSeq) throws Exception
	{
		try
		{
			emfMap.put("menuSeq", menuSeq);
			
			modelMap.addAttribute("rtnMap", emfMap);
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		} 
		
		return "mngwserc/co/cog/COGCntnsMngWrite.admin";
	}
	
	/**
	 * CMS 등록
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/{menuSeq}/insert.do")
	public String insertCntns(EmfMap emfMap, ModelMap modelMap, @PathVariable int menuSeq) throws Exception
	{
		try
		{
			emfMap.put("menuSeq", menuSeq);
			
			cOGCntnsMngService.insertCntns(emfMap);	//등록
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		} 	
		
		return "redirect:/mngwserc/contentsid/"+menuSeq+"/index.do";
	}
	
	/**
	 * CMS 수정페이지
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/{menuSeq}/modify.do")
	public String getCntnsModifyPage(EmfMap emfMap,  ModelMap modelMap, @PathVariable int menuSeq) throws Exception
	{
		try
		{
			emfMap.put("menuSeq", menuSeq);
			
			EmfMap rtnMap = cOGCntnsMngService.selectCntns(emfMap);
			
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
		
		return "mngwserc/co/cog/COGCntnsMngWrite.admin";
		
	}
	
	/**
	 * CMS 수정처리
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/{menuSeq}/update.do")
	public String updateCntns(EmfMap emfMap, ModelMap modelMap, @PathVariable int menuSeq) throws Exception
	{
		try
		{
			emfMap.put("menuSeq", menuSeq);
			
			cOGCntnsMngService.updateCntns(emfMap);			
		}				
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		} 	
		
		return "redirect:/mngwserc/contentsid/"+menuSeq+"/index.do";
	}
	
	/**
	 * CMS 삭제
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/{menuSeq}/delete.do")
	public String deleteCntns(EmfMap emfMap, ModelMap modelMap, @PathVariable int menuSeq, @RequestParam(value="chk", required=true) int[] delSeq) throws Exception
	{
		try
		{
			emfMap.put("menuSeq", menuSeq);
			emfMap.put("delSeq", delSeq);
			
			cOGCntnsMngService.deleteCntns(emfMap);
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}		
		return "redirect:/mngwserc/contentsid/"+menuSeq+"/index.do";
	}	

	/**
	 * CMS 일반복사
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/{menuSeq}/copy.do")
	public String insertCopyCntns(EmfMap emfMap, ModelMap modelMap, @PathVariable int menuSeq) throws Exception
	{
		try
		{
			emfMap.put("menuSeq", menuSeq);
			
			cOGCntnsMngService.insertCopyCntns(emfMap);	
		}
		catch(Exception he)
		{
			he.printStackTrace();
		}
		
		return "redirect:/mngwserc/contentsid/"+menuSeq+"/index.do";
	}	
	
	/**
	 * CMS 다중 복사시 CMS 리스트 팝업 내용
	 * 
	 * @param EmfMap 데이터
	 * @return String 뷰 URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/{menuSeq}/getCntnsList.ajax")
	public ModelAndView getCntnsList(EmfMap emfMap, ModelMap modelMap, @PathVariable int menuSeq) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		
		try
		{
			List<EmfMap> rtnList = cOGCntnsMngService.getCntnsList(emfMap);
			
			mav.addObject("rtnList", rtnList);
			
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
	
	/**
	 * CMS 다중복사
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/{menuSeq}/multiCopy.do")
	public String insertMultiCopyCntns(EmfMap emfMap, ModelMap modelMap, @PathVariable int menuSeq) throws Exception
	{
		try
		{
			emfMap.put("menuSeq", menuSeq);
			
			cOGCntnsMngService.insertMultiCopyCntns(emfMap);	//복사			
		}
		catch(Exception he)
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}
		
		return "redirect:/mngwserc/contentsid/"+menuSeq+"/index.do";
	}	
	
	/**
	 * CMS 승인 및 즉시 배포 시 게시글 상태 값 체크
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/{menuSeq}/chkStatus.ajax")
	public ModelAndView getPrcsStts(EmfMap emfMap, ModelMap modelMap, @PathVariable int menuSeq) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		
		try
		{
			emfMap.put("menuSeq", menuSeq);
			
			EmfMap rtnMap = cOGCntnsMngService.selectCntns(emfMap);
			
			EmfMap cntnsInfo = (EmfMap) rtnMap.get("cntnsInfo");

			if(cntnsInfo != null)
			{
				mav.addObject("prcsStts", cntnsInfo.getString("prcsStts"));
			}
			
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
		
	/**
	 * CMS 승인 요청처리
	 * 기존 '배포'중인 컨텐츠는 '배포(만료)'로 변경.
	 * 승인 요청 컨텐츠는 '배포' 로 변경 함.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/{menuSeq}/updateApproval.do")
	public String updateApproval(EmfMap emfMap, ModelMap modelMap, @PathVariable int menuSeq) throws Exception
	{
		try
		{
			emfMap.put("menuSeq", menuSeq);			

			cOGCntnsMngService.updateApprovalCntns(emfMap);
			
			/* 2013.12.23 CMS 파일 Handle */
			cOGCntnsMngService.createApprovalCntns(emfMap);
			
		}
		catch(Exception he)
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}		
		
		return "redirect:/mngwserc/contentsid/"+menuSeq+"/index.do";
	}
	
	@RequestMapping(value="/contents/distribution.do")
	public void distributionContentsAll(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		try
		{
			cOGCntnsMngService.selectContentsAllList();
		}
		catch(Exception he)
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}
	}
}
