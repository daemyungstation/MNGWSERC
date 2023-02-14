/**
 * 
 */
package mngwserc.co.coh.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import emf.core.extend.dao.EmfAbstractDAO;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 게시판관리 DAO
 * </pre>
 * 
 * @ClassName		: CHOBbsMngDAO.java
 * @Description		: 게시판관리 DAO
 * @author 김필기
 * @since 2015. 11. 17.
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2015. 11. 17.		김필기					최초생성
 * </pre>
 */

@Repository("cOHBoardMngDAO")
public class COHBoardMngDAO extends EmfAbstractDAO {

	/**
	 * 게시판 속성 정보 목록을 조회한다.
	 * 
	 * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectBoardConfigList(EmfMap emfMap) throws Exception
	{
		return list("COHBoardMngDAO.selectBoardConfigList", emfMap);
	}
	
	/**
	 * 게시판 속성 정보 상세를 조회한다.
	 * 
	 * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public EmfMap selectBoardConfig(EmfMap emfMap) throws Exception
	{
		return (EmfMap)selectByPk("COHBoardMngDAO.selectBoardConfig", emfMap);
	}	
	
    /**
     * 게시판 속성 정보를 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public void insertBoardConfig(EmfMap emfMap) throws Exception 
    {
    	insert("COHBoardMngDAO.insertBoardConfig", emfMap);
    }
	
	/**
	 * 게시판을 생성한다.
	 * 
	 * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
    public void createBoardTbl(EmfMap emfMap) throws Exception
    {
    	insert("COHBoardMngDAO.createBoardTbl", emfMap);
    }
    
    /**
	 * 게시판 인덱스를 생성한다.
	 * 
	 * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
    public void createBoardIndex(EmfMap emfMap) throws Exception
    {
    	insert("COHBoardMngDAO.createBoardIndex", emfMap);
    }
    
    /**
	 * 게시판 PK를 생성한다.
	 * 
	 * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
    public void createBoardPk(EmfMap emfMap) throws Exception
    {
    	insert("COHBoardMngDAO.createBoardPk", emfMap);
    }
    
    /**
     * 게시판 속성 정보를 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public void updateBoardConfig(EmfMap emfMap) throws Exception 
    {
    	update("COHBoardMngDAO.updateBoardConfig", emfMap);	
    }
    
    /**
     * 게시판 속성 정보를 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public void deleteBoardConfig(EmfMap emfMap) throws Exception 
    {
    	update("COHBoardMngDAO.deleteBoardConfig", emfMap);
    }
    
    /**
     * 게시판의 배너 상세정보를 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public void updateBanrConfig(EmfMap emfMap) throws Exception 
    {
    	update("COHBoardMngDAO.updateBanrConfig", emfMap);	
    }
}