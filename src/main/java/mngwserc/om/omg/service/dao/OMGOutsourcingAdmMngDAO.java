package mngwserc.om.omg.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import emf.core.extend.dao.EmfAbstractDAO;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 외주업체 관리자 조건 관리를 위한 DAO
 * </pre>
 * 
 * @ClassName		: OMGOutsourcingAdmMngDAO.java
 * @Description		: 외주업체 관리자 조건 관리를 위한 DAO
 * @author 김필기
 * @since 2016.05.20
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2016.05.20		김필기					 최초생성
 * </pre>
 */
@Repository("oMGOutsourcingAdmMngDAO")
public class OMGOutsourcingAdmMngDAO extends EmfAbstractDAO {
	
	/**
	 * 조건 설정된 외주업체 관리자 목록을 조회한다.
	 * 
	 * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectOutsourcingAdmMngList(EmfMap emfMap) throws Exception 
    {
    	return list("OMGOutsourcingAdmMngDAO.selectOutsourcingAdmMngList", emfMap);
    }	
	
	/**
	 * 외주업체 관리자 조건 정보를 조회한다.
	 * 
	 * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public EmfMap selectOutsourcingAdmMngInfo(EmfMap emfMap) throws Exception 
    {
    	return (EmfMap) selectByPk("OMGOutsourcingAdmMngDAO.selectOutsourcingAdmMngInfo", emfMap);
    }		
	
	/**
	 * 외주업체 관리자 조건을 저장한다.
	 * 
	 * @param EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void insertOutsourcingAdmMngInf(EmfMap emfMap) throws Exception 
    {
    	insert("OMGOutsourcingAdmMngDAO.insertOutsourcingAdmMngInf", emfMap);
    }
	
	/**
	 * 외주업체 관리자 조건을 수정한다.
	 * 
	 * @param EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void updateOutsourcingAdmMngInf(EmfMap emfMap) throws Exception 
    {
    	update("OMGOutsourcingAdmMngDAO.updateOutsourcingAdmMngInf", emfMap);
    }	
	
	/**
	 * 외주업체 관리자 목록을 조회한다.
	 * 
	 * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectAdmList(EmfMap emfMap) throws Exception 
    {
    	return list("OMGOutsourcingAdmMngDAO.selectAdmList", emfMap);
    }	
}
