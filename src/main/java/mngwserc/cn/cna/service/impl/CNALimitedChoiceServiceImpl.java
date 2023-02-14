package mngwserc.cn.cna.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

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
import mngwserc.cn.cna.service.CNALimitedChoiceService;
import mngwserc.cn.cna.service.dao.CNALimitedChoiceDAO;
import mngwserc.co.util.COPaginationUtil;

@Service("cNALimitedChoiceService")
public class CNALimitedChoiceServiceImpl extends EmfAbstractService implements CNALimitedChoiceService {
	
	@Resource(name="cNALimitedChoiceDAO")
	private CNALimitedChoiceDAO cNALimitedChoiceDAO;
	
	@Resource(name="limitedChoiIdgen")
	private EgovTableIdGnrService limitedChoiIdgen;
	
	@Resource(name="limitedChoiFileIdgen")
	private EgovTableIdGnrService limitedChoiFileIdgen;	
	
	private final static String img_path = EgovProperties.getProperty("Globals.limitedImageStorePath");

	/**
	 * 목록을 조회한다.
	 * 
	 * @param EmfMap
	 * @return EmfMap
	 * @throws Exception 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */ 
	@Override
	public EmfMap selectLimitedChoiList(EmfMap emfMap) throws Exception {
		
		PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
		
		//페이징 처리
		emfMap.put("paginationInfo", paginationInfo);    	
		
		//리스트 가져오기
		List<EmfMap> list = cNALimitedChoiceDAO.selectLimitedChoiList(emfMap);
		
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
	 * YYYY-MM-DD 형식의 날짜를 date 형식으로 변경
	 * @param str_date
	 * @return
	 */
	public Date getDate(String str_date) {
		String year = str_date.split("-")[0];
		String month = str_date.split("-")[1];
		String date = str_date.split("-")[2];
		
		Calendar cal = Calendar.getInstance();
		cal.set(Integer.parseInt(year), Integer.parseInt(month)-1, Integer.parseInt(date));
		cal.set(Calendar.MILLISECOND, 0);
		
		return cal.getTime();
	}
	
   /**
    * 리미티드 초이스를 등록한다.
    * 
    * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
    */   
	@Override
	public void ilci(EmfMap emfMap) throws Exception {
		EmfMap lgnMap = (EmfMap)EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("limtSeq", limitedChoiIdgen.getNextIntegerId());
		emfMap.put("ptupDt", emfMap.getString("ptupDt").replaceAll("-", ""));
		emfMap.put("regId", lgnMap.getString("id"));
		emfMap.put("regIp", lgnMap.getString("loginIp"));
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		emfMap.put("startDtm", getDate(emfMap.getString("startDtm")));
		emfMap.put("endDtm", getDate(emfMap.getString("endDtm")));

		if("Y".equals(emfMap.getString("oprtYn"))) {
			// 모든 oprtYn을 N으로 변경
			cNALimitedChoiceDAO.updateLimitedChoiInfoN(emfMap);
		}
		
		cNALimitedChoiceDAO.insertLimitedChoiseInfo(emfMap);

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
    			
    			String classification = "";
    			if(name.contains("pc")) {
    				classification = "pc";
    			} else if(name.contains("mobile")) {
    				classification = "mobile";
    			} else {
    				classification = "thumb";
    			}
    			
    			String using = "";
				if(name.contains("main")) {
					using = "main";
				} else {
					using = "pop";
				}
				
				String regOrder = name.substring(name.lastIndexOf("_")+1, name.length());
					
    			EmfMap map = new EmfMap();
    			
    			map.put("fileSeq", limitedChoiFileIdgen.getNextIntegerId());
    			map.put("classification", classification);
    			map.put("name", name);
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
		
		cNALimitedChoiceDAO.insertLimitedChoiseFile(emfMap);
	}

	/**
	 * 리미티드 초이스 상세정보 조회
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */  
	
	@Override
	public EmfMap selectLimitedChoice(EmfMap emfMap) throws Exception {
		if(!"".equals(EMFStringUtil.nullConvert(emfMap.get("seq"))))
    	{
			EmfMap limtInfo = cNALimitedChoiceDAO.selectLimitedChoice(emfMap);
			
	    	if(limtInfo != null)
	    	{
				emfMap.put("limtInfo", limtInfo);
				
				emfMap.put("using", "main");
				List<EmfMap> imgFileList = cNALimitedChoiceDAO.selectLimitedChoiceFileInfo(emfMap);
				emfMap.put("imgFileList", imgFileList);
	    	}
    	}
		
		return emfMap;
	}
	
	/**
	 * 리미티드 초이스 수정
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return void
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */  
	@Override
	public void ulc(EmfMap emfMap) throws Exception {
		EmfMap lgnMap = (EmfMap)EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("seq", emfMap.getString("seq"));
		emfMap.put("ptupDt", emfMap.getString("ptupDt").replaceAll("-", ""));
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		emfMap.put("startDtm", getDate(emfMap.getString("startDtm")));
		emfMap.put("endDtm", getDate(emfMap.getString("endDtm")));
		
		if("Y".equals(emfMap.getString("oprtYn"))) {
			// 모든 oprtYn을 N으로 변경
			cNALimitedChoiceDAO.updateLimitedChoiInfoN(emfMap);
		}
				
		cNALimitedChoiceDAO.updateLimitedChoiInfo(emfMap);
		
		// 영역삭제 및 팝업 노출 해제로 인한 파일의 삭제
		if(emfMap.getString("delFileseq").length() > 0) {
			String[] del_fileseq_arr = emfMap.getString("delFileseq").split(",");
			
			List<String> del_fileseq_map = new ArrayList<String>();
			for(String s : del_fileseq_arr) {
				del_fileseq_map.add(s);
			}
			emfMap.put("delFileseq", del_fileseq_map);
			
			cNALimitedChoiceDAO.deleteLimitedChoiFileBySeq(emfMap);
		}
		
		// 이미지 파일 저장
		MultipartHttpServletRequest mReq = (MultipartHttpServletRequest) emfMap.get("request");
		String path = mReq.getSession().getServletContext().getRealPath(img_path);
    	Iterator<String> iter = mReq.getFileNames();
    	MultipartFile mf = null;
		
//			pop_show
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
    			
    			String classification = "";
    			if(name.contains("pc")) {
    				classification = "pc";
    			} else if(name.contains("mobile")) {
    				classification = "mobile";
    			} else {
    				classification = "thumb";
    			}
    			
    			String using = "";
    			if(name.contains("main")) {
					using = "main";
				} else {
					using = "pop";
				}
    			
    			String regOrder = name.substring(name.lastIndexOf("_")+1, name.length());
    			
    			EmfMap map = new EmfMap();
    			
    			map.put("classification", classification);
    			map.put("fileNm", filenm);
    			map.put("fileSize", size);
    			map.put("fileType", ext);
    			map.put("using", using);
    			map.put("regOrder", regOrder);
    			map.put("localFileName", local_file_nm);
    			map.put("path", img_path);
    			
    			// 서버폴더에 이미지 저장
    			try {
    				EgovFileMngUtil.uploadFileImg(mf, img_path, local_file_nm);
    			} catch (IOException e) {
					e.printStackTrace();
				}
    			
    			emfMap.put("fileInfo", map);
    			
    			// 수정하려는 파일의 위치에 파일이 있는지 체크
    			EmfMap fileone = cNALimitedChoiceDAO.selectLimitedChoiFileOne(emfMap);
    			
    			if(fileone != null) {	// 해당위치에 파일이 있으면 update
    				cNALimitedChoiceDAO.updateLimitedChoiFileInfo(emfMap);
    			} else {	// 해당위치에 파일이 없으면 insert
    				map.put("fileSeq", limitedChoiFileIdgen.getNextIntegerId());
    				emfMap.put("fileInfo", map);
    				cNALimitedChoiceDAO.insertLimitedChoiFileOne(emfMap);
    			}
    		}
    	}
	}

	@Override
	public void dlcl(EmfMap emfMap)  throws Exception {
		// 선택된 목록 삭제
		cNALimitedChoiceDAO.deleteLimitedChoiList(emfMap);
		
		// 선택관련 이미지 삭제
		cNALimitedChoiceDAO.deleteLimitedChoiFileList(emfMap);
	}

	@Override
	public EmfMap selectFileInfoByFileSeq(EmfMap emfMap) {
		return cNALimitedChoiceDAO.selectFileInfoByFileSeq(emfMap);
	}
}
