package mngwserc.fair.service;

import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 박람회 이벤트 관리 Service
 * </pre>
 * 
 * @ClassName		: FairEventService.java
 * @Description		: 박람회 이벤트 관리 Service
 * @author inuscommunity
 * @since 2019. 10. 23.
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 	since			author	          description
 *  =============   ==============    =============================
 *  2019. 10. 23.	inuscomm          최초생성
 * </pre>
 */

public interface FairUserService {

	//목록 조회
	public EmfMap selectList(EmfMap emfMap) throws Exception;
	
	//목록 조회
	public EmfMap selectListExcel(EmfMap emfMap) throws Exception;
	
	//카테고리 목록 조회
	public EmfMap selectCateList(EmfMap emfMap) throws Exception;
	
	//목록 조회
	public EmfMap select(EmfMap emfMap) throws Exception;
	
	//상세 조회
	public EmfMap selectMemo(EmfMap emfMap) throws Exception;
	
	//등록
	public void insertMemo(EmfMap emfMap) throws Exception;
	
	//등록
	public void deleteMemo(EmfMap emfMap) throws Exception;
	
	//삭제
	public void delete(EmfMap emfMap) throws Exception;
	
	//상태변경
	public void statusChange(EmfMap emfMap) throws Exception;
	
	//콜센터 목록 조회
	public EmfMap selectListCall(EmfMap emfMap) throws Exception;
	
	//목록 조회
	public EmfMap selectListExcelCall(EmfMap emfMap) throws Exception;
	
}
