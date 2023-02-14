package mngwserc.sm.smc.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import emf.core.extend.dao.EmfAbstractDAO;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 다운로드 양식 관리를 위한 DAO
 * </pre>
 * 
 * @ClassName		: SMCDnldFormDAO.java
 * @Description		: 다운로드 양식 관리를 위한 DAO
 * @author 허진영
 * @since 2016.03.30
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author				   description
 *    ==========    ==============    =============================
 *    2016.03.30		허진영					최초 생성
 * </pre> 
 */ 
@Repository("sMCDnldFormDAO")
public class SMCDnldFormDAO extends EmfAbstractDAO {

	/**
	 * 다운로드 양식 목록을 조회한다.
	 * 
	 * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	
	public List<EmfMap> selectDnldFormList(EmfMap emfMap) throws Exception 
    {
    	return list("SMCDnldFormDAO.selectDnldFormList", emfMap);
    }
	
	/**
     * 다운로드 양식 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public EmfMap selectDnldForm(EmfMap emfMap) throws Exception
	{
		return (EmfMap) selectByPk("SMCDnldFormDAO.selectDnldForm", emfMap);
	}
	
	/**
     * 다운로드 양식을 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertDnldForm(EmfMap emfMap) throws Exception
	{
		insert("SMCDnldFormDAO.insertDnldForm", emfMap);
	}
	
	/**
     * 다운로드 양식을 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateDnldForm(EmfMap emfMap) throws Exception
	{
		update("SMCDnldFormDAO.updateDnldForm", emfMap);
	}
	
	/**
     * 다운로드 양식을 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteDnldForm(EmfMap emfMap) throws Exception
	{
		update("SMCDnldFormDAO.deleteDnldForm", emfMap);
	}
}
