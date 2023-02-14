package mngwserc.fair.service.impl;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import egovframework.com.cmm.service.EgovFileMngUtil;
import egovframework.com.cmm.service.EgovProperties;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import emf.core.extend.service.EmfAbstractService;
import emf.core.vo.EmfMap;
import mngwserc.co.util.COPaginationUtil;
import mngwserc.fair.service.FairProductCategoryService;
import mngwserc.fair.service.dao.FairProductCategoryDAO;

/**
 * <pre> 
 * 박람회 제품 카테고리 관리 Implement
 * </pre>
 * 
 * @ClassName		: FairProductCategoryServiceImpl.java
 * @Description		: 박람회 제품 카테고리 관리 Implement
 * @author inuscommunity
 * @since 2019. 10. 23.
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 	    since			author	               description
 *  ============    ==============    =============================
 *  2019. 10. 23.	   inuscomm                 최초생성
 * </pre>
 */

@Service("fairProductCategoryService")
public class FairProductCategoryServiceImpl extends EmfAbstractService implements FairProductCategoryService {
	
	/** 서비스 **/
	@Resource(name="fairProductCategoryDAO")
	private FairProductCategoryDAO fairProductCategoryDAO;
	
	/** SEQ **/
	@Resource(name="fairProductCategoryIdgen")
    private EgovIdGnrService fairProductCategoryIdgen;
	
	private final static String img_path = EgovProperties.getProperty("Globals.fairImagesPath");
	
	/**
     * 목록 조회
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws Exception
     */
	public EmfMap selectList(EmfMap emfMap) throws Exception {

		PaginationInfo paginationInfo = COPaginationUtil.getPage(emfMap);
		
		//페이징 처리
		emfMap.put("paginationInfo", paginationInfo);    

		//리스트 가져오기
		List<EmfMap> list = fairProductCategoryDAO.selectList(emfMap);
		
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
     * 상세 조회
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws Exception
     */
	public EmfMap select(EmfMap emfMap) throws Exception {

		//리스트 가져오기
		List<EmfMap> list = fairProductCategoryDAO.select(emfMap);
		EmfMap row = new EmfMap();
		if(!list.isEmpty()) 
		{
			row = list.get(0);
		}
		return row;
	}
	
	/**
	 * 등록
	 */
	public void insert(EmfMap emfMap) throws Exception 
	{
		
		EmfMap lgnMap = (EmfMap)EgovUserDetailsHelper.getAuthenticatedUser();
		emfMap.put("regId", lgnMap.getString("id"));
		emfMap.put("regIp", lgnMap.getString("loginIp"));

		emfMap.put("FC_SEQ", fairProductCategoryIdgen.getNextIntegerId());

		List<EmfMap> list = fairProductCategoryDAO.selectMaxOrder();
		EmfMap oRow = new EmfMap();
		if(!list.isEmpty()) 
		{
			oRow = list.get(0);
			emfMap.put("FC_ORDER", oRow.get("fcOrder"));
		}
		else
		{
			emfMap.put("FC_ORDER", "1");
		}
		
		MultipartHttpServletRequest mReq = (MultipartHttpServletRequest) emfMap.get("request");
    	Iterator<String> iter = mReq.getFileNames();
    	MultipartFile mf = null;
    	while(iter.hasNext()) {
    		String input_name = iter.next();
    		mf = mReq.getFile(input_name);
    		if(mf.isEmpty() == false) {
    			String ori_filenm = mf.getOriginalFilename();
    			String filenm = ori_filenm.substring(0, ori_filenm.lastIndexOf("."));
    			String ext = ori_filenm.substring(ori_filenm.lastIndexOf(".")+1, ori_filenm.length());
    			String local_file_nm = System.currentTimeMillis() + "_" + UUID.randomUUID().toString().substring(0, 5) + "." + ext;
    			
    			emfMap.put(input_name + "_PATH", img_path);
    			emfMap.put(input_name + "_SAVE_NM", local_file_nm);
    			emfMap.put(input_name + "_REAL_NM", filenm);
    			try {
    				EgovFileMngUtil.uploadFileImg(mf, img_path, local_file_nm);
    			} catch (IOException e) {
					e.printStackTrace();
				}
    		}
    	}   	
    	fairProductCategoryDAO.insert(emfMap);
	}

	/**
	 * 수정
	 */
	public void update(EmfMap emfMap) throws Exception 
	{
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		MultipartHttpServletRequest mReq = (MultipartHttpServletRequest) emfMap.get("request");
    	Iterator<String> iter = mReq.getFileNames();
    	MultipartFile mf = null;
    	while(iter.hasNext()) {
    		String input_name = iter.next();
    		mf = mReq.getFile(input_name);
    		if(mf.isEmpty() == false) {
    			String ori_filenm = mf.getOriginalFilename();
    			String filenm = ori_filenm.substring(0, ori_filenm.lastIndexOf("."));
    			String ext = ori_filenm.substring(ori_filenm.lastIndexOf(".")+1, ori_filenm.length());
    			String local_file_nm = System.currentTimeMillis() + "_" + UUID.randomUUID().toString().substring(0, 5) + "." + ext;
    			
    			emfMap.put(input_name + "_PATH", img_path);
    			emfMap.put(input_name + "_SAVE_NM", local_file_nm);
    			emfMap.put(input_name + "_REAL_NM", filenm);
    			try {
    				EgovFileMngUtil.uploadFileImg(mf, img_path, local_file_nm);
    			} catch (IOException e) {
					e.printStackTrace();
				}
    		}
    	}    	
    	fairProductCategoryDAO.update(emfMap);		
	}
	
	/**
	 * 순서변경
	 */
	public void order(EmfMap emfMap) throws Exception 
	{
		int fOrder = Integer.parseInt(emfMap.getString("fOrder"));
		String[] arySeq = emfMap.getString("seq").split(",");
		for(String seq : arySeq)
		{
			emfMap.put("fcOrder", fOrder);
			emfMap.put("fcSeq", Integer.parseInt(seq));
			
			fairProductCategoryDAO.order(emfMap);
	    	fOrder++;
		}		
	}
	
	/**
	 * 삭제
	 */
	public void delete(EmfMap emfMap) throws Exception 
	{
		fairProductCategoryDAO.delete(emfMap);
	}
}