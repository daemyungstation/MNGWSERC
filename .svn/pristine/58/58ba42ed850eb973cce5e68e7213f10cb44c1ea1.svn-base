package mngwserc.cs.csa.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import emf.core.extend.dao.EmfAbstractDAO;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 1:1 상담관리를 위한 DAO
 * </pre>
 * 
 * @ClassName		: CSAPrsnCnslDAO.java
 * @Description		: 1:1 상담관리를 위한 DAO
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
@Repository("cSAPrsnCnslDAO")
public class CSAPrsnCnslDAO extends EmfAbstractDAO {
	
	/**
	 * 1:1 상담 목록을 조회한다.
	 * 
	 * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectPrsnCnslList(EmfMap emfMap) throws Exception 
    {
    	return list("CSAPrsnCnslDAO.selectPrsnCnslList", emfMap);
    }	
	
	/**
     * 1:1 상담 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectPrsnCnsl(EmfMap emfMap) throws Exception 
    {
    	return (EmfMap)selectByPk("CSAPrsnCnslDAO.selectPrsnCnsl", emfMap);
    }
    
	/**
     * 1:1 상담 답변을 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updatePrsnCnslAnsw(EmfMap emfMap) throws Exception 
	{
		update("CSAPrsnCnslDAO.updatePrsnCnslAnsw", emfMap);
    }
	
	/**
     * 1:1 상담을 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deletePrsnCnsl(EmfMap emfMap) throws Exception
	{
		delete("CSAPrsnCnslDAO.deletePrsnCnsl", emfMap);
	}
	
	/**
     * 1:1 상담 처리상태를 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updatePrsnCnslPrcsCd(EmfMap emfMap) throws Exception 
	{
		update("CSAPrsnCnslDAO.updatePrsnCnslPrcsCd", emfMap);
    }
	
	/**
     * 1:1 상담 로그를 조회한다.
     * 
     * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public List<EmfMap> selectPrsnCnslLog(EmfMap emfMap) throws Exception 
	{
		return list("CSAPrsnCnslDAO.selectPrsnCnslLog", emfMap);
    }
	
	/**
     * 1:1 상담 로그를 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertPrsnCnslLog(EmfMap emfMap) throws Exception 
	{
		update("CSAPrsnCnslDAO.insertPrsnCnslLog", emfMap);
    }
	
	/**
     * 1:1 상담 목록을 조회한다. (엑셀 다운로드)
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public List<EmfMap> excelPrsnCnslList(EmfMap emfMap) throws Exception
    {
    	return list("CSAPrsnCnslDAO.excelPrsnCnslList", emfMap);
    }
}
