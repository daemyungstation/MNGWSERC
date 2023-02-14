package mngwserc.cm.cma.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import mngwserc.cm.cma.service.DmLifeService;
import mngwserc.cm.cma.service.dao.DmLifeDAO;
import mngwserc.co.util.COPaginationUtil;

import org.springframework.stereotype.Service;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import emf.core.extend.service.EmfAbstractService;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 전산db 조회를 위한 ServiceImpl
 * </pre>
 * 
 * @ClassName		: DmLifeServiceImpl.java
 * @Description		: 전산db 조회를 위한 ServiceImpl
 * @author 김필기
 * @since 2016.02.19
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2016.02.19		김필기					 최초생성
 * </pre>
 */ 
@Service("dMLifeService")
public class DmLifeServiceImpl extends EmfAbstractService implements DmLifeService {
	
	@Resource(name="dMLifeDAO")
	private DmLifeDAO dMLifeDAO;
	
	/**
     * 상품 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */	
	public EmfMap getProductList(EmfMap emfMap) throws Exception
	{
    	PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
    	
    	//페이징 처리
		emfMap.put("paginationInfo", paginationInfo);
		
		//리스트 가져오기
		List<EmfMap> productList = dMLifeDAO.getProductList(emfMap);
		
		emfMap.put("list", productList);
		
		if(productList.size() > 0)
		{
			paginationInfo.setTotalRecordCount(Integer.parseInt(productList.get(0).getString("totCnt")));
		}
		else
		{
			paginationInfo.setTotalRecordCount(0);
		}    	
    	
		return emfMap;		
	}
	
	/**
     * 납입방식을 조회한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */	
	public List<EmfMap> getPaymentMethod(EmfMap emfMap) throws Exception
	{
		ArrayList<String> prdctCdList = new ArrayList<String>();
		
		String prdctCd = emfMap.getString("prodCd");
		
		if(!"".equals(prdctCd))
		{
			String[] result = prdctCd.split(",");	
			
			for(int i = 0 ; i < result.length ; i++)
			{
				prdctCdList.add(result[i]);
			}
		}
		
		emfMap.put("prodCd", prdctCdList);
		
		List<EmfMap> paymentMethodList = dMLifeDAO.getPaymentMethod(emfMap);
		
		return paymentMethodList;
	}
	
	/**
     * 상세상품을 조회한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */	
	
	public List<EmfMap> getDetailProduct(EmfMap emfMap) throws Exception
	{
		return dMLifeDAO.getDetailProduct(emfMap);
	}	

	/**
     * 담당자 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */	
	
	public EmfMap getEmployeeList(EmfMap emfMap) throws Exception
	{
    	PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
		
    	//페이징 처리
    	emfMap.put("paginationInfo", paginationInfo);
    	
    	//리스트 가져오기
		List<EmfMap> employeeList = dMLifeDAO.getEmployeeList(emfMap);
		
		emfMap.put("list", employeeList);
		
		if(employeeList.size() > 0)
		{
			paginationInfo.setTotalRecordCount(Integer.parseInt(employeeList.get(0).getString("totCnt")));
		}
		else
		{
			paginationInfo.setTotalRecordCount(0);
		}
    	
		return emfMap;				
	}	
	
	/**
     * 회사 코드 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */	
	public EmfMap getB2bComCdList(EmfMap emfMap) throws Exception
	{
    	PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
		
    	//페이징 처리
    	emfMap.put("paginationInfo", paginationInfo);
		
    	//리스트 가져오기
		List<EmfMap> productList = dMLifeDAO.getB2bComCdList(emfMap);
		
		emfMap.put("list", productList);
		
		if(productList.size() > 0)
		{
			paginationInfo.setTotalRecordCount(Integer.parseInt(productList.get(0).getString("totCnt")));
		}
		else
		{
			paginationInfo.setTotalRecordCount(0);
		}    	
    	
		return emfMap;		
	}	
	
	/**
     * 회사 코드 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */	
	public EmfMap selectComCdInf(EmfMap emfMap) throws Exception
	{
		emfMap.put("comCdInf", dMLifeDAO.selectComCdInf(emfMap));
		
		return emfMap;		
	}
	
	/**
     * member_no 조회
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */		
	public List<EmfMap> selectDMLifeMemInf(EmfMap emfMap) throws Exception
	{
		return dMLifeDAO.selectDMLifeMemInf(emfMap);
	}
}