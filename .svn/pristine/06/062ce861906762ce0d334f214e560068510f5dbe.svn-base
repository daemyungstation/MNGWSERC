package mngwserc.co.main.service.impl;


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

import mngwserc.co.main.service.COMainMngService;
import mngwserc.co.main.service.dao.COMainMngDAO;
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

@Service("coMainMngService")
public class COMainMngServiceImpl extends EmfAbstractService implements COMainMngService {

	@Resource(name="coMainMngDAO")
	private COMainMngDAO coMainMngDAO; 
	
	@Resource(name="mainVisualIdgen")
	private EgovTableIdGnrService mainVisualIdgen;
	
	@Resource(name="mainContentIdgen")
	private EgovTableIdGnrService mainContentIdgen;
	
	@Resource(name="mainContentDtlIdgen")
	private EgovTableIdGnrService mainContentDtlIdgen;
	
	private final static String img_path = EgovProperties.getProperty("Globals.mainImagesPath");
	
	
	@Override
	public void liveMain(EmfMap emfMap) throws Exception {
    	coMainMngDAO.liveMain(emfMap);
	}
	
	@Override
	public EmfMap selectVisualGroup(EmfMap emfMap) throws Exception {
		emfMap.put("grpIds", coMainMngDAO.selectVisualGroup(emfMap));
		return emfMap;
	}
	
	@Override
	public EmfMap selectMain(EmfMap emfMap) throws Exception {
		//get group
		List<EmfMap> grpList = coMainMngDAO.selectVisualGroup(emfMap);
		emfMap.put("grpIds", grpList);
		
		if(emfMap.getString("grpId").isEmpty() == true)
		{
			if(grpList.size() > 0)
			{
				if(grpList.get(0).getString("liveGrpId").isEmpty() == true)
				{
					emfMap.put("grpId", grpList.get(0).getString("grpId"));
				}
				else
				{
					emfMap.put("grpId", grpList.get(0).getString("liveGrpId"));
				}
			}
		}
		
		List<EmfMap> visualList = coMainMngDAO.selectVisualMainList(emfMap);
		for(EmfMap vl : visualList)
		{
			String webTitleTxt = vl.getString("webTitleTxt");
			webTitleTxt = webTitleTxt.replaceAll("\r\n", "<br>");
			webTitleTxt = webTitleTxt.replaceAll("\r", "<br>");
			webTitleTxt = webTitleTxt.replaceAll("\n", "<br>");
			webTitleTxt = webTitleTxt.replaceAll("(##.*##)", "<small>$1</small>").replaceAll("##", "");
			vl.put("webTitleTxt", webTitleTxt); 
			
			vl.put("titleImgXyAry", vl.getString("titleImgXy").split(",")); 
			vl.put("titleTxtXyAry", vl.getString("titleTxtXy").split(","));
			vl.put("btnXyAry", vl.getString("btnXy").split(","));
			
			String[] bgXy = vl.getString("bgXy").split(",");
			for(int i = 0; i < bgXy.length; i++)
			{
				if(!"auto".equals(bgXy[i])) bgXy[i] = bgXy[i] +"px"; 
			}
			vl.put("bgXyAry", bgXy);
		}
		
		List<EmfMap> cList = coMainMngDAO.selectContentMainList(emfMap);
		
		String contentMstSeq = "";
		List<EmfMap> contentList = new ArrayList<EmfMap>();
		List<EmfMap> contentDtlList = new ArrayList<EmfMap>();

		EmfMap cMst = new EmfMap();
		
		for(EmfMap cl : cList) {
			if(!contentMstSeq.equals(cl.getString("cntnsMstSeq")))
			{
				if(!"".equals(contentMstSeq))
				{
					contentList.add(cMst);
				}
				contentMstSeq = cl.getString("cntnsMstSeq");

				cMst = new EmfMap();
				cMst.put("CNTNS_MST_SEQ", contentMstSeq);
				cMst.put("GRP_ID", cl.getString("grpId"));
				cMst.put("TITLE_TXT", cl.getString("titleTxt").replaceAll("(##.*##)", "<span>$1</span>").replaceAll("##", ""));
				cMst.put("TITLE_COLOR", cl.getString("titleColor"));
				cMst.put("CORDERBY", cl.getString("corderby"));
			}
			
			if(!"".equals(cl.getString("cntnsDtlSeq")))
			{
				String dsc = cl.getString("dsc");
				dsc = dsc.replaceAll("\r\n", "<br>");
				dsc = dsc.replaceAll("\r", "<br>");
				dsc = dsc.replaceAll("\n", "<br>");
				
				EmfMap dMst = new EmfMap();
				dMst.put("CNTNS_MST_SEQ", cl.getString("cntnsMstSeq"));
				dMst.put("CNTNS_DTL_SEQ", cl.getString("cntnsDtlSeq"));
				dMst.put("IMG_PATH", cl.getString("imgPath"));
				dMst.put("IMG_SAVE_FILE_NM", cl.getString("imgSaveFileNm"));
				dMst.put("IMG_REAL_FILE_NM", cl.getString("imgRealFileNm"));
				dMst.put("TITLE", cl.getString("title"));
				dMst.put("DSC", dsc);
				dMst.put("LINK", cl.getString("link"));
				dMst.put("DORDERBY", cl.getString("dorderby"));
	
				contentDtlList.add(dMst);
			}
		}
		contentList.add(cMst);		

		emfMap.put("visualList", visualList);
		emfMap.put("contentList", contentList);
		emfMap.put("contentDtlList", contentDtlList);
	
		return emfMap;
	}
	
