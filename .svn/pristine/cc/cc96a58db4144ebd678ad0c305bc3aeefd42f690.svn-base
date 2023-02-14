package mngwserc.cm.cmd.service.dao;

import java.util.List; 

import org.springframework.stereotype.Repository;

import emf.core.extend.dao.EmfAbstractDAO;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 멤버십카드신청 내역 관리를 위한 DAO
 * </pre>
 * 
 * @ClassName		: CMDMbspCardDAO.java
 * @Description		: 멤버십카드신청 내역 관리를 위한 DAO
 * @author 허진영
 * @since 2016.02.11
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author				  description
 *   ===========    ==============    =============================
 *    2016.02.11		허진영				    최초생성
 * </pre>
 */
@Repository("cMDMbspCardDAO")
public class CMDMbspCardDAO extends EmfAbstractDAO {
	
	/**
	 * 멤버십카드신청 내역 목록을 조회한다.
	 * 
	 * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectMbspCardList(EmfMap emfMap) throws Exception 
    {
    	return list("CMDMbspCardDAO.selectMbspCardList", emfMap);
    }	
	
	/**
     * 멤버십카드신청 내역 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectMbspCard(EmfMap emfMap) throws Exception 
    {
    	return (EmfMap)selectByPk("CMDMbspCardDAO.selectMbspCard", emfMap);
    }
    
	/**
     * 멤버십카드신청 내역을 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateMbspCard(EmfMap emfMap) throws Exception 
	{
		update("CMDMbspCardDAO.updateMbspCard", emfMap);
    }
	
	/**
     * 멤버십카드신청 내역 처리현황을 수정한다.
     * 
     * @param EmfMap
	 * @return int
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateMbspCardPrcsCd(EmfMap emfMap) throws Exception
	{
		update("CMDMbspCardDAO.updateMbspCardPrcsCd", emfMap);
	}
	
	/**
     * 멤버십카드신청 내역 처리현황을 일괄 수정한다.
     * 
     * @param EmfMap
	 * @return int
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateMbspCardPrcsCdAll(EmfMap emfMap) throws Exception
	{
		update("CMDMbspCardDAO.updateMbspCardPrcsCdAll", emfMap);
	}
	
	/**
     * 멤버십카드신청 내역 처리현황 로그를 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public int insertMbspCardPrcsLog(EmfMap emfMap) throws Exception
	{
		return insert("CMDMbspCardDAO.insertMbspCardPrcsLog", emfMap);
	}
	
	/**
	 * 멤버십카드신청 내역 목록을 조회한다. (엑셀 다운로드)
	 * 
	 * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> excelMbspCardList(EmfMap emfMap) throws Exception 
    {
    	return list("CMDMbspCardDAO.excelMbspCardList", emfMap);
    }	
}
