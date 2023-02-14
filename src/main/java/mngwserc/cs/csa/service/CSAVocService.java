package mngwserc.cs.csa.service;

import java.util.List;

import emf.core.vo.EmfMap;

/**
 * <pre> 
 * VOC Service
 * </pre>
 * 
 * @ClassName		: CSAVocService.java
 * @Description		: VOC Service
 * @author 장준일
 * @since 2021.02.23
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2021.02.23		장준일					 최초생성
 * </pre>
 */
public interface CSAVocService {	
	
	/**
     * VOC 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectVocList(EmfMap emfMap) throws Exception;
    
    /**
     * VOC 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectVoc(EmfMap emfMap) throws Exception;
    
	/**
     * VOC을 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteVoc(String[] delSeq) throws Exception;
	
}
