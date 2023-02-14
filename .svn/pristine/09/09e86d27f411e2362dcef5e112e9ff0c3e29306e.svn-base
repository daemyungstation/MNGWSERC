package mngwserc.co.coe.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import emf.core.extend.dao.EmfAbstractDAO;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 링크코드 관리를 위한 DAO
 * </pre>
 * 
 * @ClassName		: COECdLinkDAO.java
 * @Description		: 링크코드 관리를 위한 DAO
 * @author 허진영
 * @since 2016.03.28
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author				   description
 *   ===========    ==============    =============================
 *   2016.03.28			허진영					최초 생성
 * </pre>
 */
@Repository("cOECdLinkDAO")
public class COECdLinkDAO extends EmfAbstractDAO {
	
	/**
	 * 코드 링크 목록을 조회한다.
	 * 
	 * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectLinkList(EmfMap emfMap) throws Exception 
    {
    	return list("COECdLinkDAO.selectLinkList", emfMap);
    }	
	
	/**
	 * 링크코드를 등록한다.
	 * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void insertCdLink(EmfMap emfMap) throws Exception
	{
		insert("COECdLinkDAO.insertCdLink", emfMap);
	}
	
	/**
	 * 링크코드를 삭제한다. 
	 * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void deleteCdLink(EmfMap emfMap) throws Exception
	{
		delete("COECdLinkDAO.deleteCdLink", emfMap);
	}
}
