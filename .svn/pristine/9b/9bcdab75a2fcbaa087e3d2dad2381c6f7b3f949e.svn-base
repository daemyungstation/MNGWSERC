package mngwserc.cn.cna.service;

import java.util.List;

import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 제로초이스를 위한 Service
 * </pre>
 * 
 * @ClassName		: CNAZeroChoiceService.java
 * @Description		: 제로초이스를 위한 ServiceImpl
 * @author 강재석
 * @since 2018.03.05
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2018.03.05		강재석					 최초생성
 * </pre>
 */ 
public interface CNAZeroChoiceService {
	
	/**
	 * 제로초이스 카테고리 관리 메뉴 리스트를 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return List<EmfMap> 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> getZeroChoiCateList(EmfMap emfMap) throws Exception;

	/**
	 * 제로초이스 카테고리 관리 메뉴 등록한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return List<EmfMap> 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
//	public int insertCateMenu(EmfMap emfMap) throws Exception;
	public void icm(EmfMap emfMap) throws Exception;

	/**
	 * 제로초이스 카테고리 관리 메뉴 수정한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return List<EmfMap> 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public int ucmn(EmfMap emfMap) throws Exception ;

	/**
	 * 제로초이스 카테고리 관리 메뉴 삭제한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return List<EmfMap> 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
//	public int deleteCateMenu(EmfMap emfMap) throws Exception ;
	public int dcm(EmfMap emfMap) throws Exception ;

	/**
	 * 제로초이스 카테고리 관리 메뉴 순서 변경한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return List<EmfMap> 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
//	public void updateCateMenuPstn(EmfMap emfMap) throws Exception ;
	public void ucp(EmfMap emfMap) throws Exception ;

	/**
     * 상품 관리 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws Exception 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public EmfMap selectZeroChoiPrdMgrList(EmfMap emfMap) throws Exception;

	/**
     * 이미지 관리 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws Exception 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public EmfMap selectZeroChoiImgMgrList(EmfMap emfMap) throws Exception;

    /**
     * 상품관리 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public EmfMap selectZeroChoisePrdMgr(EmfMap emfMap) throws Exception;

    /**
     * 이미지 관리 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public EmfMap selectZeroChoiImgMgr(EmfMap emfMap) throws Exception;

    /**
     * 상품관리를 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void izcpm(EmfMap emfMap) throws Exception;

    /**
     * 이미지관리를 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void izcim(EmfMap emfMap) throws Exception;

    /**
     * 상품관리를 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void uzcpm(EmfMap emfMap) throws Exception;
	
    /**
     * 이미지관리를 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void uizcim(EmfMap emfMap) throws Exception;

	 /**
     * 다이렉트 초이스 미리보기 상세를 조회한다.
     * 
     * @param EmfMap 검색할 데이터
     * @return String URL
     * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */  
	EmfMap selectFileInfoByFileSeq(EmfMap emfMap) throws Exception;

	public void dzcl(EmfMap emfMap) throws Exception;

	/**
	 * 제로초이스 카테고리 관리 메뉴 순서 변경한다.2
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return List<EmfMap> 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void ucpb(EmfMap emfMap);

//	public void updateCatePstnAfterDelete(EmfMap emfMap);
	public void ucpad(EmfMap emfMap);

	public EmfMap getPstnByCateSeq(EmfMap emfMap);

	public void cateWrite(EmfMap emfMap);

	public void cateAllDel(EmfMap emfMap);

	public List<EmfMap> selectZeroChoiPrdMgrListByCateSeq(EmfMap emfMap);

//	public void updateCateMove1(EmfMap param);
	public void ucm1(EmfMap param);

//	public void updateCateMove2(EmfMap param);
	public void ucm2(EmfMap param);



}
