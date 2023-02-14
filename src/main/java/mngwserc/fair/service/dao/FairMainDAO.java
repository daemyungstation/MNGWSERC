package mngwserc.fair.service.dao;

import java.util.List;

import emf.core.extend.dao.EmfAbstractDAO;
import emf.core.vo.EmfMap;

import org.springframework.stereotype.Repository;


@Repository("fairMainDAO")
public class FairMainDAO extends EmfAbstractDAO {
	
	/**
     * 조회
     * 
     * @param
	 * @return List<EmfMap>
	 * @throws Exception
     */
	public List<EmfMap> select() throws Exception {
		return list("FairMainDAO.select", null);
	}
	
	/**
     * 입력
     * 
     * @param EmfMap
	 * @return List<EmfMap>
	 * @throws Exception
     */
	public void insert(EmfMap emfMap) throws Exception {
		insert("FairMainDAO.insert", emfMap);
	}

	/**
     * 수정
     * 
     * @param EmfMap
	 * @return List<EmfMap>
	 * @throws Exception
     */
	public void update(EmfMap emfMap) throws Exception {
		update("FairMainDAO.update", emfMap);
	}
	
	/**
     * 서브 목록 조회
     * 
     * @param
	 * @return List<EmfMap>
	 * @throws Exception
     */
	public List<EmfMap> selectSubList(EmfMap emfMap) throws Exception {
		return list("FairMainDAO.selectSubList", emfMap);
	}
	
	/**
     * 서브 상세 조회
     * 
     * @param
	 * @return List<EmfMap>
	 * @throws Exception
     */
	public List<EmfMap> selectSub(EmfMap emfMap) throws Exception {
		return list("FairMainDAO.selectSub", emfMap);
	}
	
	/**
     * MAX ORDER 조회
     * 
     * @param
	 * @return List<EmfMap>
	 * @throws Exception
     */
	public List<EmfMap> selectSubMaxOrder() throws Exception {
		return list("FairMainDAO.selectSubMaxOrder", null);
	}
	
	/**
     * 서브 입력
     * 
     * @param EmfMap
	 * @return List<EmfMap>
	 * @throws Exception
     */
	public void subInsert(EmfMap emfMap) throws Exception {
		insert("FairMainDAO.subInsert", emfMap);
	}

	/**
     * 서브 수정
     * 
     * @param EmfMap
	 * @return List<EmfMap>
	 * @throws Exception
     */
	public void subUpdate(EmfMap emfMap) throws Exception {
		update("FairMainDAO.subUpdate", emfMap);
	}
	
	/**
     * 서브 순서변경
     * 
     * @param EmfMap
	 * @return Void
	 * @throws Exception
     */
    public void subOrder(EmfMap emfMap) throws Exception 
    {
    	update("FairMainDAO.subOrder", emfMap);	
    }
    
    /**
     * 서브 삭제
     * 
     * @param EmfMap
	 * @return Void
	 * @throws Exception
     */
    public void subDelete(EmfMap emfMap) throws Exception 
    {
    	delete("FairMainDAO.subDelete", emfMap);
    }
}