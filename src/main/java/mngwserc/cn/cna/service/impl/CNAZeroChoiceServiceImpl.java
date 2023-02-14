package mngwserc.cn.cna.service.impl;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import egovframework.com.cmm.service.EgovFileMngUtil;
import egovframework.com.cmm.service.EgovProperties;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.idgnr.impl.EgovTableIdGnrService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import emf.core.extend.service.EmfAbstractService;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;
import mngwserc.cn.cna.GetAllMapValue;
import mngwserc.cn.cna.service.CNAZeroChoiceService;
import mngwserc.cn.cna.service.dao.CNAZeroChoiceDAO;
import mngwserc.co.util.COPaginationUtil;

/**
 * <pre> 
 * 제로초이스를 위한 ServiceImpl
 * </pre>
 * 
 * @ClassName		: CNAZeroChoiceServiceImpl.java
 * @Description		: 제로초이스를 위한 ServiceImpl
 * @author 허진영
 * @since 2018.03.05
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2018.03.05		허진영					 최초생성
 * </pre>
 */ 
@Service("cNAZeroChoiceService")
public class CNAZeroChoiceServiceImpl extends EmfAbstractService implements CNAZeroChoiceService {

	@Resource(name="cNAZeroChoiceDAO")
	private CNAZeroChoiceDAO cNAZeroChoiceDAO;
	
	@Resource(name="zeroChoiPrdMgrIdgen")
	private EgovTableIdGnrService zeroChoiPrdMgrIdgen;	
	
	@Resource(name="zeroChoiImgMgrIdgen")
	private EgovTableIdGnrService zeroChoiImgMgrIdgen;	
	
	@Resource(name="zeroChoiFileIdgen")
	private EgovTableIdGnrService zeroChoiFileIdgen;	
	
