package mngwserc.cn.cnc.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import egovframework.com.cmm.service.EgovFileMngUtil;
import egovframework.com.cmm.service.EgovProperties;
import egovframework.rte.fdl.idgnr.impl.EgovTableIdGnrService;
import emf.core.exception.EmfException;
import emf.core.util.EMFSecurityUtil;
import jxl.Sheet;
import jxl.Workbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import mngwserc.cn.cnc.service.CNCProdCnclService;
import mngwserc.cn.cnc.service.dao.CNCProdCnclDAO;
import mngwserc.co.util.COPaginationUtil;
import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import emf.core.extend.service.EmfAbstractService;
import emf.core.vo.EmfMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service("cNCProdCnclService")
public class CNCProdCnclServiceImpl  extends EmfAbstractService implements CNCProdCnclService {

	@Resource(name="cNCProdCnclDAO")
	private CNCProdCnclDAO cNCProdCnclDAO; 
	
	@Resource(name="EgovCmmUseService")
    private EgovCmmUseService cmmUseService;

	@Resource(name="EgovFileMngUtil")
	private EgovFileMngUtil fileUtil;

	@Resource(name="prodCnclIdgen")
	private EgovTableIdGnrService prodCnclIdgen;

	private final String atchFileSize = EgovProperties.getProperty("Globals.atchFileSize");
	private final String[] atchFileExtns = {"xls"};

	@Override
	public EmfMap selectProdCnclList(EmfMap emfMap) throws Exception {
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
/*		if("30".equals(lgnMap.getString("authCd")))
		{*/
			EmfMap oamInfMap = null;
			
	    	PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
			
	    	//페이징 처리
	    	emfMap.put("paginationInfo", paginationInfo);
	    	
			List<EmfMap> list = cNCProdCnclDAO.selectProdCnclList(emfMap);
			
			emfMap.put("list", list);
			
			if (list.size() > 0) {
				for (int i=0; i<list.size(); i++) {
					EMFSecurityUtil.maskEmfMap(list.get(i), "custName", "custHphone", null);
				}
				paginationInfo.setTotalRecordCount(Integer.parseInt(list.get(0).getString("totCnt")));
			} else {
				paginationInfo.setTotalRecordCount(0);
			}
			//공통코드 배열 셋팅
			ArrayList<String> cdDtlList = new ArrayList<String>();
			
			//상담상태
			cdDtlList.add("CALL_STTS");	
			
			//정의된 코드id값들의 상세 코드 맵 반환		
			emfMap.put("cdDtlList", cmmUseService.selectCmmCodeBindAll(cdDtlList));

			/*2022.03.18 황순용 refactor*/
			cmmUseService.actionViewAuthLogV2("다이렉트 채널 - 원클릭 상담 관리 - 상담관리", "", "S", null);

			/*		}
		else
		{
			throw new Exception("권한오류");
		}*/
		
		return emfMap;
	}

	@Override
	public EmfMap selectProdCncl(EmfMap emfMap) throws Exception {
		emfMap = cNCProdCnclDAO.selectProdCncl(emfMap);
    	
    	if(emfMap != null)
    	{
    		
    		emfMap.put("answerList", cNCProdCnclDAO.selectProdCnclDtlList(emfMap));
    		
    		//공통코드 배열 셋팅
    		ArrayList<String> cdDtlList = new ArrayList<String>();
    		
    		//상담상태
    		cdDtlList.add("CALL_STTS");
    		
    		//정의된 코드id값들의 상세 코드 맵 반환
    		emfMap.put("cdDtlList", cmmUseService.selectCmmCodeBindAll(cdDtlList));
    		
    		/*
			 홈페이지 개인정보 로그 - 보안관련 로직 신규 구현
			 2017.12.26
    		 */
    		EmfMap logMap = new EmfMap();
    		logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
    		logMap.put("gubun", "다이렉트 채널 - 원클릭 상담 관리 - 상담관리");
    		logMap.put("flag", "D");
    		logMap.put("name", RequestContextHolder.getRequestAttributes().getAttribute("name", RequestAttributes.SCOPE_SESSION));
    		logMap.put("hp", RequestContextHolder.getRequestAttributes().getAttribute("hp", RequestAttributes.SCOPE_SESSION));
    		logMap.put("id", RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION));
    		if(logMap.getString("id") != null && !logMap.getString("id").equals("")){
    			cmmUseService.actionViewAuthLog(logMap);
    		}

    	}

