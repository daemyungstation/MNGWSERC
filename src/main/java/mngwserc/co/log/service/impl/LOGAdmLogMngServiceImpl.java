package mngwserc.co.log.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import mngwserc.co.log.service.LOGAdmLogMngService;
import mngwserc.co.log.service.dao.LOGAdmLogMngDAO;
import mngwserc.co.util.COPaginationUtil;

import org.springframework.stereotype.Service;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import emf.core.extend.service.EmfAbstractService;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 로그 Service 구현
 * </pre>
 * 
 * @ClassName		: COBLgnDAO.java
 * @Description		: 로그인 DAO 구현
 * @author 강재석
 * @since 2018.01.03
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2018.01.03		강재석					최초생성
 * </pre>
 */
@Service("lOGAdmLogMngService")
public class LOGAdmLogMngServiceImpl extends EmfAbstractService implements LOGAdmLogMngService {

	@Resource(name="lOGAdmLogMngDAO")
	private LOGAdmLogMngDAO lOGAdmLogMngDAO;
	
    /**
	 * 로그 정보 목록을 조회 한다.
	 * 
	 * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public EmfMap selectLogAdmList(EmfMap emfMap) throws Exception {
		PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
		
		//페이징 처리
		emfMap.put("paginationInfo", paginationInfo);    
				
		//리스트 가져오기
		List<EmfMap> list;
		if (emfMap.get("pageGubun") == null) // 페이지 처음 진입시 리스트 노출하지 않는다. 검색 눌렀을때 나오는 기본 input값중 하나(pageGubun)로 비교
		{
			list = new ArrayList();
		}
		else
		{
			list = lOGAdmLogMngDAO.selectLogAdmList(emfMap);
		}
		
		emfMap.put("list", list);
		
		if(list.size() > 0)
		{
			paginationInfo.setTotalRecordCount(Integer.parseInt(list.get(0).getString("totCnt")));
		}
		else
		{
			paginationInfo.setTotalRecordCount(0);
		}
		return emfMap;
	}

    /**
	 * 로그 정보 목록을 조회 한다. (엑셀다운로드)
	 * 
	 * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> excelLogAdmList(EmfMap emfMap) throws Exception {
		//리스트 가져오기
		List<EmfMap> list = lOGAdmLogMngDAO.excelLogAdmList(emfMap);
		return list;
	}

}
