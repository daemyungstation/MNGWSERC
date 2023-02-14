package mngwserc.cm.cmb.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import mngwserc.cm.cmb.service.CMBChngDtlService;
import mngwserc.cm.cmb.service.dao.CMBChngDtlDAO;
import mngwserc.co.util.COPaginationUtil;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.service.EgovFileMngService;
import egovframework.com.cmm.service.EgovFileMngUtil;
import egovframework.com.cmm.service.EgovProperties;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.com.utl.fcc.service.EgovStringUtil;
import egovframework.rte.fdl.idgnr.impl.EgovTableIdGnrService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import emf.core.extend.service.EmfAbstractService;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 전환서비스 상품내역 관리를 위한 ServiceImpl
 * </pre>
 * 
 * @ClassName		: CMBChngDtlServiceImpl.java
 * @Description		: 전환서비스 상품내역 관리를 위한 ServiceImpl
 * @author 김대환
 * @since 2016.02.17
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author				  description
 *   ===========    ==============    =============================
 *    2016.02.17		김대환				   최초 생성
 * </pre>
 */ 
@Service("cMBChngDtlService")
public class CMBChngDtlServiceImpl extends EmfAbstractService implements CMBChngDtlService {

	@Resource(name="cMBChngDtlDAO")
	private CMBChngDtlDAO cMBChngDtlDAO;
	
	@Resource(name="EgovCmmUseService")
    private EgovCmmUseService cmmUseService;
	
	@Resource(name="EgovFileMngService")
	private EgovFileMngService fileMngService;
	
   	@Resource(name = "EgovFileMngUtil")
   	private EgovFileMngUtil fileUtil;
   	
   	@Resource(name="prdctDtlIdgen")
	private EgovTableIdGnrService prdctDtlIdgen;
   	
	@Resource(name="prdctInfIdgen")
	private EgovTableIdGnrService prdctInfIdgen;
	
	private final String thnlFileSize = EgovProperties.getProperty("Globals.thnlFileSize");
	
   	private final String imgFileSize = EgovProperties.getProperty("Globals.imgFileSize");
   	
   	private final String[] imgFileExtns = EgovProperties.getProperty("Globals.imgFileExtns").split(",");
   	
