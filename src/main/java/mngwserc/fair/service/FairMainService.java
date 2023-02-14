package mngwserc.fair.service;

import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 박람회 소구포인트 관리 Service
 * </pre>
 * 
 * @ClassName		: FairMainService.java
 * @Description		: 박람회 소구포인트 관리 Service
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

public interface FairMainService {

	//조회
	public EmfMap select() throws Exception;

	//업데이트
	public void update(EmfMap emfMap) throws Exception;
	
	//서브 목록 조회
	public EmfMap selectSubList(EmfMap emfMap) throws Exception;
	
	//서브 상세 조회
	public EmfMap selectSub(EmfMap emfMap) throws Exception;
	
	//서브 등록
	public void subInsert(EmfMap emfMap) throws Exception;
	
	//서브수정
	public void subUpdate(EmfMap emfMap) throws Exception;
	
	//서브 순서 변경
	public void subOrder(EmfMap emfMap) throws Exception;
	
	//서브 삭제
	public void subDelete(EmfMap emfMap) throws Exception;
}
