package mngwserc.cn.cnb.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import emf.core.extend.dao.EmfAbstractDAO;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 이용안내 관리를 위한 DAO
 * </pre>
 * 
 * @ClassName		: SMDOprtGuideDAO.java
 * @Description		: 이용안내 관리를 위한 DAO
 * @author 허진영
 * @since 2016.02.12
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since		   author				  description
 *   ==========    ==============    =============================
 *   2016.02.12		   허진영				   최초 생성
 * </pre>
 */
@Repository("cNBOprtGuideDAO")
public class CNBOprtGuideDAO extends EmfAbstractDAO {
	
	/**
	 * 이용안내 목록을 조회한다.
	 * 
	 * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectOprtGuideList(EmfMap emfMap) throws Exception 
    {
    	return list("CNBOprtMngDAO.selectOprtGuideList", emfMap);
    }
	
	/**
     * 이용안내 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public EmfMap selectOprtGuide(EmfMap emfMap) throws Exception
	{
		return (EmfMap) selectByPk("CNBOprtMngDAO.selectOprtGuide", emfMap);
	}
	
	/**
     * 이용안내를 등록한다.
     * 
     * @param EmfMap
	 * @return
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertOprtGuide(EmfMap emfMap)
	{
		insert("CNBOprtMngDAO.insertOprtGuide", emfMap);
	}
	
	/**
     * 이용안내를 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateOprtGuide(EmfMap emfMap) throws Exception
	{
		update("CNBOprtMngDAO.updateOprtGuide", emfMap);
	}
	
	/**
     * 이용안내를 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteOprtGuide(EmfMap emfMap) throws Exception
	{
		delete("CNBOprtMngDAO.deleteOprtGuide", emfMap);
	}
	
    /**
	 * 이용안내를 복사한다.
	 * 
	 * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */	
	public void insertOprtGuideCopy(EmfMap emfMap) throws Exception 
	{
		insert("CNBOprtMngDAO.insertOprtGuideCopy", emfMap);
	}
}
