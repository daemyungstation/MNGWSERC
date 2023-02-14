package mngwserc.pr.prb.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import emf.core.extend.dao.EmfAbstractDAO;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 네이버 실검 테스트 프로모션 관리 DAO
 * </pre>
 * 
 * @ClassName		: PRBNaverTestPromotionMngDAO.java
 * @Description		: 네이버 실검 테스트 프로모션 DAO
 * @author inuscomm
 * @since 2019. 07. 16.
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2019. 07. 16.	   inuscomm				                최초생성
 * </pre>
 */

@Repository("pRBNaverTestPromotionMngDAO")
public class PRBNaverTestPromotionMngDAO extends EmfAbstractDAO {
	
	/**
	 * 설정을 조회한다.
	 * 
	 * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectConfigList(EmfMap emfMap) throws Exception
	{
		return list("PRBNaverTestPromotionMngDAO.selectConfigList", emfMap);
	}
	
	/**
     * 설정을 업데이트한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public void updateConfig(EmfMap emfMap) throws Exception 
    {
    	update("PRBNaverTestPromotionMngDAO.updateConfig", emfMap);	
    }
	
	/**
	 * 목록을 조회한다.
	 * 
	 * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectList(EmfMap emfMap) throws Exception
	{
		return list("PRBNaverTestPromotionMngDAO.selectList", emfMap);
	}
	
	/**
	 * 목록을 다운로드 한다.
	 * 
	 * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectExcelList(EmfMap emfMap) throws Exception
	{
		return list("PRBNaverTestPromotionMngDAO.selectExcelList", emfMap);
	}
	
	/**
	 * Pv목록을 조회한다.
	 * 
	 * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectPvList(EmfMap emfMap) throws Exception
	{
		return list("PRBNaverTestPromotionMngDAO.selectPvList", emfMap);
	}
	
	/**
	 * Pv목록을 다운로드 한다.
	 * 
	 * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectPvExcelList(EmfMap emfMap) throws Exception
	{
		return list("PRBNaverTestPromotionMngDAO.selectPvExcelList", emfMap);
	}
	
}