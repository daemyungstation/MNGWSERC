package mngwserc.cm.cma.service;

import org.springframework.web.multipart.MultipartHttpServletRequest;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 온라인 상담신청를 위한 Service
 * </pre>
 * 
 * @ClassName		: CMAOnlinePrdctCsMngService.java
 * @Description		: 온라인 상담신청를 위한 Service
 * @author 김필기
 * @since 2016.02.22
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2016.02.22 	김필기					 최초생성
 * </pre>
 */
public interface CMAOnlinePrdctCsMngService {
	
	/**
     * 온라인 상담신청 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectOnlinePrdctCsMngList(EmfMap emfMap) throws Exception;
    
    /**
     * 온라인 상담신청 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectOnlinePrdctCsMng(EmfMap emfMap) throws Exception;
	
    /**
     * 온라인 상담신청 정보를 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertOnlinePrdctCsMng(MultipartHttpServletRequest multiRequest, EmfMap emfMap) throws Exception;
	
	/**
     * 온라인 상담신청을 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateOnlinePrdctCsMng(EmfMap emfMap) throws Exception;
	
	/**
     * 온라인 상담신청을 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteOnlinePrdctCsMngList(EmfMap emfMap) throws Exception;
	
	/**
     * 온라인 상담 회사목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectOnlinePrdctCoList(EmfMap emfMap) throws Exception;	
	
    /**
     * 온라인 상담 회사목록을 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public boolean insertOnlinePrdctCo(EmfMap emfMap) throws Exception;    
    
	/**
     * 온라인 상담 회사목록을 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteOnlinePrdctCoList(EmfMap emfMap) throws Exception;	
}