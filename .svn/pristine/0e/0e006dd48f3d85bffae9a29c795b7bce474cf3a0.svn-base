package mngwserc.cm.cmb.service;

import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 전환서비스 상품관리를 위한 Service
 * </pre>
 * 
 * @ClassName		: CMBChngPrdctService.java
 * @Description		: 전환서비스 상품관리를 위한 Service
 * @author 김대환
 * @since 2016.02.17
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author				  description
 *   ===========    ==============    =============================
 *    2016.02.17		김대환				   최초 생성
 * </pre>
 */
public interface CMBChngPrdctService {
	
	/**
     * 전환서비스 상품 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public EmfMap selectChngPrdctList(EmfMap emfMap) throws Exception;
	
	/**
     * 전환서비스 상품 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public EmfMap selectChngPrdct(EmfMap emfMap) throws Exception;
	
	/**
     * 전환서비스 상품을 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertChngPrdct(EmfMap emfMap) throws Exception;
	/**
	 * 전환서비스 상품을 수정한다.
	 * 
	 * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void updateChngPrdct(EmfMap emfMap) throws Exception;
	
	/**
     * 전환서비스 상품을 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteChngPrdctList(int[] delSeq) throws Exception;
	
    /**
	 * 전환서비스 상품을 복사한다.
	 * 
	 * @param EmfMap 검색데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */	
	public void insertChngPrdctCopy(EmfMap emfMap) throws Exception;
}
