package mngwserc.fair.service.dao;

import java.util.List;

import emf.core.extend.dao.EmfAbstractDAO;
import emf.core.vo.EmfMap;

import org.springframework.stereotype.Repository;


@Repository("fairUserDAO")
public class FairUserDAO extends EmfAbstractDAO {
	
	/**
     * 목록 조회
     * 
     * @param
	 * @return List<EmfMap>
	 * @throws Exception
     */
	public List<EmfMap> selectList(EmfMap emfMap) throws Exception {
		return list("FairUserDAO.selectList", emfMap);
	}
	
	/**
     * 목록 조회
     * 
     * @param
	 * @return List<EmfMap>
	 * @throws Exception
     */
	public List<EmfMap> selectListExcel(EmfMap emfMap) throws Exception {
		return list("FairUserDAO.selectListExcel", emfMap);
	}
	
	/**
     * 카테고리 조회
     * 
     * @param
	 * @return List<EmfMap>
	 * @throws Exception
     */
	public List<EmfMap> selectCateList(EmfMap emfMap) throws Exception {
		return list("FairUserDAO.selectCateList", emfMap);
	}
	
	/**
     * 상세 조회
     * 
     * @param
	 * @return List<EmfMap>
	 * @throws Exception
     */
	public List<EmfMap> select(EmfMap emfMap) throws Exception {
		return list("FairUserDAO.select", emfMap);
	}
	
	/**
     * 상세 조회
     * 
     * @param
	 * @return List<EmfMap>
	 * @throws Exception
     */
	public List<EmfMap> selectMemo(EmfMap emfMap) throws Exception {
		return list("FairUserDAO.selectMemo", emfMap);
	}
	
	/**
     * 입력
     * 
     * @param EmfMap
	 * @return List<EmfMap>
	 * @throws Exception
     */
	public void deleteMemo(EmfMap emfMap) throws Exception {
		insert("FairUserDAO.deleteMemo", emfMap);
	}

	/**
     * 입력
     * 
     * @param EmfMap
	 * @return List<EmfMap>
	 * @throws Exception
     */
	public void insertMemo(EmfMap emfMap) throws Exception {
		insert("FairUserDAO.insertMemo", emfMap);
	}

	/**
     * 수정
     * 
     * @param EmfMap
	 * @return List<EmfMap>
	 * @throws Exception
     */
	public void update(EmfMap emfMap) throws Exception {
		update("FairUserDAO.update", emfMap);
	}
    
    /**
     * 삭제
     * 
     * @param EmfMap
	 * @return Void
	 * @throws Exception
     */
    public void delete(EmfMap emfMap) throws Exception 
    {
    	delete("FairUserDAO.deleteFK", emfMap);
    	delete("FairUserDAO.delete", emfMap);
    }
    
    /**
     * 삭제
     * 
     * @param EmfMap
	 * @return Void
	 * @throws Exception
     */
    public void statusChange(EmfMap emfMap) throws Exception 
    {
    	delete("FairUserDAO.statusChange", emfMap);
    }
    
    /**
     * 콜센터 목록 조회
     * 
     * @param
	 * @return List<EmfMap>
	 * @throws Exception
     */
	public List<EmfMap> selectListCall(EmfMap emfMap) throws Exception {
		return list("FairUserDAO.selectListCall", emfMap);
	}
	
	/**
     * 목록 조회
     * 
     * @param
	 * @return List<EmfMap>
	 * @throws Exception
     */
	public List<EmfMap> selectListExcelCall(EmfMap emfMap) throws Exception {
		return list("FairUserDAO.selectListExcelCall", emfMap);
	}
}