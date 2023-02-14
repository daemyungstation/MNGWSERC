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
import mngwserc.fair.service.FairProductDetailService;
import mngwserc.fair.service.dao.FairProductDetailDAO;

/**
 * <pre> 
 * 박람회 제품 상세 관리 Implement
 * </pre>
 * 
 * @ClassName		: FairProductDetailServiceImpl.java
 * @Description		: 박람회 제품 상세 관리 Implement
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

@Service("fairProductDetailService")
public class FairProductDetailServiceImpl extends EmfAbstractService implements FairProductDetailService {
	
	/** 서비스 **/
	@Resource(name="fairProductDetailDAO")
	private FairProductDetailDAO fairProductDetailDAO;
	
	/** SEQ **/
	@Resource(name="fairProductDetailIdgen")
    private EgovIdGnrService fairProductDetailIdgen;
	
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
		List<EmfMap> list = fairProductDetailDAO.selectList(emfMap);
		
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
		List<EmfMap> list = fairProductDetailDAO.select(emfMap);
		EmfMap row = new EmfMap();
		if(!list.isEmpty()) 
		{
			row = list.get(0);
		}
		return row;
	}
	
	/**
     * 파일업로드
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws Exception
     */
	public EmfMap fileUpload(EmfMap emfMap) throws Exception {
		//파일업로드
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
    			
    			emfMap.put("path", img_path);
    			emfMap.put("save", local_file_nm);
    			emfMap.put("real", filenm);
    			try {
    				EgovFileMngUtil.uploadFileImg(mf, img_path, local_file_nm);
    			} catch (IOException e) {
					e.printStackTrace();
				}
    		}
    	}
    	return emfMap;
	}
	
	/**
	 * 등록
	 */
	public void insert(EmfMap emfMap) throws Exception 
	{
		EmfMap lgnMap = (EmfMap)EgovUserDetailsHelper.getAuthenticatedUser();
		emfMap.put("regId", lgnMap.getString("id"));
		emfMap.put("regIp", lgnMap.getString("loginIp"));

		emfMap.put("FP_SEQ", fairProductDetailIdgen.getNextIntegerId());

		List<EmfMap> list = fairProductDetailDAO.selectMaxOrder();
		EmfMap oRow = new EmfMap();
		if(!list.isEmpty()) 
		{
			oRow = list.get(0);
			emfMap.put("FP_ORDER", oRow.get("fpOrder"));
		}
		else
		{
			emfMap.put("FP_ORDER", "1");
		}

		//input form 세팅
		String fpiInput = emfMap.getString("fpiInput");
		String fpInput = "{\"INPUT_SEQ\":\""+ emfMap.getString("fpiInputSeq") +"\",\"INPUT\":"+ fpiInput;
		
		String priceType = emfMap.getString("priceType");
		if(priceType.equals("G"))
		{
			fpInput += ",\"PRICE\": [{\"KEY\":\"-1\",\"VALUE\":\"-1\",\"PRICE\":\""+ emfMap.getString("fpGPrice") +"\"}]";
			String fpGProduct = emfMap.getString("fpGProduct").replace("&#34;",  "\"");
			fpInput += ",\"BENEFIT\": [{\"KEY\":\"-1\",\"VALUE\":\"-1\",\"BENEFIT\":["+ fpGProduct +"]}]";
		}
		
		if(priceType.equals("S"))
		{
			List<String> fpSPriceList = emfMap.getList("fpSPrice");
			fpInput += ",\"PRICE\":[";
			for(int i = 0; i < fpSPriceList.size(); i++)
			{
				String fpSPrice = fpSPriceList.get(i);
				if(i > 0)
				{
					fpInput += ",";
				}
				fpInput += "{\"KEY\":\""+ emfMap.getString("fiDelegate") +"\",\"VALUE\":\""+ i +"\",\"PRICE\":\""+ fpSPrice +"\"}";
			}
			fpInput += "]";
			
			List<String> fpSProductList = emfMap.getList("fpSProduct");
			fpInput += ",\"BENEFIT\":[";
			for(int i = 0; i < fpSProductList.size(); i++)
			{
				String fpSProduct = fpSProductList.get(i).replace("&#34;",  "\"");
				if(i > 0)
				{
					fpInput += ",";
				}
				fpInput += "{\"KEY\":\""+ emfMap.getString("fiDelegate") +"\",\"VALUE\":\""+ i +"\",\"BENEFIT\":["+ fpSProduct +"]}";
			}
			fpInput += "]";
		}
		fpInput += "}";
		emfMap.put("FP_INPUT", fpInput);

		//라벨 세팅
		List<String> fpLabelTitleList = emfMap.getList("fpLabelTitle");
		List<String> fpLabelBgcolor = emfMap.getList("fpLabelBgcolor");
		String fpLabel = "[";
		for(int i = 0; i < fpLabelTitleList.size(); i++)
		{
			if(fpLabelTitleList.get(i) != null && !fpLabelTitleList.get(i).isEmpty() && fpLabelBgcolor.get(i) != null && !fpLabelBgcolor.get(i).isEmpty())
			{
				if(!fpLabel.equals("[")) fpLabel += ","; 
				fpLabel += "{";
				fpLabel += "\"TITLE\":\""+ fpLabelTitleList.get(i) +"\",";
				fpLabel += "\"BGCOLOR\":\""+ fpLabelBgcolor.get(i) +"\"";
				fpLabel += "}";
			}
		}
		fpLabel += "]";
		emfMap.put("FP_LABEL", fpLabel);
		
		//파일업로드
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
    			
    			emfMap.put(input_name +"_PATH", img_path);
    			emfMap.put(input_name +"_SAVE_NM", local_file_nm);
    			emfMap.put(input_name +"_REAL_NM", filenm);

    			try {
    				EgovFileMngUtil.uploadFileImg(mf, img_path, local_file_nm);
    			} catch (IOException e) {
					e.printStackTrace();
				}
    		}
    	}
    	
    	//썸네일 세팅
    	List<String> fpThumnailWPath = emfMap.getList("thumnailWPath");
    	List<String> fpThumnailWSave = emfMap.getList("thumnailWSave");
    	List<String> fpThumnailWReal = emfMap.getList("thumnailWReal");
    	List<String> fpThumnailMPath = emfMap.getList("thumnailMPath");
    	List<String> fpThumnailMSave = emfMap.getList("thumnailMSave");
    	List<String> fpThumnailMReal = emfMap.getList("thumnailMReal");
		String fpThumnail = "[";
		for(int i = 0; i < fpThumnailWPath.size(); i++)
		{
			if(
				fpThumnailWPath.get(i) != null && !fpThumnailWPath.get(i).isEmpty() && 
				fpThumnailWSave.get(i) != null && !fpThumnailWSave.get(i).isEmpty() &&
				fpThumnailWReal.get(i) != null && !fpThumnailWReal.get(i).isEmpty() &&
				fpThumnailMPath.get(i) != null && !fpThumnailMPath.get(i).isEmpty() && 
				fpThumnailMSave.get(i) != null && !fpThumnailMSave.get(i).isEmpty() &&
				fpThumnailMReal.get(i) != null && !fpThumnailMReal.get(i).isEmpty())
			{
				if(!fpThumnail.equals("[")) fpThumnail += ","; 
				fpThumnail += "{";
				fpThumnail += "\"W_PATH\":\""+ fpThumnailWPath.get(i) +"\",\"W_SAVE_NM\":\""+ fpThumnailWSave.get(i) +"\",\"W_REAL_NM\":\""+ fpThumnailWReal.get(i) +"\",";
				fpThumnail += "\"M_PATH\":\""+ fpThumnailMPath.get(i) +"\",\"M_SAVE_NM\":\""+ fpThumnailMSave.get(i) +"\",\"M_REAL_NM\":\""+ fpThumnailMReal.get(i) +"\"";
				fpThumnail += "}";
			}
		}
		fpThumnail += "]";
		emfMap.put("FP_THUMNAIL", fpThumnail);

    	//상세 세팅
    	List<String> fpDetailTitleList = emfMap.getList("fpDetailTitle");
		List<String> fpDetailBgcolor = emfMap.getList("fpDetailBgcolor");
    	List<String> fpDetailBgPath = emfMap.getList("detailBgPath");
    	List<String> fpDetailBgSave = emfMap.getList("detailBgSave");
    	List<String> fpDetailBgReal = emfMap.getList("detailBgReal");
    	List<String> fpDetailWPath = emfMap.getList("detailWPath");
    	List<String> fpDetailWSave = emfMap.getList("detailWSave");
    	List<String> fpDetailWReal = emfMap.getList("detailWReal");
    	List<String> fpDetailMPath = emfMap.getList("detailMPath");
    	List<String> fpDetailMSave = emfMap.getList("detailMSave");
    	List<String> fpDetailMReal = emfMap.getList("detailMReal");
		String fpDetail = "[";
		for(int i = 0; i < fpDetailTitleList.size(); i++)
		{
			if(
				fpDetailTitleList.get(i) != null && !fpDetailTitleList.get(i).isEmpty() && 
				fpDetailWPath.get(i) != null && !fpDetailWPath.get(i).isEmpty() && 
				fpDetailWSave.get(i) != null && !fpDetailWSave.get(i).isEmpty() &&
				fpDetailWReal.get(i) != null && !fpDetailWReal.get(i).isEmpty() &&
				fpDetailMPath.get(i) != null && !fpDetailMPath.get(i).isEmpty() && 
				fpDetailMSave.get(i) != null && !fpDetailMSave.get(i).isEmpty() &&
				fpDetailMReal.get(i) != null && !fpDetailMReal.get(i).isEmpty())
			{
				if(!fpDetail.equals("[")) fpDetail += ",";
				fpDetail += "{";
				fpDetail += "\"TITLE\":\""+ fpDetailTitleList.get(i) +"\",";
				if(fpDetailBgcolor.get(i) != null && !fpDetailBgcolor.get(i).isEmpty())
				{
					fpDetail += "\"BGCOLOR\":\""+ fpDetailBgcolor.get(i) +"\",";
				}
				else
				{
					fpDetail += "\"BGCOLOR\":\"\",";
				}
				if(
					fpDetailBgPath.get(i) != null && !fpDetailBgPath.get(i).isEmpty() && 
					fpDetailBgSave.get(i) != null && !fpDetailBgSave.get(i).isEmpty() &&
					fpDetailBgReal.get(i) != null && !fpDetailBgReal.get(i).isEmpty()
				) {
					fpDetail += "\"BG_PATH\":\""+ fpDetailBgPath.get(i) +"\",\"BG_SAVE_NM\":\""+ fpDetailBgSave.get(i) +"\",\"BG_REAL_NM\":\""+ fpDetailBgReal.get(i) +"\",";
				}
				else
				{
					fpDetail += "\"BG_PATH\":\"\",\"BG_SAVE_NM\":\"\",\"BG_REAL_NM\":\"\",";
				}
				fpDetail += "\"W_PATH\":\""+ fpDetailWPath.get(i) +"\",\"W_SAVE_NM\":\""+ fpDetailWSave.get(i) +"\",\"W_REAL_NM\":\""+ fpDetailWReal.get(i) +"\",";
				fpDetail += "\"M_PATH\":\""+ fpDetailMPath.get(i) +"\",\"M_SAVE_NM\":\""+ fpDetailMSave.get(i) +"\",\"M_REAL_NM\":\""+ fpDetailMReal.get(i) +"\"";
				fpDetail += "}";
			}
		}
		fpDetail += "]";
		emfMap.put("FP_DETAIL", fpDetail);
		
    	fairProductDetailDAO.insert(emfMap);
	}

	/**
	 * 수정
	 */
	public void update(EmfMap emfMap) throws Exception 
	{
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		//input form 세팅
		String fpiInput = emfMap.getString("fpiInputExists").replace("&#34;",  "\"");
		String fpInput = "{\"INPUT_SEQ\":\""+ emfMap.getString("fpiInputSeq") +"\",\"INPUT\":"+ fpiInput;
		
		String priceType = emfMap.getString("priceType");
		if(priceType.equals("G"))
		{
			fpInput += ",\"PRICE\": [{\"KEY\":\"-1\",\"VALUE\":\"-1\",\"PRICE\":\""+ emfMap.getString("fpGPrice") +"\"}]";
			String fpGProduct = emfMap.getString("fpGProduct").replace("&#34;",  "\"");
			fpInput += ",\"BENEFIT\": [{\"KEY\":\"-1\",\"VALUE\":\"-1\",\"BENEFIT\":["+ fpGProduct +"]}]";
		}
		
		if(priceType.equals("S"))
		{
			List<String> fpSPriceList = emfMap.getList("fpSPrice");
			fpInput += ",\"PRICE\":[";
			for(int i = 0; i < fpSPriceList.size(); i++)
			{
				String fpSPrice = fpSPriceList.get(i);
				if(i > 0)
				{
					fpInput += ",";
				}
				fpInput += "{\"KEY\":\""+ emfMap.getString("fiDelegate") +"\",\"VALUE\":\""+ i +"\",\"PRICE\":\""+ fpSPrice +"\"}";
			}
			fpInput += "]";
			
			List<String> fpSProductList = emfMap.getList("fpSProduct");
			fpInput += ",\"BENEFIT\":[";
			for(int i = 0; i < fpSProductList.size(); i++)
			{
				String fpSProduct = fpSProductList.get(i).replace("&#34;",  "\"");
				if(i > 0)
				{
					fpInput += ",";
				}
				fpInput += "{\"KEY\":\""+ emfMap.getString("fiDelegate") +"\",\"VALUE\":\""+ i +"\",\"BENEFIT\":["+ fpSProduct +"]}";
			}
			fpInput += "]";
		}
		fpInput += "}";
		emfMap.put("FP_INPUT", fpInput);

		//라벨 세팅
		List<String> fpLabelTitleList = emfMap.getList("fpLabelTitle");
		List<String> fpLabelBgcolor = emfMap.getList("fpLabelBgcolor");
		String fpLabel = "[";
		for(int i = 0; i < fpLabelTitleList.size(); i++)
		{
			if(fpLabelTitleList.get(i) != null && !fpLabelTitleList.get(i).isEmpty() && fpLabelBgcolor.get(i) != null && !fpLabelBgcolor.get(i).isEmpty())
			{
				if(!fpLabel.equals("[")) fpLabel += ","; 
				fpLabel += "{";
				fpLabel += "\"TITLE\":\""+ fpLabelTitleList.get(i) +"\",";
				fpLabel += "\"BGCOLOR\":\""+ fpLabelBgcolor.get(i) +"\"";
				fpLabel += "}";
			}
		}
		fpLabel += "]";
		emfMap.put("FP_LABEL", fpLabel);
		
		//파일업로드
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
    			
    			emfMap.put(input_name +"_PATH", img_path);
    			emfMap.put(input_name +"_SAVE_NM", local_file_nm);
    			emfMap.put(input_name +"_REAL_NM", filenm);

    			try {
    				EgovFileMngUtil.uploadFileImg(mf, img_path, local_file_nm);
    			} catch (IOException e) {
					e.printStackTrace();
				}
    		}
    	}
    	
    	//썸네일 세팅
    	List<String> fpThumnailWPath = emfMap.getList("thumnailWPath");
    	List<String> fpThumnailWSave = emfMap.getList("thumnailWSave");
    	List<String> fpThumnailWReal = emfMap.getList("thumnailWReal");
    	List<String> fpThumnailMPath = emfMap.getList("thumnailMPath");
    	List<String> fpThumnailMSave = emfMap.getList("thumnailMSave");
    	List<String> fpThumnailMReal = emfMap.getList("thumnailMReal");
		String fpThumnail = "[";
		for(int i = 0; i < fpThumnailWPath.size(); i++)
		{
			if(
				fpThumnailWPath.get(i) != null && !fpThumnailWPath.get(i).isEmpty() && 
				fpThumnailWSave.get(i) != null && !fpThumnailWSave.get(i).isEmpty() &&
				fpThumnailWReal.get(i) != null && !fpThumnailWReal.get(i).isEmpty() &&
				fpThumnailMPath.get(i) != null && !fpThumnailMPath.get(i).isEmpty() && 
				fpThumnailMSave.get(i) != null && !fpThumnailMSave.get(i).isEmpty() &&
				fpThumnailMReal.get(i) != null && !fpThumnailMReal.get(i).isEmpty())
			{
				if(!fpThumnail.equals("[")) fpThumnail += ","; 
				fpThumnail += "{";
				fpThumnail += "\"W_PATH\":\""+ fpThumnailWPath.get(i) +"\",\"W_SAVE_NM\":\""+ fpThumnailWSave.get(i) +"\",\"W_REAL_NM\":\""+ fpThumnailWReal.get(i) +"\",";
				fpThumnail += "\"M_PATH\":\""+ fpThumnailMPath.get(i) +"\",\"M_SAVE_NM\":\""+ fpThumnailMSave.get(i) +"\",\"M_REAL_NM\":\""+ fpThumnailMReal.get(i) +"\"";
				fpThumnail += "}";
			}
		}
		fpThumnail += "]";
		emfMap.put("FP_THUMNAIL", fpThumnail);

    	//상세 세팅
    	List<String> fpDetailTitleList = emfMap.getList("fpDetailTitle");
		List<String> fpDetailBgcolor = emfMap.getList("fpDetailBgcolor");
    	List<String> fpDetailBgPath = emfMap.getList("detailBgPath");
    	List<String> fpDetailBgSave = emfMap.getList("detailBgSave");
    	List<String> fpDetailBgReal = emfMap.getList("detailBgReal");
    	List<String> fpDetailWPath = emfMap.getList("detailWPath");
    	List<String> fpDetailWSave = emfMap.getList("detailWSave");
    	List<String> fpDetailWReal = emfMap.getList("detailWReal");
    	List<String> fpDetailMPath = emfMap.getList("detailMPath");
    	List<String> fpDetailMSave = emfMap.getList("detailMSave");
    	List<String> fpDetailMReal = emfMap.getList("detailMReal");
		String fpDetail = "[";
		for(int i = 0; i < fpDetailTitleList.size(); i++)
		{
			if(
					fpDetailTitleList.get(i) != null && !fpDetailTitleList.get(i).isEmpty() && 
					fpDetailWPath.get(i) != null && !fpDetailWPath.get(i).isEmpty() && 
					fpDetailWSave.get(i) != null && !fpDetailWSave.get(i).isEmpty() &&
					fpDetailWReal.get(i) != null && !fpDetailWReal.get(i).isEmpty() &&
					fpDetailMPath.get(i) != null && !fpDetailMPath.get(i).isEmpty() && 
					fpDetailMSave.get(i) != null && !fpDetailMSave.get(i).isEmpty() &&
					fpDetailMReal.get(i) != null && !fpDetailMReal.get(i).isEmpty())
				{
					if(!fpDetail.equals("[")) fpDetail += ",";
					fpDetail += "{";
					fpDetail += "\"TITLE\":\""+ fpDetailTitleList.get(i) +"\",";
					if(fpDetailBgcolor.get(i) != null && !fpDetailBgcolor.get(i).isEmpty())
					{
						fpDetail += "\"BGCOLOR\":\""+ fpDetailBgcolor.get(i) +"\",";
					}
					else
					{
						fpDetail += "\"BGCOLOR\":\"\",";
					}
					if(
						fpDetailBgPath.get(i) != null && !fpDetailBgPath.get(i).isEmpty() && 
						fpDetailBgSave.get(i) != null && !fpDetailBgSave.get(i).isEmpty() &&
						fpDetailBgReal.get(i) != null && !fpDetailBgReal.get(i).isEmpty()
					) {
						fpDetail += "\"BG_PATH\":\""+ fpDetailBgPath.get(i) +"\",\"BG_SAVE_NM\":\""+ fpDetailBgSave.get(i) +"\",\"BG_REAL_NM\":\""+ fpDetailBgReal.get(i) +"\",";
					}
					else
					{
						fpDetail += "\"BG_PATH\":\"\",\"BG_SAVE_NM\":\"\",\"BG_REAL_NM\":\"\",";
					}
					fpDetail += "\"W_PATH\":\""+ fpDetailWPath.get(i) +"\",\"W_SAVE_NM\":\""+ fpDetailWSave.get(i) +"\",\"W_REAL_NM\":\""+ fpDetailWReal.get(i) +"\",";
					fpDetail += "\"M_PATH\":\""+ fpDetailMPath.get(i) +"\",\"M_SAVE_NM\":\""+ fpDetailMSave.get(i) +"\",\"M_REAL_NM\":\""+ fpDetailMReal.get(i) +"\"";
					fpDetail += "}";
				}
		}
		fpDetail += "]";
		emfMap.put("FP_DETAIL", fpDetail);
		
    	fairProductDetailDAO.update(emfMap);		
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
			emfMap.put("fpOrder", fOrder);
			emfMap.put("fpSeq", Integer.parseInt(seq));
			
			fairProductDetailDAO.order(emfMap);
	    	fOrder++;
		}		
	}
	
	/**
	 * 복사 
	 */
	public int copy(EmfMap emfMap) throws Exception 
	{
		List<EmfMap> list = fairProductDetailDAO.select(emfMap);
		EmfMap row = new EmfMap();
		if(!list.isEmpty()) 
		{
			EmfMap lgnMap = (EmfMap)EgovUserDetailsHelper.getAuthenticatedUser();
			emfMap.put("regId", lgnMap.getString("id"));
			emfMap.put("regIp", lgnMap.getString("loginIp"));
			
			int seq = fairProductDetailIdgen.getNextIntegerId();
			emfMap.put("FP_SEQ", seq);
			
			List<EmfMap> olist = fairProductDetailDAO.selectMaxOrder();
			EmfMap oRow = new EmfMap();
			if(!olist.isEmpty()) 
			{
				oRow = olist.get(0);
				emfMap.put("FP_ORDER", oRow.get("fpOrder"));
			}
			else
			{
				emfMap.put("FP_ORDER", "1");
			}

			row = list.get(0);
			emfMap.put("FP_MAIN_IMAGE_BG_PATH", row.getString("fpMainImageBgPath"));
			emfMap.put("FP_MAIN_IMAGE_BG_SAVE_NM", row.getString("fpMainImageBgSaveNm"));
			emfMap.put("FP_MAIN_IMAGE_BG_REAL_NM", row.getString("fpMainImageBgRealNm"));
			emfMap.put("FP_MAIN_IMAGE_W_PATH", row.getString("fpMainImageWPath"));
			emfMap.put("FP_MAIN_IMAGE_W_SAVE_NM", row.getString("fpMainImageWSaveNm"));
			emfMap.put("FP_MAIN_IMAGE_W_REAL_NM", row.getString("fpMainImageWRealNm"));
			emfMap.put("FP_MAIN_IMAGE_M_PATH", row.getString("fpMainImageMPath"));
			emfMap.put("FP_MAIN_IMAGE_M_SAVE_NM", row.getString("fpMainImageMSaveNm"));
			emfMap.put("FP_MAIN_IMAGE_M_REAL_NM", row.getString("fpMainImageMRealNm"));
			emfMap.put("FP_MAIN_TITLE", row.getString("fpMainTitle") +"-복사본");
			emfMap.put("FP_MAIN_SUBTITLE", row.getString("fpMainSubtitle"));
			emfMap.put("FP_MAIN_DESC", row.getString("fpMainDesc"));
			emfMap.put("FP_INPUT", row.getString("fpInput"));
			emfMap.put("FP_LABEL", row.getString("fpLabel"));
			emfMap.put("FP_THUMNAIL", row.getString("fpThumnail"));
			emfMap.put("FP_DETAIL", row.getString("fpDetail"));
			emfMap.put("FP_STIME", row.getString("fpStime"));
			emfMap.put("FP_ETIME", row.getString("fpEtime"));
			emfMap.put("FP_STATUS", row.getString("fpStatus"));
			emfMap.put("FAIR_CATEGORY_FC_SEQ", row.getString("fairCategoryFcSeq"));

			fairProductDetailDAO.insert(emfMap);
			
			return seq;
		}
		else
		{
			return 0;
		}
	}
	
	/**
	 * 삭제
	 */
	public void delete(EmfMap emfMap) throws Exception 
	{
		fairProductDetailDAO.delete(emfMap);
	}
	
	/**
     * 카테고리 조회
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws Exception
     */
	public List<EmfMap> selectCate() throws Exception {
		return fairProductDetailDAO.selectCate();
	}
	
	/**
     * 입력폼 조회
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws Exception
     */
	public List<EmfMap> selectInput() throws Exception {
		return fairProductDetailDAO.selectInput();
	}
	
	/**
     * 카테고리 조회
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws Exception
     */
	public List<EmfMap> selectBenefit() throws Exception {
		return fairProductDetailDAO.selectBenefit();
	}
}