package mngwserc.sm.sma.web;

import javax.annotation.Resource;

import mngwserc.sm.sma.service.SMAPopMngService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import emf.core.exception.EmfException;
import emf.core.extend.web.EmfController;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 팝업 관리를 위한 Controller
 * </pre>
 * 
 * @ClassName		: SMAPopMngController.java
 * @Description		: 팝업 관리를 위한 Controller
 * @author 허진영
 * @since 2016.02.11.
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author				   description
 *   ===========    ==============    =============================
 *   2016.02.11.		허진영			 		최초생성
 * </pre>
 */
@Controller
@RequestMapping(value="/mngwserc/sma/pop")
public class SMAPopMngController extends EmfController {

	@Resource(name="sMAPopMngService")
	private SMAPopMngService sMAPopMngService;

	/**
	 * 팝업 목록을 조회한다.
	 *
 	 * @param emfMap
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
    @RequestMapping(value="/list.do")
    public String selectPopList(EmfMap emfMap, ModelMap modelMap) throws Exception {
    	//검색어 체크
		convertSearchParam(emfMap);
		
		try {
			EmfMap rtnMap = sMAPopMngService.selectPopList(emfMap);
			
			modelMap.addAttribute("rtnMap", rtnMap);
		} catch (Exception he) {
			if (log.isDebugEnabled()) log.debug(he);
			throw new EmfException(he.getMessage());
		}
    	
    	return "mngwserc/sm/sma/SMAPopList.admin";
    }

	/**
	 * 팝업 상세를 조회한다. (뷰 페이지)
	 *
 	 * @param emfMap
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/view.do")
    public String getPopViewPage(EmfMap emfMap, ModelMap modelMap) throws Exception {
    	String url = "erorr/blank.error";
    		
		try {
			EmfMap rtnMap = sMAPopMngService.selectPop(emfMap);
			
			//editor 플레그 값.
			if ("Y".equals(EMFStringUtil.nullConvert(emfMap.get("editorView")))) {
				url = "mngwserc/sm/sma/SMAPopEditorView";
			} else {
				url = "mngwserc/sm/sma/SMAPopView.admin";
			}

			modelMap.addAttribute("rtnMap", rtnMap);
		} catch (Exception he) {
			if (log.isDebugEnabled()) log.debug(he);
			throw new EmfException(he.getMessage());
		}
    	
		return url;   
    }

	/**
	 * 팝업 상세를 조회한다.
	 *
	 * @param emfMap
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/write.do")
    public String writePop(EmfMap emfMap, ModelMap modelMap) throws Exception {
    	try {
			EmfMap rtnMap = sMAPopMngService.selectPop(emfMap);
			modelMap.addAttribute("rtnMap", rtnMap);
		} catch (Exception he) {
			if (log.isDebugEnabled()) log.debug(he);
			throw new EmfException(he.getMessage());
		}

    	return "mngwserc/sm/sma/SMAPopWrite.admin";
    }

	/**
	 * 팝업을 등록한다.
	 *
	 * @param emfMap
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/insert.do", method=RequestMethod.POST)
    public String insertPop(EmfMap emfMap, ModelMap modelMap) throws Exception {
    	try {
		    sMAPopMngService.insertPop(emfMap);
		} catch(Exception he) {
			if (log.isDebugEnabled()) log.debug(he);
			throw new EmfException(he.getMessage());
		}
    	
    	return "redirect:./list.do";
    }

	/**
	 * 팝업을 수정한다.
	 *
 	 * @param emfMap
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
    public String selectPopMng(EmfMap emfMap, ModelMap modelMap) throws Exception {
		try {
			sMAPopMngService.updatePop(emfMap);
		} catch (Exception he) {
			if (log.isDebugEnabled()) log.debug(he);
			throw new EmfException(he.getMessage());
		}
    	
		return "redirect:./write.do?popSeq=" + emfMap.getString("popSeq");   
    }

	/**
	 * 팝업을 삭제한다.
	 *
	 * @param emfMap
	 * @param modelMap
	 * @param delSeq
	 * @return
	 * @throws Exception
	 */
    @RequestMapping(value="/delete.do", method=RequestMethod.POST)
	public String deletePopList(EmfMap emfMap, ModelMap modelMap, @RequestParam(value="delSeq", required=true) int[] delSeq) throws Exception {
    	try {
    		sMAPopMngService.deletePopList(delSeq);
		} catch (Exception he) {
			if (log.isDebugEnabled()) log.debug(he);
			throw new EmfException(he.getMessage());
		}
		
		return "redirect:./list.do";
	}

	/**
	 * 메인 팝업 목록을 조회한다.
	 *
	 * @param emfMap
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/main/list.do")
	public String selectMainPopList(EmfMap emfMap, ModelMap modelMap) throws Exception {
		//검색어 체크
		convertSearchParam(emfMap);

		try {
			EmfMap rtnMap = sMAPopMngService.selectMainPopList(emfMap);
			modelMap.addAttribute("rtnMap", rtnMap);
		} catch (Exception e) {
			log.debug(e);
			throw new EmfException(e.getMessage());
		}
		return "mngwserc/sm/sma/SMAMainPopList.admin";
	}

	/**
	 * 메인 팝업 상세를 조회한다.
	 *
	 * @param emfMap
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/main/write.do")
	public String writeMainPop(EmfMap emfMap, ModelMap modelMap) throws Exception {
		if (emfMap.get("idx") != null) {
			try {
				EmfMap rtnMap = sMAPopMngService.getMainPop(emfMap);
				modelMap.addAttribute("rtnMap", rtnMap);
			} catch (Exception he) {
				if (log.isDebugEnabled()) log.debug(he);
				throw new EmfException(he.getMessage());
			}
		}

		return "mngwserc/sm/sma/SMAMainPopWrite.admin";
	}

	/**
	 * 메인 팝업을 등록한다.
	 *
	 * @param emfMap
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/main/insert.do", method=RequestMethod.POST)
	public String setMainPopup(EmfMap emfMap, ModelMap modelMap) throws Exception {
		try {
			sMAPopMngService.setMainPopup(emfMap);
		} catch(Exception he) {
			if (log.isDebugEnabled()) log.debug(he);
			throw new EmfException(he.getMessage());
		}

		return "redirect:./list.do";
	}

	@RequestMapping(value="/main/update.do", method=RequestMethod.POST)
	public String putMainPopup(EmfMap emfMap, ModelMap modelMap) throws Exception {
		try {
			sMAPopMngService.putMainPopup(emfMap);
		} catch (Exception he) {
			if (log.isDebugEnabled()) log.debug(he);
			throw new EmfException(he.getMessage());
		}
		return "redirect:./list.do";
	}

	@RequestMapping(value="/main/delete.do", method=RequestMethod.POST)
	public String delMainPopList(@RequestParam(value="delSeq") int[] delSeq) throws Exception {
		try {
			sMAPopMngService.delMainPopList(delSeq);
		} catch (Exception he) {
			if (log.isDebugEnabled()) log.debug(he);
			throw new EmfException(he.getMessage());
		}
		return "redirect:./list.do";
	}


	private void convertSearchParam(EmfMap emfMap) {
		String f = emfMap.getString("f");
		String q = emfMap.getString("q");

		if (!"".equals(EMFStringUtil.nullConvert(q)) && q.length() <= 15) {
			emfMap.put("f", f);
			emfMap.put("q", q);
		} else {
			emfMap.put("f", "");
			emfMap.put("q", "");
		}
	}
}
