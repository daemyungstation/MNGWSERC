package mngwserc.cs.csa.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import mngwserc.co.util.COPaginationUtil;
import mngwserc.cs.csa.service.CSAJoinCnslService;
import mngwserc.cs.csa.service.dao.CSAJoinCnslDAO;
import mngwserc.cs.csa.service.dao.DMLifeMemDAO;

import org.springframework.stereotype.Service;

import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.service.EgovProperties;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import emf.core.extend.service.EmfAbstractService;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 가입 상담관리를 위한 ServiceImpl
 * </pre>
 * 
 * @ClassName		: CSAJoinCnslServiceImpl.java
 * @Description		: 가입 상담관리를 위한 ServiceImpl
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
@Service("cSAJoinCnslService")
public class CSAJoinCnslServiceImpl extends EmfAbstractService implements CSAJoinCnslService {
	
	@Resource(name="cSAJoinCnslDAO")
	private CSAJoinCnslDAO cSAJoinCnslDAO;
	
	@Resource(name="dMLifeMemDAO")
	private DMLifeMemDAO dMLifeMemDAO;
	
	@Resource(name="EgovCmmUseService")
    private EgovCmmUseService cmmUseService;
	
	private String ENCODE = EgovProperties.getProperty("Global.CHARCODE");
	
