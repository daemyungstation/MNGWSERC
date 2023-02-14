package mngwserc.pr.pra.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import mngwserc.co.util.COPaginationUtil;
import mngwserc.pr.pra.service.PRALifeMgznService;
import mngwserc.pr.pra.service.dao.PRALifeMgznDAO;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
 * 라이프웨이 매거진관리를 위한 ServiceImpl
 * </pre>
 * 
 * @ClassName		: PRALifeMgznServiceImpl.java
 * @Description		: 라이프웨이 매거진관리를 위한 ServiceImpl
 * @author 허진영
 * @since 2016.02.16
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2016.02.16		허진영					 최초생성
 * </pre>
 */ 
@Service("pRALifeMgznService")
public class PRALifeMgznServiceImpl extends EmfAbstractService implements PRALifeMgznService {
	
	@Resource(name="pRALifeMgznDAO")
	private PRALifeMgznDAO pRALifeMgznDAO;
	
    @Resource(name="EgovFileMngService")
    private EgovFileMngService fileMngService;
    
   	@Resource(name = "EgovFileMngUtil")
   	private EgovFileMngUtil fileUtil;
	
	@Resource(name="mgznIdgen")
	private EgovTableIdGnrService mgznIdgen;
	
	private final String atchFileSize = EgovProperties.getProperty("Globals.atchFileSize");
	
	private final String imgFileSize = EgovProperties.getProperty("Globals.imgFileSize");

	private final String[] cvrFileExtn = EgovProperties.getProperty("Globals.imgFileExtns").split(",");
	
	private final String[] pdfFileExtn = {"pdf"};
	
