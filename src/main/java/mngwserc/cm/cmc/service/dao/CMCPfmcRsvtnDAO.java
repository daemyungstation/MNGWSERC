package mngwserc.cm.cmc.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import emf.core.extend.dao.EmfAbstractDAO;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 공연예약 관리를 위한 DAO
 * </pre>
 * 
 * @ClassName		: CMCPfmcRsvtnDAO.java
 * @Description		: 공연예약 관리를 위한 DAO
 * @author 허진영
 * @since 2016.02.18
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2016.02.18		허진영				 최초생성
 * </pre>
 */
@Repository("cMCPfmcRsvtnDAO")
public class CMCPfmcRsvtnDAO extends EmfAbstractDAO {
	
	/**
     * 공연예약 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public List<EmfMap> selectPfmcRsvtnList(EmfMap emfMap) throws Exception 
	{
		return list("CMCPfmcRsvtnDAO.selectPfmcRsvtnList", emfMap);
	}
	
	/**
     * 공연예약 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public EmfMap selectPfmcRsvtn(EmfMap emfMap) throws Exception 
	{
		return (EmfMap) selectByPk("CMCPfmcRsvtnDAO.selectPfmcRsvtn", emfMap);
	}

	/**
     * 공연예약을 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updatePfmcRsvtn(EmfMap emfMap) throws Exception 
	{
		update("CMCPfmcRsvtnDAO.updatePfmcRsvtn", emfMap);
	}
	
	/**
     * 공연예약을 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deletePfmcRsvtn(EmfMap emfMap) throws Exception 
	{
		delete("CMCPfmcRsvtnDAO.deletePfmcRsvtn", emfMap);
	}
	
	/**
     * 공연예약 목록을 조회한다. (엑셀다운로드)
     * 
     * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public List<EmfMap> excelPfmcRsvtnList(EmfMap emfMap) throws Exception
	{
		return list("CMCPfmcRsvtnDAO.excelPfmcRsvtnList", emfMap);
	}
	
	/**
     * 공연예약 로그를 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public int insertPfmcRsvtnPrcsLog(EmfMap emfMap) throws Exception 
	{
		return update("CMCPfmcRsvtnDAO.insertPfmcRsvtnPrcsLog", emfMap);
    }
	
	/**
     * 공연예약 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public List<EmfMap> selectPfmcRsvtnCnslList(EmfMap emfMap) throws Exception 
	{
		return list("CMCPfmcRsvtnDAO.selectPfmcRsvtnCnslList", emfMap);
	}
	
	/**
     * 공연예약 상담이력을 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertPfmcRsvtnCnsl(EmfMap emfMap) throws Exception 
	{
		update("CMCPfmcRsvtnDAO.insertPfmcRsvtnCnsl", emfMap);
	}
	
	/**
     * 공연예약 담당자 확인을 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updatePfmcRsvtnConf(EmfMap emfMap) throws Exception 
	{
		update("CMCPfmcRsvtnDAO.updatePfmcRsvtnConf", emfMap);
	}
}