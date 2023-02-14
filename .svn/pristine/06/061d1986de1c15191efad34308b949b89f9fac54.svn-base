package mngwserc.co.coc.service;

import java.util.List;

import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 관리자 관리를 위한 Service
 * </pre>
 * 
 * @ClassName		: COCAdmMngService.java
 * @Description		: 관리자 관리를 위한 Service
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
public interface COCAdmMngService {
	
    /**
     * 관리자 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectAdmList(EmfMap emfMap) throws Exception;
    
    /**
     * 관리자 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectAdm(EmfMap emfMap) throws Exception;
    
	/**
     * 관리자를 등록한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertAdm(EmfMap emfMap) throws Exception;
	
	/**
     * 관리자를 수정한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateAdm(EmfMap emfMap) throws Exception;
	
	/**
     * 관리자를 수정한다. (내 정보변경)
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public void updatePrsnData(EmfMap emfMap) throws Exception;
	
	/**
     * 관리자를 삭제한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteAdm(EmfMap emfMap) throws Exception;
	
	/**
     * 아이디 중복체크를 위해 ID 갯수를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public int getIdCnt(EmfMap emfMap) throws Exception;

	/**
     * 이메일 중복체크를 위해 Email 갯수를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public int getEmailCnt(EmfMap emfMap) throws Exception;
	
	/**
     * 관리자 권한 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public List<EmfMap> getMenuList(EmfMap emfMap) throws Exception;
    
	/**
     * 부서별 관리자 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public List<EmfMap> getRoleAdmList(EmfMap emfMap) throws Exception;    
}
