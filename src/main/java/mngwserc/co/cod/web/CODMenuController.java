package mngwserc.co.cod.web;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import mngwserc.co.cod.service.CODMenuService;
import mngwserc.co.cog.service.COGCntnsMngService;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import emf.core.exception.EmfException;
import emf.core.extend.web.EmfController;
import emf.core.vo.EmfMap;
/**
 * <pre> 
 * 메뉴 관리를 위한 Controller
 * </pre>
 * 
 * @ClassName		: CODMenuController.java
 * @Description		: 메뉴 관리를 위한 Controller
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
@RequestMapping(value="/mngwserc/cod/adm")
public class CODMenuController extends EmfController {
	
	/** 메뉴 서비스 **/
	@Resource(name = "cODMenuService")
	private CODMenuService cODMenuService;
	
	/** 콘텐츠 서비스 **/
	@Resource(name="cOGCntnsMngService")
	private COGCntnsMngService cOGCntnsMngService;
	
	/**
	 * 관리자 메뉴 관리 페이지
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return Json 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/index.do")
	public String getAdmMenuPage(EmfMap emfMap, ModelMap modelMap) throws Exception
	{		
		return "mngwserc/co/cod/CODAdmMenu.admin";
	}
	
	/**
	 * 관리자 메뉴를 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return Json 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/getJson.ajax")
	public void getMenuList(EmfMap emfMap, HttpServletResponse response) throws Exception
	{	
		response.setContentType("text/html;charset=UTF-8");
        
		PrintWriter out = response.getWriter();
        
		try 
        {
            List<EmfMap> menuList = cODMenuService.getMenuList(emfMap);
            
            JSONArray jSONArray = new JSONArray();
            
            EmfMap jsonMap = null;
            
            for(int i = 0; i < menuList.size();)
            {
            	jsonMap = menuList.get(i);
            	
                JSONObject jSONObject = new JSONObject();  
                
                if(Integer.parseInt( jsonMap.getString("childcnt") ) > 0)
                {
                	jSONObject.put("state", "closed");
                }
                
                jSONObject.put("data", jsonMap.getString("menuNm"));   
                
                JSONObject jsonAttr = new JSONObject();
                jsonAttr.put("id", "node_" + jsonMap.getString("menuSeq"));
                jsonAttr.put("rel", jsonMap.getString("menuGb"));
                jsonAttr.put("parent_treeid", jsonMap.getString("parntSeq"));
                jsonAttr.put("level", jsonMap.getString("dpth"));
                jsonAttr.put("status", jsonMap.getString("userUseYn"));
                jsonAttr.put("link", jsonMap.getString("userLink"));
                jsonAttr.put("treeid", jsonMap.getString("menuSeq"));
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
	 * 카테고리의 상세정보를 가져온다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return Json 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/selectMenuDtl.ajax")
	public ModelAndView selectMenuDtl(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		
        try 
        {
			EmfMap rtnMap = cODMenuService.selectMenuDtl(emfMap);
			
			mav.addObject("rtnMap", rtnMap);
			
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
	 * 메뉴를 생성한다.
	 * 
	 * @param EmfMap 데이터
	 * @return String 뷰 URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value ="/insertMenu.ajax", method=RequestMethod.POST)
	public ModelAndView insertMenu(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		
		try
		{			
			int insMenuSeq = cODMenuService.insertMenu(emfMap);
			
			mav.addObject("insMenuSeq", insMenuSeq);
			
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
	 * 메뉴명을 수정한다.
	 * 
	 * @param EmfMap 데이터
	 * @return String 뷰 URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value ="/updateMenuNm.ajax", method=RequestMethod.POST)
	public ModelAndView updateMenuNm(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		
		try
		{			
			int updCnt = cODMenuService.updateMenuNm(emfMap);
			
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
	 * 메뉴를 삭제한다.
	 * 
	 * @param EmfMap 데이터
	 * @return String 뷰 URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value ="/deleteMenu.ajax", method=RequestMethod.POST)
	public ModelAndView deleteMenu(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		
		try
		{			
			int delCnt = cODMenuService.deleteMenu(emfMap);
			
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
	
	/**
	 * 메뉴를 이동한다.
	 * 
	 * @param EmfMap 데이터
	 * @return String 뷰 URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/updateMenuPstn.ajax", method=RequestMethod.POST)
	public ModelAndView updateMenuPstn(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		
		try
		{		
        	cODMenuService.updateMenuPstn(emfMap);
        	
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
	
	/**
	 * 메뉴정보를 수정한다.
	 * 
	 * @param EmfMap 데이터
	 * @return String 뷰 URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/updateMenuInf.ajax", method=RequestMethod.POST)
	public ModelAndView updateMenuInf(EmfMap emfMap, ModelMap modelMap) throws Exception
	{		
		ModelAndView mav = new ModelAndView();
		
		try
		{	
			if("cms".equals(emfMap.getString("menuGb")))
			{
				//컨텐츠 생성 로직 들어감.
				cOGCntnsMngService.createCntns(emfMap);
			}
			else
			{	
				cODMenuService.updateMenuInf(emfMap);;
			}
			
			mav.addObject("status", "Y");
			
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
	
	/**
	 * 게시판 카테고리의 노출 정보를 수정
	 * 
	 * @param EmfMap 데이터
	 * @return String 뷰 URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/updateUserUseYn.ajax", method=RequestMethod.POST)
	public ModelAndView updateTreesStatusInfo(EmfMap emfMap, ModelMap modelMap) throws Exception
	{		
		ModelAndView mav = new ModelAndView();
		
		try
		{	
			int updCnt = cODMenuService.updateUserUseYn(emfMap);
			
			mav.addObject("updCnt", updCnt);
			
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
	
	/**
     * 상위부모를 다 가져온다.
     * 
     * @param EmfMap 데이터
	 * @return String 뷰 URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@RequestMapping(value="/getParntData.ajax", method=RequestMethod.POST)
	public void getParntData(EmfMap emfMap, ModelMap modelMap, HttpServletResponse response) throws Exception
	{	
		response.setContentType("text/html;charset=UTF-8");
       
		PrintWriter out = response.getWriter();
       
        try 
        {
            List<EmfMap> list = cODMenuService.getParntData(emfMap);  
            
            JSONArray jSONArray = new JSONArray();
            
            for(int i = 0; i < list.size();)
            {
                JSONObject jSONObject = new JSONObject();  
                
                jSONObject.put("data", list.get(i).getString("menuNm"));   
                
                JSONObject jsonAttr = new JSONObject();
                
                jsonAttr.put("id", list.get(i).getString("menuSeq"));
                jsonAttr.put("rel", list.get(i).getString("menuGb"));
                jsonAttr.put("parent_treeid", list.get(i).getString("parntSeq"));
                jsonAttr.put("level", list.get(i).getString("dpth"));
                jsonAttr.put("status", list.get(i).getString("userUseYn"));
                jsonAttr.put("link", list.get(i).getString("userLink"));
                jsonAttr.put("treeid", list.get(i).getString("menuSeq"));        
                jSONObject.put("attr", jsonAttr);
                jsonAttr=null;
                i++;
                jSONArray.put(jSONObject);
                jSONObject=null;
            }    
            
            out.print(jSONArray);
            jSONArray=null;
        }
        catch(Exception he)
        {
        	if (log.isDebugEnabled()) 
			{
				log.debug(he.getMessage());
            }
			throw new EmfException(he.getMessage());  
        }
        finally 
        {
            out.close();
        }
	}
	
	/**
     * 하위노드를 다 가져온다.
     * 
     * @param EmfMap 데이터
	 * @return String 뷰 URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@RequestMapping(value="/getChildData.ajax", method=RequestMethod.POST)
	public void getChildData(EmfMap emfMap, ModelMap modelMap, HttpServletResponse response) throws Exception
	{	
		response.setContentType("text/html;charset=UTF-8");
	       
		PrintWriter out = response.getWriter();
       
        try 
        {
            List<EmfMap> list = cODMenuService.getChildData(emfMap);  
            
            JSONArray jSONArray = new JSONArray();
            
            EmfMap jsonMap = null;
            
            for(int i = 0; i < list.size();)
            {
            	jsonMap = list.get(i);
            	
                JSONObject jSONObject = new JSONObject();  
                
                jSONObject.put("data", jsonMap.getString("menuNm"));   
                
                JSONObject jsonAttr = new JSONObject();
                jsonAttr.put("id", jsonMap.getString("menuSeq"));
                jsonAttr.put("rel", jsonMap.getString("menuGb"));
                jsonAttr.put("parent_treeid", jsonMap.getString("parntSeq"));
                jsonAttr.put("level", jsonMap.getString("dpth"));
                jsonAttr.put("status", jsonMap.getString("userUseYn"));
                jsonAttr.put("link", jsonMap.getString("userLink"));
                jsonAttr.put("treeid", jsonMap.getString("menuSeq"));        
                jSONObject.put("attr", jsonAttr);
                
                jsonAttr=null;
                i++;
                jSONArray.put(jSONObject);
                jSONObject=null;
            }       
            
            out.print(jSONArray);
            jSONArray=null;
        }
        catch(Exception he)
        {
        	if (log.isDebugEnabled()) 
			{
				log.debug(he.getMessage());
            }
			throw new EmfException(he.getMessage());
        }
        finally 
        {
            out.close();
        }
	}
}
