package mngwserc.co.coc.service;

import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 확인요청 내역 관리를 위한 Service
 * </pre>
 * 
 * @ClassName		: CMFAppynService.java
 * @Description		: 확인요청 내역 관리를 위한 Service
 * @author 허진영
 * @since 2016.02.11
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2016.02.11		허진영					 최초생성
 * </pre>
 */
public interface CMFAppynService {	
	
	/**
     * 확인요청 내역 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectChkReqnList(EmfMap emfMap) throws Exception;
    
	/**
     * 확인요청 내역을 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteChkReqnList(int[] delSeq) throws Exception;
	
	/**
     * 확인요청 내역 처리현황을 수정한다.
     * 
     * @param EmfMap
	 * @return int
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateChkReqnPrcsCd(EmfMap emfMap) throws Exception;
}
