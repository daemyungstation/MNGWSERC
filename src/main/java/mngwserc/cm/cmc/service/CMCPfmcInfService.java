package mngwserc.cm.cmc.service;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 공연정보 관리를 위한 Service
 * </pre>
 * 
 * @ClassName		: CMCPfmcInfService.java
 * @Description		: 공연 정보 관리를 위한 Service
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
public interface CMCPfmcInfService {	
	
	/**
     * 공연정보 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectPfmcInfList(EmfMap emfMap) throws Exception;
    
    /**
     * 공연정보 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectPfmcInf(EmfMap emfMap) throws Exception;
    
	/**
     * 공연정보를 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertPfmcInf(MultipartHttpServletRequest multiRequest , EmfMap emfMap) throws Exception;
	
	/**
     * 공연정보를 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updatePfmcInf(MultipartHttpServletRequest multiRequest , EmfMap emfMap) throws Exception;
	
	/**
     * 공연정보를 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deletePfmcInfList(int[] delSeq) throws Exception;
	
	/**
     * 공연예약정보를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectRsvtnInf(EmfMap emfMap) throws Exception;
    
    /**
     * 공연예약정보를 등록한다.
     * 
     * @param EmfMap
	 * @return int
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertRsvtnInf(EmfMap emfMap) throws Exception;
}
