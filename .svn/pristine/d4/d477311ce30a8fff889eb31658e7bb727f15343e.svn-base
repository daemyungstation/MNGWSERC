package mngwserc.om.omb.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import emf.core.extend.dao.EmfAbstractOutDAO;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 외주업체 발주관리를 위한 DAO
 * </pre>
 * 
 * @ClassName		: OMBOrderMngDAO.java
 * @Description		: 외주업체 발주관리를 위한 DAO
 * @author 김필기
 * @since 2016.02.12
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2016.02.12		김필기					 최초생성
 * </pre>
 */
@Repository("oMBOrderMngDAO")
public class OMBOrderMngDAO extends EmfAbstractOutDAO {
	
	/**
	 * 외주업체 발주관리 목록을 조회한다.
	 * 
	 * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectOrderMngList(EmfMap emfMap) throws Exception 
    {
    	return list("OMBOrderMngDAO.selectOrderMngList", emfMap);
    }
	public EmfMap selectOrderMngListCnt(EmfMap emfMap) throws Exception 
    {
    	return (EmfMap)selectByPk("OMBOrderMngDAO.selectOrderMngListCnt", emfMap);
    }	
	
	/**
	 * 외주업체 발주관리 목록을 엑셀 다운로드한다.
	 * 
	 * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectOrderMngExcelList(EmfMap emfMap) throws Exception 
    {
    	return list("OMBOrderMngDAO.selectOrderMngExcelList", emfMap);
    }	
	
	
	/**
     * 외주업체 발주관리 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectOrderMng(EmfMap emfMap) throws Exception 
    {
    	return (EmfMap) selectByPk("OMBOrderMngDAO.selectOrderMng", emfMap);
    }
    
	/**
     *외주업체 발주관리을 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateOrderMng(EmfMap emfMap) throws Exception 
	{
		update("OMBOrderMngDAO.updateOrderMng", emfMap);
    }
	
	/**
     *외주업체 발주관리 발주등록
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertDeliveryInfo(EmfMap emfMap) throws Exception 
	{
		update("OMBOrderMngDAO.insertDeliveryInfo", emfMap);
    }	 
	
	/**
     *외주업체 발주관리 납품일 넣기(delv)
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateDelv(EmfMap emfMap) throws Exception 
	{
		update("OMBOrderMngDAO.updateDelv", emfMap);
    }	
	
	/**
     *외주업체 발주관리 보류일 넣기(hold)
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateHold(EmfMap emfMap) throws Exception 
	{
		update("OMBOrderMngDAO.updateHold", emfMap);
    }	

	/**
     *외주업체 발주관리 배송상황일자 넣기(req)
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateReq(EmfMap emfMap) throws Exception 
	{
		update("OMBOrderMngDAO.updateReq", emfMap);
    }		
	
	/**
     *외주업체 발주관리 업데이트(rowudt)
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateRowudt(EmfMap emfMap) throws Exception 
	{
		update("OMBOrderMngDAO.updateRowudt", emfMap);
    }			
	
	/**
     *외주업체 발주관리 상세화면 정보 변경
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateReply(EmfMap emfMap) throws Exception 
	{
		update("OMBOrderMngDAO.updateReply", emfMap);
    }	
	
}
