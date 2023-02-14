package mngwserc.cm.cmf.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import emf.core.extend.dao.EmfAbstractDAO;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 확인요청 내역 관리를 위한 DAO
 * </pre>
 * 
 * @ClassName		: CMFChkReqnService.java
 * @Description		: 확인요청 내역 관리를 위한 DAO
 * @author 허진영
 * @since 2016.02.11
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2016.02.11		허진영					 최초생성
 * </pre>
 */
@Repository("cMFChkReqnDAO")
public class CMFChkReqnDAO extends EmfAbstractDAO {

	/**
     * 확인요청 내역 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public List<EmfMap> selectChkReqnList(EmfMap emfMap) throws Exception
    {
    	return list("CMFChkReqnDAO.selectChkReqnList", emfMap);
    }
    
	/**
     * 확인요청 내역을 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteChkReqn(EmfMap emfMap) throws Exception
	{
		delete("CMFChkReqnDAO.deleteChkReqn", emfMap);
	}
	
	/**
     * 확인요청 내역 처리현황을 수정한다.
     * 
     * @param EmfMap
	 * @return int
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateChkReqnPrcsCd(EmfMap emfMap) throws Exception
	{
		update("CMFChkReqnDAO.updateChkReqnPrcsCd", emfMap);
	}
	
	/**
     * 확인요청 처리현황 로그를 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertChkReqnPrcsLog(EmfMap emfMap) throws Exception
	{
		insert("CMFChkReqnDAO.insertChkReqnPrcsLog", emfMap);
	}
}