	/**
     * 라이프웨이 매거진 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectLifeMgznList(EmfMap emfMap) throws Exception
    {
    	PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
		
		//페이징 처리
		emfMap.put("paginationInfo", paginationInfo);    	
		
		//리스트 가져오기
		List<EmfMap> list = pRALifeMgznDAO.selectLifeMgznList(emfMap);
		
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
     * 라이프웨이 매거진 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectLifeMgzn(EmfMap emfMap) throws Exception
    {
    	if(!"".equals(EMFStringUtil.nullConvert(emfMap.get("mgznSeq"))))
    	{
    		EmfMap lifeMgznInfo = pRALifeMgznDAO.selectLifeMgzn(emfMap);
    		
    		if(lifeMgznInfo != null)
	    	{
    			emfMap.put("lifeMgznInfo", lifeMgznInfo);
    			
    			//첨부파일ID를 담기 위한 EmfMap
    			EmfMap atchFileId = new EmfMap();
    			
    			if(!"".equals(EMFStringUtil.nullConvert(lifeMgznInfo.getString("sprCvrFileId"))))
    			{
    				atchFileId.put("atchFileId", lifeMgznInfo.getString("sprCvrFileId"));
    				emfMap.put("sprCvrFileList", fileMngService.selectFileInfs(atchFileId));
    			}
    			
    			if(!"".equals(EMFStringUtil.nullConvert(lifeMgznInfo.getString("sprPdfFileId"))))
    			{
    				atchFileId.put("atchFileId", lifeMgznInfo.getString("sprPdfFileId"));
    				emfMap.put("sprPdfFileList", fileMngService.selectFileInfs(atchFileId));
    			}
    			
    			if(!"".equals(EMFStringUtil.nullConvert(lifeMgznInfo.getString("smmrCvrFileId"))))
    			{
    				atchFileId.put("atchFileId", lifeMgznInfo.getString("smmrCvrFileId"));
    				emfMap.put("smmrCvrFileList", fileMngService.selectFileInfs(atchFileId));
    			}
    			
    			if(!"".equals(EMFStringUtil.nullConvert(lifeMgznInfo.getString("smmrPdfFileId"))))
    			{
    				atchFileId.put("atchFileId", lifeMgznInfo.getString("smmrPdfFileId"));
    				emfMap.put("smmrPdfFileList", fileMngService.selectFileInfs(atchFileId));
    			}
    			
    			if(!"".equals(EMFStringUtil.nullConvert(lifeMgznInfo.getString("atmnCvrFileId"))))
    			{
    				atchFileId.put("atchFileId", lifeMgznInfo.getString("atmnCvrFileId"));
    				emfMap.put("atmnCvrFileList", fileMngService.selectFileInfs(atchFileId));
    			}
    			
    			if(!"".equals(EMFStringUtil.nullConvert(lifeMgznInfo.getString("atmnPdfFileId"))))
    			{
    				atchFileId.put("atchFileId", lifeMgznInfo.getString("atmnPdfFileId"));
    				emfMap.put("atmnPdfFileList", fileMngService.selectFileInfs(atchFileId));
    			}
    			
    			if(!"".equals(EMFStringUtil.nullConvert(lifeMgznInfo.getString("wntrCvrFileId"))))
    			{
    				atchFileId.put("atchFileId", lifeMgznInfo.getString("wntrCvrFileId"));
    				emfMap.put("wntrCvrFileList", fileMngService.selectFileInfs(atchFileId));
    			}
    			
    			if(!"".equals(EMFStringUtil.nullConvert(lifeMgznInfo.getString("wntrPdfFileId"))))
    			{
    				atchFileId.put("atchFileId", lifeMgznInfo.getString("wntrPdfFileId"));
    				emfMap.put("wntrPdfFileList", fileMngService.selectFileInfs(atchFileId));
    			}
	    	}
    	}
    	
    	return emfMap;
    }
    
	/**
     * 라이프웨이 매거진을 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertLifeMgzn(MultipartHttpServletRequest multiRequest, EmfMap emfMap) throws Exception
	{
		try
		{
			//첨부파일 업로드
			final Map<String, MultipartFile> files = multiRequest.getFileMap();	
			
			Iterator<Entry<String, MultipartFile>> itr = files.entrySet().iterator();
			MultipartFile file;
			
			int sprCvrFileCnt = 0, smmrCvrFileCnt = 0, atmnCvrFileCnt = 0, wntrCvrFileCnt = 0;
			int sprPdfFileCnt = 0, smmrPdfFileCnt = 0, atmnPdfFileCnt = 0, wntrPdfFileCnt = 0;
			
			while (itr.hasNext()) 
			{
				Entry<String, MultipartFile> entry = itr.next();
			    file = entry.getValue();
			    
			    if(file.getName().indexOf("sprCvrFile") > -1)
			    {
			    	sprCvrFileCnt++;
			    }
			    else if(file.getName().indexOf("sprPdfFile") > -1)
			    {
			    	sprPdfFileCnt++;
			    }
			    else if(file.getName().indexOf("smmrCvrFile") > -1)
			    {
			    	smmrCvrFileCnt++;
			    }
			    else if(file.getName().indexOf("smmrPdfFile") > -1)
			    {
			    	smmrPdfFileCnt++;
			    }
			    else if(file.getName().indexOf("atmnCvrFile") > -1)
			    {
			    	atmnCvrFileCnt++;
			    }
			    else if(file.getName().indexOf("atmnPdfFile") > -1)
			    {
			    	atmnPdfFileCnt++;
			    }
			    else if(file.getName().indexOf("wntrCvrFile") > -1)
			    {
			    	wntrCvrFileCnt++;
			    }
			    else if(file.getName().indexOf("wntrPdfFile") > -1)
			    {
			    	wntrPdfFileCnt++;
			    }
			}
			
			if(!files.isEmpty())
			{
				List<EmfMap> atchFileList = null;
				String atchFileId = null;

				/** 봄 start ----------------------------------------------------------------------------------------------------------------------------------**/
				if(sprCvrFileCnt > 0)
				{
					atchFileList = fileUtil.parseFileInf(files, "", 0, "", "Globals.fileStorePath", "sprCvrFile", Integer.parseInt(imgFileSize), cvrFileExtn);
					
					if(sprCvrFileCnt == atchFileList.size())
					{
						atchFileId = fileMngService.insertFileInfs(atchFileList);
						emfMap.put("sprCvrFileId", atchFileId);
					} 
					else 
					{
						throw new Exception("파일용량초과");
					}
				}
				
				if(sprPdfFileCnt > 0)
				{
					atchFileList = fileUtil.parseFileInf(files, "", 0, "", "Globals.fileStorePath", "sprPdfFile", Integer.parseInt(atchFileSize), pdfFileExtn);
					
					if(sprPdfFileCnt == atchFileList.size())
					{
						atchFileId = fileMngService.insertFileInfs(atchFileList);
						emfMap.put("sprPdfFileId", atchFileId);
					} 
					else 
					{
						throw new Exception("파일용량초과");
					}
				}
				/** 봄 end   ----------------------------------------------------------------------------------------------------------------------------------**/
				
