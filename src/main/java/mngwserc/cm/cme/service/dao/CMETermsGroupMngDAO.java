package mngwserc.cm.cme.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import emf.core.extend.dao.EmfAbstractDAO;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 상품 약관그룹관리를 위한 DAO
 * </pre>
 * 
 * @ClassName		: CMETermsGroupMngDAO.java
 * @Description		: 상품 약관그룹관리를 위한 DAO
 * @author 김필기
 * @since 2016.02.17
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2016.02.17		김필기					 최초생성
 * </pre>
 */
@Repository("cMETermsGroupMngDAO")
public class CMETermsGroupMngDAO extends EmfAbstractDAO {
	
	/**
	 * 상품 약관그룹관리 목록을 조회한다.
	 * 
	 * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectTermsGroupMngList(EmfMap emfMap) throws Exception 
    {
    	return list("CMETermsGroupMngDAO.selectTermsGroupMngList", emfMap);
    }	
	public List<EmfMap> selectTermsGroupMngListAll(EmfMap emfMap) throws Exception 
    {
    	return list("CMETermsGroupMngDAO.selectTermsGroupMngListAll", emfMap);
    }		
	
	
	/**
     * 상품 약관그룹관리 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    /*public EmfMap selectTermsGroupMng(EmfMap emfMap) throws Exception 
    {
    	return (EmfMap) selectByPk("CMETermsGroupMngDAO.selectTermsGroupMng", emfMap);
    }*/
    
    /**
     * 상품 약관그룹관리을 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertTermsGroupMng(EmfMap emfMap) throws Exception 
	{
		insert("CMETermsGroupMngDAO.insertTermsGroupMng", emfMap);
    }
	
	/**
	 * 상품 약관 노출 여부를 등록한다.
	 * @param emfMap
	 * @throws Exception
	 */
	public void insertTermsGroupDtl(EmfMap emfMap) throws Exception{
		insert("CMETermsGroupMngDAO.insertTermsGroupDtl", emfMap);
	}
    
	/**
     *상품 약관그룹관리을 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateTermsGroupMng(EmfMap emfMap) throws Exception 
	{
		update("CMETermsGroupMngDAO.updateTermsGroupMng", emfMap);
    }	
	
	/**
     *상품 약관그룹관리 노출여부를 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateTermsGroupDtlMng(EmfMap emfMap) throws Exception 
	{
		update("CMETermsGroupMngDAO.updateTermsGroupDtlMng", emfMap);
    }
	
	/**
     * 상품 약관그룹관리(상품)을 삭제한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteTermsGroupMng(EmfMap emfMap) throws Exception
	{
		delete("CMETermsGroupMngDAO.deleteTermsGroupMng", emfMap);
	}

	/**
     * 상품 약관그룹관리(노출여부)을 삭제한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteTermsGroupDtlMng(EmfMap emfMap) throws Exception
	{
		delete("CMETermsGroupMngDAO.deleteTermsGroupDtlMng", emfMap);
	}	
	
    
    /**
     * 상품 약관그룹관리 로그를 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertTermsGroupMngLog(EmfMap emfMap) throws Exception 
	{
		insert("CMETermsGroupMngDAO.insertTermsGroupMngLog", emfMap);
    }	
	
    /**
     * 상품 약관그룹관리 노출여부 로그를 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertTermsGroupDtlLog(EmfMap emfMap) throws Exception 
	{
		insert("CMETermsGroupMngDAO.insertTermsGroupDtlLog", emfMap);
    }	

	/**
	 * 상품 약관그룹관리 로그 목록을 조회한다.
	 * 
	 * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> logTermGroupLogExcelList(EmfMap emfMap) throws Exception 
    {
    	return list("CMETermsGroupMngDAO.logTermGroupLogExcelList", emfMap);
    }		
	
	/**
	 * 상품 약관그룹관리 로그 목록을 조회한다.
	 * 
	 * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public Integer selectCheckProductCode(EmfMap emfMap) throws Exception 
    {
    	return (Integer)selectByPk("CMETermsGroupMngDAO.selectCheckProductCode", emfMap);
    }	
	
	/**
	 * 그룹 등록후 추가되는 약관 코드를 등록한다.
	 * 
	 * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */	
	public void insertAddTerms(EmfMap emfMap) throws Exception
	{
		insert("CMETermsGroupMngDAO.insertAddTerms", emfMap);
	}
	
	
	public List<EmfMap> selectTermsGroupExcelList(EmfMap emfMap) throws Exception 
    {
    	return list("CMETermsGroupMngDAO.selectTermsGroupExcelList", emfMap);
    }	
	public void insertTermsGroupExcelDtl(EmfMap emfMap) throws Exception
	{
		insert("CMETermsGroupMngDAO.insertTermsGroupExcelDtl", emfMap);
	}
	
}
