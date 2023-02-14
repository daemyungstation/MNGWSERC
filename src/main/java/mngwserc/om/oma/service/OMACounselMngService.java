package mngwserc.om.oma.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 외주업체 상담관리를 위한 Service
 * </pre>
 * 
 * @ClassName		: OMACounselMngService.java
 * @Description		: 외주업체 상담관리를 위한 Service
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
public interface OMACounselMngService {
	
	/**
     * 외주업체 상담관리 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectCounselMngList(EmfMap emfMap) throws Exception;
    
    /**
     * 외주업체 LGU 상담관리 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectCounselMngLGUList(EmfMap emfMap) throws Exception;
    
    /**
     * 외주업체 상담관리 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectCounselMng(EmfMap emfMap) throws Exception;
    
    /**
     * 외주업체 상담관리 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectCounselLGMng(EmfMap emfMap) throws Exception;
	
	/**
     * 외주업체 상담관리을 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateCounselMng(HttpServletRequest request, EmfMap emfMap) throws Exception;
	
	/**
     * 외주업체 상담관리을 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteCounselMngList(int[] delSeq) throws Exception;
	
	/**
     * 외주업체 상담관리을 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateCounselLGUMng(HttpServletRequest request, EmfMap emfMap) throws Exception;
	
	/**
     * 외주업체 상담관리 엑셀목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public EmfMap selectCounselMngExcelList(EmfMap emfMap) throws Exception;
	
	/**
     * 외주업체LGU 상담관리 엑셀목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public EmfMap selectCounselMngLGUExcelList(EmfMap emfMap) throws Exception;
	
	/**
	 * 양식으로 업로드된 데이터를 가져온다.
	 * 
	 * @param EmfMap
	 * @return String
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public String insertExcelData(EmfMap emfMap, MultipartHttpServletRequest multiRequest, HttpServletRequest req) throws Exception;
	/**
     * lgusawon 엑셀 생성 배치.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void selectLgusawonUserData() throws Exception;

	EmfMap selectOutsourcingAdmMngInfo(EmfMap emfMap)  throws Exception;
}