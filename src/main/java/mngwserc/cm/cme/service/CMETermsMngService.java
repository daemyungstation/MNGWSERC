package mngwserc.cm.cme.service;

import org.springframework.web.multipart.MultipartHttpServletRequest;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 약관별 관리를 위한 Service
 * </pre>
 * 
 * @ClassName		: CMETermsMngService.java
 * @Description		: 약관별 관리를 위한 Service
 * @author 김필기
 * @since 2016.02.18
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2016.02.18 	김필기					 최초생성
 * </pre>
 */
public interface CMETermsMngService {
	
	/**
     * 약관별관리 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectTermsMngList(EmfMap emfMap) throws Exception;
    
    /**
     * 약관별관리 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectTermsMng(EmfMap emfMap) throws Exception;
	
    /**
     * 약관별관리을 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertTermsMng(MultipartHttpServletRequest multiRequest, EmfMap emfMap) throws Exception;
	
	/**
     * 약관별관리을 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateTermsMng(EmfMap emfMap) throws Exception;
	
	/**
     * 약관별관리을 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteTermsMngList(EmfMap emfMap) throws Exception;
	
	/**
     * 약관 복사
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */	
	public void insertCopyTermsMng(EmfMap emfMap) throws Exception;

    /**
     * 약관별관리 상세내용을 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertTermsDtl(EmfMap emfMap) throws Exception;

	/**
     * 약관별관리 상세내용을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectTermsDtl(EmfMap emfMap) throws Exception;
	
	/**
     * 약관별관리 상세내용을 수정한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public void updateTermDtl(EmfMap emfMap) throws Exception;    
    
	
	/**
     * 약관 상세내용을 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteTermsDtl(EmfMap emfMap) throws Exception;    
    
    
}