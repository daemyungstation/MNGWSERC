package mngwserc.mb.mbc.service;

import java.util.List;

import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 휴면계정 관리를 위한 Service
 * </pre>
 * 
 * @ClassName		: MBCQscnMemService.java
 * @Description		: 휴면계정 관리를 위한 Service
 * @author 허진영
 * @since 2016.02.22
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author				   description
 *   ===========    ==============    =============================
 *    2016.02.22		허진영				    최초생성
 * </pre>
 */
public interface MBCQscnMemService {

	/**
     * 휴면계정 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public EmfMap selectQscnMemList(EmfMap emfMap) throws Exception;
	
	/**
     * 휴면계정 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public EmfMap selectQscnMem(EmfMap emfMap) throws Exception;
	
	/**
     * 휴면상태를 해제한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateQscnYn(EmfMap emfMap) throws Exception;
	
	/**
     * 휴면계정 목록을 조회한다. (엑셀다운로드)
     * 
     * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */	
	public List<EmfMap> excelQscnMemList(EmfMap emfMap) throws Exception;

	public void qscnChange(EmfMap emfMap) throws Exception;
}