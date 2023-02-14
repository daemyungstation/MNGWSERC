package mngwserc.cm.cma.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import emf.core.extend.dao.EmfAbstractDAO;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 온라인 상담신청를 위한 DAO
 * </pre>
 * 
 * @ClassName		: CMAOnlinePrdctCsMngDAO.java
 * @Description		: 온라인 상담신청를 위한 DAO
 * @author 김필기
 * @since 2016.02.22
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2016.02.22		김필기					 최초생성
 * </pre>
 */
@Repository("cMAOnlinePrdctCsMngDAO")
public class CMAOnlinePrdctCsMngDAO extends EmfAbstractDAO {
	
	/**
	 * 온라인 상담신청 목록을 조회한다.
	 * 
	 * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectOnlinePrdctCsMngList(EmfMap emfMap) throws Exception 
    {
    	return list("CMAOnlinePrdctCsMngDAO.selectOnlinePrdctCsMngList", emfMap);
    }	
	
	
	/**
     * 온라인 상담신청 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectOnlinePrdctCsMng(EmfMap emfMap) throws Exception 
    {
    	return (EmfMap) selectByPk("CMAOnlinePrdctCsMngDAO.selectOnlinePrdctCsMng", emfMap);
    }

	/**
     * 온라인 신청상품 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public List<EmfMap> selectOnlinePrdctInf(EmfMap emfMap) throws Exception 
    {
    	return list("CMAOnlinePrdctCsMngDAO.selectOnlinePrdctInf", emfMap);
    }

	/**
     * 온라인 신청 계좌를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectOnlinePrdctAcntInf(EmfMap emfMap) throws Exception 
    {
    	return (EmfMap) selectByPk("CMAOnlinePrdctCsMngDAO.selectOnlinePrdctAcntInf", emfMap);
    }
    
    
    /**
     * 온라인 상담신청 고객정보를 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertOnlinePrdctCsMng(EmfMap emfMap) throws Exception 
	{
		insert("CMAOnlinePrdctCsMngDAO.insertOnlinePrdctCsMng", emfMap);
    }

    /**
     * 온라인 상담신청 상품정보를 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertOnlinePrdctInf(EmfMap emfMap) throws Exception 
	{
		insert("CMAOnlinePrdctCsMngDAO.insertOnlinePrdctInf", emfMap);
    }
	
    /**
     * 온라인 상담신청 계좌정보를 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertOnlinePrdctAcntInf(EmfMap emfMap) throws Exception 
	{
		insert("CMAOnlinePrdctCsMngDAO.insertOnlinePrdctAcntInf", emfMap);
    }	
	
	/**
     *온라인 상담신청을 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateOnlinePrdctCsMng(EmfMap emfMap) throws Exception 
	{
		update("CMAOnlinePrdctCsMngDAO.updateOnlinePrdctCsMng", emfMap);
    }	
	
	/**
     *온라인 상담신청을 수정 로그를 입력 한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertOnlinePrdctCsLog(EmfMap emfMap) throws Exception 
	{
		update("CMAOnlinePrdctCsMngDAO.insertOnlinePrdctCsLog", emfMap);
    }	
	
	/**
     * 온라인 상담신청 고객정보를 삭제한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteOnlinePrdctCsMng(EmfMap emfMap) throws Exception
	{
		delete("CMAOnlinePrdctCsMngDAO.deleteOnlinePrdctCsMng", emfMap);
	}

	/**
     * 온라인 상담신청 상품정보를 삭제한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteOnlinePrdctInf(EmfMap emfMap) throws Exception
	{
		delete("CMAOnlinePrdctCsMngDAO.deleteOnlinePrdctInf", emfMap);
	}
	
	/**
     * 온라인 상담신청 계좌정보를 삭제한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteOnlinePrdctAcntInf(EmfMap emfMap) throws Exception
	{
		delete("CMAOnlinePrdctCsMngDAO.deleteOnlinePrdctAcntInf", emfMap);
	}	

	/**
     * 온라인 상품 그룹 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */

	public List<EmfMap> selectOnlinePrdctList(EmfMap emfMap) throws Exception
	{
		return list("CMAOnlinePrdctCsMngDAO.selectOnlinePrdctList", emfMap);
	}
	
	/**
	 * 온라인 상담 회사목록을 조회한다.
	 * 
	 * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectOnlinePrdctCoList(EmfMap emfMap) throws Exception 
    {
    	return list("CMAOnlinePrdctCsMngDAO.selectOnlinePrdctCoList", emfMap);
    }	

	/**
	 *  등록된 회사를 조회한다.
	 * 
	 * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public EmfMap selectOnlinePrdctCo(EmfMap emfMap) throws Exception 
    {
    	return (EmfMap)selectByPk("CMAOnlinePrdctCsMngDAO.selectOnlinePrdctCo", emfMap);
    }		
	
	 /**
     * 온라인 상담 회사목록을 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertOnlinePrdctCo(EmfMap emfMap) throws Exception 
	{
		insert("CMAOnlinePrdctCsMngDAO.insertOnlinePrdctCo", emfMap);
    }		
	
	/**
     * 온라인 상담 회사목록을 삭제한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteOnlinePrdctCoList(EmfMap emfMap) throws Exception
	{
		delete("CMAOnlinePrdctCsMngDAO.deleteOnlinePrdctCoList", emfMap);
	}		
	
}