				/** 여름 start --------------------------------------------------------------------------------------------------------------------------------**/
				if(smmrCvrFileCnt > 0)
				{
					atchFileList = fileUtil.parseFileInf(files, "", 0, "", "Globals.fileStorePath", "smmrCvrFile", Integer.parseInt(imgFileSize), cvrFileExtn);
					
					if(smmrCvrFileCnt == atchFileList.size())
					{
						atchFileId = fileMngService.insertFileInfs(atchFileList);
						emfMap.put("smmrCvrFileId", atchFileId);
					} 
					else 
					{
						throw new Exception("파일용량초과");
					}
				}
				
				if(smmrPdfFileCnt > 0)
				{
					atchFileList = fileUtil.parseFileInf(files, "", 0, "", "Globals.fileStorePath", "smmrPdfFile", Integer.parseInt(atchFileSize), pdfFileExtn);
					
					if(smmrPdfFileCnt == atchFileList.size())
					{
						atchFileId = fileMngService.insertFileInfs(atchFileList);
						emfMap.put("smmrPdfFileId", atchFileId);
					} 
					else 
					{
						throw new Exception("파일용량초과");
					}
				}
				/** 여름 end   --------------------------------------------------------------------------------------------------------------------------------**/
				
				/** 가을 start --------------------------------------------------------------------------------------------------------------------------------**/
				if(atmnCvrFileCnt > 0)
				{
					atchFileList = fileUtil.parseFileInf(files, "", 0, "", "Globals.fileStorePath", "atmnCvrFile", Integer.parseInt(imgFileSize), cvrFileExtn);
					
					if(atmnCvrFileCnt == atchFileList.size())
					{
						atchFileId = fileMngService.insertFileInfs(atchFileList);
						emfMap.put("atmnCvrFileId", atchFileId);
					} 
					else 
					{
						throw new Exception("파일용량초과");
					}
				}
				
				if(atmnPdfFileCnt > 0)
				{
					atchFileList = fileUtil.parseFileInf(files, "", 0, "", "Globals.fileStorePath", "atmnPdfFile", Integer.parseInt(atchFileSize), pdfFileExtn);
					
					if(atmnPdfFileCnt == atchFileList.size())
					{
						atchFileId = fileMngService.insertFileInfs(atchFileList);
						emfMap.put("atmnPdfFileId", atchFileId);
					} 
					else 
					{
						throw new Exception("파일용량초과");
					}
				}
				/** 가을 end   --------------------------------------------------------------------------------------------------------------------------------**/
				
