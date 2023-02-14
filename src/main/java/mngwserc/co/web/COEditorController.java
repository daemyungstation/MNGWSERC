package mngwserc.co.web;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import egovframework.com.cmm.service.EgovFileMngService;
import egovframework.com.cmm.service.EgovFileMngUtil;
import emf.core.extend.web.EmfController;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 에디터의 관리를 위한 Controller
 * </pre>
 * 
 * @ClassName		: COEditorController.java
 * @Description		: 에디터의 관리를 위한 Controller
 * @author 박주석
 * @since 2015.11.02
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2015.11.22		박주석					최초생성
 * </pre>
 */
@Controller
public class COEditorController extends EmfController {
	
	@Resource(name="EgovFileMngUtil")
    private EgovFileMngUtil fileUtil;
	
	@Resource(name="EgovFileMngService")
    private EgovFileMngService fileMngService;
	
	/** 이미지만 업로드가 가능합니다. **/
	private String[] UploadMimeType = {"jpg","bmp","png","gif"};
	
	/**
	 * 에디터를 가져온다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/egov/seditor/SmartEditor2Skin.do")
	public String getEditor(EmfMap emfMap, ModelMap model) throws Exception
	{
		return "mngwserc/co/editor/index";
	}
	
	/**
	 * 게시판의 이미지를 업로드 한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/mngwserc/editorimageupload/action.do", method=RequestMethod.POST)	
	public String setEditorImageUpload(final MultipartHttpServletRequest multiRequest,
									   @RequestParam(value="callback_func", required=false) String callback_func,
									   @RequestParam(value="FileDescription", required=false) String FileDescription,
									   ModelMap model) throws Exception
    {
		try
		{
			List<EmfMap> result = null;
			
			final Map<String, MultipartFile> files = multiRequest.getFileMap();		
		    
			if (!files.isEmpty())
		    {			
		    	result = fileUtil.parseFileInf(files, "EDITOR_", 0, "", "Globals.editorFileStorePath", "uploadInputBox", 1000*1024*1024, UploadMimeType);
		    	
		    	if(result.size() > 0)
		    	{
		    		EmfMap rtnMap = result.get(0);
		    		
		    		model.addAttribute("sFileName", rtnMap.getString("subPath") + File.separator + rtnMap.getString("saveFileNm"));
		    	}
		    }		    	    
		    model.addAttribute("callback_func", callback_func);		    
		    model.addAttribute("FileDescription", FileDescription);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new Exception();
		}
		
		return "mngwserc/co/editor/editorcallbak";
	}
}
