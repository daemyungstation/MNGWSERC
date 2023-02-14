package mngwserc.om.omc.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import emf.core.extend.dao.EmfAbstractOutDAO;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 외주업체 입금관리를 위한 DAO
 * </pre>
 * 
 * @ClassName		: OMCDepositMngDAO.java
 * @Description		: 외주업체 입금관리를 위한 DAO
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
@Repository("oMCDepositMngDAO")
public class OMCDepositMngDAO extends EmfAbstractOutDAO {
	
	/**
	 * 외주업체 입금관리 목록을 조회한다.
	 * 
	 * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectDepositMngList(EmfMap emfMap) throws Exception 
    {
    	return list("OMCDepositMngDAO.selectDepositMngList", emfMap);
    }	

	public EmfMap selectDepositMngListCnt(EmfMap emfMap) throws Exception 
    {
    	return (EmfMap)selectByPk("OMCDepositMngDAO.selectDepositMngListCnt", emfMap);
    }	
	
	/**
	 * 외주업체 입금관리 목록을 엑셀 다운로드한다.
	 * 
	 * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectDepositMngExcelList(EmfMap emfMap) throws Exception 
    {
    	return list("OMCDepositMngDAO.selectDepositMngExcelList", emfMap);
    }		
	
	
}
