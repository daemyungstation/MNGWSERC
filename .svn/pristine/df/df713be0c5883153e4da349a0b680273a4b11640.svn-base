package mngwserc.cm.cmb.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import emf.core.extend.dao.EmfAbstractDAO;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 전환서비스 상품관리를 위한 DAO
 * </pre>
 * 
 * @ClassName		: CMBChngPrdctDAO.java
 * @Description		: 전환서비스 상품관리를 위한 DAO
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
@Repository("cMBChngPrdctDAO")
public class CMBChngPrdctDAO extends EmfAbstractDAO{
	
	/**
     * 전환서비스 상품 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public List<EmfMap> selectChngPrdctList(EmfMap emfMap) throws Exception 
	{
		return list("CMBChngPrdctDAO.selectChngPrdctList", emfMap);
	}
	
	/**
     * 전환서비스 상품 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public EmfMap selectChngPrdct(EmfMap emfMap) throws Exception 
	{
		return (EmfMap) selectByPk("CMBChngPrdctDAO.selectChngPrdct", emfMap);
	}

	/**
     * 전환서비스 상품을 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertChngPrdct(EmfMap emfMap) throws Exception 
	{
		insert("CMBChngPrdctDAO.insertChngPrdct",emfMap);
	}
	
	/**
	 * 전환서비스 상품을 수정한다.
	 * 
	 * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void updateChngPrdct(EmfMap emfMap) throws Exception 
	{
		update("CMBChngPrdctDAO.updateChngPrdct",emfMap);
	}

	/**
     * 전환서비스 상품을 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteChngPrdct(EmfMap emfMap) throws Exception 
	{
		delete("CMBChngPrdctDAO.deleteChngPrdct", emfMap);
	}

    /**
	 * 전환서비스 상품을 복사한다.
	 * 
	 * @param EmfMap 검색데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */	
	public void insertChngPrdctCopy(EmfMap emfMap) throws Exception 
	{
		insert("CMBChngPrdctDAO.insertChngPrdctCopy",emfMap);
	}

}