	@Override
	public void mainVisualXY(EmfMap emfMap) throws Exception {
		String top = emfMap.getString("top");
		String left = emfMap.getString("left");
		String right = emfMap.getString("right");
		String bottom = emfMap.getString("bottom");
			
		if(!"auto".equals((emfMap.getString("top"))))
		{
			top = String.valueOf((Math.round((Double.parseDouble(emfMap.getString("top")) * 10) / 10.0)));
		}
		
		if(!"auto".equals((emfMap.getString("left"))))
		{
			left = String.valueOf(Math.round((Double.parseDouble(emfMap.getString("left")) * 10) / 10.0));
		}
		if(!"auto".equals((emfMap.getString("right"))))
		{
			right = String.valueOf(Math.round((Double.parseDouble(emfMap.getString("right")) * 10) / 10.0));
		}
		if(!"auto".equals((emfMap.getString("bottom"))))
		{
			bottom = String.valueOf(Math.round((Double.parseDouble(emfMap.getString("bottom")) * 10) / 10.0));
		}
		
		if(emfMap.getString("column").equals("title_img_xy"))
		{
			emfMap.put("column", "TITLE_IMG_XY");
			emfMap.put("value", top +","+ left);
			coMainMngDAO.mainVisualXY(emfMap);
		}
		else if(emfMap.getString("column").equals("title_txt_xy"))
		{
			emfMap.put("column", "TITLE_TXT_XY");
			emfMap.put("value", top +","+ left);
			coMainMngDAO.mainVisualXY(emfMap);
		}
		else if(emfMap.getString("column").equals("btn_xy"))
		{
			emfMap.put("column", "BTN_XY");
			emfMap.put("value", bottom +","+ left);
			coMainMngDAO.mainVisualXY(emfMap);
		}
		else if(emfMap.getString("column").equals("bg_xy"))
		{
			emfMap.put("column", "BG_XY");
			emfMap.put("value", top +","+ left +","+ right +","+ bottom);
			coMainMngDAO.mainVisualXY(emfMap);
		}
	}
	
	@Override
	public EmfMap selectVisualList(EmfMap emfMap) throws Exception {
		//get group
		List<EmfMap> grpList = coMainMngDAO.selectVisualGroup(emfMap);
		emfMap.put("grpIds", grpList);
		
		if(emfMap.getString("grpId").isEmpty() == true)
		{
			if(grpList.size() > 0)
			{
				if(grpList.get(0).getString("liveGrpId").isEmpty() == true)
				{
					emfMap.put("grpId", grpList.get(0).getString("grpId"));
				}
				else
				{
					emfMap.put("grpId", grpList.get(0).getString("liveGrpId"));
				}
			}
		}
    	//list
		List<EmfMap> list = coMainMngDAO.selectVisualList(emfMap);
		emfMap.put("list", list);
		return emfMap;
	}
	
