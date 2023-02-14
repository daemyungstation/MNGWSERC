package egovframework.com.cmm.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.com.cmm.EgovWebUtil;
import egovframework.com.cmm.service.EgovFileMngService;
import egovframework.com.cmm.service.EgovProperties;
import egovframework.com.utl.fcc.service.EgovFormBasedFileUtil;
import egovframework.com.utl.fcc.service.EgovStringUtil;
import emf.core.exception.EmfException;
import emf.core.extend.web.EmfController;
import emf.core.vo.EmfMap;

/**
 * 파일 다운로드를 위한 컨트롤러 클래스
 * @author 공통서비스개발팀 이삼섭
 * @since 2009.06.01
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2009.3.25  이삼섭          최초 생성
 *
 * Copyright (C) 2009 by MOPAS  All right reserved.
 * </pre>
 */
@Controller
public class EgovFileDownloadController extends EmfController {
	
	/** 첨부파일 위치 지정 **/
    private final String uploadDir = EgovProperties.getProperty("Globals.fileStorePath");
	
    /** 첨부파일 위치 지정 **/
    private final String docDir = EgovProperties.getProperty("Globals.docFileStorePath");
    
    /** Buffer size **/
    public static final int BUFFER_SIZE = 8192;

    public static final String SEPERATOR = File.separator;
    
    @Resource(name = "EgovFileMngService")
    private EgovFileMngService fileService;
    
    private static final Logger LOG = Logger.getLogger(EgovFileDownloadController.class.getName());
    
    /**
	 * 브라우저 구분 얻기.
	 * 
	 * @param request
	 * @return String
	 * @throws Exception
	 */
    private String getBrowser(HttpServletRequest request) 
    {
        String header = request.getHeader("User-Agent");
      
        if (header.indexOf("MSIE") > -1) 
        {
            return "MSIE";
        }
        else if (header.indexOf("Chrome") > -1) 
        {
            return "Chrome";
        } 
        else if (header.indexOf("Opera") > -1) 
        {
            return "Opera";
        }
        else if (header.indexOf("Trident") > -1)
        {
        	return "Trident";
        }
        
        return "Firefox";
    }
    
    /**
     * Disposition 지정하기.
     * 
     * @param filename
     * @param request
     * @param response
     * @return 
     * @throws Exception
     */
    private void setDisposition(String filename, HttpServletRequest request, HttpServletResponse response) throws Exception 
    {
		String browser = getBrowser(request);
		
		String dispositionPrefix = "attachment; filename=";
		String encodedFilename = null;
		
		if (browser.equals("MSIE")) 
		{
		    encodedFilename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", "%20");
		} 
		else if(browser.equals("Trident"))
		{
			encodedFilename = "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\"";
		}
		else if (browser.equals("Firefox"))
		{
		    encodedFilename = "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\"";
		} 
		else if (browser.equals("Opera")) 
		{
		    encodedFilename = "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\"";
		} 
		else if (browser.equals("Chrome")) 
		{
		    StringBuffer sb = new StringBuffer();
		    
		    for (int i = 0; i < filename.length(); i++) 
		    {
				char c = filename.charAt(i);
				
				if (c > '~') 
				{
				    sb.append(URLEncoder.encode("" + c, "UTF-8"));
				} 
				else 
				{
				    sb.append(c);
				}
		    }
		    
		    encodedFilename = sb.toString();
		} 
		else 
		{
		    throw new IOException("Not supported browser");
		}
		
		response.setHeader("Content-Disposition", dispositionPrefix + encodedFilename);
	
		if ("Opera".equals(browser))
		{
		    response.setContentType("application/octet-stream;charset=UTF-8");
		}
    }
    
