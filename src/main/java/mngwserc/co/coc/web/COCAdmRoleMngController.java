package mngwserc.co.coc.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import mngwserc.cn.cna.GetAllMapValue;
import mngwserc.co.coc.service.COCAdmRoleMngService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import emf.core.exception.EmfException;
import emf.core.extend.web.EmfController;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 관리자 ROLE 관리를 위한 Controller
 * </pre>
 * 
 * @ClassName		: COCAdmRoleMngController.java
 * @Description		: 관리자 ROLE 관리를 위한 Controller
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
@RequestMapping(value="/mngwserc/coc/role")
public class COCAdmRoleMngController extends EmfController {
	
	@Resource(name="cOCAdmRoleMngService")
	private COCAdmRoleMngService cOCAdmRoleMngService;
	 
	/**
	 * 관리자 ROLE 목록을 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/index.do")
	public String selectAdmRoleList(EmfMap emfMap, ModelMap modelMap) throws Exception
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
			EmfMap rtnMap = cOCAdmRoleMngService.selectAdmRoleList(emfMap);
			
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
		
		return "mngwserc/co/coc/COCAdmRoleList.admin";
	}
	
	/**
	 * 관리자 ROLE 상세를 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/write.do")
	public String selectAdmRole(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		try
		{
			EmfMap rtnMap = cOCAdmRoleMngService.selectAdmRole(emfMap);
			
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

		return "mngwserc/co/coc/COCAdmRoleWrite.admin";
	}
	
	/**
	 * 관리자 ROLE을 등록한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/insert.do")
	public String insertAdmRole(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		try
		{
			cOCAdmRoleMngService.insertAdmRole(emfMap);
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}

		return "redirect:/mngwserc/coc/role/index.do";
	}
	
	/**
	 * 관리자 ROLE을 수정한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/update.do")
	public String updateAdm(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		try
		{
			cOCAdmRoleMngService.updateAdmRole(emfMap);
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}

		return "redirect:/mngwserc/coc/role/write.do?roleCd="+emfMap.getString("roleCd");
	}
	
	/**
	 * 관리자 ROLE을 삭제한다.
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
			cOCAdmRoleMngService.deleteAdmRole(emfMap);
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}

		return "redirect:/mngwserc/coc/role/index.do";
	}
	
	/**
	 * 관리자 ROLE을 조회한다.(비동기)
	 * @param request
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getRole.ajax")
	public ModelAndView getRole(EmfMap emfMap, ModelMap modelMap, HttpServletResponse response) throws Exception
	{
		ModelAndView mav = new ModelAndView();
        
        try 
        {
        	EmfMap tmpMap = cOCAdmRoleMngService.selectAdmRoleList(emfMap);
        	log.debug("===========================================================");
        	log.debug(tmpMap);
        	log.debug("===========================================================");
        	List<EmfMap> roleList = (List<EmfMap>) tmpMap.get("list");
            
        	mav.addObject("roleList", roleList);   
        	
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
