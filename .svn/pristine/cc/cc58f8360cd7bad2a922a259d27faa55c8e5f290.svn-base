package mngwserc.co.cod.web;

import javax.annotation.Resource;

import mngwserc.co.cod.service.CODUserMenuService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import emf.core.exception.EmfException;
import emf.core.extend.web.EmfController;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 홈페이지(사용자) 메뉴관리를 위한 Controller
 * </pre>
 * 
 * @ClassName		: CODUserMenuController.java
 * @Description		: 홈페이지(사용자) 메뉴관리를 위한 Controller
 * @author 안진용
 * @since 2015.11.19
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2015.11.19		안진용					최초생성
 * </pre>
 */
@Controller
@RequestMapping(value="/mngwserc/cod/user")
public class CODUserMenuController extends EmfController {
	
	// 홈페이지(사용자) 메뉴관리 서비스 선언
	@Resource(name="cODUserMenuService")
	private CODUserMenuService cODUserMenuService;
	
	/**
	 * 홈페이지(사용자) 메뉴 관리
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/index.do")
	public String getUserMenuPage(EmfMap emfMap, ModelMap modelMap) throws Exception
	{		
		return "mngwserc/co/cod/CODUserMenu.admin";
	}
	
	/**
	 * 현재 배포중인거 있는지 찾기
	 * @param request
	 * @param vo
	 * @return
	 * @throws Exception
	 */	
	@RequestMapping(value="/chkStatus.ajax")
	public ModelAndView chkStatus(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		ModelAndView mav = new ModelAndView();

		try
		{
			EmfMap rtnMap = cODUserMenuService.getApprovalCntns(emfMap);

			mav.addObject("rtnMap", rtnMap);
			
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
