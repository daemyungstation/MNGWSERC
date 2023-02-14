package mngwserc.co.cof.service;

import java.util.List;

import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 로그관리(시스템)를 위한 Service
 * </pre>
 * 
 * @ClassName		: COFSysLogService.java
 * @Description		: 로그관리(시스템)를 위한 Service
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
public interface COFSysLogService {

	/**
	 * 시스템 로그정보를 생성한다.
	 * 
	 * @param EmfMap
	 */
	public void logInsertSysLog(EmfMap emfMap) throws Exception;

	/**
	 * 시스템 로그 목록을 조회한다.
	 * 
	 * @param EmfMap
	 */
	public EmfMap logSelectSysLogList(EmfMap emfMap) throws Exception;
	
	/**
	 * 시스템 로그 목록을 엑셀다운로드한다.
	 * 
	 * @param EmfMap
	 */
	public List<EmfMap> logExcelSysLogList(EmfMap emfMap) throws Exception;
}
