package mngwserc.sm.sma.service;

import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 팝업 관리를 위한 Service
 * </pre>
 * 
 * @ClassName		: SMAPopMngService.java
 * @Description		: 팝업 관리를 위한 Service
 * @author 허진영
 * @since 2016.02.11.
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author				   description
 *   ===========    ==============    =============================
 *   2016.02.11.		허진영			 		최초생성
 * </pre>
 */
public interface SMAPopMngService {

	/**
     * 팝업 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectPopList(EmfMap emfMap) throws Exception;

    EmfMap selectMainPopList(EmfMap emfMap) throws Exception;

    /**
     * 팝업 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public EmfMap selectPop(EmfMap emfMap) throws Exception;

	EmfMap getMainPop(EmfMap emfMap) throws Exception;

    /**
     * 팝업을 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertPop(EmfMap emfMap) throws Exception;

	void setMainPopup(EmfMap emfMap) throws Exception;

	/**
     * 팝업을 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updatePop(EmfMap emfMap) throws Exception;

	void putMainPopup(EmfMap emfMap) throws Exception;

    /**
     * 팝업을 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deletePopList(int[] delSeq) throws Exception;

	void delMainPopList(int[] delSeq) throws Exception;
}
