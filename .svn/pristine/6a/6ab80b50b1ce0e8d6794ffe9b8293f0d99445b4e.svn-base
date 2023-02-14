package mngwserc.co.coi.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import mngwserc.co.coi.service.COISnsMngService;
import mngwserc.co.coi.service.dao.COISnsMngDAO;
import mngwserc.co.util.COPaginationUtil;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.service.EgovFileMngUtil;
import egovframework.com.cmm.service.EgovProperties;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import emf.core.extend.service.EmfAbstractService;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * SNS 관리 서비스 구현
 * </pre>
 * 
 * @ClassName		: COISnsMngServiceImpl.java
 * @Description		: SNS 관리 서비스 구현
 * @author 이너스커뮤니티
 * @since 2019. 05. 15.
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2019. 05. 15.		이너스					최초생성
 * </pre>
 */

@Service("cOISnsMngService")
public class COISnsMngServiceImpl extends EmfAbstractService implements COISnsMngService {
	
	@Resource(name="cOISnsMngDAO")
	private COISnsMngDAO cOISnsMngDAO;
	
    @Resource(name="snsIdgen")
    private EgovIdGnrService snsIdgen;

    private final static String img_path = EgovProperties.getProperty("Globals.snsImagesPath");
    
    /**
	 * SNS 목록을 조회 한다.
	 * 
	 * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public EmfMap selectSnsList(EmfMap emfMap) throws Exception {

		PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
		
		//페이징 처리
		emfMap.put("paginationInfo", paginationInfo);    
				
		//리스트 가져오기
		List<EmfMap> list = cOISnsMngDAO.selectSnsList(emfMap);
		
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
	 * SNS 속성 정보 상세를 조회 한다.
	 * 
	 * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public EmfMap selectSns(EmfMap emfMap) throws Exception 
	{
		if(!"".equals(EMFStringUtil.nullConvert(emfMap.get("snsSeq"))))
    	{
			EmfMap snsInfo = cOISnsMngDAO.selectSns(emfMap);
			
			if(snsInfo != null)
	    	{
				emfMap.put("snsInfo", snsInfo);
	    	}
    	}
		return emfMap;
	}
	
	/**
	 * SNS 속성정보를 등록한다.
	 */
	public void insertSns(EmfMap emfMap) throws Exception 
	{
		
		EmfMap lgnMap = (EmfMap)EgovUserDetailsHelper.getAuthenticatedUser();
		emfMap.put("regId", lgnMap.getString("id"));
		emfMap.put("regIp", lgnMap.getString("loginIp"));

		emfMap.put("SNS_SEQ", snsIdgen.getNextIntegerId());

		if("L".equals(emfMap.getString("type")))
		{
			emfMap.put("LINK1", emfMap.getString("link0"));
			emfMap.put("LINK1_TYPE", emfMap.getString("link0Type"));
		}
		
		MultipartHttpServletRequest mReq = (MultipartHttpServletRequest) emfMap.get("request");
    	Iterator<String> iter = mReq.getFileNames();
    	MultipartFile mf = null;
    	
    	String[] allowExt = {"png", "gif", "jpg", "jpeg"};
    	
    	while(iter.hasNext()) {
    		String input_name = iter.next();
    		mf = mReq.getFile(input_name);
    		if(mf.isEmpty() == false) {
    			String ori_filenm = mf.getOriginalFilename();
    			String filenm = ori_filenm.substring(0, ori_filenm.lastIndexOf("."));
    			String ext = ori_filenm.substring(ori_filenm.lastIndexOf(".")+1, ori_filenm.length());
    			String local_file_nm = System.currentTimeMillis() + "_" + filenm + "." + ext;
    			
    			if(Arrays.asList(allowExt).contains(ext.toLowerCase())) {
	    			if(input_name.equals("IMG0")) input_name = "IMG1";
	    			emfMap.put(input_name + "_PATH", img_path);
	    			emfMap.put(input_name + "_SAVE_FILE_NM", local_file_nm);
	    			emfMap.put(input_name + "_REAL_FILE_NM", filenm);
	    			try {
	    				EgovFileMngUtil.uploadFileImg(mf, img_path, local_file_nm);
	    			} catch (IOException e) {
						e.printStackTrace();
					}
    			}
    		}
    	}   	
		cOISnsMngDAO.insertSns(emfMap);
	}

	/**
	 * SNS 속성 정보를 수정한다.
	 */
	public void updateSns(EmfMap emfMap) throws Exception 
	{
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		if("L".equals(emfMap.getString("type")))
		{
			emfMap.put("LINK1", emfMap.getString("link0"));
			emfMap.put("LINK1_TYPE", emfMap.getString("link0Type"));
		}
		
		MultipartHttpServletRequest mReq = (MultipartHttpServletRequest) emfMap.get("request");
    	Iterator<String> iter = mReq.getFileNames();
    	MultipartFile mf = null;
    	
    	String[] allowExt = {"png", "gif", "jpg", "jpeg"};
    	
    	while(iter.hasNext()) {
    		String input_name = iter.next();
    		mf = mReq.getFile(input_name);
    		if(mf.isEmpty() == false) {
    			String ori_filenm = mf.getOriginalFilename();
    			String filenm = ori_filenm.substring(0, ori_filenm.lastIndexOf("."));
    			String ext = ori_filenm.substring(ori_filenm.lastIndexOf(".")+1, ori_filenm.length());
    			String local_file_nm = System.currentTimeMillis() + "_" + filenm + "." + ext;
    			
    			if(Arrays.asList(allowExt).contains(ext.toLowerCase())) {
	    			if(input_name.equals("IMG0")) input_name = "IMG1";
	    			emfMap.put(input_name + "_PATH", img_path);
	    			emfMap.put(input_name + "_SAVE_FILE_NM", local_file_nm);
	    			emfMap.put(input_name + "_REAL_FILE_NM", filenm);
	    			try {
	    				EgovFileMngUtil.uploadFileImg(mf, img_path, local_file_nm);
	    			} catch (IOException e) {
						e.printStackTrace();
					}
    			}
    		}
    	}   	
		cOISnsMngDAO.updateSns(emfMap);		
	}
	
	/**
	 * SNS 순서변경.
	 */
	public void orderSns(EmfMap emfMap) throws Exception 
	{  	
		cOISnsMngDAO.orderSns(emfMap);		
	}
	
	/**
	 * SNS 속성 정보를 삭제한다.
	 */
	public void deleteSns(EmfMap emfMap) throws Exception 
	{
		cOISnsMngDAO.deleteSns(emfMap);
	}
}