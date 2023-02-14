package mngwserc.cm.cma.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import emf.core.extend.dao.EmfAbstractOutDAO;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 전산db 조회를 위한 DAO
 * </pre>
 * 
 * @ClassName		: DmLifeDAO.java
 * @Description		: 전산db 조회를 위한 DAO
 * @author 김필기
 * @since 2016.02.18
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2016.02.18		김필기					 최초생성
 * </pre>
 */
@Repository("dMLifeDAO")
public class DmLifeDAO extends EmfAbstractOutDAO 
{
	/**
	 * 상품 목록을 조회한다.
	 * 
	 * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */	
	public List<EmfMap> getProductList(EmfMap emfMap) throws Exception 
    {
    	return list("DmLifeDAO.getProductList", emfMap);
    }			
	
	/**
	 * 납입방식 목록을 조회한다.
	 * 
	 * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */	
	public List<EmfMap> getPaymentMethod(EmfMap emfMap) throws Exception
	{
		return list("DmLifeDAO.getPaymentMethod", emfMap);
	}

	/**
	 * 상세상품을 조회한다.
	 * 
	 * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */	
	public List<EmfMap> getDetailProduct(EmfMap emfMap) throws Exception
	{
		return list("DmLifeDAO.getDetailProduct", emfMap);
	}

	/**
	 * 담당자 목록을 조회한다.
	 * 
	 * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */	
	public List<EmfMap> getEmployeeList(EmfMap emfMap) throws Exception
	{
		return list("DmLifeDAO.getEmployeeList", emfMap);
	}
	
	/**
	 * 회사 코드 목록을 조회한다.
	 * 
	 * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */	
	public List<EmfMap> getB2bComCdList(EmfMap emfMap) throws Exception 
    {
    	return list("DmLifeDAO.getB2bComCdList", emfMap);
    }		
	
	/**
	 * 공통 코드 정보를 조회한다.
	 * 
	 * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */	
	public EmfMap selectComCdInf(EmfMap emfMap) throws Exception 
    {
    	return (EmfMap) selectByPk("DmLifeDAO.selectComCdInf", emfMap);
    }		
	
	/**
     * member_no 조회
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */		
	public List<EmfMap> selectDMLifeMemInf(EmfMap emfMap) throws Exception
	{
		return list("DmLifeDAO.selectDMLifeMemInf", emfMap);
	}	
}