    	return emfMap;
	}

	@Override
	public void updateProdCncl(HttpServletRequest request, EmfMap emfMap)
			throws Exception {
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("ip", lgnMap.getString("loginIp"));

		cNCProdCnclDAO.updateProdCnclMng(emfMap);
		cNCProdCnclDAO.insertProdCnclDtl(emfMap);

		/*
		 홈페이지 개인정보 로그 - 보안관련 로직 신규 구현
		 2017.12.26
		 */
		EmfMap logMap = new EmfMap();
		logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
		logMap.put("gubun", "다이렉트 채널 - 원클릭 상담 관리 - 상담관리 수정");
		logMap.put("flag", "M");
		logMap.put("name", RequestContextHolder.getRequestAttributes().getAttribute("name", RequestAttributes.SCOPE_SESSION));
		logMap.put("hp", RequestContextHolder.getRequestAttributes().getAttribute("hp", RequestAttributes.SCOPE_SESSION));
		logMap.put("id", RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION));
		if(logMap.getString("id") != null && !logMap.getString("id").equals("")){
			cmmUseService.actionViewAuthLog(logMap);
		}
	}

	@Override
	public void deleteProdCnclList(int[] delSeq) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EmfMap selectProdCnclMngExcelList(EmfMap emfMap) throws Exception {
    	PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
		
    	//페이징 처리
    	emfMap.put("paginationInfo", paginationInfo);
    	
		List<EmfMap> list = cNCProdCnclDAO.selectProdCnclExcelList(emfMap);
		
		emfMap.put("list", list);

		/*
		 홈페이지 개인정보 로그 - 보안관련 로직 신규 구현
		 2017.12.26
		 */
		EmfMap logMap = new EmfMap();
		logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
		logMap.put("gubun", "다이렉트 채널 - 원클릭 상담 관리 - 상담관리");
		logMap.put("flag", "S");
		logMap.put("name", RequestContextHolder.getRequestAttributes().getAttribute("name", RequestAttributes.SCOPE_SESSION));
		logMap.put("hp", RequestContextHolder.getRequestAttributes().getAttribute("hp", RequestAttributes.SCOPE_SESSION));
		logMap.put("id", RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION));

		if(logMap.getString("id") != null && !logMap.getString("id").equals("")){
			cmmUseService.actionViewAuthLog(logMap);
		}
		return emfMap;
	}


	@Override
	public EmfMap setExcelData(MultipartHttpServletRequest multiRequest) throws Exception {
		Map<String, MultipartFile> files = multiRequest.getFileMap();
		EmfMap result = new EmfMap();
		if (!files.isEmpty()) {
			List<EmfMap> atchFileList = fileUtil.parseFileInf(files, "", 0, "", "Globals.fileStorePath", "atchFile", Integer.parseInt("20971520"), atchFileExtns);
			if (atchFileList.size() > 0) {
				Workbook workbook = Workbook.getWorkbook(new FileInputStream(new File(atchFileList.get(0).getString("phyPath"), atchFileList.get(0).getString("saveFileNm"))));
				if (workbook != null) {
					Sheet sheet = workbook.getSheet(0);
					int rows = sheet.getRows();
					EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
					List<EmfMap> successList = new ArrayList<EmfMap>();
					List<EmfMap> failList = new ArrayList<EmfMap>();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					for (int i = 1; i < rows; i++) {
					    if (sheet.getCell(2, i).getContents() != null && sheet.getCell(2, i).getContents() != "") {
                            EmfMap paramMap = new EmfMap();
                            try {
//                                paramMap.put("no", prodCnclIdgen.getNextIntegerId());
                                paramMap.put("name", sheet.getCell(1, i).getContents());
                                paramMap.put("phone", sheet.getCell(2, i).getContents());
                                paramMap.put("productName", sheet.getCell(3, i).getContents());
                                paramMap.put("inflowChannel", sheet.getCell(4, i).getContents());
                                paramMap.put("interestGoods", sheet.getCell(5, i).getContents());
                                paramMap.put("counselTime", sheet.getCell(6, i).getContents());
                                paramMap.put("regDtm", sheet.getCell(7, i).getContents());
                                paramMap.put("cnslr", sheet.getCell(8, i).getContents());
                                paramMap.put("counselCd", sheet.getCell(9, i).getContents());
                                paramMap.put("cntn", sheet.getCell(10, i).getContents());
                                paramMap.put("regId", lgnMap.getString("id"));
                                paramMap.put("regIp", lgnMap.getString("loginIp"));
                                cNCProdCnclDAO.insertExcelData(paramMap);
                                successList.add(paramMap);
                            } catch (Exception e) {
                                e.printStackTrace();
                                failList.add(paramMap);
                            }
                        }
					}

					result.put("success", successList);
					result.put("fail", failList);
				}
			}
		}
		return result;
	}
}
