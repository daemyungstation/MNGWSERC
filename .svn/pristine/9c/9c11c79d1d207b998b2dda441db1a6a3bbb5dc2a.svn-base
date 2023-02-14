/**
 * 
 */
package mngwserc.bm.bma.web;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import mngwserc.bm.bma.service.BMABoardMngService;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import egovframework.com.cmm.service.EgovFileMngService;
import egovframework.com.cmm.service.EgovFileMngUtil;
import egovframework.com.cmm.service.EgovProperties;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import emf.core.exception.EmfException;
import emf.core.extend.web.EmfController;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 게시판 관리 컨트롤러
 * </pre>
 * 
 * @ClassName		: BMABoardMngController
 * @Description		: 게시판 관리 컨트롤러
 * @author 안진용
 * @since 2015. 11. 24.
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2015. 11. 24.		안진용					최초생성
 * </pre>
 */
@Controller
public class BMABoardMngController extends EmfController {
	
	/** 서비스 **/
	@Resource(name="bMABoardMngService")
	private BMABoardMngService bMABoardMngService;
	
    /** 파일정보 **/
    @Resource(name="EgovFileMngService")
    private EgovFileMngService fileMngService;
    
    /** 파일 전용 객채 **/
	@Resource(name="EgovFileMngUtil")
    private EgovFileMngUtil fileUtil;    
    
	/** 썸내일 파일 용량 제한 **/
	private String thnlFileSize = (String)EgovProperties.getProperty("Globals.thnlFileSize");	
	
	/** 썸내일 이미지의 width **/
	private Integer thnlImgWidth = Integer.parseInt(EgovProperties.getProperty("Globals.thnlImgWidth"));	
	
	/**
     * 게시글 목록 조회
     * 
     * @param EmfMap 데이터
	 * @return String 뷰 URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */    
	@RequestMapping(value={"/mngwserc/communityid/{communityid}/list.do", "/mngwserc/**/communityid/{communityid}/list.do"})
	public String selectBoardList(EmfMap emfMap, ModelMap modelMap, @PathVariable int communityid) throws Exception
	{
		try
		{
			emfMap.put("communityId", communityid);

			EmfMap mstInfo = bMABoardMngService.selectMaster(emfMap);

			if(mstInfo != null && "Y".equals(mstInfo.getString("useYn")))
			{
				//검색어 체크
				String f = emfMap.getString("f");
				String q = emfMap.getString("q");	
				
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
				
				emfMap.put("tablenm", mstInfo.getString("tablenm"));
				
				EmfMap rtnMap = bMABoardMngService.selectBoardList(emfMap);
				rtnMap.put("f", emfMap.getString("f"));
				rtnMap.put("q", emfMap.getString("q"));
				rtnMap.put("useYn", emfMap.getString("useYn"));
				rtnMap.put("categoryId", emfMap.getString("categoryId"));	
				
				
				modelMap.addAttribute("rtnMap", rtnMap);
				modelMap.addAttribute("mstInfo", mstInfo);
			}
			else
			{
				throw new FileNotFoundException();
			}
				
		}
		catch(Exception he)
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}
		
