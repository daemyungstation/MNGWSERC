package mngwserc.cm.cmb.service;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 전환서비스 상품내역 관리를 위한 Service
 * </pre>
 * 
 * @ClassName		: CMBChngDtlService.java
 * @Description		: 전환서비스 상품내역 관리를 위한 Service
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
public interface CMBChngDtlService {
	
	/**
     * 전환서비스 상품내역 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public EmfMap selectChngDtlList(EmfMap emfMap) throws Exception;
	
	/**
     * 전환서비스 상품내역 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public EmfMap selectChngDtl(EmfMap emfMap) throws Exception;
	
	/**
     * 전환서비스 상품내역을 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertChngDtl(EmfMap emfMap, MultipartHttpServletRequest multiRequest) throws Exception;
	
	/**
	 * 전환서비스 상품내역을 수정한다.
	 * 
	 * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void updateChngDtl(EmfMap emfMap, MultipartHttpServletRequest multiRequest) throws Exception;
	
	/**
     * 전환서비스 상품내역을 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteChngDtlList(int[] delSeq) throws Exception;
	
    /**
	 * 전환서비스 상품내역을 복사한다.
	 * 
	 * @param EmfMap 검색데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */	
	public void insertChngDtlCopy(EmfMap emfMap) throws Exception;
	
	/**
     * 전환서비스 상품내역을 블라인드 처리한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateChngDtlBlind(EmfMap emfMap) throws Exception;
}