	@Override
	public EmfMap selectVisual(EmfMap emfMap) throws Exception {
		//get group
		emfMap.put("grpIds", coMainMngDAO.selectVisualGroup(emfMap));
		emfMap.put("rstMap", coMainMngDAO.selectVisual(emfMap));

		return emfMap;
	}
	
	@Override
	public void insertVisual(EmfMap emfMap) throws Exception {
		//login info
		EmfMap lgnMap = (EmfMap)EgovUserDetailsHelper.getAuthenticatedUser();
		emfMap.put("regId", lgnMap.getString("id"));
		emfMap.put("regIp", lgnMap.getString("loginIp"));
		
		//get group id
		
		if(emfMap.getString("grpId").isEmpty() == true)
		{
			EmfMap keyMap = coMainMngDAO.selectVisualKeyNull(emfMap);
			emfMap.put("GRP_ID", keyMap.getString("getgrpid"));
			emfMap.put("orderBy", keyMap.getString("orderby"));
		}
		else
		{
			EmfMap keyMap = coMainMngDAO.selectVisualKey(emfMap);
			emfMap.put("orderBy", keyMap.getString("orderby"));
		}
		

		//get 시퀀스
		emfMap.put("VISUAL_SEQ", mainVisualIdgen.getNextIntegerId());

		//파일 업로드
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
    			String local_file_nm = System.currentTimeMillis() + "_" + filenm + "." + ext;
    			
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
    	coMainMngDAO.insertVisual(emfMap);
	}
	
