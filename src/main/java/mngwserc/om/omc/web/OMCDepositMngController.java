package mngwserc.om.omc.web;

import javax.annotation.Resource;

import mngwserc.om.omc.service.OMCDepositMngService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.com.cmm.util.EgovUserDetailsHelper;
import emf.core.exception.EmfException;
import emf.core.extend.web.EmfController;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 외주업체 입금관리를 위한 Controller
 * </pre>
 * 
 * @ClassName		: OMCDepositMngController.java
 * @Description		: 외주업체 입금관리 위한 Controller
 * @author 김필기
 * @since 2016.02.15
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2016.02.15		김필기					 최초생성
 * </pre>
 */
@Controller
@RequestMapping("/mngwserc/omc/deposit")
public class OMCDepositMngController extends EmfController {
	
	/** 서비스 **/
	@Resource(name = "oMCDepositMngService")
    private OMCDepositMngService oMCDepositMngService;
	
	/**
	 * 외주업체 입금관리 목록을 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/list.do")
	public String selectDepositMngList(EmfMap emfMap,  ModelMap modelMap) throws Exception
	{
		String url = "error/blank.error";
		
		try
		{
			EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();	// 로그인 사용자 정보
			
			if("30".equals(lgnMap.getString("authCd"))){
				EmfMap rtnMap = oMCDepositMngService.selectDepositMngList(emfMap);
				
				modelMap.addAttribute("rtnMap", rtnMap);
				url = "mngwserc/om/omc/OMCDepositList.admin";
			}else{
				modelMap.addAttribute("msg", "외주업체로 로그인이 되지 않았습니다.");
				modelMap.addAttribute("url", "javascript:history.back();");
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
		
		return url;	
	}
	

	/**
	 * 엑셀다운로드한다.
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
			modelMap.addAttribute("rtnMap", oMCDepositMngService.selectDepositMngExcelList(emfMap));
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		} 
		
		return "mngwserc/om/omc/OMCDepositListExcel";
	}			
}
