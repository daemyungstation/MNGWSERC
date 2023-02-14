package mngwserc.co.cof.web;

import javax.annotation.Resource;

import mngwserc.co.cof.service.COFSysLogService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import emf.core.exception.EmfException;
import emf.core.extend.web.EmfController;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 로그관리(시스템)를 위한 Controller
 * </pre>
 * 
 * @ClassName		: COFSysLogController.java
 * @Description		: 로그관리(시스템)를 위한 Controller
 * @author 김대환
 * @since 2015.11.19
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author			 description
 *   ===========    ==============    =================
 *    2015.11.19		김대환			  최초생성
 * </pre>
 */
@Controller
@RequestMapping(value="/mngwserc/cof")
public class COFSysLogController extends EmfController {

	/** 서비스 **/
	@Resource(name="cOFSysLogService")
	private COFSysLogService cOFSysLogService;

	/**
	 * 시스템 로그 목록을 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/index.do")
	public String logSelectSysLogList(EmfMap emfMap, ModelMap modelMap) throws Exception
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
			EmfMap rtnMap = cOFSysLogService.logSelectSysLogList(emfMap);
			
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
		
		return "mngwserc/co/cof/COFSysLogList.admin";
	}
	
	/**
	 * 시스템 로그 목록을 엑셀다운로드한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/excel.do")
	public String logExcelSysLogList(EmfMap emfMap, ModelMap modelMap) throws Exception
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
			modelMap.addAttribute("excelList", cOFSysLogService.logExcelSysLogList(emfMap));
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		} 
		
		return "mngwserc/co/cof/COFSysLogExcel";
	}
}
