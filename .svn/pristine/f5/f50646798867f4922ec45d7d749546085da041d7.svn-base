package mngwserc.ri.rib.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import emf.core.extend.dao.EmfAbstractOutDAO;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 수당내역 위한 DAO
 * </pre>
 * 
 * @ClassName		: RIBBenefitDAO.java
 * @Description		: 수당내역 위한 DAO
 * @author 김필기
 * @since 2016.04.08
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2016.04.08		김필기					 최초생성
 * </pre>
 */
@Repository("rIBBenefitDAO")
public class RIBBenefitDAO extends EmfAbstractOutDAO {
	
	/**
	 * 수당내역 목록(년도별)을 조회한다.
	 * 
	 * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectYearBenefitList(EmfMap emfMap) throws Exception 
    {
    	return list("RIBBenefitDAO.selectYearBenefitList", emfMap);
    }	
	
	/**
	 * 수당내역 목록을 조회한다.
	 * 
	 * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectBenefitList(EmfMap emfMap) throws Exception 
    {
    	return list("RIBBenefitDAO.selectBenefitList", emfMap);
    }		
	
	/**
	 * 수당내역 전체 카운트를 조회한다.
	 * 
	 * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public EmfMap selectBenefitListCnt(EmfMap emfMap) throws Exception 
    {
    	return (EmfMap) selectByPk("RIBBenefitDAO.selectBenefitListCnt", emfMap);
    }		
}
