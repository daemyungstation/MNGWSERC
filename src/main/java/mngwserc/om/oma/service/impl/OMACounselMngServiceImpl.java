package mngwserc.om.oma.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import mngwserc.co.util.COPaginationUtil;
import mngwserc.om.oma.service.OMACounselMngService;
import mngwserc.om.oma.service.dao.OMACounselMng2DAO;
import mngwserc.om.oma.service.dao.OMACounselMngDAO;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.service.EgovFileMngUtil;
import egovframework.com.cmm.service.EgovProperties;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.com.utl.sim.service.EgovNetworkState;
import egovframework.rte.fdl.idgnr.impl.EgovTableIdGnrService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import emf.core.extend.service.EmfAbstractService;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 외주업체 상담관리를 위한 ServiceImpl
 * </pre>
 * 
 * @ClassName		: PRACounselMngServiceImpl.java
 * @Description		: 외주업체 상담관리를 위한 ServiceImpl
 * @author 김필기
 * @since 2016.02.12
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2016.02.12		김필기					 최초생성
 * </pre>
 */ 
@Service("oMACounselMngService")
public class OMACounselMngServiceImpl extends EmfAbstractService implements OMACounselMngService {
	
	@Resource(name="oMACounselMngDAO")
	private OMACounselMngDAO oMACounselMngDAO;
	
	@Resource(name="oMACounselMng2DAO")
	private OMACounselMng2DAO oMACounselMng2DAO;	

	@Resource(name="EgovCmmUseService")
    private EgovCmmUseService cmmUseService;
	
	@Resource(name="outsourcingIdgen")
	private EgovTableIdGnrService outsourcingIdgen;
	
	@Resource(name="outsourcingDtlIdgen")
	private EgovTableIdGnrService outsourcingDtlIdgen;
	
	@Resource(name="EgovFileMngUtil")
   	private EgovFileMngUtil fileUtil;
	
	private final String atchFileSize = EgovProperties.getProperty("Globals.atchFileSize");
	
	private final String[] atchFileExtns = {"xls"};

	/**
	 * 외주업체 상담관리 목록을 조회한다.
	 *
	 * @param emfMap
	 * @return
	 * @throws Exception
	 */
    public EmfMap selectCounselMngList(EmfMap emfMap) throws Exception {
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		if ("30".equals(lgnMap.getString("authCd"))) {
			EmfMap oamInfMap = null;
			String uplussaveYn = "N";
			String uplussave3Yn = "N";
			String smartYn = "N";		
			
			//if((lgnMap.getString("id").indexOf("uplussave1") > -1) || (lgnMap.getString("id").indexOf("uplussave2") > -1)){
			if ("uplussave1".equals(lgnMap.getString("id")) || "uplussave2".equals(lgnMap.getString("id"))) {
				uplussaveYn = "Y";
			} 

			//if(lgnMap.getString("id").indexOf("uplussave3") > -1){
			if ("uplussave3".equals(lgnMap.getString("id"))) {
				uplussave3Yn = "Y";
			} 

			if ((lgnMap.getString("id").indexOf("smartlife") > -1) || (lgnMap.getString("id").indexOf("smartmobile") > -1) || (lgnMap.getString("id").indexOf("rohasdb") > -1)) {
				smartYn = "Y";
			}
						
			oamInfMap = oMACounselMngDAO.selectOutsourcingAdmMngInfo(lgnMap.getString("id"));

			if (oamInfMap != null) {
				
		    	PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
				
		    	//페이징 처리
		    	emfMap.put("paginationInfo", paginationInfo);
		    	
		    	//페이지 정보
		    	EmfMap opmInfMap = oMACounselMngDAO.selectOutsourcingPageMngInfo(oamInfMap.getString("oscCd"));
				
				emfMap.put("opmInfMap", opmInfMap);
				
				//리스트 가져오기
				emfMap.put("b2bStts", oamInfMap.getString("b2bStts"));
				emfMap.put("code1", oamInfMap.getString("code1"));
				emfMap.put("idNoYn", opmInfMap.getString("idNoYn"));
				emfMap.put("uplussaveYn", uplussaveYn);
				emfMap.put("uplussave3Yn", uplussave3Yn);
				emfMap.put("smartYn", smartYn);

				List<EmfMap> list = oMACounselMngDAO.selectCounselMngList(emfMap);
				
				emfMap.put("list", list);
				
				if (list.size() > 0) {
					paginationInfo.setTotalRecordCount(Integer.parseInt(list.get(0).getString("totCnt")));
					
					if ("LGU".equals(oamInfMap.getString("b2bStts"))){
						setLguMemberInfs(list);
					} else if ("Y".equals(opmInfMap.getString("idNoYn")) || "HANSSEM".equals(oamInfMap.getString("b2bStts")) || "JAUTOUR".equals(oamInfMap.getString("b2bStts"))
							|| "MODETOUR".equals(oamInfMap.getString("b2bStts")) || "DMTOUR".equals(oamInfMap.getString("b2bStts")) || "CHUNGHO".equals(oamInfMap.getString("b2bStts"))
							|| "WEDDING".equals(oamInfMap.getString("b2bStts")) || "KBCAR".equals(oamInfMap.getString("b2bStts")) || "ROHASB2B".equals(oamInfMap.getString("b2bStts"))) {
						setMemberInfs(list);
					}
					
				} else {
					paginationInfo.setTotalRecordCount(0);
				}

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
				logMap.put("gubun", "외주업체 관리 - 상담 목록 조회");
				logMap.put("flag", "S");
				logMap.put("name", RequestContextHolder.getRequestAttributes().getAttribute("name", RequestAttributes.SCOPE_SESSION));
				logMap.put("hp", RequestContextHolder.getRequestAttributes().getAttribute("hp", RequestAttributes.SCOPE_SESSION));
				logMap.put("id", RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION));

				if (logMap.getString("id") != null && !logMap.getString("id").equals("")) {
					cmmUseService.actionViewAuthLog(logMap);
				}
			} else {
				throw new Exception("설정오류");
			}
		} else {
			throw new Exception("권한오류");
		}
		
