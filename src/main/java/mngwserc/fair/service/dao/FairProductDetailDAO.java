package mngwserc.fair.service.dao;

import java.util.List;

import emf.core.extend.dao.EmfAbstractDAO;
import emf.core.vo.EmfMap;

import org.springframework.stereotype.Repository;


@Repository("fairProductDetailDAO")
public class FairProductDetailDAO extends EmfAbstractDAO {
	
	/**
     * 목록 조회
     * 
     * @param
	 * @return List<EmfMap>
	 * @throws Exception
     */
	public List<EmfMap> selectList(EmfMap emfMap) throws Exception {
		return list("FairProductDetailDAO.selectList", emfMap);
	}
	
	/**
     * 상세 조회
     * 
     * @param
	 * @return List<EmfMap>
	 * @throws Exception
     */
	public List<EmfMap> select(EmfMap emfMap) throws Exception {
		return list("FairProductDetailDAO.select", emfMap);
	}
	
	/**
     * MAX ORDER 조회
     * 
     * @param
	 * @return List<EmfMap>
	 * @throws Exception
     */
	public List<EmfMap> selectMaxOrder() throws Exception {
		return list("FairProductDetailDAO.selectMaxOrder", null);
	}
	
	/**
     * 입력
     * 
     * @param EmfMap
	 * @return List<EmfMap>
	 * @throws Exception
     */
	public void insert(EmfMap emfMap) throws Exception {
		insert("FairProductDetailDAO.insert", emfMap);
	}

	/**
     * 수정
     * 
     * @param EmfMap
	 * @return List<EmfMap>
	 * @throws Exception
     */
	public void update(EmfMap emfMap) throws Exception {
		update("FairProductDetailDAO.update", emfMap);
	}
	
	/**
     * 순서변경
     * 
     * @param EmfMap
	 * @return Void
	 * @throws Exception
     */
    public void order(EmfMap emfMap) throws Exception 
    {
    	update("FairProductDetailDAO.order", emfMap);	
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
    	delete("FairProductDetailDAO.delete", emfMap);
    }
    
    /**
     * 카테고리 조회
     * 
     * @param
	 * @return List<EmfMap>
	 * @throws Exception
     */
	public List<EmfMap> selectCate() throws Exception {
		return list("FairProductDetailDAO.selectCate", null);
	}
    
    /**
     * 입력폼 조회
     * 
     * @param
	 * @return List<EmfMap>
	 * @throws Exception
     */
	public List<EmfMap> selectInput() throws Exception {
		return list("FairProductDetailDAO.selectInput", null);
	}
    
    /**
     * 결합혜택 조회
     * 
     * @param
	 * @return List<EmfMap>
	 * @throws Exception
     */
	public List<EmfMap> selectBenefit() throws Exception {
		return list("FairProductDetailDAO.selectBenefit", null);
	}
}