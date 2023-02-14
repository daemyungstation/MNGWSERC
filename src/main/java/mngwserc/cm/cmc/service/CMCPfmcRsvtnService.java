package mngwserc.cm.cmc.service;

import java.util.List;

import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 공연예약 관리를 위한 Service
 * </pre>
 * 
 * @ClassName		: CMCPfmcRsvtnService.java
 * @Description		: 공연예약 관리를 위한 Service
 * @author 허진영
 * @since 2016.02.18
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2016.02.18		허진영					 최초생성
 * </pre>
 */
public interface CMCPfmcRsvtnService {
	
	/**
     * 공연예약 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public EmfMap selectPfmcRsvtnList(EmfMap emfMap) throws Exception;
	
	/**
     * 공연예약 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public EmfMap selectPfmcRsvtn(EmfMap emfMap) throws Exception;
	
	/**
     * 공연예약을 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updatePfmcRsvtn(EmfMap emfMap) throws Exception;
	
	/**
     * 공연예약을 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deletePfmcRsvtnList(int[] delSeq) throws Exception;
	
	/**
     * 공연예약 목록을 조회한다. (엑셀다운로드)
     * 
     * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public List<EmfMap> excelPfmcRsvtnList(EmfMap emfMap) throws Exception;
	
	/**
     * 공연예약 상담이력을 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertPfmcRsvtnCnsl(EmfMap emfMap) throws Exception;
	
	/**
     * 공연예약 담당자 확인을 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updatePfmcRsvtnConf(EmfMap emfMap) throws Exception;
}