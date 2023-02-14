package mngwserc.cm.cmb.service;

import java.util.List;

import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 전환서비스 체계 관리를 위한 Service
 * </pre>
 * 
 * @ClassName		: CMBChngSysService.java
 * @Description		: 전환서비스 체계 관리를 위한 Service
 * @author 허진영
 * @since 2016.02.17
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2016.02.17		허진영					 최초생성
 * </pre>
 */
public interface CMBChngSysService {	
	
	/**
     * 전환서비스 쳬계 그룹 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public EmfMap selectChngSysGrpList(EmfMap emfMap) throws Exception;
	
	/**
     * 전환서비스 쳬계 그룹을 등록을 위해 중복 검사를 한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public int getChngSysGrpNmExstCnt(EmfMap emfMap) throws Exception;
	
	/**
     * 전환서비스 쳬계 그룹을 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public int insertChngSysGrp(EmfMap emfMap) throws Exception;
	
	/**
     * 전환서비스 쳬계 그룹을 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateChngSysGrp(EmfMap emfMap) throws Exception;
	
	/**
     * 전환서비스 쳬계 그룹을 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteChngSysGrp(EmfMap emfMap) throws Exception;
	
	/**
     * 전환서비스 쳬계 그룹 상품 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public EmfMap selectChngSysGrpPrdctList(EmfMap emfMap) throws Exception;
	
	/**
     * 전환서비스 쳬계 외부상품(엔컴) 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public EmfMap selectChngSysOutPrdctList(EmfMap emfMap) throws Exception;
	
	/**
     * 전환서비스 쳬계 그룹 상품을 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertChngSysGrpPrdct(EmfMap emfMap) throws Exception;
	
	/**
     * 전환서비스 쳬계 그룹명을 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateChngSysGrpNm(EmfMap emfMap) throws Exception;
	
	/**
     * 전환서비스 쳬계 그룹 상품을 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteChngSysGrpPrdctList(int[] delSeq) throws Exception;
	
	/**
     * 전환서비스 쳬계 그룹 상품 목록을 조회한다. (엑셀 다운로드)
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public List<EmfMap> excelChngSysGrpPrdctList(EmfMap emfMap) throws Exception;
}
