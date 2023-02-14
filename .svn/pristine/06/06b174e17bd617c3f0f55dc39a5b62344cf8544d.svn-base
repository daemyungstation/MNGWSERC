package mngwserc.sm.sma.service;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 배너 관리를 위한 Service
 * </pre>
 * 
 * @ClassName		: SMABanrMngService.java
 * @Description		: 배너 관리를 위한 Service
 * @author 허진영
 * @since 2016.02.11.
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author				   description
 *   ===========    ==============    =============================
 *   2016.02.11.		허진영			 		최초생성
 * </pre>
 */
public interface SMABanrMngService {

	/**
     * 배너 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectBanrList(EmfMap emfMap) throws Exception;

    /**
     * 배너 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public EmfMap selectBanr(EmfMap emfMap) throws Exception;
	
    /**
     * 배너를 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertBanr(MultipartHttpServletRequest multiRequest, EmfMap emfMap) throws Exception;
	
	/**
     * 배너를 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateBanr(MultipartHttpServletRequest multiRequest, EmfMap emfMap) throws Exception;
	
    /**
     * 배너를 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteBanrList(int[] delSeq) throws Exception;
	
	/**
     * 배너 정렬순서를 수정한다(up).
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateBanrSortUp(EmfMap emfMap) throws Exception;
	
	/**
     * 배너 정렬순서를 수정한다(down).
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateBanrSortDown(EmfMap emfMap) throws Exception;
}
