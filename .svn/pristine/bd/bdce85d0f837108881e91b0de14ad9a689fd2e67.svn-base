package mngwserc.om.oma.service.dao;

import java.util.List;

import mngwserc.om.oma.service.impl.OMACounselExcelHandler;

import org.springframework.stereotype.Repository;

import emf.core.extend.dao.EmfAbstractDAO;
import emf.core.extend.dao.EmfAbstractOutDAO;
import emf.core.vo.EmfMap;
/**
 * <pre> 
 * 외주업체 상담관리를 위한 DAO (DB접속계정 : lf_dmuser)
 * </pre>
 * 
 * @ClassName		: OMACounselMng2DAO.java
 * @Description		: 외주업체 상담관리를 위한 DAO
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
@Repository("oMACounselMng2DAO")
public class OMACounselMng2DAO extends EmfAbstractOutDAO {
	
	/**
	 * 외주업체 상담관리 목록을 조회한다.
	 * 
	 * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectCounselMngList(EmfMap emfMap) throws Exception 
    {
    	return list("OMACounselMng2DAO.selectCounselMngList", emfMap);
    }

	/**
     * 외주업체 상담관리 엑셀 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public List<EmfMap> selectCounselMngExcelList(EmfMap emfMap) throws Exception
	{
		return list("OMACounselMng2DAO.selectCounselMngExcelList", emfMap);
	}
}