	/**
     * 가입 상담 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectJoinCnslList(EmfMap emfMap) throws Exception
    {
    	PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
    	
		emfMap.put("paginationInfo", paginationInfo);    	
		
		List<EmfMap> list = cSAJoinCnslDAO.selectJoinCnslList(emfMap);
		
		if(list.size() > 0)
		{
			EmfMap tmpMap = new EmfMap();
			EmfMap tmpMap2 = new EmfMap();
			EmfMap tmpMap3 = new EmfMap();
			
			List<String> cellList = new ArrayList<String>();
			List<String> nameList = new ArrayList<String>();
			
			for(int i = 0; i < list.size(); i++)
			{
				tmpMap = list.get(i);
				//2017.04.24 박주석 디아모 솔루션 도입 작업
//				if(!"".equals(EMFStringUtil.nullConvert(tmpMap.get("ctel"))))
//				{
//					tmpMap.put("ctel", SeedCipher.decrypt(tmpMap.getString("ctel"), ENCODE));
//				}
				
				nameList.add(tmpMap.getString("name"));
				if(!"".equals(tmpMap.getString("ctel"))){
					cellList.add(tmpMap.getString("ctel").replace("-", ""));
				}
				
				list.get(i).put("ctel", tmpMap.getString("ctel"));
			}

			EmfMap dmLifeMem = new EmfMap();
			dmLifeMem.put("name", nameList);
			dmLifeMem.put("cell", cellList);
			
			List<EmfMap> memNoList = dMLifeMemDAO.selectDMLifeMemInf(dmLifeMem); 
			
			if(memNoList.size() > 0){
				for(int i = 0 ; i < memNoList.size() ; i++){
					tmpMap2 = memNoList.get(i);

					for(int j = 0 ; j < list.size() ; j++){
						tmpMap3 = list.get(j);	
						
						if(!"".equals(tmpMap3.getString("ctel"))){
							if(tmpMap3.getString("ctel").replace("-", "").equals(tmpMap2.getString("cell"))){
								list.get(j).put("memNo", tmpMap2.getString("memNo"));
								list.get(j).put("accntNo", tmpMap2.getString("accntNo"));
								list.get(j).put("prodNm", tmpMap2.getString("prodNm"));
								list.get(j).put("joinDt", tmpMap2.getString("joinDt"));
							}
						}						
					}
				}
			}
			
			emfMap.put("list", list);
			paginationInfo.setTotalRecordCount(Integer.parseInt(list.get(0).getString("totCnt")));
		}
		else
		{
			paginationInfo.setTotalRecordCount(0);
		}
		
		//공통코드 배열 셋팅
		ArrayList<String> cdDtlList = new ArrayList<String>();
		
		//상담구분 TYPE
		cdDtlList.add("JOIN_INQRY_GB");
		
		//처리현황 TYPE
		cdDtlList.add("PROCESS_TYPE");
		
		//정의된 코드id값들의 상세 코드 맵 반환		
		emfMap.put("cdDtlList", cmmUseService.selectCmmCodeBindAll(cdDtlList));
		
		return emfMap;
    }
    
    /**
     * 가입 상담 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectJoinCnsl(EmfMap emfMap) throws Exception
    {
		EmfMap joinCnslInfo = cSAJoinCnslDAO.selectJoinCnsl(emfMap);

		if(joinCnslInfo != null)
    	{
			emfMap.put("joinCnslInfo", joinCnslInfo);
			//2017.04.24 박주석 디아모 솔루션 도입 작업
//			if(!"".equals(EMFStringUtil.nullConvert(joinCnslInfo.get("ctel"))))
//    		{
//				joinCnslInfo.put("ctel", SeedCipher.decrypt(joinCnslInfo.getString("ctel"), ENCODE));
//    		}
//    		
//    		if(!"".equals(EMFStringUtil.nullConvert(joinCnslInfo.get("email"))))
//    		{
//    			joinCnslInfo.put("email", SeedCipher.decrypt(joinCnslInfo.getString("email"), ENCODE));
//    		}
			
    		// 관리자 정보를 가져온다.
    		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
    		
    		emfMap.put("taskGb", "R");
    		emfMap.put("prcsCd", "02");
    		emfMap.put("modId", lgnMap.getString("id"));
    		emfMap.put("modIp", lgnMap.getString("loginIp"));
    		
    		// 가입 상담 처리상태를 수정한다.
    		cSAJoinCnslDAO.updateJoinCnslPrcsCd(emfMap);
    		
    		// 확인로그등록
	    	cSAJoinCnslDAO.insertJoinCnslLog(emfMap);
	    	
	    	// 가입 상담 로그를 조회한다.
    		emfMap.put("joinCnslLog", cSAJoinCnslDAO.selectJoinCnslLog(joinCnslInfo));
    	}
    	
    	return emfMap;
    }
    
	/**
     * 가입 상담 답변을 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateJoinCnslAnsw(EmfMap emfMap) throws Exception
	{
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("taskGb", "A");
		emfMap.put("prcsCd", "03");
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		// 답변등록
		cSAJoinCnslDAO.updateJoinCnslAnsw(emfMap);
		
		// 가입 상담 처리상태를 수정한다.
		cSAJoinCnslDAO.updateJoinCnslPrcsCd(emfMap);
		
		// 답변로그등록
		cSAJoinCnslDAO.insertJoinCnslLog(emfMap);
	}
	
	/**
     * 가입 상담을 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteJoinCnslList(int[] delSeq) throws Exception
	{
		EmfMap emfMap = new EmfMap();
		
		emfMap.put("delSeq", delSeq);
		
		cSAJoinCnslDAO.deleteJoinCnsl(emfMap);
	}
	
	/**
     * 가입 상담 목록을 조회한다. (엑셀 다운로드)
     * 
     * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public List<EmfMap> excelJoinCnslList(EmfMap emfMap) throws Exception
    {
    	List<EmfMap> list = cSAJoinCnslDAO.excelJoinCnslList(emfMap);
 /*   	
    	if(list.size() > 0)
		{
    		EmfMap tmpMap = new EmfMap();
    		EmfMap tmpMap2 = new EmfMap();
    		EmfMap tmpMap3 = new EmfMap();
    		
    		List<String> cellList = new ArrayList<String>();
    		List<String> nameList = new ArrayList<String>();
    		
    		for(int i = 0; i < list.size(); i++)
    		{
    			tmpMap = list.get(i);
    			//2017.04.24 박주석 디아모 솔루션 도입 작업
//    			if(!"".equals(EMFStringUtil.nullConvert(tmpMap.get("ctel"))))
//    			{
//    				tmpMap.put("ctel", SeedCipher.decrypt(tmpMap.getString("ctel"), ENCODE));
//    			}
    			
    			nameList.add(tmpMap.getString("name"));
    			if(!"".equals(tmpMap.getString("ctel"))){
    				cellList.add(tmpMap.getString("ctel").replace("-", ""));
    			}
    			
    			list.get(i).put("ctel", tmpMap.getString("ctel"));
    		}

    		EmfMap dmLifeMem = new EmfMap();
    		dmLifeMem.put("name", nameList);
    		dmLifeMem.put("cell", cellList);
    		
    		List<EmfMap> memNoList = dMLifeMemDAO.selectDMLifeMemInf(emfMap); 
    		
    		if(memNoList.size() > 0){
    			for(int i = 0 ; i < memNoList.size() ; i++){
    				tmpMap2 = memNoList.get(i);

    				for(int j = 0 ; j < list.size() ; j++){
    					tmpMap3 = list.get(j);	
    					
    					if(!"".equals(tmpMap3.getString("ctel"))){
    						if(tmpMap3.getString("ctel").replace("-", "").equals(tmpMap2.getString("cell"))){
    							list.get(j).put("memNo", tmpMap2.getString("memNo"));
    							list.get(j).put("accntNo", tmpMap2.getString("accntNo"));
    							list.get(j).put("prodNm", tmpMap2.getString("prodNm"));
    							list.get(j).put("joinDt", tmpMap2.getString("joinDt"));
    						}
    					}						
    				}
    			}
    		}
		}*/

    	//emfMap.put("list", list);
    	
    	return list;
    }
}
