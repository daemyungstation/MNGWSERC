package mngwserc.om.omg.service.impl;

import java.util.List;

import javax.annotation.Resource;

import mngwserc.co.util.COPaginationUtil;
import mngwserc.om.omg.service.OMGOutsourcingAdmMngService;
import mngwserc.om.omg.service.dao.OMGOutsourcingAdmMngDAO;

import org.springframework.stereotype.Service;

import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.rte.fdl.idgnr.impl.EgovTableIdGnrService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import emf.core.extend.service.EmfAbstractService;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 외주업체 관리자 조건 관리를 위한 ServiceImpl
 * </pre>
 * 
 * @ClassName		: OMGOutsourcingAdmMngServiceImpl.java
 * @Description		: 외주업체 관리자 조건 관리를 위한 ServiceImpl
 * @author 김필기
 * @since 2016.05.20
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2016.05.20		김필기					 최초생성
 * </pre>
 */ 
@Service("oMGOutsourcingAdmMngService")
public class OMGOutsourcingAdmMngServiceImpl extends EmfAbstractService implements OMGOutsourcingAdmMngService {
	
	@Resource(name="oMGOutsourcingAdmMngDAO")
	private OMGOutsourcingAdmMngDAO oMGOutsourcingAdmMngDAO;
	
	@Resource(name="EgovCmmUseService")
    private EgovCmmUseService cmmUseService;	

	@Resource(name="outsourcingAdmMstIdgen")
	private EgovTableIdGnrService outsourcingAdmMstIdgen;

	/**
     * 조건 설정된 외주업체 관리자 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectOutsourcingAdmMngList(EmfMap emfMap) throws Exception
    {
    	PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
    	
    	//페이징 처리
		emfMap.put("paginationInfo", paginationInfo);    	
		
		//리스트 가져오기
		List<EmfMap> dataList = oMGOutsourcingAdmMngDAO.selectOutsourcingAdmMngList(emfMap);

		emfMap.put("list", dataList);

		if(dataList.size() > 0)
		{
			paginationInfo.setTotalRecordCount(Integer.parseInt(dataList.get(0).getString("totCnt")));
		}
		else
		{
			paginationInfo.setTotalRecordCount(0);
		}    	
    	
		return emfMap;
    }
    
    /**
     * 외주업체 관리자 조건 정보를 조회한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectOutsourcingAdmMngInfo(EmfMap emfMap) throws Exception
    {
    	if(!"".equals(emfMap.getString("seq")))
    	{
    		EmfMap info = oMGOutsourcingAdmMngDAO.selectOutsourcingAdmMngInfo(emfMap);
        	
        	if(info != null)
        	{
            	emfMap.put("info", info);
        	}
    	}
    	
    	return emfMap;
    }

    /**
     * 외주업체 관리자 조건을 저장한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public void insertOutsourcingAdmMngInf(EmfMap emfMap) throws Exception
    {
    	emfMap.put("overrapChk", "Y");
    	
    	EmfMap info = oMGOutsourcingAdmMngDAO.selectOutsourcingAdmMngInfo(emfMap);
    	
    	if(info == null)
    	{
        	emfMap.put("seq", outsourcingAdmMstIdgen.getNextIntegerId());
        	
        	oMGOutsourcingAdmMngDAO.insertOutsourcingAdmMngInf(emfMap);
    	}
    	else
    	{
    		throw new Exception("관리자 아이디 중복 등록");
    	}
    }

    /**
     * 외주업체 관리자 조건을 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public void updateOutsourcingAdmMngInf(EmfMap emfMap) throws Exception
    {
    	oMGOutsourcingAdmMngDAO.updateOutsourcingAdmMngInf(emfMap);
    }
    
    /**
     * 외주업체 관리자 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public List<EmfMap> selectAdmList(EmfMap emfMap) throws Exception
    {
		return oMGOutsourcingAdmMngDAO.selectAdmList(emfMap);
    }
    
    /**
     * 영업채널1 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public List<EmfMap> selectChannelList(EmfMap emfMap) throws Exception
    {
		emfMap.put("highrCd", "OUTSOURCING");
		emfMap.put("highrDtlCd", emfMap.getString("highDtlCd"));
		emfMap.put("lowrCd", "OUTSOURCING_CHANNEL");

		return cmmUseService.selectCmmLinkCode(emfMap);
    }
}
