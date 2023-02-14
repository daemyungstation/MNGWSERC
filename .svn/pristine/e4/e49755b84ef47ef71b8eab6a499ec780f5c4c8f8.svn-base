package mngwserc.ri.ria.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import emf.core.extend.dao.EmfAbstractOutDAO;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 유치회원 위한 DAO
 * </pre>
 * 
 * @ClassName		: RIAInviteMemDAO.java
 * @Description		: 유치회원 위한 DAO
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
@Repository("rIAInviteMemDAO")
public class RIAInviteMemDAO extends EmfAbstractOutDAO {
	
	/**
	 * 유치회원 목록을 조회한다.
	 * 
	 * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectInviteMemList(EmfMap emfMap) throws Exception 
    {
    	return list("RIAInviteMemDAO.selectInviteMemList", emfMap);
    }	
	
	/**
	 * 유치회원 카운트
	 * 
	 * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public EmfMap selectInviteMemListCnt(EmfMap emfMap) throws Exception 
    {
    	return (EmfMap)selectByPk("RIAInviteMemDAO.selectInviteMemListCnt", emfMap);
    }
    
	/**
	 * grpEmpleNo로 사번을 조회한다.
	 * 
	 * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	 
	public List<EmfMap> selectEmplenoById(EmfMap emfMap) throws Exception{
		return list("RIAInviteMemDAO.selectEmplenoById", emfMap);
	}
	
	
	
}
