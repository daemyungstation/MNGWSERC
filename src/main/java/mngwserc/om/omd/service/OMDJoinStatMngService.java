package mngwserc.om.omd.service;

import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 외주업체 가입현황관리를 위한 Service
 * </pre>
 * 
 * @ClassName		: OMAJoinStatMngService.java
 * @Description		: 외주업체 가입현황관리를 위한 Service
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
public interface OMDJoinStatMngService {
	
	/**
     * 외주업체 가입현황관리 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectJoinStatMngList(EmfMap emfMap) throws Exception;
    
    /**
     * 외주업체 가입현황관리 목록 엑셀 다운로드
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectJoinStatMngExcelList(EmfMap emfMap) throws Exception;
	
}