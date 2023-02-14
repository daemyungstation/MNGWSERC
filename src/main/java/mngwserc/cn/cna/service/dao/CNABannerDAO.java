package mngwserc.cn.cna.service.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import emf.core.extend.dao.EmfAbstractDAO;
import emf.core.vo.EmfMap;

@Repository("cNABannerDAO")
public class CNABannerDAO extends EmfAbstractDAO {

	
	
	public List<EmfMap> selectBannerList(EmfMap emfMap) throws Exception {
		return list("CNABannerDAO.selectBannerList", emfMap);
	}

	public EmfMap selectBanner(EmfMap emfMap) throws Exception {
		return (EmfMap) selectByPk("CNABannerDAO.selectBanner", emfMap);
	}

	public List<EmfMap> selectBannerDtlList(EmfMap emfMap) throws Exception {
		return list("CNABannerDAO.selectBannerDtlList", emfMap);
	}

	public void updateBannerMng(EmfMap emfMap) throws Exception {
		update("CNABannerDAO.updateBannerMng", emfMap);
	}

	public void insertBannerDtl(EmfMap emfMap) throws Exception {
		update("CNABannerDAO.insertBannerDtl", emfMap);
	}

	public List<EmfMap> selectBannerExcelList(EmfMap emfMap) throws Exception {
		return list("CNABannerDAO.selectBannerExcelList", emfMap);
	}

	public EmfMap getBannerPreviewImgPath(EmfMap emfMap) throws Exception {
		return (EmfMap) selectByPk("CNABannerDAO.getBannerPreviewImgPath", emfMap);
	}

	public void insertBannerMgr(EmfMap emfMap) throws Exception {
		insert("CNABannerDAO.insertBannerMgr", emfMap);
	}

	public void insertBannerFile(EmfMap emfMap) throws Exception {
		insert("CNABannerDAO.insertBannerFile", emfMap);
	}

	public void updateBannerMgr(EmfMap emfMap) throws Exception {
		update("CNABannerDAO.updateBannerMgr", emfMap);
	}

	public void updateBannerFile(EmfMap emfMap) throws Exception {
		update("CNABannerDAO.updateBannerFile", emfMap);
	}

	public void deleteBannerMst(EmfMap emfMap) throws Exception{
		delete("CNABannerDAO.deleteBannerMst", emfMap);
	}

	public void deleteBannerImg(EmfMap emfMap) throws Exception{
		delete("CNABannerDAO.deleteBannerImg", emfMap);
	}

	public void updateBannerUrl(EmfMap emfMap) throws Exception{
		update("CNABannerDAO.updateBannerUrl", emfMap);
	}

}
