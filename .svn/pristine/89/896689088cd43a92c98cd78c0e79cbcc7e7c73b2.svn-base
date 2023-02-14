package mngwserc.cm.cmg.service;

import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 결제계좌변경 내역 관리를 위한 Service
 * </pre>
 * 
 * @ClassName		: CMGAcntChngService.java
 * @Description		: 결제계좌변경 내역 관리를 위한 Service
 * @author 허진영
 * @since 2016.03.07
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2016.03.07		허진영					 최초생성
 * </pre>
 */
public interface CMGAcntChngService {	
	
	/**
	 * 결제계좌 변경내역 목록을 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */	
	public EmfMap selectAcntChngList(EmfMap emfMap) throws Exception;

	/**
	 * 결제계좌 변경내역 상세목록을 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */	
	public EmfMap selectAcntChngListDtl(EmfMap emfMap) throws Exception;
	
	/**
     * 결제계좌 변경내역 처리현황을 수정한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateChngPtcPrcsYn(EmfMap emfMap) throws Exception;
}
