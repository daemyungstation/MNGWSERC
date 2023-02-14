package mngwserc.cn.cna;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import egovframework.com.cmm.web.EgovImageProcessController;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;

public class CNAFileUtil {
	
	private static final Logger LOG = Logger.getLogger(EgovImageProcessController.class.getName());
	
    public static void getImageInf(EmfMap fvo, HttpServletResponse response) throws Exception 
    {
    	
    	GetAllMapValue.getMapValue(fvo);
    	
		if(fvo == null)
		{
			return;
		}
		
		// 2011.10.10 보안점검 후속조치
		File file = null;
		FileInputStream fis = null;
	
		BufferedInputStream in = null;
		ByteArrayOutputStream bStream = null;
		
		try 
		{
//			file = new File(fvo.getString("phyPath"), fvo.getString("saveFileNm"));
			file = new File(fvo.getString("filePath"), fvo.getString("localFileNm"));
		    
		    if(!file.isFile())
		    {
		    	return;
		    }
		    
		    fis = new FileInputStream(file);
		    in = new BufferedInputStream(fis);
		    bStream = new ByteArrayOutputStream();
	
		    int imgByte;
		    
		    while ((imgByte = in.read()) != -1)
		    {
		    	bStream.write(imgByte);
		    }
	
			String type = "";
		
//			if (!"".equals(EMFStringUtil.nullConvert(fvo.get("fileExtn"))))
			if (!"".equals(EMFStringUtil.nullConvert(fvo.get("fileType"))))
			{
//				String fileExtsn = fvo.getString("fileExtn");
				String fileExtsn = fvo.getString("fileType");
				
			    if ("jpg".equals(fileExtsn.toLowerCase())) 
			    {
			    	type = "image/jpeg";
			    } 
			    else 
			    {
			    	type = "image/" + fileExtsn.toLowerCase();
			    }
			    
			    type = "image/" + fileExtsn.toLowerCase();
			} 
			else 
			{
			    LOG.debug("Image fileType is null.");
			}
		
			response.setHeader("Content-Type", type);
//			response.setHeader("Content-Disposition", "filename=" + fvo.get("realFileNm") + ";");
			response.setHeader("Content-Disposition", "filename=" + fvo.get("fileNm") + ";");
			response.setContentLength(bStream.size());
		
			bStream.writeTo(response.getOutputStream());
		
			response.getOutputStream().flush();
			response.getOutputStream().close();
			
			// 2011.10.10 보안점검 후속조치 끝
		}
		finally 
		{
			if (bStream != null) 
			{
				try 
				{
					bStream.close();
				} 
				catch (Exception ignore)
				{
					LOG.debug("IGNORE: " + ignore.getMessage());
				}
			}
			
			if (in != null) 
			{
				try
				{
					in.close();
				} 
				catch (Exception ignore)
				{
					LOG.debug("IGNORE: " + ignore.getMessage());
				}
			}
			
			if (fis != null)
			{
				try
				{
					fis.close();
				} 
				catch (Exception ignore)
				{
					LOG.debug("IGNORE: " + ignore.getMessage());
				}
			}
		}
    }
}
