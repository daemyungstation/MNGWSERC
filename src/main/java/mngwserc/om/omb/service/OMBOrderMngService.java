package mngwserc.om.omb.service;

import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 외주업체 발주관리를 위한 Service
 * </pre>
 * 
 * @ClassName		: OMAOrderMngService.java
 * @Description		: 외주업체 발주관리를 위한 Service
 * @author 김필기
 * @since 2016.02.12
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2016.02.12		김필기					 최초생성
 * </pre>
 */
public interface OMBOrderMngService {
	
	/**
     * 외주업체 발주관리 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectOrderMngList(EmfMap emfMap) throws Exception;
    
    /**
     * 외주업체 발주관리 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectOrderMng(EmfMap emfMap) throws Exception;
	
    
	/**
     * 외주업체 발주관리을 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateOrderMng(EmfMap emfMap) throws Exception;
		
	/**
     * 외주업체 발주관리 목록을 엑셀다운로드한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectOrderMngExcelList(EmfMap emfMap) throws Exception;	
	
}