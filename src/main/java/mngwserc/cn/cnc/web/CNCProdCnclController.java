package mngwserc.cn.cnc.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import egovframework.com.cmm.service.EgovFileMngUtil;
import egovframework.com.cmm.service.EgovProperties;
import egovframework.com.utl.sim.service.EgovNetworkState;
import egovframework.rte.fdl.idgnr.impl.EgovTableIdGnrService;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import mngwserc.cn.cnc.service.CNCProdCnclService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.com.utl.fcc.service.EgovStringUtil;
import emf.core.exception.EmfException;
import emf.core.extend.web.EmfController;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/mngwserc/cnc/prodCncl")
public class CNCProdCnclController extends EmfController {

	/** 서비스 **/
	@Resource(name="cNCProdCnclService")
	private CNCProdCnclService cNCProdCnclService;

	@RequestMapping(value="/list.do")
	public String selectProdCnclList(EmfMap emfMap, ModelMap modelMap) throws Exception {
		String url = "error/blank.error";
		
		//ID 검사를 위해 ID가져옴
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
    	emfMap.put("id", lgnMap.getString("id"));
    	
    	//검색어 체크
		String f = emfMap.getString("f");
		String q = emfMap.getString("q");
		if (!"".equals(EMFStringUtil.nullConvert(q)) && q.length() <= 15) {
			emfMap.put("f", f);

			// 판매채널
			/*
			if("3".equals(f)){
				if("".equals(q)){
					q = "ALL DATA";
				}

				if("온라인".equals(q)){
					q = "";
				}
			}
			*/
			emfMap.put("q", q);
		} else {
			emfMap.put("f", "");
			emfMap.put("q", "");
		}

		if (modelMap.get("call_stts") != null) {
			emfMap.put("callStts", modelMap.get("call_stts"));
		}

		try {
			EmfMap rtnMap = cNCProdCnclService.selectProdCnclList(emfMap);
			modelMap.addAttribute("rtnMap", rtnMap);
			url = "mngwserc/cn/cnc/CNCProdCnclList.admin";

		} catch (Exception he) {
			if (log.isDebugEnabled()) {
				log.debug(he);
            }
			
			if ("권한오류".equals(EgovStringUtil.nullConvert(he.getMessage()))) {
				modelMap.addAttribute("msg", "외주업체로 로그인이 되지 않았습니다.");
				modelMap.addAttribute("url", "/");
			}
			if ("설정오류".equals(EgovStringUtil.nullConvert(he.getMessage()))) {
				modelMap.addAttribute("msg", "조회 조건 설정이 되지 않았습니다.");
				modelMap.addAttribute("url", "/");
			} else {
				throw new EmfException(he.getMessage());	
			}
		} 
		return url;
	}

    @RequestMapping(value="/view.do")
    public String selectProdCncl(EmfMap emfMap, ModelMap modelMap) throws Exception {
		try {
			EmfMap rtnMap = cNCProdCnclService.selectProdCncl(emfMap);
			System.out.println(rtnMap.getString("custName"));
			modelMap.addAttribute("f", emfMap.getString("f"));
			modelMap.addAttribute("q", emfMap.getString("q"));
			modelMap.addAttribute("callStts", emfMap.getString("callStts"));
			modelMap.addAttribute("pageIndex", emfMap.getString("pageIndex"));
			modelMap.addAttribute("strtDt", emfMap.getString("strtDt"));
			modelMap.addAttribute("endDt", emfMap.getString("endDt"));
			modelMap.addAttribute("rtnMap", rtnMap);
		} catch (Exception he) {
			if (log.isDebugEnabled()) {
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}
		return "mngwserc/cn/cnc/CNCProdCnclView.admin";
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
	public String updateProdCncl(HttpServletRequest request, EmfMap emfMap, ModelMap modelMap) throws Exception {
		try {
			cNCProdCnclService.updateProdCncl(request, emfMap);
			
			modelMap.addAttribute("f", emfMap.getString("f"));
			modelMap.addAttribute("q", emfMap.getString("q"));
			modelMap.addAttribute("callStts", emfMap.getString("shCallStts"));
			modelMap.addAttribute("pageIndex", emfMap.getString("pageIndex"));
			modelMap.addAttribute("strtDt", emfMap.getString("strtDt"));
			modelMap.addAttribute("endDt", emfMap.getString("endDt"));			
		} catch (Exception he) {
			if (log.isDebugEnabled()) {
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}
		return "redirect:/mngwserc/cnc/prodCncl/view.do?idx=" + emfMap.getString("idx");
	}

	/**
	 * 외주업체 상담관리을 삭제한다.
	 *
	 * @param emfMap
	 * @param modelMap
	 * @param delSeq
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/delete.do", method=RequestMethod.POST)
	public String deleteProdCnclList(EmfMap emfMap, ModelMap modelMap, @RequestParam(value="delSeq", required = true) int[] delSeq) throws Exception
	{
		try
		{
			cNCProdCnclService.deleteProdCnclList(delSeq);
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}
		
		return "redirect:/mngwserc/cnc/prodCncl/list.do";
	}

	/**
	 * 외주업체 상담관리를 엑셀다운로드한다.
	 *
	 * @param emfMap
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
//	/*BLOCK_EXCEL*/@RequestMapping(value="/excel.do")
	public String excelDownLoad(EmfMap emfMap, ModelMap modelMap) throws Exception {
		//검색어 체크
		String f = emfMap.getString("f");
		String q = emfMap.getString("q");	
		String url = "";
		

    	EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
    	emfMap.put("id", lgnMap.getString("id"));
    	
		if (!"".equals(EMFStringUtil.nullConvert(q)) && q.length() <= 15) {
			emfMap.put("f", f);
			emfMap.put("q", q);
		} else {
			emfMap.put("f", "");
			emfMap.put("q", "");
		}
		
		// selectCounselMngList
		try {
			EmfMap rtnMap = cNCProdCnclService.selectProdCnclMngExcelList(emfMap);
			modelMap.addAttribute("rtnMap", rtnMap);
			url = "mngwserc/cn/cnc/CNCProdCnclListExcel";
		} catch (Exception he) {
			if (log.isDebugEnabled()) {
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		} 
		return url;
	}

	/**
	 * 상담관리 엑셀 업로드
	 *
	 * @param emfMap
	 * @param multiRequest
	 * @param req
	 * @return
	 * @throws Exception
	 */
//	/*BLOCK_EXCEL*/@RequestMapping(value = "/upload/excel.do", method = RequestMethod.POST)
	public ModelAndView insertExcelData(EmfMap emfMap, MultipartHttpServletRequest multiRequest, HttpServletRequest req) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsonView");

		try {
			EmfMap result = cNCProdCnclService.setExcelData(multiRequest);
			mav.addObject("result", result);
			mav.addObject("success", true);
		} catch (Exception he) {
			if (log.isDebugEnabled()) log.debug(he);
			throw new EmfException(he.getMessage());
		}
		return mav;
	}

//	/*BLOCK_EXCEL*/:asdfasd:q1@RequestMapping(value="/excelUploadPop.do")
	public String excelUpload(EmfMap emfMap, ModelMap modelMap)
	{
		return "mngwserc/cn/cnc/CNCExcelUploadPop";
	}

}
