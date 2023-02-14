package mngwserc.co.cod.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import emf.core.extend.web.EmfController;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 콘텐츠 메뉴관리를 위한 Controller
 * </pre>
 * 
 * @ClassName		: CODCntnsMenuController.java
 * @Description		: 콘텐츠 메뉴관리를 위한 Controller
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
@RequestMapping(value="/mngwserc/cod/cntns")
public class CODCntnsMenuController extends EmfController {
	
	/**
	 * CMS 메뉴 관리
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/index.do")
	public String getCntnsMenuPage(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		return "mngwserc/co/cod/CODCntnsMenu.admin";
	}
	
	/**
	 * CMS 카테고리를 가져온다.
	 * 
	 * @param EmfMap 데이터
	 * @return String 뷰 URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/selectCategory.ajax")
	public String selectCategory(EmfMap emfMap, ModelMap modelMap) throws Exception
	{	
		modelMap.addAttribute("rtnMap", emfMap);

		return "mngwserc/co/cod/CODCategory";
	}	
}
