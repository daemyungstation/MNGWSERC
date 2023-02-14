package mngwserc.co.cof.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import emf.core.extend.dao.EmfAbstractDAO;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 로그관리(시스템)를 위한 DAO
 * </pre>
 * 
 * @ClassName		: COFSysLogDAO.java
 * @Description		: 로그관리(시스템)를 위한 DAO
 * @author 김대환
 * @since 2015.11.19
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author			 description
 *   ===========    ==============    =================
 *    2015.11.19		김대환			  최초생성
 * </pre>
 */
@Repository("cOFSysLogDAO")
public class COFSysLogDAO extends EmfAbstractDAO {

	/**
	 * 시스템 로그정보를 생성한다.
	 * 
	 * @param SysLog
	 * @return
	 * @throws Exception 
	 */
	public void logInsertSysLog(EmfMap emfMap) throws Exception
	{
		insert("COFSysLogDAO.logInsertSysLog", emfMap);
	}

	/**
	 * 시스템 로그정보 목록을 조회한다.
	 * 
	 * @param sysLog
	 * @return
	 * @throws Exception 
	 */
	public List<EmfMap> logSelectSysLogList(EmfMap emfMap) throws Exception
	{
		return list("COFSysLogDAO.logSelectSysLogList", emfMap);
	}
	
	/**
	 * 시스템 로그 목록을 엑셀다운로드한다.
	 * 
	 * @param sysLog
	 * @return
	 * @throws Exception 
	 */
	public List<EmfMap> logExcelSysLogList(EmfMap emfMap) throws Exception
	{
		return list("COFSysLogDAO.logExcelSysLogList", emfMap);
	}
}
