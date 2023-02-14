package mngwserc.co.log.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import emf.core.extend.dao.EmfAbstractDAO;
import emf.core.vo.EmfMap;

@Repository("lOGAdmLogMngDAO")
public class LOGAdmLogMngDAO extends EmfAbstractDAO {

    /**
	 * 로그관리 목록을 가져온다.
	 * @param EmfMap
	 * @return EmfMap
	 * @exception 지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@SuppressWarnings("unchecked")
	public List<EmfMap> selectLogAdmList(EmfMap emfMap) throws Exception {
		return list("LOGAdmLogMngDAO.selectLogAdmList", emfMap);
	}

    /**
	 * 로그관리 목록을 가져온다. (엑셀다운로드) 
	 * @param EmfMap
	 * @return EmfMap
	 * @exception 지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@SuppressWarnings("unchecked")
	public List<EmfMap> excelLogAdmList(EmfMap emfMap) {
		return list("LOGAdmLogMngDAO.excelLogAdmList", emfMap);
	}

}
