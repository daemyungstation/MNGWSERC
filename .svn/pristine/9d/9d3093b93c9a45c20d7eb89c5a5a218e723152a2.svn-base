package mngwserc.cm.cmc.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import emf.core.extend.dao.EmfAbstractDAO;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 공연정보 관리를 위한 DAO
 * </pre>
 * 
 * @ClassName		: CMCPfmcInfDAO.java
 * @Description		: 공연정보 관리를 위한 DAO
 * @author 허진영
 * @since 2016.02.11
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2016.02.11		허진영					 최초생성
 * </pre>
 */
@Repository("cMCPfmcInfDAO")
public class CMCPfmcInfDAO extends EmfAbstractDAO {
	
	/**
     * 공연정보 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public List<EmfMap> selectPfmcInfList(EmfMap emfMap) throws Exception
    {
    	return list("CMCPfmcInfDAO.selectPfmcInfList", emfMap);
    }
    
    /**
     * 공연정보 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectPfmcInf(EmfMap emfMap) throws Exception
    {
    	return (EmfMap) selectByPk("CMCPfmcInfDAO.selectPfmcInf", emfMap);
    }
    
	/**
     * 공연정보를 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertPfmcInf(EmfMap emfMap) throws Exception
	{
		insert("CMCPfmcInfDAO.insertPfmcInf", emfMap);
	}
	
	/**
     * 공연정보를 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updatePfmcInf(EmfMap emfMap) throws Exception
	{
		update("CMCPfmcInfDAO.updatePfmcInf", emfMap);
	}
	
	/**
     * 공연정보를 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deletePfmcInf(EmfMap emfMap) throws Exception
	{
		delete("CMCPfmcInfDAO.deletePfmcInf", emfMap);
	}
	
	/**
     * 공연예약일시정보를 전체삭제한다.
     * 
     * @param EmfMap
	 * @return
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteRsvtnDtmAll(EmfMap emfMap) throws Exception
	{
		delete("CMCPfmcInfDAO.deleteRsvtnDtmAll", emfMap);
	}
	
	/**
     * 공연예약일시 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public List<EmfMap> selectRsvtnDtmList(EmfMap emfMap) throws Exception
    {
    	return list("CMCPfmcInfDAO.selectRsvtnDtmList", emfMap);
    }
    
    /**
     * 공연정보 좌석을 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateSeatUseYn(EmfMap emfMap) throws Exception
	{
		update("CMCPfmcInfDAO.updateSeatUseYn", emfMap);
	}
    
    /**
     * 공연예약일시를 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertRsvtnDtm(EmfMap emfMap) throws Exception
	{
		insert("CMCPfmcInfDAO.insertRsvtnDtm", emfMap);
	}
	
	/**
     * 공연예약일시를 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteRsvtnDtm(EmfMap emfMap) throws Exception
	{
		delete("CMCPfmcInfDAO.deleteRsvtnDtm", emfMap);
	}
}
