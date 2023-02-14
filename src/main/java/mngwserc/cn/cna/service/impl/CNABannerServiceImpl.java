package mngwserc.cn.cna.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import mngwserc.cn.cna.GetAllMapValue;
import mngwserc.cn.cna.service.CNABannerService;
import mngwserc.cn.cna.service.dao.CNABannerDAO;
import mngwserc.co.util.COPaginationUtil;
import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.service.EgovFileMngUtil;
import egovframework.com.cmm.service.EgovProperties;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.com.utl.fcc.service.EgovFormBasedFileUtil;
import egovframework.rte.fdl.idgnr.impl.EgovTableIdGnrService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import emf.core.exception.EmfException;
import emf.core.extend.service.EmfAbstractService;
import emf.core.vo.EmfMap;

@Service("cNABannerService")
public class CNABannerServiceImpl  extends EmfAbstractService implements CNABannerService {

	@Resource(name="cNABannerDAO")
	private CNABannerDAO cNABannerDAO; 
	
	@Resource(name="EgovCmmUseService")
    private EgovCmmUseService cmmUseService;
	
	@Resource(name="bannerFileIdgen")
	private EgovTableIdGnrService bannerFileIdgen;
	
	private final static String img_path = EgovProperties.getProperty("Globals.imageBannerPath");
	
	@Override
	public EmfMap selectBannerList(EmfMap emfMap) throws Exception {
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
/*		if("30".equals(lgnMap.getString("authCd")))
		{*/
			EmfMap oamInfMap = null;
			
	    	PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
			
	    	//페이징 처리
	    	emfMap.put("paginationInfo", paginationInfo);
	    	
			List<EmfMap> list = cNABannerDAO.selectBannerList(emfMap);
			
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

	@Override
	public EmfMap selectBanner(EmfMap emfMap) throws Exception {
		 EmfMap mstMap = cNABannerDAO.selectBanner(emfMap);
    	
    	if(mstMap != null)
    	{
    		emfMap.put("mstMap", mstMap);
    		
    		emfMap.put("dtlMap", cNABannerDAO.selectBannerDtlList(emfMap));
    	}

    	return emfMap;
	}

	@Override
//	public void updateBanner(HttpServletRequest request, EmfMap emfMap)
	public void ub(HttpServletRequest request, EmfMap emfMap)
			throws Exception {
		EmfMap lgnMap = (EmfMap)EgovUserDetailsHelper.getAuthenticatedUser();
		
		String bannerGubun = emfMap.getString("bannerGubun");
		
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		cNABannerDAO.updateBannerMgr(emfMap);
		
		System.out.println(emfMap.getString("bannerSeq"));

		// 이미지 파일 저장
		List<EmfMap> list = new ArrayList<EmfMap>();
		MultipartHttpServletRequest mReq = (MultipartHttpServletRequest) emfMap.get("request");
		String path = mReq.getSession().getServletContext().getRealPath(img_path);
    	Iterator<String> iter = mReq.getFileNames();
    	MultipartFile mf = null;
    	String imageGubun = "";
    	String gubun = "";
    	System.out.println(emfMap.getString("urlText"));
    	System.out.println(emfMap.getString("urlText").length());
    	System.out.println(emfMap.getString("fileseq"));
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
    			gubun = name.contains("pp") == true ? "pc" : "mobile"; 
    			emfMap.put("gubun", gubun);
    			String regOrder = name.substring(name.lastIndexOf("_")+1, name.length());
    			
    			EmfMap map = new EmfMap();
    			
    			if(bannerGubun.equals("MAIN") || bannerGubun.equals("TOP") ){
    				imageGubun = "only";
    			} else {
    				imageGubun = name.contains("Top") == true ? "top" : "under"; 
    				if(imageGubun == "top"){
    					emfMap.put("urlText", emfMap.getString("topUrlText"));
    				} else {
    					emfMap.put("urlText", emfMap.getString("underUrlText"));
    				}
    			}
    			
    			emfMap.put("name", name);
    			emfMap.put("imageGubun", imageGubun);
				//map.put("cnFileSeq", bannerFileIdgen.getNextIntegerId());
    			map.put("bannerSeq", emfMap.getString("bannerSeq"));
    			map.put("gubun", gubun);
    			map.put("imageGubun", imageGubun);
    			map.put("path", img_path);
    			map.put("localFileName", local_file_nm);
    			map.put("fileNm", filenm);
    			map.put("fileSize", size);
    			map.put("fileType", ext);
    			map.put("regOrder", regOrder);
    			
    			list.add(map);
    			
    			try {
    				EgovFileMngUtil.uploadFileImg(mf, img_path, local_file_nm);
				} catch (IOException e) {
					e.printStackTrace();
				}
    			
    	    	
    			emfMap.put("fileInfo", map);
    			
    			cNABannerDAO.updateBannerFile(emfMap);
    		}
    	}
    	System.out.println("1: "+emfMap.getString("urlText"));
    	System.out.println("1: "+emfMap.getString("bannerSeq"));
    	
