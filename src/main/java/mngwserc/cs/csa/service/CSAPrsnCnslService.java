package mngwserc.cs.csa.service;

import java.util.List;

import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 1:1 상담관리를 위한 Service
 * </pre>
 * 
 * @ClassName		: CSAPrsnCnslService.java
 * @Description		: 1:1 상담관리를 위한 Service
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
public interface CSAPrsnCnslService {	
	
	/**
     * 1:1 상담 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectPrsnCnslList(EmfMap emfMap) throws Exception;
    
    /**
     * 1:1 상담 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectPrsnCnsl(EmfMap emfMap) throws Exception;
    
	/**
     * 1:1 상담 답변을 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updatePrsnCnslAnsw(EmfMap emfMap) throws Exception;
	
	/**
     * 1:1 상담을 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deletePrsnCnslList(int[] delSeq) throws Exception;
	
	/**
     * 1:1 상담 답변메일을 발송한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updatePrsnCnslAnswMail(EmfMap emfMap) throws Exception;
	
	/**
     *  1:1 상담 문의구분 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public List<EmfMap> selectPrsnInqryDtlList(EmfMap emfMap) throws Exception;
	
	/**
     * 1:1 상담 목록을 조회한다. (엑셀 다운로드)
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public List<EmfMap> excelPrsnCnslList(EmfMap emfMap) throws Exception;
}
