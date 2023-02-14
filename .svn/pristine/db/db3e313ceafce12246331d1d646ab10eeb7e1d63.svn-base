package mngwserc.cn.cna.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import emf.core.extend.dao.EmfAbstractDAO;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 제로초이스를 위한 DAO
 * </pre>
 * 
 * @ClassName		: CNALimitedChoiceDAO.java
 * @Description		: 제로초이스를 위한 DAO
 * @author 강재석
 * @since 2018.03.05
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2018.03.05		강재석					 최초생성
 * </pre>
 */
@Repository("cNALimitedChoiceDAO")
public class CNALimitedChoiceDAO extends EmfAbstractDAO {

	/**
	 * 제로초이스 카테고리관리 리스트를 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return List<EmfMap> 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectLimitedChoiList(EmfMap emfMap) throws Exception{
		return list("CNALimitedChoiceDAO.selectLimitedChoiList", emfMap);
	}

	/**
	 * 리미티드 초이스 정보를 등록한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return List<EmfMap> 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void insertLimitedChoiseInfo(EmfMap emfMap) throws Exception {
		insert("CNALimitedChoiceDAO.insertLimitedChoiseInfo", emfMap);
		
	}

	/**
	 * 리미티드 초이스 파일 정보를 저장한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return List<EmfMap> 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void insertLimitedChoiseFile(EmfMap emfMap) throws Exception {
		insert("CNALimitedChoiceDAO.insertLimitedChoiseFile", emfMap);
	}

	/**
	 * 리미티드 초이스 정보를 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return EmfMap 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public EmfMap selectLimitedChoice(EmfMap emfMap) {
		return (EmfMap) selectByPk("CNALimitedChoiceDAO.selectLimitedChoice", emfMap);
	}

	/**
	 * 리미티드 초이스 파일 정보를 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return List<EmfMap> 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectLimitedChoiceFileInfo(EmfMap emfMap) {
		return list("CNALimitedChoiceDAO.selectLimitedChoiceFileInfo", emfMap);
	}

	/**
	 * 리미티드 초이스 파일 정보를 수정한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return List<EmfMap> 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void updateLimitedChoiFileInfo(EmfMap emfMap) {
		update("CNALimitedChoiceDAO.updateLimitedChoiFileInfo", emfMap);
	}

	public EmfMap selectLimitedChoiFileOne(EmfMap emfMap) {
		return (EmfMap) selectByPk("CNALimitedChoiceDAO.selectLimitedChoiFileOne", emfMap);
	}

	public void insertLimitedChoiFileOne(EmfMap emfMap) {
		insert("CNALimitedChoiceDAO.insertLimitedChoiFileOne", emfMap);
	}

	/**
	 * 리미티드 초이스 정보를 수정한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return void
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void updateLimitedChoiInfo(EmfMap emfMap) {
		update("CNALimitedChoiceDAO.updateLimitedChoiInfo", emfMap);
	}

	public List<EmfMap> selectLimitedChoiFileOne2(EmfMap emfMap) {
		return list("CNALimitedChoiceDAO.selectLimitedChoiFileOne2", emfMap);
	}

	public void deleteLimitedChoiPopFile(EmfMap emfMap) {
		delete("CNALimitedChoiceDAO.deleteLimitedChoiPopFile", emfMap);
	}

	public void deleteLimitedChoiList(EmfMap emfMap) {
		delete("CNALimitedChoiceDAO.deleteLimitedChoiList", emfMap);
	}

	public void deleteLimitedChoiFileList(EmfMap emfMap) {
		delete("CNALimitedChoiceDAO.deleteLimitedChoiFileList", emfMap);
	}

	public EmfMap selectFileInfoByFileSeq(EmfMap emfMap) {
		return (EmfMap) selectByPk("CNALimitedChoiceDAO.selectFileInfoByFileSeq", emfMap);
	}
	public void deleteLimitedChoiFileBySeq(EmfMap emfMap) {
		delete("CNALimitedChoiceDAO.deleteLimitedChoiFileBySeq", emfMap);
	}

	public void updateLimitedChoiInfoN(EmfMap emfMap) {
		update("CNALimitedChoiceDAO.updateLimitedChoiInfoN", emfMap);
	}
}