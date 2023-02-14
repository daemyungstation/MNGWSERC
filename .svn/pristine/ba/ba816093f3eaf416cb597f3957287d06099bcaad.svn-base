package mngwserc.cs.csa.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import emf.core.extend.dao.EmfAbstractDAO;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 고객의 소리 접수를 위한 DAO
 * </pre>
 * 
 * @ClassName		: CSACustVoiceDAO.java
 * @Description		: 고객의 소리 접수를 위한 DAO
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
@Repository("cSACustVoiceDAO")
public class CSACustVoiceDAO extends EmfAbstractDAO {
	
	/**
	 * 고객의 소리 접수 목록을 조회한다.
	 * 
	 * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectCustVoiceList(EmfMap emfMap) throws Exception 
    {
    	return list("CSACustVoiceDAO.selectCustVoiceList", emfMap);
    }	
	
	/**
     * 고객의 소리 접수 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectCustVoice(EmfMap emfMap) throws Exception 
    {
    	return (EmfMap)selectByPk("CSACustVoiceDAO.selectCustVoice", emfMap);
    }
    
	/**
     * 고객의 소리 접수 답변을 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateCustVoiceAnsw(EmfMap emfMap) throws Exception 
	{
		update("CSACustVoiceDAO.updateCustVoiceAnsw", emfMap);
    }
	
	/**
     * 고객의 소리 접수을 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteCustVoice(EmfMap emfMap) throws Exception
	{
		delete("CSACustVoiceDAO.deleteCustVoice", emfMap);
	}
	
	/**
     * 고객의 소리 접수 처리상태를 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateCustVoicePrcsCd(EmfMap emfMap) throws Exception 
	{
		update("CSACustVoiceDAO.updateCustVoicePrcsCd", emfMap);
    }
	
	/**
     * 고객의 소리 접수 로그를 조회한다.
     * 
     * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public List<EmfMap> selectCustVoiceLog(EmfMap emfMap) throws Exception 
	{
		return list("CSACustVoiceDAO.selectCustVoiceLog", emfMap);
    }
	
	/**
     * 고객의 소리 접수 로그를 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertCustVoiceLog(EmfMap emfMap) throws Exception 
	{
		update("CSACustVoiceDAO.insertCustVoiceLog", emfMap);
    }
	
	/**
     * 고객의 소리 접수 목록을 조회한다. (엑셀 다운로드)
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public List<EmfMap> excelCustVoiceList(EmfMap emfMap) throws Exception
    {
    	return list("CSACustVoiceDAO.excelCustVoiceList", emfMap);
    }
}
