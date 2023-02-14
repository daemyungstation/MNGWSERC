package mngwserc.fair.web;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import egovframework.com.cmm.service.EgovProperties;
import emf.core.exception.EmfException;
import emf.core.extend.web.EmfController;
import emf.core.vo.EmfMap;
import mngwserc.fair.service.FairDistributeService;
/**
 * <pre> 
 * 박람회 배포 관리 Controller
 * </pre>
 * 
 * @ClassName		: FairConfigController.java
 * @Description		: 박람회 설정 관리 Controller
 * @author inuscommunity
 * @since 2019. 10. 14.
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 	    since			author	               description
 *  ============    ==============    =============================
 *  2019. 10. 14.	   inuscomm                 최초생성
 * </pre>
 */

@Controller
@RequestMapping(value="/mngwserc/fair/distribute")
public class FairDistributeController extends EmfController {
	
	/** 서비스 **/
	@Resource(name="fairDistributeService")
	private FairDistributeService fairDistributeService;
	
	private String rootDir = EgovProperties.getProperty("Globals.fairFilePath");
	
	/**
	 * 배포 조회
	 *
	 * @param modelMap
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value="/index.do")
	public String select(ModelMap modelMap) throws Exception
	{
		try
		{
			List<String> list = new ArrayList<String>();
			File dir = new File(this.rootDir);
			File[] fileList = dir.listFiles();
			for(int i = 0 ; i < fileList.length ; i++)
			{
				File file = fileList[i];
				if(file.isDirectory()){
					list.add(file.getName());
				}
			}
			modelMap.addAttribute("list", list);
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		} 	
		return "mngwserc/fair/FairDistribute.admin";
	}
	

	/**
	 * 배포 생성
	 *
	 * @param HttpServletRequest request data
	 * @return ModelAndView
	 * @throws Exception
	 */
    @RequestMapping(value="/create.ajax", method=RequestMethod.POST)
    public ModelAndView create(HttpServletRequest request, EmfMap emfMap) throws Exception 
    {
    	String rst = "INVALID";
    	try
		{
    		//디렉토리 생성
    		String directory = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    		String directory_path = this.rootDir +"/"+ directory;
    		File dir = new File(directory_path);
    		if(!dir.exists()){
    			dir.mkdir();
    		}
    		
    		//파일 복사
    		List<String> fileList = new ArrayList<String>();
    		fileList.add("FairMain.jsp");
    		fileList.add("FairMainMo.jsp");
//    		fileList.add("FairDetail.jsp");
//    		fileList.add("FairDetailMo.jsp");
    		
    		for(String file: fileList)
    		{
	    		FileInputStream fis = new FileInputStream(new File(this.rootDir +"/"+ file));
				FileOutputStream fos = new FileOutputStream(new File(directory_path +"/"+ file));

				byte[] buffer = new byte[1024 * 2];

	            int dataSize = 0;
	            
	            while ((dataSize = fis.read(buffer)) != -1) 
	            {
	                fos.write(buffer, 0, dataSize);
	            }
	            
	            fis.close();
	            fos.close();
			}
    		
    		//파일 만들기
    		String oDir = this.rootDir;
    		String fileName = "";
    		BufferedWriter jspFile = null;
    		//메인
    		EmfMap mainHtml = fairDistributeService.makeMain();
    		
    		fileName = "FairMain.jsp";
    		jspFile = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(oDir +"/"+ fileName), "UTF-8"));
			jspFile.write(mainHtml.getString("pc"));
			jspFile.close();
			
    		fileName = "FairMainMo.jsp";
    		jspFile = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(oDir +"/"+ fileName), "UTF-8"));
			jspFile.write(mainHtml.getString("mo"));
			jspFile.close();

			rst = "OK";
		}
    	catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}
    	
    	ModelAndView mav = new ModelAndView();
    	mav.addObject("result", rst);
		mav.setViewName("jsonView");

		return mav; 
    }
    
    /**
	 * 배포 삭제
	 *
	 * @param HttpServletRequest request data
	 * @return ModelAndView
	 * @throws Exception
	 */
    @RequestMapping(value="/delete.ajax", method=RequestMethod.POST)
    public ModelAndView delete(HttpServletRequest request, EmfMap emfMap) throws Exception 
    {
    	String rst = "INVALID";
    	try
		{
    		//디렉토리 생성
    		String directory = emfMap.getString("directory");
    		String directory_path = this.rootDir +"/"+ directory;
    		File dir = new File(directory_path);
    		
    		while(dir.exists()) {
    			File[] folder_list = dir.listFiles(); //파일리스트 얻어오기
    					
    			for (int j = 0; j < folder_list.length; j++) {
    				folder_list[j].delete(); //파일 삭제 
    				System.out.println("파일이 삭제되었습니다.");
    						
    			}
    					
    			if(folder_list.length == 0 && dir.isDirectory()){ 
    				dir.delete(); //대상폴더 삭제
    				System.out.println("폴더가 삭제되었습니다.");
    			}
    	    }

			rst = "OK";
		}
    	catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}
    	
    	ModelAndView mav = new ModelAndView();
    	mav.addObject("result", rst);
		mav.setViewName("jsonView");

		return mav; 
    }
}
