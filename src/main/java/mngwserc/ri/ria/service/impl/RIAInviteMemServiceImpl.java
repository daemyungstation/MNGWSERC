package mngwserc.ri.ria.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import mngwserc.co.util.COPaginationUtil;
import mngwserc.ri.ria.service.RIAInviteMemService;
import mngwserc.ri.ria.service.dao.RIAInviteMemDAO;

import org.springframework.stereotype.Service;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import emf.core.extend.service.EmfAbstractService;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 유치회원 위한 ServiceImpl
 * </pre>
 * 
 * @ClassName		: RIAInviteMemServiceImpl.java
 * @Description		: 유치회원관리를 위한 ServiceImpl
 * @author 김필기
 * @since 2016.04.08
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2016.04.08		김필기					 최초생성
 * </pre>
 */ 
@Service("rIAInviteMemService")
public class RIAInviteMemServiceImpl extends EmfAbstractService implements RIAInviteMemService {
	
	@Resource(name="rIAInviteMemDAO")
	private RIAInviteMemDAO rIAInviteMemDAO;
	
	/**
     * 유치회원관리를 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectInviteMemList(EmfMap emfMap) throws Exception
    {
    	PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
    	
		emfMap.put("paginationInfo", paginationInfo);    	
				
		if ("".equals(emfMap.getString("strtDt")) || "".equals(emfMap.getString("endDt"))) {
			Calendar beforeOneMonth = Calendar.getInstance();
			beforeOneMonth.add(Calendar.MONTH, -1);
			emfMap.put("strtDt", new SimpleDateFormat("yyyy-MM-dd").format(beforeOneMonth.getTime()));
			emfMap.put("endDt", new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()));
		} else {
			/*	월별 검색에서 일별 검색으로 변경되면서 01로 맞춰주는 로직 주석처리 2018-10-01
			emfMap.put("strtDt", emfMap.getString("strtDt") + "-01");
			emfMap.put("endDt", emfMap.getString("endDt") + "-01");
			*/
		}
		
		if("".equals(emfMap.getString("dateGb")))
		{
			emfMap.put("dateGb", 1);
		}
		
		List<EmfMap> list = rIAInviteMemDAO.selectInviteMemList(emfMap);
		
		emfMap.put("list", list);
		
		if(list.size() > 0)
		{
			EmfMap cntMap = rIAInviteMemDAO.selectInviteMemListCnt(emfMap);
			
			String totCnt = cntMap.getString("totCnt");
			
			paginationInfo.setTotalRecordCount(Integer.parseInt(totCnt));
			
			emfMap.put("totCnt", totCnt);
		}
		else
		{
			paginationInfo.setTotalRecordCount(0);
		}
		
		return emfMap;
    }

    /**
     * 로그인 ID로 사원번호를 조회한다.
     * 
     * @param String
	 * @return String
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@Override
	public String selectEmplenoById(String id) throws Exception {
		String strEmplNO = "";
		EmfMap emfMap = new EmfMap();
		emfMap.put("grpEmpleNo", id);
		List<EmfMap> list = rIAInviteMemDAO.selectEmplenoById(emfMap);
				
				
		if (list.size() > 0) {
			strEmplNO = list.get(0).getString("empleNo");
		}
		
		return strEmplNO;
	}
}