package mngwserc.cn.cna.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
import mngwserc.cn.cna.service.CNADirectChoiceService;
import mngwserc.cn.cna.service.dao.CNADirectChoiceDAO;
import mngwserc.co.util.COPaginationUtil;

@Service("cNADirectChoiceService")
public class CNADirectChoiceServiceImpl extends EmfAbstractService implements CNADirectChoiceService {
	
	@Resource(name="cNADirectChoiceDAO")
	private CNADirectChoiceDAO cNADirectChoiceDAO;
	
	@Resource(name="directChoiIdgen")
	private EgovTableIdGnrService directChoiIdgen;
	
	@Resource(name="directChoiFileIdgen")
	private EgovTableIdGnrService directChoiFileIdgen;	
	
	private final static String img_path = EgovProperties.getProperty("Globals.directImageStorePath");
	

	/**
	 * 목록을 조회한다.
	 * 
	 * @param EmfMap
	 * @return EmfMap
	 * @throws Exception 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */ 
	@Override
	public EmfMap selectDirectChoiList(EmfMap emfMap) throws Exception {
		
		PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
		
		//페이징 처리
		emfMap.put("paginationInfo", paginationInfo);    	
		
		//리스트 가져오기
		List<EmfMap> list = cNADirectChoiceDAO.selectDirectChoiList(emfMap);
		
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
    * 다이렉트 초이스를 등록한다.
    * 
    * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
    */   
	@Override
	public void idci(EmfMap emfMap) throws Exception {
		EmfMap lgnMap = (EmfMap)EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("dirctSeq", directChoiIdgen.getNextIntegerId());
		emfMap.put("ptupDt", emfMap.getString("ptupDt").replaceAll("-", ""));
		emfMap.put("regId", lgnMap.getString("id"));
		emfMap.put("regIp", lgnMap.getString("loginIp"));
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		if("Y".equals(emfMap.getString("useYn"))) {
			// 모든 useYn을 N으로 변경
			cNADirectChoiceDAO.updateDirectChoiInfoN(emfMap);
		}
		
		cNADirectChoiceDAO.insertDirectChoiseInfo(emfMap);

		// 이미지 파일 저장
		List<EmfMap> list = new ArrayList<EmfMap>();
try {		
		MultipartHttpServletRequest mReq = (MultipartHttpServletRequest) emfMap.get("request");
		String path = mReq.getSession().getServletContext().getRealPath(img_path);
    	Iterator<String> iter = mReq.getFileNames();
    	MultipartFile mf = null;
    	
    	while(iter.hasNext()) {
    		mf = mReq.getFile(iter.next());
    		if(mf.isEmpty() == false) {
    			// 서버폴더에 이미지 저장

    				System.out.println("-------------------------------- 1");
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
	    			System.out.println("-------------------------------- 2");
	    			String name = mf.getName();
	    			String classification = name.contains("pc") == true ? "pc" : "mobile";
	    			String using = name.contains("main") == true ? "main" : "pop";
	    			String regOrder = name.substring(name.lastIndexOf("_")+1, name.length());
	    			
	    			EmfMap map = new EmfMap();
	    			System.out.println("-------------------------------- 3");
	    			map.put("fileSeq", directChoiFileIdgen.getNextIntegerId());
	    			map.put("classification", classification);
	    			map.put("name", name);
	    			map.put("fileNm", filenm);
	    			map.put("fileSize", size);
	    			map.put("fileType", ext);
	    			map.put("regOrder", regOrder);
	    			map.put("using", using);
	    			map.put("localFileName", local_file_nm);
	    			map.put("path", img_path);
	    			System.out.println("-------------------------------- 4");
	    			GetAllMapValue.getMapValue(map);
	    			
	    			list.add(map);
	    			
	    			System.out.println("-------------------------------- 5");
	    			System.out.println( img_path );
	    			System.out.println( local_file_nm );

    				EgovFileMngUtil.uploadFileImg(mf, img_path, local_file_nm);
    				System.out.println("-------------------------------- 6");

    		}
    	}
} catch (Exception e1) {
	e1.printStackTrace();
}

		emfMap.put("imgFile", list);
		
		cNADirectChoiceDAO.insertDirectChoiseFile(emfMap);
	}

	/**
	 * 다이렉트 초이스 상세정보 조회
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */  
	
	@Override
	public EmfMap selectDirectChoice(EmfMap emfMap) throws Exception {
		if(!"".equals(EMFStringUtil.nullConvert(emfMap.get("seq"))))
    	{
			EmfMap dirctInfo = cNADirectChoiceDAO.selectDirectChoice(emfMap);
	
	    	if(dirctInfo != null)
	    	{
				emfMap.put("dirctInfo", dirctInfo);
				
				emfMap.put("using", "main");
				List<EmfMap> imgFileList = cNADirectChoiceDAO.selectDirectChoiceFileInfo(emfMap);
				emfMap.put("imgFileList", imgFileList);
	    	}
    	}
		
		return emfMap;
	}
	
	/**
	 * 다이렉트 초이스 수정
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return void
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */  
	@Override
	public void udc(EmfMap emfMap) throws Exception {
		EmfMap lgnMap = (EmfMap)EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("seq", emfMap.getString("seq"));
		emfMap.put("ptupDt", emfMap.getString("ptupDt").replaceAll("-", ""));
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		if("Y".equals(emfMap.getString("useYn"))) {
			// 모든 useYn을 N으로 변경
			cNADirectChoiceDAO.updateDirectChoiInfoN(emfMap);
		}
				
		// 다이렉트 초이스 정보 수정
		cNADirectChoiceDAO.updateDirectChoiInfo(emfMap);
		
		// 영역삭제 및 팝업 노출 해제로 인한 파일의 삭제
		String[] del_fileseq_arr = emfMap.getString("delFileseq").split(",");
		List<String> del_fileseq_map = new ArrayList<String>();
		for(String s : del_fileseq_arr) {
			del_fileseq_map.add(s);
		}
		emfMap.put("delFileseq", del_fileseq_map);
		
		cNADirectChoiceDAO.deleteDirectChoiFileBySeq(emfMap);
		
		// 이미지 파일 저장
		MultipartHttpServletRequest mReq = (MultipartHttpServletRequest) emfMap.get("request");
		String path = mReq.getSession().getServletContext().getRealPath(img_path);
    	Iterator<String> iter = mReq.getFileNames();
    	MultipartFile mf = null;
		
//		pop_show
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
    			String using = name.contains("main") == true ? "main" : "pop";
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
    			EmfMap fileone = cNADirectChoiceDAO.selectDirectChoiFileOne(emfMap);	
    			
    			if(fileone != null) {	// 해당위치에 파일이 있으면 update
    				cNADirectChoiceDAO.updateDirectChoiFileInfo(emfMap);
    				
    			} else {	// 해당위치에 파일이 없으면 insert
    				map.put("fileSeq", directChoiFileIdgen.getNextIntegerId());
    				emfMap.put("fileInfo", map);
    				cNADirectChoiceDAO.insertDirectChoiFileOne(emfMap);
    			}
    		}
    	}
	}

	@Override
	public void ddcl(EmfMap emfMap) {
		// 선택된 목록 삭제
		cNADirectChoiceDAO.deleteDirectChoiList(emfMap);
		
		// 선택관련 이미지 삭제
		cNADirectChoiceDAO.deleteDirectChoiFileList(emfMap);
	}
	
	@Override
	public EmfMap selectFileInfoByFileSeq(EmfMap emfMap) {
		return cNADirectChoiceDAO.selectFileInfoByFileSeq(emfMap);
	}
}
