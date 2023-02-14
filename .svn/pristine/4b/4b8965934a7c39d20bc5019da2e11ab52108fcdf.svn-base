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
@Repository("cNAZeroChoiceDAO")
public class CNAZeroChoiceDAO extends EmfAbstractDAO {

	/**
	 * 제로초이스 카테고리관리 리스트를 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return List<EmfMap> 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> getZeroChoiCateList(EmfMap emfMap)  throws Exception {
		return list("CNAZeroChoiceDAO.getZeroChoiCateList", emfMap);
	}

	/**
	 * 제로초이스 카테고리관리 리스트를 등록한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return List<EmfMap> 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void insertCateMenu(EmfMap emfMap) throws Exception {
		insert("CNAZeroChoiceDAO.insertCateMenu", emfMap);
	}

	/**
	 * 제로초이스 카테고리관리 리스트를 등록한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return List<EmfMap> 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public int updateCateMenuNm(EmfMap emfMap) {
		return update("CNAZeroChoiceDAO.updateCateMenuNm", emfMap);
	}

	/**
	 * 제로초이스 카테고리관리 리스트를 등록한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return List<EmfMap> 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public int deleteCateMenu(EmfMap emfMap) {
		return delete("CNAZeroChoiceDAO.deleteCateMenu", emfMap);
	}

	/**
	 * 제로초이스 카테고리관리 리스트를 등록한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return List<EmfMap> 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void updateCateMenuPstn(EmfMap emfMap) {
		update("CNAZeroChoiceDAO.updateCateMenuPstn", emfMap);
	}

	/**
	 * 제로초이스 상품관리 리스트를 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return List<EmfMap> 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectZeroChoiPrdMgrList(EmfMap emfMap) {
		return list("CNAZeroChoiceDAO.selectZeroChoiPrdMgrList", emfMap);
	}

	/**
	 * 제로초이스 이미지 관리 리스트를 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return List<EmfMap> 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectZeroChoiImgMgrList(EmfMap emfMap) {
		return list("CNAZeroChoiceDAO.selectZeroChoiImgMgrList", emfMap);
	}

    /**
     * 제로초이스 상품관리 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public EmfMap selectZeroChoisePrdMgr(EmfMap emfMap) {
		return (EmfMap) selectByPk("CNAZeroChoiceDAO.selectZeroChoisePrdMgr", emfMap);
	}
	
    /**
     * 이미지 관리 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public EmfMap selectZeroChoiImgMgr(EmfMap emfMap) {
		return (EmfMap) selectByPk("CNAZeroChoiceDAO.selectZeroChoiImgMgr", emfMap);
	}

    /**
     * 상품관리를 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertZeroChoisePrdMgr(EmfMap emfMap) {
		insert("CNAZeroChoiceDAO.insertZeroChoisePrdMgr", emfMap);
	}

    /**
     * 상품관리를 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateZeroChoisePrdMgr(EmfMap emfMap) {
		update("CNAZeroChoiceDAO.updateZeroChoisePrdMgr", emfMap);
	}

    /**
     * 이미지 파일을 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertZeroChoiseFile(EmfMap emfMap) {
		insert("CNAZeroChoiceDAO.insertZeroChoiseFile", emfMap);
	}
	public void insertZeroChoiseFile2(EmfMap emfMap) {
		insert("CNAZeroChoiceDAO.insertZeroChoiseFile2", emfMap);
	}

	public List<EmfMap> selectZeroChoiseFileInfo(EmfMap emfMap) {
		return list("CNAZeroChoiceDAO.selectZeroChoiseFileInfo", emfMap);
	}

	public EmfMap selectZeroChoiseImgContainerCnt(EmfMap emfMap) {
		return (EmfMap) selectByPk("CNAZeroChoiceDAO.selectZeroChoiseImgContainerCnt", emfMap);
	}

	public EmfMap selectFileInfoByFileSeq(EmfMap emfMap) {
		return (EmfMap) selectByPk("CNAZeroChoiceDAO.selectFileInfoByFileSeq", emfMap);
	}

	public void updateZeroChoiseFile1(EmfMap emfMap) {
		update("CNAZeroChoiceDAO.updateZeroChoiseFile1", emfMap);
	}
	
	public void updateZeroChoiseFile2(EmfMap emfMap) {
		delete("CNAZeroChoiceDAO.updateZeroChoiseFile2", emfMap);
	}
	
	public void updateZeroChoiseFile3(EmfMap emfMap) {
		delete("CNAZeroChoiceDAO.updateZeroChoiseFile3", emfMap);
	}

	public void deleteZeroChoisePrdmgrList(EmfMap emfMap) {
		delete("CNAZeroChoiceDAO.deleteZeroChoisePrdmgrList", emfMap);
	}
	
	public void deleteZeroChoiseImgmgrList(EmfMap emfMap) {
		delete("CNAZeroChoiceDAO.deleteZeroChoiseImgmgrList", emfMap);
	}

	public void deleteZeroChoiseImgList(EmfMap emfMap) {
		delete("CNAZeroChoiceDAO.deleteZeroChoiseImgList", emfMap);
	}

	public void insertZeroChoiseImgMgr(EmfMap emfMap) {
		insert("CNAZeroChoiceDAO.insertZeroChoiseImgMgr", emfMap);
	}

	public void updateZeroChoiseImgMgr(EmfMap emfMap) {
		update("CNAZeroChoiceDAO.updateZeroChoiseImgMgr", emfMap);
	}

	public List<EmfMap> selectZeroChoiseFile(EmfMap emfMap) {
		return list("CNAZeroChoiceDAO.selectZeroChoiseFile", emfMap);
	}

	public void insertZeroChoiseFile1(EmfMap emfMap) {
		insert("CNAZeroChoiceDAO.insertZeroChoiseFile1", emfMap);
	}

	public void updateZeroChoiseImgMgrN(EmfMap emfMap) {
		update("CNAZeroChoiceDAO.updateZeroChoiseImgMgrN", emfMap);
	}

	public void updateCateMenuPstnBefore(EmfMap emfMap) {
		update("CNAZeroChoiceDAO.updateCateMenuPstnBefore", emfMap);
	}

	public void updateCatePstnAfterDelete(EmfMap emfMap) {
		update("CNAZeroChoiceDAO.updateCatePstnAfterDelete", emfMap);
	}

	public EmfMap getPstnByCateSeq(EmfMap emfMap) {
		return (EmfMap) selectByPk("CNAZeroChoiceDAO.getPstnByCateSeq", emfMap);
	}

	public void cateWrite(EmfMap emfMap) {
		insert("CNAZeroChoiceDAO.cateWrite", emfMap);
	}

	public void cateAllDel(EmfMap emfMap) {
		delete("CNAZeroChoiceDAO.cateAllDel", emfMap);
	}

	public List<EmfMap> selectZeroChoiPrdMgrListByCateSeq(EmfMap emfMap) {
		return list("CNAZeroChoiceDAO.selectZeroChoiPrdMgrListByCateSeq", emfMap);
	}

	public void updateCateMove1(EmfMap param) {
		update("CNAZeroChoiceDAO.updateCateMove1", param);
	}

	public void updateCateMove2(EmfMap param) {
		update("CNAZeroChoiceDAO.updateCateMove2", param);
	}
}
