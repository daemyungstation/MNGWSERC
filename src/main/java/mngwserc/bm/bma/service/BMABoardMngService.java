package mngwserc.bm.bma.service;

import java.util.List;

import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 게시판 관리 service
 * </pre>
 * 
 * @ClassName		: BMABoardMngService
 * @Description		: 게시판 관리 서비스
 * @author 안진용
 * @since 2015. 11. 24.
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2015. 11. 24.		안진용					최초생성
 * </pre>
 */
public interface BMABoardMngService {
	
	/**
	 * 게시판 속성정보 한 건을 상세조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return EmfMap 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public EmfMap selectMaster(EmfMap emfMap) throws Exception;

	/**
	 * 게시판 속성정보기반으로 데이터를 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return List<EmfMap> 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public EmfMap selectBoardList(EmfMap emfMap) throws Exception;	

	/**
	 * 게시판에 상세정보를 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return EmfMap 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
 	public EmfMap selectBoardRead(EmfMap emfMap) throws Exception;
 	
	/**
	 * 게시물을 등록한다.
	 * 
	 * @param EmfMap 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void insertBoardArticle(EmfMap emfMap) throws Exception; 	
 	
	/**
	 * 게시물을 수정한다.
	 * 
	 * @param EmfMap 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void updateBoardArticle(EmfMap emfMap) throws Exception; 		
	
	/**
	 * 게시글 삭제한다.
	 * 
	 * @param EmfMap 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void deleteBoardMulti(EmfMap emfMap, int[] delidx) throws Exception;
	
	/**
	 * 게시글 승인 / 미승인처리한다.
	 * 
	 * @param EmfMap 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void blindBoardMulti(EmfMap emfMap, int[] delidx) throws Exception;
}
