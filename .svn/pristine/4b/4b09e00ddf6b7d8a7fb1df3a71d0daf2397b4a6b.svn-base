package mngwserc.pr.pra.service;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 라이프웨이 매거진관리를 위한 Service
 * </pre>
 * 
 * @ClassName		: PRALifeMgznService.java
 * @Description		: 라이프웨이 매거진관리를 위한 Service
 * @author 허진영
 * @since 2016.02.16
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2016.02.16		허진영					 최초생성
 * </pre>
 */
public interface PRALifeMgznService {	
	
	/**
     * 라이프웨이 매거진 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectLifeMgznList(EmfMap emfMap) throws Exception;
    
    /**
     * 라이프웨이 매거진 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectLifeMgzn(EmfMap emfMap) throws Exception;
	
    /**
     * 라이프웨이 매거진을 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertLifeMgzn(MultipartHttpServletRequest multiRequest, EmfMap emfMap) throws Exception;
	
	/**
     * 라이프웨이 매거진을 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateLifeMgzn(MultipartHttpServletRequest multiRequest, EmfMap emfMap) throws Exception;
	
	/**
     * 라이프웨이 매거진을 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteLifeMgznList(int[] delSeq) throws Exception;
	
	/**
     * 라이프웨이 매거진 발간년도 중복확인.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public int getMgznPbtnYrChk(EmfMap emfMap) throws Exception;
}