		return emfMap;
    }
    
    /**
	 * 외주업체 LGU 상담관리 목록을 조회한다.
	 *
	 * @param emfMap
	 * @return
	 * @throws Exception
	 */
    public EmfMap selectCounselMngLGUList(EmfMap emfMap) throws Exception {
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		if ("30".equals(lgnMap.getString("authCd"))) {
			EmfMap oamInfMap = null;
			String uplussaveYn = "N";
			String uplussave3Yn = "N";
			String smartYn = "N";
			String userId = lgnMap.getString("id");
			oamInfMap = oMACounselMngDAO.selectOutsourcingAdmMngInfo(userId);

			if (oamInfMap != null) {
				// ## LG 보안 요청에 대리점 조회시 따라 Security 코드가 일치하지 않으면 보안코드 오류 발생 
				if( "lgusawon".equals(userId) ) {				 
					String rtnMapf = (String)emfMap.get("rtnMapf");
					if( org.apache.commons.lang.math.NumberUtils.isNumber(rtnMapf) ){
						String securityCode = oMACounselMngDAO.selectLgusawonSecurityCode(emfMap);
						String inputSecurityCode = (String)emfMap.get("securityCd");
						if( StringUtils.isEmpty(securityCode ) ) {
							throw new Exception("보안코드점검");
						}
						if( securityCode != null && !securityCode.equals(inputSecurityCode) ) {
							throw new Exception("보안코드오류");
						}
					}								
				}
		    	PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
				
		    	//페이징 처리
		    	emfMap.put("paginationInfo", paginationInfo);
		    	
		    	//페이지 정보
		    	EmfMap opmInfMap = oMACounselMngDAO.selectOutsourcingPageMngInfo(oamInfMap.getString("oscCd"));
				
				emfMap.put("opmInfMap", opmInfMap);
				
				//리스트 가져오기
				emfMap.put("b2bStts", oamInfMap.getString("b2bStts"));
				emfMap.put("code1", oamInfMap.getString("code1"));
				emfMap.put("idNoYn", opmInfMap.getString("idNoYn"));
				emfMap.put("uplussaveYn", uplussaveYn);
				emfMap.put("uplussave3Yn", uplussave3Yn);
				emfMap.put("smartYn", smartYn);

				List<EmfMap> list = oMACounselMngDAO.selectCounselMngLGUList(emfMap);
				
				emfMap.put("list", list);
				
				if (list.size() > 0) {
					paginationInfo.setTotalRecordCount(Integer.parseInt(list.get(0).getString("totCnt")));
					
					if ("LGU".equals(oamInfMap.getString("b2bStts"))){
						setLguMemberInfs(list);
					}
					
				} else {
					paginationInfo.setTotalRecordCount(0);
				}

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
				logMap.put("gubun", "외주업체 관리 - 상담 목록 조회");
				logMap.put("flag", "S");
				logMap.put("name", RequestContextHolder.getRequestAttributes().getAttribute("name", RequestAttributes.SCOPE_SESSION));
				logMap.put("hp", RequestContextHolder.getRequestAttributes().getAttribute("hp", RequestAttributes.SCOPE_SESSION));
				logMap.put("id", RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION));

				if (logMap.getString("id") != null && !logMap.getString("id").equals("")) {
					cmmUseService.actionViewAuthLog(logMap);
				}
			} else {
				throw new Exception("설정오류");
			}
		} else {
			throw new Exception("권한오류");
		}
		
		return emfMap;
    }


	/**
	 * 외주업체 상담관리 상세를 조회한다.
	 *
	 * @param emfMap
	 * @return
	 * @throws Exception
	 */
	public EmfMap selectCounselMng(EmfMap emfMap) throws Exception {
    	EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		if ("30".equals(lgnMap.getString("authCd"))) {
			EmfMap oamInfMap = oMACounselMngDAO.selectOutsourcingAdmMngInfo(lgnMap.getString("id"));
			
			if (oamInfMap != null) {
				emfMap = oMACounselMngDAO.selectCounselMng(emfMap);
		    	
		    	if (emfMap != null) {
		    		
		    		emfMap.put("answerList", oMACounselMngDAO.selectCounselDtlList(emfMap));
		    		
		    		emfMap.put("opmInfMap", oMACounselMngDAO.selectOutsourcingPageMngInfo(oamInfMap.getString("oscCd")));
		    		
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
		    		logMap.put("gubun", "외주업체 관리 - 상담 목록 상세조회");
		    		logMap.put("flag", "D");
		    		logMap.put("name", RequestContextHolder.getRequestAttributes().getAttribute("name", RequestAttributes.SCOPE_SESSION));
		    		logMap.put("hp", RequestContextHolder.getRequestAttributes().getAttribute("hp", RequestAttributes.SCOPE_SESSION));
		    		logMap.put("id", RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION));

		    		if (logMap.getString("id") != null && !logMap.getString("id").equals("")) {
		    			cmmUseService.actionViewAuthLog(logMap);
		    		}
		    	}
			} else {
				throw new Exception("설정오류");
			}
		} else {
			throw new Exception("권한오류");
		}
    	
    	return emfMap;
    }
	
	/**
	 * 외주업체 상담관리 상세를 조회한다.
	 *
	 * @param emfMap
	 * @return
	 * @throws Exception
	 */
	public EmfMap selectCounselLGMng(EmfMap emfMap) throws Exception {
    	EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		if ("30".equals(lgnMap.getString("authCd"))) {
			EmfMap oamInfMap = oMACounselMngDAO.selectOutsourcingAdmMngInfo(lgnMap.getString("id"));
			
			if (oamInfMap != null) {
				emfMap = oMACounselMngDAO.selectCounselLGMng(emfMap);
		    	
		    	if (emfMap != null) {
		    		
		    		emfMap.put("answerList", oMACounselMngDAO.selectCounselLGUDtlList(emfMap));
		    		
		    		emfMap.put("opmInfMap", oMACounselMngDAO.selectOutsourcingPageMngInfo(oamInfMap.getString("oscCd")));
		    		
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
		    		logMap.put("gubun", "외주업체 관리 - 상담 목록 상세조회");
		    		logMap.put("flag", "D");
		    		logMap.put("name", RequestContextHolder.getRequestAttributes().getAttribute("name", RequestAttributes.SCOPE_SESSION));
		    		logMap.put("hp", RequestContextHolder.getRequestAttributes().getAttribute("hp", RequestAttributes.SCOPE_SESSION));
		    		logMap.put("id", RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION));

		    		if (logMap.getString("id") != null && !logMap.getString("id").equals("")) {
		    			cmmUseService.actionViewAuthLog(logMap);
		    		}
		    	}
			} else {
				throw new Exception("설정오류");
			}
		} else {
			throw new Exception("권한오류");
		}
    	
    	return emfMap;
    }

	/**
	 * 외주업체 상담관리을 수정한다.
	 *
	 * @param request
	 * @param emfMap
	 * @throws Exception
	 */
	public void updateCounselMng(HttpServletRequest request, EmfMap emfMap) throws Exception {
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		if ("30".equals(lgnMap.getString("authCd"))) {
			emfMap.put("ip", lgnMap.getString("loginIp"));

			if ("Y".equals(emfMap.getString("updateSkb"))) {
				oMACounselMngDAO.updateSkbJoinMng(emfMap);
			} else {
				emfMap.put("oscCnslDtlSeq", outsourcingDtlIdgen.getNextIntegerId());
				
				oMACounselMngDAO.updateCounselMng(emfMap);
				oMACounselMngDAO.insertCounselDtl(emfMap);
			}

    		/*
			 홈페이지 개인정보 로그 - 보안관련 로직 신규 구현
			 2017.12.26
    		 */
    		EmfMap logMap = new EmfMap();
    		logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
    		logMap.put("gubun", "외주업체 관리 - 상담 관리 수정");
    		logMap.put("flag", "M");
    		logMap.put("name", RequestContextHolder.getRequestAttributes().getAttribute("name", RequestAttributes.SCOPE_SESSION));
    		logMap.put("hp", RequestContextHolder.getRequestAttributes().getAttribute("hp", RequestAttributes.SCOPE_SESSION));
    		logMap.put("id", RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION));

    		if(logMap.getString("id") != null && !logMap.getString("id").equals("")){
    			cmmUseService.actionViewAuthLog(logMap);
    		}
		} else {
			throw new Exception("권한오류");
		}
	}

	/**
	 * 외주업체 상담관리을 삭제한다.
	 *
	 * @param delSeq
	 * @throws Exception
	 */
	public void deleteCounselMngList(int[] delSeq) throws Exception {

	}
	
	/**
	 * 외주업체 상담관리을 수정한다.
	 *
	 * @param request
	 * @param emfMap
	 * @throws Exception
	 */
	public void updateCounselLGUMng(HttpServletRequest request, EmfMap emfMap) throws Exception {
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		if ("30".equals(lgnMap.getString("authCd"))) {
			emfMap.put("ip", lgnMap.getString("loginIp"));

			if ("Y".equals(emfMap.getString("updateSkb"))) {
				oMACounselMngDAO.updateSkbJoinMng(emfMap);
			} else {
				emfMap.put("oscCnslDtlSeq", outsourcingDtlIdgen.getNextIntegerId());
				
				oMACounselMngDAO.updateCounselLGUMng(emfMap);
				oMACounselMngDAO.insertCounselLGUDtl(emfMap);
			}

    		/*
			 홈페이지 개인정보 로그 - 보안관련 로직 신규 구현
			 2017.12.26
    		 */
    		EmfMap logMap = new EmfMap();
    		logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
    		logMap.put("gubun", "외주업체 관리 - 상담 관리 수정");
    		logMap.put("flag", "M");
    		logMap.put("name", RequestContextHolder.getRequestAttributes().getAttribute("name", RequestAttributes.SCOPE_SESSION));
    		logMap.put("hp", RequestContextHolder.getRequestAttributes().getAttribute("hp", RequestAttributes.SCOPE_SESSION));
    		logMap.put("id", RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION));

    		if(logMap.getString("id") != null && !logMap.getString("id").equals("")){
    			cmmUseService.actionViewAuthLog(logMap);
    		}
		} else {
			throw new Exception("권한오류");
		}
	}

	/**
	 * 외주업체 상담관리 엑셀목록을 조회한다.
	 *
	 * @param emfMap
	 * @return
	 * @throws Exception
	 */
	public EmfMap selectCounselMngExcelList(EmfMap emfMap) throws Exception {
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();	// 로그인 사용자 정보
		
		String uplussaveYn = "N";
		String uplussave3Yn = "N";
		String smartYn = "N";			
		
		if ((lgnMap.getString("id").indexOf("uplussave1") > -1) || (lgnMap.getString("id").indexOf("uplussave2") > -1)) {
			uplussaveYn = "Y";
		} 

		if (lgnMap.getString("id").indexOf("uplussave3") > -1) {
			uplussave3Yn = "Y";
		} 

		if ((lgnMap.getString("id").indexOf("smartlife") > -1) || (lgnMap.getString("id").indexOf("smartmobile") > -1)) {
			smartYn = "Y";
		}

		if ("30".equals(lgnMap.getString("authCd"))) {
			EmfMap oamInfMap = oMACounselMngDAO.selectOutsourcingAdmMngInfo(lgnMap.getString("id"));
			
			if (oamInfMap != null) {
				//페이지 정보
				EmfMap opmInfMap = oMACounselMngDAO.selectOutsourcingPageMngInfo(oamInfMap.getString("oscCd"));
				
				emfMap.put("opmInfMap", opmInfMap);
				
				//리스트 가져오기
				emfMap.put("b2bStts", oamInfMap.getString("b2bStts"));
				emfMap.put("code1", oamInfMap.getString("code1"));
				emfMap.put("idNoYn", opmInfMap.getString("idNoYn"));

				emfMap.put("uplussaveYn", uplussaveYn);
				emfMap.put("uplussave3Yn", uplussave3Yn);
				emfMap.put("smartYn", smartYn);
				
				List<EmfMap> list = oMACounselMngDAO.selectCounselMngExcelList(emfMap);
				
				emfMap.put("list", list);
				
				if (list.size() > 0) {
					if ("Y".equals(opmInfMap.getString("idNoYn")) || "WEDDING".equals(oamInfMap.getString("b2bStts")) || "KBCAR".equals(oamInfMap.getString("b2bStts")) || "ROHASB2B".equals(oamInfMap.getString("b2bStts"))) {
						setMemberInfs(list);
					}
					else if (lgnMap.getString("id").indexOf("hansawon") > -1 || lgnMap.getString("id").indexOf("hansawon") > -1 || lgnMap.getString("id").indexOf("modesawon") > -1 || lgnMap.getString("id").indexOf("chunghosawon") > -1 ) {
						setMemberInfs(list);
					}
				}

				/*
				 홈페이지 개인정보 로그 - 보안관련 로직 신규 구현
				 2017.12.26
				 */
				EmfMap logMap = new EmfMap();
				logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
				logMap.put("gubun", "외주업체 관리 - 상담 목록 엑셀 다운로드");
				logMap.put("flag", "E");
				logMap.put("name", RequestContextHolder.getRequestAttributes().getAttribute("name", RequestAttributes.SCOPE_SESSION));
				logMap.put("hp", RequestContextHolder.getRequestAttributes().getAttribute("hp", RequestAttributes.SCOPE_SESSION));
				logMap.put("id", RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION));

				if (logMap.getString("id") != null && !logMap.getString("id").equals("")) {
					cmmUseService.actionViewAuthLog(logMap);
				}
			} else {
				throw new Exception("설정오류");
			}
		} else {
			throw new Exception("권한오류");
		}
		
		return emfMap;
	}
	public EmfMap selectOutsourcingAdmMngInfo(EmfMap emfMap) throws Exception {
		return oMACounselMngDAO.selectOutsourcingAdmMngInfo(emfMap.getString("id"));
	}
	/**
	 * 외주업체 상담관리 엑셀목록을 조회한다.
	 *
	 * @param emfMap
	 * @return
	 * @throws Exception
	 */
	public EmfMap selectCounselMngLGUExcelList(EmfMap emfMap) throws Exception {
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();	// 로그인 사용자 정보
		
		String uplussaveYn = "N";
		String uplussave3Yn = "N";
		String smartYn = "N";			

		if ("30".equals(lgnMap.getString("authCd"))) {
			EmfMap oamInfMap = oMACounselMngDAO.selectOutsourcingAdmMngInfo(lgnMap.getString("id"));
			
			if (oamInfMap != null) {
				//페이지 정보
				EmfMap opmInfMap = oMACounselMngDAO.selectOutsourcingPageMngInfo(oamInfMap.getString("oscCd"));
				
				emfMap.put("opmInfMap", opmInfMap);
				
				//리스트 가져오기
				emfMap.put("b2bStts", oamInfMap.getString("b2bStts"));
				emfMap.put("code1", oamInfMap.getString("code1"));
				emfMap.put("idNoYn", opmInfMap.getString("idNoYn"));

				emfMap.put("uplussaveYn", uplussaveYn);
				emfMap.put("uplussave3Yn", uplussave3Yn);
				emfMap.put("smartYn", smartYn);
				
				List<EmfMap> list = oMACounselMngDAO.selectCounselMngLGUExcelList(emfMap);
//				List<EmfMap> list = oMACounselMngDAO.selectCounselMngExcelList(emfMap);
				
				emfMap.put("list", list);
				setMemberInfs(list);

				/*
				 홈페이지 개인정보 로그 - 보안관련 로직 신규 구현
				 2017.12.26
				 */
				EmfMap logMap = new EmfMap();
				logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
				logMap.put("gubun", "외주업체 관리 - 상담 목록 엑셀 다운로드");
				logMap.put("flag", "E");
				logMap.put("name", RequestContextHolder.getRequestAttributes().getAttribute("name", RequestAttributes.SCOPE_SESSION));
				logMap.put("hp", RequestContextHolder.getRequestAttributes().getAttribute("hp", RequestAttributes.SCOPE_SESSION));
				logMap.put("id", RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION));

				if (logMap.getString("id") != null && !logMap.getString("id").equals("")) {
					cmmUseService.actionViewAuthLog(logMap);
				}
			} else {
				throw new Exception("설정오류");
			}
		} else {
			throw new Exception("권한오류");
		}
		
		return emfMap;
	}
	
	/**
	 * 각 prdctCd가 empty일 경우 다음 값 대입
	 * @param String
	 * @throws Exception
	 */
	public String checkProdCd(EmfMap receiveMap) throws Exception {
		String prodCd = null;
		
		if(StringUtils.isNotEmpty(receiveMap.getString("prdctCd")) && !"M5_".equals(receiveMap.getString("prdctCd"))) {
			prodCd = receiveMap.getString("prdctCd");
			return prodCd;
		} else if ("M5_".equals(receiveMap.getString("prdctCd"))) {
			prodCd = "D";
			return prodCd;
		}
		if(StringUtils.isNotEmpty(receiveMap.getString("prdctCd2" )) && !"M5_".equals(receiveMap.getString("prdctCd2"))) {
			prodCd = receiveMap.getString("prdctCd2");
			return prodCd;
		} else if ("M5_".equals(receiveMap.getString("prdctCd2"))) {
			prodCd = "D";
			return prodCd;
		}
		if(StringUtils.isNotEmpty(receiveMap.getString("prdctCd3")) && !"M5_".equals(receiveMap.getString("prdctCd3"))) {
			prodCd = receiveMap.getString("prdctCd3");
			return prodCd;
		} else if ("M5_".equals(receiveMap.getString("prdctCd3"))) {
			prodCd = "D";
			return prodCd;
		}
		return prodCd;
	}
	
	/**
	 * LGU 계정 로그인시 코드값 설정
	 * @param list
	 * @throws Exception
	 */
	public void setLguMemberInfs(List<EmfMap> list) throws Exception {
		EmfMap cnslMap = null;
		
		String prodCd = null, statNm = null, statNo = null, prodNo = null;

		for(int i = 0; i < list.size(); i++)
		{
			cnslMap = list.get(i);

			prodCd = cnslMap.getString("prodCd");

			if(!"".equals(cnslMap.getString("accntNo")))
			{
				
				if("".equals(prodCd))
				{
					prodCd = checkProdCd(cnslMap);
				}
				if(Integer.parseInt(cnslMap.getString("trueCount")) < 1) // 구좌가 있는데 납입한적이 없으면 2
				{
					statNo = "2";
				}
				else // 납입을 한적이 있으면 3
				{
					statNo = "3";
				}
				
				statNm = cnslMap.getString("accStat");
				
				if("청약철회".equals(statNm)) // 철회하면 4
				{
					statNo = "4";
				}
				else if("해약".equals(statNm)) // 해약하면 5
				{
					statNo = "5";
				}
				else if("행사".equals(statNm)) // 행사면 6
				{
					statNo = "6";
				}
			}
			else // 구좌가 없으면 1
			{
				prodCd = checkProdCd(cnslMap);
				
				statNo = "1"; 
			}
			
			if("M5_".equals(cnslMap.getString("prdctCd")))
			{
				prodNo = "D";
			}
			else
			{
				if("AO".equals(prodCd) || "LGU1".equals(prodCd) || "GR".equals(prodCd))
				{
					prodNo = "AB";
				}
				else if("CO".equals(prodCd) || "LGU2".equals(prodCd))
				{
					prodNo = "AC";
				}
				else if("CP".equals(prodCd) || "LGU3".equals(prodCd)) 
				{
					prodNo = "AD";
				}
				// 2017.11.29 mantis 0010086: [스테이션] U+ 추가상품 출시 관련 관리자 페이지 수정 요청의 건
				else if("CY".equals(prodCd) || "LGU4".equals(prodCd) || "FD".equals(prodCd) || "GT".equals(prodCd))
				{
					prodNo = "AE";
				}
				// 2018.04.23 mantis 0017596: [스테이션] U라이프클럽 페이지 수정 관련
				else if("LGU5".equals(prodCd) || "LGU6".equals(prodCd) || "DM".equals(prodCd) || "GS".equals(prodCd)) 
				{
					prodNo = "AF";
				}
				// 2018.04.23 mantis 0017596: [스테이션] U라이프클럽 페이지 수정 관련
				else if("LGU7".equals(prodCd)) 
				{
					prodNo = "AE";
				}
				else if ("LGU8".equals(prodCd))
				{
					prodNo = "EX";
				}
				// 2020.02.28 redmine issues/1 : [스테이션] U라이프클럽 상담 신청 페이지 수정사항 공유
				else if("LGU9".equals(prodCd) || "KY".equals(prodCd) || "NY".equals(prodCd)|| "OY".equals(prodCd)){
					prodNo = "AG";
				}
				else if("LGU10".equals(prodCd) || "LZ".equals(prodCd) || "NZ".equals(prodCd)|| "OZ".equals(prodCd)){
					prodNo = "AH";
				}
				else if("M5".equals(prodCd))
				{
					prodNo = "A";
				}
				else if("M6".equals(prodCd))
				{
					prodNo = "B";
				}
				else if("LGU11".equals(prodCd) || "OX".equals(prodCd) ){
					prodNo = "AI";
				}
				else if("LGU12".equals(prodCd) || "OW".equals(prodCd)){
					prodNo = "AJ";
				}
				else if("LGU13".equals(prodCd) || "OV".equals(prodCd)){
					prodNo = "AK";
				}
				else
				{
					prodNo = "C";
				}
			}
					
			cnslMap.put("statNo", statNo);
			cnslMap.put("statNm", getStatNm(statNo));
			cnslMap.put("prodNo", prodNo);
			list.set(i, cnslMap);
		}
	}
	
	/**
	 * 외주업체 코드값 설정
	 * @param list
	 * @throws Exception
	 */
	public void setMemberInfs(List<EmfMap> list) throws Exception {
		EmfMap cnslMap = null;
		
		String prodCd = null, statNm = null, statNo = null, prodNo = null;
		
		for(int i = 0; i < list.size(); i++)
		{
			cnslMap = list.get(i);

			prodCd = cnslMap.getString("prodCd");
			
			if(!"".equals(cnslMap.getString("accntNo")))
			{
//				prodCd = cnslMap.getString("prodCd");
				
				if("".equals(prodCd))
				{
					prodCd = checkProdCd(cnslMap);
				}
				if(Integer.parseInt(cnslMap.getString("trueCount")) < 1) // 구좌가 있는데 납입한적이 없으면 2
				{
					statNo = "2";
				}
				else // 납입을 한적이 있으면 3
				{
					statNo = "3";
				}
				
				statNm = cnslMap.getString("accStat");
				
				if("청약철회".equals(statNm)) // 철회하면 4
				{
					statNo = "4";
				}
				else if("해약".equals(statNm)) // 해약하면 5
				{
					statNo = "5";
				}
				else if("행사".equals(statNm)) // 행사면 6
				{
					statNo = "6";
				}
			}
			else // 구좌가 없으면 1
			{
				prodCd = checkProdCd(cnslMap);
				
				statNo = "1";
			}
			
			if("M5_".equals(cnslMap.getString("prdctCd")))
			{
				prodNo = "D";
			}
			else
			{
				if("AO".equals(prodCd) || "LGU1".equals(prodCd) || "GR".equals(prodCd))
				{
					prodNo = "AB";
				}
				else if("CO".equals(prodCd) || "LGU2".equals(prodCd))
				{
					prodNo = "AC";
				}
				else if("CP".equals(prodCd) || "LGU3".equals(prodCd)) 
				{
					prodNo = "AD";
				}
				// 2017.11.29 mantis 0010086: [스테이션] U+ 추가상품 출시 관련 관리자 페이지 수정 요청의 건
				else if("CY".equals(prodCd) || "LGU4".equals(prodCd) || "FD".equals(prodCd) || "GT".equals(prodCd))
				{
					prodNo = "AE";
				}
				// 2018.04.23 mantis 0017596: [스테이션] U라이프클럽 페이지 수정 관련
				else if("LGU5".equals(prodCd) || "LGU6".equals(prodCd) || "DM".equals(prodCd) || "GS".equals(prodCd)) 
				{
					prodNo = "AF";
				}
				// 2018.04.23 mantis 0017596: [스테이션] U라이프클럽 페이지 수정 관련
				else if("LGU7".equals(prodCd)) 
				{
					prodNo = "AE";
				}
				// 2020.02.28 redmine issues/1 : [스테이션] U라이프클럽 상담 신청 페이지 수정사항 공유
				else if("LGU9".equals(prodCd) || "KY".equals(prodCd) || "NY".equals(prodCd)|| "OY".equals(prodCd)){
					prodNo = "AG";
				}
				else if("LGU10".equals(prodCd) || "LZ".equals(prodCd) || "NZ".equals(prodCd)|| "OZ".equals(prodCd)){
					prodNo = "AH";
				}
				else if ("LGU8".equals(prodCd))
				{
					prodNo = "EX";
				}
				else if("M5".equals(prodCd))
				{
					prodNo = "A";
				}
				else if("M6".equals(prodCd))
				{
					prodNo = "B";
				}
				else if("LGU11".equals(prodCd) || "OX".equals(prodCd) ){
					prodNo = "AI";
				}
				else if("LGU12".equals(prodCd) || "OW".equals(prodCd)){
					prodNo = "AJ";
				}
				else if("LGU13".equals(prodCd) || "OV".equals(prodCd)){
					prodNo = "AK";
				}
				else if("DLIVE1".equals(prodCd) ){
					prodNo = "QS";
				}
				else if("DLIVE2".equals(prodCd) ){
					prodNo = "QT";
				}
				else
				{
					prodNo = "C";
				}
			}
					
			cnslMap.put("statNo", statNo);
			cnslMap.put("statNm", getStatNm(statNo));
			cnslMap.put("prodNo", prodNo);
			list.set(i, cnslMap);
		}
	}

	/**
	 * 양식으로 업로드된 데이터를 가져온다.
	 *
	 * @param emfMap
	 * @param multiRequest
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public String insertExcelData(EmfMap emfMap, MultipartHttpServletRequest multiRequest, HttpServletRequest req) throws Exception
	{
		final Map<String, MultipartFile> files = multiRequest.getFileMap();	

		if(!files.isEmpty()) 
		{
			List<EmfMap> atchFileList = null;
	
			atchFileList = fileUtil.parseFileInf(files, "", 0, "", "Globals.fileStorePath", "atchFile", Integer.parseInt(atchFileSize), atchFileExtns);
			
			if(atchFileList.size() > 0) 
			{
				Workbook workbook = null;
			    Sheet sheet = null;
			    Cell orderNo = null;
			    Cell name = null;
			    Cell ph = null;

			    String b2bStts = "";
			    String b2bNm   = "";
			    
			    EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
				
			    if(lgnMap.getString("id").indexOf("interpark") > -1){
					b2bStts = "ONLIFECC";
					b2bNm 	= "인터파크";
					
				} 
			    
			    if(lgnMap.getString("id").indexOf("ezwel") > -1){
					b2bStts = "EZWEL";
					b2bNm 	= "대명 ON라이프";
					
				} 
			    
			    if(lgnMap.getString("id").indexOf("tmon") > -1){
			    	b2bStts = "TMON";
			    	b2bNm 	= "티몬";
			    	
			    } 

			    //엑셀파일을 인식
				workbook = Workbook.getWorkbook(new FileInputStream(new File(atchFileList.get(0).getString("phyPath") , atchFileList.get(0).getString("saveFileNm"))));
				
		        if(workbook != null)
		        {
		        	//엑셀파일에서 첫번째 Sheet를 인식
		            sheet = workbook.getSheet(0);

		            if(sheet != null)
		            {
		            	int rows = sheet.getRows();       // 세로항목
		            	
		            	String regIp = EgovNetworkState.getMyIPaddress(req);
		    			String sid = RequestContextHolder.getRequestAttributes().getSessionId();
		    			
		            	for(int i = 1; i < rows; i++)
		            	{
		            		EmfMap paramMap = new EmfMap();
		            		
		            		orderNo = sheet.getCell(0, i);
		            		name = sheet.getCell(1, i);
		            		ph = sheet.getCell(2, i);
		            		
		            		paramMap.put("seq", outsourcingIdgen.getNextIntegerId());
		            		paramMap.put("name", name.getContents());
		            		paramMap.put("hp", ph.getContents());
		            		paramMap.put("idNo", orderNo.getContents());
		            		paramMap.put("regIp", regIp);
		            		paramMap.put("sid", sid);
		            		paramMap.put("b2bStts", b2bStts);
		            		paramMap.put("b2bNm", b2bNm);
		            		
	            			oMACounselMngDAO.insertExcelInf(paramMap);
	            	    }

		            	/*
						 홈페이지 개인정보 로그 - 보안관련 로직 신규 구현
						 2017.12.26
		            	 */
		            	EmfMap logMap = new EmfMap();
		            	logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
		            	logMap.put("gubun", "외주업체 관리 - 상담 목록 엑셀 업로드");
		            	logMap.put("flag", "U");
		            	logMap.put("name", RequestContextHolder.getRequestAttributes().getAttribute("name", RequestAttributes.SCOPE_SESSION));
		            	logMap.put("hp", RequestContextHolder.getRequestAttributes().getAttribute("hp", RequestAttributes.SCOPE_SESSION));
		            	logMap.put("id", RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION));
		        		if(logMap.getString("id") != null && !logMap.getString("id").equals("")){
		        			cmmUseService.actionViewAuthLog(logMap);
		        		}
		            }
		        }
		        
		        workbook.close();
			}
			
			return "OK";
		}
		else
		{
			return "ER";
		}
	}
	
	/**
	 * LGU 사용자 데이터를 가져온 뒤 엑셀 파일로 생성한다.
	 *
	 * @return void
	 * @throws Exception
	 */
	public void selectLgusawonUserData() throws Exception {
		//작일, 금일 날짜 가져오기
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        Calendar cal = Calendar.getInstance();

        String previous = null;
        String now = null;
        
        cal.setTime(date);
        cal.add(Calendar.DATE, -1);
        previous = format.format(cal.getTime());
        now = format.format(date);

        //전일 파일 확인후 삭제
        File file = new File(EgovProperties.getProperty("Globals.excelFileStorePath") + "/LGUDataExcel" + previous +".xls");
        if(file.exists()) {
            System.out.println("============= 파일 있음");
            if(file.delete()) {
                System.out.println("============= 파일 삭제");
            }
        } else {
        	System.out.println("============= 파일 없음");
        }
        System.out.println(previous);
        System.out.println(now);
		
        try{
        
		//데이터 패치 후 엑셀 생성
		EmfMap paramMap = new EmfMap();
		paramMap.put("now", now);
		paramMap.put("order_by", " REG_DTM DESC ");
		HSSFWorkbook workbook = new HSSFWorkbook();
		OMACounselExcelHandler handler = new OMACounselExcelHandler(workbook);
		
		
		oMACounselMngDAO.selectLgusawonUserData(paramMap, handler);
//		setLguMemberInfs();
		
		String filePath = EgovProperties.getProperty("Globals.excelFileStorePath") + "/LGUDataExcel"+ now +".xls";
		System.out.println("filePath : " + filePath);
		
		FileOutputStream fileOut = new FileOutputStream(filePath);
		workbook.write(fileOut);
		fileOut.close();
		
        }catch(Exception e){
        	e.printStackTrace();
        }
	}
	
	private String getStatNm(String statNo){
		String strResult = "";
		
		if("1".equals(statNo)){
			strResult = "상담신청완료/미가입한 상태";
		} else if("2".equals(statNo)){
			strResult = "녹취완료";
		} else if("3".equals(statNo)){
			strResult = "출금완료";
		} else if("4".equals(statNo)){
			strResult = "청약철회";
		} else if("5".equals(statNo)){
			strResult = "해약";
		} else if("6".equals(statNo)){
			strResult = "행사사용";
		}
		
		return strResult;
	}
	
}