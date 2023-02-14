package mngwserc.cs.csa.service;

import java.util.List;

import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 고객의 소리 접수관리를 위한 Service
 * </pre>
 * 
 * @ClassName		: CSACustVoiceService.java
 * @Description		: 고객의 소리 접수관리를 위한 Service
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
public interface CSACustVoiceService {	
	
	/**
     * 고객의 소리 접수 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectCustVoiceList(EmfMap emfMap) throws Exception;
    
    /**
     * 고객의 소리 접수 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectCustVoice(EmfMap emfMap) throws Exception;
    
	/**
     * 고객의 소리 접수 답변을 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateCustVoiceAnsw(EmfMap emfMap) throws Exception;
	
	/**
     * 고객의 소리 접수을 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteCustVoiceList(int[] delSeq) throws Exception;
	
	/**
     * 고객의 소리 접수 답변메일을 발송한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateCustVoiceAnswMail(EmfMap emfMap) throws Exception;
	
	/**
     *  고객의 소리 접수 문의구분 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public List<EmfMap> selectCustVoiceDtlList(EmfMap emfMap) throws Exception;
	
	/**
     * 고객의 소리 접수 목록을 조회한다. (엑셀 다운로드)
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public List<EmfMap> excelCustVoiceList(EmfMap emfMap) throws Exception;
}
