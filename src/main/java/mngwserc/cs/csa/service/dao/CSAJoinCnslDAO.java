package mngwserc.cs.csa.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import emf.core.extend.dao.EmfAbstractDAO;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 가입 상담관리를 위한 DAO
 * </pre>
 * 
 * @ClassName		: CSAJoinCnslDAO.java
 * @Description		: 가입 상담관리를 위한 DAO
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
@Repository("cSAJoinCnslDAO")
public class CSAJoinCnslDAO extends EmfAbstractDAO {
	
	/**
	 * 가입 상담 목록을 조회한다.
	 * 
	 * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectJoinCnslList(EmfMap emfMap) throws Exception 
    {
    	return list("CSAJoinCnslDAO.selectJoinCnslList", emfMap);
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
    	return (EmfMap)selectByPk("CSAJoinCnslDAO.selectJoinCnsl", emfMap);
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
		update("CSAJoinCnslDAO.updateJoinCnslAnsw", emfMap);
    }
	
	/**
     * 가입 상담을 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteJoinCnsl(EmfMap emfMap) throws Exception
	{
		delete("CSAJoinCnslDAO.deleteJoinCnsl", emfMap);
	}
	
	/**
     * 가입 상담 처리상태를 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateJoinCnslPrcsCd(EmfMap emfMap) throws Exception 
	{
		update("CSAJoinCnslDAO.updateJoinCnslPrcsCd", emfMap);
    }
	
	/**
     * 가입 상담 로그를 조회한다.
     * 
     * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public List<EmfMap> selectJoinCnslLog(EmfMap emfMap) throws Exception 
	{
		return list("CSAJoinCnslDAO.selectJoinCnslLog", emfMap);
    }
	
	/**
     * 가입 상담 로그를 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertJoinCnslLog(EmfMap emfMap) throws Exception 
	{
		insert("CSAJoinCnslDAO.insertJoinCnslLog", emfMap);
    }
	
	/**
     * 가입 상담 목록을 조회한다. (엑셀 다운로드)
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public List<EmfMap> excelJoinCnslList(EmfMap emfMap) throws Exception
    {
    	return list("CSAJoinCnslDAO.excelJoinCnslList", emfMap);
    }
}
