package mngwserc.mb.mba.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import emf.core.extend.dao.EmfAbstractDAO;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 회원정보 관리를 위한 DAO
 * </pre>
 * 
 * @ClassName		: MBAMemInfDAO.java
 * @Description		: 회원정보 관리를 위한 DAO
 * @author 허진영
 * @since 2016.02.15
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2016.02.15		허진영					 최초생성
 * </pre>
 */
@Repository("mBAMemInfDAO")
public class MBAMemInfDAO extends EmfAbstractDAO {
	
	/**
     * 회원 정보 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public List<EmfMap> selectMemInfList(EmfMap emfMap) throws Exception
	{
		return list("MBAMemInfDAO.selectMemInfList", emfMap);
	}
	
	/**
     * 회원 정보 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public EmfMap selectMemInf(EmfMap emfMap) throws Exception
	{
		return (EmfMap) selectByPk("MBAMemInfDAO.selectMemInf", emfMap);
	}
	
	/**
     * 회원 정보를 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateMemInf(EmfMap emfMap) throws Exception
	{
		update("MBAMemInfDAO.updateMemInf", emfMap);
	}
	
	/**
     * 회원 기타 정보를 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateEtcInf(EmfMap emfMap) throws Exception
	{
		update("MBAMemInfDAO.updateEtcInf", emfMap);
	}
	
	/**
     * 회원 서비스수신 변경 로그를 조회한다.
     * 
     * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public List<EmfMap> selectSrvcRcvModLog(EmfMap emfMap) throws Exception
	{
		return list("MBAMemInfDAO.selectSrvcRcvModLog", emfMap);
	}
	
	/**
     * 회원탈퇴를 한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateMemDrot(EmfMap emfMap) throws Exception
	{
		update("MBAMemInfDAO.updateMemDrot", emfMap);
	}
	
	/**
     * 부가식별정보를 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteIdntInf(EmfMap emfMap) throws Exception {
		update("MBAMemInfDAO.deleteIdntInf", emfMap);
	}
	
	/**
     * 회원 정보 변경 로그를 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertMemInfModLog(EmfMap emfMap) throws Exception
	{
		insert("MBAMemInfDAO.insertMemInfModLog", emfMap);
	}
	
	/**
     * 회원 정보 목록을 조회한다. (엑셀다운로드)
     * 
     * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public List<EmfMap> excelMemInfList(EmfMap emfMap) throws Exception
	{
		return list("MBAMemInfDAO.excelMemInfList", emfMap);
	}
	
	/**
     * 고객서비스 변경 목록을 조회한다. (엑셀다운로드)
     * 
     * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public List<EmfMap> excelRcvModList(EmfMap emfMap) throws Exception {
		return list("MBAMemInfDAO.excelRcvModList", emfMap);
	}

	public void insertMemDropInfo(EmfMap emfMap) throws Exception {
		insert("MBAMemInfDAO.insertMemDropInfo", emfMap);
	}

	public void deleteMemDrot(EmfMap emfMap) throws Exception {
		delete("MBAMemInfDAO.deleteMemDrot", emfMap);
	}

	public void deleteMemEtcDrot(EmfMap emfMap) throws Exception {
		delete("MBAMemInfDAO.deleteMemEtcDrot", emfMap);
	}

	/**
	 * 통합회원 정보를 조회.
	 *
	 * @param emfMap
	 * @return
	 * @throws Exception
	 */
	public EmfMap getIntegrationMember(EmfMap emfMap) throws Exception {
		EmfMap paramMap = new EmfMap();
		paramMap.put("homepageId", emfMap.get("id"));
		return (EmfMap) selectByPk("MBAMemInfDAO.getIntegrationMember", paramMap);
	}

	public void dropOutIntegrationMember(EmfMap emfMap) throws Exception {
		update("MBAMemInfDAO.dropOutIntegrationMember", emfMap);
	}
}
