package mngwserc.om.oma.web;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mngwserc.om.oma.service.OMACounselMngService;
import mngwserc.om.oma.service.dao.OMACounselMngDAO;
import mngwserc.om.oma.service.impl.OMACounselExcelHandler;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.com.utl.fcc.service.EgovStringUtil;
import emf.core.exception.EmfException;
import emf.core.extend.web.EmfController;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 외주업체 상담관리를 위한 Controller
 * </pre>
 * 
 * @ClassName		: OMACounselMngController.java
 * @Description		: 외주업체 상담관리 위한 Controller
 * @author 김필기
 * @since 2016.02.26
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2016.02.26		김필기					 최초생성
 * </pre>
 */
@Controller
@RequestMapping("/mngwserc/oma/counsel")
public class OMACounselMngController extends EmfController {
	
	@Resource(name="oMACounselMngService")
    private OMACounselMngService oMACounselMngService;
	
	@Resource(name="oMACounselMngDAO")
	private OMACounselMngDAO oMACounselMngDAO;

	/**
	 * 외주업체 상담관리 목록을 조회한다.
	 *
	 * @param emfMap
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	
	private String selectCounselMngListLGU(EmfMap emfMap, ModelMap modelMap, HttpServletResponse response, String id) throws Exception {
		String url = "error/blank.error";
		//검색어 체크
		String f = emfMap.getString("f");
		String q = emfMap.getString("q");	
		String rtnMapf = emfMap.getString("rtnMapf");
		rtnMapf = rtnMapf.toUpperCase();	
		emfMap.put("rtnMapf", rtnMapf);
		emfMap.put("id", id);
		String b2bStts = (String)emfMap.get("b2bStts");
		System.out.println(emfMap);

		if(!"".equals(EMFStringUtil.nullConvert(q)) && q.length() <= 15){
			emfMap.put("f", f);			
			emfMap.put("q", q);
		} else {
			emfMap.put("f", "");
			emfMap.put("q", "");
		}
		try
		{
			EmfMap rtnMap = new EmfMap();
			if(emfMap.getString("strtDt").isEmpty() && emfMap.getString("endDt").isEmpty()){
				//rtnMap = null;
			} else {
				rtnMap = oMACounselMngService.selectCounselMngLGUList(emfMap);
			}
			modelMap.addAttribute("rtnMap", rtnMap);
			if(id.equals("lgusawon")){
				url = "mngwserc/om/oma/OMACounselListLGU.admin2";
			}else if(id.equals("lguplus")){
				url = "mngwserc/om/oma/OMACounselListLGUPLUS.admin2";
			} else if( "DLIVE".equalsIgnoreCase(b2bStts) ) {
				url = "mngwserc/om/oma/OMACounselListDLIVE.admin2";
			} else {
				url = "mngwserc/om/oma/OMACounselList.admin";
			}
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			
			if("권한오류".equals(EgovStringUtil.nullConvert(he.getMessage())))
			{	
				modelMap.addAttribute("msg", "외주업체로 로그인이 되지 않았습니다.");
				modelMap.addAttribute("url", "/");
			} else if("설정오류".equals(EgovStringUtil.nullConvert(he.getMessage())))
			{
				modelMap.addAttribute("msg", "조회 조건 설정이 되지 않았습니다.");
				modelMap.addAttribute("url", "/");
			} else if("보안코드점검".equals(EgovStringUtil.nullConvert(he.getMessage())))
			{
				modelMap.addAttribute("msg", "대리점코드나 보안코드를 확인하세요.");
				modelMap.addAttribute("url", "/");
			} else if("보안코드오류".equals(EgovStringUtil.nullConvert(he.getMessage())))
			{
				modelMap.addAttribute("msg", "보안코드가 일치하지 않습니다.");
				modelMap.addAttribute("url", "/");
			}
			else
			{
				throw new EmfException(he.getMessage());	
			}
		}
		return url;
	}
//	@ResponseBody
	@RequestMapping(value="/list.do")
	public String selectCounselMngList(EmfMap emfMap, ModelMap modelMap, HttpServletResponse response) throws Exception
	{
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		String id = lgnMap.getString("id");
		
		if(id.equals("lgusawon") || id.equals("lgumanager") || id.equals("lguplus")){
			return this.selectCounselMngListLGU(emfMap, modelMap, response, id);
		}
		
/*		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
        out.println("alert('해당 서비스를 잠시 중단합니다.');");
        out.println("history.back();");
        out.println("</script>");        
        out.flush();
*/        
		/** 전체 목록을 가져오지 못하게 막음 **/
//		if(emfMap.getString("strtDt").isEmpty()){
//			emfMap.put("strtDt", DateFormatUtils.format(new Date(), "yyyy-MM-dd"));
//		}
//		if(emfMap.getString("endDt").isEmpty()){
//			emfMap.put("endDt", DateFormatUtils.format(new Date(), "yyyy-MM-dd"));
//		}
		
		String url = "error/blank.error";
		
		//검색어 체크
		String f = emfMap.getString("f");
		String q = emfMap.getString("q");	

//		System.out.println("emfMap :: " + emfMap);
		
