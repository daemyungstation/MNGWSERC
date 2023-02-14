package mngwserc.cs.csa.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import mngwserc.co.util.COPaginationUtil;
import mngwserc.cs.csa.service.CSAAlncCnslService;
import mngwserc.cs.csa.service.dao.CSAAlncCnslDAO;

import org.springframework.stereotype.Service;

import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.service.EgovFileMngService;
import egovframework.com.cmm.service.EgovProperties;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.com.utl.sim.service.SeedCipher;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import emf.core.extend.service.EmfAbstractService;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 제휴 상담관리를 위한 ServiceImpl
 * </pre>
 * 
 * @ClassName		: CSAAlncCnslServiceImpl.java
 * @Description		: 제휴 상담관리를 위한 ServiceImpl
 * @author 허진영
 * @since 2016.02.04
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2016.02.04		허진영					 최초생성
 * </pre>
 */ 
@Service("cSAAlncCnslService")
public class CSAAlncCnslServiceImpl extends EmfAbstractService implements CSAAlncCnslService {
	
	@Resource(name="cSAAlncCnslDAO")
	private CSAAlncCnslDAO cSAAlncCnslDAO;
	
	@Resource(name="EgovCmmUseService")
    private EgovCmmUseService cmmUseService;
	
    @Resource(name = "EgovFileMngService")
    private EgovFileMngService fileMngService;
    
    private String ENCODE = EgovProperties.getProperty("Global.CHARCODE");
	
	/**
     * 제휴 상담 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectAlncCnslList(EmfMap emfMap) throws Exception
    {
    	PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
		
		//페이징 처리
		emfMap.put("paginationInfo", paginationInfo);    	
		
		//리스트 가져오기
		List<EmfMap> list = cSAAlncCnslDAO.selectAlncCnslList(emfMap);
		
		emfMap.put("list", list);
		
		if(list.size() > 0)
		{
			paginationInfo.setTotalRecordCount(Integer.parseInt(list.get(0).getString("totCnt")));
		}
		else
		{
			paginationInfo.setTotalRecordCount(0);
		}
		
		//공통코드 배열 셋팅
		ArrayList<String> cdDtlList = new ArrayList<String>();
		
		//제휴상담 구분
		cdDtlList.add("ALNC_INQRY_GB");
		
		//처리현황 TYPE
		cdDtlList.add("PROCESS_TYPE");
		
		//정의된 코드id값들의 상세 코드 맵 반환		
		emfMap.put("cdDtlList", cmmUseService.selectCmmCodeBindAll(cdDtlList));
		
		return emfMap;
    }
    
    /**
     * 제휴 상담 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectAlncCnsl(EmfMap emfMap) throws Exception
    {
		EmfMap alncCnslInfo = cSAAlncCnslDAO.selectAlncCnsl(emfMap);
		
    	if(alncCnslInfo != null)
    	{
    		emfMap.put("alncCnslInfo", alncCnslInfo);
    		//2017.04.24 박주석 디아모 솔루션 도입 작업
//    		if(!"".equals(EMFStringUtil.nullConvert(alncCnslInfo.get("ctel"))))
//    		{
//    			alncCnslInfo.put("ctel", SeedCipher.decrypt(alncCnslInfo.getString("ctel"), ENCODE));
//    		}
//    		
//    		if(!"".equals(EMFStringUtil.nullConvert(alncCnslInfo.get("email"))))
//    		{
//    			alncCnslInfo.put("email", SeedCipher.decrypt(alncCnslInfo.getString("email"), ENCODE));
//    		}
    		
    		if(!"".equals(EMFStringUtil.nullConvert(alncCnslInfo.get("atchFileId"))))
    		{
    			emfMap.put("fileList", fileMngService.selectFileInfs(alncCnslInfo));
    		}
    		
    		// 관리자 정보를 가져온다.
    		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
    		
    		emfMap.put("taskGb", "R");
    		emfMap.put("prcsCd", "02");
    		emfMap.put("modId", lgnMap.getString("id"));
    		emfMap.put("modIp", lgnMap.getString("loginIp"));
    		
    		// 제휴 상담 처리상태를 수정한다.
    		cSAAlncCnslDAO.updateAlncCnslPrcsCd(emfMap);
    		
    		// 확인로그등록
	    	cSAAlncCnslDAO.insertAlncCnslLog(emfMap);
    		
    		// 제휴 상담 로그를 조회한다.
    		emfMap.put("alncCnslLog", cSAAlncCnslDAO.selectAlncCnslLog(alncCnslInfo));
    	}
    	
    	return emfMap;
    }
    
	/**
     * 제휴 상담 답변을 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateAlncCnslAnsw(EmfMap emfMap) throws Exception
	{
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("taskGb", "A");
		emfMap.put("prcsCd", "03");
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		// 답변등록
		cSAAlncCnslDAO.updateAlncCnslAnsw(emfMap);
		
		// 제휴 상담 처리상태를 수정한다.
		cSAAlncCnslDAO.updateAlncCnslPrcsCd(emfMap);
		
		// 답변로그등록
		cSAAlncCnslDAO.insertAlncCnslLog(emfMap);
	}
	
	/**
     * 제휴 상담을 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteAlncCnslList(int[] delSeq) throws Exception
	{
		EmfMap emfMap = new EmfMap();
		
		emfMap.put("delSeq", delSeq);
		
		cSAAlncCnslDAO.deleteAlncCnsl(emfMap);
	}
}