	@Override
	public void updateVisual(EmfMap emfMap) throws Exception {
		EmfMap lgnMap = (EmfMap)EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		if(emfMap.getString("grpId").isEmpty() == true)
		{
			EmfMap keyMap = coMainMngDAO.selectVisualKeyNull(emfMap);
			emfMap.put("GRP_ID", keyMap.getString("getgrpid"));
			emfMap.put("orderBy", keyMap.getString("orderby"));
		}else
		{
			EmfMap selectMap = coMainMngDAO.selectVisual(emfMap);
			if(!selectMap.getString("grpId").equals(emfMap.getString("grpId")))
			{
				EmfMap keyMap = coMainMngDAO.selectVisualKey(emfMap);
				emfMap.put("orderBy", keyMap.getString("orderby"));
			}
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
    			String local_file_nm = System.currentTimeMillis() + "_" + filenm + "." + ext;
    			
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
    	coMainMngDAO.updateVisual(emfMap);
    	
    	//전체 정렬
    	List<EmfMap> grpList = coMainMngDAO.reOrderVisualGrp(null);
    	if(!grpList.isEmpty())
    	{
    		for(EmfMap gList : grpList)
    		{
    			EmfMap gRow = new EmfMap();
    			gRow.put("grpId", gList.getString("grpId"));
    			List<EmfMap> grpVisaulList = coMainMngDAO.reOrderVisualGrpList(gRow);
    			int i = 1;
    			for(EmfMap gvList : grpVisaulList) 
    			{
    				EmfMap gvRow = new EmfMap();
    				gvRow.put("orderBy", i);
    				gvRow.put("visualSeq", Integer.parseInt(gvList.getString("visualSeq")));
    		    	coMainMngDAO.orderVisual(gvRow);
    				i++;
    			}
    		}
    	}
	}
	
	@Override
	public void deleteVisual(EmfMap emfMap) throws Exception {
    	EmfMap rstMap = coMainMngDAO.selectVisualGrp(emfMap);
    	coMainMngDAO.deleteVisual(emfMap);
    	if((Integer.parseInt(rstMap.getString("cnt")) - 1) <= 0)
    	{
    		emfMap.put("grp_id", rstMap.getString("grpId"));
    		coMainMngDAO.deleteVisualMst(emfMap);
    	}
    	
    	//전체 정렬
    	List<EmfMap> grpList = coMainMngDAO.reOrderVisualGrp(null);
    	if(!grpList.isEmpty())
    	{
    		for(EmfMap gList : grpList)
    		{
    			EmfMap gRow = new EmfMap();
    			gRow.put("grpId", gList.getString("grpId"));
    			List<EmfMap> grpVisaulList = coMainMngDAO.reOrderVisualGrpList(gRow);
    			int i = 1;
    			for(EmfMap gvList : grpVisaulList) 
    			{
    				EmfMap gvRow = new EmfMap();
    				gvRow.put("orderBy", i);
    				gvRow.put("visualSeq", Integer.parseInt(gvList.getString("visualSeq")));
    		    	coMainMngDAO.orderVisual(gvRow);
    				i++;
    			}
    		}
    	}
	}
	
	@Override
	public void orderVisual(EmfMap emfMap) throws Exception {
		String[] visualSeq = emfMap.getString("visualSeq").split(",");
		
		int i = 1;
		for(String vSeq : visualSeq)
		{
			emfMap.put("orderBy", i);
			emfMap.put("visualSeq", Integer.parseInt(vSeq));
	    	coMainMngDAO.orderVisual(emfMap);
	    	i++;
		}
	}
	
	
	@Override
	public EmfMap selectContentList(EmfMap emfMap) throws Exception {
		//get group
		List<EmfMap> grpList = coMainMngDAO.selectVisualGroup(emfMap);
		emfMap.put("grpIds", grpList);
		
		if(emfMap.getString("grpId").isEmpty() == true)
		{
			if(grpList.size() > 0)
			{
				if(grpList.get(0).getString("liveGrpId").isEmpty() == true)
				{
					emfMap.put("grpId", grpList.get(0).getString("grpId"));
				}
				else
				{
					emfMap.put("grpId", grpList.get(0).getString("liveGrpId"));
				}
			}
		}
		
    	//list
		List<EmfMap> list = coMainMngDAO.selectContentList(emfMap);
		emfMap.put("list", list);
		return emfMap;
	}
	
	@Override
	public void insertContent(EmfMap emfMap) throws Exception {
		//login info
		EmfMap lgnMap = (EmfMap)EgovUserDetailsHelper.getAuthenticatedUser();
		emfMap.put("regId", lgnMap.getString("id"));
		emfMap.put("regIp", lgnMap.getString("loginIp"));
		
		//get orderby
		EmfMap keyMap = coMainMngDAO.selectContentGroup(emfMap);
		emfMap.put("orderBy", keyMap.getString("orderby"));

		//get 시퀀스
		emfMap.put("CNTNS_MST_SEQ", mainContentIdgen.getNextIntegerId());

    	coMainMngDAO.insertContent(emfMap);
	}
	
	@Override
	public EmfMap selectContent(EmfMap emfMap) throws Exception {
		//get group
		emfMap.put("grpIds", coMainMngDAO.selectVisualGroup(emfMap));
		emfMap.put("rstMap", coMainMngDAO.selectContent(emfMap));

		return emfMap;
	}
	
	@Override
	public void updateContent(EmfMap emfMap) throws Exception {
		EmfMap lgnMap = (EmfMap)EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		EmfMap selectMap = coMainMngDAO.selectContent(emfMap);
		if(!selectMap.getString("grpId").equals(emfMap.getString("grpId")))
		{
			EmfMap keyMap = coMainMngDAO.selectContentGroup(emfMap);
			emfMap.put("orderBy", keyMap.getString("orderby"));
		}
    	coMainMngDAO.updateContent(emfMap);
    	
    	//전체 정렬
    	List<EmfMap> grpList = coMainMngDAO.reOrderContentGrp(null);
    	if(!grpList.isEmpty())
    	{
    		for(EmfMap gList : grpList)
    		{
    			EmfMap gRow = new EmfMap();
    			gRow.put("grpId", gList.getString("grpId"));
    			List<EmfMap> grpVisaulList = coMainMngDAO.reOrderContentGrpList(gRow);
    			int i = 1;
    			for(EmfMap gvList : grpVisaulList) 
    			{
    				EmfMap gvRow = new EmfMap();
    				gvRow.put("orderBy", i);
    				gvRow.put("contentSeq", Integer.parseInt(gvList.getString("cntnsMstSeq")));
    		    	coMainMngDAO.orderContent(gvRow);
    				i++;
    			}
    		}
    	}
	}
	
	@Override
	public void deleteContent(EmfMap emfMap) throws Exception {
    	coMainMngDAO.deleteContent(emfMap);
    	
    	//전체 정렬
    	List<EmfMap> grpList = coMainMngDAO.reOrderContentGrp(null);
    	if(!grpList.isEmpty())
    	{
    		for(EmfMap gList : grpList)
    		{
    			EmfMap gRow = new EmfMap();
    			gRow.put("grpId", gList.getString("grpId"));
    			List<EmfMap> grpVisaulList = coMainMngDAO.reOrderContentGrpList(gRow);
    			int i = 1;
    			for(EmfMap gvList : grpVisaulList) 
    			{
    				EmfMap gvRow = new EmfMap();
    				gvRow.put("orderBy", i);
    				gvRow.put("contentSeq", Integer.parseInt(gvList.getString("cntnsMstSeq")));
    		    	coMainMngDAO.orderContent(gvRow);
    				i++;
    			}
    		}
    	}
	}
	
	@Override
	public void orderContent(EmfMap emfMap) throws Exception {
		String[] contentSeq = emfMap.getString("contentSeq").split(",");
		
		int i = 1;
		for(String cSeq : contentSeq)
		{
			emfMap.put("orderBy", i);
			emfMap.put("contentSeq", Integer.parseInt(cSeq));
	    	coMainMngDAO.orderContent(emfMap);
	    	i++;
		}
	}
	
	@Override
	public EmfMap selectContentDtlList(EmfMap emfMap) throws Exception {
		List<EmfMap> list = coMainMngDAO.selectContentDtlList(emfMap);
		emfMap.put("list", list);
		return emfMap;
	}
	
	@Override
	public void insertContentDtl(EmfMap emfMap) throws Exception {
		//login info
		EmfMap lgnMap = (EmfMap)EgovUserDetailsHelper.getAuthenticatedUser();
		emfMap.put("regId", lgnMap.getString("id"));
		emfMap.put("regIp", lgnMap.getString("loginIp"));
		
		//get orderby
		EmfMap keyMap = coMainMngDAO.selectContentDtlGroup(emfMap);
		emfMap.put("orderBy", keyMap.getString("orderby"));

		//get 시퀀스
		emfMap.put("CNTNS_DTL_SEQ", mainContentDtlIdgen.getNextIntegerId());

		//파일 업로드
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
    			String local_file_nm = System.currentTimeMillis() + "_" + filenm + "." + ext;
    			
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
    	coMainMngDAO.insertContentDtl(emfMap);
	}
	
	@Override
	public EmfMap selectContentDtl(EmfMap emfMap) throws Exception {
		emfMap.put("rstMap", coMainMngDAO.selectContentDtl(emfMap));

		return emfMap;
	}
	
	@Override
	public void updateContentDtl(EmfMap emfMap) throws Exception {
		EmfMap lgnMap = (EmfMap)EgovUserDetailsHelper.getAuthenticatedUser();
		
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
    			String local_file_nm = System.currentTimeMillis() + "_" + filenm + "." + ext;
    			
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
    	coMainMngDAO.updateContentDtl(emfMap);
	}
	
	@Override
	public void deleteContentDtl(EmfMap emfMap) throws Exception {
    	coMainMngDAO.deleteContentDtl(emfMap);
    	
    	//전체 정렬
    	List<EmfMap> grpList = coMainMngDAO.reOrderContentDtlGrp(null);
    	if(!grpList.isEmpty())
    	{
    		for(EmfMap gList : grpList)
    		{
    			EmfMap gRow = new EmfMap();
    			gRow.put("cntnsMstSeq", gList.getString("cntnsMstSeq"));
    			List<EmfMap> grpVisaulList = coMainMngDAO.reOrderContentDtlGrpList(gRow);
    			int i = 1;
    			for(EmfMap gvList : grpVisaulList) 
    			{
    				EmfMap gvRow = new EmfMap();
    				gvRow.put("orderBy", i);
    				gvRow.put("contentDtlSeq", Integer.parseInt(gvList.getString("cntnsDtlSeq")));
    		    	coMainMngDAO.orderContentDtl(gvRow);
    				i++;
    			}
    		}
    	}
	}
	
	
	@Override
	public void orderContentDtl(EmfMap emfMap) throws Exception {
		String[] contentDtlSeq = emfMap.getString("contentDtlSeq").split(",");
		
		int i = 1;
		for(String cdSeq : contentDtlSeq)
		{
			emfMap.put("orderBy", i);
			emfMap.put("contentDtlSeq", Integer.parseInt(cdSeq));
	    	coMainMngDAO.orderContentDtl(emfMap);
	    	i++;
		}
	}
}
