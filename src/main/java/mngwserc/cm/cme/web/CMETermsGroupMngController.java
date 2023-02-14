package mngwserc.cm.cme.web;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import mngwserc.cm.cma.service.DmLifeService;
import mngwserc.cm.cme.service.CMETermsGroupMngService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import egovframework.com.utl.fcc.service.EgovStringUtil;
import emf.core.exception.EmfException;
import emf.core.extend.web.EmfController;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 상품 약관그룹관리를 위한 Controller
 * </pre>
 * 
 * @ClassName		: CMETermsGroupMngController.java
 * @Description		: 상품 약관그룹관리 위한 Controller
 * @author 김필기
 * @since 2016.02.17
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2016.02.17		김필기					 최초생성
 * </pre>
 */
@Controller
@RequestMapping("/mngwserc/cme/termgroup")
public class CMETermsGroupMngController extends EmfController {
	
	/** 서비스 **/
	@Resource(name = "cMETermsGroupMngService")
    private CMETermsGroupMngService cMETermsGroupMngService;

	@Resource(name = "dMLifeService")
    private DmLifeService dMLifeService;

	
	/**
	 * 상품 약관그룹관리 목록을 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/list.do")
	public String selectTermsGroupMngList(EmfMap emfMap,  ModelMap modelMap) throws Exception
	{

		try
		{
			EmfMap rtnMap = cMETermsGroupMngService.selectTermsGroupMngList(emfMap);
			
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
		
		return "mngwserc/cm/cme/CMETermsGroupList.admin";
	}
	
	/**
     * 상품 약관그룹관리 상세를 조회한다. (뷰 페이지)
     * 
     * @param EmfMap 검색할 데이터
     * @return String View URL
     * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
    /*@RequestMapping(value="/view.do")
    public String getTermsGroupMngViewPage(EmfMap emfMap, ModelMap modelMap) throws Exception 
    {
		try
		{
			EmfMap rtnMap = cMETermsGroupMngService.selectTermsGroupMng(emfMap);
			
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
    	
		return "mngwserc/cm/cme/CMETermsGroupView.admin";       	
    }*/
    
	/**
	 *  상품 약관그룹관리 상세를 조회한다. (등록, 수정 페이지)
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	/*@RequestMapping(value="/write.do")
	public String selectTermsGroupMng(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		try
		{
			EmfMap rtnMap = cMETermsGroupMngService.selectTermsGroupMng(emfMap);
			
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

		return "mngwserc/cm/cme/CMETermsGroupWrite.admin";
	}*/
	
	/**
	 * 상품 약관그룹관리을 입력한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/insert.do", method=RequestMethod.POST)
	public String insertTermsGroupMng(MultipartHttpServletRequest multiRequest, EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		String url = "error/blank.error";
		
		try
		{
			cMETermsGroupMngService.insertTermsGroupMng(multiRequest, emfMap);
			
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
		return "redirect:/mngwserc/cme/termgroup/list.do?pageIndex=" + emfMap.getString("pageIndex");
	}
	
	/**
	 * 상품 약관그룹관리을 수정한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	public String updateTermsGroupMng(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		String url = "error/blank.error";
		
		try
		{
			if(!"".equals(emfMap.get("modDtm"))){
				SimpleDateFormat dateFormatParser = new SimpleDateFormat("yyyy-MM-dd");
				try{
					dateFormatParser.parse(emfMap.get("modDtm").toString());
				}catch(Exception he)
				{
					modelMap.addAttribute("msg", "잘못된 날짜 형식입니다.");
					modelMap.addAttribute("url", "/mngwserc/cme/termgroup/list.do");					
					return url;
				}
			}
			
			cMETermsGroupMngService.updateTermsGroupMng(emfMap);
			
			url = "redirect:/mngwserc/cme/termgroup/list.do";
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
	 * 상품 약관그룹관리을 삭제한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/delete.do", method=RequestMethod.POST)
	public String deleteTermsGroupMngList(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		try
		{
			cMETermsGroupMngService.deleteTermsGroupMngList(emfMap);
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}
		
		return "redirect:/mngwserc/cme/termgroup/list.do";
	}
	
	
	/**
	 * 상품 약관그룹관리 로그를 엑셀다운로드한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/excel.do")
	public String excelDownLoad (EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		try
		{			
			modelMap.addAttribute("excelList", cMETermsGroupMngService.logTermGroupLogExcelList(emfMap));
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		} 
		
		return "mngwserc/cm/cme/CMETermsGroupLogExcel";
	}
	
	/**
	 * 상품 목록을 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return Json 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	
	@RequestMapping(value="/productList.do")
	public String selectProductList(EmfMap emfMap, ModelMap modelMap) throws Exception
	{	
		try
		{
			EmfMap rtnMap = dMLifeService.getProductList(emfMap);
			List<EmfMap> rtnAllList = cMETermsGroupMngService.selectTermsGroupMngListAll(emfMap); 

			String pCdList = "";
			for(int i = 0 ; i < rtnAllList.size() ; i++){
				EmfMap tempMap = new EmfMap();
				tempMap = 	rtnAllList.get(i);
				pCdList = pCdList + tempMap.getString("prdctCd") + ",";
			}
			
			rtnMap.put("allList", pCdList);
			
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
		
		return "mngwserc/cm/cme/productListPop.pop";		
	}
	
	/*@RequestMapping(value="/productList.ajax")
	public void selectProductList(EmfMap emfMap, HttpServletResponse response) throws Exception
	{	
		response.setContentType("text/html;charset=UTF-8");
        
		PrintWriter out = response.getWriter();
        
		try 
        {
            List<EmfMap> productList = pRoductMngService.getProductList(emfMap);
            
            JSONArray jSONArray = new JSONArray();
            
            EmfMap jsonMap = null;
            
            for(int i = 0; i < productList.size();)
            {
            	jsonMap = productList.get(i);
            	
                JSONObject jSONObject = new JSONObject();  
                
                //jSONObject.put("data", jsonMap.getString("menuNm"));   
                
                JSONObject jsonAttr = new JSONObject();
                jsonAttr.put("productCode", jsonMap.getString("productCode"));
                jsonAttr.put("productName", jsonMap.get("productName"));
                jSONObject.put("attr", jsonAttr);
                
                jsonAttr = null;
                i++;
                jSONArray.put(jSONObject);
                jSONObject=null;
            }       
            System.out.println(jSONArray);
            
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
	}	*/
	
	/**
	 * 상품 약관그룹관리을 입력한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	/*@RequestMapping(value="/test.do")
	public String selectTermsGroupExcel(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		String url = "error/blank.error";
		
		try
		{
			cMETermsGroupMngService.selectTermsGroupExcel(emfMap);
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			
			throw new EmfException(he.getMessage());
		}

		//return url;    	
		return "mngwserc/cm/cme/CMETermsGroupList.admin";
	}	*/
	
}
