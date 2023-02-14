package mngwserc.mb.mbb.service;

import java.util.List;

import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 탈퇴회원 관리를 위한 Service
 * </pre>
 * 
 * @ClassName		: MBBDrotMemService.java
 * @Description		: 탈퇴회원 관리를 위한 Service
 * @author 허진영
 * @since 2016.02.22
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2016.02.22		허진영					 최초생성
 * </pre>
 */
public interface MBBDrotMemService{

	/**
     * 탈퇴회원 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public EmfMap selectDrotMemList(EmfMap emfMap) throws Exception;
	
	/**
     * 탈퇴회원 목록을 조회한다. (엑셀다운로드)
     * 
     * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */	
	public List<EmfMap> excelDrotMemList(EmfMap emfMap) throws Exception;
}