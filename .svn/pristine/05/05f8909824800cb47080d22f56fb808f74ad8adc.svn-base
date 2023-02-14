package mngwserc.co.log.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import mngwserc.co.log.service.LOGAdmLogMngService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import emf.core.exception.EmfException;
import emf.core.extend.web.EmfController;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 로그를 위한 Controller
 * </pre>
 * 
 * @ClassName		: LOGAdmLogMngController.java
 * @Description		: 로그를 Controller
 * @author 강재석
 * @since 2018.01.03
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2018.01.03		강재석					최초생성
 * </pre>
 */
@Controller
@RequestMapping(value="/mngwserc/log/adm")
public class LOGAdmLogMngController extends EmfController {

	@Resource(name="lOGAdmLogMngService")
	private LOGAdmLogMngService lOGAdmLogMngService;

	/**
	 * 로그관리 목록을 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
    @RequestMapping(value="/list.do")
	public String getAdmLogList(EmfMap emfMap, ModelMap modelMap, HttpServletRequest request) throws Exception
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
			EmfMap rtnMap = lOGAdmLogMngService.selectLogAdmList(emfMap);
			
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
		
		return "mngwserc/co/log/LOGAdmLogMngList.admin";
	}

	/**
     * 로그관리 목록을 조회한다. (엑셀다운로드)
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@RequestMapping(value="/excel.do")
	public String excelAdmLogList(EmfMap emfMap, ModelMap modelMap) throws Exception
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
			modelMap.addAttribute("excelList", lOGAdmLogMngService.excelLogAdmList(emfMap));
			modelMap.addAttribute("type", emfMap.getString("type"));
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		} 
				
		return "mngwserc/co/log/LOGAdmLogMngExcel";
	}
}
