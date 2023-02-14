package mngwserc.fair.service.dao;

import java.util.List;

import emf.core.extend.dao.EmfAbstractDAO;
import emf.core.vo.EmfMap;

import org.springframework.stereotype.Repository;


@Repository("fairProductBenefitDAO")
public class FairProductBenefitDAO extends EmfAbstractDAO {
	
	/**
     * 목록 조회
     * 
     * @param
	 * @return List<EmfMap>
	 * @throws Exception
     */
	public List<EmfMap> selectList(EmfMap emfMap) throws Exception {
		return list("FairProductBenefitDAO.selectList", emfMap);
	}
	
	/**
     * 상세 조회
     * 
     * @param
	 * @return List<EmfMap>
	 * @throws Exception
     */
	public List<EmfMap> select(EmfMap emfMap) throws Exception {
		return list("FairProductBenefitDAO.select", emfMap);
	}
	
	/**
     * MAX ORDER 조회
     * 
     * @param
	 * @return List<EmfMap>
	 * @throws Exception
     */
	public List<EmfMap> selectMaxOrder() throws Exception {
		return list("FairProductBenefitDAO.selectMaxOrder", null);
	}
	
	/**
     * 입력
     * 
     * @param EmfMap
	 * @return List<EmfMap>
	 * @throws Exception
     */
	public void insert(EmfMap emfMap) throws Exception {
		insert("FairProductBenefitDAO.insert", emfMap);
	}

	/**
     * 수정
     * 
     * @param EmfMap
	 * @return List<EmfMap>
	 * @throws Exception
     */
	public void update(EmfMap emfMap) throws Exception {
		update("FairProductBenefitDAO.update", emfMap);
	}
	
	public void updateProduct(EmfMap emfMap) throws Exception {
		update("FairProductBenefitDAO.updateProduct", emfMap);
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
    	update("FairProductBenefitDAO.order", emfMap);	
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
    	delete("FairProductBenefitDAO.delete", emfMap);
    }
}