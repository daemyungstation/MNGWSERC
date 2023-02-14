package mngwserc.co.cog.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import emf.core.extend.dao.EmfAbstractDAO;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 컨텐츠 관리를 위한 DAO
 * </pre>
 * 
 * @ClassName		: COGCntnsMngDAO.java
 * @Description		: 컨텐츠 관리를 위한 DAO
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
@Repository("cOGCntnsMngDAO")
public class COGCntnsMngDAO extends EmfAbstractDAO {
	
	/**
	 * 컨텐츠 메뉴를 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return List<EmfMap> 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectCntnsList(EmfMap emfMap) throws Exception
	{
		return list("COGCntnsMngDAO.selectCntnsList", emfMap);
	}	
	
	/**
	 * CMS가 등록되어있는 메뉴 정보 가져오기
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return List<EmfMap> 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> getRelMenuList(EmfMap emfMap) throws Exception
	{
		return list("COGCntnsMngDAO.getRelMenuList", emfMap);
	}	
	
	/**
	 * 컨텐츠 상세내용을 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return List<EmfMap> 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public EmfMap selectCntns(EmfMap emfMap) throws Exception
	{
		return (EmfMap) selectByPk("COGCntnsMngDAO.selectCntns", emfMap);
	}
	
	/**
	 * 컨텐츠 수정로그를 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return List<EmfMap> 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectCntnsLogList(EmfMap emfMap) throws Exception
	{
		return list("COGCntnsMngDAO.selectCntnsLogList", emfMap);
	}
	
	/**
	 * 컨텐츠 버전 정보 가져오기. 1.0 to_nuber로 해서 인트형으로 가져옴
	 * 
	 * @param EmfMap 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public String getCntnsVer(EmfMap emfMap) throws Exception
	{
		return (String) selectByPk("COGCntnsMngDAO.getCntnsVer", emfMap);
	}
	
	/**
	 * 컨텐츠 메뉴를 등록한다.
	 * 
	 * @param EmfMap 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void insertCntns(EmfMap emfMap) throws Exception
	{
		insert("COGCntnsMngDAO.insertCntns", emfMap);
	}
	
	/**
	 * 컨텐츠 메뉴를 수정한다.
	 * 
	 * @param EmfMap 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void updateCntns(EmfMap emfMap) throws Exception
	{
		update("COGCntnsMngDAO.updateCntns", emfMap);
	}	
	
	/**
	 * 컨텐츠 메뉴를 수정로그를 등록한다.
	 * 
	 * @param EmfMap 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void insertCntnsModLog(EmfMap emfMap) throws Exception
	{
		insert("COGCntnsMngDAO.insertCntnsModLog", emfMap);
	}
	
	/**
	 * 컨텐츠 메뉴를 삭제한다.
	 * 
	 * @param EmfMap 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void deleteCntns(EmfMap emfMap) throws Exception
	{
		update("COGCntnsMngDAO.deleteCntns", emfMap);
	}

	/**
	 * 컨텐츠 메뉴를 일반복사한다.
	 * 
	 * @param EmfMap 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void insertCopyCntns(EmfMap emfMap) throws Exception
	{
		insert("COGCntnsMngDAO.insertCopyCntns", emfMap);
	}
	
	/**
	 * CMS 다중 복사시 CMS 리스트 팝업 내용
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return List<EmfMap> 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> getCntnsList(EmfMap emfMap) throws Exception
	{
		return list("COGCntnsMngDAO.getCntnsList", emfMap);
	}
	
	/**
	 * 컨텐츠 승인한다.
	 * 
	 * @param EmfMap 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void updateApprovalContents(EmfMap emfMap) throws Exception
	{
		//기존 배포 -> 만기 변경
		update("COGCntnsMngDAO.updatePrevApprovalContents", emfMap);
		
		//배포 변경
		update("COGCntnsMngDAO.updateApprovalContents", emfMap);
	}

	/**
	 * 현재 CMS ID에 대한 배포중인 CMS 정보 가져오기
	 * 
	 * @param EmfMap 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public EmfMap selectApprovalCntns(EmfMap emfMap) throws Exception
	{
		return (EmfMap) selectByPk("COGCntnsMngDAO.selectApprovalCntns",emfMap);
	}
	
	/**
	 * 전체 최신 컨텐츠 가져오기
	 * 
	 * @param EmfMap 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectContentsAllList() throws Exception
	{
		return list("COGCntnsMngDAO.selectApprovalCntnsAll", null);
	}
}