		if(!"".equals(EMFStringUtil.nullConvert(q)) && q.length() <= 15){
			emfMap.put("f", f);
			
			// 판매채널
//			if("3".equals(f)){
//				if("".equals(q)){
//					q = "ALL DATA";
//				}
//
//				if("온라인".equals(q)){
//					q = "";
//				}
//			}
			
			emfMap.put("q", q);
		} else {
			emfMap.put("f", "");
			emfMap.put("q", "");
		}
		
		try
		{
			EmfMap rtnMap = new EmfMap();
			String b2bStts = "";
			EmfMap admMap = oMACounselMngService.selectOutsourcingAdmMngInfo(lgnMap);
			b2bStts = (String)admMap.get("b2bStts");

			if(emfMap.getString("strtDt").isEmpty() && emfMap.getString("endDt").isEmpty()){
				//rtnMap = null;
			} else {
				rtnMap = oMACounselMngService.selectCounselMngList(emfMap);
			}
			modelMap.addAttribute("rtnMap", rtnMap);
			
			if("Y".equals(rtnMap.getString("uplussaveYn"))){
				url = "mngwserc/om/oma/OMACounselListUPLUSSAVE.admin";
			}else {
				url = "mngwserc/om/oma/OMACounselList.admin";
			}
			if("Y".equals(rtnMap.getString("uplussave3Yn"))){
				url = "mngwserc/om/oma/OMACounselListUPLUSSAVE3.admin";
			}
			
			if (b2bStts.equalsIgnoreCase("CHUNGHO")) {
				url = "mngwserc/om/oma/chungho/OMACounselList.admin";
			} else if( "DLIVE".equalsIgnoreCase(b2bStts) ) {
				url = "mngwserc/om/oma/OMACounselListDLIVE.admin";
			}
			
			
			
			
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			
			if("권한오류".equals(EgovStringUtil.nullConvert(he.getMessage())))
			{
				modelMap.addAttribute("msg", "외주업체로 로그인이 되지 않았습니다.");
				modelMap.addAttribute("url", "/");
			}
			if("설정오류".equals(EgovStringUtil.nullConvert(he.getMessage())))
			{
				modelMap.addAttribute("msg", "조회 조건 설정이 되지 않았습니다.");
				modelMap.addAttribute("url", "/");
			}
			else
			{
				throw new EmfException(he.getMessage());	
			}
		} 
		
