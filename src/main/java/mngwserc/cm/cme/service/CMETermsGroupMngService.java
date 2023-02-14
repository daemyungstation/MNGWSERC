package mngwserc.cm.cme.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 상품 약관그룹관리를 위한 Service
 * </pre>
 * 
 * @ClassName		: OMATermsGroupMngService.java
 * @Description		: 상품 약관그룹관리를 위한 Service
 * @author 김필기
 * @since 2016.02.17
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2016.02.17 	김필기					 최초생성
 * </pre>
 */
public interface CMETermsGroupMngService {
	
	/**
     * 상품 약관그룹관리 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectTermsGroupMngList(EmfMap emfMap) throws Exception;    
    public List<EmfMap> selectTermsGroupMngListAll(EmfMap emfMap) throws Exception;
    
    /**
     * 상품 약관그룹관리 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    //public EmfMap selectTermsGroupMng(EmfMap emfMap) throws Exception;
	
    /**
     * 상품 약관그룹관리을 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertTermsGroupMng(MultipartHttpServletRequest multiRequest, EmfMap emfMap) throws Exception;
	
	/**
     * 상품 약관그룹관리을 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateTermsGroupMng(EmfMap emfMap) throws Exception;
	
	/**
     * 상품 약관그룹관리을 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteTermsGroupMngList(EmfMap emfMap) throws Exception;
	
	/**
     * 상품 약관그룹관리 로그를 조회한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */	
	public EmfMap logTermGroupLogExcelList(EmfMap emfMap) throws Exception;
	
	/**
     * 그룹 등록후 추가되는 약관 코드를 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */		
	public void insertAddTerms(EmfMap emfMap) throws Exception;
	
	
	public void selectTermsGroupExcel(EmfMap emfMap) throws Exception;
	
}