package mngwserc.mb.mba.service;

import java.util.List;

import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 회원정보 관리를 위한 Service
 * </pre>
 * 
 * @ClassName		: MBAMemInfService.java
 * @Description		: 회원정보 관리를 위한 Service
 * @author 허진영
 * @since 2016.02.15
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2016.02.15		허진영					 최초생성
 * </pre>
 */
public interface MBAMemInfService {	
	
	/**
     * 회원정보 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public EmfMap selectMemInfList(EmfMap emfMap) throws Exception;
	
	/**
     * 회원정보 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public EmfMap selectMemInf(EmfMap emfMap) throws Exception;
	
	/**
     * 회원정보를 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateMemInf(EmfMap emfMap) throws Exception;
	
	/**
     * 회원을 탈퇴한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateMemDrot(EmfMap emfMap) throws Exception;
	public void updateMemDrot_Sso(EmfMap emfMap) throws Exception;
	
	/**
     * 회원정보 목록을 조회한다. (엑셀다운로드)
     * 
     * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */	
	public List<EmfMap> excelMemInfList(EmfMap emfMap)throws Exception;
	
	/**
     * 고객서비스 변경 목록을 조회한다. (엑셀다운로드)
     * 
     * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */	
	public List<EmfMap> excelRcvModList(EmfMap emfMap)throws Exception;
}
