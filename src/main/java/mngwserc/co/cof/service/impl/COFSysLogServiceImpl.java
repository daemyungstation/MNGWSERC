package mngwserc.co.cof.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import mngwserc.co.cof.service.COFSysLogService;
import mngwserc.co.cof.service.dao.COFSysLogDAO;
import mngwserc.co.util.COPaginationUtil;

import org.springframework.stereotype.Service;

import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import emf.core.extend.service.EmfAbstractService;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 로그관리(시스템)를 위한 ServiceImpl
 * </pre>
 * 
 * @ClassName		: COFSysLogServiceImpl.java
 * @Description		: 로그관리(시스템)를 위한 ServiceImpl
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
@Service("cOFSysLogService")
public class COFSysLogServiceImpl extends EmfAbstractService implements COFSysLogService 
{
	@Resource(name="cOFSysLogDAO")
	private COFSysLogDAO cOFSysLogDAO;	
	
	@Resource(name="EgovCmmUseService")
    private EgovCmmUseService cmmUseService;
	
	@Resource(name="egovSysLogIdGnrService")
	private EgovIdGnrService egovSysLogIdGnrService;

	/**
	 * 시스템 로그정보를 생성한다.
	 * 
	 * @param EmfMap
	 */
	public void logInsertSysLog(EmfMap emfMap) throws Exception 
	{
		try
		{
			emfMap.put("logId", egovSysLogIdGnrService.getNextStringId());
			
			cOFSysLogDAO.logInsertSysLog(emfMap);
		}
		catch(Exception e)
		{
			log.debug(e.getMessage());
		}
	}

	/**
	 * 시스템 로그 목록을 조회한다.
	 * 
	 * @param EmfMap
	 */
	public EmfMap logSelectSysLogList(EmfMap emfMap) throws Exception 
	{
		PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);

		//페이징 처리
		emfMap.put("paginationInfo", paginationInfo);    	
		
		//리스트 가져오기
		List<EmfMap> list = cOFSysLogDAO.logSelectSysLogList(emfMap);
				
		emfMap.put("list", list);
		
		if(list.size() > 0)
		{
			paginationInfo.setTotalRecordCount(Integer.parseInt(list.get(0).getString("totCnt")));
		}
		else
		{
			paginationInfo.setTotalRecordCount(0);
		}

		//공통코드 배열 셋팅
		ArrayList<String> cdDtlList = new ArrayList<String>();
		
		//커뮤니티 TYPE
		cdDtlList.add("SYSTEM_LOG");
		
		//정의된 코드id값들의 상세 코드 맵 반환		
		emfMap.put("cdDtlList", cmmUseService.selectCmmCodeBindAll(cdDtlList));
		
		return emfMap;
	}
	
	/**
	 * 시스템 로그 목록을 엑셀다운로드한다.
	 * 
	 * @param EmfMap
	 */
	public List<EmfMap> logExcelSysLogList(EmfMap emfMap) throws Exception
	{
		return cOFSysLogDAO.logExcelSysLogList(emfMap);
	}
}
