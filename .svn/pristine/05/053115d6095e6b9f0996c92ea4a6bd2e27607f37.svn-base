package mngwserc.cm.cme.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import emf.core.extend.dao.EmfAbstractDAO;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 약관별관리를 위한 DAO
 * </pre>
 * 
 * @ClassName		: CMETermsMngDAO.java
 * @Description		: 약관별관리를 위한 DAO
 * @author 김필기
 * @since 2016.02.18
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2016.02.18		김필기					 최초생성
 * </pre>
 */
@Repository("cMETermsMngDAO")
public class CMETermsMngDAO extends EmfAbstractDAO {
	
	/**
	 * 약관별관리 목록을 조회한다.
	 * 
	 * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectTermsMngList(EmfMap emfMap) throws Exception 
    {
    	return list("CMETermsMngDAO.selectTermsMngList", emfMap);
    }	
	
	/**
     * 약관별관리 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectTermsMng(EmfMap emfMap) throws Exception 
    {
    	return (EmfMap) selectByPk("CMETermsMngDAO.selectTermsMng", emfMap);
    }
    
    /**
     * 약관별관리을 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertTermsMng(EmfMap emfMap) throws Exception 
	{
		insert("CMETermsMngDAO.insertTermsMng", emfMap);
    }
	
	/**
     *약관별관리을 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateTermsMng(EmfMap emfMap) throws Exception 
	{
		update("CMETermsMngDAO.updateTermsMng", emfMap);
    }	
	
	/**
     * 약관별관리(상품)을 삭제한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteTermsMng(EmfMap emfMap) throws Exception
	{
		delete("CMETermsMngDAO.deleteTermsMng", emfMap);
	}	

	/**
     * 약관별관리(상품) 상세를 삭제한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteTermsMngDtl(EmfMap emfMap) throws Exception
	{
		delete("CMETermsMngDAO.deleteTermsMngDtl", emfMap);
	}	
	
	
	/**
     * 조회수 증가
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateReadCnt(EmfMap emfMap) throws Exception
	{
		update("CMETermsMngDAO.updateReadCnt", emfMap);		
	}
	
	
	 /**
     * 약관별관리 상세내용을 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertTermsDtl(EmfMap emfMap) throws Exception 
	{
		insert("CMETermsMngDAO.insertTermsDtl", emfMap);
    }
	

	/**
	 * 약관별관리 상세내용을 조회한다.
	 * 
	 * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectTermsDtl(EmfMap emfMap) throws Exception 
    {
    	return list("CMETermsMngDAO.selectTermsDtl", emfMap);
    }		


	/**
	 * 약관별관리 상세내용을 조회한다.(이전 기본키값으로 조회)
	 * 
	 * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public Integer selectOldTermsDtl(EmfMap emfMap) throws Exception 
    {
    	return (Integer)selectByPk("CMETermsMngDAO.selectOldTermsDtl", emfMap);
    }		
	
	
	
	/**
     * 약관별관리 상세내용을 수정한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateTermDtl(EmfMap emfMap) throws Exception
	{
		update("CMETermsMngDAO.updateTermDtl", emfMap);		
	}	
	
	/**
     * 약관별관리 상세내용을 삭제한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteTermsDtl(EmfMap emfMap) throws Exception
	{
		delete("CMETermsMngDAO.deleteTermsDtl", emfMap);
	}		
}
