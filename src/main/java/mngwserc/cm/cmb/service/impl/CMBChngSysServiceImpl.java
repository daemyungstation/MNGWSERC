package mngwserc.cm.cmb.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import mngwserc.cm.cmb.service.CMBChngSysService;
import mngwserc.cm.cmb.service.dao.CMBChngSysDAO;
import mngwserc.cm.cmb.service.dao.CMBChngSysOutPrdctDAO;
import mngwserc.co.util.COPaginationUtil;

import org.springframework.stereotype.Service;

import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.idgnr.impl.EgovTableIdGnrService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import emf.core.extend.service.EmfAbstractService;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 전환서비스 체계 관리를 위한 ServiceImpl
 * </pre>
 * 
 * @ClassName		: CMBChngSysServiceImpl.java
 * @Description		: 전환서비스 체계 관리를 위한 ServiceImpl
 * @author 허진영
 * @since 2016.02.17
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2016.02.17		허진영					 최초생성
 * </pre>
 */
@Service("cMBChngSysService")
public class CMBChngSysServiceImpl extends EmfAbstractService implements CMBChngSysService {	
	
	@Resource(name="cMBChngSysDAO")
	private CMBChngSysDAO cMBChngSysDAO;
	
	@Resource(name="cMBChngSysOutPrdctDAO")
	private CMBChngSysOutPrdctDAO cMBChngSysOutPrdctDAO;
	
	@Resource(name="EgovCmmUseService")
    private EgovCmmUseService cmmUseService;
	
	@Resource(name="grpIdgen")
	private EgovTableIdGnrService grpIdgen;
	
	@Resource(name="grpPrdctIdgen")
	private EgovTableIdGnrService grpPrdctIdgen;

