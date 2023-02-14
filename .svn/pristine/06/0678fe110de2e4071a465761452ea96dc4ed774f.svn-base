package mngwserc.cs.csa.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import emf.core.extend.dao.EmfAbstractDAO;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * VOC DAO
 * </pre>
 * 
 * @ClassName		: CSAVocDAO.java
 * @Description		: VOC DAO
 * @author 장준일
 * @since 2021.02.23
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2021.02.23		징준일					 최초생성
 * </pre>
 */
@Repository("cSAVocDAO")
public class CSAVocDAO extends EmfAbstractDAO {
	
	/**
	 * VOC 목록을 조회한다.
	 * 
	 * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectVocList(EmfMap emfMap) throws Exception 
    {
    	return list("CSAVocDAO.selectVocList", emfMap);
    }	
	
	/**
     * VOC 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectVoc(EmfMap emfMap) throws Exception 
    {
    	return (EmfMap)selectByPk("CSAVocDAO.selectVoc", emfMap);
    }
    
	/**
     * VOC 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteVoc(EmfMap emfMap) throws Exception
	{
		delete("CSAVocDAO.deleteVoc", emfMap);
	}
}
