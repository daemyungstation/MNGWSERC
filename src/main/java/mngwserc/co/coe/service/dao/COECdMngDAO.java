package mngwserc.co.coe.service.dao;

import java.util.List; 

 
import org.springframework.stereotype.Repository;

import emf.core.extend.dao.EmfAbstractDAO;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 코드 관리를 위한 DAO
 * </pre>
 * 
 * @ClassName		: COECdMngDAO.java
 * @Description		: 코드 관리를 위한 DAO
 * @author 박주석
 * @since 2015.11.12
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2015.11.12		박주석					최초생성
 * </pre>
 */
@Repository("cOECdMngDAO")
public class COECdMngDAO extends EmfAbstractDAO {

	/**
	 *  상위코드 목록을 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return List<EmfMap> 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
    public List<EmfMap> selectCdIdList(EmfMap emfMap) throws Exception
    {    	
    	return list("COECdMngDAO.selectCdIdList", emfMap);
    }
    
    /**
	 * 하위코드 목록을 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return List<EmfMap> 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectCdIdDtl(EmfMap emfMap) throws Exception
	{
		return list("COECdMngDAO.selectCdIdDtl", emfMap);
	}
	
	/**
	 * 상위코드를 등록한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void insertCode(EmfMap emfMap) throws Exception
	{
		insert("COECdMngDAO.insertCode", emfMap);
	}
	
	/**
	 * 상위코드를 수정한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void updateCode(EmfMap emfMap) throws Exception
	{
		update("COECdMngDAO.updateCode", emfMap);
	}
	
	/**
	 * 상위코드를 삭제한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void deleteCode(EmfMap emfMap) throws Exception
	{
		delete("COECdMngDAO.deleteCode", emfMap);
		delete("COECdMngDAO.deleteCodeDtl", emfMap);
	}
	
	/**
	 * 하위코드를 등록한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void insertCodeDetail(EmfMap emfMap) throws Exception
	{
		insert("COECdMngDAO.insertCodeDetail", emfMap);
	}
	
	/**
	 * 하위코드를 수정한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void updateCodeDetail(EmfMap emfMap) throws Exception
	{
		update("COECdMngDAO.updateCodeDetail", emfMap);
	}
	
	/**
	 * 하위코드를 삭제한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void deleteCodeDetail(EmfMap emfMap) throws Exception
	{
		delete("COECdMngDAO.deleteCodeDetail", emfMap);
	}
	
	/**
	 * 파라미터로 넘긴 값의 CDNM을 불러온다
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectCodeNm(EmfMap emfMap) throws Exception 
	{
		return list("COECdMngDAO.selectcdNmList", emfMap);
	}
}
