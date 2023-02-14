package mngwserc.om.omf.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import emf.core.extend.dao.EmfAbstractDAO;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 외주업체 페이지 관리를 위한 DAO
 * </pre>
 * 
 * @ClassName		: OMFOutsourcingPageMngDAO.java
 * @Description		: 외주업체 페이지 관리를 위한 DAO
 * @author 김필기
 * @since 2016.05.16
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2016.05.16		김필기					 최초생성
 * </pre>
 */
@Repository("oMFOutsourcingPageMngDAO")
public class OMFOutsourcingPageMngDAO extends EmfAbstractDAO {
	
	/**
	 * 외주업체 코드별 관리 목록을 조회한다
	 * 
	 * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectOutsourcingPageMngList(EmfMap emfMap) throws Exception 
    {
    	return list("OMFOutsourcingPageMngDAO.selectOutsourcingPageMngList", emfMap);
    }	
	
	/**
	 * 외주업체 코드별 관리 정보를 조회한다.
	 * 
	 * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public EmfMap selectOutsourcingPageMngInfo(EmfMap emfMap) throws Exception 
    {
    	return (EmfMap) selectByPk("OMFOutsourcingPageMngDAO.selectOutsourcingPageMngInfo", emfMap);
    }		
	
	/**
	 * 외주업체 페이지 관리 정보를 저장한다.
	 * 
	 * @param EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void insertOutsourcingPageMngInf(EmfMap emfMap) throws Exception 
    {
    	insert("OMFOutsourcingPageMngDAO.insertOutsourcingPageMngInf", emfMap);
    }
	
	/**
	 * 외주업체 페이지 관리 정보를 수정한다.
	 * 
	 * @param EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void updateOutsourcingPageMngInf(EmfMap emfMap) throws Exception 
    {
    	update("OMFOutsourcingPageMngDAO.updateOutsourcingPageMngInf", emfMap);
    }	
}
