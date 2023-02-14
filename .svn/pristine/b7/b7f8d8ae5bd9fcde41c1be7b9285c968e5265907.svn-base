package mngwserc.cn.cnc.service.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import emf.core.extend.dao.EmfAbstractDAO;
import emf.core.vo.EmfMap;

@Repository("cNCProdCnclDAO")
public class CNCProdCnclDAO extends EmfAbstractDAO {

	
	
	public List<EmfMap> selectProdCnclList(EmfMap emfMap) throws Exception {
		return list("CNCProdCnclDAO.selectProdCnclList", emfMap);
	}

	public EmfMap selectProdCncl(EmfMap emfMap) {
		return (EmfMap) selectByPk("CNCProdCnclDAO.selectProdCncl", emfMap);
	}

	public List<EmfMap> selectProdCnclDtlList(EmfMap emfMap) {
		return list("CNCProdCnclDAO.selectProdCnclDtlList", emfMap);
	}

	public void updateProdCnclMng(EmfMap emfMap) {
		update("CNCProdCnclDAO.updateProdCnclMng", emfMap);
	}

	public void insertProdCnclDtl(EmfMap emfMap) {
		update("CNCProdCnclDAO.insertProdCnclDtl", emfMap);
	}

	public List<EmfMap> selectProdCnclExcelList(EmfMap emfMap) {
		return list("CNCProdCnclDAO.selectProdCnclExcelList", emfMap);
	}

	public void insertExcelData(EmfMap emfMap) {
		insert("CNCProdCnclDAO.insertExcelData", emfMap);
	}
}
