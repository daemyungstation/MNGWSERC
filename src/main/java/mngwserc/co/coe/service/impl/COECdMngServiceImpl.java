package mngwserc.co.coe.service.impl;

import java.util.List; 

import javax.annotation.Resource;

import mngwserc.cm.cme.service.CMETermsGroupMngService;
import mngwserc.co.coe.service.COECdMngService;
import mngwserc.co.coe.service.dao.COECdMngDAO;


import org.springframework.stereotype.Service;

import egovframework.com.cmm.util.EgovUserDetailsHelper;
import emf.core.extend.service.EmfAbstractService;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 코드 관리를 위한 ServiceImpl
 * </pre>
 * 
 * @ClassName		: COECdMngServiceImpl.java
 * @Description		: 코드 관리를 위한 ServiceImpl
 * @author 박주석
 * @since 2015.11.12
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2015.11.12		박주석					최초생성
 * </pre>
 */
@Service("cOECdMngService")
public class COECdMngServiceImpl extends EmfAbstractService implements COECdMngService {
	
	@Resource(name="cOECdMngDAO")
	private COECdMngDAO cOECdMngDAO;	
	
	@Resource(name = "cMETermsGroupMngService")
    private CMETermsGroupMngService cMETermsGroupMngService;
	
	/**
	 * 상위코드 목록을 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return List<EmfMap> 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectCdIdList(EmfMap emfMap) throws Exception
	{
		return cOECdMngDAO.selectCdIdList(emfMap);
	}
	
	/**
	 * 하위코드 목록을 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return List<EmfMap> 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectCdIdDtl(EmfMap emfMap) throws Exception
	{
		return cOECdMngDAO.selectCdIdDtl(emfMap);
	}
	
	/**
	 * 상위코드를 등록한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void insertCode(EmfMap emfMap) throws Exception
	{
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("regId", lgnMap.getString("id"));
		emfMap.put("regIp", lgnMap.getString("loginIp"));
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		cOECdMngDAO.insertCode(emfMap);
	}
	
	/**
	 * 상위코드를 수정한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void updateCode(EmfMap emfMap) throws Exception
	{
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));

		cOECdMngDAO.updateCode(emfMap);
	}
	
	/**
	 * 상위코드를 삭제한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void deleteCode(EmfMap emfMap) throws Exception
	{
		cOECdMngDAO.deleteCode(emfMap);
	}
	
	/**
	 * 하위코드를 등록한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void insertCodeDetail(EmfMap emfMap) throws Exception
	{
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("regId", lgnMap.getString("id"));
		emfMap.put("regIp", lgnMap.getString("loginIp"));
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));

		cOECdMngDAO.insertCodeDetail(emfMap);
		
		if("TRS_GB".equals(emfMap.get("cdId")) || "CONTRACT_GB".equals(emfMap.get("cdId"))){
			cMETermsGroupMngService.insertAddTerms(emfMap);
		}
	}
	
	/**
	 * 하위코드를 수정한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void updateCodeDetail(EmfMap emfMap) throws Exception
	{
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		cOECdMngDAO.updateCodeDetail(emfMap);
	}
	
	/**
	 * 하위코드를 삭제한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void deleteCodeDetail(EmfMap emfMap) throws Exception
	{
		cOECdMngDAO.deleteCodeDetail(emfMap);
	}

	/**
	 * 파라미터로 넘긴 값의 CDNM을 불러온다
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectCodeNm(EmfMap emfMap) throws Exception 
	{
		return cOECdMngDAO.selectCodeNm(emfMap);
	}	
}
