package mngwserc.cs.csa.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import emf.core.extend.dao.EmfAbstractDAO;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 제휴 상담관리를 위한 DAO
 * </pre>
 * 
 * @ClassName		: CSAAlncCnslDAO.java
 * @Description		: 제휴 상담관리를 위한 DAO
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
@Repository("cSAAlncCnslDAO")
public class CSAAlncCnslDAO extends EmfAbstractDAO {
	
	/**
	 * 제휴 상담 목록을 조회한다.
	 * 
	 * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectAlncCnslList(EmfMap emfMap) throws Exception 
    {
    	return list("CSAAlncCnslDAO.selectAlncCnslList", emfMap);
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
    	return (EmfMap) selectByPk("CSAAlncCnslDAO.selectAlncCnsl", emfMap);
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
		update("CSAAlncCnslDAO.updateAlncCnslAnsw", emfMap);
    }
	
	/**
     * 제휴 상담을 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteAlncCnsl(EmfMap emfMap) throws Exception
	{
		delete("CSAAlncCnslDAO.deleteAlncCnsl", emfMap);
	}
	
	/**
     * 제휴 상담 처리상태를 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateAlncCnslPrcsCd(EmfMap emfMap) throws Exception 
	{
		update("CSAAlncCnslDAO.updateAlncCnslPrcsCd", emfMap);
    }
	
	/**
     * 제휴 상담 로그를 조회한다.
     * 
     * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public List<EmfMap> selectAlncCnslLog(EmfMap emfMap) throws Exception 
	{
		return list("CSAAlncCnslDAO.selectAlncCnslLog", emfMap);
    }
	
	/**
     * 제휴 상담 로그를 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertAlncCnslLog(EmfMap emfMap) throws Exception 
	{
		update("CSAAlncCnslDAO.insertAlncCnslLog", emfMap);
    }
}
