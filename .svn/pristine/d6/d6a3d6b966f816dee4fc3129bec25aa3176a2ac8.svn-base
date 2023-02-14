package mngwserc.cm.cmb.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import emf.core.extend.dao.EmfAbstractDAO;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 전환서비스 신청 관리를 위한 DAO
 * </pre>
 * 
 * @ClassName		: CMBChngRqstDAO.java
 * @Description		: 전환서비스 신청 관리를 위한 DAO
 * @author 허진영
 * @since 2016.03.24
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2016.03.24		허진영					 최초생성
 * </pre>
 */
@Repository("cMBChngRqstDAO")
public class CMBChngRqstDAO extends EmfAbstractDAO {	
	
	/**
     * 전환서비스 신청 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public List<EmfMap> selectChngRqstList(EmfMap emfMap) throws Exception
	{
		return list("CMBChngRqstDAO.selectChngRqstList", emfMap);
	}
	
	/**
     * 전환서비스 신청 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public EmfMap selectChngRqst(EmfMap emfMap) throws Exception
	{
		return (EmfMap) selectByPk("CMBChngRqstDAO.selectChngRqst", emfMap);
	}
	
	/**
	 * 전환서비스 상품정보를 조회한다.
	 * 
	 * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public EmfMap selectChngPrdctInf(EmfMap emfMap) throws Exception
	{
		return (EmfMap) selectByPk("CMBChngRqstDAO.selectChngPrdctInf", emfMap);
	}
	
	/**
     * 전환서비스 신청을 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateChngRqst(EmfMap emfMap) throws Exception
	{
		update("CMBChngRqstDAO.updateChngRqst", emfMap);
	}
	
	/**
     * 전환서비스 신청을 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteChngRqst(EmfMap emfMap) throws Exception
	{
		delete("CMBChngRqstDAO.deleteChngRqst", emfMap);
	}
	
	/**
     * 전환서비스 신청 처리현황을 수정한다.
     * 
     * @param EmfMap
	 * @return
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateChngRqstPrcsCd(EmfMap emfMap) throws Exception
	{
		update("CMBChngRqstDAO.updateChngRqstPrcsCd", emfMap);
	}
	
	/**
     * 전환서비스 신청 처리현황 로그를 조회한다.
     * 
     * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public List<EmfMap> selectRqstPrcsLog(EmfMap emfMap) throws Exception 
	{
		return list("CMBChngRqstDAO.selectRqstPrcsLog", emfMap);
    }
	
	/**
     * 전환서비스 신청 처리현황 로그를 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public int insertRqstPrcsLog(EmfMap emfMap) throws Exception
	{
		return insert("CMBChngRqstDAO.insertRqstPrcsLog", emfMap);
	}
	
	/**
     * 전환서비스 신청 목록을 조회한다. (엑셀 다운로드)
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public List<EmfMap> excelChngRqstList(EmfMap emfMap) throws Exception
	{
		return list("CMBChngRqstDAO.excelChngRqstList", emfMap);
	}
}
