package mngwserc.sc.sca.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import emf.core.extend.dao.EmfAbstractDAO;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 휴면계정 관련 스케줄링을 위한 DAO
 * </pre>
 * 
 * @ClassName		: SCAQscnSchdDAO.java
 * @Description		: 휴면계정 관련 스케줄링을 위한 DAO
 * @author 허진영	
 * @since 2016.03.28
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2016.03.28		허진영					최초생성
 * </pre>
 */ 
@Repository("sCAQscnSchdDAO")
public class SCAQscnSchdDAO extends EmfAbstractDAO {

	/**
	 * 1년이상 미로그인 시 휴면계정으로 전환한다.
	 *
	 * @throws Exception
	 */
	@Deprecated
	public void updateQscnMemList() throws Exception {
    	update("SCAQscnSchdDAO.updateQscnMemList", null);
    }

	/**
	 * 휴면계정 전환 1주일전인 회원을 조회한다.
	 *
	 * @return
	 * @throws Exception
	 */
	public List<EmfMap> selectQscnMemList() throws Exception {
    	return list("SCAQscnSchdDAO.selectQscnMemList", null);
    }	
}
