/**
 * 
 */
package mngwserc.co.cod.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import emf.core.extend.web.EmfController;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 게시판 카테고리 메뉴 관리를 위한 Controller
 * </pre>
 * 
 * @ClassName		: CODBoardMenuController.java
 * @Description		: 게시판 카테고리 메뉴 관리를 위한 Controller
 * @author 김필기
 * @since 2015. 11. 20.
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2015. 11. 20.		김필기					최초생성
 * </pre>
 */

@Controller
@RequestMapping(value="/mngwserc/cod/board")
public class CODBoardMenuController extends EmfController {
	
	/**
	 * 게시판 카테고리관리 페이지
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return Json 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/index.do", method=RequestMethod.GET)
	public String getBoardCtgrPage(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		return "mngwserc/co/cod/CODBoardMenu.admin";
	}
	
	/**
	 * 게시판 카테고리를 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return Json 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/selectCategory.ajax")	
	public String selectCategory(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		modelMap.addAttribute("rtnMap",emfMap);
		
		return "mngwserc/co/cod/CODCategory";
	}
}
