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
import mngwserc.fair.service.FairMainService;
import mngwserc.fair.service.dao.FairMainDAO;

/**
 * <pre> 
 * 박람회 소구포인트 관리 Implement
 * </pre>
 * 
 * @ClassName		: FairMainServiceImpl.java
 * @Description		: 박람회 소구포인트 관리 Implement
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

@Service("fairMainService")
public class FairMainServiceImpl extends EmfAbstractService implements FairMainService {
	
	/** 서비스 **/
	@Resource(name="fairMainDAO")
	private FairMainDAO fairMainDAO;
	
	/** SEQ **/
	@Resource(name="fairMainIdgen")
    private EgovIdGnrService fairMainIdgen;
	
	/** SUB SEQ **/
	@Resource(name="fairMainSubIdgen")
    private EgovIdGnrService fairMainSubIdgen;
	
	private final static String img_path = EgovProperties.getProperty("Globals.fairImagesPath");
	
	/**
     * 목록 조회
     * 
     * @param
	 * @return EmfMap
	 * @throws Exception
     */
	public EmfMap select() throws Exception {
		List<EmfMap> List = fairMainDAO.select();
		EmfMap Row = new EmfMap();
		if(!List.isEmpty()) 
		{
			Row = List.get(0);
		}
		return Row;
	}
	
	/**
     * 업데이트
     * 
     * @param
	 * @return EmfMap
	 * @throws Exception
     */
	public void update(EmfMap emfMap) throws Exception {
		List<EmfMap> configList = fairMainDAO.select();
		EmfMap Row = new EmfMap();
		
		EmfMap lgnMap = (EmfMap)EgovUserDetailsHelper.getAuthenticatedUser();

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
    	
		if(configList.isEmpty())
		{
			emfMap.put("FM_SEQ", fairMainIdgen.getNextIntegerId());
			emfMap.put("regId", lgnMap.getString("id"));
			emfMap.put("regIp", lgnMap.getString("loginIp"));

			fairMainDAO.insert(emfMap);
		}else 
		{
			Row = configList.get(0);
			emfMap.put("FM_SEQ", Row.get("fmSeq"));
			emfMap.put("modId", lgnMap.getString("id"));
			emfMap.put("modIp", lgnMap.getString("loginIp"));
		
			fairMainDAO.update(emfMap);
		}
	}
	
	/**
     * 서브 목록 조회
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws Exception
     */
	public EmfMap selectSubList(EmfMap emfMap) throws Exception {

		PaginationInfo paginationInfo = COPaginationUtil.getPage(emfMap);
		
		//페이징 처리
		emfMap.put("paginationInfo", paginationInfo);    

		//리스트 가져오기
		List<EmfMap> list = fairMainDAO.selectSubList(emfMap);
		
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
     * 서브 상세 조회
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws Exception
     */
	public EmfMap selectSub(EmfMap emfMap) throws Exception {

		//리스트 가져오기
		List<EmfMap> list = fairMainDAO.selectSub(emfMap);
		EmfMap row = new EmfMap();
		if(!list.isEmpty()) 
		{
			row = list.get(0);
		}
		return row;
	}
	
	/**
	 * 서브 등록
	 */
	public void subInsert(EmfMap emfMap) throws Exception 
	{
		
		EmfMap lgnMap = (EmfMap)EgovUserDetailsHelper.getAuthenticatedUser();
		emfMap.put("regId", lgnMap.getString("id"));
		emfMap.put("regIp", lgnMap.getString("loginIp"));

		emfMap.put("FMS_SEQ", fairMainSubIdgen.getNextIntegerId());

		List<EmfMap> list = fairMainDAO.selectSubMaxOrder();
		EmfMap oRow = new EmfMap();
		if(!list.isEmpty()) 
		{
			oRow = list.get(0);
			emfMap.put("FMS_ORDER", oRow.get("fmsOrder"));
		}
		else
		{
			emfMap.put("FMS_ORDER", "1");
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
    	fairMainDAO.subInsert(emfMap);
	}

	/**
	 * 서브 수정
	 */
	public void subUpdate(EmfMap emfMap) throws Exception 
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
    	fairMainDAO.subUpdate(emfMap);		
	}
	
	/**
	 * 서브 순서변경
	 */
	public void subOrder(EmfMap emfMap) throws Exception 
	{
		int fOrder = Integer.parseInt(emfMap.getString("fOrder"));
		String[] arySeq = emfMap.getString("seq").split(",");
		for(String seq : arySeq)
		{
			emfMap.put("fmsOrder", fOrder);
			emfMap.put("fmsSeq", Integer.parseInt(seq));
			
			fairMainDAO.subOrder(emfMap);
	    	fOrder++;
		}		
	}
	
	/**
	 * 삭제
	 */
	public void subDelete(EmfMap emfMap) throws Exception 
	{
		fairMainDAO.subDelete(emfMap);
	}
}