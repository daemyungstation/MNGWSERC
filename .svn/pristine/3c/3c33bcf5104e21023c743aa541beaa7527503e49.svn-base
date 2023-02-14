package mngwserc.ri.rib.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import mngwserc.co.util.COPaginationUtil;
import mngwserc.ri.rib.service.RIBBenefitService;
import mngwserc.ri.rib.service.dao.RIBBenefitDAO;

import org.springframework.stereotype.Service;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import emf.core.extend.service.EmfAbstractService;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 수당내역 위한 ServiceImpl
 * </pre>
 * 
 * @ClassName		: RIBBenefitServiceImpl.java
 * @Description		: 수당내역 위한 ServiceImpl
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
@Service("rIBBenefitService")
public class RIBBenefitServiceImpl extends EmfAbstractService implements RIBBenefitService {
	
	@Resource(name="rIBBenefitDAO")
	private RIBBenefitDAO rIBBenefitDAO;
	
	/**
     * 수당내역 목록(년도별)을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectYearBenefitList(EmfMap emfMap) throws Exception
    {
    	if ("".equals(emfMap.getString("year")))
    	{
    		Calendar aCalendar = Calendar.getInstance();
            
    		emfMap.put("year", String.valueOf(aCalendar.get(Calendar.YEAR)));
    	}

		List<EmfMap> list = rIBBenefitDAO.selectYearBenefitList(emfMap);
		
		emfMap.put("list", list);

		return emfMap;
    }	
    
	/**
     * 수당내역 상세정보(년도별)를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectYearBenefitInf(EmfMap emfMap) throws Exception
    {
    	PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
		
    	emfMap.put("paginationInfo", paginationInfo);    	

		if ("".equals(emfMap.getString("year")))
		{
			Calendar aCalendar = Calendar.getInstance();
			
			emfMap.put("year", aCalendar.get(Calendar.YEAR));		
		}
		
		if ("".equals(emfMap.getString("month")))
		{
			throw new Exception("EmptyMonth");
		}
			
		if (emfMap.getString("month").length() < 2)
		{
			emfMap.put("month", "0" + emfMap.getString("month"));
		}
		
		emfMap.put("alowDt", emfMap.getString("year") + emfMap.getString("month"));
		
		List<EmfMap> list = rIBBenefitDAO.selectBenefitList(emfMap);
		
		emfMap.put("list", list);
		
		if (list.size() > 0)
		{
			EmfMap cntMap = rIBBenefitDAO.selectBenefitListCnt(emfMap);
			
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
     * 수당내역 상세정보(년도별)를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectYearBenefitInf2(EmfMap emfMap) throws Exception
    {
		if ("".equals(emfMap.getString("year")))
		{
			Calendar aCalendar = Calendar.getInstance();
			
			emfMap.put("year", aCalendar.get(Calendar.YEAR));		
		}
		
		if ("".equals(emfMap.getString("month")))
		{
			throw new Exception("EmptyMonth");
		}
			
		if (emfMap.getString("month").length() < 2)
		{
			emfMap.put("month", "0" + emfMap.getString("month"));
		}
		
		emfMap.put("alowDt", emfMap.getString("year") + emfMap.getString("month"));
		
		List<EmfMap> list = rIBBenefitDAO.selectYearBenefitList(emfMap);
		
		emfMap.put("list", list);
		
		return emfMap;
    }	        
    
	/**
     * 수당내역 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectBenefitList(EmfMap emfMap) throws Exception
    {
    	PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
    	
		emfMap.put("paginationInfo", paginationInfo);    	

		if ("".equals(emfMap.getString("strtDt")) || "".equals(emfMap.getString("endDt")))
		{
			emfMap.put("strtDt", new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()));
			emfMap.put("endDt", new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()));			
		}
		
		List<EmfMap> list = rIBBenefitDAO.selectBenefitList(emfMap);
		
		emfMap.put("list", list);
		
		if(list.size() > 0)
		{
			EmfMap cntMap = rIBBenefitDAO.selectBenefitListCnt(emfMap);
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
}
