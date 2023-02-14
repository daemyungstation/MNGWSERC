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
 * @ClassName		: CNAZeroChoiceDAO.java
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
@Repository("cNADirectChoiceDAO")
public class CNADirectChoiceDAO extends EmfAbstractDAO {

	/**
	 * 다이렉트 초이스 목록을 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return List<EmfMap> 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectDirectChoiList(EmfMap emfMap) throws Exception{
		return list("CNADirectChoiceDAO.selectDirectChoiList", emfMap);
	}

	/**
	 * 다이렉트 초이스 정보를 등록한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return List<EmfMap> 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void insertDirectChoiseInfo(EmfMap emfMap) throws Exception {
		insert("CNADirectChoiceDAO.insertDirectChoiseInfo", emfMap);
		
	}

	/**
	 * 다이렉트 초이스 파일 정보를 저장한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return List<EmfMap> 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void insertDirectChoiseFile(EmfMap emfMap) throws Exception {
		insert("CNADirectChoiceDAO.insertDirectChoiseFile", emfMap);
	}

	/**
	 * 다이렉트 초이스 정보를 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return EmfMap 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public EmfMap selectDirectChoice(EmfMap emfMap) {
		return (EmfMap) selectByPk("CNADirectChoiceDAO.selectDirectChoice", emfMap);
	}

	/**
	 * 다이렉트 초이스 파일 정보를 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return List<EmfMap> 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectDirectChoiceFileInfo(EmfMap emfMap) {
		return list("CNADirectChoiceDAO.selectDirectChoiceFileInfo", emfMap);
	}

	/**
	 * 다이렉트 초이스 파일 정보를 수정한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return List<EmfMap> 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void updateDirectChoiFileInfo(EmfMap emfMap) {
		update("CNADirectChoiceDAO.updateDirectChoiFileInfo", emfMap);
	}

	public EmfMap selectDirectChoiFileOne(EmfMap emfMap) {
		return (EmfMap) selectByPk("CNADirectChoiceDAO.selectDirectChoiFileOne", emfMap);
	}

	public void insertDirectChoiFileOne(EmfMap emfMap) {
		insert("CNADirectChoiceDAO.insertDirectChoiFileOne", emfMap);
	}

	/**
	 * 다이렉트 초이스 정보를 수정한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return void
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void updateDirectChoiInfo(EmfMap emfMap) {
		update("CNADirectChoiceDAO.updateDirectChoiInfo", emfMap);
	}

	public List<EmfMap> selectDirectChoiFileOne2(EmfMap emfMap) {
		return list("CNADirectChoiceDAO.selectDirectChoiFileOne2", emfMap);
	}

	public void deleteDirectChoiPopFile(EmfMap emfMap) {
		delete("CNADirectChoiceDAO.deleteDirectChoiPopFile", emfMap);
	}

	public void deleteDirectChoiList(EmfMap emfMap) {
		delete("CNADirectChoiceDAO.deleteDirectChoiList", emfMap);
	}

	public void deleteDirectChoiFileList(EmfMap emfMap) {
		delete("CNADirectChoiceDAO.deleteDirectChoiFileList", emfMap);
	}
	
	public void deleteDirectChoiFileBySeq(EmfMap emfMap) {
		delete("CNADirectChoiceDAO.deleteDirectChoiFileBySeq", emfMap);
	}

	public EmfMap selectFileInfoByFileSeq(EmfMap emfMap) {
		return (EmfMap) selectByPk("CNADirectChoiceDAO.selectFileInfoByFileSeq", emfMap);
	}

	public void updateDirectChoiInfoN(EmfMap emfMap) {
		update("CNADirectChoiceDAO.updateDirectChoiInfoN", emfMap);
	}
}
