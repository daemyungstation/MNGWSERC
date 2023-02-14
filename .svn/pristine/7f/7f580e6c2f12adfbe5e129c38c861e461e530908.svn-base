package mngwserc.mb.mba.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import emf.core.extend.dao.EmfAbstractDAO;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 회원정보 변경내역 관리를 위한 Service
 * </pre>
 * 
 * @ClassName		: MBAMemChngDAO.java
 * @Description		: 회원정보 변경내역 관리를 위한 Service
 * @author 허진영
 * @since 2016.02.22
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author				   description
 *   ===========    ==============    =============================
 *    2016.02.22		허진영					최초 생성
 * </pre>
 */
@Repository("mBAMemChngDAO")
public class MBAMemChngDAO extends EmfAbstractDAO {	
	
	/**
     * 회원정보 변경내역 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public List<EmfMap> selectMemChngList(EmfMap emfMap) throws Exception
	{
		return list("MBAMemChngDAO.selectMemChngList", emfMap);
	}
	
	/**
     * 회원정보 변경내역 처리현황을 수정한다.
     * 
     * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateChngPtcPrcsYn(EmfMap emfMap) throws Exception
	{
		update("MBAMemChngDAO.updateChngPtcPrcsYn", emfMap);
	}
	
	/**
     * 회원정보 변경내역 목록을 조회한다. (엑셀다운로드)
     * 
     * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public List<EmfMap> excelMemChngList(EmfMap emfMap) throws Exception
	{
		return list("MBAMemChngDAO.excelMemChngList", emfMap);
	}
}