		return url;

	}

	/**
	 * 외주업체 상담관리 상세를 조회한다. (뷰 페이지)
	 *
 	 * @param emfMap
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
    @RequestMapping(value="/view.do")
    public String getCounselMngViewPage(EmfMap emfMap, ModelMap modelMap, HttpServletResponse response) throws Exception {

    	String url = "mngwserc/om/oma/OMACounselView.admin";
    	
    	EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		String id = lgnMap.getString("id");
		
		if(id.equals("lgusawon") || id.equals("lgumanager") || id.equals("lguplus")){
			url = "mngwserc/om/oma/OMACounselLGUView.admin2";
		}

    	try {
    		lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
    		id = lgnMap.getString("id");
    		emfMap.put("id", id);
    		EmfMap rtnMap = null;
    		if(id.equals("lguplus") || id.equals("lgusawon")){
    			rtnMap = oMACounselMngService.selectCounselLGMng(emfMap);
    		} else {
    			rtnMap = oMACounselMngService.selectCounselMng(emfMap);
    		}

			modelMap.addAttribute("f", emfMap.getString("f"));
			modelMap.addAttribute("q", emfMap.getString("q"));
			modelMap.addAttribute("callStts", emfMap.getString("callStts"));
			modelMap.addAttribute("pageIndex", emfMap.getString("pageIndex"));
			modelMap.addAttribute("strtDt", emfMap.getString("strtDt"));
			modelMap.addAttribute("endDt", emfMap.getString("endDt"));
			modelMap.addAttribute("rtnMap", rtnMap);
			modelMap.addAttribute("kbNo", emfMap.getString("kbNo"));

			if (rtnMap.getString("b2bStts").equalsIgnoreCase("CHUNGHO")) {
				url = "mngwserc/om/oma/chungho/OMACounselView.admin";
			}

		} catch (Exception he) {
			if (log.isDebugEnabled()) {
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}
    	
		return url;
    }

	/**
	 * 외주업체 상담관리 상세를 조회한다. (등록, 수정 페이지)
	 *
	 * @param emfMap
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/write.do")
	public String selectCounselMng(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		try
		{
			EmfMap rtnMap = oMACounselMngService.selectCounselMng(emfMap);
			
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

		return "mngwserc/om/oma/OMACounselWrite.admin";
	}

	/**
	 * 외주업체 상담관리을 수정한다.
	 *
	 * @param request
	 * @param emfMap
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	public String updateCounselMng(HttpServletRequest request, EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		String id = lgnMap.getString("id");
		try
		{	
    		emfMap.put("id", id);
    		EmfMap rtnMap = null;
    		if(id.equals("lguplus") || id.equals("lgusawon")){
				oMACounselMngService.updateCounselLGUMng(request, emfMap);
			} else {
				oMACounselMngService.updateCounselMng(request, emfMap);	
			}
		
			modelMap.addAttribute("f", emfMap.getString("f"));
			modelMap.addAttribute("q", emfMap.getString("q"));
			modelMap.addAttribute("callStts", emfMap.getString("shCallStts"));
			modelMap.addAttribute("pageIndex", emfMap.getString("pageIndex"));
			modelMap.addAttribute("strtDt", emfMap.getString("strtDt"));
			modelMap.addAttribute("endDt", emfMap.getString("endDt"));			
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			
			throw new EmfException(he.getMessage());
		}
		
		if(id.equals("lguplus") || id.equals("lgusawon")){
			return "redirect:/mngwserc/oma/counsel/view.do?idx=" + emfMap.getString("idNo");  
		} else {
			return "redirect:/mngwserc/oma/counsel/view.do?idx=" + emfMap.getString("idx");  	
		}

	}


	public String excelDownLoadLGU(HttpServletResponse response, EmfMap emfMap, ModelMap modelMap, String id) throws Exception
	{		
		
//		EmfMap paramMap = new EmfMap();
//		HSSFWorkbook workbook = new HSSFWorkbook();
//		OMACounselExcelHandler handler = new OMACounselExcelHandler(workbook);
		
		
		
		//검색어 체크
		String f = emfMap.getString("f");
		String q = emfMap.getString("q");	
		String rtnMapf = emfMap.getString("rtnMapf");	
		rtnMapf.toUpperCase();
		String url = "";
		
		
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		emfMap.put("id", lgnMap.getString("id"));
		emfMap.put("rtnMapf", rtnMapf);
	
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
		
		try {
			EmfMap rtnMap = oMACounselMngService.selectCounselMngLGUExcelList(emfMap);
			modelMap.addAttribute("rtnMap", rtnMap);
			if(id.equals("lgusawon")){
				url = "mngwserc/om/oma/OMACounselListLguExcel2";
			}else if(id.equals("lguplus")){
				url = "mngwserc/om/oma/OMACounselListLguplusExcel";
			}else {
				url = "mngwserc/om/oma/OMACounselListExcel";
			}
		} catch (Exception he) {
			if (log.isDebugEnabled()) {
				log.debug(he);
	        }
			throw new EmfException(he.getMessage());
		} 
		
		return url;
	}
	
	/**
	 * 외주업체 상담관리를 엑셀다운로드한다.
	 *
	 * @param emfMap
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/excel.do")
	public String excelDownLoad(HttpServletResponse response, EmfMap emfMap, ModelMap modelMap) throws Exception
	{		
		response.reset();
		response.setHeader("Set-Cookie","fileDownload=true; path=/");
		
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		String id = lgnMap.getString("id");
		
		//
		if(id.equals("lgusawon") || id.equals("lgumanager") || id.equals("lguplus")){
			return this.excelDownLoadLGU(response, emfMap, modelMap, id);
		}
	
		//검색어 체크
		String f = emfMap.getString("f");
		String q = emfMap.getString("q");	
		String rtnMapf = emfMap.getString("rtnMapf");	
		String url = "";
		
	
		lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		emfMap.put("id", lgnMap.getString("id"));
		
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

		// selectCounselMngList
		try {
			EmfMap rtnMap = oMACounselMngService.selectCounselMngExcelList(emfMap);
			modelMap.addAttribute("rtnMap", rtnMap);
	
			if ("Y".equals(rtnMap.getString("uplussaveYn"))) {
				url = "mngwserc/om/oma/OMACounselListUPLUSSAVEExcel";
			} else {
				url = "mngwserc/om/oma/OMACounselListExcel";
			}
	
			if (rtnMap.getString("b2bStts").equalsIgnoreCase("CHUNGHO")) {
				url = "mngwserc/om/oma/chungho/OMACounselListExcel";
			} else
			if (rtnMap.getString("b2bStts").equalsIgnoreCase("DLIVE")) {
				url = "mngwserc/om/oma/OMACounselListDLIVEExcel";
			}
	
		} catch (Exception he) {
			if (log.isDebugEnabled()) {
				log.debug(he);
	        }
			throw new EmfException(he.getMessage());
		} 
		
		return url;
	}

	/**
	 * 외주업체 상담등록 페이지
	 *
	 * @param emfMap
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="/excelUploadPop.do")
	public String excelUpload(EmfMap emfMap, ModelMap modelMap)
	{
		return "mngwserc/om/oma/OMAExcelUploadPop";
	}

	/**
	 * 외주업체 상담등록 엑셀파일 등록
	 *
	 * @param emfMap
	 * @param modelMap
	 * @param multiRequest
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/insertExcelUpload.do", method=RequestMethod.POST)
	public ModelAndView insertExcelUpload(EmfMap emfMap, ModelMap modelMap, MultipartHttpServletRequest multiRequest, HttpServletRequest req) throws Exception 
	{
		ModelAndView mav = new ModelAndView();
		
        try 
        {
        	String result = oMACounselMngService.insertExcelData(emfMap, multiRequest, req);
			
			mav.addObject("result", result);
    		
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
