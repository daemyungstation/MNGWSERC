package mngwserc.cm.cmc.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import mngwserc.cm.cmc.service.CMCPfmcInfService;
import mngwserc.cm.cmc.service.dao.CMCPfmcInfDAO;
import mngwserc.co.util.COPaginationUtil;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import egovframework.com.cmm.exception.FileNotSizeException;
import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.service.EgovFileMngService;
import egovframework.com.cmm.service.EgovFileMngUtil;
import egovframework.com.cmm.service.EgovProperties;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.idgnr.impl.EgovTableIdGnrService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import emf.core.extend.service.EmfAbstractService;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 공연정보 관리를 위한 ServiceImpl
 * </pre>
 * 
 * @ClassName		: CMCPfmcInfServiceImpl.java
 * @Description		: 공연정보 관리를 위한 ServiceImpl
 * @author 허진영
 * @since 2016.02.11
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2016.02.11		허진영					 최초생성
 * </pre>
 */ 
@Service("cMCPfmcInfService")
public class CMCPfmcInfServiceImpl extends EmfAbstractService implements CMCPfmcInfService {
	
	@Resource(name="cMCPfmcInfDAO")
	private CMCPfmcInfDAO cMCPfmcInfDAO;
	
	@Resource(name="EgovCmmUseService")
    private EgovCmmUseService cmmUseService;
	
	@Resource(name="pfmcIdgen")
	private EgovTableIdGnrService pfmcIdgen;	
	
	@Resource(name="rsvtnDtmIdgen")
	private EgovTableIdGnrService rsvtnDtmIdgen;	
	
	@Resource(name="EgovFileMngService")
    private EgovFileMngService fileMngService;
    
   	@Resource(name = "EgovFileMngUtil")
   	private EgovFileMngUtil fileUtil;
   	
   	private final String imgFileSize = EgovProperties.getProperty("Globals.imgFileSize");
	
	private final String[] imgFileExtns = EgovProperties.getProperty("Globals.imgFileExtns").split(",");
	
