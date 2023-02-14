package mngwserc.fair.service.dao;

import java.util.List;

import emf.core.extend.dao.EmfAbstractDAO;
import emf.core.vo.EmfMap;

import org.springframework.stereotype.Repository;


@Repository("fairProductInputDAO")
public class FairProductInputDAO extends EmfAbstractDAO {
	
	/**
     * 목록 조회
     * 
     * @param
	 * @return List<EmfMap>
	 * @throws Exception
     */
	public List<EmfMap> selectList(EmfMap emfMap) throws Exception {
		return list("FairProductInputDAO.selectList", emfMap);
	}
	
	/**
     * 상세 조회
     * 
     * @param
	 * @return List<EmfMap>
	 * @throws Exception
     */
	public List<EmfMap> select(EmfMap emfMap) throws Exception {
		return list("FairProductInputDAO.select", emfMap);
	}
	
	/**
     * 입력
     * 
     * @param EmfMap
	 * @return List<EmfMap>
	 * @throws Exception
     */
	public void insert(EmfMap emfMap) throws Exception {
		insert("FairProductInputDAO.insert", emfMap);
	}

	/**
     * 수정
     * 
     * @param EmfMap
	 * @return List<EmfMap>
	 * @throws Exception
     */
	public void update(EmfMap emfMap) throws Exception {
		update("FairProductInputDAO.update", emfMap);
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
    	delete("FairProductInputDAO.delete", emfMap);
    }
}