	/**
     * 전환서비스 상품내역 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public EmfMap selectChngDtlList(EmfMap emfMap) throws Exception 
	{
		PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
		
		//페이징 처리
		emfMap.put("paginationInfo", paginationInfo);    	
		
		//리스트 가져오기
		List<EmfMap> list = cMBChngDtlDAO.selectChngDtlList(emfMap);

		emfMap.put("list", list);	
		
		if(list.size() > 0)
		{
			paginationInfo.setTotalRecordCount(Integer.parseInt(list.get(0).getString("totCnt")));
		}
		else
		{
			paginationInfo.setTotalRecordCount(0);
		}	
		
		//공통코드 배열 셋팅
		ArrayList<String> cdDtlList = new ArrayList<String>();
		
		//상품구분
		cdDtlList.add("PRDCT_GB");
		
		//전환 서비스 - 상세현황
		cdDtlList.add("CHNG_PRDCT_DTL_STTS");
		
		//정의된 코드id값들의 상세 코드 맵 반환		
		emfMap.put("cdDtlList", cmmUseService.selectCmmCodeBindAll(cdDtlList));
				
		return emfMap;
	}

	/**
     * 전환서비스 상품내역 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public EmfMap selectChngDtl(EmfMap emfMap) throws Exception 
	{
		if(!"".equals(EMFStringUtil.nullConvert(emfMap.get("prdctDtlSeq"))))
    	{
			EmfMap dtlInfo= cMBChngDtlDAO.selectChngDtl(emfMap);
			
			if(dtlInfo != null)
	    	{
				emfMap.put("dtlInfo", dtlInfo);
				
				//첨부파일ID를 담기 위한 EmfMap
				EmfMap atchFileId = new EmfMap();
				
				if(!"".equals(EMFStringUtil.nullConvert(dtlInfo.getString("thnlFileId"))))
				{
					atchFileId.put("atchFileId", dtlInfo.getString("thnlFileId"));
					emfMap.put("thnlFileList", fileMngService.selectFileInfs(atchFileId));
				}
				
				if(!"".equals(EMFStringUtil.nullConvert(dtlInfo.getString("atchFileId"))))
				{
					atchFileId.put("atchFileId", dtlInfo.getString("atchFileId"));
					emfMap.put("atchFileList", fileMngService.selectFileInfs(atchFileId));
				}
				
				emfMap.put("infoDtl", cMBChngDtlDAO.selectChngDtlInf(dtlInfo));
	    	}
		}
		
		//공통코드 배열 셋팅
		ArrayList<String> cdDtlList = new ArrayList<String>();
		
		//상품구분
		cdDtlList.add("PRDCT_GB");
		
		//전환 서비스 - 상세현황
		cdDtlList.add("CHNG_PRDCT_DTL_STTS");
		
		//정의된 코드id값들의 상세 코드 맵 반환		
		emfMap.put("cdDtlList", cmmUseService.selectCmmCodeBindAll(cdDtlList));
				
		return emfMap;
	}
	
	/**
     * 전환서비스 상품내역을 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertChngDtl(EmfMap emfMap, MultipartHttpServletRequest multiRequest) throws Exception 
	{
		try
		{
			//첨부파일 업로드
			final Map<String, MultipartFile> files = multiRequest.getFileMap();	
			
			Iterator<Entry<String, MultipartFile>> itr = files.entrySet().iterator();
			MultipartFile file;
			
			int thnlFileCnt = 0, atchFileCnt = 0;
			
			while (itr.hasNext()) 
			{
				Entry<String, MultipartFile> entry = itr.next();
			    file = entry.getValue();
			    
			    if(file.getName().indexOf("thnlFile") > -1)
			    {
			    	thnlFileCnt++;
			    }
			    else if(file.getName().indexOf("atchFile") > -1)
			    {
			    	atchFileCnt++;
			    }  
			}
			
			if(!files.isEmpty())
			{
				List<EmfMap> atchFileList = null;
				String atchFileId = null;
				
				if(thnlFileCnt > 0)
				{
					atchFileList = fileUtil.parseFileInf(files, "", 0, "", "Globals.fileStorePath", "thnlFile", Integer.parseInt(thnlFileSize), imgFileExtns);
	    			
	    			if(thnlFileCnt == atchFileList.size()) 
	    			{
	                	atchFileId = fileMngService.insertFileInfs(atchFileList);
	    				emfMap.put("thnlFileId", atchFileId);
	    			} 
	    			else 
	    			{						
	    				throw new Exception("파일용량초과");
	    			}
				}			

				if(atchFileCnt > 0)
				{
					atchFileList = fileUtil.parseFileInf(files, "", 0, "", "Globals.fileStorePath", "atchFile", Integer.parseInt(imgFileSize), imgFileExtns);
	    			
	    			if(atchFileCnt == atchFileList.size()) 
	    			{
	    				atchFileId = fileMngService.insertFileInfs(atchFileList);
	    				emfMap.put("atchFileId", atchFileId);
	    			} 
	    			else 
	    			{						
	    				throw new Exception("파일용량초과");
	    			}
				}
			}
			
			EmfMap lgnMap = (EmfMap)EgovUserDetailsHelper.getAuthenticatedUser();
			
			emfMap.put("prdctDtlSeq", prdctDtlIdgen.getNextIntegerId());
			emfMap.put("odtmYn", EMFStringUtil.nvl(emfMap.getString("odtmYn"), "N"));
			emfMap.put("regId", lgnMap.getString("id"));
			emfMap.put("regIp", lgnMap.getString("loginIp"));
			emfMap.put("modId", lgnMap.getString("id"));
			emfMap.put("modIp", lgnMap.getString("loginIp"));
			
			//전환서비스 상품내역을 등록한다.
			cMBChngDtlDAO.insertChngDtl(emfMap);
			
			//전환서비스 상품내역을 정보를 등록한다.
			List<String> titl = emfMap.getList("titl");
			List<String> cntn = emfMap.getList("cntn");
			
			for(int i = 0; i < titl.size(); i++)
			{
				emfMap.put("prdctInfSeq", prdctInfIdgen.getNextIntegerId());
				emfMap.put("titl", titl.get(i));
				emfMap.put("cntn", cntn.get(i));
				cMBChngDtlDAO.insertChngDtlInf(emfMap);
			}
		}
		catch(Exception e)
		{
			throw (Exception)e;
		}
	}
	
	/**
     * 전환서비스 상품내역을 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateChngDtl(EmfMap emfMap, MultipartHttpServletRequest multiRequest) throws Exception 
	{
		try
		{
			//첨부파일 업로드
			final Map<String, MultipartFile> files = multiRequest.getFileMap();	
			
			Iterator<Entry<String, MultipartFile>> itr = files.entrySet().iterator();
			MultipartFile file;
			
			int thnlFileCnt = 0, atchFileCnt = 0;
			
			while (itr.hasNext()) 
			{
				Entry<String, MultipartFile> entry = itr.next();
			    file = entry.getValue();
			    
			    if(file.getName().indexOf("thnlFile") > -1)
			    {
			    	thnlFileCnt++;
			    }
			    else if(file.getName().indexOf("atchFile") > -1)
			    {
			    	atchFileCnt++;
			    }  
			}
			
			if(!files.isEmpty())
			{
				List<EmfMap> atchFileList = null;
				String atchFileId = null;
				
				String pThnlFileId = emfMap.getString("thnlFile");
				
				if(thnlFileCnt > 0)
				{
					if(!"".equals(EMFStringUtil.nullConvert(pThnlFileId)))
					{
						atchFileList = fileUtil.parseFileInf(files, "", 0, pThnlFileId, "Globals.fileStorePath", "thnlFile", Integer.parseInt(thnlFileSize), imgFileExtns);
						
						if(thnlFileCnt == atchFileList.size()) 
		    			{
							fileMngService.updateFileInfs(atchFileList);
		    			} 
		    			else 
		    			{						
		    				throw new Exception("파일용량초과");
		    			}
					}
					else
					{
						atchFileList = fileUtil.parseFileInf(files, "", 0, "", "Globals.fileStorePath", "thnlFile", Integer.parseInt(thnlFileSize), imgFileExtns);
		    			
		    			if(thnlFileCnt == atchFileList.size()) 
		    			{
		    				atchFileId = fileMngService.insertFileInfs(atchFileList);
		    				emfMap.put("thnlFileId", atchFileId);
		    			} 
		    			else 
		    			{						
		    				throw new Exception("파일용량초과");
		    			}
					}
				}
				
				String pAtchFileId = emfMap.getString("atchFileId");
				
				if(atchFileCnt > 0)
				{
					if(!"".equals(EMFStringUtil.nullConvert(pAtchFileId)))
					{
						int nxtFileSeq = fileMngService.getMaxFileSeq(emfMap);
						
						atchFileList = fileUtil.parseFileInf(files, "", nxtFileSeq, pAtchFileId, "Globals.fileStorePath", "atchFile", Integer.parseInt(imgFileSize), imgFileExtns);
						
						if(atchFileCnt == atchFileList.size()) 
		    			{
							fileMngService.insertFileInfs(atchFileList);
		    			} 
		    			else 
		    			{						
		    				throw new Exception("파일용량초과");
		    			}
					}
					else
					{
						atchFileList = fileUtil.parseFileInf(files, "", 0, "", "Globals.fileStorePath", "atchFile", Integer.parseInt(imgFileSize), imgFileExtns);
		    			
		    			if(atchFileCnt == atchFileList.size()) 
		    			{
		    				atchFileId = fileMngService.insertFileInfs(atchFileList);
		    				emfMap.put("atchFileId", atchFileId);
		    			} 
		    			else 
		    			{						
		    				throw new Exception("파일용량초과");
		    			}
					}
				}
			}
			
			//첨부파일 삭제
			EmfMap delFileMap = new EmfMap();
			
			String[] delFileSeqArr = multiRequest.getParameterValues("delFileSeq");
			
			if(delFileSeqArr != null && delFileSeqArr.length > 0) 
			{
				String pAtchFileId = emfMap.getString("atchFileId");
				
				if(!"".equals(EgovStringUtil.nullConvert(pAtchFileId)))
				{
					delFileMap.put("atchFileId", pAtchFileId);
					
					for (int i = 0; i < delFileSeqArr.length; i++) 
	    			{
						delFileMap.put("fileSeq", delFileSeqArr[i]);
	    				fileMngService.deleteFileInf(delFileMap);
	    			} 
					
					int fileNum = fileMngService.getFileListCnt(pAtchFileId);
					
					if (fileNum == 0) 
	    			{
	    				fileMngService.deleteAllFileInf(delFileMap);
	    				emfMap.put("atchFileId", null);
	    			}
				}
			}
			
			EmfMap lgnMap = (EmfMap)EgovUserDetailsHelper.getAuthenticatedUser();
			
			emfMap.put("odtmYn", EMFStringUtil.nvl(emfMap.getString("odtmYn"), "N"));
			emfMap.put("regId", lgnMap.getString("id"));
			emfMap.put("regIp", lgnMap.getString("loginIp"));
			emfMap.put("modId", lgnMap.getString("id"));
			emfMap.put("modIp", lgnMap.getString("loginIp"));
			
			//전환서비스 상품내역을 수정한다.
			cMBChngDtlDAO.updateChngDtl(emfMap);
			
			//전환서비스 상품내역 정보를 삭제한다.
			cMBChngDtlDAO.deleteChngDtlInf(emfMap);
			
			//전환서비스 상품내역 정보를 등록한다.
			List<String> titl = emfMap.getList("titl");
			List<String> cntn = emfMap.getList("cntn");
			
			for(int i = 0; i < titl.size(); i++)
			{
				emfMap.put("prdctInfSeq", prdctInfIdgen.getNextIntegerId());
				emfMap.put("titl", titl.get(i));
				emfMap.put("cntn", cntn.get(i));
				cMBChngDtlDAO.insertChngDtlInf(emfMap);
			}
		}
		catch(Exception e)
		{
			throw (Exception)e;
		}
	}

	/**
     * 전환서비스 상품내역을 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteChngDtlList(int[] delSeq) throws Exception 
	{
		EmfMap emfMap = new EmfMap();
		
		emfMap.put("delSeq", delSeq);
		
		//전환서비스 상세를 삭제한다.
		cMBChngDtlDAO.deleteChngDtl(emfMap);
				
		//전환서비스 상세(정보)를 삭제한다.
		cMBChngDtlDAO.deleteChngDtlInfAll(emfMap);
	}

	/**
	 * 전환서비스 상품내역을 복사한다.
	 * 
	 * @param EmfMap 검색데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */	
	public void insertChngDtlCopy(EmfMap emfMap) throws Exception 
	{
		EmfMap lgnMap = (EmfMap)EgovUserDetailsHelper.getAuthenticatedUser();
		
		int prdctDtlSeq = prdctDtlIdgen.getNextIntegerId();
		
		emfMap.put("prdctDtlSeq", prdctDtlSeq);
		emfMap.put("regId", lgnMap.getString("id"));
		emfMap.put("regIp", lgnMap.getString("loginIp"));
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		//전환서비스 상품내역을 복사한다.
		cMBChngDtlDAO.insertChngDtlCopy(emfMap);
		
		//전환서비스 상품내역 정보를 복사한다.
		emfMap.put("prdctDtlSeq", emfMap.getString("delSeq"));
		
		List<EmfMap> chngDtlInfList= cMBChngDtlDAO.selectChngDtlInf(emfMap);
		
		for(int i = 0; i < chngDtlInfList.size(); i++)
		{
			emfMap.put("prdctInfSeq", prdctInfIdgen.getNextIntegerId());
			emfMap.put("prdctDtlSeq", prdctDtlSeq);
			emfMap.put("titl", chngDtlInfList.get(i).getString("titl"));
			emfMap.put("cntn", chngDtlInfList.get(i).getString("cntn"));
			cMBChngDtlDAO.insertChngDtlInfCopy(emfMap);
		}
	}
	
	/**
     * 전환서비스 상품내역을 블라인드 처리한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateChngDtlBlind(EmfMap emfMap) throws Exception 
	{
		cMBChngDtlDAO.updateChngDtlBlind(emfMap);
	}
}