		return "mngwserc/bm/bma/BMABoardList.admin";
	}
	
	/**
     * 게시글 보기
     * 
     * @param EmfMap 데이터
	 * @return String 뷰 URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */ 
	@RequestMapping(value={"/mngwserc/communityid/{communityid}/view.do", "/mngwserc/**/communityid/{communityid}/view.do"})
	public String getBoardViewPage(EmfMap emfMap, ModelMap modelMap, @PathVariable int communityid) throws Exception
	{
		String url = "erorr/blank.error";
		
		try
		{			
			emfMap.put("communityId", communityid);

			EmfMap mstInfo = bMABoardMngService.selectMaster(emfMap);
			
			if(mstInfo != null && "Y".equals(mstInfo.getString("useYn")))
			{
				emfMap.put("tablenm", mstInfo.getString("tablenm"));
				emfMap.put("communityType", mstInfo.getString("communityType"));
				emfMap.put("poorWordNm", mstInfo.getString("poorWordNm"));
				
				EmfMap rtnMap = bMABoardMngService.selectBoardRead(emfMap);
				
				if("Y".equals(EMFStringUtil.nullConvert(emfMap.get("editorView"))))
				{
					url = "mngwserc/bm/bma/BMABoardEditorView";
				}
				else
				{
					url = "mngwserc/bm/bma/BMABoardView.admin";
				}
				modelMap.addAttribute("rtnMap", rtnMap);
				modelMap.addAttribute("mstInfo", mstInfo);
				
				modelMap.addAttribute("sUseYn", emfMap.getString("useYn"));
				modelMap.addAttribute("sCategoryId", emfMap.getString("categoryId"));
			}
			else
			{
				throw new FileNotFoundException();
			}
		}
		catch(Exception he)
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}
		
		return url;
	}
	
	/**
     * 게시글 쓰기, 수정 페이지
     * 
     * @param EmfMap 데이터
	 * @return String 뷰 URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */ 
	@RequestMapping(value={"/mngwserc/communityid/{communityid}/write.do", "/mngwserc/**/communityid/{communityid}/write.do"})	
	public String selectBoardRead(EmfMap emfMap, ModelMap modelMap, @PathVariable int communityid) throws Exception
	{
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		try
		{	
			emfMap.put("communityId", communityid);
			
			EmfMap mstInfo = bMABoardMngService.selectMaster(emfMap);
			
			if(mstInfo != null && "Y".equals(mstInfo.getString("useYn")))
			{
				emfMap.put("tablenm", mstInfo.getString("tablenm"));
				emfMap.put("communityType", mstInfo.getString("communityType"));
				emfMap.put("poorWordNm", mstInfo.getString("poorWordNm"));
				
				EmfMap rtnMap = bMABoardMngService.selectBoardRead(emfMap);
				modelMap.addAttribute("regNm", lgnMap.getString("name"));
				modelMap.addAttribute("rtnMap", rtnMap);
				modelMap.addAttribute("mstInfo", mstInfo);
			}
			else
			{
				throw new FileNotFoundException();
			}
		}
		catch(Exception he)
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}				
		
		return "mngwserc/bm/bma/BMABoardWrite.admin";	
	}
	
	/**
     * 게시글을 등록한다.
     * 
     * @param EmfMap 데이터
	 * @return String 뷰 URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */	
	@RequestMapping(value={"/mngwserc/communityid/{communityid}/insert.do", "/mngwserc/**/communityid/{communityid}/insert.do"}, method=RequestMethod.POST)
	public String insertBoardArticle(EmfMap emfMap, ModelMap modelMap, @PathVariable int communityid, final MultipartHttpServletRequest multiRequest) throws Exception
	{	
		try
		{
			emfMap.put("communityId", communityid);
			
			EmfMap mstInfo = bMABoardMngService.selectMaster(emfMap);
			
			if(mstInfo != null && "Y".equals(mstInfo.getString("useYn")))
			{
				emfMap.put("tablenm", mstInfo.getString("tablenm"));
				
				bMABoardMngService.insertBoardArticle(emfMap);
			}
			else
			{
				throw new FileNotFoundException();
			}
		}
		catch(Exception he)
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}
		
		return "redirect:./list.do";
	}	
	
	/**
     * 게시글을 수정한다.
     * 
     * @param EmfMap 데이터
	 * @return String 뷰 URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */	
	@RequestMapping(value={"/mngwserc/communityid/{communityid}/update.do", "/mngwserc/**/communityid/{communityid}/update.do"}, method=RequestMethod.POST)
	public String updateBoardArticle(EmfMap emfMap, ModelMap modelMap, @PathVariable int communityid, final MultipartHttpServletRequest multiRequest) throws Exception
	{	
		try
		{
			emfMap.put("communityId", communityid);
			
			modelMap.addAttribute("f", emfMap.getString("f"));
			modelMap.addAttribute("q", emfMap.getString("q"));
			modelMap.addAttribute("pageIndex", emfMap.getString("pageIndex"));
			modelMap.addAttribute("useYn", emfMap.getString("sUseYn"));
			modelMap.addAttribute("categoryId", emfMap.getString("sCategoryId"));
			
			EmfMap mstInfo = bMABoardMngService.selectMaster(emfMap);
			
			if(mstInfo != null && "Y".equals(mstInfo.getString("useYn")))
			{
				emfMap.put("tablenm", mstInfo.getString("tablenm"));
				
				bMABoardMngService.updateBoardArticle(emfMap);
			}
			else
			{
				throw new FileNotFoundException();
			}
		}
		catch(Exception he)
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}
		
		return "redirect:./view.do?idx=" + emfMap.getString("idx");
	}
	
	/**
     * 게시글 삭제
     * 
     * @param EmfMap 검색데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */	
	@RequestMapping(value={"/mngwserc/communityid/{communityid}/deleteMulti.do", "/mngwserc/**/communityid/{communityid}/deleteMulti.do"}, method=RequestMethod.POST)
	public String deleteBoardMulti(EmfMap emfMap, ModelMap modelMap, @PathVariable int communityid, @RequestParam(value="delidx", required=true) int[] delidx) throws Exception
	{		
		try
		{
			emfMap.put("communityId", communityid);
			
			EmfMap mstInfo = bMABoardMngService.selectMaster(emfMap);
			
			if(mstInfo != null && "Y".equals(mstInfo.getString("useYn")))
			{
				emfMap.put("tablenm", mstInfo.getString("tablenm"));
				
				bMABoardMngService.deleteBoardMulti(emfMap, delidx);
			}
			else
			{
				throw new FileNotFoundException();
			}
		}
		catch(Exception he)
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}

		return "redirect:./list.do";
	}	
	
	/**
     * 게시글 승인 / 미승인처리한다.
     * 
     * @param EmfMap 검색데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */	
	@RequestMapping(value={"/mngwserc/communityid/{communityid}/blindMulti.do", "/mngwserc/**/communityid/{communityid}/blindMulti.do"}, method=RequestMethod.POST)
	public String blindBoardMulti(EmfMap emfMap, ModelMap modelMap, @PathVariable int communityid, @RequestParam(value="delidx", required=true) int[] delidx) throws Exception
	{		
		emfMap.put("communityId", communityid);
		
		EmfMap boardInfo = bMABoardMngService.selectMaster(emfMap);
		
		if(boardInfo != null && "Y".equals(boardInfo.getString("useYn")))
		{
			emfMap.put("tablenm", boardInfo.getString("tablenm"));
			
			try
			{
				bMABoardMngService.blindBoardMulti(emfMap, delidx);
			}
			catch(Exception he)
			{
				if (log.isDebugEnabled()) 
				{
					log.debug(he);
	            }
				throw new EmfException(he.getMessage());
			}
		}
		else
		{
			throw new FileNotFoundException();
		}

		return "redirect:./list.do";
	}
	
	/**
     * 게시글 첨부파일 등록 
     * 
     * @param EmfMap 검색데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@RequestMapping(value={"/mngwserc/communityid/{communityid}/fileUpload.ajax", "/mngwserc/**/communityid/{communityid}/fileUpload.ajax"})
	@ResponseBody
	public void fileUpload(EmfMap emfMap, ModelMap modelMap, @PathVariable int communityid, final MultipartHttpServletRequest multiRequest,  HttpServletResponse response) throws Exception
	{	
		response.setContentType("text/html;charset=UTF-8");
        
		PrintWriter out = response.getWriter();
		
        emfMap.put("communityId", communityid);
		
		EmfMap mstInfo = bMABoardMngService.selectMaster(emfMap);

		if(mstInfo != null && "Y".equals(mstInfo.getString("useYn")))
		{
	        JSONArray jSONArray = new JSONArray();
	        
			try
			{
				final Map<String, MultipartFile> files = multiRequest.getFileMap();	
				
				Iterator<Entry<String, MultipartFile>> itr = files.entrySet().iterator();
				MultipartFile file;
				
				String formName = null;
				long fileSize = 0;
				
				while (itr.hasNext()) 
				{
				    Entry<String, MultipartFile> entry = itr.next();
				    file = entry.getValue();

				    if(file.getName().equals("thumfile"))
				    {
				    	formName = "thumfile";
				    	fileSize = Integer.parseInt(thnlFileSize);

				    }
				    else if(file.getName().equals("attfile"))
				    {
				    	formName = "attfile";
				    	
				    	if(!"".equals(EMFStringUtil.nullConvert(mstInfo.getString("fileSize"))))
						{
				    		int size = Integer.parseInt(mstInfo.getString("fileSize"));
				    		fileSize = size * 1024 * 1024;
						}
				    }
				    else if(file.getName().equals("contentfile"))
				    {
				    	formName = "contentfile";
				    	
				    	if(!"".equals(EMFStringUtil.nullConvert(mstInfo.getString("contentsFileSize"))))
						{
				    		int size = Integer.parseInt(mstInfo.getString("contentsFileSize"));
				    		fileSize = size * 1024;
						}
				    }
				}	

				if(!files.isEmpty())
				{
					List<EmfMap> filelist = null;
					
					String filePossibleExtNm = EMFStringUtil.nullConvert(mstInfo.getString("filePossibleExtNm"));
					
					String fileId = EMFStringUtil.nullConvert(emfMap.getString("fileId"));
					
					if(!"".equals(filePossibleExtNm))
					{					
						int fileSn = Integer.parseInt(EMFStringUtil.nvl(emfMap.getString("fileSn"), "0"));
						
						if(filePossibleExtNm.indexOf(",") > 0)
						{
							filelist = fileUtil.parseFileInf(files, "", fileSn, fileId, "Globals.fileStorePath", formName, fileSize, filePossibleExtNm.split(","));
						}
						else
						{
							filelist = fileUtil.parseFileInf(files, "", fileSn, fileId, "Globals.fileStorePath", formName, fileSize, new String[]{filePossibleExtNm});
						}					
					}						
					
		            for(int i = 0; i < filelist.size(); i++)
		            {
		                JSONObject jSONObject = new JSONObject();
		                jSONObject.put("atchFileId", filelist.get(i).get("atchFileId"));
		                jSONObject.put("fileSeq", filelist.get(i).get("fileSeq"));
		                jSONObject.put("realFileNm", filelist.get(i).get("realFileNm"));
		                jSONObject.put("fileSize", filelist.get(i).get("fileSize"));
		                jSONObject.put("fileExtn", filelist.get(i).get("fileExtn"));
		                jSONArray.put(jSONObject);
		                jSONObject = null;		
		            }

		            if(filelist.size() > 0)
		            {
		            	if("".equals(fileId))
		                {	
		                	fileMngService.insertFileInfs(filelist);
		                }
		                else
		                {
		                	if("thumfile".equals(formName))
			            	{
		                		fileMngService.updateFileInfs(filelist);
			            	}
			            	else
			            	{
			            		fileMngService.insertFileInfs(filelist);
			            	}
		                }
		            }
				}
				
				out.print(jSONArray);
				jSONArray=null;
			}
			catch(Exception he)
			{
				if (log.isDebugEnabled()) 
				{
					log.debug(he);
	            }
				throw new EmfException(he.getMessage());		
			}
			finally
			{
				out.flush();
				out.close();
			}
		}
		else
		{
			return;
		}
	}	
	
	/**
     * 게시글 첨부파일 삭제 
     * 
     * @param EmfMap 검색데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@RequestMapping(value={"/mngwserc/communityid/{communityid}/fileDelete.ajax", "/mngwserc/**/communityid/{communityid}/fileDelete.ajax"}, method=RequestMethod.POST)
	public ModelAndView fileDelete(EmfMap emfMap, ModelMap modelMap, @PathVariable int communityid) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		
		try 
        {
			emfMap.put("communityId", communityid);
				
			EmfMap mstInfo = bMABoardMngService.selectMaster(emfMap);

			if(mstInfo != null && "Y".equals(mstInfo.getString("useYn")))
			{
				fileMngService.deleteFileInf(emfMap);
				
				mav.addObject("status", "Y");
				
				mav.setViewName("jsonView");
			}
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

	/**
     * 게시판 파일 설명 업데이트 
     * @param emfMap
     * @param modelMap
     * @return
     * @throws Exception
     */
	@RequestMapping(value={"/mngwserc/communityid/{communityid}/fileUpdFileCn.ajax", "/mngwserc/**/communityid/{communityid}/fileUpdFileCn.ajax"}, method=RequestMethod.POST)
	public ModelAndView fileUpdFileCn(EmfMap emfMap, ModelMap modelMap, @PathVariable int communityid) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		
		try 
        {
			emfMap.put("communityId", communityid);
				
			EmfMap mstInfo = bMABoardMngService.selectMaster(emfMap);

			if(mstInfo != null && "Y".equals(mstInfo.getString("useYn")))
			{
				fileMngService.updateFileInf(emfMap);
				
				mav.addObject("status", "Y");
				
				mav.setViewName("jsonView");
			}
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