				/** 겨울 start --------------------------------------------------------------------------------------------------------------------------------**/
				if(wntrCvrFileCnt > 0)
				{
					atchFileList = fileUtil.parseFileInf(files, "", 0, "", "Globals.fileStorePath", "wntrCvrFile", Integer.parseInt(imgFileSize), cvrFileExtn);
					
					if(wntrCvrFileCnt == atchFileList.size())
					{
						atchFileId = fileMngService.insertFileInfs(atchFileList);
						emfMap.put("wntrCvrFileId", atchFileId);
					} 
					else 
					{
						throw new Exception("파일용량초과");
					}
				}
				if(wntrPdfFileCnt > 0)
				{
					atchFileList = fileUtil.parseFileInf(files, "", 0, "", "Globals.fileStorePath", "wntrPdfFile", Integer.parseInt(atchFileSize), pdfFileExtn);
					
					if(wntrPdfFileCnt == atchFileList.size())
					{
						atchFileId = fileMngService.insertFileInfs(atchFileList);
						emfMap.put("wntrPdfFileId", atchFileId);
					} 
					else 
					{
						throw new Exception("파일용량초과");
					}
				}
				/** 겨울 end   --------------------------------------------------------------------------------------------------------------------------------**/
			}
			
			EmfMap loginMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
			
			emfMap.put("mgznSeq", mgznIdgen.getNextIntegerId());
			emfMap.put("regId", loginMap.get("id"));
			emfMap.put("regIp", loginMap.get("loginIp"));
			emfMap.put("modId", loginMap.get("id"));
			emfMap.put("modIp", loginMap.get("loginIp"));
			
			pRALifeMgznDAO.insertLifeMgzn(emfMap);
		}
		catch(Exception e)
		{
			throw (Exception)e;
		}
	}
	
	/**
     * 라이프웨이 매거진을 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateLifeMgzn(MultipartHttpServletRequest multiRequest, EmfMap emfMap) throws Exception
	{
		try
		{
			//첨부파일 업로드
			final Map<String, MultipartFile> files = multiRequest.getFileMap();	
			
			Iterator<Entry<String, MultipartFile>> itr = files.entrySet().iterator();
			MultipartFile file;
			
			int sprCvrFileCnt = 0, smmrCvrFileCnt = 0, atmnCvrFileCnt = 0, wntrCvrFileCnt = 0;
			int sprPdfFileCnt = 0, smmrPdfFileCnt = 0, atmnPdfFileCnt = 0, wntrPdfFileCnt = 0;
			
			while (itr.hasNext()) 
			{
				Entry<String, MultipartFile> entry = itr.next();
			    file = entry.getValue();
			    
			    if(file.getName().indexOf("sprCvrFile") > -1)
			    {
			    	sprCvrFileCnt++;
			    }
			    else if(file.getName().indexOf("sprPdfFile") > -1)
			    {
			    	sprPdfFileCnt++;
			    }
			    else if(file.getName().indexOf("smmrCvrFile") > -1)
			    {
			    	smmrCvrFileCnt++;
			    }
			    else if(file.getName().indexOf("smmrPdfFile") > -1)
			    {
			    	smmrPdfFileCnt++;
			    }
			    else if(file.getName().indexOf("atmnCvrFile") > -1)
			    {
			    	atmnCvrFileCnt++;
			    }
			    else if(file.getName().indexOf("atmnPdfFile") > -1)
			    {
			    	atmnPdfFileCnt++;
			    }
			    else if(file.getName().indexOf("wntrCvrFile") > -1)
			    {
			    	wntrCvrFileCnt++;
			    }
			    else if(file.getName().indexOf("wntrPdfFile") > -1)
			    {
			    	wntrPdfFileCnt++;
			    }
			}

			if(!files.isEmpty())
			{
				List<EmfMap> atchFileList = null;
				String atchFileId = null;
				
				/** 봄 start ----------------------------------------------------------------------------------------------------------------------------------**/
				String pSprCvrFileId = emfMap.getString("sprCvrFileId");
				
				if(sprCvrFileCnt > 0)
				{
					if(!"".equals(EMFStringUtil.nullConvert(pSprCvrFileId)))
					{
						atchFileList = fileUtil.parseFileInf(files, "", 0, pSprCvrFileId, "Globals.fileStorePath", "sprCvrFile", Integer.parseInt(imgFileSize), cvrFileExtn);
						
						if(sprCvrFileCnt == atchFileList.size()) 
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
						atchFileList = fileUtil.parseFileInf(files, "", 0, "", "Globals.fileStorePath", "sprCvrFile", Integer.parseInt(imgFileSize), cvrFileExtn);
		    			
		    			if(sprCvrFileCnt == atchFileList.size()) 
		    			{
		    				atchFileId = fileMngService.insertFileInfs(atchFileList);
		    				emfMap.put("sprCvrFileId", atchFileId);
		    			} 
		    			else 
		    			{						
		    				throw new Exception("파일용량초과");
		    			}
					}
				}
				
				String pSprPdfFileId = emfMap.getString("sprPdfFileId");
				
				if(sprPdfFileCnt > 0)
				{
					if(!"".equals(EMFStringUtil.nullConvert(pSprPdfFileId)))
					{
						atchFileList = fileUtil.parseFileInf(files, "", 0, pSprPdfFileId, "Globals.fileStorePath", "sprPdfFile", Integer.parseInt(atchFileSize), pdfFileExtn);
						
						if(sprPdfFileCnt == atchFileList.size()) 
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
						atchFileList = fileUtil.parseFileInf(files, "", 0, "", "Globals.fileStorePath", "sprPdfFile", Integer.parseInt(atchFileSize), pdfFileExtn);
		    			
		    			if(sprPdfFileCnt == atchFileList.size()) 
		    			{
		    				atchFileId = fileMngService.insertFileInfs(atchFileList);
		    				emfMap.put("sprPdfFileId", atchFileId);
		    			} 
		    			else 
		    			{						
		    				throw new Exception("파일용량초과");
		    			}
					}
				}
				/** 봄 end   ----------------------------------------------------------------------------------------------------------------------------------**/
				
				/** 여름 start --------------------------------------------------------------------------------------------------------------------------------**/
				String pSmmrCvrFileId = emfMap.getString("smmrCvrFileId");
				
				if(smmrCvrFileCnt > 0)
				{
					if(!"".equals(EMFStringUtil.nullConvert(pSmmrCvrFileId)))
					{
						atchFileList = fileUtil.parseFileInf(files, "", 0, pSmmrCvrFileId, "Globals.fileStorePath", "smmrCvrFile", Integer.parseInt(imgFileSize), cvrFileExtn);
						
						if(smmrCvrFileCnt == atchFileList.size()) 
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
						atchFileList = fileUtil.parseFileInf(files, "", 0, "", "Globals.fileStorePath", "smmrCvrFile", Integer.parseInt(imgFileSize), cvrFileExtn);
		    			
		    			if(smmrCvrFileCnt == atchFileList.size()) 
		    			{
		    				atchFileId = fileMngService.insertFileInfs(atchFileList);
		    				emfMap.put("smmrCvrFileId", atchFileId);
		    			} 
		    			else 
		    			{						
		    				throw new Exception("파일용량초과");
		    			}
					}
				}
				
				String pSmmrPdfFileId = emfMap.getString("smmrPdfFileId");
				
				if(smmrPdfFileCnt > 0)
				{
					if(!"".equals(EMFStringUtil.nullConvert(pSmmrPdfFileId)))
					{
						atchFileList = fileUtil.parseFileInf(files, "", 0, pSmmrPdfFileId, "Globals.fileStorePath", "smmrPdfFile", Integer.parseInt(atchFileSize), pdfFileExtn);
						
						if(smmrPdfFileCnt == atchFileList.size()) 
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
						atchFileList = fileUtil.parseFileInf(files, "", 0, "", "Globals.fileStorePath", "smmrPdfFile", Integer.parseInt(atchFileSize), pdfFileExtn);
		    			
		    			if(smmrPdfFileCnt == atchFileList.size()) 
		    			{
		    				atchFileId = fileMngService.insertFileInfs(atchFileList);
		    				emfMap.put("smmrPdfFileId", atchFileId);
		    			} 
		    			else 
		    			{						
		    				throw new Exception("파일용량초과");
		    			}
					}
				}
				/** 여름 end   --------------------------------------------------------------------------------------------------------------------------------**/
				
				/** 가을 start --------------------------------------------------------------------------------------------------------------------------------**/
				String pAtmnCvrFileId = emfMap.getString("atmnCvrFileId");
				
				if(atmnCvrFileCnt > 0)
				{
					if(!"".equals(EMFStringUtil.nullConvert(pAtmnCvrFileId)))
					{
						atchFileList = fileUtil.parseFileInf(files, "", 0, pAtmnCvrFileId, "Globals.fileStorePath", "atmnCvrFile", Integer.parseInt(imgFileSize), cvrFileExtn);
						
						if(atmnCvrFileCnt == atchFileList.size()) 
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
						atchFileList = fileUtil.parseFileInf(files, "", 0, "", "Globals.fileStorePath", "atmnCvrFile", Integer.parseInt(imgFileSize), cvrFileExtn);
		    			
		    			if(atmnCvrFileCnt == atchFileList.size()) 
		    			{
		    				atchFileId = fileMngService.insertFileInfs(atchFileList);
		    				emfMap.put("atmnCvrFileId", atchFileId);
		    			} 
		    			else 
		    			{						
		    				throw new Exception("파일용량초과");
		    			}
					}
				}
				
				String pAtmnPdfFileId = emfMap.getString("atmnPdfFileId");
				
				if(atmnPdfFileCnt > 0)
				{
					if(!"".equals(EMFStringUtil.nullConvert(pAtmnPdfFileId)))
					{
						atchFileList = fileUtil.parseFileInf(files, "", 0, pAtmnPdfFileId, "Globals.fileStorePath", "atmnPdfFile", Integer.parseInt(atchFileSize), pdfFileExtn);
						
						if(atmnPdfFileCnt == atchFileList.size()) 
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
						atchFileList = fileUtil.parseFileInf(files, "", 0, "", "Globals.fileStorePath", "atmnPdfFile", Integer.parseInt(atchFileSize), pdfFileExtn);
		    			
		    			if(atmnPdfFileCnt == atchFileList.size()) 
		    			{
		    				atchFileId = fileMngService.insertFileInfs(atchFileList);
		    				emfMap.put("atmnPdfFileId", atchFileId);
		    			} 
		    			else 
		    			{						
		    				throw new Exception("파일용량초과");
		    			}
					}
				}
				/** 가을 end   --------------------------------------------------------------------------------------------------------------------------------**/
				
				/** 겨울 start --------------------------------------------------------------------------------------------------------------------------------**/
				String pWntrCvrFileId = emfMap.getString("wntrCvrFileId");
				
				if(wntrCvrFileCnt > 0)
				{
					if(!"".equals(EMFStringUtil.nullConvert(pWntrCvrFileId)))
					{
						atchFileList = fileUtil.parseFileInf(files, "", 0, pWntrCvrFileId, "Globals.fileStorePath", "wntrCvrFile", Integer.parseInt(imgFileSize), cvrFileExtn);
						
						if(wntrCvrFileCnt == atchFileList.size()) 
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
						atchFileList = fileUtil.parseFileInf(files, "", 0, "", "Globals.fileStorePath", "wntrCvrFile", Integer.parseInt(imgFileSize), cvrFileExtn);
		    			
		    			if(wntrCvrFileCnt == atchFileList.size()) 
		    			{
		    				atchFileId = fileMngService.insertFileInfs(atchFileList);
		    				emfMap.put("wntrCvrFileId", atchFileId);
		    			} 
		    			else 
		    			{						
		    				throw new Exception("파일용량초과");
		    			}
					}
				}
				
				String pWntrPdfFileId = emfMap.getString("wntrPdfFileId");
				
				if(wntrPdfFileCnt > 0)
				{
					if(!"".equals(EMFStringUtil.nullConvert(pWntrPdfFileId)))
					{
						atchFileList = fileUtil.parseFileInf(files, "", 0, pWntrPdfFileId, "Globals.fileStorePath", "wntrPdfFile", Integer.parseInt(atchFileSize), pdfFileExtn);
						
						if(wntrPdfFileCnt == atchFileList.size()) 
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
						atchFileList = fileUtil.parseFileInf(files, "", 0, "", "Globals.fileStorePath", "wntrPdfFile", Integer.parseInt(atchFileSize), pdfFileExtn);
		    			
		    			if(wntrPdfFileCnt == atchFileList.size()) 
		    			{
		    				atchFileId = fileMngService.insertFileInfs(atchFileList);
		    				emfMap.put("wntrPdfFileId", atchFileId);
		    			} 
		    			else 
		    			{						
		    				throw new Exception("파일용량초과");
		    			}
					}
				}
				/** 겨울 end   --------------------------------------------------------------------------------------------------------------------------------**/
			} 
	
			//첨부파일 삭제
			EmfMap delFileMap = new EmfMap();
			
			/** 봄 start ----------------------------------------------------------------------------------------------------------------------------------**/
			String[] delSprPdfFileSeqArr = multiRequest.getParameterValues("delSprPdfFileSeq");
			
			if(delSprPdfFileSeqArr != null && delSprPdfFileSeqArr.length > 0 && sprPdfFileCnt == 0) 
			{
				String pSprPdfFileId = emfMap.getString("sprPdfFileId");
				
				if(!"".equals(EgovStringUtil.nullConvert(pSprPdfFileId)))
				{
					delFileMap.put("atchFileId", pSprPdfFileId);
					
					for (int i = 0; i < delSprPdfFileSeqArr.length; i++) 
	    			{
						delFileMap.put("fileSeq", delSprPdfFileSeqArr[i]);
	    				fileMngService.deleteFileInf(delFileMap);
	    			} 
					
					int fileNum = fileMngService.getFileListCnt(pSprPdfFileId);
					
					if (fileNum == 0) 
	    			{
	    				fileMngService.deleteAllFileInf(delFileMap);
	    				emfMap.put("sprPdfFileId", null);
	    			}
				}
			}
			/** 봄 end   ----------------------------------------------------------------------------------------------------------------------------------**/
			
			/** 여름 start --------------------------------------------------------------------------------------------------------------------------------**/
			String[] delSmmrPdfFileSeqArr = multiRequest.getParameterValues("delSmmrPdfFileSeq");
			
			if(delSmmrPdfFileSeqArr != null && delSmmrPdfFileSeqArr.length > 0 && smmrPdfFileCnt == 0) 
			{
				String pSmmrPdfFileId = emfMap.getString("smmrPdfFileId");
				
				if(!"".equals(EgovStringUtil.nullConvert(pSmmrPdfFileId)))
				{
					delFileMap.put("atchFileId", pSmmrPdfFileId);
					
					for (int i = 0; i < delSmmrPdfFileSeqArr.length; i++) 
	    			{
						delFileMap.put("fileSeq", delSmmrPdfFileSeqArr[i]);
	    				fileMngService.deleteFileInf(delFileMap);
	    			} 
					
					int fileNum = fileMngService.getFileListCnt(pSmmrPdfFileId);
					
					if (fileNum == 0) 
	    			{
	    				fileMngService.deleteAllFileInf(delFileMap);
	    				emfMap.put("smmrPdfFileId", null);
	    			}
				}
			}
			/** 여름 end   --------------------------------------------------------------------------------------------------------------------------------**/
			
			/** 가을 start --------------------------------------------------------------------------------------------------------------------------------**/
			String[] delAtmnPdfFileSeqArr = multiRequest.getParameterValues("delAtmnPdfFileSeq");
			
			if(delAtmnPdfFileSeqArr != null && delAtmnPdfFileSeqArr.length > 0 && atmnPdfFileCnt == 0) 
			{
				String pAtmnPdfFileId = emfMap.getString("atmnPdfFileId");
				
				if(!"".equals(EgovStringUtil.nullConvert(pAtmnPdfFileId)))
				{
					delFileMap.put("atchFileId", pAtmnPdfFileId);
					
					for (int i = 0; i < delAtmnPdfFileSeqArr.length; i++) 
	    			{
						delFileMap.put("fileSeq", delAtmnPdfFileSeqArr[i]);
	    				fileMngService.deleteFileInf(delFileMap);
	    			} 
					
					int fileNum = fileMngService.getFileListCnt(pAtmnPdfFileId);
					
					if (fileNum == 0) 
	    			{
	    				fileMngService.deleteAllFileInf(delFileMap);
	    				emfMap.put("atmnPdfFileId", null);
	    			}
				}
			}
			/** 가을 end   --------------------------------------------------------------------------------------------------------------------------------**/
			
			/** 겨울 start --------------------------------------------------------------------------------------------------------------------------------**/
			String[] delWntrPdfFileSeqArr = multiRequest.getParameterValues("delWntrPdfFileSeq");
			
			if(delWntrPdfFileSeqArr != null && delWntrPdfFileSeqArr.length > 0 && wntrPdfFileCnt == 0) 
			{
				String pWntrPdfFileId = emfMap.getString("wntrPdfFileId");
				
				if(!"".equals(EgovStringUtil.nullConvert(pWntrPdfFileId)))
				{
					delFileMap.put("atchFileId", pWntrPdfFileId);
					
					for (int i = 0; i < delWntrPdfFileSeqArr.length; i++) 
	    			{
						delFileMap.put("fileSeq", delWntrPdfFileSeqArr[i]);
	    				fileMngService.deleteFileInf(delFileMap);
	    			} 
					
					int fileNum = fileMngService.getFileListCnt(pWntrPdfFileId);
					
					if (fileNum == 0) 
	    			{
	    				fileMngService.deleteAllFileInf(delFileMap);
	    				emfMap.put("wntrPdfFileId", null);
	    			}
				}
			}
			/** 겨울 end   --------------------------------------------------------------------------------------------------------------------------------**/
			
			EmfMap loginMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
			
			emfMap.put("modId", loginMap.get("id"));
			emfMap.put("modIp", loginMap.get("loginIp"));
	
			pRALifeMgznDAO.updateLifeMgzn(emfMap);
		}
		catch(Exception e)
		{
			throw (Exception)e;
		}
	}
	
	/**
     * 라이프웨이 매거진을 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteLifeMgznList(int[] delSeq) throws Exception
	{
		EmfMap emfMap = new EmfMap();

		emfMap.put("delSeq", delSeq);
		
		pRALifeMgznDAO.deleteLifeMgzn(emfMap);
	}
	
	/**
     * 라이프웨이 매거진 발간년도 중복확인.
     * 
     * @param EmfMap
	 * @return int
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public int getMgznPbtnYrChk(EmfMap emfMap) throws Exception
    {
    	return pRALifeMgznDAO.getMgznPbtnYrChk(emfMap);
    }
}
