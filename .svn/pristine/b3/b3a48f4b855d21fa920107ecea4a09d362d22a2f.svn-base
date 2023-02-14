package mngwserc.co.coc.web;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import mngwserc.co.coc.service.COCAdmMngService;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import egovframework.com.cmm.service.EgovProperties;
import emf.core.exception.EmfException;
import emf.core.extend.web.EmfController;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 관리자 관리를 위한 Controller
 * </pre>
 * 
 * @ClassName		: COCAdmMngController.java
 * @Description		: 관리자 관리를 위한 Controller
 * @author 안진용
 * @since 2015.11.18
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2015.11.18		안진용					최초생성
 * </pre>
 */
@Controller
@RequestMapping(value="/mngwserc/coc/adm")
public class COCAdmMngController extends EmfController {
	
	@Resource(name="cOCAdmMngService")
	private COCAdmMngService cOCAdmMngService;
	
	private String httpsAdminUrl = EgovProperties.getProperty("Globals.httpsAdminUrl");
	 
	/**
	 * 관리자 목록을 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/index.do")
	public String selectAdmList(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		String url = "";
		
		if("Y".equals(emfMap.get("isPop")))
		{
			url = "mngwserc/co/coc/COCAdmPop.pop";	
		}
		else
		{
			url = "mngwserc/co/coc/COCAdmList.admin";	
		}		
		
		//검색어 체크
		String q = emfMap.getString("q");	
		
		if(!"".equals(EMFStringUtil.nullConvert(q)) && q.length() <= 15)
		{
			emfMap.put("q", q);
		}
		else
		{
			emfMap.put("q", "");
		}
		
		try
		{			
			EmfMap rtnMap = cOCAdmMngService.selectAdmList(emfMap);
			
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
	 * 관리자 상세를 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/write.do")
	public String selectAdm(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		try
		{
			EmfMap rtnMap = cOCAdmMngService.selectAdm(emfMap);

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

		return "mngwserc/co/coc/COCAdmWrite.admin";
	}
	
	/**
	 * 관리자를 등록한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/insert.do")
	public String insertAdm(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		log.debug("123");
		try
		{
			cOCAdmMngService.insertAdm(emfMap);
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}

		return "redirect:/mngwserc/coc/adm/index.do";
	}
	
	/**
	 * 관리자를 수정한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/update.do")
	public String updateAdm(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		boolean updateSuccess = false;
		try
		{
			System.out.println("aaaaaaaaaa");
			
			emfMap.put("isAdmMng", "Y");
			
			cOCAdmMngService.updateAdm(emfMap);

			updateSuccess = true;
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}

		return "redirect:/mngwserc/coc/adm/write.do?admSeq="+emfMap.getString("admSeq") + "&updateSuccess=" + updateSuccess ;
	}
	
	/**
	 * 관리자를 삭제한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/delete.do")
	public String deleteAdm(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		try
		{
			cOCAdmMngService.deleteAdm(emfMap);
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
	 * 관리자 아이디 중복확인
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */	
	@RequestMapping(value="/getIdChk.ajax", method=RequestMethod.POST)
	public ModelAndView getAdmIdChk(EmfMap emfMap,  ModelMap modelMap, HttpServletResponse response) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		
		try
		{
			int chk = 0;
			
			if(!"".equals(EMFStringUtil.nullConvert(emfMap.get("id"))))
			{
				chk = cOCAdmMngService.getIdCnt(emfMap);
			}

			String msg = "";
			String id_chk = "";		
			
			if(chk > 0)
			{
				msg = "이미 사용중인 아이디 입니다.";
				id_chk = "";
			}
			else
			{
				msg = "사용할 수 있는 아이디 입니다.";
				id_chk = "Y";
			}		
			
			mav.addObject("msg", msg);
			mav.addObject("id_chk", id_chk);
			
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
	 * 관리자 이메일 중복확인
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */	
	@RequestMapping(value="/getEmailChk.ajax", method=RequestMethod.POST)
	public ModelAndView getEmailChk(EmfMap emfMap,  ModelMap modelMap, HttpServletResponse response) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		
		try
		{
			int chk = 0;
			
			if(!"".equals(EMFStringUtil.nullConvert(emfMap.get("email"))))
			{
				chk = cOCAdmMngService.getEmailCnt(emfMap);
			}
			
			String msg = "";
			String email_chk = "";
			
			if(chk > 0)
			{
				msg = "이미 사용중인 이메일주소 입니다.";
				email_chk = "";
			}
			else
			{
				msg = "사용할 수 있는 이메일주소 입니다.";
				email_chk = "Y";
			}
			
			mav.addObject("msg", msg);
			mav.addObject("email_chk", email_chk);
			
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
	 * 관리자 관리 메뉴 조희
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */	
	@RequestMapping(value="/getMenuList.ajax")
	public void getMenuList(EmfMap emfMap, ModelMap modelMap, HttpServletResponse response) throws Exception
	{
        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = response.getWriter();

        try 
        {
            List<EmfMap> menuList = cOCAdmMngService.getMenuList(emfMap);
            
            JSONArray jSONArray = new JSONArray();
            
            for(int i = 0; i < menuList.size();)
            {
                JSONObject jSONObject = new JSONObject();
                
                if(Integer.parseInt(menuList.get(i).getString("childcnt")) > 0)
                {
                	jSONObject.put("state", "closed");
                }
                
                jSONObject.put("data", menuList.get(i).getString("menuNm"));
                
                JSONObject jsonAttr = new JSONObject();        
                
                jsonAttr.put("id", menuList.get(i).getString("menuSeq"));
                jsonAttr.put("rel", menuList.get(i).getString("menuGb"));
                jsonAttr.put("parent_treeid", menuList.get(i).getString("parntSeq"));
                jsonAttr.put("level", menuList.get(i).getString("dpth"));
                jsonAttr.put("status", menuList.get(i).getString("userUseYn"));
                jsonAttr.put("link", menuList.get(i).getString("userLink"));
                jsonAttr.put("treeid", menuList.get(i).getString("menuSeq"));      
                jsonAttr.put("checktype", menuList.get(i).getString("checktype"));
                
                if(!"".equals(EMFStringUtil.nullConvert(emfMap.get("admSeq"))))
                {
	                if(!"0".equals(menuList.get(i).getString("checkdept")))
	                {
	                	jsonAttr.put("checkdept", menuList.get(i).getString("checkdept"));
	                }
                }
                
                if("0".equals(menuList.get(i).getString("checktype")))
                {
                	jsonAttr.put("class", "jstree-unchecked"); 
                }
                else
                {
                	jsonAttr.put("class", "jstree-checked"); 
                }
                
                jSONObject.put("attr", jsonAttr);
                jsonAttr = null;
                i++;
                jSONArray.put(jSONObject);
                jSONObject = null;
            }       
            
            out.print(jSONArray);
            jSONArray = null;
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
}
