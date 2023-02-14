package mngwserc.pr.pra.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import emf.core.extend.dao.EmfAbstractDAO;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 라이프웨이 매거진관리를 위한 DAO
 * </pre>
 * 
 * @ClassName		: PRALifeMgznDAO.java
 * @Description		: 라이프웨이 매거진관리를 위한 DAO
 * @author 허진영
 * @since 2016.02.16
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2016.02.16		허진영					 최초생성
 * </pre>
 */
@Repository("pRALifeMgznDAO")
public class PRALifeMgznDAO extends EmfAbstractDAO {
	
	/**
	 * 라이프웨이 매거진 목록을 조회한다.
	 * 
	 * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectLifeMgznList(EmfMap emfMap) throws Exception 
    {
    	return list("PRALifeMgznDAO.selectLifeMgznList", emfMap);
    }	
	
	/**
     * 라이프웨이 매거진 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectLifeMgzn(EmfMap emfMap) throws Exception 
    {
    	return (EmfMap) selectByPk("PRALifeMgznDAO.selectLifeMgzn", emfMap);
    }
    
    /**
     * 라이프웨이 매거진을 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertLifeMgzn(EmfMap emfMap) throws Exception 
	{
		insert("PRALifeMgznDAO.insertLifeMgzn", emfMap);
    }
    
	/**
     *라이프웨이 매거진을 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateLifeMgzn(EmfMap emfMap) throws Exception 
	{
		update("PRALifeMgznDAO.updateLifeMgzn", emfMap);
    }
	
	/**
     * 제휴상담을 삭제한다.
     * 
     * @param EmfMap
	 * @return
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteLifeMgzn(EmfMap emfMap) throws Exception
	{
		delete("PRALifeMgznDAO.deleteLifeMgzn", emfMap);
	}
	
	/**
     * 라이프웨이 매거진 발간년도 중복확인.
     * 
     * @param EmfMap
	 * @return int
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public int getMgznPbtnYrChk(EmfMap emfMap) throws Exception 
    {
    	return (Integer) selectByPk("PRALifeMgznDAO.getMgznPbtnYrChk", emfMap);
    }
}
