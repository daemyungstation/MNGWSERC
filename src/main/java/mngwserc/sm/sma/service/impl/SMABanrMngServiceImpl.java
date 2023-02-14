package mngwserc.sm.sma.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import mngwserc.co.util.COPaginationUtil;
import mngwserc.sm.sma.service.SMABanrMngService;
import mngwserc.sm.sma.service.dao.SMABanrMngDAO;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import egovframework.com.cmm.exception.FileNotSizeException;
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
 * 배너 관리를 위한 ServiceImpl
 * </pre>
 * 
 * @ClassName		: SMABanrMngServiceImpl.java
 * @Description		: 배너 관리를 위한 ServiceImpl
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
@Service("sMABanrMngService")
public class SMABanrMngServiceImpl extends EmfAbstractService implements SMABanrMngService {
	
	@Resource(name="sMABanrMngDAO")
    private SMABanrMngDAO sMABanrMngDAO;
	
	@Resource(name="EgovFileMngService")
    private EgovFileMngService fileMngService;
    
   	@Resource(name = "EgovFileMngUtil")
   	private EgovFileMngUtil fileUtil;
	
	@Resource(name="banrIdgen")
	private EgovTableIdGnrService banrIdgen;
	
	private final String imgFileSize = EgovProperties.getProperty("Globals.imgFileSize");
	
	private final String[] imgFileExtns = EgovProperties.getProperty("Globals.imgFileExtns").split(",");
	
	/**
	 * 배너 목록을 조회한다.
	 * 
	 * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */    
	public EmfMap selectBanrList(EmfMap emfMap) throws Exception
    {
		PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
		
		//페이징 처리
		emfMap.put("paginationInfo", paginationInfo);
		
		//리스트 가져오기
		List<EmfMap> list = sMABanrMngDAO.selectBanrList(emfMap);
	
		emfMap.put("list", list);	
		
		if(list.size() > 0)
		{
			paginationInfo.setTotalRecordCount(Integer.parseInt(list.get(0).getString("totCnt")));
		}
		else
		{
			paginationInfo.setTotalRecordCount(0);
		}
		
		return emfMap;		
    }
	
	/**
	 * 배너 상세를 조회한다.
	 * 
	 * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */    
	public EmfMap selectBanr(EmfMap emfMap) throws Exception
    {	
		if(!"".equals(EMFStringUtil.nullConvert(emfMap.get("banrSeq"))))
    	{
			EmfMap banrInfo = sMABanrMngDAO.selectBanr(emfMap);
			
			if(banrInfo != null)
	    	{
				emfMap.put("banrInfo", banrInfo);
				
				if(!"".equals(EMFStringUtil.nullConvert(banrInfo.get("atchFileId"))))
	    		{
	    			emfMap.put("fileList", fileMngService.selectFileInfs(banrInfo));
	    		}
	    	}
    	}
		
		return emfMap;
    }
	
	/**
     * 배너를 등록한다.
     * 
     * @param EmfMap
	 * @return
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertBanr(MultipartHttpServletRequest multiRequest, EmfMap emfMap) throws Exception
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
			
			emfMap.put("banrSeq", banrIdgen.getNextIntegerId());
			
			//게시시작, 종료일 setting
			emfMap.put("ptupStrtDt", emfMap.getString("ptupStrtDt").replaceAll("-", ""));
			emfMap.put("ptupEndDt", emfMap.getString("ptupEndDt").replaceAll("-", ""));
			
			emfMap.put("regId", lgnMap.getString("id"));
			emfMap.put("regIp", lgnMap.getString("loginIp"));
			emfMap.put("modId", lgnMap.getString("id"));
			emfMap.put("modIp", lgnMap.getString("loginIp"));

			sMABanrMngDAO.insertBanr(emfMap);
		}
		catch(Exception e)
		{
			throw (Exception)e;
		}
	}
	
	/**
     * 배너를 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateBanr(MultipartHttpServletRequest multiRequest, EmfMap emfMap) throws Exception
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
			
			EmfMap lgnMap = (EmfMap)EgovUserDetailsHelper.getAuthenticatedUser();
			
			//게시시작, 종료일 setting
			emfMap.put("ptupStrtDt", emfMap.getString("ptupStrtDt").replaceAll("-", ""));
			emfMap.put("ptupEndDt", emfMap.getString("ptupEndDt").replaceAll("-", ""));
			
			emfMap.put("modId", lgnMap.getString("id"));
			emfMap.put("modIp", lgnMap.getString("loginIp"));
			
			sMABanrMngDAO.updateBanr(emfMap);
		}
		catch(Exception e)
		{
			throw (Exception)e;
		}
	}
	
	/**
     * 배너를 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteBanrList(int[] delSeq) throws Exception
	{	
		EmfMap emfMap = new EmfMap();
		
		emfMap.put("delSeq", delSeq);
			
		sMABanrMngDAO.deleteBanr(emfMap);
	}
	
	/**
     * 배너 정렬순서를 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateBanrSortUp(EmfMap emfMap) throws Exception
	{
		EmfMap lgnMap = (EmfMap)EgovUserDetailsHelper.getAuthenticatedUser();
		
		EmfMap sortMap = new EmfMap();
		
		sortMap.put("modId", lgnMap.getString("id"));
		sortMap.put("modIp", lgnMap.getString("loginIp"));
		
		//기존 배너 정렬 수정
		sortMap.put("banrSeq", emfMap.getString("banrSeq"));
		sortMap.put("sortSeq", emfMap.getString("nxtSortSeq"));
		sMABanrMngDAO.updateBanrSort(sortMap);
		
		//대상 배너 정렬 수정
		sortMap.put("banrSeq", emfMap.getString("nxtBanrSeq"));
		sortMap.put("sortSeq", emfMap.getString("sortSeq"));
		sMABanrMngDAO.updateBanrSort(sortMap);
	}
	
	/**
     * 배너 정렬순서를 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateBanrSortDown(EmfMap emfMap) throws Exception
	{
		EmfMap lgnMap = (EmfMap)EgovUserDetailsHelper.getAuthenticatedUser();
		
		EmfMap sortMap = new EmfMap();
		
		sortMap.put("modId", lgnMap.getString("id"));
		sortMap.put("modIp", lgnMap.getString("loginIp"));
		
		//기존 배너 정렬 수정
		sortMap.put("banrSeq", emfMap.getString("banrSeq"));
		sortMap.put("sortSeq", emfMap.getString("prvSortSeq"));
		sMABanrMngDAO.updateBanrSort(sortMap);
		
		//대상 배너 정렬 수정
		sortMap.put("banrSeq", emfMap.getString("prvBanrSeq"));
		sortMap.put("sortSeq", emfMap.getString("sortSeq"));
		sMABanrMngDAO.updateBanrSort(sortMap);
	}
}
