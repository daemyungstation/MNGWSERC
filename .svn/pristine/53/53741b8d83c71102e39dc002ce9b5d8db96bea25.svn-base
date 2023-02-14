package mngwserc.co.web;

import javax.annotation.Resource;

import mngwserc.co.cog.service.COGCntnsMngService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import emf.core.exception.EmfException;
import emf.core.extend.web.EmfController;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 컨텐츠 재배포를 위한 Controller
 * </pre>
 * 
 * @ClassName		: COEditorController.java
 * @Description		: 컨텐츠 재배포를 위한 Controller
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
public class COContentsController extends EmfController {
	
	@Resource(name="cOGCntnsMngService")
	private COGCntnsMngService cOGCntnsMngService;
	
	@RequestMapping(value="/contents/distribution.do")
	public void distributionContentsAll(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		try
		{
			cOGCntnsMngService.selectContentsAllList();
		}
		catch(Exception he)
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}
	}
}
