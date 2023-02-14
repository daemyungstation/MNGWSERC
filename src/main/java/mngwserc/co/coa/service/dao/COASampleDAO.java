package mngwserc.co.coa.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import emf.core.extend.dao.EmfAbstractDAO;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 샘플 DAO 구현
 * </pre>
 * 
 * @ClassName		: CMASampleDAO.java
 * @Description		: 샘플 DAO 구현
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
@Repository("cOASampleDAO")
public class COASampleDAO extends EmfAbstractDAO {
	/**
	 * 메뉴 리스트를 조회한다.
	 * 
	 * @param haeVO 검색할 데이터
	 * @return resultVO:HaeVO 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
    public List selectSampleList(EmfMap egovMap) throws Exception
    {
    	return this.list("CODMenu.selectSampleList",  egovMap);
    }
}
