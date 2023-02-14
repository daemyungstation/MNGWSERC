package mngwserc.co.coc.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import emf.core.extend.dao.EmfAbstractDAO;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 관리자 ROLE 관리를 위한 DAO
 * </pre>
 * 
 * @ClassName		: COCAdmRoleMngDAO.java
 * @Description		: 관리자 ROLE 관리를 위한 DAO
 * @author 허진영
 * @since 2015.11.13
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2015.11.13		허진영					최초생성
 * </pre>
 */ 
@Repository("cOCAdmRoleMngDAO")
public class COCAdmRoleMngDAO extends EmfAbstractDAO {
	
    /**
	 * 관리자 ROLE 목록을 조회한다.
	 * 
	 * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectAdmRoleList(EmfMap emfMap) throws Exception 
    {
    	return list("COCAdmRoleMngDAO.selectAdmRoleList", emfMap);
    }	
	
	/**
     * 관리자 ROLE 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectAdmRole(EmfMap emfMap) throws Exception 
    {
    	return (EmfMap)selectByPk("COCAdmRoleMngDAO.selectAdmRole", emfMap);
    }
    
    /**
     * 관리자 ROLE을 등록한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertAdmRole(EmfMap emfMap) throws Exception
	{
		insert("COCAdmRoleMngDAO.insertAdmRole", emfMap);
    }
	
	/**
     * 관리자 ROLE을 수정한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateAdmRole(EmfMap emfMap) throws Exception 
	{
		update("COCAdmRoleMngDAO.updateAdmRole", emfMap);
    }
	
	/**
     * 관리자 ROLE을 삭제한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteAdmRole(EmfMap emfMap) throws Exception
	{
		delete("COCAdmRoleMngDAO.deleteAdmRole", emfMap);
	}
	
	/**
	 * 관리자 ROEL 등급을 조회한다.
	 * 
	 * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectAdmUserTypeList(EmfMap emfMap) throws Exception 
    {
    	return list("COCAdmRoleMngDAO.selectAdmUserTypeList", emfMap);
    }
	
	/**
     * 관리자 ROLE 메뉴를 등록한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertAdmMenu(EmfMap emfMap) throws Exception 
	{
		insert("COCAdmRoleMngDAO.insertAdmMenu", emfMap);
    }
	
	/**
     * 관리자 ROLE 메뉴를 삭제한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteAdmMenu(EmfMap emfMap) throws Exception
	{
		delete("COCAdmRoleMngDAO.deleteAdmMenu", emfMap);
	}
}
