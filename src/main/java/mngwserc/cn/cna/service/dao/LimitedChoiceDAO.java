package mngwserc.cn.cna.service.dao;

import emf.core.extend.dao.EmfAbstractDAO;
import emf.core.vo.EmfMap;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LimitedChoiceDAO extends EmfAbstractDAO {

    public List<EmfMap> getLimitedChoiceCategoryList() throws Exception {
        return list("LimitedChoiceDAO.getLimitedChoiceCategoryList", null);
    }

    public List<EmfMap> getLimitedChoiceProductList(EmfMap emfMap) throws Exception {
        return list("LimitedChoiceDAO.getLimitedChoiceProductList", emfMap);
    }

    public EmfMap getLimitedChoiceProductInfo(EmfMap emfMap) throws Exception {
        return (EmfMap) selectByPk("LimitedChoiceDAO.getLimitedChoiceProductInfo", emfMap);
    }

    public List<EmfMap> getLimitedChoiceFileInfo(String using, String gubun, EmfMap emfMap) throws Exception {
        emfMap.put("using", using);
        emfMap.put("gubun", gubun);
        return list("LimitedChoiceDAO.getLimitedChoiceFileInfo", emfMap);
    }

    public Integer getZeroChoiseImgContainerCnt(String using, String gubun, EmfMap emfMap) throws Exception {
        emfMap.put("using", using);
        emfMap.put("gubun", gubun);
        return (Integer) selectByPk("LimitedChoiceDAO.getZeroChoiseImgContainerCnt", emfMap);
    }

    public int setLimitedChoiceProduct(EmfMap emfMap) throws Exception {
        insert("LimitedChoiceDAO.setLimitedChoiceProduct", emfMap);
        return (Integer) emfMap.get("seq");
    }

    public void setLimitedChoiceFile(EmfMap emfMap) throws Exception {
        insert("LimitedChoiceDAO.setLimitedChoiceFile", emfMap);
    }

    public EmfMap selectFileInfoByFileSeq(EmfMap emfMap) throws Exception {
        return (EmfMap) selectByPk("LimitedChoiceDAO.selectFileInfoByFileSeq", emfMap);
    }

    public void delLimitedChoiceProduct(EmfMap emfMap) throws Exception {
        delete("LimitedChoiceDAO.deleteLimitedChoiceProduct", emfMap);
    }

    public void delLimitedChoiceFile(EmfMap emfMap) throws Exception {
        delete("LimitedChoiceDAO.deleteLimitedChoiceFile", emfMap);
    }

    public void modifyLimitedChoiceProduct(EmfMap emfMap) throws Exception {
        update("LimitedChoiceDAO.modifyLimitedChoiceProduct", emfMap);
    }

    public void mergeLimitedChoiceFile(EmfMap emfMap) throws Exception {
        insert("LimitedChoiceDAO.mergeLimitedChoiceFile", emfMap);
    }

    public void deleteLimitedChoiceFileByUpdate(EmfMap emfMap) throws Exception {
        delete("LimitedChoiceDAO.deleteLimitedChoiceFileByUpdate", emfMap);
    }

    public int setCategory(EmfMap emfMap) throws Exception {
        insert("LimitedChoiceDAO.setCategory", emfMap);
        return (Integer) emfMap.get("seq");
    }

    public int modCategoryName(EmfMap emfMap) throws Exception {
        return update("LimitedChoiceDAO.modCategoryName", emfMap);
    }

    public int modCategoryOrder(EmfMap emfMap) throws Exception {
        return update("LimitedChoiceDAO.modCategoryOrder", emfMap);
    }

    public int removeCategory(EmfMap emfMap) throws Exception {
        return delete("LimitedChoiceDAO.removeCategory", emfMap);
    }

    public void sortCategory() throws Exception {
        update("LimitedChoiceDAO.sortCategory", null);
    }

    public List<EmfMap> getLimitedChoiceImageList(EmfMap emfMap) throws Exception {
        return list("LimitedChoiceDAO.getLimitedChoiceImageList", emfMap);
    }

    public EmfMap getLimitedChoiceImageInfo(EmfMap emfMap) throws Exception {
        return (EmfMap) selectByPk("LimitedChoiceDAO.getLimitedChoiceImageInfo", emfMap);
    }

    public void modifyLimitedChoiceImage(EmfMap emfMap) throws Exception {
        update("LimitedChoiceDAO.modifyLimitedChoiceImage", emfMap);
    }

    public List<EmfMap> getLimitedChoiceImageFile(EmfMap emfMap) throws Exception {
        return list("LimitedChoiceDAO.getLimitedChoiceImageFile", emfMap);
    }

    public int setLimitedChoiceImage(EmfMap emfMap) throws Exception {
        insert("LimitedChoiceDAO.setLimitedChoiceImage", emfMap);
        return (Integer) emfMap.get("seq");
    }
    public void delLimitedChoiceImage(EmfMap emfMap) throws Exception {
        delete("LimitedChoiceDAO.deleteLimitedChoiceImage", emfMap);
    }

}
