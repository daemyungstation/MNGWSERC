package mngwserc.co.coc.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import emf.core.extend.dao.EmfAbstractDAO;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 관리자 관리를 위한 DAO
 * </pre>
 * 
 * @ClassName		: COCAdmMngDAO.java
 * @Description		: 관리자 관리를 위한 DAO
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
@Repository("cOCAdmMngDAO")
public class COCAdmMngDAO extends EmfAbstractDAO {
	
    /**
	 * 관리자 목록을 조회한다.
	 * 
	 * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectAdmList(EmfMap emfMap) throws Exception 
    {
    	return list("COCAdmMngDAO.selectAdmList", emfMap);
    }	
	
	/**
     * 관리자 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectAdm(EmfMap emfMap) throws Exception 
    {
    	return (EmfMap)selectByPk("COCAdmMngDAO.selectAdm", emfMap);
    }
    
    /**
     * 관리자를 등록한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertAdm(EmfMap emfMap) throws Exception
	{
		insert("COCAdmMngDAO.insertAdm", emfMap);
    }
	
	/**
     * 관리자를 수정한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateAdm(EmfMap emfMap) throws Exception 
	{
		update("COCAdmMngDAO.updateAdm", emfMap);
    }
	
	/**
     * 관리자를 삭제한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteAdm(EmfMap emfMap) throws Exception
	{
		update("COCAdmMngDAO.deleteAdm", emfMap);
	}
	
	/**
	 * 관리자 등급을 조회한다.
	 * 
	 * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectAdmUserTypeList(EmfMap emfMap) throws Exception 
    {
    	return list("COCAdmMngDAO.selectAdmUserTypeList", emfMap);
    }
    
    /**
     * 아이디 중복체크를 위해 ID 갯수를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public int getIdCnt(EmfMap emfMap) throws Exception
	{
		return (Integer)selectByPk("COCAdmMngDAO.getIdCnt", emfMap);
    }
	
	/**
     * 이메일 중복체크를 위해 Email 갯수를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public int getEmailCnt(EmfMap emfMap) throws Exception 
	{
		return (Integer)selectByPk("COCAdmMngDAO.getEmailCnt", emfMap);
    }
	
	/**
     * 관리자 메뉴 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public List<EmfMap> getMenuList(EmfMap emfMap) throws Exception
    {
    	return list("COCAdmMngDAO.getMenuList", emfMap);
    }
	
	/**
     * 관리자 메뉴를 등록한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertAdmMenu(EmfMap emfMap) throws Exception 
	{
		insert("COCAdmMngDAO.insertAdmMenu", emfMap);
    }
	
	/**
     * 관리자 메뉴를 삭제한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteAdmMenu(EmfMap emfMap) throws Exception
	{
		delete("COCAdmMngDAO.deleteAdmMenu", emfMap);
	}
	
	/**
     * 부서별 관리자 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public List<EmfMap> getRoleAdmList(EmfMap emfMap) throws Exception
    {
    	return list("COCAdmMngDAO.getRoleAdmList", emfMap);
    }
}