	private final static String img_path = EgovProperties.getProperty("Globals.imageStorePath");
	/**
	 * 제로초이스 카테고리 관리 메뉴 리스트를 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return List<EmfMap> 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> getZeroChoiCateList(EmfMap emfMap)  throws Exception {
		return cNAZeroChoiceDAO.getZeroChoiCateList(emfMap);
	}

	/**
	 * 제로초이스 카테고리 관리 메뉴 리스트를 등록한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return List<EmfMap> 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
//	public int insertCateMenu(EmfMap emfMap) throws Exception {
	public void icm(EmfMap emfMap) throws Exception {
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("regId", lgnMap.getString("id"));
		emfMap.put("regIp", lgnMap.getString("loginIp"));
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		cNAZeroChoiceDAO.insertCateMenu(emfMap);
	}

	/**
	 * 제로초이스 카테고리 관리 메뉴 리스트를 변경한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return List<EmfMap> 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public int ucmn(EmfMap emfMap) throws Exception {
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		GetAllMapValue.getMapValue(emfMap);
		
		return cNAZeroChoiceDAO.updateCateMenuNm(emfMap);
	}

	/**
	 * 상품 관리 목록을 조회한다.
	 * 
	 * @param EmfMap
	 * @return EmfMap
	 * @throws Exception 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */ 
	@Override
	public EmfMap selectZeroChoiPrdMgrList(EmfMap emfMap) throws Exception {
		PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
		
		//페이징 처리
		emfMap.put("paginationInfo", paginationInfo);    	
		
		//리스트 가져오기
		List<EmfMap> list = cNAZeroChoiceDAO.selectZeroChoiPrdMgrList(emfMap);
		
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
	 * 이미지 관리 목록을 조회한다.
	 * 
	 * @param EmfMap
	 * @return EmfMap
	 * @throws Exception 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */ 
	@Override
	public EmfMap selectZeroChoiImgMgrList(EmfMap emfMap) throws Exception {
		PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
		
		//페이징 처리
		emfMap.put("paginationInfo", paginationInfo);    	
		
		//리스트 가져오기
		List<EmfMap> list = cNAZeroChoiceDAO.selectZeroChoiImgMgrList(emfMap);
		
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
     * 상품관리 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@Override
	public EmfMap selectZeroChoisePrdMgr(EmfMap emfMap) throws Exception {
		
		if(!"".equals(EMFStringUtil.nullConvert(emfMap.get("seq"))))
    	{
			EmfMap prdMgrInfo = cNAZeroChoiceDAO.selectZeroChoisePrdMgr(emfMap);
			
	    	if(prdMgrInfo != null)
	    	{
	    		emfMap.put("prdMgrInfo", prdMgrInfo);
	    		
	    		emfMap.put("using", "spec");
	    		List<EmfMap> prdSpecImgList = cNAZeroChoiceDAO.selectZeroChoiseFileInfo(emfMap);
	    		
	    		if(prdSpecImgList.size() > 0) {
	    			emfMap.put("prdSpecImgList", prdSpecImgList);
	    		}
	    		
	    		emfMap.put("using", "prd");
	    		List<EmfMap> prdImgList = cNAZeroChoiceDAO.selectZeroChoiseFileInfo(emfMap);
	    		
	    		if(prdImgList.size() > 0) {
	    			emfMap.put("prdImgList", prdImgList);
	    		}
	    		
	    		EmfMap prdImgCnt = cNAZeroChoiceDAO.selectZeroChoiseImgContainerCnt(emfMap);
	    		emfMap.put("prdImgCnt", prdImgCnt);
	    	}
    	}
		
		return emfMap;
	}

    /**
     * 이미지 관리 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@Override
	public EmfMap selectZeroChoiImgMgr(EmfMap emfMap)  throws Exception {
		
		if(!"".equals(EMFStringUtil.nullConvert(emfMap.get("seq"))))
    	{
			EmfMap imgMgrInfo = cNAZeroChoiceDAO.selectZeroChoiImgMgr(emfMap);
	
	    	if(imgMgrInfo != null)
	    	{
				emfMap.put("imgMgrInfo", imgMgrInfo);
				
				emfMap.put("using", "top");
				List<EmfMap> topFileList = cNAZeroChoiceDAO.selectZeroChoiseFileInfo(emfMap);
				emfMap.put("topFileList", topFileList);
				EmfMap topContCnt = cNAZeroChoiceDAO.selectZeroChoiseImgContainerCnt(emfMap);
	    		emfMap.put("topContCnt", topContCnt);
				
				emfMap.put("using", "bottom");
				List<EmfMap> bottomFileList = cNAZeroChoiceDAO.selectZeroChoiseFileInfo(emfMap);
				emfMap.put("bottomFileList", bottomFileList);
				EmfMap bottomContCnt = cNAZeroChoiceDAO.selectZeroChoiseImgContainerCnt(emfMap);
	    		emfMap.put("bottomContCnt", bottomContCnt);
				
				emfMap.put("using", "top_pop");
				List<EmfMap> topPopFileList = cNAZeroChoiceDAO.selectZeroChoiseFileInfo(emfMap);
				emfMap.put("topPopFileList", topPopFileList);
				EmfMap topPopContCnt = cNAZeroChoiceDAO.selectZeroChoiseImgContainerCnt(emfMap);
	    		emfMap.put("topPopContCnt", topPopContCnt);
				
				emfMap.put("using", "bottom_pop");
				List<EmfMap> bottomPopFileList = cNAZeroChoiceDAO.selectZeroChoiseFileInfo(emfMap);
				emfMap.put("bottomPopFileList", bottomPopFileList);
				EmfMap bottomPopContCnt = cNAZeroChoiceDAO.selectZeroChoiseImgContainerCnt(emfMap);
	    		emfMap.put("bottomPopContCnt", bottomPopContCnt);
				
				
	    	}
    	}
		
		return emfMap;
	}

    /**
     * 상품관리를 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@Override
	public void izcpm(EmfMap emfMap) throws Exception {
		EmfMap lgnMap = (EmfMap)EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("zeroChoiPrdMgrSeq", zeroChoiPrdMgrIdgen.getNextIntegerId());
		emfMap.put("ptupDt", emfMap.getString("ptupDt").replaceAll("-", ""));
		emfMap.put("regId", lgnMap.getString("id"));
		emfMap.put("regIp", lgnMap.getString("loginIp"));
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		emfMap.put("priceYn", "on".equals(emfMap.getString("priceYn")) ? "Y" : "N");
		emfMap.put("priceBenefitUnitYn", "on".equals(emfMap.getString("priceBenefitUnitYn")) ? "Y" : "N");

		cNAZeroChoiceDAO.insertZeroChoisePrdMgr(emfMap);

		// 이미지 파일 저장
		List<EmfMap> list = new ArrayList<EmfMap>();
		
		MultipartHttpServletRequest mReq = (MultipartHttpServletRequest) emfMap.get("request");
		String path = mReq.getSession().getServletContext().getRealPath(img_path);
    	Iterator<String> iter = mReq.getFileNames();
    	MultipartFile mf = null;
    	
    	while(iter.hasNext()) {
    		mf = mReq.getFile(iter.next());
    		if(mf.isEmpty() == false) {
    			String ori_filenm = mf.getOriginalFilename();
    			String filenm = ori_filenm.substring(0, ori_filenm.lastIndexOf("."));
    			String ext = ori_filenm.substring(ori_filenm.lastIndexOf(".")+1, ori_filenm.length());
    			String size = "";
    			String local_file_nm = System.currentTimeMillis() + "_" + filenm + "." + ext;
    			
    			if(mf.getSize()/1024/1024 > 1) { //MB
    				size = Math.round(Math.ceil(mf.getSize()/1024/1024)) + " MB";
    			} else { //KB
    				size = Math.round(Math.ceil(mf.getSize()/1024)) + " KB";
    			}
    			
    			String name = mf.getName();
    			String classification = name.contains("pc") == true ? "pc" : "mobile";
    			String using = name.contains("prd_spec") == true ? "spec" : "prd";
    			String regOrder = name.substring(name.lastIndexOf("_")+1, name.length());
    			
    			EmfMap map = new EmfMap();
    			
    			map.put("zeroChoiFileSeq", zeroChoiFileIdgen.getNextIntegerId());
    			map.put("classification", classification);
    			map.put("fileNm", filenm);
    			map.put("fileSize", size);
    			map.put("fileType", ext);
    			map.put("regOrder", regOrder);
    			map.put("using", using);
    			map.put("localFileName", local_file_nm);
    			map.put("path", img_path);
    			
    			list.add(map);
    			
    			// 서버폴더에 이미지 저장
    			try {
    				EgovFileMngUtil.uploadFileImg(mf, img_path, local_file_nm);
    			} catch (IOException e) {
					e.printStackTrace();
				}
    		}
    	}
    	
		emfMap.put("imgFile", list);
		
		cNAZeroChoiceDAO.insertZeroChoiseFile(emfMap);
	}

    /**
     * 이미지관리를 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@Override
	public void izcim(EmfMap emfMap) throws Exception {
		EmfMap lgnMap = (EmfMap)EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("zeroChoiImgMgrSeq", zeroChoiImgMgrIdgen.getNextIntegerId());
		emfMap.put("ptupDt", emfMap.getString("ptupDt").replaceAll("-", ""));
		emfMap.put("regId", lgnMap.getString("id"));
		emfMap.put("regIp", lgnMap.getString("loginIp"));
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		if("Y".equals(emfMap.getString("useYn"))) {
			// 모든 useYn을 N으로 변경
			cNAZeroChoiceDAO.updateZeroChoiseImgMgrN(emfMap);
		}
		
		cNAZeroChoiceDAO.insertZeroChoiseImgMgr(emfMap);

		// 이미지 파일 저장
		List<EmfMap> list = new ArrayList<EmfMap>();
		
		MultipartHttpServletRequest mReq = (MultipartHttpServletRequest) emfMap.get("request");
		String path = mReq.getSession().getServletContext().getRealPath(img_path);
    	Iterator<String> iter = mReq.getFileNames();
    	MultipartFile mf = null;
    	
    	while(iter.hasNext()) {
    		mf = mReq.getFile(iter.next());
    		if(mf.isEmpty() == false) {
    			String ori_filenm = mf.getOriginalFilename();
    			String filenm = ori_filenm.substring(0, ori_filenm.lastIndexOf("."));
    			String ext = ori_filenm.substring(ori_filenm.lastIndexOf(".")+1, ori_filenm.length());
    			String size = "";
    			String local_file_nm = System.currentTimeMillis() + "_" + filenm + "." + ext;
    			
    			if(mf.getSize()/1024/1024 > 1) { //MB
    				size = Math.round(Math.ceil(mf.getSize()/1024/1024)) + " MB";
    			} else { //KB
    				size = Math.round(Math.ceil(mf.getSize()/1024)) + " KB";
    			}
    			
    			String name = mf.getName();
    			String classification = name.contains("pc") == true ? "pc" : "mobile";
    			String using = "";
    			
    			if(name.contains("top")) {
    				if(name.contains("pop")) {
    					using = "top_pop";
    				} else {
    					using = "top";
    				}
    			} 
    			
    			if(name.contains("bottom")) {
    				if(name.contains("pop")) {
    					using = "bottom_pop";
    				} else {
    					using = "bottom";
    				}
    			}
    			
    			String regOrder = name.substring(name.lastIndexOf("_")+1, name.length());
    			
    			EmfMap map = new EmfMap();
    			
    			map.put("zeroChoiFileSeq", zeroChoiFileIdgen.getNextIntegerId());
    			map.put("classification", classification);
    			map.put("fileNm", filenm);
    			map.put("fileSize", size);
    			map.put("fileType", ext);
    			map.put("regOrder", regOrder);
    			map.put("using", using);
    			map.put("localFileName", local_file_nm);
    			map.put("path", img_path);
    			
    			list.add(map);
    			
    			try {
    				EgovFileMngUtil.uploadFileImg(mf, img_path, local_file_nm);
    			} catch (IOException e) {
					e.printStackTrace();
				}
    		}
    	}
    	
		emfMap.put("imgFile", list);
		
		cNAZeroChoiceDAO.insertZeroChoiseFile(emfMap);
	}

    /**
     * 상품관리를 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@Override
	public void uzcpm(EmfMap emfMap) throws Exception {
		EmfMap lgnMap = (EmfMap)EgovUserDetailsHelper.getAuthenticatedUser();
		
		List<String> space_del_orders_list = new ArrayList<String>(); 
		String[] spaceDelOrders_arr = emfMap.getString("spaceDelOrders").split(",");
		for(int i=0; i<spaceDelOrders_arr.length; i++) {
			space_del_orders_list.add(spaceDelOrders_arr[i]);
		}
		
		emfMap.put("space_del_orders_list", space_del_orders_list);
		emfMap.put("ptupDt", emfMap.getString("ptupDt").replaceAll("-", ""));
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		emfMap.put("seq", emfMap.getString("prdctSeq"));
		emfMap.put("priceYn", "on".equals(emfMap.getString("priceYn")) ? "Y" : "N");
		emfMap.put("priceBenefitUnitYn", "on".equals(emfMap.getString("priceBenefitUnitYn")) ? "Y" : "N");
		
		GetAllMapValue.getMapValue(emfMap);
		cNAZeroChoiceDAO.updateZeroChoisePrdMgr(emfMap);
		
		// 이미지 파일 저장
		MultipartHttpServletRequest mReq = (MultipartHttpServletRequest) emfMap.get("request");
		String path = mReq.getSession().getServletContext().getRealPath(img_path);
    	Iterator<String> iter = mReq.getFileNames();
    	MultipartFile mf = null;
    	
    	while(iter.hasNext()) {
    		mf = mReq.getFile(iter.next());
    		if(mf.isEmpty() == false) {
    			String ori_filenm = mf.getOriginalFilename();
    			String filenm = ori_filenm.substring(0, ori_filenm.lastIndexOf("."));
    			String ext = ori_filenm.substring(ori_filenm.lastIndexOf(".")+1, ori_filenm.length());
    			String size = "";
    			String local_file_nm = System.currentTimeMillis() + "_" + filenm + "." + ext;
    			
    			if(mf.getSize()/1024/1024 > 1) { //MB
    				size = Math.round(Math.ceil(mf.getSize()/1024/1024)) + " MB";
    			} else { //KB
    				size = Math.round(Math.ceil(mf.getSize()/1024)) + " KB";
    			}
    			
    			String name = mf.getName();
    			String classification = name.contains("pc") == true ? "pc" : "mobile";
    			String using = name.contains("prd_spec") == true ? "spec" : "prd";
    			String regOrder = name.substring(name.lastIndexOf("_")+1, name.length());
    			
    			EmfMap map = new EmfMap();
    			
    			map.put("zeroChoiFileSeq", zeroChoiFileIdgen.getNextIntegerId());
    			map.put("classification", classification);
    			map.put("fileNm", filenm);
    			map.put("fileSize", size);
    			map.put("fileType", ext);
    			map.put("regOrder", regOrder);
    			map.put("using", using);
    			map.put("localFileName", local_file_nm);
    			map.put("path", img_path);
    			
    			// 서버폴더에 이미지 저장
    			try {
    				EgovFileMngUtil.uploadFileImg(mf, img_path, local_file_nm);
    			} catch (IOException e) {
					e.printStackTrace();
				}
    			
    			emfMap.put("fileInfo", map);
    			
    			GetAllMapValue.getMapValue(emfMap);
    			
    			cNAZeroChoiceDAO.updateZeroChoiseFile1(emfMap);
    		} 
    	}
    	
    	emfMap.put("using", "prd");
		cNAZeroChoiceDAO.updateZeroChoiseFile2(emfMap);
	}

    /**
     * 이미지관리를 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@Override
	public void uizcim(EmfMap emfMap) throws Exception {
		EmfMap lgnMap = (EmfMap)EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("ptupDt", emfMap.getString("ptupDt").replaceAll("-", ""));
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		emfMap.put("seq", emfMap.getString("imgSeq"));
		
		// 모든 useYn을 N으로 변경
		cNAZeroChoiceDAO.updateZeroChoiseImgMgrN(emfMap);
		
		// 변경사항 적용
		cNAZeroChoiceDAO.updateZeroChoiseImgMgr(emfMap);
		
		// 이미지 파일 저장
		MultipartHttpServletRequest mReq = (MultipartHttpServletRequest) emfMap.get("request");
		String path = mReq.getSession().getServletContext().getRealPath(img_path);
    	Iterator<String> iter = mReq.getFileNames();
    	MultipartFile mf = null;
    	
    	// 이미지 파일 저장
		List<EmfMap> list = new ArrayList<EmfMap>();
		List<EmfMap> db_file =  new ArrayList<EmfMap>();
    	
    	while(iter.hasNext()) {
    		mf = mReq.getFile(iter.next());
    		if(mf.isEmpty() == false) {
    			String ori_filenm = mf.getOriginalFilename();
    			String filenm = ori_filenm.substring(0, ori_filenm.lastIndexOf("."));
    			String ext = ori_filenm.substring(ori_filenm.lastIndexOf(".")+1, ori_filenm.length());
    			String size = "";
    			String local_file_nm = System.currentTimeMillis() + "_" + filenm + "." + ext;
    			
    			if(mf.getSize()/1024/1024 > 1) { //MB
    				size = Math.round(Math.ceil(mf.getSize()/1024/1024)) + " MB";
    			} else { //KB
    				size = Math.round(Math.ceil(mf.getSize()/1024)) + " KB";
    			}
    			
    			String name = mf.getName();
    			
    			String classification = name.contains("pc") == true ? "pc" : "mobile";
    			String using = "";

    			if(name.contains("top")) {
    				if(name.contains("pop")) {
    					using = "top_pop";
    				} else {
    					using = "top";
    				}
    			} else {
    				if(name.contains("pop")) {
    					using = "bottom_pop";
    				} else {
    					using = "bottom";
    				}
    			}
    			
    			String regOrder = name.substring(name.lastIndexOf("_")+1, name.length());
    			
    			EmfMap map = new EmfMap();
    			
//    			map.put("zeroChoiFileSeq", zeroChoiFileIdgen.getNextIntegerId());
    			map.put("classification", classification);
    			map.put("fileNm", filenm);
    			map.put("fileSize", size);
    			map.put("fileType", ext);
    			map.put("regOrder", regOrder);
    			map.put("using", using);
    			map.put("localFileName", local_file_nm);
    			map.put("path", img_path);
    			
    			// 서버폴더에 이미지 저장
    			try {
    				EgovFileMngUtil.uploadFileImg(mf, img_path, local_file_nm);
    			} catch (IOException e) {
					e.printStackTrace();
				}
    			
    			emfMap.put("fileInfo", map);
    			
    			db_file = cNAZeroChoiceDAO.selectZeroChoiseFile(emfMap);
    			
				map.put("zeroChoiFileSeq", zeroChoiFileIdgen.getNextIntegerId());
    			if(db_file.size() > 0) {	// 해당하는 자리에 이미지가 있을경우 update
	    			cNAZeroChoiceDAO.updateZeroChoiseFile1(emfMap);
    			} else {
    				emfMap.put("fileInfo", map);
    				
    				list.add(map);
    			}
    		}
    	}
    	
    	// 해당하는 자리에 이미지가 없을 경우 insert
    	if(db_file.size() == 0 && list.size() > 0) {
    		emfMap.put("imgFile", list);
    		cNAZeroChoiceDAO.insertZeroChoiseFile2(emfMap);
    	}
    	
    	// 영역 삭제한 항목 삭제
		String[] spaceDelOrders_arr = emfMap.getString("spaceDelOrders").split(",");
		
		if(!"".equals(spaceDelOrders_arr[0])) {
			List<EmfMap> space_del_orders_list = new ArrayList<EmfMap>(); 

			for(int i=0; i<spaceDelOrders_arr.length; i++) {
				String gubun = spaceDelOrders_arr[i].split("_")[0];
				String regOrder = spaceDelOrders_arr[i].split("_")[1];
				
				EmfMap delMap = new EmfMap();
				delMap.put("gubun", gubun);
				delMap.put("regOrder", regOrder);
				
				space_del_orders_list.add(delMap);
			}
			emfMap.put("space_del_orders_list", space_del_orders_list);
			
			cNAZeroChoiceDAO.updateZeroChoiseFile3(emfMap);
		}
	}

	@Override
	public EmfMap selectFileInfoByFileSeq(EmfMap emfMap) {
		return cNAZeroChoiceDAO.selectFileInfoByFileSeq(emfMap);
	}
	
    /**
     * 상품관리를 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@Override
	public void dzcl(EmfMap emfMap) throws Exception {
		String zeroChoiGb = emfMap.getString("zeroChoiGb");
		
		if("prdmgr".equals(zeroChoiGb)) {
			// 상품 삭제
			cNAZeroChoiceDAO.deleteZeroChoisePrdmgrList(emfMap);
		} else if("imgmgr".equals(zeroChoiGb)) {
			cNAZeroChoiceDAO.deleteZeroChoiseImgmgrList(emfMap);
		} else {
			System.out.println("삭제할 기능을 추가하세요.");
		}
		
		// 상품관련 이미지 삭제
		cNAZeroChoiceDAO.deleteZeroChoiseImgList(emfMap);
	}

	/**
	 * 제로초이스 카테고리 관리 메뉴 리스트를 순서 변경한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return List<EmfMap> 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
//	public void updateCateMenuPstn(EmfMap emfMap) throws Exception {
	public void ucp(EmfMap emfMap) throws Exception {
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		cNAZeroChoiceDAO.updateCateMenuPstn(emfMap);
	}
	
	/**
	 * 제로초이스 카테고리 관리 메뉴 리스트를 삭제한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return List<EmfMap> 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
//	public int deleteCateMenu(EmfMap emfMap) throws Exception {
	public int dcm(EmfMap emfMap) throws Exception {
		return cNAZeroChoiceDAO.deleteCateMenu(emfMap);
	}
	
	@Override
	public void ucpb(EmfMap emfMap) {
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		cNAZeroChoiceDAO.updateCateMenuPstnBefore(emfMap);
	}

	@Override
	public void ucpad(EmfMap emfMap) {
		System.out.println("=================>>");
		GetAllMapValue.getMapValue(emfMap);
		cNAZeroChoiceDAO.updateCatePstnAfterDelete(emfMap);
	}

	@Override
	public EmfMap getPstnByCateSeq(EmfMap emfMap) {
		return cNAZeroChoiceDAO.getPstnByCateSeq(emfMap);
	}

	@Override
	public void cateWrite(EmfMap emfMap) {
		EmfMap lgnMap = (EmfMap)EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("ptupDt", emfMap.getString("ptupDt").replaceAll("-", ""));
		emfMap.put("regId", lgnMap.getString("id"));
		emfMap.put("regIp", lgnMap.getString("loginIp"));
		
		GetAllMapValue.getMapValue(emfMap);
		
		cNAZeroChoiceDAO.cateWrite(emfMap);
	}
	
	@Override
	public void cateAllDel(EmfMap emfMap) {
		cNAZeroChoiceDAO.cateAllDel(emfMap);
	}

	@Override
	public List<EmfMap> selectZeroChoiPrdMgrListByCateSeq(EmfMap emfMap) {
		return cNAZeroChoiceDAO.selectZeroChoiPrdMgrListByCateSeq(emfMap);
	}

	@Override
//	public void updateCateMove1(EmfMap param) {
	public void ucm1(EmfMap param) {
		cNAZeroChoiceDAO.updateCateMove1(param);
	}

	@Override
//	public void updateCateMove2(EmfMap param) {
	public void ucm2(EmfMap param) {
		cNAZeroChoiceDAO.updateCateMove2(param);
	}
}
