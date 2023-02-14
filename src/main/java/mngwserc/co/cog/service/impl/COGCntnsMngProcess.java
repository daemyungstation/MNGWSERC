package mngwserc.co.cog.service.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import egovframework.com.cmm.service.EgovProperties;

/**
 * <pre> 
 * 컨텐츠 파일 생성을 위한 Process
 * </pre>
 * 
 * @ClassName		: COGCntnsMngProcess.java
 * @Description		: 컨텐츠 파일 생성을 위한 Process
 * @author 안진용
 * @since 2015.11.17
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2015.11.17		안진용					최초생성
 * </pre>
 */
@Component("cOGCntnsMngProcess")
public class COGCntnsMngProcess {
	
	static String rootDir = EgovProperties.getProperty("Globals.contentsRootPath");
	
	public void makeFile(String filePath, String data) throws IOException
	{
		//템플릿 파일 위치
		String templateFilePath = rootDir + "/template.jsp";

		StringBuffer templateJsp = new StringBuffer();	 
		String line = null;
		BufferedReader br = null;
		
		try
		{
	        br = new BufferedReader(new InputStreamReader(new FileInputStream(templateFilePath), "UTF-8"));
	        
	        while((line=br.readLine()) != null)
	        {
	        	templateJsp.append(line).append("\n");
	        }
	        
	        br.close();
	        br = null;
	        line = null;
	        
	        BufferedWriter jspFile = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8"));
			jspFile.write(templateJsp.toString().replace("$contents$", data));
			jspFile.close();	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(br != null) br.close();
		}
	}
	
	public void fileMove(String defaultPath , String changePath)
	{
		File defaultFile = new File(rootDir+defaultPath);
		
		List<File> defaultFileList = null;
		
		File[] dFiles = defaultFile.listFiles();
		
		try
		{
			if(dFiles != null)
			{
				defaultFileList = Arrays.asList(dFiles);
				
				for(int i = 0; i< defaultFileList.size(); i++)
				{
					String fileName = defaultFileList.get(i).getName();
					
					//복사 시작
					fileCopy(rootDir + defaultPath + "/" + fileName, rootDir + changePath + "/" + fileName);
					fileDelete(rootDir + defaultPath + "/" + fileName);
				}
			}			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		defaultFile.delete();
	}
	
	public void fileCopy(String inFileName, String outFileName) throws IOException 
	{
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
        try 
        {
        	File outFilePath = new File(outFileName.substring(0,outFileName.lastIndexOf("/")));
        	
        	if(!outFilePath.exists())
        	{
        		outFilePath.mkdirs();
        	}
        	
        	fis = new FileInputStream(inFileName);
        	fos = new FileOutputStream(outFileName);

            byte[] buffer = new byte[1024 * 2];

            int dataSize = 0;
            
            while ((dataSize = fis.read(buffer)) != -1) 
            {
                fos.write(buffer, 0, dataSize);
            }
            
            fis.close();
            fos.close();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        finally
        {
        	if(fis != null)
        	{
        		fis.close();
        	}
        	
        	if(fos != null)
        	{
        		fos.close();	        	
        	}
        }
    }
	
    public void fileDelete(String deleteFileName)
    {
        File I = new File(deleteFileName);
        I.delete();
    }
}