    /**
     * 파일을 뷰한다
     * 
     * @param filename
     * @param request
     * @param response
     * @return 
     * @throws Exception
     */
    @RequestMapping(value="/cmm/fms/fileView.do", method=RequestMethod.GET)
    public void downloadFile(@RequestParam(value="fileId", required=true) String atchFileId,
    						 @RequestParam(value="fileSn", required=true) int fileSeq, 
    						 HttpServletRequest request, HttpServletResponse response, EmfMap emfMap) throws Exception 
    {   
    	atchFileId = atchFileId.replace("../", "");
		
		emfMap.put("atchFileId", atchFileId.trim());
		emfMap.put("fileSeq", Integer.toString(fileSeq));		
		
		EmfMap rtnMap = fileService.selectFileInf(emfMap);
		
		setDisposition(URLEncoder.encode((String)rtnMap.get("realFileNm"), "utf-8"), request, response);
		
		try
		{
			EgovFormBasedFileUtil.viewFile(response, rtnMap.getString("phyPath"), "", rtnMap.getString("saveFileNm"), rtnMap.getString("fileExtn"));
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

    /**
     * 첨부파일로 등록된 파일에 대하여 다운로드를 제공한다.
     * 
     * @param commandMap
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/cmm/fms/FileDown.do")    
    public void fileDownload(HttpServletRequest request, HttpServletResponse response, EmfMap emfMap) throws Exception
    {
    	String atchFileId = "";
    	
    	if(emfMap.get("fileId") != null)
    	{
        	atchFileId = emfMap.getString("fileId");
        	atchFileId = atchFileId.replace("../", "");   
        	emfMap.put("atchFileId", atchFileId);
    	}
    	
    	int fileSeq = 0;
    	
    	if(emfMap.get("fileSn") != null)
    	{
    		fileSeq = Integer.parseInt(emfMap.getString("fileSn"));
    		emfMap.put("fileSeq", fileSeq);
    	}
    	
		EmfMap rtnMap  = fileService.selectFileInf(emfMap);
		
	    if(rtnMap == null || "".equals(EgovStringUtil.nullConvert(rtnMap.get("phyPath"))))
	    {
	    	//dispatch-servlet.xml에 정의되어잇는 Exception으로 매핑
	    	throw new FileNotFoundException("파일이 없습니다.");
	    }
	    
	    File uFile = new File(rtnMap.getString("phyPath"), rtnMap.getString("saveFileNm"));
	    
	    int fSize = (int)uFile.length();
	    
	    if (fSize > 0) 
	    {
			String mimetype = "application/x-msdownload";
	
			//response.setBufferSize(fSize);	// OutOfMemeory 발생
			//response.setHeader("Content-Disposition", "attachment; filename=\"" + URLEncoder.encode(fvo.getOrignlFileNm(), "utf-8") + "\"");
			
			response.setContentType(mimetype);
			response.setContentLength(fSize);
			setDisposition(URLEncoder.encode(String.valueOf(rtnMap.get("realFileNm")), "utf-8"), request, response);
			
			BufferedInputStream in = null;
			BufferedOutputStream out = null;
	
			try 
			{
			    in = new BufferedInputStream(new FileInputStream(uFile));
			    out = new BufferedOutputStream(response.getOutputStream());
	
			    FileCopyUtils.copy(in, out);
			    out.flush();
			} 
			catch (Exception ex) 
			{
			    // 다음 Exception 무시 처리
			    // Connection reset by peer: socket write error
			    LOG.debug("IGNORED: " + ex.getMessage());
			} 
			finally 
			{
			    if (in != null) 
			    {
					try
					{
					    in.close();
					} 
					catch (Exception ignore)
					{
					    LOG.debug("IGNORED: " + ignore.getMessage());
					}
			    }
			    
			    if (out != null) 
			    {
					try 
					{
					    out.close();
					} 
					catch (Exception ignore)
					{
					    LOG.debug("IGNORED: " + ignore.getMessage());
					}
			    }
			}
	    }
	    else 
	    {
	    	throw new FileNotFoundException("파일이 없습니다.");
	    }
	}

    /*
     * 미디어 파일을 다운로드 한다.
     */
    @RequestMapping(value="/cmm/download.do",method=RequestMethod.GET)
    public void downloadMediaFile(@RequestParam("subpath") String subpath, HttpServletResponse response, HttpServletRequest request) throws Exception 
    {  
    	subpath = EgovWebUtil.filePathBlackList(subpath);
 
    	//String downFileName = docDir + subpath;
    	String downFileName = "/home/sample" + subpath; // globals.properties 를 제대로 읽지 못하는 문제로 우선 하드코딩

    	String filename = subpath; // /template/DBUploadSample.xls
    	String downloadUrl = "";
    	String[] arrFilename;
    	
    	arrFilename = filename.split("/");
    	filename = arrFilename[arrFilename.length - 1];
    	downloadUrl = arrFilename[1];
    	
    	//filename = new String(filename.getBytes("8859_1"),"utf-8");
    	
    	if(subpath.indexOf("../") > -1 )
    	{
    		response.sendRedirect("/error/500.do");
    		return;
    	}
    	
    	//파일 경로중 첫번째가 download여야 한다.
    	/*
    	if(!downloadUrl.equals("download")){
    		response.sendRedirect("/error/500.do");
    		return;
    	}
    	*/
    	
    	File file = new File(EgovWebUtil.filePathBlackList(downFileName));
    	if (!file.exists()) 
    	{
    	    throw new FileNotFoundException(downFileName);
    	}

    	if (!file.isFile()) 
    	{
    	    throw new FileNotFoundException(downFileName);
    	}
   	
    	//String refilename = new String(filename.getBytes("8859_1"),"utf-8");
    	response.setContentType("application/octet-stream");
    	response.setHeader("Content-Disposition", "attachment; filename=\"" + URLEncoder.encode(filename, "utf-8") + "\";");
    	response.setHeader("Content-Transfer-Encoding", "binary");
    	response.setHeader("Pragma", "no-cache");
    	response.setHeader("Expires", "0");
    	
    	BufferedInputStream fin = null;
    	BufferedOutputStream outs = null;
    	
    	byte[] b = new byte[BUFFER_SIZE];
    	
		try 
		{
			fin = new BufferedInputStream(new FileInputStream(file));
			outs = new BufferedOutputStream(response.getOutputStream());

			int read = 0;

			while ((read = fin.read(b)) != -1) 
			{
				outs.write(b, 0, read);
			}
		}
		finally 
		{
			if (outs != null)
			{
				try 
				{	
					// 2012.11 KISA 보안조치
					outs.close();
				} 
				catch (Exception ignore)
				{
					LOG.debug("IGNORED: " + ignore.getMessage());
				}
			}

			if (fin != null) 
			{
				try 
				{	
					// 2012.11 KISA 보안조치
					fin.close();
				} 
				catch (Exception ignore)
				{
					LOG.debug("IGNORED: " + ignore.getMessage());
				}
			}
		}
    }
}