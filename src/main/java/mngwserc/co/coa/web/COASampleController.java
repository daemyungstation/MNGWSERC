package mngwserc.co.coa.web;

import java.util.List;

import javax.annotation.Resource;

import mngwserc.co.coa.service.COASampleService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import emf.core.exception.EmfException;
import emf.core.extend.web.EmfController;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 샘플을 위한 Controller
 * </pre>
 * 
 * @ClassName		: CMASampleController.java
 * @Description		: 공통 샘플 Controller
 * @author 박주석
 * @since 2015.11.02
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2015.11.02		박주석					최초생성
 * </pre>
 */
@Controller
@RequestMapping("/coa")
public class COASampleController extends EmfController {
	
	//FrameWork에서 에러 처리를 위해 반드시 선언해야 함.
	private final String classNm = this.getClass().getSimpleName();
	
	/**서비스**/
	@Resource(name = "cOASampleService")
    private COASampleService cOASampleService;
	
	/**
	 * 조건에 따른 대상자 리스트를 가져온다.
	 * 
	 * @param HaeVO
	 * @return resultVO:HaeVO 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/selectSampleList.do", method=RequestMethod.GET)  
	public String selectSampleList(EmfMap paramMap, ModelMap modelMap) throws Exception{
		String sendUrl = "";
    	try
    	{
    		List rtnList = cOASampleService.selectSampleList(paramMap);
    		modelMap.addAttribute("rtnList", rtnList);
    	}
    	catch (Exception he) 
		{
			if (log.isErrorEnabled()) 
			{
				log.debug(he.getMessage());
            }
			throw new EmfException(he.getMessage());
		} 	
    	//메시지와 메시지 코드 및 데이터를 View 단으로 전송한다.
    	return sendUrl;
	}
}