	/**
     * 공연정보 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectPfmcInfList(EmfMap emfMap) throws Exception
    {
    	PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
		
		//페이징 처리
		emfMap.put("paginationInfo", paginationInfo);    	
		
		//리스트 가져오기
		List<EmfMap> list = cMCPfmcInfDAO.selectPfmcInfList(emfMap);
		
		emfMap.put("list", list);
		
		if(list.size() > 0)
		{
			paginationInfo.setTotalRecordCount(Integer.parseInt(list.get(0).getString("totCnt")));
		}
		else
		{
			paginationInfo.setTotalRecordCount(0);
		}

		/*
		 홈페이지 개인정보 로그 - 보안관련 로직 신규 구현
		 2017.12.26
		 */
		EmfMap logMap = new EmfMap();
		logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
		logMap.put("gubun", "고객서비스 관리 - 공연예약관리 - 공연정보 조회");
		logMap.put("flag", "S");
		logMap.put("name", RequestContextHolder.getRequestAttributes().getAttribute("name", RequestAttributes.SCOPE_SESSION));
		logMap.put("hp", RequestContextHolder.getRequestAttributes().getAttribute("hp", RequestAttributes.SCOPE_SESSION));
		logMap.put("id", RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION));
		if(logMap.getString("id") != null && !logMap.getString("id").equals("")){
			cmmUseService.actionViewAuthLog(logMap);
		}
		
		return emfMap;
    }
    
    /**
     * 공연정보 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectPfmcInf(EmfMap emfMap) throws Exception
    {
    	if(!"".equals(EMFStringUtil.nullConvert(emfMap.get("pfmcSeq"))))
    	{
    		EmfMap pfmcInfo = cMCPfmcInfDAO.selectPfmcInf(emfMap);
    		
	    	if(pfmcInfo != null)
	    	{
	    		emfMap.put("pfmcInfo", pfmcInfo);
	    		
	    		if(!"".equals(EMFStringUtil.nullConvert(pfmcInfo.getString("atchFileId"))))
	    		{
	    			emfMap.put("fileList", fileMngService.selectFileInfs(pfmcInfo));
	    		}
	    	}

	    	/*
	   		 홈페이지 개인정보 로그 - 보안관련 로직 신규 구현
	   		 2017.12.26
	    	 */
	    	EmfMap logMap = new EmfMap();
	    	logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
	    	logMap.put("gubun", "고객서비스 관리 - 공연예약관리 - 공연정보 상세조회");
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
    
	/**
     * 공연정보를 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertPfmcInf(MultipartHttpServletRequest multiRequest, EmfMap emfMap) throws Exception
	{
		try
		{
			//첨부파일 업로드
			final Map<String, MultipartFile> files = multiRequest.getFileMap();	
			
			if(!files.isEmpty())
			{
				List<EmfMap> atchFileList = null;
				String atchFileId = null;
		
				atchFileList = fileUtil.parseFileInf(files, "", 0, "", "Globals.fileStorePath", "atchFile", Integer.parseInt(imgFileSize), imgFileExtns);
				
				if(files.size() == atchFileList.size())
				{
					atchFileId = fileMngService.insertFileInfs(atchFileList);
					emfMap.put("atchFileId", atchFileId);
				} 
				else 
				{
					throw new FileNotSizeException("파일용량초과");
				}
			}
			
			EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
			
			emfMap.put("pfmcSeq", pfmcIdgen.getNextIntegerId());
			
			//공연시작, 종료일 setting
			emfMap.put("pfmcStrtDt", emfMap.getString("pfmcStrtDt").replaceAll("-", ""));
			emfMap.put("pfmcEndDt", emfMap.getString("pfmcEndDt").replaceAll("-", ""));
			
			emfMap.put("regId", lgnMap.getString("id"));
			emfMap.put("regIp", lgnMap.getString("loginIp"));
			emfMap.put("modId", lgnMap.getString("id"));
			emfMap.put("modIp", lgnMap.getString("loginIp"));
			
			cMCPfmcInfDAO.insertPfmcInf(emfMap);
			
			/*
	   		 홈페이지 개인정보 로그 - 보안관련 로직 신규 구현
	   		 2017.12.26
			 */
			EmfMap logMap = new EmfMap();
			logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
			logMap.put("gubun", "고객서비스 관리 - 공연예약관리 - 공연정보 등록");
			logMap.put("flag", "C");
			logMap.put("name", RequestContextHolder.getRequestAttributes().getAttribute("name", RequestAttributes.SCOPE_SESSION));
			logMap.put("hp", RequestContextHolder.getRequestAttributes().getAttribute("hp", RequestAttributes.SCOPE_SESSION));
			logMap.put("id", RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION));
			if(logMap.getString("id") != null && !logMap.getString("id").equals("")){
				cmmUseService.actionViewAuthLog(logMap);
			}
		}
		catch(Exception e)
		{
			throw (Exception)e;
		}
	}
	
	/**
     * 공연정보를 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updatePfmcInf(MultipartHttpServletRequest multiRequest , EmfMap emfMap) throws Exception
	{
		try
		{
			//첨부파일 업로드
			final Map<String, MultipartFile> files = multiRequest.getFileMap();	
			
			if(!files.isEmpty())
			{
				List<EmfMap> atchFileList = null;
	
				String pAtchFileId = emfMap.getString("atchFileId");
		
				atchFileList = fileUtil.parseFileInf(files, "", 0, pAtchFileId, "Globals.fileStorePath", "atchFile", Integer.parseInt(imgFileSize), imgFileExtns);
				
				if(files.size() == atchFileList.size())
				{
					fileMngService.updateFileInfs(atchFileList);
				} 
				else 
				{
					throw new FileNotSizeException("파일용량초과");
				}
			}
			
			EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
			
			//공연시작, 종료일 setting
			emfMap.put("pfmcStrtDt", emfMap.getString("pfmcStrtDt").replaceAll("-", ""));
			emfMap.put("pfmcEndDt", emfMap.getString("pfmcEndDt").replaceAll("-", ""));
			
			emfMap.put("modIp", lgnMap.getString("loginIp"));
			emfMap.put("modId", lgnMap.getString("id"));
			
			cMCPfmcInfDAO.updatePfmcInf(emfMap);
			
			/*
	   		 홈페이지 개인정보 로그 - 보안관련 로직 신규 구현
	   		 2017.12.26
			 */
			EmfMap logMap = new EmfMap();
			logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
			logMap.put("gubun", "고객서비스 관리 - 공연예약관리 - 공연정보 수정");
			logMap.put("flag", "M");
			logMap.put("name", RequestContextHolder.getRequestAttributes().getAttribute("name", RequestAttributes.SCOPE_SESSION));
			logMap.put("hp", RequestContextHolder.getRequestAttributes().getAttribute("hp", RequestAttributes.SCOPE_SESSION));
			logMap.put("id", RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION));
			if(logMap.getString("id") != null && !logMap.getString("id").equals("")){
				cmmUseService.actionViewAuthLog(logMap);
			}
		}
		catch(Exception e)
		{
			throw (Exception)e;
		}
	}
	
	/**
     * 공연정보를 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deletePfmcInfList(int[] delSeq) throws Exception
	{
  		EmfMap emfMap = new EmfMap();

  		emfMap.put("delSeq", delSeq);
		
		//공연정보 삭제
		cMCPfmcInfDAO.deletePfmcInf(emfMap);
		
		//공역예약일시정보 삭제
		cMCPfmcInfDAO.deleteRsvtnDtmAll(emfMap);

		/*
  		 홈페이지 개인정보 로그 - 보안관련 로직 신규 구현
  		 2017.12.26
		 */
		EmfMap logMap = new EmfMap();
		logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
		logMap.put("gubun", "고객서비스 관리 - 공연예약관리 - 공연정보 삭제");
		logMap.put("flag", "R");
		logMap.put("name", RequestContextHolder.getRequestAttributes().getAttribute("name", RequestAttributes.SCOPE_SESSION));
		logMap.put("hp", RequestContextHolder.getRequestAttributes().getAttribute("hp", RequestAttributes.SCOPE_SESSION));
		logMap.put("id", RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION));
		if(logMap.getString("id") != null && !logMap.getString("id").equals("")){
			cmmUseService.actionViewAuthLog(logMap);
		}
	}
	
	/**
     * 공연예약정보를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectRsvtnInf(EmfMap emfMap) throws Exception
    {
    	EmfMap pfmcInfo = cMCPfmcInfDAO.selectPfmcInf(emfMap);
		
    	if(pfmcInfo != null)
    	{
    		emfMap.put("pfmcInfo", pfmcInfo);
    		
    		emfMap.put("rsvtnDtmList", cMCPfmcInfDAO.selectRsvtnDtmList(emfMap));

    		/*
     		 홈페이지 개인정보 로그 - 보안관련 로직 신규 구현
     		 2017.12.26
    		 */
    		EmfMap logMap = new EmfMap();
    		logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
    		logMap.put("gubun", "고객서비스 관리 - 공연예약관리 - 공연예약 조회");
    		logMap.put("flag", "S");
    		logMap.put("name", RequestContextHolder.getRequestAttributes().getAttribute("name", RequestAttributes.SCOPE_SESSION));
    		logMap.put("hp", RequestContextHolder.getRequestAttributes().getAttribute("hp", RequestAttributes.SCOPE_SESSION));
    		logMap.put("id", RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION));
    		if(logMap.getString("id") != null && !logMap.getString("id").equals("")){
    			cmmUseService.actionViewAuthLog(logMap);
    		}
    	}

    	return emfMap;
    }
    
    /**
     * 공연예약정보를 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertRsvtnInf(EmfMap emfMap) throws Exception
	{
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("regId", lgnMap.getString("id"));
		emfMap.put("regIp", lgnMap.getString("loginIp"));
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		//공연정보(관람좌석)를 수정한다.
		cMCPfmcInfDAO.updateSeatUseYn(emfMap);
		
		//공연예약일시를 삭제한다.
		cMCPfmcInfDAO.deleteRsvtnDtm(emfMap);
		
		//공연예약일시를 등록한다.
		List<String> rsvtnDtm = emfMap.getList("rsvtnDtm");
		
		for(int i = 0; i < rsvtnDtm.size(); i++)
		{
			emfMap.put("rsvtnDtmSeq", rsvtnDtmIdgen.getNextIntegerId());
			emfMap.put("rsvtnDtm", rsvtnDtm.get(i));
			cMCPfmcInfDAO.insertRsvtnDtm(emfMap);
		}
		
		/*
		 홈페이지 개인정보 로그 - 보안관련 로직 신규 구현
		 2017.12.26
		 */
		EmfMap logMap = new EmfMap();
		logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
		logMap.put("gubun", "고객서비스 관리 - 공연예약관리 - 공연예약 등록");
		logMap.put("flag", "C");
		logMap.put("name", RequestContextHolder.getRequestAttributes().getAttribute("name", RequestAttributes.SCOPE_SESSION));
		logMap.put("hp", RequestContextHolder.getRequestAttributes().getAttribute("hp", RequestAttributes.SCOPE_SESSION));
		logMap.put("id", RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION));
		if(logMap.getString("id") != null && !logMap.getString("id").equals("")){
			cmmUseService.actionViewAuthLog(logMap);
		}
	}
}
