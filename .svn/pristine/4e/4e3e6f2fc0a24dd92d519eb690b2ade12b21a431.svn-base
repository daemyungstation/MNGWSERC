package mngwserc.cs.csa.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import emf.core.extend.dao.EmfAbstractOutDAO;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 전산DB 회원정보 DAO
 * </pre>
 * 
 * @ClassName		: DMLifeMemDAO.java
 * @Description		: 전산DB 회원정보 DAO
 * @author 김필기
 * @since 2016.03.03
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since		   author				 description
 *   ==========    ==============    =============================
 *   2016.03.03		   김필기				  최초 생성
 * </pre>
 */ 
@Repository("dMLifeMemDAO")
public class DMLifeMemDAO extends EmfAbstractOutDAO {
	
	/**
	 * 회원 정보를 가져온다
	 * 
	 * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectDMLifeMemInf(EmfMap emfMap) throws Exception
	{
		return list("DMLifeMemDAO.selectDMLifeMemInf", emfMap);	
	}
	
	/**
	 * 회원 정보를 가져온다(CI 비교)
	 * 
	 * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public EmfMap selectDMLifeMemInfByCi(EmfMap emfMap) throws Exception
	{
		return (EmfMap)selectByPk("DMLifeMemDAO.selectDMLifeMemInfByCi", emfMap);	
	}	
}
