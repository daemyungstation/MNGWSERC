package mngwserc.om.ome.service.dao;

import emf.core.extend.dao.EmfAbstractOutDAO;
import emf.core.vo.EmfMap;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CuckooDAO extends EmfAbstractOutDAO {
    /**
     * 외주업체 실적관리 목록을 조회한다.
     *
     * @param EmfMap
     * @return List<EmfMap>
     * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public List<EmfMap> selectRecordMngList(EmfMap emfMap) throws Exception
    {
        return list("CuckooDAO.selectRecordMngList", emfMap);
    }

    public EmfMap selectRecordMngListCnt(EmfMap emfMap) throws Exception
    {
        return (EmfMap)selectByPk("CuckooDAO.selectRecordMngListCnt", emfMap);
    }

    /**
     * 외주업체 실적관리 목록을 엑셀 다운로드
     *
     * @param EmfMap
     * @return List<EmfMap>
     * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public List<EmfMap> selectRecordMngExcelList(EmfMap emfMap) throws Exception
    {
        return list("CuckooDAO.selectRecordMngExcelList", emfMap);
    }

}
