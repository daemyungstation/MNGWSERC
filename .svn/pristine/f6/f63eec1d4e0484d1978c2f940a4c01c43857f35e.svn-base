package mngwserc.co.cod.service.dao;

import org.springframework.stereotype.Repository;

import emf.core.extend.dao.EmfAbstractDAO;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 홈페이지(사용자) 메뉴관리를 위한 DAO
 * </pre>
 * 
 * @ClassName		: CODUserMenuDAO.java
 * @Description		: 홈페이지(사용자) 메뉴관리를 위한 DAO
 * @author 안진용
 * @since 2015.11.19
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2015.11.19		안진용					최초생성
 * </pre>
 */
@Repository("cODUserMenuDAO")
public class CODUserMenuDAO extends EmfAbstractDAO {
	
	/**
	 * 현재 배포중인거 있는지 찾기
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return EmfMap 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public EmfMap getApprovalCntns(EmfMap emfMap) throws Exception
	{
		return (EmfMap) selectByPk("CODUserMenuDAO.getApprovalCntns", emfMap);
	}	
}
