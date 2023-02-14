package mngwserc.sm.smc.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import mngwserc.co.util.COPaginationUtil;
import mngwserc.sm.smc.service.SMCDnldFormService;
import mngwserc.sm.smc.service.dao.SMCDnldFormDAO;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
 * 다운로드 양식 관리를 위한 ServiceImpl
 * </pre>
 * 
 * @ClassName		: SMCDnldFormServiceImpl.java
 * @Description		: 다운로드 양식 관리를 위한 ServiceImpl
 * @author 허진영
 * @since 2016.03.30
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author				   description
 *    ==========    ==============    =============================
 *    2016.03.30		허진영					최초 생성
 * </pre> 
 */
@Service("sMCDnldFormService")
public class SMCDnldFormServiceImpl extends EmfAbstractService implements SMCDnldFormService {
	
	@Resource(name="sMCDnldFormDAO")
	private SMCDnldFormDAO sMCDnldFormDAO;
	
	@Resource(name="EgovFileMngService")
    private EgovFileMngService fileMngService;
    
   	@Resource(name = "EgovFileMngUtil")
   	private EgovFileMngUtil fileUtil;
	
	@Resource(name="dnldFormIdgen")
	private EgovTableIdGnrService dnldFormIdgen;
	
	private final String atchFileSize = EgovProperties.getProperty("Globals.atchFileSize");
	
	private final String[] atchFileExtns = EgovProperties.getProperty("File.UploadMimeType").split(",");
	
	/**
	 * 다운로드 양식 목록을 조회한다.
	 * 
	 * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */    
	public EmfMap selectDnldFormList(EmfMap emfMap) throws Exception
    {
		PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
		
		//페이징 처리
		emfMap.put("paginationInfo", paginationInfo);
		
		//리스트 가져오기
		List<EmfMap> list = sMCDnldFormDAO.selectDnldFormList(emfMap);
	
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
	 * 다운로드 양식 상세를 조회한다.
	 * 
	 * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */    
	public EmfMap selectDnldForm(EmfMap emfMap) throws Exception
    {	
		if(!"".equals(EMFStringUtil.nullConvert(emfMap.get("dnldFormSeq"))))
    	{
			EmfMap formInfo = sMCDnldFormDAO.selectDnldForm(emfMap);
			
			if(formInfo != null)
	    	{
				emfMap.put("formInfo", formInfo);
				
				if(!"".equals(EMFStringUtil.nullConvert(formInfo.get("atchFileId"))))
	    		{
	    			emfMap.put("fileList", fileMngService.selectFileInfs(formInfo));
	    		}
	    	}
    	}
		
		return emfMap;
    }
	
	/**
     * 다운로드 양식을 등록한다.
     * 
     * @param EmfMap
	 * @return
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertDnldForm(MultipartHttpServletRequest multiRequest, EmfMap emfMap) throws Exception
	{
		try
		{
			//첨부파일 업로드
			final Map<String, MultipartFile> files = multiRequest.getFileMap();	
			
			if(!files.isEmpty())
			{
				List<EmfMap> atchFileList = null;
				String atchFileId = null;
		
				atchFileList = fileUtil.parseFileInf(files, "", 0, "", "Globals.fileStorePath", "atchFile", Integer.parseInt(atchFileSize), atchFileExtns);
				
				if(files.size() == atchFileList.size())
				{
					atchFileId = fileMngService.insertFileInfs(atchFileList);
					emfMap.put("atchFileId", atchFileId);
				} 
				else 
				{
					throw new Exception("파일용량초과");
				}
			}
			
			EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
			
			emfMap.put("dnldFormSeq", dnldFormIdgen.getNextIntegerId());
			emfMap.put("regId", lgnMap.getString("id"));
			emfMap.put("regIp", lgnMap.getString("loginIp"));
			emfMap.put("modId", lgnMap.getString("id"));
			emfMap.put("modIp", lgnMap.getString("loginIp"));

			sMCDnldFormDAO.insertDnldForm(emfMap);
		}
		catch(Exception e)
		{
			throw (Exception)e;
		}
	}
	
	/**
     * 다운로드 양식을 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateDnldForm(MultipartHttpServletRequest multiRequest, EmfMap emfMap) throws Exception
	{
		try
		{
			//첨부파일 업로드
			final Map<String, MultipartFile> files = multiRequest.getFileMap();	
			
			if(!files.isEmpty())
			{
				List<EmfMap> atchFileList = null;

				String pAtchFileId = emfMap.getString("atchFileId");
		
				atchFileList = fileUtil.parseFileInf(files, "", 0, pAtchFileId, "Globals.fileStorePath", "atchFile", Integer.parseInt(atchFileSize), atchFileExtns);
				
				if(files.size() == atchFileList.size())
				{
					fileMngService.updateFileInfs(atchFileList);
				} 
				else 
				{
					throw new Exception("파일용량초과");
				}
			}
			
			EmfMap lgnMap = (EmfMap)EgovUserDetailsHelper.getAuthenticatedUser();
			
			emfMap.put("modId", lgnMap.getString("id"));
			emfMap.put("modIp", lgnMap.getString("loginIp"));
			
			sMCDnldFormDAO.updateDnldForm(emfMap);
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
	public void deleteDnldFormList(int[] delSeq) throws Exception
	{	
		EmfMap emfMap = new EmfMap();
		
		emfMap.put("delSeq", delSeq);
		
		sMCDnldFormDAO.deleteDnldForm(emfMap);
	}
}
