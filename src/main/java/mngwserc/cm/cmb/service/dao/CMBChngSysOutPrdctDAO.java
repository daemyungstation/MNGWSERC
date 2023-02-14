package mngwserc.cm.cmb.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import emf.core.extend.dao.EmfAbstractOutDAO;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 전환서비스 체계 외부상품(엔컴) 조회를 위한 DAO
 * </pre>
 * 
 * @ClassName		: CMBChngSysOutPrdctDAO.java
 * @Description		: 전환서비스 체계 외부상품(엔컴) 조회를 위한 DAO
 * @author 허진영
 * @since 2016.02.19
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2016.02.19		허진영					 최초생성
 * </pre>
 */
@Repository("cMBChngSysOutPrdctDAO")
public class CMBChngSysOutPrdctDAO extends EmfAbstractOutDAO {	
	
	/**
     * 전환서비스 쳬계 외부상품(엔컴) 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public List<EmfMap> selectChngSysOutPrdctList(EmfMap emfMap) throws Exception
	{
		return list("CMBChngSysOutPrdctDAO.selectChngSysOutPrdctList", emfMap);
	}
}
