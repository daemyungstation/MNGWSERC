package mngwserc.co.cod.service;

import java.util.List; 

import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 메뉴 관리를 위한 Service
 * </pre>
 * 
 * @ClassName		: CODMenuService.java
 * @Description		: 메뉴 관리를 위한 Service
 * @author 박주석
 * @since 2015.11.12
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2015.11.12		박주석					최초생성
 * </pre>
 */
public interface CODMenuService {
	
	/**
	 * 관리자 메뉴 리스트를 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return List<EmfMap> 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> getMenuList(EmfMap emfMap) throws Exception;
	
	/**
	 * 메뉴의 상세정보를 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return List<EmfMap> 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public EmfMap selectMenuDtl(EmfMap emfMap) throws Exception;
	
	/**
	 * 메뉴를 추가한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public int insertMenu(EmfMap emfMap) throws Exception;
	
	/**
	 * 메뉴명을 수정한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public int updateMenuNm(EmfMap emfMap) throws Exception;
	
	/**
	 * 메뉴를 삭제한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public int deleteMenu(EmfMap emfMap) throws Exception;
	
	/**
	 * 메뉴를 이동한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void updateMenuPstn(EmfMap emfMap) throws Exception;
	
	/**
	 * 메뉴정보를 수정한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public int updateMenuInf(EmfMap emfMap) throws Exception;
	
	/**
	 * 게시판 카테고리의 노출 정보를 수정
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public int updateUserUseYn(EmfMap emfMap) throws Exception;
	
	/**
	 * 상위부모를 다 가져온다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> getParntData(EmfMap emfMap) throws Exception;
	
	/**
	 * 하위노드를 다 가져온다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> getChildData(EmfMap emfMap) throws Exception;
}
