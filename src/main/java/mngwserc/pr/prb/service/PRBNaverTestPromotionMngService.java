package mngwserc.pr.prb.service;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 네이버 실검 테스트 프로모션 관리 Service
 * </pre>
 * 
 * @ClassName		: PRBNaverTestPromotionMngService.java
 * @Description		: 네이버 실검 테스트 프로모션 Service
 * @author inuscomm
 * @since 2019. 07. 16.
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2019. 07. 16.	   inuscomm				                최초생성
 * </pre>
 */

public interface PRBNaverTestPromotionMngService {
	
	
	/**
	 * 설정을 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return EmfMap 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public EmfMap selectConfigList(EmfMap emfMap) throws Exception;
	
	/**
	 * 설정을 업데이트 한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return EmfMap 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void updateConfig(EmfMap emfMap) throws Exception;
	
	/**
	 * 목록을 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return EmfMap 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public EmfMap selectList(EmfMap emfMap) throws Exception;
	
	/**
	 * 목록을 다운로드한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return EmfMap 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public EmfMap selectExcelList(EmfMap emfMap) throws Exception;
	
	/**
	 * Pv목록을 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return EmfMap 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public EmfMap selectPvList(EmfMap emfMap) throws Exception;
	
	/**
	 * Pv목록을 다운로드한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return EmfMap 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public EmfMap selectPvExcelList(EmfMap emfMap) throws Exception;
	
}