	/**
     * 전환서비스 쳬계 그룹 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public EmfMap selectChngSysGrpList(EmfMap emfMap) throws Exception
	{
		emfMap.put("list", cMBChngSysDAO.selectChngSysGrpList(emfMap));
		
		//공통코드 배열 셋팅
		ArrayList<String> cdDtlList = new ArrayList<String>();
		
		//상품 구분
		cdDtlList.add("PRDCT_GB");
		
		//정의된 코드id값들의 상세 코드 맵 반환		
		emfMap.put("cdDtlList", cmmUseService.selectCmmCodeBindAll(cdDtlList));
		
		//상품 리스트를 가져온다.
		List<EmfMap> prdctAllList = cMBChngSysDAO.getPrdctAllList();
    	
		//상품 구분별로 분리 처리를 한다.
    	EmfMap tmpMap = null;
    	
    	HashMap prdctMap = new HashMap();
    	
    	ArrayList<EmfMap> list;
    	
    	if(prdctAllList != null && prdctAllList.size() > 0)
    	{
    		for(int i = 0; i < prdctAllList.size(); i++)
        	{    		
        		tmpMap = (EmfMap) prdctAllList.get(i);
    			
        		if(prdctMap.get(tmpMap.getString("prdctCd")) == null)
    			{
        			prdctMap.put(tmpMap.getString("prdctCd"), new ArrayList<EmfMap>());
    			}
    			
        		list = (ArrayList<EmfMap>) prdctMap.get(tmpMap.getString("prdctCd"));
    			list.add(tmpMap);			
    		}
    	}
    	
    	EmfMap cdDtlMap = (EmfMap) emfMap.get("cdDtlList");
    	
    	ArrayList<EmfMap> prdctArr = (ArrayList<EmfMap>) cdDtlMap.get("prdctGb");
    	
    	String prdctCd = "";
    	
    	if(prdctArr != null && prdctArr.size() > 0)
    	{
    		for(int i = 0; i < prdctArr.size(); i++)
        	{
    			prdctCd = prdctArr.get(i).getString("cd");

    			if(prdctMap.get(prdctCd) != null)
    			{
    				emfMap.put(prdctCd, (ArrayList<EmfMap>) prdctMap.get(prdctCd));
    			}
    		}
    	}

    	return emfMap;
	}
	
	/**
     * 전환서비스 쳬계 그룹을 등록을 위해 중복 검사를 한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public int getChngSysGrpNmExstCnt(EmfMap emfMap) throws Exception
	{
		return cMBChngSysDAO.getChngSysGrpNmExstCnt(emfMap);
	}

	/**
     * 전환서비스 쳬계 그룹을 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public int insertChngSysGrp(EmfMap emfMap) throws Exception 
	{
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		//그룹순번을 가져온다.
		int grpSeq = grpIdgen.getNextIntegerId();
		
		emfMap.put("grpSeq", grpSeq);
		emfMap.put("regId", lgnMap.getString("id"));
		emfMap.put("regIp", lgnMap.getString("loginIp"));
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		//전환서비스 쳬계 그룹을 등록한다.
		cMBChngSysDAO.insertChngSysGrp(emfMap);
		
		//전환서비스 쳬계 그룹 상품정보를 등록한다.
		cMBChngSysDAO.insertChngSysGrpDtl(emfMap);
		
		return grpSeq;
	}
	
	/**
     * 전환서비스 쳬계 그룹을 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateChngSysGrp(EmfMap emfMap) throws Exception 
	{
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("regId", lgnMap.getString("id"));
		emfMap.put("regIp", lgnMap.getString("loginIp"));
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		//전환서비스 쳬계 그룹 상품정보를 수정한다.
		String[] prdctCd = emfMap.getString("prdctCdArr").split(",");
		String[] prdctSeq = emfMap.getString("prdctSeqArr").split(",", prdctCd.length);

		for(int i = 0; i < prdctCd.length; i++)
		{
			emfMap.put("prdctCd", prdctCd[i]);
			emfMap.put("prdctSeq", prdctSeq[i]);
			
			cMBChngSysDAO.updateChngSysGrpDtl(emfMap);
		}
	}
	
	/**
     * 전환서비스 쳬계 그룹을 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteChngSysGrp(EmfMap emfMap) throws Exception
	{
		//전환서비스 쳬계 그룹을 삭제한다.
		cMBChngSysDAO.deleteChngSysGrp(emfMap);
		
		//전환서비스 쳬계 그룹 상품정보를 삭제한다.
		cMBChngSysDAO.deleteChngSysGrpDtl(emfMap);
		
		//전환서비스 쳬계 그룹 상품을 삭제한다.
		cMBChngSysDAO.deleteChngSysGrpPrdct(emfMap);
	}

	/**
     * 전환서비스 쳬계 그룹 상품 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public EmfMap selectChngSysGrpPrdctList(EmfMap emfMap) throws Exception 
	{
		PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
		
		//페이징 처리
		emfMap.put("paginationInfo", paginationInfo);    	
		
		//리스트 가져오기
		List<EmfMap> list = cMBChngSysDAO.selectChngSysGrpPrdctList(emfMap);
		
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
		
		//상품 구분
		cdDtlList.add("PRDCT_GB");
		
		//정의된 코드id값들의 상세 코드 맵 반환		
		emfMap.put("cdDtlList", cmmUseService.selectCmmCodeBindAll(cdDtlList));
		
		//전환서비스 체계 그룹 상세를 가져온다.
		emfMap.put("chngSysGrpDtl", cMBChngSysDAO.getChngSysGrpDtl(emfMap));
		
		return emfMap;
	}
	
	/**
     * 전환서비스 쳬계 그룹명을 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateChngSysGrpNm(EmfMap emfMap) throws Exception 
	{
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		cMBChngSysDAO.updateChngSysGrpNm(emfMap);
	}
	
	/**
     * 전환서비스 쳬계 외부상품(엔컴) 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public EmfMap selectChngSysOutPrdctList(EmfMap emfMap) throws Exception 
	{
		PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
		
		//페이징 처리
		emfMap.put("paginationInfo", paginationInfo);
		
		//전환서비스 체계 그룹에 등록된 상품을 가져온다.
		List<EmfMap> prdctList = cMBChngSysDAO.getChngSysGrpPrdctAllList(emfMap);
		
		String [] prdctArr;
		
		if(prdctList != null && prdctList.size() > 0)
		{
			prdctArr = new String[prdctList.size()];
			
			for(int i = 0; i < prdctList.size(); i++)
			{
				prdctArr[i] = prdctList.get(i).getString("outPrdctCd");
			}
			
			emfMap.put("prdctArr", prdctArr);
		}
		
		//리스트 가져오기
		List<EmfMap> list = cMBChngSysOutPrdctDAO.selectChngSysOutPrdctList(emfMap);
		
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
     * 전환서비스 쳬계 그룹 상품을 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertChngSysGrpPrdct(EmfMap emfMap) throws Exception 
	{
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("regId", lgnMap.getString("id"));
		emfMap.put("regIp", lgnMap.getString("loginIp"));
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		//전환서비스 쳬계 그룹 상품을 등록한다.
		String[] prodCdArr = emfMap.getString("prodCdArr").split(",");
		String[] prodNmArr = emfMap.getString("prodNmArr").split(",");
		
		for(int i = 0; i < prodCdArr.length; i++)
		{
			emfMap.put("grpPrdctSeq", grpPrdctIdgen.getNextIntegerId());
			emfMap.put("outPrdctCd", prodCdArr[i]);
			emfMap.put("outPrdctNm", prodNmArr[i]);
			
			cMBChngSysDAO.insertChngSysGrpPrdct(emfMap);
		}
	}

	/**
     * 전환서비스 쳬계 그룹 상품을 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteChngSysGrpPrdctList(int[] delSeq) throws Exception 
	{
		EmfMap emfMap = new EmfMap();
		
		emfMap.put("delSeq", delSeq);
		
		cMBChngSysDAO.deleteChngSysGrpPrdct(emfMap);
	}
	
	/**
     * 전환서비스 쳬계 그룹 상품 목록을 조회한다. (엑셀 다운로드)
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public List<EmfMap> excelChngSysGrpPrdctList(EmfMap emfMap) throws Exception
	{
		return cMBChngSysDAO.excelChngSysGrpPrdctList(emfMap);
	}
}