    	if(bannerGubun.equals("Floating")){
    		if(!"".equals(emfMap.getString("topUrlText"))){
    			System.out.println("1");
    			emfMap.put("imageGubun", "top");
    			emfMap.put("urlText", emfMap.getString("topUrlText"));
    			cNABannerDAO.updateBannerUrl(emfMap);
    		} 
    		if(!"".equals(emfMap.getString("underUrlText"))) {
    			System.out.println("2");
    			emfMap.put("imageGubun", "under");
    			emfMap.put("urlText", emfMap.getString("underUrlText"));
    			cNABannerDAO.updateBannerUrl(emfMap);
    		}
    	} else {
    		System.out.println("3");
    		emfMap.put("imageGubun", "only");
    		cNABannerDAO.updateBannerUrl(emfMap);
    	}
	}

	@Override
//	public void deleteBannerList(EmfMap emfMap) throws Exception {
		public void dbl(EmfMap emfMap) throws Exception {
		cNABannerDAO.deleteBannerMst(emfMap);
		cNABannerDAO.deleteBannerImg(emfMap);
	}

	@Override
	public EmfMap getBannerPreviewImgPath(EmfMap emfMap) throws Exception {
/*		EmfMap map = cNABannerDAO.getBannerPreviewImgPath(emfMap);
		String path = map.getString("phyPath") + "/" + map.getString("saveFileNm");*/
		return cNABannerDAO.getBannerPreviewImgPath(emfMap);
	}

	@Override
//	public void insertBanner(EmfMap emfMap) throws Exception {
	public void ib(EmfMap emfMap) throws Exception {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 배너 등록 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		EmfMap lgnMap = (EmfMap)EgovUserDetailsHelper.getAuthenticatedUser();
		
		String bannerGubun = emfMap.getString("bannerGubun");
		
		emfMap.put("regId", lgnMap.getString("id"));
		emfMap.put("regIp", lgnMap.getString("loginIp"));
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		cNABannerDAO.insertBannerMgr(emfMap);
		
		System.out.println(emfMap.getString("bannerSeq"));

		// 이미지 파일 저장
		List<EmfMap> list = new ArrayList<EmfMap>();
		
		MultipartHttpServletRequest mReq = (MultipartHttpServletRequest) emfMap.get("request");
		String path = mReq.getSession().getServletContext().getRealPath(img_path);
    	Iterator<String> iter = mReq.getFileNames();
    	MultipartFile mf = null;
    	System.out.println(emfMap.getString("urlText"));
    	System.out.println(emfMap.getString("urlText").length());
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
    			String gubun = name.contains("pp") == true ? "pc" : "mobile";
    			String regOrder = name.substring(name.lastIndexOf("_")+1, name.length());
    			
    			EmfMap map = new EmfMap();
    			
    			String imageGubun = "";
    			if(bannerGubun.equals("MAIN") || bannerGubun.equals("TOP") ){
    				imageGubun = "only";
    			} else {
    				imageGubun = name.contains("Top") == true ? "top" : "under"; 
    				if("top".equals(imageGubun)){
    					map.put("urlText", emfMap.getString("topUrlText"));
    				} else {
    					map.put("urlText", emfMap.getString("underUrlText"));
    				}
    			}
    			
				map.put("cnFileSeq", bannerFileIdgen.getNextIntegerId());
    			map.put("bannerSeq", emfMap.getString("bannerSeq"));
    			map.put("gubun", gubun);
    			map.put("imageGubun", imageGubun);
    			map.put("path", img_path);
    			map.put("localFileName", local_file_nm);
    			map.put("fileNm", filenm);
    			map.put("fileSize", size);
    			map.put("fileType", ext);
    			map.put("regOrder", regOrder);
    			
    			list.add(map);

    			try {
    				EgovFileMngUtil.uploadFileImg(mf, img_path, local_file_nm);
    			} catch (IOException e) {
					e.printStackTrace();
				}
    	    	
    			emfMap.put("imgFile", list);
    			
    		}
    	}
    	
    	
    	GetAllMapValue.getMapValue(emfMap);
    	
    	cNABannerDAO.insertBannerFile(emfMap);
	}
}
