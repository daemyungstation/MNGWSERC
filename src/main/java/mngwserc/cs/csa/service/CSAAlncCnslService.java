package mngwserc.cs.csa.service;

import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 제휴 상담관리를 위한 Service
 * </pre>
 * 
 * @ClassName		: CSAAlncCnslService.java
 * @Description		: 제휴 상담관리를 위한 Service
 * @author 허진영
 * @since 2016.02.04
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2016.02.04		허진영					 최초생성
 * </pre>
 */
public interface CSAAlncCnslService {	
	
	/**
     * 제휴 상담 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectAlncCnslList(EmfMap emfMap) throws Exception;
    
    /**
     * 제휴 상담 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectAlncCnsl(EmfMap emfMap) throws Exception;
    
	/**
     * 제휴 상담 답변을 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateAlncCnslAnsw(EmfMap emfMap) throws Exception;
	
	/**
     * 제휴 상담을 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteAlncCnslList(int[] delSeq) throws Exception;
}
