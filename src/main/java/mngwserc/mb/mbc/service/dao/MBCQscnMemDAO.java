package mngwserc.mb.mbc.service.dao;

import java.util.List;  

import org.springframework.stereotype.Repository;


import emf.core.extend.dao.EmfAbstractDAO;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 휴면계정 관리를 위한 DAO
 * </pre>
 * 
 * @ClassName		: MBCQscnMemDAO.java
 * @Description		: 휴면계정 관리를 위한 DAO
 * @author 허진영
 * @since 2016.02.22
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author				  description
 *   ===========    ==============    =============================
 *    2016.02.22		허진영				    최초생성
 * </pre>
 */
@Repository("mBCQscnMemDAO")
public class MBCQscnMemDAO extends EmfAbstractDAO {

	/**
	 * 휴면계정 목록을 조회한다.
	 *
	 * @param emfMap
	 * @return
	 * @throws Exception
	 */
	public List<EmfMap> selectDrotMemList(EmfMap emfMap) throws Exception {
		return list("MBCQscnMemDAO.selectQscnMemList", emfMap);
	}

	/**
	 * 휴면계정 상세를 조회한다.
	 *
	 * @param emfMap
	 * @return
	 * @throws Exception
	 */
	public EmfMap selectQscnMem(EmfMap emfMap) throws Exception {
		return (EmfMap) selectByPk("MBCQscnMemDAO.selectQscnMem", emfMap);
	}

	/**
	 * 휴면상태를 해제한다.
	 *
	 * @param emfMap
	 * @throws Exception
	 */
	@Deprecated
	public void updateQscnYn(EmfMap emfMap) throws Exception {
		update("MBCQscnMemDAO.updateQscnYn", emfMap);
	}	

	/**
	 * 휴면계정 목록을 조회한다. (엑셀다운로드)
	 *
	 * @param emfMap
	 * @return
	 * @throws Exception
	 */
	public List<EmfMap> excelQscnMemList(EmfMap emfMap) throws Exception {
		return list("MBCQscnMemDAO.excelQscnMemList", emfMap);
	}

	/**
	 * 휴먼회원으로 전환한다.
	 *
	 * @param emfMap
	 * @throws Exception
	 */
	public void qscnChange(EmfMap emfMap) throws Exception {
		update("MBCQscnMemDAO.qscnChange", emfMap);
	}

	/**
	 * 휴먼회원 전환 후 회원 마스터 테이블에서 삭제 처리.
	 *
	 * @param emfMap
	 * @throws Exception
	 */
	public void deleteQscnChange(EmfMap emfMap) throws Exception {
		delete("MBCQscnMemDAO.deleteQscnChange", emfMap);
	}

	/**
	 * 휴먼회원 활성회원으로 전환.
	 *
	 * @param emfMap
	 * @throws Exception
	 */
	public void qscnMemChange(EmfMap emfMap) throws Exception {
		update("MBCQscnMemDAO.qscnMemChange", emfMap);
	}

	/**
	 * 활성회원 전환 후 휴먼회원 테이블에서 삭제 처리.
	 *
	 * @param emfMap
	 * @throws Exception
	 */
	public void deleteQscnMemChange(EmfMap emfMap) throws Exception {
		delete("MBCQscnMemDAO.deleteQscnMemChange", emfMap);
	}
}