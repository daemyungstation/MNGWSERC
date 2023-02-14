package mngwserc.cm.cmb.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import emf.core.extend.dao.EmfAbstractDAO;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 전환서비스 체계 관리를 위한 DAO
 * </pre>
 * 
 * @ClassName		: CMBChngSysDAO.java
 * @Description		: 전환서비스 체계 관리를 위한 DAO
 * @author 허진영
 * @since 2016.02.17
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2016.02.17		허진영					 최초생성
 * </pre>
 */
@Repository("cMBChngSysDAO")
public class CMBChngSysDAO extends EmfAbstractDAO {	
	
	/**
     * 전환서비스 쳬계 그룹 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public List<EmfMap> selectChngSysGrpList(EmfMap emfMap) throws Exception
	{
		return list("CMBChngSysDAO.selectChngSysGrpList", emfMap);
	}
	
	/**
     * 전환서비스 모든 상품을 가져온다.
     * 
     * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public List<EmfMap> getPrdctAllList() throws Exception
	{
		return list("CMBChngSysDAO.getPrdctAllList", null);
	}
	
	/**
     * 전환서비스 쳬계 그룹을 등록을 위해 중복 검사를 한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public int getChngSysGrpNmExstCnt(EmfMap emfMap) throws Exception
	{
		return (Integer) selectByPk("CMBChngSysDAO.getChngSysGrpNmExstCnt", emfMap);
	}
	
	/**
     * 전환서비스 쳬계 그룹을 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertChngSysGrp(EmfMap emfMap) throws Exception
	{
		insert("CMBChngSysDAO.insertChngSysGrp", emfMap);
	}
	
	/**
     * 전환서비스 쳬계 그룹 상세를 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertChngSysGrpDtl(EmfMap emfMap) throws Exception
	{
		insert("CMBChngSysDAO.insertChngSysGrpDtl", emfMap);
	}
	
	/**
     * 전환서비스 쳬계 그룹을 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateChngSysGrp(EmfMap emfMap) throws Exception
	{
		update("CMBChngSysDAO.updateChngSysGrp", emfMap);
	}
	
	/**
     * 전환서비스 쳬계 그룹 상세를 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateChngSysGrpDtl(EmfMap emfMap) throws Exception
	{
		update("CMBChngSysDAO.updateChngSysGrpDtl", emfMap);
	}
	
	/**
     * 전환서비스 쳬계 그룹을 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteChngSysGrp(EmfMap emfMap) throws Exception
	{
		delete("CMBChngSysDAO.deleteChngSysGrp", emfMap);
	}
	
	/**
     * 전환서비스 쳬계 그룹 상세를 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteChngSysGrpDtl(EmfMap emfMap) throws Exception
	{
		delete("CMBChngSysDAO.deleteChngSysGrpDtl", emfMap);
	}
	
	/**
     * 전환서비스 쳬계 그룹 상품 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public List<EmfMap> selectChngSysGrpPrdctList(EmfMap emfMap) throws Exception
	{
		return list("CMBChngSysDAO.selectChngSysGrpPrdctList", emfMap);
	}
	
	/**
     * 전환서비스 쳬계 그룹 모든 상품을 가져온다.
     * 
     * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public List<EmfMap> getChngSysGrpPrdctAllList(EmfMap emfMap) throws Exception
	{
		return list("CMBChngSysDAO.getChngSysGrpPrdctAllList", emfMap);
	}
	
	/**
     * 전환서비스 체계 그룹 상세를 가져온다.
     * 
     * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public List<EmfMap> getChngSysGrpDtl(EmfMap emfMap) throws Exception
	{
		return list("CMBChngSysDAO.getChngSysGrpDtl", emfMap);
	}
	/**
     * 전환서비스 쳬계 그룹 상품을 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertChngSysGrpPrdct(EmfMap emfMap) throws Exception
	{
		insert("CMBChngSysDAO.insertChngSysGrpPrdct", emfMap);
	}
	
	/**
     * 전환서비스 쳬계 그룹명을 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateChngSysGrpNm(EmfMap emfMap) throws Exception
	{
		update("CMBChngSysDAO.updateChngSysGrpNm", emfMap);
	}
	
	/**
     * 전환서비스 쳬계 그룹 상품을 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteChngSysGrpPrdct(EmfMap emfMap) throws Exception
	{
		delete("CMBChngSysDAO.deleteChngSysGrpPrdct", emfMap);
	}
	
	/**
     * 전환서비스 쳬계 그룹 상품 목록을 조회한다. (엑셀 다운로드)
     * 
     * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public List<EmfMap> excelChngSysGrpPrdctList(EmfMap emfMap) throws Exception
	{
		return list("CMBChngSysDAO.excelChngSysGrpPrdctList", emfMap);
	}
}
