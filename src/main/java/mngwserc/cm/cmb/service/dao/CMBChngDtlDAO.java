package mngwserc.cm.cmb.service.dao;

import java.util.List; 

import org.springframework.stereotype.Repository;

import emf.core.extend.dao.EmfAbstractDAO;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 전환서비스 상품내역 관리를 위한 DAO
 * </pre>
 * 
 * @ClassName		: CMBChngDtlDAO.java
 * @Description		: 전환서비스 상품내역 관리를 위한 DAO
 * @author 김대환
 * @since 2016.02.17
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author				  description
 *   ===========    ==============    =============================
 *    2016.02.17		김대환				   최초 생성
 * </pre>
 */ 
@Repository("cMBChngDtlDAO")
public class CMBChngDtlDAO extends EmfAbstractDAO {
	
	/**
     * 전환서비스 상품내역 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public List<EmfMap> selectChngDtlList(EmfMap emfMap) throws Exception 
	{
		return list("CMBChngDtlDAO.selectChngDtlList", emfMap);
	}

	/**
     * 전환서비스 상품내역 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public EmfMap selectChngDtl(EmfMap emfMap) throws Exception 
	{
		return (EmfMap) selectByPk("CMBChngDtlDAO.selectChngDtl", emfMap);
	}
	
	/**
     * 전환서비스 상품내역을 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertChngDtl(EmfMap emfMap) throws Exception 
	{
		insert("CMBChngDtlDAO.insertChngDtl", emfMap);
	}
	
	/**
	 * 전환서비스 상품내역을 수정한다.
	 * 
	 * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void updateChngDtl(EmfMap emfMap) throws Exception 
	{
		update("CMBChngDtlDAO.updateChngDtl", emfMap);
	}
	
	/**
	 * 전환서비스 상품내역을 삭제한다.
	 * 
	 * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void deleteChngDtl(EmfMap emfMap) throws Exception 
	{
		delete("CMBChngDtlDAO.deleteChngDtl", emfMap);
	}
	
	/**
	 * 전환서비스 상품내역 정보를 전체삭제한다.
	 * 
	 * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void deleteChngDtlInfAll(EmfMap emfMap) throws Exception 
	{
		delete("CMBChngDtlDAO.deleteChngDtlInfAll", emfMap);
	}
	
	/**
	 * 전환서비스 상품내역 정보를 조회한다.
	 * 
	 * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectChngDtlInf(EmfMap emfMap) throws Exception 
	{
		return list("CMBChngDtlDAO.selectChngDtlInf", emfMap);
	}	
	
	/**
     * 전환서비스 상품내역 정보를 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertChngDtlInf(EmfMap emfMap) throws Exception 
	{
		insert("CMBChngDtlDAO.insertChngDtlInf", emfMap);
	}
	
	/**
     * 전환서비스 상품내역 정보를 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteChngDtlInf(EmfMap emfMap) throws Exception 
	{
		delete("CMBChngDtlDAO.deleteChngDtlInf", emfMap);
	}
	
    /**
	 * 전환서비스 상품내역을 복사한다.
	 * 
	 * @param EmfMap 검색데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */	
	public void insertChngDtlCopy(EmfMap emfMap) throws Exception 
	{
		insert("CMBChngDtlDAO.insertChngDtlCopy",emfMap);
	}
	
	/**
	 * 전환서비스 상품내역을 정보를 복사한다.
	 * 
	 * @param EmfMap 검색데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */	
	public void insertChngDtlInfCopy(EmfMap emfMap) throws Exception 
	{
		insert("CMBChngDtlDAO.insertChngDtlInfCopy",emfMap);
	}
	
	/**
     * 전환서비스 상품내역 정보를 블라인드 처리한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateChngDtlBlind(EmfMap emfMap) throws Exception 
	{
		update("CMBChngDtlDAO.updateChngDtlBlind", emfMap);
	}
}
