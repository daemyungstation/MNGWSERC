package mngwserc.co.coc.service;

import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 관리자 ROLE 관리를 위한 Service
 * </pre>
 * 
 * @ClassName		: COCAdmRoleMngService.java
 * @Description		: 관리자 ROLE 관리를 위한 Service
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
public interface COCAdmRoleMngService {
	
    /**
     * 관리자 ROLE 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectAdmRoleList(EmfMap emfMap) throws Exception;
    
    /**
     * 관리자 ROLE 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectAdmRole(EmfMap emfMap) throws Exception;
    
	/**
     * 관리자 ROLE을 등록한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertAdmRole(EmfMap emfMap) throws Exception;
	
	/**
     * 관리자 ROLE을 수정한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateAdmRole(EmfMap emfMap) throws Exception;
	
	/**
     * 관리자 ROLE을 삭제한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteAdmRole(EmfMap emfMap) throws Exception;
}
