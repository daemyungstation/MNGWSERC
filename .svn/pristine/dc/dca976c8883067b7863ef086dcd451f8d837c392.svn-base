package mngwserc.fair.service;

import java.util.List;

import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 박람회 제품 상세 관리 Service
 * </pre>
 * 
 * @ClassName		: FairProductDetailService.java
 * @Description		: 박람회 제품 상세 관리 Service
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

public interface FairProductDetailService {

	//목록 조회
	public EmfMap selectList(EmfMap emfMap) throws Exception;
	
	//상세 조회
	public EmfMap select(EmfMap emfMap) throws Exception;
	
	//등록
	public void insert(EmfMap emfMap) throws Exception;
	
	//수정
	public void update(EmfMap emfMap) throws Exception;
	
	//파일업로드
	public EmfMap fileUpload(EmfMap emfMap) throws Exception;
		
	//순서 변경
	public void order(EmfMap emfMap) throws Exception;
	
	//순서 변경
	public int copy(EmfMap emfMap) throws Exception;
			
	//삭제
	public void delete(EmfMap emfMap) throws Exception;

	//카테고리 조회
	public List<EmfMap> selectCate() throws Exception;
	
	//입력폼 조회
	public List<EmfMap> selectInput() throws Exception;
	
	//결합혜택 조회
	public List<EmfMap> selectBenefit() throws Exception;
}
