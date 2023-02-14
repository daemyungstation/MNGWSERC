package mngwserc.mb.mba.service;

import java.util.List;

import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 회원정보 변경내역 관리를 위한 Service
 * </pre>
 * 
 * @ClassName		: MBAMemChngService.java
 * @Description		: 회원정보 변경내역 관리를 위한 Service
 * @author 허진영
 * @since 2016.02.22
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author				   description
 *   ===========    ==============    =============================
 *    2016.02.22		허진영					최초 생성
 * </pre>
 */
public interface MBAMemChngService {	
	
	/**
     * 회원정보 변경내역 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public EmfMap selectMemChngList(EmfMap emfMap) throws Exception;
	
	/**
     * 회원정보 변경내역 처리현황을 수정한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateChngPtcPrcsYn(EmfMap emfMap) throws Exception;
	
	/**
     * 회원정보 변경내역 목록을 조회한다. (엑셀다운로드)
     * 
     * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */	
	public List<EmfMap> excelMemChngList(EmfMap emfMap) throws Exception;
}
