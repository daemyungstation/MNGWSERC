package mngwserc.cm.cmb.service;

import java.util.List;

import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 전환서비스 신청 관리를 위한 Service
 * </pre>
 * 
 * @ClassName		: CMBChngRqstService.java
 * @Description		: 전환서비스 신청 관리를 위한 Service
 * @author 허진영
 * @since 2016.03.24
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2016.03.24		허진영					 최초생성
 * </pre>
 */
public interface CMBChngRqstService {	
	
	/**
     * 전환서비스 신청 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public EmfMap selectChngRqstList(EmfMap emfMap) throws Exception;
	
	/**
     * 전환서비스 신청 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public EmfMap selectChngRqst(EmfMap emfMap) throws Exception;
	
	/**
     * 전환서비스 신청을 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateChngRqst(EmfMap emfMap) throws Exception;
	
	/**
     * 전환서비스 신청을 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteChngRqstList(int[] delSeq) throws Exception;
	
	/**
     *  전환서비스 신청 처리현황을 수정한다.
     * 
     * @param EmfMap
	 * @return int
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateChngRqstPrcsCd(EmfMap emfMap) throws Exception;
	
	/**
     * 전환서비스 신청 목록을 조회한다. (엑셀 다운로드)
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public List<EmfMap> excelChngRqstList(EmfMap emfMap) throws Exception;
}
