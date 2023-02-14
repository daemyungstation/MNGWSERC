package mngwserc.fair.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.codehaus.jackson.map.ObjectMapper;
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
import mngwserc.fair.service.FairProductBenefitService;
import mngwserc.fair.service.dao.FairProductBenefitDAO;

/**
 * <pre> 
 * 박람회 제품 결합상품 관리 Implement
 * </pre>
 * 
 * @ClassName		: FairProductBenefitServiceImpl.java
 * @Description		: 박람회 제품 결합상품 관리 Implement
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

@Service("fairProductBenefitService")
public class FairProductBenefitServiceImpl extends EmfAbstractService implements FairProductBenefitService {
	
	/** 서비스 **/
	@Resource(name="fairProductBenefitDAO")
	private FairProductBenefitDAO fairProductBenefitDAO;
	
	/** SEQ **/
	@Resource(name="fairProductBenefitIdgen")
    private EgovIdGnrService fairProductBenefitIdgen;
	
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
		List<EmfMap> list = fairProductBenefitDAO.selectList(emfMap);
		
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
		List<EmfMap> list = fairProductBenefitDAO.select(emfMap);
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

		emfMap.put("FB_SEQ", fairProductBenefitIdgen.getNextIntegerId());

		List<EmfMap> list = fairProductBenefitDAO.selectMaxOrder();
		EmfMap oRow = new EmfMap();
		if(!list.isEmpty()) 
		{
			oRow = list.get(0);
			emfMap.put("FB_ORDER", oRow.get("fbOrder"));
		}
		else
		{
			emfMap.put("FB_ORDER", "1");
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
    	fairProductBenefitDAO.insert(emfMap);
	}

	/**
	 * 수정
	 */
	public EmfMap update(EmfMap emfMap) throws Exception 
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
    	fairProductBenefitDAO.update(emfMap);
    	return emfMap;
	}
	
	/**
	 * 상품 내용 수정
	 */
	public void updateProduct(EmfMap emfMap) throws Exception
	{
		fairProductBenefitDAO.updateProduct(emfMap);
	}
	
	
	/**
	 * 복사 
	 */
	public int copy(EmfMap emfMap) throws Exception 
	{
		List<EmfMap> list = fairProductBenefitDAO.select(emfMap);
		EmfMap row = new EmfMap();
		if(!list.isEmpty()) 
		{
			EmfMap lgnMap = (EmfMap)EgovUserDetailsHelper.getAuthenticatedUser();
			emfMap.put("regId", lgnMap.getString("id"));
			emfMap.put("regIp", lgnMap.getString("loginIp"));
			
			int seq = fairProductBenefitIdgen.getNextIntegerId();
			emfMap.put("FB_SEQ", seq);
			
			List<EmfMap> olist = fairProductBenefitDAO.selectMaxOrder();
			EmfMap oRow = new EmfMap();
			if(!olist.isEmpty()) 
			{
				oRow = olist.get(0);
				emfMap.put("FB_ORDER", oRow.get("fbOrder"));
			}
			else
			{
				emfMap.put("FB_ORDER", "1");
			}
			
			row = list.get(0);
			emfMap.put("FB_IMAGE_W_PATH", row.getString("fbImageWPath"));
			emfMap.put("FB_IMAGE_W_SAVE_NM", row.getString("fbImageWSaveNm"));
			emfMap.put("FB_IMAGE_W_REAL_NM", row.getString("fbImageWRealNm"));
			emfMap.put("FB_IMAGE_M_PATH", row.getString("fbImageMPath"));
			emfMap.put("FB_IMAGE_M_SAVE_NM", row.getString("fbImageMSaveNm"));
			emfMap.put("FB_IMAGE_M_REAL_NM", row.getString("fbImageMRealNm"));
			emfMap.put("FB_TITLE", row.getString("fbTitle") +"-복사본");
			emfMap.put("FB_SUBTITLE", row.getString("fbSubtitle"));
			emfMap.put("FB_MODEL", row.getString("fbModel"));
			emfMap.put("FB_PRICE", row.getString("fbPrice"));
			emfMap.put("FB_USER_TARGET", row.getString("fbUserTarget"));
			emfMap.put("FB_PRODUCT_TARGET", row.getString("fbProductTarget"));
			emfMap.put("FB_STIME", row.getString("fbStime"));
			emfMap.put("FB_ETIME", row.getString("fbEtime"));
			emfMap.put("FB_STATUS", row.getString("fbStatus"));
			
			fairProductBenefitDAO.insert(emfMap);
			
			return seq;
		}
		else
		{
			return 0;
		}
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
			emfMap.put("fbOrder", fOrder);
			emfMap.put("fbSeq", Integer.parseInt(seq));
			
			fairProductBenefitDAO.order(emfMap);
	    	fOrder++;
		}		
	}
	
	/**
	 * 삭제
	 */
	public void delete(EmfMap emfMap) throws Exception 
	{
		fairProductBenefitDAO.delete(emfMap);
	}
}