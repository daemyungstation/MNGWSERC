package mngwserc.fair.service;

import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 박람회 탑배너 관리 Service
 * </pre>
 * 
 * @ClassName		: FairBannerTopService.java
 * @Description		: 박람회 탑배너 관리 Service
 * @author inuscommunity
 * @since 2019. 10. 14.
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 	since			author	          description
 *  =============   ==============    =============================
 *  2019. 10. 14.	inuscomm          최초생성
 * </pre>
 */

public interface FairBannerTopService {
	
	//목록 조회
	public EmfMap selectList(EmfMap emfMap) throws Exception;
	
	//상세 조회
	public EmfMap select(EmfMap emfMap) throws Exception;
	
	//등록
	public void insert(EmfMap emfMap) throws Exception;
	
	//수정
	public void update(EmfMap emfMap) throws Exception;
	
	//순서 변경
	public void order(EmfMap emfMap) throws Exception;
	
	//삭제
	public void delete(EmfMap emfMap) throws Exception;
}
