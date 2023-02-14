package mngwserc.co.coa.service;

import java.util.List;

import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 샘플 Service
 * </pre>
 * 
 * @ClassName		: CMASampleService.java
 * @Description		: 샘플 Service
 * @author 박주석
 * @since 2015.11.02
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2015.11.02		박주석					최초생성
 * </pre>
 */ 
public interface COASampleService {	
	
	/**
	 * 샘플 리스트
	 * 
	 * @param ModelMap
	 * @return resultVO:List 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List selectSampleList(EmfMap egovMap) throws Exception;
}
