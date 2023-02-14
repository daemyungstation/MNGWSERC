package mngwserc.co.coh.service;

import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 게시판 관리를 위한 Service
 * </pre>
 * 
 * @ClassName		: COHBbsMngService.java
 * @Description		: 게시판관리 Service
 * @author 김필기
 * @since 2015. 11. 17.
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2015. 11. 17.		김필기					최초생성
 * </pre>
 */
public interface COHBoardMngService {
	
	/**
	 * 게시판정보 목록을 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return EmfMap 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public EmfMap selectBoardConfigList(EmfMap emfMap) throws Exception;
	
	/**
	 * 게시판정보 목록을 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return EmfMap 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public EmfMap selectBoardConfig(EmfMap emfMap) throws Exception;
	
	/**
	 * 
	 * @param EmfMap 생성할 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void insertBoardConfig(EmfMap emfMap) throws Exception;
	
	/**
	 * 
	 * @param EmfMap 수정할 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void updateBoardConfig(EmfMap emfMap) throws Exception;
	
	/**
	 * 
	 * @param EmfMap 삭제할 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void deleteBoardConfig(EmfMap emfMap) throws Exception;
	
	/**
	 * 
	 * @param EmfMap 복사할 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void insertBoardConfigCopy(EmfMap emfMap) throws Exception;
	
	/**
	 * 
	 * @param EmfMap 수정할 게시판 배너 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void updateBanrConfig(EmfMap emfMap) throws Exception;
}
