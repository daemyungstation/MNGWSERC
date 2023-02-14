package mngwserc.om.oma.service.dao;

import java.util.List;

import mngwserc.om.oma.service.impl.OMACounselExcelHandler;

import org.springframework.stereotype.Repository;

import emf.core.extend.dao.EmfAbstractDAO;
import emf.core.vo.EmfMap;
/**
 * <pre> 
 * 외주업체 상담관리를 위한 DAO (DB접속계정 : dmweb)
 * </pre>
 * 
 * @ClassName		: OMACounselMngDAO.java
 * @Description		: 외주업체 상담관리를 위한 DAO
 * @author 김필기
 * @since 2016.02.12
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2016.02.12		김필기					 최초생성
 * </pre>
 */
@Repository("oMACounselMngDAO")
public class OMACounselMngDAO extends EmfAbstractDAO {
	
	/**
	 * 외주업체 상담관리 목록을 조회한다.
	 * 
	 * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectCounselMngList(EmfMap emfMap) throws Exception 
    {
    	return list("OMACounselMngDAO.selectCounselMngList", emfMap);
    }
	
	/**
	 * 외주업체 LGU 상담관리 목록을 조회한다.
	 * 
	 * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectCounselMngLGUList(EmfMap emfMap) throws Exception 
    {
    	return list("OMACounselMngDAO.selectCounselMngLGUList", emfMap);
    }
	
	/**
	 * 외주업체 상담관리 목록을 조회한다.
	 * 
	 * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectCounselMngListUPLUSSAVE() throws Exception 
    {
    	return list("OMACounselMngDAO.selectCounselMngListUPLUSSAVE", null);
    }
	
	/**
     * 외주업체 상담관리 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectCounselMng(EmfMap emfMap) throws Exception 
    {
    	return (EmfMap) selectByPk("OMACounselMngDAO.selectCounselMng", emfMap);
    }
    
    /**
     * 외주업체 상담관리 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectCounselLGMng(EmfMap emfMap) throws Exception 
    {
    	return (EmfMap) selectByPk("OMACounselMngDAO.selectCounselLGMng", emfMap);
    }
    
    /**
     * 외주업체 상담관리을 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertCounselMng(EmfMap emfMap) throws Exception 
	{
		insert("OMACounselMngDAO.insertCounselMng", emfMap);
    }
    
	/**
     *외주업체 상담관리을 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateCounselMng(EmfMap emfMap) throws Exception 
	{
		update("OMACounselMngDAO.updateCounselMng", emfMap);
    }
	
	/**
     * 외주업체 상담관리을 삭제한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteCounselMng(EmfMap emfMap) throws Exception
	{
		delete("OMACounselMngDAO.deleteCounselMng", emfMap);
	}
	
	/**
     *외주업체 상담관리을 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateCounselLGUMng(EmfMap emfMap) throws Exception 
	{
		update("OMACounselMngDAO.updateCounselLGUMng", emfMap);
    }
	
	/**
     * 외주업체 상담관리 상담내역 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public List<EmfMap> selectCounselLGUDtlList(EmfMap emfMap) throws Exception 
    {
    	return list("OMACounselMngDAO.selectCounselLGUDtlList", emfMap);
    }
	
	/**
     * 외주업체 상담관리 상담내역 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public List<EmfMap> selectCounselDtlList(EmfMap emfMap) throws Exception 
    {
    	return list("OMACounselMngDAO.selectCounselDtlList", emfMap);
    }
	
	/**
     * 외주업체 상담관리 상담내역을 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertCounselDtl(EmfMap emfMap) throws Exception 
	{
		insert("OMACounselMngDAO.insertCounselDtl", emfMap);
    }
	
	/**
     * 외주업체 상담관리 상담내역을 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertCounselLGUDtl(EmfMap emfMap) throws Exception 
	{
		insert("OMACounselMngDAO.insertCounselLGUDtl", emfMap);
    }

	/**
     * 외주업체 상담관리 엑셀 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public List<EmfMap> selectCounselMngExcelList(EmfMap emfMap) throws Exception
	{
		return list("OMACounselMngDAO.selectCounselMngExcelList", emfMap);
	}
	
	/**
     * 외주업체 상담관리 엑셀 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public List<EmfMap> selectCounselMngLGUExcelList(EmfMap emfMap) throws Exception
	{
		return list("OMACounselMngDAO.selectCounselMngLGUExcelList", emfMap);
	}
	
	
	/**
     * PRDCT_CD 조회
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectPrdctCd(EmfMap emfMap) throws Exception 
    {
    	return (EmfMap) selectByPk("OMACounselMngDAO.selectPrdctCd", emfMap);
    }
	
	/**
	 * 외주업체 관리자 조건 정보를 조회한다.
	 * 
	 * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public EmfMap selectOutsourcingAdmMngInfo(String admId) throws Exception 
    {
		return (EmfMap)selectByPk("OMACounselMngDAO.selectOutsourcingAdmMngInfo", admId);
    }
	
	/**
	 * 외주업체 코드별 관리 정보를 조회한다.
	 * 
	 * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public EmfMap selectOutsourcingPageMngInfo(String oscCd) throws Exception 
    {
    	return (EmfMap)selectByPk("OMACounselMngDAO.selectOutsourcingPageMngInfo", oscCd);
    }
	
	/**
	 * 외주업체 코드별 관리 정보를 조회한다.
	 * 
	 * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public EmfMap selectOutsourcingPageLGUMngInfo(String oscCd) throws Exception 
    {
    	return (EmfMap)selectByPk("OMACounselMngDAO.selectOutsourcingPageLGUMngInfo", oscCd);
    }

	/**
     *외주업체 SKB 가입상태를 변경한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateSkbJoinMng(EmfMap emfMap) throws Exception 
	{
		update("OMACounselMngDAO.updateSkbJoinMng", emfMap);
    }
	
	/**
     * 외주업체 상담관리 엑셀파일을 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertExcelInf(EmfMap emfMap) throws Exception 
	{
		insert("OMACounselMngDAO.insertExcelInf", emfMap);
    }
	
	public void selectLgusawonUserData(EmfMap emfMap, OMACounselExcelHandler handler) throws Exception{
		getSqlSession().select("OMACounselMngDAO.selectLgusawonUserData", emfMap, handler);
	}
	
	public List<EmfMap> selectLgusawonUserDataTest(EmfMap emfMap) throws Exception
	{
		return list("OMACounselMngDAO.selectLgusawonUserData", emfMap);
	}
	public String selectLgusawonSecurityCode(EmfMap emfMap) throws Exception
	{
		return getSqlSession().selectOne("OMACounselMngDAO.selectLgusawonSecurityCode", emfMap);
	}
}
