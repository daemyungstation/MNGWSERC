package mngwserc.co.cog.service;

import java.util.List;

import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 컨텐츠 관리를 위한 Service
 * </pre>
 * 
 * @ClassName		: COGCntnsMngService.java
 * @Description		: 컨텐츠 관리를 위한 Service
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
public interface COGCntnsMngService {
	
	/**
	 * 컨텐츠 메뉴를 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return EmfMap 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public EmfMap selectCntnsList(EmfMap emfMap) throws Exception;
	
	/**
	 * 컨텐츠 상세내용을 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return EmfMap 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public EmfMap selectCntns(EmfMap emfMap) throws Exception;
	
	/**
	 * 컨텐츠 메뉴를 등록한다.
	 * 
	 * @param EmfMap 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void insertCntns(EmfMap emfMap) throws Exception;

	/**
	 * 컨텐츠 메뉴를 수정한다.
	 * 
	 * @param EmfMap 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void updateCntns(EmfMap emfMap) throws Exception;	
	
	/**
	 * 컨텐츠 메뉴를 삭제한다.
	 * 
	 * @param EmfMap 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void deleteCntns(EmfMap emfMap) throws Exception;	
	
	/**
	 * 컨텐츠 메뉴를 일반복사한다.
	 * 
	 * @param EmfMap 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void insertCopyCntns(EmfMap emfMap) throws Exception;
	
	/**
	 * CMS 다중 복사시 CMS 리스트 팝업 내용
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return List<EmfMap> 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> getCntnsList(EmfMap emfMap) throws Exception;	
	
	/**
	 * 컨텐츠 메뉴를 다중복사한다.
	 * 
	 * @param EmfMap 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void insertMultiCopyCntns(EmfMap emfMap) throws Exception;	
	
	/**
	 * 컨텐츠 승인한다.
	 * 
	 * @param EmfMap 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void updateApprovalCntns(EmfMap emfMap) throws Exception;	
	
	/**
	 * 승인시 컨텐츠 생성 로직
	 * 컨텐츠 배포시
	 * @param EmfMap 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void createApprovalCntns(EmfMap emfMap) throws Exception;	
	
	/**
	 * 컨텐츠 생성 로직
	 * 카테고리 정보 수정
	 * @param EmfMap 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void createCntns(EmfMap emfMap) throws Exception;	
	
	/**
	 * 컨텐츠 생성 로직
	 * 컨텐츠 All 재배포
	 * @param EmfMap 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void selectContentsAllList() throws Exception;
}
