package mngwserc.cm.cmg.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import emf.core.extend.dao.EmfAbstractDAO;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 결제계좌변경 내역 관리를 위한 DAO
 * </pre>
 * 
 * @ClassName		: CMGAcntChngDAO.java
 * @Description		: 결제계좌변경 내역 관리를 위한 DAO
 * @author 허진영
 * @since 2016.03.07
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2016.03.07		허진영					 최초생성
 * </pre>
 */
@Repository("cMGAcntChngDAO")
public class CMGAcntChngDAO extends EmfAbstractDAO {	
	
	/**
	 * 결제계좌 변경내역 목록을 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */	
	public List<EmfMap> selectAcntChngList(EmfMap emfMap) throws Exception
	{
		return list("CMGAcntChngDAO.selectAcntChngList", emfMap);
	}
	
	/**
     * 결제계좌 변경내역 처리현황을 수정한다.
     * 
     * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateChngPtcPrcsYn(EmfMap emfMap) throws Exception
	{
		update("CMGAcntChngDAO.updateChngPtcPrcsYn", emfMap);
	}
}
