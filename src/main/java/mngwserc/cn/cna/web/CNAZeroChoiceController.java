package mngwserc.cn.cna.web;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mngwserc.cn.cna.CNAFileUtil;
import mngwserc.cn.cna.GetAllMapValue;
import mngwserc.cn.cna.service.CNAZeroChoiceService;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import egovframework.com.cmm.service.EgovProperties;
import emf.core.exception.EmfException;
import emf.core.extend.web.EmfController;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 다이렉트 채널 > 컨텐츠 관리 > 제로초이스를 위한 Controller
 * </pre>
 * 
 * @ClassName		: CNAZeroChoiceController.java
 * @Description		: 제로초이스를 위한 Controller
 * @author 강재석
 * @since 2018.02.22
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2018.02.22		강재석					 최초생성
 * </pre>
 */

@Controller
@RequestMapping(value="/mngwserc/cna/{zeroChoiGb}")
public class CNAZeroChoiceController extends EmfController {

	@Resource(name = "cNAZeroChoiceService")
	private CNAZeroChoiceService cNAZeroChoiceService;
	
	/**
	 * 제로초이스 (상품 관리 목록 & 이미지 관리 목록)을 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value={"/list.do"})
	public String selectZeroChoiseList(EmfMap emfMap, ModelMap modelMap, @PathVariable String zeroChoiGb) throws Exception
	{
		if(!"prdmgr".equals(zeroChoiGb) && !"catemgr".equals(zeroChoiGb) && !"imgmgr".equals(zeroChoiGb))
    	{
    		throw new FileNotFoundException();
    	}
		
    	//검색어 체크
		String f1 = emfMap.getString("f1");
		String f2 = emfMap.getString("f2");
		String q = emfMap.getString("q");	
		
		if(!"".equals(EMFStringUtil.nullConvert(q)) && q.length() <= 15)
		{
			emfMap.put("f1", f1);
			emfMap.put("f2", f2);
			emfMap.put("q", q);
		}
		else
		{
			emfMap.put("f1", "");
			emfMap.put("q", "");
		}
		
		if("catemgr".equals(zeroChoiGb)) {
			return "mngwserc/cn/cna/CNAZeroChoiCate.admin";
		}
		
		try
		{
			emfMap.put("zeroChoiGb", zeroChoiGb);

			EmfMap rtnMap = null;
			
			if("prdmgr".equals(zeroChoiGb)) 
			{
				List<EmfMap> cateList = cNAZeroChoiceService.getZeroChoiCateList(emfMap);
				
				rtnMap = cNAZeroChoiceService.selectZeroChoiPrdMgrList(emfMap);
				rtnMap.put("cateList", cateList);
			} 
			else
			{
				rtnMap = cNAZeroChoiceService.selectZeroChoiImgMgrList(emfMap);
			}
			
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
    	
		return "mngwserc/cn/cna/CNAZeroChoiList.admin";
	}
	
    /**
     * 제로초이스 (상품 관리 목록 & 이미지 관리 목록) 상세를 조회한다. (뷰 페이지)
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
    @RequestMapping(value="/view.ajax")
    public ModelAndView getZeroChoiseViewPage(HttpServletRequest request, EmfMap emfMap, ModelMap modelMap, @PathVariable String zeroChoiGb) throws Exception 
    {
    	if(!"prdmgr".equals(zeroChoiGb) && !"imgmgr".equals(zeroChoiGb))
    	{
    		throw new FileNotFoundException();
    	}
    	
    	EmfMap rtnMap = null;
    		
		try
		{
			emfMap.put("zeroChoiGb", zeroChoiGb);
    		
			if("prdmgr".equals(zeroChoiGb)) 
			{
				rtnMap = cNAZeroChoiceService.selectZeroChoisePrdMgr(emfMap);
			} 
			else
			{
				rtnMap = cNAZeroChoiceService.selectZeroChoiImgMgr(emfMap);
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
    @RequestMapping(value="/write.ajax")
    public ModelAndView selectZeroChoise(EmfMap emfMap, @PathVariable String zeroChoiGb) throws Exception 
    {    	
    	if(!"prdmgr".equals(zeroChoiGb) && !"imgmgr".equals(zeroChoiGb))
    	{
    		throw new FileNotFoundException();
    	}
    	
    	EmfMap rtnMap = null;
    	
    	try
		{
    		emfMap.put("zeroChoiGb", zeroChoiGb);
    		
			if("prdmgr".equals(zeroChoiGb)) 
			{
				rtnMap = cNAZeroChoiceService.selectZeroChoisePrdMgr(emfMap);
			} 
			else
			{
				rtnMap = cNAZeroChoiceService.selectZeroChoiImgMgr(emfMap);
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
    	
    	ModelAndView mav = new ModelAndView();
		mav.addObject("data", rtnMap);
		mav.setViewName("jsonView");
		
		return mav;
    }
    
    /**
     * 다이렉트 초이스 미리보기 상세를 조회한다.
     * 
     * @param EmfMap 검색할 데이터
     * @return String View URL
     * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
	@RequestMapping(value={"/previewImg.do"})
	public void previewImgFile(EmfMap emfMap, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String fileSeq = request.getParameter("fileSeq");
		emfMap.put("fileSeq", fileSeq);
		
		EmfMap fvo = cNAZeroChoiceService.selectFileInfoByFileSeq(emfMap);
		
		CNAFileUtil.getImageInf(fvo, response);
	}
    
    /**
     * 제로초이스 (상품 관리 목록 & 이미지 관리 목록)를 등록한다.
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
    @RequestMapping(value="/insert.do", method=RequestMethod.POST)
    public String insertZeroChoise(EmfMap emfMap, ModelMap modelMap, @PathVariable String zeroChoiGb, HttpServletRequest request) throws Exception 
    {
    	if(!"prdmgr".equals(zeroChoiGb) && !"imgmgr".equals(zeroChoiGb))
    	{
    		throw new FileNotFoundException();
    	}
    	
    	try
		{
    		emfMap.put("zeroChoiGb", zeroChoiGb);
    		emfMap.put("request", request);
    		
    		if("prdmgr".equals(zeroChoiGb)) 
			{
//    			cNAZeroChoiceService.insertZeroChoisePrdMgr(emfMap);
    			cNAZeroChoiceService.izcpm(emfMap);
			} 
			else
			{
//				cNAZeroChoiceService.insertZeroChoiseImgMgr(emfMap);
				cNAZeroChoiceService.izcim(emfMap);
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
    	
    	return "redirect:./list.do";    	
    }
    
    /**
     * 제로초이스 (상품 관리 목록 & 이미지 관리 목록)를 수정한다.
     * 
     * @param EmfMap 검색데이터
     * @return String View URL
     * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
    @RequestMapping(value="/update.do", method=RequestMethod.POST)
    public String updateZeroChoise(EmfMap emfMap, ModelMap modelMap, @PathVariable String zeroChoiGb, HttpServletRequest request) throws Exception 
    {
    	if(!"prdmgr".equals(zeroChoiGb) && !"imgmgr".equals(zeroChoiGb))
    	{
    		throw new FileNotFoundException();
    	}
    	
    	try
		{
    		emfMap.put("zeroChoiGb", zeroChoiGb);
    		emfMap.put("request", request);
		    
    		if("prdmgr".equals(zeroChoiGb)) 
			{
//    			cNAZeroChoiceService.updateZeroChoisePrdMgr(emfMap);
    			cNAZeroChoiceService.uzcpm(emfMap);
			} 
			else
			{
//				cNAZeroChoiceService.updateZeroChoiseImgMgr(emfMap);
				cNAZeroChoiceService.uizcim(emfMap);
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
    	
//    	return "redirect:./view.do?oprtGuideSeq=" + emfMap.getString("oprtGuideSeq");    	
    	return "redirect:./list.do";
    }
    
    /**
	 * 제로초이스 (상품 관리 목록 & 이미지 관리 목록)를 삭제한다.
	 * 
	 * @param EmfMap 검색데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */	
	@RequestMapping(value="/delete.do", method=RequestMethod.POST)
	public String deleteZeroChoiseList(EmfMap emfMap
												, @PathVariable String zeroChoiGb
												, @RequestParam(value="delSeq", required=true) int[] delSeq) throws Exception
	{
		if(!"prdmgr".equals(zeroChoiGb) && !"imgmgr".equals(zeroChoiGb))
    	{
    		throw new FileNotFoundException();
    	}
    	
    	try
		{
    		emfMap.put("zeroChoiGb", zeroChoiGb);
    		emfMap.put("delSeq", delSeq);

//			cNBOprtGuideService.deleteZeroChoiseList(delSeq);
			cNAZeroChoiceService.dzcl(emfMap);
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
	 * 카테고리 메뉴를 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return Json 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/getCateJson.ajax")
	public void getMenuList(EmfMap emfMap, HttpServletResponse response) throws Exception
	{	
		response.setContentType("text/html;charset=UTF-8");
        
		PrintWriter out = response.getWriter();
        
		try 
        {
            List<EmfMap> cateList = cNAZeroChoiceService.getZeroChoiCateList(emfMap);
            
            JSONArray jSONArray = new JSONArray();
            
            EmfMap jsonMap = null;
            
            for(int i = 0; i < cateList.size();)
            {
            	jsonMap = cateList.get(i);
            	
                JSONObject jSONObject = new JSONObject();  

                jSONObject.put("data", jsonMap.getString("cateNm"));   
                
                JSONObject jsonAttr = new JSONObject();
                jsonAttr.put("id", "node_" + jsonMap.getString("cateSeq"));
//                jsonAttr.put("rel", jsonMap.getString("menuGb"));
                jsonAttr.put("rel", "cms");
                //jsonAttr.put("parent_treeid", jsonMap.getString("parntSeq"));
                //jsonAttr.put("level", jsonMap.getString("dpth"));
                //jsonAttr.put("status", jsonMap.getString("userUseYn"));
                //jsonAttr.put("link", jsonMap.getString("userLink"));
                //jsonAttr.put("treeid", jsonMap.getString("menuSeq"));
                jSONObject.put("attr", jsonAttr);
                
                jsonAttr=null;
                i++;
                jSONArray.put(jSONObject);
                jSONObject=null;
            }       
            
            out.print(jSONArray);
            jSONArray=null;
        }
        catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		} 	
        finally 
        {
            out.close();
        }
	}

	/**
	 * 카테고리를 생성한다.
	 * 
	 * @param EmfMap 데이터
	 * @return String 뷰 URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value ="/insertCateMenu.ajax", method=RequestMethod.POST)
	public ModelAndView insertMenu(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		// pstn 1번부터 시작
		emfMap.put("pstn", Integer.parseInt(emfMap.getString("pstn")) + 1);
		
		ModelAndView mav = new ModelAndView();
		
		try
		{			
			
			GetAllMapValue.getMapValue(emfMap);
//			int insMenuSeq = cNAZeroChoiceService.insertCateMenu(emfMap);
			cNAZeroChoiceService.icm(emfMap);
			
			mav.addObject("insMenuSeq", emfMap.getString("cateSeq"));
			
			mav.setViewName("jsonView");
		}
		catch (Exception he) 
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
	 * 카테고리를 수정한다.
	 * 
	 * @param EmfMap 데이터
	 * @return String 뷰 URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value ="/updateCateMenuNm.ajax", method=RequestMethod.POST)
	public ModelAndView updateCateMenuNm(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		
		try
		{			
//			int updCnt = cNAZeroChoiceService.updateCateMenuNm(emfMap);
			int updCnt = cNAZeroChoiceService.ucmn(emfMap);
			
			mav.addObject("updCnt", updCnt);
			
			mav.setViewName("jsonView");
		}
		catch (Exception he) 
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
	 * 카테고리를 삭제한다.
	 * 
	 * @param EmfMap 데이터
	 * @return String 뷰 URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value ="/deleteCateMenu.ajax", method=RequestMethod.POST)
	public ModelAndView deleteCateMenu(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		
		try
		{		
			List<EmfMap> prdList = cNAZeroChoiceService.selectZeroChoiPrdMgrListByCateSeq(emfMap);
			if(prdList.size() > 0) {
				return null;
			}
			
			EmfMap map = cNAZeroChoiceService.getPstnByCateSeq(emfMap);
			emfMap.put("pstn", map.getString("pstn"));
//			int delCnt = cNAZeroChoiceService.deleteCateMenu(emfMap);
			// 카테고리 삭제
			int delCnt = cNAZeroChoiceService.dcm(emfMap);
			
			// 카테고리 삭제후 PSTN 다시 정렬
//			cNAZeroChoiceService.updateCatePstnAfterDelete(emfMap);
			cNAZeroChoiceService.ucpad(emfMap);
			
			mav.addObject("delCnt", delCnt);
			
			mav.setViewName("jsonView");
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he.getMessage());
            }
			throw new EmfException(he.getMessage());
		} 	
		
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value="/cateAllDel.ajax", method=RequestMethod.GET)
	public void cateAllDel(EmfMap emfMap) throws Exception
	{
		try
		{			
			cNAZeroChoiceService.cateAllDel(emfMap);
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he.getMessage());
			}
			throw new EmfException(he.getMessage());
		} 	
		
	}

	@ResponseBody
	@RequestMapping(value="/cateWrite.ajax", method=RequestMethod.POST)
	public void cateWrite(HttpServletRequest request, EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		try
		{			
			cNAZeroChoiceService.cateWrite(emfMap);
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he.getMessage());
            }
			throw new EmfException(he.getMessage());
		} 	
	}
	
		/**
		 * 메뉴를 이동한다.
		 * 
		 * @param EmfMap 데이터
		 * @return String 뷰 URL
		 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
		 */
		@RequestMapping(value="/updateCateMenuPstn.ajax", method=RequestMethod.POST)
		public ModelAndView updateMenuPstn(EmfMap emfMap, ModelMap modelMap) throws Exception
		{
			emfMap.put("pstn", Integer.parseInt(emfMap.getString("pstn")) + 1);
			
		ModelAndView mav = new ModelAndView();
		
		try
		{	
			System.out.println(">>>>>>>>>>>>>");
			GetAllMapValue.getMapValue(emfMap);
			
			EmfMap map1 = cNAZeroChoiceService.getPstnByCateSeq(emfMap);	// 선택된 카테고리의 순서
			
			int sPstn = Integer.parseInt(map1.getString("pstn"));
			int ePstn = Integer.parseInt(emfMap.getString("pstn"));
			
			EmfMap param = new EmfMap();
			
			System.out.println("start PSTN : " + sPstn + " / end PSTN : " + (ePstn-1));
			
			if(sPstn < ePstn) {	// 위에서 아래로 이동할 경우
				param.put("sPstn", sPstn);
				param.put("ePstn", ePstn-1);
				emfMap.put("pstn", Integer.parseInt(emfMap.getString("pstn"))-1);
				
				System.out.println("=====위에서 아래로 이동======");
//				cNAZeroChoiceService.updateCateMove1(param);
				cNAZeroChoiceService.ucm1(param);
			
			} else if(sPstn > ePstn) {		// 뒤에서 앞으로 이동할 경우
				param.put("sPstn", sPstn);
				param.put("ePstn", ePstn);
				
				System.out.println("=====아래에서 위로 이동======");
//				cNAZeroChoiceService.updateCateMove2(param);
				cNAZeroChoiceService.ucm2(param);
			} else {
				System.out.println("=====같은곳======");
			}
			
			
			
			// 원래 자리에 있던 카테고리를 변경
//			cNAZeroChoiceService.updateCateMenuPstnBefore(emfMap);
//			cNAZeroChoiceService.ucpb(emfMap);
			
//			cNAZeroChoiceService.updateCateMenuPstn(emfMap);
			// 카테고리 순서 변경
			cNAZeroChoiceService.ucp(emfMap);
        	
        	mav.addObject("moveYn", "Y");
			
			mav.setViewName("jsonView");
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
}
