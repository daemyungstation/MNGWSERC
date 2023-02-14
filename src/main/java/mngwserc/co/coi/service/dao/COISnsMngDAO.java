package mngwserc.co.coi.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import emf.core.extend.dao.EmfAbstractDAO;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * SNS 관리 DAO
 * </pre>
 * 
 * @ClassName		: CHISnsMngDAO.java
 * @Description		: SNS 관리 DAO
 * @author 이너스커뮤니티
 * @since 2019. 05. 15.
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2019. 05. 15.		이너스					최초생성
 * </pre>
 */

@Repository("cOISnsMngDAO")
public class COISnsMngDAO extends EmfAbstractDAO {

	/**
	 * SNS 속성 정보 목록을 조회한다.
	 * 
	 * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectSnsList(EmfMap emfMap) throws Exception
	{
		return list("COISnsMngDAO.selectSnsList", emfMap);
	}
	
	/**
	 * SNS 속성 정보 상세를 조회한다.
	 * 
	 * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public EmfMap selectSns(EmfMap emfMap) throws Exception
	{
		return (EmfMap)selectByPk("COISnsMngDAO.selectSns", emfMap);
	}	
	
    /**
     * SNS 속성 정보를 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public void insertSns(EmfMap emfMap) throws Exception 
    {
    	insert("COISnsMngDAO.insertSns", emfMap);
    }
    
    /**
     * SNS 속성 정보를 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public void orderSns(EmfMap emfMap) throws Exception 
    {
    	update("COISnsMngDAO.orderSns", emfMap);	
    }
    
    /**
     * SNS 순서를 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public void updateSns(EmfMap emfMap) throws Exception 
    {
    	update("COISnsMngDAO.updateSns", emfMap);	
    }
    
    /**
     * SNS 속성 정보를 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public void deleteSns(EmfMap emfMap) throws Exception 
    {
    	delete("COISnsMngDAO.deleteSns", emfMap);
    }
    
}